package com.salido.labor.logic.impl;

import java.io.File;
import java.io.FileInputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.salido.labor.bean.LaborLocation;
import com.salido.labor.bean.LaborRule;
import com.salido.labor.bean.LaborRuleLocation;
import com.salido.labor.bean.LaborRuleLocationHistory;
import com.salido.labor.common.CommonEnum;
import com.salido.labor.dao.LaborLocationCustomDAO;
import com.salido.labor.dao.LaborLocationDAO;
import com.salido.labor.dao.LaborRuleDAO;
import com.salido.labor.dao.LaborRuleLocationDAO;
import com.salido.labor.dao.LaborRuleLocationHistoryDAO;
import com.salido.labor.dto.LaborRuleLocationDTO;
import com.salido.labor.dto.Location;
import com.salido.labor.exception.SalidoLaborBusinessException;
import com.salido.labor.logic.LaborRuleLogic;
import com.salido.labor.logic.RuleCommonLogic;
import com.salido.labor.util.DateUtils;
import com.salido.labor.util.ServiceClientPost;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Component
public class LaborRuleLogicImpl implements LaborRuleLogic {

    @Autowired
    private LaborRuleDAO laborRuleDAO;

    @Autowired
    private LaborLocationDAO laborLocationDAO;

    @Autowired
    private LaborLocationCustomDAO laborLocationCustomDAO;

    @Autowired
    private DateUtils dateUtils;

    @Autowired
    private LaborRuleLocationDAO laborRuleLocationDAO;

    @Autowired
    private RuleCommonLogic commonLogic;

    @Autowired
    ServiceClientPost serviceClientPost;

    @Value("${RULE_ICON_PATH}")
    private String ruleIconBasePath;

    @Autowired
    private LaborRuleLocationHistoryDAO laborRuleLocationHistoryDAO;

    private static final Logger LOGGER = LogManager.getLogger(LaborRuleLogicImpl.class);

    /*
     * Get list by organization,location id and brandId
     */

    @Override
    public JSONArray listAppliedRule(final LaborRuleLocationDTO laborRuleLocationDTO) {
        Location[] locations = laborRuleLocationDTO.getLocations();
        JSONArray pArray = new JSONArray();
        for (Location location : locations) {
            processLocation(location);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("location_id", location.getLocationId());
            jsonObject.put("location_name", location.getLocationName());
            laborRuleLocationDTO.setLocationId(location.getLocationId());
            appendRules(laborRuleLocationDTO, jsonObject);
            pArray.add(jsonObject);
        }
        return pArray;
    }

    private void appendRules(final LaborRuleLocationDTO laborRuleLocationDTO, final JSONObject jsonObject) {
        List<Object> laborRuleLocations = laborLocationCustomDAO.getAppliedRules(laborRuleLocationDTO.getOrgId(),
                laborRuleLocationDTO.getBrandId(), laborRuleLocationDTO.getLocationId());

        List<JSONObject> ruleArray = new ArrayList<JSONObject>();
        if (!laborRuleLocations.isEmpty()) {
            for (int idx = 0; idx < laborRuleLocations.size(); idx++) {
                Object objectArr = laborRuleLocations.get(idx);
                Object[] obj = (Object[]) objectArr;
                JSONObject ruleObject = new JSONObject();
                ruleObject.put("rule_id", String.valueOf(obj[0]));
                ruleObject.put("rule_name", String.valueOf(obj[1]));
                ruleObject.put("rule_tag", String.valueOf(obj[2]));
                ruleObject.put("rule_description", String.valueOf(obj[3]));
                ruleObject.put("start_date", String.valueOf(obj[4]));
                ruleObject.put("end_date", obj[5] != null ? String.valueOf(obj[5]) : "");
                try {
                    ruleObject.put("status", commonLogic.getStatus(ruleObject.getString("start_date"),
                            ruleObject.getString("end_date")));
                    ruleArray.add(ruleObject);
                } catch (Exception e) {
                    LOGGER.error("Exception while appending rule-->", e);
                }
            }
        }
        ruleArray = commonLogic.sortJsonList(ruleArray, "status");
        jsonObject.put("rules", ruleArray);

    }

    @Override
    public JSONArray listAllRules(final LaborRuleLocationDTO laborRuleLocationDTO) {
        JSONArray jsonArray = new JSONArray();
        List<Object> laborRules = laborLocationCustomDAO.listAllRules(laborRuleLocationDTO.getOrgId(),
                laborRuleLocationDTO.getBrandId(), laborRuleLocationDTO.getLocationId());
        laborRules.stream().forEach(object -> {
            Object[] obj = (Object[]) object;
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("rule_name", String.valueOf(obj[0]));
            jsonObject.put("rule_tag", String.valueOf(obj[1]));
            jsonObject.put("rule_description", String.valueOf(obj[2]));
            jsonObject.put("rule_id", String.valueOf(obj[3]));

            if (String.valueOf(obj[4]) != null) {
                jsonObject.put("location_id", obj[4]);
                jsonObject.put("start_date", obj[5] != null ? String.valueOf(obj[5]) : "");
                jsonObject.put("end_date", obj[6] != null ? String.valueOf(obj[6]) : "");
                jsonObject.put("status", CommonEnum.STATUS_EXPIRED.getValue());

                if (StringUtils.isNotBlank(jsonObject.getString("start_date"))) {
                    jsonObject.put("status", commonLogic.getStatus(jsonObject.getString("start_date"),
                            jsonObject.getString("end_date")));
                }
                jsonArray.add(jsonObject);

            }

        });
        return jsonArray;

    }

    @Override
    public LaborLocation processLocation(final Location location) {
        Optional<LaborLocation> laborLocationOptional = laborLocationDAO.findById(location.getLocationId());
        LaborLocation laborLocation;
        if (laborLocationOptional.isPresent()) {
            laborLocation = laborLocationOptional.get();
            laborLocation.setLocationName(location.getLocationName());
        } else {
            laborLocation = new LaborLocation(location.getLocationId(), location.getLocationName());
        }
        return laborLocationDAO.save(laborLocation);
    }

    /*
     * add rule location
     */

    @Override
    public LaborRuleLocation applyRule(final LaborRuleLocationDTO locationDTO) throws ParseException {
        LaborLocation laborLocation;
        LaborRuleLocation laborRuleLocation = new LaborRuleLocation();
        Optional<LaborRule> optional = laborRuleDAO.findById(locationDTO.getRuleId());
        if (!optional.isPresent()) {
            throw new SalidoLaborBusinessException("rule.not.found", "rule not found!");
        }
        LaborRule laborRule = optional.get();
        Optional<LaborLocation> laborLocationOptional = laborLocationDAO.findById(locationDTO.getLocationId());

        if (!laborLocationOptional.isPresent()) {
            throw new SalidoLaborBusinessException("location.not.found", "Location Id not found!");
        }
        laborLocation = laborLocationOptional.get();
        laborRuleLocation.setLaborRule(laborRule);
        laborRuleLocation.setLaborLocation(laborLocation);
        laborRuleLocation.setBrandId(locationDTO.getBrandId());
        laborRuleLocation.setUpdatedBy(locationDTO.getCreatedBy());
        laborRuleLocation.setCreatedDate(dateUtils.getCurrentUTCDate());
        laborRuleLocation.setUpdatedDate(dateUtils.getCurrentUTCDate());
        laborRuleLocation.setOrgId(locationDTO.getOrgId());
        laborRuleLocation.setCreatedBy(locationDTO.getCreatedBy());
        laborRuleLocation
                .setStartDate(dateUtils.stringToDate(locationDTO.getStartDate(), DateUtils.DATE_FORMAT_COMMON));
        laborRuleLocation.setEndDate(StringUtils.isNotBlank(locationDTO.getEndDate())
                ? dateUtils.stringToDate(locationDTO.getEndDate(), DateUtils.DATE_FORMAT_COMMON) : null);

        updateRuleHistory(locationDTO);
        return laborRuleLocationDAO.save(laborRuleLocation);
    }

    private void updateRuleHistory(LaborRuleLocationDTO locationDTO) {
        LaborRuleLocation laborRuleLocation = laborRuleLocationDAO
                .getRuleLocationByPrimaryKeyLaborLocationLocationIdAndPrimaryKeyLaborRuleRuleId(
                        locationDTO.getLocationId(), locationDTO.getRuleId());
        if (laborRuleLocation != null) {
            LaborRuleLocationHistory entity = new LaborRuleLocationHistory();
            entity.setLocationId(laborRuleLocation.getPrimaryKey().getLaborLocation().getLocationId());
            entity.setRuleId(laborRuleLocation.getPrimaryKey().getLaborRule().getRuleId());
            entity.setStartDate(laborRuleLocation.getStartDate());
            entity.setEndDate(laborRuleLocation.getEndDate());
            entity.setCreatedDate(dateUtils.getCurrentUTCDate());
            laborRuleLocationHistoryDAO.save(entity);
        }
    }

    @Override
    public FileInputStream getRuleIcon(final String ruleId, final String type) {
        FileInputStream fileInputStream = null;
        fileInputStream = getIcon(ruleId, type);
        if (fileInputStream == null) {
            String defaultRuleIconName = "default";
            fileInputStream = getIcon(defaultRuleIconName, type);
        }
        return fileInputStream;
    }

    private FileInputStream getIcon(final String iconName, final String type) {
        FileInputStream fileInputStream = null;
        try {
            if (StringUtils.isNotBlank(iconName)) {
                String imageUrl = getIconPath(iconName, type) + iconName + ".svg";
                LOGGER.debug("getIcon: icon path: " + imageUrl);
                File file = new File(imageUrl);
                if (file.exists()) {
                    fileInputStream = new FileInputStream(imageUrl);
                }
            }
        } catch (Exception ex) {
            LOGGER.error("Error while get event image by getEventImage-", ex);
            throw new SalidoLaborBusinessException(ex.getMessage());
        }
        return fileInputStream;
    }

    private String getIconPath(final String iconName, final String type) {
        String iconURL = ruleIconBasePath;
        if (StringUtils.isNotBlank(type)) {
            iconURL += "black/";
        }
        return iconURL;
    }

}

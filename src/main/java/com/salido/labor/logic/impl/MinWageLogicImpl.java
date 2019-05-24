package com.salido.labor.logic.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.salido.labor.bean.LaborLocation;
import com.salido.labor.bean.LocationMinWage;
import com.salido.labor.bean.LocationMinWageHistory;
import com.salido.labor.dao.LaborLocationDAO;
import com.salido.labor.dao.MinWageDAO;
import com.salido.labor.dao.MinWageHistoryDAO;
import com.salido.labor.dto.Location;
import com.salido.labor.dto.MinWageDTO;
import com.salido.labor.exception.SalidoLaborBusinessException;
import com.salido.labor.logic.LaborRuleLogic;
import com.salido.labor.logic.MinWageLogic;
import com.salido.labor.logic.RuleCommonLogic;
import com.salido.labor.util.DateUtils;
import com.salido.labor.util.UuidUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Component
public class MinWageLogicImpl implements MinWageLogic {
    @Autowired
    private LaborRuleLogic laborRuleLogic;
    @Autowired
    private MinWageDAO minWageDAO;
    @Autowired
    LaborLocationDAO laborLocationDAO;
    @Autowired
    private DateUtils dateUtils;
    @Autowired
    private MinWageHistoryDAO minWageHistoryDAO;

    @Autowired
    private RuleCommonLogic commonLogic;

    private static final Logger LOGGER = LogManager.getLogger(MinWageLogicImpl.class);

    @Override
    public LocationMinWage addMinWage(final MinWageDTO minWageDTO) throws ParseException {
        LaborLocation laborLocation;
        LocationMinWage locationMinWage = new LocationMinWage();
        Optional<LaborLocation> laborLocationop = laborLocationDAO.findById(minWageDTO.getLocationId());
        if (!laborLocationop.isPresent()) {
            throw new SalidoLaborBusinessException("location.not.found", "No location found against min wage!");
        }
        laborLocation = laborLocationop.get();
        if (minWageDTO.getId() == null) {
            minWageDTO.setId(UuidUtil.getUUID());
        }
        Timestamp currentUTCTime = dateUtils.getCurrentUTCDate();
        locationMinWage.setId(minWageDTO.getId());
        locationMinWage.setLaborLocation(laborLocation);
        locationMinWage.setBrandId(minWageDTO.getBrandId());
        locationMinWage.setOrgId(minWageDTO.getOrgId());
        locationMinWage.setMinWage(minWageDTO.getMinWage());
        locationMinWage
                .setStartDate(dateUtils.stringToDate(minWageDTO.getStartDate(), DateUtils.DATE_FORMAT_COMMON));
        locationMinWage
                .setEndDate(dateUtils.stringToDate(minWageDTO.getEndDate(), DateUtils.DATE_FORMAT_COMMON));
        locationMinWage.setStatus(minWageDTO.getStatus());
        locationMinWage.setCreatedBy(minWageDTO.getCreatedBy());
        locationMinWage.setUpdatedBy(minWageDTO.getCreatedBy());
        locationMinWage.setCreatedDate(currentUTCTime);
        locationMinWage.setUpdatedDate(currentUTCTime);
        updateMinWageHistory(minWageDTO);
        return minWageDAO.save(locationMinWage);
    }

    private void updateMinWageHistory(MinWageDTO minWageDTO) {
        Optional<LocationMinWage> locationMinWage = minWageDAO.findById(minWageDTO.getId());
        if (locationMinWage.isPresent()) {
            LocationMinWageHistory entity = new LocationMinWageHistory();
            entity.setLocationId(locationMinWage.get().getLaborLocation().getLocationId());
            entity.setMinWage(locationMinWage.get().getMinWage());
            entity.setCreatedDate(dateUtils.getCurrentUTCDate());
            entity.setStartDate(locationMinWage.get().getStartDate());
            entity.setEndDate(locationMinWage.get().getEndDate());
            minWageHistoryDAO.save(entity);
        }

    }

    @Override
    public JSONArray listMinWage(final MinWageDTO minWageDTO) {
        Location[] locations = minWageDTO.getLocations();
        JSONArray pArray = new JSONArray();
        for (Location location : locations) {
            minWageDTO.setLocationId(location.getLocationId());
            laborRuleLogic.processLocation(location);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("location_id", location.getLocationId());
            jsonObject.put("location_name", location.getLocationName());
            appendMinWage(minWageDTO, jsonObject);
            pArray.add(jsonObject);
        }
        return pArray;
    }

    private void appendMinWage(final MinWageDTO minWageDTO, final JSONObject jsonObject) {

        List<LocationMinWage> locationMinWages = minWageDAO
                .findByOrgIdAndBrandIdAndLaborLocationLocationIdOrderByStartDate(minWageDTO.getOrgId(),
                        minWageDTO.getBrandId(), minWageDTO.getLocationId());

        List<JSONObject> wageArray = new ArrayList<JSONObject>();

        for (LocationMinWage locationMinWage : locationMinWages) {
            JSONObject wageObject = new JSONObject();
            try {
                wageObject.put("id", locationMinWage.getId());
                wageObject.put("min_wage", locationMinWage.getMinWage());
                wageObject.put("start_date", locationMinWage.getStartDate().toString());
                if (locationMinWage.getEndDate() == null) {
                    wageObject.put("end_date", "");
                } else {
                    wageObject.put("end_date", locationMinWage.getEndDate().toString());
                }
                wageObject.put("status",
                        commonLogic.getStatus(wageObject.getString("start_date"), wageObject.getString("end_date")));
                wageArray.add(wageObject);
            } catch (Exception e) {
                LOGGER.error("Exception while appending min wage-->", e);
            }

        }

        wageArray = commonLogic.sortJsonList(wageArray, "status");
        jsonObject.put("min_wages", wageArray);
    }

}
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
import com.salido.labor.bean.LocationTipCredits;
import com.salido.labor.bean.LocationTipCreditsHistory;
import com.salido.labor.dao.LaborLocationDAO;
import com.salido.labor.dao.TipCreditDAO;
import com.salido.labor.dao.TipCreditHistoryDAO;
import com.salido.labor.dto.Location;
import com.salido.labor.dto.TipCreditDTO;
import com.salido.labor.exception.SalidoLaborBusinessException;
import com.salido.labor.logic.LaborRuleLogic;
import com.salido.labor.logic.RuleCommonLogic;
import com.salido.labor.logic.TipCreditLogic;
import com.salido.labor.util.DateUtils;
import com.salido.labor.util.UuidUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Component
public class TipCreditLogicImpl implements TipCreditLogic {

    @Autowired
    private LaborRuleLogic laborRuleLogic;

    @Autowired
    private TipCreditDAO tipCreditDAO;

    @Autowired
    LaborLocationDAO laborLocationDAO;

    @Autowired
    private DateUtils dateUtils;

    @Autowired
    RuleCommonLogic commonLogic;

    @Autowired
    TipCreditHistoryDAO creditHistoryDAO;

    private static final Logger LOGGER = LogManager.getLogger(TipCreditLogicImpl.class);

    /*
     * add tip_credit
     */
    @Override
    public LocationTipCredits addTipCredit(final TipCreditDTO tipCreditDTO) throws ParseException {
        LaborLocation laborLocation;
        LocationTipCredits locationTipCredits = new LocationTipCredits();
        Optional<LaborLocation> laborLocationop = laborLocationDAO.findById(tipCreditDTO.getLocationId());
        if (!laborLocationop.isPresent()) {
            throw new SalidoLaborBusinessException("location.not.found", "Location Id not found!");
        }
        laborLocation = laborLocationop.get();
        if (tipCreditDTO.getId() == null) {
            tipCreditDTO.setId(UuidUtil.getUUID());
        }
        Timestamp currentUTCTime = dateUtils.getCurrentUTCDate();
        locationTipCredits.setId(tipCreditDTO.getId());
        locationTipCredits.setLaborLocation(laborLocation);
        locationTipCredits.setBrandId(tipCreditDTO.getBrandId());
        locationTipCredits.setOrgId(tipCreditDTO.getOrgId());
        locationTipCredits.setTipCredit(tipCreditDTO.getTipCredit());
        locationTipCredits
                .setStartDate(dateUtils.stringToDate(tipCreditDTO.getStartDate(), DateUtils.DATE_FORMAT_COMMON));
        locationTipCredits
                .setEndDate(dateUtils.stringToDate(tipCreditDTO.getEndDate(), DateUtils.DATE_FORMAT_COMMON));
        locationTipCredits.setStatus(tipCreditDTO.getStatus());
        locationTipCredits.setCreatedBy(tipCreditDTO.getCreatedBy());
        locationTipCredits.setUpdatedBy(tipCreditDTO.getCreatedBy());
        locationTipCredits.setCreatedDate(currentUTCTime);
        locationTipCredits.setUpdatedDate(currentUTCTime);
        updateHistory(tipCreditDTO.getId());
        return tipCreditDAO.save(locationTipCredits);
    }

    private void updateHistory(final String tipCreditId) {
        Optional<LocationTipCredits> locationTipCreditsIp = tipCreditDAO.findById(tipCreditId);
        if (locationTipCreditsIp.isPresent()) {
            LocationTipCreditsHistory creditsHistory = new LocationTipCreditsHistory();
            creditsHistory.setLocationId(locationTipCreditsIp.get().getLaborLocation().getLocationId());
            creditsHistory.setTipCredit(locationTipCreditsIp.get().getTipCredit());
            creditsHistory.setStartDate(locationTipCreditsIp.get().getStartDate());
            creditsHistory.setEndDate(locationTipCreditsIp.get().getEndDate());
            creditsHistory.setCreatedDate(dateUtils.getCurrentUTCDate());
            creditHistoryDAO.save(creditsHistory);
        }
    }

    /*
     * Get list by orgId,brand_id and location id
     */

    @Override
    public JSONArray listTipCreditById(final TipCreditDTO tipCreditDTO) {
        Location[] locations = tipCreditDTO.getLocations();
        JSONArray pArray = new JSONArray();
        for (Location location : locations) {
            tipCreditDTO.setLocationId(location.getLocationId());
            laborRuleLogic.processLocation(location);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("location_id", location.getLocationId());
            jsonObject.put("location_name", location.getLocationName());
            appendTipCredit(tipCreditDTO, jsonObject);
            pArray.add(jsonObject);
        }
        return pArray;
    }

    private void appendTipCredit(final TipCreditDTO tipCreditDTO, final JSONObject jsonObject) {

        List<LocationTipCredits> locationTipCredits = tipCreditDAO
                .findByOrgIdAndBrandIdAndLaborLocationLocationIdOrderByStartDate(tipCreditDTO.getOrgId(),
                        tipCreditDTO.getBrandId(), tipCreditDTO.getLocationId());

        List<JSONObject> tipArray = new ArrayList<JSONObject>();

        for (LocationTipCredits locationTipCredit : locationTipCredits) {
            JSONObject tipObject = new JSONObject();
            try {
                tipObject.put("id", locationTipCredit.getId());
                tipObject.put("tip_credit", locationTipCredit.getTipCredit());
                tipObject.put("start_date", locationTipCredit.getStartDate().toString());
                if (locationTipCredit.getEndDate() == null) {
                    tipObject.put("end_date", "");
                } else {
                    tipObject.put("end_date", locationTipCredit.getEndDate().toString());
                }

                tipObject.put("status",
                        commonLogic.getStatus(tipObject.getString("start_date"), tipObject.getString("end_date")));
                tipArray.add(tipObject);
            } catch (Exception e) {
                LOGGER.error("Exception while appending tip credit-->", e);
            }

        }

        tipArray = commonLogic.sortJsonList(tipArray, "status");
        jsonObject.put("tip_credits", tipArray);
    }

}

package com.salido.labor.cost;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.salido.labor.bean.LocationMinWage;
import com.salido.labor.bean.RuleExpressionResult;
import com.salido.labor.bean.RuleExpressions;
import com.salido.labor.common.RuleProcessConstants;
import com.salido.labor.cost.logic.RuleResultProcessor;
import com.salido.labor.cost.util.RuleUtils;
import com.salido.labor.dao.MinWageDAO;
import com.salido.labor.dto.LaborCostRequestDTO;
import com.salido.labor.util.DateUtils;

import net.sf.json.JSONObject;

@Qualifier("sohRuleResultProcessor")
@Component
public class SOHRuleResultProcessor implements RuleResultProcessor {

    @Autowired
    RuleUtils ruleUtils;

    @Autowired
    MinWageDAO minWageDAO;

    @Autowired
    DateUtils dateUtils;

    private static final Logger LOGGER = LogManager.getLogger(SOHRuleResultProcessor.class);

    @Override
    public LaborCostRequestDTO process(LaborCostRequestDTO costRequestDTO, RuleExpressions ruleExpression) {
        ruleExpression.getExpressionResult().forEach(expressionResult -> {
            setSohObject(costRequestDTO, expressionResult);
        });
        return costRequestDTO;

    }

    private void setSohObject(LaborCostRequestDTO costRequestDTO, RuleExpressionResult expressionResult) {
        JSONObject sohWageObject = new JSONObject();
        double totalWorkingHrs = getTotalWorkingHrs(costRequestDTO, expressionResult);
        if (totalWorkingHrs > 0) {
            costRequestDTO.getTimecardCost().put(RuleProcessConstants.LaborCostKeys.SOH_AMOUNT,
                    calculateSohAmount(costRequestDTO));
            sohWageObject.put(RuleProcessConstants.LaborCostKeys.SOH_AMOUNT, calculateSohAmount(costRequestDTO));
            costRequestDTO.getTimecardCost().put(RuleProcessConstants.LaborCostKeys.HAS_SOH, true);
        }
        costRequestDTO.setSohWageObject(sohWageObject);
    }

    private double getTotalWorkingHrs(LaborCostRequestDTO costRequestDTO, RuleExpressionResult expressionResult) {
        LaborCostRequestDTO currentTimecard = costRequestDTO.getCurrentDayTimecards()
                .get(costRequestDTO.getCurrentDayTimecards().size() - 1);
        List<LaborCostRequestDTO> cardDTOs = costRequestDTO.getCurrentDayTimecards();
        double totalDayHr = ruleUtils.getCurrentTCWorkedHours(currentTimecard);
        double totalWeekHrs = ruleUtils.getTotalWorkedHours(cardDTOs, null);
        int hrsPaid = Integer.parseInt(expressionResult.getHoursPaidValue());

        return totalWeekHrs - totalDayHr > hrsPaid ? 0 : totalWeekHrs;
    }

    private double calculateSohAmount(LaborCostRequestDTO costRequestDTO) {
        return getMinimumWage(costRequestDTO.getLocationId(), costRequestDTO.getTimecardStartDate());
    }

    private double getMinimumWage(String locationId, Date tcStartDate) {
        double minWage = 0;
        List<LocationMinWage> locationMinWages = minWageDAO.listMinWage(locationId, tcStartDate);
        if (!locationMinWages.isEmpty()) {
            minWage = Double.parseDouble(locationMinWages.get(0).getMinWage());
        } else {
            LOGGER.warn("No minimum wage (SOH) found againest location: " + locationId + " for date " + tcStartDate);
        }
        return minWage;
    }

}

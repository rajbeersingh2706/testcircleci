package com.salido.labor.cost;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.salido.labor.bean.LocationTipCredits;
import com.salido.labor.bean.RuleExpressionResult;
import com.salido.labor.bean.RuleExpressions;
import com.salido.labor.common.RuleProcessConstants;
import com.salido.labor.cost.logic.RuleResultProcessor;
import com.salido.labor.cost.util.RuleUtils;
import com.salido.labor.dao.TipCreditDAO;
import com.salido.labor.dto.LaborCostRequestDTO;
import com.salido.labor.util.DateUtils;

import net.sf.json.JSONObject;

@Qualifier("tipCreditRuleResultProcessor")
@Component
public class TipCreditRuleResultProcessor implements RuleResultProcessor {

    @Autowired
    RuleUtils ruleUtils;

    @Autowired
    TipCreditDAO tipCreditDAO;

    @Autowired
    DateUtils dateUtils;

    private static final Logger LOGGER = LogManager.getLogger(TipCreditRuleResultProcessor.class);

    @Override
    public LaborCostRequestDTO process(LaborCostRequestDTO costRequestDTO, RuleExpressions ruleExpression) {
        ruleExpression.getExpressionResult().forEach(expressionResult -> {
            setTipCreditObject(costRequestDTO, expressionResult);
        });
        return costRequestDTO;
    }

    private void setTipCreditObject(LaborCostRequestDTO costRequestDTO, RuleExpressionResult expressionResult) {
        JSONObject tipcreditWageObject = new JSONObject();
        double tipCredit = getTipCredit(costRequestDTO.getLocationId(), costRequestDTO.getTimecardStartDate());

        costRequestDTO.getTimecardCost().put(RuleProcessConstants.LaborCostKeys.TIPCREDIT_AMOUNT,
                ruleUtils.formatDouble(
                        calculateTipCreditAmount(costRequestDTO, expressionResult.getModifier(), tipCredit)));

        costRequestDTO.getTimecardCost().put(RuleProcessConstants.LaborCostKeys.TIPCREDIT + "_" + RuleProcessConstants.LaborCostKeys.PAY_RATE,
                tipCredit);

        tipcreditWageObject.put(RuleProcessConstants.LaborCostKeys.PAY_RATE, tipCredit);
        tipcreditWageObject.put(RuleProcessConstants.LaborCostKeys.TIPCREDIT_AMOUNT, ruleUtils
                .formatDouble(calculateTipCreditAmount(costRequestDTO, expressionResult.getModifier(), tipCredit)));
        costRequestDTO.setTipCreditWageObject(tipcreditWageObject);
    }

    private double calculateTipCreditAmount(LaborCostRequestDTO costRequestDTO, String modifier, double tipCredit) {
        double workedHours = ruleUtils.getCurrentTCWorkedHours(costRequestDTO);
        return tipCredit * workedHours;
    }

    private double getTipCredit(String locationId, Date tcStartDate) {
        double tipCredit = 0;
        List<LocationTipCredits> locationMinWages = tipCreditDAO.listTipCredits(locationId, tcStartDate);
        if (!locationMinWages.isEmpty()) {
            tipCredit = Double.parseDouble(locationMinWages.get(0).getTipCredit());
        } else {
            LOGGER.warn("No tipCredit found againest location: " + locationId + " for date " + tcStartDate);
        }
        return tipCredit;
    }

}

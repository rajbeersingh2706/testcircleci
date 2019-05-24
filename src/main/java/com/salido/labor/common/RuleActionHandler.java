package com.salido.labor.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.salido.labor.bean.LaborRule;
import com.salido.labor.bean.RuleExpressions;
import com.salido.labor.cost.logic.RuleResultProcessor;
import com.salido.labor.dao.LaborRuleLocationDAO;
import com.salido.labor.dto.LaborCostRequestDTO;

@Component
public class RuleActionHandler {

    @Autowired
    @Qualifier("otRuleResultProcessor")
    RuleResultProcessor otRuleResultProcessor;

    @Autowired
    @Qualifier("sohRuleResultProcessor")
    RuleResultProcessor sohRuleResultProcessor;

    @Autowired
    @Qualifier("tipCreditRuleResultProcessor")
    RuleResultProcessor tipCreditRuleResultProcessor;

    @Autowired
    @Qualifier("regRuleResultProcessor")
    RuleResultProcessor regRuleResultProcessor;

    @Autowired
    LaborRuleLocationDAO laborRuleLocationDAO;

    private static final Logger LOGGER = LogManager.getLogger(RuleActionHandler.class);

    public LaborCostRequestDTO executeResult(LaborRule laborRule, LaborCostRequestDTO laborCostRequestDTO,
            RuleExpressions ruleExpression) {
        LOGGER.debug("Executing Result--> Input Object: "+laborCostRequestDTO.getCostObject());
        execute(laborRule, laborCostRequestDTO, ruleExpression);
        return laborCostRequestDTO;
    }

    public LaborCostRequestDTO execute(LaborRule laborRule, LaborCostRequestDTO laborCostRequestDTO,
            RuleExpressions ruleExpression) {
        switch (laborRule.getRuleTag()) {
        case RuleProcessConstants.RuleType.RULE_TYPE_OT:
            otRuleResultProcessor.process(laborCostRequestDTO, ruleExpression);
            break;
        case RuleProcessConstants.RuleType.RULE_TYPE_SOH:
            sohRuleResultProcessor.process(laborCostRequestDTO, ruleExpression);
            break;
        case RuleProcessConstants.RuleType.RULE_TYPE_TIPCREDIT:
            tipCreditRuleResultProcessor.process(laborCostRequestDTO, ruleExpression);
            break;
        default:
            break;
        }
        return laborCostRequestDTO;
    }

}

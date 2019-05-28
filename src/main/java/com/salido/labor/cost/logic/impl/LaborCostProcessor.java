package com.salido.labor.cost.logic.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.EvaluationException;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParseException;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import com.salido.labor.bean.LaborRule;
import com.salido.labor.bean.LaborRuleLocation;
import com.salido.labor.bean.RuleExpressionGroup;
import com.salido.labor.bean.RuleExpressionParam;
import com.salido.labor.bean.RuleExpressions;
import com.salido.labor.common.RuleActionHandler;
import com.salido.labor.common.RuleProcessConstants;
import com.salido.labor.cost.dao.RuleExpressionParamDAO;
import com.salido.labor.cost.logic.RuleResultProcessor;
import com.salido.labor.cost.util.RuleUtils;
import com.salido.labor.dao.LaborRuleLocationDAO;
import com.salido.labor.dto.LaborCostRequestDTO;
import com.salido.labor.logic.impl.RuleCommonLogicImpl;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

@Component
public class LaborCostProcessor {

	@Autowired
	RuleUtils ruleUtil;

	@Autowired
	RuleActionHandler actionHandler;

	@Autowired
	LaborRuleLocationDAO laborRuleLocationDAO;

	@Autowired
	RuleExpressionParamDAO ruleExpressionParamDao;

	@Autowired
	RuleCommonLogicImpl ruleCommonLogicImpl;

	@Autowired
	@Qualifier("regRuleResultProcessor")
	RuleResultProcessor regRuleResultProcessor;

	private static final Logger LOGGER = LogManager.getLogger(LaborCostProcessor.class);

	public Map<String, Object> processRule(LaborCostRequestDTO laborCostRequestDTO) {
		init(laborCostRequestDTO);
		List<LaborRuleLocation> laborRules = laborRuleLocationDAO.getRuleList(laborCostRequestDTO.getLocationId(),
				laborCostRequestDTO.getTimecardStartDate());

		if (laborRules.isEmpty()) {
			// Calculating regular wage here at least, if no rule is applied.
			regRuleResultProcessor.process(laborCostRequestDTO, null);
		} else {
			for (LaborRuleLocation laborRuleLocation : laborRules) {
				LOGGER.debug("LABORRULE NAME\t " + laborRuleLocation.getLaborRule().getName());
				laborCostRequestDTO = process(laborRuleLocation.getLaborRule(), laborCostRequestDTO);
			}
		}
		return laborCostRequestDTO.getTimecardCost();
	}

	public LaborCostRequestDTO process(LaborRule laborRule, LaborCostRequestDTO laborCostRequestDTO) {
		List<RuleExpressionGroup> expressionGroups = laborRule.getRuleExpressionGroup();
		Collections.sort(expressionGroups);
		for (RuleExpressionGroup expressionGroup : expressionGroups) {
			LOGGER.debug("EXPRESSIONGRP NAME\t" + expressionGroup.getName());
			List<RuleExpressions> ruleExpressionsList = expressionGroup.getRuleExpression();
			Collections.sort(ruleExpressionsList);
			for (RuleExpressions ruleExpression : ruleExpressionsList) {
				LOGGER.debug("RULE EXPRESSION  \t" + ruleExpression.getExpression());
				if (validateCondition(ruleExpression, laborCostRequestDTO, laborRule.getRuleTag())) {
					LOGGER.debug(expressionGroup.getName() + " VERIFIED");
					actionHandler.executeResult(laborRule, laborCostRequestDTO, ruleExpression);
					/*
					 * If one expression is matched in expression group, process
					 * next group.
					 */

					break;
				} else {
					LOGGER.debug(expressionGroup.getName() + " NOT VERIFIED");
				}
			}
		}
		// Calculating regular wage here in last.
		regRuleResultProcessor.process(laborCostRequestDTO, null);
		return laborCostRequestDTO;

	}

	private boolean validateCondition(RuleExpressions ruleExpression, LaborCostRequestDTO cardDTO, String ruleTag) {
		boolean result = true;
		// If even single condition not satisfied, return false.
		if (!(validateRuleCondition(ruleExpression, cardDTO, ruleTag) && validateDayslimit(ruleExpression, cardDTO))) {
			return false;
		}
		return result;
	}

	public boolean validateRuleCondition(RuleExpressions ruleExpression, LaborCostRequestDTO cardDTO, String ruleTag) {
		if (RuleProcessConstants.RuleType.RULE_TYPE_TIPCREDIT.equalsIgnoreCase(ruleTag)) {
			return true;
		}
		HashMap<String, Double> paramWorkedHrs = new HashMap<>();
		List<RuleExpressionParam> params = ruleExpressionParamDao.findByRuleExpressionId(ruleExpression.getId());
		for (RuleExpressionParam param : params) {
			double paramValue = 0;
			if (RuleProcessConstants.RuleType.RULE_TYPE_SOH.equalsIgnoreCase(ruleTag)) {
				paramValue = ruleUtil.getSohDayWorkedHours(cardDTO);
			} else {
				paramValue = ruleUtil.getConditionParamValue(cardDTO, ruleExpression, param.getExpKey());
			}
			paramWorkedHrs.put(param.getExpKey(), paramValue);
			LOGGER.debug("PARAM\t" + param.getExpKey() + "\tPARAM-VALUE\t" + paramValue);
		}
		return validate(ruleExpression.getExpression(), paramWorkedHrs);
	}

	private boolean validate(String expression, Map<String, Double> params) {
		boolean isValidated = false;
		try {
			EvaluationContext context = new StandardEvaluationContext();
			params.forEach((k, v) -> {
				context.setVariable(k, v);
			});
			ExpressionParser parser = new SpelExpressionParser();
			Expression exp = parser.parseExpression(expression);
			if (exp != null && exp.getValue(context) != null) {
				isValidated = (boolean) exp.getValue(context);
			}
		} catch (ParseException | EvaluationException ex) {
			LOGGER.error("Error in parsing evaluation context", ex);
		} catch (Exception ex) {
			LOGGER.error("Error in parsing evaluation context", ex);
		}
		return isValidated;

	}

	private boolean validateDayslimit(RuleExpressions ruleExpressions, LaborCostRequestDTO cardDTO) {
		boolean verifyDayLimit = true;
		if (ruleExpressions.getPreCondition() != null && !ruleExpressions.getPreCondition().isEmpty()) {
			JSONObject preCondition = (JSONObject) JSONSerializer.toJSON(ruleExpressions.getPreCondition());
			if (preCondition.has(RuleProcessConstants.Param.DAYS_WORKED_UNTIL_WEEK)) {
				long currentTcDayAsNum = ruleUtil.getTimecardDay(cardDTO);
				long currentTcDayAsNumLimit = preCondition.getLong(RuleProcessConstants.Param.DAYS_WORKED_UNTIL_WEEK);
				if (currentTcDayAsNum > currentTcDayAsNumLimit) {
					verifyDayLimit = false;
				}
			}
		}
		return verifyDayLimit;
	}

	private void init(LaborCostRequestDTO laborCostRequestDTO) {
		laborCostRequestDTO
				.setWeekTimecards(ruleCommonLogicImpl.sortTimeCardsList(laborCostRequestDTO.getWeekTimecards()));
		laborCostRequestDTO.setCurrentDayTimecards(ruleUtil.filterCurrentDateTC(laborCostRequestDTO));
	}

}

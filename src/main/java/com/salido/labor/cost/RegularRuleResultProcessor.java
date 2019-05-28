package com.salido.labor.cost;

import static java.util.stream.Collectors.toMap;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.salido.labor.bean.RuleExpressions;
import com.salido.labor.common.RuleProcessConstants;
import com.salido.labor.cost.logic.RuleResultProcessor;
import com.salido.labor.cost.util.RuleUtils;
import com.salido.labor.dao.MinWageDAO;
import com.salido.labor.dto.LaborCostRequestDTO;
import com.salido.labor.logic.RuleCommonLogic;
import com.salido.labor.util.DateUtils;

@Qualifier("regRuleResultProcessor")
@Component
public class RegularRuleResultProcessor implements RuleResultProcessor {

	@Autowired
	RuleCommonLogic commonLogic;

	@Autowired
	MinWageDAO minWageDAO;

	@Autowired
	DateUtils dateUtils;

	@Autowired
	RuleUtils ruleUtils;

	@Override
	public LaborCostRequestDTO process(LaborCostRequestDTO costRequestDTO, RuleExpressions ruleExpression) {
		setRegMap(costRequestDTO);
		return costRequestDTO;

	}

	private void setRegMap(LaborCostRequestDTO costRequestDTO) {
		Date timeCardStartDate = dateUtils.addMinutes(costRequestDTO.getTimecardStartDate(),
				costRequestDTO.getBreaks());
		Map<String, Object> otMap = costRequestDTO.getTimecardCost();
		if (otMap != null && !otMap.isEmpty()) {
			otMap = sortMapByValue(costRequestDTO.getTimecardCost());
			if (otMap.size() > 0) {
				Map.Entry<String, Object> entry = otMap.entrySet().stream().findFirst().get();
				Date otStartDate = dateUtils.stringToDate(entry.getValue().toString(), DateUtils.DATE_FORMAT_FULL);
				if (timeCardStartDate.compareTo(otStartDate) != 0) {
					setRegWage(costRequestDTO, timeCardStartDate, otStartDate);
				}
			}
		} else {
			setRegWage(costRequestDTO, timeCardStartDate, costRequestDTO.getTimecardEndDate());
		}

	}

	private void setRegWage(LaborCostRequestDTO costRequestDTO, Date startDate, Date endDate) {
		costRequestDTO.getTimecardCost().put(
				RuleProcessConstants.LaborCostKeys.REG + "_" + RuleProcessConstants.LaborCostKeys.START_TIME,
				dateUtils.dateToString(startDate, DateUtils.DATE_FORMAT_FULL));
		costRequestDTO.getTimecardCost().put(
				RuleProcessConstants.LaborCostKeys.REG + "_" + RuleProcessConstants.LaborCostKeys.END_TIME,
				dateUtils.dateToString(endDate, DateUtils.DATE_FORMAT_FULL));

		costRequestDTO.getTimecardCost().put(
				RuleProcessConstants.LaborCostKeys.REG + "_" + RuleProcessConstants.LaborCostKeys.PAY_RATE,
				costRequestDTO.getPayRate());

		double hours = dateUtils.getHours(endDate.getTime() - startDate.getTime());
		costRequestDTO.getTimecardCost().put(RuleProcessConstants.LaborCostKeys.REG_AMOUNT,
				ruleUtils.formatDouble(costRequestDTO.getPayRate() * hours));
		double workedInMilis = hours * 60 * 60;
		costRequestDTO.getTimecardCost().put(
				RuleProcessConstants.LaborCostKeys.REG + "_" + RuleProcessConstants.LaborCostKeys.HOURS, workedInMilis);
	}

	private Map<String, Object> sortMapByValue(Map<String, Object> map) {
		Map<String, Object> sorted = map.entrySet().stream()
				.filter(obj -> obj.getKey()
						.contains(RuleProcessConstants.LaborCostKeys.OT_UNDERSCORE
								+ RuleProcessConstants.LaborCostKeys.START_TIME))
				.sorted((e1, e2) -> e1.getValue().toString().compareTo(e2.getValue().toString()))
				.collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
		return sorted;
	}

}

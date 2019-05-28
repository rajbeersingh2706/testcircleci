package com.salido.labor.logic;

import java.util.List;
import java.util.Map;

import com.salido.labor.dto.LaborCostRequestDTO;

import net.sf.json.JSONObject;

public interface RuleCommonLogic {

	String getStatus(final String startDate, final String endDate);

	List<JSONObject> sortJsonList(final List<JSONObject> jsonArr, final String key, final String order);

	List<JSONObject> sortJsonList(final List<JSONObject> jsonArr, final String key);

	List<LaborCostRequestDTO> sortTimeCardsList(final List<LaborCostRequestDTO> weektimeCards);

	Map<String, Object> sortMapByValue(Map<String, Object> map, String key);

}

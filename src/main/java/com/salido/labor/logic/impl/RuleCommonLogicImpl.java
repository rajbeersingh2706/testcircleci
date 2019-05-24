package com.salido.labor.logic.impl;

import static java.util.stream.Collectors.toMap;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.salido.labor.common.CommonEnum;
import com.salido.labor.common.Constants;
import com.salido.labor.dto.LaborCostRequestDTO;
import com.salido.labor.logic.RuleCommonLogic;
import com.salido.labor.util.DateUtils;

import net.sf.json.JSONObject;

@Component
public class RuleCommonLogicImpl implements RuleCommonLogic {

	@Autowired
	DateUtils dateUtils;

	private static final Logger LOGGER = LogManager.getLogger(RuleCommonLogicImpl.class);

	@Override
	public List<JSONObject> sortJsonList(final List<JSONObject> jsonArr, final String key) {
		return sortJsonList(jsonArr, key, null);
	}

	@Override
	public List<JSONObject> sortJsonList(final List<JSONObject> jsonArr, final String key, final String order) {

		if (jsonArr == null || jsonArr.isEmpty()) {
			return jsonArr;
		}
		Collections.sort(jsonArr, new Comparator<JSONObject>() {
			@Override
			public int compare(JSONObject a, JSONObject b) {
				String valA = (String) a.get(key);
				String valB = (String) b.get(key);
				if (Constants.SORT_ORDER_DESC.equalsIgnoreCase(order)) {
					return -valA.compareTo(valB);
				} else {
					return valA.compareTo(valB);
				}
			}
		});
		return jsonArr;
	}

	@Override
	public List<LaborCostRequestDTO> sortTimeCardsList(final List<LaborCostRequestDTO> weektimeCards) {
		Collections.sort(weektimeCards, (o1, o2) -> o1.getTimecardStartDate().compareTo(o2.getTimecardStartDate()));
		return weektimeCards;

	}

	@Override
	public String getStatus(final String startDate, final String endDate) {
		String status = CommonEnum.STATUS_EXPIRED.getValue();
		try {
			// Check if active
			if (isActive(startDate, endDate)) {
				status = CommonEnum.STATUS_ACTIVE_STR.getValue();
			} else if (isScheduled(startDate)) {
				status = CommonEnum.STATUS_SCHEDULED.getValue();
			}
		} catch (Exception e) {
			LOGGER.error("Exception while ppreparing status==>", e);
		}
		return status;
	}

	private boolean isScheduled(final String startDate) {
		boolean isScheduled = false;
		Date currentDate = dateUtils.getFormatedDate(new Date(), DateUtils.DATE_FORMAT_COMMON);
		Date startDt = dateUtils.stringToDate(startDate, DateUtils.DATE_FORMAT_COMMON);

		if (StringUtils.isNotBlank(startDate) && currentDate.compareTo(startDt) == -1) {
			isScheduled = true;
		}
		return isScheduled;
	}

	private boolean isActive(final String startDate, final String endDate) {
		boolean isActive = false;
		Date currentDate = dateUtils.getFormatedDate(new Date(), DateUtils.DATE_FORMAT_COMMON);
		if (StringUtils.isNotBlank(startDate)) {
			Date startDt = dateUtils.stringToDate(startDate, DateUtils.DATE_FORMAT_COMMON);
			// 0==> if equal, 1==> current date > parameter date
			if (currentDate.compareTo(startDt) == 0 || currentDate.compareTo(startDt) == 1) {
				isActive = getIsActive(endDate, currentDate);

			}

		}
		return isActive;
	}

	private boolean getIsActive(String endDate, Date currentDate) {
		boolean isActive = false;
		if (endDate != null && !endDate.isEmpty()) {
			Date endDt = dateUtils.stringToDate(endDate, DateUtils.DATE_FORMAT_COMMON);
			// 0==> date are equal, -1==> current date < parameter date
			if (currentDate.compareTo(endDt) == 0 || currentDate.compareTo(endDt) == -1) {
				isActive = true;
			}
		} else {
			isActive = true;
		}
		return isActive;
	}
	@Override
	public Map<String, Object> sortMapByValue(Map<String, Object> map, String key) {
		Map<String, Object> sorted = map.entrySet().stream()
				.filter(obj -> obj.getKey()
						.contains(key))
				.sorted((e1, e2) -> e1.getValue().toString().compareTo(e2.getValue().toString()))
				.collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
		return sorted;
	}
}

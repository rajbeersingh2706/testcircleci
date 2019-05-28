package com.salido.labor.logic.impl;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import com.salido.labor.bean.LaborRuleLocation;
import com.salido.labor.bean.LaborRuleLocationHistory;
import com.salido.labor.common.Constants;
import com.salido.labor.dao.LaborRuleLocationDAO;
import com.salido.labor.dao.LaborRuleLocationHistoryDAO;
import com.salido.labor.logic.RuleReProcessorLogic;
import com.salido.labor.util.DateUtils;
import com.salido.labor.util.ServiceClientPost;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Component
public class RuleReProcessorLogicImpl implements RuleReProcessorLogic {

	@Autowired
	private DateUtils dateUtils;

	@Autowired
	private LaborRuleLocationDAO laborRuleLocationDAO;

	@Autowired
	private ServiceClientPost serviceClientPost;

	@Value("${RULE_ICON_PATH}")
	private String ruleIconBasePath;

	@Value("${UPDATE_SHIFT_SERVICE_URL}")
	private String serviceUrl;

	@Value("${AUTH_SERVICE_URL}")
	private String authServiceUrl;

	@Value("${UPDATE_TIMECARD_PLATFORM_RETRY_AFTER}")
	private long retryAfter;

	@Autowired
	private LaborRuleLocationHistoryDAO laborRuleLocationHistoryDAO;

	private static final Logger LOGGER = LogManager.getLogger(RuleReProcessorLogicImpl.class);

	@Override
	public void processTimeCards(final String token) {
		ExecutorService exService = Executors.newSingleThreadExecutor();
		FutureTask<String> futureTask = new FutureTask<String>(new ProcessTimeCardsTask(token));
		exService.execute(futureTask);
		return;
	}

	private class ProcessTimeCardsTask implements Callable<String> {
		private String token;

		public ProcessTimeCardsTask(String token) {
			this.token = token;
		}

		@Override
		public String call() {
			try {
			    updateTimeCards(token);
			} catch (Exception ex) {
				LOGGER.error("Exception accured in ProcessTimeCardsTask: ", ex);
			}

			return null;
		}
	}

	private synchronized void updateTimeCards(String token) {
		LOGGER.debug("running token :" + token);
		boolean processSucces = false;
		while (!processSucces) {
			try {
				wait(retryAfter);
				processSucces = process(token);
			} catch (InterruptedException e) {
				LOGGER.error("Plateform: updateTimeCards thread intruption error->", e);

			}

		}
	}

	private boolean process(final String token) {
		boolean processSucces = false;
		try {
			List<LaborRuleLocation> laborRuleLocations = laborRuleLocationDAO
					.getRuleLocationBytimecardsUpdateStatus(Boolean.FALSE);
			if (!laborRuleLocations.isEmpty()) {
				JSONObject request = prepareRequest(laborRuleLocations);
				String response = callWebService(request, token);

				LOGGER.debug("Plateform: timecard update service response->" + response);
				JSONObject resObject = JSONObject.fromObject(response);
				if (resObject.has(Constants.KEY_SUCCESS) && resObject.getBoolean(Constants.KEY_SUCCESS)) {
					processSucces = true;
					laborRuleLocations.stream().forEach(laborRuleLocation -> {
						updateStatus(laborRuleLocation);
					});
				}

			} else {
				processSucces = true;
			}
		} catch (Exception ex) {
			LOGGER.error("Error while calling webservice-", ex);
		}

		return processSucces;
	}

	private JSONObject prepareRequest(final List<LaborRuleLocation> laborRuleLocations) {
		JSONObject request = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		laborRuleLocations.stream().forEach(laborRuleLocation -> {
			jsonArray.add(getInputAsJson(laborRuleLocation));
		});
		if (!jsonArray.isEmpty()) {
			request.put("shifts", jsonArray);
		}
		LOGGER.debug("getLocationRuleByTimeCardStatus Calling...request->" + request);
		return request;
	}

	private JSONObject getInputAsJson(final LaborRuleLocation laborRuleLocation) {
		LaborRuleLocationHistory laborRuleLocationHistory = null;
		String locationId = laborRuleLocation.getPrimaryKey().getLaborLocation().getLocationId();
		String ruleId = laborRuleLocation.getPrimaryKey().getLaborRule().getRuleId();
		String ruleTag = laborRuleLocation.getLaborRule().getRuleTag();
		String sDate = laborRuleLocation.getStartDate() != null
				? dateUtils.dateToString(laborRuleLocation.getStartDate(), DateUtils.DATE_FORMAT_COMMON) : null;
		String eDate = laborRuleLocation.getEndDate() != null
				? dateUtils.dateToString(laborRuleLocation.getEndDate(), DateUtils.DATE_FORMAT_COMMON) : null;
		String sDatePre = null;
		String eDatePre = null;

		List<LaborRuleLocationHistory> laborRuleLocationHistoryList = laborRuleLocationHistoryDAO
				.findByLocationIdAndRuleIdOrderByCreatedDateDesc(locationId, ruleId);
		if (!laborRuleLocationHistoryList.isEmpty()) {
			laborRuleLocationHistory = laborRuleLocationHistoryList.get(0);
			sDatePre = laborRuleLocationHistory.getStartDate() != null
					? dateUtils.dateToString(laborRuleLocationHistory.getStartDate(), DateUtils.DATE_FORMAT_COMMON)
					: null;
			eDatePre = laborRuleLocationHistory.getEndDate() != null
					? dateUtils.dateToString(laborRuleLocationHistory.getEndDate(), DateUtils.DATE_FORMAT_COMMON)
					: null;
		}
		return createRequest(locationId, sDate, eDate, sDatePre, eDatePre, ruleTag);
	}

	private JSONObject createRequest(final String locationId, final String sDate, final String eDate,
			final String sDateOld, final String eDateOld, final String ruleTag) {
		JSONObject result = new JSONObject();
		result.put("location_id", locationId);
		result.put("start_date", sDate);
		result.put("end_date", eDate);
		result.put("start_date_previous", sDateOld);
		result.put("old_end_previous", eDateOld);
		result.put("rule_tag", ruleTag);
		LOGGER.debug("JSONObject createRequest:->" + result);
		return result;

	}

	private String callWebService(final JSONObject request, final String token) {
		MultiValueMap<String, String> headers = serviceClientPost.createHeader(token);
		return serviceClientPost.callWebService(request.toString(), serviceUrl, headers);
	}

	private void updateStatus(final LaborRuleLocation laborRuleLocation) {
		laborRuleLocation.setTimecardsUpdateStatus(true);
		laborRuleLocationDAO.save(laborRuleLocation);
	}

	

}

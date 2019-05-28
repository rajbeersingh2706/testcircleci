package com.salido.labor.controller.impl;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salido.labor.common.Constants;
import com.salido.labor.controller.MinWageController;
import com.salido.labor.dto.MinWageDTO;
import com.salido.labor.logic.MinWageLogic;
import com.salido.labor.logic.RuleReProcessorLogic;
import com.salido.labor.util.ResourceMsgUtil;

import net.sf.json.JSONObject;

@RestController
@RequestMapping("/v1/labor/")
public class MinWageControllerImpl implements MinWageController {

	@Autowired
	private MinWageLogic minWageLogic;

	@Resource
	private ResourceMsgUtil resourceMsgUtil;

	@Autowired
	RuleReProcessorLogic ruleReProcessorLogic;

	private static final Logger LOGGER = LogManager.getLogger(LaborRuleControllerImpl.class);

	@Override
	@PostMapping("/addMinWage")
	public String addMinWage(@RequestBody final MinWageDTO minWageDTO, @RequestHeader("Authorization") String authorization) {
		LOGGER.debug("addMinWage service input->" + minWageDTO.toString());
		JSONObject resultObject = new JSONObject();
		try {
			if (minWageDTO.validateAddMinWage() && minWageDTO.validateDates()) {
				minWageLogic.addMinWage(minWageDTO);
				resultObject.put(Constants.KEY_STATUS, Constants.CODE_SUCCESS);
				resultObject.put(Constants.KEY_MESSAGE, resourceMsgUtil.getMessage("minwage.applied.successfully"));
				ruleReProcessorLogic.processTimeCards(authorization);
			}

		} catch (Exception e) {
			LOGGER.error("Excception in addMinWage->", e);
			resultObject.put(Constants.KEY_STATUS, Constants.KEY_ERROR);
			resultObject.put(Constants.KEY_MESSAGE, e.getMessage());
		}
		LOGGER.debug("addMinWage service output->" + resultObject.toString());
		return resultObject.toString();

	}

	@Override
	@PostMapping("/listMinWage")
	public String listMinWageById(@RequestBody final MinWageDTO minWageDTO) {
		LOGGER.debug("listMinWage service input->" + minWageDTO);
		JSONObject jsonObject = new JSONObject();
		try {
			if (minWageDTO.validateListMinWage()) {
				jsonObject.put(Constants.KEY_STATUS, Constants.CODE_SUCCESS);
				jsonObject.put(Constants.KEY_DATA, minWageLogic.listMinWage(minWageDTO));
			}
		} catch (Exception e) {
			LOGGER.error("Excception in listMinWage->", e);
			jsonObject.put(Constants.KEY_STATUS, Constants.KEY_ERROR);
			jsonObject.put(Constants.KEY_MESSAGE, e.getMessage());
		}
		LOGGER.debug("listMinWage service output->" + jsonObject);
		return jsonObject.toString();
	}

}
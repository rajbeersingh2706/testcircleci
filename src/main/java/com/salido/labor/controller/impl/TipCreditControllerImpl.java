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
import com.salido.labor.controller.TipCreditController;
import com.salido.labor.dto.TipCreditDTO;
import com.salido.labor.logic.RuleReProcessorLogic;
import com.salido.labor.logic.TipCreditLogic;
import com.salido.labor.util.ResourceMsgUtil;

import net.sf.json.JSONObject;

@RestController
@RequestMapping("/v1/labor/")
public class TipCreditControllerImpl implements TipCreditController {

	@Autowired
	private TipCreditLogic tipCreditLogic;

	@Resource
	private ResourceMsgUtil resourceMsgUtil;

	@Autowired
	RuleReProcessorLogic ruleReProcessorLogic;

	private static final Logger LOGGER = LogManager.getLogger(LaborRuleControllerImpl.class);

	@Override
	@PostMapping("/addTipCredit")
	public String addTipCredit(@RequestBody final TipCreditDTO tipCreditDTO, @RequestHeader("Authorization") String authorization) {
		LOGGER.debug("tipcredit service input->" + tipCreditDTO.toString());
		JSONObject result = new JSONObject();
		try {
			if (tipCreditDTO.validateAddTipCredit() && tipCreditDTO.validateDates()) {
				tipCreditLogic.addTipCredit(tipCreditDTO);
				result.put(Constants.KEY_STATUS, Constants.CODE_SUCCESS);
				result.put(Constants.KEY_MESSAGE, resourceMsgUtil.getMessage("tipcredit.applied.successfully"));
				ruleReProcessorLogic.processTimeCards(authorization);
			}

		} catch (Exception e) {
			LOGGER.error("Excception in addTipCredit->", e);
			result.put(Constants.KEY_STATUS, Constants.KEY_ERROR);
			result.put(Constants.KEY_MESSAGE, e.getMessage());
		}
		LOGGER.debug("tipcredit service output->" + result.toString());
		return result.toString();

	}

	@Override
	@PostMapping("/listTipCredits")
	public String listTipCreditById(@RequestBody final TipCreditDTO tipCreditDTO) {
		LOGGER.debug("listMinWage service input->" + tipCreditDTO);
		JSONObject jsonObject = new JSONObject();
		try {
			if (tipCreditDTO.validateListTipCredit()) {
				jsonObject.put(Constants.KEY_STATUS, Constants.CODE_SUCCESS);
				jsonObject.put(Constants.KEY_DATA, tipCreditLogic.listTipCreditById(tipCreditDTO));
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

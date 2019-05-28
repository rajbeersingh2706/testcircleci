package com.salido.labor.controller.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salido.labor.common.Constants;
import com.salido.labor.common.RuleActionHandler;
import com.salido.labor.controller.LaborCostController;
import com.salido.labor.cost.logic.impl.LaborCostProcessor;
import com.salido.labor.dto.LaborCostRequestDTO;

import net.sf.json.JSONObject;

@RestController
@RequestMapping("/v1/labor/")
public class LaborCostControllerImpl implements LaborCostController {

	@Autowired
	RuleActionHandler ruleProcessHandler;

	@Autowired
	LaborCostProcessor laborCostProcessor;

	private static final Logger LOGGER = LogManager.getLogger(LaborCostControllerImpl.class);

	@Override
	@PostMapping("/calculateTimecardCost")
	public String calculateTimecardCost(@RequestBody LaborCostRequestDTO laborCostRequestDTO) {
		LOGGER.debug("Input of Calculate Timecard Cost Service-->\t" + laborCostRequestDTO.toString());
		JSONObject costJsonObject = new JSONObject();
		try {
			if (laborCostRequestDTO.validateRequest(laborCostRequestDTO)) {
				costJsonObject.put(Constants.KEY_STATUS, Constants.CODE_SUCCESS);
				costJsonObject.put(Constants.KEY_DATA, laborCostProcessor.processRule(laborCostRequestDTO));
			}
		} catch (Exception e) {
			LOGGER.error("ERROR in Calculate Timecard Cost Service-->\t", e);
			costJsonObject.put(Constants.KEY_STATUS, Constants.KEY_ERROR);
			costJsonObject.put(Constants.KEY_MESSAGE, e.getMessage());
		}
		LOGGER.debug("Response of Calculate Timecard Cost Service-->\t" + costJsonObject.toString());
		return costJsonObject.toString();
	}
}

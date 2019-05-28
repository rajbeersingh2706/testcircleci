package com.salido.labor.controller.impl;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salido.labor.common.Constants;
import com.salido.labor.controller.LaborRuleController;
import com.salido.labor.dto.LaborRuleLocationDTO;
import com.salido.labor.logic.LaborRuleLogic;
import com.salido.labor.logic.RuleReProcessorLogic;
import com.salido.labor.util.ResourceMsgUtil;

import net.sf.json.JSONObject;

@RestController
@RequestMapping("/v1/labor/")
public class LaborRuleControllerImpl implements LaborRuleController {

	@Autowired
	private LaborRuleLogic laborRuleLogic;

	@Resource
	private ResourceMsgUtil resourceMsgUtil;

	@Autowired
	RuleReProcessorLogic ruleReProcessorLogic;

	private static final Logger LOGGER = LogManager.getLogger(LaborRuleControllerImpl.class);

	@Override
	@PostMapping("/listAppliedRule")
	public String listAppliedRule(@RequestBody final LaborRuleLocationDTO locationDTO,
			@RequestHeader("Authorization") String authorization) {
		LOGGER.debug("listAppliedRule service token->" + authorization);
		LOGGER.debug("listAppliedRule service input->" + locationDTO);
		JSONObject ruleJsonObject = new JSONObject();
		try {
			if (locationDTO.validateListAppliedRule()) {
				ruleJsonObject.put(Constants.KEY_STATUS, Constants.CODE_SUCCESS);
				ruleJsonObject.put(Constants.KEY_DATA, laborRuleLogic.listAppliedRule(locationDTO));
				ruleReProcessorLogic.processTimeCards(authorization);
			}

		} catch (Exception e) {
			LOGGER.error("Excception in listAppliedRule->", e);
			ruleJsonObject.put(Constants.KEY_STATUS, Constants.KEY_ERROR);
			ruleJsonObject.put(Constants.KEY_MESSAGE, e.getMessage());
		}
		LOGGER.debug("listAppliedRule service output->" + ruleJsonObject);
		return ruleJsonObject.toString();
	}

	@Override
	@PostMapping("/listAllRules")
	public String listAllRules(@RequestBody final LaborRuleLocationDTO locationDTO) {
		LOGGER.debug("listAllRules service input->" + locationDTO);
		JSONObject allRuleJsonObject = new JSONObject();
		try {
			if (locationDTO.validateListAllRules()) {
				allRuleJsonObject.put(Constants.KEY_STATUS, Constants.CODE_SUCCESS);
				allRuleJsonObject.put(Constants.KEY_DATA, laborRuleLogic.listAllRules(locationDTO));

			}
		} catch (Exception e) {
			LOGGER.error("Excception in listAllRule->", e);
			allRuleJsonObject.put(Constants.KEY_STATUS, Constants.KEY_ERROR);
			allRuleJsonObject.put(Constants.KEY_MESSAGE, e.getMessage());
		}
		LOGGER.debug("listAllRules service output->" + allRuleJsonObject);
		return allRuleJsonObject.toString();
	}

	@Override
	@PostMapping("/applyRule")
	public String applyRule(@Valid @RequestBody final LaborRuleLocationDTO locationDTO) {
		LOGGER.debug("applyRule service inpput->" + locationDTO.toString());
		JSONObject jsonObject = new JSONObject();
		try {
			if (locationDTO.validateApplyRule() && locationDTO.validateDates()) {
				laborRuleLogic.applyRule(locationDTO);
				jsonObject.put(Constants.KEY_STATUS, Constants.CODE_SUCCESS);
				jsonObject.put(Constants.KEY_MESSAGE, resourceMsgUtil.getMessage("laborrule.applied.successfully"));

			}

		} catch (Exception e) {
			LOGGER.error("Excception in applyRule->", e);
			jsonObject.put(Constants.KEY_STATUS, Constants.KEY_ERROR);
			jsonObject.put(Constants.KEY_MESSAGE, e.getMessage());
		}
		LOGGER.debug("applyRule service output->" + jsonObject);
		return jsonObject.toString();

	}

	@Override
	@GetMapping("/getRuleIcon/{ruleId}")
	public void getRuleIcon(@PathVariable("ruleId") final String ruleId, final HttpServletRequest request,
			final HttpServletResponse response) {
		LOGGER.debug("Download rule icon by ruleId Id-->" + ruleId);
		InputStream fin = null;
		try {
			String type = request.getParameter("type");
			fin = laborRuleLogic.getRuleIcon(ruleId, type);
			if (fin != null) {
				response.setContentType("image/svg+xml");
				IOUtils.copy(fin, response.getOutputStream());
				LOGGER.debug("Rule icon written to stream...");
			} else {
				LOGGER.debug("No Rule icon found...");
			}

		} catch (Exception exception) {
			LOGGER.error("Exception get getRuleIcon : rule Id " + ruleId + ": " + exception);
		} finally {
			if (fin != null) {
				try {
					fin.close();
				} catch (IOException e) {
					LOGGER.error("Error in closing the getRuleIcon InputStream: ", e);
				}
			}
		}
	}

}

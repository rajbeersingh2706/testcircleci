
package com.salido.labor.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.salido.labor.dto.LaborRuleLocationDTO;

public interface LaborRuleController {

	public String listAllRules(LaborRuleLocationDTO locationDTO);

	public String applyRule(LaborRuleLocationDTO locationDTO);

	void getRuleIcon(String ruleId, HttpServletRequest request, HttpServletResponse response);

	String listAppliedRule(LaborRuleLocationDTO locationDTO, String token);

}

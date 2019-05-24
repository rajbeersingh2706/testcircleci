package com.salido.labor.controller;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.salido.labor.bean.LaborRuleLocation;
import com.salido.labor.data.LaborLocationData;
import com.salido.labor.dto.LaborRuleLocationDTO;
import com.salido.labor.logic.LaborRuleLogic;
import com.salido.labor.logic.RuleReProcessorLogic;
import com.salido.labor.util.ResourceMsgUtil;

import net.minidev.json.parser.ParseException;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONTokener;

@RunWith(SpringRunner.class)
@WebMvcTest(value = LaborRuleController.class, secure = false)
public class LaborRuleControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private LaborRuleLogic laborRuleLogic;

	@MockBean
	RuleReProcessorLogic ruleReProcessorLogic;

	@MockBean
	private ResourceMsgUtil messageResource;

	String baseUri = "/v1/labor";

	String applyRule = baseUri + "/applyRule";

	String listAllRules = baseUri + "/listAllRules";

	String listAppliedRule = baseUri + "/listAppliedRule";

	LaborLocationData laborLocationData = new LaborLocationData();

	/*
	 * apply-rule check
	 */
	@Test
	public void applyRule() throws Exception {

		JSONObject inputJson = laborLocationData.applyRule();
		LaborRuleLocation laborRuleLocation = new LaborRuleLocation();

		Mockito.when(laborRuleLogic.applyRule(Mockito.any(LaborRuleLocationDTO.class))).thenReturn(laborRuleLocation);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(applyRule).accept(MediaType.APPLICATION_JSON)
				.content(inputJson.toString()).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		JSONObject jObect = mapToString(response.getContentAsString());
		assertEquals("200", jObect.get("status"));

	}

	@Test
	public void applyRuleValidationFail() throws Exception {
		JSONObject inputJson = laborLocationData.applyRule();
		inputJson.remove("locationId");
		LaborRuleLocation laborRuleLocation = new LaborRuleLocation();
		Mockito.when(laborRuleLogic.applyRule(Mockito.any(LaborRuleLocationDTO.class))).thenReturn(laborRuleLocation);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(applyRule).accept(MediaType.APPLICATION_JSON)
				.content(inputJson.toString()).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		JSONObject jObect = mapToString(response.getContentAsString());
		assertEquals("201", jObect.get("status"));
	}

	/*
	 * list-Applied-Rule check
	 */
	@Test
	public void listAppliedRule() throws Exception {

		JSONObject inputJson = laborLocationData.listAppliedRule();
		List<LaborRuleLocation> laborRuleLocationList = laborLocationData.laborRuleLocationList();
		Mockito.when(laborRuleLogic.listAppliedRule(Mockito.any(LaborRuleLocationDTO.class)))
				.thenReturn(laborRuleLocationList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(listAppliedRule).accept(MediaType.APPLICATION_JSON)
				.header("token", "14885424555654756").content(inputJson.toString())
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		JSONObject jObect = mapToString(response.getContentAsString());
		assertEquals("200", jObect.get("status"));

	}

	@Test
	public void listAppliedRuleValidationFail() throws Exception {

		JSONObject inputJson = laborLocationData.listAppliedRule();
		inputJson.remove("brandId");
		List<LaborRuleLocation> laborRuleLocationList = laborLocationData.laborRuleLocationList();
		Mockito.when(laborRuleLogic.listAppliedRule(Mockito.any(LaborRuleLocationDTO.class)))
				.thenReturn(laborRuleLocationList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(listAppliedRule).accept(MediaType.APPLICATION_JSON)
				.header("token", "14885424555654756").content(inputJson.toString())
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		JSONObject jObect = mapToString(response.getContentAsString());
		assertEquals("201", jObect.get("status"));

	}

	/* check rules list(applied+fresh) */

	@Test
	public void listAllRules() throws Exception {

		JSONObject inputJson = laborLocationData.listAllRules();
		List<LaborRuleLocation> laborRuleLocationList = laborLocationData.laborRuleLocationListAll();
		Mockito.when(laborRuleLogic.listAllRules(Mockito.any(LaborRuleLocationDTO.class)))
				.thenReturn(laborRuleLocationList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(listAllRules).accept(MediaType.APPLICATION_JSON)
				.content(inputJson.toString()).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		JSONObject jObect = mapToString(response.getContentAsString());
		assertEquals("200", jObect.get("status"));
	}

	@Test
	public void listAllRulesValidationFail() throws Exception {
		JSONObject inputJson = laborLocationData.listAllRules();
		inputJson.remove("orgId");
		List<LaborRuleLocation> laborRuleLocationList = laborLocationData.laborRuleLocationListAll();
		Mockito.when(laborRuleLogic.listAllRules(Mockito.any(LaborRuleLocationDTO.class)))
				.thenReturn(laborRuleLocationList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(listAllRules).accept(MediaType.APPLICATION_JSON)
				.content(inputJson.toString()).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		JSONObject jObect = mapToString(response.getContentAsString());
		assertEquals("201", jObect.get("status"));

	}

	private JSONObject mapToString(String str) throws ParseException {
		JSONTokener jsonTokener = new JSONTokener(str);
		JSONObject obj = (JSONObject) jsonTokener.nextValue();
		return obj;
	}

}

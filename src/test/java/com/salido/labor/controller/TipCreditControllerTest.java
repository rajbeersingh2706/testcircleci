package com.salido.labor.controller;

import static org.junit.Assert.assertEquals;

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

import com.salido.labor.bean.LocationTipCredits;
import com.salido.labor.data.TipCreditData;
import com.salido.labor.dto.TipCreditDTO;
import com.salido.labor.logic.RuleReProcessorLogic;
import com.salido.labor.logic.TipCreditLogic;
import com.salido.labor.util.ResourceMsgUtil;

import net.minidev.json.parser.ParseException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONTokener;

@RunWith(SpringRunner.class)
@WebMvcTest(value = TipCreditController.class, secure = false)
public class TipCreditControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TipCreditLogic tipCreditLogic;

	@MockBean
	RuleReProcessorLogic ruleReProcessorLogic;

	@MockBean
	private ResourceMsgUtil messageResource;

	String baseUri = "/v1/labor";

	String addTipCredit = baseUri + "/addTipCredit";

	String listTipCredits = baseUri + "/listTipCredits";

	TipCreditData tipCreditData = new TipCreditData();

	/*
	 * add tip credit check
	 */

	@Test
	public void addtipCreditTestPass() throws Exception {

		JSONObject inputJson = tipCreditData.addtipCredit();

		LocationTipCredits locationTipCredits = tipCreditData.locationTipCreditsData();
		Mockito.when(tipCreditLogic.addTipCredit(Mockito.any(TipCreditDTO.class))).thenReturn(locationTipCredits);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(addTipCredit).accept(MediaType.APPLICATION_JSON)
				.header("token", "14885424555654756").content(inputJson.toString())
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		JSONObject jObect = mapToString(response.getContentAsString());
		assertEquals("200", jObect.get("status"));

	}

	@Test
	public void addtipCreditTestFail() throws Exception {

		JSONObject inputJson = tipCreditData.addtipCredit();
		inputJson.remove("orgId");

		LocationTipCredits locationTipCredits = tipCreditData.locationTipCreditsData();
		Mockito.when(tipCreditLogic.addTipCredit(Mockito.any(TipCreditDTO.class))).thenReturn(locationTipCredits);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(addTipCredit).accept(MediaType.APPLICATION_JSON)
				.header("token", "14885424555654756").content(inputJson.toString())
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		JSONObject jObect = mapToString(response.getContentAsString());
		assertEquals("201", jObect.get("status"));

	}

	/*
	 * list-tip-credit check
	 */

	@SuppressWarnings("unchecked")
	@Test
	public void listTipCreditTestPass() throws Exception {

		JSONObject inputJson = tipCreditData.listTipCredit();
		JSONArray pArray = tipCreditData.listTipCreditData();
		Mockito.when(tipCreditLogic.listTipCreditById(Mockito.any(TipCreditDTO.class))).thenReturn(pArray);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(listTipCredits).accept(MediaType.APPLICATION_JSON)
				.content(inputJson.toString()).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		JSONObject jObect = mapToString(response.getContentAsString());
		assertEquals("200", jObect.get("status"));

	}

	@SuppressWarnings("unchecked")
	@Test
	public void listTipCreditTestFail() throws Exception {
		JSONObject inputJson = tipCreditData.listTipCredit();
		inputJson.remove("orgId");
		JSONArray pArray = tipCreditData.listTipCreditData();
		Mockito.when(tipCreditLogic.listTipCreditById(Mockito.any(TipCreditDTO.class))).thenReturn(pArray);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(listTipCredits).accept(MediaType.APPLICATION_JSON)
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

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

import com.salido.labor.bean.LocationMinWage;
import com.salido.labor.data.MinWageData;
import com.salido.labor.dto.MinWageDTO;
import com.salido.labor.logic.MinWageLogic;
import com.salido.labor.logic.RuleReProcessorLogic;
import com.salido.labor.util.ResourceMsgUtil;

import net.minidev.json.parser.ParseException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONTokener;

@RunWith(SpringRunner.class)
@WebMvcTest(value = MinWageController.class, secure = false)
public class MinWageControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private MinWageLogic minWageLogic;

	@MockBean
	RuleReProcessorLogic ruleReProcessorLogic;

	@MockBean
	private ResourceMsgUtil messageResource;

	String baseUri = "/v1/labor";

	String addMinWage = baseUri + "/addMinWage";

	String listMinWage = baseUri + "/listMinWage";

	MinWageData minWageData = new MinWageData();

	/*
	 * add minimum wage check
	 */
	@Test
	public void addMinWageTestPass() throws Exception {

		JSONObject inputJson = minWageData.addMinWage();
		LocationMinWage locationMinWage = minWageData.locationMinWageData();
		Mockito.when(minWageLogic.addMinWage(Mockito.any(MinWageDTO.class))).thenReturn(locationMinWage);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(addMinWage).accept(MediaType.APPLICATION_JSON)
				.header("token", "14885424555654756").content(inputJson.toString())
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		JSONObject jObect = mapToString(response.getContentAsString());
		assertEquals("200", jObect.get("status"));

	}

	@Test
	public void addMinWageTestFail() throws Exception {

		JSONObject inputJson = minWageData.addMinWage();
		inputJson.remove("orgId");
		LocationMinWage locationMinWage = minWageData.locationMinWageData();
		Mockito.when(minWageLogic.addMinWage(Mockito.any(MinWageDTO.class))).thenReturn(locationMinWage);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(addMinWage).accept(MediaType.APPLICATION_JSON)
				.header("token", "14885424555654756").content(inputJson.toString())
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		JSONObject jObect = mapToString(response.getContentAsString());
		assertEquals("201", jObect.get("status"));

	}

	/*
	 * list-minimum-wage check
	 */

	@SuppressWarnings("unchecked")
	@Test
	public void listMinWageTestPass() throws Exception {

		JSONObject inputJson = minWageData.listMinWage();
		JSONArray pArray = minWageData.listMinWageData();
		Mockito.when(minWageLogic.listMinWage(Mockito.any(MinWageDTO.class))).thenReturn(pArray);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(listMinWage).accept(MediaType.APPLICATION_JSON)
				.content(inputJson.toString()).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		JSONObject jObect = mapToString(response.getContentAsString());
		assertEquals("200", jObect.get("status"));

	}

	@SuppressWarnings("unchecked")
	@Test
	public void listMinWageTestFail() throws Exception {

		JSONObject inputJson = minWageData.listMinWage();
		inputJson.remove("brandId");
		JSONArray pArray = minWageData.listMinWageData();
		Mockito.when(minWageLogic.listMinWage(Mockito.any(MinWageDTO.class))).thenReturn(pArray);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(listMinWage).accept(MediaType.APPLICATION_JSON)
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

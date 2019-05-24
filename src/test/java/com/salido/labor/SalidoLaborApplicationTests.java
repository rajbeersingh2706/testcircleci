/*package com.salido.labor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.salido.labor.bean.LaborRule;
import com.salido.labor.bean.LaborRuleLocation;
import com.salido.labor.controller.LaborRuleController;

import com.salido.labor.logic.LaborRuleLogic;

@RunWith(SpringRunner.class)
@WebMvcTest(value = LaborRuleController.class, secure = false)
public class SalidoLaborApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private LaborRuleLogic laborRuleLogic;

	// add-rule controller check
	@Test
	public void testAddRulePass() throws Exception {
		LaborRule laborRule = new LaborRule();
		laborRule.setId("1"); // --------------------------------------------->// pass case
								
		laborRule.setName("rohit");
		laborRule.setDescription("desc1");
		laborRule.setRuleTag("rultag1");
		laborRule.setCreatedDate(null);
		laborRule.setCreatedBy("try");
		laborRule.setUpdatedDate(null);
		laborRule.setUpdatedBy("up");
		String inputInJson = this.mapToJson(laborRule);
		String URI = "/labor/applyRule";
		Mockito.when(laborRuleLogic.addRule(Mockito.any(LaborRule.class))).thenReturn(laborRule);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON)
				.content(inputInJson).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();

		String outputInJson = response.getContentAsString();

		assertThat(outputInJson).isEqualTo(inputInJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());

	}

	@Test
	public void testAddRulefail1() throws Exception {
		LaborRule laborRule = new LaborRule();
		laborRule.setId("2"); // --------------------------------------------->// fail case due to (method=get)
								
		laborRule.setName("rohit");
		laborRule.setDescription("desc1");
		laborRule.setRuleTag("rultag1");
		laborRule.setCreatedDate(null);
		laborRule.setCreatedBy("try");
		laborRule.setUpdatedDate(null);
		laborRule.setUpdatedBy("up");
		String inputInJson = this.mapToJson(laborRule);
		String URI = "/labor/applyRule";
		Mockito.when(laborRuleLogic.addRule(Mockito.any(LaborRule.class))).thenReturn(laborRule);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)
				.content(inputInJson).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();

		String outputInJson = response.getContentAsString();

		assertThat(outputInJson).isEqualTo(inputInJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());

	}

	// -----------------------------------------------------------------------------------------------------------------------------------------------------
								// get list(applied+fresh) check
	@Test
	public void testListAllLaborRule() throws Exception {
		LaborRule laborRule = new LaborRule();
		laborRule.setId("1");
		laborRule.setName("rohit");
		laborRule.setDescription("desc1");
		laborRule.setRuleTag("rultag1");
		laborRule.setLocationId("L1");
		laborRule.setLocationName("h1");
		laborRule.setStartDate(null);
		laborRule.setEndDate(null);
		laborRule.setStatus("1");

		LaborRule laborRule1 = new LaborRule();
		laborRule.setId("2");
		laborRule.setName("rohit");
		laborRule.setDescription("desc1");
		laborRule.setRuleTag("rultag1");
		laborRule.setLocationId("L1");
		laborRule.setLocationName("h1");
		laborRule.setStartDate(null);
		laborRule.setEndDate(null);
		laborRule.setStatus("1");
		List<LaborRule> labRuleList = new ArrayList<>();
		labRuleList.add(laborRule);
		labRuleList.add(laborRule1);
		Mockito.when(laborRuleLogic.listAllRules()).thenReturn(labRuleList);
		String URI = "/labor/listAppliedRules";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expectedJson = this.mapToJson(labRuleList);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}
	// ---------------------------------------------------------------------------------------------------------------------------------------------------

											// add-rule location check
	@Test
	public void testAddLocationPass() throws Exception {
		LaborRuleLocation ruleLocation = new LaborRuleLocation();
		LaborRule rule = new LaborRule();
		rule.setId("1"); 
							
		rule.setName("rohit");
		rule.setDescription("desc1");
		rule.setRuleTag("rultag1");
		rule.setCreatedDate(null);
		rule.setCreatedBy("try");
		rule.setUpdatedDate(null);
		rule.setUpdatedBy("up");

		LaborRule rule1 = new LaborRule();
		rule1.setId("2"); 
						
		rule1.setName("srivastava");
		rule1.setDescription("desc1");
		rule1.setRuleTag("rultag1");
		rule1.setCreatedDate(null);
		rule1.setCreatedBy("try");
		rule1.setUpdatedDate(null);
		rule1.setUpdatedBy("up");
		List<LaborRule> laborRule = new ArrayList<LaborRule>();
		laborRule.add(rule);
		laborRule.add(rule1);

		ruleLocation.setId("11"); 
		ruleLocation.setLaborRule(laborRule);
		ruleLocation.setOrgId("123");
		ruleLocation.setBrandId("b1");
		ruleLocation.setBrandName("nike");
		ruleLocation.setLocationId("l1");
		ruleLocation.setLocationName("loc1");
		ruleLocation.setStartDate(null);
		ruleLocation.setEndDate(null);
		ruleLocation.setStatus("1");
		ruleLocation.setCreatedDate(null);
		ruleLocation.setCreatedBy("try");
		ruleLocation.setUpdatedDate(null);
		ruleLocation.setUpdatedBy("up");
		String id = rule.getId();

		String inputInJson = this.mapToJson(ruleLocation);
		String URI = "/labor/applyRuleLocation/1/rule_location";
		Mockito.when(laborRuleLogic.addRuleLocation(Mockito.any(LaborRuleLocation.class), Mockito.eq(id)))
				.thenReturn(ruleLocation);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON)
				.content(inputInJson).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();

		String outputInJson = response.getContentAsString();

		assertThat(outputInJson).isEqualTo(inputInJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());

	}

	// -----------------------------------------------------------------------------------------------------------------------------------------------

																	// objectMapper
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}

	
	 * @Autowired private LaborRuleLogic laborRuleLogic;
	 * 
	 * @MockBean private LaborRuleDAO laborRuleDAO;
	 * 
	 * @Test public void testAddLocationPass() throws Exception {
	 * LaborRuleLocation ruleLocation=new LaborRuleLocation(); List<LaborRule>
	 * lr=new ArrayList<>(); ruleLocation.setId("1"); //
	 * ---------------------------------------------> pass case
	 * ruleLocation.setLaborRule(null); ruleLocation.setOrgId("123");
	 * ruleLocation.setBrandId("b1"); ruleLocation.setBrandName("nike");
	 * ruleLocation.setLocationId("l1"); ruleLocation.setLocationName("loc1");
	 * ruleLocation.setStartDate(null); ruleLocation.setEndDate(null);
	 * ruleLocation.setStatus("1"); ruleLocation.setCreatedDate(null);
	 * ruleLocation.setCreatedBy("try"); ruleLocation.setUpdatedDate(null);
	 * ruleLocation.setUpdatedBy("up");
	 * Mockito.when(laborRuleDAO.save(ruleLocation)).thenReturn(ruleLocation);
	 * 
	 * assertThat(laborRuleLogic.addRuleLocation(ruleLocation,
	 * id)).isEqualTo(ruleLocation);
	 * 
	 * }
	 

}
*/
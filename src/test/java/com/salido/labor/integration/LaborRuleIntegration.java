package com.salido.labor.integration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.salido.labor.SalidoLaborApplication;
import com.salido.labor.data.CommonData;
import com.salido.labor.data.LaborLocationData;
import com.salido.labor.dto.LaborRuleLocationDTO;
import com.salido.labor.dto.Location;

import net.sf.json.JSONObject;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SalidoLaborApplication.class)
@AutoConfigureMockMvc
public class LaborRuleIntegration {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate testRestTemplate;

	private HttpHeaders headers = new HttpHeaders();

	@Autowired
	MockMvc mockMvc;

	String baseUri = "/v1/labor";

	String applyRule = baseUri + "/applyRule";

	String listAllRules = baseUri + "/listAllRules";

	String listAppliedRule = baseUri + "/listAppliedRule";

	LaborLocationData laborLocationData = new LaborLocationData();

	private String location_one = "l1";
	private String location_two = "l2";
	private String location_three = "l3";

	private String federal_ruleId = "eb64162b-910c-4f9c-844c-b7f171d8c75a";
	private String california_ruleId = "52682848-e4bb-4808-9b51-6193e910b959";
	private String weekly_fourty_ruleId = "cc98da40-d23a-47a3-b484-085214ec5682";
	private String tipcredit_ruleId = "5bc758c6-e947-49e1-96a6-60cc7d4a0b75";
	private String soh_ruleId = "0c4cc6fe-4a2c-41ba-a651-e04f72f9204d";

	CommonData commonData = new CommonData();

	@Test
	public void testApplyRulePassOne() throws Exception {

		HttpEntity<LaborRuleLocationDTO> entity = new HttpEntity<LaborRuleLocationDTO>(
				laborLocationData.laborRuleLocationDataDTO(federal_ruleId, location_one), headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(applyRule), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("200");
	}

	@Test
	public void testApplyRulePassSecond() throws Exception {

		HttpEntity<LaborRuleLocationDTO> entity = new HttpEntity<LaborRuleLocationDTO>(
				laborLocationData.laborRuleLocationDataDTO(tipcredit_ruleId, location_one), headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(applyRule), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("200");
	}

	@Test
	public void testApplyRulePassThird() throws Exception {

		HttpEntity<LaborRuleLocationDTO> entity = new HttpEntity<LaborRuleLocationDTO>(
				laborLocationData.laborRuleLocationDataDTO(soh_ruleId, location_one), headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(applyRule), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("200");
	}

	@Test
	public void testApplyRulePassFourth() throws Exception {

		HttpEntity<LaborRuleLocationDTO> entity = new HttpEntity<LaborRuleLocationDTO>(
				laborLocationData.laborRuleLocationDataDTO(california_ruleId, location_two), headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(applyRule), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("200");
	}

	@Test
	public void testApplyRulePassFifth() throws Exception {

		HttpEntity<LaborRuleLocationDTO> entity = new HttpEntity<LaborRuleLocationDTO>(
				laborLocationData.laborRuleLocationDataDTO(tipcredit_ruleId, location_two), headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(applyRule), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("200");
	}

	@Test
	public void testApplyRulePassSixth() throws Exception {

		HttpEntity<LaborRuleLocationDTO> entity = new HttpEntity<LaborRuleLocationDTO>(
				laborLocationData.laborRuleLocationDataDTO(soh_ruleId, location_two), headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(applyRule), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("200");
	}

	@Test
	public void testApplyRulePassSeventh() throws Exception {

		HttpEntity<LaborRuleLocationDTO> entity = new HttpEntity<LaborRuleLocationDTO>(
				laborLocationData.laborRuleLocationDataDTO(weekly_fourty_ruleId, location_three), headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(applyRule), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("200");
	}

	@Test
	public void testApplyRulePassEirth() throws Exception {

		HttpEntity<LaborRuleLocationDTO> entity = new HttpEntity<LaborRuleLocationDTO>(
				laborLocationData.laborRuleLocationDataDTO(tipcredit_ruleId, location_three), headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(applyRule), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("200");
	}

	@Test
	public void testApplyRulePassNinth() throws Exception {

		HttpEntity<LaborRuleLocationDTO> entity = new HttpEntity<LaborRuleLocationDTO>(
				laborLocationData.laborRuleLocationDataDTO(soh_ruleId, location_three), headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(applyRule), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("200");
	}

	@Test
	public void testApplyRuleWithoutRuleId() throws Exception {
		LaborRuleLocationDTO ruleLocationAddData = laborLocationData.laborRuleLocationDataForError();
		ruleLocationAddData.setRuleId(null);
		HttpEntity<LaborRuleLocationDTO> entity = new HttpEntity<LaborRuleLocationDTO>(ruleLocationAddData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(applyRule), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("201");
	}

	@Test
	public void testApplyRuleLocationIdMissing() throws Exception {

		LaborRuleLocationDTO ruleLocationAddData = laborLocationData.laborRuleLocationDataForError();
		ruleLocationAddData.setLocationId(null);
		HttpEntity<LaborRuleLocationDTO> entity = new HttpEntity<LaborRuleLocationDTO>(ruleLocationAddData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(applyRule), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("201");
	}

	@Test
	public void testApplyRuleInvalidStartDate() throws Exception {

		LaborRuleLocationDTO ruleLocationAddData = laborLocationData.laborRuleLocationDataForError();
		ruleLocationAddData.setStartDate(null);
		HttpEntity<LaborRuleLocationDTO> entity = new HttpEntity<LaborRuleLocationDTO>(ruleLocationAddData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(applyRule), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("201");
	}

	@Test
	public void testApplyRuleCreatedByMissing() throws Exception {

		LaborRuleLocationDTO ruleLocationAddData = laborLocationData.laborRuleLocationDataForError();
		ruleLocationAddData.setCreatedBy(null);
		HttpEntity<LaborRuleLocationDTO> entity = new HttpEntity<LaborRuleLocationDTO>(ruleLocationAddData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(applyRule), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("201");
	}

	@Test
	public void testApplyRuleInvalidEndDate() throws Exception {

		LaborRuleLocationDTO ruleLocationAddData = laborLocationData.laborRuleLocationDataForError();
		ruleLocationAddData.setEndDate("2018-11-02");
		HttpEntity<LaborRuleLocationDTO> entity = new HttpEntity<LaborRuleLocationDTO>(ruleLocationAddData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(applyRule), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("201");
	}

	@Test
	public void testApplyRulenNonExistingRuleId() throws Exception {

		LaborRuleLocationDTO ruleLocationAddData = laborLocationData.laborRuleLocationDataForError();
		ruleLocationAddData.setRuleId("rule002");
		HttpEntity<LaborRuleLocationDTO> entity = new HttpEntity<LaborRuleLocationDTO>(ruleLocationAddData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(applyRule), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("201");
	}

	@Test
	public void testApplyRulenNonExistingLocationId() throws Exception {

		LaborRuleLocationDTO ruleLocationAddData = laborLocationData.laborRuleLocationDataForError();
		ruleLocationAddData.setLocationId("l17");
		HttpEntity<LaborRuleLocationDTO> entity = new HttpEntity<LaborRuleLocationDTO>(ruleLocationAddData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(applyRule), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("201");
	}

	@Test
	public void testApplyRuleValidEndDate() throws Exception {

		LaborRuleLocationDTO ruleLocationAddData = laborLocationData.laborRuleLocationDataDTO("RULE001", "l9");
		ruleLocationAddData.setEndDate("2020-01-01");
		HttpEntity<LaborRuleLocationDTO> entity = new HttpEntity<LaborRuleLocationDTO>(ruleLocationAddData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(applyRule), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("200");
	}

	@Test
	public void testListAllRulesPass() throws Exception {

		HttpEntity<LaborRuleLocationDTO> entity = new HttpEntity<LaborRuleLocationDTO>(
				laborLocationData.listAllRuleDataDTO(), headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(listAllRules), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("200");
	}

	@Test
	public void testListAllRulesBrandIdMissing() throws Exception {

		LaborRuleLocationDTO ruleLocationAddData = laborLocationData.laborRuleLocationDataForError();
		ruleLocationAddData.setBrandId(null);
		HttpEntity<LaborRuleLocationDTO> entity = new HttpEntity<LaborRuleLocationDTO>(ruleLocationAddData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(listAllRules), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("201");
	}

	@Test
	public void testListAllRulesLocationIdNonExisting() throws Exception {

		LaborRuleLocationDTO ruleLocationAddData = laborLocationData.listAllRuleDataDTO();
		ruleLocationAddData.setLocationId("l10");
		HttpEntity<LaborRuleLocationDTO> entity = new HttpEntity<LaborRuleLocationDTO>(ruleLocationAddData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(listAllRules), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("200");
	}

	@Test
	public void testListAllRulesLocationIdMissing() throws Exception {

		LaborRuleLocationDTO ruleLocationAddData = laborLocationData.laborRuleLocationDataForError();
		ruleLocationAddData.setLocationId(null);
		HttpEntity<LaborRuleLocationDTO> entity = new HttpEntity<LaborRuleLocationDTO>(ruleLocationAddData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(listAllRules), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("201");
	}

	@Test
	public void testListAllRulesOrgIdNonExisting() throws Exception {

		LaborRuleLocationDTO ruleLocationAddData = laborLocationData.laborRuleLocationDataForError();
		ruleLocationAddData.setOrgId("o10");
		HttpEntity<LaborRuleLocationDTO> entity = new HttpEntity<LaborRuleLocationDTO>(ruleLocationAddData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(listAllRules), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("200");
	}

	@Test
	public void testlistAppliedRulePass() throws Exception {
		headers.add("token", "14785236658542");
		HttpEntity<LaborRuleLocationDTO> entity = new HttpEntity<LaborRuleLocationDTO>(
				laborLocationData.listAppliedRuleLocationDataDTO(), headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(listAppliedRule),
				HttpMethod.POST, entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("200");
	}

	@Test
	public void testlistAppliedRuleLocationIdNotExist() throws Exception {
		headers.add("token", "14785236658542");
		LaborRuleLocationDTO appliedRuleData = laborLocationData.laborRuleLocationDataForError();
		Location[] locations = new Location[1];
		Location location = new Location();
		location.setLocationId(null);
		location.setLocationName("l10");
		locations[0] = location;
		appliedRuleData.setLocations(locations);
		HttpEntity<LaborRuleLocationDTO> entity = new HttpEntity<LaborRuleLocationDTO>(appliedRuleData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(listAppliedRule),
				HttpMethod.POST, entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("201");
	}

	@Test
	public void testlistAppliedRuleLocationNameNotExist() throws Exception {
		headers.add("token", "14785236658542");
		LaborRuleLocationDTO appliedRuleData = laborLocationData.listAppliedRuleLocationDataDTO();
		Location[] locations = new Location[1];
		Location location = new Location();
		location.setLocationId("l1");
		location.setLocationName(null);
		locations[0] = location;
		appliedRuleData.setLocations(locations);
		HttpEntity<LaborRuleLocationDTO> entity = new HttpEntity<LaborRuleLocationDTO>(appliedRuleData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(listAppliedRule),
				HttpMethod.POST, entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("201");
	}

	@Test
	public void testlistAppliedRuleLocationMissing() throws Exception {
		headers.add("token", "14785236658542");
		LaborRuleLocationDTO appliedRuleData = laborLocationData.laborRuleLocationDataForError();
		appliedRuleData.setLocations(null);
		HttpEntity<LaborRuleLocationDTO> entity = new HttpEntity<LaborRuleLocationDTO>(appliedRuleData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(listAppliedRule),
				HttpMethod.POST, entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("201");
	}

	@Test
	public void testlistAppliedRuleLocationNotExist() throws Exception {
		headers.add("token", "14785236658542");
		LaborRuleLocationDTO appliedRuleData = laborLocationData.laborRuleLocationDataForError();
		Location[] locations = new Location[1];
		Location location = new Location();
		location.setLocationId("l10");
		location.setLocationName("Denmark");
		locations[0] = location;
		appliedRuleData.setLocations(locations);
		HttpEntity<LaborRuleLocationDTO> entity = new HttpEntity<LaborRuleLocationDTO>(appliedRuleData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(listAppliedRule),
				HttpMethod.POST, entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("200");
	}

	@Test
	public void testgetRuleIcon() throws Exception {
		String uri = baseUri + "/getRuleIcon/r1";
		testRestTemplate.getForObject(formFullURLWithPort(uri), String.class);

	}

	@Test
	public void testgetRuleIconWithoutId() throws Exception {
		String uri = baseUri + "/getRuleIcon/";
		testRestTemplate.getForObject(formFullURLWithPort(uri), String.class);

	}

	@Test
	public void testgetRuleIconInvalidRuleId() throws Exception {
		String uri = baseUri + "/getRuleIcon/r10";
		testRestTemplate.getForObject(formFullURLWithPort(uri), String.class);

	}

	private String formFullURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
}

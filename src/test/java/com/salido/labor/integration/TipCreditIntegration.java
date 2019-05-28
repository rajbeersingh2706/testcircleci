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
import com.salido.labor.data.TipCreditData;
import com.salido.labor.dto.Location;
import com.salido.labor.dto.TipCreditDTO;

import net.sf.json.JSONObject;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SalidoLaborApplication.class)
@AutoConfigureMockMvc
public class TipCreditIntegration {
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate testRestTemplate;

	private HttpHeaders headers = new HttpHeaders();

	@Autowired
	MockMvc mockMvc;

	String baseUri = "/v1/labor";

	String addTipCredit = baseUri + "/addTipCredit";

	String listTipCredits = baseUri + "/listTipCredits";

	TipCreditData tipCreditData = new TipCreditData();

	CommonData commonData = new CommonData();

	/*
	 * ADD TIP CREDIT (PASS CASE)
	 */

	@Test
	public void testAddTipCreditPass() throws Exception {
		headers.add("token", "14785236658542");
		HttpEntity<TipCreditDTO> entity = new HttpEntity<TipCreditDTO>(tipCreditData.tipCreditDataDTO(), headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(addTipCredit), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("200");
	}

	@Test
	public void testAddTipCreditPassForLocationOne() throws Exception {
		headers.add("token", "14785236658542");
		HttpEntity<TipCreditDTO> entity = new HttpEntity<TipCreditDTO>(tipCreditData.tipCreditDataDTO("l1"), headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(addTipCredit), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("200");
	}

	@Test
	public void testAddTipCreditPassForLocationSecond() throws Exception {
		headers.add("token", "14785236658542");
		HttpEntity<TipCreditDTO> entity = new HttpEntity<TipCreditDTO>(tipCreditData.tipCreditDataDTO("l2"), headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(addTipCredit), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("200");
	}

	@Test
	public void testAddTipCreditPassForLocationThird() throws Exception {
		headers.add("token", "14785236658542");
		HttpEntity<TipCreditDTO> entity = new HttpEntity<TipCreditDTO>(tipCreditData.tipCreditDataDTO("l3"), headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(addTipCredit), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("200");
	}

	/*
	 * Location-Id IS MISSING
	 */

	@Test
	public void testAddTipCreditLocationMissing() throws Exception {
		headers.add("token", "14785236658542");
		TipCreditDTO tipCreditAddData = tipCreditData.tipCreditDataDTO();
		tipCreditAddData.setLocationId(null);
		HttpEntity<TipCreditDTO> entity = new HttpEntity<TipCreditDTO>(tipCreditAddData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(addTipCredit), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("201");
	}

	/*
	 * Location-Id IS NOT EXISTING
	 */

	@Test
	public void testAddTipCreditNotExistingLocation() throws Exception {
		headers.add("token", "14785236658542");
		TipCreditDTO tipCreditAddData = tipCreditData.tipCreditDataDTO();
		tipCreditAddData.setLocationId("L4");
		HttpEntity<TipCreditDTO> entity = new HttpEntity<TipCreditDTO>(tipCreditAddData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(addTipCredit), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("201");
	}

	/*
	 * Start-Date IS INVALID
	 */

	@Test
	public void testAddTipCreditInvalidStartDate() throws Exception {
		headers.add("token", "14785236658542");
		TipCreditDTO tipCreditAddData = tipCreditData.tipCreditDataDTO();
		tipCreditAddData.setStartDate(null);
		HttpEntity<TipCreditDTO> entity = new HttpEntity<TipCreditDTO>(tipCreditAddData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(addTipCredit), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("201");
	}

	/*
	 * Tip-Credit IS MISSING
	 */

	@Test
	public void testAddTipCreditMissingTipCredit() throws Exception {
		headers.add("token", "14785236658542");
		TipCreditDTO tipCreditAddData = tipCreditData.tipCreditDataDTO();
		tipCreditAddData.setTipCredit(null);
		HttpEntity<TipCreditDTO> entity = new HttpEntity<TipCreditDTO>(tipCreditAddData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(addTipCredit), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("201");
	}

	/*
	 * EndDate not null
	 */

	@Test
	public void testAddTipCreditEndDateNotNull() throws Exception {
		headers.add("token", "14785236658542");
		TipCreditDTO tipCreditAddData = tipCreditData.tipCreditDataDTO();
		tipCreditAddData.setEndDate("2022-12-11");
		HttpEntity<TipCreditDTO> entity = new HttpEntity<TipCreditDTO>(tipCreditAddData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(addTipCredit), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("200");
	}

	/*
	 * Add Tip-Credit
	 */

	@Test
	public void testAddTipCredit() throws Exception {
		headers.add("token", "14785236658542");
		TipCreditDTO tipCreditAddData = tipCreditData.tipCreditDataDTO();
		tipCreditAddData.setId(null);
		tipCreditAddData.setEndDate("2021-11-11");
		HttpEntity<TipCreditDTO> entity = new HttpEntity<TipCreditDTO>(tipCreditAddData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(addTipCredit), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("200");
	}

	/*
	 * LIST TIP CREDIT (PASS CASE)
	 */

	@Test
	public void testListTipCreditPass() throws Exception {
		HttpEntity<TipCreditDTO> entity = new HttpEntity<TipCreditDTO>(tipCreditData.tipCreditDataListDTO(), headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(listTipCredits),
				HttpMethod.POST, entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("200");
	}

	/*
	 * Brand-Id IS MISSING
	 */

	@Test
	public void testListTipCreditBrandIdMissing() throws Exception {
		TipCreditDTO tipCreditDataList = tipCreditData.tipCreditDataListDTO();
		tipCreditDataList.setBrandId(null);
		HttpEntity<TipCreditDTO> entity = new HttpEntity<TipCreditDTO>(tipCreditDataList, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(listTipCredits),
				HttpMethod.POST, entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("201");
	}

	/*
	 * Organization-Id IS MISSING
	 */

	@Test
	public void testListTipCreditOrgIdMissing() throws Exception {
		TipCreditDTO tipCreditDataList = tipCreditData.tipCreditDataListDTO();
		tipCreditDataList.setOrgId(null);
		HttpEntity<TipCreditDTO> entity = new HttpEntity<TipCreditDTO>(tipCreditDataList, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(listTipCredits),
				HttpMethod.POST, entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("201");
	}

	/*
	 * Location-Id IS MISSING
	 */

	@Test
	public void testListTipCreditLocationIdMissing() throws Exception {
		TipCreditDTO tipCreditDataList = tipCreditData.tipCreditDataListDTO();
		Location[] locations = new Location[1];
		Location location = new Location();
		location.setLocationId(null);
		location.setLocationName("loc1");
		locations[0] = location;
		tipCreditDataList.setLocations(locations);
		HttpEntity<TipCreditDTO> entity = new HttpEntity<TipCreditDTO>(tipCreditDataList, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(listTipCredits),
				HttpMethod.POST, entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("201");
	}

	/*
	 * Location ADD IF IT DOES NOT EXIST
	 */

	@Test
	public void testListTipCreditLocationIdNotExisting() throws Exception {
		TipCreditDTO tipCreditDataList = tipCreditData.tipCreditDataListDTO();
		Location[] locations = new Location[1];
		Location location = new Location();
		location.setLocationId("l11");
		location.setLocationName("Hawaii");
		locations[0] = location;
		tipCreditDataList.setLocations(locations);
		HttpEntity<TipCreditDTO> entity = new HttpEntity<TipCreditDTO>(tipCreditDataList, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(listTipCredits),
				HttpMethod.POST, entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("200");
	}

	public String formFullURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

}

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
import com.salido.labor.data.MinWageData;
import com.salido.labor.dto.Location;
import com.salido.labor.dto.MinWageDTO;

import net.sf.json.JSONObject;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SalidoLaborApplication.class)
@AutoConfigureMockMvc
public class MinWageIntegration {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate testRestTemplate;

	private HttpHeaders headers = new HttpHeaders();

	@Autowired
	MockMvc mockMvc;

	String baseUri = "/v1/labor";

	String addMinWage = baseUri + "/addMinWage";

	String listMinWage = baseUri + "/listMinWage";

	MinWageData minWageData = new MinWageData();

	CommonData commonData = new CommonData();

	/*
	 * ADD MIN WAGE (PASS CASE)
	 */

	@Test
	public void testAddMinWagePass() throws Exception {
		headers.add("token", "14785236658542");
		HttpEntity<MinWageDTO> entity = new HttpEntity<MinWageDTO>(minWageData.minWageDataDTO(), headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(addMinWage), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("200");
	}

	@Test
	public void testAddMinWagePassForLocationOne() throws Exception {
		headers.add("token", "14785236658542");
		HttpEntity<MinWageDTO> entity = new HttpEntity<MinWageDTO>(minWageData.minWageDataDTO("l1"), headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(addMinWage), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("200");
	}

	@Test
	public void testAddMinWagePassForLocationTwo() throws Exception {
		headers.add("token", "14785236658542");
		HttpEntity<MinWageDTO> entity = new HttpEntity<MinWageDTO>(minWageData.minWageDataDTO("l2"), headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(addMinWage), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("200");
	}

	@Test
	public void testAddMinWagePassForLocationThree() throws Exception {
		headers.add("token", "14785236658542");
		HttpEntity<MinWageDTO> entity = new HttpEntity<MinWageDTO>(minWageData.minWageDataDTO("l3"), headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(addMinWage), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("200");
	}

	@Test
	public void testAddMinWagePassSecond() throws Exception {
		headers.add("token", "14785236658542");
		HttpEntity<MinWageDTO> entity = new HttpEntity<MinWageDTO>(minWageData.minWageDataDTOSecond(), headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(addMinWage), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("200");
	}

	/*
	 * Location-Id IS MISSING
	 */

	@Test
	public void testAddMinWageLocationMissing() throws Exception {
		headers.add("token", "14785236658542");
		MinWageDTO minWageAddData = minWageData.minWageDataDTO();
		minWageAddData.setLocationId(null);
		HttpEntity<MinWageDTO> entity = new HttpEntity<MinWageDTO>(minWageAddData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(addMinWage), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("201");
	}

	/*
	 * Location-Id IS NOT EXISTING
	 */

	@Test
	public void testAddMinWageLocationIdNotExist() throws Exception {
		headers.add("token", "14785236658542");
		MinWageDTO minWageAddData = minWageData.minWageDataDTO();
		minWageAddData.setLocationId("L4");
		HttpEntity<MinWageDTO> entity = new HttpEntity<MinWageDTO>(minWageAddData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(addMinWage), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("201");
	}

	/*
	 * Start-Date IS INVALID
	 */

	@Test
	public void testAddMinWageInvalidStartDate() throws Exception {
		headers.add("token", "14785236658542");
		MinWageDTO minWageAddData = minWageData.minWageDataDTO();
		minWageAddData.setStartDate(null);
		HttpEntity<MinWageDTO> entity = new HttpEntity<MinWageDTO>(minWageAddData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(addMinWage), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("201");
	}
	/*
	 * Status is expired
	 */

	@Test
	public void testAddMinWageExpiredStatus() throws Exception {
		headers.add("token", "14785236658542");
		MinWageDTO minWageAddData = minWageData.minWageDataDTO();
		minWageAddData.setStartDate("2017-11-11");
		minWageAddData.setEndDate("2017-12-11");
		HttpEntity<MinWageDTO> entity = new HttpEntity<MinWageDTO>(minWageAddData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(addMinWage), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("200");
	}
	/*
	 * Status is active
	 */

	@Test
	public void testAddMinWageActiveStatus() throws Exception {
		headers.add("token", "14785236658542");
		MinWageDTO minWageAddData = minWageData.minWageDataDTO();
		minWageAddData.setStartDate("2017-11-11");
		minWageAddData.setEndDate("2020-12-11");
		HttpEntity<MinWageDTO> entity = new HttpEntity<MinWageDTO>(minWageAddData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(addMinWage), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("200");
	}
	/*
	 * ADD MIN WAGE
	 */

	@Test
	public void testAddMinWage() throws Exception {
		headers.add("token", "14785236658542");
		MinWageDTO minWageAddData = minWageData.minWageDataDTO();
		minWageAddData.setId(null);
		minWageAddData.setEndDate("2021-11-11");
		HttpEntity<MinWageDTO> entity = new HttpEntity<MinWageDTO>(minWageAddData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(addMinWage), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("200");
	}

	/*
	 * EndDate not null
	 */

	@Test
	public void testAddMinWageEndDateNotNull() throws Exception {
		headers.add("token", "14785236658542");
		MinWageDTO minWageAddData = minWageData.minWageDataDTO();
		minWageAddData.setEndDate("2021-12-15");
		HttpEntity<MinWageDTO> entity = new HttpEntity<MinWageDTO>(minWageAddData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(addMinWage), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("200");
	}

	/*
	 * Minimum-Wage IS MISSING
	 */

	@Test
	public void testAddMinWageMissingMinWage() throws Exception {
		headers.add("token", "14785236658542");
		MinWageDTO minWageAddData = minWageData.minWageDataDTO();
		minWageAddData.setMinWage(null);
		HttpEntity<MinWageDTO> entity = new HttpEntity<MinWageDTO>(minWageAddData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(addMinWage), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("201");
	}

	/*
	 * LIST MIN WAGE (PASS CASE)
	 */

	@Test
	public void testListMinWagePass() throws Exception {

		HttpEntity<MinWageDTO> entity = new HttpEntity<MinWageDTO>(minWageData.minWageDataListDTO(), headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(listMinWage), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("200");
	}

	/*
	 * Brand-Id IS MISSING
	 */

	@Test
	public void testListMinWageBrandIdMissing() throws Exception {

		MinWageDTO MinWageDataList = minWageData.minWageDataListDTO();
		MinWageDataList.setBrandId(null);
		HttpEntity<MinWageDTO> entity = new HttpEntity<MinWageDTO>(MinWageDataList, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(listMinWage), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("201");
	}

	/*
	 * Organization-Id IS MISSING
	 */

	@Test
	public void testListMinWageOrgIdMissing() throws Exception {

		MinWageDTO MinWageDataList = minWageData.minWageDataListDTO();
		MinWageDataList.setOrgId(null);
		HttpEntity<MinWageDTO> entity = new HttpEntity<MinWageDTO>(MinWageDataList, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(listMinWage), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("201");
	}

	/*
	 * Location-Id IS MISSING
	 */

	@Test
	public void testListMinWageLocationIdMissing() throws Exception {

		MinWageDTO MinWageDataList = minWageData.minWageDataListDTO();
		Location[] locations = new Location[1];
		Location location = new Location();
		location.setLocationId(null);
		location.setLocationName("loc1");
		locations[0] = location;
		MinWageDataList.setLocations(locations);
		HttpEntity<MinWageDTO> entity = new HttpEntity<MinWageDTO>(MinWageDataList, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(listMinWage), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("201");
	}

	/*
	 * Location ADD IF IT DOES NOT EXIST
	 */

	@Test
	public void testListMinWageLocationNotExisting() throws Exception {

		MinWageDTO MinWageDataList = minWageData.minWageDataListDTO();
		Location[] locations = new Location[1];
		Location location = new Location();
		location.setLocationId("l3");
		location.setLocationName("loc1");
		locations[0] = location;
		MinWageDataList.setLocations(locations);
		HttpEntity<MinWageDTO> entity = new HttpEntity<MinWageDTO>(MinWageDataList, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(listMinWage), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = commonData.stringToJson(response.getBody());
		String responseInJson = obj.get("status").toString();
		assertThat(responseInJson).isEqualTo("200");
	}

	private String formFullURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
}

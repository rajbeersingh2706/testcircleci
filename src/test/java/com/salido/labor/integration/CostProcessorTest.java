package com.salido.labor.integration;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.DateFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
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

import com.salido.labor.SalidoLaborApplication;
import com.salido.labor.data.CaliforniaRuleTestData;
import com.salido.labor.data.FederalRuleTestData;
import com.salido.labor.data.SOHRuleTestData;
import com.salido.labor.data.TipCreditRuleTestData;
import com.salido.labor.data.WeeklyFourtyRuleTestData;
import com.salido.labor.dto.LaborCostRequestDTO;

import net.sf.json.JSONObject;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SalidoLaborApplication.class)
@AutoConfigureMockMvc
public class CostProcessorTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate testRestTemplate;

	private HttpHeaders headers = new HttpHeaders();

	// @Autowired
	// MockMvc mockMvc;

	String baseUri = "/v1/labor";

	String calculateTimecardCost = baseUri + "/calculateTimecardCost";

	@Mock
	DateFormat formatter;

	// START FEDERAL RULE

	@Test
	public void testFederalRuleNotVerified() throws Exception {
		LaborCostRequestDTO ruleData = FederalRuleTestData.getRuleDataNotVerified();
		HttpEntity<LaborCostRequestDTO> entity = new HttpEntity<LaborCostRequestDTO>(ruleData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(getURI(calculateTimecardCost), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = JSONObject.fromObject(response.getBody());

		JSONObject expectedData = new JSONObject();
		expectedData.put("reg_amount", "10.0");
		expectedData.put("reg_end_time", "2019-03-16 12:30:00");
		expectedData.put("reg_pay_rate", "10.0");
		expectedData.put("reg_start_time", "2019-03-16 11:30:00");
		expectedData.put("reg_work_hour", "3600");
		expectedData.put("tipcredit_amount", "15.0");
		expectedData.put("tipcredit_pay_rate", "15.0");

		assertThat(obj.get("data")).isEqualTo(expectedData);
	}

	@Test
	public void testFederalVerified() throws Exception {
		LaborCostRequestDTO ruleData = FederalRuleTestData.getRuleDataVerified();
		HttpEntity<LaborCostRequestDTO> entity = new HttpEntity<LaborCostRequestDTO>(ruleData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(getURI(calculateTimecardCost), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = JSONObject.fromObject(response.getBody());

		JSONObject expectedData = new JSONObject();
		expectedData.put("reg_amount", "30.0");
		expectedData.put("reg_end_time", "2019-03-16 17:30:00");
		expectedData.put("reg_pay_rate", "10.0");
		expectedData.put("reg_start_time", "2019-03-16 14:30:00");
		expectedData.put("reg_work_hour", "10800");
		expectedData.put("tipcredit_amount", "60.0");
		expectedData.put("tipcredit_pay_rate", "15.0");
		expectedData.put("wot_amount", "15.0");
		expectedData.put("wot_end_time", "2019-03-16 18:30:00");
		expectedData.put("wot_pay_rate", "15.0");
		expectedData.put("wot_start_time", "2019-03-16 17:30:00");
		expectedData.put("wot_work_hour", "3600");
		expectedData.put("has_ot",true);
		assertThat(obj.get("data")).isEqualTo(expectedData);
	}

	@Test
	public void testFederalRuleVerifiedWithSOH() throws Exception {
		LaborCostRequestDTO ruleData = FederalRuleTestData.getRuleDataVerifiedWithSOH();
		HttpEntity<LaborCostRequestDTO> entity = new HttpEntity<LaborCostRequestDTO>(ruleData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(getURI(calculateTimecardCost), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = JSONObject.fromObject(response.getBody());

		JSONObject expectedData = new JSONObject();
		// expectedData.put("soh_amount", "10.0");
		expectedData.put("soh_amount", "10.0");
		expectedData.put("tipcredit_amount", "15.0");
		expectedData.put("tipcredit_pay_rate", "15.0");
		expectedData.put("wot_amount", "15.0");
		expectedData.put("wot_end_time", "2019-03-16 19:30:00");
		expectedData.put("wot_pay_rate", "15.0");
		expectedData.put("wot_start_time", "2019-03-16 18:30:00");
		expectedData.put("wot_work_hour", "3600");
		expectedData.put("has_ot",true);
		expectedData.put("has_soh",true);
		
		assertThat(obj.get("data")).isEqualTo(expectedData);
	}

	@Test
	public void testFederalRuleWithRegAndSOH() throws Exception {
		LaborCostRequestDTO ruleData = FederalRuleTestData.getRuleDataWithRegAndSOH();
		HttpEntity<LaborCostRequestDTO> entity = new HttpEntity<LaborCostRequestDTO>(ruleData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(getURI(calculateTimecardCost), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = JSONObject.fromObject(response.getBody());

		JSONObject expectedData = new JSONObject();
		expectedData.put("reg_amount", "5.0");
		expectedData.put("reg_end_time", "2019-03-16 18:00:00");
		expectedData.put("reg_pay_rate", "10.0");
		expectedData.put("reg_start_time", "2019-03-16 17:30:00");
		expectedData.put("reg_work_hour", "1800");
		expectedData.put("soh_amount", "10.0");
		expectedData.put("tipcredit_amount", "30.0");
		expectedData.put("tipcredit_pay_rate", "15.0");
		expectedData.put("wot_amount", "22.5");
		expectedData.put("wot_end_time", "2019-03-16 19:30:00");
		expectedData.put("wot_pay_rate", "15.0");
		expectedData.put("wot_start_time", "2019-03-16 18:00:00");
		expectedData.put("wot_work_hour", "5400");
		expectedData.put("has_ot",true);
        expectedData.put("has_soh",true);
        
		assertThat(obj.get("data")).isEqualTo(expectedData);
	}

	@Test
	public void testFederalVerifiedFullDay() throws Exception {
		LaborCostRequestDTO ruleData = FederalRuleTestData.getRuleDataFederalVerifiedFullDay();
		HttpEntity<LaborCostRequestDTO> entity = new HttpEntity<LaborCostRequestDTO>(ruleData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(getURI(calculateTimecardCost), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = JSONObject.fromObject(response.getBody());

		JSONObject expectedData = new JSONObject();
		expectedData.put("reg_amount", "30.0");
		expectedData.put("reg_end_time", "2019-03-16 17:30:00");
		expectedData.put("reg_pay_rate", "10.0");
		expectedData.put("reg_start_time", "2019-03-16 14:30:00");
		expectedData.put("reg_work_hour", "10800");
		expectedData.put("soh_amount", "10.0");
		expectedData.put("tipcredit_amount", "142.5");
		expectedData.put("tipcredit_pay_rate", "15.0");
		expectedData.put("wot_amount", "97.5");
		expectedData.put("wot_end_time", "2019-03-17 00:00:00");
		expectedData.put("wot_pay_rate", "15.0");
		expectedData.put("wot_start_time", "2019-03-16 17:30:00");
		expectedData.put("wot_work_hour", "23400");
		expectedData.put("has_ot",true);
        expectedData.put("has_soh",true);
        
		assertThat(obj.get("data")).isEqualTo(expectedData);
	}

	// END FEDERAL RULE

	// START CALIFORNIA RULE

	@Test
	public void testCaliforniaSevenConHrsGreaterThanEight() throws Exception {
		LaborCostRequestDTO ruleData = CaliforniaRuleTestData.getRuleDataCaliforniaSevenConHrsGreaterThanEight();
		HttpEntity<LaborCostRequestDTO> entity = new HttpEntity<LaborCostRequestDTO>(ruleData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(getURI(calculateTimecardCost), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = JSONObject.fromObject(response.getBody());

		JSONObject expectedData = new JSONObject();
		expectedData.put("reg_pay_rate","10.0");
		expectedData.put("ot_pay_rate","15.0");
		expectedData.put("ot_end_time","2019-03-16 17:30:00");
		expectedData.put("reg_amount","60.0");
		expectedData.put("tipcredit_amount","97.5");
		expectedData.put("reg_work_hour","21600");
		expectedData.put("ot_amount","7.5");
		expectedData.put("ot_start_time","2019-03-16 17:00:00");
		expectedData.put("ot_work_hour","1800");
		expectedData.put("reg_end_time","2019-03-16 17:00:00");
		expectedData.put("reg_start_time","2019-03-16 11:00:00");
		expectedData.put("tipcredit_pay_rate","15.0");
		expectedData.put("has_ot",true);

		assertThat(obj.get("data")).isEqualTo(expectedData);
	}

	@Test
	public void testCaliforniaSevenConHrsGreaterThanEight_1() throws Exception {
		LaborCostRequestDTO ruleData = CaliforniaRuleTestData.getRuleDataCaliforniaSevenConHrsGreaterThanEightSecond();
		HttpEntity<LaborCostRequestDTO> entity = new HttpEntity<LaborCostRequestDTO>(ruleData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(getURI(calculateTimecardCost), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = JSONObject.fromObject(response.getBody());

		JSONObject expectedData = new JSONObject();
		expectedData.put("ot_pay_rate","15.0");
		expectedData.put("ot_end_time","2019-03-16 17:30:00");
		expectedData.put("tipcredit_amount","0.0");
		expectedData.put("ot_amount","0.0");
		expectedData.put("ot_start_time","2019-03-16 17:30:00");
		expectedData.put("ot_work_hour","0");
		expectedData.put("tipcredit_pay_rate","15.0");
		
		assertThat(obj.get("data")).isEqualTo(expectedData);
	}

	@Test
	public void testCaliforniaSevenConNormal() throws Exception {
		LaborCostRequestDTO ruleData = CaliforniaRuleTestData.getRuleDataCaliforniaSevenConNormal();
		HttpEntity<LaborCostRequestDTO> entity = new HttpEntity<LaborCostRequestDTO>(ruleData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(getURI(calculateTimecardCost), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = JSONObject.fromObject(response.getBody());

		JSONObject expectedData = new JSONObject();
		expectedData.put("reg_pay_rate","10.0");
		expectedData.put("reg_amount","45.0");
		expectedData.put("tipcredit_amount","67.5");
		expectedData.put("reg_work_hour","16200");
		expectedData.put("reg_end_time","2019-03-16 15:30:00");
		expectedData.put("reg_start_time","2019-03-16 11:00:00");
		expectedData.put("tipcredit_pay_rate","15.0");

		assertThat(obj.get("data")).isEqualTo(expectedData);
	}

	@Test
	public void testCaliforniaDailyOTDayGreaterThanTwelve() throws Exception {
		LaborCostRequestDTO ruleData = CaliforniaRuleTestData.getRuleDataCaliforniaDailyOTHrsGreaterThanTwelve();
		HttpEntity<LaborCostRequestDTO> entity = new HttpEntity<LaborCostRequestDTO>(ruleData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(getURI(calculateTimecardCost), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = JSONObject.fromObject(response.getBody());

		JSONObject expectedData = new JSONObject();
		expectedData.put("dot_amount","10.0");
		expectedData.put("ot_end_time","2019-03-15 22:00:00");
		expectedData.put("soh_amount","10.0");
		expectedData.put("dot_pay_rate","20.0");
		expectedData.put("dot_start_time","2019-03-15 22:00:00");
		expectedData.put("ot_amount","37.5");
		expectedData.put("ot_start_time","2019-03-15 19:30:00");
		expectedData.put("tipcredit_pay_rate","15.0");
		expectedData.put("ot_pay_rate","15.0");
		expectedData.put("dot_end_time","2019-03-15 22:30:00");
		expectedData.put("tipcredit_amount","45.0");
		expectedData.put("ot_work_hour","9000");
		expectedData.put("dot_work_hour","1800");
		expectedData.put("has_ot",true);
        expectedData.put("has_soh",true);
        
		assertThat(obj.get("data")).isEqualTo(expectedData);
	}

	@Test
	public void testCaliforniaDailyOTSecond() throws Exception {
		LaborCostRequestDTO ruleData = CaliforniaRuleTestData
				.getRuleDataCaliforniaDailyOTHrsGreaterThanTwelveWithRegAndPartialTC();
		HttpEntity<LaborCostRequestDTO> entity = new HttpEntity<LaborCostRequestDTO>(ruleData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(getURI(calculateTimecardCost), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = JSONObject.fromObject(response.getBody());

		JSONObject expectedData = new JSONObject();
		expectedData.put("dot_amount","20.0");
		expectedData.put("ot_end_time","2019-03-15 21:30:00");
		expectedData.put("soh_amount","10.0");
		expectedData.put("dot_pay_rate","20.0");
		expectedData.put("dot_start_time","2019-03-15 21:30:00");
		expectedData.put("reg_work_hour","3600");
		expectedData.put("ot_amount","60.0");
		expectedData.put("ot_start_time","2019-03-15 17:30:00");
		expectedData.put("tipcredit_pay_rate","15.0");
		expectedData.put("reg_pay_rate","10.0");
		expectedData.put("ot_pay_rate","15.0");
		expectedData.put("dot_end_time","2019-03-15 22:30:00");
		expectedData.put("reg_amount","10.0");
		expectedData.put("tipcredit_amount","90.0");
		expectedData.put("ot_work_hour","14400");
		expectedData.put("dot_work_hour","3600");
		expectedData.put("reg_end_time","2019-03-15 17:30:00");
		expectedData.put("reg_start_time","2019-03-15 16:30:00");
		expectedData.put("has_ot",true);
        expectedData.put("has_soh",true);

		assertThat(obj.get("data")).isEqualTo(expectedData);
	}

	@Test
	public void testCaliforniaDailyOTFourth() throws Exception {
		LaborCostRequestDTO ruleData = CaliforniaRuleTestData
				.getRuleDataCaliforniaDailyOTHrsGreaterThanEightWithRegAndFullTC();
		HttpEntity<LaborCostRequestDTO> entity = new HttpEntity<LaborCostRequestDTO>(ruleData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(getURI(calculateTimecardCost), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = JSONObject.fromObject(response.getBody());

		JSONObject expectedData = new JSONObject();
		expectedData.put("ot_pay_rate","15.0");
		expectedData.put("ot_end_time","2019-03-15 21:30:00");
		expectedData.put("soh_amount","10.0");
		expectedData.put("tipcredit_amount","15.0");
		expectedData.put("ot_amount","15.0");
		expectedData.put("ot_start_time","2019-03-15 20:30:00");
		expectedData.put("ot_work_hour","3600");
		expectedData.put("tipcredit_pay_rate","15.0");
		expectedData.put("has_ot",true);
        expectedData.put("has_soh",true);
        
		assertThat(obj.get("data")).isEqualTo(expectedData);
	}

	@Test
	public void testCaliforniaDailyOTFifth() throws Exception {
		LaborCostRequestDTO ruleData = CaliforniaRuleTestData
				.getRuleDataCaliforniaDailyOTHrsGreaterThanEightAndPartialTCAndReg();
		HttpEntity<LaborCostRequestDTO> entity = new HttpEntity<LaborCostRequestDTO>(ruleData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(getURI(calculateTimecardCost), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = JSONObject.fromObject(response.getBody());

		JSONObject expectedData = new JSONObject();
		expectedData.put("ot_end_time","2019-03-15 21:00:00");
		expectedData.put("soh_amount","10.0");
		expectedData.put("reg_work_hour","3600");
		expectedData.put("ot_amount","37.5");
		expectedData.put("ot_start_time","2019-03-15 18:30:00");
		expectedData.put("tipcredit_pay_rate","15.0");
		expectedData.put("reg_pay_rate","10.0");
		expectedData.put("ot_pay_rate","15.0");
		expectedData.put("reg_amount","10.0");
		expectedData.put("tipcredit_amount","52.5");
		expectedData.put("ot_work_hour","9000");
		expectedData.put("reg_end_time","2019-03-15 18:30:00");
		expectedData.put("reg_start_time","2019-03-15 17:30:00");
		expectedData.put("has_ot",true);
        expectedData.put("has_soh",true);
        
		assertThat(obj.get("data")).isEqualTo(expectedData);
	}

	@Test
	public void testCaliforniaWeeklyOTNotVerified() throws Exception {
		LaborCostRequestDTO ruleData = CaliforniaRuleTestData.getRuleDataCaliforniaWeeklyOTNotVerified();
		HttpEntity<LaborCostRequestDTO> entity = new HttpEntity<LaborCostRequestDTO>(ruleData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(getURI(calculateTimecardCost), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = JSONObject.fromObject(response.getBody());

		JSONObject expectedData = new JSONObject();
		expectedData.put("reg_pay_rate", "10.0");
		expectedData.put("reg_amount", "7.5");
		expectedData.put("tipcredit_amount", "11.25");
		expectedData.put("reg_start_time", "2019-03-15 16:15:00");
		expectedData.put("reg_end_time", "2019-03-15 17:00:00");
		expectedData.put("tipcredit_pay_rate", "15.0");
		expectedData.put("reg_work_hour", "2700");

		assertThat(obj.get("data")).isEqualTo(expectedData);
	}

	@Test
	public void testCaliforniaWeeklyOTVerified() throws Exception {
		LaborCostRequestDTO ruleData = CaliforniaRuleTestData.getRuleDataCaliforniaWeeklyOTVerified();
		HttpEntity<LaborCostRequestDTO> entity = new HttpEntity<LaborCostRequestDTO>(ruleData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(getURI(calculateTimecardCost), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = JSONObject.fromObject(response.getBody());

		JSONObject expectedData = new JSONObject();
		expectedData.put("wot_work_hour","1800");
		expectedData.put("tipcredit_amount","7.5");
		expectedData.put("wot_end_time","2019-03-15 16:30:00");
		expectedData.put("wot_amount","7.5");
		expectedData.put("wot_start_time","2019-03-15 16:00:00");
		expectedData.put("tipcredit_pay_rate","15.0");
		expectedData.put("wot_pay_rate","15.0");
		expectedData.put("has_ot",true);
        
		assertThat(obj.get("data")).isEqualTo(expectedData);
	}

	@Test
	public void testCaliforniaWeeklyOTVerifiedWithReg() throws Exception {
		LaborCostRequestDTO ruleData = CaliforniaRuleTestData.getRuleDataCaliforniaWeeklyOTVerifiedWithReg();
		HttpEntity<LaborCostRequestDTO> entity = new HttpEntity<LaborCostRequestDTO>(ruleData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(getURI(calculateTimecardCost), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = JSONObject.fromObject(response.getBody());

		JSONObject expectedData = new JSONObject();
		expectedData.put("reg_pay_rate","10.0");
		expectedData.put("reg_amount","10.0");
		expectedData.put("wot_work_hour","5400");
		expectedData.put("tipcredit_amount","37.5");
		expectedData.put("wot_end_time","2019-03-15 16:30:00");
		expectedData.put("wot_amount","22.5");
		expectedData.put("reg_work_hour","3600");
		expectedData.put("wot_start_time","2019-03-15 15:00:00");
		expectedData.put("reg_end_time","2019-03-15 15:00:00");
		expectedData.put("reg_start_time","2019-03-15 14:00:00");
		expectedData.put("tipcredit_pay_rate","15.0");
		expectedData.put("wot_pay_rate","15.0");
		expectedData.put("has_ot",true);

		assertThat(obj.get("data")).isEqualTo(expectedData);
	}

	@Test
	public void testCaliforniaWeeklyOTVerifiedPartialTC() throws Exception {
		LaborCostRequestDTO ruleData = CaliforniaRuleTestData.getRuleDataCaliforniaWeeklyOTVerifiedPartialTC();
		HttpEntity<LaborCostRequestDTO> entity = new HttpEntity<LaborCostRequestDTO>(ruleData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(getURI(calculateTimecardCost), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = JSONObject.fromObject(response.getBody());

		JSONObject expectedData = new JSONObject();
		expectedData.put("wot_work_hour","2700");
		expectedData.put("tipcredit_amount","11.25");
		expectedData.put("wot_end_time","2019-03-15 16:30:00");
		expectedData.put("wot_amount","11.25");
		expectedData.put("wot_start_time","2019-03-15 15:45:00");
		expectedData.put("tipcredit_pay_rate","15.0");
		expectedData.put("wot_pay_rate","15.0");
		expectedData.put("has_ot",true);

		assertThat(obj.get("data")).isEqualTo(expectedData);
	}

	@Test
	public void testDataCaliforniaWeeklyOTVerifiedAfter8AndSOH() throws Exception {
		LaborCostRequestDTO ruleData = CaliforniaRuleTestData.getRuleDataCaliforniaWeeklyOTVerifiedAfter8AndSOH();
		HttpEntity<LaborCostRequestDTO> entity = new HttpEntity<LaborCostRequestDTO>(ruleData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(getURI(calculateTimecardCost), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = JSONObject.fromObject(response.getBody());

		JSONObject expectedData = new JSONObject();
		expectedData.put("ot_end_time","2019-03-15 19:30:00");
		expectedData.put("wot_work_hour","5400");
		expectedData.put("soh_amount","10.0");
		expectedData.put("reg_work_hour","9900");
		expectedData.put("ot_amount","30.0");
		expectedData.put("ot_start_time","2019-03-15 17:30:00");
		expectedData.put("wot_start_time","2019-03-15 16:00:00");
		expectedData.put("tipcredit_pay_rate","15.0");
		expectedData.put("wot_pay_rate","15.0");
		expectedData.put("reg_pay_rate","10.0");
		expectedData.put("ot_pay_rate","15.0");
		expectedData.put("reg_amount","27.5");
		expectedData.put("tipcredit_amount","93.75");
		expectedData.put("wot_end_time","2019-03-15 17:30:00");
		expectedData.put("wot_amount","22.5");
		expectedData.put("ot_work_hour","7200");
		expectedData.put("reg_end_time","2019-03-15 16:00:00");
		expectedData.put("reg_start_time","2019-03-15 13:15:00");
		expectedData.put("has_ot",true);
        expectedData.put("has_soh",true);
        
		assertThat(obj.get("data")).isEqualTo(expectedData);
	}

	@Test
	public void testDataCaliforniaForFullDay() throws Exception {
		LaborCostRequestDTO ruleData = CaliforniaRuleTestData.getRuleDataCaliforniaForFullDay();
		HttpEntity<LaborCostRequestDTO> entity = new HttpEntity<LaborCostRequestDTO>(ruleData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(getURI(calculateTimecardCost), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = JSONObject.fromObject(response.getBody());

		JSONObject expectedData = new JSONObject();
		expectedData.put("dot_amount","50.0");
		expectedData.put("ot_end_time","2019-03-15 21:30:00");
		expectedData.put("wot_work_hour","5400");
		expectedData.put("soh_amount","10.0");
		expectedData.put("dot_pay_rate","20.0");
		expectedData.put("dot_start_time","2019-03-15 21:30:00");
		expectedData.put("reg_work_hour","9900");
		expectedData.put("ot_amount","60.0");
		expectedData.put("ot_start_time","2019-03-15 17:30:00");
		expectedData.put("wot_start_time","2019-03-15 16:00:00");
		expectedData.put("tipcredit_pay_rate","15.0");
		expectedData.put("wot_pay_rate","15.0");
		expectedData.put("reg_pay_rate","10.0");
		expectedData.put("ot_pay_rate","15.0");
		expectedData.put("dot_end_time","2019-03-16 00:00:00");
		expectedData.put("reg_amount","27.5");
		expectedData.put("tipcredit_amount","161.25");
		expectedData.put("wot_end_time","2019-03-15 17:30:00");
		expectedData.put("wot_amount","22.5");
		expectedData.put("ot_work_hour","14400");
		expectedData.put("dot_work_hour","9000");
		expectedData.put("reg_end_time","2019-03-15 16:00:00");
		expectedData.put("reg_start_time","2019-03-15 13:15:00");
		expectedData.put("has_ot",true);
        expectedData.put("has_soh",true);
        
		assertThat(obj.get("data")).isEqualTo(expectedData);
	}
	// END CALIFORNIA RULE

	// START WEEKLY FOURTY RULE

	@Test
	public void testWeeklyFourtyNotVerified() throws Exception {
		LaborCostRequestDTO ruleData = WeeklyFourtyRuleTestData.getRuleDataNotVerified();
		HttpEntity<LaborCostRequestDTO> entity = new HttpEntity<LaborCostRequestDTO>(ruleData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(getURI(calculateTimecardCost), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = JSONObject.fromObject(response.getBody());

		JSONObject expectedData = new JSONObject();
		expectedData.put("reg_pay_rate","10.0");
		expectedData.put("reg_amount","10.0");
		expectedData.put("tipcredit_amount","15.0");
		expectedData.put("reg_work_hour","3600");
		expectedData.put("reg_end_time","2019-03-16 17:00:00");
		expectedData.put("reg_start_time","2019-03-16 16:00:00");
		expectedData.put("tipcredit_pay_rate","15.0");

		assertThat(obj.get("data")).isEqualTo(expectedData);
	}

	@Test
	public void testWeeklyFourtyVerifiedForWeek() throws Exception {
		LaborCostRequestDTO ruleData = WeeklyFourtyRuleTestData.getRuleDataVerifiedForWeek();
		HttpEntity<LaborCostRequestDTO> entity = new HttpEntity<LaborCostRequestDTO>(ruleData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(getURI(calculateTimecardCost), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = JSONObject.fromObject(response.getBody());

		JSONObject expectedData = new JSONObject();
		expectedData.put("reg_pay_rate","10.0");
        expectedData.put("reg_amount","10.0");
        expectedData.put("reg_end_time","2019-03-16 17:30:00");
        expectedData.put("reg_start_time","2019-03-16 16:30:00");
        expectedData.put("reg_work_hour","3600");
        expectedData.put("tipcredit_amount","37.5");
        expectedData.put("wot_end_time","2019-03-16 19:00:00");
        expectedData.put("wot_amount","7.5");
        expectedData.put("wot_work_hour","1800");
        expectedData.put("wot_start_time","2019-03-16 18:30:00");
        expectedData.put("wot_pay_rate","15.0");
        expectedData.put("tipcredit_pay_rate","15.0");
        expectedData.put("ot_end_time","2019-03-16 18:30:00");
        expectedData.put("ot_amount","15.0");
        expectedData.put("ot_work_hour","3600");
        expectedData.put("ot_start_time","2019-03-16 17:30:00");
        expectedData.put("ot_pay_rate","15.0");
		expectedData.put("has_ot",true);

		assertThat(obj.get("data")).isEqualTo(expectedData);
	}

	@Test
	public void testWeeklyFourtyVerifiedForDay() throws Exception {
		LaborCostRequestDTO ruleData = WeeklyFourtyRuleTestData.getRuleDataVerifiedForDay();
		HttpEntity<LaborCostRequestDTO> entity = new HttpEntity<LaborCostRequestDTO>(ruleData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(getURI(calculateTimecardCost), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = JSONObject.fromObject(response.getBody());

		JSONObject expectedData = new JSONObject();
		expectedData.put("reg_pay_rate","10.0");
		expectedData.put("ot_pay_rate","15.0");
		expectedData.put("ot_end_time","2019-03-16 19:00:00");
		expectedData.put("reg_amount","10.0");
		expectedData.put("tipcredit_amount","37.5");
		expectedData.put("reg_work_hour","3600");
		expectedData.put("ot_amount","22.5");
		expectedData.put("ot_start_time","2019-03-16 17:30:00");
		expectedData.put("ot_work_hour","5400");
		expectedData.put("reg_end_time","2019-03-16 17:30:00");
		expectedData.put("reg_start_time","2019-03-16 16:30:00");
		expectedData.put("tipcredit_pay_rate","15.0");
		expectedData.put("has_ot",true);

		assertThat(obj.get("data")).isEqualTo(expectedData);
	}

	@Test
	public void testWeeklyFourtyVerifiedForDayWithSOH() throws Exception {
		LaborCostRequestDTO ruleData = WeeklyFourtyRuleTestData.getRuleDataVerifiedForDayWithSOH();
		HttpEntity<LaborCostRequestDTO> entity = new HttpEntity<LaborCostRequestDTO>(ruleData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(getURI(calculateTimecardCost), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = JSONObject.fromObject(response.getBody());

		JSONObject expectedData = new JSONObject();
		expectedData.put("ot_end_time","2019-03-16 19:30:00");
		expectedData.put("soh_amount","10.0");
		expectedData.put("reg_work_hour","3600");
		expectedData.put("ot_amount","37.5");
		expectedData.put("ot_start_time","2019-03-16 17:00:00");
		expectedData.put("tipcredit_pay_rate","15.0");
		expectedData.put("reg_pay_rate","10.0");
		expectedData.put("ot_pay_rate","15.0");
		expectedData.put("reg_amount","10.0");
		expectedData.put("tipcredit_amount","52.5");
		expectedData.put("ot_work_hour","9000");
		expectedData.put("reg_end_time","2019-03-16 17:00:00");
		expectedData.put("reg_start_time","2019-03-16 16:00:00");
		expectedData.put("has_ot",true);
        expectedData.put("has_soh",true);

		assertThat(obj.get("data")).isEqualTo(expectedData);
	}

	@Test
	public void testWeeklyFourtyVerifiedForVerifiedForFullDay() throws Exception {
		LaborCostRequestDTO ruleData = WeeklyFourtyRuleTestData.getRuleDataVerifiedForFullDay();
		HttpEntity<LaborCostRequestDTO> entity = new HttpEntity<LaborCostRequestDTO>(ruleData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(getURI(calculateTimecardCost), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = JSONObject.fromObject(response.getBody());

		JSONObject expectedData = new JSONObject();
		expectedData.put("ot_end_time","2019-03-17 00:00:00");
		expectedData.put("soh_amount","10.0");
		expectedData.put("reg_work_hour","3600");
		expectedData.put("ot_amount","105.0");
		expectedData.put("ot_start_time","2019-03-16 17:00:00");
		expectedData.put("tipcredit_pay_rate","15.0");
		expectedData.put("reg_pay_rate","10.0");
		expectedData.put("ot_pay_rate","15.0");
		expectedData.put("reg_amount","10.0");
		expectedData.put("tipcredit_amount","120.0");
		expectedData.put("ot_work_hour","25200");
		expectedData.put("reg_end_time","2019-03-16 17:00:00");
		expectedData.put("reg_start_time","2019-03-16 16:00:00");
		expectedData.put("has_ot",true);
		expectedData.put("has_soh",true);
		assertThat(obj.get("data")).isEqualTo(expectedData);
	}
	// END WEEKLY FOURTY RULE

	// START SOH
	@Test
	public void testSOH() throws Exception {
		LaborCostRequestDTO ruleData = SOHRuleTestData.getRuleData();
		HttpEntity<LaborCostRequestDTO> entity = new HttpEntity<LaborCostRequestDTO>(ruleData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(getURI(calculateTimecardCost), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = JSONObject.fromObject(response.getBody());

		JSONObject expectedData = new JSONObject();
		expectedData.put("ot_pay_rate","15.0");
		expectedData.put("ot_end_time","2019-03-15 23:00:00");
		expectedData.put("soh_amount","10.0");
		expectedData.put("tipcredit_amount","75.0");
		expectedData.put("ot_amount","75.0");
		expectedData.put("ot_start_time","2019-03-15 18:00:00");
		expectedData.put("ot_work_hour","18000");
		expectedData.put("tipcredit_pay_rate","15.0");
		expectedData.put("has_ot",true);
        expectedData.put("has_soh",true);

		assertThat(obj.get("data")).isEqualTo(expectedData);
	}

	@Test
	public void testSOHFail() throws Exception {
		LaborCostRequestDTO ruleData = SOHRuleTestData.getRuleDataNoMinwage();
		HttpEntity<LaborCostRequestDTO> entity = new HttpEntity<LaborCostRequestDTO>(ruleData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(getURI(calculateTimecardCost), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = JSONObject.fromObject(response.getBody());

		JSONObject expectedData = new JSONObject();
		expectedData.put("reg_pay_rate","10.0");
		expectedData.put("reg_amount","50.0");
		expectedData.put("reg_work_hour","18000");
		expectedData.put("reg_end_time","2019-03-15 23:00:00");
		expectedData.put("reg_start_time","2019-03-15 18:00:00");
        expectedData.put("has_soh",true);
        expectedData.put("tipcredit_pay_rate","100.0");
        expectedData.put("tipcredit_amount","500.0");
        expectedData.put("soh_amount","15.0");
		assertThat(obj.get("data")).isEqualTo(expectedData);
	}
	// END SOH

	// START TIP CREDIT RULE
	@Test
	public void testTipCreditNoTipCredit() throws Exception {
		LaborCostRequestDTO ruleData = TipCreditRuleTestData.testTipCreditNoTipCreditInfo();
		HttpEntity<LaborCostRequestDTO> entity = new HttpEntity<LaborCostRequestDTO>(ruleData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(getURI(calculateTimecardCost), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = JSONObject.fromObject(response.getBody());

		JSONObject expectedData = new JSONObject();
		expectedData.put("reg_pay_rate","10.0");
		expectedData.put("reg_amount","15.0");
		expectedData.put("reg_work_hour","5400");
		expectedData.put("reg_end_time","2019-03-15 22:00:00");
		expectedData.put("reg_start_time","2019-03-15 20:30:00");
		
		assertThat(obj.get("data")).isEqualTo(expectedData);
	}

	@Test
	public void testTipCredit() throws Exception {
		LaborCostRequestDTO ruleData = TipCreditRuleTestData.getRuleData();
		HttpEntity<LaborCostRequestDTO> entity = new HttpEntity<LaborCostRequestDTO>(ruleData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(getURI(calculateTimecardCost), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = JSONObject.fromObject(response.getBody());

		JSONObject expectedData = new JSONObject();
		expectedData.put("reg_pay_rate","10.0");
		expectedData.put("reg_amount","15.0");
		expectedData.put("reg_work_hour","5400");
		expectedData.put("reg_end_time","2019-03-15 22:00:00");
		expectedData.put("reg_start_time","2019-03-15 20:30:00");

		assertThat(obj.get("data")).isEqualTo(expectedData);
	}

	@Test
	public void testError() throws Exception {
		LaborCostRequestDTO ruleData = FederalRuleTestData.getErrorData();
		HttpEntity<LaborCostRequestDTO> entity = new HttpEntity<LaborCostRequestDTO>(ruleData, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(getURI(calculateTimecardCost), HttpMethod.POST,
				entity, String.class);
		JSONObject obj = JSONObject.fromObject(response.getBody());

		assertThat(obj.get("status")).isEqualTo("201");
	}

	// END TIP CREDIT RULE
	private String getURI(String uri) {
		return "http://localhost:" + port + uri;
	}

}

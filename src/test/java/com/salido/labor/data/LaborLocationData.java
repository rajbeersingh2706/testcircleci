package com.salido.labor.data;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.salido.labor.bean.LaborLocation;
import com.salido.labor.bean.LaborRule;
import com.salido.labor.bean.LaborRuleLocation;
import com.salido.labor.dto.LaborRuleLocationDTO;
import com.salido.labor.dto.Location;
import com.salido.labor.util.DateUtils;

import net.sf.json.JSONObject;

public class LaborLocationData {

	private CommonData commonData = new CommonData();
	DateUtils dateUtils = new DateUtils();

	public JSONObject applyRule() {
		JSONObject inputJson = new JSONObject();

		inputJson = commonData.commonDataAdd();
		inputJson.put("ruleId", "0c4cc6fe-4a2c-41ba-a651-e04f72f9204d");

		return inputJson;

	}

	public JSONObject listAppliedRule() {
		JSONObject inputJson = commonData.commonDataList();
		return inputJson;

	}

	public JSONObject listAllRules() {
		JSONObject inputJson = new JSONObject();
		inputJson.put("brandId", "b1");
		inputJson.put("orgId", "o1");
		inputJson.put("locationId", "l1");
		return inputJson;
	}

	public LaborRuleLocationDTO laborRuleLocationDataDTO(String ruleId, String locationId) {
		LaborRuleLocationDTO laborRuleLocationDTO = new LaborRuleLocationDTO();
		laborRuleLocationDTO.setRuleId(ruleId);
		laborRuleLocationDTO.setBrandId("b1");
		laborRuleLocationDTO.setCreatedBy("ea3758b5-8dd6-4499-84c8-8fd6381f3d83");
		laborRuleLocationDTO.setCreatedDate(new Date());
		laborRuleLocationDTO.setEndDate("");
		laborRuleLocationDTO.setLocationId(locationId);
		laborRuleLocationDTO.setOrgId("o1");
		laborRuleLocationDTO.setStartDate("2019-03-15");
		laborRuleLocationDTO.setStatus("1");
		laborRuleLocationDTO.setUpdatedBy("ea3758b5-8dd6-4499-84c8-8fd6381f3d83");
		laborRuleLocationDTO.setUpdatedDate(new Date());
		return laborRuleLocationDTO;

	}

	public LaborRuleLocationDTO laborRuleLocationDataForError() {
		LaborRuleLocationDTO laborRuleLocationDTO = new LaborRuleLocationDTO();
		laborRuleLocationDTO.setRuleId("RULE001");
		laborRuleLocationDTO.setBrandId("b1");
		laborRuleLocationDTO.setCreatedBy("ea3758b5-8dd6-4499-84c8-8fd6381f3d83");
		laborRuleLocationDTO.setCreatedDate(new Date());
		laborRuleLocationDTO.setEndDate("2021-12-12");
		laborRuleLocationDTO.setLocationId("l9");
		laborRuleLocationDTO.setOrgId("o1");
		laborRuleLocationDTO.setStartDate("2019-01-01");
		laborRuleLocationDTO.setStatus("1");
		laborRuleLocationDTO.setUpdatedBy("ea3758b5-8dd6-4499-84c8-8fd6381f3d83");
		laborRuleLocationDTO.setUpdatedDate(new Date());
		return laborRuleLocationDTO;

	}

	public LaborRuleLocationDTO listAllRuleDataDTO() {
		LaborRuleLocationDTO laborRuleLocationDTO = new LaborRuleLocationDTO();
		laborRuleLocationDTO.setBrandId("b1");
		laborRuleLocationDTO.setLocationId("l1");
		laborRuleLocationDTO.setOrgId("o1");
		return laborRuleLocationDTO;

	}

	public LaborRuleLocationDTO listAppliedRuleLocationDataDTO() {
		LaborRuleLocationDTO laborRuleLocationDTO = new LaborRuleLocationDTO();
		laborRuleLocationDTO.setBrandId("b1");
		laborRuleLocationDTO.setOrgId("o1");
		Location[] locations = new Location[1];
		Location location = new Location();
		location.setLocationId("l1");
		location.setLocationName("New jersey");
		locations[0] = location;
		laborRuleLocationDTO.setLocations(locations);
		return laborRuleLocationDTO;

	}

	public List<LaborRuleLocation> laborRuleLocationList() throws ParseException {
		LaborRuleLocationDTO laborLocationData = new LaborLocationData()
				.laborRuleLocationDataDTO("0c4cc6fe-4a2c-41ba-a651-e04f72f9204d", "l1");
		List<LaborRuleLocation> laborRuleLocationArr = new ArrayList<>();
		LaborRuleLocation laborRuleLocation = new LaborRuleLocation();
		LaborRule laborRule = new LaborRule();
		LaborLocation laborLocation = new LaborLocation();
		laborRule.setRuleId("0c4cc6fe-4a2c-41ba-a651-e04f72f9204d");
		laborLocation.setLocationId(laborLocationData.getLocationId());
		laborLocation.setLocationName(laborLocationData.getLocationName());
		laborRuleLocation.setLaborRule(laborRule);
		laborRuleLocation.setBrandId(laborLocationData.getBrandId());
		laborRuleLocation.setCreatedBy("1");
		laborRuleLocation.setCreatedDate(laborLocationData.getCreatedDate());
		laborRuleLocation.setEndDate(dateUtils.stringToDate("", DateUtils.DATE_FORMAT_COMMON));
		laborRuleLocation.setLaborLocation(laborLocation);
		laborRuleLocation.setOrgId(laborLocationData.getOrgId());
		laborRuleLocation.setStartDate(dateUtils.stringToDate("2019-11-02", DateUtils.DATE_FORMAT_COMMON));
		laborRuleLocation.setStatus("1");
		laborRuleLocation.setUpdatedBy("1");
		laborRuleLocation.setUpdatedDate(laborLocationData.getCreatedDate());
		return laborRuleLocationArr;

	}

	public List<LaborRuleLocation> laborRuleLocationListAll() throws ParseException {

		List<LaborRuleLocation> laborRuleLocationArr = new ArrayList<>();
		LaborRuleLocationDTO laborLocationData = new LaborLocationData()
				.laborRuleLocationDataDTO("0c4cc6fe-4a2c-41ba-a651-e04f72f9204d", "l1");
		LaborRuleLocation laborRuleLocation = new LaborRuleLocation();
		LaborRule laborRule = new LaborRule();
		LaborLocation laborLocation = new LaborLocation();
		laborRule.setRuleId("0c4cc6fe-4a2c-41ba-a651-e04f72f9204d");
		laborLocation.setLocationId(laborLocationData.getLocationId());
		laborLocation.setLocationName(laborLocationData.getLocationName());
		laborRuleLocation.setLaborRule(laborRule);
		laborRuleLocation.setBrandId(laborLocationData.getBrandId());
		laborRuleLocation.setCreatedBy("1");
		laborRuleLocation.setCreatedDate(laborLocationData.getCreatedDate());
		laborRuleLocation.setEndDate(dateUtils.stringToDate("", DateUtils.DATE_FORMAT_COMMON));
		laborRuleLocation.setLaborLocation(laborLocation);
		laborRuleLocation.setOrgId(laborLocationData.getOrgId());
		laborRuleLocation.setStartDate(dateUtils.stringToDate("2019-11-02", DateUtils.DATE_FORMAT_COMMON));
		laborRuleLocation.setStatus("1");
		laborRuleLocation.setUpdatedBy("1");
		laborRuleLocation.setUpdatedDate(laborLocationData.getCreatedDate());

		LaborRuleLocationDTO laborLocationData1 = new LaborLocationData()
				.laborRuleLocationDataDTO("0c4cc6fe-4a2c-41ba-a651-e04f72f9204d", "l1");
		LaborRuleLocation laborRuleLocation1 = new LaborRuleLocation();
		LaborRule laborRule1 = new LaborRule();
		LaborLocation laborLocation1 = new LaborLocation();
		laborRule1.setRuleId("0c4cc6fe-4a2c-41ba-a651-e04f72f9204d");
		laborRuleLocation1.setLaborRule(laborRule1);
		laborRuleLocation1.setBrandId(laborLocationData1.getBrandId());
		laborRuleLocation1.setCreatedBy("rr");
		laborRuleLocation1.setCreatedDate(laborLocationData1.getCreatedDate());
		laborRuleLocation1.setEndDate(dateUtils.stringToDate("", DateUtils.DATE_FORMAT_COMMON));
		laborRuleLocation1.setLaborLocation(laborLocation1);
		laborRuleLocation1.setOrgId(laborLocationData1.getOrgId());
		laborRuleLocation1.setStartDate(dateUtils.stringToDate("2019-11-02", DateUtils.DATE_FORMAT_COMMON));
		laborRuleLocation1.setStatus("1");
		laborRuleLocation1.setUpdatedBy("rr");
		laborRuleLocation1.setUpdatedDate(laborLocationData1.getCreatedDate());
		laborRuleLocationArr.add(laborRuleLocation1);
		laborRuleLocationArr.add(laborRuleLocation);
		return laborRuleLocationArr;

	}

}

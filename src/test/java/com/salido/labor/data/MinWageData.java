package com.salido.labor.data;

import java.text.ParseException;
import java.util.Date;

import com.salido.labor.bean.LaborLocation;
import com.salido.labor.bean.LocationMinWage;
import com.salido.labor.dto.Location;
import com.salido.labor.dto.MinWageDTO;
import com.salido.labor.util.DateUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class MinWageData {

	DateUtils dateUtils = new DateUtils();

	private CommonData commonData = new CommonData();

	public JSONObject addMinWage() {
		JSONObject inputJson = new JSONObject();
		inputJson = commonData.commonDataAdd();
		inputJson.put("minWage", 20);

		return inputJson;

	}

	public JSONObject listMinWage() {
		return commonData.commonDataList();
	}

	public MinWageDTO minWageDataDTO(String locationId) {
		MinWageDTO minWageDTO = new MinWageDTO();
		minWageDTO.setBrandId("b6");
		minWageDTO.setCreatedBy("ea3758b5-8dd6-4499-84c8-8fd6381f3d83");
		minWageDTO.setCreatedDate(new Date());
		minWageDTO.setEndDate("");
		minWageDTO.setLocationId(locationId);
		minWageDTO.setMinWage("10");
		minWageDTO.setOrgId("o1");
		minWageDTO.setStartDate("2019-01-01");
		minWageDTO.setStatus("1");
		minWageDTO.setUpdatedBy("ea3758b5-8dd6-4499-84c8-8fd6381f3d83");
		minWageDTO.setUpdatedDate(new Date());
		return minWageDTO;
	}

	public MinWageDTO minWageDataDTO() {
		MinWageDTO minWageDTO = new MinWageDTO();
		minWageDTO.setBrandId("b6");
		minWageDTO.setCreatedBy("ea3758b5-8dd6-4499-84c8-8fd6381f3d83");
		minWageDTO.setCreatedDate(new Date());
		minWageDTO.setEndDate("");
		minWageDTO.setLocationId("l9");
		minWageDTO.setMinWage("15");
		minWageDTO.setOrgId("o1");
		minWageDTO.setStartDate("2019-11-02");
		minWageDTO.setStatus("1");
		minWageDTO.setUpdatedBy("ea3758b5-8dd6-4499-84c8-8fd6381f3d83");
		minWageDTO.setUpdatedDate(new Date());
		return minWageDTO;
	}

	public MinWageDTO minWageDataDTOSecond() {
		MinWageDTO minWageDTO = new MinWageDTO();
		minWageDTO.setBrandId("b1");
		minWageDTO.setCreatedBy("ea3758b5-8dd6-4499-84c8-8fd6381f3d83");
		minWageDTO.setCreatedDate(new Date());
		minWageDTO.setEndDate("2019-11-02");
		minWageDTO.setLocationId("l9");
		minWageDTO.setMinWage("15");
		minWageDTO.setOrgId("o1");
		minWageDTO.setStartDate("2019-11-02");
		minWageDTO.setStatus("1");
		minWageDTO.setUpdatedBy("ea3758b5-8dd6-4499-84c8-8fd6381f3d83");
		minWageDTO.setUpdatedDate(new Date());
		return minWageDTO;
	}

	public LocationMinWage locationMinWageData() throws ParseException {

		MinWageDTO minWageData = new MinWageData().minWageDataDTO();
		LocationMinWage locationMinWage = new LocationMinWage();
		LaborLocation laborLocation = new LaborLocation();
		laborLocation.setLocationId("l6");
		locationMinWage.setBrandId(minWageData.getBrandId());
		locationMinWage.setCreatedBy(minWageData.getCreatedBy());
		locationMinWage.setCreatedDate(minWageData.getCreatedDate());
		locationMinWage.setUpdatedDate(minWageData.getCreatedDate());
		locationMinWage.setStartDate(dateUtils.stringToDate(minWageData.getStartDate(), DateUtils.DATE_FORMAT_COMMON));
		locationMinWage.setEndDate(dateUtils.stringToDate(minWageData.getEndDate(), DateUtils.DATE_FORMAT_COMMON));
		locationMinWage.setLaborLocation(laborLocation);
		locationMinWage.setMinWage(minWageData.getMinWage());
		locationMinWage.setOrgId(minWageData.getOrgId());
		locationMinWage.setStatus(minWageData.getStatus());
		locationMinWage.setUpdatedBy(minWageData.getUpdatedBy());
		return locationMinWage;

	}

	public JSONArray listMinWageData() {
		JSONArray pArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("location_id", "l9");
		jsonObject.put("location_name", "Arizona");
		JSONObject wageObj = new JSONObject();
		wageObj.put("brand_id", "b1");
		wageObj.put("org_id", "b1");
		wageObj.put("start_date", "2019-12-21");
		wageObj.put("end_date", "");
		wageObj.put("min_wage", "15");
		wageObj.put("status", "Scheduled");
		pArray.add(jsonObject);
		pArray.add(wageObj);

		return pArray;

	}

	public MinWageDTO minWageDataListDTO() {
		MinWageDTO minWageDTO = new MinWageDTO();
		minWageDTO.setBrandId("b1");
		Location[] locations = new Location[1];
		Location location = new Location();
		location.setLocationId("l6");
		location.setLocationName("Arizona");
		locations[0] = location;
		minWageDTO.setLocations(locations);
		minWageDTO.setOrgId("o1");
		return minWageDTO;
	}

}

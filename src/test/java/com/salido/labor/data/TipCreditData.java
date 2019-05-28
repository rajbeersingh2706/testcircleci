package com.salido.labor.data;

import java.text.ParseException;
import java.util.Date;

import com.salido.labor.bean.LaborLocation;
import com.salido.labor.bean.LocationTipCredits;
import com.salido.labor.dto.Location;
import com.salido.labor.dto.TipCreditDTO;
import com.salido.labor.util.DateUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class TipCreditData {

	DateUtils dateUtils = new DateUtils();

	private CommonData commonData = new CommonData();

	public JSONObject addtipCredit() {
		JSONObject inputJson = new JSONObject();
		inputJson = commonData.commonDataAdd();
		inputJson.put("tipCredit", 100);

		return inputJson;
	}

	public JSONObject listTipCredit() {
		JSONObject inputJson = commonData.commonDataList();
		return inputJson;
	}

	public TipCreditDTO tipCreditDataDTO() {
		TipCreditDTO tipCreditDTO = new TipCreditDTO();
		tipCreditDTO.setBrandId("b1");
		tipCreditDTO.setCreatedBy("ea3758b5-8dd6-4499-84c8-8fd6381f3d83");
		tipCreditDTO.setCreatedDate(new Date());
		tipCreditDTO.setEndDate("");
		tipCreditDTO.setLocationId("l9");
		tipCreditDTO.setTipCredit("100");
		tipCreditDTO.setOrgId("o1");
		tipCreditDTO.setStartDate("2019-01-01");
		tipCreditDTO.setStatus("1");
		tipCreditDTO.setUpdatedBy("ea3758b5-8dd6-4499-84c8-8fd6381f3d83");
		tipCreditDTO.setUpdatedDate(new Date());
		return tipCreditDTO;

	}

	public TipCreditDTO tipCreditDataDTO(String locationId) {
		TipCreditDTO tipCreditDTO = new TipCreditDTO();
		tipCreditDTO.setBrandId("b1");
		tipCreditDTO.setCreatedBy("ea3758b5-8dd6-4499-84c8-8fd6381f3d83");
		tipCreditDTO.setCreatedDate(new Date());
		tipCreditDTO.setEndDate("");
		tipCreditDTO.setLocationId(locationId);
		tipCreditDTO.setTipCredit("15");
		tipCreditDTO.setOrgId("o1");
		tipCreditDTO.setStartDate("2019-01-01");
		tipCreditDTO.setStatus("1");
		tipCreditDTO.setUpdatedBy("ea3758b5-8dd6-4499-84c8-8fd6381f3d83");
		tipCreditDTO.setUpdatedDate(new Date());
		return tipCreditDTO;

	}

	public TipCreditDTO tipCreditDataListDTO() {
		TipCreditDTO tipCreditDTO = new TipCreditDTO();
		tipCreditDTO.setBrandId("b1");
		Location[] locations = new Location[1];
		Location location = new Location();
		location.setLocationId("l9");
		location.setLocationName("Arizona");
		locations[0] = location;
		tipCreditDTO.setLocations(locations);
		tipCreditDTO.setOrgId("o1");
		return tipCreditDTO;

	}

	public LocationTipCredits locationTipCreditsData() throws ParseException {

		TipCreditDTO tipCreditData = new TipCreditData().tipCreditDataDTO();
		LocationTipCredits locationtipCredit = new LocationTipCredits();
		LaborLocation laborLocation = new LaborLocation();
		laborLocation.setLocationId("l9");
		locationtipCredit.setBrandId(tipCreditData.getBrandId());
		locationtipCredit.setCreatedBy(tipCreditData.getCreatedBy());
		locationtipCredit.setCreatedDate(tipCreditData.getCreatedDate());
		locationtipCredit.setUpdatedDate(tipCreditData.getCreatedDate());
		locationtipCredit
				.setStartDate(dateUtils.stringToDate(tipCreditData.getStartDate(), DateUtils.DATE_FORMAT_COMMON));
		locationtipCredit.setEndDate(dateUtils.stringToDate(tipCreditData.getEndDate(), DateUtils.DATE_FORMAT_COMMON));
		locationtipCredit.setLaborLocation(laborLocation);
		locationtipCredit.setTipCredit(tipCreditData.getTipCredit());
		locationtipCredit.setOrgId(tipCreditData.getOrgId());
		locationtipCredit.setStatus(tipCreditData.getStatus());
		locationtipCredit.setUpdatedBy(tipCreditData.getUpdatedBy());
		return locationtipCredit;

	}

	public JSONArray listTipCreditData() {
		JSONArray pArray = new JSONArray();

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("location_id", "l9");
		jsonObject.put("location_name", "Arizona");
		JSONObject tipObj = new JSONObject();
		tipObj.put("brand_id", "b1");
		tipObj.put("org_id", "b1");
		tipObj.put("start_date", "2019-12-21");
		tipObj.put("end_date", "");
		tipObj.put("tip_credit", "100");
		tipObj.put("status", "Scheduled");
		pArray.add(jsonObject);
		pArray.add(tipObj);

		return pArray;

	}
}

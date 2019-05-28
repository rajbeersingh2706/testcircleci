
package com.salido.labor.data;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONTokener;

public class CommonData {

	public JSONObject commonDataList() {
		JSONObject inputJson = new JSONObject();
		inputJson.put("brandId", "b1");
		inputJson.put("orgId", "o1");
		JSONArray pArray = new JSONArray();
		JSONObject inputJson1 = new JSONObject();
		inputJson1.put("locationId", "l9");
		inputJson1.put("locationName", "Arizona");
		pArray.add(inputJson1);
		inputJson.put("locations", pArray);
		return inputJson;
	}

	public JSONObject commonDataAdd() {
		JSONObject inputJson = new JSONObject();
		inputJson.put("brandId", "b1");
		inputJson.put("orgId", "o1");
		inputJson.put("locationId", "l9");
		inputJson.put("status", "1");
		inputJson.put("startDate", "2019-12-21");
		inputJson.put("endDate", "");
		inputJson.put("createdBy", "ea3758b5-8dd6-4499-84c8-8fd6381f3d83");
		inputJson.put("createdDate", null);
		inputJson.put("updatedBy", "ea3758b5-8dd6-4499-84c8-8fd6381f3d83");
		inputJson.put("updatedDate", null);
		return inputJson;
	}

	public JSONObject stringToJson(String str) {
		JSONTokener jsonTokener = new JSONTokener(str);
		JSONObject obj = (JSONObject) jsonTokener.nextValue();
		return obj;

	}
}

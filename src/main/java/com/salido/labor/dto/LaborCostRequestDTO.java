package com.salido.labor.dto;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.salido.labor.common.RuleProcessConstants;
import com.salido.labor.exception.SalidoLaborBusinessException;
import com.salido.labor.util.DateUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class LaborCostRequestDTO {

	private String shiftId;

	@JsonFormat(pattern = "E MMM dd HH:mm:ss Z yyyy")
	private Date timecardStartDate;

	@JsonFormat(pattern = "E MMM dd HH:mm:ss Z yyyy")
	private Date timecardEndDate;

	private double payRate;
	private double blendedRate;
	private String empId;
	private String empPositionId;
	private String locationId;
	private int workWeek;
	private long breaks;
	private Map<String, Object> timecardCost = new HashMap<>();
	private List<LaborCostRequestDTO> weekTimecards;
	private List<LaborCostRequestDTO> currentDayTimecards;
	DateUtils dateUtils = DateUtils.getInstance();

	@JsonIgnore
	private JSONObject costObject;

	private long durationInSeconds;

	public String getShiftId() {
		return shiftId;
	}

	public void setShiftId(String shiftId) {
		this.shiftId = shiftId;
	}

	public double getPayRate() {
		return payRate;
	}

	public Date getTimecardStartDate() {
		if (timecardStartDate == null) {
			return null;
		} else {
			return new Date(timecardStartDate.getTime());
		}
	}

	public void setTimecardStartDate(Date timecardStartDate) {
		this.timecardStartDate = timecardStartDate != null ? new Date(timecardStartDate.getTime()) : null;
	}

	public Date getTimecardEndDate() {
		if (timecardEndDate == null) {
			return null;
		} else {
			return new Date(timecardEndDate.getTime());
		}
	}

	public void setTimecardEndDate(Date timecardEndDate) {
		this.timecardEndDate = timecardEndDate != null ? new Date(timecardEndDate.getTime()) : null;
	}

	public void setPayRate(double payRate) {
		this.payRate = payRate;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpPositionId() {
		return empPositionId;
	}

	public void setEmpPositionId(String empPositionId) {
		this.empPositionId = empPositionId;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public int getWorkWeek() {
		return workWeek;
	}

	public void setWorkWeek(int workWeek) {
		this.workWeek = workWeek;
	}

	public List<LaborCostRequestDTO> getWeekTimecards() {
		return weekTimecards;
	}

	public void setWeekTimecards(List<LaborCostRequestDTO> weekTimecards) {
		this.weekTimecards = weekTimecards;
	}

	public long getDurationInSeconds() {
		return durationInSeconds;
	}

	public void setDurationInSeconds(long durationInSeconds) {
		this.durationInSeconds = durationInSeconds;
	}

	public double getBlendedRate() {
		return blendedRate;
	}

	public void setBlendedRate(double blendedRate) {
		this.blendedRate = blendedRate;
	}

	public long getBreaks() {
		return breaks;
	}

	public void setBreaks(long breaks) {
		this.breaks = breaks;
	}

	public Map<String, Object> getTimecardCost() {
		return timecardCost;
	}

	public void setTimecardCost(Map<String, Object> timecardCost) {
		this.timecardCost = timecardCost;
	}

	@JsonIgnore
	public JSONObject getRegWageObject() {
		return (JSONObject) this.getCostObject().get(RuleProcessConstants.LaborCostKeys.REG_WAGE_OBJECT);
	}

	@JsonIgnore
	@SuppressWarnings("unchecked")
	public List<JSONObject> getOtWageObject() {
		return (List<JSONObject>) this.getCostObject().get(RuleProcessConstants.LaborCostKeys.OT_WAGE_OBJECT);

	}

	@JsonIgnore
	public JSONObject getSohWageObject() {
		return (JSONObject) this.getCostObject().get(RuleProcessConstants.LaborCostKeys.SOH_WAGE_OBJECT);

	}

	@JsonIgnore
	public JSONObject getTipCreditWageObject() {
		return (JSONObject) this.getCostObject().get(RuleProcessConstants.LaborCostKeys.TIPCREDIT_WAGE_OBJECT);
	}

	@JsonIgnore
	public void setRegWageObject(JSONObject regWageObject) {
		this.getCostObject().put(RuleProcessConstants.LaborCostKeys.REG_WAGE_OBJECT, regWageObject);
	}

	@JsonIgnore
	public void setOtWageObject(List<JSONObject> otWageObjectArr) {
		this.getCostObject().put(RuleProcessConstants.LaborCostKeys.OT_WAGE_OBJECT, otWageObjectArr);
	}

	@JsonIgnore
	public void addOtWageObject(JSONObject otWageObject) {
		((JSONArray) this.getCostObject().get(RuleProcessConstants.LaborCostKeys.OT_WAGE_OBJECT)).add(otWageObject);
	}

	@JsonIgnore
	public void setSohWageObject(JSONObject sohWageObject) {
		this.getCostObject().put(RuleProcessConstants.LaborCostKeys.SOH_WAGE_OBJECT, sohWageObject);
	}

	@JsonIgnore
	public void setTipCreditWageObject(JSONObject tipCreditWageObject) {
		this.getCostObject().put(RuleProcessConstants.LaborCostKeys.TIPCREDIT_WAGE_OBJECT, tipCreditWageObject);
	}

	@JsonIgnore
	public JSONObject getCostObject() {
		return this.costObject != null ? this.costObject : returnDefaultObject();
	}

	@JsonIgnore
	public void setCostObject(JSONObject costObject) {
		this.costObject = costObject;
	}

	@JsonIgnore
	public List<LaborCostRequestDTO> getCurrentDayTimecards() {
		return currentDayTimecards;
	}

	@JsonIgnore
	public void setCurrentDayTimecards(List<LaborCostRequestDTO> currentDayTimecards) {
		this.currentDayTimecards = currentDayTimecards;
	}

	private JSONObject returnDefaultObject() {
		costObject = new JSONObject();
		costObject.put(RuleProcessConstants.LaborCostKeys.REG_WAGE_OBJECT, new JSONObject());
		costObject.put(RuleProcessConstants.LaborCostKeys.OT_WAGE_OBJECT, new JSONArray());
		costObject.put(RuleProcessConstants.LaborCostKeys.SOH_WAGE_OBJECT, new JSONObject());
		costObject.put(RuleProcessConstants.LaborCostKeys.TIPCREDIT_WAGE_OBJECT, new JSONObject());
		return costObject;
	}

	@Override
	public String toString() {
		return "LaborCostRequestDTO [shiftId=" + shiftId + ", timecardStartDate=" + timecardStartDate
				+ ", timecardEndDate=" + timecardEndDate + ", payRate=" + payRate + ", blendedRate=" + blendedRate
				+ ", empId=" + empId + ", empPositionId=" + empPositionId + ", locationId=" + locationId + ", workWeek="
				+ workWeek + ", weekTimecards=" + weekTimecards + ", currentDayTimecards=" + currentDayTimecards
				+ ", dateUtils=" + dateUtils + ", costObject=" + costObject + ", durationInSeconds=" + durationInSeconds
				+ "]";
	}

	public boolean validateRequest(LaborCostRequestDTO costRequestDTO) {
		if (costRequestDTO.getWeekTimecards().isEmpty()) {
			throw new SalidoLaborBusinessException("TimeCards not found");
		} else if (StringUtils.isBlank(costRequestDTO.getLocationId())) {
			throw new SalidoLaborBusinessException("Location Id not found");
		} else if (costRequestDTO.getPayRate() <= 0) {
			throw new SalidoLaborBusinessException("Pay-Rate must be greater than 0");
		}
		for (LaborCostRequestDTO weekCard : costRequestDTO.getWeekTimecards()) {
			validateDTO(weekCard);
		}
		return true;
	}

	private boolean validateDTO(LaborCostRequestDTO costRequestDTO) {
		if (costRequestDTO.getTimecardStartDate() == null) {
			throw new SalidoLaborBusinessException("TimecardStartDate not found");
		} else if (costRequestDTO.getTimecardEndDate() == null) {
			throw new SalidoLaborBusinessException("TimecardEndDate not found");
		}
		return true;
	}
}

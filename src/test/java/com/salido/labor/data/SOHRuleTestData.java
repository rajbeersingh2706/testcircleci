package com.salido.labor.data;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.salido.labor.dto.LaborCostRequestDTO;
import com.salido.labor.util.DateUtils;

public class SOHRuleTestData {
	private SOHRuleTestData() {
		super();
	}

	public static LaborCostRequestDTO getRuleData() throws ParseException {
		// For Spread of Hours Result
		List<LaborCostRequestDTO> weekTimecards = new ArrayList<>();
		LaborCostRequestDTO sohRuleTimecardA = new LaborCostRequestDTO();
		sohRuleTimecardA.setShiftId("59e523bf1e4fa3000702ae72");
		sohRuleTimecardA.setTimecardStartDate(DateUtils.getDateInFormat("Thu Mar 15 08:00:00 IST 2019"));
		sohRuleTimecardA.setTimecardEndDate(DateUtils.getDateInFormat("Thu Mar 15 14:00:00 IST 2019"));
		sohRuleTimecardA.setPayRate(10);
		sohRuleTimecardA.setEmpId("56a8fde4d53590000a00009d");
		sohRuleTimecardA.setEmpPositionId("56ab9c41cf8b48000a00001e");
		sohRuleTimecardA.setLocationId("l3");
		sohRuleTimecardA.setDurationInSeconds(32400);
		weekTimecards.add(sohRuleTimecardA);

		LaborCostRequestDTO sohRuleTimecardB = new LaborCostRequestDTO();
		sohRuleTimecardB.setShiftId("59e523bf1e4fa3000702ae73");
		sohRuleTimecardB.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 14:00:00 IST 2019"));
		sohRuleTimecardB.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 18:00:00 IST 2019"));
		sohRuleTimecardB.setPayRate(10);
		sohRuleTimecardB.setEmpId("56a8fde4d53590000a00009d");
		sohRuleTimecardB.setEmpPositionId("56ab9c41cf8b48000a00001e");
		sohRuleTimecardB.setLocationId("l3");
		sohRuleTimecardB.setDurationInSeconds(32400);
		weekTimecards.add(sohRuleTimecardB);

		LaborCostRequestDTO sohRuleTimecardC = new LaborCostRequestDTO();
		sohRuleTimecardC.setShiftId("59e523bf1e4fa3000702ae79");
		sohRuleTimecardC.setTimecardStartDate(DateUtils.getDateInFormat("Sat Mar 15 18:00:00 IST 2019"));
		sohRuleTimecardC.setTimecardEndDate(DateUtils.getDateInFormat("Sat Mar 15 23:00:00 IST 2019"));
		sohRuleTimecardC.setPayRate(10);
		sohRuleTimecardC.setEmpId("56a8fde4d53590000a00009d");
		sohRuleTimecardC.setEmpPositionId("56ab9c41cf8b48000a00001e");
		sohRuleTimecardC.setLocationId("l3");
		sohRuleTimecardC.setDurationInSeconds(32400);
		weekTimecards.add(sohRuleTimecardC);

		LaborCostRequestDTO sohCostRequestDTO = new LaborCostRequestDTO();
		sohCostRequestDTO.setShiftId("59e523bf1e4fa3000702ae74");
		sohCostRequestDTO.setTimecardStartDate(DateUtils.getDateInFormat("Sat Mar 15 18:00:00 IST 2019"));
		sohCostRequestDTO.setTimecardEndDate(DateUtils.getDateInFormat("Sat Mar 15 23:00:00 IST 2019"));
		sohCostRequestDTO.setPayRate(10);
		sohCostRequestDTO.setEmpId("56a8fde4d53590000a00009d");
		sohCostRequestDTO.setEmpPositionId("56ab9c41cf8b48000a00001e");
		sohCostRequestDTO.setLocationId("l3");
		sohCostRequestDTO.setWorkWeek(1);
		sohCostRequestDTO.setDurationInSeconds(32400);
		sohCostRequestDTO.setWeekTimecards(weekTimecards);
		return sohCostRequestDTO;
	}

	public static LaborCostRequestDTO getRuleDataNoMinwage() throws ParseException {
		// For Spread of Hours Result
		List<LaborCostRequestDTO> weekTimecards = new ArrayList<>();
		LaborCostRequestDTO sohRuleTimecardD = new LaborCostRequestDTO();
		sohRuleTimecardD.setShiftId("59e523bf1e4fa3000702ae72");
		sohRuleTimecardD.setTimecardStartDate(DateUtils.getDateInFormat("Thu Mar 15 08:00:00 IST 2019"));
		sohRuleTimecardD.setTimecardEndDate(DateUtils.getDateInFormat("Thu Mar 15 14:00:00 IST 2019"));
		sohRuleTimecardD.setPayRate(10);
		sohRuleTimecardD.setEmpId("56a8fde4d53590000a00009d");
		sohRuleTimecardD.setEmpPositionId("56ab9c41cf8b48000a00001e");
		sohRuleTimecardD.setLocationId("l9");
		sohRuleTimecardD.setDurationInSeconds(32400);
		weekTimecards.add(sohRuleTimecardD);

		LaborCostRequestDTO sohRuleTimecardE = new LaborCostRequestDTO();
		sohRuleTimecardE.setShiftId("59e523bf1e4fa3000702ae73");
		sohRuleTimecardE.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 14:00:00 IST 2019"));
		sohRuleTimecardE.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 18:00:00 IST 2019"));
		sohRuleTimecardE.setPayRate(10);
		sohRuleTimecardE.setEmpId("56a8fde4d53590000a00009d");
		sohRuleTimecardE.setEmpPositionId("56ab9c41cf8b48000a00001e");
		sohRuleTimecardE.setLocationId("l9");
		sohRuleTimecardE.setDurationInSeconds(32400);
		weekTimecards.add(sohRuleTimecardE);

		LaborCostRequestDTO sohRuleTimecardF = new LaborCostRequestDTO();
		sohRuleTimecardF.setShiftId("59e523bf1e4fa3000702ae79");
		sohRuleTimecardF.setTimecardStartDate(DateUtils.getDateInFormat("Sat Mar 15 18:00:00 IST 2019"));
		sohRuleTimecardF.setTimecardEndDate(DateUtils.getDateInFormat("Sat Mar 15 23:00:00 IST 2019"));
		sohRuleTimecardF.setPayRate(10);
		sohRuleTimecardF.setEmpId("56a8fde4d53590000a00009d");
		sohRuleTimecardF.setEmpPositionId("56ab9c41cf8b48000a00001e");
		sohRuleTimecardF.setLocationId("l9");
		sohRuleTimecardF.setDurationInSeconds(32400);
		weekTimecards.add(sohRuleTimecardF);

		LaborCostRequestDTO sohCostRequestDTOA = new LaborCostRequestDTO();
		sohCostRequestDTOA.setShiftId("59e523bf1e4fa3000702ae74");
		sohCostRequestDTOA.setTimecardStartDate(DateUtils.getDateInFormat("Sat Mar 15 18:00:00 IST 2019"));
		sohCostRequestDTOA.setTimecardEndDate(DateUtils.getDateInFormat("Sat Mar 15 23:00:00 IST 2019"));
		sohCostRequestDTOA.setPayRate(10);
		sohCostRequestDTOA.setEmpId("56a8fde4d53590000a00009d");
		sohCostRequestDTOA.setEmpPositionId("56ab9c41cf8b48000a00001e");
		sohCostRequestDTOA.setLocationId("l9");
		sohCostRequestDTOA.setWorkWeek(1);
		sohCostRequestDTOA.setDurationInSeconds(32400);
		sohCostRequestDTOA.setWeekTimecards(weekTimecards);
		return sohCostRequestDTOA;
	}

}

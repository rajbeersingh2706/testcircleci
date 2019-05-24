package com.salido.labor.data;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.salido.labor.dto.LaborCostRequestDTO;
import com.salido.labor.util.DateUtils;

public class TipCreditRuleTestData {
	private TipCreditRuleTestData() {
		super();
	}

	public static LaborCostRequestDTO getRuleData() throws ParseException {
		// For Tip Credit Result
		List<LaborCostRequestDTO> weekTimecards = new ArrayList<>();
		LaborCostRequestDTO tcRuleTimecardA = new LaborCostRequestDTO();
		tcRuleTimecardA.setShiftId("59e523bf1e4fa3000702ae72");
		tcRuleTimecardA.setTimecardStartDate(DateUtils.getDateInFormat("Thu Mar 15 10:00:00 IST 2019"));
		tcRuleTimecardA.setTimecardEndDate(DateUtils.getDateInFormat("Thu Mar 15 12:00:00 IST 2019"));
		tcRuleTimecardA.setPayRate(10);
		tcRuleTimecardA.setEmpId("56a8fde4d53590000a00009d");
		tcRuleTimecardA.setEmpPositionId("56ab9c41cf8b48000a00001e");
		tcRuleTimecardA.setLocationId("l6");
		tcRuleTimecardA.setDurationInSeconds(32400);
		tcRuleTimecardA.setBreaks(1000 * 60 * 30);
		weekTimecards.add(tcRuleTimecardA);

		LaborCostRequestDTO tcRuleTimecardB = new LaborCostRequestDTO();
		tcRuleTimecardB.setShiftId("59e523bf1e4fa3000702ae73");
		tcRuleTimecardB.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 15:00:00 IST 2019"));
		tcRuleTimecardB.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 19:00:00 IST 2019"));
		tcRuleTimecardB.setPayRate(10);
		tcRuleTimecardB.setEmpId("56a8fde4d53590000a00009d");
		tcRuleTimecardB.setEmpPositionId("56ab9c41cf8b48000a00001e");
		tcRuleTimecardB.setLocationId("l6");
		tcRuleTimecardB.setDurationInSeconds(32400);
		tcRuleTimecardB.setBreaks(1000 * 60 * 30);
		weekTimecards.add(tcRuleTimecardB);

		LaborCostRequestDTO tcRuleTimecardC = new LaborCostRequestDTO();
		tcRuleTimecardC.setShiftId("59e523bf1e4fa3000702ae79");
		tcRuleTimecardC.setTimecardStartDate(DateUtils.getDateInFormat("Sat Mar 15 20:00:00 IST 2019"));
		tcRuleTimecardC.setTimecardEndDate(DateUtils.getDateInFormat("Sat Mar 15 22:00:00 IST 2019"));
		tcRuleTimecardC.setPayRate(10);
		tcRuleTimecardC.setEmpId("56a8fde4d53590000a00009d");
		tcRuleTimecardC.setEmpPositionId("56ab9c41cf8b48000a00001e");
		tcRuleTimecardC.setLocationId("l6");
		tcRuleTimecardC.setDurationInSeconds(32400);
		tcRuleTimecardC.setBreaks(1000 * 60 * 30);
		weekTimecards.add(tcRuleTimecardC);

		LaborCostRequestDTO tcCostRequestDTO = new LaborCostRequestDTO();
		tcCostRequestDTO.setShiftId("59e523bf1e4fa3000702ae74");
		tcCostRequestDTO.setTimecardStartDate(DateUtils.getDateInFormat("Sat Mar 15 20:00:00 IST 2019"));
		tcCostRequestDTO.setTimecardEndDate(DateUtils.getDateInFormat("Sat Mar 15 22:00:00 IST 2019"));
		tcCostRequestDTO.setPayRate(10);
		tcCostRequestDTO.setEmpId("56a8fde4d53590000a00009d");
		tcCostRequestDTO.setEmpPositionId("56ab9c41cf8b48000a00001e");
		tcCostRequestDTO.setLocationId("l6");
		tcCostRequestDTO.setWorkWeek(1);
		tcCostRequestDTO.setDurationInSeconds(32400);
		tcCostRequestDTO.setBreaks(1000 * 60 * 30);
		tcCostRequestDTO.setWeekTimecards(weekTimecards);
		return tcCostRequestDTO;
	}

	public static LaborCostRequestDTO testTipCreditNoTipCreditInfo() throws ParseException {
		// For Tip Credit Result
		List<LaborCostRequestDTO> weekTimecards = new ArrayList<>();
		LaborCostRequestDTO tcRuleTimecardD = new LaborCostRequestDTO();
		tcRuleTimecardD.setShiftId("59e523bf1e4fa3000702ae72");
		tcRuleTimecardD.setTimecardStartDate(DateUtils.getDateInFormat("Thu Mar 15 10:00:00 IST 2019"));
		tcRuleTimecardD.setTimecardEndDate(DateUtils.getDateInFormat("Thu Mar 15 12:00:00 IST 2019"));
		tcRuleTimecardD.setPayRate(10);
		tcRuleTimecardD.setEmpId("56a8fde4d53590000a00009d");
		tcRuleTimecardD.setEmpPositionId("56ab9c41cf8b48000a00001e");
		tcRuleTimecardD.setLocationId("l4");
		tcRuleTimecardD.setDurationInSeconds(32400);
		tcRuleTimecardD.setBreaks(1000 * 60 * 30);
		weekTimecards.add(tcRuleTimecardD);

		LaborCostRequestDTO tcRuleTimecardE = new LaborCostRequestDTO();
		tcRuleTimecardE.setShiftId("59e523bf1e4fa3000702ae73");
		tcRuleTimecardE.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 15:00:00 IST 2019"));
		tcRuleTimecardE.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 19:00:00 IST 2019"));
		tcRuleTimecardE.setPayRate(10);
		tcRuleTimecardE.setEmpId("56a8fde4d53590000a00009d");
		tcRuleTimecardE.setEmpPositionId("56ab9c41cf8b48000a00001e");
		tcRuleTimecardE.setLocationId("l4");
		tcRuleTimecardE.setDurationInSeconds(32400);
		tcRuleTimecardE.setBreaks(1000 * 60 * 30);
		weekTimecards.add(tcRuleTimecardE);

		LaborCostRequestDTO tcRuleTimecardF = new LaborCostRequestDTO();
		tcRuleTimecardF.setShiftId("59e523bf1e4fa3000702ae79");
		tcRuleTimecardF.setTimecardStartDate(DateUtils.getDateInFormat("Sat Mar 15 20:00:00 IST 2019"));
		tcRuleTimecardF.setTimecardEndDate(DateUtils.getDateInFormat("Sat Mar 15 22:00:00 IST 2019"));
		tcRuleTimecardF.setPayRate(10);
		tcRuleTimecardF.setEmpId("56a8fde4d53590000a00009d");
		tcRuleTimecardF.setEmpPositionId("56ab9c41cf8b48000a00001e");
		tcRuleTimecardF.setLocationId("l4");
		tcRuleTimecardF.setDurationInSeconds(32400);
		tcRuleTimecardF.setBreaks(1000 * 60 * 30);
		weekTimecards.add(tcRuleTimecardF);

		LaborCostRequestDTO tcCostRequestDTOA = new LaborCostRequestDTO();
		tcCostRequestDTOA.setShiftId("59e523bf1e4fa3000702ae74");
		tcCostRequestDTOA.setTimecardStartDate(DateUtils.getDateInFormat("Sat Mar 15 20:00:00 IST 2019"));
		tcCostRequestDTOA.setTimecardEndDate(DateUtils.getDateInFormat("Sat Mar 15 22:00:00 IST 2019"));
		tcCostRequestDTOA.setPayRate(10);
		tcCostRequestDTOA.setEmpId("56a8fde4d53590000a00009d");
		tcCostRequestDTOA.setEmpPositionId("56ab9c41cf8b48000a00001e");
		tcCostRequestDTOA.setLocationId("l4");
		tcCostRequestDTOA.setWorkWeek(1);
		tcCostRequestDTOA.setDurationInSeconds(32400);
		tcCostRequestDTOA.setBreaks(1000 * 60 * 30);
		tcCostRequestDTOA.setWeekTimecards(weekTimecards);
		return tcCostRequestDTOA;
	}

}

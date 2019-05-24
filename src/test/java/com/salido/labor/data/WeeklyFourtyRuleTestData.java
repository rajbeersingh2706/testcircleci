package com.salido.labor.data;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.salido.labor.dto.LaborCostRequestDTO;
import com.salido.labor.util.DateUtils;

public class WeeklyFourtyRuleTestData {
	private WeeklyFourtyRuleTestData() {
		super();
	}

	// For Weekly 40 & Daily 8 Overtime
	public static LaborCostRequestDTO getRuleDataNotVerified() throws ParseException {
		// Not Verified
		List<LaborCostRequestDTO> weekTimecards = new ArrayList<>();
		LaborCostRequestDTO wfRuleTimecardA = new LaborCostRequestDTO();
		wfRuleTimecardA.setShiftId("59e523bf1e4fa3000702ae70");
		wfRuleTimecardA.setTimecardStartDate(DateUtils.getDateInFormat("Mon Mar 11 09:00:00 IST 2019"));
		wfRuleTimecardA.setTimecardEndDate(DateUtils.getDateInFormat("Mon Mar 11 12:00:00 IST 2019"));
		wfRuleTimecardA.setPayRate(10);
		wfRuleTimecardA.setEmpId("56a8fde4d53590000a00009d");
		wfRuleTimecardA.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfRuleTimecardA.setLocationId("l3");
		wfRuleTimecardA.setDurationInSeconds(32400);
		weekTimecards.add(wfRuleTimecardA);

		LaborCostRequestDTO wfRuleTimecardB = new LaborCostRequestDTO();
		wfRuleTimecardB.setShiftId("59e523bf1e4fa3000702ae70");
		wfRuleTimecardB.setTimecardStartDate(DateUtils.getDateInFormat("Mon Mar 11 12:00:00 IST 2019"));
		wfRuleTimecardB.setTimecardEndDate(DateUtils.getDateInFormat("Mon Mar 11 13:00:00 IST 2019"));
		wfRuleTimecardB.setPayRate(10);
		wfRuleTimecardB.setEmpId("56a8fde4d53590000a00009d");
		wfRuleTimecardB.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfRuleTimecardB.setLocationId("l3");
		wfRuleTimecardB.setDurationInSeconds(32400);
		weekTimecards.add(wfRuleTimecardB);

		LaborCostRequestDTO wfRuleTimecardC = new LaborCostRequestDTO();
		wfRuleTimecardC.setShiftId("59e523bf1e4fa3000702ae71");
		wfRuleTimecardC.setTimecardStartDate(DateUtils.getDateInFormat("Tue Mar 12 09:00:00 IST 2019"));
		wfRuleTimecardC.setTimecardEndDate(DateUtils.getDateInFormat("Tue Mar 12 15:00:00 IST 2019"));
		wfRuleTimecardC.setPayRate(10);
		wfRuleTimecardC.setEmpId("56a8fde4d53590000a00009d");
		wfRuleTimecardC.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfRuleTimecardC.setLocationId("l3");
		wfRuleTimecardC.setDurationInSeconds(32400);
		weekTimecards.add(wfRuleTimecardC);

		LaborCostRequestDTO wfRuleTimecardD = new LaborCostRequestDTO();
		wfRuleTimecardD.setShiftId("59e523bf1e4fa3000702ae72");
		wfRuleTimecardD.setTimecardStartDate(DateUtils.getDateInFormat("Wed Mar 13 09:00:00 IST 2019"));
		wfRuleTimecardD.setTimecardEndDate(DateUtils.getDateInFormat("Wed Mar 13 15:00:00 IST 2019"));
		wfRuleTimecardD.setPayRate(10);
		wfRuleTimecardD.setEmpId("56a8fde4d53590000a00009d");
		wfRuleTimecardD.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfRuleTimecardD.setLocationId("l3");
		wfRuleTimecardD.setDurationInSeconds(32400);
		weekTimecards.add(wfRuleTimecardD);

		LaborCostRequestDTO wfRuleTimecardE = new LaborCostRequestDTO();
		wfRuleTimecardE.setShiftId("59e523bf1e4fa3000702ae73");
		wfRuleTimecardE.setTimecardStartDate(DateUtils.getDateInFormat("Thu Mar 14 09:00:00 IST 2019"));
		wfRuleTimecardE.setTimecardEndDate(DateUtils.getDateInFormat("Thu Mar 14 18:00:00 IST 2019"));
		wfRuleTimecardE.setPayRate(10);
		wfRuleTimecardE.setEmpId("56a8fde4d53590000a00009d");
		wfRuleTimecardE.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfRuleTimecardE.setLocationId("l3");
		wfRuleTimecardE.setDurationInSeconds(32400);
		weekTimecards.add(wfRuleTimecardE);

		LaborCostRequestDTO wfRuleTimecardF = new LaborCostRequestDTO();
		wfRuleTimecardF.setShiftId("59e523bf1e4fa3000702ae74");
		wfRuleTimecardF.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 09:00:00 IST 2019"));
		wfRuleTimecardF.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 12:00:00 IST 2019"));
		wfRuleTimecardF.setPayRate(10);
		wfRuleTimecardF.setEmpId("56a8fde4d53590000a00009d");
		wfRuleTimecardF.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfRuleTimecardF.setLocationId("l3");
		wfRuleTimecardF.setDurationInSeconds(32400);
		weekTimecards.add(wfRuleTimecardF);

		LaborCostRequestDTO wfRuleTimecardG = new LaborCostRequestDTO();
		wfRuleTimecardG.setShiftId("59e523bf1e4fa3000702ae74");
		wfRuleTimecardG.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 13:00:00 IST 2019"));
		wfRuleTimecardG.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 16:00:00 IST 2019"));
		wfRuleTimecardG.setPayRate(10);
		wfRuleTimecardG.setEmpId("56a8fde4d53590000a00009d");
		wfRuleTimecardG.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfRuleTimecardG.setLocationId("l3");
		wfRuleTimecardG.setDurationInSeconds(32400);
		weekTimecards.add(wfRuleTimecardG);

		LaborCostRequestDTO wfRuleTimecardH = new LaborCostRequestDTO();
		wfRuleTimecardH.setShiftId("59e523bf1e4fa3000702ae74");
		wfRuleTimecardH.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 16:00:00 IST 2019"));
		wfRuleTimecardH.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 19:00:00 IST 2019"));
		wfRuleTimecardH.setPayRate(10);
		wfRuleTimecardH.setEmpId("56a8fde4d53590000a00009d");
		wfRuleTimecardH.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfRuleTimecardH.setLocationId("l3");
		wfRuleTimecardH.setDurationInSeconds(32400);
		weekTimecards.add(wfRuleTimecardH);

		LaborCostRequestDTO wfRuleTimecardI = new LaborCostRequestDTO();
		wfRuleTimecardI.setShiftId("59e523bf1e4fa3000702ae74");
		wfRuleTimecardI.setTimecardStartDate(DateUtils.getDateInFormat("Sat Mar 16 09:00:00 IST 2019"));
		wfRuleTimecardI.setTimecardEndDate(DateUtils.getDateInFormat("Sat Mar 16 16:00:00 IST 2019"));
		wfRuleTimecardI.setPayRate(10);
		wfRuleTimecardI.setEmpId("56a8fde4d53590000a00009d");
		wfRuleTimecardI.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfRuleTimecardI.setLocationId("l3");
		wfRuleTimecardI.setDurationInSeconds(32400);
		weekTimecards.add(wfRuleTimecardI);

		LaborCostRequestDTO wfRuleTimecardJ = new LaborCostRequestDTO();
		wfRuleTimecardJ.setShiftId("59e523bf1e4fa3000702ae74");
		wfRuleTimecardJ.setTimecardStartDate(DateUtils.getDateInFormat("Sat Mar 16 16:00:00 IST 2019"));
		wfRuleTimecardJ.setTimecardEndDate(DateUtils.getDateInFormat("Sat Mar 16 17:00:00 IST 2019"));
		wfRuleTimecardJ.setPayRate(10);
		wfRuleTimecardJ.setEmpId("56a8fde4d53590000a00009d");
		wfRuleTimecardJ.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfRuleTimecardJ.setLocationId("l3");
		wfRuleTimecardJ.setDurationInSeconds(32400);
		weekTimecards.add(wfRuleTimecardJ);

		LaborCostRequestDTO wfCostRequestDTOA = new LaborCostRequestDTO();
		wfCostRequestDTOA.setShiftId("59e523bf1e4fa3000702ae74");
		wfCostRequestDTOA.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 16 16:00:00 IST 2019"));
		wfCostRequestDTOA.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 16 17:00:00 IST 2019"));
		wfCostRequestDTOA.setPayRate(10);
		wfCostRequestDTOA.setEmpId("56a8fde4d53590000a00009d");
		wfCostRequestDTOA.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfCostRequestDTOA.setLocationId("l3");
		wfCostRequestDTOA.setWorkWeek(1);
		wfCostRequestDTOA.setDurationInSeconds(32400);
		wfCostRequestDTOA.setWeekTimecards(weekTimecards);
		return wfCostRequestDTOA;
	}

	public static LaborCostRequestDTO getRuleDataVerifiedForWeek() throws ParseException {
		// Verified for #HOURS_WORKED_WEEK > 40
		List<LaborCostRequestDTO> weekTimecards = new ArrayList<>();
		LaborCostRequestDTO wfRuleTimecardK = new LaborCostRequestDTO();
		wfRuleTimecardK.setShiftId("59e523bf1e4fa3000702ae70");
		wfRuleTimecardK.setTimecardStartDate(DateUtils.getDateInFormat("Mon Mar 11 09:00:00 IST 2019"));
		wfRuleTimecardK.setTimecardEndDate(DateUtils.getDateInFormat("Mon Mar 11 12:00:00 IST 2019"));
		wfRuleTimecardK.setPayRate(10);
		wfRuleTimecardK.setEmpId("56a8fde4d53590000a00009d");
		wfRuleTimecardK.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfRuleTimecardK.setLocationId("l3");
		wfRuleTimecardK.setDurationInSeconds(32400);
		wfRuleTimecardK.setBreaks(1000 * 60 * 30);
		weekTimecards.add(wfRuleTimecardK);

		LaborCostRequestDTO wfRuleTimecardL = new LaborCostRequestDTO();
		wfRuleTimecardL.setShiftId("59e523bf1e4fa3000702ae70");
		wfRuleTimecardL.setTimecardStartDate(DateUtils.getDateInFormat("Mon Mar 11 12:00:00 IST 2019"));
		wfRuleTimecardL.setTimecardEndDate(DateUtils.getDateInFormat("Mon Mar 11 13:00:00 IST 2019"));
		wfRuleTimecardL.setPayRate(10);
		wfRuleTimecardL.setEmpId("56a8fde4d53590000a00009d");
		wfRuleTimecardL.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfRuleTimecardL.setLocationId("l3");
		wfRuleTimecardL.setDurationInSeconds(32400);
		weekTimecards.add(wfRuleTimecardL);

		LaborCostRequestDTO wfRuleTimecardM = new LaborCostRequestDTO();
		wfRuleTimecardM.setShiftId("59e523bf1e4fa3000702ae71");
		wfRuleTimecardM.setTimecardStartDate(DateUtils.getDateInFormat("Tue Mar 12 09:00:00 IST 2019"));
		wfRuleTimecardM.setTimecardEndDate(DateUtils.getDateInFormat("Tue Mar 12 15:00:00 IST 2019"));
		wfRuleTimecardM.setPayRate(10);
		wfRuleTimecardM.setEmpId("56a8fde4d53590000a00009d");
		wfRuleTimecardM.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfRuleTimecardM.setLocationId("l3");
		wfRuleTimecardM.setDurationInSeconds(32400);
		weekTimecards.add(wfRuleTimecardM);

		LaborCostRequestDTO wfRuleTimecardN = new LaborCostRequestDTO();
		wfRuleTimecardN.setShiftId("59e523bf1e4fa3000702ae72");
		wfRuleTimecardN.setTimecardStartDate(DateUtils.getDateInFormat("Wed Mar 13 09:00:00 IST 2019"));
		wfRuleTimecardN.setTimecardEndDate(DateUtils.getDateInFormat("Wed Mar 13 16:00:00 IST 2019"));
		wfRuleTimecardN.setPayRate(10);
		wfRuleTimecardN.setEmpId("56a8fde4d53590000a00009d");
		wfRuleTimecardN.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfRuleTimecardN.setLocationId("l3");
		wfRuleTimecardN.setDurationInSeconds(32400);
		weekTimecards.add(wfRuleTimecardN);

		LaborCostRequestDTO wfRuleTimecardO = new LaborCostRequestDTO();
		wfRuleTimecardO.setShiftId("59e523bf1e4fa3000702ae73");
		wfRuleTimecardO.setTimecardStartDate(DateUtils.getDateInFormat("Thu Mar 14 09:00:00 IST 2019"));
		wfRuleTimecardO.setTimecardEndDate(DateUtils.getDateInFormat("Thu Mar 14 18:00:00 IST 2019"));
		wfRuleTimecardO.setPayRate(10);
		wfRuleTimecardO.setEmpId("56a8fde4d53590000a00009d");
		wfRuleTimecardO.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfRuleTimecardO.setLocationId("l3");
		wfRuleTimecardO.setDurationInSeconds(32400);
		weekTimecards.add(wfRuleTimecardO);

		LaborCostRequestDTO wfRuleTimecardP = new LaborCostRequestDTO();
		wfRuleTimecardP.setShiftId("59e523bf1e4fa3000702ae74");
		wfRuleTimecardP.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 09:00:00 IST 2019"));
		wfRuleTimecardP.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 12:00:00 IST 2019"));
		wfRuleTimecardP.setPayRate(10);
		wfRuleTimecardP.setEmpId("56a8fde4d53590000a00009d");
		wfRuleTimecardP.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfRuleTimecardP.setLocationId("l3");
		wfRuleTimecardP.setDurationInSeconds(32400);
		weekTimecards.add(wfRuleTimecardP);

		LaborCostRequestDTO wfRuleTimecardQ = new LaborCostRequestDTO();
		wfRuleTimecardQ.setShiftId("59e523bf1e4fa3000702ae74");
		wfRuleTimecardQ.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 13:00:00 IST 2019"));
		wfRuleTimecardQ.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 16:00:00 IST 2019"));
		wfRuleTimecardQ.setPayRate(10);
		wfRuleTimecardQ.setEmpId("56a8fde4d53590000a00009d");
		wfRuleTimecardQ.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfRuleTimecardQ.setLocationId("l3");
		wfRuleTimecardQ.setDurationInSeconds(32400);
		weekTimecards.add(wfRuleTimecardQ);

		LaborCostRequestDTO wfRuleTimecardR = new LaborCostRequestDTO();
		wfRuleTimecardR.setShiftId("59e523bf1e4fa3000702ae74");
		wfRuleTimecardR.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 16:00:00 IST 2019"));
		wfRuleTimecardR.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 19:00:00 IST 2019"));
		wfRuleTimecardR.setPayRate(10);
		wfRuleTimecardR.setEmpId("56a8fde4d53590000a00009d");
		wfRuleTimecardR.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfRuleTimecardR.setLocationId("l3");
		wfRuleTimecardR.setDurationInSeconds(32400);
		weekTimecards.add(wfRuleTimecardR);

		LaborCostRequestDTO wfRuleTimecardS = new LaborCostRequestDTO();
		wfRuleTimecardS.setShiftId("59e523bf1e4fa3000702ae74");
		wfRuleTimecardS.setTimecardStartDate(DateUtils.getDateInFormat("Sat Mar 16 09:00:00 IST 2019"));
		wfRuleTimecardS.setTimecardEndDate(DateUtils.getDateInFormat("Sat Mar 16 16:00:00 IST 2019"));
		wfRuleTimecardS.setPayRate(10);
		wfRuleTimecardS.setEmpId("56a8fde4d53590000a00009d");
		wfRuleTimecardS.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfRuleTimecardS.setLocationId("l3");
		wfRuleTimecardS.setDurationInSeconds(32400);
		weekTimecards.add(wfRuleTimecardS);

		LaborCostRequestDTO wfRuleTimecardT = new LaborCostRequestDTO();
		wfRuleTimecardT.setShiftId("59e523bf1e4fa3000702ae74");
		wfRuleTimecardT.setTimecardStartDate(DateUtils.getDateInFormat("Sat Mar 16 16:00:00 IST 2019"));
		wfRuleTimecardT.setTimecardEndDate(DateUtils.getDateInFormat("Sat Mar 16 19:00:00 IST 2019"));
		wfRuleTimecardT.setPayRate(10);
		wfRuleTimecardT.setEmpId("56a8fde4d53590000a00009d");
		wfRuleTimecardT.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfRuleTimecardT.setLocationId("l3");
		wfRuleTimecardT.setDurationInSeconds(32400);
		wfRuleTimecardT.setBreaks(1000 * 60 * 30);
		weekTimecards.add(wfRuleTimecardT);

		LaborCostRequestDTO wfCostRequestDTOB = new LaborCostRequestDTO();
		wfCostRequestDTOB.setShiftId("59e523bf1e4fa3000702ae74");
		wfCostRequestDTOB.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 16 16:00:00 IST 2019"));
		wfCostRequestDTOB.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 16 19:00:00 IST 2019"));
		wfCostRequestDTOB.setPayRate(10);
		wfCostRequestDTOB.setEmpId("56a8fde4d53590000a00009d");
		wfCostRequestDTOB.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfCostRequestDTOB.setLocationId("l3");
		wfCostRequestDTOB.setWorkWeek(1);
		wfCostRequestDTOB.setDurationInSeconds(32400);
		wfCostRequestDTOB.setBreaks(1000 * 60 * 30);
		wfCostRequestDTOB.setWeekTimecards(weekTimecards);
		return wfCostRequestDTOB;
	}

	public static LaborCostRequestDTO getRuleDataVerifiedForDay() throws ParseException {
		// Verified for #HOURS_WORKED_DAY > 8
		List<LaborCostRequestDTO> weekTimecards = new ArrayList<>();
		LaborCostRequestDTO wfRuleTimecardU = new LaborCostRequestDTO();
		wfRuleTimecardU.setShiftId("59e523bf1e4fa3000702ae70");
		wfRuleTimecardU.setTimecardStartDate(DateUtils.getDateInFormat("Mon Mar 11 09:00:00 IST 2019"));
		wfRuleTimecardU.setTimecardEndDate(DateUtils.getDateInFormat("Mon Mar 11 12:00:00 IST 2019"));
		wfRuleTimecardU.setPayRate(10);
		wfRuleTimecardU.setEmpId("56a8fde4d53590000a00009d");
		wfRuleTimecardU.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfRuleTimecardU.setLocationId("l3");
		wfRuleTimecardU.setDurationInSeconds(32400);
		weekTimecards.add(wfRuleTimecardU);

		LaborCostRequestDTO wfRuleTimecardV = new LaborCostRequestDTO();
		wfRuleTimecardV.setShiftId("59e523bf1e4fa3000702ae70");
		wfRuleTimecardV.setTimecardStartDate(DateUtils.getDateInFormat("Mon Mar 11 12:00:00 IST 2019"));
		wfRuleTimecardV.setTimecardEndDate(DateUtils.getDateInFormat("Mon Mar 11 13:00:00 IST 2019"));
		wfRuleTimecardV.setPayRate(10);
		wfRuleTimecardV.setEmpId("56a8fde4d53590000a00009d");
		wfRuleTimecardV.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfRuleTimecardV.setLocationId("l3");
		wfRuleTimecardV.setDurationInSeconds(32400);
		weekTimecards.add(wfRuleTimecardV);

		LaborCostRequestDTO wfRuleTimecardW = new LaborCostRequestDTO();
		wfRuleTimecardW.setShiftId("59e523bf1e4fa3000702ae71");
		wfRuleTimecardW.setTimecardStartDate(DateUtils.getDateInFormat("Tue Mar 12 09:00:00 IST 2019"));
		wfRuleTimecardW.setTimecardEndDate(DateUtils.getDateInFormat("Tue Mar 12 15:00:00 IST 2019"));
		wfRuleTimecardW.setPayRate(10);
		wfRuleTimecardW.setEmpId("56a8fde4d53590000a00009d");
		wfRuleTimecardW.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfRuleTimecardW.setLocationId("l3");
		wfRuleTimecardW.setDurationInSeconds(32400);
		weekTimecards.add(wfRuleTimecardW);

		LaborCostRequestDTO wfRuleTimecardX = new LaborCostRequestDTO();
		wfRuleTimecardX.setShiftId("59e523bf1e4fa3000702ae72");
		wfRuleTimecardX.setTimecardStartDate(DateUtils.getDateInFormat("Wed Mar 13 09:00:00 IST 2019"));
		wfRuleTimecardX.setTimecardEndDate(DateUtils.getDateInFormat("Wed Mar 13 16:00:00 IST 2019"));
		wfRuleTimecardX.setPayRate(10);
		wfRuleTimecardX.setEmpId("56a8fde4d53590000a00009d");
		wfRuleTimecardX.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfRuleTimecardX.setLocationId("l3");
		wfRuleTimecardX.setDurationInSeconds(32400);
		weekTimecards.add(wfRuleTimecardX);

		LaborCostRequestDTO wfRuleTimecardY = new LaborCostRequestDTO();
		wfRuleTimecardY.setShiftId("59e523bf1e4fa3000702ae73");
		wfRuleTimecardY.setTimecardStartDate(DateUtils.getDateInFormat("Thu Mar 14 09:00:00 IST 2019"));
		wfRuleTimecardY.setTimecardEndDate(DateUtils.getDateInFormat("Thu Mar 14 14:00:00 IST 2019"));
		wfRuleTimecardY.setPayRate(10);
		wfRuleTimecardY.setEmpId("56a8fde4d53590000a00009d");
		wfRuleTimecardY.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfRuleTimecardY.setLocationId("l3");
		wfRuleTimecardY.setDurationInSeconds(32400);
		weekTimecards.add(wfRuleTimecardY);

		LaborCostRequestDTO wfRuleTimecardZ = new LaborCostRequestDTO();
		wfRuleTimecardZ.setShiftId("59e523bf1e4fa3000702ae74");
		wfRuleTimecardZ.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 09:00:00 IST 2019"));
		wfRuleTimecardZ.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 12:00:00 IST 2019"));
		wfRuleTimecardZ.setPayRate(10);
		wfRuleTimecardZ.setEmpId("56a8fde4d53590000a00009d");
		wfRuleTimecardZ.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfRuleTimecardZ.setLocationId("l3");
		wfRuleTimecardZ.setDurationInSeconds(32400);
		weekTimecards.add(wfRuleTimecardZ);

		LaborCostRequestDTO wfRuleTimecardAA = new LaborCostRequestDTO();
		wfRuleTimecardAA.setShiftId("59e523bf1e4fa3000702ae74");
		wfRuleTimecardAA.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 13:00:00 IST 2019"));
		wfRuleTimecardAA.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 16:00:00 IST 2019"));
		wfRuleTimecardAA.setPayRate(10);
		wfRuleTimecardAA.setEmpId("56a8fde4d53590000a00009d");
		wfRuleTimecardAA.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfRuleTimecardAA.setLocationId("l3");
		wfRuleTimecardAA.setDurationInSeconds(32400);
		weekTimecards.add(wfRuleTimecardAA);

		LaborCostRequestDTO wfRuleTimecardAB = new LaborCostRequestDTO();
		wfRuleTimecardAB.setShiftId("59e523bf1e4fa3000702ae74");
		wfRuleTimecardAB.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 16:00:00 IST 2019"));
		wfRuleTimecardAB.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 19:00:00 IST 2019"));
		wfRuleTimecardAB.setPayRate(10);
		wfRuleTimecardAB.setEmpId("56a8fde4d53590000a00009d");
		wfRuleTimecardAB.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfRuleTimecardAB.setLocationId("l3");
		wfRuleTimecardAB.setDurationInSeconds(32400);
		weekTimecards.add(wfRuleTimecardAB);

		LaborCostRequestDTO wfRuleTimecardAC = new LaborCostRequestDTO();
		wfRuleTimecardAC.setShiftId("59e523bf1e4fa3000702ae74");
		wfRuleTimecardAC.setTimecardStartDate(DateUtils.getDateInFormat("Sat Mar 16 09:00:00 IST 2019"));
		wfRuleTimecardAC.setTimecardEndDate(DateUtils.getDateInFormat("Sat Mar 16 16:00:00 IST 2019"));
		wfRuleTimecardAC.setPayRate(10);
		wfRuleTimecardAC.setEmpId("56a8fde4d53590000a00009d");
		wfRuleTimecardAC.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfRuleTimecardAC.setLocationId("l3");
		wfRuleTimecardAC.setDurationInSeconds(32400);
		weekTimecards.add(wfRuleTimecardAC);

		LaborCostRequestDTO wfRuleTimecardAD = new LaborCostRequestDTO();
		wfRuleTimecardAD.setShiftId("59e523bf1e4fa3000702ae74");
		wfRuleTimecardAD.setTimecardStartDate(DateUtils.getDateInFormat("Sat Mar 16 16:00:00 IST 2019"));
		wfRuleTimecardAD.setTimecardEndDate(DateUtils.getDateInFormat("Sat Mar 16 19:00:00 IST 2019"));
		wfRuleTimecardAD.setPayRate(10);
		wfRuleTimecardAD.setEmpId("56a8fde4d53590000a00009d");
		wfRuleTimecardAD.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfRuleTimecardAD.setLocationId("l3");
		wfRuleTimecardAD.setDurationInSeconds(32400);
		wfRuleTimecardAD.setBreaks(1000 * 60 * 30);
		weekTimecards.add(wfRuleTimecardAD);

		LaborCostRequestDTO wfCostRequestDTOC = new LaborCostRequestDTO();
		wfCostRequestDTOC.setShiftId("59e523bf1e4fa3000702ae74");
		wfCostRequestDTOC.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 16 16:00:00 IST 2019"));
		wfCostRequestDTOC.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 16 19:00:00 IST 2019"));
		wfCostRequestDTOC.setPayRate(10);
		wfCostRequestDTOC.setEmpId("56a8fde4d53590000a00009d");
		wfCostRequestDTOC.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfCostRequestDTOC.setLocationId("l3");
		wfCostRequestDTOC.setWorkWeek(1);
		wfCostRequestDTOC.setDurationInSeconds(32400);
		wfCostRequestDTOC.setBreaks(1000 * 60 * 30);
		wfCostRequestDTOC.setWeekTimecards(weekTimecards);
		return wfCostRequestDTOC;
	}

	public static LaborCostRequestDTO getRuleDataVerifiedForDayWithSOH() throws ParseException {
		// Not Verified for #HOURS_WORKED_DAY > 8 with SOH
		List<LaborCostRequestDTO> weekTimecards = new ArrayList<>();
		LaborCostRequestDTO wfRuleTimecardAP = new LaborCostRequestDTO();
		wfRuleTimecardAP.setShiftId("59e523bf1e4fa3000702ae70");
		wfRuleTimecardAP.setTimecardStartDate(DateUtils.getDateInFormat("Mon Mar 11 09:00:00 IST 2019"));
		wfRuleTimecardAP.setTimecardEndDate(DateUtils.getDateInFormat("Mon Mar 11 12:00:00 IST 2019"));
		wfRuleTimecardAP.setPayRate(10);
		wfRuleTimecardAP.setEmpId("56a8fde4d53590000a00009d");
		wfRuleTimecardAP.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfRuleTimecardAP.setLocationId("l3");
		wfRuleTimecardAP.setDurationInSeconds(32400);
		weekTimecards.add(wfRuleTimecardAP);

		LaborCostRequestDTO wfRuleTimecardAF = new LaborCostRequestDTO();
		wfRuleTimecardAF.setShiftId("59e523bf1e4fa3000702ae70");
		wfRuleTimecardAF.setTimecardStartDate(DateUtils.getDateInFormat("Mon Mar 11 12:00:00 IST 2019"));
		wfRuleTimecardAF.setTimecardEndDate(DateUtils.getDateInFormat("Mon Mar 11 13:00:00 IST 2019"));
		wfRuleTimecardAF.setPayRate(10);
		wfRuleTimecardAF.setEmpId("56a8fde4d53590000a00009d");
		wfRuleTimecardAF.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfRuleTimecardAF.setLocationId("l3");
		wfRuleTimecardAF.setDurationInSeconds(32400);
		weekTimecards.add(wfRuleTimecardAF);

		LaborCostRequestDTO wfRuleTimecardAG = new LaborCostRequestDTO();
		wfRuleTimecardAG.setShiftId("59e523bf1e4fa3000702ae71");
		wfRuleTimecardAG.setTimecardStartDate(DateUtils.getDateInFormat("Tue Mar 12 09:00:00 IST 2019"));
		wfRuleTimecardAG.setTimecardEndDate(DateUtils.getDateInFormat("Tue Mar 12 15:00:00 IST 2019"));
		wfRuleTimecardAG.setPayRate(10);
		wfRuleTimecardAG.setEmpId("56a8fde4d53590000a00009d");
		wfRuleTimecardAG.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfRuleTimecardAG.setLocationId("l3");
		wfRuleTimecardAG.setDurationInSeconds(32400);
		weekTimecards.add(wfRuleTimecardAG);

		LaborCostRequestDTO wfRuleTimecardAI = new LaborCostRequestDTO();
		wfRuleTimecardAI.setShiftId("59e523bf1e4fa3000702ae72");
		wfRuleTimecardAI.setTimecardStartDate(DateUtils.getDateInFormat("Wed Mar 13 09:00:00 IST 2019"));
		wfRuleTimecardAI.setTimecardEndDate(DateUtils.getDateInFormat("Wed Mar 13 16:00:00 IST 2019"));
		wfRuleTimecardAI.setPayRate(10);
		wfRuleTimecardAI.setEmpId("56a8fde4d53590000a00009d");
		wfRuleTimecardAI.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfRuleTimecardAI.setLocationId("l3");
		wfRuleTimecardAI.setDurationInSeconds(32400);
		weekTimecards.add(wfRuleTimecardAI);

		LaborCostRequestDTO wfRuleTimecardAJ = new LaborCostRequestDTO();
		wfRuleTimecardAJ.setShiftId("59e523bf1e4fa3000702ae73");
		wfRuleTimecardAJ.setTimecardStartDate(DateUtils.getDateInFormat("Thu Mar 14 09:00:00 IST 2019"));
		wfRuleTimecardAJ.setTimecardEndDate(DateUtils.getDateInFormat("Thu Mar 14 14:00:00 IST 2019"));
		wfRuleTimecardAJ.setPayRate(10);
		wfRuleTimecardAJ.setEmpId("56a8fde4d53590000a00009d");
		wfRuleTimecardAJ.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfRuleTimecardAJ.setLocationId("l3");
		wfRuleTimecardAJ.setDurationInSeconds(32400);
		weekTimecards.add(wfRuleTimecardAJ);

		LaborCostRequestDTO wfRuleTimecardAK = new LaborCostRequestDTO();
		wfRuleTimecardAK.setShiftId("59e523bf1e4fa3000702ae74");
		wfRuleTimecardAK.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 09:00:00 IST 2019"));
		wfRuleTimecardAK.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 12:00:00 IST 2019"));
		wfRuleTimecardAK.setPayRate(10);
		wfRuleTimecardAK.setEmpId("56a8fde4d53590000a00009d");
		wfRuleTimecardAK.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfRuleTimecardAK.setLocationId("l3");
		wfRuleTimecardAK.setDurationInSeconds(32400);
		weekTimecards.add(wfRuleTimecardAK);

		LaborCostRequestDTO wfRuleTimecardAL = new LaborCostRequestDTO();
		wfRuleTimecardAL.setShiftId("59e523bf1e4fa3000702ae74");
		wfRuleTimecardAL.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 13:00:00 IST 2019"));
		wfRuleTimecardAL.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 16:00:00 IST 2019"));
		wfRuleTimecardAL.setPayRate(10);
		wfRuleTimecardAL.setEmpId("56a8fde4d53590000a00009d");
		wfRuleTimecardAL.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfRuleTimecardAL.setLocationId("l3");
		wfRuleTimecardAL.setDurationInSeconds(32400);
		weekTimecards.add(wfRuleTimecardAL);

		LaborCostRequestDTO wfRuleTimecardAM = new LaborCostRequestDTO();
		wfRuleTimecardAM.setShiftId("59e523bf1e4fa3000702ae74");
		wfRuleTimecardAM.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 16:00:00 IST 2019"));
		wfRuleTimecardAM.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 19:00:00 IST 2019"));
		wfRuleTimecardAM.setPayRate(10);
		wfRuleTimecardAM.setEmpId("56a8fde4d53590000a00009d");
		wfRuleTimecardAM.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfRuleTimecardAM.setLocationId("l3");
		wfRuleTimecardAM.setDurationInSeconds(32400);
		weekTimecards.add(wfRuleTimecardAM);

		LaborCostRequestDTO wfRuleTimecardAN = new LaborCostRequestDTO();
		wfRuleTimecardAN.setShiftId("59e523bf1e4fa3000702ae74");
		wfRuleTimecardAN.setTimecardStartDate(DateUtils.getDateInFormat("Sat Mar 16 09:00:00 IST 2019"));
		wfRuleTimecardAN.setTimecardEndDate(DateUtils.getDateInFormat("Sat Mar 16 16:00:00 IST 2019"));
		wfRuleTimecardAN.setPayRate(10);
		wfRuleTimecardAN.setEmpId("56a8fde4d53590000a00009d");
		wfRuleTimecardAN.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfRuleTimecardAN.setLocationId("l3");
		wfRuleTimecardAN.setDurationInSeconds(32400);
		weekTimecards.add(wfRuleTimecardAN);

		LaborCostRequestDTO wfRuleTimecardAO = new LaborCostRequestDTO();
		wfRuleTimecardAO.setShiftId("59e523bf1e4fa3000702ae74");
		wfRuleTimecardAO.setTimecardStartDate(DateUtils.getDateInFormat("Sat Mar 16 16:00:00 IST 2019"));
		wfRuleTimecardAO.setTimecardEndDate(DateUtils.getDateInFormat("Sat Mar 16 19:30:00 IST 2019"));
		wfRuleTimecardAO.setPayRate(10);
		wfRuleTimecardAO.setEmpId("56a8fde4d53590000a00009d");
		wfRuleTimecardAO.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfRuleTimecardAO.setLocationId("l3");
		wfRuleTimecardAO.setDurationInSeconds(32400);
		weekTimecards.add(wfRuleTimecardAO);

		LaborCostRequestDTO wfCostRequestDTOD = new LaborCostRequestDTO();
		wfCostRequestDTOD.setShiftId("59e523bf1e4fa3000702ae74");
		wfCostRequestDTOD.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 16 16:00:00 IST 2019"));
		wfCostRequestDTOD.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 16 19:30:00 IST 2019"));
		wfCostRequestDTOD.setPayRate(10);
		wfCostRequestDTOD.setEmpId("56a8fde4d53590000a00009d");
		wfCostRequestDTOD.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfCostRequestDTOD.setLocationId("l3");
		wfCostRequestDTOD.setWorkWeek(1);
		wfCostRequestDTOD.setDurationInSeconds(32400);
		wfCostRequestDTOD.setWeekTimecards(weekTimecards);
		return wfCostRequestDTOD;
	}

	public static LaborCostRequestDTO getRuleDataVerifiedForFullDay() throws ParseException {
		// Verified for #HOURS_WORKED_DAY > 8 with SOH
		List<LaborCostRequestDTO> weekTimecards = new ArrayList<>();
		LaborCostRequestDTO wfRuleTimecardAR = new LaborCostRequestDTO();
		wfRuleTimecardAR.setShiftId("59e523bf1e4fa3000702ae70");
		wfRuleTimecardAR.setTimecardStartDate(DateUtils.getDateInFormat("Mon Mar 11 09:00:00 IST 2019"));
		wfRuleTimecardAR.setTimecardEndDate(DateUtils.getDateInFormat("Mon Mar 11 12:00:00 IST 2019"));
		wfRuleTimecardAR.setPayRate(10);
		wfRuleTimecardAR.setEmpId("56a8fde4d53590000a00009d");
		wfRuleTimecardAR.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfRuleTimecardAR.setLocationId("l3");
		wfRuleTimecardAR.setDurationInSeconds(32400);
		weekTimecards.add(wfRuleTimecardAR);

		LaborCostRequestDTO wfRuleTimecardAS = new LaborCostRequestDTO();
		wfRuleTimecardAS.setShiftId("59e523bf1e4fa3000702ae70");
		wfRuleTimecardAS.setTimecardStartDate(DateUtils.getDateInFormat("Mon Mar 11 12:00:00 IST 2019"));
		wfRuleTimecardAS.setTimecardEndDate(DateUtils.getDateInFormat("Mon Mar 11 13:00:00 IST 2019"));
		wfRuleTimecardAS.setPayRate(10);
		wfRuleTimecardAS.setEmpId("56a8fde4d53590000a00009d");
		wfRuleTimecardAS.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfRuleTimecardAS.setLocationId("l3");
		wfRuleTimecardAS.setDurationInSeconds(32400);
		weekTimecards.add(wfRuleTimecardAS);

		LaborCostRequestDTO wfRuleTimecardAAA = new LaborCostRequestDTO();
		wfRuleTimecardAAA.setShiftId("59e523bf1e4fa3000702ae71");
		wfRuleTimecardAAA.setTimecardStartDate(DateUtils.getDateInFormat("Tue Mar 12 09:00:00 IST 2019"));
		wfRuleTimecardAAA.setTimecardEndDate(DateUtils.getDateInFormat("Tue Mar 12 15:00:00 IST 2019"));
		wfRuleTimecardAAA.setPayRate(10);
		wfRuleTimecardAAA.setEmpId("56a8fde4d53590000a00009d");
		wfRuleTimecardAAA.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfRuleTimecardAAA.setLocationId("l3");
		wfRuleTimecardAAA.setDurationInSeconds(32400);
		weekTimecards.add(wfRuleTimecardAAA);

		LaborCostRequestDTO wfRuleTimecardAT = new LaborCostRequestDTO();
		wfRuleTimecardAT.setShiftId("59e523bf1e4fa3000702ae72");
		wfRuleTimecardAT.setTimecardStartDate(DateUtils.getDateInFormat("Wed Mar 13 09:00:00 IST 2019"));
		wfRuleTimecardAT.setTimecardEndDate(DateUtils.getDateInFormat("Wed Mar 13 16:00:00 IST 2019"));
		wfRuleTimecardAT.setPayRate(10);
		wfRuleTimecardAT.setEmpId("56a8fde4d53590000a00009d");
		wfRuleTimecardAT.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfRuleTimecardAT.setLocationId("l3");
		wfRuleTimecardAT.setDurationInSeconds(32400);
		weekTimecards.add(wfRuleTimecardAT);

		LaborCostRequestDTO wfRuleTimecardAU = new LaborCostRequestDTO();
		wfRuleTimecardAU.setShiftId("59e523bf1e4fa3000702ae73");
		wfRuleTimecardAU.setTimecardStartDate(DateUtils.getDateInFormat("Thu Mar 14 09:00:00 IST 2019"));
		wfRuleTimecardAU.setTimecardEndDate(DateUtils.getDateInFormat("Thu Mar 14 14:00:00 IST 2019"));
		wfRuleTimecardAU.setPayRate(10);
		wfRuleTimecardAU.setEmpId("56a8fde4d53590000a00009d");
		wfRuleTimecardAU.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfRuleTimecardAU.setLocationId("l3");
		wfRuleTimecardAU.setDurationInSeconds(32400);
		weekTimecards.add(wfRuleTimecardAU);

		LaborCostRequestDTO wfRuleTimecardAV = new LaborCostRequestDTO();
		wfRuleTimecardAV.setShiftId("59e523bf1e4fa3000702ae74");
		wfRuleTimecardAV.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 09:00:00 IST 2019"));
		wfRuleTimecardAV.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 12:00:00 IST 2019"));
		wfRuleTimecardAV.setPayRate(10);
		wfRuleTimecardAV.setEmpId("56a8fde4d53590000a00009d");
		wfRuleTimecardAV.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfRuleTimecardAV.setLocationId("l3");
		wfRuleTimecardAV.setDurationInSeconds(32400);
		weekTimecards.add(wfRuleTimecardAV);

		LaborCostRequestDTO wfRuleTimecardAW = new LaborCostRequestDTO();
		wfRuleTimecardAW.setShiftId("59e523bf1e4fa3000702ae74");
		wfRuleTimecardAW.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 13:00:00 IST 2019"));
		wfRuleTimecardAW.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 16:00:00 IST 2019"));
		wfRuleTimecardAW.setPayRate(10);
		wfRuleTimecardAW.setEmpId("56a8fde4d53590000a00009d");
		wfRuleTimecardAW.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfRuleTimecardAW.setLocationId("l3");
		wfRuleTimecardAW.setDurationInSeconds(32400);
		weekTimecards.add(wfRuleTimecardAW);

		LaborCostRequestDTO wfRuleTimecardAX = new LaborCostRequestDTO();
		wfRuleTimecardAX.setShiftId("59e523bf1e4fa3000702ae74");
		wfRuleTimecardAX.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 16:00:00 IST 2019"));
		wfRuleTimecardAX.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 19:00:00 IST 2019"));
		wfRuleTimecardAX.setPayRate(10);
		wfRuleTimecardAX.setEmpId("56a8fde4d53590000a00009d");
		wfRuleTimecardAX.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfRuleTimecardAX.setLocationId("l3");
		wfRuleTimecardAX.setDurationInSeconds(32400);
		weekTimecards.add(wfRuleTimecardAX);

		LaborCostRequestDTO wfRuleTimecardAY = new LaborCostRequestDTO();
		wfRuleTimecardAY.setShiftId("59e523bf1e4fa3000702ae74");
		wfRuleTimecardAY.setTimecardStartDate(DateUtils.getDateInFormat("Sat Mar 16 09:00:00 IST 2019"));
		wfRuleTimecardAY.setTimecardEndDate(DateUtils.getDateInFormat("Sat Mar 16 16:00:00 IST 2019"));
		wfRuleTimecardAY.setPayRate(10);
		wfRuleTimecardAY.setEmpId("56a8fde4d53590000a00009d");
		wfRuleTimecardAY.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfRuleTimecardAY.setLocationId("l3");
		wfRuleTimecardAY.setDurationInSeconds(32400);
		weekTimecards.add(wfRuleTimecardAY);

		LaborCostRequestDTO wfRuleTimecardAZ = new LaborCostRequestDTO();
		wfRuleTimecardAZ.setShiftId("59e523bf1e4fa3000702ae74");
		wfRuleTimecardAZ.setTimecardStartDate(DateUtils.getDateInFormat("Sat Mar 16 16:00:00 IST 2019"));
		wfRuleTimecardAZ.setTimecardEndDate(DateUtils.getDateInFormat("Sat Mar 16 24:00:00 IST 2019"));
		wfRuleTimecardAZ.setPayRate(10);
		wfRuleTimecardAZ.setEmpId("56a8fde4d53590000a00009d");
		wfRuleTimecardAZ.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfRuleTimecardAZ.setLocationId("l3");
		wfRuleTimecardAZ.setDurationInSeconds(32400);
		weekTimecards.add(wfRuleTimecardAZ);

		LaborCostRequestDTO wfCostRequestDTOF = new LaborCostRequestDTO();
		wfCostRequestDTOF.setShiftId("59e523bf1e4fa3000702ae74");
		wfCostRequestDTOF.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 16 16:00:00 IST 2019"));
		wfCostRequestDTOF.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 16 24:00:00 IST 2019"));
		wfCostRequestDTOF.setPayRate(10);
		wfCostRequestDTOF.setEmpId("56a8fde4d53590000a00009d");
		wfCostRequestDTOF.setEmpPositionId("56ab9c41cf8b48000a00001e");
		wfCostRequestDTOF.setLocationId("l3");
		wfCostRequestDTOF.setWorkWeek(1);
		wfCostRequestDTOF.setDurationInSeconds(32400);
		wfCostRequestDTOF.setWeekTimecards(weekTimecards);
		return wfCostRequestDTOF;
	}
}

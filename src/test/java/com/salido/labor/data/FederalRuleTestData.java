package com.salido.labor.data;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.salido.labor.dto.LaborCostRequestDTO;
import com.salido.labor.util.DateUtils;

public class FederalRuleTestData {
	private FederalRuleTestData() {
		super();
	}
	// For Federal Overtime Rule

	public static LaborCostRequestDTO getRuleDataNotVerified() throws ParseException {
		// Not Verified
		List<LaborCostRequestDTO> weekTimecards = new ArrayList<>();

		LaborCostRequestDTO fRuleTimecardA = new LaborCostRequestDTO();
		fRuleTimecardA.setShiftId("59e523bf1e4fa3000702ae70");
		fRuleTimecardA.setTimecardStartDate(DateUtils.getDateInFormat("Mon Mar 11 09:00:00 IST 2019"));
		fRuleTimecardA.setTimecardEndDate(DateUtils.getDateInFormat("Mon Mar 11 12:30:00 IST 2019"));
		fRuleTimecardA.setPayRate(10);
		fRuleTimecardA.setEmpId("56a8fde4d53590000a00009d");
		fRuleTimecardA.setEmpPositionId("56ab9c41cf8b48000a00001e");
		fRuleTimecardA.setLocationId("l1");
		fRuleTimecardA.setDurationInSeconds(32400);
		fRuleTimecardA.setBreaks(1000 * 60 * 30);
		weekTimecards.add(fRuleTimecardA);

		LaborCostRequestDTO fRuleTimecardB = new LaborCostRequestDTO();
		fRuleTimecardB.setShiftId("59e523bf1e4fa3000702ae70");
		fRuleTimecardB.setTimecardStartDate(DateUtils.getDateInFormat("Mon Mar 11 12:30:00 IST 2019"));
		fRuleTimecardB.setTimecardEndDate(DateUtils.getDateInFormat("Mon Mar 11 15:00:00 IST 2019"));
		fRuleTimecardB.setPayRate(10);
		fRuleTimecardB.setEmpId("56a8fde4d53590000a00009d");
		fRuleTimecardB.setEmpPositionId("56ab9c41cf8b48000a00001e");
		fRuleTimecardB.setLocationId("l1");
		fRuleTimecardB.setDurationInSeconds(32400);
		fRuleTimecardB.setBreaks(1000 * 60 * 30);
		weekTimecards.add(fRuleTimecardB);

		LaborCostRequestDTO fRuleTimecardC = new LaborCostRequestDTO();
		fRuleTimecardC.setShiftId("59e523bf1e4fa3000702ae71");
		fRuleTimecardC.setTimecardStartDate(DateUtils.getDateInFormat("Tue Mar 12 09:00:00 IST 2019"));
		fRuleTimecardC.setTimecardEndDate(DateUtils.getDateInFormat("Tue Mar 12 16:00:00 IST 2019"));
		fRuleTimecardC.setPayRate(10);
		fRuleTimecardC.setEmpId("56a8fde4d53590000a00009d");
		fRuleTimecardC.setEmpPositionId("56ab9c41cf8b48000a00001e");
		fRuleTimecardC.setLocationId("l1");
		fRuleTimecardC.setDurationInSeconds(32400);
		fRuleTimecardC.setBreaks(1000 * 60 * 30);
		weekTimecards.add(fRuleTimecardC);

		LaborCostRequestDTO fRuleTimecardD = new LaborCostRequestDTO();
		fRuleTimecardD.setShiftId("59e523bf1e4fa3000702ae72");
		fRuleTimecardD.setTimecardStartDate(DateUtils.getDateInFormat("Wed Mar 13 09:00:00 IST 2019"));
		fRuleTimecardD.setTimecardEndDate(DateUtils.getDateInFormat("Wed Mar 13 15:00:00 IST 2019"));
		fRuleTimecardD.setPayRate(10);
		fRuleTimecardD.setEmpId("56a8fde4d53590000a00009d");
		fRuleTimecardD.setEmpPositionId("56ab9c41cf8b48000a00001e");
		fRuleTimecardD.setLocationId("l1");
		fRuleTimecardD.setDurationInSeconds(32400);
		fRuleTimecardD.setBreaks(1000 * 60 * 30);
		weekTimecards.add(fRuleTimecardD);

		LaborCostRequestDTO fRuleTimecardE = new LaborCostRequestDTO();
		fRuleTimecardE.setShiftId("59e523bf1e4fa3000702ae73");
		fRuleTimecardE.setTimecardStartDate(DateUtils.getDateInFormat("Thu Mar 14 09:00:00 IST 2019"));
		fRuleTimecardE.setTimecardEndDate(DateUtils.getDateInFormat("Thu Mar 14 16:00:00 IST 2019"));
		fRuleTimecardE.setPayRate(10);
		fRuleTimecardE.setEmpId("56a8fde4d53590000a00009d");
		fRuleTimecardE.setEmpPositionId("56ab9c41cf8b48000a00001e");
		fRuleTimecardE.setLocationId("l1");
		fRuleTimecardE.setDurationInSeconds(32400);
		fRuleTimecardE.setBreaks(1000 * 60 * 30);
		weekTimecards.add(fRuleTimecardE);

		LaborCostRequestDTO fRuleTimecardF = new LaborCostRequestDTO();
		fRuleTimecardF.setShiftId("59e523bf1e4fa3000702ae74");
		fRuleTimecardF.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 09:00:00 IST 2019"));
		fRuleTimecardF.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 15:00:00 IST 2019"));
		fRuleTimecardF.setPayRate(10);
		fRuleTimecardF.setEmpId("56a8fde4d53590000a00009d");
		fRuleTimecardF.setEmpPositionId("56ab9c41cf8b48000a00001e");
		fRuleTimecardF.setLocationId("l1");
		fRuleTimecardF.setDurationInSeconds(32400);
		fRuleTimecardF.setBreaks(1000 * 60 * 30);
		weekTimecards.add(fRuleTimecardF);

		LaborCostRequestDTO fRuleTimecardG = new LaborCostRequestDTO();
		fRuleTimecardG.setShiftId("59e523bf1e4fa3000702ae74");
		fRuleTimecardG.setTimecardStartDate(DateUtils.getDateInFormat("Sat Mar 16 09:00:00 IST 2019"));
		fRuleTimecardG.setTimecardEndDate(DateUtils.getDateInFormat("Sat Mar 16 11:00:00 IST 2019"));
		fRuleTimecardG.setPayRate(10);
		fRuleTimecardG.setEmpId("56a8fde4d53590000a00009d");
		fRuleTimecardG.setEmpPositionId("56ab9c41cf8b48000a00001e");
		fRuleTimecardG.setLocationId("l1");
		fRuleTimecardG.setDurationInSeconds(32400);
		fRuleTimecardG.setBreaks(1000 * 60 * 30);
		weekTimecards.add(fRuleTimecardG);

		LaborCostRequestDTO fRuleTimecardH = new LaborCostRequestDTO();
		fRuleTimecardH.setShiftId("59e523bf1e4fa3000702ae74");
		fRuleTimecardH.setTimecardStartDate(DateUtils.getDateInFormat("Sat Mar 16 11:00:00 IST 2019"));
		fRuleTimecardH.setTimecardEndDate(DateUtils.getDateInFormat("Sat Mar 16 12:30:00 IST 2019"));
		fRuleTimecardH.setPayRate(10);
		fRuleTimecardH.setEmpId("56a8fde4d53590000a00009d");
		fRuleTimecardH.setEmpPositionId("56ab9c41cf8b48000a00001e");
		fRuleTimecardH.setLocationId("l1");
		fRuleTimecardH.setDurationInSeconds(32400);
		fRuleTimecardH.setBreaks(1000 * 60 * 30);
		weekTimecards.add(fRuleTimecardH);

		LaborCostRequestDTO fRuleCostRequestDTOA = new LaborCostRequestDTO();
		fRuleCostRequestDTOA.setShiftId("59e523bf1e4fa3000702ae74");
		fRuleCostRequestDTOA.setTimecardStartDate(DateUtils.getDateInFormat("Sat Mar 16 11:00:00 IST 2019"));
		fRuleCostRequestDTOA.setTimecardEndDate(DateUtils.getDateInFormat("Sat Mar 16 12:30:00 IST 2019"));
		fRuleCostRequestDTOA.setPayRate(10);
		fRuleCostRequestDTOA.setEmpId("56a8fde4d53590000a00009d");
		fRuleCostRequestDTOA.setEmpPositionId("56ab9c41cf8b48000a00001e");
		fRuleCostRequestDTOA.setLocationId("l1");
		fRuleCostRequestDTOA.setWorkWeek(1);
		fRuleCostRequestDTOA.setDurationInSeconds(32400);
		fRuleCostRequestDTOA.setBreaks(1000 * 60 * 30);
		fRuleCostRequestDTOA.setWeekTimecards(weekTimecards);
		return fRuleCostRequestDTOA;
	}

	public static LaborCostRequestDTO getRuleDataVerified() throws ParseException {
		// For Federal Overtime Rule Verified
		List<LaborCostRequestDTO> weekTimecards = new ArrayList<>();

		LaborCostRequestDTO fRuleTimecardI = new LaborCostRequestDTO();
		fRuleTimecardI.setShiftId("59e523bf1e4fa3000702ae70");
		fRuleTimecardI.setTimecardStartDate(DateUtils.getDateInFormat("Mon Mar 11 09:00:00 IST 2019"));
		fRuleTimecardI.setTimecardEndDate(DateUtils.getDateInFormat("Mon Mar 11 12:30:00 IST 2019"));
		fRuleTimecardI.setPayRate(10);
		fRuleTimecardI.setEmpId("56a8fde4d53590000a00009d");
		fRuleTimecardI.setEmpPositionId("56ab9c41cf8b48000a00001e");
		fRuleTimecardI.setLocationId("l1");
		fRuleTimecardI.setDurationInSeconds(32400);
		weekTimecards.add(fRuleTimecardI);

		LaborCostRequestDTO fRuleTimecardJ = new LaborCostRequestDTO();
		fRuleTimecardJ.setShiftId("59e523bf1e4fa3000702ae70");
		fRuleTimecardJ.setTimecardStartDate(DateUtils.getDateInFormat("Mon Mar 11 12:30:00 IST 2019"));
		fRuleTimecardJ.setTimecardEndDate(DateUtils.getDateInFormat("Mon Mar 11 15:00:00 IST 2019"));
		fRuleTimecardJ.setPayRate(10);
		fRuleTimecardJ.setEmpId("56a8fde4d53590000a00009d");
		fRuleTimecardJ.setEmpPositionId("56ab9c41cf8b48000a00001e");
		fRuleTimecardJ.setLocationId("l1");
		fRuleTimecardJ.setDurationInSeconds(32400);
		weekTimecards.add(fRuleTimecardJ);

		LaborCostRequestDTO fRuleTimecardK = new LaborCostRequestDTO();
		fRuleTimecardK.setShiftId("59e523bf1e4fa3000702ae70");
		fRuleTimecardK.setTimecardStartDate(DateUtils.getDateInFormat("Mon Mar 11 15:00:00 IST 2019"));
		fRuleTimecardK.setTimecardEndDate(DateUtils.getDateInFormat("Mon Mar 11 18:00:00 IST 2019"));
		fRuleTimecardK.setPayRate(10);
		fRuleTimecardK.setEmpId("56a8fde4d53590000a00009d");
		fRuleTimecardK.setEmpPositionId("56ab9c41cf8b48000a00001e");
		fRuleTimecardK.setLocationId("l1");
		fRuleTimecardK.setDurationInSeconds(32400);
		fRuleTimecardK.setBreaks(1000 * 60 * 30);
		weekTimecards.add(fRuleTimecardK);

		LaborCostRequestDTO fRuleTimecardL = new LaborCostRequestDTO();
		fRuleTimecardL.setShiftId("59e523bf1e4fa3000702ae71");
		fRuleTimecardL.setTimecardStartDate(DateUtils.getDateInFormat("Tue Mar 12 09:00:00 IST 2019"));
		fRuleTimecardL.setTimecardEndDate(DateUtils.getDateInFormat("Tue Mar 12 13:00:00 IST 2019"));
		fRuleTimecardL.setPayRate(10);
		fRuleTimecardL.setEmpId("56a8fde4d53590000a00009d");
		fRuleTimecardL.setEmpPositionId("56ab9c41cf8b48000a00001e");
		fRuleTimecardL.setLocationId("l1");
		fRuleTimecardL.setDurationInSeconds(32400);
		fRuleTimecardL.setBreaks(1000 * 60 * 30);
		weekTimecards.add(fRuleTimecardL);

		LaborCostRequestDTO fRuleTimecardM = new LaborCostRequestDTO();
		fRuleTimecardM.setShiftId("59e523bf1e4fa3000702ae72");
		fRuleTimecardM.setTimecardStartDate(DateUtils.getDateInFormat("Wed Mar 13 09:00:00 IST 2019"));
		fRuleTimecardM.setTimecardEndDate(DateUtils.getDateInFormat("Wed Mar 13 13:00:00 IST 2019"));
		fRuleTimecardM.setPayRate(10);
		fRuleTimecardM.setEmpId("56a8fde4d53590000a00009d");
		fRuleTimecardM.setEmpPositionId("56ab9c41cf8b48000a00001e");
		fRuleTimecardM.setLocationId("l1");
		fRuleTimecardM.setDurationInSeconds(32400);
		fRuleTimecardM.setBreaks(1000 * 60 * 30);
		weekTimecards.add(fRuleTimecardM);

		LaborCostRequestDTO fRuleTimecardN = new LaborCostRequestDTO();
		fRuleTimecardN.setShiftId("59e523bf1e4fa3000702ae73");
		fRuleTimecardN.setTimecardStartDate(DateUtils.getDateInFormat("Thu Mar 14 09:00:00 IST 2019"));
		fRuleTimecardN.setTimecardEndDate(DateUtils.getDateInFormat("Thu Mar 14 18:00:00 IST 2019"));
		fRuleTimecardN.setPayRate(10);
		fRuleTimecardN.setEmpId("56a8fde4d53590000a00009d");
		fRuleTimecardN.setEmpPositionId("56ab9c41cf8b48000a00001e");
		fRuleTimecardN.setLocationId("l1");
		fRuleTimecardN.setDurationInSeconds(32400);
		fRuleTimecardN.setBreaks(1000 * 60 * 30);
		weekTimecards.add(fRuleTimecardN);

		LaborCostRequestDTO fRuleTimecardO = new LaborCostRequestDTO();
		fRuleTimecardO.setShiftId("59e523bf1e4fa3000702ae74");
		fRuleTimecardO.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 09:00:00 IST 2019"));
		fRuleTimecardO.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 18:00:00 IST 2019"));
		fRuleTimecardO.setPayRate(10);
		fRuleTimecardO.setEmpId("56a8fde4d53590000a00009d");
		fRuleTimecardO.setEmpPositionId("56ab9c41cf8b48000a00001e");
		fRuleTimecardO.setLocationId("l1");
		fRuleTimecardO.setDurationInSeconds(32400);
		fRuleTimecardO.setBreaks(1000 * 60 * 30);
		weekTimecards.add(fRuleTimecardO);

		LaborCostRequestDTO fRuleTimecardP = new LaborCostRequestDTO();
		fRuleTimecardP.setShiftId("59e523bf1e4fa3000702ae74");
		fRuleTimecardP.setTimecardStartDate(DateUtils.getDateInFormat("Sat Mar 16 09:00:00 IST 2019"));
		fRuleTimecardP.setTimecardEndDate(DateUtils.getDateInFormat("Sat Mar 16 14:00:00 IST 2019"));
		fRuleTimecardP.setPayRate(10);
		fRuleTimecardP.setEmpId("56a8fde4d53590000a00009d");
		fRuleTimecardP.setEmpPositionId("56ab9c41cf8b48000a00001e");
		fRuleTimecardP.setLocationId("l1");
		fRuleTimecardP.setDurationInSeconds(32400);
		fRuleTimecardP.setBreaks(1000 * 60 * 30);
		weekTimecards.add(fRuleTimecardP);

		LaborCostRequestDTO fRuleTimecardQ = new LaborCostRequestDTO();
		fRuleTimecardQ.setShiftId("59e523bf1e4fa3000702ae74");
		fRuleTimecardQ.setTimecardStartDate(DateUtils.getDateInFormat("Sat Mar 16 14:00:00 IST 2019"));
		fRuleTimecardQ.setTimecardEndDate(DateUtils.getDateInFormat("Sat Mar 16 18:30:00 IST 2019"));
		fRuleTimecardQ.setPayRate(10);
		fRuleTimecardQ.setEmpId("56a8fde4d53590000a00009d");
		fRuleTimecardQ.setEmpPositionId("56ab9c41cf8b48000a00001e");
		fRuleTimecardQ.setLocationId("l1");
		fRuleTimecardQ.setDurationInSeconds(32400);
		fRuleTimecardQ.setBreaks(1000 * 60 * 30);
		weekTimecards.add(fRuleTimecardQ);

		LaborCostRequestDTO fRuleCostRequestDTOB = new LaborCostRequestDTO();
		fRuleCostRequestDTOB.setShiftId("59e523bf1e4fa3000702ae74");
		fRuleCostRequestDTOB.setTimecardStartDate(DateUtils.getDateInFormat("Sat Mar 16 14:00:00 IST 2019"));
		fRuleCostRequestDTOB.setTimecardEndDate(DateUtils.getDateInFormat("Sat Mar 16 18:30:00 IST 2019"));
		fRuleCostRequestDTOB.setPayRate(10);
		fRuleCostRequestDTOB.setEmpId("56a8fde4d53590000a00009d");
		fRuleCostRequestDTOB.setEmpPositionId("56ab9c41cf8b48000a00001e");
		fRuleCostRequestDTOB.setLocationId("l1");
		fRuleCostRequestDTOB.setWorkWeek(1);
		fRuleCostRequestDTOB.setDurationInSeconds(32400);
		fRuleCostRequestDTOB.setBreaks(1000 * 60 * 30);
		fRuleCostRequestDTOB.setWeekTimecards(weekTimecards);
		return fRuleCostRequestDTOB;
	}

	public static LaborCostRequestDTO getRuleDataVerifiedWithSOH() throws ParseException {
		// For Federal Overtime Rule Verified with SOH
		List<LaborCostRequestDTO> weekTimecards = new ArrayList<>();

		LaborCostRequestDTO fRuleTimecardR = new LaborCostRequestDTO();
		fRuleTimecardR.setShiftId("59e523bf1e4fa3000702ae70");
		fRuleTimecardR.setTimecardStartDate(DateUtils.getDateInFormat("Mon Mar 11 09:00:00 IST 2019"));
		fRuleTimecardR.setTimecardEndDate(DateUtils.getDateInFormat("Mon Mar 11 12:30:00 IST 2019"));
		fRuleTimecardR.setPayRate(10);
		fRuleTimecardR.setEmpId("56a8fde4d53590000a00009d");
		fRuleTimecardR.setEmpPositionId("56ab9c41cf8b48000a00001e");
		fRuleTimecardR.setLocationId("l1");
		fRuleTimecardR.setDurationInSeconds(32400);
		fRuleTimecardR.setBreaks(1000 * 60 * 30);
		weekTimecards.add(fRuleTimecardR);

		LaborCostRequestDTO fRuleTimecardS = new LaborCostRequestDTO();
		fRuleTimecardS.setShiftId("59e523bf1e4fa3000702ae70");
		fRuleTimecardS.setTimecardStartDate(DateUtils.getDateInFormat("Mon Mar 11 12:30:00 IST 2019"));
		fRuleTimecardS.setTimecardEndDate(DateUtils.getDateInFormat("Mon Mar 11 15:00:00 IST 2019"));
		fRuleTimecardS.setPayRate(10);
		fRuleTimecardS.setEmpId("56a8fde4d53590000a00009d");
		fRuleTimecardS.setEmpPositionId("56ab9c41cf8b48000a00001e");
		fRuleTimecardS.setLocationId("l1");
		fRuleTimecardS.setDurationInSeconds(32400);
		fRuleTimecardS.setBreaks(1000 * 60 * 30);
		weekTimecards.add(fRuleTimecardS);

		LaborCostRequestDTO fRuleTimecardT = new LaborCostRequestDTO();
		fRuleTimecardT.setShiftId("59e523bf1e4fa3000702ae70");
		fRuleTimecardT.setTimecardStartDate(DateUtils.getDateInFormat("Mon Mar 11 15:00:00 IST 2019"));
		fRuleTimecardT.setTimecardEndDate(DateUtils.getDateInFormat("Mon Mar 11 18:00:00 IST 2019"));
		fRuleTimecardT.setPayRate(10);
		fRuleTimecardT.setEmpId("56a8fde4d53590000a00009d");
		fRuleTimecardT.setEmpPositionId("56ab9c41cf8b48000a00001e");
		fRuleTimecardT.setLocationId("l1");
		fRuleTimecardT.setDurationInSeconds(32400);
		fRuleTimecardT.setBreaks(1000 * 60 * 30);
		weekTimecards.add(fRuleTimecardT);

		LaborCostRequestDTO fRuleTimecardU = new LaborCostRequestDTO();
		fRuleTimecardU.setShiftId("59e523bf1e4fa3000702ae71");
		fRuleTimecardU.setTimecardStartDate(DateUtils.getDateInFormat("Tue Mar 12 09:00:00 IST 2019"));
		fRuleTimecardU.setTimecardEndDate(DateUtils.getDateInFormat("Tue Mar 12 13:00:00 IST 2019"));
		fRuleTimecardU.setPayRate(10);
		fRuleTimecardU.setEmpId("56a8fde4d53590000a00009d");
		fRuleTimecardU.setEmpPositionId("56ab9c41cf8b48000a00001e");
		fRuleTimecardU.setLocationId("l1");
		fRuleTimecardU.setDurationInSeconds(32400);
		fRuleTimecardU.setBreaks(1000 * 60 * 30);
		weekTimecards.add(fRuleTimecardU);

		LaborCostRequestDTO fRuleTimecardV = new LaborCostRequestDTO();
		fRuleTimecardV.setShiftId("59e523bf1e4fa3000702ae72");
		fRuleTimecardV.setTimecardStartDate(DateUtils.getDateInFormat("Wed Mar 13 09:00:00 IST 2019"));
		fRuleTimecardV.setTimecardEndDate(DateUtils.getDateInFormat("Wed Mar 13 13:00:00 IST 2019"));
		fRuleTimecardV.setPayRate(10);
		fRuleTimecardV.setEmpId("56a8fde4d53590000a00009d");
		fRuleTimecardV.setEmpPositionId("56ab9c41cf8b48000a00001e");
		fRuleTimecardV.setLocationId("l1");
		fRuleTimecardV.setDurationInSeconds(32400);
		fRuleTimecardV.setBreaks(1000 * 60 * 30);
		weekTimecards.add(fRuleTimecardV);

		LaborCostRequestDTO fRuleTimecardW = new LaborCostRequestDTO();
		fRuleTimecardW.setShiftId("59e523bf1e4fa3000702ae73");
		fRuleTimecardW.setTimecardStartDate(DateUtils.getDateInFormat("Thu Mar 14 09:00:00 IST 2019"));
		fRuleTimecardW.setTimecardEndDate(DateUtils.getDateInFormat("Thu Mar 14 18:00:00 IST 2019"));
		fRuleTimecardW.setPayRate(10);
		fRuleTimecardW.setEmpId("56a8fde4d53590000a00009d");
		fRuleTimecardW.setEmpPositionId("56ab9c41cf8b48000a00001e");
		fRuleTimecardW.setLocationId("l1");
		fRuleTimecardW.setDurationInSeconds(32400);
		fRuleTimecardW.setBreaks(1000 * 60 * 30);
		weekTimecards.add(fRuleTimecardW);

		LaborCostRequestDTO fRuleTimecardX = new LaborCostRequestDTO();
		fRuleTimecardX.setShiftId("59e523bf1e4fa3000702ae74");
		fRuleTimecardX.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 09:00:00 IST 2019"));
		fRuleTimecardX.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 18:00:00 IST 2019"));
		fRuleTimecardX.setPayRate(10);
		fRuleTimecardX.setEmpId("56a8fde4d53590000a00009d");
		fRuleTimecardX.setEmpPositionId("56ab9c41cf8b48000a00001e");
		fRuleTimecardX.setLocationId("l1");
		fRuleTimecardX.setDurationInSeconds(32400);
		fRuleTimecardX.setBreaks(1000 * 60 * 30);
		weekTimecards.add(fRuleTimecardX);

		LaborCostRequestDTO fRuleTimecardY = new LaborCostRequestDTO();
		fRuleTimecardY.setShiftId("59e523bf1e4fa3000702ae74");
		fRuleTimecardY.setTimecardStartDate(DateUtils.getDateInFormat("Sat Mar 16 09:00:00 IST 2019"));
		fRuleTimecardY.setTimecardEndDate(DateUtils.getDateInFormat("Sat Mar 16 18:00:00 IST 2019"));
		fRuleTimecardY.setPayRate(10);
		fRuleTimecardY.setEmpId("56a8fde4d53590000a00009d");
		fRuleTimecardY.setEmpPositionId("56ab9c41cf8b48000a00001e");
		fRuleTimecardY.setLocationId("l1");
		fRuleTimecardY.setDurationInSeconds(32400);
		fRuleTimecardY.setBreaks(1000 * 60 * 30);
		weekTimecards.add(fRuleTimecardY);

		LaborCostRequestDTO fRuleTimecardZ = new LaborCostRequestDTO();
		fRuleTimecardZ.setShiftId("59e523bf1e4fa3000702ae74");
		fRuleTimecardZ.setTimecardStartDate(DateUtils.getDateInFormat("Sat Mar 16 18:00:00 IST 2019"));
		fRuleTimecardZ.setTimecardEndDate(DateUtils.getDateInFormat("Sat Mar 16 19:30:00 IST 2019"));
		fRuleTimecardZ.setPayRate(10);
		fRuleTimecardZ.setEmpId("56a8fde4d53590000a00009d");
		fRuleTimecardZ.setEmpPositionId("56ab9c41cf8b48000a00001e");
		fRuleTimecardZ.setLocationId("l1");
		fRuleTimecardZ.setDurationInSeconds(32400);
		fRuleTimecardZ.setBreaks(1000 * 60 * 30);
		weekTimecards.add(fRuleTimecardZ);

		LaborCostRequestDTO fRuleCostRequestDTOC = new LaborCostRequestDTO();
		fRuleCostRequestDTOC.setShiftId("59e523bf1e4fa3000702ae74");
		fRuleCostRequestDTOC.setTimecardStartDate(DateUtils.getDateInFormat("Sat Mar 16 18:00:00 IST 2019"));
		fRuleCostRequestDTOC.setTimecardEndDate(DateUtils.getDateInFormat("Sat Mar 16 19:30:00 IST 2019"));
		fRuleCostRequestDTOC.setPayRate(10);
		fRuleCostRequestDTOC.setEmpId("56a8fde4d53590000a00009d");
		fRuleCostRequestDTOC.setEmpPositionId("56ab9c41cf8b48000a00001e");
		fRuleCostRequestDTOC.setLocationId("l1");
		fRuleCostRequestDTOC.setWorkWeek(1);
		fRuleCostRequestDTOC.setDurationInSeconds(32400);
		fRuleCostRequestDTOC.setBreaks(1000 * 60 * 30);
		fRuleCostRequestDTOC.setWeekTimecards(weekTimecards);
		return fRuleCostRequestDTOC;
	}

	public static LaborCostRequestDTO getRuleDataWithRegAndSOH() throws ParseException {
		// For Federal Overtime Rule Verified with Regular Wage & SOH
		List<LaborCostRequestDTO> weekTimecards = new ArrayList<>();

		LaborCostRequestDTO fRuleTimecardAA = new LaborCostRequestDTO();
		fRuleTimecardAA.setShiftId("59e523bf1e4fa3000702ae70");
		fRuleTimecardAA.setTimecardStartDate(DateUtils.getDateInFormat("Mon Mar 11 09:00:00 IST 2019"));
		fRuleTimecardAA.setTimecardEndDate(DateUtils.getDateInFormat("Mon Mar 11 12:30:00 IST 2019"));
		fRuleTimecardAA.setPayRate(10);
		fRuleTimecardAA.setEmpId("56a8fde4d53590000a00009d");
		fRuleTimecardAA.setEmpPositionId("56ab9c41cf8b48000a00001e");
		fRuleTimecardAA.setLocationId("l1");
		fRuleTimecardAA.setDurationInSeconds(32400);
		weekTimecards.add(fRuleTimecardAA);

		LaborCostRequestDTO fRuleTimecardAB = new LaborCostRequestDTO();
		fRuleTimecardAB.setShiftId("59e523bf1e4fa3000702ae70");
		fRuleTimecardAB.setTimecardStartDate(DateUtils.getDateInFormat("Mon Mar 11 12:30:00 IST 2019"));
		fRuleTimecardAB.setTimecardEndDate(DateUtils.getDateInFormat("Mon Mar 11 15:00:00 IST 2019"));
		fRuleTimecardAB.setPayRate(10);
		fRuleTimecardAB.setEmpId("56a8fde4d53590000a00009d");
		fRuleTimecardAB.setEmpPositionId("56ab9c41cf8b48000a00001e");
		fRuleTimecardAB.setLocationId("l1");
		fRuleTimecardAB.setDurationInSeconds(32400);
		weekTimecards.add(fRuleTimecardAB);

		LaborCostRequestDTO fRuleTimecardAC = new LaborCostRequestDTO();
		fRuleTimecardAC.setShiftId("59e523bf1e4fa3000702ae70");
		fRuleTimecardAC.setTimecardStartDate(DateUtils.getDateInFormat("Mon Mar 11 15:00:00 IST 2019"));
		fRuleTimecardAC.setTimecardEndDate(DateUtils.getDateInFormat("Mon Mar 11 17:00:00 IST 2019"));
		fRuleTimecardAC.setPayRate(10);
		fRuleTimecardAC.setEmpId("56a8fde4d53590000a00009d");
		fRuleTimecardAC.setEmpPositionId("56ab9c41cf8b48000a00001e");
		fRuleTimecardAC.setLocationId("l1");
		fRuleTimecardAC.setDurationInSeconds(32400);
		weekTimecards.add(fRuleTimecardAC);

		LaborCostRequestDTO fRuleTimecardAD = new LaborCostRequestDTO();
		fRuleTimecardAD.setShiftId("59e523bf1e4fa3000702ae71");
		fRuleTimecardAD.setTimecardStartDate(DateUtils.getDateInFormat("Tue Mar 12 09:00:00 IST 2019"));
		fRuleTimecardAD.setTimecardEndDate(DateUtils.getDateInFormat("Tue Mar 12 14:00:00 IST 2019"));
		fRuleTimecardAD.setPayRate(10);
		fRuleTimecardAD.setEmpId("56a8fde4d53590000a00009d");
		fRuleTimecardAD.setEmpPositionId("56ab9c41cf8b48000a00001e");
		fRuleTimecardAD.setLocationId("l1");
		fRuleTimecardAD.setDurationInSeconds(32400);
		fRuleTimecardAD.setBreaks(1000 * 60 * 30);
		weekTimecards.add(fRuleTimecardAD);

		LaborCostRequestDTO fRuleTimecardAE = new LaborCostRequestDTO();
		fRuleTimecardAE.setShiftId("59e523bf1e4fa3000702ae72");
		fRuleTimecardAE.setTimecardStartDate(DateUtils.getDateInFormat("Wed Mar 13 09:00:00 IST 2019"));
		fRuleTimecardAE.setTimecardEndDate(DateUtils.getDateInFormat("Wed Mar 13 13:00:00 IST 2019"));
		fRuleTimecardAE.setPayRate(10);
		fRuleTimecardAE.setEmpId("56a8fde4d53590000a00009d");
		fRuleTimecardAE.setEmpPositionId("56ab9c41cf8b48000a00001e");
		fRuleTimecardAE.setLocationId("l1");
		fRuleTimecardAE.setDurationInSeconds(32400);
		weekTimecards.add(fRuleTimecardAE);

		LaborCostRequestDTO fRuleTimecardAF = new LaborCostRequestDTO();
		fRuleTimecardAF.setShiftId("59e523bf1e4fa3000702ae73");
		fRuleTimecardAF.setTimecardStartDate(DateUtils.getDateInFormat("Thu Mar 14 09:00:00 IST 2019"));
		fRuleTimecardAF.setTimecardEndDate(DateUtils.getDateInFormat("Thu Mar 14 18:00:00 IST 2019"));
		fRuleTimecardAF.setPayRate(10);
		fRuleTimecardAF.setEmpId("56a8fde4d53590000a00009d");
		fRuleTimecardAF.setEmpPositionId("56ab9c41cf8b48000a00001e");
		fRuleTimecardAF.setLocationId("l1");
		fRuleTimecardAF.setDurationInSeconds(32400);
		weekTimecards.add(fRuleTimecardAF);

		LaborCostRequestDTO fRuleTimecardAG = new LaborCostRequestDTO();
		fRuleTimecardAG.setShiftId("59e523bf1e4fa3000702ae74");
		fRuleTimecardAG.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 09:00:00 IST 2019"));
		fRuleTimecardAG.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 18:00:00 IST 2019"));
		fRuleTimecardAG.setPayRate(10);
		fRuleTimecardAG.setEmpId("56a8fde4d53590000a00009d");
		fRuleTimecardAG.setEmpPositionId("56ab9c41cf8b48000a00001e");
		fRuleTimecardAG.setLocationId("l1");
		fRuleTimecardAG.setDurationInSeconds(32400);
		weekTimecards.add(fRuleTimecardAG);

		LaborCostRequestDTO fRuleTimecardAH = new LaborCostRequestDTO();
		fRuleTimecardAH.setShiftId("59e523bf1e4fa3000702ae74");
		fRuleTimecardAH.setTimecardStartDate(DateUtils.getDateInFormat("Sat Mar 16 09:00:00 IST 2019"));
		fRuleTimecardAH.setTimecardEndDate(DateUtils.getDateInFormat("Sat Mar 16 14:00:00 IST 2019"));
		fRuleTimecardAH.setPayRate(10);
		fRuleTimecardAH.setEmpId("56a8fde4d53590000a00009d");
		fRuleTimecardAH.setEmpPositionId("56ab9c41cf8b48000a00001e");
		fRuleTimecardAH.setLocationId("l1");
		fRuleTimecardAH.setDurationInSeconds(32400);
		weekTimecards.add(fRuleTimecardAH);

		LaborCostRequestDTO fRuleTimecardAI = new LaborCostRequestDTO();
		fRuleTimecardAI.setShiftId("59e523bf1e4fa3000702ae74");
		fRuleTimecardAI.setTimecardStartDate(DateUtils.getDateInFormat("Sat Mar 16 17:00:00 IST 2019"));
		fRuleTimecardAI.setTimecardEndDate(DateUtils.getDateInFormat("Sat Mar 16 19:30:00 IST 2019"));
		fRuleTimecardAI.setPayRate(10);
		fRuleTimecardAI.setEmpId("56a8fde4d53590000a00009d");
		fRuleTimecardAI.setEmpPositionId("56ab9c41cf8b48000a00001e");
		fRuleTimecardAI.setLocationId("l1");
		fRuleTimecardAI.setDurationInSeconds(32400);
		fRuleTimecardAI.setBreaks(1000 * 60 * 30);
		weekTimecards.add(fRuleTimecardAI);

		LaborCostRequestDTO fRuleCostRequestDTOD = new LaborCostRequestDTO();
		fRuleCostRequestDTOD.setShiftId("59e523bf1e4fa3000702ae74");
		fRuleCostRequestDTOD.setTimecardStartDate(DateUtils.getDateInFormat("Sat Mar 16 17:00:00 IST 2019"));
		fRuleCostRequestDTOD.setTimecardEndDate(DateUtils.getDateInFormat("Sat Mar 16 19:30:00 IST 2019"));
		fRuleCostRequestDTOD.setPayRate(10);
		fRuleCostRequestDTOD.setEmpId("56a8fde4d53590000a00009d");
		fRuleCostRequestDTOD.setEmpPositionId("56ab9c41cf8b48000a00001e");
		fRuleCostRequestDTOD.setLocationId("l1");
		fRuleCostRequestDTOD.setWorkWeek(1);
		fRuleCostRequestDTOD.setDurationInSeconds(32400);
		fRuleCostRequestDTOD.setBreaks(1000 * 60 * 30);
		fRuleCostRequestDTOD.setWeekTimecards(weekTimecards);
		return fRuleCostRequestDTOD;
	}

	public static LaborCostRequestDTO getRuleDataFederalVerifiedFullDay() throws ParseException {
		// For Federal Overtime Rule Verified
		List<LaborCostRequestDTO> weekTimecards = new ArrayList<>();

		LaborCostRequestDTO fRuleTimecardAK = new LaborCostRequestDTO();
		fRuleTimecardAK.setShiftId("59e523bf1e4fa3000702ae70");
		fRuleTimecardAK.setTimecardStartDate(DateUtils.getDateInFormat("Mon Mar 11 09:00:00 IST 2019"));
		fRuleTimecardAK.setTimecardEndDate(DateUtils.getDateInFormat("Mon Mar 11 12:30:00 IST 2019"));
		fRuleTimecardAK.setPayRate(10);
		fRuleTimecardAK.setEmpId("56a8fde4d53590000a00009d");
		fRuleTimecardAK.setEmpPositionId("56ab9c41cf8b48000a00001e");
		fRuleTimecardAK.setLocationId("l1");
		fRuleTimecardAK.setDurationInSeconds(32400);
		weekTimecards.add(fRuleTimecardAK);

		LaborCostRequestDTO fRuleTimecardAL = new LaborCostRequestDTO();
		fRuleTimecardAL.setShiftId("59e523bf1e4fa3000702ae70");
		fRuleTimecardAL.setTimecardStartDate(DateUtils.getDateInFormat("Mon Mar 11 12:30:00 IST 2019"));
		fRuleTimecardAL.setTimecardEndDate(DateUtils.getDateInFormat("Mon Mar 11 15:00:00 IST 2019"));
		fRuleTimecardAL.setPayRate(10);
		fRuleTimecardAL.setEmpId("56a8fde4d53590000a00009d");
		fRuleTimecardAL.setEmpPositionId("56ab9c41cf8b48000a00001e");
		fRuleTimecardAL.setLocationId("l1");
		fRuleTimecardAL.setDurationInSeconds(32400);
		weekTimecards.add(fRuleTimecardAL);

		LaborCostRequestDTO fRuleTimecardAM = new LaborCostRequestDTO();
		fRuleTimecardAM.setShiftId("59e523bf1e4fa3000702ae70");
		fRuleTimecardAM.setTimecardStartDate(DateUtils.getDateInFormat("Mon Mar 11 15:00:00 IST 2019"));
		fRuleTimecardAM.setTimecardEndDate(DateUtils.getDateInFormat("Mon Mar 11 18:00:00 IST 2019"));
		fRuleTimecardAM.setPayRate(10);
		fRuleTimecardAM.setEmpId("56a8fde4d53590000a00009d");
		fRuleTimecardAM.setEmpPositionId("56ab9c41cf8b48000a00001e");
		fRuleTimecardAM.setLocationId("l1");
		fRuleTimecardAM.setDurationInSeconds(32400);
		fRuleTimecardAM.setBreaks(1000 * 60 * 30);
		weekTimecards.add(fRuleTimecardAM);

		LaborCostRequestDTO fRuleTimecardAN = new LaborCostRequestDTO();
		fRuleTimecardAN.setShiftId("59e523bf1e4fa3000702ae71");
		fRuleTimecardAN.setTimecardStartDate(DateUtils.getDateInFormat("Tue Mar 12 09:00:00 IST 2019"));
		fRuleTimecardAN.setTimecardEndDate(DateUtils.getDateInFormat("Tue Mar 12 13:00:00 IST 2019"));
		fRuleTimecardAN.setPayRate(10);
		fRuleTimecardAN.setEmpId("56a8fde4d53590000a00009d");
		fRuleTimecardAN.setEmpPositionId("56ab9c41cf8b48000a00001e");
		fRuleTimecardAN.setLocationId("l1");
		fRuleTimecardAN.setDurationInSeconds(32400);
		fRuleTimecardAN.setBreaks(1000 * 60 * 30);
		weekTimecards.add(fRuleTimecardAN);

		LaborCostRequestDTO fRuleTimecardAO = new LaborCostRequestDTO();
		fRuleTimecardAO.setShiftId("59e523bf1e4fa3000702ae72");
		fRuleTimecardAO.setTimecardStartDate(DateUtils.getDateInFormat("Wed Mar 13 09:00:00 IST 2019"));
		fRuleTimecardAO.setTimecardEndDate(DateUtils.getDateInFormat("Wed Mar 13 13:00:00 IST 2019"));
		fRuleTimecardAO.setPayRate(10);
		fRuleTimecardAO.setEmpId("56a8fde4d53590000a00009d");
		fRuleTimecardAO.setEmpPositionId("56ab9c41cf8b48000a00001e");
		fRuleTimecardAO.setLocationId("l1");
		fRuleTimecardAO.setDurationInSeconds(32400);
		fRuleTimecardAO.setBreaks(1000 * 60 * 30);
		weekTimecards.add(fRuleTimecardAO);

		LaborCostRequestDTO fRuleTimecardAP = new LaborCostRequestDTO();
		fRuleTimecardAP.setShiftId("59e523bf1e4fa3000702ae73");
		fRuleTimecardAP.setTimecardStartDate(DateUtils.getDateInFormat("Thu Mar 14 09:00:00 IST 2019"));
		fRuleTimecardAP.setTimecardEndDate(DateUtils.getDateInFormat("Thu Mar 14 18:00:00 IST 2019"));
		fRuleTimecardAP.setPayRate(10);
		fRuleTimecardAP.setEmpId("56a8fde4d53590000a00009d");
		fRuleTimecardAP.setEmpPositionId("56ab9c41cf8b48000a00001e");
		fRuleTimecardAP.setLocationId("l1");
		fRuleTimecardAP.setDurationInSeconds(32400);
		fRuleTimecardAP.setBreaks(1000 * 60 * 30);
		weekTimecards.add(fRuleTimecardAP);

		LaborCostRequestDTO fRuleTimecardAQ = new LaborCostRequestDTO();
		fRuleTimecardAQ.setShiftId("59e523bf1e4fa3000702ae74");
		fRuleTimecardAQ.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 09:00:00 IST 2019"));
		fRuleTimecardAQ.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 18:00:00 IST 2019"));
		fRuleTimecardAQ.setPayRate(10);
		fRuleTimecardAQ.setEmpId("56a8fde4d53590000a00009d");
		fRuleTimecardAQ.setEmpPositionId("56ab9c41cf8b48000a00001e");
		fRuleTimecardAQ.setLocationId("l1");
		fRuleTimecardAQ.setDurationInSeconds(32400);
		fRuleTimecardAQ.setBreaks(1000 * 60 * 30);
		weekTimecards.add(fRuleTimecardAQ);

		LaborCostRequestDTO fRuleTimecardAR = new LaborCostRequestDTO();
		fRuleTimecardAR.setShiftId("59e523bf1e4fa3000702ae74");
		fRuleTimecardAR.setTimecardStartDate(DateUtils.getDateInFormat("Sat Mar 16 09:00:00 IST 2019"));
		fRuleTimecardAR.setTimecardEndDate(DateUtils.getDateInFormat("Sat Mar 16 14:00:00 IST 2019"));
		fRuleTimecardAR.setPayRate(10);
		fRuleTimecardAR.setEmpId("56a8fde4d53590000a00009d");
		fRuleTimecardAR.setEmpPositionId("56ab9c41cf8b48000a00001e");
		fRuleTimecardAR.setLocationId("l1");
		fRuleTimecardAR.setDurationInSeconds(32400);
		fRuleTimecardAR.setBreaks(1000 * 60 * 30);
		weekTimecards.add(fRuleTimecardAR);

		LaborCostRequestDTO fRuleTimecardAS = new LaborCostRequestDTO();
		fRuleTimecardAS.setShiftId("59e523bf1e4fa3000702ae74");
		fRuleTimecardAS.setTimecardStartDate(DateUtils.getDateInFormat("Sat Mar 16 14:00:00 IST 2019"));
		fRuleTimecardAS.setTimecardEndDate(DateUtils.getDateInFormat("Sat Mar 16 24:00:00 IST 2019"));
		fRuleTimecardAS.setPayRate(10);
		fRuleTimecardAS.setEmpId("56a8fde4d53590000a00009d");
		fRuleTimecardAS.setEmpPositionId("56ab9c41cf8b48000a00001e");
		fRuleTimecardAS.setLocationId("l1");
		fRuleTimecardAS.setDurationInSeconds(32400);
		fRuleTimecardAS.setBreaks(1000 * 60 * 30);
		weekTimecards.add(fRuleTimecardAS);

		LaborCostRequestDTO fRuleCostRequestDTOZ = new LaborCostRequestDTO();
		fRuleCostRequestDTOZ.setShiftId("59e523bf1e4fa3000702ae74");
		fRuleCostRequestDTOZ.setTimecardStartDate(DateUtils.getDateInFormat("Sat Mar 16 14:00:00 IST 2019"));
		fRuleCostRequestDTOZ.setTimecardEndDate(DateUtils.getDateInFormat("Sat Mar 16 24:00:00 IST 2019"));
		fRuleCostRequestDTOZ.setPayRate(10);
		fRuleCostRequestDTOZ.setEmpId("56a8fde4d53590000a00009d");
		fRuleCostRequestDTOZ.setEmpPositionId("56ab9c41cf8b48000a00001e");
		fRuleCostRequestDTOZ.setLocationId("l1");
		fRuleCostRequestDTOZ.setWorkWeek(1);
		fRuleCostRequestDTOZ.setDurationInSeconds(32400);
		fRuleCostRequestDTOZ.setBreaks(1000 * 60 * 30);
		fRuleCostRequestDTOZ.setWeekTimecards(weekTimecards);
		return fRuleCostRequestDTOZ;
	}

	public static LaborCostRequestDTO getErrorData() throws ParseException {
		// For Federal Overtime Rule Verified with Regular Wage & SOH
		List<LaborCostRequestDTO> weekTimecards = new ArrayList<>();

		LaborCostRequestDTO fRuleTimecardAJ = new LaborCostRequestDTO();
		fRuleTimecardAJ.setShiftId("59e523bf1e4fa3000702ae74");
		fRuleTimecardAJ.setTimecardEndDate(DateUtils.getDateInFormat("Sat Mar 16 19:30:00 IST 2019"));
		fRuleTimecardAJ.setEmpId("56a8fde4d53590000a00009d");
		fRuleTimecardAJ.setEmpPositionId("56ab9c41cf8b48000a00001e");
		fRuleTimecardAJ.setLocationId("l10");
		fRuleTimecardAJ.setDurationInSeconds(32400);
		fRuleTimecardAJ.setBreaks(1000 * 60 * 30);
		weekTimecards.add(fRuleTimecardAJ);

		LaborCostRequestDTO fRuleCostRequestDTOD = new LaborCostRequestDTO();
		fRuleCostRequestDTOD.setShiftId("59e523bf1e4fa3000702ae74");
		fRuleCostRequestDTOD.setTimecardStartDate(DateUtils.getDateInFormat("Sat Mar 16 17:00:00 IST 2019"));
		fRuleCostRequestDTOD.setEmpId("56a8fde4d53590000a00009d");
		fRuleCostRequestDTOD.setEmpPositionId("56ab9c41cf8b48000a00001e");
		fRuleCostRequestDTOD.setLocationId("l10");
		fRuleCostRequestDTOD.setWorkWeek(1);
		fRuleCostRequestDTOD.setDurationInSeconds(32400);
		fRuleCostRequestDTOD.setBreaks(1000 * 60 * 30);
		fRuleCostRequestDTOD.setWeekTimecards(weekTimecards);
		return fRuleCostRequestDTOD;
	}

}

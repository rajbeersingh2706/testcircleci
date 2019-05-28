package com.salido.labor.data;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.salido.labor.dto.LaborCostRequestDTO;
import com.salido.labor.util.DateUtils;

public class CaliforniaRuleTestData {
	private CaliforniaRuleTestData() {
		super();
	}

	// For California Weekly Overtime 7th Consecutive Day Overtime

	public static LaborCostRequestDTO getRuleDataCaliforniaSevenConHrsGreaterThanEight() throws ParseException {
		// #DAYS_WORKED_WEEK > 6 && #HOURS_WORKED_DAY > 8
		List<LaborCostRequestDTO> weekTimecards = new ArrayList<>();

		LaborCostRequestDTO crRuleTimecardA = new LaborCostRequestDTO();
		crRuleTimecardA.setShiftId("59e523bf1e4fa3000702ae70");
		crRuleTimecardA.setTimecardStartDate(DateUtils.getDateInFormat("Mon Mar 11 09:00:00 IST 2019"));
		crRuleTimecardA.setTimecardEndDate(DateUtils.getDateInFormat("Mon Mar 11 12:00:00 IST 2019"));
		crRuleTimecardA.setPayRate(10);
		crRuleTimecardA.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardA.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardA.setLocationId("l2");
		crRuleTimecardA.setDurationInSeconds(32400);
		crRuleTimecardA.setBreaks(1000 * 60 * 30);
		weekTimecards.add(crRuleTimecardA);

		LaborCostRequestDTO crRuleTimecardB = new LaborCostRequestDTO();
		crRuleTimecardB.setShiftId("59e523bf1e4fa3000702ae71");
		crRuleTimecardB.setTimecardStartDate(DateUtils.getDateInFormat("Tue Mar 12 09:00:00 IST 2019"));
		crRuleTimecardB.setTimecardEndDate(DateUtils.getDateInFormat("Tue Mar 12 12:00:00 IST 2019"));
		crRuleTimecardB.setPayRate(10);
		crRuleTimecardB.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardB.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardB.setLocationId("l2");
		crRuleTimecardB.setDurationInSeconds(32400);
		crRuleTimecardB.setBreaks(1000 * 60 * 30);
		weekTimecards.add(crRuleTimecardB);

		LaborCostRequestDTO crRuleTimecardC = new LaborCostRequestDTO();
		crRuleTimecardC.setShiftId("59e523bf1e4fa3000702ae72");
		crRuleTimecardC.setTimecardStartDate(DateUtils.getDateInFormat("Wed Mar 13 09:00:00 IST 2019"));
		crRuleTimecardC.setTimecardEndDate(DateUtils.getDateInFormat("Wed Mar 13 12:00:00 IST 2019"));
		crRuleTimecardC.setPayRate(10);
		crRuleTimecardC.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardC.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardC.setLocationId("l2");
		crRuleTimecardC.setDurationInSeconds(32400);
		crRuleTimecardC.setBreaks(1000 * 60 * 30);
		weekTimecards.add(crRuleTimecardC);

		LaborCostRequestDTO crRuleTimecardD = new LaborCostRequestDTO();
		crRuleTimecardD.setShiftId("59e523bf1e4fa3000702ae73");
		crRuleTimecardD.setTimecardStartDate(DateUtils.getDateInFormat("Thu Mar 14 09:00:00 IST 2019"));
		crRuleTimecardD.setTimecardEndDate(DateUtils.getDateInFormat("Thu Mar 14 18:00:00 IST 2019"));
		crRuleTimecardD.setPayRate(10);
		crRuleTimecardD.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardD.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardD.setLocationId("l2");
		crRuleTimecardD.setDurationInSeconds(32400);
		crRuleTimecardD.setBreaks(1000 * 60 * 30);
		weekTimecards.add(crRuleTimecardD);

		LaborCostRequestDTO crRuleTimecardE = new LaborCostRequestDTO();
		crRuleTimecardE.setShiftId("59e523bf1e4fa3000702ae74");
		crRuleTimecardE.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 09:00:00 IST 2019"));
		crRuleTimecardE.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 18:00:00 IST 2019"));
		crRuleTimecardE.setPayRate(10);
		crRuleTimecardE.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardE.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardE.setLocationId("l2");
		crRuleTimecardE.setDurationInSeconds(32400);
		crRuleTimecardE.setBreaks(1000 * 60 * 30);
		weekTimecards.add(crRuleTimecardE);

		LaborCostRequestDTO crRuleTimecardF = new LaborCostRequestDTO();
		crRuleTimecardF.setShiftId("59e523bf1e4fa3000702ae74");
		crRuleTimecardF.setTimecardStartDate(DateUtils.getDateInFormat("Sat Mar 16 08:00:00 IST 2019"));
		crRuleTimecardF.setTimecardEndDate(DateUtils.getDateInFormat("Sat Mar 16 10:30:00 IST 2019"));
		crRuleTimecardF.setPayRate(10);
		crRuleTimecardF.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardF.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardF.setLocationId("l2");
		crRuleTimecardF.setDurationInSeconds(32400);
		crRuleTimecardF.setBreaks(1000 * 60 * 30);
		weekTimecards.add(crRuleTimecardF);

		LaborCostRequestDTO crRuleTimecardG = new LaborCostRequestDTO();
		crRuleTimecardG.setShiftId("59e523bf1e4fa3000702ae74");
		crRuleTimecardG.setTimecardStartDate(DateUtils.getDateInFormat("Sat Mar 16 10:30:00 IST 2019"));
		crRuleTimecardG.setTimecardEndDate(DateUtils.getDateInFormat("Sat Mar 16 17:30:00 IST 2019"));
		crRuleTimecardG.setPayRate(10);
		crRuleTimecardG.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardG.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardG.setLocationId("l2");
		crRuleTimecardG.setDurationInSeconds(32400);
		crRuleTimecardG.setBreaks(1000 * 60 * 30);
		weekTimecards.add(crRuleTimecardG);

		LaborCostRequestDTO calcostRequestDTOA = new LaborCostRequestDTO();
		calcostRequestDTOA.setShiftId("59e523bf1e4fa3000702ae74");
		calcostRequestDTOA.setTimecardStartDate(DateUtils.getDateInFormat("Sat Mar 16 10:30:00 IST 2019"));
		calcostRequestDTOA.setTimecardEndDate(DateUtils.getDateInFormat("Sat Mar 16 17:30:00 IST 2019"));
		calcostRequestDTOA.setPayRate(10);
		calcostRequestDTOA.setEmpId("56a8fde4d53590000a00009d");
		calcostRequestDTOA.setEmpPositionId("56ab9c41cf8b48000a00001e");
		calcostRequestDTOA.setLocationId("l2");
		calcostRequestDTOA.setWorkWeek(1);
		calcostRequestDTOA.setDurationInSeconds(32400);
		calcostRequestDTOA.setBreaks(1000 * 60 * 30);
		calcostRequestDTOA.setWeekTimecards(weekTimecards);
		return calcostRequestDTOA;
	}

	public static LaborCostRequestDTO getRuleDataCaliforniaSevenConHrsGreaterThanEightSecond() throws ParseException {
		// #DAYS_WORKED_WEEK > 6 && #HOURS_WORKED_DAY > 8 with 0 cost for more
		// than 8 hrs.
		List<LaborCostRequestDTO> weekTimecards = new ArrayList<>();

		LaborCostRequestDTO crRuleTimecardH = new LaborCostRequestDTO();
		crRuleTimecardH.setShiftId("59e523bf1e4fa3000702ae70");
		crRuleTimecardH.setTimecardStartDate(DateUtils.getDateInFormat("Mon Mar 11 09:00:00 IST 2019"));
		crRuleTimecardH.setTimecardEndDate(DateUtils.getDateInFormat("Mon Mar 11 12:00:00 IST 2019"));
		crRuleTimecardH.setPayRate(10);
		crRuleTimecardH.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardH.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardH.setLocationId("l2");
		crRuleTimecardH.setDurationInSeconds(32400);
		crRuleTimecardH.setBreaks(1000 * 60 * 30);
		weekTimecards.add(crRuleTimecardH);

		LaborCostRequestDTO crRuleTimecardI = new LaborCostRequestDTO();
		crRuleTimecardI.setShiftId("59e523bf1e4fa3000702ae71");
		crRuleTimecardI.setTimecardStartDate(DateUtils.getDateInFormat("Tue Mar 12 09:00:00 IST 2019"));
		crRuleTimecardI.setTimecardEndDate(DateUtils.getDateInFormat("Tue Mar 12 12:00:00 IST 2019"));
		crRuleTimecardI.setPayRate(10);
		crRuleTimecardI.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardI.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardI.setLocationId("l2");
		crRuleTimecardI.setDurationInSeconds(32400);
		crRuleTimecardI.setBreaks(1000 * 60 * 30);
		weekTimecards.add(crRuleTimecardI);

		LaborCostRequestDTO crRuleTimecardJ = new LaborCostRequestDTO();
		crRuleTimecardJ.setShiftId("59e523bf1e4fa3000702ae72");
		crRuleTimecardJ.setTimecardStartDate(DateUtils.getDateInFormat("Wed Mar 13 09:00:00 IST 2019"));
		crRuleTimecardJ.setTimecardEndDate(DateUtils.getDateInFormat("Wed Mar 13 12:00:00 IST 2019"));
		crRuleTimecardJ.setPayRate(10);
		crRuleTimecardJ.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardJ.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardJ.setLocationId("l2");
		crRuleTimecardJ.setDurationInSeconds(32400);
		crRuleTimecardJ.setBreaks(1000 * 60 * 30);
		weekTimecards.add(crRuleTimecardJ);

		LaborCostRequestDTO crRuleTimecardK = new LaborCostRequestDTO();
		crRuleTimecardK.setShiftId("59e523bf1e4fa3000702ae73");
		crRuleTimecardK.setTimecardStartDate(DateUtils.getDateInFormat("Thu Mar 14 09:00:00 IST 2019"));
		crRuleTimecardK.setTimecardEndDate(DateUtils.getDateInFormat("Thu Mar 14 18:00:00 IST 2019"));
		crRuleTimecardK.setPayRate(10);
		crRuleTimecardK.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardK.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardK.setLocationId("l2");
		crRuleTimecardK.setDurationInSeconds(32400);
		crRuleTimecardK.setBreaks(1000 * 60 * 30);
		weekTimecards.add(crRuleTimecardK);

		LaborCostRequestDTO crRuleTimecardL = new LaborCostRequestDTO();
		crRuleTimecardL.setShiftId("59e523bf1e4fa3000702ae74");
		crRuleTimecardL.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 09:00:00 IST 2019"));
		crRuleTimecardL.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 18:00:00 IST 2019"));
		crRuleTimecardL.setPayRate(10);
		crRuleTimecardL.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardL.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardL.setLocationId("l2");
		crRuleTimecardL.setDurationInSeconds(32400);
		crRuleTimecardL.setBreaks(1000 * 60 * 30);
		weekTimecards.add(crRuleTimecardL);

		LaborCostRequestDTO crRuleTimecardM = new LaborCostRequestDTO();
		crRuleTimecardM.setShiftId("59e523bf1e4fa3000702ae74");
		crRuleTimecardM.setTimecardStartDate(DateUtils.getDateInFormat("Sat Mar 16 08:00:00 IST 2019"));
		crRuleTimecardM.setTimecardEndDate(DateUtils.getDateInFormat("Sat Mar 16 17:00:00 IST 2019"));
		crRuleTimecardM.setPayRate(10);
		crRuleTimecardM.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardM.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardM.setLocationId("l2");
		crRuleTimecardM.setDurationInSeconds(32400);
		crRuleTimecardM.setBreaks(1000 * 60 * 30);
		weekTimecards.add(crRuleTimecardM);

		LaborCostRequestDTO crRuleTimecardN = new LaborCostRequestDTO();
		crRuleTimecardN.setShiftId("59e523bf1e4fa3000702ae74");
		crRuleTimecardN.setTimecardStartDate(DateUtils.getDateInFormat("Sat Mar 16 17:00:00 IST 2019"));
		crRuleTimecardN.setTimecardEndDate(DateUtils.getDateInFormat("Sat Mar 16 17:30:00 IST 2019"));
		crRuleTimecardN.setPayRate(10);
		crRuleTimecardN.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardN.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardN.setLocationId("l2");
		crRuleTimecardN.setDurationInSeconds(32400);
		crRuleTimecardN.setBreaks(1000 * 60 * 30);
		weekTimecards.add(crRuleTimecardN);

		LaborCostRequestDTO costRequestDTOA = new LaborCostRequestDTO();
		costRequestDTOA.setShiftId("59e523bf1e4fa3000702ae74");
		costRequestDTOA.setTimecardStartDate(DateUtils.getDateInFormat("Sat Mar 16 17:00:00 IST 2019"));
		costRequestDTOA.setTimecardEndDate(DateUtils.getDateInFormat("Sat Mar 16 17:30:00 IST 2019"));
		costRequestDTOA.setPayRate(10);
		costRequestDTOA.setEmpId("56a8fde4d53590000a00009d");
		costRequestDTOA.setEmpPositionId("56ab9c41cf8b48000a00001e");
		costRequestDTOA.setLocationId("l2");
		costRequestDTOA.setWorkWeek(1);
		costRequestDTOA.setDurationInSeconds(32400);
		costRequestDTOA.setBreaks(1000 * 60 * 30);
		costRequestDTOA.setWeekTimecards(weekTimecards);
		return costRequestDTOA;
	}

	public static LaborCostRequestDTO getRuleDataCaliforniaSevenConNormal() throws ParseException {
		// #DAYS_WORKED_WEEK > 6
		List<LaborCostRequestDTO> weekTimecards = new ArrayList<>();

		LaborCostRequestDTO crRuleTimecardO = new LaborCostRequestDTO();
		crRuleTimecardO.setShiftId("59e523bf1e4fa3000702ae70");
		crRuleTimecardO.setTimecardStartDate(DateUtils.getDateInFormat("Mon Mar 11 09:00:00 IST 2019"));
		crRuleTimecardO.setTimecardEndDate(DateUtils.getDateInFormat("Mon Mar 11 12:00:00 IST 2019"));
		crRuleTimecardO.setPayRate(10);
		crRuleTimecardO.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardO.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardO.setLocationId("l2");
		crRuleTimecardO.setDurationInSeconds(32400);
		crRuleTimecardO.setBreaks(1000 * 60 * 30);
		weekTimecards.add(crRuleTimecardO);

		LaborCostRequestDTO crRuleTimecardP = new LaborCostRequestDTO();
		crRuleTimecardP.setShiftId("59e523bf1e4fa3000702ae71");
		crRuleTimecardP.setTimecardStartDate(DateUtils.getDateInFormat("Tue Mar 12 09:00:00 IST 2019"));
		crRuleTimecardP.setTimecardEndDate(DateUtils.getDateInFormat("Tue Mar 12 12:00:00 IST 2019"));
		crRuleTimecardP.setPayRate(10);
		crRuleTimecardP.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardP.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardP.setLocationId("l2");
		crRuleTimecardP.setDurationInSeconds(32400);
		crRuleTimecardP.setBreaks(1000 * 60 * 30);
		weekTimecards.add(crRuleTimecardP);

		LaborCostRequestDTO crRuleTimecardQ = new LaborCostRequestDTO();
		crRuleTimecardQ.setShiftId("59e523bf1e4fa3000702ae72");
		crRuleTimecardQ.setTimecardStartDate(DateUtils.getDateInFormat("Wed Mar 13 09:00:00 IST 2019"));
		crRuleTimecardQ.setTimecardEndDate(DateUtils.getDateInFormat("Wed Mar 13 12:00:00 IST 2019"));
		crRuleTimecardQ.setPayRate(10);
		crRuleTimecardQ.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardQ.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardQ.setLocationId("l2");
		crRuleTimecardQ.setDurationInSeconds(32400);
		crRuleTimecardQ.setBreaks(1000 * 60 * 30);
		weekTimecards.add(crRuleTimecardQ);

		LaborCostRequestDTO crRuleTimecardR = new LaborCostRequestDTO();
		crRuleTimecardR.setShiftId("59e523bf1e4fa3000702ae73");
		crRuleTimecardR.setTimecardStartDate(DateUtils.getDateInFormat("Thu Mar 14 09:00:00 IST 2019"));
		crRuleTimecardR.setTimecardEndDate(DateUtils.getDateInFormat("Thu Mar 14 18:00:00 IST 2019"));
		crRuleTimecardR.setPayRate(10);
		crRuleTimecardR.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardR.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardR.setLocationId("l2");
		crRuleTimecardR.setDurationInSeconds(32400);
		crRuleTimecardR.setBreaks(1000 * 60 * 30);
		weekTimecards.add(crRuleTimecardR);

		LaborCostRequestDTO crRuleTimecardS = new LaborCostRequestDTO();
		crRuleTimecardS.setShiftId("59e523bf1e4fa3000702ae74");
		crRuleTimecardS.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 09:00:00 IST 2019"));
		crRuleTimecardS.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 18:00:00 IST 2019"));
		crRuleTimecardS.setPayRate(10);
		crRuleTimecardS.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardS.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardS.setLocationId("l2");
		crRuleTimecardS.setDurationInSeconds(32400);
		crRuleTimecardS.setBreaks(1000 * 60 * 30);
		weekTimecards.add(crRuleTimecardS);

		LaborCostRequestDTO crRuleTimecardT = new LaborCostRequestDTO();
		crRuleTimecardT.setShiftId("59e523bf1e4fa3000702ae74");
		crRuleTimecardT.setTimecardStartDate(DateUtils.getDateInFormat("Sat Mar 16 10:30:00 IST 2019"));
		crRuleTimecardT.setTimecardEndDate(DateUtils.getDateInFormat("Sat Mar 16 15:30:00 IST 2019"));
		crRuleTimecardT.setPayRate(10);
		crRuleTimecardT.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardT.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardT.setLocationId("l2");
		crRuleTimecardT.setDurationInSeconds(32400);
		crRuleTimecardT.setBreaks(1000 * 60 * 30);
		weekTimecards.add(crRuleTimecardT);

		LaborCostRequestDTO costRequestDTOB = new LaborCostRequestDTO();
		costRequestDTOB.setShiftId("59e523bf1e4fa3000702ae74");
		costRequestDTOB.setTimecardStartDate(DateUtils.getDateInFormat("Sat Mar 16 10:30:00 IST 2019"));
		costRequestDTOB.setTimecardEndDate(DateUtils.getDateInFormat("Sat Mar 16 15:30:00 IST 2019"));
		costRequestDTOB.setPayRate(10);
		costRequestDTOB.setEmpId("56a8fde4d53590000a00009d");
		costRequestDTOB.setEmpPositionId("56ab9c41cf8b48000a00001e");
		costRequestDTOB.setLocationId("l2");
		costRequestDTOB.setWorkWeek(1);
		costRequestDTOB.setDurationInSeconds(32400);
		costRequestDTOB.setBreaks(1000 * 60 * 30);
		costRequestDTOB.setWeekTimecards(weekTimecards);
		return costRequestDTOB;
	}

	/*****************************************************************************************************************/
	// For Daily Overtime

	public static LaborCostRequestDTO getRuleDataCaliforniaDailyOTHrsGreaterThanTwelve() throws ParseException {
		// #HOURS_WORKED_DAY > 12 && #DAYS_WORKED_WEEK < 7 with complete
		// Timecard Hrs. & without Regular Wages
		List<LaborCostRequestDTO> weekTimecards = new ArrayList<>();

		LaborCostRequestDTO crRuleTimecardU = new LaborCostRequestDTO();
		crRuleTimecardU.setShiftId("59e523bf1e4fa3000702ae70");
		crRuleTimecardU.setTimecardStartDate(DateUtils.getDateInFormat("Mon Mar 11 09:00:00 IST 2019"));
		crRuleTimecardU.setTimecardEndDate(DateUtils.getDateInFormat("Mon Mar 11 12:00:00 IST 2019"));
		crRuleTimecardU.setPayRate(10);
		crRuleTimecardU.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardU.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardU.setLocationId("l2");
		crRuleTimecardU.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardU);

		LaborCostRequestDTO crRuleTimecardV = new LaborCostRequestDTO();
		crRuleTimecardV.setShiftId("59e523bf1e4fa3000702ae71");
		crRuleTimecardV.setTimecardStartDate(DateUtils.getDateInFormat("Tue Mar 12 09:00:00 IST 2019"));
		crRuleTimecardV.setTimecardEndDate(DateUtils.getDateInFormat("Tue Mar 12 12:00:00 IST 2019"));
		crRuleTimecardV.setPayRate(10);
		crRuleTimecardV.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardV.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardV.setLocationId("l2");
		crRuleTimecardV.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardV);

		LaborCostRequestDTO crRuleTimecardW = new LaborCostRequestDTO();
		crRuleTimecardW.setShiftId("59e523bf1e4fa3000702ae73");
		crRuleTimecardW.setTimecardStartDate(DateUtils.getDateInFormat("Thu Mar 14 09:00:00 IST 2019"));
		crRuleTimecardW.setTimecardEndDate(DateUtils.getDateInFormat("Thu Mar 14 20:00:00 IST 2019"));
		crRuleTimecardW.setPayRate(10);
		crRuleTimecardW.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardW.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardW.setLocationId("l2");
		crRuleTimecardW.setDurationInSeconds(32400);
		crRuleTimecardW.setBreaks(1000 * 60 * 30);
		weekTimecards.add(crRuleTimecardW);

		LaborCostRequestDTO crRuleTimecardX = new LaborCostRequestDTO();
		crRuleTimecardX.setShiftId("59e523bf1e4fa3000702ae74");
		crRuleTimecardX.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 09:00:00 IST 2019"));
		crRuleTimecardX.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 11:30:00 IST 2019"));
		crRuleTimecardX.setPayRate(10);
		crRuleTimecardX.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardX.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardX.setLocationId("l2");
		crRuleTimecardX.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardX);

		LaborCostRequestDTO crRuleTimecardY = new LaborCostRequestDTO();
		crRuleTimecardY.setShiftId("59e523bf1e4fa3000702ae74");
		crRuleTimecardY.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 11:30:00 IST 2019"));
		crRuleTimecardY.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 19:00:00 IST 2019"));
		crRuleTimecardY.setPayRate(10);
		crRuleTimecardY.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardY.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardY.setLocationId("l2");
		crRuleTimecardY.setDurationInSeconds(32400);
		crRuleTimecardY.setBreaks(1000 * 60 * 30);
		weekTimecards.add(crRuleTimecardY);

		LaborCostRequestDTO crRuleTimecardZ = new LaborCostRequestDTO();
		crRuleTimecardZ.setShiftId("59e523bf1e4fa3000702ae74");
		crRuleTimecardZ.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 19:00:00 IST 2019"));
		crRuleTimecardZ.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 22:30:00 IST 2019"));
		crRuleTimecardZ.setPayRate(10);
		crRuleTimecardZ.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardZ.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardZ.setLocationId("l2");
		crRuleTimecardZ.setDurationInSeconds(32400);
		crRuleTimecardZ.setBreaks(1000 * 60 * 30);
		weekTimecards.add(crRuleTimecardZ);

		LaborCostRequestDTO costRequestDTOC = new LaborCostRequestDTO();
		costRequestDTOC.setShiftId("59e523bf1e4fa3000702ae74");
		costRequestDTOC.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 19:00:00 IST 2019"));
		costRequestDTOC.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 22:30:00 IST 2019"));
		costRequestDTOC.setPayRate(10);
		costRequestDTOC.setEmpId("56a8fde4d53590000a00009d");
		costRequestDTOC.setEmpPositionId("56ab9c41cf8b48000a00001e");
		costRequestDTOC.setLocationId("l2");
		costRequestDTOC.setWorkWeek(1);
		costRequestDTOC.setDurationInSeconds(32400);
		costRequestDTOC.setBreaks(1000 * 60 * 30);
		costRequestDTOC.setWeekTimecards(weekTimecards);
		return costRequestDTOC;
	}

	public static LaborCostRequestDTO getRuleDataCaliforniaDailyOTHrsGreaterThanTwelveWithRegAndPartialTC()
			throws ParseException {
		// #HOURS_WORKED_DAY > 12 && #DAYS_WORKED_WEEK < 7 with partial Timecard
		// Hrs. & with Regular Wages
		List<LaborCostRequestDTO> weekTimecards = new ArrayList<>();

		LaborCostRequestDTO crRuleTimecardAA = new LaborCostRequestDTO();
		crRuleTimecardAA.setShiftId("59e523bf1e4fa3000702ae70");
		crRuleTimecardAA.setTimecardStartDate(DateUtils.getDateInFormat("Mon Mar 11 09:00:00 IST 2019"));
		crRuleTimecardAA.setTimecardEndDate(DateUtils.getDateInFormat("Mon Mar 11 12:00:00 IST 2019"));
		crRuleTimecardAA.setPayRate(10);
		crRuleTimecardAA.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardAA.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardAA.setLocationId("l2");
		crRuleTimecardAA.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardAA);

		LaborCostRequestDTO crRuleTimecardAB = new LaborCostRequestDTO();
		crRuleTimecardAB.setShiftId("59e523bf1e4fa3000702ae71");
		crRuleTimecardAB.setTimecardStartDate(DateUtils.getDateInFormat("Tue Mar 12 09:00:00 IST 2019"));
		crRuleTimecardAB.setTimecardEndDate(DateUtils.getDateInFormat("Tue Mar 12 12:00:00 IST 2019"));
		crRuleTimecardAB.setPayRate(10);
		crRuleTimecardAB.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardAB.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardAB.setLocationId("l2");
		crRuleTimecardAB.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardAB);

		LaborCostRequestDTO crRuleTimecardAC = new LaborCostRequestDTO();
		crRuleTimecardAC.setShiftId("59e523bf1e4fa3000702ae73");
		crRuleTimecardAC.setTimecardStartDate(DateUtils.getDateInFormat("Thu Mar 14 09:00:00 IST 2019"));
		crRuleTimecardAC.setTimecardEndDate(DateUtils.getDateInFormat("Thu Mar 14 20:00:00 IST 2019"));
		crRuleTimecardAC.setPayRate(10);
		crRuleTimecardAC.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardAC.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardAC.setLocationId("l2");
		crRuleTimecardAC.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardAC);

		LaborCostRequestDTO crRuleTimecardAD = new LaborCostRequestDTO();
		crRuleTimecardAD.setShiftId("59e523bf1e4fa3000702ae74");
		crRuleTimecardAD.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 09:00:00 IST 2019"));
		crRuleTimecardAD.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 11:30:00 IST 2019"));
		crRuleTimecardAD.setPayRate(10);
		crRuleTimecardAD.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardAD.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardAD.setLocationId("l2");
		crRuleTimecardAD.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardAD);

		LaborCostRequestDTO crRuleTimecardAE = new LaborCostRequestDTO();
		crRuleTimecardAE.setShiftId("59e523bf1e4fa3000702ae74");
		crRuleTimecardAE.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 11:30:00 IST 2019"));
		crRuleTimecardAE.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 16:00:00 IST 2019"));
		crRuleTimecardAE.setPayRate(10);
		crRuleTimecardAE.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardAE.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardAE.setLocationId("l2");
		crRuleTimecardAE.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardAE);

		LaborCostRequestDTO crRuleTimecardAF = new LaborCostRequestDTO();
		crRuleTimecardAF.setShiftId("59e523bf1e4fa3000702ae74");
		crRuleTimecardAF.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 16:00:00 IST 2019"));
		crRuleTimecardAF.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 22:30:00 IST 2019"));
		crRuleTimecardAF.setPayRate(10);
		crRuleTimecardAF.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardAF.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardAF.setLocationId("l2");
		crRuleTimecardAF.setDurationInSeconds(32400);
		crRuleTimecardAF.setBreaks(1000 * 60 * 30);
		weekTimecards.add(crRuleTimecardAF);

		LaborCostRequestDTO costRequestDTOD = new LaborCostRequestDTO();
		costRequestDTOD.setShiftId("59e523bf1e4fa3000702ae74");
		costRequestDTOD.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 16:00:00 IST 2019"));
		costRequestDTOD.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 22:30:00 IST 2019"));
		costRequestDTOD.setPayRate(10);
		costRequestDTOD.setEmpId("56a8fde4d53590000a00009d");
		costRequestDTOD.setEmpPositionId("56ab9c41cf8b48000a00001e");
		costRequestDTOD.setLocationId("l2");
		costRequestDTOD.setWorkWeek(1);
		costRequestDTOD.setDurationInSeconds(32400);
		costRequestDTOD.setBreaks(1000 * 60 * 30);
		costRequestDTOD.setWeekTimecards(weekTimecards);
		return costRequestDTOD;
	}

	public static LaborCostRequestDTO getRuleDataCaliforniaDailyOTHrsGreaterThanEightWithRegAndFullTC()
			throws ParseException {
		// #HOURS_WORKED_DAY > 8 && #DAYS_WORKED_WEEK < 7 with complete Timecrad
		// Hrs. 7 without Regular Wages
		List<LaborCostRequestDTO> weekTimecards = new ArrayList<>();

		LaborCostRequestDTO crRuleTimecardAG = new LaborCostRequestDTO();
		crRuleTimecardAG.setShiftId("59e523bf1e4fa3000702ae70");
		crRuleTimecardAG.setTimecardStartDate(DateUtils.getDateInFormat("Mon Mar 11 09:00:00 IST 2019"));
		crRuleTimecardAG.setTimecardEndDate(DateUtils.getDateInFormat("Mon Mar 11 12:00:00 IST 2019"));
		crRuleTimecardAG.setPayRate(10);
		crRuleTimecardAG.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardAG.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardAG.setLocationId("l2");
		crRuleTimecardAG.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardAG);

		LaborCostRequestDTO crRuleTimecardAH = new LaborCostRequestDTO();
		crRuleTimecardAH.setShiftId("59e523bf1e4fa3000702ae71");
		crRuleTimecardAH.setTimecardStartDate(DateUtils.getDateInFormat("Tue Mar 12 09:00:00 IST 2019"));
		crRuleTimecardAH.setTimecardEndDate(DateUtils.getDateInFormat("Tue Mar 12 12:00:00 IST 2019"));
		crRuleTimecardAH.setPayRate(10);
		crRuleTimecardAH.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardAH.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardAH.setLocationId("l2");
		crRuleTimecardAH.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardAH);

		LaborCostRequestDTO crRuleTimecardAI = new LaborCostRequestDTO();
		crRuleTimecardAI.setShiftId("59e523bf1e4fa3000702ae73");
		crRuleTimecardAI.setTimecardStartDate(DateUtils.getDateInFormat("Thu Mar 14 09:00:00 IST 2019"));
		crRuleTimecardAI.setTimecardEndDate(DateUtils.getDateInFormat("Thu Mar 14 20:00:00 IST 2019"));
		crRuleTimecardAI.setPayRate(10);
		crRuleTimecardAI.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardAI.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardAI.setLocationId("l2");
		crRuleTimecardAI.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardAI);

		LaborCostRequestDTO crRuleTimecardAJ = new LaborCostRequestDTO();
		crRuleTimecardAJ.setShiftId("59e523bf1e4fa3000702ae74");
		crRuleTimecardAJ.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 10:00:00 IST 2019"));
		crRuleTimecardAJ.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 11:30:00 IST 2019"));
		crRuleTimecardAJ.setPayRate(10);
		crRuleTimecardAJ.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardAJ.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardAJ.setLocationId("l2");
		crRuleTimecardAJ.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardAJ);

		LaborCostRequestDTO crRuleTimecardAK = new LaborCostRequestDTO();
		crRuleTimecardAK.setShiftId("59e523bf1e4fa3000702ae74");
		crRuleTimecardAK.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 11:30:00 IST 2019"));
		crRuleTimecardAK.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 20:00:00 IST 2019"));
		crRuleTimecardAK.setPayRate(10);
		crRuleTimecardAK.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardAK.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardAK.setLocationId("l2");
		crRuleTimecardAK.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardAK);

		LaborCostRequestDTO crRuleTimecardAL = new LaborCostRequestDTO();
		crRuleTimecardAL.setShiftId("59e523bf1e4fa3000702ae74");
		crRuleTimecardAL.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 20:00:00 IST 2019"));
		crRuleTimecardAL.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 21:30:00 IST 2019"));
		crRuleTimecardAL.setPayRate(10);
		crRuleTimecardAL.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardAL.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardAL.setLocationId("l2");
		crRuleTimecardAL.setDurationInSeconds(32400);
		crRuleTimecardAL.setBreaks(1000 * 60 * 30);
		weekTimecards.add(crRuleTimecardAL);

		LaborCostRequestDTO costRequestDTOE = new LaborCostRequestDTO();
		costRequestDTOE.setShiftId("59e523bf1e4fa3000702ae74");
		costRequestDTOE.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 20:00:00 IST 2019"));
		costRequestDTOE.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 21:30:00 IST 2019"));
		costRequestDTOE.setPayRate(10);
		costRequestDTOE.setEmpId("56a8fde4d53590000a00009d");
		costRequestDTOE.setEmpPositionId("56ab9c41cf8b48000a00001e");
		costRequestDTOE.setLocationId("l2");
		costRequestDTOE.setWorkWeek(1);
		costRequestDTOE.setDurationInSeconds(32400);
		costRequestDTOE.setBreaks(1000 * 60 * 30);
		costRequestDTOE.setWeekTimecards(weekTimecards);
		return costRequestDTOE;
	}

	public static LaborCostRequestDTO getRuleDataCaliforniaDailyOTHrsGreaterThanEightAndPartialTCAndReg()
			throws ParseException {
		// #HOURS_WORKED_DAY > 8 && #DAYS_WORKED_WEEK < 7 with partial Timecard
		// Hrs. & Regular Wages
		List<LaborCostRequestDTO> weekTimecards = new ArrayList<>();

		LaborCostRequestDTO crRuleTimecardAM = new LaborCostRequestDTO();
		crRuleTimecardAM.setShiftId("59e523bf1e4fa3000702ae70");
		crRuleTimecardAM.setTimecardStartDate(DateUtils.getDateInFormat("Mon Mar 11 09:00:00 IST 2019"));
		crRuleTimecardAM.setTimecardEndDate(DateUtils.getDateInFormat("Mon Mar 11 12:00:00 IST 2019"));
		crRuleTimecardAM.setPayRate(10);
		crRuleTimecardAM.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardAM.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardAM.setLocationId("l2");
		crRuleTimecardAM.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardAM);

		LaborCostRequestDTO crRuleTimecardAN = new LaborCostRequestDTO();
		crRuleTimecardAN.setShiftId("59e523bf1e4fa3000702ae71");
		crRuleTimecardAN.setTimecardStartDate(DateUtils.getDateInFormat("Tue Mar 12 09:00:00 IST 2019"));
		crRuleTimecardAN.setTimecardEndDate(DateUtils.getDateInFormat("Tue Mar 12 12:00:00 IST 2019"));
		crRuleTimecardAN.setPayRate(10);
		crRuleTimecardAN.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardAN.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardAN.setLocationId("l2");
		crRuleTimecardAN.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardAN);

		LaborCostRequestDTO crRuleTimecardAO = new LaborCostRequestDTO();
		crRuleTimecardAO.setShiftId("59e523bf1e4fa3000702ae73");
		crRuleTimecardAO.setTimecardStartDate(DateUtils.getDateInFormat("Thu Mar 14 09:00:00 IST 2019"));
		crRuleTimecardAO.setTimecardEndDate(DateUtils.getDateInFormat("Thu Mar 14 20:00:00 IST 2019"));
		crRuleTimecardAO.setPayRate(10);
		crRuleTimecardAO.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardAO.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardAO.setLocationId("l2");
		crRuleTimecardAO.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardAO);

		LaborCostRequestDTO crRuleTimecardAP = new LaborCostRequestDTO();
		crRuleTimecardAP.setShiftId("59e523bf1e4fa3000702ae74");
		crRuleTimecardAP.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 10:00:00 IST 2019"));
		crRuleTimecardAP.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 11:30:00 IST 2019"));
		crRuleTimecardAP.setPayRate(10);
		crRuleTimecardAP.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardAP.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardAP.setLocationId("l2");
		crRuleTimecardAP.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardAP);

		LaborCostRequestDTO crRuleTimecardAQ = new LaborCostRequestDTO();
		crRuleTimecardAQ.setShiftId("59e523bf1e4fa3000702ae74");
		crRuleTimecardAQ.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 11:30:00 IST 2019"));
		crRuleTimecardAQ.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 17:00:00 IST 2019"));
		crRuleTimecardAQ.setPayRate(10);
		crRuleTimecardAQ.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardAQ.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardAQ.setLocationId("l2");
		crRuleTimecardAQ.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardAQ);

		LaborCostRequestDTO crRuleTimecardAR = new LaborCostRequestDTO();
		crRuleTimecardAR.setShiftId("59e523bf1e4fa3000702ae74");
		crRuleTimecardAR.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 17:00:00 IST 2019"));
		crRuleTimecardAR.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 21:00:00 IST 2019"));
		crRuleTimecardAR.setPayRate(10);
		crRuleTimecardAR.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardAR.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardAR.setLocationId("l2");
		crRuleTimecardAR.setDurationInSeconds(32400);
		crRuleTimecardAR.setBreaks(1000 * 60 * 30);
		weekTimecards.add(crRuleTimecardAR);

		LaborCostRequestDTO costRequestDTOF = new LaborCostRequestDTO();
		costRequestDTOF.setShiftId("59e523bf1e4fa3000702ae74");
		costRequestDTOF.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 17:00:00 IST 2019"));
		costRequestDTOF.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 21:00:00 IST 2019"));
		costRequestDTOF.setPayRate(10);
		costRequestDTOF.setEmpId("56a8fde4d53590000a00009d");
		costRequestDTOF.setEmpPositionId("56ab9c41cf8b48000a00001e");
		costRequestDTOF.setLocationId("l2");
		costRequestDTOF.setWorkWeek(1);
		costRequestDTOF.setDurationInSeconds(32400);
		costRequestDTOF.setBreaks(1000 * 60 * 30);
		costRequestDTOF.setWeekTimecards(weekTimecards);
		return costRequestDTOF;
	}

	// ******************************************************************************************************************************
	// For California Weekly Overtime

	public static LaborCostRequestDTO getRuleDataCaliforniaWeeklyOTNotVerified() throws ParseException {
		// Not Verified
		List<LaborCostRequestDTO> weekTimecards = new ArrayList<>();

		LaborCostRequestDTO crRuleTimecardAS = new LaborCostRequestDTO();
		crRuleTimecardAS.setShiftId("59e523bf1e4fa3000702ae70");
		crRuleTimecardAS.setTimecardStartDate(DateUtils.getDateInFormat("Sun Mar 10 09:00:00 IST 2019"));
		crRuleTimecardAS.setTimecardEndDate(DateUtils.getDateInFormat("Sun Mar 10 16:00:00 IST 2019"));
		crRuleTimecardAS.setPayRate(10);
		crRuleTimecardAS.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardAS.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardAS.setLocationId("l2");
		crRuleTimecardAS.setDurationInSeconds(32400);
		crRuleTimecardAS.setBreaks(1000 * 60 * 30);
		weekTimecards.add(crRuleTimecardAS);

		LaborCostRequestDTO crRuleTimecardAT = new LaborCostRequestDTO();
		crRuleTimecardAT.setShiftId("59e523bf1e4fa3000702ae70");
		crRuleTimecardAT.setTimecardStartDate(DateUtils.getDateInFormat("Mon Mar 11 09:00:00 IST 2019"));
		crRuleTimecardAT.setTimecardEndDate(DateUtils.getDateInFormat("Mon Mar 11 15:00:00 IST 2019"));
		crRuleTimecardAT.setPayRate(10);
		crRuleTimecardAT.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardAT.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardAT.setLocationId("l2");
		crRuleTimecardAT.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardAT);

		LaborCostRequestDTO crRuleTimecardAU = new LaborCostRequestDTO();
		crRuleTimecardAU.setShiftId("59e523bf1e4fa3000702ae71");
		crRuleTimecardAU.setTimecardStartDate(DateUtils.getDateInFormat("Tue Mar 12 09:00:00 IST 2019"));
		crRuleTimecardAU.setTimecardEndDate(DateUtils.getDateInFormat("Tue Mar 12 15:00:00 IST 2019"));
		crRuleTimecardAU.setPayRate(10);
		crRuleTimecardAU.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardAU.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardAU.setLocationId("l2");
		crRuleTimecardAU.setDurationInSeconds(32400);
		crRuleTimecardAU.setBreaks(1000 * 60 * 30);
		weekTimecards.add(crRuleTimecardAU);

		LaborCostRequestDTO crRuleTimecardAV = new LaborCostRequestDTO();
		crRuleTimecardAV.setShiftId("59e523bf1e4fa3000702ae71");
		crRuleTimecardAV.setTimecardStartDate(DateUtils.getDateInFormat("Wed Mar 13 09:00:00 IST 2019"));
		crRuleTimecardAV.setTimecardEndDate(DateUtils.getDateInFormat("Wed Mar 13 15:00:00 IST 2019"));
		crRuleTimecardAV.setPayRate(10);
		crRuleTimecardAV.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardAV.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardAV.setLocationId("l2");
		crRuleTimecardAV.setDurationInSeconds(32400);
		crRuleTimecardAV.setBreaks(1000 * 60 * 30);
		weekTimecards.add(crRuleTimecardAV);

		LaborCostRequestDTO crRuleTimecardAW = new LaborCostRequestDTO();
		crRuleTimecardAW.setShiftId("59e523bf1e4fa3000702ae73");
		crRuleTimecardAW.setTimecardStartDate(DateUtils.getDateInFormat("Thu Mar 14 09:00:00 IST 2019"));
		crRuleTimecardAW.setTimecardEndDate(DateUtils.getDateInFormat("Thu Mar 14 17:00:00 IST 2019"));
		crRuleTimecardAW.setPayRate(10);
		crRuleTimecardAW.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardAW.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardAW.setLocationId("l2");
		crRuleTimecardAW.setDurationInSeconds(32400);
		crRuleTimecardAW.setBreaks(1000 * 60 * 30);
		weekTimecards.add(crRuleTimecardAW);

		LaborCostRequestDTO crRuleTimecardAX = new LaborCostRequestDTO();
		crRuleTimecardAX.setShiftId("59e523bf1e4fa3000702ae73");
		crRuleTimecardAX.setTimecardStartDate(DateUtils.getDateInFormat("Thu Mar 14 15:00:00 IST 2019"));
		crRuleTimecardAX.setTimecardEndDate(DateUtils.getDateInFormat("Thu Mar 14 20:00:00 IST 2019"));
		crRuleTimecardAX.setPayRate(10);
		crRuleTimecardAX.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardAX.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardAX.setLocationId("l2");
		crRuleTimecardAX.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardAX);

		LaborCostRequestDTO crRuleTimecardAY = new LaborCostRequestDTO();
		crRuleTimecardAY.setShiftId("59e523bf1e4fa3000702ae74");
		crRuleTimecardAY.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 09:00:00 IST 2019"));
		crRuleTimecardAY.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 11:30:00 IST 2019"));
		crRuleTimecardAY.setPayRate(10);
		crRuleTimecardAY.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardAY.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardAY.setLocationId("l2");
		crRuleTimecardAY.setDurationInSeconds(32400);
		crRuleTimecardAY.setBreaks(1000 * 60 * 30);
		weekTimecards.add(crRuleTimecardAY);

		LaborCostRequestDTO crRuleTimecardAZ = new LaborCostRequestDTO();
		crRuleTimecardAZ.setShiftId("59e523bf1e4fa3000702ae74");
		crRuleTimecardAZ.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 11:30:00 IST 2019"));
		crRuleTimecardAZ.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 15:45:00 IST 2019"));
		crRuleTimecardAZ.setPayRate(10);
		crRuleTimecardAZ.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardAZ.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardAZ.setLocationId("l2");
		crRuleTimecardAZ.setDurationInSeconds(32400);
		crRuleTimecardAZ.setBreaks(1000 * 60 * 30);
		weekTimecards.add(crRuleTimecardAZ);

		LaborCostRequestDTO crRuleTimecardBA = new LaborCostRequestDTO();
		crRuleTimecardBA.setShiftId("59e523bf1e4fa3000702ae74");
		crRuleTimecardBA.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 15:45:00 IST 2019"));
		crRuleTimecardBA.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 16:00:00 IST 2019"));
		crRuleTimecardBA.setPayRate(10);
		crRuleTimecardBA.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardBA.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardBA.setLocationId("l2");
		crRuleTimecardBA.setDurationInSeconds(32400);
		crRuleTimecardBA.setBreaks(1000 * 60 * 30);
		weekTimecards.add(crRuleTimecardBA);

		LaborCostRequestDTO costRequestDTOG = new LaborCostRequestDTO();
		costRequestDTOG.setShiftId("59e523bf1e4fa3000702ae74");
		costRequestDTOG.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 15:45:00 IST 2019"));
		costRequestDTOG.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 17:00:00 IST 2019"));
		costRequestDTOG.setPayRate(10);
		costRequestDTOG.setEmpId("56a8fde4d53590000a00009d");
		costRequestDTOG.setEmpPositionId("56ab9c41cf8b48000a00001e");
		costRequestDTOG.setLocationId("l2");
		costRequestDTOG.setWorkWeek(1);
		costRequestDTOG.setDurationInSeconds(32400);
		costRequestDTOG.setBreaks(1000 * 60 * 30);
		costRequestDTOG.setWeekTimecards(weekTimecards);

		return costRequestDTOG;
	}

	public static LaborCostRequestDTO getRuleDataCaliforniaWeeklyOTVerified() throws ParseException {
		// Verified
		List<LaborCostRequestDTO> weekTimecards = new ArrayList<>();

		LaborCostRequestDTO crRuleTimecardBB = new LaborCostRequestDTO();
		crRuleTimecardBB.setShiftId("59e523bf1e4fa3000702ae70");
		crRuleTimecardBB.setTimecardStartDate(DateUtils.getDateInFormat("Sun Mar 10 09:00:00 IST 2019"));
		crRuleTimecardBB.setTimecardEndDate(DateUtils.getDateInFormat("Sun Mar 10 17:00:00 IST 2019"));
		crRuleTimecardBB.setPayRate(10);
		crRuleTimecardBB.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardBB.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardBB.setLocationId("l2");
		crRuleTimecardBB.setDurationInSeconds(32400);
		crRuleTimecardBB.setBreaks(1000 * 60 * 30);
		weekTimecards.add(crRuleTimecardBB);

		LaborCostRequestDTO crRuleTimecardBC = new LaborCostRequestDTO();
		crRuleTimecardBC.setShiftId("59e523bf1e4fa3000702ae70");
		crRuleTimecardBC.setTimecardStartDate(DateUtils.getDateInFormat("Mon Mar 11 09:00:00 IST 2019"));
		crRuleTimecardBC.setTimecardEndDate(DateUtils.getDateInFormat("Mon Mar 11 17:00:00 IST 2019"));
		crRuleTimecardBC.setPayRate(10);
		crRuleTimecardBC.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardBC.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardBC.setLocationId("l2");
		crRuleTimecardBC.setDurationInSeconds(32400);
		crRuleTimecardBC.setBreaks(1000 * 60 * 30);
		weekTimecards.add(crRuleTimecardBC);

		LaborCostRequestDTO crRuleTimecardBD = new LaborCostRequestDTO();
		crRuleTimecardBD.setShiftId("59e523bf1e4fa3000702ae71");
		crRuleTimecardBD.setTimecardStartDate(DateUtils.getDateInFormat("Tue Mar 12 09:00:00 IST 2019"));
		crRuleTimecardBD.setTimecardEndDate(DateUtils.getDateInFormat("Tue Mar 12 15:00:00 IST 2019"));
		crRuleTimecardBD.setPayRate(10);
		crRuleTimecardBD.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardBD.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardBD.setLocationId("l2");
		crRuleTimecardBD.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardBD);

		LaborCostRequestDTO crRuleTimecardBE = new LaborCostRequestDTO();
		crRuleTimecardBE.setShiftId("59e523bf1e4fa3000702ae71");
		crRuleTimecardBE.setTimecardStartDate(DateUtils.getDateInFormat("Wed Mar 13 09:00:00 IST 2019"));
		crRuleTimecardBE.setTimecardEndDate(DateUtils.getDateInFormat("Wed Mar 13 15:00:00 IST 2019"));
		crRuleTimecardBE.setPayRate(10);
		crRuleTimecardBE.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardBE.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardBE.setLocationId("l2");
		crRuleTimecardBE.setDurationInSeconds(32400);
		crRuleTimecardBE.setBreaks(1000 * 60 * 30);
		weekTimecards.add(crRuleTimecardBE);

		LaborCostRequestDTO crRuleTimecardBF = new LaborCostRequestDTO();
		crRuleTimecardBF.setShiftId("59e523bf1e4fa3000702ae73");
		crRuleTimecardBF.setTimecardStartDate(DateUtils.getDateInFormat("Thu Mar 14 09:00:00 IST 2019"));
		crRuleTimecardBF.setTimecardEndDate(DateUtils.getDateInFormat("Thu Mar 14 17:00:00 IST 2019"));
		crRuleTimecardBF.setPayRate(10);
		crRuleTimecardBF.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardBF.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardBF.setLocationId("l2");
		crRuleTimecardBF.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardBF);

		LaborCostRequestDTO crRuleTimecardBG = new LaborCostRequestDTO();
		crRuleTimecardBG.setShiftId("59e523bf1e4fa3000702ae73");
		crRuleTimecardBG.setTimecardStartDate(DateUtils.getDateInFormat("Thu Mar 14 15:00:00 IST 2019"));
		crRuleTimecardBG.setTimecardEndDate(DateUtils.getDateInFormat("Thu Mar 14 20:00:00 IST 2019"));
		crRuleTimecardBG.setPayRate(10);
		crRuleTimecardBG.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardBG.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardBG.setLocationId("l2");
		crRuleTimecardBG.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardBG);

		LaborCostRequestDTO crRuleTimecardBH = new LaborCostRequestDTO();
		crRuleTimecardBH.setShiftId("59e523bf1e4fa3000702ae74");
		crRuleTimecardBH.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 09:00:00 IST 2019"));
		crRuleTimecardBH.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 11:30:00 IST 2019"));
		crRuleTimecardBH.setPayRate(10);
		crRuleTimecardBH.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardBH.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardBH.setLocationId("l2");
		crRuleTimecardBH.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardBH);

		LaborCostRequestDTO crRuleTimecardBI = new LaborCostRequestDTO();
		crRuleTimecardBI.setShiftId("59e523bf1e4fa3000702ae74");
		crRuleTimecardBI.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 11:30:00 IST 2019"));
		crRuleTimecardBI.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 15:30:00 IST 2019"));
		crRuleTimecardBI.setPayRate(10);
		crRuleTimecardBI.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardBI.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardBI.setLocationId("l2");
		crRuleTimecardBI.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardBI);

		LaborCostRequestDTO crRuleTimecardBJ = new LaborCostRequestDTO();
		crRuleTimecardBJ.setShiftId("59e523bf1e4fa3000702ae74");
		crRuleTimecardBJ.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 15:30:00 IST 2019"));
		crRuleTimecardBJ.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 16:30:00 IST 2019"));
		crRuleTimecardBJ.setPayRate(10);
		crRuleTimecardBJ.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardBJ.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardBJ.setLocationId("l2");
		crRuleTimecardBJ.setDurationInSeconds(32400);
		crRuleTimecardBJ.setBreaks(1000 * 60 * 30);
		weekTimecards.add(crRuleTimecardBJ);

		LaborCostRequestDTO costRequestDTOH = new LaborCostRequestDTO();
		costRequestDTOH.setShiftId("59e523bf1e4fa3000702ae74");
		costRequestDTOH.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 15:30:00 IST 2019"));
		costRequestDTOH.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 16:30:00 IST 2019"));
		costRequestDTOH.setPayRate(10);
		costRequestDTOH.setEmpId("56a8fde4d53590000a00009d");
		costRequestDTOH.setEmpPositionId("56ab9c41cf8b48000a00001e");
		costRequestDTOH.setLocationId("l2");
		costRequestDTOH.setWorkWeek(1);
		costRequestDTOH.setDurationInSeconds(32400);
		costRequestDTOH.setBreaks(1000 * 60 * 30);
		costRequestDTOH.setWeekTimecards(weekTimecards);

		return costRequestDTOH;
	}

	public static LaborCostRequestDTO getRuleDataCaliforniaWeeklyOTVerifiedWithReg() throws ParseException {
		// Verified with Regular Wages
		List<LaborCostRequestDTO> weekTimecards = new ArrayList<>();

		LaborCostRequestDTO crRuleTimecardBK = new LaborCostRequestDTO();
		crRuleTimecardBK.setShiftId("59e523bf1e4fa3000702ae70");
		crRuleTimecardBK.setTimecardStartDate(DateUtils.getDateInFormat("Sun Mar 10 09:00:00 IST 2019"));
		crRuleTimecardBK.setTimecardEndDate(DateUtils.getDateInFormat("Sun Mar 10 17:00:00 IST 2019"));
		crRuleTimecardBK.setPayRate(10);
		crRuleTimecardBK.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardBK.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardBK.setLocationId("l2");
		crRuleTimecardBK.setDurationInSeconds(32400);
		crRuleTimecardBK.setBreaks(1000 * 60 * 30);
		weekTimecards.add(crRuleTimecardBK);

		LaborCostRequestDTO crRuleTimecardBL = new LaborCostRequestDTO();
		crRuleTimecardBL.setShiftId("59e523bf1e4fa3000702ae70");
		crRuleTimecardBL.setTimecardStartDate(DateUtils.getDateInFormat("Mon Mar 11 09:00:00 IST 2019"));
		crRuleTimecardBL.setTimecardEndDate(DateUtils.getDateInFormat("Mon Mar 11 17:00:00 IST 2019"));
		crRuleTimecardBL.setPayRate(10);
		crRuleTimecardBL.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardBL.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardBL.setLocationId("l2");
		crRuleTimecardBL.setDurationInSeconds(32400);
		crRuleTimecardBL.setBreaks(1000 * 60 * 30);
		weekTimecards.add(crRuleTimecardBL);

		LaborCostRequestDTO crRuleTimecardBM = new LaborCostRequestDTO();
		crRuleTimecardBM.setShiftId("59e523bf1e4fa3000702ae71");
		crRuleTimecardBM.setTimecardStartDate(DateUtils.getDateInFormat("Tue Mar 12 09:00:00 IST 2019"));
		crRuleTimecardBM.setTimecardEndDate(DateUtils.getDateInFormat("Tue Mar 12 15:00:00 IST 2019"));
		crRuleTimecardBM.setPayRate(10);
		crRuleTimecardBM.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardBM.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardBM.setLocationId("l2");
		crRuleTimecardBM.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardBM);

		LaborCostRequestDTO crRuleTimecardBN = new LaborCostRequestDTO();
		crRuleTimecardBN.setShiftId("59e523bf1e4fa3000702ae71");
		crRuleTimecardBN.setTimecardStartDate(DateUtils.getDateInFormat("Wed Mar 13 09:00:00 IST 2019"));
		crRuleTimecardBN.setTimecardEndDate(DateUtils.getDateInFormat("Wed Mar 13 15:00:00 IST 2019"));
		crRuleTimecardBN.setPayRate(10);
		crRuleTimecardBN.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardBN.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardBN.setLocationId("l2");
		crRuleTimecardBN.setDurationInSeconds(32400);
		crRuleTimecardBN.setBreaks(1000 * 60 * 30);
		weekTimecards.add(crRuleTimecardBN);

		LaborCostRequestDTO crRuleTimecardBO = new LaborCostRequestDTO();
		crRuleTimecardBO.setShiftId("59e523bf1e4fa3000702ae73");
		crRuleTimecardBO.setTimecardStartDate(DateUtils.getDateInFormat("Thu Mar 14 09:00:00 IST 2019"));
		crRuleTimecardBO.setTimecardEndDate(DateUtils.getDateInFormat("Thu Mar 14 17:00:00 IST 2019"));
		crRuleTimecardBO.setPayRate(10);
		crRuleTimecardBO.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardBO.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardBO.setLocationId("l2");
		crRuleTimecardBO.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardBO);

		LaborCostRequestDTO crRuleTimecardBP = new LaborCostRequestDTO();
		crRuleTimecardBP.setShiftId("59e523bf1e4fa3000702ae73");
		crRuleTimecardBP.setTimecardStartDate(DateUtils.getDateInFormat("Thu Mar 14 15:00:00 IST 2019"));
		crRuleTimecardBP.setTimecardEndDate(DateUtils.getDateInFormat("Thu Mar 14 20:00:00 IST 2019"));
		crRuleTimecardBP.setPayRate(10);
		crRuleTimecardBP.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardBP.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardBP.setLocationId("l2");
		crRuleTimecardBP.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardBP);

		LaborCostRequestDTO crRuleTimecardBQ = new LaborCostRequestDTO();
		crRuleTimecardBQ.setShiftId("59e523bf1e4fa3000702ae74");
		crRuleTimecardBQ.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 09:00:00 IST 2019"));
		crRuleTimecardBQ.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 11:30:00 IST 2019"));
		crRuleTimecardBQ.setPayRate(10);
		crRuleTimecardBQ.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardBQ.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardBQ.setLocationId("l2");
		crRuleTimecardBQ.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardBQ);

		LaborCostRequestDTO crRuleTimecardBR = new LaborCostRequestDTO();
		crRuleTimecardBR.setShiftId("59e523bf1e4fa3000702ae74");
		crRuleTimecardBR.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 11:30:00 IST 2019"));
		crRuleTimecardBR.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 13:30:00 IST 2019"));
		crRuleTimecardBR.setPayRate(10);
		crRuleTimecardBR.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardBR.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardBR.setLocationId("l2");
		crRuleTimecardBR.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardBR);

		LaborCostRequestDTO crRuleTimecardBS = new LaborCostRequestDTO();
		crRuleTimecardBS.setShiftId("59e523bf1e4fa3000702ae74");
		crRuleTimecardBS.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 13:30:00 IST 2019"));
		crRuleTimecardBS.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 16:30:00 IST 2019"));
		crRuleTimecardBS.setPayRate(10);
		crRuleTimecardBS.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardBS.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardBS.setLocationId("l2");
		crRuleTimecardBS.setDurationInSeconds(32400);
		crRuleTimecardBS.setBreaks(1000 * 60 * 30);
		weekTimecards.add(crRuleTimecardBS);

		LaborCostRequestDTO costRequestDTOI = new LaborCostRequestDTO();
		costRequestDTOI.setShiftId("59e523bf1e4fa3000702ae74");
		costRequestDTOI.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 13:30:00 IST 2019"));
		costRequestDTOI.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 16:30:00 IST 2019"));
		costRequestDTOI.setPayRate(10);
		costRequestDTOI.setEmpId("56a8fde4d53590000a00009d");
		costRequestDTOI.setEmpPositionId("56ab9c41cf8b48000a00001e");
		costRequestDTOI.setLocationId("l2");
		costRequestDTOI.setWorkWeek(1);
		costRequestDTOI.setDurationInSeconds(32400);
		costRequestDTOI.setBreaks(1000 * 60 * 30);
		costRequestDTOI.setWeekTimecards(weekTimecards);

		return costRequestDTOI;
	}

	public static LaborCostRequestDTO getRuleDataCaliforniaWeeklyOTVerifiedPartialTC() throws ParseException {
		// Verified (Total extra HRS = 1.5 & Current Timecard HRS = .75)
		List<LaborCostRequestDTO> weekTimecards = new ArrayList<>();

		LaborCostRequestDTO crRuleTimecardBT = new LaborCostRequestDTO();
		crRuleTimecardBT.setShiftId("59e523bf1e4fa3000702ae70");
		crRuleTimecardBT.setTimecardStartDate(DateUtils.getDateInFormat("Sun Mar 10 09:00:00 IST 2019"));
		crRuleTimecardBT.setTimecardEndDate(DateUtils.getDateInFormat("Sun Mar 10 16:00:00 IST 2019"));
		crRuleTimecardBT.setPayRate(10);
		crRuleTimecardBT.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardBT.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardBT.setLocationId("l2");
		crRuleTimecardBT.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardBT);

		LaborCostRequestDTO crRuleTimecardBU = new LaborCostRequestDTO();
		crRuleTimecardBU.setShiftId("59e523bf1e4fa3000702ae70");
		crRuleTimecardBU.setTimecardStartDate(DateUtils.getDateInFormat("Mon Mar 11 09:00:00 IST 2019"));
		crRuleTimecardBU.setTimecardEndDate(DateUtils.getDateInFormat("Mon Mar 11 15:00:00 IST 2019"));
		crRuleTimecardBU.setPayRate(10);
		crRuleTimecardBU.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardBU.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardBU.setLocationId("l2");
		crRuleTimecardBU.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardBU);

		LaborCostRequestDTO crRuleTimecardBV = new LaborCostRequestDTO();
		crRuleTimecardBV.setShiftId("59e523bf1e4fa3000702ae71");
		crRuleTimecardBV.setTimecardStartDate(DateUtils.getDateInFormat("Tue Mar 12 09:00:00 IST 2019"));
		crRuleTimecardBV.setTimecardEndDate(DateUtils.getDateInFormat("Tue Mar 12 16:00:00 IST 2019"));
		crRuleTimecardBV.setPayRate(10);
		crRuleTimecardBV.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardBV.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardBV.setLocationId("l2");
		crRuleTimecardBV.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardBV);

		LaborCostRequestDTO crRuleTimecardBW = new LaborCostRequestDTO();
		crRuleTimecardBW.setShiftId("59e523bf1e4fa3000702ae71");
		crRuleTimecardBW.setTimecardStartDate(DateUtils.getDateInFormat("Wed Mar 13 09:00:00 IST 2019"));
		crRuleTimecardBW.setTimecardEndDate(DateUtils.getDateInFormat("Wed Mar 13 15:00:00 IST 2019"));
		crRuleTimecardBW.setPayRate(10);
		crRuleTimecardBW.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardBW.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardBW.setLocationId("l2");
		crRuleTimecardBW.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardBW);

		LaborCostRequestDTO crRuleTimecardBX = new LaborCostRequestDTO();
		crRuleTimecardBX.setShiftId("59e523bf1e4fa3000702ae73");
		crRuleTimecardBX.setTimecardStartDate(DateUtils.getDateInFormat("Thu Mar 14 09:00:00 IST 2019"));
		crRuleTimecardBX.setTimecardEndDate(DateUtils.getDateInFormat("Thu Mar 14 17:00:00 IST 2019"));
		crRuleTimecardBX.setPayRate(10);
		crRuleTimecardBX.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardBX.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardBX.setLocationId("l2");
		crRuleTimecardBX.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardBX);

		LaborCostRequestDTO crRuleTimecardBY = new LaborCostRequestDTO();
		crRuleTimecardBY.setShiftId("59e523bf1e4fa3000702ae73");
		crRuleTimecardBY.setTimecardStartDate(DateUtils.getDateInFormat("Thu Mar 14 15:00:00 IST 2019"));
		crRuleTimecardBY.setTimecardEndDate(DateUtils.getDateInFormat("Thu Mar 14 20:00:00 IST 2019"));
		crRuleTimecardBY.setPayRate(10);
		crRuleTimecardBY.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardBY.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardBY.setLocationId("l2");
		crRuleTimecardBY.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardBY);

		LaborCostRequestDTO crRuleTimecardBZ = new LaborCostRequestDTO();
		crRuleTimecardBZ.setShiftId("59e523bf1e4fa3000702ae74");
		crRuleTimecardBZ.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 09:00:00 IST 2019"));
		crRuleTimecardBZ.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 11:30:00 IST 2019"));
		crRuleTimecardBZ.setPayRate(10);
		crRuleTimecardBZ.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardBZ.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardBZ.setLocationId("l2");
		crRuleTimecardBZ.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardBZ);

		LaborCostRequestDTO crRuleTimecardCA = new LaborCostRequestDTO();
		crRuleTimecardCA.setShiftId("59e523bf1e4fa3000702ae74");
		crRuleTimecardCA.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 11:30:00 IST 2019"));
		crRuleTimecardCA.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 15:45:00 IST 2019"));
		crRuleTimecardCA.setPayRate(10);
		crRuleTimecardCA.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardCA.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardCA.setLocationId("l2");
		crRuleTimecardCA.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardCA);

		LaborCostRequestDTO crRuleTimecardCB = new LaborCostRequestDTO();
		crRuleTimecardCB.setShiftId("59e523bf1e4fa3000702ae74");
		crRuleTimecardCB.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 15:45:00 IST 2019"));
		crRuleTimecardCB.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 16:30:00 IST 2019"));
		crRuleTimecardCB.setPayRate(10);
		crRuleTimecardCB.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardCB.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardCB.setLocationId("l2");
		crRuleTimecardCB.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardCB);

		LaborCostRequestDTO costRequestDTOJ = new LaborCostRequestDTO();
		costRequestDTOJ.setShiftId("59e523bf1e4fa3000702ae74");
		costRequestDTOJ.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 15:45:00 IST 2019"));
		costRequestDTOJ.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 16:30:00 IST 2019"));
		costRequestDTOJ.setPayRate(10);
		costRequestDTOJ.setEmpId("56a8fde4d53590000a00009d");
		costRequestDTOJ.setEmpPositionId("56ab9c41cf8b48000a00001e");
		costRequestDTOJ.setLocationId("l2");
		costRequestDTOJ.setWorkWeek(1);
		costRequestDTOJ.setDurationInSeconds(32400);
		costRequestDTOJ.setWeekTimecards(weekTimecards);

		return costRequestDTOJ;
	}

	public static LaborCostRequestDTO getRuleDataCaliforniaWeeklyOTVerifiedAfter8AndSOH() throws ParseException {
		// Verified with Daily Overtime(After 8) & SOH
		List<LaborCostRequestDTO> weekTimecards = new ArrayList<>();

		LaborCostRequestDTO crRuleTimecardCC = new LaborCostRequestDTO();
		crRuleTimecardCC.setShiftId("59e523bf1e4fa3000702ae70");
		crRuleTimecardCC.setTimecardStartDate(DateUtils.getDateInFormat("Sun Mar 10 09:00:00 IST 2019"));
		crRuleTimecardCC.setTimecardEndDate(DateUtils.getDateInFormat("Sun Mar 10 16:00:00 IST 2019"));
		crRuleTimecardCC.setPayRate(10);
		crRuleTimecardCC.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardCC.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardCC.setLocationId("l2");
		crRuleTimecardCC.setDurationInSeconds(32400);
		crRuleTimecardCC.setBreaks(1000 * 60 * 30);
		weekTimecards.add(crRuleTimecardCC);

		LaborCostRequestDTO crRuleTimecardCD = new LaborCostRequestDTO();
		crRuleTimecardCD.setShiftId("59e523bf1e4fa3000702ae70");
		crRuleTimecardCD.setTimecardStartDate(DateUtils.getDateInFormat("Mon Mar 11 09:00:00 IST 2019"));
		crRuleTimecardCD.setTimecardEndDate(DateUtils.getDateInFormat("Mon Mar 11 15:00:00 IST 2019"));
		crRuleTimecardCD.setPayRate(10);
		crRuleTimecardCD.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardCD.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardCD.setLocationId("l2");
		crRuleTimecardCD.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardCD);

		LaborCostRequestDTO crRuleTimecardCE = new LaborCostRequestDTO();
		crRuleTimecardCE.setShiftId("59e523bf1e4fa3000702ae71");
		crRuleTimecardCE.setTimecardStartDate(DateUtils.getDateInFormat("Tue Mar 12 09:00:00 IST 2019"));
		crRuleTimecardCE.setTimecardEndDate(DateUtils.getDateInFormat("Tue Mar 12 16:00:00 IST 2019"));
		crRuleTimecardCE.setPayRate(10);
		crRuleTimecardCE.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardCE.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardCE.setLocationId("l2");
		crRuleTimecardCE.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardCE);

		LaborCostRequestDTO crRuleTimecardCF = new LaborCostRequestDTO();
		crRuleTimecardCF.setShiftId("59e523bf1e4fa3000702ae71");
		crRuleTimecardCF.setTimecardStartDate(DateUtils.getDateInFormat("Wed Mar 13 09:00:00 IST 2019"));
		crRuleTimecardCF.setTimecardEndDate(DateUtils.getDateInFormat("Wed Mar 13 15:00:00 IST 2019"));
		crRuleTimecardCF.setPayRate(10);
		crRuleTimecardCF.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardCF.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardCF.setLocationId("l2");
		crRuleTimecardCF.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardCF);

		LaborCostRequestDTO crRuleTimecardCG = new LaborCostRequestDTO();
		crRuleTimecardCG.setShiftId("59e523bf1e4fa3000702ae73");
		crRuleTimecardCG.setTimecardStartDate(DateUtils.getDateInFormat("Thu Mar 14 09:00:00 IST 2019"));
		crRuleTimecardCG.setTimecardEndDate(DateUtils.getDateInFormat("Thu Mar 14 17:00:00 IST 2019"));
		crRuleTimecardCG.setPayRate(10);
		crRuleTimecardCG.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardCG.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardCG.setLocationId("l2");
		crRuleTimecardCG.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardCG);

		LaborCostRequestDTO crRuleTimecardCH = new LaborCostRequestDTO();
		crRuleTimecardCH.setShiftId("59e523bf1e4fa3000702ae73");
		crRuleTimecardCH.setTimecardStartDate(DateUtils.getDateInFormat("Thu Mar 14 15:00:00 IST 2019"));
		crRuleTimecardCH.setTimecardEndDate(DateUtils.getDateInFormat("Thu Mar 14 20:00:00 IST 2019"));
		crRuleTimecardCH.setPayRate(10);
		crRuleTimecardCH.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardCH.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardCH.setLocationId("l2");
		crRuleTimecardCH.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardCH);

		LaborCostRequestDTO crRuleTimecardCI = new LaborCostRequestDTO();
		crRuleTimecardCI.setShiftId("59e523bf1e4fa3000702ae74");
		crRuleTimecardCI.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 09:00:00 IST 2019"));
		crRuleTimecardCI.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 11:30:00 IST 2019"));
		crRuleTimecardCI.setPayRate(10);
		crRuleTimecardCI.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardCI.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardCI.setLocationId("l2");
		crRuleTimecardCI.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardCI);

		LaborCostRequestDTO crRuleTimecardCJ = new LaborCostRequestDTO();
		crRuleTimecardCJ.setShiftId("59e523bf1e4fa3000702ae74");
		crRuleTimecardCJ.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 11:30:00 IST 2019"));
		crRuleTimecardCJ.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 12:45:00 IST 2019"));
		crRuleTimecardCJ.setPayRate(10);
		crRuleTimecardCJ.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardCJ.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardCJ.setLocationId("l2");
		crRuleTimecardCJ.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardCJ);

		LaborCostRequestDTO crRuleTimecardCK = new LaborCostRequestDTO();
		crRuleTimecardCK.setShiftId("59e523bf1e4fa3000702ae74");
		crRuleTimecardCK.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 12:45:00 IST 2019"));
		crRuleTimecardCK.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 19:30:00 IST 2019"));
		crRuleTimecardCK.setPayRate(10);
		crRuleTimecardCK.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardCK.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardCK.setLocationId("l2");
		crRuleTimecardCK.setDurationInSeconds(32400);
		crRuleTimecardCK.setBreaks(1000 * 60 * 30);
		weekTimecards.add(crRuleTimecardCK);

		LaborCostRequestDTO costRequestDTOK = new LaborCostRequestDTO();
		costRequestDTOK.setShiftId("59e523bf1e4fa3000702ae74");
		costRequestDTOK.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 12:45:00 IST 2019"));
		costRequestDTOK.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 19:30:00 IST 2019"));
		costRequestDTOK.setPayRate(10);
		costRequestDTOK.setEmpId("56a8fde4d53590000a00009d");
		costRequestDTOK.setEmpPositionId("56ab9c41cf8b48000a00001e");
		costRequestDTOK.setLocationId("l2");
		costRequestDTOK.setWorkWeek(1);
		costRequestDTOK.setDurationInSeconds(32400);
		costRequestDTOK.setBreaks(1000 * 60 * 30);
		costRequestDTOK.setWeekTimecards(weekTimecards);

		return costRequestDTOK;
	}

	public static LaborCostRequestDTO getRuleDataCaliforniaForFullDay() throws ParseException {
		// Verified with Daily Overtime(After 8) & SOH
		List<LaborCostRequestDTO> weekTimecards = new ArrayList<>();

		LaborCostRequestDTO crRuleTimecardCL = new LaborCostRequestDTO();
		crRuleTimecardCL.setShiftId("59e523bf1e4fa3000702ae70");
		crRuleTimecardCL.setTimecardStartDate(DateUtils.getDateInFormat("Sun Mar 10 09:00:00 IST 2019"));
		crRuleTimecardCL.setTimecardEndDate(DateUtils.getDateInFormat("Sun Mar 10 16:00:00 IST 2019"));
		crRuleTimecardCL.setPayRate(10);
		crRuleTimecardCL.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardCL.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardCL.setLocationId("l2");
		crRuleTimecardCL.setDurationInSeconds(32400);
		crRuleTimecardCL.setBreaks(1000 * 60 * 30);
		weekTimecards.add(crRuleTimecardCL);

		LaborCostRequestDTO crRuleTimecardCM = new LaborCostRequestDTO();
		crRuleTimecardCM.setShiftId("59e523bf1e4fa3000702ae70");
		crRuleTimecardCM.setTimecardStartDate(DateUtils.getDateInFormat("Mon Mar 11 09:00:00 IST 2019"));
		crRuleTimecardCM.setTimecardEndDate(DateUtils.getDateInFormat("Mon Mar 11 15:00:00 IST 2019"));
		crRuleTimecardCM.setPayRate(10);
		crRuleTimecardCM.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardCM.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardCM.setLocationId("l2");
		crRuleTimecardCM.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardCM);

		LaborCostRequestDTO crRuleTimecardCN = new LaborCostRequestDTO();
		crRuleTimecardCN.setShiftId("59e523bf1e4fa3000702ae71");
		crRuleTimecardCN.setTimecardStartDate(DateUtils.getDateInFormat("Tue Mar 12 09:00:00 IST 2019"));
		crRuleTimecardCN.setTimecardEndDate(DateUtils.getDateInFormat("Tue Mar 12 16:00:00 IST 2019"));
		crRuleTimecardCN.setPayRate(10);
		crRuleTimecardCN.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardCN.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardCN.setLocationId("l2");
		crRuleTimecardCN.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardCN);

		LaborCostRequestDTO crRuleTimecardCO = new LaborCostRequestDTO();
		crRuleTimecardCO.setShiftId("59e523bf1e4fa3000702ae71");
		crRuleTimecardCO.setTimecardStartDate(DateUtils.getDateInFormat("Wed Mar 13 09:00:00 IST 2019"));
		crRuleTimecardCO.setTimecardEndDate(DateUtils.getDateInFormat("Wed Mar 13 15:00:00 IST 2019"));
		crRuleTimecardCO.setPayRate(10);
		crRuleTimecardCO.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardCO.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardCO.setLocationId("l2");
		crRuleTimecardCO.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardCO);

		LaborCostRequestDTO crRuleTimecardCP = new LaborCostRequestDTO();
		crRuleTimecardCP.setShiftId("59e523bf1e4fa3000702ae73");
		crRuleTimecardCP.setTimecardStartDate(DateUtils.getDateInFormat("Thu Mar 14 09:00:00 IST 2019"));
		crRuleTimecardCP.setTimecardEndDate(DateUtils.getDateInFormat("Thu Mar 14 17:00:00 IST 2019"));
		crRuleTimecardCP.setPayRate(10);
		crRuleTimecardCP.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardCP.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardCP.setLocationId("l2");
		crRuleTimecardCP.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardCP);

		LaborCostRequestDTO crRuleTimecardCQ = new LaborCostRequestDTO();
		crRuleTimecardCQ.setShiftId("59e523bf1e4fa3000702ae73");
		crRuleTimecardCQ.setTimecardStartDate(DateUtils.getDateInFormat("Thu Mar 14 15:00:00 IST 2019"));
		crRuleTimecardCQ.setTimecardEndDate(DateUtils.getDateInFormat("Thu Mar 14 20:00:00 IST 2019"));
		crRuleTimecardCQ.setPayRate(10);
		crRuleTimecardCQ.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardCQ.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardCQ.setLocationId("l2");
		crRuleTimecardCQ.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardCQ);

		LaborCostRequestDTO crRuleTimecardCR = new LaborCostRequestDTO();
		crRuleTimecardCR.setShiftId("59e523bf1e4fa3000702ae74");
		crRuleTimecardCR.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 09:00:00 IST 2019"));
		crRuleTimecardCR.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 11:30:00 IST 2019"));
		crRuleTimecardCR.setPayRate(10);
		crRuleTimecardCR.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardCR.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardCR.setLocationId("l2");
		crRuleTimecardCR.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardCR);

		LaborCostRequestDTO crRuleTimecardCS = new LaborCostRequestDTO();
		crRuleTimecardCS.setShiftId("59e523bf1e4fa3000702ae74");
		crRuleTimecardCS.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 11:30:00 IST 2019"));
		crRuleTimecardCS.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 12:45:00 IST 2019"));
		crRuleTimecardCS.setPayRate(10);
		crRuleTimecardCS.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardCS.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardCS.setLocationId("l2");
		crRuleTimecardCS.setDurationInSeconds(32400);
		weekTimecards.add(crRuleTimecardCS);

		LaborCostRequestDTO crRuleTimecardCT = new LaborCostRequestDTO();
		crRuleTimecardCT.setShiftId("59e523bf1e4fa3000702ae74");
		crRuleTimecardCT.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 12:45:00 IST 2019"));
		crRuleTimecardCT.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 24:00:00 IST 2019"));
		crRuleTimecardCT.setPayRate(10);
		crRuleTimecardCT.setEmpId("56a8fde4d53590000a00009d");
		crRuleTimecardCT.setEmpPositionId("56ab9c41cf8b48000a00001e");
		crRuleTimecardCT.setLocationId("l2");
		crRuleTimecardCT.setDurationInSeconds(32400);
		crRuleTimecardCT.setBreaks(1000 * 60 * 30);
		weekTimecards.add(crRuleTimecardCT);

		LaborCostRequestDTO costRequestDTOL = new LaborCostRequestDTO();
		costRequestDTOL.setShiftId("59e523bf1e4fa3000702ae74");
		costRequestDTOL.setTimecardStartDate(DateUtils.getDateInFormat("Fri Mar 15 12:45:00 IST 2019"));
		costRequestDTOL.setTimecardEndDate(DateUtils.getDateInFormat("Fri Mar 15 24:00:00 IST 2019"));
		costRequestDTOL.setPayRate(10);
		costRequestDTOL.setEmpId("56a8fde4d53590000a00009d");
		costRequestDTOL.setEmpPositionId("56ab9c41cf8b48000a00001e");
		costRequestDTOL.setLocationId("l2");
		costRequestDTOL.setWorkWeek(1);
		costRequestDTOL.setDurationInSeconds(32400);
		costRequestDTOL.setBreaks(1000 * 60 * 30);
		costRequestDTOL.setWeekTimecards(weekTimecards);

		return costRequestDTOL;
	}

}

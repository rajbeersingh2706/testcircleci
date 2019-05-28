package com.salido.labor.cost;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.salido.labor.bean.RuleExpressionResult;
import com.salido.labor.bean.RuleExpressions;
import com.salido.labor.common.Constants;
import com.salido.labor.common.RuleProcessConstants;
import com.salido.labor.cost.logic.RuleResultProcessor;
import com.salido.labor.cost.util.RuleUtils;
import com.salido.labor.dto.LaborCostRequestDTO;
import com.salido.labor.logic.RuleCommonLogic;
import com.salido.labor.util.DateUtils;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

@Qualifier("otRuleResultProcessor")
@Component
public class OTRuleResultProcessor implements RuleResultProcessor {

    @Autowired
    RuleCommonLogic commonLogic;

    @Autowired
    RuleUtils ruleUtils;

    @Autowired
    DateUtils dateUtils;

    private static final Logger LOGGER = LogManager.getLogger(OTRuleResultProcessor.class);

    @Override
    public LaborCostRequestDTO process(LaborCostRequestDTO costRequestDTO, RuleExpressions expression) {
        List<JSONObject> otArray = new ArrayList<>();
        List<RuleExpressionResult> expressionResults = expression.getExpressionResult();
        Collections.sort(expressionResults);
        Date lastOtStartDate = null;
        double totalOldHrs = 0;
        if (costRequestDTO.getTimecardCost().size() > 0) {
            Map<String, Object> sortedMap = commonLogic.sortMapByValue(costRequestDTO.getTimecardCost(),
                    RuleProcessConstants.LaborCostKeys.HOURS);
            Map<String, Object> sortedMap1 = commonLogic.sortMapByValue(costRequestDTO.getTimecardCost(),
                    RuleProcessConstants.LaborCostKeys.START_TIME);
            lastOtStartDate = dateUtils.stringToDate(sortedMap1.entrySet().iterator().next().getValue().toString(),
                    DateUtils.DATE_FORMAT_FULL);
            Set<Entry<String, Object>> entries = sortedMap.entrySet();
            for (Entry<String, Object> entry : entries) {
                totalOldHrs += Double.parseDouble(entry.getValue().toString());
            }

        }
        for (RuleExpressionResult expressionResult : expressionResults) {
            costRequestDTO
                    .setBlendedRate(ruleUtils.formatDouble(getRate(costRequestDTO, expressionResult, expression)));
            double multiplier = getMultiplier(expressionResult);
            String otType = getOtType(expressionResult.getTimeframe(), String.valueOf(multiplier));
            Date startedAt = getStartTime(costRequestDTO, expressionResult, expression, lastOtStartDate, otType);
            JSONObject otAmountObj = new JSONObject();
            otAmountObj.put(RuleProcessConstants.LaborCostKeys.START_TIME,
                    dateUtils.dateToString(startedAt, DateUtils.DATE_FORMAT_FULL));
            otAmountObj.put(RuleProcessConstants.LaborCostKeys.PAY_RATE,
                    ruleUtils.formatDouble(getOTWagePerHour(costRequestDTO, multiplier)));
            otAmountObj.put(RuleProcessConstants.LaborCostKeys.OT_TYPE, otType);
            otArray.add(otAmountObj);
        }

        prepareResponse(costRequestDTO, expression, otArray, lastOtStartDate);
        return costRequestDTO;
    }

    private void prepareResponse(LaborCostRequestDTO processDTO, RuleExpressions ruleExpressions,
            List<JSONObject> otArray, Date lastOtStartDate) {
        otArray = commonLogic.sortJsonList(otArray, RuleProcessConstants.LaborCostKeys.START_TIME,
                Constants.SORT_ORDER_DESC);
        Date endedAt = null;
        /*
         * Assigning last OT objects start date to current object end date, if
         * any available
         */
        if (lastOtStartDate != null) {
           // endedAt = lastOtStartDate;
        }
        for (JSONObject otObject : otArray) {
            if (endedAt == null) {
                endedAt = getEndTime(processDTO, ruleExpressions);
            }

            String otType = otObject.getString(RuleProcessConstants.LaborCostKeys.OT_TYPE);
            updateOtObject(getKey(otType, RuleProcessConstants.LaborCostKeys.START_TIME),
                    (String) otObject.get(RuleProcessConstants.LaborCostKeys.START_TIME), processDTO);

            updateOtObject(getKey(otType, RuleProcessConstants.LaborCostKeys.END_TIME),
                    dateUtils.dateToString(endedAt, DateUtils.DATE_FORMAT_FULL), processDTO);

            Date startDate = dateUtils.stringToDate(
                    (String) otObject.get(RuleProcessConstants.LaborCostKeys.START_TIME), DateUtils.DATE_FORMAT_FULL);
            LOGGER.debug("endedAt\t" + endedAt + "\tstartDate\t" + startDate);
            double hours = dateUtils.getHours(endedAt.getTime() - startDate.getTime());
            LOGGER.debug("hours> " + hours);

            updateOtObject(getKey(otType, RuleProcessConstants.LaborCostKeys.AMOUNT),
                    ruleUtils
                            .formatDouble((otObject.getDouble(RuleProcessConstants.LaborCostKeys.PAY_RATE) * hours)),
                    processDTO);
            double workedInMilis = hours * 60 * 60;
            updateOtObject(getKey(otType, RuleProcessConstants.LaborCostKeys.HOURS), workedInMilis, processDTO);
            if (workedInMilis > 0) {
                updateOtObject(RuleProcessConstants.LaborCostKeys.HAS_OT, true, processDTO);
            }
            updateOtObject(getKey(otType, RuleProcessConstants.LaborCostKeys.PAY_RATE),
                    otObject.getString(RuleProcessConstants.LaborCostKeys.PAY_RATE), processDTO);

            /*
             * For all next TC, start date of current TC will be used as end
             * date for all next
             */
            endedAt = startDate;
        }
    }

    private double getMultiplier(RuleExpressionResult expressionResult) {
        JSONObject modifire = (JSONObject) JSONSerializer.toJSON(expressionResult.getModifier());
        return modifire.getDouble(RuleProcessConstants.Modifire.MULTIPLIER);
    }

    private String getKey(String otType, String key) {
        return otType + "_" + key;
    }

    private void updateOtObject(String key, Object value, LaborCostRequestDTO costRequestDTO) {
        costRequestDTO.getTimecardCost().put(key, value);
    }

    private String getOtType(String timeFrame, String multiplier) {
        String otType = RuleProcessConstants.LaborCostKeys.OT;
        if (RuleProcessConstants.LaborCostKeys.ONE.equalsIgnoreCase(multiplier)) {
            otType = RuleProcessConstants.LaborCostKeys.DOT;
        } else if (RuleProcessConstants.Timecard.WORK_WEEK.equalsIgnoreCase(timeFrame)) {
            otType = RuleProcessConstants.LaborCostKeys.WOT;
        }
        return otType;
    }

    private Date getEndTime(LaborCostRequestDTO processDTO, RuleExpressions ruleExpressions) {
        Calendar calendarEndDate = Calendar.getInstance();
        calendarEndDate.setTime(processDTO.getTimecardEndDate());

        /*
         * Processing precondition here (Returned worked hours based on the
         * precondition suppose Until 8 hrs of the day. )
         */
        if (ruleExpressions != null && ruleExpressions.getPreCondition() != null
                && !ruleExpressions.getPreCondition().isEmpty()) {
            double hoursWorked = ruleUtils.getCurrentTCWorkedHours(processDTO);
            hoursWorked = ruleUtils.processPreCondition(ruleExpressions, hoursWorked);
            calendarEndDate.setTime(processDTO.getTimecardStartDate());
            double breaks = dateUtils.getHours(processDTO.getBreaks());
            calendarEndDate.add(Calendar.MINUTE, dateUtils.getMinuts(hoursWorked + breaks));
        }
        return calendarEndDate.getTime();
    }

    // Get OT wage applicable as per rule per hour
    private double getOTWagePerHour(LaborCostRequestDTO processDTO, double multiplier) {
        double wagePerHour = processDTO.getPayRate() + (processDTO.getBlendedRate() * multiplier);
        LOGGER.debug("processDTO.getPayRate()\t" + processDTO.getPayRate() + " :processDTO.getBlendedRate()\t"
                + processDTO.getBlendedRate() + " :wagePerHour\t" + wagePerHour);
        return wagePerHour;
    }
    
 // Get OT start time.
    private Date getStartTimeOrig(LaborCostRequestDTO costRequestDTO, RuleExpressionResult expressionResult,
            RuleExpressions expression, double totalOldHrs, String otType) {
        Calendar calendarDate = Calendar.getInstance();
        calendarDate.setTime(costRequestDTO.getTimecardStartDate());
        double currentTCWorkedHours = ruleUtils.getCurrentTCWorkedHours(costRequestDTO);
        currentTCWorkedHours = ruleUtils.processPreCondition(expression, currentTCWorkedHours);
        List<LaborCostRequestDTO> currentDayTcList = costRequestDTO.getWeekTimecards();

        if (RuleProcessConstants.Timecard.DAY.equalsIgnoreCase(expressionResult.getTimeframe().trim())) {
            currentDayTcList = costRequestDTO.getCurrentDayTimecards();
        }
        double todayPaidHrs = ruleUtils.getPaidOTHrs(costRequestDTO, currentDayTcList, expressionResult, expression, otType);
        double hrsToPaid = (currentTCWorkedHours - todayPaidHrs) + dateUtils.getHours(costRequestDTO.getBreaks());
        calendarDate.add(Calendar.MINUTE, dateUtils.getMinuts(hrsToPaid));
        Date shiftOtStartDate = validateOTStartTime(costRequestDTO, calendarDate.getTime());
        return shiftOtStartDate;
    }
    
 // Get OT start time.
    private Date getStartTime(LaborCostRequestDTO costRequestDTO, RuleExpressionResult expressionResult,
            RuleExpressions expression, Date lastOtStartDate,String otType) {
        Calendar calendarDate = Calendar.getInstance();
        double currentTCWorkedHours = ruleUtils.getCurrentTCWorkedHours(costRequestDTO);
        currentTCWorkedHours = ruleUtils.processPreCondition(expression, currentTCWorkedHours);
        List<LaborCostRequestDTO> currentDayTcList = costRequestDTO.getWeekTimecards();

        if (RuleProcessConstants.Timecard.DAY.equalsIgnoreCase(expressionResult.getTimeframe().trim())) {
            currentDayTcList = costRequestDTO.getCurrentDayTimecards();
        }
        double todayPaidHrs = ruleUtils.getPaidOTHrs(costRequestDTO, currentDayTcList, expressionResult, expression, otType);
        /*if(lastOtStartDate != null){
            calendarDate.setTime(lastOtStartDate);
            calendarDate.add(Calendar.MINUTE, -dateUtils.getMinuts(todayPaidHrs));
        }else{*/
            double hrsToPaid = (currentTCWorkedHours - todayPaidHrs)+dateUtils.getHours(costRequestDTO.getBreaks());
            calendarDate.setTime(costRequestDTO.getTimecardStartDate());
            calendarDate.add(Calendar.MINUTE, dateUtils.getMinuts(hrsToPaid));
        //}
        return validateOTStartTime(costRequestDTO, calendarDate.getTime());
    }

  
    /*
     * Check If shift OT start time is starts from less than current time card
     * start time after break deduction in case WOT processed before OT.
     */
    private Date validateOTStartTime(LaborCostRequestDTO costRequestDTO, Date otStartDate) {
        Calendar currentTCStartDate = Calendar.getInstance();
        currentTCStartDate.setTime(costRequestDTO.getTimecardStartDate());
        currentTCStartDate.add(Calendar.MINUTE, dateUtils.getMinutsFromMillis(costRequestDTO.getBreaks()));
        if (currentTCStartDate.getTime().after(otStartDate)) {
            otStartDate = currentTCStartDate.getTime();
        }
        return otStartDate;

    }

    /*
     * Check If shift OT start time is starts from less than current time card
     * start time after break deduction in case WOT processed before OT.
     */
    private Date verifyShiftOtStartTime(LaborCostRequestDTO costRequestDTO, RuleExpressionResult expressionResult,
            Date shiftOtStartDate) {
        Calendar calendarInstance = Calendar.getInstance();
        List<LaborCostRequestDTO> currentDayTcList = costRequestDTO.getCurrentDayTimecards();
        calendarInstance.setTime(currentDayTcList.get(0).getTimecardStartDate());
        /*
         * Get hrs paid after value and add break in to it then convert in to
         * minutes
         */
        int currentDayHrs = dateUtils.getMinuts(Integer.parseInt(expressionResult.getHoursPaidValue()))
                + dateUtils.getMinutsFromMillis(costRequestDTO.getBreaks());
        calendarInstance.add(Calendar.MINUTE, currentDayHrs);
        /*
         * Check If shift OT start time is starts from less than current time
         * card start time after break deduction.
         */
        if (calendarInstance.getTime().getTime() > shiftOtStartDate.getTime()) {
            shiftOtStartDate = calendarInstance.getTime();
        }
        return shiftOtStartDate;
    }

    // Calculating Blended rate.
    private double getRate(LaborCostRequestDTO costRequestDTO, RuleExpressionResult expressionResult,
            RuleExpressions expression) {
        List<LaborCostRequestDTO> timecardsList = costRequestDTO.getWeekTimecards();
        if (RuleProcessConstants.Timecard.DAY.equalsIgnoreCase(expressionResult.getTimeframe().trim())) {
            timecardsList = costRequestDTO.getCurrentDayTimecards();
        }
        return ruleUtils.getBlendedRate(timecardsList, expression);
    }

}

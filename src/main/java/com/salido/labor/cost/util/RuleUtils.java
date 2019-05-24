package com.salido.labor.cost.util;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.salido.labor.bean.RuleExpressionResult;
import com.salido.labor.bean.RuleExpressions;
import com.salido.labor.common.RuleProcessConstants;
import com.salido.labor.dto.LaborCostRequestDTO;
import com.salido.labor.util.DateUtils;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

@Component
public class RuleUtils {

    @Autowired
    DateUtils dateUtils;

    private static DecimalFormat df2 = new DecimalFormat(".##");
    static {
        df2.setRoundingMode(RoundingMode.HALF_UP);
    }

    private static final Logger LOGGER = LogManager.getLogger(RuleUtils.class);

    public double getTotalWorkedHours(List<LaborCostRequestDTO> cardDTOs, RuleExpressions ruleExpression) {
        return getTotalWorkedH(prepareDayTcList(cardDTOs), ruleExpression);
    }

    private List<List<LaborCostRequestDTO>> prepareDayTcList(List<LaborCostRequestDTO> cardDTOs) {
        List<List<LaborCostRequestDTO>> totalDaysTcList = new ArrayList<>();
        List<LaborCostRequestDTO> singleDayTcList = new ArrayList<>();
        String tcStartDate = null;
        for (LaborCostRequestDTO costRequestDTO : cardDTOs) {
            String tcStartedAtBean = dateUtils.dateToString(costRequestDTO.getTimecardStartDate(),
                    DateUtils.DATE_FORMAT_COMMON);

            if (!tcStartedAtBean.equalsIgnoreCase(tcStartDate)) {
                if (!singleDayTcList.isEmpty()) {
                    totalDaysTcList.add(singleDayTcList);
                }
                singleDayTcList = new ArrayList<>();
            }
            singleDayTcList.add(costRequestDTO);
            tcStartDate = tcStartedAtBean;
        }
        totalDaysTcList.add(singleDayTcList);
        return totalDaysTcList;
    }

    private double getTotalWorkedH(List<List<LaborCostRequestDTO>> pCardDTOs, RuleExpressions ruleExpression) {
        double weekWorkedHrsTotal = 0.0;
        for (List<LaborCostRequestDTO> cardDTOs : pCardDTOs) {
            double weekWorkedHrs = getDayHoursWorked(cardDTOs);
            weekWorkedHrsTotal += processPreCondition(ruleExpression, weekWorkedHrs);
        }
        return weekWorkedHrsTotal;
    }

    private double getDayHoursWorked(List<LaborCostRequestDTO> cardDTOs) {
        double weekWorkedHrs = 0.0;
        for (LaborCostRequestDTO cardDTO : cardDTOs) {
            weekWorkedHrs += getCurrentTCWorkedHours(cardDTO);
        }
        LOGGER.debug("SINGLE DAY TOTAL TIME\t" + weekWorkedHrs);
        return weekWorkedHrs;
    }

    public double getCurrentTCWorkedHours(LaborCostRequestDTO cardDTO) {
        long duration = cardDTO.getTimecardEndDate().getTime() - cardDTO.getTimecardStartDate().getTime();
        double totalWorkedHours = dateUtils.getHours(duration - cardDTO.getBreaks());
        return totalWorkedHours;
    }

    public double formatDouble(double value) {
        return Double.parseDouble(df2.format(value));
    }

     public double getPaidOTHrs(final LaborCostRequestDTO costRequestDTO, final List<LaborCostRequestDTO> cardDTOs,
            RuleExpressionResult expressionResult, RuleExpressions ruleExpression, String otType) {
        double totalTCHours = 0;
        double totalTCHoursExceptLatest = 0;
        double totalExtraHours = 0;
        double extraHrs = 0;
        double cndtnHours = Integer.parseInt(expressionResult.getHoursPaidValue());
        List<List<LaborCostRequestDTO>> totalTcDayList = prepareDayTcList(cardDTOs);
        List<LaborCostRequestDTO> latestAllDayTcCardList = new ArrayList<>();
        String latestTcStartDate = dateUtils.dateToString(costRequestDTO.getTimecardStartDate(),
                DateUtils.DATE_FORMAT_COMMON);

        for (List<LaborCostRequestDTO> cardDTOss : totalTcDayList) {
            extraHrs = 0;
            double durationInHr = getDayHoursWorked(cardDTOss);
            totalTCHours += processPreCondition(ruleExpression, durationInHr);
            boolean result = evalCondition(totalTCHours, cndtnHours, expressionResult.getHoursPaidMeasure());

            if (result) {
                extraHrs = (totalTCHours - (cndtnHours + totalExtraHours));
                totalExtraHours += extraHrs;
            }
            latestAllDayTcCardList = cardDTOss;

            String currentDTOStartDate = dateUtils.dateToString(cardDTOss.get(0).getTimecardStartDate(),
                    DateUtils.DATE_FORMAT_COMMON);

            if (!latestTcStartDate.equals(currentDTOStartDate)) {
                double tcDurationInHr = getDayHoursWorked(cardDTOss);
                totalTCHoursExceptLatest += processPreCondition(ruleExpression, tcDurationInHr);
            }

            LOGGER.debug("getPaidOTHrs: extraHrs->" + extraHrs + " : totalTCHours->" + totalTCHours);
        }

        if (RuleProcessConstants.LaborCostKeys.WOT.equalsIgnoreCase(otType) && latestAllDayTcCardList.size() > 1) {
            JSONObject preCondition = getPrecondition(ruleExpression);
            if (preCondition != null) {
                extraHrs+= checkIfConditionSatisfiedInPrevTcOfDay(latestAllDayTcCardList, expressionResult, latestTcStartDate,
                        totalTCHoursExceptLatest, preCondition);
            }

        }

        List<LaborCostRequestDTO> cardDTOss = totalTcDayList.get(totalTcDayList.size() - 1);
        double totalHrsOfLastTcOfDayTCs = getCurrentTCWorkedHours(cardDTOss.get(cardDTOss.size() - 1));
        if (extraHrs >= totalHrsOfLastTcOfDayTCs) {
            extraHrs = totalHrsOfLastTcOfDayTCs;
        }
        LOGGER.debug("getPaidOTHrs Get Total extraHrs\t" + extraHrs);
        return extraHrs;
    }

    private double checkIfConditionSatisfiedInPrevTcOfDay(List<LaborCostRequestDTO> latestAllDayTcCardList,
            RuleExpressionResult expressionResult, String latestTcStartDate, double totalTCHoursExceptLatest,
            JSONObject preCondition) {
        double totalTCHours = totalTCHoursExceptLatest;
        double totalExtraHours = 0;
        double extraHrs = 0;
        int itemCount = 1;
        double cndtnHours = Integer.parseInt(expressionResult.getHoursPaidValue());

        long hrWorkedUntill = preCondition.getLong(RuleProcessConstants.Param.HOURS_WORKED_UNTIL_DAY);

        String tcStartDate = "";
        double extraHrsForDay = 0;
        double currentDayTotalHours = 0;
        for (LaborCostRequestDTO localCardDTO : latestAllDayTcCardList) {
            extraHrs = 0;
            double durationInHr = getCurrentTCWorkedHours(localCardDTO);
            currentDayTotalHours += durationInHr;
            if (currentDayTotalHours > hrWorkedUntill) {
                durationInHr -= (currentDayTotalHours - cndtnHours);
            }
            totalTCHours += durationInHr;
            boolean result = evalCondition(totalTCHours, cndtnHours, expressionResult.getHoursPaidMeasure());
            if (result && itemCount < latestAllDayTcCardList.size()) {
                tcStartDate = dateUtils.dateToString(localCardDTO.getTimecardStartDate(), DateUtils.DATE_FORMAT_COMMON);

                if (latestTcStartDate.equalsIgnoreCase(tcStartDate)) {
                    extraHrs = (totalTCHours - (cndtnHours + totalExtraHours));
                    totalExtraHours += extraHrs;
                    extraHrsForDay += extraHrs;
                }
                if (currentDayTotalHours > cndtnHours) {
                    break;
                }

            }
            itemCount++;
            System.out.println(extraHrs + " : " + totalTCHours);
            LOGGER.debug("getWeeklyOTHrs: " + extraHrs + " : " + totalTCHours);
        }
        return extraHrsForDay;
    }

    public double processPreCondition(final RuleExpressions ruleExpression, final double hoursWorkedDay) {
        double hoursWorked = hoursWorkedDay;

        JSONObject preCondition = getPrecondition(ruleExpression);
        if (preCondition != null && preCondition.has(RuleProcessConstants.Param.HOURS_WORKED_UNTIL_DAY)) {
            long hrWorkedValue = preCondition.getLong(RuleProcessConstants.Param.HOURS_WORKED_UNTIL_DAY);
            if (hoursWorked >= hrWorkedValue) {
                hoursWorked = hrWorkedValue;
            }
        }
        return hoursWorked;
    }

    public JSONObject getPrecondition(final RuleExpressions ruleExpression) {
        JSONObject preCondition = null;
        if (ruleExpression != null && ruleExpression.getPreCondition() != null
                && !ruleExpression.getPreCondition().isEmpty()) {
            preCondition = (JSONObject) JSONSerializer.toJSON(ruleExpression.getPreCondition());
        }
        return preCondition;
    }

    public double getConditionParamValue(final LaborCostRequestDTO cardDTO, final RuleExpressions ruleExpression,
            String param) {
        List<LaborCostRequestDTO> cardDTOs = cardDTO.getWeekTimecards();
        double hoursWorked = 0;
        switch (param) {
        case RuleProcessConstants.Param.HOURS_WORKED_WEEK:
            hoursWorked = getTotalWorkedHours(cardDTOs, ruleExpression);
            break;

        case RuleProcessConstants.Param.HOURS_WORKED_DAY:
            hoursWorked = getTotalWorkedHours(cardDTO.getCurrentDayTimecards(), ruleExpression);
            break;

        case RuleProcessConstants.Param.DAYS_WORKED_WEEK:
            hoursWorked = getTimecardDay(cardDTO);
            break;

        default:
            break;
        }
        return hoursWorked;

    }

    public double getSohDayWorkedHours(final LaborCostRequestDTO costRequestDTO) {
        return getSohWorkedHours(costRequestDTO.getCurrentDayTimecards());
    }

    /*
     * 1st Shift, Start Time - Last Shift, End Time of the day
     */
    private double getSohWorkedHours(List<LaborCostRequestDTO> cardDTOs) {
        Date startDate = cardDTOs.get(0).getTimecardStartDate();
        Date endDate = cardDTOs.get(cardDTOs.size() - 1).getTimecardEndDate();
        long duration = endDate.getTime() - startDate.getTime();
        return dateUtils.getHours(duration);

    }

    // Filter time cards of the day
    public List<LaborCostRequestDTO> filterCurrentDateTC(LaborCostRequestDTO costRequestDTO) {
        String tcStartedAt = dateUtils.dateToString(costRequestDTO.getTimecardStartDate(),
                DateUtils.DATE_FORMAT_COMMON);
        List<LaborCostRequestDTO> timeCardsSubList = new ArrayList<>();
        for (LaborCostRequestDTO laborCostRequestDTO : costRequestDTO.getWeekTimecards()) {
            String tcStartedAtLocal = dateUtils.dateToString(laborCostRequestDTO.getTimecardStartDate(),
                    DateUtils.DATE_FORMAT_COMMON);
            if (tcStartedAt.equalsIgnoreCase(tcStartedAtLocal)) {
                timeCardsSubList.add(laborCostRequestDTO);
            }
        }
        return timeCardsSubList;
    }

    // To get day of time card
    public long getTimecardDay(LaborCostRequestDTO cardDTO) {
        int workWeek = cardDTO.getWorkWeek();
        Date workWeekTimeCardDate = getWorkWeekTimeCardStartDate(cardDTO.getTimecardStartDate(), workWeek);
        long duration = cardDTO.getTimecardStartDate().getTime() - workWeekTimeCardDate.getTime();
        long diffInDays = TimeUnit.MILLISECONDS.toDays(duration);
        LOGGER.debug("getTimecardDay-->" + diffInDays + ": workWeek" + workWeek + ": workWeekTimeCardDate"
                + workWeekTimeCardDate);
        return diffInDays + 1;
    }

    private Date getWorkWeekTimeCardStartDate(Date currentTCStartDate, int workWeek) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentTCStartDate);
        calendar.setFirstDayOfWeek(workWeek);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayOfWeek == 0) {
            dayOfWeek = 7;
        }
        int dayRange = dayOfWeek - calendar.getFirstDayOfWeek();
        if (workWeek > dayOfWeek) {
            dayRange = dayOfWeek + (7 - workWeek);
        }
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - dayRange);
        return new DateUtils().getFormatedDate(calendar.getTime(), DateUtils.DATE_FORMAT_COMMON);
    }

    private boolean evalCondition(double value1, double value2, String measure) {
        boolean result = false;
        switch (measure) {
        case RuleProcessConstants.Measure.LESS_THEN:
            result = value1 < value2;
            break;

        case RuleProcessConstants.Measure.GREATER_THEN:
            result = value1 > value2;
            break;

        case RuleProcessConstants.Measure.LESS_THEN_EQUAL:
            result = value1 <= value2;
            break;

        case RuleProcessConstants.Measure.GREATER_THEN_EQUAL:
            result = value1 <= value2;
            break;

        default:
            break;
        }

        return result;

    }

    public double getBlendedRate(List<LaborCostRequestDTO> cardDTOs, RuleExpressions ruleExpression) {
        double bRate = 0;
        double totalHWorked = 0;
        for (LaborCostRequestDTO cardDTO : cardDTOs) {
            double workedH = getCurrentTCWorkedHours(cardDTO);
            if (cardDTO.getPayRate() > 0 && workedH > 0) {
                totalHWorked += workedH;
                bRate += cardDTO.getPayRate() * workedH;
            }
        }
        return totalHWorked > 0 ? bRate / totalHWorked : 0;
    }

}

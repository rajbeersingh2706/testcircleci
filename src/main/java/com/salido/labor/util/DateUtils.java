package com.salido.labor.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class DateUtils {
	private static final Logger LOGGER = LogManager.getLogger(DateUtils.class);

	public static final String DATE_FORMAT_COMMON = "yyyy-MM-dd";
	public static final String DATE_FORMAT_FULL = "yyyy-MM-dd HH:mm:ss";

	public Date stringToDate(String date, String format) {
		try {
			SimpleDateFormat dateFormat = getDateFormat(format);
			return dateFormat.parse(date);
		} catch (Exception ex) {
			LOGGER.error("Exception in convertStringToDate-->", ex);
		}
		return null;

	}

	public String dateToString(Date date, String format) {
		DateFormat formatter = getDateFormat(format);
		return formatter.format(date);

	}

	public Timestamp getCurrentUTCDate() {
		Timestamp utcDate = new Timestamp(System.currentTimeMillis()
				- Calendar.getInstance().getTimeZone().getOffset(System.currentTimeMillis()));
		return utcDate;
	}

	public Date getFormatedDate(final Date date, final String format) {
		Date dateLocal = date;
		try {
			SimpleDateFormat sdf = getDateFormat(format);
			dateLocal = sdf.parse(sdf.format(date));
		} catch (ParseException e) {
			LOGGER.error("Exception in getFormatedDate-->", e + " -Input date->" + date + ": Format->" + format);
		}
		return dateLocal;
	}

	public SimpleDateFormat getDateFormat(String format) {
		return new SimpleDateFormat(format);
	}

	public double getHours(long millis) {
		return (double) millis / (60 * 60 * 1000);
	}
	
	public Double getHoursFromSec(double millis) {
		return (double)millis / (60 * 60);
	}
	
	public double getSecFromHours(double hours){
	    return hours * 60 * 60;
	}

	public int getMinuts(double hours) {
		double mins = hours * 60;
		return (int) mins;
	}

	public int getMinutsFromMillis(double millis) {
		double mins = millis / 1000 / 60;
		return (int) mins;
	}

	public Date addMinutes(Date date, long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, getMinutsFromMillis(millis));
		return calendar.getTime();
	}

	private static DateUtils dateUtils;
	static {
		dateUtils = new DateUtils();
	}

	public static DateUtils getInstance() {
		return dateUtils;
	}

	public static Date getDateInFormat(String input) throws ParseException {
		DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
		return formatter.parse(input);
	}
}

package com.fn.fornow.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;

/**
 * @author Simon Lv
 * @since 2012-6-10
 */
public class DateUtils {

	public static final String YYMMDD = "yyMMdd";
	public static final String YYYYMMDD = "yyyyMMdd";
	public static final String PATTERN = "yyyy-MM-dd HH:mm:ss";
	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(
			"yyyy-MM-dd hh:mm:ss");

	public static DateTime toDateTime(String dateTime) {
		if (StringUtils.isBlank(dateTime)) {
			return null;
		}
		return DateTimeFormat.forPattern(PATTERN).parseDateTime(dateTime);
	}

	public static String toString(DateTime dateTime) {
		return dateTime.toString(PATTERN);
	}

	public static String toString(String dateTime, String pattern) {
		return new DateTime(dateTime).toString(pattern);
	}

	public static String toString(LocalDate localDate, String pattern) {
		if (localDate == null) {
			return null;
		}
		return localDate.toString(pattern);
	}

	public static String todayToString() {
		return new LocalDate().toString(YYMMDD);
	}
	
	/**
	 * 将微信消息中的CreateTime转换成标准格式的时间（yyyy-MM-dd HH:mm:ss）
	 * 
	 * @param createTime
	 * @return
	 */
	public static String getNormalDateFromWebChat(String createTime) {
		Long msgCreateTime = Long.parseLong(createTime) * 1000;

		return DATE_FORMAT.format(new Date(msgCreateTime));
	}

}

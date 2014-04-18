/*****************************************************************************
 *
 *                      HOPERUN PROPRIETARY INFORMATION
 *
 *          The information contained herein is proprietary to HopeRun
 *           and shall not be reproduced or disclosed in whole or in part
 *                    or used for any design or manufacture
 *              without direct written authorization from HopeRun.
 *
 *            Copyright (c) 2014 by HopeRun.  All rights reserved.
 *
 *****************************************************************************/
package com.fn.fornow.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author Simon Lv
 * @date Apr 14, 2014
 * 
 */
public class DateUtils {
	public static final SimpleDateFormat US_DATE_FORMAT = new SimpleDateFormat(
			"d MMM yyyy", Locale.US);
	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(
			"yyyy-MM-dd hh:mm:ss");
	public static final SimpleDateFormat S_DATE_FORMAT = new SimpleDateFormat(
			"yyyy-MM-dd hh:mm");

	/**
	 * get normal date format
	 * 
	 * @param dateTime
	 * @return
	 * @throws ParseException
	 */
	public static Date getNormalDate(String dateTime) throws ParseException {
		if (StringUtils.isEmpty(dateTime)) {
			return null;
		}

		Date date = DATE_FORMAT.parse(dateTime);

		return date;
	}

	/**
	 * get us date format
	 * 
	 * @param dateTime
	 * @return
	 * @throws ParseException
	 */
	public static Date getUsDate(String dateTime) throws ParseException {
		if (StringUtils.isEmpty(dateTime)) {
			return null;
		}

		Date date = US_DATE_FORMAT.parse(dateTime);

		return date;
	}

	/**
	 * get date format without seconds
	 * 
	 * @param date
	 * @return
	 */
	public static String getDate2StrWithoutSS(Date date) {
		if (date == null) {
			return null;
		}

		return S_DATE_FORMAT.format(date);
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

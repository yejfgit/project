package com.survey.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


/**
 * 日期工具
 * @author wengxf
 *
 */
public class DateUtil {

	/**
	 * 得到当前日期
	 * @return
	 */
	public static Date getCurrentDate() {
		return new Date();
	}
	
	/**
	 * 转换字符串为日期
	 * @param dateString
	 * @param pattern
	 * @return
	 */
	public static Date getDateByString(String dateString, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date dt = null;
		try {
			dt = sdf.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dt;
	}
	
	/**
	 * 转换日期为字符串
	 * @param dt
	 * @param pattern
	 * @return
	 */
	public static String getStringByDate(Date dt, String pattern) {
		return new SimpleDateFormat(pattern).format(dt);
	}
	
	/**
	 * 转换日期为年月日时分秒字符串
	 * @param dt
	 * @return
	 */
	public static String getTimeStringByDate(Date dt) {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dt);
	}
	
	/**
	 * 转换日期为年月日字符串
	 * @param dt
	 * @return
	 */
	public static String getDateStringByDate(Date dt) {
		return new SimpleDateFormat("yyyy-MM-dd").format(dt);
	}
	
	
	/**
	 * 得到当前日期组成的文件夹目录
	 * @return
	 */
	public static String getDatePath() {

		return getDatePath("/");

	}
	
	/**
	 * 得到当前日期组成的文件夹目录
	 * @param seperator		分隔符
	 * @return
	 */
	public static String getDatePath(String seperator) {

		Calendar c = Calendar.getInstance(Locale.SIMPLIFIED_CHINESE);
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DAY_OF_MONTH);
		
		String sMonth = month + "";
		String sDay = day + "";
		if(month < 10){
			sMonth = "0" + month;
		}
		if(day < 10){
			sDay = "0" + day;
		}

		return seperator + year + seperator + sMonth + seperator + sDay + seperator;

	}
}

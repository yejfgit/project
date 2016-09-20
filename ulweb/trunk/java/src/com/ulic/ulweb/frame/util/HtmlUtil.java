package com.ulic.ulweb.frame.util;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class HtmlUtil {
	public static String getHtmlValue(String str) {
		if (str != null) {
			str = str.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>");
			return str;
		}
		else {
			return "";
		}
	}
	public static String reHtmlValue(String str) {
		if (str != null) {
			str = str.replaceAll("<p/>", "\n").replaceAll("&lt;", "<").replaceAll("&gt;", ">");
			return str;
		}
		else {
			return "";
		}
	}
	public static String getHtmlFilterValue(String str) {
		if (str != null) {
			str = str.replaceAll("\\\\", "\\\\\\\\").replaceAll("\n", "\\\\n").replaceAll("\r", "\\\\r")
					.replaceAll("\b", "\\\\b").replaceAll("\t", "\\\\t").replaceAll("\f", "\\\\f").replaceAll("'",
							"\'").replaceAll("\'", "\\\\\'").replaceAll("\"", "\\\\\"");
			return str;
		}
		return "";
	}
	public static String getNotNullValue(String str) {
		if (str != null) {
			return str;
		}
		return "";
	}
	public static String getCheckedValue(String s1, String s2) {
		if (s1 != null && s2 != null && s1.equals(s2)) {
			return "checked";
		}
		return "";
	}
	public static String getSelectedValue(String s1, String s2) {
		if (s1 != null && s2 != null && s1.equals(s2)) {
			return "selected";
		}
		return "";
	}
	public static boolean compareTime(Timestamp t1, Timestamp t2) {
		boolean tag = false;
		if (t1.getTime() > t2.getTime()) {
			tag = true;
		}
		else {
			tag = false;
		}
		return tag;
	}
	public static Timestamp getFormatTimestamp(String format, String src) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return new Timestamp(sdf.parse(src).getTime());
	}
}

package com.survey.util;

public class XmlUtil {

	/**
	 * 解析xml中的一些属性值
	 * @param str
	 * @param tag
	 * @return
	 */
	public static String parseTag(String str, String tag) {

		String ret;
		try {
			ret = str.substring(str.indexOf("<" + tag + ">") + tag.length() + 2,
					str.indexOf("</" + tag + ">"));
		} catch (Exception e) {
			ret = "";
		}
		
		return ret;

	}
	
}

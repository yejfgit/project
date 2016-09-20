package com.ulic.ulweb.ulweb2.util;

import java.io.Reader;
import java.sql.Clob;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class FormatUtil {
	public final static String clob2String(Clob clob) {
		if (clob == null) {
			return null;
		}

		StringBuffer sb = new StringBuffer(65535);// 64K
		Reader clobStream = null;
		try {
			clobStream = clob.getCharacterStream();
			char[] b = new char[60000];// 每次获取60K
			int i = 0;
			while ((i = clobStream.read(b)) != -1) {
				sb.append(b, 0, i);
			}
		} catch (Exception ex) {
			sb = null;
		} finally {
			try {
				if (clobStream != null)
					clobStream.close();
			} catch (Exception e) {
			}
		}
		if (sb == null)
			return null;
		else
			return sb.toString();
	}
	
	public static String join(String[] strs, String sep) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < strs.length; i++) {
			if (i != strs.length - 1) {
				sb.append(strs[i] + sep);
			}
		}
		return sb.toString();
	}

	public static Set getTmplAttributes(String htmlStr) {

		int a = 0, b = 0;
		Set strs = new HashSet();
		while (true) {
			a = htmlStr.indexOf("{!");
			if (a == -1) {
				break;
			}
			b = htmlStr.indexOf("}", a);
			if (b == -1) {
				break;
			}
			strs.add(htmlStr.substring(a + 2, b));
			htmlStr = htmlStr.replace(htmlStr.substring(0, b), "");
		}
		return strs;
	}
	
	public static String objectToString(Object obj) {
		String ret = null;
		if (obj instanceof String) {
			ret = (String) obj;
		} else if (obj instanceof Integer) {
			ret = Integer.toString((Integer) obj);
		} else if (obj instanceof Long) {
			ret = Long.toString((Long) obj);
		} else if (obj instanceof Long) {
			ret = Long.toString((Long) obj);
		} else if (obj instanceof Clob) {
			ret = FormatUtil.clob2String((Clob) obj);
		} else if (obj instanceof Date) {
			ret = ((Date) obj).toString();
		}
		return ret;
	}

	public static int[] stringToIntegers(String columnIds) {
		String[] set = columnIds.split(",");
		int[] ids = new int[set.length];;
		for (int i = 0; i < set.length; i++) {
			String e = set[i].trim();
			ids[i] = Integer.parseInt(e);
		}
		return ids;
	}

	public static boolean isNull(String s){
		if(s == null)return true;
		if(s.trim().length() == 0)return true;
		return false;
	}
}

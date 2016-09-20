package com.survey.util;


/**
 * 数组工具
 * @author wengxf
 *
 */
public class ArrayUtil {

	/**
	 * 检测整数数组中是否包含元素
	 * @param array
	 * @param element
	 * @return
	 */
	public static boolean contain(int[] array, int element) {
		
		boolean ret = false;
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] == element) {
				ret = true;
				break;
			}
		}
		
		return ret;
	}
	
	
	/**
	 * 检测字符串数组中是否包含元素
	 * @param array
	 * @param element
	 * @return
	 */
	public static boolean contain(String[] array, String element) {
		
		boolean ret = false;
		
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(element)) {
				ret = true;
				break;
			}
		}
		
		return ret;
	}
	
	
	/**
	 * 根据分隔符把字符串分成子串数组
	 * @param str1
	 * @param comma
	 * @return
	 */
	public static String[] split(String str1, String comma) {
		if (str1 == null) {
			return null;
		}
		String[] str2 = str1.split(comma);
		for (int i = 0; i < str2.length; i++) {
			str2[i] = str2[i].trim();
		}
		return str2;
	}
	
	
	/**
	 * 根据分隔符把字符串数组连接起来（字符串）
	 * @param str1
	 * @param comma
	 * @return
	 */
	public static String join(String[] str1, String comma) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; str1 != null && i < str1.length; i++) {
			sb.append(str1[i].trim());
			if (i < str1.length - 1) {
				sb.append(comma);
			}
		}
		return sb.toString();
	}
	
	/**
	 * 根据分隔符把字符串数组连接起来（数字型）
	 * @param str1
	 * @param comma
	 * @return
	 */
	public static String join(int[] str1, String comma) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; str1 != null && i < str1.length; i++) {
			sb.append(String.valueOf(str1[i]).trim());
			if (i < str1.length - 1) {
				sb.append(comma);
			}
		}
		return sb.toString();
	}
	
	
	public static void main(String[] args) {
		System.out.println(join(split("1,2,3 , 53", ","), ","));
	}
	
}

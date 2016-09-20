package com.survey.util;

public class StringUtil {

	public static int parseInt(String s) {
		
		int i = 0; 
		try {
			i = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public static int[] parseInts(String[] ss) {
		if (ss == null) {
			return new int[0];
		}
		int[] is = new int[ss.length]; 
		try {
			for (int i = 0; i < ss.length; i++) {
				is[i] = Integer.parseInt(ss[i]);
			}
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return is;
	}
}

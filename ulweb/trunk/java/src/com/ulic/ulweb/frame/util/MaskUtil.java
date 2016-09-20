package com.ulic.ulweb.frame.util;

import java.util.ArrayList;

public final class MaskUtil {

	private MaskUtil() {
	}

	// / <summary>
	// / 转换为逗号分隔的字符串
	// / </summary>
	// / <param name="mask"></param>
	// / <returns></returns>
	public static String ToString(int mask) {
		java.util.ArrayList arr = ToArrayList(mask);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr.size(); i++) {
			if (i == arr.size() - 1)
				sb.append(arr.get(i).toString());
			else
				sb.append(arr.get(i).toString() + ",");
		}
		return sb.toString();
	}

	// / <summary>
	// / 转换为逗号分隔的字符串
	// / </summary>
	// / <param name="mask"></param>
	// / <returns></returns>
	public static String ToString(long mask) {
		java.util.ArrayList arr = ToArrayList(mask);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr.size(); i++) {
			if (i == arr.size() - 1)
				sb.append(arr.get(i).toString());
			else
				sb.append(arr.get(i).toString() + ",");
		}
		return sb.toString();
	}

	// / <summary>
	// / 转换成数组列表

	// / </summary>
	// / <param name="mask"></param>
	// / <returns></returns>
	public static ArrayList ToArrayList(int mask) {
		ArrayList bits = new ArrayList();

		for (int i = 0; i < 32; i++) {
			int m = ((int) StrictMath.pow(2, i));
			if ((mask & m) >= 1) {
				bits.add(m);
			
			}else
				if(mask < m){
					break;
				}
		}
		return bits;
	}

	// / <summary>
	// / 转换成数组列表

	// / </summary>
	// / <param name="mask"></param>
	// / <returns></returns>
	public static ArrayList ToArrayList(long mask) {
		ArrayList bits = new ArrayList();

		for (int i = 0; i < 64; i++) {
			int m = ((int)  StrictMath.pow(2, i));
			if ((mask & m) >= 1) {
				bits.add(m);
			}
			if(mask < m){
				break;
			}
		}
		return bits;
	}

}

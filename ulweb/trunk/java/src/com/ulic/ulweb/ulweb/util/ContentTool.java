package com.ulic.ulweb.ulweb.util;

import java.util.ArrayList;
import java.util.List;

import com.ulic.ulweb.ulweb.entity.UlColumn;


public class ContentTool {
	public static List<UlColumn> sortColum(List<UlColumn> columList) {
		UlColumn[] colums = columList.toArray(new UlColumn[columList.size()]);
		List<UlColumn> newList = new ArrayList<UlColumn>();
		for (int i = 0; i < colums.length; i++) {			
			List<UlColumn> list = colums[i].getListColumn();
			if (list == null) {
				list = new ArrayList<UlColumn>();
			}
			int columId = colums[i].getColumnId();
			for (int k = 0; k < colums.length; k++) {
				if (k == i) {
					continue;
				}
				if (colums[k].getParentId() == columId) {
					list.add(colums[k]);
				}
			}
			int topColumnId = colums[i].getParentId();
			if (topColumnId == 0) {
				newList.add(colums[i]);
			}
			colums[i].setListColumn(list);
		}
		return newList;
	}
	
	public static String unescape(String src, String separator) {
		if (src.indexOf(separator) == -1 || src.indexOf("u") == -1) {
			return src;
		}
		return unescape(src.replace(separator, "%"));
	}
	
	/**
	 * 把Unicode转为原字符串
	 * @param src
	 * @return
	 */
	public static String unescape(String src) {
		StringBuffer tmp = new StringBuffer();
		tmp.ensureCapacity(src.length());
		int lastPos = 0, pos = 0;
		char ch;
		while (lastPos < src.length()) {
			pos = src.indexOf("%", lastPos);
			if (pos == lastPos) {
				if (src.charAt(pos + 1) == 'u') {
					ch = (char) Integer.parseInt(src
							.substring(pos + 2, pos + 6), 16);
					tmp.append(ch);
					lastPos = pos + 6;
				} else {
					ch = (char) Integer.parseInt(src
							.substring(pos + 1, pos + 3), 16);
					tmp.append(ch);
					lastPos = pos + 3;
				}
			} else {
				if (pos == -1) {
					tmp.append(src.substring(lastPos));
					lastPos = src.length();
				} else {
					tmp.append(src.substring(lastPos, pos));
					lastPos = pos;
				}
			}
		}
		return tmp.toString();
	}
	
}

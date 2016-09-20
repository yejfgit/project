package com.ulic.ulweb.frame.util;

public class PageTool {
	private int pageNo;
	private int pageCount;
	private int len;
	private int size;
	private int begin;
	private int end;
	private int beginPageNo;
	private int endPageNo;
	private String pageTag;
	public static String imgPath;
	public String getPageTag() {
		return pageTag;
	}
	public int getBeginPageNo() {
		return beginPageNo;
	}
	public int getEndPageNo() {
		return endPageNo;
	}
	public PageTool(int pageNo, int size) {
		if (pageNo <= 0) {
			this.pageNo = 1;
		}
		else {
			this.pageNo = pageNo;
		}
		this.size = size;
	}
	public PageTool(int pageNo, int len, int size) {
		if (pageNo <= 0) {
			this.pageNo = 1;
		}
		else {
			this.pageNo = pageNo;
		}
		this.len = len;
		this.size = size;
		this.execute();
	}
	public int getLen() {
		return len;
	}
	public void setLen(int len) {
		this.len = len;
		this.execute();
	}
	public int getPageCount() {
		return pageCount;
	}
	public int getPageNo() {
		return pageNo;
	}
	public int getSize() {
		return size;
	}
	public int getBegin() {
		return begin;
	}
	public int getEnd() {
		return end;
	}
	private void execute() {
		pageCount = (len + size - 1) / size;
		if (pageNo > pageCount) {
			pageNo = pageCount;
		}
		begin = (pageNo - 1) * size;
		end = begin + size;
	}
	public String outPageNo(String url, String jsCode, int showLen) {
		this.initWithShowLen(showLen);
		StringBuffer sb = new StringBuffer();
		sb.append("<ul>");
		sb.append("<li><a href=\"" + url + "&page=1" + "\"><img src=\"" + PageTool.imgPath
				+ "/imgs/begin.gif" + "\"/></a></li>");
		sb.append("<li><a href=\"" + url + "&page=" + (beginPageNo - 1) + "\"><img src=\""
				+ PageTool.imgPath + "/imgs/pre.gif" + "\"/></a></li>");
		for (int i = beginPageNo; i <= endPageNo; i++) {
			if (i == pageNo) {
				sb.append("<li>" + i + "</li>");
			}
			else {
				sb.append("<li><a href=\"" + url + "&page=" + i + "\" onclick=\"" + jsCode + "\">" + i
						+ "</a></li>");
			}
		}
		if (endPageNo > pageCount - 1) {
			endPageNo = pageCount - 1;
		}
		sb.append("<li><a href=\"" + url + "&page=" + (endPageNo + 1) + "\"><img src=\""
				+ PageTool.imgPath + "/imgs/next.gif" + "\"/></a></li>");
		sb.append("<li><a href=\"" + url + "&page=" + pageCount + "\"><img src=\"" + PageTool.imgPath
				+ "/imgs/end.gif" + "\"/></a></li>");
		sb.append("</ul>");
		return sb.toString();
	}
	public String outPageNo(int showLen) {
		this.initWithShowLen(showLen);
		StringBuffer sb = new StringBuffer();
		sb.append("<ul>");
		sb.append("<li><a href=\"#\" onclick=\"skipto(1);\"><img src=\"" + PageTool.imgPath
				+ "/imgs/begin.gif" + "\"/></a></li>");
		sb.append("<li><a href=\"#\" onclick=\"skipto(" + (beginPageNo - 1) + ");\"><img src=\""
				+ PageTool.imgPath + "/imgs/pre.gif" + "\"/></a></li>");
		for (int i = beginPageNo; i <= endPageNo; i++) {
			if (i == pageNo) {
				sb.append("<li>" + i + "</li>");
			}
			else {
				sb.append("<li><a href=\"#\" onclick=\"skipto(" + i + ");\">" + i + "</a></li>");
			}
		}
		if (endPageNo > pageCount - 1) {
			endPageNo = pageCount - 1;
		}
		sb.append("<li><a href=\"#\" onclick=\"skipto(" + (endPageNo + 1) + ");\"><img src=\""
				+ PageTool.imgPath + "/imgs/next.gif" + "\"/></a></li>");
		sb.append("<li><a href=\"#\" onclick=\"skipto(" + pageCount + ");\"><img src=\""
				+ PageTool.imgPath + "/imgs/end.gif" + "\"/></a></li>");
		sb.append("</ul>");
		return sb.toString();
	}
	public static void outPageNo(int pageNo, int pageCount, int showLen) {
		int mid = showLen / 2;
		int beginPageNo;
		int endPageNo;
		if (pageCount - pageNo > mid) {
			beginPageNo = (pageNo > mid) ? pageNo - mid + 1 : 1;
			endPageNo = beginPageNo + showLen - 1;
			endPageNo = (endPageNo > pageCount) ? pageCount : endPageNo;
		}
		else {
			beginPageNo = (pageCount > showLen) ? pageCount - showLen + 1 : 1;
			endPageNo = pageCount;
		}
		for (int i = beginPageNo; i <= endPageNo; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		PageTool.outPageNo(2, 5, 10);
	}
	private void initWithShowLen(int showLen) {
		int mid = showLen / 2;
		if (pageCount - pageNo > mid) {
			beginPageNo = (pageNo > mid) ? pageNo - mid + 1 : 1;
			endPageNo = beginPageNo + showLen - 1;
			endPageNo = (endPageNo > pageCount) ? pageCount : endPageNo;
		}
		else {
			beginPageNo = (pageCount > showLen) ? pageCount - showLen + 1 : 1;
			endPageNo = pageCount;
		}
	}
}
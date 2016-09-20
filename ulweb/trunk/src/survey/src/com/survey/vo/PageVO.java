package com.survey.vo;

import java.util.ArrayList;
import java.util.List;


/**
 * 分页处理的值对象
 * @author wengxf
 *
 */
public class PageVO implements java.io.Serializable {

	
	private static final long serialVersionUID = 1L;

	// 当前页的数据列表
	private List objectList;
	
	// 每页的记录数
	private int pageSize = 100;
	
	// 页码
	private int pageNum = 1;

	// 总记录数
	private int totalNum;

	
	public PageVO() {
		objectList = new ArrayList();
	}
	
	public PageVO(int pageSize) {
		this();
		this.pageSize = pageSize;
	}

	// 当前页的第一个记录，从0开始
	public int getFirstResult() {
		if (pageNum < 1) {
			return 0;
		}
		if (pageNum > this.getPageTotalNum()) {
			pageNum = this.getPageTotalNum();
		}
		return (pageNum - 1) * pageSize;
	}
	
	public int getMaxResult() {
		if (pageNum < 1) return 0;
		return pageNum * pageSize - 1;
	}


	public List getObjectList() {
		return objectList;
	}

	public void setObjectList(List objectList) {
		this.objectList = objectList;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		if (pageNum < 1) pageNum = 1;
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	// 总页数
	public int getPageTotalNum() {
		return (totalNum - 1) / pageSize + 1;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	
	
	// 是否显示“下一页”按钮
	public int getHasNextButton() {
		if (pageNum < getPageTotalNum()) {
			return 1;
		} else {
			return 0;
		}
	}
	
//	 是否显示“上一页”按钮
	public int getHasPrevButton() {
		if (pageNum > 1) {
			return 1;
		} else {
			return 0;
		}
	}
}

package com.ulic.ulweb.ulweb2.entity;

import java.util.List;

// default package

/**
 * ColumnEntity generated by MyEclipse Persistence Tools
 */

public class ColumnEntity implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int columnId;

	private String columnName;

	private String organId;

	private int columnLevel;

	private int parentId;

	private int isDelete;

	private int includeColumn;

	private int showToUser;

	private int includeContent;

	private int columnOrder;

	private int showOthersClass;

	private int showOrganClass;

	private int openColumn;

	private String columnEid;

	private int orderNum;

	private int contentTmplId;
	
	private String contentTmplName;
	
	private List subColumns;

	// Property accessors

	public List getSubColumns() {
		return subColumns;
	}

	public void setSubColumns(List subColumns) {
		this.subColumns = subColumns;
	}

	public int getColumnId() {
		return this.columnId;
	}

	public void setColumnId(int columnId) {
		this.columnId = columnId;
	}

	public String getColumnName() {
		return this.columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getOrganId() {
		return this.organId;
	}

	public void setOrganId(String organId) {
		this.organId = organId;
	}

	public int getColumnLevel() {
		return this.columnLevel;
	}

	public void setColumnLevel(int columnLevel) {
		this.columnLevel = columnLevel;
	}

	public int getParentId() {
		return this.parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public int getIncludeColumn() {
		return this.includeColumn;
	}

	public void setIncludeColumn(int includeColumn) {
		this.includeColumn = includeColumn;
	}

	public int getShowToUser() {
		return this.showToUser;
	}

	public void setShowToUser(int showToUser) {
		this.showToUser = showToUser;
	}

	public int getIncludeContent() {
		return this.includeContent;
	}

	public void setIncludeContent(int includeContent) {
		this.includeContent = includeContent;
	}

	public int getColumnOrder() {
		return this.columnOrder;
	}

	public void setColumnOrder(int columnOrder) {
		this.columnOrder = columnOrder;
	}

	public int getShowOthersClass() {
		return this.showOthersClass;
	}

	public void setShowOthersClass(int showOthersClass) {
		this.showOthersClass = showOthersClass;
	}

	public int getShowOrganClass() {
		return this.showOrganClass;
	}

	public void setShowOrganClass(int showOrganClass) {
		this.showOrganClass = showOrganClass;
	}

	public int getOpenColumn() {
		return this.openColumn;
	}

	public void setOpenColumn(int openColumn) {
		this.openColumn = openColumn;
	}

	public String getColumnEid() {
		return this.columnEid;
	}

	public void setColumnEid(String columnEid) {
		this.columnEid = columnEid;
	}

	public int getOrderNum() {
		return this.orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public int getContentTmplId() {
		return this.contentTmplId;
	}

	public void setContentTmplId(int contentTmplId) {
		this.contentTmplId = contentTmplId;
	}

	public String getContentTmplName() {
		return contentTmplName;
	}

	public void setContentTmplName(String contentTmplName) {
		this.contentTmplName = contentTmplName;
	}

}
package com.ulic.ulweb.ulweb.entity;

import java.util.List;

import com.ulic.ulweb.frame.bean.AbstractBean;

public class UlColumn extends AbstractBean{
	private int columnId;
	private String columnName;
	private String organId;
	private String columnEId;
	private int columnLevel;
	private int parentId;
	private int isdelete;
	private int includeColumn;
	private int showToUser;
	private int includeContent;
	private int columnOrder;
	private int showOthersClass;
	private int showOrganClass;
	private int openColumn;
	private int cantBeDelete;
	private List listColumn;
	private String parentName;
	
	
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public List getListColumn() {
		return listColumn;
	}
	public void setListColumn(List listColumn) {
		this.listColumn = listColumn;
	}
	public int getCantBeDelete() {
		return cantBeDelete;
	}
	public void setCantBeDelete(int cantBeDelete) {
		this.cantBeDelete = cantBeDelete;
	}
	public int getColumnId() {
		return columnId;
	}
	public void setColumnId(int columnId) {
		this.columnId = columnId;
	}
	public int getColumnLevel() {
		return columnLevel;
	}
	public void setColumnLevel(int columnLevel) {
		this.columnLevel = columnLevel;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public int getColumnOrder() {
		return columnOrder;
	}
	public void setColumnOrder(int columnOrder) {
		this.columnOrder = columnOrder;
	}
	public int getIncludeColumn() {
		return includeColumn;
	}
	public void setIncludeColumn(int includeColumn) {
		this.includeColumn = includeColumn;
	}
	public int getIncludeContent() {
		return includeContent;
	}
	public void setIncludeContent(int includeContent) {
		this.includeContent = includeContent;
	}
	public int getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
	public int getOpenColumn() {
		return openColumn;
	}
	public void setOpenColumn(int openColumn) {
		this.openColumn = openColumn;
	}
	public String getOrganId() {
		return organId;
	}
	public void setOrganId(String organId) {
		this.organId = organId;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getShowOrganClass() {
		return showOrganClass;
	}
	public void setShowOrganClass(int showOrganClass) {
		this.showOrganClass = showOrganClass;
	}
	public int getShowOthersClass() {
		return showOthersClass;
	}
	public void setShowOthersClass(int showOthersClass) {
		this.showOthersClass = showOthersClass;
	}
	public int getShowToUser() {
		return showToUser;
	}
	public void setShowToUser(int showToUser) {
		this.showToUser = showToUser;
	}
	public String getColumnEId() {
		return columnEId;
	}
	public void setColumnEId(String columnEId) {
		this.columnEId = columnEId;
	}
	

}

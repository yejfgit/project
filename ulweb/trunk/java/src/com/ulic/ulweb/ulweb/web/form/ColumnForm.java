package com.ulic.ulweb.ulweb.web.form;

import java.util.List;

import org.apache.struts.validator.ValidatorForm;

import com.ulic.ulweb.ulweb.entity.UlColumn;

public class ColumnForm extends ValidatorForm{

	private int columnId;
	private String columnName;
	private String deptId;
	private int parentColumn;
	private int include;
	private int showToUser;
	private String show;
	private String notShow;
	private int showOtherClass;
	private int showOrganClass;
	private int openColumn;
	private int columnOrder;
	private int isDelete;
	private String js;
	private UlColumn c;
	private List<UlColumn> cl;
	
	
	public UlColumn getC() {
		return c;
	}
	public void setC(UlColumn c) {
		this.c = c;
	}
	public List<UlColumn> getCl() {
		return cl;
	}
	public void setCl(List<UlColumn> cl) {
		this.cl = cl;
	}
	public String getJs() {
		return js;
	}
	public void setJs(String js) {
		this.js = js;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	public int getColumnOrder() {
		return columnOrder;
	}
	public void setColumnOrder(int columnOrder) {
		this.columnOrder = columnOrder;
	}
	public int getColumnId() {
		return columnId;
	}
	public void setColumnId(int columnId) {
		this.columnId = columnId;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getNotShow() {
		return notShow;
	}
	public void setNotShow(String notShow) {
		this.notShow = notShow;
	}
	public String getShow() {
		return show;
	}
	public void setShow(String show) {
		this.show = show;
	}
	public int getInclude() {
		return include;
	}
	public void setInclude(int include) {
		this.include = include;
	}
	public int getOpenColumn() {
		return openColumn;
	}
	public void setOpenColumn(int openColumn) {
		this.openColumn = openColumn;
	}
	public int getParentColumn() {
		return parentColumn;
	}
	public void setParentColumn(int parentColumn) {
		this.parentColumn = parentColumn;
	}
	public int getShowOrganClass() {
		return showOrganClass;
	}
	public void setShowOrganClass(int showOrganClass) {
		this.showOrganClass = showOrganClass;
	}
	public int getShowOtherClass() {
		return showOtherClass;
	}
	public void setShowOtherClass(int showOtherClass) {
		this.showOtherClass = showOtherClass;
	}
	public int getShowToUser() {
		return showToUser;
	}
	public void setShowToUser(int showToUser) {
		this.showToUser = showToUser;
	}
	
}

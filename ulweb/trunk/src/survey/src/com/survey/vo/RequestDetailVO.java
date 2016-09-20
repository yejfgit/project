package com.survey.vo;

public class RequestDetailVO implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String deptName;
	
	private String reqDate;
	
	private String userName;
	
	private int total;
	
	private int done;
	
	private int todo;
	
	private int closed;
	
	private int invalid;
	

	public int getInvalid() {
		return invalid;
	}

	public void setInvalid(int invalid) {
		this.invalid = invalid;
	}

	public int getClosed() {
		return closed;
	}

	public void setClosed(int closed) {
		this.closed = closed;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public int getDone() {
		return done;
	}

	public void setDone(int done) {
		this.done = done;
	}

	public String getReqDate() {
		return reqDate;
	}

	public void setReqDate(String reqDate) {
		this.reqDate = reqDate;
	}

	public int getTodo() {
		return todo;
	}

	public void setTodo(int todo) {
		this.todo = todo;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}

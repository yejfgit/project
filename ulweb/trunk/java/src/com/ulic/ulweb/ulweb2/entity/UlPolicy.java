package com.ulic.ulweb.ulweb2.entity;

/**
 * UlPolicy entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class UlPolicy implements java.io.Serializable {

	// Fields

	private String policyId;
	private String policyName;
	private String policyDesc;
	private String secure;
	private String groups;
	private String users;

	// Constructors

	/** default constructor */
	public UlPolicy() {
	}

	/** minimal constructor */
	public UlPolicy(String policyId, String secure) {
		this.policyId = policyId;
		this.secure = secure;
	}

	/** full constructor */
	public UlPolicy(String policyId, String policyName, String policyDesc,
			String secure, String groups, String users) {
		this.policyId = policyId;
		this.policyName = policyName;
		this.policyDesc = policyDesc;
		this.secure = secure;
		this.groups = groups;
		this.users = users;
	}

	// Property accessors

	public String getPolicyId() {
		return this.policyId;
	}

	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}

	public String getPolicyName() {
		return this.policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getPolicyDesc() {
		return this.policyDesc;
	}

	public void setPolicyDesc(String policyDesc) {
		this.policyDesc = policyDesc;
	}

	public String getSecure() {
		return this.secure;
	}

	public void setSecure(String secure) {
		this.secure = secure;
	}

	public String getGroups() {
		return this.groups;
	}

	public void setGroups(String groups) {
		this.groups = groups;
	}

	public String getUsers() {
		return this.users;
	}

	public void setUsers(String users) {
		this.users = users;
	}

	@Override
	public String toString() {

		return " policyName =" + this.policyName + " policyDesc = "
				+ this.policyDesc + " groups = " + this.groups + " users = "
				+ this.users + " secure = " + this.secure;
	}
}
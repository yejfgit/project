package com.ulic.ulweb.ulweb2.entity;

/**
 * CusEdcprincipalentitytype entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class CusEdcprincipalentitytype implements java.io.Serializable {

	// Fields

	private Integer id;
	private Edcprincipalentity edcprincipalentity;
	private String cusType;
	private Integer cusIsHidden;
	private String name;

	// Constructors

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/** default constructor */
	public CusEdcprincipalentitytype() {
	}

	/** minimal constructor */
	public CusEdcprincipalentitytype(Edcprincipalentity edcprincipalentity) {
		this.edcprincipalentity = edcprincipalentity;
	}

	/** full constructor */
	public CusEdcprincipalentitytype(Edcprincipalentity edcprincipalentity,
			String cusType, Integer cusIsHidden) {
		this.edcprincipalentity = edcprincipalentity;
		this.cusType = cusType;
		this.cusIsHidden = cusIsHidden;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Edcprincipalentity getEdcprincipalentity() {
		return this.edcprincipalentity;
	}

	public void setEdcprincipalentity(Edcprincipalentity edcprincipalentity) {
		this.edcprincipalentity = edcprincipalentity;
	}

	public String getCusType() {
		return this.cusType;
	}

	public void setCusType(String cusType) {
		this.cusType = cusType;
	}

	public Integer getCusIsHidden() {
		return this.cusIsHidden;
	}

	public void setCusIsHidden(Integer cusIsHidden) {
		this.cusIsHidden = cusIsHidden;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " canonicalname = " +  this.edcprincipalentity.getCanonicalname();
	}
}
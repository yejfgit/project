package com.ulic.ulweb.ulweb2.entity;

/**
 * Edcprincipaluserentity entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Edcprincipaluserentity implements java.io.Serializable {

	// Fields

	private String id;
	private Edcprincipalentity edcprincipalentity;
	private Long sequencenumber;
	private Integer edcrole;
	private Integer isenabled;
	private String uidstring;

	// Constructors

	/** default constructor */
	public Edcprincipaluserentity() {
	}

	/** minimal constructor */
	public Edcprincipaluserentity(String id, Long sequencenumber) {
		this.id = id;
		this.sequencenumber = sequencenumber;
	}

	/** full constructor */
	public Edcprincipaluserentity(String id,
			Edcprincipalentity edcprincipalentity, Long sequencenumber,
			Integer edcrole, Integer isenabled, String uidstring) {
		this.id = id;
		this.edcprincipalentity = edcprincipalentity;
		this.sequencenumber = sequencenumber;
		this.edcrole = edcrole;
		this.isenabled = isenabled;
		this.uidstring = uidstring;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Edcprincipalentity getEdcprincipalentity() {
		return this.edcprincipalentity;
	}

	public void setEdcprincipalentity(Edcprincipalentity edcprincipalentity) {
		this.edcprincipalentity = edcprincipalentity;
	}

	public Long getSequencenumber() {
		return this.sequencenumber;
	}

	public void setSequencenumber(Long sequencenumber) {
		this.sequencenumber = sequencenumber;
	}

	public Integer getEdcrole() {
		return this.edcrole;
	}

	public void setEdcrole(Integer edcrole) {
		this.edcrole = edcrole;
	}

	public Integer getIsenabled() {
		return this.isenabled;
	}

	public void setIsenabled(Integer isenabled) {
		this.isenabled = isenabled;
	}

	public String getUidstring() {
		return this.uidstring;
	}

	public void setUidstring(String uidstring) {
		this.uidstring = uidstring;
	}

}
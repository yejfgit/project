package com.ulic.ulweb.ulweb2.entity;

/**
 * Edcprincipalgroupentity entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Edcprincipalgroupentity implements java.io.Serializable {

	// Fields

	private String id;
	private Edcprincipalentity edcprincipalentity;
	private Long sequencenumber;
	private Short allowsexternalusers;
	private Integer epochinprogress;
	private Integer stateinprogress;

	// Constructors

	/** default constructor */
	public Edcprincipalgroupentity() {
	}

	/** minimal constructor */
	public Edcprincipalgroupentity(String id, Long sequencenumber) {
		this.id = id;
		this.sequencenumber = sequencenumber;
	}

	/** full constructor */
	public Edcprincipalgroupentity(String id,
			Edcprincipalentity edcprincipalentity, Long sequencenumber,
			Short allowsexternalusers, Integer epochinprogress,
			Integer stateinprogress) {
		this.id = id;
		this.edcprincipalentity = edcprincipalentity;
		this.sequencenumber = sequencenumber;
		this.allowsexternalusers = allowsexternalusers;
		this.epochinprogress = epochinprogress;
		this.stateinprogress = stateinprogress;
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

	public Short getAllowsexternalusers() {
		return this.allowsexternalusers;
	}

	public void setAllowsexternalusers(Short allowsexternalusers) {
		this.allowsexternalusers = allowsexternalusers;
	}

	public Integer getEpochinprogress() {
		return this.epochinprogress;
	}

	public void setEpochinprogress(Integer epochinprogress) {
		this.epochinprogress = epochinprogress;
	}

	public Integer getStateinprogress() {
		return this.stateinprogress;
	}

	public void setStateinprogress(Integer stateinprogress) {
		this.stateinprogress = stateinprogress;
	}

}
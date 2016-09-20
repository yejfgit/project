package com.ulic.ulweb.ulweb2.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Edcprincipalentity entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Edcprincipalentity implements java.io.Serializable {

	// Fields

	private String id;
	private Long sequencenumber;
	private String canonicalname;
	private String domainname;
	private Integer epochnumber;
	private String friendlyemail;
	private String friendlyname;
	private String friendlyorganization;
	private Short ishidden;
	private String principaltype;
	private CusEdcprincipalentitytype cusEdcprincipalentitytype ;
	private Set edcprincipalemailaliasentities = new HashSet(0);
	private Set groupEntities = new HashSet(0);
	private Set edcprincipalgroupcontainmententitiesForPrincipalchildid = new HashSet(
			0);
	private Set edcprincipaluserentities = new HashSet(0);
	private Set edcprincipalkeyentities = new HashSet(0);
	private Set edclicenseentities = new HashSet(0);
	private Set edcpolicyarchiveentities = new HashSet(0);
	private Set edcprincipaladminentities = new HashSet(0);
	private Set edcprincipalexternaluserentities = new HashSet(0);
	
	private Set edcpolicyentities = new HashSet(0);
	private Set edcprincipalgroupcontainmententitiesForPrincipalparentid = new HashSet(
			0);

	// Constructors

	/** default constructor */
	public Edcprincipalentity() {
	}

	/** minimal constructor */
	public Edcprincipalentity(String id, Long sequencenumber) {
		this.id = id;
		this.sequencenumber = sequencenumber;
	}

	/** full constructor */
	public Edcprincipalentity(String id, Long sequencenumber,
			String canonicalname, String domainname, Integer epochnumber,
			String friendlyemail, String friendlyname,
			String friendlyorganization, Short ishidden, String principaltype,
			Set edcprincipalemailaliasentities, Set groupEntities,
			Set edcprincipalgroupcontainmententitiesForPrincipalchildid,
			Set edcprincipaluserentities, Set edcprincipalkeyentities,
			Set edclicenseentities, Set edcpolicyarchiveentities,
			Set edcprincipaladminentities,
			Set edcprincipalexternaluserentities,
			Set edcpolicyentities,
			Set edcprincipalgroupcontainmententitiesForPrincipalparentid) {
		this.id = id;
		this.sequencenumber = sequencenumber;
		this.canonicalname = canonicalname;
		this.domainname = domainname;
		this.epochnumber = epochnumber;
		this.friendlyemail = friendlyemail;
		this.friendlyname = friendlyname;
		this.friendlyorganization = friendlyorganization;
		this.ishidden = ishidden;
		this.principaltype = principaltype;
		this.edcprincipalemailaliasentities = edcprincipalemailaliasentities;
		this.groupEntities = groupEntities;
		this.edcprincipalgroupcontainmententitiesForPrincipalchildid = edcprincipalgroupcontainmententitiesForPrincipalchildid;
		this.edcprincipaluserentities = edcprincipaluserentities;
		this.edcprincipalkeyentities = edcprincipalkeyentities;
		this.edclicenseentities = edclicenseentities;
		this.edcpolicyarchiveentities = edcpolicyarchiveentities;
		this.edcprincipaladminentities = edcprincipaladminentities;
		this.edcprincipalexternaluserentities = edcprincipalexternaluserentities;
		this.edcpolicyentities = edcpolicyentities;
		this.edcprincipalgroupcontainmententitiesForPrincipalparentid = edcprincipalgroupcontainmententitiesForPrincipalparentid;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getSequencenumber() {
		return this.sequencenumber;
	}

	public void setSequencenumber(Long sequencenumber) {
		this.sequencenumber = sequencenumber;
	}

	public String getCanonicalname() {
		return this.canonicalname;
	}

	public void setCanonicalname(String canonicalname) {
		this.canonicalname = canonicalname;
	}

	public String getDomainname() {
		return this.domainname;
	}

	public void setDomainname(String domainname) {
		this.domainname = domainname;
	}

	public Integer getEpochnumber() {
		return this.epochnumber;
	}

	public void setEpochnumber(Integer epochnumber) {
		this.epochnumber = epochnumber;
	}

	public String getFriendlyemail() {
		return this.friendlyemail;
	}

	public void setFriendlyemail(String friendlyemail) {
		this.friendlyemail = friendlyemail;
	}

	public String getFriendlyname() {
		return this.friendlyname;
	}

	public void setFriendlyname(String friendlyname) {
		this.friendlyname = friendlyname;
	}

	public String getFriendlyorganization() {
		return this.friendlyorganization;
	}

	public void setFriendlyorganization(String friendlyorganization) {
		this.friendlyorganization = friendlyorganization;
	}

	public Short getIshidden() {
		return this.ishidden;
	}

	public void setIshidden(Short ishidden) {
		this.ishidden = ishidden;
	}

	public String getPrincipaltype() {
		return this.principaltype;
	}

	public void setPrincipaltype(String principaltype) {
		this.principaltype = principaltype;
	}

	public Set getEdcprincipalemailaliasentities() {
		return this.edcprincipalemailaliasentities;
	}

	public void setEdcprincipalemailaliasentities(
			Set edcprincipalemailaliasentities) {
		this.edcprincipalemailaliasentities = edcprincipalemailaliasentities;
	}

	public Set getGroupEntities() {
		return this.groupEntities;
	}

	public void setGroupEntities(Set groupEntities) {
		this.groupEntities = groupEntities;
	}

	public Set getEdcprincipalgroupcontainmententitiesForPrincipalchildid() {
		return this.edcprincipalgroupcontainmententitiesForPrincipalchildid;
	}

	public void setEdcprincipalgroupcontainmententitiesForPrincipalchildid(
			Set edcprincipalgroupcontainmententitiesForPrincipalchildid) {
		this.edcprincipalgroupcontainmententitiesForPrincipalchildid = edcprincipalgroupcontainmententitiesForPrincipalchildid;
	}

	public Set getEdcprincipaluserentities() {
		return this.edcprincipaluserentities;
	}

	public void setEdcprincipaluserentities(Set edcprincipaluserentities) {
		this.edcprincipaluserentities = edcprincipaluserentities;
	}

	public Set getEdcprincipalkeyentities() {
		return this.edcprincipalkeyentities;
	}

	public void setEdcprincipalkeyentities(Set edcprincipalkeyentities) {
		this.edcprincipalkeyentities = edcprincipalkeyentities;
	}

	public Set getEdclicenseentities() {
		return this.edclicenseentities;
	}

	public void setEdclicenseentities(Set edclicenseentities) {
		this.edclicenseentities = edclicenseentities;
	}

	public Set getEdcpolicyarchiveentities() {
		return this.edcpolicyarchiveentities;
	}

	public void setEdcpolicyarchiveentities(Set edcpolicyarchiveentities) {
		this.edcpolicyarchiveentities = edcpolicyarchiveentities;
	}

	public Set getEdcprincipaladminentities() {
		return this.edcprincipaladminentities;
	}

	public void setEdcprincipaladminentities(Set edcprincipaladminentities) {
		this.edcprincipaladminentities = edcprincipaladminentities;
	}

	public Set getEdcprincipalexternaluserentities() {
		return this.edcprincipalexternaluserentities;
	}

	public void setEdcprincipalexternaluserentities(
			Set edcprincipalexternaluserentities) {
		this.edcprincipalexternaluserentities = edcprincipalexternaluserentities;
	}


	public Set getEdcpolicyentities() {
		return this.edcpolicyentities;
	}

	public void setEdcpolicyentities(Set edcpolicyentities) {
		this.edcpolicyentities = edcpolicyentities;
	}

	public Set getEdcprincipalgroupcontainmententitiesForPrincipalparentid() {
		return this.edcprincipalgroupcontainmententitiesForPrincipalparentid;
	}

	public void setEdcprincipalgroupcontainmententitiesForPrincipalparentid(
			Set edcprincipalgroupcontainmententitiesForPrincipalparentid) {
		this.edcprincipalgroupcontainmententitiesForPrincipalparentid = edcprincipalgroupcontainmententitiesForPrincipalparentid;
	}

	public CusEdcprincipalentitytype getCusEdcprincipalentitytype() {
		return cusEdcprincipalentitytype;
	}

	public void setCusEdcprincipalentitytype(
			CusEdcprincipalentitytype cusEdcprincipalentitytype) {
		this.cusEdcprincipalentitytype = cusEdcprincipalentitytype;
	}

}
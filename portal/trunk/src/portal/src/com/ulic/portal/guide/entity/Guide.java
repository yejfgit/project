package com.ulic.portal.guide.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 服务实体
 * @author yejf
 * 2013-06-18
 * */

@Entity
@Table(name="t_portal_guide")
@SequenceGenerator(name="seq_guide",sequenceName="s_portal_guide_id")
public class Guide implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_guide")
	private int id;
	
	
	private String name;
	
	@Column(name="guide_desc")
	private String description;
	
	@Column(name="type_id")
	private int typeId;
	
	
	private String label;
	
	@Column(name="create_user_id")
	private int createUserId;
	
	@Column(name="create_time")
	private Date createTime;
	
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(int createUserId) {
		this.createUserId = createUserId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
}

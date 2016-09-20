package com.ulic.portal.guide.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 服务类型实体
 * @author yejf
 * 2013-06-18
 * */

@Entity
@Table(name="t_portal_guide_type")
@SequenceGenerator(name="seq_guideType",sequenceName="s_portal_guide_type_id")
public class GuideType implements java.io.Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_guideType")
	private int id;
	
	@Column(name="type_name")
	private String name;
	
	@Column(name="parent_id")
	private int parentId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
}

package com.ulic.portal.guide.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 * 服务相关实体
 * @author yejf
 * 2013-06-18
 * */
@Entity
@Table(name="t_portal_guide_relation")
public class GuideRelation {
	
	@Id
    @Column(name="guide_id")
	private int guideId;
	
	@Column(name="guide_rel_id")
	private int guideRelId;
	
	@Column(name="guide_rel_name")
	private String guideRelName;

	public String getGuideRelName() {
		return guideRelName;
	}

	public void setGuideRelName(String guideRelName) {
		this.guideRelName = guideRelName;
	}

	public int getGuideId() {
		return guideId;
	}

	public void setGuideId(int guideId) {
		this.guideId = guideId;
	}

	public int getGuideRelId() {
		return guideRelId;
	}

	public void setGuideRelId(int guideRelId) {
		this.guideRelId = guideRelId;
	}
	
}

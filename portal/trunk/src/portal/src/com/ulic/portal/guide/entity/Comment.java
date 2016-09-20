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
 * 评论实体
 * 
 * @author yejf 2013-06-18
 */

@Entity
@Table(name = "t_portal_comment")
@SequenceGenerator(name = "seq_comment", sequenceName = "s_portal_comment__id")
public class Comment implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_comment")
	private int id;

	@Column(name = "guide_id")
	private int guideId;

	@Column(name = "comment_desc")
	private String commentDesc;// 评论内容

	@Column(name = "user_id")
	private int userId;

	@Column(name = "comment_date")
	private Date commentDate;

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public String getCommentDesc() {
		return commentDesc;
	}

	public void setCommentDesc(String commentDesc) {
		this.commentDesc = commentDesc;
	}

	public int getGuideId() {
		return guideId;
	}

	public void setGuideId(int guideId) {
		this.guideId = guideId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}

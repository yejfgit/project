package com.ulic.portal.search.searching.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 用户痕迹实体
 * @author wengxf
 * 2013-2-20
 */
@Entity
@Table(name="t_pt_footprint")
@SequenceGenerator(name="seq_footprint",sequenceName="s_pt_footprint__id")
public class Footprint implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_footprint")
	private int id;
	
	@Column(name="query_string")
	private String queryString;
	
	private String ip;
	
	private Date createDate;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="pinyin")
	private String pinyin;
	
	@Column(name="pinyin_head")
	private String pinyinHead;

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	public String getPinyinHead() {
		return pinyinHead;
	}

	public void setPinyinHead(String pinyinHead) {
		this.pinyinHead = pinyinHead;
	}

}

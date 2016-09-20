package com.ulic.portal.search.indexing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 客户系统
 * @author zhangch
 *
 */
@Entity
@Table(name="t_pt_cusSystem")
public class CusSystem {
	@Id
	private int id;
	
	@Column(name="sys_name")
	private String sysName;
	
	@Column(name="sys_path")
	private String sysPath;
	
	@Column(name="sys_indexPath")
	private String sysIndexPath;
	
	@Column(name="queue_name")
	private String queueName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSysIndexPath() {
		return sysIndexPath;
	}

	public void setSysIndexPath(String sysIndexPath) {
		this.sysIndexPath = sysIndexPath;
	}

	public String getSysName() {
		return sysName;
	}

	public void setSysName(String sysName) {
		this.sysName = sysName;
	}

	public String getSysPath() {
		return sysPath;
	}

	public void setSysPath(String sysPath) {
		this.sysPath = sysPath;
	}

	public String getQueueName() {
		return queueName;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}
	
}

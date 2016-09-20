package com.ulic.portal.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 狗狗实体
 * @author wengxf
 * 2013-7-10
 */
@Entity
@Table(name="t_dog")
public class Dog implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	@ManyToOne
	@JoinColumn(name="home_id", referencedColumnName="id") //外键为home_id，与student中的id关联
	private Home home;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}

package com.ulic.portal.demo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 猫猫实体
 * @author wengxf
 * 2013-2-20
 */
@Entity
@Table(name="t_cat")
@SequenceGenerator(name="seq_cat",sequenceName="s_cat__id")
public class Cat implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_cat")
	private int id;

	@Column(name="cat_name")
	private String catName;

	private Date birthday;
	
	@Transient
	private String ext;
	
//	@ManyToOne
//	@JoinColumn(name="home_id", referencedColumnName="id")//外键为home_id，与student中的id关联
//	private Home home;

	
//	@ManyToMany
//	@JoinTable(name = "t_cat_hobby",  
//           joinColumns = {@JoinColumn(name = "cat_id")},  
//           inverseJoinColumns = {@JoinColumn(name = "hobby_id")}
//	)
//	private Set<Hobby> hobbys = new HashSet<Hobby>();


//	public Set<Hobby> getHobbys() {
//		return hobbys;
//	}
//
//	public void setHobbys(Set<Hobby> hobbys) {
//		this.hobbys = hobbys;
//	}

//	public Home getHome() {
//		return home;
//	}
//
//	public void setHome(Home home) {
//		this.home = home;
//	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}

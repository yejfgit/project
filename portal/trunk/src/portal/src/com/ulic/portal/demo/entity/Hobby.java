package com.ulic.portal.demo.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 * 猫猫实体
 * @author wengxf
 * 2013-2-20
 */
@Entity
@Table(name="t_hobby")
public class Hobby implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="hobby_id")
	private int hobbyId;

	@Column(name="hobby_name")
	private String hobbyName;
	
//	@ManyToMany(mappedBy = "hobbys", fetch = FetchType.EAGER)
//	@OrderBy(value = "id asc")
//    private List<Cat> cats = new ArrayList<Cat>();


//	public List<Cat> getCats() {
//		return cats;
//	}
//
//	public void setCats(List<Cat> cats) {
//		this.cats = cats;
//	}

	public int getHobbyId() {
		return hobbyId;
	}

	public void setHobbyId(int hobbyId) {
		this.hobbyId = hobbyId;
	}

	public String getHobbyName() {
		return hobbyName;
	}

	public void setHobbyName(String hobbyName) {
		this.hobbyName = hobbyName;
	}


}

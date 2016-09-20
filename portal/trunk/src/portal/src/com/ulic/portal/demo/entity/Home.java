package com.ulic.portal.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 * 家实体
 * @author User
 * 2013-7-10
 */
@Entity
@Table(name="t_home")
public class Home implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	private String address;
	
	@OneToMany(mappedBy = "home", fetch = FetchType.EAGER)
	@OrderBy(value = "id asc")
	private List<Dog> dogs = new ArrayList<Dog>();


	public List<Dog> getDogs() {
		return dogs;
	}

	public void setDogs(List<Dog> dogs) {
		this.dogs = dogs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

}

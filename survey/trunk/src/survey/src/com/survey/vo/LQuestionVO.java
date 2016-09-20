package com.survey.vo;

import java.util.ArrayList;
import java.util.List;

public class LQuestionVO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;

	private String name;

	private int libraryId;

	private String category;
	
	private List optionList;
	
	private int type;
	
	private int seq;
	
	private int num;
	
	private String typeName;
	
	private List categorys;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(int libraryId) {
		this.libraryId = libraryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List getOptionList() {
		return optionList;
	}

	public void setOptionList(List optionList) {
		this.optionList = optionList;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public List getCategorys() {
		return categorys;
	}

	public void setCategorys(List categorys) {
		this.categorys = categorys;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	
}
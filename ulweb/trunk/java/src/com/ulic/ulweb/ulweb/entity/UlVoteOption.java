package com.ulic.ulweb.ulweb.entity;

import java.sql.Timestamp;
import com.ulic.ulweb.frame.bean.AbstractBean;

public class UlVoteOption extends AbstractBean{
	private int optionId;
	private int questionId;
	private int amount;
	private int baseMun;
	private String optionName;
	private String optionContent;
	private String optionPath;
	private int optionType;
	private Timestamp insertTime;
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getBaseMun() {
		return baseMun;
	}
	public void setBaseMun(int baseMun) {
		this.baseMun = baseMun;
	}
	public Timestamp getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(Timestamp insertTime) {
		this.insertTime = insertTime;
	}
	public String getOptionContent() {
		return optionContent;
	}
	public void setOptionContent(String optionContent) {
		this.optionContent = optionContent;
	}
	public int getOptionId() {
		return optionId;
	}
	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}
	public String getOptionName() {
		return optionName;
	}
	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}
	public String getOptionPath() {
		return optionPath;
	}
	public void setOptionPath(String optionPath) {
		this.optionPath = optionPath;
	}
	public int getOptionType() {
		return optionType;
	}
	public void setOptionType(int optionType) {
		this.optionType = optionType;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	
	
}

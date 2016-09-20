package com.survey.vo;

import java.util.Date;
import java.util.List;

import com.survey.util.ContextUtil;


public class Survey implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String tip = "各位领导、各位同事：" +
	"欢迎使用合众人寿在线问卷系统，现在有一份问卷需要您填写。";

	private int id;

	private String name;

	private int ownerId;
	
	private int timeLimit;
	
	private int isShuffle;
	
	private List questionList;
	
	private String tips;
	
	private int minScore;
	
	private int maxScore;
	
	private String mailTips;
	
	private String hurryTips;
	
	private String closeTips;
	
	private int type;
	
	private int isDelete;
	
	private int isOpen;
	
	private int surveyScore;
	
	private int num;
	
	private Date createTime;
	
	private int dispatchNum;
	
	private int finishedNum;
	
	private int hurryTimes;
	
	public int getHurryTimes() {
		return hurryTimes;
	}

	public void setHurryTimes(int hurryTimes) {
		this.hurryTimes = hurryTimes;
	}

	public int getDispatchNum() {
		return dispatchNum;
	}

	public void setDispatchNum(int dispatchNum) {
		this.dispatchNum = dispatchNum;
	}

	public int getFinishedNum() {
		return finishedNum;
	}

	public void setFinishedNum(int finishedNum) {
		this.finishedNum = finishedNum;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCloseTips() {
		return closeTips;
	}

	public void setCloseTips(String closeTips) {
		this.closeTips = closeTips;
	}

	public String getHurryTips() {
		return hurryTips;
	}

	public void setHurryTips(String hurryTips) {
		this.hurryTips = hurryTips;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getSurveyScore() {
		return surveyScore;
	}

	public void setSurveyScore(int surveyScore) {
		this.surveyScore = surveyScore;
	}

	public int getIsOpen() {
		return isOpen;
	}

	public void setIsOpen(int isOpen) {
		this.isOpen = isOpen;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getMailTips() {
		return mailTips;
	}

	public void setMailTips(String mailTips) {
		this.mailTips = mailTips;
	}

	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}

	public List getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List questionList) {
		this.questionList = questionList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public int getIsShuffle() {
		return isShuffle;
	}

	public void setIsShuffle(int isShuffle) {
		this.isShuffle = isShuffle;
	}

	public int getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}

	public int getMaxScore() {
		return maxScore;
	}

	public void setMaxScore(int maxScore) {
		this.maxScore = maxScore;
	}

	public int getMinScore() {
		return minScore;
	}

	public void setMinScore(int minScore) {
		this.minScore = minScore;
	}
	
	public Survey(){
		
	}
	
	public Survey(int type){
		this.type = type;
		this.mailTips = tip;
		this.tips = tip;
		this.hurryTips = tip;
		this.closeTips = tip;
		this.createTime = new Date();
		this.name = "新建问卷";
		this.ownerId = ContextUtil.getCurrentUserId();
		
	}
}
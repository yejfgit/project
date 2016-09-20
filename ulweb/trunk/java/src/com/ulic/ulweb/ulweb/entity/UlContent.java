package com.ulic.ulweb.ulweb.entity;

import java.sql.Timestamp;

import com.ulic.ulweb.frame.bean.AbstractBean;

public class UlContent extends AbstractBean{
	private int contentId;
	private int columnId;
	private String contentName;
	private String content;
	private Timestamp uploadTime;
	private String uploadUser;
	private String organId;
	private int isDelete;
	private int attachmentSum;
	private String keyWord;
	private Timestamp updateTime;
	private int showOthersClass;
	private int showOrganClass;
	private int isQuickLink;
	private String documentNum;
	private String documentWord;
	private int haveContent;
	private int quickTime;
	private int onIndex;
	private int displayType;
	private String column_name;
	private String dept;
	private int columnLevel;
	private int parentId;
	private String subTitle;
	private String uploadDeptStr;
	private int uploadDeptInt;
	
	
	
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public int getUploadDeptInt() {
		return uploadDeptInt;
	}
	public void setUploadDeptInt(int uploadDeptInt) {
		this.uploadDeptInt = uploadDeptInt;
	}
	public String getUploadDeptStr() {
		return uploadDeptStr;
	}
	public void setUploadDeptStr(String uploadDeptStr) {
		this.uploadDeptStr = uploadDeptStr;
	}
	public String getColumn_name() {
		return column_name;
	}
	public void setColumn_name(String column_name) {
		this.column_name = column_name;
	}

	public int getColumnLevel() {
		return columnLevel;
	}
	public void setColumnLevel(int columnLevel) {
		this.columnLevel = columnLevel;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getDisplayType() {
		return displayType;
	}
	public void setDisplayType(int displayType) {
		this.displayType = displayType;
	}
	public int getOnIndex() {
		return onIndex;
	}
	public void setOnIndex(int onIndex) {
		this.onIndex = onIndex;
	}
	public int getQuickTime() {
		return quickTime;
	}
	public void setQuickTime(int quickTime) {
		this.quickTime = quickTime;
	}
	public int getHaveContent() {
		return haveContent;
	}
	public void setHaveContent(int haveContent) {
		this.haveContent = haveContent;
	}
	public String getDocumentNum() {
		return documentNum;
	}
	public void setDocumentNum(String documentNum) {
		this.documentNum = documentNum;
	}
	public String getDocumentWord() {
		return documentWord;
	}
	public void setDocumentWord(String documentWord) {
		this.documentWord = documentWord;
	}
	public int getIsQuickLink() {
		return isQuickLink;
	}
	public void setIsQuickLink(int isQuickLink) {
		this.isQuickLink = isQuickLink;
	}
	public int getAttachmentSum() {
		return attachmentSum;
	}
	public void setAttachmentSum(int attachmentSum) {
		this.attachmentSum = attachmentSum;
	}
	public int getColumnId() {
		return columnId;
	}
	public void setColumnId(int columnId) {
		this.columnId = columnId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getContentId() {
		return contentId;
	}
	public void setContentId(int contentId) {
		this.contentId = contentId;
	}
	public String getContentName() {
		return contentName;
	}
	public void setContentName(String contentName) {
		this.contentName = contentName;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public String getOrganId() {
		return organId;
	}
	public void setOrganId(String organId) {
		this.organId = organId;
	}
	public int getShowOrganClass() {
		return showOrganClass;
	}
	public void setShowOrganClass(int showOrganClass) {
		this.showOrganClass = showOrganClass;
	}
	public int getShowOthersClass() {
		return showOthersClass;
	}
	public void setShowOthersClass(int showOthersClass) {
		this.showOthersClass = showOthersClass;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public Timestamp getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(Timestamp uploadTime) {
		this.uploadTime = uploadTime;
	}
	public String getUploadUser() {
		return uploadUser;
	}
	public void setUploadUser(String uploadUser) {
		this.uploadUser = uploadUser;
	}
	
	public String getDay(){
		return this.getUploadTime().toString().substring(0,this.getUploadTime().toString().indexOf(" "));
		
	}
// 070809 add another function to get the day	
	public String getDay2(){
		return "" + this.getUpdateTime().getYear() + "-"
			+ (this.getUploadTime().getMonth() + 1) + "-" + this.getUploadTime().getDate();  
		
	}	
//070809 add to show the "new" pic	
	public String getNewPic(int betweenday){
		int days = (int)((System.currentTimeMillis() - this.getUploadTime().getTime())/86400000);
		return ( (days <= betweenday)  ? "<img src='images/index/new_01.gif' border=0 />" : "");
	}
	
	public String getNewPic(){
		int days = (int)((System.currentTimeMillis() - this.getUploadTime().getTime())/86400000);
		return ( (days <= 1)  ? "<img src='images/index/new_01.gif' border=0 />" : "");
	}
	
}

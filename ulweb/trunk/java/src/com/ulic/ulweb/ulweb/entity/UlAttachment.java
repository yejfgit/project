package com.ulic.ulweb.ulweb.entity;

import com.ulic.ulweb.frame.bean.AbstractBean;


public class UlAttachment extends AbstractBean{
	private int attachmentId;
	private String attachmentPath;
	private int isdelete;
	private int contentId;
	private String showName;
	private int attachmentOrder;
	private int attachmentType;
	
	public int getAttachmentType() {
		return attachmentType;
	}
	public void setAttachmentType(int attachmentType) {
		this.attachmentType = attachmentType;
	}
	public int getAttachmentOrder() {
		return attachmentOrder;
	}
	public void setAttachmentOrder(int attachmentOrder) {
		this.attachmentOrder = attachmentOrder;
	}
	public int getAttachmentId() {
		return attachmentId;
	}
	public void setAttachmentId(int attachmentId) {
		this.attachmentId = attachmentId;
	}
	public String getAttachmentPath() {
		return attachmentPath;
	}
	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}
	public int getContentId() {
		return contentId;
	}
	public void setContentId(int contentId) {
		this.contentId = contentId;
	}
	public int getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
	public String getShowName() {
		return showName;
	}
	public void setShowName(String showName) {
		this.showName = showName;
	}
	
//071022 add to show pic
	public String getImg(){
		return attachmentPath == null ? "" : "<img src='" + attachmentPath + "' border='0' />";
	}
	public String getImg(int width){
		if(attachmentPath == null)return "";
		StringBuffer sb = new StringBuffer();
		sb.append("<img src='" + attachmentPath + "'");
		sb.append(width == 0 ? "" : "width='" + width + "' ");
		sb.append(" border='0' />");
		return sb.toString();
	}
	
	public String getImg(int width, int height){
		if(attachmentPath == null)return "";
		StringBuffer sb = new StringBuffer();
		sb.append("<img src='" + attachmentPath + "' ");
		sb.append(width == 0 ? "" : "width='" + width + "' ");
		sb.append(height == 0 ? "" : "height='" + height + "' ");		
		sb.append(" border='0' />");
		return sb.toString();
	}
	
}

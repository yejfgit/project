package com.ulic.ulweb.po;

/**
 * UlAttachment generated by MyEclipse Persistence Tools
 */

public class UlAttachment implements java.io.Serializable {

	// Fields

	private int attachmentId;

	private String attachmentPath;

	private int isDelete;

	private int contentId;

	private String showName;

	private int attachmentOrder;

	private int attachmentType;

	public int getAttachmentId() {
		return attachmentId;
	}

	public void setAttachmentId(int attachmentId) {
		this.attachmentId = attachmentId;
	}

	public int getAttachmentOrder() {
		return attachmentOrder;
	}

	public void setAttachmentOrder(int attachmentOrder) {
		this.attachmentOrder = attachmentOrder;
	}

	public String getAttachmentPath() {
		return attachmentPath;
	}

	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}

	public int getAttachmentType() {
		return attachmentType;
	}

	public void setAttachmentType(int attachmentType) {
		this.attachmentType = attachmentType;
	}

	public int getContentId() {
		return contentId;
	}

	public void setContentId(int contentId) {
		this.contentId = contentId;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}


}
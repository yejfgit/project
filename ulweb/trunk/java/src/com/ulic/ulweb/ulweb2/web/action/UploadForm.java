package com.ulic.ulweb.ulweb2.web.action;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class UploadForm extends ActionForm {

	private FormFile file = null;

	private String filename = null;

	private String size = "";

	/**
	 * 是否转换为pad文档
	 */
	private int isToPdf;

	private String apolicy;

	private int contentId;

	private String policyName;

	private String newPolicydesc;

	private String newPolicySecure;

	private String newReadRange;
	
	private String newGroupIds;
	
	private String newGroupNames;
	
	private String newUserIds;
	
	private String newUserNames;

	private int attachmentListSize;

	public String getNewGroupNames() {
		return newGroupNames;
	}

	public void setNewGroupNames(String newGroupNames) {
		this.newGroupNames = newGroupNames;
	}


	public String getNewUserNames() {
		return newUserNames;
	}

	public void setNewUserNames(String newUserNames) {
		this.newUserNames = newUserNames;
	}


	public String getNewGroupIds() {
		return newGroupIds;
	}

	public void setNewGroupIds(String newGroupIds) {
		this.newGroupIds = newGroupIds;
	}

	public String getNewUserIds() {
		return newUserIds;
	}

	public void setNewUserIds(String newUserIds) {
		this.newUserIds = newUserIds;
	}

	public int getContentId() {
		return contentId;
	}

	public void setContentId(int contentId) {
		this.contentId = contentId;
	}

	public int getIsToPdf() {
		return isToPdf;
	}

	public void setIsToPdf(int isToPdf) {
		this.isToPdf = isToPdf;
	}

	public String getApolicy() {
		return apolicy;
	}

	public void setApolicy(String apolicy) {
		this.apolicy = apolicy;
	}

	public FormFile getFile() {
		return file;
	}

	public void setFile(FormFile file) {
		this.file = file;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public UploadForm() {
	}


	public String getNewPolicydesc() {
		return newPolicydesc;
	}

	public void setNewPolicydesc(String newPolicydesc) {
		this.newPolicydesc = newPolicydesc;
	}

	public String getNewPolicySecure() {
		return newPolicySecure;
	}

	public void setNewPolicySecure(String newPolicySecure) {
		this.newPolicySecure = newPolicySecure;
	}

	public String getNewReadRange() {
		return newReadRange;
	}

	public void setNewReadRange(String newReadRange) {
		this.newReadRange = newReadRange;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public int getAttachmentListSize() {
		return attachmentListSize;
	}

	public void setAttachmentListSize(int attachmentListSize) {
		this.attachmentListSize = attachmentListSize;
	}


}

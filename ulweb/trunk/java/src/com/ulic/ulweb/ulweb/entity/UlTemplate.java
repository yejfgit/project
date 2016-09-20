package com.ulic.ulweb.ulweb.entity;

import java.sql.Timestamp;

public class UlTemplate {

	private int templateId;
	private String templateName;
	private int templatePtype;
	private String templateDept;
	private String templateDesc;
	private String css;
	private Timestamp saveTime;
	private String userId;
	private int isDelete;
	private int pageSize;
	private String pic1;
	private String pic2;
	private String pic3;
	private String pic4;
	private String pic5;
	private String pic6;
	private String flash;
	private int columnId;
	
	
	public int getColumnId() {
		return columnId;
	}
	public void setColumnId(int columnId) {
		this.columnId = columnId;
	}
	public String getCss() {
		return css;
	}
	public void setCss(String css) {
		this.css = css;
	}
	public String getFlash() {
		return flash;
	}
	public void setFlash(String flash) {
		this.flash = flash;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getPic1() {
		return (pic1 == null ? "" : pic1 );
	}
	public void setPic1(String pic1) {
		this.pic1 = pic1;
	}
	public String getPic2() {
		return (pic2 == null ? "" : pic2 );
	}
	public void setPic2(String pic2) {
		this.pic2 = pic2;
	}
	public String getPic3() {
		return (pic3 == null ? "" : pic3 );
	}
	public void setPic3(String pic3) {
		this.pic3 = pic3;
	}
	public String getPic4() {
		return (pic4 == null ? "" : pic4 );
	}
	public void setPic4(String pic4) {
		this.pic4 = pic4;
	}
	public String getPic5() {
		return (pic5 == null ? "" : pic5 );
	}
	public void setPic5(String pic5) {
		this.pic5 = pic5;
	}
	public String getPic6() {
		return (pic6 == null ? "" : pic6 );
	}
	public void setPic6(String pic6) {
		this.pic6 = pic6;
	}
	public Timestamp getSaveTime() {
		return saveTime;
	}
	public void setSaveTime(Timestamp saveTime) {
		this.saveTime = saveTime;
	}
	public String getTemplateDept() {
		return templateDept;
	}
	public void setTemplateDept(String templateDept) {
		this.templateDept = templateDept;
	}
	public String getTemplateDesc() {
		return templateDesc;
	}
	public void setTemplateDesc(String templateDesc) {
		this.templateDesc = templateDesc;
	}
	public int getTemplateId() {
		return templateId;
	}
	public void setTemplateId(int templateId) {
		this.templateId = templateId;
	}
	public String getTemplateName() {
		return templateName;
	}
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	public int getTemplatePtype() {
		return templatePtype;
	}
	public void setTemplatePtype(int templatePtype) {
		this.templatePtype = templatePtype;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getImg1() {
		return (pic1 == null ? "" : "<img src='" + pic1 + "' border='0' />");
	}
	public String getImg2() {
		return (pic2 == null ? "" : "<img src='" + pic2 + "' border='0' />");
	}
	public String getImg3() {
		return (pic3 == null ? "" : "<img src='" + pic3 + "' border='0' />");
	}
	public String getImg4() {
		return (pic4 == null ? "" : "<img src='" + pic4 + "' border='0' />");
	}
	public String getImg5() {
		return (pic5 == null ? "" : "<img src='" + pic5 + "' border='0' />");
	}
	public String getImg6() {
		return (pic6 == null ? "" : "<img src='" + pic6 + "' border='0' />");
	}
	public String getCssOnPage(){
		return (css == null ? "" : css);
	}
	
	
	
}

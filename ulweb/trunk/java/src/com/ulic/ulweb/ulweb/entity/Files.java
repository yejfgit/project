package com.ulic.ulweb.ulweb.entity;

import java.sql.Timestamp;
import java.util.List;

public class Files {
	private int fileid;
	private String title;
	private int columnid;
	private String uploaduser;
	private Timestamp uploadtime;
	private String content;
	private int used;
	private int docno;
	private String keyword;
	private String attName;
	private int docid;
	private int aused;
	private String realName;
	private List<Attachment> l;
	private int haveContent;
	
	
	public int getHaveContent() {
		return haveContent;
	}
	public void setHaveContent(int haveContent) {
		this.haveContent = haveContent;
	}
	public String getAttName() {
		return attName;
	}
	public void setAttName(String attName) {
		this.attName = attName;
	}
	public int getAused() {
		return aused;
	}
	public void setAused(int aused) {
		this.aused = aused;
	}
	public int getColumnid() {
		return columnid;
	}
	public void setColumnid(int columnid) {
		this.columnid = columnid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getDocid() {
		return docid;
	}
	public void setDocid(int docid) {
		this.docid = docid;
	}
	public int getDocno() {
		return docno;
	}
	public void setDocno(int docno) {
		this.docno = docno;
	}
	public int getFileid() {
		return fileid;
	}
	public void setFileid(int fileid) {
		this.fileid = fileid;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Timestamp getUploadtime() {
		return uploadtime;
	}
	public void setUploadtime(Timestamp uploadtime) {
		this.uploadtime = uploadtime;
	}
	public String getUploaduser() {
		return uploaduser;
	}
	public void setUploaduser(String uploaduser) {
		this.uploaduser = uploaduser;
	}
	public int getUsed() {
		return used;
	}
	public void setUsed(int used) {
		this.used = used;
	}
	public List<Attachment> getL() {
		return l;
	}
	public void setL(List<Attachment> l) {
		this.l = l;
	}
	
	
}

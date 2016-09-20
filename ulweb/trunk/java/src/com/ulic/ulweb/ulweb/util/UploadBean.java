package com.ulic.ulweb.ulweb.util;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;

public class UploadBean {
	private SmartUpload su;
	private File file;
	private Request req;
	private String dummyPath;
	private String mimeType;
	private String realFileName;
	public String getRealFileName() {
		return realFileName;
	}
	public UploadBean(ServletConfig servletConfig, HttpServletRequest request,
			HttpServletResponse response, String path) throws Exception {
		su = new SmartUpload();
		su.initialize(servletConfig, request, response);
		su.setMaxFileSize(5*1024*1024);
		su.upload();
		
		req = su.getRequest();
		Files files = su.getFiles();
		String rand = "/" + (int) (Math.random() * 1000000);
		java.io.File f = new java.io.File(path);
		if (!f.exists()) {
			f.mkdirs();
		}
		file = files.getFile(0);
		mimeType = file.getTypeMIME();
		path = path + rand + "." + file.getFileExt();
		file.saveAs(path);
		realFileName = path ;
		dummyPath = path = request.getContextPath() + "/" + path.substring(path.indexOf("files/"), path.length());
		
		
	}
	public String getMIMEType()
	{
		return mimeType;
	}
	public String getParameter(String key) {
		return req.getParameter(key);
	}
	public String getDummyPath() {
		return dummyPath;
	}
	public File getFile() {
		return file;
	}
	public Request getReq() {
		return req;
	}
	public void setReq(Request req) {
		this.req = req;
	}
}

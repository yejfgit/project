package com.ulic.portal.pub.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FileUploadAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Log log = LogFactory.getLog(FileUploadAction.class);
	
	private File file;
	private String fileFileName;
	private String fileContentType;

	public String execute() throws Exception {
		// 实现上传
		InputStream is = new FileInputStream(file);
		String root = "d:/file/portal";
		File diskFile = new File(root, this.getFileFileName());
		OutputStream os = new FileOutputStream(diskFile);
		byte[] bytefer = new byte[1024];
		int length = 0;
		while ((length = is.read(bytefer)) != -1) {
			os.write(bytefer, 0, length);
		}
		os.close();
		is.close();
		
		log.debug(this.getFileFileName());
		log.debug(diskFile.getAbsolutePath());
		return "success";
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

}

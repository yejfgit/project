package com.survey.util.file;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Hashtable;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;
import org.apache.struts.upload.MultipartRequestHandler;

public class FileUploadUtil {

	private int fileMaxSize = 200;
	
	private int fileNameMaxLength = 100;
	
	private String fileBoxKey = "uploadFile";
	
	private ActionForm form;
	
	private IFileHandler fileHandler;

	
	/**
	 * 文件上传
	 * @param fileMaxSize	文件最大大小
	 * @param fileNameMaxLength	文件名最大长度
	 * @param fileBoxKey	文件输入框名称<input type="file" name="KEY">
	 * @param form	struts ActionForm
	 * @param fileHandler	文件处理器，针对每一个文件进行处理
	 */
	public FileUploadUtil(int fileMaxSize, int fileNameMaxLength, String fileBoxKey, 
			ActionForm form, IFileHandler fileHandler) {
		super();
		this.fileMaxSize = fileMaxSize;
		this.fileNameMaxLength = fileNameMaxLength;
		this.fileBoxKey = fileBoxKey;
		this.form = form;
		this.fileHandler = fileHandler;
	}
	
	
	
	
	public void upload() throws Exception {
		MultipartRequestHandler mrh = form.getMultipartRequestHandler();
		
		if (mrh == null) {
			throw new Exception("文件不存在");
		}

		Hashtable files = mrh.getFileElements();
		OutputStream fos = null;
		boolean hasLongName = false;
		boolean hasBigFile = false;
		for(int i = 1; i <= files.size(); i++) {
			String key = fileBoxKey + String.valueOf(i); 
			FormFile file = (FormFile) files.get(key);
			System.out.println(key + " - " + file.getFileName() + "," + file.getFileSize());
				

			if (file.getFileSize() == 0 || file.getFileName() == null 
					|| file.getFileName().indexOf(".") == -1) {
				continue;
			}
			if (file.getFileSize() > fileMaxSize * 1024 * 1024 ){
				hasBigFile = true;
				continue;
			}
			if (file.getFileName().length() > fileNameMaxLength ){
				hasLongName = true;
				continue;
			}

			String filePath = fileHandler.getFilePath(file.getFileName(), file.getFileSize());
			fos = new FileOutputStream(filePath);
			InputStream fis = file.getInputStream();
			int buffer = 1024 * 100;
			int len = 0;
			byte[] b = new byte[buffer];
			while ((len = fis.read(b)) != -1) {
				fos.write(b, 0, len);
			}
			

			fos.flush();
			fos.close();
			fis.close();
		}
		
		
		String msg = "";
		// 大文件的提示
		if (hasBigFile) {
			msg += "您上传的某个文件超过 " + fileMaxSize + " MB ，该文件暂时无法上传。";
		}
		// 长文件名的提示
		if (hasLongName) {
			msg += "您上传的某个文件名称长度超过 " + fileNameMaxLength + " 个字 ，该文件暂时无法上传。";
		}
		if (hasBigFile || hasLongName) {
			msg += "其他文件已经上传成功。";
			return;
		}

	}



	
	/**
	 * 根据文件全名获得文件扩展名
	 * @param fileName
	 * @return
	 */
	public static String getFileType(String fileName) {
		
		int dot = fileName.lastIndexOf(".");
		if (dot == -1) {
			return "";
		} else {
			return fileName.substring(dot + 1, fileName.length());
		}
		
	}

	
}


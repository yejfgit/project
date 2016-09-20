package com.ulic.ulweb.ulweb2.service.impl.task;

import java.io.File;
import java.net.MalformedURLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ulic.ulweb.frame.service.ServiceLocator;
import com.ulic.ulweb.ulweb2.entity.AttachmentEntity;
import com.ulic.ulweb.ulweb2.service.IAttachmentService;
import com.ulic.ulweb.ulweb2.util.ConfigManager;

/**
 * 功能：将一个文件转换成pdf文件
 * 
 * @author Linda.Hou
 * 
 */
public class Securer implements Runnable {

	private static Log _logger = LogFactory.getLog(Securer.class);
	
	private AttachmentEntity attachmentEntity;

	private static IAttachmentService attachmentService = (IAttachmentService) ServiceLocator
			.getService("attachmentAdminService");

	private static SecureDocHttpClient2 client = new SecureDocHttpClient2(
			ConfigManager.getCreatePolicyUsername(),
			ConfigManager.getCreatePolicePassword(),
			ConfigManager.config.getString("policy_server_ip"),
			ConfigManager.config.getString("policy_server_port"));

	private static  String webappsDir = null;
	static {
		String javaHome = System.getProperty("tomcat.home");
		if (javaHome == null) {
			javaHome = System.getProperty("catalina.home");
		}
		
		if(javaHome != null){
			File tomcatFile = new File(javaHome,"webapps");
			try {
				webappsDir = tomcatFile.toURL().getPath();
				if(webappsDir.startsWith("/")){
					webappsDir = webappsDir.substring(1);
				}
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	private static final String _webURL = ConfigManager.config
			.getString("webURL");


	Securer(AttachmentEntity attachmentEntity) {
		this.attachmentEntity = attachmentEntity;
	}

	public void run() {
		if (attachmentEntity != null) {
			_logger.debug("attachmentEntity " + attachmentEntity);
			try {
				
				// 开始加密
				String inFilePath = attachmentEntity.getPdfPath();
				if(inFilePath == null || "".equals(inFilePath.trim())){
					inFilePath = attachmentEntity.getAttachmentPath();
				}
				String secureSubPath = getSecureSubPath(inFilePath);
				File inFile = new File(ConfigManager.getUploadPath(),inFilePath);
				if (inFile.exists() && inFilePath.endsWith(".pdf")) {
					inFilePath = inFile.toURL().getPath();
					inFilePath = inFilePath.replaceAll(ConfigManager.getUploadPath(), _webURL);
					while(inFilePath.startsWith("/")){
						inFilePath = inFilePath.substring(1);
					}					
					File secureFile = new File(ConfigManager.getUploadFile(),secureSubPath);
					_logger.debug("开始加密 : " +inFilePath);
					_logger.debug(inFilePath);
					if(attachmentEntity.getUlPolicy() !=null){
						client.secure(attachmentEntity.getUlPolicy().getPolicyId(),
								inFilePath, secureFile, inFile.getName());
						

						if(secureFile.length()>0){
							_logger.debug("加密完成 ："+ secureFile.getAbsolutePath());
							// 加密之后
							attachmentEntity
									.setSecurePath(secureSubPath);
							attachmentEntity.setStatus(5);// 成功为5，失败-5
							
							
						}else{
							secureFile.delete();
							attachmentEntity.setStatus(-5);// 成功为5，失败-5
							attachmentEntity.setErrorMessage("加密失败，请检查文件内容是否正确");
						}
					}else{
						secureFile.delete();
						attachmentEntity.setStatus(-5);// 成功为5，失败-5
						attachmentEntity.setErrorMessage("没有找到相应的加密策略");
					}
					
					
				} else {
					
					attachmentEntity.setStatus(-5);// 成功为5，失败-5
					attachmentEntity.setErrorMessage("file : [" + inFile.getAbsolutePath()
							+ "] not exist,or is not a pdf file.");
				}
				//				
			} catch (Exception e) {

				e.printStackTrace();
				attachmentEntity.setStatus(-5);
			}

			// 保存
			try {
				attachmentService.updateAttachment(attachmentEntity);
				AttachmentEventListener.handleStatus(attachmentEntity);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
	
	private String getSecureSubPath(String srcPath){
		String subPath = null;
		int index = srcPath.lastIndexOf("/");
		int index2 = srcPath.lastIndexOf(".");
		String parentPath = srcPath.substring(0,index);
		String fileName = srcPath.substring(index+1,index2);
		subPath = parentPath + "/secure_"+fileName+".pdf";
		while(subPath.indexOf("secure_pdf_")>=0){
			subPath = subPath.replace("secure_pdf_", "secure_");
		}
		return subPath ;
	}
}

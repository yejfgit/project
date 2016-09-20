package com.ulic.ulweb.ulweb2.service.impl.task;

import java.io.File;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ulic.ulweb.frame.service.ServiceLocator;
import com.ulic.ulweb.ulweb2.entity.AttachmentEntity;
import com.ulic.ulweb.ulweb2.service.IAttachmentService;
import com.ulic.ulweb.ulweb2.service.convert.TOPDF;
import com.ulic.ulweb.ulweb2.util.ConfigManager;

/**
 * 功能：将一个文件转换成pdf文件
 * 
 * @author Linda.Hou
 * 
 */
public class Convertor implements Runnable {

	private static Log _logger = LogFactory.getLog(Convertor.class);
	
	private AttachmentEntity attachmentEntity;

	private static final String _pdf_dir = "pdf_dir";

	private static File _pafFile = null;

	private static TOPDF toPdf = TOPDF.getInstance();

	static {
		init();
	}

	private static IAttachmentService attachmentService = (IAttachmentService) ServiceLocator
			.getService("attachmentAdminService");

	Convertor(AttachmentEntity attachmentEntity) {
		this.attachmentEntity = attachmentEntity;
	}

	public void run() {

		if (attachmentEntity != null) {

			try {

				File srcFile = new File(ConfigManager.getUploadFile(),
						attachmentEntity.getAttachmentPath());

				// 转换
				String psfSubPath = getPdfSubPath(attachmentEntity
						.getAttachmentPath());
				File destFile = new File(ConfigManager.getUploadFile(),
						psfSubPath);

				if (srcFile.exists() ) {
					_logger.debug("开始转换文件" + srcFile.getName());
					toPdf.toPDF(srcFile.getAbsolutePath(), destFile, srcFile
							.getName());
					_logger.debug("转换文件结束" + srcFile.getName());
					// 转换完毕之后

					attachmentEntity.setPdfPath(psfSubPath);
					if (attachmentEntity.getNeedSecure() == 1) {
						attachmentEntity.setStatus(3);// 待加密

					} else {
						attachmentEntity.setStatus(2);// 转换成功
					}
				} else {
					attachmentEntity.setErrorMessage("file : ["
							+ srcFile.getAbsolutePath()
							+ "] is not exist.");
					attachmentEntity.setStatus(-2);// 转换失败
				}

				//				
			} catch (Exception e) {
				e.printStackTrace();
				attachmentEntity.setStatus(-2);
				_logger.debug("attachmentEntity = " + attachmentEntity
						+ " to pdf failed.");
				
			}

			// 保存
			try {
				attachmentService.updateAttachment(attachmentEntity);
				AttachmentEventListener.handleStatus(attachmentEntity);
				// 唤醒加密线程
				if (attachmentEntity.getStatus() == 3) {
					SecureListerer secureListerer = SecureListerer
							.getInstance();
					synchronized (secureListerer) {
						secureListerer.notifyAll();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	private String getPdfSubPath(String srcPath) {
		String pdfSubPath = null;
		int index = srcPath.lastIndexOf("/");
		int index2 = srcPath.lastIndexOf(".");
		String parentPath = srcPath.substring(0, index);
		String fileName = srcPath.substring(index+1, index2);
		pdfSubPath = parentPath + "/pdf_" + fileName + ".pdf";
		
		return pdfSubPath;
	}

	private static void init() {

		String destPath = ConfigManager.getString(_pdf_dir);
		if (destPath == null || "".equals(destPath.trim())) {
			destPath = "pdf";
		}

		_pafFile = new File(destPath);

	}
}

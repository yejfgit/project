package com.ulic.ulweb.ulweb2.service.impl.task;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ulic.ulweb.frame.service.ServiceLocator;
import com.ulic.ulweb.ulweb2.entity.AttachmentEntity;
import com.ulic.ulweb.ulweb2.service.IAttachmentService;

/**
 * 功能：监听待转换的数据，发现待转换的数据后，交给交换者转换
 * 
 * @author Linda.Hou
 * 
 */
public class SecureListerer extends Thread {

	private static Log _logger = LogFactory.getLog(SecureListerer.class);

	// 线程池
	private ExecutorService exec = Executors.newFixedThreadPool(20);

	private static SecureListerer secureListerer = new SecureListerer();

	public static SecureListerer getInstance() {
		return secureListerer;
	}

	@Override
	public void run() {
		while (true) {

			try {
				IAttachmentService attachmentService = (IAttachmentService) ServiceLocator
						.getService("attachmentAdminService");
				List<AttachmentEntity> list = attachmentService.listSecure();
				_logger.debug("secure list : " +list);
				synchronized (this) {

					if (list != null && list.size() > 0) {
						for (AttachmentEntity attachmentEntity : list) {
							_logger.debug(" attachmentEntity = "
									+ attachmentEntity);
							// 转换
							 attachmentEntity.setStatus(4);// 设置为加密中
							 attachmentService.updateAttachment(attachmentEntity);
							 AttachmentEventListener.handleStatus(attachmentEntity);
							 exec.submit(new Securer(attachmentEntity));
//							 new Securer(attachmentEntity).run();
						}
					}else{
						this.wait();
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
				_logger.error("ConverListerer run error.", e);
				try {
					this.sleep(3000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}

	}
	
	

	public static void main(String[] args) {
		SecureListerer secureListerer = SecureListerer.getInstance();
		secureListerer.run();
	}
}

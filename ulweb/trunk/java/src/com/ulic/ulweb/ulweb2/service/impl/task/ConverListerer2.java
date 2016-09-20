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
public class ConverListerer2 extends Thread {

	private static Log _logger = LogFactory.getLog(ConverListerer2.class);

	// 线程池
	private ExecutorService exec = Executors.newFixedThreadPool(20);

	private static ConverListerer2 converListerer = new ConverListerer2();

	public static ConverListerer2 getInstance() {
		return converListerer;
	}

	@Override
	public void run() {
		_logger.debug("ConverListerer2  run ");
		IAttachmentService attachmentService = (IAttachmentService) ServiceLocator
				.getService("attachmentAdminService");
		while (true) {

			try {

				List<AttachmentEntity> list = attachmentService.listGenerate();
				_logger.debug(" need_generate list : " + list);
				synchronized (this) {
					if (list != null && list.size() > 0) {
						for (AttachmentEntity attachmentEntity : list) {
							// 转换
							attachmentEntity.setStatus(1);// 设置为转换中
							attachmentService.updateAttachment(attachmentEntity);
							AttachmentEventListener.handleStatus(attachmentEntity);
							exec.submit(new Convertor(attachmentEntity));
//							new Convertor(attachmentEntity).run();
						}
					} else {

						_logger.debug(" ConverListerer2 to wait ....");
						this.wait();
						_logger.debug(" ConverListerer2 wait end ....");
					}

				}

			} catch (Exception e) {
				_logger.error("ConverListerer run error.", e);
			}

		}

	}
}

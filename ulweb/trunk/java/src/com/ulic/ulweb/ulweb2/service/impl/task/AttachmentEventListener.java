package com.ulic.ulweb.ulweb2.service.impl.task;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ulic.ulweb.frame.service.ServiceLocator;
import com.ulic.ulweb.ulweb2.entity.AttachmentEntity;
import com.ulic.ulweb.ulweb2.entity.ContentEntity;
import com.ulic.ulweb.ulweb2.service.IAttachmentService;
import com.ulic.ulweb.ulweb2.service.IContentService;
import com.ulic.ulweb.ulweb2.util.UlicSendMail;

public class AttachmentEventListener {

	private static Log log = LogFactory.getLog(AttachmentEventListener.class);
	
	public final static int SecureFailure = -5;
	
	public final static int ConvertFailure = -2;
	
	public final static int ToConvert = 0;
	
	public final static int Converting = 1;
	
	public final static int ConvertSuccess = 2;
	
	public final static int ToSecure = 3;
	
	public final static int Securing = 4;
	
	public final static int SecureSuccess = 5;
	
	public final static int DoNothing = 6;
	
	
	private static AttachmentEventListener ael = new AttachmentEventListener();
	
	public static AttachmentEventListener getInstance() {
		return ael;

	}


	private IContentService cons = (IContentService) ServiceLocator
			.getService("contentAdminService");

	private IAttachmentService atts = (IAttachmentService) ServiceLocator
			.getService("attachmentAdminService");
	
	/**
	 * 分发不同的状态事件到不同的监听器
	 * @param ae
	 * @param status
	 */
	public static void handleStatus(AttachmentEntity ae) {
		
		switch (ae.getStatus()) {
		case AttachmentEventListener.DoNothing: 
			getInstance().onDoNothing(ae);
			break;
		case AttachmentEventListener.ToConvert: 
			getInstance().onToConvert(ae);
			break;
		case AttachmentEventListener.Converting: 
			getInstance().onConverting(ae);
			break;
		case AttachmentEventListener.ConvertSuccess: 
			getInstance().onConvertSuccess(ae);
			break;
		case AttachmentEventListener.ConvertFailure: 
			getInstance().onConvertFailure(ae);
			break;
		case AttachmentEventListener.ToSecure: 
			getInstance().onToSecure(ae);
			break;
		case AttachmentEventListener.Securing: 
			getInstance().onSecuring(ae);
			break;
		case AttachmentEventListener.SecureSuccess: 
			getInstance().onSecureSuccess(ae);
			break;
		case AttachmentEventListener.SecureFailure: 
			getInstance().onSecureFailure(ae);
			break;

		default :
			System.err.println("-------- got wrong attachment status number");
		}

	}

	/** 不作处理 */
	public void onDoNothing(AttachmentEntity ae) {
		log.info("==================== " + ae.getShowName() + " onDoNothing");
		
	}
	
	/** 待转换 */
	public void onToConvert(AttachmentEntity ae) {
		log.info("==================== " + ae.getShowName() + " onToConvert");
		setContentNoDisplay(ae);
		
	}
	/** 转换中 */
	public void onConverting(AttachmentEntity ae) {
		log.info("==================== " + ae.getShowName() + " onConverting");
		
	}
	/** 转换成功 */
	public void onConvertSuccess(AttachmentEntity ae) {
		log.info("==================== " + ae.getShowName() + " onConvertSuccess");
		// TODO send email
		String to = ae.getUploadUser() + "@ulic.com.cn";
//		String to = "wengxf@ulic.com.cn";
		ae.setContent(cons.getContentById(ae.getContent().getContentId()));
		String msg = "内容编号：" + ae.getContent().getContentId()
		+ "，内容名称：" + ae.getContent().getContentName()
		+ "，\n附件编号：" + ae.getAttachmentId()
		+ "，附件名称：" + ae.getShowName()
		+ "。\n附件转换成功";
		new UlicSendMail().send(to, "", "", "您的附件转换成功", msg);
		
		
		if (isAllAttachmentDone(ae)) {
			setContentDisplay(ae);
		}
		
	}
	/** 转换失败 */
	public void onConvertFailure(AttachmentEntity ae) {
		log.info("==================== " + ae.getShowName() + " onConvertFailure");
		// TODO send email
		String to = ae.getUploadUser() + "@ulic.com.cn";
//		String to = "wengxf@ulic.com.cn";
		ae.setContent(cons.getContentById(ae.getContent().getContentId()));
		String msg = "内容编号：" + ae.getContent().getContentId()
		+ "，内容名称：" + ae.getContent().getContentName()
		+ "，\n附件编号：" + ae.getAttachmentId()
		+ "，附件名称：" + ae.getShowName()
		+ "。\n附件转换失败，请重试";
		new UlicSendMail().send(to, "", "", "您的附件转换失败", msg);
		
	}

	/** 待加密 */
	public void onToSecure(AttachmentEntity ae) {
		log.info("==================== " + ae.getShowName() + " onToSecure");
		if (ae.getNeedGenerate() == 0) {
			setContentNoDisplay(ae);
		}
		
	}
	/** 加密中 */
	public void onSecuring(AttachmentEntity ae) {
		log.info("==================== " + ae.getShowName() + " onSecuring");
		
	}
	/** 加密成功 */
	public void onSecureSuccess(AttachmentEntity ae) {
		log.info("==================== " + ae.getShowName() + " onSecureSuccess");
		// TODO send email
		String to = ae.getUploadUser() + "@ulic.com.cn";
//		String to = "wengxf@ulic.com.cn";
		ae.setContent(cons.getContentById(ae.getContent().getContentId()));
		String msg = "内容编号：" + ae.getContent().getContentId()
		+ "，内容名称：" + ae.getContent().getContentName()
		+ "，\n附件编号：" + ae.getAttachmentId()
		+ "，附件名称：" + ae.getShowName()
		+ "。\n附件加密成功";
		new UlicSendMail().send(to, "", "", "您的附件加密成功", msg);
		
		
		if (isAllAttachmentDone(ae)) {
			setContentDisplay(ae);
		}

	}
	/** 加密失败 */
	public void onSecureFailure(AttachmentEntity ae) {
		log.info("==================== " + ae.getShowName() + " onSecureFailure");
		// TODO send email
		String to = ae.getUploadUser() + "@ulic.com.cn";
//		String to = "wengxf@ulic.com.cn";
		ae.setContent(cons.getContentById(ae.getContent().getContentId()));
		String msg = "内容编号：" + ae.getContent().getContentId()
			+ "，内容名称：" + ae.getContent().getContentName()
			+ "，\n附件编号：" + ae.getAttachmentId()
			+ "，附件名称：" + ae.getShowName()
			+ "。\n附件加密失败，请重试";
		new UlicSendMail().send(to, "", "", "您的附件加密失败", msg);
	}
	
	
	/**
	 * 设置该附件对应的内容隐藏
	 * @param ae
	 */
	private void setContentNoDisplay(AttachmentEntity ae) {
		try {
			ContentEntity c = cons.getContentById(ae.getContent().getContentId());
			if (c.getIsProcessing() == 0) {
				c.setIsProcessing(1);
				cons.updateContent(c);
				log.info("***************** " + c.getContentId() + " hide");
				ContentEventListener.onContentEdit(c);
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 设置该附件对应的内容显示
	 * @param ae
	 */
	private void setContentDisplay(AttachmentEntity ae) {
		try {
			ContentEntity c = cons.getContentById(ae.getContent().getContentId());
			if (c.getIsProcessing() == 1) {
				c.setIsProcessing(0);
				cons.updateContent(c);
				log.info("***************** " + c.getContentId() + " show");
				ContentEventListener.onContentEdit(c);
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 检查是否所有附件都就绪（包括不作处理，转换成功不加密，加密成功3种）
	 * @param ae
	 * @return
	 */
	private boolean isAllAttachmentDone(AttachmentEntity ae) {
		
		return isAllAttachmentDone(ae.getContent());
		
	}

	/**
	 * 检查是否所有附件都就绪（包括不作处理，转换成功不加密，加密成功3种）
	 * @param c
	 * @return
	 */
	public boolean isAllAttachmentDone(ContentEntity c) {
		
		try {
			List<AttachmentEntity> l = atts.listAttachmentByContentId(c.getContentId());
			for (AttachmentEntity att : l) {
				int s = att.getStatus();
				if (s == AttachmentEventListener.DoNothing
				|| s == AttachmentEventListener.ConvertSuccess
				|| s == AttachmentEventListener.SecureSuccess
				) {
					;
				} else {
					return false;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
}

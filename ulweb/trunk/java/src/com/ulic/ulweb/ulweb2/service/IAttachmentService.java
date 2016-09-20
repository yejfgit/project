package com.ulic.ulweb.ulweb2.service;

import java.util.Date;
import java.util.List;

import com.adobe.edc.sdk.infomodel.Policy;
import com.ulic.ulweb.frame.service.IService;
import com.ulic.ulweb.ulweb2.entity.AttachmentEntity;
import com.ulic.ulweb.ulweb2.entity.UlPolicy;

public interface IAttachmentService extends IService{

	/**
	 * 根据ID得到attachment。
	 */
	public AttachmentEntity getAttachmentById(int attachmentId)throws Exception;
	
	/**
	 * 根据contentId得到attachment列表。
	 * @throws Exception 
	 */
	public List<AttachmentEntity> listAttachmentByContentId(int contentId) throws Exception;
		
	/**
	 * 得到状态为 status 的attachment列表。
	 */
	public List<AttachmentEntity> listAttachmentByStatus(int status)throws Exception;
	
	
	/**
	 * 增加attachment
	 * @throws Exception 
	 */
	public AttachmentEntity addAttachment(AttachmentEntity ae) throws Exception;
	
	/**
	 * 获取要转换的AttachementEntity的集合
	 * isDelete=0，need_generate=1 status = 0
	 * @return
	 * @throws Exception 
	 */
	public List<AttachmentEntity> listGenerate() throws Exception;
	
	
	
	/**
	 * 获取要加密的AttachementEntity的集合
	 * isDelete=0，need_secure=1 status = 0
	 * @return
	 * @throws Exception 
	 */
	public List<AttachmentEntity> listSecure() throws Exception;
	
	/**
	 * 对他做转换完毕的处理
	 * @param ae
	 * @throws Exception 
	 */
	public void updateAttachment(AttachmentEntity ae) throws Exception;
	
	
	/**
	 * 作废attachment
	 */
	public void deleteAttachment(AttachmentEntity ae) throws Exception;
	
	/**
	 * 取attachmentId对应的policy policyServer上的策略
	 */
	public UlPolicy getPolicyByAttachment(int attachmentId) throws Exception;
	
	/**
	 * 获取userId用户在begin到end 的时间范围内上传的附件的处理情况
	 * @throws Exception 
	 */
	public List<AttachmentEntity> findAttachEntity(String userId,Date begin,Date end) throws Exception;
	/**
	 * 取得policyServer上的组
	 */
	
	/**
	 * 获取一个policyId对应的策略
	 */
	public UlPolicy getUlPolicyById(String policyid)throws Exception;
	
	public int getOrderByContentId(int contentId)throws Exception;
	
	public void updateOrder(int attachmentId,int order)throws Exception;
	/**
	 * 取特定人员
	 */
	
	/**
	 * 增加策略
	 */
	
	/**
	 * 取附件的策略
	 */
	
	
	
	
	
	
	
	
}

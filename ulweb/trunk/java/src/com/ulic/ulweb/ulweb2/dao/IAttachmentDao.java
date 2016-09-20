package com.ulic.ulweb.ulweb2.dao;

import java.util.List;
import java.util.Map;

import com.ulic.ulweb.ulweb2.entity.AttachmentEntity;
import com.ulic.ulweb.ulweb2.entity.UlPolicy;

public interface IAttachmentDao {

	public AttachmentEntity addAttachement(AttachmentEntity ae) throws Exception ;

	public AttachmentEntity getAttachmentById(int id)throws Exception;

	@SuppressWarnings("unchecked")
	public List<AttachmentEntity> listAttachment(String sql,Map<String,Object> map)
			throws Exception ;

	public void update(AttachmentEntity ae) throws Exception ;
	
	public UlPolicy getUlPolicyById(String policyid)throws Exception ;
	
	public int getOrderByContentId(int contentId)throws Exception;
	
	public void updateOrder(int attachmentId,int order)throws Exception;
}

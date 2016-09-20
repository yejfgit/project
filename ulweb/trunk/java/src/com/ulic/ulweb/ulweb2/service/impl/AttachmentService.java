package com.ulic.ulweb.ulweb2.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ulic.ulweb.ulweb2.dao.IAttachmentDao;
import com.ulic.ulweb.ulweb2.dao.impl.AttachmentDao;
import com.ulic.ulweb.ulweb2.entity.AttachmentEntity;
import com.ulic.ulweb.ulweb2.entity.UlPolicy;
import com.ulic.ulweb.ulweb2.service.IAttachmentService;

public class AttachmentService implements IAttachmentService{

	private IAttachmentDao attachmentDao;

	public List<AttachmentEntity> listAttachmentByContentId(int contentId) throws Exception {
		String sql = "from AttachmentEntity where content.contentId = :contentId  and isDelete =0 order by attachmentOrder, attachmentId";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("contentId",contentId);
		return attachmentDao.listAttachment(sql,map);
	}

	public List<AttachmentEntity> listAttachmentByStatus(int status) throws Exception {
		String sql = "from AttachmentEntity where status = :status  and isDelete =0 ";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("status",status);
		return attachmentDao.listAttachment(sql,map);
	}

	public AttachmentEntity getAttachmentById(int attachmentId) throws Exception {
		return attachmentDao.getAttachmentById(attachmentId);
	}

	public AttachmentEntity addAttachment(AttachmentEntity ae) throws Exception {
		 return attachmentDao.addAttachement(ae);
		
	}

	public void setAttachmentDao(AttachmentDao attachmentDao) {
		this.attachmentDao = attachmentDao;
	}

	public void updateAttachment(AttachmentEntity ae) throws Exception {
		attachmentDao.update(ae);
		
	}


	public List<AttachmentEntity> listGenerate() throws Exception {
		
		String sql = "from AttachmentEntity where status = :status and needGenerate =:needGenerate  and isDelete =0";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("status",0);
		map.put("needGenerate", 1);
		return attachmentDao.listAttachment(sql,map);
	
	}

	public List<AttachmentEntity> listSecure() throws Exception {
		String sql = "from AttachmentEntity where status =:status and needSecure =:needSecure and isDelete =0";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("status",3);
		map.put("needSecure", 1);
		return attachmentDao.listAttachment(sql,map);
	}

	public void deleteAttachment(AttachmentEntity ae) throws Exception {
		ae.setIsDelete(1);
		attachmentDao.update(ae);
	}

	
	public UlPolicy getPolicyByAttachment(int attachmentId) throws Exception {
		AttachmentEntity attachmentEntity = attachmentDao.getAttachmentById(attachmentId);
		
		return attachmentEntity.getUlPolicy();
	}

	public List<AttachmentEntity> findAttachEntity(String userId, Date begin,
			Date end) throws Exception {
	
//		String sql = "from AttachmentEntity where uploadUser =:userId and updateTime >= :begin and updateTime <= :end";
		String sql = "from AttachmentEntity where uploadUser =:userId";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId", userId);
		map.put("begin", begin);
		map.put("end", end);
		return attachmentDao.listAttachment(sql,map);
	}
	
	public UlPolicy getUlPolicyById(String policyid)throws Exception{
		return attachmentDao.getUlPolicyById(policyid);
	}

	public int getOrderByContentId(int contentId) throws Exception {
		// TODO Auto-generated method stub
		return attachmentDao.getOrderByContentId(contentId);
	}

	public void updateOrder(int attachmentId, int order) throws Exception {
		 
		attachmentDao.updateOrder(attachmentId, order);
	}

}

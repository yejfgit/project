package com.ulic.ulweb.ulweb.service.impl;

import java.util.List;

import com.ulic.ulweb.frame.service.BaseService;
import com.ulic.ulweb.ulweb.dao.UlAttachmentDAO;
import com.ulic.ulweb.ulweb.dao.UlContentDAO;
import com.ulic.ulweb.ulweb.entity.UlAttachment;
import com.ulic.ulweb.ulweb.entity.UlContent;
import com.ulic.ulweb.ulweb.entity.UlDocument;
import com.ulic.ulweb.ulweb.service.IUlAttachmentService;

public class UlAttachmentServiceImpl extends BaseService implements IUlAttachmentService{
	private UlAttachmentDAO attachmentDAO;
	private UlContentDAO contentDAO;
	

	public UlAttachmentDAO getAttachmentDAO() {
		return attachmentDAO;
	}

	public void setAttachmentDAO(UlAttachmentDAO attachmentDAO) {
		this.attachmentDAO = attachmentDAO;
	}

	public void addAttachment(UlAttachment ua) throws Exception {
		attachmentDAO.create(ua);
	}
	
	public void deleteAttachment(int id) throws Exception {
		attachmentDAO.delete(id);
	}
	
	public void updateAttachment(UlAttachment ua) throws Exception {
		attachmentDAO.update(ua);
	}
	
	public UlAttachment getAttachment(int id) throws Exception {
		
		return attachmentDAO.getById(id);
	}
	

	public void updateAttachmentSum(int contentId, int attNum) throws Exception {
		// TODO Auto-generated method stub
		contentDAO.updateAttachmentSum(contentId, attNum);
	}

	public UlContentDAO getContentDAO() {
		return contentDAO;
	}

	public void setContentDAO(UlContentDAO contentDAO) {
		this.contentDAO = contentDAO;
	}

	public UlAttachment getByContentIdAndOrder(int contentId, int order) throws Exception {
		// TODO Auto-generated method stub
		return attachmentDAO.getByContentIdAndOrder(contentId, order);
	}

	public List getattachmentByContentId(int contentId) throws Exception {
		// TODO Auto-generated method stub
		return attachmentDAO.getattachmentByContentId(contentId);
	}

	public UlContent getContentById(int id) throws Exception {
		// TODO Auto-generated method stub
		return contentDAO.getById(id);
	}

	public int delete(int id, String oid) throws Exception {
		// TODO Auto-generated method stub
		return attachmentDAO.delete(id, oid);
	}

	public UlDocument getDocument(int id) throws Exception {
		// TODO Auto-generated method stub
		return contentDAO.getDocument(id);
	}

	public UlAttachment getLastAttByColumnId(int columnId) throws Exception {
		// TODO Auto-generated method stub
		return attachmentDAO.getLastAttByColumnId(columnId);
	}

	public UlContent getLastContentInColumnId(int columnId) throws Exception {
		// TODO Auto-generated method stub
		return contentDAO.getLastContentInColumnId(columnId);
	}

	public int getMaxAttachmentOrderByContentId(int contentId) throws Exception {
		// TODO Auto-generated method stub
		return attachmentDAO.getMaxAttachmentOrderByContentId(contentId);
	}

	public int getAttachmentNumByContentId(int contentId) throws Exception {
		// TODO Auto-generated method stub
		return attachmentDAO.getAttachmentNumByContentId(contentId);
	}
	
}

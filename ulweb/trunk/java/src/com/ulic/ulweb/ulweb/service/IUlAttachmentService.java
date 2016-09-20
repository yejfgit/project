package com.ulic.ulweb.ulweb.service;

import java.util.List;

import com.ulic.ulweb.frame.service.IService;
import com.ulic.ulweb.ulweb.entity.UlAttachment;
import com.ulic.ulweb.ulweb.entity.UlContent;
import com.ulic.ulweb.ulweb.entity.UlDocument;

public interface IUlAttachmentService extends IService{
	public void addAttachment(UlAttachment ua) throws Exception;
	public void deleteAttachment(int id) throws Exception;
	public void updateAttachment(UlAttachment ua) throws Exception;
	public UlAttachment getAttachment(int id) throws Exception;
	public void updateAttachmentSum(int contentId, int attNum)throws Exception;
	public UlAttachment getByContentIdAndOrder(int contentId, int order) throws Exception;
	public List getattachmentByContentId(int contentId) throws Exception;
	public UlContent getContentById(int id) throws Exception;
	public int delete(int id, String oid) throws Exception;
	public UlDocument getDocument(int id) throws  Exception;
	public UlAttachment getLastAttByColumnId(int columnId) throws Exception;	
	public UlContent getLastContentInColumnId(int columnId) throws Exception;
	public int getMaxAttachmentOrderByContentId(int contentId) throws Exception;
	public int getAttachmentNumByContentId(int contentId) throws Exception; 
	
	
}

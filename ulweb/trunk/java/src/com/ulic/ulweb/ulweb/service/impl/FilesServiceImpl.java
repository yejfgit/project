package com.ulic.ulweb.ulweb.service.impl;

import java.sql.Timestamp;
import java.util.List;

import com.ulic.ulweb.frame.service.BaseService;
import com.ulic.ulweb.ulweb.dao.FilesDAO;
import com.ulic.ulweb.ulweb.entity.Attachment;
import com.ulic.ulweb.ulweb.entity.Files;
import com.ulic.ulweb.ulweb.service.IFilesService;

public class FilesServiceImpl extends BaseService implements IFilesService {

	private FilesDAO fileDAO ;
	public List getByColumnId(int cid, int page, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		return fileDAO.getByColumnId(cid, page, pageSize);
	}

	public Files getById(int id) throws Exception {
		// TODO Auto-generated method stub
		return fileDAO.getById(id);
	}

	public Files getCandA1ById(int id) throws Exception {
		// TODO Auto-generated method stub
		return fileDAO.getCandA1ById(id);
	}

	public Attachment getByContentId(int contentId, int docno) throws Exception {
		// TODO Auto-generated method stub
		return fileDAO.getByContentId(contentId, docno);
	}

	public List getByColumnIdAndKeyword(int cid, String keyword, int page, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		return fileDAO.getByColumnIdAndKeyword(cid, keyword, page, pageSize);
	}

	public int getByColumnIdAndKeywordForPageNum(int cid, String keyword, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		return fileDAO.getByColumnIdAndKeywordForPageNum(cid, keyword, pageSize); 
	}

	public int getByColumnIdforPageSum(int cid, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		return fileDAO.getByColumnIdforPageSum(cid, pageSize);
	}

	public FilesDAO getFileDAO() {
		return fileDAO;
	}

	public void setFileDAO(FilesDAO fileDAO) {
		this.fileDAO = fileDAO;
	}

	public List getContentIdForMoveData(String condition, int pageSize, Timestamp startTime) throws Exception {
		// TODO Auto-generated method stub
		return this.fileDAO.getContentIdForMoveData(condition, pageSize, startTime);
	}

	public Attachment getAttachmentForMoveDataByContentId(int contentId, int docno) throws Exception {
		// TODO Auto-generated method stub
		return fileDAO.getAttachmentForMoveDataByContentId(contentId, docno);
	}

}

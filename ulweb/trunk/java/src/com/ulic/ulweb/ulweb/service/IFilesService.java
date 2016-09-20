package com.ulic.ulweb.ulweb.service;

import java.sql.Timestamp;
import java.util.List;

import com.ulic.ulweb.frame.service.IService;
import com.ulic.ulweb.ulweb.entity.Attachment;
import com.ulic.ulweb.ulweb.entity.Files;

public interface IFilesService extends IService{
	public List getByColumnId(int cid, int page, int pageSize) throws Exception;
	public Files getById(int id) throws Exception;
	public Files getCandA1ById(int id) throws Exception;
	public Attachment getByContentId(int contentId ,int docno) throws Exception;
	public List getByColumnIdAndKeyword(int cid, String keyword, int page, int pageSize) throws Exception;
	public int getByColumnIdAndKeywordForPageNum(int cid, String keyword, int pageSize) throws Exception;
	public int getByColumnIdforPageSum(int cid, int pageSize) throws Exception;
	public List getContentIdForMoveData(String condition, int pageSize, Timestamp startTime) throws Exception;
	public Attachment getAttachmentForMoveDataByContentId(int contentId ,int docno) throws Exception;
	
}

package com.survey.service.impl;

import java.util.List;

import com.survey.dao.impl.BaseDao;
import com.survey.service.IAttachmentService;
import com.survey.vo.Attachment;

public class AttachmentServiceImpl implements IAttachmentService {
	
	private BaseDao baseDao;

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}


	public List getAttachmentListBySurveyId(int surveyId) {
		
		String sql = "select a.id id, a.file_name fileName " +
				" from t_sv_attachment a " +
				" where a.survey_id = " + surveyId + 
				" order by a.id asc ";
		
		List attList = baseDao.getList(sql, Attachment.class);
		
		return attList;
	}


	public Attachment getAttachmentById(int attId) {

		String sql = " select a.id id, a.file_name fileName, " +
				" a.survey_id surveyId, a.file_path filePath, a.file_real_name fileRealName " +
				" from t_sv_attachment a " +
				" where a.id =  " + attId;

		Attachment a = (Attachment) baseDao.getRecord(sql, Attachment.class);

		return a;
	}

	public void saveAttachment(Attachment att) {
		att = (Attachment) baseDao.save(att);
	}


	public void delAttachment(int attId) {
		baseDao.executeUpdate("delete from t_sv_attachment where id = " + attId);
		
	}
}

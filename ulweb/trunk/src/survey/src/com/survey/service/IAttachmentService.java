package com.survey.service;

import java.util.List;

import com.survey.vo.Attachment;

public interface IAttachmentService {
	
	public List getAttachmentListBySurveyId(int surveyId);

	public Attachment getAttachmentById(int attId);

	public void saveAttachment(Attachment att);
	
	public void delAttachment(int attId);
	
}

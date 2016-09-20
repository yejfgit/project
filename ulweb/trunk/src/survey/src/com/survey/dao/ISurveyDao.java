package com.survey.dao;

import java.util.List;

import com.survey.vo.Survey;

public interface ISurveyDao {

	public List getSurveyListByUserId(int userId);
	
	public List getSurveyListByAdminUserId(int userId);
	
	public Object saveEntity(Object entity);
	
	public void updateEntity(Object entity);
	
	public Object getEntityById(Class c, int id);
	
	public List getListByProperty(String entity, String name, Object value);
	
	public List getListByProperty(String entity, String name, Object value, String orderBy);
	
	public Survey getById(int userId);
	
	public List getQuestionsBySurveyId(int surveyId);
	
	public List getAnswersById(int surveyId,int seq,String optionName,String startDate, String endDate,int deptId);

	public List getTotalAnswerById(int surveyId, String optionName, String startDate, String endDate, int deptId);

	public List getOptionScoreById(int surveyId);
	
	public Survey getSurveyById(int surveyId);

}

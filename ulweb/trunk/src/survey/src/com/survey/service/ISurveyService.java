package com.survey.service;

import java.util.List;

import com.survey.vo.Survey;

public interface ISurveyService {

	public List getSurveyListByUserId(int userId);
	
	public List getSurveyListByAdminUserId(int userId);
	
	public void saveSurveyInfo(String surveyInfo);
	
	public Survey getSurveyInfo(int surveyId);
	
	//此方法关联Misson;
	public Survey getById(int surveyId);
	
	public Survey getSurveyById(int surveyId);

	public List getQusetionsBySurveyId(int surveyId);
	
	public List getAnswersById(int surveyId,int seq,String optionName,String startDate, String endDate,int deptId);
	
	public List getTotalAnswerById(int surveyId,String optionName,String startDate, String endDate,int deptId);
	
	public List getOptionScoreById(int surveyId);
	
}

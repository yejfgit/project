package com.survey.service;

import java.util.List;

import com.survey.vo.PageVO;
import com.survey.vo.Question;
import com.survey.vo.Survey;

public interface ISurveyService {

	public List getSurveyListByUserId(int userId);
	
	public List getSurveyListByUserIdAndType(int userId,int type);
	
	public List getSurveyListByAdminUserId(int userId);
	
	public PageVO getSurveyListPvo(PageVO pvo, String surveyName,int type);
	
	public void saveSurveyInfo(String surveyInfo, String mailTips, String tips,String HurryTips,String CloseTips);
	
	public Survey getSurveyInfo(int surveyId);
	
	//此方法关联Misson;
	public Survey getById(int surveyId);
	
	public Survey getSurveyById(int surveyId);

	public List getQusetionsBySurveyId(int surveyId);
	
	public List getAnswersById(int surveyId,int seq,String optionName,String startDate, String endDate,int deptId);
	
	public List getTotalAnswerById(int surveyId,String optionName,String startDate, String endDate,int deptId);
	
	public List getOptionScoreById(int surveyId);

	public void delSurvey(int surveyId);

	public Question getQusetionsById(int questionId);

	public Survey getDraftSurveyInfo(int id, int surveyId);

	public void updateSurveyInfo(String surveyInfo, String mailTips, String tips, int surveyId,String hurryTips,String closeTips);

	public List getTextAnswersByQuestionId(int questionId);

	public PageVO getTextAnswersByQuestionId(PageVO pvo, int questionId);

	public void markTextAnswer(int id, int score);

	public void updateSurveySet(Survey s);

	public void updateSurveySet(Survey s, String tips, String mailTips, String hurryTips, String closeTips);

	public List getXZQusetionsBySurveyId(int surveyId);
	
	public Survey saveSurveyInfoAndGet(String surveyInfo, String mailTips, String tips,String HurryTips,String CloseTips);

	public PageVO getSurveyListPvo(PageVO pvo, String surveyName);
	
	public Survey updateSurveyInfoAndGet(String surveyInfo,int surveyId);
	
	public List getSendEmailList();
	
	public void updateEntity(Object entity);
	public Object saveEntity(Object entity);
}

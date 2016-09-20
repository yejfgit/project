package com.survey.service;

import java.util.List;

import com.survey.vo.Mission;
import com.survey.vo.PageVO;
import com.survey.vo.Survey;

public interface IMissionService {

	
	public Mission beginMission(int userId,int surveyId);
	
	public Mission beginMissionByMissionId(int missionId);
	
	public Mission finishMissionOfks(int missionId, String answerInfo,int leftTime);
	
	public Mission finishMissionOfdc(int missionId, String answerInfo,int leftTime);
	
	public List getUnFinished();	
	
	public Mission requestMission(int userId,int surveyId,int deptId);
	
	public Mission closeMission(int missionId);
	
	public List getUnFinishedMission();

	public void updateMission(Mission m);
	
	public Mission getMissionById(int missionId);
	
	public Mission getMissionByUserIdAndSurveyId(int UserId,int surveyId);

	public List getUnFinishedMissionBySurveyId(int surveyId);

	public List getFinishedMission(int surveyId);

	public List getUnBeginMission(int surveyId);
	
	public List getBUnFinishMission(int surveyId);

	public List getMissionBySurveyId(int surveyId);

	public List getUnFinished(String startDate, String endDate, int surveyId, int deptId);
	
	public PageVO getUnFinished(PageVO pvo,String startDate, String endDate, int surveyId, int deptId,String isClosed);

	public List getUnFinished(String startDate, String endDate, int deptId);
	
	public PageVO getUnFinished(PageVO pvo,String startDate, String endDate, int deptId,String isClosed);//分页
	
	public Mission RebeginMissionByMissionId(int missionId);

	public Mission requestMission(int i, Survey survey, int j);

	public Mission saveDraft(int missionId, String answerInfo, int leftTime);

	public List getgetMissionsBySurveyId(String startDate, String endDate, int surveyId, int deptId);

	public List getAllMissionCondition(int surveyId);
	
	public List getUserUnfinishedList(int userId);
	
	public List getMissionList(int surveyId,String empNum);
}

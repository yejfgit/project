package com.survey.service;

import java.util.List;

import com.survey.vo.Mission;

public interface IMissionService {

	
	public Mission beginMission(int userId,int surveyId);
	
	public Mission beginMissionByMissionId(int missionId);
	
	public Mission finishMission(int missionId, String answerInfo);
	
	public List getUnFinished();	
	
	public Mission requestMission(int userId,int surveyId,int deptId);
	
	public Mission closeMission(int missionId);
	
	public List getUnBeginMission();

	public void updateMission(Mission m);
	
	public Mission getMissionById(int missionId);
	
	public Mission getMissionByUserIdAndSurveyId(int UserId,int surveyId);
}

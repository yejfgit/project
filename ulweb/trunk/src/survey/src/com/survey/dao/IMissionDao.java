package com.survey.dao;

import java.util.List;

import com.survey.vo.Mission;

public interface IMissionDao {

	public List getUnFinished();
	
	public Mission getByUserId(int userId,int surveyId);
	
	public List getUnBeginMission();
	
	public Mission getMissionById(int missionId);
	
//	public Mission getMissionByUserIdAndSurveyId(int userId,int survey);

}

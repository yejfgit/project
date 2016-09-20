package com.survey.dao;

import java.util.List;

import com.survey.vo.Answer;
import com.survey.vo.Mission;
import com.survey.vo.OptionAnswer;
import com.survey.vo.PageVO;
import com.survey.vo.TextAnswer;

public interface IMissionDao {

	public List getUnFinished();
	
	public Mission getByUserId(int userId,int surveyId);
	
	public List getUnFinishedMission();
	
	public Mission getMissionById(int missionId);

	public List getUnFinishedMissionBySurveyId(int surveyId);

	public List getFinishedMission(int surveyId);

	public List getUnBeginMission(int surveyId);
	
	public List getBUnFinishMission(int surveyId);

	public List getMissionBySurveyId(int surveyId);

	public List getUnFinished(String startDate, String endDate, int surveyId, int deptId);
	
	public List getUnFinished(String startDate, String endDate, int deptId);

	public OptionAnswer getOaByAnswerId(int id);

	public List getAnswersByMissionId(int id);

	public void deleteEntity(Object obj);
	
	/**
	 * 获得主观题答案 
	 * @param id
	 * @return
	 */
	public TextAnswer getTaByAnswerId(int id);
	
//	public Mission getMissionByUserIdAndSurveyId(int userId,int survey);

}

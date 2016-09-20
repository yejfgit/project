package com.survey.service;

import java.util.List;

import com.survey.vo.Question;
import com.survey.vo.Survey;

public interface IDispatchService {

	public String dispatchSurvey(String msg,int surveyId, String path);
	
}

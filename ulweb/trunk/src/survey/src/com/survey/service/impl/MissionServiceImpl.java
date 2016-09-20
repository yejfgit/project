package com.survey.service.impl;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.survey.dao.IMissionDao;
import com.survey.dao.ISurveyDao;
import com.survey.service.IMissionService;
import com.survey.service.ISurveyService;
import com.survey.service.IUserService;
import com.survey.util.ServiceLocator;
import com.survey.vo.Answer;
import com.survey.vo.Mission;
import com.survey.vo.Option;
import com.survey.vo.OptionAnswer;
import com.survey.vo.Question;
import com.survey.vo.Survey;

public class MissionServiceImpl implements IMissionService { 

	private ISurveyDao surveyDao;
	
	private ISurveyService surveyService;
	
	private IMissionDao missionDao;
	
	private IMissionService missionService;
	

	public void setSurveyService(ISurveyService surveyService) {
		this.surveyService = surveyService;
	}
	public void setMissionService(IMissionService missionService) {
		this.missionService = missionService;
	}

	public void setSurveyDao(ISurveyDao surveyDao) {
		this.surveyDao = surveyDao;
	}
	public void setMissionDao(IMissionDao missionDao) {
		this.missionDao = missionDao;
	}

	public Mission finishMission(int missionId, String answerInfo) {
		
		Mission mission = parseAnswerInfoXml(answerInfo);
		BigDecimal scoreSum = new BigDecimal(0);
		
		// 保存答案
		Iterator iter1 = mission.getAnswerList().iterator();
		int answerCount = 0;
		while (iter1.hasNext()) {
			Answer answer = (Answer) iter1.next();
			answer.setMissionId(missionId);
			answer = (Answer) surveyDao.saveEntity(answer);
			
			// 检查该问题是否完成
			if (answer.getOptionAnswerList().size() > 0) {
				answerCount++;
			}
			
			Iterator iter2 = answer.getOptionAnswerList().iterator();
			while (iter2.hasNext()) {
				OptionAnswer oa = (OptionAnswer) iter2.next();
				oa.setAnswerId(answer.getId());
				oa = (OptionAnswer) surveyDao.saveEntity(oa);
				Option o = (Option) surveyDao.getEntityById(Option.class, oa.getOptionId());
				scoreSum = scoreSum.add(o.getScore());
			}
			
		}
		
		
		
		// 计算总分
		int total = scoreSum.intValue();
		
		// 更新Mission
		mission = (Mission) surveyDao.getEntityById(Mission.class, missionId);
		mission.setFinishTime(new Date());
		
		
		// 检查是否完成了所有的题目
		List questionList = surveyDao.getQuestionsBySurveyId(mission.getSurveyId());
		if (answerCount == questionList.size()) {
			mission.setIsClosed(2);
		} else {
			mission.setIsClosed(4);
		}
		

		mission.setTotalScore(total);
		surveyDao.updateEntity(mission);
		
		
		return mission;
		

		
	}

	
	/**
	 * 解析答案
	 * @param answerInfoXml
	 * @return
	 */
	private Mission parseAnswerInfoXml(String answerInfoXml) {
		
		Mission mission = new Mission();
		
		try {
			SAXReader sr = new SAXReader();
			Document d = sr.read(new ByteArrayInputStream(answerInfoXml.getBytes("UTF-8")));

			Element eMission = d.getRootElement();
			Iterator iter1 = eMission.elementIterator("answer");
			List answerList = new ArrayList();
			while (iter1.hasNext()) {
				Element eAnswer = (Element) iter1.next();
				int questionId = Integer.parseInt(eAnswer.elementText("question"));
				Answer answer = new Answer();
				answer.setQuestionId(questionId);
				
				Iterator iter2 = eAnswer.elementIterator("option");
				List optAnsList = new ArrayList();
				while (iter2.hasNext()) {
					Element eOption = (Element) iter2.next();
					OptionAnswer oa = new OptionAnswer();
					oa.setOptionId(Integer.parseInt(eOption.getText()));
					optAnsList.add(oa);
					
				}
				answer.setOptionAnswerList(optAnsList);
				answerList.add(answer);
			}
			mission.setAnswerList(answerList);
			
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mission;
	}

    public Mission requestMission(int userId,int surveyId,int deptId){
    	Mission m = new Mission();
    	m.setRequestTime(new Date());
    	m.setUserId(userId);
    	m.setSurveyId(surveyId);
    	m.setDeptId(deptId);
    	m.setIsClosed(0);
    	m = (Mission) surveyDao.saveEntity(m);
    	
    	return m;
    }
	
//	public Mission beginMission(int surveyId, int userId,int deptId,int missionId) {
//
//		// 创建Mission
//		Mission m = (Mission) surveyDao.getEntityById(Mission.class, missionId);
//		m.setSurveyId(surveyId);
//		m.setUserId(userId);
//		m.setDeptId(deptId);
//		m.setBeginTime(new Date());
//		m = (Mission) surveyDao.saveEntity(m);
//		
//		// 得到整个问卷
//		Survey s = surveyService.getSurveyInfo(surveyId);
//		m.setSurvey(s);
//
//		return m;
//	}
    
	public Mission beginMission(int userId,int surveyId) {

		// 创建Mission
		Mission m = (Mission) missionDao.getByUserId(userId,surveyId);
		m.setBeginTime(new Date());
		m = (Mission) surveyDao.saveEntity(m);
		// 得到整个问卷
		m.getSurveyId();
		Survey s = surveyService.getSurveyInfo(m.getSurveyId());
		m.setSurvey(s);
        m.setIsClosed(1);
		return m;
	}
	
	public Mission closeMission(int missionId){
		
		Mission mission = (Mission) surveyDao.getEntityById(Mission.class, missionId);
		mission.setIsClosed(3);
		surveyDao.updateEntity(mission);
		return mission;
		}
	
	private double computeTotal(double scoreSum) {
		
		int total = (int) scoreSum;
//		if (scoreSum > 95) {
//			total = 100;}
//		} else if (scoreSum >= 10) {
//			total = -0.2;
//		} else {
//			total = -0.4;
//		}
		return total;
		
	}
	
	
	public static void main(String[] args) {
		BigDecimal bd = new BigDecimal(0);
		BigDecimal bd1 = new BigDecimal(-0.5);
		
		bd = bd.add(bd1);
		System.out.println(bd);
		
		
	}


	public List getUnFinished() {
		return missionDao.getUnFinished();
	}
	
	public List getUnBeginMission(){
		return missionDao.getUnBeginMission();
		
	}
	
	public void updateMission(Mission m) {
		surveyDao.updateEntity(m);
	}
	public Mission getMissionById(int missionId) {
		Mission mission = (Mission) surveyDao.getEntityById(Mission.class, missionId);
		return mission;
	}

	public Mission getMissionByUserIdAndSurveyId(int userId,int surveyId){
		Mission m = (Mission) missionDao.getByUserId(userId,surveyId);
		return m;
	}
	public Mission beginMissionByMissionId(int missionId) {
		Mission m = (Mission) missionDao.getMissionById(missionId);
		m.setBeginTime(new Date());
		m = (Mission) surveyDao.saveEntity(m);
		// 得到整个问卷
		m.getSurveyId();
		Survey s = surveyService.getSurveyInfo(m.getSurveyId());
		m.setSurvey(s);
        if (m.getIsClosed() == 0 || m.getIsClosed() == 1) {
        	m.setIsClosed(1);
        	return m;
        } else {
        	return null;
        }
        
		
	}
}

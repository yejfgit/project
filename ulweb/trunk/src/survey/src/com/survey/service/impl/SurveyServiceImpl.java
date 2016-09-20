package com.survey.service.impl;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.survey.dao.ISurveyDao;
import com.survey.dao.IUserDao;
import com.survey.service.ISurveyService;
import com.survey.vo.Option;
import com.survey.vo.Question;
import com.survey.vo.Survey;

public class SurveyServiceImpl implements ISurveyService {

	private ISurveyDao surveyDao;
	
	private IUserDao userDao;

	public void setSurveyDao(ISurveyDao surveyDao) {
		this.surveyDao = surveyDao;
	}
	
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public List getSurveyListByUserId(int userId) {
		
//		List list = new ArrayList();
//		User user = userDao.getUserById(userId);
//		if(user.getRoleId()==1){
//			 list = surveyDao.getSurveyListByUserId(userId);
//		}else if(user.getRoleId()==2){
//			 list = surveyDao.getSurveyListByAdminUserId(userId);
//		}
		List list = surveyDao.getSurveyListByUserId(userId);
		return list;
	}
	
	public List getSurveyListByAdminUserId(int userId){
		
		List list = surveyDao.getSurveyListByAdminUserId(userId);
		return list;
	}
	
	

	public Survey getSurveyInfo(int surveyId) {

		Survey s = (Survey) surveyDao.getEntityById(Survey.class, surveyId);
		List queList = surveyDao.getListByProperty("Question", "surveyId", s.getId(), "seq asc");
		Iterator iter1 = queList.iterator();
		while (iter1.hasNext()) {
			Question q = (Question) iter1.next();
			List optList = surveyDao.getListByProperty("Option", "questionId", q.getId(), "seq asc");
			q.setOptionList(optList);
		}

		s.setQuestionList(queList);
		
		return s;
	}

	public void saveSurveyInfo(String surveyInfo) {
		
		Survey s = parseSurveyInfoXml(surveyInfo);
		s = (Survey) surveyDao.saveEntity(s);
		
		Iterator iter1 = s.getQuestionList().iterator();
		int queSeq = 0;
		while (iter1.hasNext()) {
			Question q = (Question) iter1.next();
			q.setSurveyId(s.getId());
			q.setSeq(++queSeq);
			q = (Question) surveyDao.saveEntity(q);
			
			Iterator iter2 = q.getOptionList().iterator();
			int optSeq = 0;
			while (iter2.hasNext()) {
				Option o = (Option) iter2.next();
				o.setQuestionId(q.getId());
				o.setSeq(++optSeq);
				o = (Option) surveyDao.saveEntity(o);
				
			}
		}
		
	}
	
	/**
	 * 解析问卷
	 * @param surveyInfoXml
	 * @return
	 */
	private static Survey parseSurveyInfoXml(String surveyInfoXml) {
		
		Survey survey = new Survey();
		
		try {
			SAXReader sr = new SAXReader();
			Document d = sr.read(new ByteArrayInputStream(surveyInfoXml.getBytes("UTF-8")));
			
			// 解析survey
			Element eSurvey = d.getRootElement();
			survey.setName(eSurvey.elementText("name"));
			survey.setOwnerId(Integer.parseInt(eSurvey.elementText("owner")));
			survey.setTimeLimit(Integer.parseInt(eSurvey.elementText("time")));
			survey.setIsShuffle(Integer.parseInt(eSurvey.elementText("shuffle")));
			
			// 遍历所有question
			Iterator iter1 = eSurvey.elements("question").iterator();
			List queList = new ArrayList();
			while (iter1.hasNext()) {
				Element eQuestion = (Element) iter1.next();
				
				Question que = new Question();
				que.setName(eQuestion.elementText("name"));
				que.setType(Integer.parseInt(eQuestion.elementText("type")));

				// 遍历所有option
				Iterator iter2 = eQuestion.elements("option").iterator();
				
				List optList = new ArrayList();
				while (iter2.hasNext()) {
					Element eOpt = (Element) iter2.next();
					Option opt = new Option();
					opt.setName(eOpt.elementText("name"));
					opt.setScore(new BigDecimal(eOpt.elementText("score")));
					optList.add(opt);
				}
				que.setOptionList(optList);
				queList.add(que);
				
			}
			survey.setQuestionList(queList);

		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
		return survey;
	}
	
	public static void main(String[] args) {
		String xml = "<survey><name>abc</name><question><name>q1</name><type>0</type><option><name>o1</name><score>5</score></option><option><name>o2</name><score>0</score></option></question><question><name>q2</name><type>1</type><option><name>o2</name><score>0</score></option></question></survey>";
		Survey sv = parseSurveyInfoXml(xml);
		
		//System.out.println(sv.getName());
		
	}
	
	public Survey getById(int surveyId){
		Survey survey =  surveyDao.getById(surveyId);
		return survey;
	}

	public List getQusetionsBySurveyId(int surveyId) {
        List qList = surveyDao.getQuestionsBySurveyId(surveyId);
		return qList;
	}

	public List getAnswersById(int surveyId, int seq, String optionName,String startDate, String endDate,int deptId) {
	     List nList = surveyDao.getAnswersById(surveyId, seq, optionName, startDate, endDate, deptId);
			return nList;
	}

	public List getTotalAnswerById(int surveyId, String optionName, String startDate, String endDate, int deptId) {
	     List tList = surveyDao.getTotalAnswerById(surveyId,optionName, startDate, endDate, deptId);
			return tList;
	}

	public List getOptionScoreById(int surveyId) {
	     List osList = surveyDao.getOptionScoreById(surveyId);
			return osList;
	}

	public Survey getSurveyById(int surveyId) {
		return this.surveyDao.getSurveyById(surveyId);
	}
	
	
}

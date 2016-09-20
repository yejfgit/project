package com.survey.service.impl;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.survey.dao.IBaseDao;
import com.survey.dao.IMissionDao;
import com.survey.dao.ISurveyDao;
import com.survey.dao.IUserDao;
import com.survey.service.ISurveyService;
import com.survey.util.ContextUtil;
import com.survey.util.StringUtil;
import com.survey.vo.Mission;
import com.survey.vo.Option;
import com.survey.vo.PageVO;
import com.survey.vo.Question;
import com.survey.vo.Survey;
import com.survey.vo.TextAnswer;


public class SurveyServiceImpl implements ISurveyService { 
 
	private ISurveyDao surveyDao;
	 
	private IMissionDao missionDao;
	
	private IUserDao userDao;
	
	private IBaseDao baseDaoImpl;
	
	public IBaseDao getBaseDaoImpl() {
		return baseDaoImpl;
	}

	public void setBaseDaoImpl(IBaseDao baseDaoImpl) {
		this.baseDaoImpl = baseDaoImpl;
	}

	public IMissionDao getMissionDao() {
		return missionDao;
	}

	public ISurveyDao getSurveyDao() {
		return surveyDao;
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setMissionDao(IMissionDao missionDao){
		this.missionDao = missionDao;
	}

	public void setSurveyDao(ISurveyDao surveyDao) {
		this.surveyDao = surveyDao;
	}
	
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public List getSurveyListByUserId(int userId) {
		
		List list = surveyDao.getSurveyListByUserId(userId);
		return list;
	}
	
	public List getSurveyListByUserIdAndType(int userId,int type)
	{
		List list = surveyDao.getSurveyListByUserIdAndType(userId,type);
		return list;
	}
	
	public List getSurveyListByAdminUserId(int userId){
		
		List list = surveyDao.getSurveyListByAdminUserId(userId);
		return list;
	}
	
	

	public Survey getSurveyInfo(int surveyId) {
		
		List missionList = missionDao.getFinishedMission(surveyId);
		
		Survey s = (Survey) surveyDao.getEntityById(Survey.class, surveyId);
		List queList = surveyDao.getListByProperty("Question", "surveyId", s.getId(), "objseq asc,seq asc");

		BigDecimal SuScore = new BigDecimal(0);
		Iterator iter1 = queList.iterator();
		
			while (iter1.hasNext()) {
				Question q = (Question) iter1.next();
				
				List optList = new ArrayList();
				if(missionList.size()>0){
					optList = surveyDao.getViewSurveyOptList(q.getId());
				}else{
					optList = surveyDao.getoptListByQuestionId(q.getId());
				}
				q.setOptionList(optList);
				SuScore = SuScore.add(q.getScore());
			}

		s.setQuestionList(queList);
		s.setSurveyScore(SuScore.intValue());
		
		return s;
	}

	public void saveSurveyInfo(String surveyInfo,String mailTips,String tips,String hurryTips,String closeTips) {
		
		Survey s = parseSurveyInfoXml(surveyInfo);
		
		s.setMailTips(mailTips);
		s.setTips(tips);
		s.setHurryTips(hurryTips);
		s.setCloseTips(closeTips);
		s.setCreateTime(new Date());
		
		s = (Survey) surveyDao.saveEntity(s);
		
		Iterator iter1 = s.getQuestionList().iterator();
		int queSeq = 0;
		int objSeq = 0;
		while (iter1.hasNext()) {
			Question q = (Question) iter1.next();
			q.setSurveyId(s.getId());
			q.setObjSeq(++objSeq);
			
			//除分割线以外题目存储题目号
			if(q.getType()!=4){
				q.setSeq(++queSeq);
			}

			if(q.getType()==2){
				q.setName(q.getName());
			}
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
			survey.setTips(eSurvey.elementText("tips"));
			survey.setMailTips(eSurvey.elementText("mailTips"));
			survey.setMinScore(Integer.parseInt(eSurvey.elementText("minScore")));
			survey.setMaxScore(Integer.parseInt(eSurvey.elementText("maxScore")));
			survey.setIsShuffle(Integer.parseInt(eSurvey.elementText("shuffle")));
			survey.setIsOpen(Integer.parseInt(eSurvey.elementText("open")));
			survey.setType(Integer.parseInt(eSurvey.elementText("type")));
			//2013-04-23 增加催办次数属性
			int hurryTimes = StringUtil.parseInt(eSurvey.elementText("hurryTimes"));
			if(hurryTimes==0){
				hurryTimes=3;
			}
			survey.setHurryTimes(hurryTimes);
			
			
			// 遍历所有question
			Iterator iter1 = eSurvey.elements("question").iterator();
			List queList = new ArrayList();
			while (iter1.hasNext()) {
				Element eQuestion = (Element) iter1.next();
				
				Question que = new Question();
				
				que.setName(eQuestion.elementText("name"));
				que.setType(Integer.parseInt(eQuestion.elementText("type")));
			
				if(survey.getType()==1){
					que.setScore(new BigDecimal(eQuestion.elementText("queScore")));
				}else{
					que.setScore(new BigDecimal(0));
					que.setMaxCheck(Integer.parseInt(eQuestion.elementText("maxCheck")));
					que.setMinCheck(Integer.parseInt(eQuestion.elementText("minCheck")));
				}

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
        List qList = surveyDao.getAllQuestionsBySurveyId(surveyId);
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

	public void delSurvey(int surveyId) {
		// TODO Auto-generated method stub
		Survey survey = surveyDao.getSurveyById(surveyId);
		
		survey.setIsDelete(1);
		surveyDao.saveEntity(survey);
	}

	public Question getQusetionsById(int questionId) {
		// TODO Auto-generated method stub
		return (Question) this.surveyDao.getEntityById(Question.class, questionId);
	}
	
	public Survey getDraftSurveyInfo(int missionId,int surveyId) {

		Survey s = (Survey) surveyDao.getEntityById(Survey.class, surveyId);
		List queList = surveyDao.getListByProperty("Question", "surveyId", s.getId(), "objseq asc,seq asc");

		Iterator iter1 = queList.iterator();
		
			while (iter1.hasNext()) {
				Question q = (Question) iter1.next();
				if(q.getType()==3){
					//获得主观题的草稿答案
					List optList = surveyDao.getTextAnswer(q.getId(),missionId);
					q.setOptionList(optList);
				}else{
					List optList = surveyDao.getOptListByQuestionIdAndMissionId(q.getId(),missionId);
					q.setOptionList(optList);
				}

			}

		s.setQuestionList(queList);
		
		return s;
	}

	public void updateSurveyInfo(String surveyInfo, String mailTips, String tips, int surveyId,String hurryTips,String closeTips) {
		// TODO Auto-generated method stub
		//删除原问卷
		Survey oldSurvey = surveyDao.getSurveyById(surveyId);
		oldSurvey.setIsDelete(1);
		surveyDao.updateEntity(oldSurvey);
		
		Survey s = parseSurveyInfoXml(surveyInfo);
		s.setMailTips(mailTips);
		s.setTips(tips);
		s.setHurryTips(hurryTips);
		s.setCloseTips(closeTips);
		s.setCreateTime(new Date());
		s = (Survey) surveyDao.saveEntity(s);
		
		Iterator iter1 = s.getQuestionList().iterator();
		int queSeq = 0;
		int objSeq = 0;
		while (iter1.hasNext()) {
			Question q = (Question) iter1.next();
			q.setSurveyId(s.getId());		
			q.setObjSeq(++objSeq);
			
			//除分割线以外题目存储题目号
			if(q.getType()!=4){
				q.setSeq(++queSeq);
			}
			
			if(q.getType()==2){
				q.setName(q.getName());
			}
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

	public List getTextAnswersByQuestionId(int questionId) {
		// TODO Auto-generated method stub
		List list = surveyDao.getTextAnswersByQuestionId(questionId);
		return list;
	}

	public PageVO getTextAnswersByQuestionId(PageVO pvo, int questionId) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("select t.id id,t.text text,u.real_name realName,o.full_name fullName,a.question_id questionId," +
				"q.name questionName,t.score score,t.is_read isRead "+
				"from t_sv_text_answer t,t_sv_answer a,t_sv_mission m,t_um_user u,t_um_organ o,t_sv_question q "+
				"where t.answer_id = a.id "+
				"and a.mission_id = m.id "+
				"and m.user_id = u.um_user_id "+
				"and u.um_organ = o.um_organ_id "+
				"and a.question_id = q.id "+
				"and a.question_id = "+questionId);
		
		String sql = sb.toString();
		pvo = baseDaoImpl.getListInPage(pvo, sql, TextAnswer.class);
		return pvo;
	}

	public void markTextAnswer(int id, int score) {
		// TODO Auto-generated method stub
		TextAnswer ta = (TextAnswer) baseDaoImpl.getById(TextAnswer.class, id);
		
		ta.setIsRead(1);
		ta.setScore(score);
		baseDaoImpl.save(ta);
	}

	public void updateSurveySet(Survey s) {
		// TODO Auto-generated method stub
		Survey oldSurvey = surveyDao.getSurveyById(s.getId());
		oldSurvey.setIsOpen(s.getIsOpen());
		oldSurvey.setCloseTips(s.getCloseTips());
		oldSurvey.setHurryTips(s.getHurryTips());
		oldSurvey.setIsShuffle(s.getIsShuffle());
		oldSurvey.setMailTips(s.getMailTips());
		oldSurvey.setMaxScore(s.getMaxScore());
		oldSurvey.setMinScore(s.getMinScore());
		oldSurvey.setTimeLimit(s.getTimeLimit());
		oldSurvey.setTips(s.getTips());
		
		surveyDao.updateEntity(oldSurvey);
	}

	public void updateSurveySet(Survey s, String tips, String mailTips, String hurryTips, String closeTips) {
		// TODO Auto-generated method stub
		Survey oldSurvey = surveyDao.getSurveyById(s.getId());
		oldSurvey.setIsOpen(s.getIsOpen());
		oldSurvey.setCloseTips(closeTips);
		oldSurvey.setIsShuffle(s.getIsShuffle());
		oldSurvey.setHurryTips(hurryTips);
		oldSurvey.setIsShuffle(s.getIsShuffle());
		oldSurvey.setMailTips(mailTips);
		oldSurvey.setMaxScore(s.getMaxScore());
		oldSurvey.setMinScore(s.getMinScore());
		oldSurvey.setTimeLimit(s.getTimeLimit());
		oldSurvey.setTips(tips);
		oldSurvey.setHurryTimes(s.getHurryTimes());
		
		surveyDao.updateEntity(oldSurvey);
	}

	public List getXZQusetionsBySurveyId(int surveyId) {
		// TODO Auto-generated method stub
        List qList = surveyDao.getQuestionsBySurveyId(surveyId);
		return qList;
	}

	public Survey saveSurveyInfoAndGet(String surveyInfo, String mailTips, String tips, String HurryTips, String CloseTips) {
			
		Survey s = parseSurveyInfoXml(surveyInfo);
		
		s.setMailTips(mailTips);
		s.setTips(tips);
		s.setHurryTips(HurryTips);
		s.setCloseTips(CloseTips);
		s.setCreateTime(new Date());
		
		s = (Survey) surveyDao.saveEntity(s);
		
		Iterator iter1 = s.getQuestionList().iterator();
		int queSeq = 0;
		int objSeq = 0;
		while (iter1.hasNext()) {
			Question q = (Question) iter1.next();
			q.setSurveyId(s.getId());
			q.setObjSeq(++objSeq);
			
			//除分割线以外题目存储题目号
			if(q.getType()!=4){
				q.setSeq(++queSeq);
			}

			if(q.getType()==2){
				q.setName(q.getName());
			}
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
		return s;
	}

	public PageVO getSurveyListPvo(PageVO pvo, String surveyName) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append( "select s.id id,s.name name,s.owner_id ownerId,s.type type,s.is_delete isDelete,nvl(a.num, 0) num,s.create_time createTime, " +
				"nvl(b.num, 0) dispatchNum, nvl(c.num, 0) finishedNum "+
				"from t_sv_survey s,"+
				"(select s.id id,count(1) num from t_sv_mission t,t_sv_survey s "+
			"where  s.id = t.survey_id " +
			"and t.isclosed in (0,1) "+
			"group  by s.id) a, "+
			
		    "(select s.id id, count(1) num "+
		    	 "from t_sv_mission t, t_sv_survey s "+
		    	 "where s.id = t.survey_id "+
		    	 "group by s.id) b, "+  
		    	        
		     "(select s.id id, count(1) num "+
		    	 "from t_sv_mission t, t_sv_survey s "+
		    	  "where s.id = t.survey_id "+
		    	  "and t.isclosed in (2) "+
		    	  "group by s.id) c "+ 
			
			"where s.id=a.id(+) "+
			"and s.id = b.id(+) "+
			"and s.id = c.id(+) "+
			"and s.is_delete = 0 " +
			"and s.owner_id = '" + ContextUtil.getCurrentUserId()+"'");
		
		if(surveyName!=null&&surveyName.length()!=0){
			sb.append(" and s.name like '%"+surveyName+"%'");
		}
		
		sb.append("order by s.id desc");
		
		String sql = sb.toString();
		
		pvo = baseDaoImpl.getListInPage(pvo, sql, Survey.class);
		return pvo;
	}
	
	public PageVO getSurveyListPvo(PageVO pvo, String surveyName,int type) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append( "select s.id id,s.name name,s.owner_id ownerId,s.type type,s.is_delete isDelete,nvl(a.num, 0) num,s.create_time createTime, " +
				"nvl(b.num, 0) dispatchNum, nvl(c.num, 0) finishedNum "+
				"from t_sv_survey s,"+
				"(select s.id id,count(1) num from t_sv_mission t,t_sv_survey s "+
			"where  s.id = t.survey_id " +
			"and t.isclosed in (0,1) "+
			"group  by s.id) a, "+
			
		    "(select s.id id, count(1) num "+
		    	 "from t_sv_mission t, t_sv_survey s "+
		    	 "where s.id = t.survey_id "+
		    	 "group by s.id) b, "+  
		    	        
		     "(select s.id id, count(1) num "+
		    	 "from t_sv_mission t, t_sv_survey s "+
		    	  "where s.id = t.survey_id "+
		    	  "and t.isclosed in (2) "+
		    	  "group by s.id) c "+ 
			
			"where s.id=a.id(+) "+
			"and s.id = b.id(+) "+
			"and s.id = c.id(+) "+
			"and s.is_delete = 0 " +
			"and s.type= " +type+
			"and s.owner_id = '" + ContextUtil.getCurrentUserId()+"'");
		
		if(surveyName!=null&&surveyName.length()!=0){
			sb.append(" and s.name like '%"+surveyName+"%'");
		}
		
		sb.append("order by s.id desc");
		
		String sql = sb.toString();
		
		pvo = baseDaoImpl.getListInPage(pvo, sql, Survey.class);
		return pvo;
	}

	public Survey updateSurveyInfoAndGet(String surveyInfo,int surveyId) {
		// TODO Auto-generated method stub
		//删除原问卷
		Survey oldSurvey = surveyDao.getSurveyById(surveyId);
		oldSurvey.setIsDelete(1);
		surveyDao.updateEntity(oldSurvey);
		
		Survey s = parseSurveyInfoXml(surveyInfo);
		
		s.setMailTips(oldSurvey.getMailTips());
		s.setTips(oldSurvey.getTips());
		s.setHurryTips(oldSurvey.getHurryTips());
		s.setCloseTips(oldSurvey.getCloseTips());
		s.setCreateTime(new Date());
		
		s = (Survey) surveyDao.saveEntity(s);
		
		Iterator iter1 = s.getQuestionList().iterator();
		int queSeq = 0;
		int objSeq = 0;
		while (iter1.hasNext()) {
			Question q = (Question) iter1.next();
			q.setSurveyId(s.getId());
			q.setObjSeq(++objSeq);
			
			//除分割线以外题目存储题目号
			if(q.getType()!=4){
				q.setSeq(++queSeq);
			}

			if(q.getType()==2){
				q.setName(q.getName());
			}
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
		return s;	
	}
	
	public List getSendEmailList() {
		// TODO Auto-generated method stub
		List list = surveyDao.getSendEmailList();
		return list;
	}
	
	public void updateEntity(Object entity) {
		surveyDao.updateEntity(entity);
	}
	public Object saveEntity(Object entity){
		return surveyDao.saveEntity(entity);
	}
}

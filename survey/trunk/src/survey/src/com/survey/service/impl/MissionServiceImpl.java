package com.survey.service.impl;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.SimpleDateFormat;
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

import com.survey.dao.IBaseDao;
import com.survey.dao.IMissionDao;
import com.survey.dao.ISurveyDao;
import com.survey.service.IMissionService;
import com.survey.service.ISurveyService;
import com.survey.service.IUserService;
import com.survey.util.ServiceLocator;
import com.survey.vo.Answer;
import com.survey.vo.Mission;
import com.survey.vo.MissionVO;
import com.survey.vo.Option;
import com.survey.vo.OptionAnswer;
import com.survey.vo.PageVO;
import com.survey.vo.Question;
import com.survey.vo.Survey;
import com.survey.vo.SurveyVO;
import com.survey.vo.TextAnswer;

public class MissionServiceImpl implements IMissionService {    

	private ISurveyDao surveyDao;
	
	private ISurveyService surveyService;
	
	private IMissionDao missionDao;
	
	private IMissionService missionService; 
	
	private IBaseDao baseDaoImpl;
	
	public IBaseDao getBaseDaoImpl() {
		return baseDaoImpl;
	}

	public void setBaseDaoImpl(IBaseDao baseDaoImpl) {
		this.baseDaoImpl = baseDaoImpl;
	}
	

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

	public Mission finishMissionOfks(int missionId, String answerInfo,int leftTime) {
		
		Mission mission = parseAnswerInfoXml(answerInfo);

		//算分不保存
		BigDecimal scoreSum = new BigDecimal(0);
		
		Iterator iter3 = mission.getAnswerList().iterator();
		int answerCount = 0;
		while (iter3.hasNext()) {
			
			Answer answer = (Answer) iter3.next();
			int questionId = answer.getQuestionId();
			Question que = (Question) surveyDao.getEntityById(Question.class, questionId);
			
			if(que.getType()!=3){
				// 检查该问题是否完成
				if (answer.getOptionAnswerList().size() > 0) {
					answerCount++;
				}
			
				//得到该题正确答案
				List rightOptionList = surveyDao.getRightOption(questionId);
			
				//得到用户答案
				List optionList = answer.getOptionAnswerList();
				
				//判断是否未答
				if(optionList.size()==0){
					break;
				}
				
				boolean contain = true;
				for(int i=0;i<optionList.size() && contain;i++){
					OptionAnswer oa = (OptionAnswer) optionList.get(i);
					int optionId = oa.getOptionId();
					boolean optionContain = false;
					for(int j=0;j<rightOptionList.size();j++){
						Option rightOption = (Option) rightOptionList.get(j);
						if(optionId==rightOption.getId()){
							optionContain = true;
							break;
						}
						
					}
					if (!optionContain) {
						contain = false;
						break;
					}
				}
				
				if(contain == true){
					if(rightOptionList.size()== optionList.size()){
						scoreSum = scoreSum.add(que.getScore());
					}else if(rightOptionList.size()> optionList.size()){
						scoreSum = scoreSum.add(que.getScore().multiply(new BigDecimal(0.5)));
					}	
				}
			}

			
	}
		
//		 计算总分
		int total = scoreSum.intValue();
		System.out.println("===================="+total+"=================");
		
		Mission m = (Mission) surveyDao.getEntityById(Mission.class, missionId);
		Survey survey = (Survey) surveyDao.getEntityById(Survey.class, m.getSurveyId());
		//判断是否未答完

//		while (iter3.hasNext()) {
//
//			Answer answer = (Answer) iter3.next();
//			// 检查该问题是否完成
//			if (answer.getOptionAnswerList().size() > 0) {
//				answerCount++;
//			}
//		}
		
		
		List questionList = surveyDao.getQuestionsBySurveyId(m.getSurveyId());

		if(m.getIsTiming()==1&&leftTime!=0){		
			// 检查是否完成了所有的题目
			if (answerCount != questionList.size()) {
					m.setErrorMsg(" 您还有未完成的题目。");
					return m;
				}

			//验证是否符合maxScore和minScore;
				if(survey.getMaxScore()>0){
					if(total<survey.getMinScore()||total>survey.getMaxScore()){
						m.setErrorMsg(" 您此次问卷的得分:"+total+"分");
						return m;
					}
				}
		}


		//判断之前是否为草稿状态
		if(m.getIsClosed()==5){
			List answerlist =  missionDao.getAnswersByMissionId(m.getId());
			for(int i=0;i<answerlist.size();i++){
				Answer answer = (Answer) answerlist.get(i);
				OptionAnswer oa = (OptionAnswer) missionDao.getOaByAnswerId(answer.getId());
				missionDao.deleteEntity(answer);
				//删除主观题草稿
				TextAnswer ta = (TextAnswer) missionDao.getTaByAnswerId(answer.getId());
				
				if(oa!=null){
					missionDao.deleteEntity(oa);
				}
				if(ta!=null){
					missionDao.deleteEntity(ta);
				}
			}
		}

		// 保存答案
		Iterator iter1 = mission.getAnswerList().iterator();

		while (iter1.hasNext()) {
			Answer answer = (Answer) iter1.next();
			answer.setMissionId(missionId);
			answer = (Answer) surveyDao.saveEntity(answer);
			
			Question que = (Question) surveyDao.getEntityById(Question.class, answer.getQuestionId());
			Iterator iter2 = answer.getOptionAnswerList().iterator();
			while (iter2.hasNext()) {
				if(que.getType()==3){
					TextAnswer ta = (TextAnswer) iter2.next();
					ta.setAnswerId(answer.getId());
					ta = (TextAnswer) surveyDao.saveEntity(ta);
				}else{
					OptionAnswer oa = (OptionAnswer) iter2.next();
					oa.setAnswerId(answer.getId());
					oa = (OptionAnswer) surveyDao.saveEntity(oa);
				}

			}
			
		}
		

		// 更新Mission
		m.setFinishTime(new Date());
		m.setIsClosed(2);
		m.setTotalScore(total);
		surveyDao.updateEntity(m);
		
		
		return m;
	
	}
	
public Mission finishMissionOfdc(int missionId, String answerInfo,int leftTime) {
		
		Mission mission = parseAnswerInfoXml(answerInfo);

		Mission m = (Mission) surveyDao.getEntityById(Mission.class, missionId);
		BigDecimal scoreSum = new BigDecimal(0);
		
		//算分不保存<start>

		Iterator iter3 = mission.getAnswerList().iterator();
		//选择题答题情况
		int answerCount = 0;
		StringBuffer errorCheck = new StringBuffer();
		
		while (iter3.hasNext()) {

			Answer answer = (Answer) iter3.next();
			
			Question que = surveyService.getQusetionsById(answer.getQuestionId());
			if(que.getType()!=3){
				
				// 检查该问题是否完成
				if (answer.getOptionAnswerList().size() > 0) {
					answerCount++;
				}
				if(que.getMaxCheck()>0||que.getMinCheck()>0){
					if(answer.getOptionAnswerList().size()>que.getMaxCheck()||answer.getOptionAnswerList().size()<que.getMinCheck()){
						errorCheck.append(que.getSeq()+"; ");
					}
				}

				Iterator iter4 = answer.getOptionAnswerList().iterator();
				while (iter4.hasNext()) {
					OptionAnswer oa = (OptionAnswer) iter4.next();
					
					oa.setAnswerId(answer.getId());
					Option o = (Option) surveyDao.getEntityById(Option.class, oa.getOptionId());
					scoreSum = scoreSum.add(o.getScore());
				}
					
			}
		
		}
		
		int total = scoreSum.intValue();
//		算分不保存<end>

	
		if(m.getIsTiming()==1&&leftTime!=0||m.getIsTiming()==0){
			if(errorCheck.length()>0){
				m.setErrorMsg(" 您此次问卷中第"+errorCheck.toString()+"题");
				return m;
			}
			
//			 检查是否完成了所有的题目
			List questionList = surveyDao.getQuestionsBySurveyId(m.getSurveyId());
			if (answerCount != questionList.size()) {
				m.setErrorMsg(" 您还有未完成的题目。");
				return m;
			}
			
			//验证是否符合maxScore和minScore;
			Survey survey = (Survey) surveyDao.getEntityById(Survey.class, m.getSurveyId());
			if(survey.getMaxScore()>0){
				if(total<survey.getMinScore()||total>survey.getMaxScore()){
					m.setErrorMsg(" 您此次问卷的得分:"+total+"分");
					return m;
				}
			}
			

		}
	
		
		//判断之前是否为草稿状态
		if(m.getIsClosed()==5){
			List answerlist =  missionDao.getAnswersByMissionId(m.getId());
			for(int i=0;i<answerlist.size();i++){
				Answer answer = (Answer) answerlist.get(i);
				OptionAnswer oa = (OptionAnswer) missionDao.getOaByAnswerId(answer.getId());
				//删除主观题草稿
				TextAnswer ta = (TextAnswer) missionDao.getTaByAnswerId(answer.getId());
				missionDao.deleteEntity(answer);
				
				if(oa!=null){
					missionDao.deleteEntity(oa);
				}
				if(ta!=null){
					missionDao.deleteEntity(ta);
				}
				
			}
		}
		
		// 保存答案
		Iterator iter1 = mission.getAnswerList().iterator();
		while (iter1.hasNext()) {
			Answer answer = (Answer) iter1.next();
			answer.setMissionId(missionId);
			answer = (Answer) surveyDao.saveEntity(answer);

			Question que = (Question) surveyDao.getEntityById(Question.class, answer.getQuestionId());
			Iterator iter2 = answer.getOptionAnswerList().iterator();
			while (iter2.hasNext()) {
				if(que.getType()==3){
					TextAnswer ta = (TextAnswer) iter2.next();
					ta.setAnswerId(answer.getId());
					ta = (TextAnswer) surveyDao.saveEntity(ta);
				}else{
					OptionAnswer oa = (OptionAnswer) iter2.next();
					oa.setAnswerId(answer.getId());
					oa = (OptionAnswer) surveyDao.saveEntity(oa);
				}

			}
			
		}

		// 更新Mission
		m.setFinishTime(new Date());
		m.setIsClosed(2);
		m.setTotalScore(total);
		surveyDao.updateEntity(m);
		
		
		return m;
		
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
				Question que = (Question) surveyDao.getEntityById(Question.class, questionId);
				
				Answer answer = new Answer();
				answer.setQuestionId(questionId);
				
				Iterator iter2 = eAnswer.elementIterator("option");
				List optAnsList = new ArrayList();
				while (iter2.hasNext()) {
					Element eOption = (Element) iter2.next();
					if(que.getType()==3){
						TextAnswer ta = new TextAnswer();
						ta.setText(eOption.getText());
						optAnsList.add(ta);
					}else{
						OptionAnswer oa = new OptionAnswer();
						oa.setOptionId(Integer.parseInt(eOption.getText()));
						optAnsList.add(oa);	
					}					
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
	
	public List getUnFinishedMission(){
		return missionDao.getUnFinishedMission();
		
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
        if (m.getIsClosed() == 0 || m.getIsClosed() == 1|| m.getIsClosed() == 5) {
        	return m;
        } else {
        	return null;
        }
        
		
	}
	public List getUnFinishedMissionBySurveyId(int surveyId) {
		// TODO Auto-generated method stub
		return missionDao.getUnFinishedMissionBySurveyId(surveyId);
	}

	public List getFinishedMission(int surveyId) {
		// TODO Auto-generated method stub
		return missionDao.getFinishedMission(surveyId);
	}
	public List getUnBeginMission(int surveyId) {
		// TODO Auto-generated method stub
		return missionDao.getUnBeginMission(surveyId);
	}
	
	public List getBUnFinishMission(int surveyId) {
		// TODO Auto-generated method stub
		return missionDao.getBUnFinishMission(surveyId);
	}
	public List getMissionBySurveyId(int surveyId) {
		// TODO Auto-generated method stub
		return missionDao.getMissionBySurveyId(surveyId);
	}
	public List getUnFinished(String startDate, String endDate, int surveyId, int deptId) {
		// TODO Auto-generated method stub
		return missionDao.getUnFinished(startDate,endDate,surveyId,deptId);
	}
	
	public PageVO getUnFinished(PageVO pvo,String startDate, String endDate, int surveyId, int deptId,String isClosed) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb
				.append("select d.full_name deptFullName,u.real_name realName,"
						+ "to_timestamp(to_char(m.request_time, 'yyyy-mm-dd hh24:mi:ss'), " +
						" 'yyyy-mm-dd hh24:mi:ss') requestTime," +
						  "to_timestamp(to_char(m.begin_time, 'yyyy-mm-dd hh24:mi:ss'), " +
						" 'yyyy-mm-dd hh24:mi:ss') beginTime," +
						  "to_timestamp(to_char(m.finish_time, 'yyyy-mm-dd hh24:mi:ss'), " +
						" 'yyyy-mm-dd hh24:mi:ss') finishTime," +
						  "m.id missionId,m.isClosed isClosed, " 
						+ "s.name surveyName "
						+ "from t_sv_survey s,t_um_user u,t_sv_mission m,t_um_organ d "
						+ "where u.um_user_id = m.user_id "
						+ "and u.um_organ = d.um_organ_id "
						+ "and s.id = m.survey_id "
						+ "and d.um_organ_id in (select a.um_organ_id from ( "
						+ "select d.um_organ_id , d.full_name , "
						+ "parent_id  "
						+ "from t_um_organ d "
						+ "connect by prior um_organ_id = parent_id start with um_organ_id in ('"
						+ deptId
						+ "')) a ) "
						+ "and m.survey_Id = '"
						+ surveyId
						+ "' "
						+" and m.isClosed in("+isClosed+")"
						+ "order by case when m.isClosed = 5 then 1 end asc, m.isclosed asc, m.id desc");
		;

		final String sql = sb.toString();
		pvo =  baseDaoImpl.getListInPage(pvo,sql,MissionVO.class);
		return pvo;
	}
	
	public List getUnFinished(String startDate, String endDate, int deptId) {
		// TODO Auto-generated method stub
		return missionDao.getUnFinished(startDate,endDate,deptId);
	}
	
	public PageVO getUnFinished(PageVO pvo,String startDate, String endDate, int deptId,String isClosed) {
		StringBuffer sb = new StringBuffer();
		sb.append("select d.full_name deptFullName,u.real_name realName,"
						+ "to_timestamp(to_char(m.request_time, 'yyyy-mm-dd hh24:mi:ss'), " +
						" 'yyyy-mm-dd hh24:mi:ss') requestTime," +
						  "to_timestamp(to_char(m.begin_time, 'yyyy-mm-dd hh24:mi:ss'), " +
						" 'yyyy-mm-dd hh24:mi:ss') beginTime," +
						  "to_timestamp(to_char(m.finish_time, 'yyyy-mm-dd hh24:mi:ss'), " +
						" 'yyyy-mm-dd hh24:mi:ss') finishTime," +
						  "m.id missionId,m.isClosed isClosed, " 
						+ "s.name surveyName "
						+ "from t_sv_survey s,t_um_user u,t_sv_mission m,t_um_organ d "
						+ "where u.um_user_id = m.user_id "
						+ "and u.um_organ = d.um_organ_id "
						+ "and s.id = m.survey_id "
						+ "and d.um_organ_id in (select a.um_organ_id from ( "
						+ "select d.um_organ_id , d.full_name , "
						+ "parent_id  "
						+ "from t_um_organ d "
						+ "connect by prior um_organ_id = parent_id start with um_organ_id in ('"
						+ deptId
						+ "')) a ) "
						+ "and m.request_time > to_date('"
						+ startDate
						+ "', 'YYYY-MM-DD') "
						+ "and m.request_time < to_date('"
						+ endDate
						+ "','YYYY-MM-DD') + 1 " 
				
						+" and m.isClosed in('"+isClosed+"')"
						+"order by case when m.isClosed = 5 then 1 end asc, m.isclosed asc, m.id desc");
		;

		final String sql = sb.toString();
		pvo =  baseDaoImpl.getListInPage(pvo,sql,MissionVO.class);
		return pvo;
	}
	
	public Mission saveDraft(int missionId, String answerInfo,int leftTime) {

		Mission mission = parseAnswerInfoXml(answerInfo);

		Mission m = (Mission) surveyDao.getEntityById(Mission.class, missionId);

		//判断之前是否为草稿状态
		if(m.getIsClosed()==5){
			List answerlist =  missionDao.getAnswersByMissionId(m.getId());
			for(int i=0;i<answerlist.size();i++){
				Answer answer = (Answer) answerlist.get(i);
				OptionAnswer oa = (OptionAnswer) missionDao.getOaByAnswerId(answer.getId());
				missionDao.deleteEntity(answer);
				if(oa!=null){
					missionDao.deleteEntity(oa);
				}
			}
		}
		
		// 保存答案
		Iterator iter1 = mission.getAnswerList().iterator();
		while (iter1.hasNext()) {
			Answer answer = (Answer) iter1.next();
			answer.setMissionId(missionId);
			answer = (Answer) surveyDao.saveEntity(answer);
			
			Question que = (Question) surveyDao.getEntityById(Question.class, answer.getQuestionId());
			Iterator iter2 = answer.getOptionAnswerList().iterator();
			while (iter2.hasNext()) {
				if(que.getType()==3){
					TextAnswer ta = (TextAnswer) iter2.next();
					ta.setAnswerId(answer.getId());
					ta = (TextAnswer) surveyDao.saveEntity(ta);
				}else{
					OptionAnswer oa = (OptionAnswer) iter2.next();
					oa.setAnswerId(answer.getId());
					oa = (OptionAnswer) surveyDao.saveEntity(oa);
				}

			}
			
		}

		// 更新Mission
		m.setFinishTime(new Date());
		m.setIsClosed(5);
		m.setTimeLimit(leftTime);
		surveyDao.updateEntity(m);
		
		
		return m;
	}
	
	public Mission RebeginMissionByMissionId(int missionId) {
		Mission m = (Mission) missionDao.getMissionById(missionId);
		m.setBeginTime(new Date());
		m = (Mission) surveyDao.saveEntity(m);
		// 得到整个问卷
		m.getSurveyId();
		Survey s = surveyService.getDraftSurveyInfo(m.getId(),m.getSurveyId());
		m.setSurvey(s);
        if (m.getIsClosed() == 0 || m.getIsClosed() == 1|| m.getIsClosed() == 5) {
        	return m;
        } else {
        	return null;
        }
        
		
	}
	public Mission requestMission(int i, Survey survey, int j) {
		// TODO Auto-generated method stub
    	Mission m = new Mission();
    	m.setRequestTime(new Date());
    	m.setUserId(i);
    	m.setSurveyId(survey.getId());
    	m.setDeptId(j);
    	m.setIsClosed(0);
    	
    	if(survey.getTimeLimit()>0){
    		m.setIsTiming(1);
    		m.setTimeLimit(survey.getTimeLimit());
    	}
    	
    	m = (Mission) surveyDao.saveEntity(m);
    	
    	return m;
	}
	public List getgetMissionsBySurveyId(String startDate, String endDate, int surveyId, int deptId) {
		// TODO Auto-generated method stub
		return null;
	}
	public List getAllMissionCondition(int surveyId) {
		// TODO Auto-generated method stub
		String sql = "select a.num unFinishNum,b.num finishNum,c.num closeNum,d.num allNum from "+
			"(select count(1) num from t_sv_mission t where t.survey_id = "+surveyId+" and t.isclosed in (0,1,5)) a, "+
			"(select count(1) num from t_sv_mission t where t.survey_id = "+surveyId+" and t.isclosed in (2) ) b, " +
			"(select count(1) num from t_sv_mission t where t.survey_id = "+surveyId+" and t.isclosed in (3) ) c, "+
			"(select count(1) num from t_sv_mission t where t.survey_id = "+surveyId+" ) d ";
		
		List list = baseDaoImpl.getList(sql, Mission.class);
		
		return list;
	}
	
	public List getUserUnfinishedList(int userId){
		String sql = " select distinct (m.survey_id) surveyId,"
				+ "  m.user_id userId," 
				+ "  m.id missionId,"
				+ "  m.request_time requestTime," 
				+ "  m.isclosed isClosed,"
				+ "  s.name surveyName," 
				+ "  u.real_name realName,"
				+ "  u.mail mail," 
				+ "  u.telephone telephone, "
				+ "  m.time_limit limitTime"
				+ "  from t_sv_mission m, t_sv_survey s, t_um_user u"
				+ "  where m.isclosed in (0, 1, 5)"
				+ "  and m.user_id = "+userId 
				+ "  and m.isclosed =(" 
				+ "  select max(m1.isclosed)"
				+ "  from t_sv_mission m1" 
				+ "  where  m1.survey_id=m.survey_id"
				+ "  and m1.user_id=m.user_id)" 
				+ "  and s.id = m.survey_id "
				+ "  and u.um_user_id = s.owner_id "
				+ "  order by m.time_limit,m.request_time desc";
        List list = baseDaoImpl.getList(sql, MissionVO.class);
		return list;
	}
	public List getMissionList(int surveyId,String empNums){
		String sql = "select m.id missionId," +
				" m.survey_id surveyId,s.name surveyName," +
				" m.user_id userId," +
				" u.employee_number employeeNumber," +
				" m.dept_id deptId " +
				" from t_sv_mission m," +
				" t_um_user u ,t_sv_survey s  " +
				" where m.survey_id = " +surveyId+
				" and u.um_user_id=m.user_id " +
				" and s.id=m.survey_id" +
				" and u.employee_number in("+empNums+")";
		List list = baseDaoImpl.getList(sql, MissionVO.class);
		return list;
	}
}

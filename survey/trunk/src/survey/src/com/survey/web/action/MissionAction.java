package com.survey.web.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;


import com.survey.service.IDeptService;
import com.survey.service.IMissionService;
import com.survey.service.ISurveyService;
import com.survey.service.IUserService;
import com.survey.util.ArrayUtil;
import com.survey.util.ConfigManager;
import com.survey.util.ServiceLocator;
import com.survey.util.StringUtil;
import com.survey.util.UlicSendMail;
import com.survey.util.UserContextUtil;
import com.survey.vo.Dept;
import com.survey.vo.DispatchUser;
import com.survey.vo.Mission;
import com.survey.vo.MissionVO;
import com.survey.vo.PageVO;
import com.survey.vo.Question;
import com.survey.vo.Survey;
import com.survey.vo.TSendEmail;
import com.survey.vo.TUmOrgan;
import com.survey.vo.TUmUser;
import com.survey.vo.User;
import com.survey.vo.UserContextVO;
import com.survey.util.ContextUtil;
import com.survey.vo.TSendEmail;

public class MissionAction extends BaseAction {


	private IMissionService ms = (IMissionService) ServiceLocator.getService("missionService");
	private IUserService us = (IUserService) ServiceLocator.getService("svUserService");
	private IDeptService ds = (IDeptService) ServiceLocator.getService("deptService");
	private ISurveyService ss = (ISurveyService) ServiceLocator.getService("surveyService");
	
	public ActionForward jump(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		int userId = Integer.parseInt(request.getParameter("userId"));
//		int surveyId = Integer.parseInt(request.getParameter("surveyId"));
		int missionId = Integer.parseInt(request.getParameter("missionId"));
		String root = ConfigManager.getString("webURL");
//		String url = root + request.getContextPath() + 
//				"/mission.do?method=answer" +
//				"&userId=" + userId +  
//				"&missionId=" + missionId;
		//System.out.println(url);
		
		String url = root + request.getContextPath() + 
		"/mission.do?method=surveyIndex" +
		"&userId=" + userId +  
		"&missionId=" + missionId;
		
		User vo = new User();
		vo.setId(userId);
		UserContextVO ucvo = new UserContextVO();
		ucvo.setUser(vo);
		UserContextUtil.initUserContext(ucvo);
		request.getSession().setAttribute(UserContextUtil.USER_CONTEXT_NAME, ucvo);
		
		response.sendRedirect(url);
		
		return null;
	}
	//未完成问卷列表
	public ActionForward getUnfinishedList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		int userId = Integer.parseInt(request.getParameter("userId"));
//		int surveyId = Integer.parseInt(request.getParameter("surveyId"));
		int missionId = Integer.parseInt(request.getParameter("missionId"));
		String root = ConfigManager.getString("webURL");
//		String url = root + request.getContextPath() + 
//				"/mission.do?method=answer" +
//				"&userId=" + userId +  
//				"&missionId=" + missionId;
		//System.out.println(url);
		
		String url = root + request.getContextPath() + 
		"/mission.do?method=surveyIndex" +
		"&userId=" + userId +  
		"&missionId=" + missionId;
		
		User vo = new User();
		vo.setId(userId);
		UserContextVO ucvo = new UserContextVO();
		ucvo.setUser(vo);
		UserContextUtil.initUserContext(ucvo);
		request.getSession().setAttribute(UserContextUtil.USER_CONTEXT_NAME, ucvo);
		
		response.sendRedirect(url);
		
		return null;
	}
	
	
	
	public ActionForward answer(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		DynaActionForm aForm = (DynaActionForm) form; 

		int currentUserId = StringUtil.parseInt(request.getParameter("userId"));
		int missionId = Integer.parseInt(request.getParameter("missionId"));
		
//		Mission mission = ms.beginMissionByMissionId(missionId);
		Mission mi = ms.getMissionById(missionId);
		Survey survey = ss.getSurveyById(mi.getSurveyId());
		
		String userName = us.getUmUserByUserId(currentUserId).getRealName();
		if(mi.getIsClosed()==2||mi.getIsClosed()==4){
//			request.setAttribute("info", "您的这份问卷已完成或已关闭。");
//			return mapping.findForward("info");
			//考试提交
			if(survey.getType()==1){
				request.setAttribute("totalScore", mi.getTotalScore());
				return mapping.findForward("submit");
			}
			//调查查看
			if(survey.getType()==2){
				request.setAttribute("survey", survey);
				return mapping.findForward("submitOfSurvey");
			}
			
		}
		
		if(mi.getIsClosed()==3){
			request.setAttribute("info", "您的这份问卷已被关闭。");
			return mapping.findForward("info");
		}
		
		
		if(mi.getIsClosed()==5){
			Mission m = ms.RebeginMissionByMissionId(missionId);
			Survey s = m.getSurvey();
			
			request.setAttribute("missionId", m.getId());
			request.setAttribute("missionType", mi.getIsClosed());
			request.setAttribute("userName",userName);
			request.setAttribute("survey", s);
		}else{
			Mission m = ms.beginMissionByMissionId(missionId);
			Survey s = m.getSurvey();
			
			
			// 加入打乱题号的功能
			if (s.getIsShuffle() == 1) {
				List queList = s.getQuestionList();
				Collections.shuffle(queList, new Random());
				s.setQuestionList(queList);
			}
			
			
			request.setAttribute("missionId", m.getId());
			request.setAttribute("missionType", m.getIsClosed());
			request.setAttribute("userName",userName);
			request.setAttribute("answerInfo", "");
			request.setAttribute("survey", s);
		}
		request.setAttribute("userId",currentUserId);
		return mapping.findForward("answer");
	}
	
	public ActionForward goBack(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int missionId = Integer.parseInt(request.getParameter("missionId"));
		int leftTime = StringUtil.parseInt(request.getParameter("leftTime"));
		String answerInfo = request.getParameter("answerInfo");
        
		  Mission mission = ms.getMissionById(missionId);
          Survey s = ss.getById(mission.getSurveyId());
			Mission m = ms.saveDraft(missionId, answerInfo,leftTime);
			request.setAttribute("missionId", missionId);
			request.setAttribute("leftTime", leftTime);
			request.setAttribute("answerInfo", answerInfo);
			request.setAttribute("info", "");
			request.setAttribute("type",2);
		return mapping.findForward("info");
	}

	public ActionForward draft(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		int missionId = Integer.parseInt(request.getParameter("missionId"));
		int leftTime = StringUtil.parseInt(request.getParameter("leftTime"));
		String answerInfo = request.getParameter("answerInfo");
        
		Mission mission = ms.getMissionById(missionId);
        Survey s = ss.getById(mission.getSurveyId());
		if(mission.getIsClosed()==2){	
			request.setAttribute("info", "您的这份问卷已完成，请勿重复提交！");
			return mapping.findForward("info");
		}else{
			Mission m = ms.saveDraft(missionId, answerInfo,leftTime);
			request.setAttribute("info", "您的这份问卷已保存为草稿！");
			request.setAttribute("missionId", missionId);
			request.setAttribute("leftTime", leftTime);
			request.setAttribute("answerInfo", answerInfo);
			request.setAttribute("type",1);
			return mapping.findForward("info");
		}
		
	}

	public ActionForward submit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int currentUserId = StringUtil.parseInt(request.getParameter("userId"));
		int missionId = Integer.parseInt(request.getParameter("missionId"));
		int leftTime = StringUtil.parseInt(request.getParameter("leftTime"));
		
		String answerInfo = request.getParameter("answerInfo");
        Mission mission = ms.getMissionById(missionId);

        Survey s = ss.getById(mission.getSurveyId());
		if(mission.getIsClosed()==2){	
			request.setAttribute("info", "您的这份问卷已完成，请勿重复提交！");
			return mapping.findForward("info");
		}else if(mission.getIsClosed()==3){
			request.setAttribute("info", "您的这份问卷已关闭，如有疑问请联系管理员！");
			return mapping.findForward("info");
		}else{
			//考试提交
			if(s.getType()==1){
				Mission m = ms.finishMissionOfks(missionId, answerInfo ,leftTime);
				
				if(m.getIsClosed()!=2){
					request.setAttribute("mission", m);
					request.setAttribute("survey", s);
					Mission mss = ms.saveDraft(missionId, answerInfo,leftTime);
					return mapping.findForward("errorResult");
				}
				
				request.setAttribute("totalScore", m.getTotalScore());
				return mapping.findForward("submit");
			}
//			调查提交
			if(s.getType()==2){
				Mission m = ms.finishMissionOfdc(missionId, answerInfo ,leftTime);
				
				if(m.getIsClosed()!=2){
					request.setAttribute("mission", m);
					request.setAttribute("survey", s);
					Mission mss = ms.saveDraft(missionId, answerInfo,leftTime);
					return mapping.findForward("errorResult");
				}
				
				request.setAttribute("survey", s);
				return mapping.findForward("submitOfSurvey");
			}	
		}
		return null;
	}
	
	public ActionForward create(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("info");
	}
 
	public ActionForward monitor(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm af = (DynaActionForm) form; 
		int surveyId = StringUtil.parseInt(request.getParameter("surveyId"));
		int deptId = 21;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date();
		String endDate = sdf.format(now);
		Date dt = now;
		dt.setYear(dt.getYear() - 1);
		String startDate = sdf.format(dt);
		
		PageVO pvo = new PageVO();
		pvo.setPageSize(10);
		int pageNum = 0;
		if (request.getParameter("pageNum") != null) {
			pageNum = StringUtil.parseInt(request.getParameter("pageNum"));
		}
		pvo.setPageNum(pageNum);
		String isClosed="0,1,2,3,5";
		if(surveyId==0){
			pvo = ms.getUnFinished(pvo, startDate, endDate, deptId,isClosed);
			request.setAttribute("pagevo", pvo);
		}else{
			pvo = ms.getUnFinished(pvo, startDate, endDate, surveyId, deptId,isClosed);
			request.setAttribute("pagevo", pvo);
		}
		
		
		/*if(surveyId==0){
			List uflist = ms.getUnFinished(startDate,endDate,deptId);
			request.setAttribute("ufList", uflist);
		}else{
			List uflist = ms.getUnFinished(startDate,endDate,surveyId,deptId);
			request.setAttribute("ufList", uflist);
		}*/
		
		Survey s = ss.getSurveyById(surveyId);
		
		//整体的完成情况
		
		List list = ms.getAllMissionCondition(surveyId);
		af.set("survey",s);
		
		request.setAttribute("surveyId", surveyId);
		request.setAttribute("surveyName", s.getName());
		request.setAttribute("startDate", startDate);
		request.setAttribute("endDate", endDate);
		request.setAttribute("missionCondition", list);
		return mapping.findForward("monitor");
	}
	
	public ActionForward queryMonitor(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm af = (DynaActionForm) form; 
		int surveyId = Integer.parseInt(request.getParameter("surveyId"));
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		int deptId =21;
		if(request.getParameter("applyDeptId") != null)
			deptId =Integer.parseInt(request.getParameter("applyDeptId"));
		String isClosed="-1";
		if(request.getParameter("isClosed") != null)
			isClosed =request.getParameter("isClosed");
		
		PageVO pvo = new PageVO();
		pvo.setPageSize(10);
		int pageNum = 0;
		if (request.getParameter("pageNum") != null) {
			pageNum = StringUtil.parseInt(request.getParameter("pageNum"));
		}
		pvo.setPageNum(pageNum);
		if(surveyId==0){
			pvo = ms.getUnFinished(pvo, startDate, endDate, deptId,isClosed);
			request.setAttribute("pagevo", pvo);
		}else{
			pvo = ms.getUnFinished(pvo, startDate, endDate, surveyId, deptId,isClosed);
			request.setAttribute("pagevo", pvo);
		}

		String deptName = ds.getDeptById(deptId).getDeptFullName();
		Survey s = ss.getSurveyById(surveyId);
		
		//整体的完成情况
		List list = ms.getAllMissionCondition(surveyId);
		af.set("survey",s);
		request.setAttribute("surveyId", surveyId);
		request.setAttribute("surveyName", s.getName());
		request.setAttribute("startDate", startDate);
		request.setAttribute("endDate", endDate);
		request.setAttribute("deptName", deptName);
		request.setAttribute("applyDeptId", deptId);
		request.setAttribute("isClosed", isClosed);
		request.setAttribute("missionCondition", list);
		return mapping.findForward("monitor");
	}

/*
 *单个关闭问卷 

	public ActionForward closeMission(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int missionId = Integer.parseInt(request.getParameter("missionId"));
		Mission mission = ms.getMissionById(missionId);
		if(mission.getIsClosed()==2){
			request.setAttribute("info", "无法关闭已完成问卷！");
			return mapping.findForward("info");
		}else{
			Mission m = ms.closeMission(missionId);
			private String body = "由于您长时间没有登陆系统进行答卷，管理员已经关闭此次问卷。谢谢您的参与！";
			private String subject = "问卷关闭通知";
			String to = us.getUmUserByUserId(m.getUserId()).getMail();
			UlicSendMail.sendMail(to, subject, body);
		}
        
		return new ActionForward("mission.do?method=monitor", true);
	}
 */	
	/*
	 * 批量催办
	 */
	public ActionForward hurry(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		//String mIds = request.getParameter("missionIds");
		String mIds = request.getParameter("missionIn");
		//int currentUserId = ContextUtil.getCurrentUserId();
		
		String isCs=request.getParameter("isCs");
	    //DispatchUser currentUser= us.getDispatchUserByUmUserId(currentUserId);
		
		//String cs = currentUser.getWorkEmail();//催办人邮箱
		
	//	String cs="niyq@ulic.com.cn";
		String[] missionIds = ArrayUtil.split(mIds, ";");
			
		for(int i=0;i<missionIds.length;i++){
			Mission m = ms.getMissionById(Integer.parseInt(missionIds[i]));
			
			String root = ConfigManager.getString("webURL")+request.getContextPath();
			String url = root + "/mission.do?method=jump" +
			"&userId=" + m.getUserId() + 
			"&missionId=" + m.getId();
			
			DispatchUser user = us.getDispatchUserByUmUserId(m.getUserId());
			
			String mail = user.getWorkEmail();
			
			Survey survey = ss.getSurveyById(m.getSurveyId());
			
			//发起人信息		
			TUmUser fqUser = us.getUmUserByUserId(survey.getOwnerId());
			TUmOrgan fqOrgan = ds.getUmOrganById(StringUtil.parseInt(fqUser.getUmOrgan()));
			String cs = fqUser.getMail();//催办人邮箱
			
			String hurryTips = survey.getHurryTips();
			
			if(hurryTips==null){
				hurryTips="";
			}
			
			String body = hurryTips +
			"<span>&nbsp;&nbsp;&nbsp;&nbsp;" +
    		"请点击：<a href=\"" + url + "\" target=_blank>开始答卷</a> ，及时完成答卷。谢谢！<br><br>"+
    		"<div>&nbsp;&nbsp;&nbsp;&nbsp;" +
    		"问卷发起人："+fqUser.getRealName()+"("+fqOrgan.getFullName()+")</div>";
			
			TSendEmail sendEmial = new TSendEmail();
			
			
			
			if(isCs!=null&&"Y".equals(isCs)){
				
				sendEmial.setSurveyId(m.getSurveyId());
				//sendEmial.setEmail("survey@ulic.com.cn");
				sendEmial.setEmail(mail);
				sendEmial.setFcd(new Date());
				sendEmial.setFcu(Integer.parseInt(fqUser.getUmUserId()));
				sendEmial.setIfCopySend(1);
				sendEmial.setCopySendEmail(cs);//抄送
				sendEmial.setIfSend(0);
				sendEmial.setMissionId(m.getId());
				sendEmial.setSendType(1);//催办
				sendEmial.setUserId(Integer.parseInt(user.getUmUserId()));
				ss.saveEntity(sendEmial);
			    //UlicSendMail.sendMail(mail, "问卷提醒：" + survey.getName(), body,cs);
			}else{
				sendEmial.setSurveyId(m.getSurveyId());
				//sendEmial.setEmail("survey@ulic.com.cn");
				sendEmial.setEmail(mail);
				sendEmial.setFcd(new Date());
				sendEmial.setFcu(Integer.parseInt(fqUser.getUmUserId()));
				sendEmial.setIfCopySend(0);
				sendEmial.setIfSend(0);
				sendEmial.setMissionId(m.getId());
				sendEmial.setSendType(1);//催办
				sendEmial.setUserId(Integer.parseInt(user.getUmUserId()));
				ss.saveEntity(sendEmial);
				//UlicSendMail.sendMail(mail, "问卷提醒：" + survey.getName(), body,"");
			}
		}

		return new ActionForward("mission.do?method=monitor", true);
	}
	
	/**
	 * 批量关闭mission
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward close(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		String mIds = request.getParameter("missionIds");
		String cs="niyq@ulic.com.cn";

		String[] missionIds = ArrayUtil.split(mIds, ";");
			
		for(int i=0;i<missionIds.length;i++){
			Mission m = ms.getMissionById(Integer.parseInt(missionIds[i]));
			
			ms.closeMission(m.getId());
			
			DispatchUser user = us.getDispatchUserByUmUserId(m.getUserId());
			
			String mail = user.getWorkEmail();
			Survey survey = ss.getSurveyById(m.getSurveyId());
			
			//发起人信息		
			TUmUser fqUser = us.getUmUserByUserId(survey.getOwnerId());
			TUmOrgan fqOrgan = ds.getUmOrganById(StringUtil.parseInt(fqUser.getUmOrgan()));
			
			String closeTips = survey.getCloseTips();
			if(closeTips==null){
				closeTips ="此次问卷已关闭";
			}
			
			String body = closeTips+"<br><br>"+
    		"<div>&nbsp;&nbsp;&nbsp;&nbsp;" +
    		"问卷发起人："+fqUser.getRealName()+"("+fqOrgan.getFullName()+")</div>";
			;
		
			UlicSendMail.sendMail(mail, "问卷提醒：" + survey.getName(), body,"");
		}

		return new ActionForward("mission.do?method=monitor", true);
	}
	
	/**
	 * 答卷页面框架框架
	 */
	public ActionForward surveyIndex(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		int currentUserId = StringUtil.parseInt(request.getParameter("userId"));
		int missionId = Integer.parseInt(request.getParameter("missionId"));
		Mission mission = ms.getMissionById(missionId);
		Survey survey = ss.getSurveyById(mission.getSurveyId());
		TUmUser user = us.getUmUserByUserId(currentUserId);
		Dept dept = ds.getDeptById(Integer.parseInt(user.getUmOrgan()));
		List<MissionVO> unfinishedList=ms.getUserUnfinishedList(currentUserId);
		
		List questionList = ss.getQusetionsBySurveyId(mission.getSurveyId());
		
		request.setAttribute("survey", survey);
		request.setAttribute("userId", currentUserId);
		request.setAttribute("missionId",missionId);
		request.setAttribute("mission", mission);
		request.setAttribute("userName", user.getRealName());
		request.setAttribute("fullName", dept.getDeptFullName());
		request.setAttribute("questionList", questionList);
		request.setAttribute("unfinishedList", unfinishedList);
		return mapping.findForward("surveyIndex");
	}
	
	public ActionForward viewCount(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// 固定user_id
//		int currentUserId = ContextUtil.getCurrentUserId();
		int surveyId = this.getIntValue(request, "surveyId");
		Survey survey = ss.getSurveyInfo(surveyId);
		int personNum = ms.getFinishedMission(surveyId).size();

		request.setAttribute("survey", survey);
		request.setAttribute("fm", personNum);
		return mapping.findForward("viewCount");
	}
	
}

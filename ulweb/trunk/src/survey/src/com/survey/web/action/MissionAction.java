package com.survey.web.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.util.LabelValueBean;


import com.survey.service.IMissionService;
import com.survey.service.ISurveyService;
import com.survey.service.IUserService;
import com.survey.util.ConfigManager;
import com.survey.util.ServiceLocator;
import com.survey.util.UlicSendMail;
import com.survey.util.UserContextUtil;
import com.survey.vo.Mission;
import com.survey.vo.Question;
import com.survey.vo.Survey;
import com.survey.vo.User;
import com.survey.vo.UserContextVO;
import com.survey.util.ContextUtil;


public class MissionAction extends BaseAction {

	private String body = "由于您长时间没有登陆系统进行答卷，管理员已经关闭此次问卷。谢谢您的参与！";
	private String subject = "问卷关闭通知";
	private  String from = "oamail@ulic.com.cn";
	private IMissionService ms = (IMissionService) ServiceLocator.getService("missionService");
	private IUserService us = (IUserService) ServiceLocator.getService("userService");
	private ISurveyService ss = (ISurveyService) ServiceLocator.getService("surveyService");
	
	public ActionForward jump(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		int userId = Integer.parseInt(request.getParameter("userId"));
//		int surveyId = Integer.parseInt(request.getParameter("surveyId"));
		int missionId = Integer.parseInt(request.getParameter("missionId"));
		String root = ConfigManager.getString("webURL");
		String url = root + request.getContextPath() + 
				"/mission.do?method=answer" +
				"&userId=" + userId + 
				"&missionId=" + missionId;
		//System.out.println(url);
		
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
//		int surveyId = Integer.parseInt(request.getParameter("surveyId"));
		int currentUserId = ContextUtil.getCurrentUserId();
		int missionId = Integer.parseInt(request.getParameter("missionId"));
		Mission mission = ms.beginMissionByMissionId(missionId);
//		Mission mission = ms.getMissionByUserIdAndSurveyId(currentUserId, surveyId);
		String userName = us.getUmUserByUserId(currentUserId).getRealName();
		if(mission==null){
			request.setAttribute("info", "您的这份问卷已完成或已关闭。");
			return mapping.findForward("info");
		}else{
//			Mission m = ms.beginMission(currentUserId,surveyId);
			Mission m = ms.beginMissionByMissionId(missionId);
			Survey s = m.getSurvey();
			
			
			// 加入打乱题号的功能
			if (s.getIsShuffle() == 1) {
				List queList = s.getQuestionList();
				Collections.shuffle(queList, new Random());
				s.setQuestionList(queList);
			}
			

			request.setAttribute("missionId", m.getId());
			request.setAttribute("userName",userName);
			request.setAttribute("survey", s);
		}
	
		return mapping.findForward("answer");
	}


	public ActionForward submit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		int missionId = Integer.parseInt(request.getParameter("missionId"));
		String answerInfo = request.getParameter("answerInfo");
        Mission mission = ms.getMissionById(missionId);
		System.out.println(answerInfo);	
		if(mission.getIsClosed()==2){	
			request.setAttribute("info", "您的这份问卷已完成，请勿重复提交！");
			return mapping.findForward("info");
		}else{
			Mission m = ms.finishMission(missionId, answerInfo);
			System.out.println(m.getTotalScore());
			request.setAttribute("totalScore", m.getTotalScore());
			return mapping.findForward("submit");
		}
	}
	
	public ActionForward create(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		return mapping.findForward("info");
	}
 
	public ActionForward monitor(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
        List uflist = ms.getUnFinished();
//		int userId = ContextUtil.getCurrentUserId();
//		List surveyList = ss.getSurveyListByAdminUserId(userId);
//		List surveyLabelList = new ArrayList();
//		for (Iterator it = surveyList.iterator(); it.hasNext();) {
//			Survey survey = (Survey) it.next();
//			int ss = survey.getId();
//			LabelValueBean typeOption = new LabelValueBean(survey.getName(),String.valueOf(survey.getId()));
//			surveyLabelList.add(typeOption);
//		}
//		request.setAttribute("surveyLabelList", surveyLabelList);	
		
		request.setAttribute("ufList", uflist);
		return mapping.findForward("monitor");
	}

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
			
			UlicSendMail sm = new UlicSendMail();
			String to = us.getUmUserByUserId(m.getUserId()).getMail();
			sm.send(to, from, subject, body);
		}
        
		return new ActionForward("mission.do?method=monitor", true);
	}
	
}

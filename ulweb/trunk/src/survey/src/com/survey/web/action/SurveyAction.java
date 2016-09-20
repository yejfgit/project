package com.survey.web.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.survey.service.ISurveyService;
import com.survey.service.IUserService;
import com.survey.util.AdminMenu;
import com.survey.util.ContextUtil;
import com.survey.util.ServiceLocator;
import com.survey.vo.Survey;
import com.survey.vo.User;



public class SurveyAction extends BaseAction {

	private ISurveyService ss = (ISurveyService) ServiceLocator.getService("surveyService");
	private IUserService us = (IUserService) ServiceLocator.getService("userService");
	
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		int currentUserId = ContextUtil.getCurrentUserId();
		request.setAttribute("ownerId", currentUserId);
		
		return mapping.findForward("add");
	}
	

	public ActionForward save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String surveyInfo = request.getParameter("surveyInfo");
		
		System.out.println(surveyInfo);
		ss.saveSurveyInfo(surveyInfo);
		
//		request.setAttribute("info", "ok");
		return new ActionForward("survey.do?method=adminList", true);
	}
	
	public ActionForward view(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		return mapping.findForward("view");
	}

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
        
		int currentUserId = ContextUtil.getCurrentUserId();
		List sList = ss.getSurveyListByUserId(currentUserId);
//		List surveyList = ss.getSurveyListByUserId(currentUserId);
//		List surveyLabelList = new ArrayList();
//		for (Iterator it = surveyList.iterator(); it.hasNext();) {
//			MissionVO survey1 = (MissionVO) it.next();
//			System.out.println(survey1);
//			int ss1 = survey1.getId();
//			LabelValueBean typeOption = new LabelValueBean(survey1.getName(),String.valueOf(survey1.getId()));
//			surveyLabelList.add(typeOption);
//		}
//		request.setAttribute("surveyLabelList", surveyLabelList);
    	request.setAttribute("sList", sList);
		return mapping.findForward("list");

	}
	
	public ActionForward adminList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
        
		int currentUserId = ContextUtil.getCurrentUserId();
		List sList = ss.getSurveyListByAdminUserId(currentUserId);
		request.setAttribute("sList", sList);
		return mapping.findForward("adminList");

	}
	
	public ActionForward edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// 固定user_id
//		int currentUserId = ContextUtil.getCurrentUserId();
		int surveyId = this.getIntValue(request, "surveyId");
		Survey survey = ss.getSurveyInfo(surveyId);
		List scoreList = ss.getOptionScoreById(surveyId);
		request.setAttribute("survey", survey);
		request.setAttribute("scoreList", scoreList);
		return mapping.findForward("view");
	}
	
	

	public ActionForward copy(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		int currentUserId = ContextUtil.getCurrentUserId();
		request.setAttribute("ownerId", currentUserId);
		
		int surveyId = this.getIntValue(request, "surveyId");
		Survey survey = ss.getSurveyInfo(surveyId);
		request.setAttribute("survey", survey);
		return mapping.findForward("copy");
	}

	
	
	
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {


    	int surveyId = this.getIntValue(request, "surveyId");
		Survey survey = ss.getById(surveyId);
		survey.setName(this.getStringValue(request, "surveyName"));


		
		request.setAttribute("info", "ok");
		return mapping.findForward("info");
	}

	/**
	 * 框架左侧
	 */
	public ActionForward left(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// goto dept left
		return mapping.findForward("left");
	}

	public ActionForward tree(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm aForm = (DynaActionForm) form;

		List<AdminMenu> list = new ArrayList<AdminMenu>();
		int currentUserId = ContextUtil.getCurrentUserId();
		User user = us.getUserById(currentUserId);
		AdminMenu menu;
		if(user!=null){
			if(user.getRoleId() == 2){
				menu = new AdminMenu("创建问卷", "../survey/survey.do?method=add");
				list.add(menu);
				menu = new AdminMenu("管理问卷", "../survey/survey.do?method=adminList");
				list.add(menu);
				menu = new AdminMenu("下发问卷", "../survey/user.do?method=index1");
				list.add(menu);
				menu = new AdminMenu("对外下发问卷", "../survey/mail.do?method=toSendMailOutside");
				list.add(menu);
				menu = new AdminMenu("监控已下发问卷", "../survey/mission.do?method=monitor");
				list.add(menu);
				menu = new AdminMenu("分数汇总表", "../survey/report.do?method=times");
				list.add(menu);
				menu = new AdminMenu("调查明细表", "../survey/report.do?method=times2");
				list.add(menu);
				menu = new AdminMenu("下发明细表", "../survey/report.do?method=requestDetail");
				list.add(menu);
				menu = new AdminMenu("修改密码", "../survey/user.do?method=toChangePassword");
				list.add(menu);
			}else if(user.getRoleId()!=2){
				menu = new AdminMenu("选择试卷", "../survey/survey.do?method=list");
				list.add(menu);	
			}
		}else{
			menu = new AdminMenu("选择试卷", "../survey/survey.do?method=list");
			list.add(menu);
		}

		aForm.set("list", list);
		return mapping.findForward("tree");
	}

}

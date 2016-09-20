package com.survey.web.action;

import java.util.ArrayList;
import java.util.List;

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
import com.survey.util.AdminMenu;
import com.survey.util.ContextUtil;
import com.survey.util.ServiceLocator;
import com.survey.util.StringUtil;
import com.survey.util.UlicSendMail;
import com.survey.vo.DispatchUser;
import com.survey.vo.MissionVO;
import com.survey.vo.PageVO;
import com.survey.vo.Question;
import com.survey.vo.Survey;
import com.survey.vo.TUmOrgan;
import com.survey.vo.TUmUser;
import com.survey.vo.User;




public class SurveyAction extends BaseAction {

	private ISurveyService ss = (ISurveyService) ServiceLocator.getService("surveyService");
	private IUserService us = (IUserService) ServiceLocator.getService("svUserService");
	private IMissionService ms = (IMissionService) ServiceLocator.getService("missionService");
	private IDeptService ds = (IDeptService) ServiceLocator.getService("deptService");
	
	public ActionForward addKs(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		int currentUserId = ContextUtil.getCurrentUserId();
		request.setAttribute("ownerId", currentUserId);
		return mapping.findForward("addKs");
	}
	
	public ActionForward addDc(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		int currentUserId = ContextUtil.getCurrentUserId();
		request.setAttribute("ownerId", currentUserId);
		return mapping.findForward("addDc");
	}
	

	public ActionForward save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String surveyInfo = request.getParameter("surveyInfo");
		int isJumpSet = StringUtil.parseInt(request.getParameter("isJumpSet"));
		int isSave = StringUtil.parseInt(request.getParameter("isSave"));
		int type = StringUtil.parseInt(request.getParameter("surveyType"));
		//添加问卷信息和邮件提示信息
		String mailTips = "各位领导、各位同事：" +
				"欢迎使用合众人寿在线问卷系统，现在有一份问卷需要您填写。";
		String hurryTips = "各位领导、各位同事：" +
				"欢迎使用合众人寿在线问卷系统，现在有一份问卷需要您填写。";
		String closeTips = "各位领导、各位同事：" +
				"由于您长时间没有登陆系统进行答卷，管理员已经关闭此次问卷。" +
				"如有疑问请联系问卷发起人。感谢您的使用，谢谢！";
		String tips = "欢迎使用合众人寿在线问卷、考试系统!";
		if(request.getParameter("tips")!=null&&!"".equals(request.getParameter("tips")))
		{
			tips = tips.replace("\n", "");
			tips = tips.replace("\r", "");
			tips = tips.replace(" ", "&nbsp");
			tips=request.getParameter("tips");
		}
		if(request.getParameter("closeTips")!=null&&!"".equals(request.getParameter("closeTips")))
		{
			closeTips = tips.replace("\n", "");
			closeTips = tips.replace("\r", "");
			closeTips = tips.replace(" ", "&nbsp");
			closeTips=request.getParameter("closeTips");
		}
			
		Survey survey = ss.saveSurveyInfoAndGet(surveyInfo,mailTips,tips,hurryTips,closeTips);
		
//		request.setAttribute("info", "ok");
		
		String url ="";
		if(isSave==1){
			url ="survey.do?method=edit&surveyId="+survey.getId();
		}else{
			
			url = "dispatch.do?method=index&surveyId="+survey.getId();
		}
		
		return new ActionForward(url, true);
	}
	
	/**
	 * 修改问卷
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {


		request.setAttribute("ownerId", ContextUtil.getCurrentUserId());
		
		int surveyId = this.getIntValue(request, "surveyId");
		Survey survey = ss.getSurveyInfo(surveyId);
		
		//修改问卷前先关闭该问卷的已下发任务
		this.closeUnFinishMission(survey);
		
		if(survey.getType()==1){
			request.setAttribute("survey", survey);
			return mapping.findForward("editOfKs");
		}else if(survey.getType()==2){
			request.setAttribute("survey", survey);
			return mapping.findForward("editOfDc");
		}
		
		return null;
	}

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
        
		int currentUserId = ContextUtil.getCurrentUserId();
		List sList = ss.getSurveyListByUserId(currentUserId);

    	request.setAttribute("sList", sList);
		return mapping.findForward("list");

	}
	//获取问卷或考试列表
	public ActionForward WJList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
        
        String surveyName = request.getParameter("surveyName");
        int type=StringUtil.parseInt(request.getParameter("type"));
		if(surveyName!=null){
			surveyName = StringUtil.decodeStr(surveyName);
			request.setAttribute("surveyName", surveyName);
		}
		
		PageVO pvo = new PageVO();
		pvo.setPageSize(10);
		int pageNum = 0;
		if (request.getParameter("pageNum") != null) {
			pageNum = StringUtil.parseInt(request.getParameter("pageNum"));
		}
		pvo.setPageNum(pageNum);
		pvo = ss.getSurveyListPvo(pvo,surveyName,type);
		
		
		request.setAttribute("pagevo", pvo);
		request.setAttribute("type",type);
//		List sList = ss.getSurveyListByAdminUserId(ContextUtil.getCurrentUserId());		
//		request.setAttribute("sList", sList);
	
		return mapping.findForward("surveyList");
	}
	
	public ActionForward adminList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
        
		
		String surveyName = request.getParameter("surveyName");
		
		
		if(surveyName!=null){
			surveyName = StringUtil.decodeStr(surveyName);
			request.setAttribute("surveyName", surveyName);
		}
		
		PageVO pvo = new PageVO();
		pvo.setPageSize(10);
		int pageNum = 0;
		if (request.getParameter("pageNum") != null) {
			pageNum = StringUtil.parseInt(request.getParameter("pageNum"));
		}
		pvo.setPageNum(pageNum);
		pvo = ss.getSurveyListPvo(pvo,surveyName);
		
		
		request.setAttribute("pagevo", pvo);
		
//		List sList = ss.getSurveyListByAdminUserId(ContextUtil.getCurrentUserId());		
//		request.setAttribute("sList", sList);
	
		return mapping.findForward("surveyList");

	}
	
	
	public ActionForward view(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// 固定user_id
//		int currentUserId = ContextUtil.getCurrentUserId();
		int surveyId = this.getIntValue(request, "surveyId");
		Survey survey = ss.getSurveyInfo(surveyId);
		
		//问卷答题情况
		List mlist = ms.getMissionBySurveyId(surveyId);
		List fmlist = ms.getFinishedMission(surveyId);
		List unBlist = ms.getUnBeginMission(surveyId);
		List bUnlist = ms.getBUnFinishMission(surveyId);
		
		List scoreList = ss.getOptionScoreById(surveyId);
		
		request.setAttribute("ml", mlist.size());
		request.setAttribute("fm", fmlist.size());
		request.setAttribute("unB", unBlist.size());
		request.setAttribute("bUn", bUnlist.size());
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
		
		if(survey.getType()==1){
			request.setAttribute("surveyId", surveyId);
			request.setAttribute("survey", survey);
			return mapping.findForward("copyOfKs");
		}else if(survey.getType()==2){
			request.setAttribute("surveyId", surveyId);
			request.setAttribute("survey", survey);
			return mapping.findForward("copyOfDc");
		}
		
		return null;
	}
	
	public ActionForward copySave(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String surveyInfo = request.getParameter("surveyInfo");
		int isJumpSet = StringUtil.parseInt(request.getParameter("isJumpSet"));
		int surveyId = StringUtil.parseInt(request.getParameter("surveyId"));
		
		Survey oldSurvey = ss.getSurveyById(surveyId);	
//		System.out.println(surveyInfo);
		Survey survey = ss.saveSurveyInfoAndGet(surveyInfo,oldSurvey.getMailTips(),
				oldSurvey.getTips(),oldSurvey.getHurryTips(),oldSurvey.getCloseTips());
		

		String url ="";
		if(isJumpSet==0){
			url = "survey.do?method=adminList";
		}else{
			url = "dispatch.do?method=index&surveyId="+survey.getId();
		}
		
		return new ActionForward(url, true);
	}
	
	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		int currentUserId = ContextUtil.getCurrentUserId();
		request.setAttribute("ownerId", currentUserId);
		
		int surveyId = this.getIntValue(request, "surveyId");
		Survey survey = ss.getSurveyInfo(surveyId);

		//删除问卷前先关闭该问卷的已下发任务
		this.closeUnFinishMission(survey);
		
		ss.delSurvey(surveyId);
		int type=StringUtil.parseInt(request.getParameter("type"));	
		return new ActionForward("survey.do?method=WJList&type="+type, true);
	}

	
	
	
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {


		String surveyInfo = request.getParameter("surveyInfo");
		int surveyId = this.getIntValue(request, "surveyId");
		//是否跳转至设置页面
		int isJumpSet = StringUtil.parseInt(request.getParameter("isJumpSet"));
			
//		ss.updateSurveyInfo(surveyInfo,mailTips,tips,surveyId,hurryTips,closeTips);
		Survey survey = ss.updateSurveyInfoAndGet(surveyInfo,surveyId);
//		添加问卷信息和邮件提示信息
		String mailTips = survey.getMailTips();
		String hurryTips = survey.getHurryTips();
		String closeTips = survey.getCloseTips();
		String tips = request.getParameter("tips");
		
		if(tips!=null){
			tips = tips.replace("\n", "");
			tips = tips.replace("\r", "");
			tips = tips.replace(" ", "&nbsp");
		}
		if(mailTips!=null){
			mailTips = mailTips.replace("\n", "");
			mailTips = mailTips.replace("\r", "");
			mailTips = mailTips.replace(" ", "&nbsp");
		}
		if(hurryTips!=null){
			hurryTips = hurryTips.replace("\n", "");
			hurryTips = hurryTips.replace("\r", "");
			hurryTips = hurryTips.replace(" ", "&nbsp");
		}
		
		if(closeTips!=null){
			closeTips = closeTips.replace("\n", "");
			closeTips = closeTips.replace("\r", "");
			closeTips = closeTips.replace(" ", "&nbsp");
		}
		
		ss.updateSurveySet(survey,tips,mailTips,hurryTips,closeTips);
		String url = ""; 
		if(isJumpSet==0){
			url =  "dispatch.do?method=index&surveyId="+survey.getId();
		}else{
			url = "survey.do?method=setSurvey&id="+survey.getId();
		}
		
		return new ActionForward(url, true);

	}
	
	private void closeUnFinishMission(Survey survey){
		
		List missionList = ms.getUnFinishedMissionBySurveyId(survey.getId());
		for(int i=0;i<missionList.size();i++){
			MissionVO m = (MissionVO) missionList.get(i);		
			ms.closeMission(m.getMissionId());
			
			DispatchUser user = us.getDispatchUserByUmUserId(m.getUserId());
			
			String mail = user.getWorkEmail();
			
			String closeTips = survey.getCloseTips();
			if(closeTips==null){
				closeTips ="此次问卷已关闭";
			}
			
			String body = closeTips;
		
			UlicSendMail.sendMail(mail, "问卷提醒：" + survey.getName(), body,"");
		}
	}
	
	
	/**
	 * 查看主观题答案
	 */
	public ActionForward viewTextAnswer(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
//		int questionId = StringUtil.parseInt(request.getParameter("questionId"));
//		List textAnswerList = ss.getTextAnswersByQuestionId(questionId);
//		Question que = ss.getQusetionsById(questionId);
//		
		
		int questionId = StringUtil.parseInt(request.getParameter("questionId"));
		Question que = ss.getQusetionsById(questionId);
		
		Survey survey = ss.getSurveyById(que.getSurveyId());
		// 分页
		PageVO pvo = new PageVO();
		pvo.setPageSize(12);
		int pageNum = 0;
		if (request.getParameter("pageNum") != null) {
			pageNum = StringUtil.parseInt(request.getParameter("pageNum"));
		}
		pvo.setPageNum(pageNum);
		pvo = ss.getTextAnswersByQuestionId(pvo, questionId);
		
		
		request.setAttribute("pagevo", pvo);
		
		
		request.setAttribute("queName", que.getName());
		request.setAttribute("queScore", que.getScore());
		request.setAttribute("questionId", questionId);
		request.setAttribute("surveyType", survey.getType());
//		request.setAttribute("textAnswerList", textAnswerList);
		return mapping.findForward("textAnswerList");
	}
	
	/**
	 * 主观题评分
	 */
	
	public ActionForward markTextAnswer(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	 		throws Exception {
		
		int id = StringUtil.parseInt(request.getParameter("id"));
		int score = StringUtil.parseInt(request.getParameter("score"));
		int questionId = StringUtil.parseInt(request.getParameter("questionId"));
		int pageNum = StringUtil.parseInt(request.getParameter("pageNum"));
		
		ss.markTextAnswer(id,score);
		
		return new ActionForward("/survey.do?method=viewTextAnswer&questionId="+questionId+"&pageNum="+pageNum);
	}
	
	/**
	 * 设置问卷
	 */
	public ActionForward setSurvey(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	 		throws Exception {
		
		DynaActionForm af = (DynaActionForm) form; 
		
		int id = StringUtil.parseInt(request.getParameter("id"));
		Survey s = ss.getSurveyById(id);
		
//		request.setAttribute(arg0, arg1);
		af.set("survey", s);
		return mapping.findForward("setSurvey");
	}
	
	/**
	 * 保存设置问卷
	 */
	public ActionForward updateSetSurvey(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	 		throws Exception {
		
		DynaActionForm af = (DynaActionForm) form; 
		Survey s = (Survey) af.get("survey");
		
		int isShuffle = StringUtil.parseInt(request.getParameter("isShuffle"));
		int isOpen = StringUtil.parseInt(request.getParameter("isOpen"));
		s.setIsShuffle(isShuffle);
		s.setIsOpen(isOpen);
		
		//添加问卷信息和邮件提示信息
		String mailTips = request.getParameter("mailTips");
		String hurryTips = request.getParameter("hurryTips");
		String closeTips = request.getParameter("closeTips");
		String tips = request.getParameter("tips");
		
		if(tips!=null){
			tips = tips.replace("\n", "");
			tips = tips.replace("\r", "");
			tips = tips.replace(" ", "&nbsp");
		}
		if(mailTips!=null){
			mailTips = mailTips.replace("\n", "");
			mailTips = mailTips.replace("\r", "");
			mailTips = mailTips.replace(" ", "&nbsp");
		}
		if(hurryTips!=null){
			hurryTips = hurryTips.replace("\n", "");
			hurryTips = hurryTips.replace("\r", "");
			hurryTips = hurryTips.replace(" ", "&nbsp");
		}
		
		if(closeTips!=null){
			closeTips = closeTips.replace("\n", "");
			closeTips = closeTips.replace("\r", "");
			closeTips = closeTips.replace(" ", "&nbsp");
		}
		
		ss.updateSurveySet(s,tips,mailTips,hurryTips,closeTips);
		
		return new ActionForward("survey.do?method=adminList", true);
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
	
	/**
	 * 框架上侧
	 */
	public ActionForward top(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// goto dept left
		int userId = ContextUtil.getCurrentUserId();
		TUmUser user = us.getUmUserByUserId(userId);
		TUmOrgan organ = ds.getUmOrganById(StringUtil.parseInt(user.getUmOrgan()));
		
		request.setAttribute("userName", user.getRealName());
		request.setAttribute("organName", organ.getFullName());
		return mapping.findForward("top");
	}
	
	/**
	 * 框架下侧
	 */
	public ActionForward bottom(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// goto dept left
		return mapping.findForward("bottom");
	}
	
	/**
	 * 框架中侧
	 */
	public ActionForward index1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// goto dept left
		return mapping.findForward("index1");
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
				menu = new AdminMenu("创建考试问卷", "../survey/survey.do?method=addKs");
				list.add(menu);
				menu = new AdminMenu("创建调查问卷", "../survey/survey.do?method=addDc");
				list.add(menu);
				menu = new AdminMenu("问卷管理", "../survey/survey.do?method=adminList");
				list.add(menu);
				menu = new AdminMenu("问卷下发", "../survey/user.do?method=index1");
				list.add(menu);
				menu = new AdminMenu("问卷下发（外部邮箱）", "../survey/mail.do?method=toSendMailOutside");
				list.add(menu);
				menu = new AdminMenu("问卷监控", "../survey/mission.do?method=monitor");
				list.add(menu);
				menu = new AdminMenu("分数汇总", "../survey/report.do?method=times");
				list.add(menu);
				menu = new AdminMenu("调查明细（运营专用）", "../survey/report.do?method=times2");
				list.add(menu);
				menu = new AdminMenu("下发明细", "../survey/report.do?method=requestDetail");
				list.add(menu);
				menu = new AdminMenu("系统介绍", "../survey/product.do?method=toIntroduce");
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

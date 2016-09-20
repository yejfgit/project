package com.survey.web.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.util.LabelValueBean;

import com.survey.service.IDeptService;
import com.survey.service.IDispatchService;
import com.survey.service.IMissionService;
import com.survey.service.ISurveyService;
import com.survey.service.IUserService;
import com.survey.util.ServiceLocator;
import com.survey.util.StringUtil;
import com.survey.vo.Dept;
import com.survey.vo.MissionVO;
import com.survey.vo.Survey;
import com.survey.vo.TUmOrgan;



public class DispatchAction extends BaseAction {

	private IDeptService deptService = (IDeptService) ServiceLocator.getService("deptService");
	private IUserService userService = (IUserService) ServiceLocator.getService("svUserService");
	private IDispatchService dispatchService = (IDispatchService) ServiceLocator.getService("dispatchService");
	private ISurveyService surveyService = (ISurveyService) ServiceLocator.getService("surveyService");
	private IMissionService ms = (IMissionService) ServiceLocator.getService("missionService");
	
	public ActionForward index(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		DynaActionForm af = (DynaActionForm) form; 
		
		int surveyId = StringUtil.parseInt(request.getParameter("surveyId"));	
//		int surveyId = 233;
		Survey survey = surveyService.getSurveyById(surveyId);
		af.set("survey", survey);
		//总分公司下拉框
		List organList = deptService.getCompany(); 
		List organLabelList = new ArrayList();
		for (Iterator it = organList.iterator(); it.hasNext();) {
			TUmOrgan organ = (TUmOrgan) it.next();
			LabelValueBean typeOption = new LabelValueBean(organ.getAbbrName(),String.valueOf(organ.getUmOrgCode()));
			organLabelList.add(typeOption);
		}

		request.setAttribute("surveyName", survey.getName());
		request.setAttribute("surveyId", surveyId);
		request.setAttribute("organLabelList", organLabelList);
		return mapping.findForward("index");

	}
	
	public ActionForward left(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		DynaActionForm aForm = (DynaActionForm) form;
//		int deptId = Integer.parseInt(ConfigManager.getParentDeptId()); 
		int deptId = 21;
//		Dept dept = deptService.getDeptById(deptId);
		TUmOrgan organ = deptService.getUmOrganById(deptId);
		
		StringBuffer placeStr = new StringBuffer();
		
		placeStr.append("[{'id':'" + organ.getUmOrganId() + "','name':'" 
		+organ.getAbbrName() + "','text':'umOrgan"+"','type':'0'},]");
		
		request.setAttribute("placeStr", placeStr.toString());
		return mapping.findForward("left");

	}
	
	public ActionForward loadChilds(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String parentId = (String)request.getParameter("id");
		
		String organStr = getNodeChildsStr(parentId);
		String childArr = "[" + organStr + "]";
		
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter(); 
		out.print(childArr);
		
		
		return null;

	}
	
	private String getNodeChildsStr(String parentId) {
		//根据机构id获得子机构列表
		List treeChilds = deptService.getUmOrganTreeChildsByParentId(parentId);
		
		StringBuffer organStr = new StringBuffer();
		for(Object o : treeChilds) {
			Dept dept = (Dept)o;
			organStr.append("{'id':'" + dept.getId()+ "','parentId':'" + dept.getParentId() + "','name':'" 
					+ dept.getDeptName() + "','text':'umOrgan','type':'0'},");
		}
		
		return organStr.toString();
	}
	
	public ActionForward middle(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		return mapping.findForward("middle");

	}
	
	public ActionForward right(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		return mapping.findForward("right");

	}
	
	public ActionForward addUsers(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		int deptId = StringUtil.parseInt(request.getParameter("deptId"));
		
//		String deptId = (String)request.getParameter("id");
		
//		List userList = deptService.getUsersByDeptId(deptId);
		List userList = deptService.getTSvUsersByDeptId(deptId);
		TUmOrgan organ = deptService.getUmOrganById(deptId);
		
		request.setAttribute("userList", userList);
		request.setAttribute("umOrgan", organ);
		return mapping.findForward("middle");

	}
	
	public ActionForward addDept(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		int deptId = StringUtil.parseInt(request.getParameter("deptId"));
		
		Dept dept = deptService.getDeptById(deptId);
		
		request.setAttribute("umOrgan", dept);
		return mapping.findForward("middle");

	}
	
	public ActionForward dispatchSurvey(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		//String msg = request.getParameter("msg");
		String msg = request.getParameter("userMsg");
		int surveyId = StringUtil.parseInt(request.getParameter("surveyId"));
//		int surveyId = 233;
		String path = request.getContextPath();
		String[] emp=msg.split(";");
		String empNums="";
		for(int i=0;i<emp.length;i++)
		{
			String[] empNum=emp[i].split(",");
			empNums+="'"+empNum[0]+"',";
		}
		empNums=empNums.substring(0,empNums.length()-1);
		 List missionList=ms.getMissionList(surveyId, empNums);
		 String[] msgArray=msg.split(";");
		if(missionList.size()!=0)
		{
			for(int j=0;j<missionList.size();j++)
			{
				MissionVO mv=(MissionVO)missionList.get(j);
				for(int z=0;z<msgArray.length;z++)
				{
					String msg1=msgArray[z];
					String msg2=msg1.substring(0,msg1.length()-2);
					if(mv.getEmployeeNumber().equals(msg2))
						msg=msg.replace(msg1+";", "");
				}
			}
		}
		
		if(msg!="" && msg.length()!=0){
			String noEmail = dispatchService.dispatchSurvey(msg, surveyId,path);
		}
		//保存下发邮件设置
		DynaActionForm af = (DynaActionForm) form; 
		Survey s = (Survey) af.get("survey");
		Survey survey = surveyService.getSurveyById(surveyId);
		int isOpen = StringUtil.parseInt(request.getParameter("isOpen"));
		int hurryTimes=StringUtil.parseInt(request.getParameter("hurryTimes"));
		//添加问卷信息和邮件提示信息
		String mailTips = request.getParameter("mailTips");
		String closeTips =request.getParameter("closeTips");
		String hurryTips = survey.getHurryTips();
		String tips = survey.getTips();
		
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
		
		survey.setIsOpen(isOpen);
		survey.setHurryTimes(hurryTimes);
		surveyService.updateSurveySet(survey,tips,mailTips,hurryTips,closeTips);
		 return mapping.findForward("done");
	}
	
	public ActionForward addUsersByPosition(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String positionName = request.getParameter("posName");
		if(positionName!=null){
			positionName = StringUtil.decodeStr(positionName);
		}
		
		int organId = StringUtil.parseInt(request.getParameter("organId"));
		
//		List userList = deptService.getUsersByDeptId(deptId);
		List userPosList = userService.getTSvUsersByPositionName((positionName),organId);

		request.setAttribute("userPosList", userPosList);
		return mapping.findForward("middle");

	}

}

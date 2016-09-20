package com.survey.web.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.util.LabelValueBean;

import com.survey.dao.ISurveyDao;
import com.survey.dao.IUserDao;
import com.survey.service.IDeptService;
import com.survey.service.ISurveyService;
import com.survey.util.ContextUtil;
import com.survey.util.ServiceLocator;
import com.survey.util.TreeUtil;
import com.survey.vo.Dept;
import com.survey.vo.Survey;
import com.survey.vo.User;



public class UserAction extends BaseAction{
	private IDeptService deptService = (IDeptService) ServiceLocator.getService("deptService");
	private ISurveyService surveyService = (ISurveyService) ServiceLocator.getService("surveyService");
	
	/**
	 * 框架
	 */
	public ActionForward index1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// goto dept index
		return mapping.findForward("index1");
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


//		List deptList = deptService.getDept();
//
//		request.setAttribute("deptList", deptList);
//		return mapping.findForward("tree");
//	}
		DynaActionForm aForm = (DynaActionForm) form;
//		TUmOrgan organ = new TUmOrgan();
		List<Dept> list = deptService.getDept();


               
		Map map = TreeUtil.getTreeByList(list, 0);
    	aForm.set("tree", map.get("tree"));
		aForm.set("list", map.get("oList"));
    	return mapping.findForward("tree");
	}
	
	public ActionForward userList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
        
    	int userId = ContextUtil.getCurrentUserId();
		int deptId = Integer.parseInt(request.getParameter("deptId"));
		System.out.println(deptId);
		List userList = deptService.getUsersByDeptId(deptId);
		Dept d = deptService.getDeptById(deptId); 
		

		 //显示問卷下来框
		List surveyList = surveyService.getSurveyListByAdminUserId(userId);
		List surveyLabelList = new ArrayList();
		for (Iterator it = surveyList.iterator(); it.hasNext();) {
			Survey survey = (Survey) it.next();
			int ss = survey.getId();
			LabelValueBean typeOption = new LabelValueBean(survey.getName(),String.valueOf(survey.getId()));
			surveyLabelList.add(typeOption);
		}
		request.setAttribute("surveyLabelList", surveyLabelList);	
		request.setAttribute("userList", userList);
		request.setAttribute("dept",d);
		return mapping.findForward("userList");
		
	}
	
	public ActionForward deptList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {


		List deptList = deptService.getDept();

		request.setAttribute("deptList", deptList);
		return mapping.findForward("deptList");
	}
	
	public ActionForward deptTreeQuery(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		DynaActionForm aForm = (DynaActionForm) form;
//		List<Dept> list = deptService.getDept();
		List<Dept> list = deptService.getDept();
//		List<Dept> list = new ArrayList();
//		
//		for(int i=0;i<listUm.size();i++){
//				Dept dept = new Dept();
//	        	if(listUm.get(i).getUmOrganId()!=null){
//	        		dept.setId(Integer.parseInt(listUm.get(i).getUmOrganId()));
//	        		dept.setDeptName(listUm.get(i).getFullName());
//	        		if(listUm.get(i).getParentId()!= null){
//	        			dept.setParentId(Integer.parseInt(listUm.get(i).getParentId()));	
//	        		}else{
//	        			dept.setParentId(1);
//	        		}
//	        		dept.setDeptLevel(listUm.get(i).getOrgLevel());
//	        		dept.setIsDisplay(1);
//	            	list.add(dept);  
//	        	}else{
//	        		System.out.println(listUm.get(i).getUmOrganId());
//			}
//			
//        
//        }

		String treeHtml = TreeUtil.getTreeDialogByList(list);
        System.out.println(treeHtml);
		aForm.set("tree", treeHtml);
		return mapping.findForward("deptTreeQuery");
	}
	
	
	public ActionForward toChangePassword(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return new ActionForward("/jsp/user/changePassword.jsp");
	}

	public ActionForward changePassword(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String p0 = request.getParameter("password0");
		String p1 = request.getParameter("password1");
		String p2 = request.getParameter("password2");
		if (p0 == null || p1 == null || p2 == null) {
			request.setAttribute("info", "请输入原密码和新密码");
			return mapping.findForward("info");
		}

		IUserDao userDao = (IUserDao) ServiceLocator.getService("userDao");
		ISurveyDao surveyDao = (ISurveyDao) ServiceLocator.getService("surveyDao");
		User u = userDao.getUserById(ContextUtil.getCurrentUserId());
		
		if (!p0.equals(u.getPassword())) {
			request.setAttribute("info", "原密码不正确，暂时无法修改密码");
			return mapping.findForward("info");
		}
		u.setPassword(p1);
		surveyDao.updateEntity(u);
		
		request.setAttribute("info", "密码已经修改");
		return mapping.findForward("info");
	}

	
}

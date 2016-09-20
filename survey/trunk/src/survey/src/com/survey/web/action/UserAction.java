package com.survey.web.action;

import java.io.PrintWriter;
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
import com.survey.service.IUserService;
import com.survey.util.ContextUtil;
import com.survey.util.ServiceLocator;
import com.survey.util.TreeUtil;
import com.survey.vo.Dept;
import com.survey.vo.Survey;
import com.survey.vo.TUmOrgan;
import com.survey.vo.User;



public class UserAction extends BaseAction{
	private IDeptService deptService = (IDeptService) ServiceLocator.getService("deptService");
	private ISurveyService surveyService = (ISurveyService) ServiceLocator.getService("surveyService");
	private IUserService userService = (IUserService) ServiceLocator.getService("svUserService");
	
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

//		DynaActionForm aForm = (DynaActionForm) form;
//		List<Dept> list = deptService.getDept();
//
//		String treeHtml = TreeUtil.getTreeDialogByList(list);
//        System.out.println(treeHtml);
//		aForm.set("tree", treeHtml);
		
		DynaActionForm aForm = (DynaActionForm) form;
//		int deptId = Integer.parseInt(ConfigManager.getParentDeptId()); 
		int deptId = 21;
//		Dept dept = deptService.getDeptById(deptId);
		TUmOrgan organ = deptService.getUmOrganById(deptId);
		
		StringBuffer placeStr = new StringBuffer();
		
		placeStr.append("[{'id':'" + organ.getUmOrganId() + "','name':'" 
		+organ.getAbbrName() + "','text':'umOrgan"+"','type':'0'},]");
		
		request.setAttribute("placeStr", placeStr.toString());
		
		return mapping.findForward("deptTreeQuery");
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
	
	/**
	 * 用户对话框
	 */
//	public ActionForward userDialog(ActionMapping mapping, ActionForm form,
//			HttpServletRequest request, HttpServletResponse response)
//			throws Exception {
//		
//		String userName = request.getParameter("userName");
//		
//		List userList = userService.getUserListByUserNameOrRealName(userName);
//		
//		request.setAttribute("userList", userList);
//		return mapping.findForward("userDialog");
//	}
	
	/**
	 * 用户对话框
	 */
	public ActionForward dispatchUserDialog(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String userName = request.getParameter("userName");
		
		List userList = userService.getDisPatchUserListByUserNameOrRealName(userName);
		
		request.setAttribute("userList", userList);
		return mapping.findForward("userDialog");
	}
	
	
	
}

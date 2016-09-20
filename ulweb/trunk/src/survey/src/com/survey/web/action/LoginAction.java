package com.survey.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.survey.service.IDeptService;
import com.survey.service.ISurveyService;
import com.survey.service.IUserService;
import com.survey.util.AdminMenu;
import com.survey.util.ContextUtil;
import com.survey.util.ServiceLocator;
import com.survey.util.UserContextUtil;
import com.survey.vo.TUmUser;
import com.survey.vo.User;
import com.survey.web.action.BaseAction;
import com.survey.dao.impl.AdminDAO;
import com.survey.vo.UserContextVO;



public class LoginAction extends BaseAction{
	private IUserService userService = (IUserService) ServiceLocator.getService("userService");
	private ISurveyService ss = (ISurveyService) ServiceLocator.getService("surveyService");
	
	public ActionForward index1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// goto dept index
		return mapping.findForward("index");
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

	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	
		String forward = "pass";
		String uName = this.getStringValue(request, "userName");		
		String pw = this.getStringValue(request, "pw");
		
//		int ipw = Integer.parseInt(pw);
		if(uName.length() == 0 || pw.length() == 0){
			request.setAttribute("errorMessage", "请填写正确的用户名和密码");
			return mapping.findForward("fail");
		}
		
		User u = userService.getByUserName(uName);
		if (u == null || !pw.equals(u.getPassword())) {
			request.setAttribute("errorMessage", "请填写正确的用户名和密码");
			return mapping.findForward("fail");
		} else {
			UserContextVO ucvo = new UserContextVO();
			ucvo.setUser(u);
			UserContextUtil.initUserContext(ucvo);
			request.getSession().setAttribute(UserContextUtil.USER_CONTEXT_NAME, ucvo);
            
			request.setAttribute("vo", u);
			
		}
		if (u.getRoleId() == 1) {
			List sList = ss.getSurveyListByUserId(u.getId());
			request.setAttribute("sList", sList);
			return mapping.findForward("answer");
		} else if (u.getRoleId() == 2) {
			return mapping.findForward("pass");
		}
		
//		
//		
//		HttpServletRequest hsrq = (HttpServletRequest) request;
////		UserContextVO userContext = (UserContextVO) hsrq.getSession()
////				.getAttribute("userContextVO");
//		
//		String str = hsrq.getRequestURI();
//		
//		AdminDAO ad = new AdminDAO();			
//		if(ad.adCheck(uName, pw) == true) {	
//			User vo = userService.getUserByUserName(uName);
//			hsrq.getSession().setAttribute("userContextVO", vo);
//			UserContextVO ucvo = new UserContextVO();
//			ucvo.setUser(vo);
//			UserContextUtil.initUserContext(ucvo);
//			request.getSession().setAttribute(UserContextUtil.USER_CONTEXT_NAME, ucvo);
//            
//			request.setAttribute("vo", vo);
//			
//			int currentUserId = vo.getId();
//			List sList = ss.getSurveyListByUserId(currentUserId);
//	    	
//     		User user = userService.getByUserName(uName);
//			if(user!=null){
//				if(user.getRoleId() == 2){
//					forward = "pass";
//				
//				}else if(user.getRoleId()!=2){
//					forward = "answer";
//					request.setAttribute("sList", sList);
//				}}
//			else{
//				forward = "answer";
//				request.setAttribute("sList", sList);
//			}
//		}else 
//			if(ad.adCheck(uName, pw) == false){
//			request.setAttribute("errorMessage", "请填写用户名和密码");
//			forward = "fail";
//		}

		return mapping.findForward(forward);
	}
}
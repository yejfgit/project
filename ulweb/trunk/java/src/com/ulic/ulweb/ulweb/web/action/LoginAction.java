package com.ulic.ulweb.ulweb.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ulic.ulweb.frame.action.BaseAction;
import com.ulic.ulweb.ulweb.dao.AdminDAO;
import com.ulic.ulweb.ulweb.entity.UlRoleClass;
import com.ulic.ulweb.ulweb.service.IUlRoleClassService;

public class LoginAction extends BaseAction{

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String forward = "pass";
		String uName = this.getStringValue(request, "userName");		
		String pw = this.getStringValue(request, "pw");
		if(uName.length() == 0 || pw.length() == 0){
			request.setAttribute("errorMessage", "请填写用户名和密码");
			return mapping.findForward("fail");
		}
		
		HttpSession session = request.getSession();
		int userClass = 0; 	
		AdminDAO ad = new AdminDAO();
		UlRoleClass r = ad.loginCheck(uName, pw);		
//		UmLog ul = new UmLog();	
//		Map mInfo = ul.log(uName, pw, Constant.systemCode);
//		String flag = (String)mInfo.get("flag");
		if(r.getLoginOk() == 1) {	
			session.setAttribute("name", r.getName());
			session.setAttribute("username", uName);
//			System.out.println("--------------pw:" + pw);
			session.setAttribute("password", pw);
			session.setAttribute("rClass", userClass);
			IUlRoleClassService rcs = (IUlRoleClassService)this.getService("roleClassService");
			UlRoleClass rc = rcs.getUlRoleClassById(r.getRoleId());
			if(rc != null){
				session.setAttribute("dept", rc.getDept());
				session.setAttribute("aClass", rc.getIsAdmin());
				if(rc.getIsAdmin() == 1){					
					session.setAttribute("uRole",  r.getRoleId());		
					session.setAttribute("columnId", rc.getColumnId());
				}
			}else{
				request.setAttribute("errorMessage", "您的用户没有任何权限");
				forward = "fail";
			}
			
/*			
			
			rcs.getUserRightColumn(r.getRoleId());
			UserInformation user = (UserInformation)mInfo.get("userInfo");	
			List listR = (List)mInfo.get("roleList");	
			String roleList = CheckUserRight.getStrRoleid(listR);		
			userClass = rcs.getUserRoleMaxClass(roleList);			
			session.setAttribute("name", r.getName());
			session.setAttribute("rClass", userClass);
			session.setAttribute("dept", user.getOrganizationId());			
			ul.setSessionTrace((List)mInfo.get("roleList"),user.getUserId(),Constant.systemCode,request.getRemoteAddr(),session);
			int userAdminClass = rcs.getUserAdminClass(roleList);		
			int userAdminClass = 9;
		if(userAdminClass != 0) {
				if(userAdminClass != 1) {
					session.setAttribute("aClass", userAdminClass);				
					session.setAttribute("adminId", rcs.getUserAdminId(roleList));
					session.setAttribute("aClass", userAdminClass);
				}else{
					session.setAttribute("uRole", roleList);
					session.setAttribute("aClass", userAdminClass);	
				}				
			}else{
				session.setAttribute("aClass", 0);
			}
			
*/
		}else if(r.getLoginOk() == 2){
			request.setAttribute("errorMessage", "您输入的密码不正确");
			forward = "fail";
		}else {
			request.setAttribute("errorMessage", "没有此用户");
			forward = "fail";
		}
		return mapping.findForward(forward);
	}
}

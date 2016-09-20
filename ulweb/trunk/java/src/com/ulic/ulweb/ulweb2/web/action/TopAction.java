package com.ulic.ulweb.ulweb2.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts.actions.DispatchAction;

import com.ulic.ulweb.frame.service.IService;
import com.ulic.ulweb.frame.service.ServiceLocator;

public class TopAction extends DispatchAction {
	 
	protected final int ADMIN_TOP = 9;
	
	protected final int ADMIN_DEPT = 2;
	
	protected final int ADMIN_COL = 1;
	
	protected final int ADMIN_LOGIN = 0;

	protected IService getService(String serviceName) {
		return ServiceLocator.getService(serviceName);
	}

	protected int getIntValue(HttpServletRequest req, String str) {
		try {
			return Integer.parseInt(req.getParameter(str));
		} catch (Exception e) {
			return 0;
		}
	}
	
	protected String getStringValue(HttpServletRequest req, String key){
		return getStringValue(req,key,"");
	}
	
	protected String getStringValue(HttpServletRequest req, String key, String s) {
		String temp = req.getParameter(key);
		if ((temp == null) || (temp.trim().length() == 0)) {
			return s;
		}
		return temp.trim();
	}
	
	/**
	 * 检查当前用户的权限
	 * @param req
	 * @return
	 */
	protected int checkUser(HttpServletRequest request) {
		HttpSession session = request.getSession();
		try {
			if (session.getAttribute("aClass") == null) {
				request.setAttribute("errorMessage", "只有登录后才有权限");
				return -1;
			} else if ((Integer) session.getAttribute("aClass") == 9) {
				
				return 9;
			} else if ((Integer) session.getAttribute("aClass") == 2) {
				
				return 2;
			} else if ((Integer) session.getAttribute("aClass") == 1) {
				
				return 1;
			} else if ((Integer) session.getAttribute("aClass") == 0) {
				request.setAttribute("errorMessage", "只有管理员才有权限");
				return 0;
			} else if (session.getAttribute("name") == null
					|| session.getAttribute("name") == "未登录") {
				
				return -1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			return -1;
		}
	}
	
	protected boolean checkRight(HttpServletRequest request, int aClass) {
		if (this.checkUser(request) >= aClass) {
			return true;
		} else {
			if (aClass == this.ADMIN_TOP) {
				request.setAttribute("errorMessage", "只有主页管理员才有权限");
			} else if (aClass == this.ADMIN_DEPT) {
				request.setAttribute("errorMessage", "只有部门管理员才有权限");
			} else if (aClass == this.ADMIN_COL) {
				request.setAttribute("errorMessage", "只有栏目管理员才有权限");
			} else if (aClass == this.ADMIN_LOGIN) {
				request.setAttribute("errorMessage", "只有登录后才有权限");
			}
			return false;
		}
	}
	
}

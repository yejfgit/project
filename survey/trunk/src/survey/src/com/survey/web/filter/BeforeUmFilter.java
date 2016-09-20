package com.survey.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.survey.service.IDeptService;
import com.survey.service.IUserService;
import com.survey.util.ServiceLocator;
import com.survey.util.StringUtil;
import com.survey.util.UserContextUtil;
import com.survey.vo.TUmUser;
import com.survey.vo.User;
import com.survey.vo.UserContextVO;
import com.ulic.um.client.UMContext;

public class BeforeUmFilter implements Filter {

	public void init(FilterConfig fc) throws ServletException {

	}	
	
	private IUserService userSvc;
	private IDeptService deptSvc;
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
//		userSvc = (IUserService) ServiceLocator.getService("svUserService");
//		deptSvc = (IDeptService) ServiceLocator.getService("deptService");
//		
//		HttpServletRequest hsrq = (HttpServletRequest) request; 
//		String url = hsrq.getServletPath();
//		String userId = request.getParameter("userId");
//		String white = "/mission.do";
//		System.out.println(url.equals(white));
//		
//		if(url.equals(white)){
//			System.out.println("================================================");
//			if (request instanceof HttpServletRequest) {
//				HttpServletRequest hsrq1 = (HttpServletRequest) request;
//				UserContextVO userContext = (UserContextVO) hsrq1.getSession()
//						.getAttribute(UserContextUtil.USER_CONTEXT_NAME);
//				
//				//System.out.println("==============================" + hsrq.getRequestURI());
//				
//				// 未登录的
//				if (userContext == null) {			
//					TUmUser umUser = userSvc.getUmUserByUserId(StringUtil.parseInt(userId));
//					userContext = new UserContextVO();
//					
//					User u = new User();
//					u.setId(StringUtil.parseInt(userId));
//					u.setUserName(umUser.getUserName());
//					u.setDeptId(StringUtil.parseInt(umUser.getUmOrgan()));
//					
//					userContext.setUser(u);
//					userContext = userSvc.login(userContext.getUser().getUserName(), hsrq.getRemoteAddr());
//					hsrq1.getSession().setAttribute(UserContextUtil.USER_CONTEXT_NAME, userContext);
//
//				}
//				
//
//				UserContextUtil.initUserContext(userContext);
//				chain.doFilter(request, response);
//				
//				
//				UserContextUtil.destoryUserContext();
//			}
//		}else{
//			chain.doFilter(request, response);
//		}
		chain.doFilter(request, response);
	}
	


	public void destroy() {

	}

}

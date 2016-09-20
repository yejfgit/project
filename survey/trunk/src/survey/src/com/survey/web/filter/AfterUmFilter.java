package com.survey.web.filter;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import com.survey.vo.TUmOrgan;
import com.survey.vo.TUmUser;
import com.survey.vo.User;
import com.survey.vo.UserContextVO;
import com.ulic.um.client.UMContext;




public class AfterUmFilter implements Filter {

	private IUserService userSvc;
	private IDeptService deptSvc;
	
	public void init(FilterConfig fc) throws ServletException {

	}	

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		userSvc = (IUserService) ServiceLocator.getService("svUserService");
		deptSvc = (IDeptService) ServiceLocator.getService("deptService");
		/**
		 * 将vo放入当前进程中，判断是否有权进入这个系统
		 */
		if (request instanceof HttpServletRequest) {
			HttpServletRequest hsrq = (HttpServletRequest) request;
			UserContextVO userContext = (UserContextVO) hsrq.getSession()
					.getAttribute(UserContextUtil.USER_CONTEXT_NAME);
			
			//System.out.println("==============================" + hsrq.getRequestURI());
			
			// 未登录的
			if (userContext == null) {
				
				userContext = createContextUser(userContext);
				userContext = userSvc.login(userContext.getUser().getUserName(), hsrq.getRemoteAddr());
				// 把用户上下文放入会话中
				hsrq.getSession().setAttribute(UserContextUtil.USER_CONTEXT_NAME, userContext);

			}
			

			UserContextUtil.initUserContext(userContext);
			chain.doFilter(request, response);
			
			// 记录用户请求审计日志
			audit(hsrq);
			
			UserContextUtil.destoryUserContext();
		}
		
	}
	
	
	
	private void audit(HttpServletRequest hsrq) {

//		String url = hsrq.getRequestURI().substring(
//				hsrq.getContextPath().length() + 1, hsrq.getRequestURI().length()) + 
//				(hsrq.getQueryString() == null ? "" : "?" + hsrq.getQueryString());
		
		String url = hsrq.getRequestURI().substring(
				hsrq.getContextPath().length() + 1, hsrq.getRequestURI().length()) + 
				listMap(hsrq.getParameterMap());
		//System.out.println(url);
//		userSvc.saveAudit(url);
		
	}

	
	private String listMap(Map map) {
		StringBuffer sb = new StringBuffer();
		Set s = map.keySet();
		Iterator iter = s.iterator();
		if (s.size() > 0) {
			sb.append("?");
		}
		int i = 0;
		while (iter.hasNext()) {
			String k = (String) iter.next();
			String[] v = (String[]) map.get(k);
			if (i > 0) {
				sb.append("&");
			}
			sb.append("" + k + "=" + v[0]);
			i++;
		}
		return sb.toString();
	}
	
	
	/**
	 * 构造用户上下文信息
	 * @param userContext
	 */
	private UserContextVO createContextUser(UserContextVO userContext) {


		userContext = new UserContextVO();

		// 从um中获得认证后的用户
		com.ulic.um.client.UMUser umUser = UMContext.getCurrentUser();
		//log.info(umUser.getUsername());

		// 构造当前用户信息
		User u = new User();
		u.setId(StringUtil.parseInt(umUser.getUlicUMUserID()));
		//u.setDeptId(StringUtil.parseInt(umUser.getOrgan().getUlicUMOrganID()));
		u.setDeptId(StringUtil.parseInt("21"));
		u.setUserName(umUser.getUsername());
		u.setRealName(umUser.getCommonName());
	
		userContext.setUser(u);
			
		return userContext;
	}

	

	public void destroy() {

	}

}

package com.survey.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.survey.util.ContextUtil;
import com.survey.util.UserContextUtil;
import com.survey.vo.UserContextVO;

public class SecurityFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest hsrq = (HttpServletRequest) request;
		UserContextVO ucvo = (UserContextVO) hsrq.getSession().getAttribute(UserContextUtil.USER_CONTEXT_NAME);
		
		String url = hsrq.getRequestURI().substring(hsrq.getContextPath().length())
			 + (hsrq.getQueryString() == null ? "" : "?" + hsrq.getQueryString());
		//System.out.println(url);
		
		if (ucvo == null && url.indexOf("login.do") == -1 && url.indexOf(".jpg") == -1 && url.indexOf("jump") == -1) {
			request.setAttribute("toUrl", url);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}


		UserContextUtil.initUserContext(ucvo);
		if(ucvo!=null && ucvo.getUser().getId()!=ContextUtil.getCurrentUserId()){
			System.out.println("================================no good=============================");
			System.out.println("session="+ucvo.getUser().getId());
			System.out.println("context="+ContextUtil.getCurrentUserId());
			System.out.println("================================no good=============================");
		}
		chain.doFilter(request, response);
		UserContextUtil.destoryUserContext();
	}

	public void destroy() {
		

	}
}

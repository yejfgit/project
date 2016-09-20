package com.ulic.portal.pub.web.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements ServletContextAware,
	ServletResponseAware, ServletRequestAware, SessionAware {
	
    private static final long serialVersionUID = 1L;

	protected static Log log = LogFactory.getLog(BaseAction.class);

    protected ServletContext servletContext;

    protected HttpServletRequest request;

    protected HttpServletResponse response;
    
    protected HttpSession httpSession;
    
    protected Map<String, Object> session;

    //@Override
    public void setServletContext(ServletContext context) {
    	this.servletContext = context;
    }
    
    //@Override
    public void setServletResponse(HttpServletResponse response) {
    	this.response = response;
    }

    //@Override
    public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		this.httpSession = request.getSession();
    }

    //@Override
    public void setSession(Map<String, Object> session) {
    	this.session = session;
    }

}

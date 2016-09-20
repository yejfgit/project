package com.ulic.portal.pub.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ulic.portal.pub.util.ServiceLocator;

/**
 * 启动 applicationContext 环境
 * 
 * @author
 * 
 */

public class InitServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
		this.intiService();
		this.initLog();
		
	}

	private void intiService() {
		ServiceLocator.ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(this.getServletContext());
		
		com.ulic.message.server.TaskServer.startTaskListener();
	}

	private void initLog() {
		// BasicConfigurator.configure();
	}

}

package com.ulic.ulweb.web.servlet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ulic.ulweb.util.ServiceLocator;

/**
 * 
 * @author
 *
 */

public class InitServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void init() throws ServletException {
		this.intiService();
		this.initLog();
		System.out.println("***************** init application context *****************");
	}
	
	private void intiService() {
		ServiceLocator.ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(this
				.getServletContext());
		
	}
	private void initLog() {
		// BasicConfigurator.configure();
	}
	
	
}

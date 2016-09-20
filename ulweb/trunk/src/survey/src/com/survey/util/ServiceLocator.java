package com.survey.util;

import javax.servlet.ServletException;

import org.springframework.context.ApplicationContext;

import com.survey.web.servlet.InitServlet;

public class ServiceLocator {

	public static ApplicationContext ctx = null;

	private ServiceLocator() {

	}

	/**
	 * 从服务定位器得到相应服务
	 * 
	 * @param serviceName
	 * @return TODO
	 */
	public static Object getService(String serviceName) {
		if (ctx == null) {
			InitServlet is = new InitServlet();
			try {
				is.init();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// System.out.println("***************** get bean *****************");
		return ctx.getBean(serviceName);
	}

}
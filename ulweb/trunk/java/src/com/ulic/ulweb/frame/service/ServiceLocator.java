package com.ulic.ulweb.frame.service;

import org.springframework.context.ApplicationContext;
import com.ulic.ulweb.frame.page.HtmlPage;

public class ServiceLocator {
	public static ApplicationContext ctx = null;
	private ServiceLocator() {
	}
	public static IService getService(String serviceName) {
		
		return (IService) ctx.getBean(serviceName);
	}
	public static IService getServiceProxy(String serviceName) {
		IService service = null;
		try {
			Object obj = ctx.getBean(serviceName);
			service = (IService) ServiceProxy.newInstance(obj);
		}
		catch (Exception e) {
			System.out.println("can not find spring bean ::::::   " + serviceName);
			e.printStackTrace();
		}
		return service;
	}
	public static HtmlPage getPage(String page) {
		return (HtmlPage) ctx.getBean(page);
	}
}
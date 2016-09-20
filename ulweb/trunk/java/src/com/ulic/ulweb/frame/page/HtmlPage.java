package com.ulic.ulweb.frame.page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ulic.ulweb.frame.service.ServiceLocator;

public abstract class HtmlPage {
	public abstract String execute(HttpServletRequest request, HttpServletResponse response);
	public static HtmlPage getPage(String page) {
		return ServiceLocator.getPage(page);
	}
}

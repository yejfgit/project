package com.ulic.ulweb.frame.tag;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import com.ulic.ulweb.frame.service.IService;
import com.ulic.ulweb.frame.service.ServiceLocator;

public abstract class BaseTag extends TagSupport {
	protected String divid;
	public String getDivid() {
		return divid;
	}
	public void setDivid(String divid) {
		this.divid = divid;
	}
	protected IService getService(String serviceName) {
		return ServiceLocator.getServiceProxy(serviceName);
	}
	public int doAfterBody() throws JspException {
		return TagSupport.EVAL_BODY_INCLUDE;
	}
	public int doStartTag() throws JspException {
		return TagSupport.EVAL_BODY_INCLUDE;
	}
	protected void outToWeb(String s) {
		try {
			this.pageContext.getOut().write(s);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	protected HttpServletRequest getRequest() {
		return (HttpServletRequest) this.pageContext.getRequest();
	}
}

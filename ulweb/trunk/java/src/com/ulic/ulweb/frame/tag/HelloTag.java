package com.ulic.ulweb.frame.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class HelloTag implements Tag {
	private PageContext context;
	private Tag parent;
	public void setPageContext(PageContext context) {
		this.context = context;
	}
	public void setParent(Tag parent) {
		this.parent = parent;
	}
	public Tag getParent() {
		return parent;
	}
	public int doStartTag() throws JspException {
		System.out.println("doStartTag");
		return Tag.SKIP_BODY;
	}
	public int doEndTag() throws JspException {
		System.out.println("doEndtTag");
		try {
			this.context.getOut().write("Hello World");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return Tag.EVAL_PAGE;
	}
	public void release() {
	}
}
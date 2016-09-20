package com.ulic.ulweb.frame.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class HelloSupport extends TagSupport {
	private String value;
	public int doStartTag() throws JspException {
		System.out.println("doStartTag");
		return TagSupport.EVAL_PAGE;
	}
	public int doEndTag() throws JspException {
		System.out.println("doEndTag");
		try {
			this.pageContext.getOut().write("????????????" + this.value);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return Tag.EVAL_PAGE;
	}
	public int doAfterBody() throws JspException {
		System.out.println("doAfterBody");
		try {
			this.pageContext.getOut().write("<br>??????????????<br>");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return TagSupport.EVAL_BODY_INCLUDE;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}

package com.ulic.ulweb.frame.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class IfTag extends TagSupport {
	private String value;
	public int doStartTag() throws JspException {
		System.out.println("doStartTag");
		if (value.equals("0")) {
			return TagSupport.EVAL_BODY_INCLUDE;
		}
		else {
			return TagSupport.SKIP_BODY;
		}
	}
	public int doEndTag() throws JspException {
		System.out.println("doEndTag");
		return TagSupport.EVAL_PAGE;
	}
	public int doAfterBody() throws JspException {
		System.out.println("doAfterBody");
		return TagSupport.EVAL_PAGE;
	}
	public void setValue(String value) {
		this.value = value;
	}
}

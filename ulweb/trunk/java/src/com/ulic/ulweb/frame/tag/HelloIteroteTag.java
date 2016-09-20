package com.ulic.ulweb.frame.tag;


import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.IterationTag;

public class HelloIteroteTag extends BodyTagSupport {
	public String count;
	public String strColor;
	private int cou;
	public void setCount(String count) {
		this.count = count;
		cou = Integer.parseInt(count);
	}
	public int doStartTag() throws JspException {
		try {
			this.pageContext.getOut().write("<font color='" + this.strColor + "'>");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return IterationTag.EVAL_BODY_INCLUDE;
	}
	public int doAfterBody() throws JspException {
		try {
			this.pageContext.getOut().write("<br>");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		if (cou > 1) {
			cou--;
			return IterationTag.EVAL_BODY_AGAIN;
		}
		else {
			return IterationTag.SKIP_BODY;
		}
	}
	public int doEndTag() throws JspException {
		try {
			this.pageContext.getOut().write("</font>");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return IterationTag.EVAL_PAGE;
	}
	public int getCou() {
		return cou;
	}
	public void setCou(int cou) {
		this.cou = cou;
	}
	public String getCount() {
		return count;
	}
	public String getStrColor() {
		return strColor;
	}
	public void setStrColor(String strColor) {
		this.strColor = strColor;
	}
}

package com.ulic.ulweb.ulweb.web.action.addPackage;

import java.io.File;
import java.net.URLConnection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ulic.ulweb.frame.action.BaseAction;

public class UtilAction extends BaseAction{

	public ActionForward mailAddress(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String path = this.getStringValue(request, "path", "http://10.14.132.18/admin/mail.csv");		
		File file = new File(path);
		if(!file.exists()){
			request.setAttribute("errorMessage", "没有读到文件");
		}else{
			request.setAttribute("errorMessage", "创建时间:" + file.lastModified() );
		}
		ActionForward af = new ActionForward();
		af.setName("ok");
		af.setPath("/error/errorpage.jsp");
		return af;
	}
	
	public ActionForward watching(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String url = this.getStringValue(request, "url", "http://10.18.1.118:8080/newapp/admin/login.jsp");
		URLConnection con = request.getSession().getServletContext().getResource(url).openConnection();
		
		ActionForward af = new ActionForward();
		af.setName("ok");
		af.setPath("/error/errorpage.jsp");
		return af;
	}
	
	
}

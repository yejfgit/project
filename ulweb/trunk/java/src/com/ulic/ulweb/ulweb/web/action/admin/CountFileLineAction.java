package com.ulic.ulweb.ulweb.web.action.admin;

import java.io.File;
import java.io.FileReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ulic.ulweb.frame.action.BaseAction;

public class CountFileLineAction extends BaseAction{
	int sum = 0;
	public ActionForward addAttachment(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String fPath = this.getStringValue(request, "fPath");
		File p = new File(fPath);
		this.sumLine(p);
		request.setAttribute("num", sum);		
		return mapping.findForward("showPage");
	}
	
	public void sumLine(File p) throws Exception{
		if(!p.isFile()){
			File child[] = p.listFiles();		
			for(int i = 0; i < child.length; i++){
				this.sumLine(child[i]);
			}
		}else{
			
			sum++;
		}
		
	}
}

package com.survey.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.json.JSONObject;

public class JsonAction extends DispatchAction {
	
	public ActionForward jsonOpen(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		return mapping.findForward("open");
	}
	
	public ActionForward jsonGo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String obj = request.getParameter("obj");
		
		JSONObject jsonObj = new JSONObject(obj);
		String name = jsonObj.getString("name");
		
		System.out.println(name);
		return null;
	}
	
}

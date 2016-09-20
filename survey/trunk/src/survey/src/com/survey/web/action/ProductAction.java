package com.survey.web.action;


import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.survey.vo.User;
import com.survey.vo.UserContextVO;


public class ProductAction extends BaseAction{
	
	public ActionForward toIntroduce (ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		return mapping.findForward("toIntroduce");
	}
	
	
}

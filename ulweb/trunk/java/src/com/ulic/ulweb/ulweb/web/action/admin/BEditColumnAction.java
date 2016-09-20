package com.ulic.ulweb.ulweb.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ulic.ulweb.frame.action.BaseAction;
import com.ulic.ulweb.ulweb.entity.UlColumn;
import com.ulic.ulweb.ulweb.service.IUlColumnService;
import com.ulic.ulweb.ulweb.util.CheckUserRight;

public class BEditColumnAction extends BaseAction{
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(CheckUserRight.checkUser(request) < 2){
			request.setAttribute("errorMessage", "只有不受限管理员才能作此操作");
			return mapping.findForward("error");
		}
		if(request.getParameter("columnId") == null) {
			request.setAttribute("errorMessage", "没有得到columnId");
			return mapping.findForward("error");
		}
		int columnId = Integer.parseInt(request.getParameter("columnId"));
		IUlColumnService cs = (IUlColumnService)this.getService("columnService");
		UlColumn c = null;
		if( cs.getColumnById(columnId) == null) {
			request.setAttribute("errorMessage", "没有得到column");
			return mapping.findForward("error");
		}
		c = cs.getColumnById(columnId);
		request.setAttribute("columnName",c.getColumnName());
		if(c.getIncludeContent() == 1) {
			request.setAttribute("include", "内容");
		}else{
			request.setAttribute("include", "栏目");
		}
		if(c.getShowToUser() == 1){
			request.setAttribute("show", "checked");
			request.setAttribute("notShow","");
		}else{
			request.setAttribute("show","");
			request.setAttribute("notShow","checked");
		}
		request.setAttribute("showOtherClass", c.getShowOthersClass());
		request.setAttribute("showOrganClass", c.getShowOrganClass());
		request.setAttribute("columnOrder", c.getColumnOrder());
		if(c.getOpenColumn() == 1){
			request.setAttribute("openColumn", "是");
		}else{
			request.setAttribute("openColumn", "否");
		}
		
		
		return mapping.findForward("ok");
	}
}

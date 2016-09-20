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
import com.ulic.ulweb.ulweb.web.form.ColumnForm;

public class EditColumnAction extends BaseAction{
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
			request.setAttribute("errorMessage", "数据库中没有column");
			return mapping.findForward("error");
		}
		ColumnForm cf = (ColumnForm)form;
		c = cs.getColumnById(columnId);
		c.setColumnName(cf.getColumnName());
		c.setShowToUser(cf.getShowToUser());
		c.setShowOthersClass(cf.getShowOtherClass());
		c.setShowOrganClass(cf.getShowOrganClass());
		c.setColumnOrder(cf.getColumnOrder());
		cs.updateColumn(c);		
		return mapping.findForward("ok");
		
	}
}

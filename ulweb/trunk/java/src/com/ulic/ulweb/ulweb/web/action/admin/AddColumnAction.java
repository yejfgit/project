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

public class AddColumnAction extends BaseAction{
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(CheckUserRight.checkUser(request) < 2){
			request.setAttribute("errorMessage", "只有不受限管理员才能作此操作");
			return mapping.findForward("error");
		}
		String forward = "ok";				
		UlColumn c = new UlColumn();
		ColumnForm cf = (ColumnForm)form; 
		IUlColumnService cs = (IUlColumnService)this.getService("columnService");
		c.setColumnName(cf.getColumnName());
		c.setParentId(cf.getParentColumn());
		c.setOrganId(cf.getDeptId());
		c.setColumnOrder(cf.getColumnOrder());
		c.setIsdelete(0);
		c.setOpenColumn(cf.getOpenColumn());		
		c.setShowOrganClass(cf.getShowOrganClass());
		c.setShowOthersClass(cf.getShowOtherClass());
		c.setShowToUser(cf.getShowToUser());
//		看同一级别栏目中是否有重名的		
		int columnLevel = cs.getColumnLevelAndNoSameName(c);
		if(columnLevel == 0){
			request.setAttribute("errorMessage", "<span color=#ff0000 >同一栏目中已有引名字的样目了</span>");
			return mapping.findForward("ok");
		}else if(columnLevel == -1){
			request.setAttribute("errorMessage", "dao层出错了，级别被定为-1了");
			return mapping.findForward("error");
		}
		c.setColumnLevel(columnLevel);
		if(cf.getInclude() == 1){
			c.setIncludeColumn(1);
			c.setIncludeContent(0);
		}else if(cf.getInclude() == 2){
			c.setIncludeColumn(0);
			c.setIncludeContent(1);
		}else{
			request.setAttribute("errorMessage", "include 数据出错");
			return mapping.findForward("error");
		}
		cs.addColumn(c);
//		request.setAttribute("js","document.getElementsByName(\"dept\")[0].value = '" + c.getOrganId() + "';");
		request.setAttribute("errorMessage",c.getColumnName() );
		return mapping.findForward(forward);
	}
}

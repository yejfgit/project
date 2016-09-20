package com.ulic.ulweb.ulweb.web.action.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ulic.ulweb.frame.action.BaseAction;
import com.ulic.ulweb.ulweb.entity.UlColumn;
import com.ulic.ulweb.ulweb.entity.UlDept;
import com.ulic.ulweb.ulweb.service.IUlColumnService;
import com.ulic.ulweb.ulweb.service.IUlDeptService;
import com.ulic.ulweb.ulweb.util.CheckUserRight;
import com.ulic.ulweb.ulweb.util.GetColumns;

public class ColumnAction  extends BaseAction{
	public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int adminLevel = CheckUserRight.checkUser(request);
		if( adminLevel < 2){
			request.setAttribute("errorMessage", "只有管理员才能作此操作");
			return mapping.findForward("error");
		}
		String deptId = null;
		HttpSession session = request.getSession();	
		IUlColumnService cs = (IUlColumnService)this.getService("columnService");
		IUlDeptService ds = (IUlDeptService)this.getService("deptService");
		List<UlDept> deptList = null;
		if(adminLevel == 9){
			if(request.getParameter("deptId") != null){
				deptId = request.getParameter("deptId");				
			}else if(request.getAttribute("deptId") != null){
				deptId = (String)request.getAttribute("deptId");
			}else{
				deptId = "0000";
			}				
			deptList = ds.getList();
		}else {
			deptId = (String)session.getAttribute("dept");
		}		
		UlDept d = ds.getDept(deptId); 
		GetColumns gc = new GetColumns();
		List l = cs.getListByDeptForColumn(deptId);
		request.setAttribute("columnList", gc.columnListUsedColumn(l, d.getDeptName()));
		request.setAttribute("deptId",deptId);
		request.setAttribute("deptList", deptList);
		request.setAttribute("from", "do");		
		return mapping.findForward("listPage");
	}
	
	public ActionForward bEdit(ActionMapping mapping, ActionForm form, HttpServletRequest request,
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
		request.setAttribute("columnId", columnId);
		// set english name to page
		String eId = c.getColumnEId() == null ? "" : c.getColumnEId();
		request.setAttribute("eId", eId);
		request.setAttribute("columnName",c.getColumnName());
		request.setAttribute("parentName", c.getParentName());
		request.setAttribute("parentId", c.getParentId());
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
		
		
		return mapping.findForward("editPage");
	}
	
	public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(CheckUserRight.checkUser(request) < 2){
			request.setAttribute("errorMessage", "只有不受限管理员才能作此操作");
			return mapping.findForward("error");
		}			
		UlColumn c = new UlColumn();
//		ColumnForm cf = (ColumnForm)form; 
		IUlColumnService cs = (IUlColumnService)this.getService("columnService");
		String columnName = (this.getStringValue(request, "columnName")).replace("'", "");
		columnName = columnName.replace("\"", "");
		c.setColumnName(columnName);
		c.setParentId(this.getIntValue(request, "parentColumn", 0));
		c.setOrganId(this.getStringValue(request, "deptId"));
		// get english name from page
		c.setColumnEId(this.getStringValue(request, "eId", ""));
		c.setColumnOrder(this.getIntValue(request, "columnOrder" , 0));
		c.setIsdelete(0);
		c.setOpenColumn(this.getIntValue(request, "openColumn" , 0));		
		c.setShowOrganClass(this.getIntValue(request, "showOrganClass", 0));
		c.setShowOthersClass(this.getIntValue(request, "showOthersClass", 0));
		c.setShowToUser(this.getIntValue(request, "showToUser", 0));
//		看同一级别栏目中是否有重名的		
		int columnLevel = cs.getColumnLevelAndNoSameName(c);
		if(columnLevel == 0){
			request.setAttribute("errorMessage", "<span color=#ff0000 >同一栏目中已有相同名字的样目了</span>");
			return mapping.findForward("error");
		}else if(columnLevel == -1){
			request.setAttribute("errorMessage", "dao层出错了，级别被定为-1了");
			return mapping.findForward("error");
		}
		c.setColumnLevel(columnLevel);
		if(this.getIntValue(request, "include", 0) == 1){
			c.setIncludeColumn(1);
			c.setIncludeContent(0);
		}else if(this.getIntValue(request, "include", 0) == 2){
			c.setIncludeColumn(0);
			c.setIncludeContent(1);
		}else{
			request.setAttribute("errorMessage", "include 数据出错");
			return mapping.findForward("error");
		}
		cs.addColumn(c);
//		request.setAttribute("js","document.getElementsByName(\"dept\")[0].value = '" + c.getOrganId() + "';");
		request.setAttribute("errorMessage",c.getColumnName() );
		return mapping.findForward("list");
	}
	
	public ActionForward edit(ActionMapping mapping, ActionForm form, HttpServletRequest request,
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
		UlColumn c = cs.getColumnById(columnId);
		if( c == null) {
			request.setAttribute("errorMessage", "数据库中没有column");
			return mapping.findForward("error");
		}
//		ColumnForm cf = (ColumnForm)form;
		c.setParentId(this.getIntValue(request, "parentColumn", 0));
		// get english name from page
		c.setColumnEId(this.getStringValue(request, "eId", ""));
		//log.info("**********************eId:" + this.getStringValue(request, "eId", ""));
		c.setColumnName(this.getStringValue(request, "columnName"));
		c.setShowToUser(this.getIntValue(request, "showToUser", 0));
//		c.setShowOthersClass(cf.getShowOtherClass());
//		c.setShowOrganClass(cf.getShowOrganClass());
		c.setColumnOrder(this.getIntValue(request, "columnOrder", 0));
		cs.updateColumn(c);		
		request.setAttribute("errorMessage", "修改成功");
		return mapping.findForward("list");
		
	}
	
	public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(CheckUserRight.checkUser(request) < 9){
			request.setAttribute("errorMessage", "只有超级管理员才能作此操作");
			return mapping.findForward("error");
		}
		if(request.getParameter("columnId") == null){
			request.setAttribute("errorMessage", "没有得到columnId");
			return mapping.findForward("error");
		}		
		IUlColumnService cs = (IUlColumnService)this.getService("columnService");
		String userDeptId = cs.deleteColumn(Integer.parseInt(request.getParameter("columnId").trim()));
		if(userDeptId.equals("error")){
			request.setAttribute("errorMessage", "没有找到这个column的dept，可能是不存在");
			return mapping.findForward("error");
		}		
		return mapping.findForward("list");
	}
	
	public ActionForward show(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(CheckUserRight.checkUser(request) < 2){
			request.setAttribute("errorMessage", "只有超级管理员才能作此操作");
			return mapping.findForward("error");
		}
		int cId = this.getIntValue(request, "c", 0);
		if(cId == 0){
			request.setAttribute("errorMessage", "没有得到columnId");
			return mapping.findForward("error");
		}		
		IUlColumnService cs = (IUlColumnService)this.getService("columnService");
		UlColumn c = cs.getByIdForShow(cId);
		request.setAttribute("c",c);
		return mapping.findForward("showPage");
	}
}

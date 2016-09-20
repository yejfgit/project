package com.ulic.ulweb.ulweb.web.action.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ulic.ulweb.frame.action.BaseAction;
import com.ulic.ulweb.ulweb.entity.UlDept;
import com.ulic.ulweb.ulweb.service.IUlDeptService;
import com.ulic.ulweb.ulweb.util.CheckUserRight;

public class DeptAction extends BaseAction{
	public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(request.getParameter("deptId") == null){
			request.setAttribute("errorMessage","没有得到request中的deptId,从deptAction来");
			return mapping.findForward("error");
		}
		if(CheckUserRight.checkUser(request) < 9){
			request.setAttribute("errorMessage", "只有不受限管理员才能作此操作");
			return mapping.findForward("error");
		}
		UlDept d = new UlDept();
		d.setDeptId(request.getParameter("deptId"));
		d.setDeptName(request.getParameter("deptName"));
		d.setDeptModel(Integer.parseInt(request.getParameter("deptModel")));
		IUlDeptService ds = (IUlDeptService)this.getService("deptService");
		if(ds.getDept(d.getDeptId()) == null){
			ds.save(d);
		}else{
			request.setAttribute("errorMessage", "此id已经被使用了，请选择一个新的id");
			return mapping.findForward("error");
		}
		return mapping.findForward("list");
	}
	
	public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(CheckUserRight.checkUser(request) < 9){
			request.setAttribute("errorMessage", "只有不受限管理员才能作此操作");
			return mapping.findForward("error");
		}
		IUlDeptService ds = (IUlDeptService)this.getService("deptService");
		List<UlDept> list = ds.getList();
		StringBuffer sb = new StringBuffer();		
		sb.append("<tr><td>名称</td><td>模版</td><td>操作</td>");
		if(!list.isEmpty()){			
			for(int i=0; i < list.size(); i++){
				if(i%2 == 1){
					sb.append("<tr bgcolor='#a0ceff'><td>");
				}else{
					sb.append("<tr><td>");
				}
				sb.append(list.get(i).getDeptName());
				sb.append("</td><td>" + list.get(i).getDeptModel());
				sb.append("</td><td><a href='admin/dept.do?method=bUpdate&deptId=" + list.get(i).getDeptId());
				sb.append("'>修改</a>&nbsp;<a href='admin/dept.do?method=delete&deptId=" + list.get(i).getDeptId());
				sb.append("'>删除</a></td></tr>");
			}
		}
		request.setAttribute("list", sb.toString());
		return mapping.findForward("listPage");
	}
	
	public ActionForward bUpdate(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(CheckUserRight.checkUser(request) < 9){
			request.setAttribute("errorMessage", "只有不受限管理员才能作此操作");
			return mapping.findForward("error");
		}
		if(request.getParameter("deptId") == null){
			request.setAttribute("errorMessage","没有得到request中的deptId,从deptAction来");
			return mapping.findForward("error");
		}		
		IUlDeptService ds = (IUlDeptService)this.getService("deptService");
		UlDept d = ds.getDept(request.getParameter("deptId"));
		request.setAttribute("deptId", d.getDeptId());
		request.setAttribute("deptName", d.getDeptName());
		request.setAttribute("deptModel", d.getDeptModel());
		return mapping.findForward("editPage");
	}
	
	public ActionForward update(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(CheckUserRight.checkUser(request) < 9){
			request.setAttribute("errorMessage", "只有不受限管理员才能作此操作");
			return mapping.findForward("error");
		}
		if(request.getParameter("deptId") == null){
			request.setAttribute("errorMessage","没有得到request中的deptId,从deptAction来");
			return mapping.findForward("error");
		}
		UlDept d = new UlDept();
		d.setDeptId(request.getParameter("deptId"));
		d.setDeptName(request.getParameter("deptName"));
		d.setDeptModel(Integer.parseInt(request.getParameter("deptModel")));
		IUlDeptService ds = (IUlDeptService)this.getService("deptService");
		if(ds.update(d) == 1){
			return mapping.findForward("list");
		}else{
			request.setAttribute("errorMessage","没有更新成功,从deptAction来");
			return mapping.findForward("error");
		}
	}
	
	public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(CheckUserRight.checkUser(request) < 9){
			request.setAttribute("errorMessage", "只有不受限管理员才能作此操作");
			return mapping.findForward("error");
		}
		if(request.getParameter("deptId") == null){
			request.setAttribute("errorMessage","没有得到request中的deptId,从deptAction来");
			return mapping.findForward("error");
		}
		IUlDeptService ds = (IUlDeptService)this.getService("deptService");
		ds.delete(request.getParameter("deptId"));
		return mapping.findForward("list");
	}
}

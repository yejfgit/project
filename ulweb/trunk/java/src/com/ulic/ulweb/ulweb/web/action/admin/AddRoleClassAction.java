package com.ulic.ulweb.ulweb.web.action.admin;

import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ulic.ulweb.frame.action.BaseAction;
import com.ulic.ulweb.ulweb.dao.AdminDAO;
import com.ulic.ulweb.ulweb.entity.UlColumn;
import com.ulic.ulweb.ulweb.entity.UlRoleClass;
import com.ulic.ulweb.ulweb.service.IUlColumnService;
import com.ulic.ulweb.ulweb.service.IUlDeptService;
import com.ulic.ulweb.ulweb.service.IUlRoleClassService;
import com.ulic.ulweb.ulweb.util.CheckUserRight;
import com.ulic.ulweb.ulweb.util.GetColumns;

public class AddRoleClassAction extends BaseAction{
	public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(CheckUserRight.checkUser(request) < 2){
			request.setAttribute("errorMessage", "只有不受限管理员才能作此操作");
			return mapping.findForward("error");
		}
		
		IUlRoleClassService rs = (IUlRoleClassService)this.getService("roleClassService");
		List<UlRoleClass> rl = rs.getRoleList();
		request.setAttribute("listu", rl);
		return mapping.findForward("listPage");		
	}

	public ActionForward bedit(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(CheckUserRight.checkUser(request) < 2){
			request.setAttribute("errorMessage", "只有不受限管理员才能作此操作");
			return mapping.findForward("error");
		}
		
		if(request.getParameter("roleId") == null || request.getParameter("roleId").equals("")) {
			request.setAttribute("errorMessage", "没有得到request中的roleId");
			return mapping.findForward("error");
		}

		int rId = Integer.parseInt(request.getParameter("roleId"));
		IUlRoleClassService rs = (IUlRoleClassService)this.getService("roleClassService");
		UlRoleClass r = rs.getUlRoleClassById(rId);
		IUlDeptService ds = (IUlDeptService)this.getService("deptService");
		GetColumns gc = new GetColumns();
		String deptList = gc.getDeptList(ds.getList());
		
		if(r == null){
			request.setAttribute("errorMessage", "此人员不属于管理员");
			return mapping.findForward("error");
		}else{
			request.setAttribute("roleName", r.getName());
			request.setAttribute("roleId", rId);
			request.setAttribute("roleClass", r.getRoleClass());
			request.setAttribute("isAdmin", r.getIsAdmin());
			request.setAttribute("deptId", r.getDept());
		}
		request.setAttribute("deptList", deptList);
//		request.setAttribute("roleName", request.getParameter("roleName"));
		return mapping.findForward("editPage");		
	}
	
	public ActionForward bAdd(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(CheckUserRight.checkUser(request) < 2){
			request.setAttribute("errorMessage", "只有不受限管理员才能作此操作");
			return mapping.findForward("error");
		}		
		AdminDAO ad = new AdminDAO();
		List<UlRoleClass> list = ad.getAllUserId();
		IUlDeptService ds = (IUlDeptService)this.getService("deptService");
		GetColumns gc = new GetColumns();
		String deptList = gc.getDeptList(ds.getList());
		request.setAttribute("deptList", deptList);
		request.setAttribute("list", list);
		return mapping.findForward("addPage");
	}
	
	public ActionForward getUser(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		GetColumns gc = new GetColumns();
		String name = this.getStringValue(request, "userName");
		if(name.equals("")){
			request.setAttribute("errorMessage", "请输入要查找的人员");
			return mapping.findForward("error");
		}
		AdminDAO ad = new AdminDAO();
		List<UlRoleClass> list = ad.getUserByName(name);
		request.setAttribute("list", list);
		return mapping.findForward("getUserPage");
	}
	
	public ActionForward getColumn(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(CheckUserRight.checkUser(request) < 2){
			request.setAttribute("errorMessage", "只有不受限管理员才能作此操作");
			return mapping.findForward("error");
		}		
		int rId = this.getIntValue(request,"roleId",0);
		if(rId == 0)rId = this.getIntValue(request, "userId", 0);
		if(rId == 0){
			request.setAttribute("errorMessage", "没有得到RoleId");
			return mapping.findForward("error");
		}
		IUlRoleClassService rs = (IUlRoleClassService)this.getService("roleClassService");
		UlRoleClass r = rs.getUlRoleClassById(rId);
		IUlColumnService cs = (IUlColumnService)this.getService("columnService");
		String deptId = this.getStringValue(request, "deptId");
		List<UlColumn> l = cs.getListByDeptForColumn(deptId);
		StringBuffer sb = new StringBuffer();
		sb.append("<script type='text/javascript'>");
		sb.append("d = new dTree('d');");
		sb.append("d.add(0,-1,\"所有栏目\");");
//排列所有栏目	
		for(int i = 0; i < (l.isEmpty()?0:l.size()); i++){
			
			sb.append("d.add(" + l.get(i).getColumnId() + "," + l.get(i).getParentId() + ",\"" );
			if(l.get(i).getIncludeContent() == 1){
				sb.append("<input type='checkbox' name='columnId' value='" + l.get(i).getColumnId() + "' ");
				sb.append("id='id" + l.get(i).getColumnId() + "'>");
			}			
			sb.append(l.get(i).getColumnName() + "\",\"\");");
		}
		sb.append("document.write(d);");	
//如果有一定的权限，就给打上对勾	
		
		if(r != null){
			if(r.getColumnId() != null){
				String[] cid = r.getColumnId().split(",");
				for(int j = 0; j < cid.length; j++){
					sb.append("checkbox('" + cid[j] + "');");
				}				
			}
		}
		sb.append("</script>");
		request.setAttribute("deptId", deptId);
		request.setAttribute("roleId", rId);
		request.setAttribute("columns",sb.toString());	
		request.setAttribute("roleClass", request.getParameter("roleClass"));
		return mapping.findForward("choseColumns");		
	}
	
	public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
		int uAdmin = CheckUserRight.checkUser(request);
		if( uAdmin < 2){
			request.setAttribute("errorMessage", "只有不受限管理员才能作此操作");
			return mapping.findForward("error");
		}		
		int rId = this.getIntValue(request, "roleId", 0);	
		if(rId == 0)rId = this.getIntValue(request, "userId", 0);
		if(rId == 0){
			request.setAttribute("errorMessage", "没有得到RoleId");
			return mapping.findForward("error");
		}
		IUlRoleClassService rs = (IUlRoleClassService)this.getService("roleClassService");
		UlRoleClass r = rs.getUlRoleClassById(rId);	
		int soru = 0;
		if(r == null){
			r = new UlRoleClass();
			soru = 1;
			r.setRoleId(rId);	
		}		
		if(!this.getStringValue(request, "deptId").equals("")){
			r.setDept(request.getParameter("deptId"));
		}	
		r.setRoleClass(this.getIntValue(request, "roleClass", 0));
		if(uAdmin < 9 && r.getRoleClass() == 9){
			request.setAttribute("errorMessage", "只有超级管理员才能添加超级管理员");
			return mapping.findForward("error");
		}
		AdminDAO ad = new AdminDAO();		
		r.setName(ad.getById(r.getRoleId()).getName());
//		System.out.println("name: " + r.getName());
		if(this.getIntValue(request, "isAdmin",0) == 1){
			r.setIsAdmin(1);
			if(request.getParameterValues("columnId") != null){
				String[] str = request.getParameterValues("columnId");
				StringBuffer sb = new StringBuffer();
				sb.append(str[0]);
				for(int i = 1; i < str.length; i++ ){
					sb.append("," + str[i]);
				}
				r.setColumnId(sb.toString());
			}else{
				r.setColumnId("");
			}
		}else{
			if(soru == 1){
				r.setColumnId("");
			}			
			r.setIsAdmin(Integer.parseInt(request.getParameter("isAdmin")));
		}
		if(soru == 1){
			rs.addRoleClass(r);
		}else{
			rs.updateRoleClass(r);
		}
		return mapping.findForward("list");
	}
	
	public ActionForward showuser(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int rId = this.getIntValue(request, "roleId", 0);	
		if(rId == 0){
			request.setAttribute("errorMessage", "没有得到RoleId");
			return mapping.findForward("error");
		}
		IUlRoleClassService rs = (IUlRoleClassService)this.getService("roleClassService");
		UlRoleClass r = rs.getUlRoleClassById(rId);
		List<UlColumn> list = null;
		if(r.getIsAdmin() == 1){
			IUlColumnService cs = (IUlColumnService)this.getService("columnService");
			list = cs.getListByColumnIds(r.getColumnId());
		}
		request.setAttribute("r", r);
		request.setAttribute("list",list);
		return mapping.findForward("showUserPage");
	}
	
	public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int rId = this.getIntValue(request, "roleId", 0);	
		if(rId == 0){
			request.setAttribute("errorMessage", "没有得到RoleId");
			return mapping.findForward("error");
		}
		IUlRoleClassService rs = (IUlRoleClassService)this.getService("roleClassService");
		rs.deleteRoleClass(rId);
		return mapping.findForward("list");
		
	}
						 
	public ActionForward findAdUserRealName(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String username = this.getStringValue(request,"username");
		AdminDAO ad = new AdminDAO();
		//根据登录名username设置从域中查到的真实姓名realname
		request.setAttribute("username",username);
		request.setAttribute("realname",ad.findAdUserRealName(username));
		
		ActionForward af = new ActionForward();
		af.setPath("/admin/add/addadrole.jsp");
		return af;
		
	}
	
	public ActionForward addAdUser(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String username = this.getStringValue(request,"username");
		String realname = this.getStringValue(request,"realname");
		
		//把域上的登录名和真实姓名添加到用户库中
		AdminDAO ad = new AdminDAO();
		ad.addAdUser(username, realname);
	
		ActionForward af = new ActionForward();
		af.setPath("/admin/addRoleClass.do?method=bAdd");
		return af;
	}
	
}

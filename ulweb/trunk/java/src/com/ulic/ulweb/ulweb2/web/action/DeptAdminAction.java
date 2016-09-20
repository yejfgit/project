package com.ulic.ulweb.ulweb2.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.ulic.ulweb.ulweb2.entity.ContentTmplEntity;
import com.ulic.ulweb.ulweb2.entity.DeptEntity;
import com.ulic.ulweb.ulweb2.service.IContentTmplService;
import com.ulic.ulweb.ulweb2.service.IDeptService;

public class DeptAdminAction extends TopAction {

	private IDeptService ds = (IDeptService) this.getService("deptAdminService");
	private IContentTmplService cts = (IContentTmplService) this.getService("contentTmplAdminService");

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// CheckRight
		if (!this.checkRight(request, this.ADMIN_TOP)) {
			return mapping.findForward("error");
		}
		
		DynaActionForm f = (DynaActionForm) form;
		List l = ds.getAllDepts(true);
		f.set("list", l);
		return mapping.findForward("list");
	}

	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// CheckRight
		if (!this.checkRight(request, this.ADMIN_TOP)) {
			return mapping.findForward("error");
		}
		
		return mapping.findForward("add");
	}
	
	public ActionForward addSave(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// CheckRight
		if (!this.checkRight(request, this.ADMIN_TOP)) {
			return mapping.findForward("error");
		}
		
		DynaActionForm f = (DynaActionForm) form;
		DeptEntity d = (DeptEntity) f.get("dept");
		if (!ds.saveDept(d)) {
			request.setAttribute("errorMessage", "新建部门失败");
			return mapping.findForward("error");
		}
		return mapping.findForward("back");
	}
	
	public ActionForward edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// CheckRight
		if (!this.checkRight(request, this.ADMIN_TOP)) {
			return mapping.findForward("error");
		}
		
		DynaActionForm f = (DynaActionForm) form;
		String id = this.getStringValue(request, "id");
		if (id.equals("")) {
			request.setAttribute("errorMessage", "ID不合法");
			return mapping.findForward("error");
		}
		DeptEntity d = ds.getDeptById(id);
		if (d == null) {
			request.setAttribute("errorMessage", "该部门不存在");
			return mapping.findForward("error");
		}
		ContentTmplEntity ct = cts.getTmplById(d.getContentTmplId());
		if (ct == null) {
			d.setContentTmplId(0);
			d.setContentTmplName("");
		} else {
			d.setContentTmplName(ct.getTmplName());
		}
		f.set("dept", d);
		return mapping.findForward("edit");
	}
	
	public ActionForward editSave(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// CheckRight
		if (!this.checkRight(request, this.ADMIN_TOP)) {
			return mapping.findForward("error");
		}
		
		DynaActionForm f = (DynaActionForm) form;
		DeptEntity d = (DeptEntity) f.get("dept");
		if (!ds.updateDept(d)) {
			request.setAttribute("errorMessage", "修改部门失败");
			return mapping.findForward("error");
		}
		return mapping.findForward("back");
	}
	
	public ActionForward del(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// CheckRight
		if (!this.checkRight(request, this.ADMIN_TOP)) {
			return mapping.findForward("error");
		}
		
		String id = this.getStringValue(request, "id");
		if (id.equals("")) {
			request.setAttribute("errorMessage", "ID不合法");
			return mapping.findForward("error");
		}
		if (!ds.delDeptById(id)) {
			request.setAttribute("errorMessage", "删除部门失败");
			return mapping.findForward("error");
		}
		return mapping.findForward("back");
	}
}

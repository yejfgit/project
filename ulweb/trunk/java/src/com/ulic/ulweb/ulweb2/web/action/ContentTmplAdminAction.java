package com.ulic.ulweb.ulweb2.web.action;

import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.ulic.ulweb.ulweb2.entity.ContentTmplEntity;
import com.ulic.ulweb.ulweb2.service.IContentTmplService;

public class ContentTmplAdminAction extends TopAction {

	private IContentTmplService cts = (IContentTmplService) this.getService("contentTmplAdminService");

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// CheckRight
		if (!this.checkRight(request, this.ADMIN_TOP)) {
			return mapping.findForward("error");
		}
		
		DynaActionForm f = (DynaActionForm) form;
		List l = cts.getAllTmpls();
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
		ContentTmplEntity ct = (ContentTmplEntity) f.get("contentTmpl");
		//System.out.println(ct.getTmplContent());
		if (!cts.saveTmpl(ct)) {
			request.setAttribute("errorMessage", "新建内容模板失败");
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
		int id = this.getIntValue(request, "id");
		if (id == 0) {
			request.setAttribute("errorMessage", "ID不合法");
			return mapping.findForward("error");
		}
		ContentTmplEntity ct = cts.getTmplById(id);
		if (ct == null) {
			request.setAttribute("errorMessage", "该内容模板不存在");
			return mapping.findForward("error");
		}
		f.set("contentTmpl", ct);
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
		ContentTmplEntity ct = (ContentTmplEntity) f.get("contentTmpl");
		if (!cts.updateTmpl(ct)) {
			request.setAttribute("errorMessage", "修改内容模板失败");
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
		
		int id = this.getIntValue(request, "id");
		if (id == 0) {
			request.setAttribute("errorMessage", "ID不合法");
			return mapping.findForward("error");
		}
		if (!cts.delTmplById(id)) {
			request.setAttribute("errorMessage", "删除内容模板失败");
			return mapping.findForward("error");
		}
		return mapping.findForward("back");
	}
	
	public ActionForward preview(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// CheckRight
		if (!this.checkRight(request, this.ADMIN_TOP)) {
			return mapping.findForward("error");
		}
		
		DynaActionForm f = (DynaActionForm) form;
		ContentTmplEntity ct = (ContentTmplEntity) f.get("contentTmpl");
		String htmlStr = ct.getTmplContentString();
		if (htmlStr == null) {
			htmlStr = "";
		}
		htmlStr = new String(htmlStr.getBytes("utf8"), "iso8859-1");
		ServletOutputStream out = response.getOutputStream();
		out.println(htmlStr);
		
		return null;
	}
	
	public ActionForward selectConTmpl(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// CheckRight
		if (!this.checkRight(request, this.ADMIN_DEPT)) {
			return mapping.findForward("error");
		}
		
		DynaActionForm f = (DynaActionForm) form;
		List l = cts.getAllTmpls();
		f.set("list", l);
		
		return mapping.findForward("selectConTmpl");
	}
	
	
}

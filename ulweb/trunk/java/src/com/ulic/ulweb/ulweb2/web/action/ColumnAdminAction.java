package com.ulic.ulweb.ulweb2.web.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.ulic.ulweb.ulweb2.entity.ColumnEntity;
import com.ulic.ulweb.ulweb2.entity.ContentTmplEntity;
import com.ulic.ulweb.ulweb2.entity.DeptEntity;
import com.ulic.ulweb.ulweb2.service.IColumnService;
import com.ulic.ulweb.ulweb2.service.IContentTmplService;
import com.ulic.ulweb.ulweb2.service.IDeptService;

public class ColumnAdminAction extends TopAction {

	private IColumnService cols = (IColumnService) this
			.getService("columnAdminService");

	private IDeptService ds = (IDeptService) this
			.getService("deptAdminService");

	private IContentTmplService cts = (IContentTmplService) this
			.getService("contentTmplAdminService");

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// CheckRight
		if (!this.checkRight(request, this.ADMIN_DEPT)) {
			return mapping.findForward("error");
		}
		DynaActionForm f = (DynaActionForm) form;
		String deptId = this.getStringValue(request, "deptId");
		if (deptId.equals("")) {
			deptId = ((DeptEntity) f.get("dept")).getDeptId();
		}
		
		if (this.checkUser(request) == this.ADMIN_TOP) {
			List dl = ds.getAllDepts(false);
			f.set("deptList", dl);
		} else {
			deptId = (String) request.getSession().getAttribute("dept");
			f.set("deptList", new ArrayList());
		}

		if (deptId == null || deptId.equals("")) {
			f.set("dept", new DeptEntity());
			f.set("columnList", new ArrayList());
		} else {
			DeptEntity d = ds.getDeptById(deptId);
			List cl = cols.findColumnsByDeptId(deptId);
			f.set("dept", d);
			f.set("columnList", cl);
		}

		return mapping.findForward("list");
	}

	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// CheckRight
		if (!this.checkRight(request, this.ADMIN_DEPT)) {
			return mapping.findForward("error");
		}

		int id = this.getIntValue(request, "id");
		String deptId = this.getStringValue(request, "deptId");
		log.info(deptId);
		DynaActionForm f = (DynaActionForm) form;
		ColumnEntity pCol;
		if (id == 0) {
			pCol = new ColumnEntity();
			DeptEntity d = ds.getDeptById(deptId);
			if (d != null) {
				pCol.setColumnName(d.getDeptName());
				pCol.setOrganId(d.getDeptId());
			}
		} else {
			pCol = cols.getColumnById(id);
		}

		f.set("parentColumn", pCol);

		return mapping.findForward("add");
	}

	public ActionForward addSave(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// CheckRight
		if (!this.checkRight(request, this.ADMIN_DEPT)) {
			return mapping.findForward("error");
		}

		DynaActionForm f = (DynaActionForm) form;
		ColumnEntity c = (ColumnEntity) f.get("column");

		if (c.getIncludeColumn() == 1) {
			c.setIncludeContent(0);
		} else {
			c.setIncludeContent(1);
		}

		if (!cols.saveColumn(c)) {
			request.setAttribute("errorMessage", "新建栏目失败");
			return mapping.findForward("error");
		}
		return mapping.findForward("back");
	}

	public ActionForward edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// CheckRight
		if (!this.checkRight(request, this.ADMIN_DEPT)) {
			return mapping.findForward("error");
		}

		DynaActionForm f = (DynaActionForm) form;
		int id = this.getIntValue(request, "id");
		if (id == 0) {
			request.setAttribute("errorMessage", "ID不合法");
			return mapping.findForward("error");
		}
		ColumnEntity col = cols.getColumnById(id);
		ContentTmplEntity ct = cts.getTmplById(col.getContentTmplId());
		if (ct == null) {
			col.setContentTmplId(0);
			col.setContentTmplName("");
		} else {
			col.setContentTmplName(ct.getTmplName());
		}
		f.set("column", col);

		if (col.getParentId() != 0) {
			ColumnEntity pCol = cols.getColumnById(col.getParentId());
			f.set("parentColumn", pCol);
		}

		return mapping.findForward("edit");
	}

	public ActionForward editSave(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// CheckRight
		if (!this.checkRight(request, this.ADMIN_DEPT)) {
			return mapping.findForward("error");
		}

		DynaActionForm f = (DynaActionForm) form;
		ColumnEntity c = (ColumnEntity) f.get("column");
		if (!cols.updateColumn(c)) {
			request.setAttribute("errorMessage", "修改栏目失败");
			return mapping.findForward("error");
		}
		return mapping.findForward("back");
	}

	public ActionForward del(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// CheckRight
		if (!this.checkRight(request, this.ADMIN_DEPT)) {
			return mapping.findForward("error");
		}

		int id = this.getIntValue(request, "id");
		if (id == 0) {
			request.setAttribute("errorMessage", "ID不合法");
			return mapping.findForward("error");
		}
		if (!cols.delColumnById(id)) {
			request.setAttribute("errorMessage", "删除栏目失败");
			return mapping.findForward("error");
		}
		return mapping.findForward("back");
	}
}

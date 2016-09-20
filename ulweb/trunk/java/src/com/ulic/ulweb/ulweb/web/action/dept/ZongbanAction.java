package com.ulic.ulweb.ulweb.web.action.dept;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ulic.ulweb.frame.action.BaseAction;
import com.ulic.ulweb.ulweb.entity.UlColumn;
import com.ulic.ulweb.ulweb.service.IUlColumnService;
import com.ulic.ulweb.ulweb.service.IUlContentService;

public class ZongbanAction extends BaseAction {

	// 部门英文名指定
	final String DEPT_NAME = "zongban";
	
	// 栏目英文名指定
	final String COLUMN1 = "column1"; // 栏目1
	final String COLUMN2 = "column2"; // 栏目2

	private IUlContentService cons = (IUlContentService) this
			.getService("contentService");

	private IUlColumnService cols = (IUlColumnService) this
			.getService("columnService");

	/**
	 * 首页
	 */
	public ActionForward index(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String ptype = this.getStringValue(request, "ptype");

		int column1 = cols.getColumnIdByEId(this.DEPT_NAME, this.COLUMN1);
		int column2 = cols.getColumnIdByEId(this.DEPT_NAME, this.COLUMN2);
		
		request.setAttribute(this.COLUMN1, cons.getContentByColumnId(column1, 1, 10));
		request.setAttribute(this.COLUMN2, cons.getContentByColumnId(column2, 1, 10));

		request.setAttribute("ptype", ptype);

		return new ActionForward("/dept/peixun/index" + ptype + ".jsp");
	}

	/**
	 * 列表页
	 */
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String ptype = this.getStringValue(request, "ptype");
		String eId = this.getStringValue(request, "eId", "");
		int page = this.getIntValue(request, "page", 1);
		int pageSize = this.getIntValue(request, "pageSize", 10);	

		int columnId = cols.getColumnIdByEId(this.DEPT_NAME, eId);
		
		UlColumn c = cols.getColumnById(columnId);
		request.setAttribute("column", c);
		request.setAttribute("columnList", cols.getColumnsByParentId(c.getParentId(), this.DEPT_NAME));
		request.setAttribute("contentList", cons.getContentByColumnId(columnId, page, pageSize));

		request.setAttribute("totlePage", cons.getContentTotlePage(columnId, pageSize));
		request.setAttribute("page", page);
		return new ActionForward("/dept/peixun/list" + ptype + ".jsp");
	}

}

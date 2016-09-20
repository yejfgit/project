package com.ulic.ulweb.ulweb2.web.action;

import java.sql.Clob;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;


import com.ulic.ulweb.frame.util.HtmlUtil;
import com.ulic.ulweb.ulweb2.entity.ColumnEntity;
import com.ulic.ulweb.ulweb2.entity.ContentEntity;
import com.ulic.ulweb.ulweb2.entity.DeptEntity;
import com.ulic.ulweb.ulweb2.entity.PageEntity;
import com.ulic.ulweb.ulweb2.service.IColumnService;
import com.ulic.ulweb.ulweb2.service.IContentService;
import com.ulic.ulweb.ulweb2.service.IDeptService;
import com.ulic.ulweb.ulweb2.service.impl.task.AttachmentEventListener;
import com.ulic.ulweb.ulweb2.service.impl.task.ContentEventListener;
import com.ulic.ulweb.ulweb2.util.FormatUtil;

public class ContentAdminAction extends TopAction {

	private IContentService cons = (IContentService) this
			.getService("contentAdminService");

	private IColumnService cols = (IColumnService) this
			.getService("columnAdminService");

	private IDeptService ds = (IDeptService) this
			.getService("deptAdminService");

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// CheckRight
		if (!this.checkRight(request, this.ADMIN_COL)) {
			return mapping.findForward("error");
		}

		DynaActionForm f = (DynaActionForm) form;
		String deptId = this.getStringValue(request, "deptId");
		int columnId = this.getIntValue(request, "columnId");
		String pageId = request.getParameter("pageId");
		request.setAttribute("pageId", pageId);
		request.setAttribute("columnId", columnId);

		

		if (this.checkUser(request) == this.ADMIN_TOP) {

			List dl = ds.getAllDepts(false);
			f.set("deptList", dl);
			
			if (deptId == null || deptId.equals("")) {
				f.set("dept", new DeptEntity());
				f.set("columnList", new ArrayList());
			} else {
				DeptEntity d = ds.getDeptById(deptId);
				List cl = cols.findColumnsByDeptId(deptId);
				f.set("dept", d);
				f.set("columnList", cl);
			}

		} else if (this.checkUser(request) == this.ADMIN_DEPT) {
			deptId = (String) request.getSession().getAttribute("dept");
			f.set("deptList", new ArrayList());

			DeptEntity d = ds.getDeptById(deptId);
			List cl = cols.findColumnsByDeptId(deptId);
			f.set("dept", d);
			f.set("columnList", cl);

		} else {
			f.set("deptList", new ArrayList());

			String columnIds = (String) request.getSession().getAttribute(
					"columnId");
			int[] ids = FormatUtil.stringToIntegers(columnIds);
			List cl = cols.findColumnsByColumnIds(ids);
			f.set("dept", new DeptEntity());
			f.set("columnList", cl);

		}

		return mapping.findForward("list");
	}

	public ActionForward getContentList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// CheckRight
		if (!this.checkRight(request, this.ADMIN_COL)) {
			return mapping.findForward("error");
		}

		int columnId = this.getIntValue(request, "id");
		if (columnId == 0) {
			request.setAttribute("errorMessage", "请输入栏目ID");
			return mapping.findForward("error");
		}
		int pageNum = this.getIntValue(request, "pageNum");
		if (pageNum == 0) {
			pageNum = 1;
		}

		PageEntity pe = new PageEntity();

//		DetachedCriteria dc = DetachedCriteria.forClass(ContentEntity.class);
//		dc.add(Restrictions.eq("columnId", columnId));
//		dc.add(Restrictions.eq("isDelete", 0));
//		dc.addOrder(Order.desc("orderNum"));
//		dc.addOrder(Order.desc("contentId"));
//		
//		pe.setCondition(dc);
		
		Map qMap = new HashMap();
		List oList = new ArrayList();
		qMap.put("columnId", columnId);
		qMap.put("isDelete", 0);
		oList.add("orderNum desc");
		oList.add("contentId desc");
		
		pe.setQueryCondition(qMap);
		pe.setQueryOrder(oList);
		pe.setPageNum(pageNum);
		PageEntity cl = cons.listContentByColumnId(pe);

		DynaActionForm f = (DynaActionForm) form;
		f.set("contentList", cl.getObjectList());
		ColumnEntity c = cols.getColumnById(columnId);
		f.set("column", c);
		f.set("page", pe);

		return mapping.findForward("contentList");
	}

	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// CheckRight
		if (!this.checkRight(request, this.ADMIN_COL)) {
			return mapping.findForward("error");
		}

		DynaActionForm f = (DynaActionForm) form;
		ColumnEntity fc = (ColumnEntity) f.get("column");
		if (fc == null || fc.getColumnId() == 0) {
			request.setAttribute("errorMessage", "请先选择栏目");
			return mapping.findForward("error");
		}
		ColumnEntity col = cols.getColumnById(fc.getColumnId());
		f.set("column", col);

		return mapping.findForward("add");
	}

	public ActionForward addSave(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// CheckRight
		if (!this.checkRight(request, this.ADMIN_COL)) {
			return mapping.findForward("error");
		}

		DynaActionForm f = (DynaActionForm) form;
		ContentEntity c = (ContentEntity) f.get("content");
		// System.out.println("Content Name:" + c.getContentName());

		c.setUploadUser((String) request.getSession().getAttribute("name"));
		c.setUploadTime(new Date());
		c.setUpdateTime(new Date());
		

		
		if (c.getContentString() != null && c.getContentString().length() > 0) {
			c.setHaveContent(1);
		} else {
			c.setHaveContent(0);
		}
		c = cons.saveContent(c);
		//是微话内容，初始化微话点击量表
		if(c!=null&&c.getColumnId()==5686){
			cons.addContentClicks(c.getContentId());
		}
		if (c == null) {
			request.setAttribute("errorMessage", "添加内容失败");
			return mapping.findForward("error");
		}
		
		String needAtt = request.getParameter("att");
		
		//创建索引
//		UlDocument ud = new UlDocument();
//		ud.setId(String.valueOf(c.getContentId()));
//		ud.setSystem("Ulweb");
//		ud.setTitile(c.getContentName());
//		ud.setContent(c.getContentString());
//		ud.setUrl("show.do?c="+c.getContentId());
//		ud.setType(2);
//		
//		TaskClient.addTask(ud);
		
		if ("1".equals(needAtt)) {
			c.setIsProcessing(1);
			cons.updateContent(c);
			return new ActionForward(
					"/web/admin/attachment/attachmentAdmin.do?method=add&contentId=" + c.getContentId(), 
					true);
		} else {
			ContentEventListener.onContentAdd(c);
			return new ActionForward(
				"/web/admin/content/contentAdmin.do?method=list&deptId="
				+ c.getOrganId() + "&columnId=" + c.getColumnId(), 
				true);
		}
	}

	public ActionForward edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// CheckRight
		if (!this.checkRight(request, this.ADMIN_COL)) {
			return mapping.findForward("error");
		}
		
		String pageId = request.getParameter("pageId");
		int id = this.getIntValue(request, "id");
		if (id == 0) {
			request.setAttribute("errorMessage", "ID不合法");
			return mapping.findForward("error");
		}

		DynaActionForm f = (DynaActionForm) form;
		ContentEntity con = cons.getContentById(id);
		//System.out.println(con.getContentString());
		con.setContentString(HtmlUtil.getHtmlFilterValue(con.getContentString()));
		//System.out.println(con.getContentString());
		f.set("content", con);
		//System.out.println(con.getContentString());

		ColumnEntity col = cols.getColumnById(con.getColumnId());
		f.set("column", col);
		request.setAttribute("pageId", pageId);
		return mapping.findForward("edit");
	}

	public ActionForward editSave(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// CheckRight
		if (!this.checkRight(request, this.ADMIN_COL)) {
			return mapping.findForward("error");
		}

		String pageId = request.getParameter("pageId");
		DynaActionForm f = (DynaActionForm) form;
		ContentEntity c = (ContentEntity) f.get("content");
		if (c.getContentString() != null && c.getContentString().length() > 0) {
			c.setHaveContent(1);
		} else {
			c.setHaveContent(0);
		}

		c.setAttachmentSum(cons.getContentById(c.getContentId()).getAttachmentSum());
		
		c.setUpdateTime(new Date());
		if (!cons.updateContent(c)) {
			request.setAttribute("errorMessage", "修改内容失败");
			return mapping.findForward("error");
		}
		
		String needAtt = request.getParameter("att");
		if ("1".equals(needAtt)) {
			c.setIsProcessing(1);
			cons.updateContent(c);
			ContentEventListener.onContentEdit(c);
			return new ActionForward(
					"/web/admin/attachment/attachmentAdmin.do?method=add&contentId=" + c.getContentId()+"&pageId="+pageId, 
					true);
		} else {
			if (AttachmentEventListener.getInstance().isAllAttachmentDone(c)) {
				c.setIsProcessing(0);
			} else {
				c.setIsProcessing(1);
			}
			cons.updateContent(c);
			ContentEventListener.onContentEdit(c);
			return new ActionForward(
					"/web/admin/content/contentAdmin.do?method=list&deptId="
					+ c.getOrganId() + "&columnId=" + c.getColumnId()+"&pageId="+pageId, 
					true);
		}

		
	}

	public ActionForward del(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// CheckRight
		if (!this.checkRight(request, this.ADMIN_COL)) {
			return mapping.findForward("error");
		}

		int id = this.getIntValue(request, "id");
		if (id == 0) {
			request.setAttribute("errorMessage", "ID不合法");
			return mapping.findForward("error");
		}
		ContentEntity c = cons.getContentById(id);
		if (!cons.delContentById(id)) {
			request.setAttribute("errorMessage", "删除内容失败");
			return mapping.findForward("error");
		}
		ContentEventListener.onContentDel(c);
		return new ActionForward(
				"/web/admin/content/contentAdmin.do?method=list&deptId="
				+ c.getOrganId() + "&columnId=" + c.getColumnId(), 
				true);
	}

	public ActionForward show(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// CheckRight
		if (!this.checkRight(request, this.ADMIN_COL)) {
			return mapping.findForward("error");
		}

		int id = this.getIntValue(request, "id");
		if (id == 0) {
			request.setAttribute("errorMessage", "ID不合法");
			return mapping.findForward("error");
		}
		String htmlStr = cons.showContent(id);

		htmlStr = new String(htmlStr.getBytes("utf8"), "iso8859-1");
		ServletOutputStream out = response.getOutputStream();
		out.println(htmlStr);
		return null;
	}
	
	private static String clob2String(Clob clob) throws Exception {
        return (clob != null ? clob.getSubString(1, (int) clob.length()) : "");
    } 
}

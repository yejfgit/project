package com.ulic.ulweb.ulweb.web.action.dept;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ulic.ulweb.frame.action.BaseAction;
import com.ulic.ulweb.ulweb.entity.UlColumn;
import com.ulic.ulweb.ulweb.entity.UlContent;
import com.ulic.ulweb.ulweb.entity.UlTemplate;
import com.ulic.ulweb.ulweb.service.IUlColumnService;
import com.ulic.ulweb.ulweb.service.IUlContentService;

public class DeptColumn2Action extends BaseAction{

	public ActionForward index(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String dept = this.getStringValue(request, "dept","");
		int show = this.getIntValue(request, "show", 1);
		if(dept.equals("")){
			request.setAttribute("errorMessage", "您要转到的部门现在还没有主页");
			return mapping.findForward("error");
		}
//		int templateId = this.getIntValue(request, "tId", 0);
		IUlColumnService cs = (IUlColumnService)this.getService("columnService");
		List list = cs.getListByColumnLevelAndDept(1, dept, show);
//		if(templateId != 0){
		IUlContentService cons = (IUlContentService)this.getService("contentService");
		List<UlTemplate> listTemplate = cons.getTemplateByColumnId( 99999, 9, dept);			
		request.setAttribute("template",listTemplate.get(0));	
		request.setAttribute("columnList",list);
		ActionForward af = new ActionForward();
		af.setName("ok");
		af.setPath("/dept/" + dept + "/index.jsp");
		return af;
	}
	
	public ActionForward sub1(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String ptype = this.getStringValue(request, "ptype");
		int show = this.getIntValue(request, "show", 1);
		String forward = null;
		int columnId = this.getIntValue(request, "columnId", 0);
		int page = this.getIntValue(request, "page", 1);
		int pageSize = this.getIntValue(request, "pageSize", 0);		
		UlTemplate template = null;
		
		if(columnId == 0){
			request.setAttribute("errorMessage", "没有得到columnId");
			return mapping.findForward("error");
		}
				
		IUlColumnService cs = (IUlColumnService)this.getService("columnService");
		IUlContentService cons = (IUlContentService)this.getService("contentService");
		
		UlColumn  columnt = cs.getColumnById(columnId);	
		UlColumn column = null;
		if(columnt.getIncludeContent() == 0){
			
			List<UlColumn> list1 = cs.getListByParentIdForShow(columnt.getParentId(),columnt.getOrganId(), show);
			List<UlColumn> list2 = cs.getListByParentIdForShow(columnt.getColumnId(), columnt.getOrganId(), show);
			
			request.setAttribute("cList1", list1);
			request.setAttribute("cList2", list2);
			request.setAttribute("columnP", columnt);			
			if(list2.size() > 0){
				column = list2.get(0);
				template = (UlTemplate)(cons.getTemplateByColumnId(column.getColumnId(),column.getColumnLevel(),column.getOrganId())).get(0);
				if(pageSize == 0){
					pageSize = template.getPageSize();
				}
				request.setAttribute("contentList", cons.getContentByColumnId(column.getColumnId(),page, pageSize));
				request.setAttribute("column", column);
				request.setAttribute("template",template);
				request.setAttribute("totlePage",cons.getTotlePageFor2LevelColumn(column.getColumnId(),pageSize));
			}else if(list2.size() == 0){
				request.setAttribute("errorMessage", "此栏目下没有子栏目");
				return mapping.findForward("error");
			}
			forward = "/dept/" + columnt.getOrganId() + "/subpage2" + ptype + ".jsp";
		}else{
			List<UlColumn> list1 = cs.getListByParentIdForShow(columnt.getParentId(), columnt.getOrganId(), show);
			request.setAttribute("cList1", list1);	
			template = (UlTemplate)(cons.getTemplateByColumnId(columnt.getColumnId(),columnt.getColumnLevel(),columnt.getOrganId())).get(0);
			if(pageSize == 0){
				pageSize = template.getPageSize();
			}
			request.setAttribute("contentList", cons.getContentByColumnId(columnt.getColumnId(),page, pageSize));
			request.setAttribute("column", columnt);
			request.setAttribute("template",template);	
			request.setAttribute("totlePage",cons.getTotlePageFor2LevelColumn(columnt.getColumnId(),pageSize));
			forward = "/dept/" + columnt.getOrganId() + "/subpage1" + ptype + ".jsp";
		}
				
		request.setAttribute("page",page);
		ActionForward af = new ActionForward();
		af.setName("ok");
		af.setPath(forward);
		return af;
	}
	
	
	public ActionForward sub2(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String forward = null;
		String ptype = this.getStringValue(request, "ptype");
		int show = this.getIntValue(request, "show", 1);
		int columnId = this.getIntValue(request, "columnId", 0);
		int page = this.getIntValue(request, "page", 1);
		int pageSize = this.getIntValue(request, "pageSize", 0);
		UlTemplate template = null;
		
		if(columnId == 0){
			request.setAttribute("errorMessage", "没有得到columnId");
			return mapping.findForward("error");
		}
				
		IUlColumnService cs = (IUlColumnService)this.getService("columnService");
		IUlContentService cons = (IUlContentService)this.getService("contentService");
		
		UlColumn  column = cs.getColumnById(columnId);
		
		if(column.getIncludeContent() == 0){
			request.setAttribute("errorMessage", "此栏目下没有内容");
			return mapping.findForward("error");
		}
		
		List list1 = cs.getListByColumnLevelAndDept(1,column.getOrganId(), show);
		List list2 = cs.getListByParentIdForShow(column.getParentId(),column.getOrganId(), show);	
	
		template = (UlTemplate)(cons.getTemplateByColumnId(column.getColumnId(), column.getColumnLevel(), column.getOrganId()).get(0));
		if(pageSize == 0){
			pageSize = template.getPageSize();
		}
	
		List<UlContent> contentList = cons.getContentByColumnId(column.getColumnId(),page, pageSize);
		int totlePage = cons.getTotlePageFor2LevelColumn(column.getColumnId(),pageSize);
		
		request.setAttribute("contentList", contentList);
		request.setAttribute("totlePage", totlePage);
		request.setAttribute("cList1", list1);
		request.setAttribute("cList2", list2);
		request.setAttribute("column", column);
		request.setAttribute("template",template);
		request.setAttribute("page",page);
		forward = "/dept/" + column.getOrganId() + "/subpage2" + ptype + ".jsp";
		ActionForward af = new ActionForward();
		af.setName("ok");
		af.setPath(forward);
		return af;
	}
	
	public ActionForward sub3(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String forward = null;
		int columnId = this.getIntValue(request, "columnId", 0);
		IUlColumnService cs = (IUlColumnService)this.getService("columnService");
		UlColumn column = cs.getColumnById(columnId);
		
		forward = "/dept/" + column.getOrganId() + "/subpage2.jsp";
		ActionForward af = new ActionForward();
		af.setName("ok");
		af.setPath(forward);
		return af;
	}
	
	public ActionForward toFind(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String forward = null;
		String ptype = this.getStringValue(request, "ptype");
		String dept = this.getStringValue(request, "dept", "1110");
		int columnLevel = this.getIntValue(request, "level", 2);
		IUlColumnService cs = (IUlColumnService)this.getService("columnService");
		List<UlColumn> list = cs.getListByColumnLevelAndDept(columnLevel, dept, 1);
		request.setAttribute("list", list);
		forward = "/dept/" + dept + "/find" + ptype + ".jsp";
		ActionForward af = new ActionForward();
		af.setName("ok");
		af.setPath(forward);
		return af;
	}
	
	
}















package com.ulic.ulweb.ulweb.web.action.dept;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ulic.ulweb.frame.action.BaseAction;
import com.ulic.ulweb.frame.constant.Constant;
import com.ulic.ulweb.ulweb.entity.UlTemplate;
import com.ulic.ulweb.ulweb.service.IUlColumnService;
import com.ulic.ulweb.ulweb.service.IUlContentService;

public class Finacial extends BaseAction{
	

	public ActionForward index(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String dept = this.getStringValue(request, "dept","caiwu");
		int show = this.getIntValue(request, "show", 1);		
		int columnIdg = this.getIntValue(request, "cg", 0);
		int columnId1 = this.getIntValue(request, "c1", 0);
		if(columnIdg == 0 || columnId1 == 0){
			request.setAttribute("errorMessage", "没有得到columnId");
			return mapping.findForward("error");
		}
		IUlContentService cons = (IUlContentService)this.getService("contentService");
		List<UlTemplate> listTemplate = cons.getTemplateByColumnId( 99999, 9, dept);			
		
		IUlColumnService cs = (IUlColumnService)this.getService("columnService");
		List list = cs.getListByColumnLevelAndDept(1, dept, show);			
		request.setAttribute("template",listTemplate.get(0));	
		request.setAttribute("columnList",list);
		request.setAttribute("listg", cons.getContentByColumnId(columnIdg, 1, 5));
		request.setAttribute("list1", cons.getContentByColumnId(columnId1, 1, 5));
		request.setAttribute("list2", cons.getQuickLinkByDept(dept, 1, listTemplate.get(0).getPageSize()));
		
		ActionForward af = new ActionForward();
		af.setName("ok");
		af.setPath("/dept/" + dept + "/indext.jsp");
		return af;
	}


	
	public ActionForward indextop(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String dept = this.getStringValue(request, "dept","caiwu");
		int show = this.getIntValue(request, "show", 1);		
		
		IUlContentService cons = (IUlContentService)this.getService("contentService");
		List<UlTemplate> listTemplate = cons.getTemplateByColumnId( 99999, 9, dept);			
		
		IUlColumnService cs = (IUlColumnService)this.getService("columnService");
		List list = cs.getListByColumnLevelAndDept(1, dept, show);			
		request.setAttribute("template",listTemplate.get(0));	
		request.setAttribute("columnList",list);
		
		ActionForward af = new ActionForward();
		af.setName("ok");
		af.setPath("/dept/" + dept + "/indextop.jsp");
		return af;
	}
	
	
	public ActionForward indexcenter(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String dept = this.getStringValue(request, "dept","caiwu");
		int columnIdg = this.getIntValue(request, "cg", 0);
		int columnId1 = this.getIntValue(request, "c1", 0);
		int show = this.getIntValue(request, "show", 1);		
		IUlContentService cons = (IUlContentService)this.getService("contentService");
		List<UlTemplate> listTemplate = cons.getTemplateByColumnId( 99999, 9, dept);	
		IUlColumnService cs = (IUlColumnService)this.getService("columnService");
		List list = cs.getListByColumnLevelAndDept(1, dept, show);		
		request.setAttribute("columnList",list);
		request.setAttribute("listg", cons.getContentByColumnId(columnIdg, 1, 5));
		request.setAttribute("list1", cons.getContentByColumnId(columnId1, 1, 5));
		request.setAttribute("list2", cons.getQuickLinkByDept(dept, 1, listTemplate.get(0).getPageSize()));
		
		request.setAttribute("template",listTemplate.get(0));	
		
		ActionForward af = new ActionForward();
		af.setName("ok");
		af.setPath("/dept/" + dept + "/indexcenter.jsp");
		return af;
	}
/*	采用分页的方法
	public ActionForward subPage1(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String ptype = this.getStringValue(request, "ptype");
		String dept = this.getStringValue(request, "dept", "caiwu");
		String forward = null;
		int columnId = this.getIntValue(request, "columnId", 0);
		int page = this.getIntValue(request, "page", 1);
		int pageSize = this.getIntValue(request, "pageSize", 10);		
		
		if(columnId == 0){
			request.setAttribute("errorMessage", "没有得到columnId");
			return mapping.findForward("error");
		}
		IUlContentService cons = (IUlContentService)this.getService("contentService");
		request.setAttribute("columnId",columnId);
		request.setAttribute("contentList", cons.getContentByColumnId(columnId,page, pageSize));
		request.setAttribute("totlePage",cons.getTotlePageFor2LevelColumn(columnId,pageSize));
		request.setAttribute("page",page);
		forward = "/dept/" + dept + "/subpage1" + ptype + ".jsp";
		
		ActionForward af = new ActionForward();
		af.setName("ok");
		af.setPath( forward );
		return af;
	}
*/	
	
	public ActionForward subPage1(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String ptype = this.getStringValue(request, "ptype");
		String dept = this.getStringValue(request, "dept", "caiwu");
		String forward = null;
		int columnId = this.getIntValue(request, "columnId", 0);
		int page = this.getIntValue(request, "page", 1);
		int pageSize = this.getIntValue(request, "pageSize", 0);		
		
		if(columnId == 0){
			request.setAttribute("errorMessage", "没有得到columnId");
			return mapping.findForward("error");
		}
		int show = this.getIntValue(request, "show", 1);		
		IUlContentService cons = (IUlContentService)this.getService("contentService");
		List<UlTemplate> listTemplate = cons.getTemplateByColumnId( columnId, 1, dept);	
		IUlColumnService cs = (IUlColumnService)this.getService("columnService");
		List list = cs.getListByColumnLevelAndDept(1, dept, show);		
		request.setAttribute("columnList",list);
		request.setAttribute("columnId",columnId);
		request.setAttribute("template", listTemplate.get(0));
		
//070806 change get right pageSize
		if(pageSize == 0)pageSize = listTemplate.get(0).getPageSize();			
		
		request.setAttribute("contentList", cons.getContentByColumnId(columnId,page, pageSize));
		request.setAttribute("totlePage",cons.getContentTotlePage(columnId,pageSize));
		request.setAttribute("page",page);
		forward = "/dept/" + dept + "/subpage1" + ptype + ".jsp";
		
		ActionForward af = new ActionForward();
		af.setName("ok");
		af.setPath( forward );
		return af;
	}
	
//070626增加的查找用的
	
	public ActionForward check(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {	
		
		int show = this.getIntValue(request, "show", 1);	
		String ptype = this.getStringValue(request, "ptype");
		String dept = this.getStringValue(request, "dept", "caiwu");
		int columnId = this.getIntValue(request, "columnId", 0);
		IUlContentService cons = (IUlContentService)this.getService("contentService");
		List<UlTemplate> listTemplate = cons.getTemplateByColumnId( columnId, 1, dept);	
		request.setAttribute("template", listTemplate.get(0));
		StringBuffer sb = new StringBuffer();
		int page = this.getIntValue(request, "page", 1);		
		int ti = 0;		
		String ts = this.getStringValue(request, "condition");
		String forward = this.getStringValue(request, "forward", "/dept/caiwu/checkshow" );
		forward += ptype;
		if(!ts.equals("")){
			sb.append(ts);
		}else{
			sb.append(" where organ_id = '" + dept + "' and is_delete = 0 ");
			ts = this.getStringValue(request, "tName");				
			if(!ts.equals("")){
				sb.append(" and content_name like '%" + ts.toLowerCase() + "%' ");
			}
			ti = this.getIntValue(request, "type", 0);
			if(ti != 0){
				sb.append(" and column_id = " + ti + " ");
			}
			ts = this.getStringValue(request, "dNum");
			if(!ts.equals("")){
				sb.append(" and document_num = '" + ts + "' ");
			}
			ts = this.getStringValue(request, "ts");
			if(!ts.equals("")){
				if(ts.indexOf("-") == -1){
					if(ts.length() == 4){
						sb.append(" and upload_time > to_date('" + ts + "', 'yyMM') ");
					}else if(ts.length() == 6 && ts.indexOf("0") == 0){
						sb.append(" and upload_time > to_date('" + ts + "', 'yyMMDD') ");
					}else{
						sb.append(" and upload_time > to_date('" + ts + "', 'yyyyMMDD') ");
					}
				}else{
					if(ts.indexOf("0") == 0){
						sb.append(" and upload_time > to_date('" + ts + "', 'yy-MM-DD') ");
					}else{
						sb.append(" and upload_time > to_date('" + ts + "', 'yyyy-MM-DD') ");
					}		
				}		
			}
			ts = this.getStringValue(request, "te");
			if(!ts.equals("")){
				if(ts.indexOf("-") == -1){
					if(ts.length() == 4){
						sb.append(" and (upload_time - 1) < to_date('" + ts + "', 'yyMM') ");
					}else if(ts.length() == 6 && ts.indexOf("0") == 0){
						sb.append(" and (upload_time - 1) < to_date('" + ts + "', 'yyMMDD') ");
					}else{
						sb.append(" and (upload_time - 1) < to_date('" + ts + "', 'yyyyMMDD') ");
					}
				}else{
					if(ts.indexOf("0") == 0){
						sb.append(" and (upload_time - 1) < to_date('" + ts + "', 'yy-MM-DD') ");
					}else{
						sb.append(" and (upload_time - 1) < to_date('" + ts + "', 'yyyy-MM-DD') ");
					}				
				}		
			}				
		}				
		int pageSize = this.getIntValue(request, "pageSize", Constant.indexPageSize);
		IUlContentService cs = (IUlContentService)this.getService("contentService");
		int totlePage = cs.getCheckTotlePage(sb.toString(), pageSize);
		
		List clist = cs.getListByColumnLevelAndDept(1, dept, show);		
		if(page > totlePage && totlePage > 1) page = totlePage;
		List list = cs.getCheck(sb.toString(), page, pageSize);
		
		
		request.setAttribute("condition", sb.toString());
				
		request.setAttribute("totlePage", totlePage);
		request.setAttribute("columnList",clist);
		request.setAttribute("columnId",columnId);
		request.setAttribute("template", listTemplate.get(0));
		request.setAttribute("contentList", list);
		request.setAttribute("page",page);

		ActionForward af = new ActionForward();
		af.setName("ok");
		af.setPath( forward + ".jsp");
		return af;
		
	}
/*
	public ActionForward indextopForView(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String dept = this.getStringValue(request, "dept","caiwu");
		int show = this.getIntValue(request, "show", 1);		
		
		IUlContentService cons = (IUlContentService)this.getService("contentService");
		List<UlTemplate> listTemplate = cons.getTemplateByColumnId( 99999, 9, dept);			
		
		IUlColumnService cs = (IUlColumnService)this.getService("columnService");
		List list = cs.getListByColumnLevelAndDept(1, dept, show);			
		request.setAttribute("template",listTemplate.get(0));	
		request.setAttribute("columnList",list);
		
		ActionForward af = new ActionForward();
		af.setName("ok");
		af.setPath("/dept/" + dept + "/indextop.jsp");
		return af;
	}
	
	
	public ActionForward indexcenterForView(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String dept = this.getStringValue(request, "dept","caiwu");
		int columnIdg = this.getIntValue(request, "cg", 0);
		int columnId1 = this.getIntValue(request, "c1", 0);
		int show = this.getIntValue(request, "show", 1);		
		IUlContentService cons = (IUlContentService)this.getService("contentService");
		List<UlTemplate> listTemplate = cons.getTemplateByColumnId( 99999, 9, dept);	
		IUlColumnService cs = (IUlColumnService)this.getService("columnService");
		List list = cs.getListByColumnLevelAndDept(1, dept, show);		
		request.setAttribute("columnList",list);
		request.setAttribute("listg", cons.getContentByColumnId(columnIdg, 1, 5));
		request.setAttribute("list1", cons.getContentByColumnId(columnId1, 1, 5));
		request.setAttribute("list2", cons.getQuickLinkByDept(dept, 1, listTemplate.get(0).getPageSize()));
		
		request.setAttribute("template",listTemplate.get(0));	
		
		ActionForward af = new ActionForward();
		af.setName("ok");
		af.setPath("/dept/" + dept + "/indexcenter.jsp");
		return af;
	}
*/	
}

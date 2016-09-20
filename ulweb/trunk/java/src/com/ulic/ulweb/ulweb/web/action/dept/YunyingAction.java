package com.ulic.ulweb.ulweb.web.action.dept;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ulic.ulweb.frame.action.BaseAction;
import com.ulic.ulweb.ulweb.entity.UlColumn;
import com.ulic.ulweb.ulweb.entity.UlTemplate;
import com.ulic.ulweb.ulweb.service.IUlColumnService;
import com.ulic.ulweb.ulweb.service.IUlContentService;

public class YunyingAction extends BaseAction{
	
	public ActionForward index(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String ptype = this.getStringValue(request, "ptype");
		
		IUlContentService cons = (IUlContentService)this.getService("contentService");
		IUlColumnService cs = (IUlColumnService)this.getService("columnService");
		
		int xinxi = 367;
		int wenjian = 368;
		int jilu = 369;
		
		List<UlTemplate> listTemplate = cons.getTemplateByColumnId( 99999, 9, "yunying");	
		
		request.setAttribute("template",(listTemplate.get(0) == null ? (new UlTemplate()) : listTemplate.get(0)));	
		
		request.setAttribute("columnList", cs.getListByColumnLevelAndDept(1,"yunying", 1));
		request.setAttribute("xinxi", cons.getContentByColumnId(xinxi, 1, 5));
		request.setAttribute("wenjian", cons.getContentByColumnId(wenjian, 1, 5));
		request.setAttribute("jilu", cons.getContentByColumnId(jilu, 1, 5));
		
		request.setAttribute("ptype",ptype);
		ActionForward af = new ActionForward();
		af.setPath("/dept/yunying/index" + ptype + ".jsp");
		return af;
		
	}
	
	public ActionForward subPage1(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String ptype = this.getStringValue(request, "ptype");
		int columnId = this.getIntValue(request, "columnId", 0);
		int page = this.getIntValue(request, "page", 1);
		int pageSize = this.getIntValue(request, "pageSize", 0);		
		
		if(columnId == 0){
			request.setAttribute("errorMessage", "没有得到columnId");
			return mapping.findForward("error");
		}
		IUlContentService cons = (IUlContentService)this.getService("contentService");
		IUlColumnService cs = (IUlColumnService)this.getService("columnService");
		
		UlColumn c = cs.getColumnById(columnId);
		
		
		List<UlTemplate> listTemplate = cons.getTemplateByColumnId( columnId, 1, "yunying");	
		request.setAttribute("template",(listTemplate.get(0) == null ? (new UlTemplate()) : listTemplate.get(0)));	
		
		if(pageSize == 0)pageSize = listTemplate.get(0).getPageSize();	
		
		request.setAttribute("column", c);	
		request.setAttribute("contentList", cons.getContentByColumnId(columnId, page, pageSize));
		request.setAttribute("totlePage",cons.getContentTotlePage(columnId,pageSize));
		request.setAttribute("page",page);
		request.setAttribute("ptype",ptype);
		ActionForward af = new ActionForward();
		af.setPath("/dept/yunying/subpage1" + ptype + ".jsp");
		return af;
		
	}
	
	public ActionForward subPage2(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String ptype = this.getStringValue(request, "ptype");
		int columnId = this.getIntValue(request, "columnId", 0);
		int page = this.getIntValue(request, "page", 1);
		int pageSize = this.getIntValue(request, "pageSize", 0);		
		
		if(columnId == 0){
			request.setAttribute("errorMessage", "没有得到columnId");
			return mapping.findForward("error");
		}
		IUlContentService cons = (IUlContentService)this.getService("contentService");
		IUlColumnService cs = (IUlColumnService)this.getService("columnService");
		
		UlColumn c = cs.getColumnById(columnId);
		
		
		List<UlTemplate> listTemplate = cons.getTemplateByColumnId( columnId, 1, "yunying");	
		request.setAttribute("template",(listTemplate.get(0) == null ? (new UlTemplate()) : listTemplate.get(0)));	
		
		if(pageSize == 0)pageSize = listTemplate.get(0).getPageSize();	
		
		request.setAttribute("columnList", cs.getListByParentIdForShow(c.getParentId(), "yunying", 1));
		request.setAttribute("column", c);	
		request.setAttribute("parentColumn", cs.getColumnById(c.getParentId()));
		request.setAttribute("contentList", cons.getContentByColumnId(columnId, page, pageSize));
		request.setAttribute("totlePage",cons.getContentTotlePage(columnId,pageSize));
		request.setAttribute("page",page);
		request.setAttribute("ptype",ptype);
		ActionForward af = new ActionForward();
		af.setPath("/dept/yunying/subpage2" + ptype + ".jsp");
		return af;
		
	}
}

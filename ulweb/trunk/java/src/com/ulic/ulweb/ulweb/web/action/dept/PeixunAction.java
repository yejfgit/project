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
import com.ulic.ulweb.ulweb.service.UtilService;

public class PeixunAction extends BaseAction{
	public ActionForward index(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String ptype = this.getStringValue(request, "ptype");
		int countProcesser = ((UtilService)this.getService("utilService")).getCountProcesser("peixun");
		request.setAttribute("countProcesser",countProcesser);
				
		IUlContentService cons = (IUlContentService)this.getService("contentService");
		IUlColumnService cs = (IUlColumnService)this.getService("columnService");
		
		
		int tongzhi = 267;//文件通知
		int zhichuang = 268;//培训之窗
		int yuandi = 269;//教学园地
		int jiayuan = 270;//训练家园
		int guanli = 271;//培训管理
		int zhuanlan = 272;//考试专栏
		int zhisheng = 273;//机构之声
		
		int zhitongche = 318;//培训直通车
		int gonggao = 0;//培训公告
		
		List<UlTemplate> listTemplate = cons.getTemplateByColumnId( 99999, 9, "peixun");	
		request.setAttribute("template",(listTemplate.get(0) == null ? (new UlTemplate()) : listTemplate.get(0)));	
		
		request.setAttribute("zhitongche", cons.getContentByDeptId("peixun", 1, 10));
		request.setAttribute("gonggao", cons.getContentByColumnId(gonggao, 1, 5));
		request.setAttribute("daodu", cons.getContentByNearDayIndept("peixun", 1, 20));
		
		request.setAttribute("tongzhi", cs.getListByParentIdForShow(tongzhi,"peixun", 1));
		request.setAttribute("zhichuang", cs.getListByParentIdForShow(zhichuang,"peixun", 1));
		request.setAttribute("yuandi", cs.getListByParentIdForShow(yuandi,"peixun", 1));
		request.setAttribute("jiayuan", cs.getListByParentIdForShow(jiayuan,"peixun", 1));
		request.setAttribute("guanli", cs.getListByParentIdForShow(guanli,"peixun", 1));
		request.setAttribute("zhuanlan", cs.getListByParentIdForShow(zhuanlan,"peixun", 1));
		request.setAttribute("zhisheng", cs.getListByParentIdForShow(zhisheng,"peixun", 1));
		request.setAttribute("ptype",ptype);
		ActionForward af = new ActionForward();
		af.setPath("/dept/peixun/index" + ptype + ".jsp");
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
		
		if(c.getIncludeContent() == 0){	
			request.setAttribute("parentColumn",c);
			List scl = cs.getListByParentIdForShow(c.getColumnId(),"peixun",1);
			if(scl == null || scl.get(0)== null){
				request.setAttribute("errorMessage", "栏目号错误");
				return mapping.findForward("error");
			}
			c = (UlColumn)scl.get(0);
		}else{
			request.setAttribute("parentColumn", cs.getColumnById(c.getParentId()));
		}
		
		List<UlTemplate> listTemplate = cons.getTemplateByColumnId( columnId, 1, "peixun");	
		request.setAttribute("template",(listTemplate.get(0) == null ? (new UlTemplate()) : listTemplate.get(0)));	
		
		if(pageSize == 0)pageSize = listTemplate.get(0).getPageSize();	
				
		request.setAttribute("column", c);		
		request.setAttribute("columnList", cs.getListByParentIdForShow(c.getParentId(), "peixun", 1));
		if(columnId == 318){
			request.setAttribute("contentList", cons.getContentByDeptId("peixun", page, pageSize));
			request.setAttribute("totlePage",cons.getTotlePageByDept("peixun",pageSize));
		}else{
			request.setAttribute("contentList", cons.getContentByColumnId(columnId, page, pageSize));
			request.setAttribute("totlePage",cons.getContentTotlePage(columnId,pageSize));
		}
		request.setAttribute("page",page);
		request.setAttribute("ptype",ptype);
		ActionForward af = new ActionForward();
		af.setPath("/dept/peixun/subpage1" + ptype + ".jsp");
		return af;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

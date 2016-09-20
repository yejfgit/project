package com.ulic.ulweb.ulweb.web.action.dept;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ulic.ulweb.frame.action.BaseAction;
import com.ulic.ulweb.frame.constant.Constant;
import com.ulic.ulweb.ulweb.entity.UlColumn;
import com.ulic.ulweb.ulweb.entity.UlTemplate;
import com.ulic.ulweb.ulweb.service.IUlColumnService;
import com.ulic.ulweb.ulweb.service.IUlContentService;

public class ItAction extends BaseAction{
	public ActionForward itIndex(ActionMapping mapping, ActionForm form, HttpServletRequest request,
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
	
	public ActionForward it(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int columnId = this.getIntValue(request, "columnId", 0);
		int defaultCId = this.getIntValue(request, "scid", 0);
		if(columnId == 0){
			if(request.getAttribute("columnId") == null){
				request.setAttribute("errorMessage", "没有得到columnId这是listAction");
				return mapping.findForward("error");
			}else{
				columnId = ((Integer)request.getAttribute("columnId")).intValue();
			}
		}
		String ptype = this.getStringValue(request, "ptype", "1");	
		String forward = null;
		HttpSession session = request.getSession();
		int rClass = 0;	
		if(session.getAttribute("rClass") != null){
			rClass = (Integer)session.getAttribute("rClass");
		}
		int pageSize = this.getIntValue(request, "pageSize", Constant.indexPageSize); 
		IUlContentService cs = (IUlContentService)this.getService("contentService");
		UlColumn c = cs.getByIdForShow(columnId);
		UlColumn columnSec = null;
		List list = null;
//这里放置特殊页需要的特殊数据
//		if(ptype.equals("4")){
//			request.setAttribute("cSameLevelList", cs.getSameLevelListById(columnId));
//		}
		
		
		if(c.getIncludeContent() == 0){
			List<UlColumn> cl = cs.getListByParentId(columnId, "");
			if(cl == null){
				request.setAttribute("errorMessage", "您所选择的栏目下没有任何栏目或内容");
				return mapping.findForward("error");
			}
			if(defaultCId == 0){
				columnSec = cl.get(0);
				
			}else{
				for(int i = 0; i < cl.size(); i++ ){
					if(defaultCId == cl.get(i).getColumnId()){
						columnSec = cl.get(i);						
						break;
					}
					
//如果没找到一样的，就用第一个，这是为了防止scid出错
					if(i == (cl.size()-1))columnSec = cl.get(0);
				
				}
						
			}
			if(columnSec.getIncludeContent() == 1){
				columnId = columnSec.getColumnId();
				forward = "c2t" + ptype;
			}else{
				columnId = 0;
				forward = "c3t" + ptype;
			}
			request.setAttribute("column", columnSec);
			request.setAttribute("parnetColumn",c);
		}else{
			request.setAttribute("column", c);
			forward = "c1t" + ptype;
		}
		if(columnId != 0){
			int pageSum = cs.getContentTotlePage(columnId, pageSize);
			int page = this.getIntValue(request, "page" , 1);
			if(page > pageSum) page = pageSum;			
			list = cs.getContentListWoContentWOtherClassByCid(columnId,rClass,pageSize,page);	
			request.setAttribute("page", page);
			request.setAttribute("pageSum",pageSum);
		}			
		UlTemplate template = null;
		if(request.getAttribute("template") == null){
//		template = (UlTemplate)(cs.getTemplateByColumnName(c.getOrganId() + c.getColumnName(), c.getOrganId() + "00", 1)).get(0);
		}else{
			template = (UlTemplate)request.getAttribute("template");
		}
		request.setAttribute("template", template);
		request.setAttribute("list", list);
		request.setAttribute("ptype", ptype);
		request.setAttribute("scid", defaultCId);
		
		
		ActionForward af = new ActionForward();
		af.setName("uploadok");
		af.setPath("/dept/1101/" + forward + ".jsp");
		return af;
	}
	
	
}

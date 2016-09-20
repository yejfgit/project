package com.ulic.ulweb.ulweb.web.action;

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
import com.ulic.ulweb.ulweb.service.IUlColumnService;
import com.ulic.ulweb.ulweb.service.IUlContentService;

public class ListAction extends BaseAction{
	public ActionForward zongbu(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//如果得到的是包含内容的栏目，默认的scid将不起作用
		int columnId = this.getIntValue(request, "columnId", 0);
		
		// get column by organId and eId.
		String oId = this.getStringValue(request, "organId", "0000");
		String eId = this.getStringValue(request, "eId", "");
		
		int defaultCId = this.getIntValue(request, "scid", 0);
		if(columnId == 0 && ( oId.equals("") || eId.equals(""))){
			request.setAttribute("errorMessage", "没有得到columnId，也没有organId和eId。这是listAction");
			return mapping.findForward("error");
		} else if (columnId == 0 && !oId.equals("") && !oId.equals("")) {
			IUlColumnService cols = (IUlColumnService)this.getService("columnService");
			columnId = cols.getColumnIdByEId(oId, eId);
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
		
//这里放置特殊页需要的特殊数据
		if(ptype.equals("4")){
			request.setAttribute("cSameLevelList", cs.getSameLevelListById(columnId));
		}
		
		
		if(c.getIncludeContent() == 0){
			List<UlColumn> cl = cs.getListByParentId(columnId, oId);
			if(cl == null){
				request.setAttribute("errorMessage", "您所选择的栏目下没有任何栏目或内容");
				return mapping.findForward("error");
			}
			if(defaultCId == 0){
				request.setAttribute("c",cl.get(0));
			}else{
				for(int i = 0; i < cl.size(); i++ ){
					if(defaultCId == cl.get(i).getColumnId()){
						request.setAttribute("c", cl.get(i));
						columnId = cl.get(i).getColumnId();
						break;
					}
					
//如果没找到一样的，就用第一个，这是为了防止scid出错
					if(i == (cl.size()-1))request.setAttribute("c", cl.get(0));
					columnId = cl.get(0).getColumnId();
				}
						
			}
			request.setAttribute("cp", c);
			request.setAttribute("cl", cl);
			forward = "c2t" + ptype;
		}else{
			request.setAttribute("c", c);
			forward = "c1t" + ptype;
		}
		int pageSum = cs.getContentTotlePage(columnId, pageSize);
		int page = this.getIntValue(request, "page" , 1);
		if(page > pageSum) page = pageSum;			
		List list = cs.getContentListWoContentWOtherClassByCid(columnId,rClass,pageSize,page);		
		request.setAttribute("page", page);
		request.setAttribute("pageSum",pageSum);
		request.setAttribute("list", list);
		request.setAttribute("ptype", ptype);
		request.setAttribute("scid", defaultCId);
		ActionForward af = new ActionForward();
		af.setName("listok");
		af.setPath("/subpage/" + forward + ".jsp");
		return af;
	}
	
	public ActionForward zongbuHaveAtt(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//如果得到的是包含内容的栏目，默认的scid将不起作用
		int isNeedContent = this.getIntValue(request, "con", 0);
		int columnId = this.getIntValue(request, "columnId", 0);
		
		// get column by organId and eId.
		String oId = this.getStringValue(request, "organId", "");
		String eId = this.getStringValue(request, "eId", "");
		
		int defaultCId = this.getIntValue(request, "scid", 0);
		if(columnId == 0 && ( oId.equals("") || eId.equals(""))){
			request.setAttribute("errorMessage", "没有得到columnId，也没有organId和eId。这是listAction");
			return mapping.findForward("error");
		} else if (columnId == 0 && !oId.equals("") && !oId.equals("")) {
			IUlColumnService cols = (IUlColumnService)this.getService("columnService");
			columnId = cols.getColumnIdByEId(oId, eId);
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
		
//这里放置特殊页需要的特殊数据
		if(ptype.equals("4")){
			request.setAttribute("cSameLevelList", cs.getSameLevelListById(columnId));
		}
		
		
		if(c.getIncludeContent() == 0){
			List<UlColumn> cl = cs.getListByParentId(columnId, oId);
			if(cl == null){
				request.setAttribute("errorMessage", "您所选择的栏目下没有任何栏目或内容");
				return mapping.findForward("error");
			}
			if(defaultCId == 0){
				request.setAttribute("c",cl.get(0));
			}else{
				for(int i = 0; i < cl.size(); i++ ){
					if(defaultCId == cl.get(i).getColumnId()){
						request.setAttribute("c", cl.get(i));
						columnId = cl.get(i).getColumnId();
						break;
					}
					
//如果没找到一样的，就用第一个，这是为了防止scid出错
					if(i == (cl.size()-1))request.setAttribute("c", cl.get(0));
					columnId = cl.get(0).getColumnId();
				}
						
			}
			request.setAttribute("cp", c);
			request.setAttribute("cl", cl);
			forward = "c2t" + ptype;
		}else{
			request.setAttribute("c", c);
			forward = "c1t" + ptype;
		}
		int pageSum = cs.getContentTotlePage(columnId, pageSize);
		int page = this.getIntValue(request, "page" , 1);
		if(page > pageSum) page = pageSum;			
		List list = cs.getContentListWithAtt(columnId, isNeedContent, pageSize, page);		
		request.setAttribute("page", page);
		request.setAttribute("pageSum",pageSum);
		request.setAttribute("list", list);
		request.setAttribute("ptype", ptype);
		request.setAttribute("scid", defaultCId);
		ActionForward af = new ActionForward();
		af.setName("listok");
		af.setPath("/subpage/" + forward + ".jsp");
		return af;
	}
}

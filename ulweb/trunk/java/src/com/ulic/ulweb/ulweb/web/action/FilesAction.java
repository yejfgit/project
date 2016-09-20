package com.ulic.ulweb.ulweb.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ulic.ulweb.frame.action.BaseAction;
import com.ulic.ulweb.frame.constant.Constant;
import com.ulic.ulweb.ulweb.service.IFilesService;

public class FilesAction extends BaseAction{
	public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String sp = this.getStringValue(request, "sp","/frame/showoldfiles.jsp");
		int page = this.getIntValue(request, "page", 1);
		int pageSize = this.getIntValue(request, "pageSize", Constant.indexPageSize);
		int columnId = this.getIntValue(request, "columnId", 0);
		String ptype = this.getStringValue(request, "ptype", "ok");
		String keyword = null;
		int keyId = this.getIntValue(request, "keyword",0);	
		switch(keyId){
		case 1 : keyword = "合保人";
		break;
		case 2 : keyword = "合保发";
		break;
		case 3 : keyword = "合保复";
		break;
		case 4 : keyword = "合保办";
		break;
		case 5 : keyword = "合保会纪";
		break;	
		case 11 : keyword = "it";
		break;
		case 12 : keyword = "人力资源部";
		break;
		case 13 : keyword = "办公室";
		break;
		default : keyword = "";
		}
		if(columnId == 0){
			request.setAttribute("errorMessage", "没有得到columnId这是FileAction");
			return mapping.findForward("error");
		}		
		IFilesService fs = (IFilesService)this.getService("filesService");
		List list = null;	
		int pageSum = 1;
		if(keyId == 0){
			pageSum = fs.getByColumnIdforPageSum(columnId, pageSize);
			if(page > pageSum) page = pageSum;
			list = fs.getByColumnId(columnId, page, pageSize);
		}else{
			pageSum = fs.getByColumnIdAndKeywordForPageNum(columnId, keyword, pageSize);
			if(page > pageSum) page = pageSum;
			list = fs.getByColumnIdAndKeyword(columnId, keyword, page, pageSize);
		}
		request.setAttribute("page", page);
		request.setAttribute("pageSum", pageSum);
		request.setAttribute("list", list);
		request.setAttribute("ptype", ptype);
		request.setAttribute("columnId",columnId);
		request.setAttribute("keywordName",keyword);
		request.setAttribute("keyword",keyId);
		
		ActionForward af = new ActionForward();
		af.setName("ok");
		af.setPath(sp);
		return af;
//		return mapping.findForward("showPage");
	}
	
	public ActionForward linkList(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int page = this.getIntValue(request, "page", 1);
		int pageSize = this.getIntValue(request, "pageSize", Constant.indexPageSize);
		int columnId = this.getIntValue(request, "columnId", 0);
		String ptype = this.getStringValue(request, "ptype", "ok");
		String keyword = null;
		
		if(columnId == 0){
			request.setAttribute("errorMessage", "没有得到columnId这是FileAction");
			return mapping.findForward("error");
		}		
		IFilesService fs = (IFilesService)this.getService("filesService");
		List list = null;	
		int pageSum = 1;
	
		pageSum = fs.getByColumnIdforPageSum(columnId, pageSize);
		if(page > pageSum) page = pageSum;
		list = fs.getByColumnId(columnId, page, pageSize);
		
		request.setAttribute("page", page);
		request.setAttribute("pageSum", pageSum);
		request.setAttribute("list", list);
		request.setAttribute("ptype", ptype);
		request.setAttribute("columnId",columnId);
		request.setAttribute("keyword",keyword);
		return mapping.findForward("showDeptPage");
	}
}

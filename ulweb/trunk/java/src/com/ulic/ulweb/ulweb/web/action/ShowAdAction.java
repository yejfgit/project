package com.ulic.ulweb.ulweb.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ulic.ulweb.frame.action.BaseAction;
import com.ulic.ulweb.frame.constant.Constant;
import com.ulic.ulweb.ulweb.entity.UlAttachment;
import com.ulic.ulweb.ulweb.entity.UlContent;
import com.ulic.ulweb.ulweb.service.IUlAttachmentService;
import com.ulic.ulweb.ulweb.service.IUlContentService;

public class ShowAdAction extends BaseAction{

	public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int page = this.getIntValue(request, "page", 0);
		int pageSize = this.getIntValue(request, "pageSize", Constant.listNum);
		IUlContentService cs = (IUlContentService)this.getService("contentService");
		List list = cs.getContentListWoContentWOtherClassByCid(Constant.ad, 1, pageSize, page);
		int totlePage = cs.getContentTotlePage(Constant.ad, pageSize);
		request.setAttribute("list", list);
		request.setAttribute("totlePage", totlePage);
		request.setAttribute("page", page);
		return mapping.findForward("listPage");
	}
	
	
	public ActionForward show(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int cid = this.getIntValue(request, "c", 0);
		IUlAttachmentService as = (IUlAttachmentService)this.getService("attachmentService");
		UlContent c = null;
		if(cid == 0){
//			System.out.print("====" + Constant.ad);
			c = as.getLastContentInColumnId(Constant.ad);
		}else{
			c = as.getContentById(cid);
		}
		if(c != null && c.getAttachmentSum() > 0){
			List<UlAttachment> a = as.getattachmentByContentId(c.getContentId());			
			request.setAttribute("a", a);
		}
		request.setAttribute("c", c);
		return mapping.findForward("showPage");
	}
	
	public ActionForward find(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		return mapping.findForward("listPage");
	}
}

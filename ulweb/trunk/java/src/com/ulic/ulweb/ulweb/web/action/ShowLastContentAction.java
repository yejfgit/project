package com.ulic.ulweb.ulweb.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ulic.ulweb.frame.action.BaseAction;
import com.ulic.ulweb.ulweb.entity.UlContent;
import com.ulic.ulweb.ulweb.service.IUlContentService;

public class ShowLastContentAction  extends BaseAction{
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int columnId = this.getIntValue(request, "c", 0);
		IUlContentService cons = (IUlContentService)this.getService("contentService");		
		UlContent c = cons.getLastContentInColumnId(columnId);	
		if(c == null){
			request.setAttribute("errorMessage", "没有得到content");
			return mapping.findForward("error");
		}	
		ActionForward af = new ActionForward();
		if(c.getHaveContent() != 0){
			String ptype = this.getStringValue(request, "ptype");			
			request.setAttribute("c", c);	
			af.setPath("/frame/showcontent" + ptype + ".jsp");
			return af;
		}else{			
			af.setPath("/show.do?c=" + c.getContentId() + "&a=1");
			return af;
		}
	}
}

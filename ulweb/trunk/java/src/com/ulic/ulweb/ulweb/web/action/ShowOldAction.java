package com.ulic.ulweb.ulweb.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ulic.ulweb.frame.action.BaseAction;
import com.ulic.ulweb.ulweb.entity.Attachment;
import com.ulic.ulweb.ulweb.entity.Files;
import com.ulic.ulweb.ulweb.service.IFilesService;

public class ShowOldAction extends BaseAction{
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int an = this.getIntValue(request, "a", -1);	
		int cId = this.getIntValue(request, "c", 0);
		if(cId == 0){
			request.setAttribute("errormassage", "请求发生异常，未得到请求内容的编号");
			return mapping.findForward("error");
		}
		IFilesService fs = (IFilesService)this.getService("filesService");		
//		System.out.println("--" + an);
		if(an == -1){
			Files f = fs.getById(cId);
			if(f == null){
				request.setAttribute("errormassage", "请求发生异常，您所请求的内容已被删除");
				return mapping.findForward("error");
			}
			request.setAttribute("file", f);
			return mapping.findForward("showContent");
		}else{
//			Attachment a = fs.getByContentId(cId, an);
//			System.out.println("-=-");
//			System.out.println("==" + a.getAttName());
			request.setAttribute("href",fs.getByContentId(cId,an).getAttName());
			return mapping.findForward("showAttachment");
		}		
	}
}

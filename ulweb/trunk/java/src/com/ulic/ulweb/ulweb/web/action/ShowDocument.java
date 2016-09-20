package com.ulic.ulweb.ulweb.web.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ulic.ulweb.frame.action.BaseAction;
import com.ulic.ulweb.frame.constant.Constant;
import com.ulic.ulweb.ulweb.entity.UlContent;
import com.ulic.ulweb.ulweb.entity.UlDocumentModel;
import com.ulic.ulweb.ulweb.service.IUlAttachmentService;
import com.ulic.ulweb.ulweb.service.UtilService;
import com.ulic.ulweb.ulweb.util.UserClassRight;

public class ShowDocument extends BaseAction{
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {	
		int cId = this.getIntValue(request, "c", 0);
		if(cId == 0){
			request.setAttribute("errormassage", "请求发生异常，未得到请求内容的编号");
			return mapping.findForward("error");
		}
		IUlAttachmentService as = (IUlAttachmentService)this.getService("attachmentService");
		UlContent c = as.getContentById(cId);
		if(c == null){
			request.setAttribute("errormassage", "请求发生异常，您所请求的内容已被删除");
			return mapping.findForward("error");
		}
		if(c.getShowOthersClass() > 1){
			if(c.getOrganId().equals(UserClassRight.getUserDept(request))){
				if(c.getShowOrganClass() > UserClassRight.getUserClass(request)){
					request.setAttribute("errormassage", "您没有权限查看此项内容");
					return mapping.findForward("error");
				}
			}else{
				if(c.getShowOthersClass() > UserClassRight.getUserClass(request)){
					request.setAttribute("errormassage", "您没有权限查看此项内容");
					return mapping.findForward("error");
				}
			}			
		}
//		UlDocument d = as.getDocument(c.getContentId());

/*		
		StringBuffer sb = new StringBuffer();
		UtilService us = (UtilService)this.getService("utilService");
		UlDocumentModel dm = us.getDocumentModelById(Constant.documentModel);
		
		sb.append(dm.getHead());	
		sb.append(d.getDocumentNum()); 
		sb.append(dm.getHr1());
		sb.append(d.getDocumentName());
		sb.append(dm.getTitle());
		sb.append(d.getContent());
		sb.append(dm.getSeal());
		sb.append(d.getDate1());
		sb.append(dm.getPage2Blank());
		sb.append(d.getDocumentWord());
		sb.append(dm.getZhutici());
		sb.append(d.getChaosong());
		sb.append(dm.getChaosong());
		sb.append(d.getDayin());
		sb.append(dm.getDayin());
		sb.append(d.getGongdayin());
		sb.append(dm.getGongdayin());
		sb.append(d.getChengban());
		sb.append(dm.getChengban());
		sb.append(d.getDianhua());
		sb.append(dm.getDianhua());
		sb.append(d.getGongsi());
		sb.append(dm.getGongsi());
		sb.append(d.getShijian());
		sb.append(dm.getShijian());
		request.setAttribute("d", sb.toString());	
		
*/
		if(c.getAttachmentSum() == 0){
			request.setAttribute("a","");
		}else{
			StringBuffer sb2 = new StringBuffer();
			sb2.append("此公文包含附件，点击下载<br>");
			for(int i = 1; i < (c.getAttachmentSum() + 1) ; i++ ){
				sb2.append("<a style='color:#3366cc;font-size:16px;' target='_blank' href='show.do?c=");
				sb2.append(c.getContentId());
				sb2.append("&a=" + i);
				sb2.append("' >附件" + i + "</a>&nbsp;&nbsp;");
				
			}
			request.setAttribute("a",sb2.toString());
		}
		request.setAttribute("c", c);
		return mapping.findForward("ok");
		
	}
}

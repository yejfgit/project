package com.ulic.ulweb.ulweb.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ulic.ulweb.frame.action.BaseAction;
import com.ulic.ulweb.frame.constant.Constant;
import com.ulic.ulweb.ulweb.entity.UlChat;
import com.ulic.ulweb.ulweb.service.IUlChatService;

public class ChatAction extends BaseAction{
	public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(request.getParameter("content") == null){
			return mapping.findForward("ok");
		}
		IUlChatService cs = (IUlChatService)this.getService("chatService");
		UlChat c = new UlChat();
		c.setIp(request.getRemoteAddr());
		c.setContent(request.getParameter("content") + "<br>");
		cs.save(c);
		if(Constant.sbcount < 100){
			Constant.sb1.append(c.getContent());
			Constant.sbcount++;
		}else if(Constant.sbcount >= 100 && Constant.sbcount < 200){
			Constant.sb2.append(c.getContent());
			Constant.sbcount = 200;
			Constant.sb1.delete(0, Constant.sb1.length());
		}else if(Constant.sbcount >= 200 && Constant.sbcount < 300){
			Constant.sb2.append(c.getContent());
			Constant.sbcount++;
		}else if(Constant.sbcount >= 300){
			Constant.sb1.append(c.getContent());
			Constant.sbcount = 0;
			Constant.sb2.delete(0, Constant.sb2.length());
		}
		return mapping.findForward("ok");
	}
}

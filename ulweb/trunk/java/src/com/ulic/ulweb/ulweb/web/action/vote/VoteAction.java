package com.ulic.ulweb.ulweb.web.action.vote;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ulic.ulweb.frame.action.BaseAction;
import com.ulic.ulweb.ulweb.entity.UlVoteAdmin;
import com.ulic.ulweb.ulweb.service.IUlVoteAdminService;
import com.ulic.ulweb.ulweb.util.CheckUserRight;

public class VoteAction extends BaseAction{
	public ActionForward addVote(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		
		return mapping.findForward("");
	}
	
	public ActionForward editVote(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		
		return mapping.findForward("");
	}
	
	public ActionForward editQuest(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		
		return mapping.findForward("");
	}
	
	public ActionForward voteQuest(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		
		return mapping.findForward("");
	}
	
	public ActionForward deleteVote(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		
		return mapping.findForward("");
	}
	
	public ActionForward deleteQuest(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		
		return mapping.findForward("");
	}
	
	public ActionForward deleteOption(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		
		return mapping.findForward("");
	}
	
	public ActionForward editOption(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		
		return mapping.findForward("");
	}
	
	public ActionForward addUser(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if( CheckUserRight.checkUser(request) < 2){
			request.setAttribute("errorMessage", "只有管理员才能作此操作");
			return mapping.findForward("error");
		}
		int userId = this.getIntValue(request, "userId", 0);
		if(userId == 0){
			request.setAttribute("errorMessage", "没有得到userId, 这里是voteAction");
			return mapping.findForward("error");
		}
		UlVoteAdmin v = null;
		IUlVoteAdminService vs = (IUlVoteAdminService)this.getService("voteAdminService");
		 v = vs.getByUserId(userId);
		if(v == null){
			v = new UlVoteAdmin();
			v.setUserId(userId);
			v.setUserName(this.getStringValue(request, "userName"));
			v.setVoteRight(this.getIntValue(request, "voteRight", 0));			
			vs.addVoteAdmin(v);
		}else{
			v.setUserName(this.getStringValue(request, "userName"));
			v.setVoteRight(this.getIntValue(request, "voteRight", 0));
			vs.updateVoteAdmin(v);			
		}		
		
		return mapping.findForward("list");
	}
	
	public ActionForward listUser(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	
		if( CheckUserRight.checkUser(request) < 2){
			request.setAttribute("errorMessage", "只有管理员才能作此操作");
			return mapping.findForward("error");
		}
		IUlVoteAdminService vs = (IUlVoteAdminService)this.getService("voteAdminService");
		List<UlVoteAdmin> list = vs.getUserList();
		request.setAttribute("list", list);
		
		
		return mapping.findForward("listPage");
	}
	
	
}

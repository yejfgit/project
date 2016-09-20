package com.ulic.ulweb.ulweb.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ulic.ulweb.frame.action.BaseAction;
import com.ulic.ulweb.frame.constant.Constant;
import com.ulic.ulweb.ulweb.entity.UlReport;
import com.ulic.ulweb.ulweb.service.IUlReportService;

public class ReportAction extends BaseAction{
	public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!request.getRemoteAddr().equals(Constant.ip)){
			request.setAttribute("errorMessage", "只有指定机器才能作此操作");
			return mapping.findForward("error");
		}
		UlReport r = new UlReport();
		r.setPersonal(Constant.gexianbaofei);
		r.setGroup(Constant.tuanxianbaofei);
		r.setBank(Constant.yindaibaofei);	
		r.setIp(request.getRemoteAddr());
		if(request.getParameter("gexian") != null && !request.getParameter("gexian").equals("")){
			
			r.setPersonal(Integer.parseInt(request.getParameter("gexian").trim()));
		}
		if(request.getParameter("tuanxian") != null && !request.getParameter("tuanxian").equals("")){
			
			r.setGroup(Integer.parseInt(request.getParameter("tuanxian").trim()));
		}
		if(request.getParameter("yindai") != null && !request.getParameter("yindai").equals("")){
			
			r.setBank(Integer.parseInt(request.getParameter("yindai").trim()));
		}
		IUlReportService rs = (IUlReportService)this.getService("reportService");
		rs.save(r);
		Constant.gexianbaofei = r.getPersonal();
		Constant.tuanxianbaofei = r.getGroup();
		Constant.yindaibaofei = r.getBank();
		request.setAttribute("errorMessage", "修改成功");
		return mapping.findForward("error");
	}
	
	public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		IUlReportService rs = (IUlReportService)this.getService("reportService");
		request.setAttribute("list", rs.getAllReport());
		return mapping.findForward("editPage");
	}
	
	public ActionForward getReport(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		IUlReportService rs = (IUlReportService)this.getService("reportService");
		UlReport r = rs.getReport();
		Constant.gexianbaofei = r.getPersonal();
		Constant.tuanxianbaofei = r.getGroup();
		Constant.yindaibaofei = r.getBank();
		request.setAttribute("errorMessage", "读取成功");
		return mapping.findForward("error");
	}
	
}

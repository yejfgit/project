package com.ulic.ulweb.ulweb.web.action.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.ulic.ulweb.frame.action.BaseAction;
import com.ulic.ulweb.frame.constant.Constant;
import com.ulic.ulweb.ulweb.entity.UlTemplate;
import com.ulic.ulweb.ulweb.service.IUlColumnService;
import com.ulic.ulweb.ulweb.service.IUlContentService;
import com.ulic.ulweb.ulweb.util.CheckUserRight;
import com.ulic.ulweb.ulweb.util.ResourceUtil;

public class DeptPageConfigAction extends BaseAction{

	public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(CheckUserRight.checkUser(request) < 2){
			request.setAttribute("errorMessage", "只有不受限管理员才能作此操作");
			return mapping.findForward("error");
		}
		String listPage = this.getStringValue(request, "ptype");
		HttpSession session = request.getSession();
		String dept = (String)session.getAttribute("dept");
		IUlContentService cs = (IUlContentService)this.getService("contentService");
		List list = cs.getTemplateListByDeptName(dept, 1);
		request.setAttribute("list",list);
		ActionForward af = new ActionForward();
		af.setName("ok");
		af.setPath("/admin/template/listtemplate" + listPage  + ".jsp");		
		return af;	
	}

	public ActionForward bAdd(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(CheckUserRight.checkUser(request) < 2){
			request.setAttribute("errorMessage", "只有不受限管理员才能作此操作");
			return mapping.findForward("error");
		}
		int templatePtype = this.getIntValue(request, "templatePtype", 9);	
		HttpSession session = request.getSession();
		String dept = (String)session.getAttribute("dept");
		if(templatePtype != 9){
			IUlColumnService cs = (IUlColumnService)this.getService("columnService");
			List list = cs.getListByColumnLevelAndDept(templatePtype, dept, 0);		
			request.setAttribute("list",list);
		}
		request.setAttribute("templatePtype",templatePtype);
		ActionForward af = new ActionForward();
		af.setName("ok");
		af.setPath("/admin/template/" + dept + "/addtemplate" + templatePtype + ".jsp");		
		return af;	
	}
	
	
	public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(CheckUserRight.checkUser(request) < 2){
			request.setAttribute("errorMessage", "只有不受限管理员才能作此操作");
			return mapping.findForward("error");
		}		
		
		HttpSession session = request.getSession();
		String dept = (String)session.getAttribute("dept");
		
		String templateName = this.getStringValue(request, "templateName");
		int templatePtype = this.getIntValue(request, "templatePtype", 0);
		String templateDesc = this.getStringValue(request, "templateDesc");
		String css = this.getStringValue(request, "css");
		int pageSize = this.getIntValue(request, "pageSize", 10);
		int columnId = this.getIntValue(request, "columnId", 0);
		if(templatePtype == 0 || columnId == 0){
			request.setAttribute("errorMessage", "没有得到templatePtype或columnId");
			return mapping.findForward("error");
		}
/*			071113 delete the code. 使这一段可用于css或js	
		if(css.length() < 10){
			css = "";
		}else{
			if(css.indexOf("<style") == -1){
				css = "<style>" + css + "</style>";
			}
		}
*/		
		IUlContentService cs = (IUlContentService)this.getService("contentService");
		UlTemplate t = new UlTemplate();
		
		t.setTemplateName(templateName);
		t.setTemplatePtype(templatePtype);
		t.setColumnId(columnId);
		t.setTemplateDept(dept);
		t.setTemplateDesc(templateDesc);
		t.setCss(css);
		t.setUserId((String)session.getAttribute("name")); 
		t.setIsDelete(0);
		t.setPageSize(pageSize);		
		t.setPic1(this.getStringValue(request, "pic1"));
		t.setPic2(this.getStringValue(request, "pic2"));
		t.setPic3(this.getStringValue(request, "pic3"));
		t.setPic4(this.getStringValue(request, "pic4"));
		t.setPic5(this.getStringValue(request, "pic5"));
		t.setPic6(this.getStringValue(request, "pic6"));		
		t.setFlash(this.getStringValue(request, "flash"));
		cs.saveTemplate(t);
		request.setAttribute("errorMessage", "已经成功新建模板");
		return mapping.findForward("error");	
	}
	
	public ActionForward bEdit(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(CheckUserRight.checkUser(request) < 2){
			request.setAttribute("errorMessage", "只有不受限管理员才能作此操作");
			return mapping.findForward("error");
		}
		int templateId = this.getIntValue(request, "templateId", 0);
		if(templateId == 0){
			request.setAttribute("errorMessage", "没有得到templateId,这里是DeptPageConfigAction的add");
			return mapping.findForward("error");
		}
		IUlContentService cs = (IUlContentService)this.getService("contentService");
		UlTemplate t = cs.getTemplateListByid(templateId);
		request.setAttribute("template",t);
		ActionForward af = new ActionForward();
		af.setName("ok");
		af.setPath("/admin/template/" + t.getTemplateDept() + "/edittemplate" + t.getTemplatePtype() + ".jsp");		
		return af;	
	}
	
	public ActionForward edit(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(CheckUserRight.checkUser(request) < 2){
			request.setAttribute("errorMessage", "只有不受限管理员才能作此操作");
			return mapping.findForward("error");
		}
		int templateId = this.getIntValue(request, "templateId", 0);
		if(templateId == 0){
			request.setAttribute("errorMessage", "没有得到templateId,这里是DeptPageConfigAction的add");
			return mapping.findForward("error");
		}
		IUlContentService cs = (IUlContentService)this.getService("contentService");
		UlTemplate t = cs.getTemplateListByid(templateId);
		if(t == null){
			request.setAttribute("errorMessage", "没有得到template,这里是DeptPageConfigAction的edit");
			return mapping.findForward("error");
		}	
		
		String css = this.getStringValue(request, "css");
	
/*	071107 delete the code. 使这一段可用于css或js
 * 		
		if(css.length() < 10){
			css = "";
		}else{
			if(css.indexOf("<style") == -1){
				css = "<style>" + css + "</style>";
			}
		}
*/		
		t.setTemplateName(this.getStringValue(request, "templateName"));
		t.setTemplateDesc(this.getStringValue(request, "templateDesc"));
		t.setCss(css);
		t.setPageSize(this.getIntValue(request, "pageSize", t.getPageSize()));		
		t.setPic1(this.getStringValue(request, "pic1"));
		t.setPic2(this.getStringValue(request, "pic2"));
		t.setPic3(this.getStringValue(request, "pic3"));
		t.setPic4(this.getStringValue(request, "pic4"));
		t.setPic5(this.getStringValue(request, "pic5"));
		t.setPic6(this.getStringValue(request, "pic6"));		
		t.setFlash(this.getStringValue(request, "flash"));
		
		cs.editTemplate(t);
		return mapping.findForward("list");	
	}
	
	public ActionForward uploadPic(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(CheckUserRight.checkUser(request) < 2){
			request.setAttribute("errorMessage", "只有不受限管理员才能作此操作");
			return mapping.findForward("error");
		}
		if( CheckUserRight.checkUser(request) == 0){
			request.setAttribute("errorMessage", "只有管理员才能作此操作");
			return mapping.findForward("error");
		}	
		HttpSession session = request.getSession();		
		SmartUpload su = new SmartUpload();
		su.initialize(this.getServlet().getServletConfig(), request, response);
		Request req = su.getRequest();					
//		此外可设置上传文件的大小 		su.setMaxFileSize(10*1024*1024);		
		su.upload();		
		Files files = su.getFiles();	
		File file = files.getFile(0);
		String path = Constant.getdeptPath(((String)session.getAttribute("dept")));
		path = ResourceUtil.getFilesRootDir() + path.substring(path.indexOf("files/"), path.length());
		java.io.File f = new java.io.File(path);
		if (!f.exists()) {
			f.mkdirs();
		}
		String subpath = path.substring(path.indexOf("files/"), path.length());
		if(!file.isMissing()){
			int ran = ((int)(Math.random() * 100000));
			file.saveAs(path + ran + "." + file.getFileExt(),SmartUpload.SAVE_PHYSICAL);
			request.setAttribute("path",(subpath + ran + "." + file.getFileExt()));
			request.setAttribute("name",req.getParameter("name"));
			return mapping.findForward("uploadPicOk");	
		}else{
			request.setAttribute("errorMessage", "文件上传不成功");
			return mapping.findForward("error");	
		}
		
	}
	
	
	public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(CheckUserRight.checkUser(request) < 2){
			request.setAttribute("errorMessage", "只有不受限管理员才能作此操作");
			return mapping.findForward("error");
		}
		int templateId = this.getIntValue(request, "templateId", 0);
		
		if(templateId == 0){
			request.setAttribute("errorMessage", "没有得到templateId,这里是DeptPageConfigAction的add");
			return mapping.findForward("error");
		}
		IUlContentService cs = (IUlContentService)this.getService("contentService");
		UlTemplate t = cs.getTemplateListByid(templateId);
		if(t == null){
			request.setAttribute("errorMessage", "没有得到template,这里是DeptPageConfigAction的edit");
			return mapping.findForward("error");
		}else{
			int isDelete = this.getIntValue(request, "d", (t.getIsDelete() == 0 ? 1 : 0));
			cs.deleteTemplate(templateId, isDelete);
		}		
		
		return mapping.findForward("list");	
	}
	
}

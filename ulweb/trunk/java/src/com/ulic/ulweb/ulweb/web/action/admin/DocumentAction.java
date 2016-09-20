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
import com.ulic.ulweb.ulweb.entity.UlAttachment;
import com.ulic.ulweb.ulweb.entity.UlColumn;
import com.ulic.ulweb.ulweb.entity.UlContent;
import com.ulic.ulweb.ulweb.entity.UlDocumentModel;
import com.ulic.ulweb.ulweb.service.IUlAttachmentService;
import com.ulic.ulweb.ulweb.service.IUlColumnService;
import com.ulic.ulweb.ulweb.service.IUlContentService;
import com.ulic.ulweb.ulweb.service.UtilService;
import com.ulic.ulweb.ulweb.util.CheckUserRight;
import com.ulic.ulweb.ulweb.util.GetColumns;
import com.ulic.ulweb.ulweb.util.ResourceUtil;
import com.ulic.ulweb.ulweb.web.action.IndexAction;

public class DocumentAction extends BaseAction{
	public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int adminLevel = CheckUserRight.checkUser(request);
		if( adminLevel < 9){
			request.setAttribute("errorMessage", "只有超级管理员才能作此操作");
			return mapping.findForward("error");
		}
		int page = this.getIntValue(request, "page", 1);		
		int pageSize = this.getIntValue(request, "pageSize", Constant.listNum);
//070606做过修改，改为以公文中的栏目来查询
		int columnId = this.getIntValue(request, "columnId", 0);
//		if(request.getParameter("page") != null) page = Integer.parseInt(request.getParameter("page"));
		IUlContentService cs = (IUlContentService)this.getService("contentService");
		int pageSum = cs.getContentTotlePage(columnId, pageSize);
		if(page > pageSum) page = pageSum;
		List l = cs.getListByColumnIdDocument(columnId, pageSize, page);
		request.setAttribute("columnId",columnId);
		request.setAttribute("list", l);		
		request.setAttribute("pageSum", pageSum);
		request.setAttribute("pageNow", page);
		return mapping.findForward("documentList");
	}
	
	public ActionForward bAdd(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if( CheckUserRight.checkUser(request) == 0){
			request.setAttribute("errorMessage", "只有管理员才能作此操作");
			return mapping.findForward("error");
		}	
		IUlColumnService cs = (IUlColumnService)this.getService("columnService");
		List listc = cs.getColumnsByParentId(Constant.gongwen, "0000");
		request.setAttribute("listColumn", listc);		
		return mapping.findForward("addPage");
	}
	
	public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if( CheckUserRight.checkUser(request) == 0){
			request.setAttribute("errorMessage", "只有管理员才能作此操作");
			return mapping.findForward("error");
		}			
		
		HttpSession session = request.getSession();	
		UlContent c = new UlContent();	
		int columnId = this.getIntValue(request, "columnId", 0);
		if(columnId == 0){
			request.setAttribute("errorMessage", "没有得到columnId,这里是columnAction的add");
			return mapping.findForward("error");
		}
		IUlContentService cs = (IUlContentService)this.getService("contentService");		
		UlColumn uc = cs.getByIdForShow(columnId);
		c.setColumnId(columnId);
		c.setContent(this.getStringValue(request, "content"));
		c.setContentName(this.getStringValue(request, "contentName"));
		c.setIsQuickLink(this.getIntValue(request, "isQuickLink", 0));
		c.setKeyWord(uc.getColumnName());
		c.setShowOrganClass(this.getIntValue(request, "showToOrgan", 0));
		c.setShowOthersClass(this.getIntValue(request, "showToOther", 0));
		c.setUploadUser((String)session.getAttribute("name"));
		c.setOrganId("0000");
		c.setDocumentNum( this.getStringValue(request, "documentNum"));
		c.setDocumentWord(this.getStringValue(request, "documentWord"));
		c.setAttachmentSum(0);		
		if(request.getParameter("content") == ""){
			c.setHaveContent(0);
		}else{
			c.setHaveContent(1);
		}
		
		int contentId = cs.addContentDocument(c);				
		request.setAttribute("contentId", contentId);
	
//		080410 add 增加栏目时更新列表
		IndexAction indexa = new IndexAction();
		indexa.initList();
		
		
		if(request.getParameter("att").equals("1")){			
			return mapping.findForward("addAPage");
		}else{
			return mapping.findForward("list");
		}
		
	}
/*	
	public ActionForward add070116(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if( CheckUserRight.checkUser(request) == 0){
			request.setAttribute("errorMessage", "只有管理员才能作此操作");
			return mapping.findForward("error");
		}			
		
		HttpSession session = request.getSession();	
		UlContent c = new UlContent();	
		c.setColumnId(Constant.gongwen);
//		c.setContent(request.getParameter("content"));
		c.setContentName(this.getStringValue(request, "documentName"));
//		c.setIsQuickLink(this.getIntValue(request, "isQuickLink", 0));
		c.setKeyWord(this.getStringValue(request, "documentWord"));
		c.setShowOrganClass(this.getIntValue(request, "showToOrgan",0));
		c.setShowOthersClass(this.getIntValue(request, "showToOther",0));
		c.setUploadUser((String)session.getAttribute("name"));
		c.setOrganId("0000");
		c.setDocumentNum(this.getStringValue(request, "documentNum"));
		c.setDocumentWord(this.getStringValue(request, "documentWord"));	
		c.setAttachmentSum(0);			
		c.setHaveContent(1);
//		UtilService us = (UtilService)this.getService("utilService");
//		UlDocumentModel dm = us.getDocumentModelById(Constant.documentModel);
		UlDocument d = new UlDocument();
		d.setDocumentNum(this.getStringValue(request, "documentNum"));
		d.setDocumentName(this.getStringValue(request, "documentName"));
		d.setContent(this.getStringValue(request, "content"));
		d.setDate1(this.getStringValue(request, "date1"));
		d.setDocumentWord(this.getStringValue(request, "documentWord"));
		d.setChaosong(this.getStringValue(request, "chaosong"));
		d.setDayin(this.getStringValue(request, "dayin"));
		d.setGongdayin(this.getStringValue(request, "gongdayin"));
		d.setChengban(this.getStringValue(request, "chengban"));
		d.setDianhua(this.getStringValue(request, "dianhua"));
		d.setGongsi(this.getStringValue(request, "gongsi"));
		d.setShijian(this.getStringValue(request, "shijian"));	
		c.setContent("");
			
		IUlContentService cs = (IUlContentService)this.getService("contentService");
		int contentId = cs.addContentDocument(c);	
		d.setDocumentId(contentId);
		cs.addDocument(d);
		request.setAttribute("contentId", contentId);
		
		if(request.getParameter("att").equals("1")){			
			return mapping.findForward("addAPage");
		}else{
			return mapping.findForward("list");
		}
		
	}
*/	
	
	public ActionForward bEdit(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int adminLevel = CheckUserRight.checkUser(request);
		if( adminLevel < 9){
			request.setAttribute("errorMessage", "只有管理员才能作此操作");
			return mapping.findForward("error");
		}
		int contentId = this.getIntValue(request, "cId", 0);
		if(contentId == 0){
			request.setAttribute("errorMessage", "没有得到Id这里是DocumentAction的edit");
			return mapping.findForward("error");
		}
		IUlContentService cs = (IUlContentService)this.getService("contentService");
		
		UlContent c = cs.getContentById(contentId);
//		UlDocument d = cs.getDocument(contentId);
		request.setAttribute("c",c);
//		request.setAttribute("d",d);
		return mapping.findForward("editPage");
	}
	
	
	public ActionForward edit(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if( CheckUserRight.checkUser(request) == 0){
			request.setAttribute("errorMessage", "只有管理员才能作此操作");
			return mapping.findForward("error");
		}			
		int contentId = this.getIntValue(request, "contentId", 0);
		if(contentId == 0){
			request.setAttribute("errorMessage", "没有得到Id这里是DocumentAction的edit");
			return mapping.findForward("error");
		}
		HttpSession session = request.getSession();	
		IUlContentService cs = (IUlContentService)this.getService("contentService");
		UlContent c = cs.getContentById(contentId);	
//		c.setColumnId(Constant.gongwen);
//		c.setContent(request.getParameter("content"));
		c.setContentName(this.getStringValue(request, "contentName"));
		c.setKeyWord(this.getStringValue(request, "documentWord"));
		c.setShowOrganClass(this.getIntValue(request, "showToOrgan", 0));
		c.setShowOthersClass(this.getIntValue(request, "showToOther", 0));
		c.setUploadUser((String)session.getAttribute("name"));
		c.setDocumentNum(this.getStringValue(request, "documentNum"));
		c.setDocumentWord(this.getStringValue(request, "documentWord"));	
//		UtilService us = (UtilService)this.getService("utilService");
//		UlDocumentModel dm = us.getDocumentModelById(Constant.documentModel);
//		UlDocument d = cs.getDocument(contentId);		
		c.setContent(this.getStringValue(request, "content"));
		String attDel = this.getStringValue(request, "attDel");
		if(!attDel.equals("")){
			while(attDel.indexOf(",,") > -1){
				attDel = attDel.replace(",,", ",");
			}
			if(attDel.indexOf(",") == 0 && attDel.length() > 1){
				attDel = attDel.substring(1, (attDel.length()));	
				IUlAttachmentService as = (IUlAttachmentService)this.getService("attachmentService");
				if(as.delete(c.getContentId(), attDel) == 0){
					request.setAttribute("errorMessage", "删除附件时出现问题");
					return mapping.findForward("error");
				}
			}
		}
		c.setAttachmentSum(this.getIntValue(request, "attSum", 0));
		int tc = cs.updateContentDocument(c);
//		System.out.print("====content update ok" );
		if(tc == 0){
			request.setAttribute("errorMessage", "主内容项更新不成功");
			return mapping.findForward("error");
		}
//		080410 add 增加栏目时更新列表
		IndexAction indexa = new IndexAction();
		indexa.initList();
		
		
		request.setAttribute("contentId", contentId);
		request.setAttribute("attSum", c.getAttachmentSum());
		if(request.getParameter("att").equals("1")){			
			return mapping.findForward("addAPage");
		}else{
			return mapping.findForward("list");
		}
		
	}
	
/*	
	
	public ActionForward edit070116(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if( CheckUserRight.checkUser(request) == 0){
			request.setAttribute("errorMessage", "只有管理员才能作此操作");
			return mapping.findForward("error");
		}			
		int contentId = this.getIntValue(request, "contentId", 0);
		if(contentId == 0){
			request.setAttribute("errorMessage", "没有得到Id这里是DocumentAction的edit");
			return mapping.findForward("error");
		}
		HttpSession session = request.getSession();	
		IUlContentService cs = (IUlContentService)this.getService("contentService");
		UlContent c = cs.getContentById(contentId);	
//		c.setColumnId(Constant.gongwen);
//		c.setContent(request.getParameter("content"));
		c.setContentName(this.getStringValue(request, "documentName"));
		c.setKeyWord(this.getStringValue(request, "documentWord"));
		c.setShowOrganClass(this.getIntValue(request, "showToOrgan", 0));
		c.setShowOthersClass(this.getIntValue(request, "showToOther", 0));
		c.setUploadUser((String)session.getAttribute("name"));
		c.setDocumentNum(this.getStringValue(request, "documentNum"));
		c.setDocumentWord(this.getStringValue(request, "documentWord"));	
//		UtilService us = (UtilService)this.getService("utilService");
//		UlDocumentModel dm = us.getDocumentModelById(Constant.documentModel);
		UlDocument d = cs.getDocument(contentId);
		d.setDocumentNum(this.getStringValue(request, "documentNum"));
		d.setDocumentName(this.getStringValue(request, "documentName"));
		d.setContent(this.getStringValue(request, "content"));
		d.setDate1(this.getStringValue(request, "date1"));
		d.setDocumentWord(this.getStringValue(request, "documentWord"));
		d.setChaosong(this.getStringValue(request, "chaosong"));
		d.setDayin(this.getStringValue(request, "dayin"));
		d.setGongdayin(this.getStringValue(request, "gongdayin"));
		d.setChengban(this.getStringValue(request, "chengban"));
		d.setDianhua(this.getStringValue(request, "dianhua"));
		d.setGongsi(this.getStringValue(request, "gongsi"));
		d.setShijian(this.getStringValue(request, "shijian"));	
		c.setContent("");
		String attDel = this.getStringValue(request, "attDel");
		if(!attDel.equals("")){
			while(attDel.indexOf(",,") > -1){
				attDel = attDel.replace(",,", ",");
			}
			if(attDel.indexOf(",") == 0 && attDel.length() > 1){
				attDel = attDel.substring(1, (attDel.length()));	
				IUlAttachmentService as = (IUlAttachmentService)this.getService("attachmentService");
				if(as.delete(c.getContentId(), attDel) == 0){
					request.setAttribute("errorMessage", "删除附件时出现问题");
					return mapping.findForward("error");
				}
			}
		}
		c.setAttachmentSum(this.getIntValue(request, "attSum", 0));
		int tc = cs.updateContentDocument(c);
//		System.out.print("====content update ok" );
		int td = cs.updateDocument(d);
		if(tc == 0){
			request.setAttribute("errorMessage", "主内容项更新不成功");
			return mapping.findForward("error");
		}else if(td == 0){
			request.setAttribute("errorMessage", "附件更新不成功");
			return mapping.findForward("error");
		}
		request.setAttribute("contentId", contentId);
		request.setAttribute("attSum", c.getAttachmentSum());
		if(request.getParameter("att").equals("1")){			
			return mapping.findForward("addAPage");
		}else{
			return mapping.findForward("list");
		}
		
	}
	
*/	
	
	public ActionForward addHtml(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if( CheckUserRight.checkUser(request) == 0){
			request.setAttribute("errorMessage", "只有管理员才能作此操作");
			return mapping.findForward("error");
		}			
		
		HttpSession session = request.getSession();	
		UlContent c = new UlContent();	
		c.setColumnId(Constant.gongwen);
		c.setContent(request.getParameter("content"));
		c.setContentName(request.getParameter("contentName"));
		c.setIsQuickLink(Integer.parseInt(request.getParameter("isQuickLink")));
		c.setKeyWord(request.getParameter("keyWord"));
		c.setShowOrganClass(Integer.parseInt(request.getParameter("showToOrgan")));
		c.setShowOthersClass(Integer.parseInt(request.getParameter("showToOther")));
		c.setUploadUser((String)session.getAttribute("name"));
		c.setOrganId("0000");
		c.setDocumentNum(request.getParameter("documentNum"));
		c.setDocumentWord(request.getParameter("documentWord"));
		c.setAttachmentSum(0);		
		if(request.getParameter("content") == ""){
			c.setHaveContent(0);
		}else{
			c.setHaveContent(1);
		}
		IUlContentService cs = (IUlContentService)this.getService("contentService");
		int contentId = cs.addContent(c);				
		request.setAttribute("contentId", contentId);
		return mapping.findForward("addAPage");
		
	}
		
/*	
	public ActionForward addAttachment070116(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if( CheckUserRight.checkUser(request) == 0){
			request.setAttribute("errorMessage", "只有管理员才能作此操作");
			return mapping.findForward("error");
		}		
		SmartUpload su = new SmartUpload();
		su.initialize(this.getServlet().getServletConfig(), request, response);
		Request req = su.getRequest();					
//		此外可设置上传文件的大小 		su.setMaxFileSize(10*1024*1024);		
		su.upload();		
		Files files = su.getFiles();	
		File file = null;
		int contentId = Integer.parseInt(req.getParameter("contentId"));
		String path = Constant.getdeptPath("gongwen");
		java.io.File f = new java.io.File(path);
		if (!f.exists()) {
			f.mkdirs();
		}
		System.out.print(path);
		String subpath = path.substring(path.indexOf("files/"), path.length());
		IUlAttachmentService as = (IUlAttachmentService)this.getService("attachmentService");
		UlAttachment a = new UlAttachment();	
		int fileNum = 0;		
		for(int i = 0; i < files.getCount(); i++){
		
			file = files.getFile(i);
			if(!file.isMissing()){
				fileNum++;			
				file.saveAs(path + contentId + fileNum + "." + file.getFileExt(),SmartUpload.SAVE_PHYSICAL);
				a.setAttachmentOrder(fileNum);
				a.setAttachmentPath("gongwen/" + subpath + contentId + fileNum + ".pdf");
				a.setContentId(contentId);
				a.setIsdelete(0);
				a.setShowName(file.getFileName());							
				a.setAttachmentType(2);				
				as.addAttachment(a);
			}
		}		
		as.updateAttachmentSum(contentId, fileNum);
		return mapping.findForward("list");
	}
//没存名字的,为中文名使用的方法
	public ActionForward addAttachment070410(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//		System.out.print("==adda start");
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
		File file = null;
		int contentId = Integer.parseInt(req.getParameter("contentId"));
//		System.out.print("=====" + contentId + "----" + request.getParameter("contentId"));
		String path = Constant.getdeptPath(((String)session.getAttribute("dept")));
		
		String subpath = path.substring(path.indexOf("files/"), path.length());
		IUlAttachmentService as = (IUlAttachmentService)this.getService("attachmentService");
		UlAttachment a = new UlAttachment();	
		int fileNum = req.getParameter("attSum") == null ? 0 : Integer.parseInt(req.getParameter("attSum"));					
		int ran = 0;
		for(int i = 0; i < files.getCount(); i++){
		
			file = files.getFile(i);
//			System.out.println("====" + new String(file.getFieldName().getBytes("gbk"),"gb2132"));
			if(!file.isMissing()){				
				fileNum++;		
				ran = ((int)(Math.random() * 100000));
				java.io.File f = new java.io.File(path + ran);
				if (!f.exists()) {
					f.mkdirs();
				}
				file.saveAs(path +  ran + "/" + file.getFileName() ,SmartUpload.SAVE_PHYSICAL);
				a.setAttachmentOrder(fileNum);
				a.setAttachmentPath(subpath + ran + "/" );
				a.setContentId(contentId);
				a.setIsdelete(0);
				a.setShowName(file.getFileName());		
				if(file.getFileExt().equals("gif") || file.getFileExt().equals("jpg") ||
						file.getFileExt().equals("png") ||file.getFileExt().equals("bmp") ){
					a.setAttachmentType(1);					
				}else if(file.getFileExt().equals("txt") ||file.getFileExt().equals("doc")){					
					a.setAttachmentType(2);
				}else{
					a.setAttachmentType(0);
				}
				as.addAttachment(a);
			}
		}		
//		request.setAttribute("columnId", Integer.parseInt(req.getParameter("columnId")));
//		request.setAttribute("deptId", req.getParameter("deptId"));	
		as.updateAttachmentSum(contentId, fileNum);
//		System.out.print("++adda end");
		return mapping.findForward("list");
	}
*/	

	public ActionForward addAttachment(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//		System.out.print("==adda start");
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
		File file = null;
		int contentId = Integer.parseInt(req.getParameter("contentId"));
//		System.out.print("=====" + contentId + "----" + request.getParameter("contentId"));
		String path = Constant.getdeptPath(((String)session.getAttribute("dept")));
		path = ResourceUtil.getFilesRootDir() + path.substring(path.indexOf("files/"), path.length());
			
		java.io.File f = new java.io.File(path);
		if (!f.exists()) {
			f.mkdirs();
		}
		String subpath = path.substring(path.indexOf("files/"), path.length());
		IUlAttachmentService as = (IUlAttachmentService)this.getService("attachmentService");
		UlAttachment a = new UlAttachment();	
		int fileNum = req.getParameter("attSum") == null ? 0 : Integer.parseInt(req.getParameter("attSum"));	
		int ran = 0;
		for(int i = 0; i < files.getCount(); i++){
		
			file = files.getFile(i);
			if(!file.isMissing()){
				fileNum++;		
				ran = ((int)(Math.random() * 100000));
				file.saveAs(path + contentId + ran + "." + file.getFileExt(),SmartUpload.SAVE_PHYSICAL);
				a.setAttachmentOrder(fileNum);
				a.setAttachmentPath(subpath + contentId + ran + "." + file.getFileExt());
				a.setContentId(contentId);
				a.setIsdelete(0);
				a.setShowName(new String(file.getFileName().getBytes("gbk"),"gbk"));		
				if(file.getFileExt().equals("gif") || file.getFileExt().equals("jpg") ||
						file.getFileExt().equals("png") ||file.getFileExt().equals("bmp") ){
					a.setAttachmentType(1);					
				}else if(file.getFileExt().equals("txt") ||file.getFileExt().equals("doc")){					
					a.setAttachmentType(2);
				}else{
					a.setAttachmentType(0);
				}
				as.addAttachment(a);
			}
		}	
//		request.setAttribute("columnId", Integer.parseInt(req.getParameter("columnId")));
//		request.setAttribute("deptId", req.getParameter("deptId"));	
		as.updateAttachmentSum(contentId, fileNum);
//		System.out.print("++adda end");
		
//		080410 add 增加栏目时更新列表
		IndexAction indexa = new IndexAction();
		indexa.initList();
		
		ActionForward af = new ActionForward();			
		af.setName("listD");
		af.setPath("/admin/document.do?method=getDocumentList&columnId=" + req.getParameter("columnId"));
		return af;
	}
	
	
	public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if( CheckUserRight.checkUser(request) == 0){
			request.setAttribute("errorMessage", "只有管理员才能作此操作");
			return mapping.findForward("error");
		}
		if(request.getParameter("contentId") == null){
			request.setAttribute("errorMessage", "没有从request里得到contentId,这里是content的delete方法");
			return mapping.findForward("error");
		}		
		int contentId = this.getIntValue(request, "contentId", 0);
		IUlContentService cs = (IUlContentService)this.getService("contentService");
		int i = cs.daleteContent(contentId);
		if(i == 0){
			request.setAttribute("errorMessage", "要删除的内容在数据库里不存在,这里是content的delete方法");
			return mapping.findForward("error");
		}
//		080410 add 增加栏目时更新列表
		IndexAction indexa = new IndexAction();
		indexa.initList();
		
		int page = this.getIntValue(request, "page", 1);		
		int pageSize = this.getIntValue(request, "pageSize", Constant.listNum);
		int pageSum = cs.getContentTotlePage(Constant.gongwen, pageSize);
		if(page > pageSum) page = pageSum;
		List l = cs.getContentByColumnIdDocument(Constant.gongwen, pageSize, page);
		request.setAttribute("list", l);
		request.setAttribute("pageSum", pageSum);
		request.setAttribute("pageNum", page);
		return mapping.findForward("documentList");		
	}
	
	
	public ActionForward addModel(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if( CheckUserRight.checkUser(request) == 0){
			request.setAttribute("errorMessage", "只有管理员才能作此操作");
			return mapping.findForward("error");
		}
		UlDocumentModel d = new UlDocumentModel();
		int id = this.getIntValue(request, "modelId", 0);
		d.setId(id);
		if(id == 0){
			request.setAttribute("errorMessage", "没有得到modelId, 这里是documentAction的addModel");
			return mapping.findForward("error");
		}
		d.setHead(this.getStringValue(request, "hhead"));
		d.setTitle(this.getStringValue(request, "htitle"));
		d.setHr1(this.getStringValue(request, "hhr1"));
		d.setSeal(this.getStringValue(request, "hseal"));
		d.setPage2Blank(this.getStringValue(request, "h2pageblank"));
		d.setZhutici(this.getStringValue(request, "hzhutici"));
		d.setChaosong(this.getStringValue(request, "hchaosong"));
		d.setDayin(this.getStringValue(request, "hdayin"));
		d.setGongdayin(this.getStringValue(request, "hgongdayin"));
		d.setChengban(this.getStringValue(request, "hchengban"));
		d.setDianhua(this.getStringValue(request, "hdianhua"));
		d.setGongsi(this.getStringValue(request, "hgongsi"));
		d.setShijian(this.getStringValue(request, "shijian"));
		d.setBottom(this.getStringValue(request, "hbottom"));
		d.setAdd1(this.getStringValue(request, "hadd1"));
		d.setAdd2(this.getStringValue(request, "hadd2"));
		d.setAdd3(this.getStringValue(request, "hadd3"));	
		
		UtilService us = (UtilService)this.getService("utilService");
		us.addDocumentModel(d);
		request.setAttribute("errorMessage", "添加成功");
		return mapping.findForward("listModel");
	}
	
	public ActionForward bEditModel(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if( CheckUserRight.checkUser(request) == 0){
			request.setAttribute("errorMessage", "只有管理员才能作此操作");
			return mapping.findForward("error");
		}
		int id = this.getIntValue(request, "modelId", 0);
		if(id == 0){
			request.setAttribute("errorMessage", "没有得到modelId, 这里是documentAction的bEditModel");
			return mapping.findForward("error");
		}
		UtilService us = (UtilService)this.getService("utilService");
		UlDocumentModel d = us.getDocumentModelById(id);
		request.setAttribute("d", d);
		return mapping.findForward("editModelPage");
	}
	
	
	public ActionForward editModel(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if( CheckUserRight.checkUser(request) == 0){
			request.setAttribute("errorMessage", "只有管理员才能作此操作");
			return mapping.findForward("error");
		}
		UlDocumentModel d = new UlDocumentModel();
		int id = this.getIntValue(request, "modelId", 0);
		d.setId(id);
		if(id == 0){
			request.setAttribute("errorMessage", "没有得到modelId, 这里是documentAction的addModel");
			return mapping.findForward("error");
		}
		d.setHead(this.getStringValue(request, "hhead"));
		d.setTitle(this.getStringValue(request, "htitle"));
		d.setHr1(this.getStringValue(request, "hhr1"));
		d.setSeal(this.getStringValue(request, "hseal"));
		d.setPage2Blank(this.getStringValue(request, "h2pageblank"));
		d.setZhutici(this.getStringValue(request, "hzhutici"));
		d.setDayin(this.getStringValue(request, "hdayin"));
		d.setGongdayin(this.getStringValue(request, "hgongdayin"));
		d.setChengban(this.getStringValue(request, "hchengban"));
		d.setDianhua(this.getStringValue(request, "hdianhua"));
		d.setGongsi(this.getStringValue(request, "hgongsi"));
		d.setBottom(this.getStringValue(request, "hbottom"));
		d.setAdd1(this.getStringValue(request, "hadd1"));
		d.setAdd2(this.getStringValue(request, "hadd2"));
		d.setAdd3(this.getStringValue(request, "hadd3"));	
		
		UtilService us = (UtilService)this.getService("utilService");
		int temp1 = us.editDocumentModle(d);
		if(temp1 == 0){
			request.setAttribute("errorMessage", "添加不成功");
		}else{
			request.setAttribute("errorMessage", "添加成功");
		}		
		return mapping.findForward("listModel");
	}
	
	public ActionForward listModel(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if( CheckUserRight.checkUser(request) == 0){
			request.setAttribute("errorMessage", "只有管理员才能作此操作");
			return mapping.findForward("error");
		}
		UtilService us = (UtilService)this.getService("utilService");
		request.setAttribute("list",us.getDocumentModelList());
		return mapping.findForward("listModelPage");
	}
	
	public ActionForward viewModel(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if( CheckUserRight.checkUser(request) == 0){
			request.setAttribute("errorMessage", "只有管理员才能作此操作");
			return mapping.findForward("error");
		}
		StringBuffer sb = new StringBuffer();	
		sb.append(this.getStringValue(request, "hhead"));		
		sb.append(this.getStringValue(request, "hhr1"));
		sb.append(this.getStringValue(request, "htitle"));
		sb.append(this.getStringValue(request, "hseal"));		
		sb.append(this.getStringValue(request, "h2pageblank"));
		sb.append(this.getStringValue(request, "hzhutici"));
		sb.append(this.getStringValue(request, "hchaosong"));
		sb.append(this.getStringValue(request, "hdayin"));
		sb.append(this.getStringValue(request, "hgongdayin"));
		sb.append(this.getStringValue(request, "hchengban"));
		sb.append(this.getStringValue(request, "hdianhua"));
		sb.append(this.getStringValue(request, "hgongsi"));
		sb.append(this.getStringValue(request, "shijian"));
		sb.append(this.getStringValue(request, "hbottom"));
		request.setAttribute("sb", sb.toString());	
		return mapping.findForward("viewModelPage");
	}
	
	public ActionForward viewDocument(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if( CheckUserRight.checkUser(request) == 0){
			request.setAttribute("errorMessage", "只有管理员才能作此操作");
			return mapping.findForward("error");
		}
		UlContent c = new UlContent();	
		c.setContent(this.getStringValue(request, "content"));
		c.setContentName(this.getStringValue(request,"contentName"));
		c.setDocumentNum(this.getStringValue(request,"documentNum"));
		
/*		
		UlDocument d = new UlDocument();
		d.setDocumentNum(this.getStringValue(request, "documentNum"));
		d.setDocumentName(this.getStringValue(request, "documentName"));
		d.setContent(this.getStringValue(request, "content"));
		d.setDate1(this.getStringValue(request, "date1"));
		d.setDocumentWord(this.getStringValue(request, "documentWord"));
		d.setChaosong(this.getStringValue(request, "chaosong"));
		d.setDayin(this.getStringValue(request, "dayin"));
		d.setGongdayin(this.getStringValue(request, "gongdayin"));
		d.setChengban(this.getStringValue(request, "chengban"));
		d.setDianhua(this.getStringValue(request, "dianhua"));
		d.setGongsi(this.getStringValue(request, "gongsi"));
		d.setShijian(this.getStringValue(request, "shijian"));	

		
		UtilService us = (UtilService)this.getService("utilService");
		UlDocumentModel dm = us.getDocumentModelById(Constant.documentModel);
		StringBuffer sb = new StringBuffer();		
		sb.append(dm.getHead());	
		sb.append(this.getStringValue(request, "documentNum"));	
		sb.append(dm.getHr1());
		sb.append(this.getStringValue(request, "documentName"));		
		sb.append(dm.getTitle());
		sb.append(this.getStringValue(request, "content"));	
		sb.append(dm.getSeal());
		sb.append(this.getStringValue(request, "date1"));
		sb.append(dm.getPage2Blank());
		sb.append(this.getStringValue(request, "documentWord"));
		sb.append(dm.getZhutici());
		sb.append(this.getStringValue(request, "chaosong"));
		sb.append(dm.getChaosong());
		sb.append(this.getStringValue(request, "dayin"));
		sb.append(dm.getDayin());
		sb.append(this.getStringValue(request, "gongdayin"));
		sb.append(dm.getGongdayin());
		sb.append(this.getStringValue(request, "chengban"));
		sb.append(dm.getChengban());
		sb.append(this.getStringValue(request, "dianhua"));
		sb.append(dm.getDianhua());
		sb.append(this.getStringValue(request, "gongsi"));
		sb.append(dm.getGongsi());
		sb.append(this.getStringValue(request, "shijian"));
		request.setAttribute("sb", sb.toString());	
		
*/
		request.setAttribute("c", c);
		return mapping.findForward("viewDocumentPage");
	}
		
	
//070606增加的公文翻页
	public ActionForward getDocumentList(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if( CheckUserRight.checkUser(request) == 0){
			request.setAttribute("errorMessage", "只有管理员才能作此操作");
			return mapping.findForward("error");
		}		
		int page = this.getIntValue(request, "page", 1);		
		int pageSize = this.getIntValue(request, "pageSize", Constant.listNum);
		int columnId = this.getIntValue(request, "columnId", 0);
		if(columnId == 0){
			request.setAttribute("errorMessage", "没有得到columnId,这里是columnAction的getDocumentList");
			return mapping.findForward("error");
		}
		IUlContentService cs = (IUlContentService)this.getService("contentService");
		int pageSum = cs.getContentTotlePage(columnId, pageSize);
		if(page > pageSum) page = pageSum;
		List l = cs.getContentByColumnId(columnId, page, pageSize);
//		GetColumns gc = new GetColumns();
//		request.setAttribute("condition", " where is_delete = 0 and column_id = " + columnId);
		request.setAttribute("list", l);
		request.setAttribute("pageSum", pageSum);
		request.setAttribute("pageNow", page);
		request.setAttribute("columnId",columnId);
		ActionForward af = new ActionForward();			
		af.setName("listD");
		af.setPath("/admin/add/listdocument.jsp");
		return af;
	}
}

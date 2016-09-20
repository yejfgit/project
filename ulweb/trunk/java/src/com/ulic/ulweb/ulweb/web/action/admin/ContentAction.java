package com.ulic.ulweb.ulweb.web.action.admin;

import java.net.URLDecoder;
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
import com.ulic.ulweb.ulweb.entity.UlContent;
import com.ulic.ulweb.ulweb.entity.UlDept;
import com.ulic.ulweb.ulweb.service.IUlAttachmentService;
import com.ulic.ulweb.ulweb.service.IUlContentService;
import com.ulic.ulweb.ulweb.service.IUlDeptService;
import com.ulic.ulweb.ulweb.util.CheckUserRight;
import com.ulic.ulweb.ulweb.util.GetColumns;
import com.ulic.ulweb.ulweb.util.ResourceUtil;
import com.ulic.ulweb.ulweb.web.action.IndexAction;

public class ContentAction extends BaseAction{
	
	public static int uploadSize = 50;
	
	public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int adminLevel = CheckUserRight.checkUser(request);
//		if( adminLevel < 2){
//			request.setAttribute("errorMessage", "只有管理员才能作此操作");
//			return mapping.findForward("error");
//		}
		String deptId = null;
		HttpSession session = request.getSession();		
		IUlContentService cs = (IUlContentService)this.getService("contentService");
		List<UlDept> deptList = null;
		if(adminLevel == 9){
			if(request.getParameter("deptId") != null){
				deptId = request.getParameter("deptId");
				
			}else if(request.getAttribute("deptId") != null){
				deptId = (String)request.getAttribute("deptId");
			}else{
				deptId = "0000";
			}			
			IUlDeptService ds = (IUlDeptService)this.getService("deptService");
			deptList = ds.getList();
		}else {
			deptId = (String)session.getAttribute("dept");
		}		
		
		GetColumns gc = new GetColumns();
		if(adminLevel == 1){
			String tempurc = cs.getUserRightColumn(((Integer)session.getAttribute("uRole")).intValue());
			if( tempurc != null){				
				request.setAttribute("columnList",gc.getColumnUsedAdmin1(cs.getListByColumnIds(tempurc)));
						
			}
		}else{
			List l = cs.getListForContentByDeptId(deptId);
			request.setAttribute("columnList", gc.columnListUsedContent(l));
		}
	
		List l2 = cs.getByUploadUser((String)session.getAttribute("name"),1,10);		
		request.setAttribute("contentList", gc.getContentListForAdmin10Content(l2));	
		request.setAttribute("deptId", deptId);
		request.setAttribute("deptList", deptList);
		request.setAttribute("from", "do");
		return mapping.findForward("listPage");
	}
	
	public ActionForward oldList(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int adminLevel = CheckUserRight.checkUser(request);
		if( adminLevel < 2){
			request.setAttribute("errorMessage", "只有管理员才能作此操作");
			return mapping.findForward("error");
		}
		String deptId = null;
		HttpSession session = request.getSession();
		if(adminLevel == 9){
			if(request.getParameter("deptId") != null){
				deptId = request.getParameter("deptId");
				
			}else if(request.getAttribute("deptId") != null){
				deptId = (String)request.getAttribute("deptId");
			}else{
				return mapping.findForward("choseDept");
			}			
		}else {
			deptId = (String)session.getAttribute("dept");
		}
		IUlContentService cs = (IUlContentService)this.getService("contentService");
		List l = cs.getListForContentByDeptId(deptId);
		GetColumns gc = new GetColumns();
		request.setAttribute("columnList", gc.columnListUsedContent(l));
		request.setAttribute("deptId", deptId);
		return mapping.findForward("oldListPage");
	}
	
	public ActionForward bAdd(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int adminLevel = CheckUserRight.checkUser(request);
		if( adminLevel == 0){
			request.setAttribute("errorMessage", "只有管理员才能作此操作");
			return mapping.findForward("error");
		}
		String deptId = null;
		HttpSession session = request.getSession();
		IUlContentService cs = (IUlContentService)this.getService("contentService");	
		GetColumns gc = new GetColumns();
		if(adminLevel == 9){
			if(request.getParameter("deptId") != null){
				deptId = request.getParameter("deptId");				
			}else if(request.getAttribute("deptId") != null){
				deptId = (String)request.getAttribute("deptId");
			}else{
				deptId = "0000";
			}			
		}else if(adminLevel == 1){
			if(session.getAttribute("uRole") == null){
				request.setAttribute("errorMessage", "没有得到角色,这里是contentA的bAdd");
				return mapping.findForward("error");
			}
			deptId = (String)session.getAttribute("dept");
			String tempurc = cs.getUserRightColumn(((Integer)session.getAttribute("uRole")).intValue());
			if( tempurc != null){
				
				request.setAttribute("columnList",gc.getColumnUsedAdmin1(cs.getListByColumnIds(tempurc)));
				request.setAttribute("deptId", deptId);
				return mapping.findForward("addPage");
				
			}else{
				request.setAttribute("errorMessage", "您没有对任何栏目添加内容的权限");
				return mapping.findForward("error");
			}
		}else{		
			deptId = (String)session.getAttribute("dept");
		}
	
		request.setAttribute("columnList", gc.columnListUsedContent(cs.getListForContentByDeptId(deptId)));
		request.setAttribute("deptId", deptId);
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
		c.setColumnId(Integer.parseInt(request.getParameter("columnId")));
		c.setContent(request.getParameter("content"));
		c.setContentName(request.getParameter("contentName"));
//		System.out.println("==" + request.getParameter("contentName"));
		c.setKeyWord(request.getParameter("keyWord"));
		c.setShowOrganClass(Integer.parseInt(request.getParameter("showToOrgan")));
		c.setShowOthersClass(Integer.parseInt(request.getParameter("showToOther")));
		c.setUploadUser((String)session.getAttribute("name"));
		c.setOrganId(request.getParameter("deptId"));
		c.setIsQuickLink(Integer.parseInt(request.getParameter("isQuickLink")));
		c.setDisplayType(Integer.parseInt(request.getParameter("displayType")));
		c.setSubTitle(request.getParameter("subTitle"));
		c.setUploadDeptStr(request.getParameter("uploadDeptStr"));
		if(request.getParameter("quickTime") != null && !request.getParameter("quickTime").equals("")){
			c.setQuickTime(Integer.parseInt(request.getParameter("quickTime")));
		}else{
			c.setQuickTime(3);
		}
		c.setAttachmentSum(0);
		if(request.getParameter("content") == ""){
			c.setHaveContent(0);
		}else{
			c.setHaveContent(1);
		}
		IUlContentService cs = (IUlContentService)this.getService("contentService");
		if(Constant.isInQuickLinkSingle(c.getColumnId())){
			cs.unSetQuickLinkSingle(c.getColumnId());
			c.setOnIndex(1);
		}else{
			c.setOnIndex(0);
		}
		
		int contentId = cs.addContent(c);	

//080410 add 增加栏目时更新列表
		if(c.getOrganId().equals("0000")){
			IndexAction indexa = new IndexAction();
			indexa.initList();
		}
		
		request.setAttribute("contentId", contentId);
		request.setAttribute("columnId", c.getColumnId());
		request.setAttribute("deptId", c.getOrganId());
//		System.out.print("--add end");
		if(request.getParameter("att").equals("1")){			
			return mapping.findForward("addAPage");
		}else{
			if(CheckUserRight.checkUser(request) == 1){
				request.setAttribute("errorMessage", "附件添加成功");
				return mapping.findForward("error");
			}else{
				return mapping.findForward("list");
			}
		}
		
	}
	
//此方法是保存为原文件名	
	/*
	public ActionForward addAttachment070404(ActionMapping mapping, ActionForm form, HttpServletRequest request,
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
		String path = Constant.getdeptPath(((String)session.getAttribute("dept")));
		
		String subpath = path.substring(path.indexOf("files/"), path.length());
		IUlAttachmentService as = (IUlAttachmentService)this.getService("attachmentService");
		UlAttachment a = new UlAttachment();	
		int fileNum = req.getParameter("attSum") == null ? 0 : Integer.parseInt(req.getParameter("attSum"));	
		int ran = 0;
		for(int i = 0; i < files.getCount(); i++){
		
			file = files.getFile(i);
//			System.out.println("----" + file.getFieldName());
//			System.out.println("----" + file.getFileName());
//			System.out.println("====" + new String(file.getFileName().getBytes(),"utf-8"));
//			System.out.println("====" + new String(file.getFileName().getBytes("gbk"),"utf-8"));
//			System.out.println("====" + new String(file.getFileName().getBytes("gbk"),"gbk"));
//			System.out.println("====" + new String(file.getFileName().getBytes("gbk"),"gb2312"));
			
//			System.out.println("====" + new String(file.getFileName().getBytes("ISO-8859-1"),"gb2312"));
//			System.out.println("====" + new String(file.getFileName().getBytes("gb2132"),"gbk"));
//			System.out.println("====" + new String(file.getFileName().getBytes("gb2132"),"utf-8"));
			
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
//				+ file.getFileName() );
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
		int columnId = Integer.parseInt(req.getParameter("columnId"));
		request.setAttribute("columnId", columnId);	
		request.setAttribute("deptId", req.getParameter("deptId"));	
		as.updateAttachmentSum(contentId, fileNum);
//		这里是检查是否是地址簿，如果是就让constant重新载入
//		System.out.println("=====" + columnId);
		if(columnId == Constant.youjiandizhibu){
//			System.out.println("---------");
			InitAction ia = new InitAction();
			ia.getMailaddress();
//			System.out.println(ia.getMailaddress());
		}
//		System.out.print("++adda end");
		return mapping.findForward("list");
	}
*/	
//此方法是保存为数字名称
	public ActionForward addAttachment(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//		System.out.print("==adda start");
		int userClass = CheckUserRight.checkUser(request);
		if( userClass == 0){
			request.setAttribute("errorMessage", "只有管理员才能作此操作");
			return mapping.findForward("error");
		}	
		HttpSession session = request.getSession();		
		SmartUpload su = new SmartUpload();
		su.initialize(this.getServlet().getServletConfig(), request, response);
		Request req = su.getRequest();					
//		此外可设置上传文件的大小 		
		su.setMaxFileSize(uploadSize*1024*1024);		
		su.upload();		
		Files files = su.getFiles();	
		File file = null;
		int contentId = Integer.parseInt(req.getParameter("contentId"));
		String dept = (String)session.getAttribute("dept");
		if(dept == null){
			dept = "nodept";			
		}
		String path = Constant.getdeptPath(dept);
		//System.out.println(path);
		path = ResourceUtil.getFilesRootDir() + path.substring(path.indexOf("files/"), path.length());
		//System.out.println(path);
		java.io.File f = new java.io.File(path);
		if (!f.exists()) {
			f.mkdirs();
		}
		String subpath = path.substring(path.indexOf("files/"), path.length());
		IUlAttachmentService as = (IUlAttachmentService)this.getService("attachmentService");
		UlAttachment a = new UlAttachment();	
		
		int fileNum = req.getParameter("attSum") == null ? 0 : Integer.parseInt(req.getParameter("attSum"));	
//	070516增加的得到内容下最大attachment_order 
		if(fileNum != 0){
			fileNum = as.getMaxAttachmentOrderByContentId(contentId) ;
		}
		
		int ran = 0;		
		for(int i = 0; i < files.getCount(); i++){
		
			file = files.getFile(i);
//			System.out.println("----" + file.getFieldName());
//			System.out.println("----" + file.getFileName());
//			System.out.println("====" + new String(file.getFileName().getBytes(),"utf-8"));
//			System.out.println("====" + new String(file.getFileName().getBytes("gbk"),"utf-8"));
//			System.out.println("====" + new String(file.getFileName().getBytes("gbk"),"gbk"));
//			System.out.println("====" + new String(file.getFileName().getBytes("gbk"),"gb2312"));
			
//			System.out.println("====" + new String(file.getFileName().getBytes("ISO-8859-1"),"gb2312"));
//			System.out.println("====" + new String(file.getFileName().getBytes("gb2132"),"gbk"));
//			System.out.println("====" + new String(file.getFileName().getBytes("gb2132"),"utf-8"));
			
			if(!file.isMissing()){
				fileNum++;		
				ran = ((int)(Math.random() * 100000));
				String fileType = file.getFileExt().toLowerCase();
				a.setAttachmentType(0);
				if(fileType.equals("doc")){					
					a.setAttachmentType(2);
				}else if(fileType.equals("pdf")){
					a.setAttachmentType(3);
				}else if(fileType.equals("gif") || fileType.equals("jpg") ||
						fileType.equals("png") ||fileType.equals("bmp") ){
					a.setAttachmentType(1);					
				}else if(fileType.equals("jsp")){
					fileType = fileType + "un";
				}			
				file.saveAs(path + contentId + ran + "." + fileType,SmartUpload.SAVE_PHYSICAL);
				a.setAttachmentOrder(fileNum);
				a.setAttachmentPath(subpath + contentId + ran + "." + fileType);
				a.setContentId(contentId);
				a.setIsdelete(0);
				a.setShowName(new String(file.getFileName().getBytes("gbk"),"gbk"));		
				
				as.addAttachment(a);
			}
		}		
		int columnId = Integer.parseInt(req.getParameter("columnId"));
		request.setAttribute("columnId", columnId);	
		request.setAttribute("deptId", req.getParameter("deptId"));	
		as.updateAttachmentSum(contentId, as.getAttachmentNumByContentId(contentId));
//		这里是检查是否是地址簿，如果是就让constant重新载入
//		System.out.println("=====" + columnId);
		if(columnId == Constant.youjiandizhibu){
//			System.out.println("---------");
			InitAction ia = new InitAction();
			ia.getMailaddress();
//			System.out.println(ia.getMailaddress());
		}
//		System.out.print("++adda end");
		
//		080410 add 增加栏目时更新列表
		UlContent c = as.getContentById(contentId);
		if(c.getOrganId().equals("0000")){
			IndexAction indexa = new IndexAction();
			indexa.initList();
		}
		
		
		if(userClass == 1){
			request.setAttribute("errorMessage", "附件添加成功");
			return mapping.findForward("error");
		}
		
		return mapping.findForward("list");
	}
	
	
	public ActionForward bEdit(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int adminLevel = CheckUserRight.checkUser(request);
		if( adminLevel == 0){
			request.setAttribute("errorMessage", "只有管理员才能作此操作");
			return mapping.findForward("error");
		}
		int contentId = 0;
		try{
			contentId = Integer.parseInt(request.getParameter("contentId"));
		}catch(Exception e){
			request.setAttribute("errorMessage", "没有得到contentId");
			return mapping.findForward("error");
		}		
		if(request.getParameter("deptId") == null){
			request.setAttribute("errorMessage", "没有得到deptId");
			return mapping.findForward("error");
		}
		String deptId = null;
		GetColumns gc = new GetColumns();
		HttpSession session = request.getSession();
		IUlContentService cs = (IUlContentService)this.getService("contentService");
		deptId = (String)session.getAttribute("dept");
		if(adminLevel == 1){
			if(session.getAttribute("uRole") == null){
				request.setAttribute("errorMessage", "没有得到角色,这里是contentA的bAdd");
				return mapping.findForward("error");
			}			
			String tempurc = cs.getUserRightColumn((Integer)session.getAttribute("uRole"));
			if( tempurc != null){				
				request.setAttribute("columnList",gc.columnListUsedContentForAdmin1(cs.getListForContentByDeptId(deptId), tempurc));
								
			}else{
				request.setAttribute("errorMessage", "您没有对任何栏目添加内容的权限");
				return mapping.findForward("error");
			}
		}else{					
			request.setAttribute("columnList", gc.columnListUsedContent(cs.getListForContentByDeptId(deptId)));
		}
		request.setAttribute("deptId", deptId);
		UlContent c = cs.getContentById(contentId);
		request.setAttribute("content",c);
		return mapping.findForward("editPage");
	}
	
	public ActionForward edit(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if( CheckUserRight.checkUser(request) == 0){
			request.setAttribute("errorMessage", "只有管理员才能作此操作");
			return mapping.findForward("error");
		}			
		IUlContentService cs = (IUlContentService)this.getService("contentService");
		UlContent c = cs.getContentById(this.getIntValue(request, "contentId" , 0 ));
		if(c == null){
			request.setAttribute("errorMessage", "没有找到对应的内容");
			return mapping.findForward("error");
		}
		c.setContentId(Integer.parseInt(request.getParameter("contentId")));
		c.setColumnId(Integer.parseInt(request.getParameter("columnId")));
		c.setContent(request.getParameter("content"));
		c.setContentName(request.getParameter("contentName"));
		c.setKeyWord(request.getParameter("keyWord"));
//		c.setShowOrganClass(Integer.parseInt(request.getParameter("showToOrgan")));
//		c.setShowOthersClass(Integer.parseInt(request.getParameter("showToOther")));
//		c.setUploadUser((String)session.getAttribute("name"));
//		c.setOrganId(request.getParameter("deptId"));
		c.setIsQuickLink(Integer.parseInt(request.getParameter("isQuickLink")));
		c.setDisplayType(Integer.parseInt(request.getParameter("displayType")));
		c.setSubTitle(request.getParameter("subTitle"));
		c.setUploadDeptStr(request.getParameter("uploadDeptStr"));
		if(request.getParameter("quickTime") != null && !request.getParameter("quickTime").equals("")){
			c.setQuickTime(Integer.parseInt(request.getParameter("quickTime")));
		}else{
			c.setQuickTime(3);
		}	
		if(request.getParameter("content") == ""){
			c.setHaveContent(0);
		}else{
			c.setHaveContent(1);
		}
		
/*
		if(Constant.isInQuickLinkSingle(c.getColumnId())){
			cs.unSetQuickLinkSingle(c.getColumnId());
			c.setOnIndex(1);
		}else{
			c.setOnIndex(0);
		}		
*/
		String attDel = (request.getParameter("attDel") == null ? "" : request.getParameter("attDel"));
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
		c.setAttachmentSum(Integer.parseInt(request.getParameter("attSum")));
		cs.updateContent(c);		
		
//		080410 add 增加栏目时更新列表
		if(c.getOrganId().equals("0000")){
			IndexAction indexa = new IndexAction();
			indexa.initList();
		}

		request.setAttribute("contentId", c.getContentId());
		request.setAttribute("columnId", c.getColumnId());
		request.setAttribute("deptId", request.getParameter("deptId"));
		request.setAttribute("attSum", c.getAttachmentSum());
		if(request.getParameter("att").equals("1")){			
			return mapping.findForward("addAPage");
		}else{
			return mapping.findForward("list");
		}
		
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
		int pageNum = 1;
		if(request.getParameter("page") != null){
			try{
				pageNum = Integer.parseInt(request.getParameter("page"));
			}catch(Exception e){
				pageNum = 1;
			}
		}
		int contentId = this.getIntValue(request, "contentId", 0);
		IUlContentService cs = (IUlContentService)this.getService("contentService");
		UlContent c = cs.getContentById(contentId);
		int i = cs.daleteContent(contentId);
	
		if(i == 0){
			request.setAttribute("errorMessage", "要删除的内容在数据库里不存在,这里是content的delete方法");
			return mapping.findForward("error");
		}
//		080410 add 增加栏目时更新列表
		
		if(c.getOrganId().equals("0000")){
			IndexAction indexa = new IndexAction();
			indexa.initList();
		}
		
		int pageSize = this.getIntValue(request, "pageSize", Constant.listNum);
		List l = cs.getContentByColumnId(i, pageNum, pageSize);
		GetColumns gc = new GetColumns();
		request.setAttribute("condition", " where is_delete = 0 and column_id = " + i);
		request.setAttribute("contentList", gc.getContentList(l));
		request.setAttribute("totlePage", cs.getContentTotlePage(i, pageSize));
		request.setAttribute("page", pageNum);
		
		
		return mapping.findForward("ajaxAdminContent");		
	}
	
	public ActionForward getContentList(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if( CheckUserRight.checkUser(request) == 0){
			request.setAttribute("errorMessage", "只有管理员才能作此操作");
			return mapping.findForward("error");
		}
		if(request.getParameter("columnId") == null){
			request.setAttribute("errorMessage", "没有从request里得到columnId,这里是content的getContentList方法");
			return mapping.findForward("error");
		}
		int pageNum = 1;
		if(request.getParameter("page") != null){
			try{
				pageNum = Integer.parseInt(request.getParameter("page"));
			}catch(Exception e){
				pageNum = 1;
			}
		}
		int pageSize = this.getIntValue(request, "pageSize", Constant.listNum);
		int columnId = Integer.parseInt(request.getParameter("columnId"));
		IUlContentService cs = (IUlContentService)this.getService("contentService");
		List l = cs.getContentByColumnId(columnId, pageNum, pageSize);
		GetColumns gc = new GetColumns();
		request.setAttribute("condition", " where is_delete = 0 and column_id = " + columnId);
		request.setAttribute("contentList", gc.getContentList(l));
		request.setAttribute("totlePage", cs.getContentTotlePage(columnId, pageSize));
		request.setAttribute("page", pageNum);
		return mapping.findForward("ajaxAdminContent");
	}
	

	public ActionForward choseDept(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		IUlDeptService ds = (IUlDeptService)this.getService("deptService");
		List<UlDept> list = ds.getList();
		StringBuffer sb = new StringBuffer();	
		sb.append("<select name='deptId'>");
		for(int i = 0; i < (list.isEmpty()? 0:list.size()); i++){
			sb.append("<option value='" + list.get(i).getDeptId() + "'>" + list.get(i).getDeptName() + "</option>");
		}
		sb.append("</select>");
		request.setAttribute("deptList", sb.toString());
		return mapping.findForward("choseDeptPage");
	}
	
	public ActionForward find(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {		
		StringBuffer sb = new StringBuffer();		    
		
		int page = this.getIntValue(request, "page", 1);	
		String ts = this.getStringValue(request, "condition");		
		if(!ts.equals("")){
			sb.append(ts);
		}else{	
			sb.append(" where is_delete = 0 ");
			ts = this.getStringValue(request, "deptId");
			if(!ts.equals("")){
				sb.append(" and organ_id = '" + ts + "'");
			}			
			ts = this.getStringValue(request, "ccName");
			if(!ts.equals("")){
				
				
//				ts =  new String(ts.trim().getBytes("ISO-8859-1"), "utf-8");
				sb.append(" and content_name like '%" +  URLDecoder.decode(ts, "utf-8") + "%' ");	
			
			}			
			ts = this.getStringValue(request, "dNum");
			if(!ts.equals("")){
				sb.append(" and document_num = '" + ts + "' ");
			}
			ts = this.getStringValue(request, "ts");
			if(!ts.equals("")){
				if(ts.indexOf("-") == -1){
					if(ts.length() == 4){
						sb.append(" and upload_time > to_date('" + ts + "', 'yyMM') ");
					}else if(ts.length() == 6 && ts.indexOf("0") == 0){
						sb.append(" and upload_time > to_date('" + ts + "', 'yyMMDD') ");
					}else{
						sb.append(" and upload_time > to_date('" + ts + "', 'yyyyMMDD') ");
					}
				}else{
					if(ts.indexOf("0") == 0){
						sb.append(" and upload_time > to_date('" + ts + "', 'yy-MM-DD') ");
					}else{
						sb.append(" and upload_time > to_date('" + ts + "', 'yyyy-MM-DD') ");
					}				
				}		
			}
			ts = this.getStringValue(request, "te");
			if(!ts.equals("")){
				if(ts.indexOf("-") == -1){
					if(ts.length() == 4){
						sb.append(" and (upload_time - 1) < to_date('" + ts + "', 'yyMM') ");
					}else if(ts.length() == 6 && ts.indexOf("0") == 0){
						sb.append(" and (upload_time - 1) < to_date('" + ts + "', 'yyMMDD') ");
					}else{
						sb.append(" and (upload_time - 1) < to_date('" + ts + "', 'yyyyMMDD') ");
					}
				}else{
					if(ts.indexOf("0") == 0){
						sb.append(" and (upload_time - 1) < to_date('" + ts + "', 'yy-MM-DD') ");
					}else{
						sb.append(" and (upload_time - 1) < to_date('" + ts + "', 'yyyy-MM-DD') ");
					}				
				}		
			}
				
		}			
		int pageSize = this.getIntValue(request, "pageSize",Constant.listNum );
		IUlContentService cs = (IUlContentService)this.getService("contentService");
		int totlePage = cs.getCheckTotlePage(sb.toString(), pageSize);
		if(page > totlePage && totlePage > 1) page = totlePage;
		List list = cs.getCheck(sb.toString(), page, pageSize);
		GetColumns gc = new GetColumns();
		request.setAttribute("condition", sb.toString());		
		request.setAttribute("contentList", gc.getContentList(list));
		request.setAttribute("totlePage", totlePage);
		request.setAttribute("page", page);
		return mapping.findForward("ajaxAdminContent");
	}
	
}

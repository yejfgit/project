package com.ulic.ulweb.ulweb.web.action.admin;

import java.sql.Timestamp;
import java.util.List;
import java.util.Timer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ulic.ulweb.frame.action.BaseAction;
import com.ulic.ulweb.frame.constant.ChangeConstant;
import com.ulic.ulweb.ulweb.entity.Attachment;
import com.ulic.ulweb.ulweb.entity.Files;
import com.ulic.ulweb.ulweb.entity.UlAttachment;
import com.ulic.ulweb.ulweb.entity.UlConfig;
import com.ulic.ulweb.ulweb.entity.UlContent;
import com.ulic.ulweb.ulweb.service.IFilesService;
import com.ulic.ulweb.ulweb.service.IUlAttachmentService;
import com.ulic.ulweb.ulweb.service.IUlColumnService;
import com.ulic.ulweb.ulweb.service.IUlContentService;
import com.ulic.ulweb.ulweb.service.UtilService;
import com.ulic.ulweb.ulweb.util.CheckUserRight;
import com.ulic.ulweb.ulweb.util.PorjectTask;
import com.ulic.ulweb.ulweb.web.action.IndexAction;

public class ConfigAction extends BaseAction{
	

	public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(CheckUserRight.checkUser(request) < 9){
			request.setAttribute("errorMessage", "只有不受限管理员才能作此操作");
			return mapping.findForward("error");
		}
		UtilService us = (UtilService)this.getService("utilService");
		List<UlConfig> list = us.getConfigList();
		request.setAttribute("list", list);
		return mapping.findForward("listPage");
	}
	
	public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(CheckUserRight.checkUser(request) < 9){
			request.setAttribute("errorMessage", "只有不受限管理员才能作此操作");
			return mapping.findForward("error");
		}
		int id = this.getIntValue(request, "configId", 0);
		if(id == 0){
			request.setAttribute("errorMessage", "没有得到configId,这里是configAction");
			return mapping.findForward("error");
		}
		UlConfig c = new UlConfig();
		c.setConfigId(id);
		c.setConstantName(this.getStringValue(request, "constantName"));
		c.setColumnName(this.getStringValue(request, "columnName"));
		c.setConstantData(this.getStringValue(request, "constantData"));
		c.setIp(request.getRemoteAddr());
		c.setDesc(this.getStringValue(request, "desc"));
		c.setUpdateUser((String)request.getSession().getAttribute("name"));
		UtilService us = (UtilService)this.getService("utilService");
		us.add(c);
		request.setAttribute("errorMessage","添加成功");
		return mapping.findForward("infoPage");
	}
	
	public ActionForward edit(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(CheckUserRight.checkUser(request) < 9){
			request.setAttribute("errorMessage", "只有不受限管理员才能作此操作");
			return mapping.findForward("error");
		}
//		System.out.print("进来了");
		int id = this.getIntValue(request, "configId", 0);
		if(id == 0){
			request.setAttribute("errorMessage", "没有得到configId,这里是configAction");
			return mapping.findForward("error");
		}
		UtilService us = (UtilService)this.getService("utilService");
		UlConfig c = us.getById(id);
		if(c == null){
			request.setAttribute("errorMessage", "您所查找的设置项不存在");
			return mapping.findForward("error");
		}
		c.setColumnName(this.getStringValue(request, "columnName"));
		c.setConstantData(this.getStringValue(request, "constantData"));
		c.setIp(request.getRemoteAddr());
		c.setDesc(this.getStringValue(request, "desc"));
		c.setUpdateUser((String)request.getSession().getAttribute("name"));
		int temp = us.updateConfig(c);
		if(temp == 0){
			request.setAttribute("errorMessage", "修改不成功");
			return mapping.findForward("error");
		}
		ChangeConstant cc = new ChangeConstant();
		cc.change(c.getConstantName(), c.getConstantData());
		request.setAttribute("errorMessage","修改成功");
		return mapping.findForward("infoPage");
	}
	
	public ActionForward bEdit(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(CheckUserRight.checkUser(request) < 9){
			request.setAttribute("errorMessage", "只有不受限管理员才能作此操作");
			return mapping.findForward("error");
		}
		int id = this.getIntValue(request, "configId", 0);
		if(id == 0){
			request.setAttribute("errorMessage", "没有得到configId,这里是configAction");
			return mapping.findForward("error");
		}
		UtilService us = (UtilService)this.getService("utilService");
		UlConfig c = us.getById(id);
		if(c == null){
			request.setAttribute("errorMessage", "您所查找的设置项不存在");
			return mapping.findForward("error");
		}
		request.setAttribute("c", c);
		return mapping.findForward("editPage");
	}
	
	public ActionForward getInit(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(CheckUserRight.checkUser(request) < 9){
			request.setAttribute("errorMessage", "只有不受限管理员才能作此操作");
			return mapping.findForward("error");
		}
		InitAction ia = new InitAction();
		if(ia.initUlweb() == 0){
			request.setAttribute("errorMessage","初始化失败");
		}else{
			request.setAttribute("errorMessage", "初始化成功");
		}
		return mapping.findForward("infoPage");
	}
	
	public ActionForward beforeMoveData(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(CheckUserRight.checkUser(request) < 9){
			request.setAttribute("errorMessage", "只有不受限管理员才能作此操作");
			return mapping.findForward("error");
		}
		HttpSession session = request.getSession();
		session.setAttribute("startTime",null);
		session.setAttribute("startMoveContentId",null);
		IUlColumnService cs = (IUlColumnService)this.getService("columnService");
		List l = cs.getListUsedForRole();
		request.setAttribute("columnList", l);		
		ActionForward af = new ActionForward();
		af.setName("ok");
		af.setPath("/admin/config/movedata.jsp");
		return af;
	}
	
	public ActionForward moveData(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(CheckUserRight.checkUser(request) < 9){
			request.setAttribute("errorMessage", "只有不受限管理员才能作此操作");
			return mapping.findForward("error");
		}
		HttpSession session = request.getSession();
		int oldColumnId = this.getIntValue(request, "oldColumnId", 0);
		String oldKeyword = this.getStringValue(request, "oldKeyword");
		int moveNum = this.getIntValue(request,"moveNum", 10);
		int moveAll = this.getIntValue(request, "moveAll",0);
		int newColumnId = this.getIntValue(request, "newColumnId", 0);
//		String startTime = this.getStringValue(request, "startTime", "");
		String dept = this.getStringValue(request, "dept","0000");
		Timestamp startTime = null;
		if(session.getAttribute("startTime") == null){
			startTime = new Timestamp(20,0,0,0,0,0,0);
		}else{
			startTime = (Timestamp)session.getAttribute("startTime");
		}
		
		
//第一次移动 记录开始号
		int firstMove = this.getIntValue(request, "firstMove", 0);
//		int moveRow = 0;
		
		int firstContentId = 0;
		int lastContentId = 0;
		StringBuffer strContentId = new StringBuffer();
		
		if(oldColumnId == 0){
			request.setAttribute("errorMessage", "没有得到oldColumnId");
			return mapping.findForward("error");
		}else if(newColumnId == 0){
			request.setAttribute("errorMessage", "没有得到newColumnId");
			return mapping.findForward("error");
		}else if(oldKeyword.equals("")){
			request.setAttribute("errorMessage", "没有得到keyword");
			return mapping.findForward("error");
		}
		
		System.out.println("oldColumnId = " + oldColumnId);
		System.out.println("newColumnId = " + newColumnId);
		System.out.println("keyword = " + oldKeyword);		
		System.out.println("move num = " + moveNum);
		System.out.println("move All = " + moveAll);
		
		
		
		StringBuffer condition = new StringBuffer();
		condition.append(" and COLUMNID = '" + oldColumnId + "' ");		
		if(!oldKeyword.equals("no")) condition.append(" and KEYWORD like '" + oldKeyword + "' ");
		
		IFilesService fs = (IFilesService)this.getService("filesService");
		List<Integer> l = fs.getContentIdForMoveData(condition.toString(), moveNum, startTime);
		IUlContentService cs = (IUlContentService)this.getService("contentService");
		IUlAttachmentService as = (IUlAttachmentService)this.getService("attachmentService");
		
		Files file = new Files();
		UlContent content = new UlContent();
		int contentId = 0;
		Attachment oldAtt = new Attachment();
		UlAttachment newAtt = new UlAttachment();
		
		if(l == null){
			request.setAttribute("errorMessage", "没有得到符合要求的内容");
			return mapping.findForward("error");
		}
//		System.out.println("--test--");
		for (int i = 0 ; i < l.size() ; i++){
			file = fs.getCandA1ById(l.get(i).intValue());
			content.setColumnId(newColumnId);
			content.setContentName(file.getTitle());
			content.setUploadUser(file.getUploaduser());
			content.setUploadTime(file.getUploadtime());
			content.setAttachmentSum(file.getDocno());
			content.setKeyWord(file.getKeyword());
//			content.setUploadDeptInt(intDept);
			content.setOrganId(dept);
			
			content.setIsQuickLink(0);
			content.setOnIndex(0);
			content.setShowOrganClass(0);
			content.setShowOthersClass(0);
			content.setQuickTime(0);
//用来记录标志可以删除			
			content.setDisplayType(0);
			
			if(file.getContent()== null ){
				content.setContent("");
				content.setHaveContent(0);
			}else{
				content.setContent(file.getContent());
				content.setHaveContent(1);
			}
			content.setIsDelete(file.getUsed() == 0 ? 1 : 0);
			contentId = cs.createForMoveData(content);
			if(file.getDocno() > 0){
				for(int j = 0 ; j < file.getDocno(); j++){
					oldAtt = fs.getAttachmentForMoveDataByContentId(file.getFileid(), j);
					if(oldAtt == null){
						System.out.println("Att no found ++++ fileid = " + file.getFileid() );
					}else{											
					newAtt.setContentId(contentId);
					newAtt.setAttachmentPath(".." + oldAtt.getAttName());
					newAtt.setAttachmentOrder(oldAtt.getDocid() + 1);
					newAtt.setIsdelete(oldAtt.getAused() == 0 ? 1 : 0);
					newAtt.setShowName("oldAtt");
					newAtt.setAttachmentType(0);
					as.addAttachment(newAtt);
					}
				}
			}
			
			strContentId.append(contentId + ",");
			
			if(i == 0){
				System.out.println("--------");
				System.out.println("move data from files " + file.getFileid());
				System.out.println("move data to content begain whith " + contentId);
				firstContentId = contentId;
			}else if(i == (l.size() - 1)){
				lastContentId = contentId;
				startTime = file.getUploadtime();
			}
		}
		
		
		
		request.setAttribute("oldColumnId",oldColumnId);
		request.setAttribute("oldKeyword",oldKeyword);
		request.setAttribute("moveNum",moveNum);
		request.setAttribute("moveAll",moveAll);
		request.setAttribute("newColumnId",newColumnId);
//		request.setAttribute("startTime",startTime);
		request.setAttribute("firstContentId",firstContentId);
		request.setAttribute("lastContentId",lastContentId);
		request.setAttribute("rowNum", l.size());
		request.setAttribute("strContentId",strContentId.toString());
		request.setAttribute("dept",dept);
		
		session.setAttribute("startTime",startTime);
		ActionForward af = new ActionForward();
		af.setName("ok");
		if(moveAll == 0){
			af.setPath("/admin/config/nocontinue.jsp");
		}else{
			if(firstMove == 1){
				
				session.setAttribute("startMoveContentId",firstContentId );
			}
			af.setPath("/admin/config/continue.jsp");
		}
		
		return af;
	}
	
	public ActionForward cancleThisTime(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(CheckUserRight.checkUser(request) < 9){
			request.setAttribute("errorMessage", "只有不受限管理员才能作此操作");
			return mapping.findForward("error");
		}
		int firstContentId = this.getIntValue(request, "firstContentId", 0);
		int lastContentId = this.getIntValue(request, "lastContentId", 0);
		int newColumnId = this.getIntValue(request, "newColumnId",0);
		if(firstContentId == 0 || lastContentId == 0 || newColumnId == 0){
			request.setAttribute("errorMessage", "没有得到开始与结束的contentId或newColumnId");
			return mapping.findForward("error");			
		}
		IUlContentService cs = (IUlContentService)this.getService("contentService");
		cs.deleteListFromTo(firstContentId, lastContentId);
		
		request.setAttribute("errorMessage", "此次数据删除完成");
		return mapping.findForward("error");
	}
	
	public ActionForward cancleAllData(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(CheckUserRight.checkUser(request) < 9){
			request.setAttribute("errorMessage", "只有不受限管理员才能作此操作");
			return mapping.findForward("error");
		}
		HttpSession session = request.getSession();
		if(session.getAttribute("startMoveContentId") == null){
			request.setAttribute("errorMessage", "没有得到开始的contentId");
			return mapping.findForward("error");
		}
		int contentId = ((Integer)session.getAttribute("startMoveContentId")).intValue();
		
		IUlContentService cs = (IUlContentService)this.getService("contentService");
		cs.deleteListFrom(contentId);
		
		request.setAttribute("errorMessage", "所有移动的数据删除完成");
		return mapping.findForward("error");
	}
	
//080415 增加手动更新主页列表	
	public ActionForward resetIndex(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		int resetList = this.getIntValue(request, "resetList", 0);
		int uploadSize = this.getIntValue(request, "uploadSize", 0);
		int indexTask = this.getIntValue(request, "indexTask", 1);
		int flashTime = this.getIntValue(request, "flashTime",3600);
		
//		081015 add index task timer control 
		System.out.println("----indexTask=" + indexTask);
		if(indexTask == 1){
			new PorjectTask().start();
			
		}else if(indexTask == 0){
			new PorjectTask().shutdown();
			System.out.println("tttt");
		}
		
		if(flashTime > 0)PorjectTask.flashTime = flashTime;
		
		
		if(uploadSize > 1)ContentAction.uploadSize = uploadSize;
		
		/*
		int iprefuse = this.getIntValue(request, "iprefuse", 0);
		
		String ip1 = this.getStringValue(request, "ip1");
		String ip2 = this.getStringValue(request, "ip2");
		String ip3 = this.getStringValue(request, "ip3");
		String ip4 = this.getStringValue(request, "ip4");
		String ip5 = this.getStringValue(request, "ip5");
		
		if(ip1.length() > 6)IndexAction.ip1 = ip1;
		if(ip2.length() > 6)IndexAction.ip2 = ip2;
		if(ip3.length() > 6)IndexAction.ip3 = ip3;
		if(ip4.length() > 6)IndexAction.ip4 = ip4;
		if(ip5.length() > 6)IndexAction.ip5 = ip5;
		
		if(iprefuse == 1){
			IndexAction.iprefuse = true;
		}else{
			IndexAction.iprefuse = false;
		}
*/		
		if(resetList == 1){
			IndexAction indexa = new IndexAction();
			indexa.initList();
		}
		
		ActionForward af = new ActionForward();
		af.setPath("/admin/config/indexset.jsp");
		return af;
	}
}

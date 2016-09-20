package com.ulic.ulweb.ulweb.web.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jspsmart.upload.SmartUpload;
import com.ulic.ulweb.frame.action.BaseAction;
import com.ulic.ulweb.frame.constant.Constant;
import com.ulic.ulweb.ulweb.entity.UlAttachment;
import com.ulic.ulweb.ulweb.entity.UlContent;
import com.ulic.ulweb.ulweb.service.IUlAttachmentService;
import com.ulic.ulweb.ulweb.util.ResourceUtil;
import com.ulic.ulweb.ulweb.util.UserClassRight;

public class ShowAction extends BaseAction{
	

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		
		int an = this.getIntValue(request, "a", 0);	
		int cId = this.getIntValue(request, "c", 0);
		int attN = this.getIntValue(request, "attN", 0);
		if(cId == 0){
			request.setAttribute("errorMessage", "请求发生异常，未得到请求内容的编号");
			return mapping.findForward("error");
		}
		IUlAttachmentService as = (IUlAttachmentService)this.getService("attachmentService");
		UlContent c = as.getContentById(cId);
		if(c == null){
			request.setAttribute("errorMessage", "请求发生异常，您所请求的内容已被删除");
			return mapping.findForward("error");
		}
/*
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
*/		
		if(an == 0){
			String ptype = this.getStringValue(request, "ptype");			
			request.setAttribute("c", c);					
			ActionForward af = new ActionForward();			
			af.setName("att");
			af.setPath("/frame/showcontent" + ptype + ".jsp");
			return af;
		}else{
			UlAttachment a = as.getByContentIdAndOrder(cId, an);	
			String attName = null;	
//			String attNameType =  a.getAttachmentPath().substring(a.getAttachmentPath().indexOf("."),a.getAttachmentPath().length());
			if(a.getAttachmentPath().indexOf("../app/") == -1){
			
				String attNameType = a.getAttachmentPath().substring(a.getAttachmentPath().lastIndexOf("."),a.getAttachmentPath().length());
				attNameType = attNameType.toLowerCase();
				if(attN == 0){
					if(c.getHaveContent() == 1){
						attName = new String((c.getContentName() + "_附件" + an 
								+ attNameType).getBytes("gbk"),"iso-8859-1") + ";";
					}else{
						if(an > 1){
							attName = new String((c.getContentName() + "_附件" + (an - 1)
									+ attNameType).getBytes("gbk"),"iso-8859-1") + ";";
						}else{
							attName = new String((c.getContentName() +  attNameType).getBytes("gbk"),"iso-8859-1") + ";";
						}					
					}
				}else{
					attName = new String(a.getShowName().getBytes("gbk"),"iso-8859-1") + ";";
				}
					
					//response.reset();
					//response.addHeader("Content-Disposition", "FileName=" + attName);
					//response.setContentType(attNameType);
					
					try
				    {
						//ResourceUtil.downloadFile(request, response, a.getAttachmentPath());
						String path = "web/admin/attachment/attachmentAdmin.do?method=download" +
						"&path=" + a.getAttachmentPath() + "&showName=" + a.getShowName();
						log.info(path);
						request.getRequestDispatcher(path).forward(request, response);
						
//					RequestDispatcher dispatcher = null;		
//					dispatcher = request.getRequestDispatcher(
//							ResourceUtil.getFilesRootDir() + a.getAttachmentPath());								
//	//				RequestDispatcher dispatcher = request.getRequestDispatcher(basePath);
//						if(dispatcher != null)
//					        {			        	
//					            dispatcher.forward(request,response);
//					        }
//					        response.flushBuffer();
					    }
				    catch(Exception e)
				    {
		//		        e.printStackTrace();
				    }
				    finally{}
		
				    return null;
		  
			}else{
					ActionForward af = new ActionForward();			
					af.setName("att");
					af.setRedirect(true);
					af.setPath("/" + a.getAttachmentPath());
//					af.setPath("/" + a.getAttachmentPath() + java.net.URLEncoder.encode(a.getShowName(),"utf-8"));
					return af;
				}
		
		}
		
	}
	
/*	
	public ActionForward executet(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int an = this.getIntValue(request, "a", 0);	
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
//这里放一个如果是公文就跳到那一页的代码
	
  		if(c.getColumnId() == Constant.gongwen){
			return mapping.findForward("showDocument");
		}

				
		if(an == 0){
//			List<UlAttachment> a = as.getattachmentByContentId(cId);			
//			request.setAttribute("a", a);
			request.setAttribute("c", c);
			
			if(c.getColumnId() == Constant.ad){
				return mapping.findForward("adPage");
			}

			return mapping.findForward("showContent");
		}else{
			UlAttachment a = as.getByContentIdAndOrder(cId, an);	
			response.reset();
		//	response.sendRedirect(Constant.realPath +	java.net.URLEncoder.encode(a.getAttachmentPath(),"utf-8"));
//			request.setAttribute("href", a.getAttachmentPath());
		//	return null;
//			return mapping.findForward("showAttachment");
			
			ActionForward af = new ActionForward();			
			af.setName("att");
			af.setRedirect(true);
//			af.setPath("/dd.txt");
			af.setPath("/" + a.getAttachmentPath());
//			af.setPath("/" + a.getAttachmentPath() + java.net.URLEncoder.encode(a.getShowName(),"utf-8"));
			return af;
		}
		
	}	
	
	

	public ActionForward execute070305(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int an = this.getIntValue(request, "a", 0);	
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
//这里放一个如果是公文就跳到那一页的代码
/*		
  		if(c.getColumnId() == Constant.gongwen){
			return mapping.findForward("showDocument");
		}

		
		
		if(an == 0){
			List<UlAttachment> a = as.getattachmentByContentId(cId);			
			request.setAttribute("a", a);
			request.setAttribute("c", c);
			
/*			if(c.getColumnId() == Constant.ad){
				return mapping.findForward("adPage");
			}

			return mapping.findForward("showContent");
		}else{
			UlAttachment a = as.getByContentIdAndOrder(cId, an);
			
/*
 * 	test
 			
	
		
			   File f = new File(Constant.realPath + a.getAttachmentPath());
				if(!f.exists())
				{
					request.setAttribute("href", "未找到文件");
					return mapping.findForward("showAttachment");
				}
				
		        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f));
		        OutputStream os = null;
		        try{			
				
			        byte[] buf = new byte[1024];
					int len = 0;
					os = response.getOutputStream();
					response.reset(); //非常重要
	//				System.out.print("----" + f.getName());
					//纯下载方式	
					
					response.setCharacterEncoding("utf-8");
					response.setContentType("application/octet-stream; CHARSET=utf8"); 
					response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(a.getShowName(),"UTF-8"));
					//+ f.getName()); 
					response.setContentType("bin;charset=utf-8"); 
				
					while((len = bis.read(buf)) >0)	os.write(buf,0,len);
					
					response.setContentType("<script ");
		        }catch(Exception e){
					System.out.print("用户取消下载或网络中断");
				
				}finally{
					bis.close();
					os.close();
				}

			request.setAttribute("href", a.getAttachmentPath());
//			return null;
			return mapping.findForward("showAttachment");
		}
	}

	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int an = this.getIntValue(request, "a", 0);	
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
		
		if(an == 0){

			request.setAttribute("c", c);			
			return mapping.findForward("showContent");
		}else{
			UlAttachment a = as.getByContentIdAndOrder(cId, an);	
			/*	
			
			response.reset();
//			response.setContentType("application/octet-stream");       //windows
//			response.addHeader("Content-Disposition", "filename=\"" + myName + "\"");      //windows
			response.setContentType("application/octet-stream; charset=GBK");     //linux

			response.addHeader("Content-Disposition", "attachment; filename=\"" +java.net.URLEncoder.encode(a.getShowName(),"utf-8") + "\"");      //linux


//			新建文件输入输出流
			OutputStream output = null;
			FileInputStream fis = null;
			try{
			  //新建File对象
			  File f = new File(Constant.realPath + a.getAttachmentPath());
			  //新建文件输入输出流对象
			  output = response.getOutputStream();
			  fis = new FileInputStream(f);
			  //设置每次写入缓存大小
			  byte[] b = new byte[(int)f.length()];
			  //out.print(f.length());
			  //把输出流写入客户端
			  int i = 0;
			  while((i = fis.read(b)) > 0){
			    output.write(b, 0, i);
			  }
			  output.flush();
			}
			catch(Exception e){
			  e.printStackTrace();
			}
			finally{
			  if(fis != null){
			    fis.close();
			    fis = null;
			  }
			  if(output != null){
			    output.close();
			    output = null;
			  }
			}
			
			return null;
			
		
			  response.setContentType("application/vnd.ms-excel; charset=UTF-8");
              response.addHeader("Content-Disposition", "inline; filename=" + report.getName() + ".xls");
              PrintWriter out = response.getWriter();
              out.print("<html>");
              out.print("<head><meta http-equiv=Content-Type content=\"text/html; charset=utf-8\"></head>");
              out.print("<body>");
              
              out.print(page);
              
              out.print("</body></html>");
              return null;

			
			
			response.reset();

//			response.setContentType("text/html; charset=UTF-8");
//			response.setContentType("application/x-download; charset=UTF-8");
//			response.setContentType("application/octet-stream");     
//			response.setHeader("Content-Disposition", "attachment;FileName="+a.getShowName());     
//			response.sendRedirect(a.getAttachmentPath());   
			
//			response.addHeader("Content-Disposition", "attachment;FileName=" + new String(a.getShowName().getBytes("gbk"),"iso-8859-1") + ";");
			response.addHeader("Content-Disposition", "FileName=" + new String(a.getShowName().getBytes("gbk"),"iso-8859-1") + ";");
			
			try
			    {
			        RequestDispatcher dispatcher = request.getRequestDispatcher(a.getAttachmentPath());
			        if(dispatcher != null)
			        {
			        	
			            dispatcher.forward(request,response);
			        }
			        response.flushBuffer();
			    }
			    catch(Exception e)
			    {
//			        e.printStackTrace();
			    }
			    finally
			    {
			    
			    }

			return null;
			
		
		}
		
	}
	
/*	
	public ActionForward executettt(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int an = this.getIntValue(request, "a", 0);	
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
		
		if(an == 0){

			request.setAttribute("c", c);			
			return mapping.findForward("showContent");
		}else{
			UlAttachment a = as.getByContentIdAndOrder(cId, an);	
	
//			 新建一个SmartUpload对象
			SmartUpload su = new SmartUpload();
//			 初始化
			su.initialize(this.getServlet().getServletConfig(), request, response);
//			 设定contentDisposition为null以禁止浏览器自动打开文件，
//			保证点击链接后是下载文件。若不设定，则下载的文件扩展名为
//			doc时，浏览器将自动用word打开它。扩展名为pdf时，
//			浏览器将用acrobat打开。
			request.setCharacterEncoding("gbk");
			su.setContentDisposition(null);
//			 下载文件			
			su.downloadFile(Constant.realPath  + a.getAttachmentPath(),"",java.net.URLEncoder.encode(a.getShowName(),"gbk") );
		

			return null;
		}
		
	}
	
	*/
}

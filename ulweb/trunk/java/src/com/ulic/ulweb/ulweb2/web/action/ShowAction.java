package com.ulic.ulweb.ulweb2.web.action;

import java.net.InetAddress;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ulic.ulweb.frame.action.BaseAction;
import com.ulic.ulweb.frame.service.ServiceLocator;
import com.ulic.ulweb.ulweb2.dao.IMonitorDao;
import com.ulic.ulweb.ulweb2.entity.AttachmentEntity;
import com.ulic.ulweb.ulweb2.entity.ContentEntity;
import com.ulic.ulweb.ulweb2.entity.ContentTmplEntity;
import com.ulic.ulweb.ulweb2.entity.MonitorEntity;
import com.ulic.ulweb.ulweb2.service.IAttachmentService;
import com.ulic.ulweb.ulweb2.service.IColumnService;
import com.ulic.ulweb.ulweb2.service.IContentService;

public class ShowAction extends BaseAction {

	private IAttachmentService atts = (IAttachmentService) this.getService("attachmentAdminService");
	
	private IContentService cons = (IContentService) this.getService("contentAdminService");
	
	private IColumnService cols = (IColumnService) this.getService("columnAdminService");
		
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		int an = this.getIntValue(request, "a", 0);
		int cId = this.getIntValue(request, "c", 0);
		
		if (cId == 0) {
			request.setAttribute("errorMessage", "请求发生异常，未得到请求内容的编号");
			return mapping.findForward("error");
		}
	
		ContentEntity c = cons.getContentById(cId);
		/*if(cId!=0){
			cons.saveContentClicks(c.getContentId());
		}*/
		
		try {
			StringBuffer sb = new StringBuffer();
			sb.append("show.do?c="+cId);
			IMonitorDao mt = (IMonitorDao) ServiceLocator.getService("monitorDao");
			MonitorEntity me = new MonitorEntity();
			me.setAccessTime(new Date());
			me.setUrl(sb.toString());
			me.setIp(request.getRemoteAddr());	
//			System.out.println(request.getRemoteUser());
			System.out.println(request.getRemoteAddr());
			mt.save(me);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		System.out.println("content:" + c.getAttachmentSum() + "," + c.getHaveContent());
		
		if (c == null) {
			request.setAttribute("errorMessage", "请求发生异常，您所请求的内容已被删除");
			return mapping.findForward("error");
		}

		if (an == 0) {
			
			 if (c.getAttachmentSum() == 1 && c.getHaveContent() == 0) {
				//System.out.println("only 1 att");
				request.getRequestDispatcher("show.do?c=" + c.getContentId() + "&a=1").forward(request,
						response);
				return null;
			} 
			
			String ptype = this.getStringValue(request, "ptype");
			request.setAttribute("c", c);

			ContentTmplEntity tmpl = cols.getContentTmplByColumnId(c.getColumnId());

			if (tmpl == null || tmpl.getTmplContentString() == null) {
				return new ActionForward("/frame/showcontent" + ptype + ".jsp");
			} else {
				
				String htmlStr = cons.showContent(c.getContentId());

				htmlStr = new String(htmlStr.getBytes("utf8"), "iso8859-1");
				ServletOutputStream out = response.getOutputStream();
				out.println(htmlStr);
				return null;
			}

		} else {
			List attList = atts.listAttachmentByContentId(cId);
			AttachmentEntity att = new AttachmentEntity();
			try {
				att = (AttachmentEntity) attList.get(an - 1);
			} catch (Exception e1) {
				e1.printStackTrace();
				request.setAttribute("errorMessage", "不存在该附件");
				return mapping.findForward("error");
				
			}
			

			if (att.getAttachmentPath().indexOf("../app/") == -1) {

				String attNameType = att.getAttachmentPath().substring(
						att.getAttachmentPath().lastIndexOf("."),
						att.getAttachmentPath().length());
				attNameType = attNameType.toLowerCase();


				try {

					String path = "web/admin/attachment/attachmentAdmin.do?method=download"
							+ "&path="
							+ att.getDisplayPath()
							+ "&showName="
							+ c.getContentName() + "_附件" + an
							+ "." + attNameType;		
					// edit by wengxf because some showName is wrong with charset
					//log.info(path);
					request.getRequestDispatcher(path).forward(request,
							response);

				} catch (Exception e) {
					 e.printStackTrace();
				} finally {
				}

				return null;

			} else {
				ActionForward af = new ActionForward();
				af.setName("att");
				af.setRedirect(true);
				af.setPath("/" + att.getAttachmentPath());

				return af;
			}

		}

	}

}

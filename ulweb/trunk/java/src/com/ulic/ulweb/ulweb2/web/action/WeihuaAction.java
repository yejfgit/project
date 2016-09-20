package com.ulic.ulweb.ulweb2.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.ulic.ulweb.frame.action.BaseAction;
import com.ulic.ulweb.frame.constant.Constant;
import com.ulic.ulweb.frame.service.ServiceLocator;
import com.ulic.ulweb.ulweb.entity.UlAttachment;
import com.ulic.ulweb.ulweb.entity.UlColumn;
import com.ulic.ulweb.ulweb.entity.UlContent;
import com.ulic.ulweb.ulweb.entity.UlTemplate;
import com.ulic.ulweb.ulweb.service.IUlAttachmentService;
import com.ulic.ulweb.ulweb.service.IUlColumnService;
import com.ulic.ulweb.ulweb.service.IUlContentService;
import com.ulic.ulweb.ulweb.service.UtilService;
import com.ulic.ulweb.ulweb.util.ContentTool;
import com.ulic.ulweb.ulweb2.dao.IMonitorDao;
import com.ulic.ulweb.ulweb2.entity.AttachmentEntity;
import com.ulic.ulweb.ulweb2.entity.ColumnEntity;
import com.ulic.ulweb.ulweb2.entity.ContentClicksGoodEntity;
import com.ulic.ulweb.ulweb2.entity.ContentEntity;
import com.ulic.ulweb.ulweb2.entity.ContentTmplEntity;
import com.ulic.ulweb.ulweb2.entity.MonitorEntity;
import com.ulic.ulweb.ulweb2.entity.PageEntity;
import com.ulic.ulweb.ulweb2.service.IAttachmentService;
import com.ulic.ulweb.ulweb2.service.IColumnService;
import com.ulic.ulweb.ulweb2.service.IContentService;
import com.ulic.ulweb.ulweb2.util.FormatUtil;

public class WeihuaAction extends BaseAction {


	private IAttachmentService atts = (IAttachmentService) this.getService("attachmentAdminService");
	
	private IContentService cons = (IContentService) this.getService("contentAdminService");
	
	private IColumnService cols = (IColumnService) this.getService("columnAdminService");
	/**
	 * 首页
	 */
	public ActionForward index(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	
		ActionForward af = new ActionForward();

		//Runtime.getRuntime().exec("explorer.exe mailto:yejf001@ulic.com.cn");
		//Foxmail.

		af.setPath("/weihua/index.jsp");
		return af;

	}

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	
		ActionForward af = new ActionForward();

		//Runtime.getRuntime().exec("explorer.exe mailto:yejf001@ulic.com.cn");
		//Foxmail.

		af.setPath("/weihua/list.jsp");
		return af;

	}
	
	public void clicksGood(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	
		ActionForward af = new ActionForward();
		String contentId = request.getParameter("contentId");
		String type = request.getParameter("type");
		
		cons.saveClicksGood(Integer.parseInt(contentId), Integer.parseInt(type));


	}

	
	public void jiazai(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
        
		int clickNum=Integer.parseInt(request.getParameter("clickNum"));
		int columnId=Integer.parseInt(request.getParameter("columnId"));
		int pageSize=Integer.parseInt(request.getParameter("pageSize"));
		int pageNum=Integer.parseInt(request.getParameter("pageNum"));
		String conditions = "isDelete=0:i;isProcessing=0:i;";
		String deptId = request.getParameter("deptId");
		String enName = request.getParameter("enName");
		String keyWord = "";
		
		IContentService cons = (IContentService) ServiceLocator
		.getService("contentAdminService");
		
		PageEntity pe = new PageEntity();

		// Page
		pe.setPageSize(pageSize);
		pe.setPageNum(pageNum);
		

		// EntityName
		try {
			Class c = Class
					.forName("com.ulic.ulweb.ulweb2.entity.ContentEntity");
			pe.setQueryClass(c);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			pe.setQueryClass(null);
		}
		
		
		if (columnId != 0) {
			conditions = "columnId=" + columnId + ":i;"
			+ conditions;
		} else if (!FormatUtil.isNull(enName)) {
			IColumnService cols = (IColumnService) ServiceLocator
					.getService("columnAdminService");
			ColumnEntity column = cols.getColumnByEnname(deptId, enName);
			if (column == null) {
				column = new ColumnEntity();
			}
			conditions = "columnId=" + column.getColumnId() + ":i;"
					+ conditions;
		} else if (!FormatUtil.isNull(deptId)) {
			conditions = "organId=" + deptId + ":s;"
			+ conditions;
		}
		
		DetachedCriteria dc = DetachedCriteria.forClass(ContentEntity.class);
		//log.info("condition:" + conditions + "Key Word:" + keyWord);
		// Key Word
		if (!FormatUtil.isNull(keyWord)) {
			keyWord = ContentTool.unescape(keyWord, "U");
			dc.add(Restrictions.like("contentName", keyWord, MatchMode.ANYWHERE));

		}
		//log.info("condition:" + conditions + "Key Word:" + keyWord);
		
		// Query
		dc.addOrder(Order.desc("orderNum"));
		dc.addOrder(Order.desc("contentId"));
		pe.setCondition(dc);
		pe.setQueryString(conditions);
		
		//pe = cons.listContentByColumnId(pe,true,clickNum,columnId);
		pe = cons.listContentByColumnId(pe,true);
		
		String showStr = "";
		List objectList = pe.getObjectList();
		if(objectList!=null&&objectList.size()>0){
			for(int i=0;i<objectList.size();i++){
				ContentEntity c = (ContentEntity) objectList.get(i);
				List attachmentList = c.getAttachmentList();
				if(attachmentList!=null&&attachmentList.size()>0){
					int imgIndexF = 1;
					for(int j=0;j<attachmentList.size();j++){
						AttachmentEntity attachmentEntity = (AttachmentEntity)attachmentList.get(j);
						if(imgIndexF==1){
							showStr+="<div style='width: 100%;height: 116px;border-bottom: 1px solid #ddd;margin-top: 8px;'>"+
							"	<div style='height: 100%;width: 150px;background-color: #fff;float: left;cursor: pointer;' onclick='openInfo("+c.getContentId()+");'>"+
							"		<img src='"+attachmentEntity.getDisplayPath()+"' style='width: 135px;height: 100px' class='bor'/>"+
							"	</div>"+
							"	<div style='height: 100%;width: 510px;background-color: #fff;float: left;text-align: left;'>"+
							"		<div style='font-size: 19px;padding: 5px 5px;font-weight:bolder;cursor: pointer;'>"+
							"			<a target='_blank' style='text-decoration: none' href='weihua.do?method=show&c="+c.getContentId()+"'>"+
											c.getContentName()+
							"			</a>"+
							"		</div>"+
							"		<div style='padding: 5px 5px;'>"+(c.getKeyWord()==null?"":c.getKeyWord())+"</div>"+
							//"		<bean:define id='element' name='element' property='contentId'></bean:define>"+
							"		<div style='padding: 5px 5px;text-align: right;color: #aaa;font-size: 14px;'>"+cons.getContentClicks(c.getContentId())+"&nbsp;&nbsp;&nbsp;&nbsp;点击</div>"+
							"	</div>"+
							"</div>";
						}
						
						imgIndexF++;
					}
					
				}

			}
		}
		
		PrintWriter prt=response.getWriter();
		prt.print(showStr);
		response.getWriter().close();

	}
	
	
	public ActionForward show(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		int an = this.getIntValue(request, "a", 0);
		int cId = this.getIntValue(request, "c", 0);
		
		if (cId == 0) {
			request.setAttribute("errorMessage", "请求发生异常，未得到请求内容的编号");
			return mapping.findForward("error");
		}
	
		ContentEntity c = cons.getContentById(cId);
		if(cId!=0){
			cons.saveContentClicks(c.getContentId());
		}
		
		try {
			StringBuffer sb = new StringBuffer();
			sb.append("weihua.do?c="+cId);
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
			
			
			List clicksGoodList = cons.getClicksGoodByContentid(cId);
			request.setAttribute("clicksGoodList", clicksGoodList);

			

			ContentTmplEntity tmpl = cols.getContentTmplByColumnId(c.getColumnId());

			if (tmpl == null || tmpl.getTmplContentString() == null) {
				//return new ActionForward("/frame/showcontent" + ptype + ".jsp");
				return new ActionForward("/weihua/show.jsp");
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

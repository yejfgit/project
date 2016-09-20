package com.ulic.ulweb.ulweb.web.action.dept;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ulic.ulweb.frame.action.BaseAction;
import com.ulic.ulweb.ulweb.entity.UlAttachment;
import com.ulic.ulweb.ulweb.entity.UlColumn;
import com.ulic.ulweb.ulweb.entity.UlContent;
import com.ulic.ulweb.ulweb.service.IUlAttachmentService;
import com.ulic.ulweb.ulweb.service.IUlColumnService;
import com.ulic.ulweb.ulweb.service.IUlContentService;
import com.ulic.ulweb.ulweb.util.ContentTool;

public class DangjianAction extends BaseAction {

	// 部门名指定
	final String DEPT_NAME = "dangjian";
	final String NAV_BAR_SEPARATOR = "&nbsp;&gt;&gt;&nbsp;";

	// 栏目英文名指定

	final String JIANJIE = "jianjie";
	final String XUANCHUAN = "xuanchuan";
	final String ZUZHI = "zuzhi";
	final String JIJIAN = "jijian";
	final String WANGSHANG = "wangshang";
	final String TESE = "tese";
	final String ZHIDU = "zhidu";
	final String DIAOCHA = "diaocha";
	final String WENTI = "wenti";
	final String DANGYUAN = "dangyuan";
	final String HUODONG = "huodong";
	final String FAZHANGUAN = "fazhanguan";
	final String WENJIAN = "wenjian";
	final String BIAOZHANG = "biaozhang";
	final String ZUIXIN = "zuixin";
	final String DANGSHI = "dangshi";
	final String REDIAN = "redian";
	final String DANGZUZHI = "dangzuzhi";

	

	private IUlContentService cons = (IUlContentService) this
			.getService("contentService");

	private IUlColumnService cols = (IUlColumnService) this
			.getService("columnService");

	/**
	 * 首页
	 */
	public ActionForward index(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String ptype = this.getStringValue(request, "ptype");

		request.setAttribute(this.REDIAN, 
				cons.getContentListWithAttByEId(this.DEPT_NAME, this.REDIAN, 0, 5, 1));
		request.setAttribute(this.ZUIXIN, 
				cons.getContentByColumnEId(this.DEPT_NAME, this.ZUIXIN, 1, 5));
		request.setAttribute(this.DANGSHI, 
				cons.getContentByColumnEId(this.DEPT_NAME, this.DANGSHI, 1, 5));
		int dangzhibuId = cols.getColumnIdByEId(this.DEPT_NAME, this.DANGZUZHI);
		request.setAttribute(this.DANGZUZHI, 
				cols.getColumnsByParentId(dangzhibuId, this.DEPT_NAME));
		
		request.setAttribute("ptype", ptype);
		return new ActionForward("/dept/" + this.DEPT_NAME + "/index" + ptype
				+ ".jsp");
	}

	/**
	 * 内容列表页
	 */
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String ptype = this.getStringValue(request, "ptype");
		String eId = this.getStringValue(request, "eId", "");
		int page = this.getIntValue(request, "page", 1);
		int pageSize = this.getIntValue(request, "pageSize", 10);

		int columnId = 0;
		if (eId.equals("")) {
			columnId = this.getIntValue(request, "columnId", 0);
		} else {
			columnId = cols.getColumnIdByEId(this.DEPT_NAME, eId);
		}

		UlColumn c = cols.getColumnById(columnId);
		request.setAttribute("column", c);

		request.setAttribute("contentList", cons.getContentByColumnId(columnId,
				page, pageSize));

		
		// nav bar 分隔符是>>
		request.setAttribute("nav_bar", 
				cols.getNavBarByLeafId(columnId, this.NAV_BAR_SEPARATOR));
		
		request.setAttribute("totalPage", cons.getContentTotlePage(columnId,
				pageSize));
		request.setAttribute("page", page);
		return new ActionForward("/dept/" + this.DEPT_NAME + "/list" + ptype
				+ ".jsp");
	}

	
	/**
	 * 内容详细页
	 */
	public ActionForward detail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String ptype = this.getStringValue(request, "ptype");
		
		int cId = this.getIntValue(request, "c", 0);
		String eId = this.getStringValue(request, "eId");
		if (!eId.equals("")) {
			UlContent uc = cons.getLastContentInColumnEId(this.DEPT_NAME, eId);
			if (uc == null) {
				request.setAttribute("errormassage", "对不起，该内容暂时不存在，请访问本站点的其他内容");
				return mapping.findForward("error");
			} else {
				cId = uc.getContentId();
			}
			//System.out.println("****************** c=" + cId);
		}


		int an = this.getIntValue(request, "a", 0);
		int attN = this.getIntValue(request, "attN", 0);
		if (cId == 0) {
			request.setAttribute("errormassage", "请求发生异常，未得到请求内容的编号");
			return mapping.findForward("error");
		}
		IUlAttachmentService as = (IUlAttachmentService) this
				.getService("attachmentService");
		UlContent c = as.getContentById(cId);
		if (c == null) {
			request.setAttribute("errormassage", "请求发生异常，您所请求的内容已被删除");
			return mapping.findForward("error");
		}
		
		// nav bar 分隔符是>>
		request.setAttribute("nav_bar", 
				cols.getNavBarByLeafId(c.getColumnId(), this.NAV_BAR_SEPARATOR));
		

		if (an == 0) {

			request.setAttribute("c", c);
			ActionForward af = new ActionForward();
			af.setName("att");
			af.setPath("/dept/" + this.DEPT_NAME + "/detail" + ptype + ".jsp");
			return af;
		} else {
			UlAttachment a = as.getByContentIdAndOrder(cId, an);
			String attName = null;
			// String attNameType =
			// a.getAttachmentPath().substring(a.getAttachmentPath().indexOf("."),a.getAttachmentPath().length());
			if (a.getAttachmentPath().indexOf("../app/") == -1) {

				String attNameType = a.getAttachmentPath().substring(
						a.getAttachmentPath().lastIndexOf("."),
						a.getAttachmentPath().length());
				attNameType = attNameType.toLowerCase();
				if (attN == 0) {
					if (c.getHaveContent() == 1) {
						attName = new String(
								(c.getContentName() + "_附件" + an + attNameType)
										.getBytes("gbk"), "iso-8859-1")
								+ ";";
					} else {
						if (an > 1) {
							attName = new String((c.getContentName() + "_附件"
									+ (an - 1) + attNameType).getBytes("gbk"),
									"iso-8859-1")
									+ ";";
						} else {
							attName = new String(
									(c.getContentName() + attNameType)
											.getBytes("gbk"), "iso-8859-1")
									+ ";";
						}
					}
				} else {
					attName = new String(a.getShowName().getBytes("gbk"),
							"iso-8859-1")
							+ ";";
				}

				response.reset();
				response
						.addHeader("Content-Disposition", "FileName=" + attName);

				try {
					RequestDispatcher dispatcher = null;
					dispatcher = request.getRequestDispatcher(a
							.getAttachmentPath());
					// RequestDispatcher dispatcher =
					// request.getRequestDispatcher(basePath);
					if (dispatcher != null) {
						dispatcher.forward(request, response);
					}
					response.flushBuffer();
				} catch (Exception e) {
					// e.printStackTrace();
				} finally {
				}

				return null;

			} else {
				ActionForward af = new ActionForward();
				af.setName("att");
				af.setRedirect(true);
				af.setPath("/" + a.getAttachmentPath());
				// af.setPath("/" + a.getAttachmentPath() +
				// java.net.URLEncoder.encode(a.getShowName(),"utf-8"));
				return af;
			}

		}


		//return new ActionForward("/dept/" + this.DEPT_NAME + "/detail" + ptype
		//		+ ".jsp");
	}

}

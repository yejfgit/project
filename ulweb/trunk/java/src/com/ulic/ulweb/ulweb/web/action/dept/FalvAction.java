package com.ulic.ulweb.ulweb.web.action.dept;

import java.util.List;

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

public class FalvAction extends BaseAction {

	// 部门名指定
	final String DEPT_NAME = "falv";
	final String NAV_BAR_SEPARATOR = "&nbsp;&gt;&gt;&nbsp;";

	// 栏目英文名指定
	final String JIANJIE = "jianjie";
	final String TONGXUNLU = "tongxunlu";
	final String BIAOGE = "biaoge";
	final String TUPIAN1 = "tupian1";
	final String TUPIAN2 = "tupian2";
	final String FALV_FAGUI = "falv_fagui";
	final String SIFA_JIESHI = "sifa_jieshi";
	final String JIANGUAN_WENJIAN = "jianguan_wenjian";
	
	final String ZHENGCE_FAGUI = "zhengce_fagui";
	
	final String NEIKONG_ZHIDU = "neikong_zhidu";
	final String GONGZUO_TONGZHI = "gongzuo_tongzhi";
	final String PEIXUN_XUANCHUAN = "peixun_xuanchuan";
	final String KEHU_HEIMINGDAN = "kehu_heimingdan";
	final String GONGGAO = "gonggao";
	final String GONGZUO_DONGTAI = "gongzuo_dongtai";
	final String ZHIDU_WENJIAN = "zhidu_wenjian";
	final String GAOSHAN_YANGZHI = "gaoshan_yangzhi";
	final String PEIXUN_YUANDI = "peixun_yuandi";
	final String FANBEN_HETONG = "fanben_hetong";
	final String DIANZI_ZAZHI = "dianzi_zazhi";
	final String RECENT_LIST = "recent_list";
	

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

		request.setAttribute(this.TUPIAN1, 
				cons.getContentListWithAttByEId(this.DEPT_NAME, this.TUPIAN1, 0, 1, 1));
		request.setAttribute(this.TUPIAN2, 
				cons.getContentListWithAttByEId(this.DEPT_NAME, this.TUPIAN2, 0, 1, 1));

		request.setAttribute(this.FALV_FAGUI, 
				cons.getContentByColumnEId(this.DEPT_NAME, this.FALV_FAGUI, 1, 5));
		request.setAttribute(this.SIFA_JIESHI, 
				cons.getContentByColumnEId(this.DEPT_NAME, this.SIFA_JIESHI, 1, 5));
		request.setAttribute(this.JIANGUAN_WENJIAN, 
				cons.getContentByColumnEId(this.DEPT_NAME, this.JIANGUAN_WENJIAN, 1, 5));
		
		request.setAttribute(this.ZHENGCE_FAGUI, 
				cons.getContentByColumnEId(this.DEPT_NAME, this.ZHENGCE_FAGUI, 1, 5));
		
		request.setAttribute(this.NEIKONG_ZHIDU, 
				cons.getContentByColumnEId(this.DEPT_NAME, this.NEIKONG_ZHIDU, 1, 5));
		request.setAttribute(this.GONGZUO_TONGZHI, 
				cons.getContentByColumnEId(this.DEPT_NAME, this.GONGZUO_TONGZHI, 1, 5));
		request.setAttribute(this.PEIXUN_XUANCHUAN, 
				cons.getContentByColumnEId(this.DEPT_NAME, this.PEIXUN_XUANCHUAN, 1, 5));
		request.setAttribute(this.KEHU_HEIMINGDAN, 
				cons.getContentByColumnEId(this.DEPT_NAME, this.KEHU_HEIMINGDAN, 1, 5));
		request.setAttribute(this.GONGGAO, 
				cons.getContentByColumnEId(this.DEPT_NAME, this.GONGGAO, 1, 8));
		request.setAttribute(this.ZHIDU_WENJIAN, 
				cons.getContentByColumnEId(this.DEPT_NAME, this.ZHIDU_WENJIAN, 1, 6));
		request.setAttribute(this.PEIXUN_YUANDI, 
				cons.getContentByColumnEId(this.DEPT_NAME, this.PEIXUN_YUANDI, 1, 6));
		request.setAttribute(this.GONGZUO_DONGTAI, 
				cons.getContentByColumnEId(this.DEPT_NAME, this.GONGZUO_DONGTAI, 1, 6));

		
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
		int columnId = this.getIntValue(request, "columnId", 0);

		if (columnId == 0) {
			columnId = cols.getColumnIdByEId(this.DEPT_NAME, eId);
		}

		UlColumn c = cols.getColumnById(columnId);
		
		if (c.getIncludeColumn() == 1) {
			List<UlColumn> list = cols.getListByParentIdForShow(c.getColumnId(), this.DEPT_NAME, 1);
			c = list.get(0);
		}
		
		if (c.getParentId() != 0) {
			UlColumn p = cols.getColumnById(c.getParentId());
			List<UlColumn> list = cols.getListByParentIdForShow(c.getParentId(), this.DEPT_NAME, 1);

			request.setAttribute("parentName", p.getColumnName());
			request.setAttribute("columnList", list);
		}
		request.setAttribute("column", c);

		request.setAttribute("contentList", cons.getContentByColumnId(c.getColumnId(),
				page, pageSize));
		
		// head & recent
		request.setAttribute(this.TUPIAN1, 
				cons.getContentListWithAttByEId(this.DEPT_NAME, this.TUPIAN1, 0, 1, 1));
		request.setAttribute(this.RECENT_LIST, 
				cons.getContentByNearDayIndept(this.DEPT_NAME, 7, 6));

		// nav bar 分隔符是>>
		request.setAttribute("nav_bar", 
				cols.getNavBarByLeafId(c.getColumnId(), this.NAV_BAR_SEPARATOR));
		
		request.setAttribute("totalPage", cons.getContentTotlePage(c.getColumnId(),
				pageSize));
		request.setAttribute("page", page);
		return new ActionForward("/dept/" + this.DEPT_NAME + "/list" + ptype
				+ ".jsp");
	}

	/**
	 * 内容搜索页
	 */
	public ActionForward search(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String ptype = this.getStringValue(request, "ptype");

		int page = this.getIntValue(request, "page", 1);
		int pageSize = this.getIntValue(request, "pageSize", 10);

		String keyWord = this.getStringValue(request, "keyWord");
		//System.out.println(keyWord);
		keyWord = ContentTool.unescape(keyWord, "U");
		//System.out.println(keyWord);
		
		StringBuffer sb = new StringBuffer();
		sb.append(" where content_name like '%" + keyWord + "%' ");
		sb.append(" and is_delete = 0 ");
		sb.append(" and organ_id = '" + this.DEPT_NAME + "' ");

		request.setAttribute("contentList", cons.getCheck(sb.toString(), page, pageSize));
		UlColumn c = new UlColumn();
		c.setColumnName("“" + keyWord + "”的搜索结果");
		request.setAttribute("column", c);
		
		
		// head & recent
		request.setAttribute(this.TUPIAN1, 
				cons.getContentListWithAttByEId(this.DEPT_NAME, this.TUPIAN1, 0, 1, 1));
		request.setAttribute(this.RECENT_LIST, 
				cons.getContentByNearDayIndept(this.DEPT_NAME, 7, 6));

		// nav bar 分隔符是>>
		request.setAttribute("nav_bar", this.NAV_BAR_SEPARATOR + "“" + keyWord + "”的搜索结果");
		
		request.setAttribute("totalPage", cons.getCheckTotlePage(sb.toString(), pageSize));
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
		
		// head & recent
		request.setAttribute(this.TUPIAN1, 
				cons.getContentListWithAttByEId(this.DEPT_NAME, this.TUPIAN1, 0, 1, 1));
		request.setAttribute(this.RECENT_LIST, 
				cons.getContentByNearDayIndept(this.DEPT_NAME, 7, 6));

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
			
			request.getRequestDispatcher("show.do?c=" + cId + "&a=" + an).forward(request, response);
			return null;
/*			
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
*/
		}


		//return new ActionForward("/dept/" + this.DEPT_NAME + "/detail" + ptype
		//		+ ".jsp");
	}

}

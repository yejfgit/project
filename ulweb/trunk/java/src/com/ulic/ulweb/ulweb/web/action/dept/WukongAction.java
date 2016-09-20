package com.ulic.ulweb.ulweb.web.action.dept;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ulic.ulweb.frame.action.BaseAction;
import com.ulic.ulweb.frame.constant.Constant;
import com.ulic.ulweb.ulweb.entity.UlColumn;
import com.ulic.ulweb.ulweb.entity.UlContent;
import com.ulic.ulweb.ulweb.entity.UlTemplate;
import com.ulic.ulweb.ulweb.service.IUlColumnService;
import com.ulic.ulweb.ulweb.service.IUlContentService;
import com.ulic.ulweb.ulweb.service.UtilService;

public class WukongAction extends BaseAction{
	
	
	//-------------prd-------------------
	int gonggao1 = 1159;		//公告文件1 公告
	int gonggao2 = 1160;		//公告文件2 采购
	int gonggao3 = 1161;		//公告文件3 职场
	int zhengce1 = 1157;		//管理政策1 采购
	int zhengce2 = 1158;		//管理政策2 职场
	int chanpin1 = 1162;		//产品信息1 IT
	int chanpin2 = 1163;		//产品信息2 综合
	//-----------------------------------
	
	
	public ActionForward index(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String ptype = this.getStringValue(request, "ptype");

		int countProcesser = ((UtilService)this.getService("utilService")).getCountProcesser("market");
		request.setAttribute("countProcesser",countProcesser);

		
		IUlContentService cons = (IUlContentService)this.getService("contentService");
		IUlColumnService cs = (IUlColumnService)this.getService("columnService");
		
		request.setAttribute("gonggao1", cons.getContentByColumnId(gonggao1, 1, 3));
		request.setAttribute("gonggao2", cons.getContentByColumnId(gonggao2, 1, 3));
		request.setAttribute("gonggao3", cons.getContentByColumnId(gonggao3, 1, 3));
		
		request.setAttribute("zhengce1", cons.getContentByColumnId(zhengce1, 1, 1));
		request.setAttribute("zhengce2", cons.getContentByColumnId(zhengce2, 1, 1));

		request.setAttribute("chanpin1", cons.getContentByColumnId(chanpin1, 1, 1));
		request.setAttribute("chanpin2", cons.getContentByColumnId(chanpin2, 1, 1));

		
		ActionForward af = new ActionForward();
		af.setPath("/dept/wukong/index" + ptype + ".jsp");
		return af;
	}

	
	public ActionForward subPage2(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String ptype = this.getStringValue(request, "ptype");
		int columnId = this.getIntValue(request, "columnId", 0);
		int page = this.getIntValue(request, "page", 1);
		int pageSize = this.getIntValue(request, "pageSize", 10);
		
		if(columnId == 0){
			request.setAttribute("errorMessage", "没有得到columnId");
			return mapping.findForward("error");
		}
		
		IUlContentService cons = (IUlContentService)this.getService("contentService");
		IUlColumnService cs = (IUlColumnService)this.getService("columnService");

		UlColumn c = cs.getColumnById(columnId);
		request.setAttribute("column", c);
		request.setAttribute("columnList", cs.getListByParentIdForShow(c.getParentId(), "wukong", 1));
		request.setAttribute("contentList", cons.getContentByColumnId(columnId, page, pageSize));
		request.setAttribute("totlePage",cons.getContentTotlePage(columnId,pageSize));
		request.setAttribute("page",page);
		ActionForward af = new ActionForward();
		af.setPath("/dept/wukong/subpage2" + ptype + ".jsp");
		return af;
	}
	
	
	public ActionForward check(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {	
		
		int show = this.getIntValue(request, "show", 1);	
		String ptype = this.getStringValue(request, "ptype");
		String dept = "wukong";
		int columnId = this.getIntValue(request, "columnId", 0);
		IUlContentService cons = (IUlContentService)this.getService("contentService");

		StringBuffer sb = new StringBuffer();
		int page = this.getIntValue(request, "page", 1);		
		int ti = 0;		
		String ts = this.getStringValue(request, "condition");
		String forward = this.getStringValue(request, "forward", "/dept/wukong/checkshow" );
		forward += ptype;
		if(!ts.equals("")){
			sb.append(ts);
		}else{
			sb.append(" where organ_id = '" + dept + "' and is_delete = 0 ");
			ts = this.getStringValue(request, "tName");				
			if(!ts.equals("")){
				sb.append(" and content_name like '%" + ts.toLowerCase() + "%' ");
			}
			ti = this.getIntValue(request, "type", 0);
			if(ti != 0){
				sb.append(" and column_id = " + ti + " ");
			}

			ts = this.getStringValue(request, "keyWord");
			if(!ts.equals("")){
				sb.append(" and key_word like '%" + ts + "%' ");
			}
				
		}				
		int pageSize = this.getIntValue(request, "pageSize", Constant.indexPageSize);
	
		int totlePage = cons.getCheckTotlePage(sb.toString(), pageSize);
		
		if(page > totlePage && totlePage > 1) page = totlePage;
		List list = cons.getCheck(sb.toString(), page, pageSize);
		
	
		request.setAttribute("condition", sb.toString());
				
		request.setAttribute("totlePage", totlePage);

		request.setAttribute("contentList", list);
		request.setAttribute("page",page);

		ActionForward af = new ActionForward();
		af.setName("ok");
		af.setPath( forward + ".jsp");
		return af;
		
	}
	
	
}

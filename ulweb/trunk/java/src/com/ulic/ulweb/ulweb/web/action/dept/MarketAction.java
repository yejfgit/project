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

public class MarketAction extends BaseAction{
	
	public ActionForward index(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String ptype = this.getStringValue(request, "ptype");
//080116增加统计用户访问量功能
		int countProcesser = ((UtilService)this.getService("utilService")).getCountProcesser("market");
		request.setAttribute("countProcesser",countProcesser);
		
		
		int gonggao = 148;//公告
		int wenjian = 204;//文件
		int subao = 149;//速报
		int baojianhui = 248;//保监会文件
		int xiangmu = 3506;//重点项目
		
//081009 早安合众
		int zaoan = 667;
		
//		int renli = 153;//人力  内容
		int biaobao = 153;//标保达成  内容
						
//		int jingying = 141;//经营分析
		int chanpin = 142;//产品园地
		int tashan = 143;//他山之石  
		int jili = 144;//竞赛激励
		int ziyuan = 145;//资源共享
		int dudao = 146;//督导园地

		 
		
		int lanmu = 247;//中间的活动栏目
		
		IUlContentService cons = (IUlContentService)this.getService("contentService");
		IUlColumnService cs = (IUlColumnService)this.getService("columnService");
		
		List<UlTemplate> listTemplate = cons.getTemplateByColumnId( 99999, 9, "market");	
		request.setAttribute("template",(listTemplate.get(0) == null ? (new UlTemplate()) : listTemplate.get(0)));	
		
//		request.setAttribute("gonggao", cons.getContentByColumnId(gonggao,1,5));
		request.setAttribute("gonggao", cons.getContentWithContentStrByColumnId(gonggao,1,3));
		request.setAttribute("wenjian", cons.getContentByColumnId(wenjian,1,5));
		request.setAttribute("baojianhui", cons.getContentByColumnId(baojianhui,1,4));
//081009		
		request.setAttribute("zaoan", cons.getContentByColumnId(zaoan,1,8));
		
		
		request.setAttribute("subao", cons.getContentByColumnId(subao, 1, 5));
//		request.setAttribute("renli", cons.getLastContentInColumnId(renli));
		request.setAttribute("biaobao", cons.getLastContentInColumnId(biaobao));
		
//		request.setAttribute("jingying", cs.getListByParentIdForShow(jingying,"market", 1));
		request.setAttribute("chanpin", cs.getListByParentIdForShow(chanpin,"market", 1));
		request.setAttribute("tashan", cs.getListByParentIdForShow(tashan,"market", 1));
		request.setAttribute("jili", cs.getListByParentIdForShow(jili,"market", 1));
		request.setAttribute("ziyuan", cs.getListByParentIdForShow(ziyuan,"market", 1));
		request.setAttribute("xiangmu", cs.getListByParentIdForShow(xiangmu,"market", 1));
		request.setAttribute("columnForCheck", cs.getListByDeptForColumn("market", 0,1,1,0));
//		request.setAttribute("wenjian", cs.getListByParentIdForShow(wenjian,"market", 1));
		request.setAttribute("lanmu", cons.getContentListWithAtt(lanmu,0,10,1));
		
		ActionForward af = new ActionForward();
		af.setPath("/dept/market/index" + ptype + ".jsp");
		return af;
	}
	
	public ActionForward subPage1(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String ptype = this.getStringValue(request, "ptype");
		int columnId = this.getIntValue(request, "columnId", 0);
		int page = this.getIntValue(request, "page", 1);
		int pageSize = this.getIntValue(request, "pageSize", 0);		
		
		if(columnId == 0){
			request.setAttribute("errorMessage", "没有得到columnId");
			return mapping.findForward("error");
		}
		
		IUlContentService cons = (IUlContentService)this.getService("contentService");
		IUlColumnService cs = (IUlColumnService)this.getService("columnService");
		List<UlTemplate> listTemplate = cons.getTemplateByColumnId( columnId, 1, "market");	
		request.setAttribute("template",(listTemplate.get(0) == null ? (new UlTemplate()) : listTemplate.get(0)));	
		
		if(pageSize == 0)pageSize = listTemplate.get(0).getPageSize();	
		
		UlColumn c = cs.getColumnById(columnId);
		request.setAttribute("column", c);
//		request.setAttribute("columnList", cs.getListByParentIdForShow(c.getParentId(), "market", 1));
		request.setAttribute("contentList", cons.getContentByColumnId(columnId, page, pageSize));
		request.setAttribute("totlePage",cons.getContentTotlePage(columnId,pageSize));
		request.setAttribute("page",page);
		ActionForward af = new ActionForward();
		af.setPath("/dept/market/subpage1" + ptype + ".jsp");
		return af;
	}
	

	public ActionForward subPage2(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String ptype = this.getStringValue(request, "ptype");
		int columnId = this.getIntValue(request, "columnId", 0);
		int page = this.getIntValue(request, "page", 1);
		int pageSize = this.getIntValue(request, "pageSize", 0);		
		
		if(columnId == 0){
			request.setAttribute("errorMessage", "没有得到columnId");
			return mapping.findForward("error");
		}
		
		IUlContentService cons = (IUlContentService)this.getService("contentService");
		IUlColumnService cs = (IUlColumnService)this.getService("columnService");
		List<UlTemplate> listTemplate = cons.getTemplateByColumnId( columnId, 2, "market");	
		request.setAttribute("template",(listTemplate.get(0) == null ? (new UlTemplate()) : listTemplate.get(0)));			
		if(pageSize == 0)pageSize = listTemplate.get(0).getPageSize();
		UlColumn c = cs.getColumnById(columnId);
		request.setAttribute("column", c);
		request.setAttribute("columnList", cs.getListByParentIdForShow(c.getParentId(), "market", 1));
		request.setAttribute("contentList", cons.getContentByColumnId(columnId, page, pageSize));
		request.setAttribute("totlePage",cons.getContentTotlePage(columnId,pageSize));
		request.setAttribute("page",page);
		ActionForward af = new ActionForward();
		af.setPath("/dept/market/subpage2" + ptype + ".jsp");
		return af;
	}
	
	
	public ActionForward check(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {	
		
		int show = this.getIntValue(request, "show", 1);	
		String ptype = this.getStringValue(request, "ptype");
		String dept = "market";
		int columnId = this.getIntValue(request, "columnId", 0);
		IUlContentService cons = (IUlContentService)this.getService("contentService");
		List<UlTemplate> listTemplate = cons.getTemplateByColumnId( columnId, 1, dept);	
		
		request.setAttribute("template", listTemplate.get(0));
		StringBuffer sb = new StringBuffer();
		int page = this.getIntValue(request, "page", 1);		
		int ti = 0;		
		String ts = this.getStringValue(request, "condition");
		String forward = this.getStringValue(request, "forward", "/dept/market/checkshow" );
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
/*			ts = this.getStringValue(request, "ts");
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
*/						
		}				
		int pageSize = this.getIntValue(request, "pageSize", Constant.indexPageSize);
	
		int totlePage = cons.getCheckTotlePage(sb.toString(), pageSize);
		
//		List clist = cons.getListByColumnLevelAndDept(1, dept, show);		
		if(page > totlePage && totlePage > 1) page = totlePage;
		List list = cons.getCheck(sb.toString(), page, pageSize);
		
	
		request.setAttribute("condition", sb.toString());
				
		request.setAttribute("totlePage", totlePage);
//		request.setAttribute("columnList",clist);
//		request.setAttribute("columnId",columnId);
		request.setAttribute("template", listTemplate.get(0));
		request.setAttribute("contentList", list);
		request.setAttribute("page",page);

		ActionForward af = new ActionForward();
		af.setName("ok");
		af.setPath( forward + ".jsp");
		return af;
		
	}
	
	
}

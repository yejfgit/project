package com.ulic.ulweb.ulweb.web.action.dept;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ulic.ulweb.frame.action.BaseAction;
import com.ulic.ulweb.frame.constant.Constant;
import com.ulic.ulweb.ulweb.entity.UlContent;
import com.ulic.ulweb.ulweb.entity.UlTemplate;
import com.ulic.ulweb.ulweb.service.IUlColumnService;
import com.ulic.ulweb.ulweb.service.IUlContentService;

public class CddAction extends BaseAction{

	public ActionForward index(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String dept = this.getStringValue(request, "dept","cdd");
		String ptype = this.getStringValue(request, "ptype");
				
		IUlContentService cons = (IUlContentService)this.getService("contentService");
		List<UlTemplate> listTemplate = cons.getTemplateByColumnId( 99999, 9, dept);		
		IUlColumnService cs = (IUlColumnService)this.getService("columnService");
		
//右侧和中间列表	
		int contentcenter1 = this.getIntValue(request, "c1c", 128);		
		int contentRight1 = this.getIntValue(request, "r1c", 129);		
		int contentRight2 = this.getIntValue(request, "r2c", 130);
		int contentRight3 = this.getIntValue(request, "r3c", 131);
		
		List contentListRight2 = cons.getContentListWithAtt(contentRight2, 0, 3,1);		
		List contentListRight1 = cons.getContentByColumnId(contentRight1, 1, 10);
		List contentListcenter1 = cons.getContentByColumnId(contentcenter1, 1, 10);
		List contentListRight3 = cons.getContentByColumnId(contentRight3, 1, 10);
		
//上部栏目列表		
		int columnIdTop1 = this.getIntValue(request, "ct1", 122);		
		List columnListTop1 = cs.getListByParentIdForShow(columnIdTop1, dept, 1);	
		
//		领导寄语
		int lingdao = this.getIntValue(request, "sc1", 132);
		UlContent lingdaojiyu = cons.getLastContentInColumnId(lingdao);
		request.setAttribute("lingdaojiyu", lingdaojiyu);

//得到查询用的栏目名
		List columnListForCheck = cs.getListByDeptForColumn(dept, 0,1,1,0);
		
		request.setAttribute("template",(listTemplate.get(0) == null ? (new UlTemplate()) : listTemplate.get(0)));	
		request.setAttribute("columnListTop1",columnListTop1);
		request.setAttribute("columnForCheck", columnListForCheck);
		
		request.setAttribute("contentListCenter1", contentListcenter1);
		request.setAttribute("contentListRight1", contentListRight1);
		request.setAttribute("contentListRight2", contentListRight2);
		request.setAttribute("contentListRight3", contentListRight3);

		ActionForward af = new ActionForward();
		af.setName("ok");
		af.setPath("/dept/" + dept + "/index" + ptype + ".jsp");
		return af;
	}
	
	public ActionForward subPage1(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String ptype = this.getStringValue(request, "ptype");
		String dept = this.getStringValue(request, "dept", "cdd");
		String forward = null;
		int columnId = this.getIntValue(request, "columnId", 0);
		int page = this.getIntValue(request, "page", 1); 
		int pageSize = this.getIntValue(request, "pageSize", 0);		
		
		if(columnId == 0){
			request.setAttribute("errorMessage", "没有得到columnId");
			return mapping.findForward("error");
		}	
		IUlContentService cons = (IUlContentService)this.getService("contentService");
		List<UlTemplate> listTemplate = cons.getTemplateByColumnId( columnId, 1, dept);	
		IUlColumnService cs = (IUlColumnService)this.getService("columnService");
		
//		领导寄语
		int lingdao = this.getIntValue(request, "sc1", 132);
		UlContent lingdaojiyu = cons.getLastContentInColumnId(lingdao);
		request.setAttribute("lingdaojiyu", lingdaojiyu);
		
//		上部栏目列表		
		int columnIdTop1 = this.getIntValue(request, "ct1", 122);		
		List columnListTop1 = cs.getListByParentIdForShow(columnIdTop1, dept, 1);	
		request.setAttribute("columnListTop1",columnListTop1);
		
//		得到查询用的栏目名
		List columnListForCheck = cs.getListByDeptForColumn(dept, 0,1,1,0);
		request.setAttribute("columnForCheck", columnListForCheck);
		
		
		request.setAttribute("column",cs.getColumnById(columnId));
		request.setAttribute("template",(listTemplate.get(0) == null ? (new UlTemplate()) : listTemplate.get(0)));	
		
		if(pageSize == 0)pageSize = listTemplate.get(0).getPageSize();			
		
		request.setAttribute("columnId",columnId);
		request.setAttribute("contentList", cons.getContentByColumnId(columnId,page, pageSize));
		request.setAttribute("totlePage",cons.getContentTotlePage(columnId,pageSize));
		request.setAttribute("page",page);
		forward = "/dept/" + dept + "/subpage1" + ptype + ".jsp";
		
		ActionForward af = new ActionForward();
		af.setName("ok");
		af.setPath( forward );
		return af;
	}
	
	public ActionForward check(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {	
		
		int show = this.getIntValue(request, "show", 1);	
		String ptype = this.getStringValue(request, "ptype");
		String dept = this.getStringValue(request, "dept", "cdd");
		int columnId = this.getIntValue(request, "columnId", 0);
		IUlContentService cons = (IUlContentService)this.getService("contentService");
		List<UlTemplate> listTemplate = cons.getTemplateByColumnId( columnId, 1, dept);	
		
		

		
		request.setAttribute("template", listTemplate.get(0));
		StringBuffer sb = new StringBuffer();
		int page = this.getIntValue(request, "page", 1);		
		int ti = 0;		
		String ts = this.getStringValue(request, "condition");
		String forward = this.getStringValue(request, "forward", "/dept/ed/checkshow" );
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
		int pageSize = this.getIntValue(request, "pageSize", Constant.indexPageSize);
	
		int totlePage = cons.getCheckTotlePage(sb.toString(), pageSize);
		
		List clist = cons.getListByColumnLevelAndDept(1, dept, show);		
		if(page > totlePage && totlePage > 1) page = totlePage;
		List list = cons.getCheck(sb.toString(), page, pageSize);
		
		IUlColumnService cs = (IUlColumnService)this.getService("columnService");
		
//		领导寄语
		int lingdao = this.getIntValue(request, "sc1", 132);
		UlContent lingdaojiyu = cons.getLastContentInColumnId(lingdao);
		request.setAttribute("lingdaojiyu", lingdaojiyu);
		
//		上部栏目列表		
		int columnIdTop1 = this.getIntValue(request, "ct1", 122);		
		List columnListTop1 = cs.getListByParentIdForShow(columnIdTop1, dept, 1);	
		request.setAttribute("columnListTop1",columnListTop1);
		
//		得到查询用的栏目名
		List columnListForCheck = cs.getListByDeptForColumn(dept, 0,1,1,0);
		request.setAttribute("columnForCheck", columnListForCheck);
		
		
		request.setAttribute("condition", sb.toString());
				
		request.setAttribute("totlePage", totlePage);
		request.setAttribute("columnList",clist);
		request.setAttribute("columnId",columnId);
		request.setAttribute("template", listTemplate.get(0));
		request.setAttribute("contentList", list);
		request.setAttribute("page",page);

		ActionForward af = new ActionForward();
		af.setName("ok");
		af.setPath( forward + ".jsp");
		return af;
		
	}
}

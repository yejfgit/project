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

	public class ZhixingAction extends BaseAction{
		public ActionForward index(ActionMapping mapping, ActionForm form, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			//取部门号
			String dept = this.getStringValue(request, "dept","zhixing");
			String ptype = this.getStringValue(request, "ptype");
			//取栏目号（文件夹的）		
			int columnIdTop1 = this.getIntValue(request, "ct1", 1429);
			int columnIdRight1 = this.getIntValue(request, "cr1", 1431);	
		     //取内容号
			int contentLeft2 = this.getIntValue(request, "l2c", 1480);
			int contentRight1 = this.getIntValue(request, "r1c", 1473);
			int contentRight2 = this.getIntValue(request, "r2c", 1478);
			//中间的图片及文字
			int contentCenter1 = this.getIntValue(request, "news", 1479);
			int contentCenter2 = this.getIntValue(request, "news", 1481);
			
			IUlContentService cons = (IUlContentService)this.getService("contentService");
			List<UlTemplate> listTemplate = cons.getTemplateByColumnId( 99999, 9, dept);		
			IUlColumnService cs = (IUlColumnService)this.getService("columnService");

//	文件列表	
			//快速取部门内勾选了允许快捷显示的前五条
			List contentListLeft1 = cons.getQuickLinkByDept("zhixing", 1, 5);
			//取带文件的栏目文章三个
			List contentListLeft2 = cons.getContentListWithAtt(contentLeft2, 0, 3,1);
			//取栏目的文章二十个
			List contentListRight1 = cons.getContentByColumnId(contentRight1, 1, 20);
			List contentListRight2 = cons.getContentByColumnId(contentRight2, 1, 20);
			
//	栏目列表		
			//取栏目下的子栏目名
			List columnListTop1 = cs.getColumnsByParentId(columnIdTop1, dept);
			List columnListRight1 = cs.getColumnsByParentId(columnIdRight1, dept);
			
//	主页上部显示题目和内容	
			//取最后上传的文章
			UlContent news1 = cons.getLastContentInColumnId(contentCenter1);
			UlContent news2 = cons.getLastContentInColumnId(contentCenter2);
			
			request.setAttribute("template",(listTemplate.get(0) == null ? (new UlTemplate()) : listTemplate.get(0)));	
			request.setAttribute("columnListTop1",columnListTop1);
			request.setAttribute("columnListRight1",columnListRight1);
			
			request.setAttribute("contentListLeft1", contentListLeft1);
			request.setAttribute("contentListLeft2", contentListLeft2);
			request.setAttribute("contentListRight1", contentListRight1);
			request.setAttribute("contentListRight2", contentListRight2);
			
			request.setAttribute("contentNews1", news1);
			request.setAttribute("contentNews2", news2);

			ActionForward af = new ActionForward();
			af.setName("ok");
			af.setPath("/dept/" + dept + "/index" + ptype + ".jsp");
			return af;
		}
		
		public ActionForward subPage1(ActionMapping mapping, ActionForm form, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			
			String ptype = this.getStringValue(request, "ptype");
			String dept = this.getStringValue(request, "dept", "zhixing");
			String forward = null;
			int columnId = this.getIntValue(request, "columnId", 0);
			int page = this.getIntValue(request, "page", 1);
			int pageSize = this.getIntValue(request, "pageSize", 0);		
			
			if(columnId == 0){
				request.setAttribute("errorMessage", "没有得到columnId");
				return mapping.findForward("error");
			}
			int show = this.getIntValue(request, "show", 1);		
			IUlContentService cons = (IUlContentService)this.getService("contentService");
			List<UlTemplate> listTemplate = cons.getTemplateByColumnId( columnId, 1, dept);	
			IUlColumnService cs = (IUlColumnService)this.getService("columnService");
			List list = cs.getListByColumnLevelAndDept(1, dept, show);		
			request.setAttribute("columnList",list);
			request.setAttribute("columnId",columnId);
			request.setAttribute("template",(listTemplate.get(0) == null ? (new UlTemplate()) : listTemplate.get(0)));	
			
			if(pageSize == 0)pageSize = listTemplate.get(0).getPageSize();			
			
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
			String dept = this.getStringValue(request, "dept", "zhixing");
			int columnId = this.getIntValue(request, "columnId", 0);
			IUlContentService cons = (IUlContentService)this.getService("contentService");
			List<UlTemplate> listTemplate = cons.getTemplateByColumnId( columnId, 1, dept);	
			request.setAttribute("template", listTemplate.get(0));
			StringBuffer sb = new StringBuffer();
			int page = this.getIntValue(request, "page", 1);		
			int ti = 0;		
			String ts = this.getStringValue(request, "condition");
			String forward = this.getStringValue(request, "forward", "/dept/zhixing/checkshow" );
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
			IUlContentService cs = (IUlContentService)this.getService("contentService");
			int totlePage = cs.getCheckTotlePage(sb.toString(), pageSize);
			
			List clist = cs.getListByColumnLevelAndDept(1, dept, show);		
			if(page > totlePage && totlePage > 1) page = totlePage;
			List list = cs.getCheck(sb.toString(), page, pageSize);
			
			
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


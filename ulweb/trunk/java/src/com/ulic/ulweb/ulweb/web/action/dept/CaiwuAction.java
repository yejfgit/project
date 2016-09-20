package com.ulic.ulweb.ulweb.web.action.dept;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

public class CaiwuAction extends BaseAction{


	int jieshao = 1210;			//部门介绍
	int gonggao = 60;		//最新公告
	int zhuye = 1209;		//主页链接
	int shengri = 1211;		//生日信息
	int tupian = 1208;		//机构图片
	int tongzhi = 55;		//工作通知
	int fawen = 56;			//财务部发文
	int fagui = 57;			//监管法规
	int zixun = 54;			//财务资讯
	int yaowen = 1207;		//财税要闻
	int dongtai = 58;		//机构动态

	
	String deptName = "caiwu";
	
	public ActionForward index(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String ptype = this.getStringValue(request, "ptype");

		int countProcesser = ((UtilService)this.getService("utilService")).getCountProcesser("market");
		request.setAttribute("countProcesser",countProcesser);

		
		IUlContentService cons = (IUlContentService)this.getService("contentService");
		IUlColumnService cs = (IUlColumnService)this.getService("columnService");
		
		request.setAttribute("jieshao", cons.getLastContentInColumnId(jieshao));
		
		request.setAttribute("gonggao", cons.getContentByColumnId(gonggao, 1, 5));
		request.setAttribute("zhuye", cons.getContentByColumnId(zhuye, 1, 50));
		
		request.setAttribute("shengri", this.getBirthday());
		request.setAttribute("tupian", cons.getContentListWithAtt(tupian, 0, 1, 1));
		
		request.setAttribute("tongzhi", cons.getContentByColumnId(tongzhi, 1, 5));
		request.setAttribute("fawen", cons.getContentByColumnId(fawen, 1, 5));
		request.setAttribute("fagui", cons.getContentByColumnId(fagui, 1, 5));
		request.setAttribute("zixun", cons.getContentByColumnId(zixun, 1, 5));
		request.setAttribute("yaowen", cons.getContentByColumnId(yaowen, 1, 5));
		request.setAttribute("dongtai", cons.getContentByColumnId(dongtai, 1, 5));

		request.setAttribute("columnForCheck", cs.getListByDeptForColumn("caiwu", 0,1,1,0));
		
		ActionForward af = new ActionForward();
		af.setPath("/dept/" + deptName + "/index" + ptype + ".jsp");
		return af;
	}

	
	public ActionForward subPage1(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String ptype = this.getStringValue(request, "ptype");
		int columnId = this.getIntValue(request, "columnId", 0);
		int page = this.getIntValue(request, "page", 1);
		int pageSize = this.getIntValue(request, "pageSize", 20);		
		
		if(columnId == 0){
			request.setAttribute("errorMessage", "没有得到columnId");
			return mapping.findForward("error");
		}
		
		IUlContentService cons = (IUlContentService)this.getService("contentService");
		IUlColumnService cs = (IUlColumnService)this.getService("columnService");
		request.setAttribute("jieshao", cons.getLastContentInColumnId(jieshao));
		request.setAttribute("zhuye", cons.getContentByColumnId(zhuye, 1, 50));
		request.setAttribute("columnForCheck", cs.getListByDeptForColumn("caiwu", 0,1,1,0));
		
		UlColumn c = cs.getColumnById(columnId);
		request.setAttribute("column", c);
//		request.setAttribute("columnList", cs.getListByParentIdForShow(c.getParentId(), "market", 1));
		request.setAttribute("contentList", cons.getContentByColumnId(columnId, page, pageSize));
		request.setAttribute("totlePage",cons.getContentTotlePage(columnId,pageSize));
		request.setAttribute("page",page);
		ActionForward af = new ActionForward();
		af.setPath("/dept/" + deptName + "/subpage1" + ptype + ".jsp");
		return af;
	}
	
	
	public ActionForward check(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {	
		
		int show = this.getIntValue(request, "show", 1);	
		String ptype = this.getStringValue(request, "ptype");
		int columnId = this.getIntValue(request, "columnId", 0);
		IUlContentService cons = (IUlContentService)this.getService("contentService");
		IUlColumnService cs = (IUlColumnService)this.getService("columnService");
		
		StringBuffer sb = new StringBuffer();
		int page = this.getIntValue(request, "page", 1);		
		int ti = 0;		
		String ts = this.getStringValue(request, "condition");
		String forward = this.getStringValue(request, "forward", "/dept/" + deptName + "/checkshow" );
		forward += ptype;
		if(!ts.equals("")){
			sb.append(ts);
		}else{
			sb.append(" where organ_id = '" + deptName + "' and is_delete = 0 ");
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
		int pageSize = this.getIntValue(request, "pageSize", 20);
	
		int totlePage = cons.getCheckTotlePage(sb.toString(), pageSize);
		request.setAttribute("columnForCheck", cs.getListByDeptForColumn("caiwu", 0,1,1,0));
		request.setAttribute("jieshao", cons.getLastContentInColumnId(jieshao));
		request.setAttribute("zhuye", cons.getContentByColumnId(zhuye, 1, 50));
		
		
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
	
	private boolean isRun(int year) {
		if (year % 100 != 0 && year % 4 == 0 || year % 400 == 0) return true;
		else return false;
	}
	
	private List getBirthday() throws Exception {

		Date dt = new Date();
		//System.out.println(dt.getYear() + "-" + dt.getMonth() + "-" + dt.getDate());
		//String today = "2-27";
		
		List list = new ArrayList();
		IUlContentService cons = (IUlContentService)this.getService("contentService");

		String day[] = new String[7];
//		String strArray[] = new String[2];
//		strArray = today.trim().split("-");
//		int month = Integer.parseInt(strArray[0]);
//		int date = Integer.parseInt(strArray[1]);
		int month = dt.getMonth() + 1;
		int date = dt.getDate();
		
		for (int i = 0; i < 7; i++) {
			
			day[i] = String.valueOf(month) + "-" + String.valueOf(date);
			//System.out.println(day[i]);
			
			StringBuffer sb = new StringBuffer();
			sb.append(" where organ_id = '" + deptName + "' and is_delete = 0 ");
			sb.append(" and column_id = " + shengri + " ");
			sb.append(" and key_word like '" + day[i] + "' ");
			List listthatday = cons.getCheck(sb.toString(), 1, 20);
			for (int j = 0; j < listthatday.size(); j++) {
				list.add(listthatday.get(j));
			}
					
			if (day[i].equals("1-31")
			 || isRun(dt.getYear() + 1900) && day[i].equals("2-29")	
			 || !isRun(dt.getYear() + 1900) && day[i].equals("2-28")
			 || day[i].equals("3-31")
			 || day[i].equals("4-30")
			 || day[i].equals("5-31")
			 || day[i].equals("6-30")
			 || day[i].equals("7-31")
			 || day[i].equals("8-31")
			 || day[i].equals("9-30")
			 || day[i].equals("10-31")
			 || day[i].equals("11-30")
			 || day[i].equals("12-31")) {
				
				date = 1;
				month = month % 12 + 1;
			} else {
				date++;
			}
		
		}

		return list;
	}
	
	
}

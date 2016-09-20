package com.ulic.ulweb.ulweb.web.action.dept;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ulic.ulweb.frame.action.BaseAction;
import com.ulic.ulweb.frame.constant.Constant;
import com.ulic.ulweb.ulweb.service.IUlColumnService;
import com.ulic.ulweb.ulweb.service.IUlContentService;
import com.ulic.ulweb.ulweb.service.UtilService;


public class CacCheckAction extends BaseAction{
	String deptName = "cac";
	int shengri = 1211;		//生日信息
	
	public ActionForward index(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String ptype = this.getStringValue(request, "ptype");
		request.setAttribute("shengri", this.getBirthday());
		ActionForward af = new ActionForward();
		af.setPath("/dept/" + deptName + "/index" + ptype + ".jsp");
		return af;
	}

	
	public ActionForward zongbu(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {		
		StringBuffer sb = new StringBuffer();
		int page = this.getIntValue(request, "page", 1);
		String dept = this.getStringValue(request, "dept", "cac");
		
		int ti = 0;		
		String ts = this.getStringValue(request, "condition");
		String forward = this.getStringValue(request, "forward", "/frame/checkshowsub");
		if(!ts.equals("")){
			sb.append(ts);
		}else{
			sb.append(" where organ_id = '" + dept + "' and is_delete = 0 ");
			ts = this.getStringValue(request, "tName");	
			if(!ts.equals("")){
				sb.append(" and lower(content_name) like '%" + ts.toLowerCase() + "%' ");
			}
			ti = this.getIntValue(request, "type", 0);
			if(ti != 0){
				sb.append(" and column_id = " + ti + " ");
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
		if(page > totlePage && totlePage > 1) page = totlePage;
		List list = cs.getCheck(sb.toString(), page, pageSize);
		request.setAttribute("condition", sb.toString());
		request.setAttribute("list", list);
		request.setAttribute("page", page);
		request.setAttribute("totlePage", totlePage);

		ActionForward af = new ActionForward();
		af.setName("ok");
		af.setPath( forward + ".jsp");
		return af;
	}
	
	public ActionForward all(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		return mapping.findForward("");
	}
	
	private boolean isRun(int year) {
		if (year % 100 != 0 && year % 4 == 0 || year % 400 == 0) return true;
		else return false;
	}
	private List getBirthday() throws Exception {
		String deptName = "caiwu";
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
	

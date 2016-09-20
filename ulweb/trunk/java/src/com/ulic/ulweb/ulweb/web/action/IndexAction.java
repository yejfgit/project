package com.ulic.ulweb.ulweb.web.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ulic.ulweb.frame.action.BaseAction;
import com.ulic.ulweb.frame.constant.Constant;
import com.ulic.ulweb.frame.service.ServiceLocator;
import com.ulic.ulweb.ulweb.service.IUlContentService;

public class IndexAction extends BaseAction{
/*	
	public static List listx = null;
	public static List listg = null;
	public static List listq = null;
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		int init = this.getIntValue(request, "init", 0);
		String ptype = this.getStringValue(request, "ptype","");
		ActionForward af = new ActionForward();
	
		if(init == 1){
			IUlContentService cs = (IUlContentService)this.getService("contentService");	
			 listx = cs.getContentListWoContentWOtherClassByCid(Constant.hezhongbobao,0,10,1);
			 listg = cs.getContentListWoContentWOtherClassByCid(Constant.gonggao,0,10,1);
			 listq = cs.getIndexContent("0000", 0);
			 
		}
		
		request.setAttribute("listq", listq);
		request.setAttribute("listx",listx);
		request.setAttribute("listg", listg);
		request.setAttribute("gNum",18);
		request.setAttribute("from", "do");	
		
		af.setPath("/index" + ptype + ".jsp");
		return af;
	}
	*/
	public static List listx = null;
	public static List listg = null;
	public static List listq = null;
	public static int gNum = 0;
	
	

//	public static List listgw = null;
	
//	public static String ip1 = "";
//	public static String ip2 = "";
//	public static String ip3 = "";
//	public static String ip4 = "";
//	public static String ip5 = "";
	
//	public static boolean iprefuse = false;
	
	
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String ptype = this.getStringValue(request, "ptype","");
		ActionForward af = new ActionForward();
		
//		if(iprefuse){
//			boolean iprefused = false;
//			iprefused = iprefused || request.getRemoteAddr().equals(ip1);
//			iprefused = iprefused || request.getRemoteAddr().equals(ip2);
//			iprefused = iprefused || request.getRemoteAddr().equals(ip3);
//			iprefused = iprefused || request.getRemoteAddr().equals(ip4);
//			iprefused = iprefused || request.getRemoteAddr().equals(ip5);
//			if(iprefused)return null;
//		
//		}
		
//		request.setAttribute("listq", listq);
//		request.setAttribute("listx",listx);
//		request.setAttribute("listg",listg);
//		request.setAttribute("listgw",listgw);	
//		request.setAttribute("from", "do");	
		
		af.setPath("/index" + ptype + ".jsp");
		return af;
	}
	
	public void initList() {
		IUlContentService cs = (IUlContentService)this.getService("contentService");
		try{
			listx = cs.getContentListWoContentWOtherClassByCid(Constant.hezhongbobao,0,10,1);
			listg = cs.getContentListWoContentWOtherClassByCid(Constant.gonggao,0,10,1);
			listq = cs.getIndexContent("0000", 0);
//			listgw = cs.getListByParentColumnIdDocument(Constant.gongwen,10,3);
			gNum = cs.getNewNum(Constant.gongwen, 3);
			//log.info("ulweb index list init.");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	
	
}

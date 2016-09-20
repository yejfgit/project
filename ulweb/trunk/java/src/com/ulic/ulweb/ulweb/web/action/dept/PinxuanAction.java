package com.ulic.ulweb.ulweb.web.action.dept;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.ulic.ulweb.frame.action.BaseAction;

import com.ulic.ulweb.ulweb.entity.UlColumn;
import com.ulic.ulweb.ulweb.service.IUlColumnService;
import com.ulic.ulweb.ulweb.service.IUlContentService;

//import com.ulic.ulweb.ulweb.entity.UlTemplate;
//import com.ulic.ulweb.ulweb.service.UtilService;
//import com.ulic.ulweb.frame.constant.Constant;
//import com.ulic.ulweb.ulweb.entity.UlAttachment;
//import com.ulic.ulweb.ulweb.entity.UlContent;

public class PinxuanAction extends BaseAction{
	
	//----栏目号设置（正式环境）-----------------------------------------
	int view = 721;			//合众视角
	int share = 723;		//经验分享
	int news = 707;			//信息之窗（大类）
	int news_top = 708;		//信息之窗-头条
	int news_normal = 709;	//信息之窗-普通
	int express = 720;		//新品速递
	int culture = 710;		//企业文化（大类）
	int culture_intro = 714;	//企业文化概述
	int system = 722;		//制度建设
	int newspaper = 715;	//合众内刊（大类）
	int np_hzbxb = 726;		//合众内刊-合众保险报
	int np_hzsd = 727;		//合众内刊-合众视点
	int video = 716;		//合众影像（大类）
	int video_intro = 731;	//合众影像概述
	int address = 724;		//品宣通讯录
	int download = 718;		//资料下载（大类）
	int dl_wz = 739;		//资料下载-文字类
	int sitemap = 725;		//网站地图
	int activity = 717;		//活动推广（大类）
	int activity_intro = 734;	//品牌活动概述
	int ac_fach = 735;		//活动推广-合众助学行-方案策划
	int subheadPic = 743; 	//二级栏目头部图片
	int indexPic = 742;		//首页头部图片
	
	
	//----------------------------------------------------------
	
	public ActionForward index(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//String ptype = this.getStringValue(request, "ptype");
		//计数器
		//int countProcesser = ((UtilService)this.getService("utilService")).getCountProcesser("pinxuan");
		//request.setAttribute("countProcesser",countProcesser);
		
		IUlContentService cons = (IUlContentService)this.getService("contentService");
		//IUlColumnService cols = (IUlColumnService)this.getService("columnService");

		request.setAttribute("view", cons.getListWithContentByCid(view, 1, 1));
		request.setAttribute("share", cons.getContentByColumnId(share, 1, 7));
		//request.setAttribute("news", cons.getContentListWithAtt(news0,1,4,1)); //带content 旧的news
		request.setAttribute("news_top", cons.getContentListWithAtt(news_top,1,1,1));//带content
		request.setAttribute("news_normal", cons.getContentByColumnId(news_normal, 1,3));
		request.setAttribute("aboutus", cons.getContentListWithAtt(express,0,8,1)); //带content
		request.setAttribute("indexPic", cons.getContentListWithAtt(indexPic,0,5,1));
		
		
		ActionForward af = new ActionForward();
		af.setPath("/dept/pinxuan/index.jsp");
		return af;
	}
	
	public ActionForward subPage(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String ptype = this.getStringValue(request, "ptype");
		String cName = this.getStringValue(request, "cName");	//栏目页面的模板
		String subpage = null;	//准备转向的栏目页面文件名（不含扩展名）
		int columnId = this.getIntValue(request, "columnId", 0);
		int page = this.getIntValue(request, "page", 1);
		int pageSize = this.getIntValue(request, "pageSize", 10);	

//		if(columnId == 0){
//			request.setAttribute("errorMessage", "没有得到columnId");
//			return mapping.findForward("error");
//		}
		//传递栏目名cName
		if(cName.equals("")){
			cName = ptype;
			ptype = "";
		}
		request.setAttribute("ptype", cName);
		//System.out.println(cName + "-" + columnId);

	
		IUlContentService cons = (IUlContentService)this.getService("contentService");
		IUlColumnService cols = (IUlColumnService)this.getService("columnService");
/*
		if(cName.equals("aboutus")){
			columnId = this.getIntValue(request, "columnId", aboutus);
			subpage = "aboutus";
			request.setAttribute("share", cons.getContentByColumnId(share, 1,4));
			request.setAttribute("aboutustext", cons.getListWithContentByCid(aboutustext, 1, 1));
			request.setAttribute("aboutus", cons.getContentListWithAtt(aboutus,1,15,1)); //带content	
			
		}else 
*/	
			
		if(cName.equals("newspaper")){		
			columnId = this.getIntValue(request, "columnId", np_hzbxb);
			subpage = "newspaper";
			request.setAttribute("newspaper", cons.getContentByColumnId(columnId, page, pageSize));
			request.setAttribute("columnList", cols.getListByParentIdForShow(newspaper, "pinxuan", 1));
			
		}else if(cName.equals("video")){
			columnId = this.getIntValue(request, "columnId", video_intro);
			subpage = "video";
			if(columnId == video_intro)
				request.setAttribute("video_intro", cons.getListWithContentByCid(video_intro, 1, 1));
			else
				request.setAttribute("video", cons.getContentByColumnId(columnId, page, pageSize));
			request.setAttribute("columnList", cols.getListByParentIdForShow(video, "pinxuan", 1));
		
		}else if(cName.equals("culture")){
			columnId = this.getIntValue(request, "columnId", culture_intro);
			subpage = "culture";
			if(columnId == culture_intro)
				request.setAttribute("culture_intro", cons.getListWithContentByCid(culture_intro, 1, 1));
			else
				request.setAttribute("culture", cons.getListWithContentByCid(columnId, 1, 1));
			request.setAttribute("columnList", cols.getListByParentIdForShow(culture, "pinxuan", 1));
				
		}else if(cName.equals("address")){
			columnId = this.getIntValue(request, "columnId", address);
			subpage = "address";
			request.setAttribute("share", cons.getContentByColumnId(share, 1, 7));
			request.setAttribute("address", cons.getListWithContentByCid(address, 1, 1));
			
		}else if(cName.equals("activity")){
			columnId = this.getIntValue(request, "columnId", activity_intro);
			subpage = "activity";
			if(columnId == activity_intro)
				request.setAttribute("activity_intro", cons.getListWithContentByCid(activity_intro, 1, 1));
			else
				request.setAttribute("activity", cons.getContentByColumnId(columnId, page, pageSize));
			
			List<UlColumn> columnList = (List<UlColumn>)cols.getListByParentIdForShow(activity, "pinxuan", 1);
			List<List<UlColumn>> subcolumnList = new ArrayList<List<UlColumn>>();
			for(int i = 0; i < (columnList == null ? 0 : columnList.size()); i++){
				List<UlColumn> sublist = (List<UlColumn>)cols.getListByParentIdForShow(columnList.get(i).getColumnId(), "pinxuan", 1);
				subcolumnList.add(sublist);
			}
			request.setAttribute("columnList", cols.getListByParentIdForShow(activity, "pinxuan", 1));
			request.setAttribute("subcolumnList", subcolumnList);
			
		}else if(cName.equals("share")){
			columnId = this.getIntValue(request, "columnId", share);
			subpage = "share";
			request.setAttribute("share", cons.getContentByColumnId(columnId, page, pageSize));
			
		}else if(cName.equals("news")){	
			//columnId = this.getIntValue(request, "columnId", news0);
			columnId = this.getIntValue(request, "columnId", news);
			subpage = "news";
			request.setAttribute("share", cons.getContentByColumnId(share, 1, 7));
			request.setAttribute("news", cons.getContentByColumnIdDocument(columnId, pageSize, page));
			
		}else if(cName.equals("system")){
			columnId = this.getIntValue(request, "columnId", system);
			subpage = "system";
			request.setAttribute("share", cons.getContentByColumnId(share, 1, 7));
			request.setAttribute("system", cons.getContentByColumnId(system, page, pageSize));
			
		}else if(cName.equals("view")){
			columnId = this.getIntValue(request, "columnId", view);
			subpage = "view";
			request.setAttribute("share", cons.getContentByColumnId(share, 1, 7));
			request.setAttribute("view", cons.getContentByColumnId(view, page, pageSize));
			
		}else if(cName.equals("sitemap")){
			columnId = this.getIntValue(request, "columnId", sitemap);
			subpage = "sitemap";
			request.setAttribute("sitemap", cons.getListWithContentByCid(sitemap, 1, 1));
			
		}else if(cName.equals("download")){
			columnId = this.getIntValue(request, "columnId", dl_wz);
			subpage = "download";
			request.setAttribute("download", cons.getContentByColumnId(columnId, page, pageSize));
			request.setAttribute("columnList", cols.getListByParentIdForShow(download, "pinxuan", 1));
			
		}else{
			request.setAttribute("errorMessage", "无此栏目");
			return mapping.findForward("error");
		}
		
		UlColumn c = cols.getColumnById(columnId);
		request.setAttribute("column", c);
		if(cName.equals("news"))
			request.setAttribute("totlePage", cons.getTotlePageFor2LevelColumn(columnId, pageSize));
		else
			request.setAttribute("totlePage", cons.getContentTotlePage(columnId, pageSize));
		request.setAttribute("page", page);
		request.setAttribute("subheadPic", cons.getContentListWithAtt(subheadPic,0,20,1));
		
	
		ActionForward af = new ActionForward();
		af.setPath("/dept/pinxuan/" + subpage + ptype + ".jsp");
		return af;
	}
	
	public ActionForward check(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {	
		
		String ptype = this.getStringValue(request, "ptype");
		String dept = "pinxuan";
		//int columnId = this.getIntValue(request, "columnId", 0);
		IUlContentService cons = (IUlContentService)this.getService("contentService");
		//IUlColumnService cols = (IUlColumnService)this.getService("columnService");
		
		StringBuffer sb = new StringBuffer();
		int page = this.getIntValue(request, "page", 1);		

		String ts = this.getStringValue(request, "condition");
		String forward = this.getStringValue(request, "forward", "/dept/pinxuan/checkshow" );
		forward += ptype;
		if(!ts.equals("")){
			sb.append(ts);
		}else{
			sb.append(" where organ_id = '" + dept + "' and is_delete = 0 ");

			//查找词
			ts = this.getStringValue(request, "tName");		
			String[] kw_arr = new String[1];
			StringBuffer kw = new StringBuffer();
			kw_arr = ts.trim().split(" ");
			for(int i=0; i < kw_arr.length; i++){
				if(!kw_arr.equals("")){
					sb.append(" and content_name like '%" + kw_arr[i].toLowerCase() + "%' ");
					kw.append(kw_arr[i].toLowerCase() + " ");
				}
			}
			
			String str = (kw.length()>= 20 ? kw.substring(0, 20) : kw.toString());
			request.setAttribute("kw",str.trim());
			//
			
//			//关键词
//			ts = this.getStringValue(request, "keyWord");
//			if(!ts.equals("")){
//				sb.append(" and key_word like '%" + ts + "%' ");
//			}
					
		}
		int pageSize = this.getIntValue(request, "pageSize", 10);
		int totlePage = cons.getCheckTotlePage(sb.toString(), pageSize);	
		if(page > totlePage && totlePage > 1) page = totlePage;
		List list = cons.getCheck(sb.toString(), page, pageSize);
		
		request.setAttribute("condition", sb.toString());	
		request.setAttribute("totlePage", totlePage);
		request.setAttribute("contentList", list);
		request.setAttribute("page", page);
		request.setAttribute("subheadPic", cons.getContentListWithAtt(subheadPic,0,20,1));

		ActionForward af = new ActionForward();
		af.setName("ok");
		af.setPath( forward + ".jsp");
		return af;
		
		
		
	}
	
	
	

	
}

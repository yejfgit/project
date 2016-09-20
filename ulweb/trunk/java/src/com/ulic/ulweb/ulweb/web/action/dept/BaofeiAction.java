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
import com.ulic.ulweb.ulweb.entity.UlTemplate;
import com.ulic.ulweb.ulweb.service.IUlColumnService;
import com.ulic.ulweb.ulweb.service.IUlContentService;
import com.ulic.ulweb.ulweb.service.UtilService;

public class BaofeiAction extends BaseAction{
	
	//----栏目号设置---- 正式环境 -----------------------------------
	int wenjian = 747;	//文件通知（大类）
	int jingying = 748;	//经营管理（大类）
	int jiaoyu = 749;	//教育训练（大类）
	int renyuan = 750;	//人员管理（大类）
	int xuqi = 752;		//续期业绩速报（大类）
	int jingsai = 753;	//竞赛激励（大类）
	int dudao = 754;	//督导园地（大类）
	int yeguan = 755;	//业管信息（大类）
	int jigou = 758;	//机构之声（大类）
	
	int hangye = 751;	//行业信息
	int paihang = 756;	//机构业绩排行榜
	int bumen = 757;	//部门快讯
	int hello = 761;	//欢迎图片
	int zhanshi = 762;	//展示图片
	
	int intro = 759;	//部门简介
	int address = 760;	//保费部通讯录
	
	//-----------------------------------------------------------
	
	
	public ActionForward index(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String ptype = this.getStringValue(request, "ptype");
		//计数器
//		int countProcesser = ((UtilService)this.getService("utilService")).getCountProcesser("shichang");
//		request.setAttribute("countProcesser",countProcesser);
		
		IUlContentService cons = (IUlContentService)this.getService("contentService");
		IUlColumnService cols = (IUlColumnService)this.getService("columnService");
//		List<UlTemplate> listTemplate = cons.getTemplateByColumnId( 99999, 9, "shichang");
//		request.setAttribute("template",(listTemplate.get(0) == null ? (new UlTemplate()) : listTemplate.get(0)));
		
		request.setAttribute("wenjian", cols.getListByParentIdForShow(wenjian, "baofei", 1));
		request.setAttribute("jingying", cols.getListByParentIdForShow(jingying, "baofei", 1));
		request.setAttribute("jiaoyu", cols.getListByParentIdForShow(jiaoyu, "baofei", 1));
		request.setAttribute("renyuan", cols.getListByParentIdForShow(renyuan, "baofei", 1));
		request.setAttribute("xuqi", cols.getListByParentIdForShow(xuqi, "baofei", 1));
		request.setAttribute("jingsai", cols.getListByParentIdForShow(jingsai, "baofei", 1));
		request.setAttribute("dudao", cols.getListByParentIdForShow(dudao, "baofei", 1));
		request.setAttribute("yeguan", cols.getListByParentIdForShow(yeguan, "baofei", 1));
		request.setAttribute("jigou", cols.getListByParentIdForShow(jigou, "baofei", 1));
		
		request.setAttribute("hangye", cons.getContentByColumnId(hangye, 1, 4));
		request.setAttribute("hangyeId", hangye);
		request.setAttribute("bumen", cons.getContentByColumnId(bumen, 1, 5));
		request.setAttribute("intro", cons.getContentByColumnId(intro, 1, 1));
		request.setAttribute("address", cons.getContentByColumnId(address, 1, 1));
		
		request.setAttribute("paihang", cons.getContentListWithAtt(paihang,0,2,1));
		request.setAttribute("hello", cons.getContentListWithAtt(hello,0,1,1));
		request.setAttribute("zhanshi", cons.getContentListWithAtt(zhanshi,0,1,1));
		
		
		
		ActionForward af = new ActionForward();
		af.setPath("/dept/baofei/index" + ptype + ".jsp");
		return af;
	}
	
	public ActionForward subPage1(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String ptype = this.getStringValue(request, "ptype");
		int columnId = this.getIntValue(request, "columnId", 0);
		int page = this.getIntValue(request, "page", 1);
		int pageSize = this.getIntValue(request, "pageSize", 15);	
		
		if(columnId == 0){
			request.setAttribute("errorMessage", "没有得到columnId");
			return mapping.findForward("error");
		}

		IUlContentService cons = (IUlContentService)this.getService("contentService");
		IUlColumnService cols = (IUlColumnService)this.getService("columnService");

		UlColumn c = cols.getColumnById(columnId);
		request.setAttribute("column", c);
		request.setAttribute("columnList", cols.getListByParentIdForShow(c.getParentId(), "baofei", 1));
		request.setAttribute("contentList", cons.getContentByColumnId(columnId, page, pageSize));
		request.setAttribute("totlePage", cons.getContentTotlePage(columnId,pageSize));
		request.setAttribute("page", page);

		request.setAttribute("intro", cons.getContentByColumnId(intro, 1, 1));
		request.setAttribute("address", cons.getContentByColumnId(address, 1, 1));
		
		
		ActionForward af = new ActionForward();
		af.setPath("/dept/baofei/subpage1" + ptype + ".jsp");
		return af;
	}

	
	
}

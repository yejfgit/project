package com.ulic.ulweb.ulweb.web.action.dept;

import java.util.ArrayList;
import java.util.Date;
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
import com.ulic.ulweb.ulweb.service.UtilService;
import com.ulic.ulweb.ulweb2.entity.ContentEntity;
import com.ulic.ulweb.ulweb2.service.IContentService;

public class BudongchanAction extends BaseAction{

	//测试环境
//	int jieshao = 3191;
//	int zhongxin = 3192;
//	int shiji = 3193;
//	int tongzhi = 3194;
//	int jiyao = 3195;
//    int wenjian = 3196;
//	int zhidu = 3197;
//	int tongxun = 3224;
//	int cybg = 3324;
	
	//生产环境
	int jieshao = 4004;
	int zhongxin = 4005;
	int shiji = 4006;
	int tongzhi = 4007;
	int jiyao = 4008;
    int wenjian = 4009;
	int zhidu = 4010;
	int tongxun = 4012;
	int cybg = 4264;
	
	final String DEPT_NAME = "budongchan";
	final String TUPIAN = "tupian";
	
	private IUlContentService cons = (IUlContentService) this
	.getService("contentService");
	
	private IUlColumnService cols = (IUlColumnService) this
	.getService("columnService");
	
	private IContentService contentAdminService = (IContentService) this
	.getService("contentAdminService");
	
	public ActionForward index(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		IUlContentService cons = (IUlContentService)this.getService("contentService");
		IUlColumnService cs = (IUlColumnService)this.getService("columnService");
		ContentEntity lc = contentAdminService.getLastContentByColumnId(tongxun);
		
		List zhongxinList = cons.getContentByColumnId(zhongxin, 1, 8);
		List shijiList = cons.getContentByColumnId(shiji, 1, 8);
		List tongzhiList = cons.getContentByColumnId(tongzhi, 1, 8);
		List jiyaoList = cons.getContentByColumnId(jiyao, 1, 8);
		List wenjianList = cons.getContentByColumnId(wenjian, 1, 8);
		List zhiduList = cons.getContentByColumnId(zhidu, 1, 8);
		List tupianList = cons.getContentListWithAttByEId(this.DEPT_NAME, this.TUPIAN, 0, 5, 1);
		List zuixinList = cons.getListByOrganId(DEPT_NAME,7);

		request.setAttribute("zhongxinList", zhongxinList);
		request.setAttribute("shijiList", shijiList);
		request.setAttribute("tongzhiList", tongzhiList);
		request.setAttribute("jiyaoList", jiyaoList);
		request.setAttribute("wenjianList", wenjianList);
		request.setAttribute("zhiduList", zhiduList);
		request.setAttribute("zuixinList", zuixinList);
		request.setAttribute("zhongxin", zhongxin);
		request.setAttribute("jieshao", jieshao);
		request.setAttribute("shiji", shiji);
		request.setAttribute("tongzhi", tongzhi);
		request.setAttribute("jiyao", jiyao);
		request.setAttribute("wenjian", wenjian);
		request.setAttribute("zhidu", zhidu);
		request.setAttribute("tupian", tupianList);
		request.setAttribute("contentId", lc.getContentId());
		request.setAttribute("cybg", cybg);
		return mapping.findForward("budongchan");
	}
	
	public ActionForward subPage(ActionMapping mapping, ActionForm form, HttpServletRequest request,
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
		request.setAttribute("columnForCheck", cs.getListByDeptForColumn("budongchan", 0,1,1,0));
		
		UlColumn c = cs.getColumnById(columnId);
		request.setAttribute("zhongxin", zhongxin);
		request.setAttribute("jieshao", jieshao);
		request.setAttribute("shiji", shiji);
		request.setAttribute("tongzhi", tongzhi);
		request.setAttribute("jiyao", jiyao);
		request.setAttribute("wenjian", wenjian);
		request.setAttribute("zhidu", zhidu);
		
		request.setAttribute("column", c);
//		request.setAttribute("columnList", cs.getListByParentIdForShow(c.getParentId(), "market", 1));
		request.setAttribute("contentList", cons.getContentByColumnId(columnId, page, pageSize));
		request.setAttribute("totlePage",cons.getContentTotlePage(columnId,pageSize));
		request.setAttribute("page",page);
		ActionForward af = new ActionForward();
		af.setPath("/dept/" + DEPT_NAME + "/subpage" + ptype + ".jsp");
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
		String forward = this.getStringValue(request, "forward", "/dept/" + DEPT_NAME + "/checkshow" );
		forward += ptype;
		if(!ts.equals("")){
			sb.append(ts);
		}else{
			sb.append(" where organ_id = '" + DEPT_NAME + "' and is_delete = 0 ");
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
		request.setAttribute("columnForCheck", cs.getListByDeptForColumn("budongchan", 0,1,1,0));

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
	
	public ActionForward showPage(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		int contentId = this.getIntValue(request, "contentId", 0);
		
		ContentEntity c = contentAdminService.getContentById(contentId);
		
		IUlColumnService cs = (IUlColumnService)this.getService("columnService");
		UlColumn column = cs.getColumnById(c.getColumnId());
			
		request.setAttribute("zhongxin", zhongxin);
		request.setAttribute("jieshao", jieshao);
		request.setAttribute("shiji", shiji);
		request.setAttribute("tongzhi", tongzhi);
		request.setAttribute("jiyao", jiyao);
		request.setAttribute("wenjian", wenjian);
		request.setAttribute("zhidu", zhidu);
		
		request.setAttribute("c", c);
		request.setAttribute("column", column);
//		request.setAttribute("document", document);
		return mapping.findForward("showpage");
	}
	
	public ActionForward showLast(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		int columnId = this.getIntValue(request, "columnId", 0);
		
		ContentEntity c = contentAdminService.getLastContentByColumnId(columnId);
		
		IUlColumnService cs = (IUlColumnService)this.getService("columnService");
		UlColumn column = cs.getColumnById(columnId);
		
		request.setAttribute("zhongxin", zhongxin);
		request.setAttribute("jieshao", jieshao);
		request.setAttribute("shiji", shiji);
		request.setAttribute("tongzhi", tongzhi);
		request.setAttribute("jiyao", jiyao);
		request.setAttribute("wenjian", wenjian);
		request.setAttribute("zhidu", zhidu);
		
		request.setAttribute("c", c);
		request.setAttribute("column", column);
//		request.setAttribute("document", document);
		return mapping.findForward("showpage");
	}
	


	

}

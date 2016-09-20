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
import com.ulic.ulweb.ulweb.entity.UlDept;
import com.ulic.ulweb.ulweb.entity.UlTemplate;
import com.ulic.ulweb.ulweb.service.IUlColumnService;
import com.ulic.ulweb.ulweb.service.IUlContentService;
import com.ulic.ulweb.ulweb.service.IUlDeptService;
import com.ulic.ulweb.ulweb.service.UtilService;
import com.ulic.ulweb.ulweb.util.ContentTool;
import com.ulic.ulweb.ulweb.util.GetColumns;

public class Peixun2Action extends BaseAction{
	

	final String DEPT_NAME = "peixun2";
////正式环境栏目号
	int zhongdian = 2125;	//2010重点项目
	int yewu = 2140;		//left1
	int zhuguan = 2154;	//left2
	int xunlian = 989;	//left3
	int jigou = 990;	//bottom
	int wenjian = 991;	//right1

	
	int intro = 1046;	//
	int photo = 1047;
	int photo2 = 1048;



	IUlContentService cons = (IUlContentService)this.getService("contentService");
	IUlColumnService cols = (IUlColumnService)this.getService("columnService");
	
	
	public ActionForward index(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String ptype = this.getStringValue(request, "ptype");
		int countProcesser = ((UtilService)this.getService("utilService")).getCountProcesser("peixun");
		request.setAttribute("countProcesser", countProcesser);
		
		//风采
		request.setAttribute("intro", cons.getContentByColumnId(intro, 1, 1));
		//文字栏目
		request.setAttribute("zhongdian", cols.getListByParentIdForShow(zhongdian, "peixun2", 1));
		request.setAttribute("yewu", cols.getListByParentIdForShow(yewu, "peixun2", 1));
		request.setAttribute("zhuguan", cols.getListByParentIdForShow(zhuguan, "peixun2", 1));
		request.setAttribute("xunlian", cols.getListByParentIdForShow(xunlian, "peixun2", 1));
		request.setAttribute("jigou", cols.getListByParentIdForShow(jigou, "peixun2", 1));
		request.setAttribute("wenjian", cols.getListByParentIdForShow(wenjian, "peixun2", 1));

		//图片（2个）
		request.setAttribute("photo", cons.getContentListWithAtt(photo, 0, 1, 1));
		request.setAttribute("photo2", cons.getContentListWithAtt(photo2, 0, 1, 1));
		//导读和直通车
		request.setAttribute("daodu", cons.getContentByNearDayIndept("peixun2", 0, 10));
		request.setAttribute("zhitongche", cons.getContentByDeptId("peixun2", 1, 10));
		
		request.setAttribute("ptype",ptype);
		ActionForward af = new ActionForward();
		af.setPath("/dept/peixun2/index" + ptype + ".jsp");
		return af;
	}
	
	public ActionForward subPage(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String ptype = this.getStringValue(request, "ptype");
		int columnId = this.getIntValue(request, "columnId", 0);
		int page = this.getIntValue(request, "page", 1);
		int pageSize = this.getIntValue(request, "pageSize", 10);		
		
		if(columnId == 0){
			request.setAttribute("errorMessage", "没有得到columnId");
			return mapping.findForward("error");
		}

		UlColumn c = cols.getColumnById(columnId);
		
		request.setAttribute("column", c);		
		//request.setAttribute("columnList", cols.getListByParentIdForShow(c.getParentId(), "peixun2", 1));
		request.setAttribute("subColumnList", cols.getListByParentIdForShow(c.getColumnId(), "peixun2", 1));
		request.setAttribute("contentList", cons.getContentByColumnId(columnId, page, pageSize));
		
		//tree
		String deptId = "peixun2";
		//String deptName = "培训部";
		//IUlDeptService ds = (IUlDeptService)this.getService("deptService");
		//UlDept d = ds.getDept(deptId); 
		//GetColumns gc = new GetColumns();
		List<UlColumn> l = cols.getListByDeptForColumn(deptId);
		//request.setAttribute("columnList", gc.columnListUsedColumn(l, d.getDeptName()));
		StringBuffer sb = new StringBuffer();
		sb.append("<script type='text/javascript'>");
		sb.append("d = new dTree('d');");
		sb.append("d.add(0,-1,\"培训部首页\",\"peixun2.do?method=index\");");
		for(int i = 0; i < (l.isEmpty()?0:l.size()); i++){
			if (l.get(i).getShowToUser() == 1) {
				sb.append("d.add(" + l.get(i).getColumnId() + "," + l.get(i).getParentId() + ",\"" );
				sb.append(l.get(i).getColumnName() + "\",\"");	
				
				//sb.append("javascript:nList(" + l.get(i).getColumnId() + ",'" + l.get(i).getColumnName() + "');");
				sb.append("peixun2.do?method=subPage&columnId=" + l.get(i).getColumnId());
				
				if(l.get(i).getIncludeContent() == 0){
					sb.append("\",\"\",\"\",\"images/dtree/folder.gif\",\"images/dtree/folderopen.gif");
				}
				sb.append("\");");
			}
		}		
		sb.append("document.write(d);");
		sb.append("</script>");
		request.setAttribute("columnList", sb.toString());
		
		
		//风采
		request.setAttribute("intro", cons.getContentByColumnId(intro, 1, 1));
		
		
		request.setAttribute("totalPage", cons.getContentTotlePage(columnId, pageSize));
		request.setAttribute("page",page);

		ActionForward af = new ActionForward();
		af.setPath("/dept/peixun2/subpage" + ptype + ".jsp");
		return af;
	}
	
	
	public ActionForward zhitongche(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String ptype = this.getStringValue(request, "ptype");

		int page = this.getIntValue(request, "page", 1);
		int pageSize = this.getIntValue(request, "pageSize", 10);		
	
		
		UlColumn c = new UlColumn();
		c.setColumnName("培训直通车");
		request.setAttribute("column", c);		
		request.setAttribute("subColumnList", new ArrayList<UlColumn>());
		
		request.setAttribute("contentList",cons.getContentByDeptId("peixun2", page, pageSize));
		
		//tree
		String deptId = "peixun2";
		//String deptName = "培训部";
		//IUlDeptService ds = (IUlDeptService)this.getService("deptService");
		//UlDept d = ds.getDept(deptId); 
		//GetColumns gc = new GetColumns();
		List<UlColumn> l = cols.getListByDeptForColumn(deptId);
		//request.setAttribute("columnList", gc.columnListUsedColumn(l, d.getDeptName()));
		StringBuffer sb = new StringBuffer();
		sb.append("<script type='text/javascript'>");
		sb.append("d = new dTree('d');");
		sb.append("d.add(0,-1,\"培训部首页\",\"peixun2.do?method=index\");");
		for(int i = 0; i < (l.isEmpty()?0:l.size()); i++){
			if (l.get(i).getShowToUser() == 1) {
				sb.append("d.add(" + l.get(i).getColumnId() + "," + l.get(i).getParentId() + ",\"" );
				sb.append(l.get(i).getColumnName() + "\",\"");	
				
				//sb.append("javascript:nList(" + l.get(i).getColumnId() + ",'" + l.get(i).getColumnName() + "');");
				sb.append("peixun2.do?method=subPage&columnId=" + l.get(i).getColumnId());
				
				if(l.get(i).getIncludeContent() == 0){
					sb.append("\",\"\",\"\",\"images/dtree/folder.gif\",\"images/dtree/folderopen.gif");
				}
				sb.append("\");");
			}
		}		
		sb.append("document.write(d);");
		sb.append("</script>");
		request.setAttribute("columnList", sb.toString());
		
		
		//风采
		request.setAttribute("intro", cons.getContentByColumnId(intro, 1, 1));
		
		
		request.setAttribute("totalPage", 
				cons.getCheckTotlePage(" where is_delete = 0 and organ_id = 'peixun2' ", pageSize));
		request.setAttribute("page",page);

		ActionForward af = new ActionForward();
		af.setPath("/dept/peixun2/subpage" + ptype + ".jsp");
		return af;
	}
	
	

	/**
	 * 内容搜索页
	 */
	public ActionForward search(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String ptype = this.getStringValue(request, "ptype");

		int page = this.getIntValue(request, "page", 1);
		int pageSize = this.getIntValue(request, "pageSize", 10);

		String keyWord = this.getStringValue(request, "keyWord");
		//System.out.println(keyWord);
		keyWord = ContentTool.unescape(keyWord, "U");
		//System.out.println(keyWord);
		
		StringBuffer sb0 = new StringBuffer();
		sb0.append(" where content_name like '%" + keyWord + "%' ");
		sb0.append(" and is_delete = 0 ");
		sb0.append(" and organ_id = '" + this.DEPT_NAME + "' ");

		request.setAttribute("contentList", cons.getCheck(sb0.toString(), page, pageSize));
		
		UlColumn c = new UlColumn();
		c.setColumnName("“" + keyWord + "”的搜索结果");
		request.setAttribute("column", c);
		request.setAttribute("subColumnList", new ArrayList<UlColumn>());


		//tree
		String deptId = "peixun2";
		//String deptName = "培训部";
		//IUlDeptService ds = (IUlDeptService)this.getService("deptService");
		//UlDept d = ds.getDept(deptId); 
		//GetColumns gc = new GetColumns();
		List<UlColumn> l = cols.getListByDeptForColumn(deptId);
		//request.setAttribute("columnList", gc.columnListUsedColumn(l, d.getDeptName()));
		StringBuffer sb = new StringBuffer();
		sb.append("<script type='text/javascript'>");
		sb.append("d = new dTree('d');");
		sb.append("d.add(0,-1,\"培训部首页\",\"peixun2.do?method=index\");");
		for(int i = 0; i < (l.isEmpty()?0:l.size()); i++){
			if (l.get(i).getShowToUser() == 1) {
				sb.append("d.add(" + l.get(i).getColumnId() + "," + l.get(i).getParentId() + ",\"" );
				sb.append(l.get(i).getColumnName() + "\",\"");	
				
				//sb.append("javascript:nList(" + l.get(i).getColumnId() + ",'" + l.get(i).getColumnName() + "');");
				sb.append("peixun2.do?method=subPage&columnId=" + l.get(i).getColumnId());
				
				if(l.get(i).getIncludeContent() == 0){
					sb.append("\",\"\",\"\",\"images/dtree/folder.gif\",\"images/dtree/folderopen.gif");
				}
				sb.append("\");");
			}
		}		
		sb.append("document.write(d);");
		sb.append("</script>");
		request.setAttribute("columnList", sb.toString());
		
		
		
		request.setAttribute("intro", cons.getContentByColumnId(intro, 1, 1));
		
		request.setAttribute("totalPage", cons.getCheckTotlePage(sb0.toString(), pageSize));
		request.setAttribute("page", page);
		
		ActionForward af = new ActionForward();
		af.setPath("/dept/peixun2/subpage" + ptype + ".jsp");
		return af;
	}
	
	
	
	
	
	
	
	
	
	
}

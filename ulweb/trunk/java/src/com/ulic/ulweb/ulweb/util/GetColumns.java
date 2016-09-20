package com.ulic.ulweb.ulweb.util;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ulic.ulweb.frame.constant.Constant;
import com.ulic.ulweb.ulweb.entity.UlColumn;
import com.ulic.ulweb.ulweb.entity.UlContent;
import com.ulic.ulweb.ulweb.entity.UlDept;

public class GetColumns {
	
/*	
	public static List<UlColumn> getColumnList(List<UlColumn> list1, List<UlColumn> list2, List<UlColumn> list3){
		List<UlColumn> ulist = new ArrayList<UlColumn>();
	
		int l1=0,l2=0,l3=0;
		if(!list1.isEmpty()){
			l1 = list1.size();
		}
		if(!list2.isEmpty()){
			l2 = list2.size();
		}
		if(!list3.isEmpty()){
			l3 = list3.size();
		}
		
		if(l1 != 0){
			for(int i = 0; i < l1; i++){				
				ulist.add(list1.get(i));
				if(l2 != 0){
					for(int j = 0; j < l2; j++){
						if(list2.get(j).getParentId() == list1.get(i).getColumnId()){
							ulist.add(list2.get(j));
							if(l3 != 0){
								for(int k = 0; k < l3; k++){
									
									if(list3.get(k).getParentId() == list2.get(j).getColumnId()){
										ulist.add(list3.get(k));
									}
								}
							}
						}
					}
				}
			}
		}
		
		return ulist;		
	}
	
	public List<UlColumn> getColumnList(List<UlColumn> list1, List<UlColumn> list2){
		List<UlColumn> ulist = new ArrayList<UlColumn>();
	
		int l1=0,l2=0;
		if(!list1.isEmpty()){
			l1 = list1.size();
		}
		if(!list2.isEmpty()){
			l2 = list2.size();
		}
				
		if(l1 != 0){
			for(int i = 0; i < l1; i++){				
				ulist.add(list1.get(i));
				if(l2 != 0){
					for(int j = 0; j < l2; j++){
						if(list2.get(j).getParentId() == list1.get(i).getColumnId()){
							ulist.add(list2.get(j));	
						}
					}
				}
			}
		}
		
		return ulist;		
	}
	
	public static String getStrColumnList(List<UlColumn> list1, List<UlColumn> list2, List<UlColumn> list3){
		StringBuffer sb = new StringBuffer();
		List<UlColumn> list = getColumnList(list1, list2, list3);		
		if(list.isEmpty()){
			return "";
		}
		UlColumn[] col = list.toArray(new UlColumn[list.size()]);
		for(int i = 0; i < list.size(); i++) {
			sb.append("<option " + " id='id" + col[i].getColumnId() + "'");
			if(col[i].getIncludeContent() == 1){
				sb.append("value='" + col[i].getColumnId() + "'>");
			}else{
				sb.append("value='-1' style='color:#ff0000'>");
			}
			if(col[i].getColumnLevel() ==1 ){
				sb.append("->");
			}else if(col[i].getColumnLevel() == 2){
				sb.append("--->");
			}else if(col[i].getColumnLevel() == 3){
				sb.append("---->");
			}
			sb.append(col[i].getColumnName() + "</option>");
		}
		return sb.toString();
	}
	
	public String getStrColumnList(List<UlColumn> list1, List<UlColumn> list2){
		StringBuffer sb = new StringBuffer();
		List<UlColumn> list = this.getColumnList(list1, list2);		
		if(list.isEmpty()){
			return "";
		}
		UlColumn[] col = list.toArray(new UlColumn[list.size()]);
		for(int i = 0; i < list.size(); i++) {
			sb.append("<option id='id" + col[i].getColumnId() + "' ");
			if(col[i].getIncludeContent() == 0 ){
				sb.append("value='" + col[i].getColumnId() + "'>");				
			}else{
				sb.append("value='-1' style='color:#ff0000'>");
			}
			if(col[i].getColumnLevel() == 1){
				sb.append("->");
			}else if(col[i].getColumnLevel() == 2){
				sb.append("--->");
			}
			sb.append(col[i].getColumnName() + "</option>");
		}
		return sb.toString();
	}
	
	public String getRadioColumnList(List<UlColumn> list1, List<UlColumn> list2, List<UlColumn> list3) {
		StringBuffer sb = new StringBuffer();
		List<UlColumn> list = getColumnList(list1, list2, list3);		
		if(list.isEmpty()){
			return "";
		}
		UlColumn[] col = list.toArray(new UlColumn[list.size()]);
		for(int i = 0; i < list.size(); i++){
			if(col[i].getColumnLevel() ==1 ){
				sb.append("<tr><td>");
				sb.append("|-<input type='checkbox' name='columnId' value='" + col[i].getColumnId() + "'/>");
				sb.append(col[i].getColumnName());
				sb.append("</td></tr>");
			}else if(col[i].getColumnLevel() == 2){
				sb.append("<tr><td>");
				sb.append("|&nbsp;|-<input type='checkbox' name='columnId' value='" + col[i].getColumnId() + "'/>");
				sb.append(col[i].getColumnName());
				sb.append("</td></tr>");
			}else if(col[i].getColumnLevel() == 3){
				sb.append("<tr><td>");
				sb.append("|&nbsp;|&nbsp;|-<input type='checkbox' name='columnId' value='" + col[i].getColumnId() + "'/>");
				sb.append(col[i].getColumnName());
				sb.append("</td></tr>");
			}
		}
				
		return sb.toString();
	}
	
	public String getRadioColumnList(List<UlColumn> list1, List<UlColumn> list2) {
		StringBuffer sb = new StringBuffer();
		List<UlColumn> list = this.getColumnList(list1, list2);		
		if(list.isEmpty()){
			return "";
		}
		UlColumn[] col = list.toArray(new UlColumn[list.size()]);
		for(int i = 0; i < list.size(); i++){
			if(col[i].getColumnLevel() ==1 ){
				sb.append("<tr><td>");
				sb.append("|-<input type='checkbox' name='columnId' value='" + col[i].getColumnId() + "'/>");
				sb.append(col[i].getColumnName());
				sb.append("</td></tr>");
			}else if(col[i].getColumnLevel() == 2){
				sb.append("<tr><td>");
				sb.append("|&nbsp;|-<input type='checkbox' name='columnId' value='" + col[i].getColumnId() + "'/>");
				sb.append(col[i].getColumnName());
				sb.append("</td></tr>");
			}
		}
				
		return sb.toString();
	}
	
	public static String getColumnButtonList(List<UlColumn> list1, List<UlColumn> list2, List<UlColumn> list3) {
		StringBuffer sb = new StringBuffer();
		List<UlColumn> list = getColumnList(list1, list2, list3);		
		if(list.isEmpty()){
			return "";
		}else if(list.size() > 1){
			list = deleteCheck(list);
		}
		UlColumn[] col = list.toArray(new UlColumn[list.size()]);
		for(int i = 0; i < list.size(); i++) {
			sb.append("<tr ");
			
			if(col[i].getColumnLevel() ==1 ){
				sb.append("bgcolor='#F2A8F9'><td>->");
			}else if(col[i].getColumnLevel() == 2){
				sb.append("bgcolor='#8BC5C0'><td>&nbsp;&nbsp;-->>");
			}else if(col[i].getColumnLevel() == 3){
				sb.append("bgcolor='#96C7FC'><td>&nbsp;&nbsp;&nbsp;&nbsp;--->>>");
			}
			sb.append(col[i].getColumnName());
			sb.append("</td><td>");
			sb.append("<a href='admin/beforeEditColumn.do?columnId=" + col[i].getColumnId() + "'>修改</a>");
			sb.append("&nbsp;");
			if(col[i].getCantBeDelete() != 1){
				sb.append("<a href='javascript:deleteColumn(" + col[i].getColumnId() + ");'>删除</a>");
			}
			sb.append("</td></tr>");
		}
		return sb.toString();
	}
*/
	public   List<UlColumn> deleteCheck(List<UlColumn> list){
		List<UlColumn> listn = new ArrayList<UlColumn>(list.size());
		UlColumn c = new UlColumn();
		for(int i = 1; i < list.size(); i++) {
			c = list.get(i-1);
			if(list.get(i).getParentId() == c.getColumnId()) {
				c.setCantBeDelete(1);
			}
			listn.add(c);
		}		
		listn.add(list.get(list.size()-1));
		return listn;
	}
	
	public   String getDeptList(List<UlDept> list){
		if(list.isEmpty()){
			return "<option>没有对应的部门</option>";
		}
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < list.size(); i++){
			sb.append("<option value='" + list.get(i).getDeptId());
			sb.append("'>" + list.get(i).getDeptName() + "</option>");
		}
		return sb.toString();
	}
	
	public   List<UlColumn> sortColum(List<UlColumn> columList) {
		UlColumn[] colums = columList.toArray(new UlColumn[columList.size()]);
		List<UlColumn> newList = new ArrayList<UlColumn>();
		for (int i = 0; i < colums.length; i++) {			
			List<UlColumn> list = colums[i].getListColumn();
			if (list == null) {
				list = new ArrayList<UlColumn>();
			}
			int columId = colums[i].getColumnId();
			for (int k = 0; k < colums.length; k++) {
				if (k == i) {
					continue;
				}
				if (colums[k].getParentId() == columId) {
					list.add(colums[k]);
				}
			}
			int topColumnId = colums[i].getParentId();
			if (topColumnId == 0) {
				newList.add(colums[i]);
			}
			colums[i].setListColumn(list);
		}
		return newList;
	}
	
	public   String getColumnContentUsedAdmin1(List<UlColumn> l){
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < l.size(); i++){				
			sb.append("<option id='id" + l.get(i).getColumnId() + "' ");
			if(l.get(i).getIncludeContent() == 1){
				sb.append("value='" + l.get(i).getColumnId() + "'>");				
			}else{
				sb.append("value='-1' style='color:#ff0000;'>");
			}
			if(l.get(i).getColumnLevel() == 1){				
					sb.append("->" + l.get(i).getColumnName());								
			}else if(l.get(i).getColumnLevel() == 2){				
					sb.append("--->" + l.get(i).getColumnName());			
			}else if(l.get(i).getColumnLevel() == 3){
				sb.append("----->" + l.get(i).getColumnName());	
			}
			sb.append("</option>");
		}
		return sb.toString();
	}
	
	
	public   String getColumnUsedAdmin1(List<UlColumn> l){
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < l.size(); i++){	
			sb.append("<a href=\"javascript:cList(" 
					+ l.get(i).getColumnId() + ",'" + l.get(i).getColumnName() + "');\">");
			sb.append(l.get(i).getColumnName() + "</a>--" + l.get(i).getOrganId() + "<br>");
		
		}
		return sb.toString();
	}
	
	
	public   String columnListUsedContent(List<UlColumn> l){
		StringBuffer sb = new StringBuffer();
		sb.append("<script type='text/javascript'>");
		sb.append("d = new dTree('d');");
		sb.append("d.add(0,-1,\"所有栏目\");");
		for(int i = 0; i < (l.isEmpty()?0:l.size()); i++){
			sb.append("d.add(" + l.get(i).getColumnId() + "," + l.get(i).getParentId() + ",\"" );
			sb.append(l.get(i).getColumnName() + "\",\"");
			if(l.get(i).getIncludeContent() == 1 ){
				sb.append("javascript:cList(" + l.get(i).getColumnId() + ",'" + l.get(i).getColumnName() + "');\");");
			}else{
				sb.append("\");");
			}
		}
		
		sb.append("document.write(d);");
		sb.append("</script>");
		return sb.toString();
	}
	
	public   String columnListUsedContentForAdmin1(List<UlColumn> l, String aRight){
		StringBuffer sb = new StringBuffer();
		sb.append("<script type='text/javascript'>");
		sb.append("d = new dTree('d');");
		sb.append("d.add(0,-1,\"所有栏目\");");
		for(int i = 0; i < (l.isEmpty()?0:l.size()); i++){
			sb.append("d.add(" + l.get(i).getColumnId() + "," + l.get(i).getParentId() + ",\"" );
			sb.append(l.get(i).getColumnName() + "\",\"");
			if(l.get(i).getIncludeContent() == 1 ){
				if(aRight.indexOf(l.get(i).getColumnId()) < 0){
					sb.append("javascript:nList(" + l.get(i).getColumnId() + ",'" + l.get(i).getColumnName() + "');\");");
				}else{
					sb.append("javascript:cList(" + l.get(i).getColumnId() + ",'" + l.get(i).getColumnName() + "');\");");
				}
				
			}else{
				sb.append("\");");
			}
		}
		
		sb.append("document.write(d);");
		sb.append("</script>");
		return sb.toString();
	}
	
	public   String columnListUsedColumn(List<UlColumn> l, String deptName){
		StringBuffer sb = new StringBuffer();
		sb.append("<script type='text/javascript'>");
		sb.append("d = new dTree('d');");
		sb.append("d.add(0,-1,\"" + deptName + "\",\"javascript:toAddColumn(0,'" + deptName + "');\");");
		for(int i = 0; i < (l.isEmpty()?0:l.size()); i++){
			sb.append("d.add(" + l.get(i).getColumnId() + "," + l.get(i).getParentId() + ",\"" );
			sb.append(l.get(i).getColumnName() + "\",\"");			
			if(l.get(i).getIncludeContent() == 0){
				sb.append("javascript:nList(" + l.get(i).getColumnId() + ",'" + l.get(i).getColumnName() + "');");
				sb.append("\",\"\",\"\",\"images/dtree/folder.gif\",\"images/dtree/folderopen.gif");
			}else{
				sb.append("javascript:nList(" + l.get(i).getColumnId() + ",'" + l.get(i).getColumnName() + "');");
			}
			sb.append("\");");			
		}		
		sb.append("document.write(d);");
		sb.append("</script>");
		return sb.toString();
	}
	
	public   String getContentList(List<UlContent> l){
		StringBuffer sb = new StringBuffer();
		sb.append("<table border=1 width='450' cellspacing='0'>");
		sb.append("<tr><td width='300' colspan=5>最近发布的记录</td></tr>");
		sb.append("<tr><td>栏目名称</td><td>发布时间</td><td>发布人</td><td>修改时间</td><td>操作</td>");
		for(int i = 0; i < (l.isEmpty()?0:l.size()); i++){
			sb.append("<tr><td width='50%' align='left'><a href='show.do?c=" + l.get(i).getContentId()  
					+ "' target='_blank'>" +  l.get(i).getContentName() + "</a>");
			sb.append("</td><td width='10%' align='left'>");
			sb.append(l.get(i).getUploadTime().toString().substring(5,l.get(i).getUploadTime().toString().indexOf(" ")));
			sb.append("</td><td width='20%' align='left'>");
			sb.append(l.get(i).getUploadUser());
			sb.append("</td><td width='10%' align='left'>");
			sb.append(l.get(i).getUpdateTime().toString().substring(5,l.get(i).getUpdateTime().toString().indexOf(" ")));
			sb.append("</td><td width='10%' align='left'>");
			sb.append("<a href='javascript:editContent(" + l.get(i).getContentId() );
			sb.append(");' >修改</a><br>");
			sb.append("<a href='javascript:deleteContent(" + l.get(i).getContentId());
			sb.append(");' style='color:red'>删除</a></td></tr>");
		}	
		sb.append("</table>");
		return sb.toString();
	}
	
	public   String getContentListForAdmin10Content(List<UlContent> l){
		StringBuffer sb = new StringBuffer();
		sb.append("<table border=1 width='450' cellspacing='0'>");
		sb.append("<tr><td width='300' colspan=5>最近发布的记录</td></tr>");
		sb.append("<tr><td>栏目名称</td><td>发布时间</td><td>发布人</td><td>修改时间</td><td>操作</td>");
		for(int i = 0; i < (l.isEmpty()?0:l.size()); i++){
			sb.append("<tr><td width='50%' align='left'><a href='show.do?c=" + l.get(i).getContentId()  
					+ "' target='_blank'>" +  l.get(i).getContentName() + "</a>");
			sb.append("</td><td width='10%' align='left'>");
			sb.append(l.get(i).getUploadTime().toString().substring(5,l.get(i).getUploadTime().toString().indexOf(" ")));
			sb.append("</td><td width='20%' align='left'>");
			sb.append(l.get(i).getUploadUser());
			sb.append("</td><td width='10%' align='left'>");
			sb.append(l.get(i).getUpdateTime().toString().substring(5,l.get(i).getUpdateTime().toString().indexOf(" ")));
			sb.append("</td><td width='10%' align='left'>");
			if(l.get(i).getParentId() == Constant.gongwen){
				sb.append("<a href='javascript:editDocument(" + l.get(i).getContentId() );
				sb.append(");' >修改</a><br>");
			}else{
				sb.append("<a href='javascript:editContent(" + l.get(i).getContentId() );
				sb.append(");' >修改</a><br>");
			}
			sb.append("<a href='javascript:deleteContent(" + l.get(i).getContentId());
			sb.append(");' style='color:red'>删除</a></td></tr>");
		}	
		sb.append("</table>");
		return sb.toString();
	}
/*
	public   String getStringP(HttpServletRequest req, String name){
		return req.getParameter(name) == null ? "" : req.getParameter(name).trim();
	}
	
	public   String getStringA(HttpServletRequest req, String name){
		return req.getAttribute(name) == null ? "" : ((String)req.getAttribute(name)).trim();
	}
	
	public   int getIntP(HttpServletRequest req, String name){
		return req.getParameter(name) == null ? 0 : Integer.parseInt(req.getParameter(name).trim());
	}
	
	public   int getIntA(HttpServletRequest req, String name){
		return req.getAttribute(name) == null ? 0 : ((Integer)req.getAttribute(name)).intValue();
	}
	
	public   int getPage(HttpServletRequest req, String name){
		int page = 1;
		if(req.getParameter(name) != null){
			try{
				page = Integer.parseInt(req.getParameter(name).trim());
			}catch(Exception e){
				page = 1;
			}
				if(page < 1) page = 1;				
		}
		return page;
	}
	
*/
}



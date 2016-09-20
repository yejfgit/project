package com.ulic.ulweb.ulweb.util;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ulic.ulweb.ulweb.entity.UlColumn;
import com.ulic.ulweb.ulweb.entity.UlContent;
import com.ulic.ulweb.ulweb.entity.UlContentWithAtt;

public class DisplayOnPage {

	private static String titleColor[] = {"#000000","#ffffff","#000000","#0066ff","#009900","#00dddd","#ffccff","#9900cc","#ffcc00","#ff0000"};
	private static String[] blankStr = {"", "target='_blank'"};
	
	private HttpServletRequest request = null;

	
    public DisplayOnPage() {
        this.request = null;
    }


	public DisplayOnPage(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	


    public String divContentYunying(String contentName, int newDay, String ptype, String beforTitle)
    {
        StringBuffer sb = new StringBuffer();
        try
        {
            List list = (List)getRequest().getAttribute(contentName);
            if(list != null)
            {
                for(int i = 0; i < list.size(); i++)
                {
                    sb.append("<p>");
                    if(((UlContent)list.get(i)).getHaveContent() == 0 && ((UlContent)list.get(i)).getAttachmentSum() != 0)
                    {
                        sb.append((new StringBuilder(String.valueOf(beforTitle))).append("&nbsp;").append(((UlContent)list.get(i)).getDay()).toString());
                        sb.append((new StringBuilder("&nbsp;&nbsp;<a target='_blank' href='show.do?c=")).append(((UlContent)list.get(i)).getContentId()).append("&a=1' ").append(titleColor[((UlContent)list.get(i)).getDisplayType()]).append(">").toString());
                        sb.append((new StringBuilder(String.valueOf(((UlContent)list.get(i)).getContentName()))).append("</a>").toString());
                        sb.append(((UlContent)list.get(i)).getNewPic(newDay));
                        if(((UlContent)list.get(i)).getAttachmentSum() > 1)
                        {
                            sb.append("<br>");
                            for(int j = 2; j <= ((UlContent)list.get(i)).getAttachmentSum(); j++)
                            {
                                sb.append((new StringBuilder("<a target='_blank' href='show.do?c=")).append(((UlContent)list.get(i)).getContentId()).append("&a=").append(j).append("'>").toString());
                                sb.append((new StringBuilder("\u9644\u4EF6")).append(j - 1).append("</a> &nbsp;&nbsp;").toString());
                            }

                        }
                    } else
                    {
                        sb.append((new StringBuilder(String.valueOf(beforTitle))).append("&nbsp;").append(((UlContent)list.get(i)).getDay()).toString());
                        sb.append((new StringBuilder("&nbsp;&nbsp;<a target='_blank' href='show.do?")).append(ptype).append("&c=").append(((UlContent)list.get(i)).getContentId()).append("' ").append(titleColor[((UlContent)list.get(i)).getDisplayType()]).append(">").toString());
                        sb.append((new StringBuilder(String.valueOf(((UlContent)list.get(i)).getContentName()))).append("</a>").toString());
                        sb.append(((UlContent)list.get(i)).getNewPic(newDay));
                        if(((UlContent)list.get(i)).getAttachmentSum() > 0)
                        {
                            sb.append("<br>");
                            for(int j = 1; j <= ((UlContent)list.get(i)).getAttachmentSum(); j++)
                            {
                                sb.append((new StringBuilder("<a target='_blank' href='show.do?c=")).append(((UlContent)list.get(i)).getContentId()).append("&a=").append(j).append("'>").toString());
                                sb.append((new StringBuilder("\u9644\u4EF6")).append(j).append("</a> &nbsp;&nbsp;").toString());
                            }

                        }
                    }
                    sb.append("</p>");
                }

            }
        }
        catch(Exception e)
        {
            return "";
        }
        return sb.toString();
    }

	
	
//内容列表，显示标题	
	public String divContentNotime(String name , int newDay){
		if(request != null){
			try{
				return divContentNotime(((List)this.request.getAttribute(name)) ,  newDay, "");
			}catch(Exception e){
				return "数据有问题";
			}
		}else{
			return "";
		}		
	}
	
	public String divContentNotime(String name , int newDay, String ptype){
		if(request != null){
			try{
				return divContentNotime(((List)this.request.getAttribute(name)) ,  newDay, "ptype=" + ptype + "&");
			}catch(Exception e){
				return "数据有问题";
			}
		}else{
			return "";
		}		
	}
	
	public String divContent(String name , int newDay){
		if(request != null){
			try{
				return divContent(((List)this.request.getAttribute(name)) ,  newDay,  "");
			}catch(Exception e){
				return "数据有问题";
			}
		}else{
			return "";
		}		
	}


	public String divContent(String name , int newDay, String ptype){
		if(request != null){
			try{
				return divContent(((List)this.request.getAttribute(name)) ,  newDay,  "ptype=" + ptype + "&");
			}catch(Exception e){
				return "数据有问题";
			}
		}else{
			return "";
		}		
	}

	
	public String divContentNotime(List listContent , int newDay, String ptype){
		StringBuffer sb = new StringBuffer();
		try{
			List<UlContent> list = (List<UlContent>)listContent;
			if(list != null){
				for(int i = 0; i < list.size(); i++){					
					sb.append("<p>");					
					if(list.get(i).getHaveContent() == 0 && list.get(i).getAttachmentSum() != 0){
						sb.append("<a target='_blank' href='show.do?c=" + list.get(i).getContentId() + "&a=1' style='color:" + titleColor[list.get(i).getDisplayType()] + "'>");
						sb.append(list.get(i).getContentName() + "</a>");
						sb.append(list.get(i).getNewPic(newDay)  );					
							
						if(list.get(i).getAttachmentSum() > 1){
							sb.append("<br>");
							for(int j = 2; j <= list.get(i).getAttachmentSum() ; j++){
								sb.append("<a target='_blank' href='show.do?c=" + list.get(i).getContentId() + "&a=" + j + "'>");
								sb.append("附件" + (j - 1) + "</a> &nbsp;&nbsp;");
							}							
						}
					}else{
						sb.append("<a target='_blank' href='show.do?" + ptype + "&c=" + list.get(i).getContentId() + "' style='color:" + titleColor[list.get(i).getDisplayType()] + "'>");
						sb.append(list.get(i).getContentName() + "</a>");
						sb.append(list.get(i).getNewPic(newDay) );					
								
						if(list.get(i).getAttachmentSum() > 0){
							sb.append("<br>");
							for(int j = 1; j <= list.get(i).getAttachmentSum() ; j++){
								sb.append("<a target='_blank' href='show.do?c=" + list.get(i).getContentId() + "&a=" + j + "'>");
								sb.append("附件" + j + "</a> &nbsp;&nbsp;");
							}							
						}
					}
					sb.append("</p>");	
				}
				
			}
		}catch(Exception e){
			return "";
		}
		return sb.toString();
	}
	
	public String divContent(List listContent , int newDay, String ptype){
		StringBuffer sb = new StringBuffer();
		try{
			List<UlContent> list = (List<UlContent>)listContent;
			if(list != null){
				for(int i = 0; i < list.size(); i++){					
					sb.append("<p>");					
					if(list.get(i).getHaveContent() == 0 && list.get(i).getAttachmentSum() != 0){
						sb.append("<a target='_blank' href='show.do?c=" + list.get(i).getContentId() + "&a=1' style='color:" + titleColor[list.get(i).getDisplayType()] + "'>");
						sb.append(list.get(i).getContentName() + "</a>");
						sb.append(list.get(i).getNewPic(newDay) + "&nbsp;/" + list.get(i).getDay() );					
							
						if(list.get(i).getAttachmentSum() > 1){
							sb.append("<br>");
							for(int j = 2; j <= list.get(i).getAttachmentSum() ; j++){
								sb.append("<a target='_blank' href='show.do?c=" + list.get(i).getContentId() + "&a=" + j + "'>");
								sb.append("附件" + (j - 1) + "</a> &nbsp;&nbsp;");
							}							
						}
					}else{
						sb.append("<a target='_blank' href='show.do?c=" + list.get(i).getContentId() + "' style='color:" + titleColor[list.get(i).getDisplayType()] + "'>");
						sb.append(list.get(i).getContentName() + "</a>");
						sb.append(list.get(i).getNewPic(newDay) + "&nbsp;/" + list.get(i).getDay());					
								
						if(list.get(i).getAttachmentSum() > 0){
							sb.append("<br>");
							for(int j = 1; j <= list.get(i).getAttachmentSum() ; j++){
								sb.append("<a target='_blank' href='show.do?c=" + list.get(i).getContentId() + "&a=" + j + "'>");
								sb.append("附件" + j + "</a> &nbsp;&nbsp;");
							}							
						}
					}
					sb.append("</p>");	
				}
				
			}
		}catch(Exception e){
			return "";
		}
		return sb.toString();
	}
	
	public String liContent(String name , int newDay){
		if(request != null){
			try{
				return liContent(((List)this.request.getAttribute(name)) ,  newDay,  "");
			}catch(Exception e){
				return "数据有问题";
			}
		}else{
			return "";
		}		
	}


	public String liContent(String name , int newDay, String ptype){
		if(request != null){
			try{
				return liContent(((List)this.request.getAttribute(name)) ,  newDay,  "ptype=" + ptype + "&");
			}catch(Exception e){
				return "数据有问题";
			}
		}else{
			return "";
		}		
	}

	
	public String liContent(List listContent , int newDay, String ptypet){
		StringBuffer sb = new StringBuffer();
		String ptype = "";
		if(!ptype.equals("")){
			ptype = "ptype=" + ptypet;
		}
		try{
			List<UlContent> list = (List<UlContent>)listContent;
			if(list != null){
				for(int i = 0; i < list.size(); i++){					
					sb.append("<li>");					
					if(list.get(i).getHaveContent() == 0 && list.get(i).getAttachmentSum() != 0){
						sb.append("<a target='_blank' href='show.do?c=" + list.get(i).getContentId() + "&a=1' style='color:" + titleColor[list.get(i).getDisplayType()] + "'>");
						sb.append(list.get(i).getContentName() + "</a>");
						sb.append(list.get(i).getNewPic(newDay) + "&nbsp;/" + list.get(i).getDay() );					
							
						if(list.get(i).getAttachmentSum() > 1){
							sb.append("<br>");
							for(int j = 2; j <= list.get(i).getAttachmentSum() ; j++){
								sb.append("<a target='_blank' href='show.do?c=" + list.get(i).getContentId() + "&a=" + j + "'>");
								sb.append("附件" + (j - 1) + "</a> &nbsp;&nbsp;");
							}							
						}
					}else{
						sb.append("<a target='_blank' href='show.do?" + ptype + "c=" + list.get(i).getContentId() + "' style='color:" + titleColor[list.get(i).getDisplayType()] + "'>");
						sb.append(list.get(i).getContentName() + "</a>");
						sb.append(list.get(i).getNewPic(newDay) + "&nbsp;/" + list.get(i).getDay());					
								
						if(list.get(i).getAttachmentSum() > 0){
							sb.append("<br>");
							for(int j = 1; j <= list.get(i).getAttachmentSum() ; j++){
								sb.append("<a target='_blank' href='show.do?c=" + list.get(i).getContentId() + "&a=" + j + "'>");
								sb.append("附件" + j + "</a> &nbsp;&nbsp;");
							}							
						}
					}
					sb.append("</li>");	
				}
				
			}
		}catch(Exception e){
			return "";
		}
		return sb.toString();
	}
	
	public String divContentJustDay(String name , int newDay){
		if(request != null){
			try{
				return divContentJustDay(((List)this.request.getAttribute(name)) ,  newDay,  "");
			}catch(Exception e){
				return "数据有问题";
			}
		}else{
			return "";
		}		
	}


	public String divContentJustDay(String name , int newDay, String ptype){
		if(request != null){
			try{
				return divContentJustDay(((List)this.request.getAttribute(name)) ,  newDay,  "ptype=" + ptype + "&");
			}catch(Exception e){
				return "数据有问题";
			}
		}else{
			return "";
		}		
	}

	
	public String divContentJustDay(List listContent , int newDay, String ptypet){
		StringBuffer sb = new StringBuffer();
		String ptype = "";
		if(!ptype.equals("")){
			ptype = "ptype=" + ptypet;
		}
		try{
			List<UlContent> list = (List<UlContent>)listContent;
			if(list != null){
				for(int i = 0; i < list.size(); i++){					
					sb.append("<p>");					
					if(list.get(i).getHaveContent() == 0 && list.get(i).getAttachmentSum() != 0){
						sb.append("<a target='_blank' href='show.do?c=" + list.get(i).getContentId() + "&a=1' style='color:" + titleColor[list.get(i).getDisplayType()] + "'>");
						sb.append(list.get(i).getDay() + "</a>");
						sb.append(list.get(i).getNewPic(newDay));					
							
						if(list.get(i).getAttachmentSum() > 1){
							sb.append("<br>");
							for(int j = 2; j <= list.get(i).getAttachmentSum() ; j++){
								sb.append("<a target='_blank' href='show.do?c=" + list.get(i).getContentId() + "&a=" + j + "'>");
								sb.append("附件" + (j - 1) + "</a> &nbsp;&nbsp;");
							}							
						}
					}else{
						sb.append("<a target='_blank' href='show.do?" + ptype + "c=" + list.get(i).getContentId() + "' style='color:" + titleColor[list.get(i).getDisplayType()] + "'>");
						sb.append( list.get(i).getDay() + "</a>");
						sb.append(list.get(i).getNewPic(newDay) );					
								
						if(list.get(i).getAttachmentSum() > 0){
							sb.append("<br>");
							for(int j = 1; j <= list.get(i).getAttachmentSum() ; j++){
								sb.append("<a target='_blank' href='show.do?c=" + list.get(i).getContentId() + "&a=" + j + "'>");
								sb.append("附件" + j + "</a> &nbsp;&nbsp;");
							}							
						}
					}
					sb.append("</p>");	
				}
				
			}
		}catch(Exception e){
			return "";
		}
		return sb.toString();
	}
	
	
	
	public String tableContent(List listContent ){
		return tableContent( listContent , "contentList",0,0,0,3);
	}
	
	public String tableContent(List listContent , int newDay){
		return tableContent( listContent , "contentList",0,0,0,newDay);
	}
	
	public String tableContent(List listContent , String className, int border, int cellpadding, int cellspacing, int newDay){
		StringBuffer sb = new StringBuffer();
		try{
		List<UlContent> list = (List<UlContent>)listContent;
			if(list != null){
				sb.append("<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\" class=\"" + className + "\">");
				for(int i = 0; i < list.size(); i++){					
					sb.append("<tr><td height='20'  ></td>");
					sb.append("<td colspan='3' valign='middle'  ><img src='images/index/a6.gif' width='8' height='8'> ");
					if(list.get(i).getHaveContent() == 0 && list.get(i).getAttachmentSum() != 0){
						sb.append("<a target='_blank' href='show.do?c=" + list.get(i).getContentId() + "&a=1'>");
						sb.append(list.get(i).getContentName() + "</a>" + list.get(i).getNewPic(newDay) + "&nbsp;/" + list.get(i).getDay());					
						sb.append("</td><td></td></tr>");			
						if(list.get(i).getAttachmentSum() > 1){
							sb.append("<tr><td></td><td>");
							for(int j = 2; j <= list.get(i).getAttachmentSum() ; j++){
								sb.append("<a target='_blank' href='show.do?c=" + list.get(i).getContentId() + "&a=" + j + "'>");
								sb.append("附件" + (j - 1) + "</a> &nbsp;&nbsp;");
							}
							sb.append("</td><td></td></tr>");
						}
					}else{
						sb.append("<a target='_blank' href='show.do?c=" + list.get(i).getContentId() + "'>");
						sb.append(list.get(i).getContentName() + "</a>" + list.get(i).getNewPic(newDay) + "&nbsp;/" + list.get(i).getDay());					
						sb.append("</td><td></td></tr>");			
						if(list.get(i).getAttachmentSum() > 0){
							sb.append("<tr><td></td><td>");
							for(int j = 1; j <= list.get(i).getAttachmentSum() ; j++){
								sb.append("<a target='_blank' href='show.do?c=" + list.get(i).getContentId() + "&a=" + j + "'>");
								sb.append("附件" + j + "</a> &nbsp;&nbsp;");
							}
							sb.append("</td><td></td></tr>");
						}
					}
							
				}
				sb.append("</table>");
			}
		}catch(Exception e){
			return "";
		}
		return sb.toString();
	}

	
//显示栏目	
	public String divColumn(String name , String url,  int blank){
		if(request != null){
			try{
				return divColumn(((List)this.request.getAttribute(name)) ,url,  blank, "");
			}catch(Exception e){
				return "数据有问题";
			}
		}else{
			return "";
		}		
	}
	
	public String divColumn(String name , String url,  int blank, String color){
		if(request != null){
			try{
				return divColumn(((List)this.request.getAttribute(name)) ,url,  blank, " style='color:" + color + ";'");
			}catch(Exception e){
				return "数据有问题";
			}
		}else{
			return "";
		}		
	}
	
	public String divColumn(List list, String url, int blank, String color){
		try{
			List<UlColumn> l = (List<UlColumn>)list;
			StringBuffer s = new StringBuffer();		
			if(l == null ){
				return "";
			}
			
			for(int i  = 0; i < l.size(); i++){
				s.append("<div>");
				s.append("<a href='" + url + "columnId=" + l.get(i).getColumnId() + "' " + blankStr[blank]);
				if(!color.equals("")){
					if(l.get(i).getColumnId() == (((UlColumn)request.getAttribute("column")).getColumnId())){
						s.append( color);
					}
				}
				s.append(" >");
				s.append(l.get(i).getColumnName() + "</a></div>");
			}
			return s.toString();
		}catch(Exception e){
			return "数据有问题";
		}
	}
	
	public String pColumn(String name , String url,  int blank){
		if(request != null){
			try{
				return pColumn(((List)this.request.getAttribute(name)) ,url,  blank, "");
			}catch(Exception e){
				return "数据有问题";
			}
		}else{
			return "";
		}		
	}
	
	public String pColumn(String name , String url,  int blank, String color){
		if(request != null){
			try{
				return pColumn(((List)this.request.getAttribute(name)) ,url,  blank, " style='color:" + color + ";'");
			}catch(Exception e){
				return "数据有问题";
			}
		}else{
			return "";
		}		
	}
	
	public String pColumn(List list, String url, int blank, String color){
		try{
			List<UlColumn> l = (List<UlColumn>)list;
			StringBuffer s = new StringBuffer();		
			if(l == null ){
				return "";
			}
			
			for(int i  = 0; i < l.size(); i++){
				s.append("<p>");
				s.append("<a href='" + url + "columnId=" + l.get(i).getColumnId() + "' " + blankStr[blank]);
				if(!color.equals("")){
					if(l.get(i).getColumnId() == (((UlColumn)request.getAttribute("column")).getColumnId())){
						s.append( color);
					}
				}
				s.append(" >");
				s.append(l.get(i).getColumnName() + "</a></p>");
			}
			return s.toString();
		}catch(Exception e){
			return "数据有问题";
		}
	}
	
	
	public String liColumn(String name , String url,  int blank){
		if(request != null){
			try{
				return liColumn(((List)this.request.getAttribute(name)) ,url,  blank);
			}catch(Exception e){
				return "数据有问题";
			}
		}else{
			return "";
		}		
	}
	
	public String liColumn(List list, String url, int blank){
		try{
			List<UlColumn> l = (List<UlColumn>)list;
			StringBuffer s = new StringBuffer();		
			if(l == null ){
				return "";
			}
			
			for(int i  = 0; i < l.size(); i++){
				s.append("<li>");
				s.append("<a href='" + url + "columnId=" + l.get(i).getColumnId() + "' " + blankStr[blank] + " >");
				s.append(l.get(i).getColumnName() + "</a></li>");
			}
			return s.toString();
		}catch(Exception e){
			return "数据有问题";
		}
	}
	
	public String tableColumn(List<UlColumn> l, String url, int blank, String className){
		return tableColumnForAll(l, url, blank, "class='" + className + "'");
	}
	
	public String tableColumnForAll(List<UlColumn> l, String url, int blank, String tableAttribute){
		StringBuffer s = new StringBuffer();
		if(l == null ){
			return "";
		}		
		
		s.append("<table " + tableAttribute + " >");
		for(int i  = 0; i < l.size(); i++){
			s.append("<tr><td>");
			s.append("<a href='" + url + "columnId=" + l.get(i).getColumnId() + "' " + "' " + blankStr[blank] + " >");
			s.append(l.get(i).getColumnName() + "</a></td></tr>");
		}
		s.append("</table>");
		return s.toString();
	}
	
//下拉框里的栏目，一般用于查询的栏目选择	
	public String optionColumn(String name){
		if(request != null){
			try{
				return optionColumn(((List)this.request.getAttribute(name)));
			}catch(Exception e){
				return "数据有问题";
			}
		}else{
			return "";
		}			
	}
	
	public String optionColumn(List list ){
		StringBuffer s = new StringBuffer();
		try{
			List<UlColumn> l = (List<UlColumn>)list;
			if(l == null ){
				return "";
			}		
			for(int i  = 0; i < l.size(); i++){
				s.append("<option ");
				s.append("value='" + l.get(i).getColumnId() + "'>");
				s.append(l.get(i).getColumnName() + "</option>");
			}
			return s.toString();
		}catch(Exception e){
			return "";
		}
	}
	
//	显示内容的列表

	public String contentOnPage(String name){		
		try{
			UlContent c = (UlContent)request.getAttribute(name);
			if(c == null){
				return "";				
			}
						
			return c.getContent() ;
		}catch(Exception e){
			return "";
		}
	}
	
	public String contentListOnPage(String name){
		if(request != null){
			try{
				return contentListOnPage(((List)this.request.getAttribute(name)));
			}catch(Exception e){
				return "数据有问题";
			}
		}else{
			return "";
		}	
	}
	
	public String contentListOnPage(List list){		
		try{
			if(list == null){
				return "";				
			}
			List<UlContent> l = (List<UlContent>)list;
			StringBuffer s = new StringBuffer();
			for(int i = 0; i < l.size(); i++){
				s.append(l.get(i).getContent());
				s.append("<br>");
			}
			return s.toString();
		}catch(Exception e){
			return "";
		}
	}

//显示图片的附件	
	
	public String contentAttOnPage(String name, int width, int height){
		if(request != null){
			try{
				return contentAttOnPage(((List)this.request.getAttribute(name)), width, height);
			}catch(Exception e){
				return "数据有问题";
			}
		}else{
			return "";
		}	
	}
	
	
	public String contentAttOnPage(String name){
		if(request != null){
			try{
				return contentAttOnPage(((List)this.request.getAttribute(name)), 0, 0);
			}catch(Exception e){
				return "数据有问题";
			}
		}else{
			return "";
		}	
	}
	
	public String contentAttOnPage(List list, int width, int height){		
		try{
			if(list == null){
				return "";				
			}
			List<UlContentWithAtt> l = (List<UlContentWithAtt>)list;
			StringBuffer s = new StringBuffer();
			for(int i = 0; i < l.size(); i++){
				if(l.get(i).getAttList() != null){
					s.append( l.get(i).getAttList().get(0).getImg(width, height));
					s.append("<br>");
				}
			}
			return s.toString();
		}catch(Exception e){
			return "";
		}
	}
	
//翻页
	public String toPage(int subpage){
		StringBuffer s = new StringBuffer();
		int columnId = 0;
		try{
			if(request.getAttribute("column") != null){
				columnId = ((UlColumn)request.getAttribute("column")).getColumnId();
			}else if(request.getAttribute("columnId") != null){
				columnId = Integer.parseInt((String)request.getAttribute("columnId"));
			}
		
			s.append("<form  method='post' name='forms' id='idforms'>");			
			s.append("<input type='hidden' name='columnId' id='idcolumnId' value='" + columnId + "' />");
			s.append("<input type='hidden' name='ptype' value='" + (request.getAttribute("ptype") == null ? "" : request.getAttribute("ptype")) + "' />");
			
			int totlePage = 1;
			int pageNow = 1;					
			if(request.getAttribute("totlePage") != null){
	
				totlePage = (Integer)request.getAttribute("totlePage");
			}
			if(request.getAttribute("page") != null){
				pageNow = (Integer)request.getAttribute("page");
			}
			if(totlePage > 1){
				s.append("现在是第" + pageNow + "页&nbsp;&nbsp;&nbsp;");
				s.append("共" + totlePage + "页 &nbsp;&nbsp;");
				if(pageNow != 1){
					s.append("<a href='javascript:goto" + subpage + "P(" + (pageNow - 1) + ");'>上一页</a>&nbsp;&nbsp;");
				}						
				s.append("<a href='javascript:goto" + subpage + "Page();' >转到</a>&nbsp;第");
				s.append("<input id='idpage' name='page' size='3' maxlength='3' type='text'></input>页");
				if(pageNow != totlePage){
					s.append("&nbsp;&nbsp;<a href='javascript:goto" + subpage + "P(" + (pageNow + 1) + ");'>下一页</a>&nbsp;&nbsp;");
				}
			}
			s.append("</form>");		
		}catch(Exception e){
			return "";
		}
		return s.toString();
	}
	
	public String toCheckPage(){
		StringBuffer s = new StringBuffer();
		int columnId = 0;
		try{
			if(request.getAttribute("column") != null){
				columnId = ((UlColumn)request.getAttribute("column")).getColumnId();
			}else if(request.getAttribute("columnId") != null){
				columnId = Integer.parseInt((String)request.getAttribute("columnId"));
			}
		
			s.append("<form  method='post' name='forms' id='idforms'>");
			s.append("<input type='hidden' name='condition' id='idcondition' value=\"" + request.getAttribute("condition") + "\" />");
//			s.append("<input type='hidden' name='columnId' value='" + columnId + "' />");
			s.append("<input type='hidden' name='ptype' value='" + (request.getAttribute("ptype") == null ? "" : request.getAttribute("ptype")) + "' />");
							
			int totlePage = 1;
			int pageNow = 1;					
			if(request.getAttribute("totlePage") != null){
	
				totlePage = (Integer)request.getAttribute("totlePage");
			}
			if(request.getAttribute("page") != null){
				pageNow = (Integer)request.getAttribute("page");
			}
			if(totlePage > 1){
				s.append("现在是第" + pageNow + "页&nbsp;&nbsp;&nbsp;");
				s.append("共" + totlePage + "页 &nbsp;&nbsp;");
				if(pageNow != 1){
					s.append("<a href='javascript:gotocP(" + (pageNow - 1) + ");'>上一页</a>&nbsp;&nbsp;");
				}						
				s.append("<a href='javascript:gotocPage();' >转到</a>&nbsp;第");
				s.append("<input id='idpage' name='page' size='3' maxlength='3' type='text'></input>页");
				if(pageNow != totlePage){
					s.append("<a href='javascript:gotocP(" + (pageNow + 1) + ");'>下一页</a>&nbsp;&nbsp;");
				}
			}
			s.append("</form>");		
		}catch(Exception e){
			return "";
		}
		return s.toString();
	}
	
//080219增加 标题前面能带小图片的栏目名和内容名
	public String divContent(String contentName , int newDay, String ptype, String beforTitle){
		StringBuffer sb = new StringBuffer();
		try{
			List<UlContent> list = (List<UlContent>)this.getRequest().getAttribute(contentName);
			if(list != null){
				for(int i = 0; i < list.size(); i++){					
					sb.append("<p>");					
					if(list.get(i).getHaveContent() == 0 && list.get(i).getAttachmentSum() != 0){
						sb.append(beforTitle);
						sb.append("<a target='_blank' href='show.do?c=" + list.get(i).getContentId() + "&a=1' style='color:" + titleColor[list.get(i).getDisplayType()] + "'>");
						sb.append(list.get(i).getContentName() + "</a>");
						sb.append(list.get(i).getNewPic(newDay) + "&nbsp;/" + list.get(i).getDay() );					
							
						if(list.get(i).getAttachmentSum() > 1){
							sb.append("<br>");
							for(int j = 2; j <= list.get(i).getAttachmentSum() ; j++){
								sb.append("<a target='_blank' href='show.do?c=" + list.get(i).getContentId() + "&a=" + j + "'>");
								sb.append("附件" + (j - 1) + "</a> &nbsp;&nbsp;");
							}							
						}
					}else{
						sb.append(beforTitle);
						sb.append("<a target='_blank' href='show.do?" + ptype + "&c=" + list.get(i).getContentId() + "' style='color:" + titleColor[list.get(i).getDisplayType()] + "'>");
						sb.append(list.get(i).getContentName() + "</a>");
						sb.append(list.get(i).getNewPic(newDay) + "&nbsp;/" + list.get(i).getDay());					
								
						if(list.get(i).getAttachmentSum() > 0){
							sb.append("<br>");
							for(int j = 1; j <= list.get(i).getAttachmentSum() ; j++){
								sb.append("<a target='_blank' href='show.do?c=" + list.get(i).getContentId() + "&a=" + j + "'>");
								sb.append("附件" + j + "</a> &nbsp;&nbsp;");
							}							
						}
					}
					sb.append("</p>");	
				}
				
			}
		}catch(Exception e){
			return "";
		}
		return sb.toString();
	}
	
	public String divColumn(String name, String url, int blank, String color, String beforTitle){
		try{
			List<UlColumn> l = (List<UlColumn>)this.getRequest().getAttribute(name);
			StringBuffer s = new StringBuffer();		
			if(l == null ){
				return "";
			}
			
			for(int i  = 0; i < l.size(); i++){
				s.append("<div>");
				s.append(beforTitle);
				s.append("<a href='" + url + "columnId=" + l.get(i).getColumnId() + "' " + blankStr[blank]);
				if(!color.equals("")){
					if(l.get(i).getColumnId() == (((UlColumn)request.getAttribute("column")).getColumnId())){
						s.append( color);
					}
				}
				s.append(" >");
				s.append(l.get(i).getColumnName() + "</a></div>");
			}
			return s.toString();
		}catch(Exception e){
			return "数据有问题";
		}
	}
	
	
	/******** Begin  by wengxf on Feb 4, 2010    ***********/
	
	/**
	 * 显示li标签的内容列表
	 */
	public String showContentList(String colName, int charLength, String detailAction) {
		StringBuffer sb = new StringBuffer();

		List contentList = (List) this.request.getAttribute(colName);
		//System.out.println(contentList != null);
		try {
			List<UlContent> list = (List<UlContent>) contentList;
			if (list != null) {
				//System.out.println("************************" + list.size());
				for (int i = 0; i < list.size(); i++) {
					sb.append("<li>");
					sb.append("<a target='_blank' href='" + detailAction + "c="
							+ list.get(i).getContentId() + "");

					if (list.get(i).getHaveContent() == 0
							&& list.get(i).getAttachmentSum() == 1) {
						sb.append("&a=1");
					}

					sb.append("' title='" + list.get(i).getContentName() + " " + list.get(i).getDay() + "'");
					sb.append(" style='color:"
							+ titleColor[list.get(i).getDisplayType()] + "'>");
					String contentName = list.get(i).getContentName();
					if (contentName.length() > charLength) {
						sb.append(contentName.substring(0, charLength) + "...");
					} else {
						sb.append(contentName);
					}
					sb.append("</a>");

					sb.append("</li>\n");
				}

			}
		} catch (Exception e) {
			System.out.println("exception in show content");
			return "";
		}
		return sb.toString();
	}
	
	/**
	 * 显示li标签的栏目列表
	 */
	public String showColumnList(String parentColName, int charLength, String listAction) {
		StringBuffer sb = new StringBuffer();

		List columnList = (List) this.request.getAttribute(parentColName);

		try {
			List<UlColumn> list = (List<UlColumn>) columnList;
			if (list != null) {
				//System.out.println("************************" + list.size());
				for (int i = 0; i < list.size(); i++) {
					sb.append("<li>");
					sb.append("<a href='" + listAction + "&columnId="
							+ list.get(i).getColumnId() + "'>");
					String columnName = list.get(i).getColumnName();
					if (columnName.length() > charLength) {
						sb.append(columnName.substring(0, charLength) + "...");
					} else {
						sb.append(columnName);
					}
					sb.append("</a>");

					sb.append("</li>\n");
				}

			}
		} catch (Exception e) {
			System.out.println("exception in show column");
			return "";
		}
		return sb.toString();
	}
	
	/**
	 * 显示图片和链接
	 */
	public String showPic(String colName, int len, int width, int height, String defaultPath) {
		StringBuffer sb = new StringBuffer();
		List contentList = (List) this.request.getAttribute(colName);
		try {
			List<UlContentWithAtt> list = (List<UlContentWithAtt>) contentList;
			if (list == null) {
				return sb.toString();
			}

			for (int i = 0; i < len; i++) {

				
				if (i < list.size() && list.get(i).getAttachmentSum() >= 1) {
					if (list.get(i).getSubTitle() != null) {
						sb.append("<a target='_blank' href='" + list.get(i).getSubTitle() + "'>");
						sb.append("<img src=\"" + list.get(i).getAtt(1).getAttachmentPath()
								+ "\" width=\"" + width + "\" height=\"" + height + "\" />");
						sb.append("</a>");
					} else {
						sb.append("<img src=\"" + list.get(i).getAtt(1).getAttachmentPath()
								+ "\" width=\"" + width + "\" height=\"" + height + "\" />");
					}

				} else {
					sb.append("<img src=\"" + defaultPath
							+ "\" width=\"" + width + "\" height=\"" + height + "\" />");
				}
				sb.append("\n");

			}

		} catch (Exception e) {
			System.out.println("exception in show content");
			return "<img src=\"" + defaultPath
			+ "\" width=\"" + width + "\" height=\"" + height + "\" />";
		}
		return sb.toString();
	}
	
	/**
	 * 显示内容详细
	 * @param detailAction
	 * @return
	 */
	public String showContentDetail(String detailAction) {
		StringBuffer sb = new StringBuffer();
		
		UlContent c = (UlContent)request.getAttribute("c");
		if (c == null) {
			return "暂时没有找到任何内容";
		}
		
		// content
		sb.append("<h1>" + c.getContentName() + "</h1>\n");
		sb.append("<h2>" + (c.getSubTitle() == null ? "" : c.getSubTitle()));
		sb.append("发布时间：" + c.getUploadTime().toString()
				.substring(0, c.getUploadTime().toString().indexOf(" "))+ "</h2>\n");
		sb.append("<p>" + (c.getContent() == null ? "此项内容无正文，在主页中查看会自动显示附件内容" : c.getContent()) + "</p>");
		
		// attachment
  		if(c.getAttachmentSum() > 0){
  			sb.append("<ul>");
			for(int i = 0; i < c.getAttachmentSum(); i++){
				sb.append("<li><a target='_blank' href='" + detailAction + "c=" + c.getContentId() + "&a=" + (i + 1) + "'>附件" + (i + 1 ) + "</a></li>");
			}	
			sb.append("</ul>");
		}
		
		return sb.toString();
	}
	
	/**
	 * 得到栏目实体
	 * @return
	 */
	public UlColumn getColumn() {
		return (UlColumn) request.getAttribute("column");
	}
	
	/**
	 * 得到内容实体
	 * @return
	 */
	public UlContent getContent() {
		return (UlContent) request.getAttribute("c");
	}
	
	/**
	 * 得到导航栏
	 * @return
	 */
	public String getNavBar() {
		return (String) request.getAttribute("nav_bar");
	}
	
	/**
	 * 得到分页栏
	 */
	public String showPageBar() {
		
		StringBuffer sb = new StringBuffer();

		int page = Integer.parseInt(String.valueOf(request.getAttribute("page")));
		int totalPage = Integer.parseInt(String.valueOf(request.getAttribute("totalPage")));

		sb.append("页次: [ " + page + " / " + totalPage + " ] ");
		if (page != 1) {
			sb.append("<a href=\"#\" onclick=\"page(" + (page - 1) + ");\">上一页</a> ");
		}
		if (page != totalPage) {
			sb.append("<a href=\"#\" onclick=\"page(" + (page + 1) + ");\">下一页</a> ");
		}

		sb.append("跳转: <select name=\"page\"" +
				" onchange=\"page(this.value);\">");
		for (int i = 1; i <= totalPage; i++) {
			sb.append("<option value=\"" + i + "\"");
			if (i == page) {
				sb.append(" selected=\"true\"");
			}
			sb.append(">" + i + "</option>");
		}

		sb.append("</select>页");
		
		return sb.toString();
		
	}
	
	/******** End  by wengxf on Feb 4, 2010    ***********/
	
//	imgUrl1="dept/dangjian/images/01.jpg";
//	imgtext1="蔬菜广告创意01"
//	imgLink1=escape("");
//	imgUrl2="dept/dangjian/images/02.jpg";
//	imgtext2="蔬菜广告创意02"
//	imgLink2=escape("http://www.xjzhan.com");
//	imgUrl3="dept/dangjian/images/03.jpg";
//	imgtext3="蔬菜广告创意03"
//	imgLink3=escape("http://www.xjzhan.com");
//	imgUrl4="dept/dangjian/images/04.jpg";
//	imgtext4="蔬菜广告创意04"
//	imgLink4=escape("http://www.xjzhan.com");
//	imgUrl5="dept/dangjian/images/05.jpg";
//	imgtext5="蔬菜广告创意05"
//	imgLink5=escape("http://www.xjzhan.com");

	/**
	 * 显示幻灯片flash
	 */
	public String showSlideFlash(String colName, 
			int focusWidth, int focusHeight, int textHeight, String flashSrc) {
		
		// 构造传给flash的参数pics, links, texts
		String pics = "";
		String links = "";
		String texts = "";
		
		//System.out.println(colName + "#" + request.getAttribute(colName));
		List<UlContentWithAtt> cli = (List<UlContentWithAtt>) request.getAttribute(colName);
		//System.out.println(cli.size());
		Iterator<UlContentWithAtt> it = cli.iterator();
		while (it.hasNext()) {
			UlContentWithAtt uc = it.next();
			if (uc.getAttachmentSum() <= 0 || uc.getAtt(0) == null) {
				continue;
			}
			String path = uc.getAtt(0).getAttachmentPath();
			String link = uc.getSubTitle();
			String text = uc.getContentName();
			path = path == null ? "" : path.replace("|", "_");
			link = link == null ? "" : link.replace("|", "_");
			text = text == null ? "" : text.replace("|", "_");
			if (pics.equals("")) {
				pics += path;
				links += link;
				texts += text;
			} else {
				pics += "|" + path;
				links += "|" + link;
				texts += "|" + text;
			}
			
		}
		
		
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("<a target=_self href=\"javascript:goUrl()\"> <span>\n");
		sb.append("<script type=\"text/javascript\">\n");
		
		sb.append("var focus_width=" + focusWidth + ";\n");
		sb.append("var focus_height=" + focusHeight + ";\n");
		sb.append("var text_height=" + textHeight + ";\n");
		sb.append("var swf_height=focus_height+text_height;\n");
		sb.append("var pics='" + pics + "';\n");
		sb.append("var links='" + links + "';\n");
		sb.append("var texts='" + texts + "';\n");
		sb.append("document.write('<object classid=\"" +
				"clsid:d27cdb6e-ae6d-11cf-96b8-444553540000\" " +
				"codebase=\"http://fpdownload.macromedia.com/" +
				"pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0\" " +
				" width=\"'+ focus_width +'\" height=\"'+ swf_height +'\">');\n");
		sb.append("document.write('<param name=\"allowScriptAccess\" value=\"sameDomain\">" +
				"<param name=\"movie\" value=\"" + flashSrc + "\">" +
				"<param name=\"quality\" value=\"high\">" +
				"<param name=\"bgcolor\" value=\"#F0F0F0\">');\n");
		sb.append("document.write('<param name=\"menu\" value=\"false\">" +
				"<param name=\"wmode\" value=\"opaque\">');\n");
		sb.append("document.write('<param name=\"FlashVars\"" +
				" value=\"pics='+pics+'&links='+links+'&texts='+texts" +
				"+'&borderwidth='+focus_width+'&borderheight='+focus_height" +
				"+'&textheight='+text_height+'\">');\n");
		sb.append("document.write('<embed src=\"pixviewer.swf\" wmode=\"opaque\"" +
				" FlashVars=\"pics='+pics+'&links='+links+'&texts='+texts+'&borderwidth='" +
				"+focus_width+'&borderheight='+focus_height+'&textheight='+text_height+'\"" +
				" menu=\"false\" bgcolor=\"#F0F0F0\" quality=\"high\"" +
				" width=\"'+ focus_width +'\" height=\"'+ focus_height +'\"" +
				" allowScriptAccess=\"sameDomain\" type=\"application/x-shockwave-flash\"" +
				" pluginspage=\"http://www.macromedia.com/go/getflashplayer\" />');\n");
		sb.append("document.write('</object>');\n");
		sb.append("</script></span></a><span id=focustext></span>\n");

		return sb.toString();
	}

}

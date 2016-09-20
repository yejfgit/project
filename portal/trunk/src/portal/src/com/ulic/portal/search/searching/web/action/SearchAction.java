package com.ulic.portal.search.searching.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.ulic.portal.pub.vo.PageSupport;
import com.ulic.portal.pub.web.action.BaseAction;
import com.ulic.portal.search.indexing.util.UnicodeUtil;
import com.ulic.portal.search.searching.entity.Footprint;
import com.ulic.portal.search.searching.service.SearchService;


/**
 * 查询Action
 * @author zhangch003
 * 2013-6-21
 */
// 基础路径
@Controller
public class SearchAction extends BaseAction{
	
	private static final long serialVersionUID = 1L;

	/**
	 * 自动注入Service
	 */
	@Resource
	private SearchService searchService;
	
	private String queryString;
	
	private String pageNumString;
	
	private String source;
	
	/**
	 * 搜索痕迹提示
	 */
	private List footprintList;
	
	/**
	 * 相关搜索
	 */
	private List relativeList;
	
	/**
	 * 分页对象
	 */
	private PageSupport pageSupport;

	public PageSupport getPageSupport() {
		return pageSupport;
	}

	public void setPageSupport(PageSupport pageSupport) {
		this.pageSupport = pageSupport;
	}
	
	/**
	 * 绑定结果列表
	 */
	private List resultList;

	public List getResultList() {
		return resultList;
	}

	public void setResultList(List resultList) {
		this.resultList = resultList;
	}
	
	public String getPageNumString() {
		return pageNumString;
	}

	public void setPageNumString(String pageNumString) {
		this.pageNumString = pageNumString;
	}

	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	
	public List getFootprintList() {
		return footprintList;
	}

	public void setFootprintList(List footprintList) {
		this.footprintList = footprintList;
	}
	
	public List getRelativeList() {
		return relativeList;
	}

	public void setRelativeList(List relativeList) {
		this.relativeList = relativeList;
	}

	/**
	 * 分页条件查询
	 * @return
	 */
	@Action(value = "/search/search", results = { @Result(name = SUCCESS, location = "/search/searching/index.jsp") })
    public String search() {
		
		if(this.queryString!=null){
			this.queryString = UnicodeUtil.fromEncodedUnicode(this.queryString.toCharArray(), 0, this.queryString.length());
		}
		
		String queryStr = this.queryString;
		String source = this.source;
			
		if (this.pageSupport == null) {
			this.pageSupport = new PageSupport();
		}
		this.pageSupport.setPageSize(10);
		if(queryStr!=null&&queryStr.length()!=0){
			this.pageSupport = searchService.getResultList(this.pageSupport,queryStr,source);
		}
		HttpServletRequest request = (HttpServletRequest)ServletActionContext.getRequest();
		String ip = request.getRemoteAddr();
//		System.out.println("==============================="+ip);
    		
    	//保存用户搜索痕迹
		if(queryStr!=null&&queryStr.length()!=0){
    		searchService.saveFootPrint(queryStr,ip);
    	}
    	
    	//获取相关链接
		if(queryStr!=null&&queryStr.length()!=0){
        	this.relativeList = searchService.getRelativeList(queryStr);
    	}

		return SUCCESS;
    }
	
	/**
	 * 获取用户查询痕迹
	 * @return
	 * @throws IOException 
	 * @throws IOException 
	 */
	@Action(value = "/search/footprint")
    public String footprint() throws IOException {
		
		String queryStr = this.queryString;
		// 根据用户查询痕迹给出提示
    	this.footprintList = searchService.getFootprintList(queryStr);
    	
		int count = 0;
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for (int i = 0; i < footprintList.size() && count < 10; i++) {
			Footprint fp = (Footprint) footprintList.get(i);
			sb.append("'" + fp.getQueryString() + "',");
			count++;
		}
		if (sb.length() > 1) {
			sb.delete(sb.length() - 1, sb.length());
		}
		sb.append("]");
    	
    	
    	HttpServletResponse response = (HttpServletResponse)ServletActionContext.getResponse();
		PrintWriter pw = response.getWriter();
		pw.println(sb.toString());
		pw.close();
		return null;
    }
	
	/**
	 * 垂直查询查询
	 * @return
	 */
	@Action(value = "/search/searchUlweb2", results = { @Result(name = SUCCESS, location = "/search/searching/index_ulweb2.jsp") })
    public String searchUlweb1() {
		
		if(this.queryString!=null){
			this.queryString = UnicodeUtil.fromEncodedUnicode(this.queryString.toCharArray(), 0, this.queryString.length());
		}
		
		String queryStr = this.queryString;
		String source = this.source;
			
		if (this.pageSupport == null) {
			this.pageSupport = new PageSupport();
		}
		this.pageSupport.setPageSize(10);
		if(queryStr!=null&&queryStr.length()!=0){
			this.pageSupport = searchService.getResultList(this.pageSupport,queryStr,source);
		}
		HttpServletRequest request = (HttpServletRequest)ServletActionContext.getRequest();
		String ip = request.getRemoteAddr();
		System.out.println("==============================="+ip);
    	
    	//保存用户搜索痕迹
		if(queryStr!=null&&queryStr.length()!=0){
    		searchService.saveFootPrint(queryStr,ip);
    	}
    	
    	//获取相关链接
		if(queryStr!=null&&queryStr.length()!=0){
        	this.relativeList = searchService.getRelativeList(queryStr);
    	}

		return SUCCESS;
    }

}

package com.ulic.portal.search.indexing.web.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.ulic.portal.demo.service.CatService;
import com.ulic.portal.pub.web.action.BaseAction;
import com.ulic.portal.search.indexing.service.IIndexService;
import com.ulic.portal.search.indexing.service.impl.IndexService;
import com.ulic.portal.search.indexing.vo.UlDocument;

/**
 * 索引相关action
 * @author zhangch003
 * 2013-6-21
 */
//基础路径
@Controller(value = "/index")
public class IndexAction extends BaseAction {
	
	private static final long serialVersionUID = 1L;
	/**
	 * 自动注入IndexService
	 */
	@Resource
	private IndexService indexService;
	
	@Action(value = "/add", results = { @Result(name = SUCCESS, location = "/search/indexing/addSuccess.jsp") })
	public String createIndex(){
		UlDocument ud = new UlDocument();
		ud.setId(String.valueOf(10000));
		ud.setTitile("合众搜索测试测试");
		ud.setContent("合众搜索 张晨晖，java程序员上班那点事，有备无患。");
		ud.setUrl("show.do?c=10000");
		ud.setSystem("ulweb");
		ud.setType(1);
		
		indexService.createIndex(ud);
		
		return SUCCESS;
	}
	
	
	public static void main(String[] args){
//		createIndex();
	}
}

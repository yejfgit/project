package com.ulic.portal.demo.web.action;

import java.io.IOException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.ulic.portal.demo.entity.Cat;
import com.ulic.portal.demo.service.CatService;
import com.ulic.portal.pub.vo.PageSupport;
import com.ulic.portal.pub.web.action.BaseAction;


/**
 * 猫猫Action
 * @author wengxf
 * 2013-2-20
 */
// 基础路径
@Controller
public class CatAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	
	private static Log log = LogFactory.getLog(CatAction.class);
	
	/**
	 * 自动注入猫猫Service
	 */
	@Autowired
	private CatService catService;
	
	/**
	 * 绑定猫猫实体
	 */
	private Cat cat;
	
	/**
	 * 绑定猫猫列表
	 */
	private List catList;
	
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

	public List getCatList() {
		return catList;
	}

	public void setCatList(List catList) {
		this.catList = catList;
	}

	public Cat getCat() {
		return cat;
	}

	public void setCat(Cat cat) {
		this.cat = cat;
	}

	/**
	 * 首页
	 * @return
	 * @throws IOException 
	 * @throws Exception 
	 */
	@Action(value = "/cat/index")
    public String index() throws Exception {
    	log.debug("cat index");
    	request.getRequestDispatcher("/demo/cat/index.jsp")
    		.forward(request, response);
		return null;
    }

	/**
	 * 分页条件查询
	 * @return
	 */
	@Action(value = "/cat/query", results = { @Result(name = SUCCESS, location = "/demo/cat/query.jsp") })
    public String query() {

    	//PageSupport ps = new PageSupport();
		if (this.pageSupport == null) {
			this.pageSupport = new PageSupport();
		}
		this.pageSupport.setPageSize(1);
		this.pageSupport = catService.getCatList(this.pageSupport);

		return SUCCESS;
    }


	
	/**
	 * 新建
	 * @return
	 */
	@Action(value = "/cat/add", results = { @Result(name = SUCCESS, location = "/demo/cat/add.jsp") })
    public String add() {
		
		return SUCCESS;
    }
	
	/**
	 * 保存
	 * @return
	 */
	@Action(value = "/cat/save", results = { @Result(name = SUCCESS, location = "query", type = "redirect") })
    public String save() {
		
		// 得到页面传来的对象
		Cat c = this.cat;
		catService.saveCat(c);
		
		return SUCCESS;
    }
	
	/**
	 * 编辑
	 * @return
	 */
	@Action(value = "/cat/edit", results = { @Result(name = SUCCESS, location = "/demo/cat/edit.jsp") })
    public String edit() {
		
		// 得到页面传来的id
		int id = this.cat.getId();
		Cat c = catService.getCat(id);
		
		// 发送对象到页面
		this.cat = c;
		return SUCCESS;
    }
	


	
	/**
	 * 更新
	 * @return
	 */
	@Action(value = "/cat/update", results = { @Result(name = SUCCESS, location = "query", type = "redirect") })
    public String update() {
		
		// 得到页面传来的对象
		Cat c = this.cat;
		catService.updateCat(c);
		
		return SUCCESS;
    }
	
	/**
	 * 删除
	 * @return
	 */
	@Action(value = "/cat/del", results = { @Result(name = SUCCESS, location = "query", type = "redirect") })
    public String del() {
		
		// 得到页面传来的id
		int id = this.cat.getId();
		catService.delCat(id);

		return SUCCESS;
    }
	
	
	
	
	@Action(value = "/cat/list")
    public String list() {

    	PageSupport ps = new PageSupport();
    	ps = catService.getCatList(ps);

    	String str = JSON.toJSONString(ps.getItems());
    	str = "{\"catList\":" + str + "}";
    	try {
			response.getWriter().println(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return null;
    }
	
	
	/**
	 * 编辑
	 * @return
	 */
	@Action(value = "/cat/get")
    public String get() {
		
		// 得到页面传来的id
		int id = this.cat.getId();
		Cat c = catService.getCat(id);
		
		String str = JSON.toJSONString(c);
    	str = "" + str + "";
    	try {
			response.getWriter().println(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
    }
	
	/**
	 * 删除
	 * @return
	 */
	@Action(value = "/cat/delete")
    public String delete() {
		
		// 得到页面传来的id
		int id = this.cat.getId();
		catService.delCat(id);

		return null;
    }
	
	
}

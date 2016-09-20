package com.ulic.ulweb.ulweb2.web.tag;

import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ulic.ulweb.frame.service.ServiceLocator;
import com.ulic.ulweb.ulweb2.dao.IContentDao;
import com.ulic.ulweb.ulweb2.entity.PageEntity;

public class ListTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String beanName;

	private int pageSize = 15;

	private int pageNum = 1;

	private String entityName;

	private String conditions;

	private static final Log log = LogFactory.getLog(ListTag.class);

	public int doEndTag() {

		//log.info("==========list tag run");
		this.checkBeanName(0);

		PageEntity pe = new PageEntity();

		// Page
		pe.setPageNum(pageNum);
		pe.setPageSize(pageSize);

		// EntityName
		try {
			Class c = Class.forName("com.ulic.ulweb.ulweb2.entity."
					+ this.entityName);
			pe.setQueryClass(c);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			pe.setQueryClass(null);
		}

		// Query
		pe.setQueryString(this.conditions);
		IContentDao conDao = (IContentDao) ServiceLocator
				.getService("contentAdminDao");
		pageContext.setAttribute(this.beanName, conDao.findByProperties(pe));
		return EVAL_PAGE;
	}

	/**
	 * 检查beanName是否有值，如果没有，则按0，1，2，3一直排下去。 调用此方法时参数请使用0，表示从0开始检查有没有被使用。
	 */
	private void checkBeanName(Integer zero) {
		if (this.beanName == null || this.beanName.trim().equals("")) {
			if (this.pageContext.getAttribute("list" + zero.toString()) == null) {
				this.beanName = "list" + zero.toString();
			} else {
				this.checkBeanName(zero + 1);
			}
		}
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

}

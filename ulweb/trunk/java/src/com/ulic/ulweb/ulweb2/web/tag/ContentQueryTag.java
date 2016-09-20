package com.ulic.ulweb.ulweb2.web.tag;

import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ulic.ulweb.frame.service.ServiceLocator;
import com.ulic.ulweb.ulweb2.entity.ColumnEntity;
import com.ulic.ulweb.ulweb2.entity.PageEntity;
import com.ulic.ulweb.ulweb2.service.IColumnService;
import com.ulic.ulweb.ulweb2.service.IContentService;
import com.ulic.ulweb.ulweb2.util.FormatUtil;

public class ContentQueryTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String beanName;

	private int pageSize = 15;

	private int pageNum = 1;

	private String deptId;

	private String enName;
	
	private int columnId;

	private static final Log log = LogFactory.getLog(ContentQueryTag.class);

	public int doEndTag() {

		//log.info("==========content tag run");
		this.checkBeanName(0);

		IContentService cons = (IContentService) ServiceLocator
		.getService("contentAdminService");
		
		PageEntity pe = new PageEntity();
		pe.setPageSize(pageSize);
		pe.setPageNum(pageNum);

		// English Name
		if (columnId != 0) {
			pe = cons.listContentByParentId(pe, columnId);
			
		} else if (!FormatUtil.isNull(enName)) {
			IColumnService cols = (IColumnService) ServiceLocator
					.getService("columnAdminService");
			ColumnEntity column = cols.getColumnByEnname(deptId, enName);
			if (column == null) {
				column = new ColumnEntity();
			}
			pe = cons.listContentByParentId(pe, column.getColumnId());
			
		}
		
		pageContext.setAttribute(this.beanName, pe);
		return EVAL_PAGE;
	}

	/**
	 * 检查beanName是否有值，如果没有，则按0，1，2，3一直排下去。 调用此方法时参数请使用0，表示从0开始检查有没有被使用。
	 */
	private void checkBeanName(Integer zero) {
		if (this.beanName == null || this.beanName.trim().equals("")) {
			if (this.pageContext.getAttribute("content" + zero.toString()) == null) {
				this.beanName = "content" + zero.toString();
			} else {
				this.checkBeanName(zero + 1);
			}
		}
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public void setColumnId(int columnId) {
		this.columnId = columnId;
	}

}

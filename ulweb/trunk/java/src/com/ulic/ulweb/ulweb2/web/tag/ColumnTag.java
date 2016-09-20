package com.ulic.ulweb.ulweb2.web.tag;

import java.util.ArrayList;

import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ulic.ulweb.frame.service.ServiceLocator;
import com.ulic.ulweb.ulweb2.entity.ColumnEntity;
import com.ulic.ulweb.ulweb2.service.IColumnService;
import com.ulic.ulweb.ulweb2.util.FormatUtil;

public class ColumnTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String beanName;

	private String deptId;

	private String enName;
	
	private int columnId;

	private int withSub = 0;

	private static final Log log = LogFactory.getLog(ColumnTag.class);

	public int doEndTag() {

		//log.info("==========column tag run");
		this.checkBeanName(0);
		
		IColumnService cols = (IColumnService) ServiceLocator
		.getService("columnAdminService");

		ColumnEntity column = new ColumnEntity();
		
		if (columnId == 0 && !FormatUtil.isNull(deptId) && !FormatUtil.isNull(enName)) {
			column = cols.getColumnByEnname(deptId, enName);

		} else {
			column = cols.getColumnById(columnId);
		}
		
		if (column == null) {
			column = new ColumnEntity();
			
		}
		
		int parentId = column.getParentId();
		if (parentId == 0) {
			column.setSubColumns(new ArrayList());
		} else {
			column = cols.getColumnById(column.getParentId());
			column.setSubColumns(cols.findColumnsByParentId(column.getColumnId()));
		}
		

		pageContext.setAttribute(this.beanName, column);
		return EVAL_PAGE;
	}

	private boolean getWithSubBoolean() {
		if (withSub == 1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 检查beanName是否有值，如果没有，则按0，1，2，3一直排下去。 调用此方法时参数请使用0，表示从0开始检查有没有被使用。
	 */
	private void checkBeanName(Integer zero) {
		if (this.beanName == null || this.beanName.trim().equals("")) {
			if (this.pageContext.getAttribute("column" + zero.toString()) == null) {
				this.beanName = "column" + zero.toString();
			} else {
				this.checkBeanName(zero + 1);
			}
		}
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public void setWithSub(int withSub) {
		this.withSub = withSub;
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

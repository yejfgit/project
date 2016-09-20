package com.ulic.ulweb.ulweb2.web.tag;

import java.util.ArrayList;

import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ulic.ulweb.frame.service.ServiceLocator;
import com.ulic.ulweb.ulweb2.entity.ColumnEntity;
import com.ulic.ulweb.ulweb2.entity.DeptEntity;
import com.ulic.ulweb.ulweb2.service.IColumnService;
import com.ulic.ulweb.ulweb2.service.IDeptService;
import com.ulic.ulweb.ulweb2.util.FormatUtil;

public class NavbarTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String beanName;

	private String deptId;

	private String enName;
	
	private int columnId;

	private static final Log log = LogFactory.getLog(NavbarTag.class);

	public int doEndTag() {

		//log.info("==========navbar tag run");
		this.checkBeanName(0);
		
		IColumnService cols = (IColumnService) ServiceLocator
		.getService("columnAdminService");
		IDeptService ds = (IDeptService) ServiceLocator
		.getService("deptAdminService");

		ColumnEntity column = new ColumnEntity();
		DeptEntity dept = new DeptEntity();
		
		if (columnId == 0 && !FormatUtil.isNull(deptId) && !FormatUtil.isNull(enName)) {
			column = cols.getColumnByEnname(deptId, enName);
			dept = ds.getDeptById(deptId);
			
		} else if (columnId != 0) {
			column = cols.getColumnById(columnId);
			dept = ds.getDeptById(column.getOrganId());
		} else {
			pageContext.setAttribute(this.beanName, "");
			return EVAL_PAGE;
		}
		if (column == null) {
			column = new ColumnEntity();
		}
		
		StringBuffer sb = new StringBuffer();
		
		while (column != null && column.getColumnId() != 0) {
			sb.insert(0, " > " + column.getColumnName());
			column = cols.getColumnById(column.getParentId());
		}
		sb.insert(0, dept.getDeptName());
		
		//log.info(sb.toString());

		pageContext.setAttribute(this.beanName, sb.toString());
		return EVAL_PAGE;
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

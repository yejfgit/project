package com.ulic.ulweb.ulweb2.web.tag;

import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.ulic.ulweb.frame.service.ServiceLocator;
import com.ulic.ulweb.ulweb.util.ContentTool;
import com.ulic.ulweb.ulweb2.entity.ColumnEntity;
import com.ulic.ulweb.ulweb2.entity.ContentEntity;
import com.ulic.ulweb.ulweb2.entity.PageEntity;
import com.ulic.ulweb.ulweb2.service.IColumnService;
import com.ulic.ulweb.ulweb2.service.IContentService;
import com.ulic.ulweb.ulweb2.util.FormatUtil;

public class ContentTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String beanName;

	private int pageSize = 15;

	private int pageNum = 1;

	private String deptId;

	private String enName;
	
	private String keyWord;
	
	private int columnId;

	private String conditions;

	private int withAtt = 0;
	
	private int clickNum = 0;
	

	private static final Log log = LogFactory.getLog(ContentTag.class);

	public int doEndTag() {

		//log.info("==========content tag run");
		this.checkBeanName(0);

		PageEntity pe = new PageEntity();

		// Page
		pe.setPageSize(pageSize);
		pe.setPageNum(pageNum);
		

		// EntityName
		try {
			Class c = Class
					.forName("com.ulic.ulweb.ulweb2.entity.ContentEntity");
			pe.setQueryClass(c);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			pe.setQueryClass(null);
		}

		// English Name
		if (columnId != 0) {
			this.conditions = "columnId=" + columnId + ":i;"
			+ this.conditions;
		} else if (!FormatUtil.isNull(enName)) {
			IColumnService cols = (IColumnService) ServiceLocator
					.getService("columnAdminService");
			ColumnEntity column = cols.getColumnByEnname(deptId, enName);
			if (column == null) {
				column = new ColumnEntity();
			}
			this.conditions = "columnId=" + column.getColumnId() + ":i;"
					+ this.conditions;
		} else if (!FormatUtil.isNull(deptId)) {
			this.conditions = "organId=" + deptId + ":s;"
			+ this.conditions;
		}
		
		DetachedCriteria dc = DetachedCriteria.forClass(ContentEntity.class);
		//log.info("condition:" + conditions + "Key Word:" + keyWord);
		// Key Word
		if (!FormatUtil.isNull(keyWord)) {
			keyWord = ContentTool.unescape(keyWord, "U");
			dc.add(Restrictions.like("contentName", keyWord, MatchMode.ANYWHERE));

		}
		//log.info("condition:" + conditions + "Key Word:" + keyWord);
		
		// Query
		dc.addOrder(Order.desc("orderNum"));
		dc.addOrder(Order.desc("contentId"));
		pe.setCondition(dc);
		pe.setQueryString(this.conditions);

		IContentService cons = (IContentService) ServiceLocator
				.getService("contentAdminService");
		
		if(clickNum!=0){
			pageContext.setAttribute(this.beanName, cons.listContentByColumnId(pe,
					this.getWithAttBoolean(),clickNum,columnId));
		}else{
			pageContext.setAttribute(this.beanName, cons.listContentByColumnId(pe,
					this.getWithAttBoolean()));
		}
		
		
		return EVAL_PAGE;
	}

	private boolean getWithAttBoolean() {
		if (withAtt == 1) {
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

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setWithAtt(int withAtt) {
		this.withAtt = withAtt;
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

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public void setClickNum(int clickNum) {
		this.clickNum = clickNum;
	}

}

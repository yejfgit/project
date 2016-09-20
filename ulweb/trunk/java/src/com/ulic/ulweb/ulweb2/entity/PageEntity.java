package com.ulic.ulweb.ulweb2.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

public class PageEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Log log = LogFactory.getLog(PageEntity.class);
	
	private List objectList;
	
	private int pageSize = 15;
	
	private int pageNum = 1;
	
	private int pageTotalNum;
	
	private int firstResult;
	
	private int totalNum;
	
	private Map queryCondition;

	private List queryOrder;
	
	private DetachedCriteria condition;
	
	private String queryString;
	
	private Class queryClass;
	
	private String pageTag;
	


	public List getObjectList() {
		return objectList;
	}

	public void setObjectList(List objectList) {
		this.objectList = objectList;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
		this.firstResult = (pageNum - 1) * this.pageSize;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		if (pageSize == 0) {
			return;
		}
		this.pageSize = pageSize;
	}

	public int getPageTotalNum() {
		return pageTotalNum;
	}

	public void setPageTotalNum(int pageTotalNum) {
		this.pageTotalNum = pageTotalNum;
	}

	public Map getQueryCondition() {
		return queryCondition;
	}

	public void setQueryCondition(Map queryCondition) {
		this.queryCondition = queryCondition;
	}

	public List getQueryOrder() {
		return queryOrder;
	}

	public void setQueryOrder(List queryOrder) {
		this.queryOrder = queryOrder;
	}
	
	public String getQueryConditionString() {
		Map qc = this.queryCondition;
		if (qc == null || qc.isEmpty()) {
			return "";
		}
		StringBuffer sb = new StringBuffer();
		sb.append(" where");
		
		Iterator it = qc.keySet().iterator();
		int i = 0;
		while (it.hasNext()) {
			String element = (String) it.next();
			sb.append(" " + element + " = :" + element);
			if (i < qc.size() - 1) {
				sb.append(" and");
			}
			i++;
		}
		//log.debug("Query Condition String:" + sb.toString());
		return sb.toString();
	}
	
	public String getQueryOrderString() {
		List qo = this.queryOrder;
		if (qo == null || qo.isEmpty()) {
			return "";
		}
		StringBuffer sb = new StringBuffer();
		sb.append(" order by");
		
		Iterator it = qo.iterator();
		int i = 0;
		while (it.hasNext()) {
			String element = (String) it.next();
			sb.append(" " + element);
			if (i < qo.size() - 1) {
				sb.append(",");
			}
			i++;
		}
		//log.debug("Query Order String:" + sb.toString());
		return sb.toString();
	}

	public int getFirstResult() {
		return firstResult;
	}

	public void setFirstResult(int firstResult) {
		this.firstResult = firstResult;
	}
	
	public void setPageTag(String pageTag) {
		this.pageTag = pageTag;
	}
	
	public String getPageTag() {
		StringBuffer sb = new StringBuffer();
		sb.append("页次: [ " + this.pageNum + " / " + this.pageTotalNum + " ] ");
		
		if (this.pageNum != 1) {
			sb.append(" <a href=\"javascript:page(" + (this.pageNum - 1) + ");\">上一页</a> ");
		}
		if (this.pageNum != this.pageTotalNum) {
			sb.append(" <a href=\"javascript:page(" + (this.pageNum + 1) + ");\">下一页</a> ");
		}
		
		if (this.pageTotalNum > 1) {
			sb.append("跳转: <select onchange=\"page(this.value);\">");
			for (int i = 1; i <= this.pageTotalNum; i++) {
				if (i == this.pageNum) {
					sb.append("<option value=\"" + i + "\" selected=\"true\">"
							+ i + "</option>");
				} else {
					sb.append("<option value=\"" + i + "\">" + i + "</option>");
				}
			}
			sb.append("</select>页 ");
		}

		this.pageTag = sb.toString();
		//log.debug(sb.toString());
		return this.pageTag;
	}

	public DetachedCriteria getCondition() {
		return condition;
	}

	public void setCondition(DetachedCriteria condition) {
		this.condition = condition;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
		if (totalNum != 0 && totalNum % this.pageSize == 0) {
			this.pageTotalNum = totalNum / this.pageSize;
		} else {
			this.pageTotalNum = totalNum / this.pageSize + 1;
		}

	}

	public String getQueryString() {
		return queryString;
	}

	/**
	 * columnId=3:i;organId=falv:s;uploadTime>2010-01-01:d;uploadTime<2010-02-01
	 * ...
	 * 
	 * @param queryString
	 */
	public void setQueryString(String queryString) {
		this.queryString = queryString;
		final String OP_EQ = "=";
		final String OP_LT = "<";
		final String OP_GT = ">";
		
		if (this.condition == null) {
			DetachedCriteria dc = DetachedCriteria.forClass(this.queryClass);
			this.condition = dc;
		}
		
		try {
			
			String[] cdt = queryString.split(";");
			for (int i = 0; i < cdt.length; i++) {
				String[] seg = cdt[i].trim().split(":");
				String type = seg[1];
				String op = seg[0];
				if (op.indexOf(OP_EQ) != -1) {
					String[] kv = op.split(OP_EQ);
					this.condition.add(Restrictions.eq(kv[0], getValueForType(kv[1], type)));
					
				} else if (op.indexOf(OP_LT) != -1) {
					String[] kv = op.split(OP_LT);
					this.condition.add(Restrictions.lt(kv[0], getValueForType(kv[1], type)));
					
				} else if (op.indexOf(OP_GT) != -1) {
					String[] kv = op.split(OP_GT);
					this.condition.add(Restrictions.gt(kv[0], getValueForType(kv[1], type)));
					
				} else {
					
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		log.debug(condition);

	}

	private Object getValueForType(String value, String type) {
		final String TYPE_INT = "i";
		final String TYPE_STRING = "s";
		final String TYPE_DATE = "d";
		
		if (type.equals(TYPE_INT)) {
			return Integer.parseInt(value);
			
		} else if (type.equals(TYPE_STRING)) {
			return value;
			
		} else if (type.equals(TYPE_DATE)) {
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
			try {
				return sdf.parse(value);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			
		} else {
			
		}
		return null;
	}

	public Class getQueryClass() {
		return queryClass;
	}

	public void setQueryClass(Class queryClass) {
		this.queryClass = queryClass;
	}
	
	
}

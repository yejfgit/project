package com.ulic.portal.search.indexing.service;

import com.ulic.portal.search.indexing.vo.UlDocument;

/**
 * 
 * @author zhangch003
 *
 */
public interface IIndexService  {
	
	/**
	 * 实时创建索引
	 */
	public void createIndex(UlDocument document);
	
	/**
	 * 实时更新索引
	 */
	public void updateIndex(Object obj);
	
	/**
	 * 删除索引
	 */
	public void deleteIndex(UlDocument document);
	
}

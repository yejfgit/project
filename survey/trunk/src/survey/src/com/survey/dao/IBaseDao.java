package com.survey.dao;

import java.util.List;

import com.survey.vo.PageVO;


public interface IBaseDao {
	
	public Object save(Object obj);
	
	public void update(Object obj);
	
	public void delete(Object obj);
	
	/**
	 * 根据id删除某表的记录
	 * @param table
	 * @param id
	 */
	public void deleteById(String table, int id);
	
	/**
	 * 用sql语句执行更新操作
	 * @param sql
	 */
	public void executeUpdate(String sql);
	
	public Object getById(Class c, int id);
	
	/**
	 * 根据一个属性获取列表
	 * @param entity
	 * @param name
	 * @param value
	 * @return
	 */
	public List getListByProperty(String entity, String name, Object value);

	/**
	 * 根据多个属性获取列表
	 * @param entity
	 * @param names
	 * @param values
	 * @return
	 */
	public List getListByProperties(String entity, String[] names, Object[] values);
	
	
	/**
	 * 获取整个列表
	 * @param entity
	 * @return
	 */
	public List getList(String entity);

	
	/**
	 * 用sql分页获取列表
	 * @param pvo 分页控件
	 * @param sql 查询sql
	 * @param resultClazz 结果集类型class
	 * @return
	 */
	public PageVO getListInPage(PageVO pvo, final String sql, final Class resultClazz);
	
	
	
	/**
	 * 用sql获取列表
	 * @param sql
	 * @param resultClazz
	 * @return
	 */
	public List getList(final String sql,
			final Class resultClazz);
	
	/**
	 * 用sql获取列表，并把每个列表元素放入一个map中
	 * @param sql
	 * @return
	 */
	public List getListInMap(final String sql);
	
	/**
	 * 用sql获取一个记录
	 * @param sql
	 * @param resultClazz
	 * @return
	 */
	public Object getRecord(final String sql,
			final Class resultClazz);
	
	
	/**
	 * 批量保存实体
	 * @param entityList
	 */
	public void batchSave(final List entityList);
	
	/**
	 * 用sql执行更新操作（绑定变量）
	 * @param sql
	 * @param paramList
	 */
	public void executeUpdate(final String sql, final List paramList);
	

	public List getList(final String sql,
			final Class resultClazz, List paramList);
	
}

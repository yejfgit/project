package com.ulic.ulweb.frame.dao;

import java.sql.SQLException;
import java.util.List;

import com.ulic.ulweb.frame.bean.AbstractBean;
import com.ulic.ulweb.frame.util.PageTool;

/*
 *	DAO标准接口。未实现的接口抛出java.lang.UnSupportedOperationException
 */
public interface IDao {
	public List<AbstractBean> getList() throws Exception;
	public List<AbstractBean> getList(PageTool pt) throws Exception;
	public AbstractBean getById(int Id) throws SQLException;
	public int add(AbstractBean bean) throws SQLException;
	public void update(AbstractBean bean) throws SQLException;
	public void delete(int Id) throws SQLException;
}

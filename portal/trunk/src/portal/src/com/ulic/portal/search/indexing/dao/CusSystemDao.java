package com.ulic.portal.search.indexing.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ulic.portal.demo.entity.Cat;
import com.ulic.portal.pub.dao.BaseDao;
import com.ulic.portal.search.indexing.entity.CusSystem;

/**
 * 用户系统管理Dao
 * @author zhangch003
 *
 */
@Repository
public class CusSystemDao extends BaseDao {
	
	public CusSystem getCusSystem(String sysName){
		 List list = this.getListByProperty("CusSystem", "sysName", sysName);
		 if(list.size()>0){
			 return (CusSystem) list.get(0);
		 }else{
			 return null;
		 }
	}
	
	
}

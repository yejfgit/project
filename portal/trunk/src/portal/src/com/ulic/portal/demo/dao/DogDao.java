package com.ulic.portal.demo.dao;

import org.springframework.stereotype.Repository;

import com.ulic.portal.demo.entity.Home;
import com.ulic.portal.pub.dao.BaseDao;

/**
 * 狗狗Dao
 * @author User
 * 2013-7-10
 */
@Repository
public class DogDao extends BaseDao {

	public Home getHomeById(int id) {
		return (Home) this.getHibernateTemplate().get(Home.class, id);
	}

}

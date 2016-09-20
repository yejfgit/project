package com.ulic.portal.demo.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.ulic.portal.demo.entity.Cat;
import com.ulic.portal.demo.entity.Hobby;
import com.ulic.portal.demo.entity.Home;
import com.ulic.portal.pub.dao.BaseDao;
import com.ulic.portal.pub.vo.PageSupport;

/**
 * 猫猫Dao
 * @author wengxf
 * 2013-2-20
 */
@Repository
public class CatDao extends BaseDao {

	public void delCat(int id) {
		this.deleteById("t_cat", id);
	}

	/**
	 * 分页取猫猫列表
	 * @param ps
	 * @return
	 */
	public PageSupport getCatList(PageSupport ps) {
		return this.findPageBySql(
				"select id id, cat_name catName, birthday birthday " +
				"from t_cat order by id desc ", 
				Cat.class, 
				ps, 
				new ArrayList()
				);
	}

	public Cat getCat(int id) {
		return (Cat) this.getHibernateTemplate().get(Cat.class, id);
	}
	
	public Cat saveCat(Cat c) {
		this.save(c);
		return null;
	}

	public Cat updateCat(Cat c) {
		this.update(c);
		return null;
	}

	public Home getHomeById(int id) {
		return (Home) this.getHibernateTemplate().get(Home.class, id);
	}

	public Hobby getHobbyById(int id) {
		return (Hobby) this.getHibernateTemplate().get(Hobby.class, id);
	}
	
}

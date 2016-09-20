package com.ulic.portal.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ulic.portal.demo.dao.CatDao;
import com.ulic.portal.demo.entity.Cat;
import com.ulic.portal.demo.entity.Hobby;
import com.ulic.portal.demo.entity.Home;
import com.ulic.portal.pub.vo.PageSupport;

/**
 * 猫猫Service
 * @author wengxf
 * 2013-2-20
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CatService {

	/**
	 * 自动注入Dao
	 */
	@Autowired
	private CatDao catDao;


	/**
	 * 分页查询猫猫列表
	 * @param ps
	 * @return
	 */
	public PageSupport getCatList(PageSupport ps) {
		return catDao.getCatList(ps);
	}

	public Cat saveCat(Cat c) {
		return catDao.saveCat(c);
	}

	/**
	 * 根据ID得到猫猫
	 * @param id
	 * @return
	 */
	public Cat getCat(int id) {
		return catDao.getCat(id);
	}
	
	public Cat updateCat(Cat c) {
		return catDao.updateCat(c);
	}


	public void delCat(int id) {
		catDao.delCat(id);
	}
	
	/**
	 * 根据id得到猫家
	 * @param id
	 * @return
	 */
	public Home getHomeById(int id) {
		return catDao.getHomeById(id);
	}

	
	/**
	 * 根据id得到爱好
	 * @param id
	 * @return
	 */
	public Hobby getHobbyById(int id) {
		return catDao.getHobbyById(id);
	}

	

}

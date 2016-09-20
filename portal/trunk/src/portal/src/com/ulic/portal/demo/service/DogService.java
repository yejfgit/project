package com.ulic.portal.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ulic.portal.demo.dao.DogDao;
import com.ulic.portal.demo.entity.Dog;
import com.ulic.portal.demo.entity.Home;

/**
 * 狗狗Service
 * @author User
 * 2013-7-10
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class DogService {

	/**
	 * 自动注入Dao
	 */
	@Autowired
	private DogDao dogDao;


	public Dog getDogById(int id) {
		return (Dog) dogDao.getById(Dog.class, id);
	}


	/**
	 * 根据id得到家
	 * @param id
	 * @return
	 */
	public Home getHomeById(int id) {
		return dogDao.getHomeById(id);
	}


	

}

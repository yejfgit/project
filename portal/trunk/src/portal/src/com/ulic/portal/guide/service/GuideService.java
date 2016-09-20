package com.ulic.portal.guide.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.ulic.portal.guide.dao.GuideDao;
import com.ulic.portal.guide.entity.Guide;
import com.ulic.portal.pub.vo.PageSupport;

/**
 * 服务向导Service
 * @author wengxf
 * 2013-6-18
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class GuideService {
	
	/**
	 * 自动注入Dao
	 */
	@Resource
	private GuideDao guideDao;


	/**
	 * 分页查询服务向导列表
	 * @param ps
	 * @return
	 */
	public PageSupport getGuideList(PageSupport ps) {
		return guideDao.getGuideList(ps);
	}

	/**
	 * 分页搜索查询服务向导列表
	 * @param ps
	 * @return
	 */
	public PageSupport getSearchGuideList(PageSupport ps,String search) {
		return guideDao.getSearchGuideList(ps,search);
	}
	
	
	/**
	 * 得到相同类型服务
	 * @param ps
	 * @return
	 */
	public List getSameGuideList(int guideTypeId) {
		return guideDao.getSameGuideList(guideTypeId);
	}
	
	
	/**
	 * 最新相同类型服务
	 * @param ps
	 * @return
	 */
	public List getNewGuideList() {
		return guideDao.getNewGuideList();
	}


	public Guide saveGuide(Guide g) {
		return guideDao.saveGuide(g);
	}

	/**
	 * 根据ID得到服务向导
	 * @param id
	 * @return
	 */
	public Guide getGuide(int guideId) {
		return guideDao.getGuide(guideId);
	}
	
	public Guide updateGuide(Guide g) {
		return guideDao.updateGuide(g);
	}


	public void delGuide(int id) {
		guideDao.delGuide(id);
	}
}

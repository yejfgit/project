package com.ulic.portal.guide.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.ulic.portal.guide.dao.GuideRelationDao;
import com.ulic.portal.guide.entity.GuideRelation;


/**
 * 服务相关Service
 * @author wengxf
 * 2013-6-18
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class GuideRelationService {
	
	/**
	 * 自动注入Dao
	 */
	@Resource
	private GuideRelationDao guideRelationDao;

	//取相关服务列表
	public List getGuideRelationList(int guideId){
		return guideRelationDao.getGuideRelationList(guideId);
	}
	
	public GuideRelation saveGuideRelation(GuideRelation g) {
		return guideRelationDao.saveGuideRelation(g);
	}

	/**
	 * 根据ID得到服务相关
	 * @param id
	 * @return
	 */
	public GuideRelation getGuideRelation(int id) {
		return guideRelationDao.getGuideRelation(id);
	}
	
	public GuideRelation updateGuideRelation(GuideRelation g) {
		return guideRelationDao.updateGuideRelation(g);
	}


	public void delGuideRelation(int id) {
		guideRelationDao.delGuideRelation(id);
	}
}

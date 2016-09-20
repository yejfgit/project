package com.ulic.portal.guide.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.ulic.portal.guide.dao.GuideTypeDao;
import com.ulic.portal.guide.entity.GuideType;


/**
 * 服务向导Service
 * @author wengxf
 * 2013-6-18
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class GuideTypeService {
	
	/**
	 * 自动注入Dao
	 */
	@Resource
	private GuideTypeDao guideTypeDao;



	public GuideType saveGuideType(GuideType g) {
		return guideTypeDao.saveGuideType(g);
	}
	
	//根据guideId得到服务类型
	public GuideType getGuideTypeByGuideId(int guideId){
		return guideTypeDao.getGuideTypeByGuideId(guideId);
	}
	
	//得到所有父节点服务类型
	public List getParentGuideTypeList(){
		return guideTypeDao.getParentGuideTypeList();
	}
	
	
   //根据父节点得到所有子节点的服务类型
	public List getGuideTypeListByParentId(int parentId){
		return guideTypeDao.getGuideTypeListByParentId(parentId);
	}
	
	/**
	 * 根据ID得到服务向导
	 * @param id
	 * @return
	 */
	public GuideType getGuideType(int id) {
		return guideTypeDao.getGuideType(id);
	}
	
	public GuideType updateGuideType(GuideType g) {
		return guideTypeDao.updateGuideType(g);
	}


	public void delGuideType(int id) {
		guideTypeDao.delGuideType(id);
	}
}

package com.ulic.portal.guide.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ulic.portal.guide.entity.Guide;
import com.ulic.portal.guide.entity.GuideRelation;
import com.ulic.portal.guide.vo.GuideVo;
import com.ulic.portal.pub.dao.BaseDao;
import com.ulic.portal.pub.vo.PageSupport;

/**
 * 服务dao
 * @author yejf
 * 2013-06-18
 * */
@Repository
public class GuideRelationDao extends BaseDao{
	
	
	//根据当前guideId取相关服务列表
	public List getGuideRelationList(int guideId){
		String sql="select t.guide_id guideId,t.guide_rel_id guideRelId,t.guide_rel_name guideRelName "+
		" from t_portal_guide_relation t "+
		"where t.guide_id = "+guideId;
		return this.getList(sql, GuideRelation.class);
	}
	
	public void delGuideRelation(int guideId) {
		this.deleteById("table", guideId);
	}

	public GuideRelation getGuideRelation(int guideId) {
		return (GuideRelation) this.getHibernateTemplate().get(GuideRelation.class, guideId);
	}
	
	public GuideRelation saveGuideRelation(GuideRelation g) {
		this.save(g);
		return null;
	}

	public GuideRelation updateGuideRelation(GuideRelation g) {
		this.update(g);
		return null;
	}
}

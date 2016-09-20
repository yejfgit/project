package com.ulic.portal.guide.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.ulic.portal.guide.entity.GuideType;
import com.ulic.portal.pub.dao.BaseDao;


/**
 * 服务dao
 * @author yejf
 * 2013-06-18
 * */
@Repository
public class GuideTypeDao extends BaseDao{
	
	public void delGuideType(int guideTypeid) {
		this.deleteById("table", guideTypeid);
	}

	public GuideType getGuideType(int guideTypeid) {
		return (GuideType) this.getHibernateTemplate().get(GuideType.class, guideTypeid);
	}
	
	public GuideType saveGuideType(GuideType g) {
		this.save(g);
		return null;
	}

	public GuideType updateGuideType(GuideType g) {
		this.update(g);
		return null;
	}
//	得到所有父节点服务类型
	public List getParentGuideTypeList(){
		String sql="select t.id id,t.type_name name,t.parent_id parentId "+
		"from t_portal_guide_type t "+
		"where t.parent_id=0 ";
		return this.getList(sql, GuideType.class);
	}
	
//	根据父节点得到所有子节点的服务类型
	public List getGuideTypeListByParentId(int parentId){
		String sql="select t.id id,t.type_name name,t.parent_id parentId "+
		"from t_portal_guide_type t "+
		"where t.parent_id = "+parentId;
		return this.getList(sql, GuideType.class);
	}
//	根据guideId得到服务类型
	public GuideType getGuideTypeByGuideId(int guideId){
		String sql="select distinct t.id id,t.type_name name,t.parent_id parentId "+
		"from t_portal_guide_type t,t_portal_guide g "+
		"where t.id=g.type_id and g.id =  "+guideId;
		return (GuideType)this.getList(sql, GuideType.class).get(0);
	}
}

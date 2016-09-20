package com.ulic.portal.guide.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ulic.portal.guide.entity.Guide;
import com.ulic.portal.guide.vo.GuideVo;
import com.ulic.portal.pub.dao.BaseDao;
import com.ulic.portal.pub.vo.PageSupport;

/**
 * 服务dao
 * 
 * @author yejf 2013-06-18
 */
@Repository
public class GuideDao extends BaseDao {

	public void delGuide(int guideId) {
		this.deleteById("table", guideId);
	}

	/**
	 * 分页取guide列表
	 * 
	 * @param ps
	 * @return
	 */
	public PageSupport getGuideList(PageSupport ps) {
		return this.findPageBySql("select * " + "from table ", GuideVo.class,
				ps, new ArrayList());
	}
	
	
	/**
	 * 分页搜索取guide列表
	 * 
	 * @param ps
	 * @return
	 */
	public PageSupport getSearchGuideList(PageSupport ps,String search) {
		List list=new ArrayList();
		list.add(0, "%"+search+"%");
		list.add(1, "%"+search+"%");
		list.add(2, "%"+search+"%");
		return this.findPageBySql("select t.id,t.name,t.guide_desc description,t.type_id typeId,t.create_user_id createUserId,t.label,t.create_time createTime " + 
				"from t_portal_guide t "+
				"where (t.name like ? or t.guide_desc like ? or t.label like ?)", 
				GuideVo.class,
				ps, list);
	}
	
	

	/**
	 * 得到相同类型服务
	 * 
	 * @param ps
	 * @return
	 */
	public List getSameGuideList(int guideTypeId) {
		String sql = "select t.id,t.name,t.guide_desc description,t.type_id typeId,t.create_user_id createUserId,t.label "
				+ "from t_portal_guide t " + "where t.type_id = " + guideTypeId;
		return this.getList(sql, Guide.class);

	}

	/**
	 * 最新服务
	 * @param ps
	 * @return
	 */
	public List getNewGuideList() {
		String sql = "select t.id,t.name,t.guide_desc description,t.type_id typeId,t.create_user_id createUserId,t.label  "+ 
				"from ( " + 
				   "select rownum num,a.* "+
				   "from t_portal_guide a "+
				   "order by a.id  "+
				 ")t "+
				"where t.num<4";

		return this.getList(sql, Guide.class);

	}

	public Guide getGuide(int guideId) {
		return (Guide) this.getHibernateTemplate().get(Guide.class, guideId);
	}

	public Guide saveGuide(Guide g) {
		this.save(g);
		return null;
	}

	public Guide updateGuide(Guide g) {
		this.update(g);
		return null;
	}
}

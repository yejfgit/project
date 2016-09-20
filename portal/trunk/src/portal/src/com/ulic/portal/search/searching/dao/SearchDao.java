package com.ulic.portal.search.searching.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ulic.portal.pub.dao.BaseDao;
import com.ulic.portal.pub.vo.PageSupport;
import com.ulic.portal.search.searching.entity.Footprint;
import com.ulic.portal.search.searching.vo.FootprintVO;

/**
 * 检索Dao
 * @author zhangch003
 * 2013-06-21
 */
@Repository
public class SearchDao extends BaseDao {

	public List getFootprintList(String queryString) {
		// TODO Auto-generated method stub
		List paramList = new ArrayList();
		String sql = "select distinct tt.query_string queryString,v.num " +
				"from t_pt_footprint tt," +
				"(select t.query_string queryString,count(1) num " +
				"from t_pt_footprint t group by t.query_string) v " +
				"where tt.query_string = v.queryString " +
				"and (replace(tt.query_string,' ','') like ? " +
				       " or replace(tt.pinyin,' ','') like ? " +
				       " or replace(tt.pinyin_head,' ','') like ? )" +
					   "order by v.num desc";
		
		paramList.add(""+queryString+"%");
		paramList.add(""+queryString+"%");
		paramList.add(""+queryString+"%");
		List list = this.getList(sql, Footprint.class,paramList);
		
		return list;
	}

	public List getRelativeList(String[] queryStr1,String queryStr) {
		// TODO Auto-generated method stub

		List paramList = new ArrayList();

		StringBuffer sb = new StringBuffer();
		sb.append("select distinct tt.query_string queryString,v.num " +
			"from t_pt_footprint tt," +
			"(select t.query_string queryString,count(1) num " +
			"from t_pt_footprint t group by t.query_string) v " +
			"where tt.query_string = v.queryString " +
			"and tt.query_string!= ?" );
		
		paramList.add(queryStr);
		sb.append("and (tt.query_string like ?");
		paramList.add("%"+queryStr+"%");
		for (int i = 0; i < queryStr1.length; i++) {
			sb.append(" or tt.query_string like ?" );
			paramList.add("%"+queryStr1[i]+"%");
		}
		sb.append(")");	
		sb.append("order by v.num desc");
		
		List list =  this.getList(sb.toString(), FootprintVO.class, paramList);

		return list;
	}

}

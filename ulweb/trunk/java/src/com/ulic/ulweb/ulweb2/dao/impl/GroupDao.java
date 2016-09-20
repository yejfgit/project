package com.ulic.ulweb.ulweb2.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ulic.ulweb.ulweb2.dao.IGroupDao;
import com.ulic.ulweb.ulweb2.entity.CusEdcprincipalentitytype;
import com.ulic.ulweb.ulweb2.entity.Edcprincipalentity;
import com.ulic.ulweb.ulweb2.entity.Edcprincipaluserentity;

/**
 * TODO
 * @author pdfshare
 *
 */
public class GroupDao extends HibernateDaoSupport implements IGroupDao {

	@SuppressWarnings("unchecked")
	public List<CusEdcprincipalentitytype> listGroupByType(String type) {
		List<CusEdcprincipalentitytype>  list = null;
		Query query = getSession()
				.createQuery(
						"from com.ulic.ulweb.ulweb2.entity.CusEdcprincipalentitytype c"
								+ " where c.cusType=:type and c.cusIsHidden=0 and c.edcprincipalentity.principaltype=:ptype");
		query.setString("type", type);
		query.setString("ptype", "GROUP");
		list = query.list();
		getSession().close();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Edcprincipaluserentity> findUsers(String uidString) {
		Criteria criteria = getSession().createCriteria(Edcprincipaluserentity.class);
		Criterion criterion = Expression.like("uidstring", "%"+uidString+"%");
		criteria.add(criterion);
		criteria.setFirstResult(0);
		criteria.setMaxResults(30);
		List<Edcprincipaluserentity> idList = criteria.list(); 
		
		
		criteria = getSession().createCriteria(Edcprincipaluserentity.class);
		Criterion criterion2 = Expression.like("friendlyname", "%"+uidString+"%");
		criteria = criteria.createCriteria("edcprincipalentity");
		criteria.setFirstResult(0);
		criteria.setMaxResults(30);
		criteria.add(criterion2);
		
		List nameList = criteria.list();
		
		idList.addAll(nameList);
		
		getSession().close();
		return idList;
	}

	public List<CusEdcprincipalentitytype> listAllGroup() {
		List<CusEdcprincipalentitytype> list = null;
		Query query = getSession()
				.createQuery(
						"from com.ulic.ulweb.ulweb2.entity.CusEdcprincipalentitytype c"
								+ " where c.edcprincipalentity.canonicalname='all_authenticated_users'");
		
		list = query.list();
		
		getSession().close();
		return list;
	}
	

	public Edcprincipaluserentity getUserBuId(String uidString) {
	    Query query = getSession().createQuery("from com.ulic.ulweb.ulweb2.entity.Edcprincipaluserentity u where u.uidstring=:uidString");
	    query.setString("uidString", uidString);
	    Edcprincipaluserentity user = (Edcprincipaluserentity) query.uniqueResult();
	    getSession().close();
		return user;
	}
	

}

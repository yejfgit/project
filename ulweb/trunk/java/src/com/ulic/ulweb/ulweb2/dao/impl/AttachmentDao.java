package com.ulic.ulweb.ulweb2.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ulic.ulweb.ulweb2.dao.IAttachmentDao;
import com.ulic.ulweb.ulweb2.entity.AttachmentEntity;
import com.ulic.ulweb.ulweb2.entity.UlPolicy;

public class AttachmentDao extends HibernateDaoSupport implements IAttachmentDao{

	public AttachmentEntity addAttachement(AttachmentEntity ae) throws Exception {
		Serializable ser = getHibernateTemplate().save(ae);
//		return (AttachmentEntity) getHibernateTemplate().get(AttachmentEntity.class,ser);
		return ae;
	}

	public AttachmentEntity getAttachmentById(int id)throws Exception{
		AttachmentEntity entity = (AttachmentEntity) getHibernateTemplate().get(AttachmentEntity.class, id);
		return entity;
	}

	@SuppressWarnings("unchecked")
	public List<AttachmentEntity> listAttachment(final String sql,final Map<String,Object> map)
			throws Exception {
//		 Query query = getSession().createQuery(sql);
//		 query.setProperties(map);
//		 List list =  (List<AttachmentEntity>)query.list();
//		 getSession().close();
		 
		List list =  getHibernateTemplate().executeFind(new HibernateCallback(){

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				 Query query = session.createQuery(sql);
				 query.setProperties(map);
				List list =  (List<AttachmentEntity>)query.list();
				
				return list;
			}
			 
		 });
		 return list;
	}

	public void update(AttachmentEntity ae) throws Exception {
		 getHibernateTemplate().update(ae);
		
	}
	
	public UlPolicy getUlPolicyById(String policyid)throws Exception{
		UlPolicy ulPolicy = (UlPolicy) getHibernateTemplate().get(UlPolicy.class, policyid);
		return ulPolicy;
	}

	public int getOrderByContentId(int contentId) throws Exception {
		String sql = "select count(*) from AttachmentEntity where content.contentId = :contentId ";
		 Query query = this.getSession().createQuery(sql);   
		 query.setInteger("contentId", contentId);
		
		int order = ((Number)query.uniqueResult()).intValue();
		
		getSession().close();
		return order;
	}

	public void updateOrder(int attachmentId, int order) throws Exception {
		
		AttachmentEntity ae = getAttachmentById(attachmentId);
		ae.setAttachmentOrder(order);
	    getHibernateTemplate().update(ae);
	
	}

	
	
}

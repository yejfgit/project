package com.ulic.ulweb.ulweb2.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ulic.ulweb.ulweb2.dao.IMonitorDao;
import com.ulic.ulweb.ulweb2.entity.ContentEntity;
import com.ulic.ulweb.ulweb2.entity.MonitorClicksEntity;
import com.ulic.ulweb.ulweb2.entity.MonitorEntity;

public class MonitorDao extends HibernateDaoSupport implements IMonitorDao {

	public void save(MonitorEntity m) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(m);
	}
	
	public MonitorClicksEntity getByContentId(int contentId) {
		MonitorClicksEntity c = null;
		try {
			List l = this.getHibernateTemplate().find("from MonitorClicksEntity where contentId = ?", contentId);
			if (l != null && l.size() > 0) {
				c = (MonitorClicksEntity) l.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
	
	public MonitorClicksEntity getMonitorClicksByContentId(int contentId) {
		MonitorClicksEntity c = null;
		try {
			List l = this.getHibernateTemplate().find("from MonitorClicksEntity where contentId = ?", contentId);
			if (l != null && l.size() > 0) {
				c = (MonitorClicksEntity) l.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
	
	public void addTonitorClick(int contentId,long clicks) {
		// TODO Auto-generated method stub
		MonitorClicksEntity m = new MonitorClicksEntity();
		m.setContentId(contentId);
		m.setClicksNums(clicks);
/*		String sql =  " insert into ul_monitor_clicks(id,content_id,clicks_nums) select seq_monitor_clicks_id.nextval,"+contentId+","+clicks+" from dual ";
		Query query = this.getSession().createSQLQuery(sql);
		//query.setInteger("columnId", oldId);
		query.executeUpdate();
		getSession().close();*/
		
		
		try {
			this.getHibernateTemplate().save(m);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	
	}
	
	public void updateTonitorClick(MonitorClicksEntity m) {
		// TODO Auto-generated method stub

		/*String sql =  " update ul_monitor_clicks set clicks_nums ="+clicks+" where content_id ="+contentId;
		Query query = this.getSession().createSQLQuery(sql);
		//query.setInteger("columnId", oldId);
		query.executeUpdate();
		getSession().close();*/
		
		
		final String tempsql = " update ul_monitor_clicks set clicks_nums = clicks_nums+1 where content_id ="+m.getContentId();
		this.getHibernateTemplate().execute(new HibernateCallback()
		{
			public Object doInHibernate(Session session)
			throws HibernateException
			{
				session.createSQLQuery(tempsql).executeUpdate();
				return null;
			}
		});

		
		

		/*try {
			this.getHibernateTemplate().update(m);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

}

package com.ulic.ulweb.ulweb2.dao;

import com.ulic.ulweb.frame.service.IService;
import com.ulic.ulweb.ulweb2.entity.MonitorClicksEntity;
import com.ulic.ulweb.ulweb2.entity.MonitorEntity;

public interface IMonitorDao extends IService {
	
	public void save(MonitorEntity m); 
	public MonitorClicksEntity getMonitorClicksByContentId(int contentId);
	public void addTonitorClick(int contentId,long clicks);
	public MonitorClicksEntity getByContentId(int contentId);
	public void updateTonitorClick(MonitorClicksEntity m);
}

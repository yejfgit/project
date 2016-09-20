package com.ulic.ulweb.ulweb2.dao;

import java.util.List;

import com.ulic.ulweb.frame.service.IService;
import com.ulic.ulweb.ulweb2.entity.ContentClicksGoodEntity;
import com.ulic.ulweb.ulweb2.entity.ContentEntity;
import com.ulic.ulweb.ulweb2.entity.PageEntity;

public interface IContentDao extends IService {

	List findAll();

	ContentEntity getById(int id);

	boolean delete(ContentEntity d);

	ContentEntity save(ContentEntity c);

	boolean update(ContentEntity c);

	PageEntity findByProperties(PageEntity pe);
	
	public PageEntity findByParentId(PageEntity pe, int parentId);

	PageEntity findByPropertyMap(PageEntity pe);

	List getListById(int oldId);

	ContentEntity getLastContentByColumnId(int columnId);
	public List getTopClickNumListById(int oldId);
	public List getLastContentByContentIds(String ContentIds);
	public List getClicksGoodListByContentid(int contentId);
	public ContentClicksGoodEntity getClicksGood(int contentId,int type) ;
	public void updateClicksGood(ContentClicksGoodEntity m) ;
	public void addClicksGood(int contentId,int type,long clicks) ;

}

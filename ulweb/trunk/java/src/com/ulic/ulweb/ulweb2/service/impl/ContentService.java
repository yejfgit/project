package com.ulic.ulweb.ulweb2.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ulic.ulweb.ulweb2.dao.IContentDao;
import com.ulic.ulweb.ulweb2.dao.IMonitorDao;
import com.ulic.ulweb.ulweb2.entity.AttachmentEntity;
import com.ulic.ulweb.ulweb2.entity.ContentClicksGoodEntity;
import com.ulic.ulweb.ulweb2.entity.ContentEntity;
import com.ulic.ulweb.ulweb2.entity.ContentTmplEntity;
import com.ulic.ulweb.ulweb2.entity.MonitorClicksEntity;
import com.ulic.ulweb.ulweb2.entity.PageEntity;
import com.ulic.ulweb.ulweb2.service.IAttachmentService;
import com.ulic.ulweb.ulweb2.service.IColumnService;
import com.ulic.ulweb.ulweb2.service.IContentService;
import com.ulic.ulweb.ulweb2.service.IContentTmplService;
import com.ulic.ulweb.ulweb2.util.EntityUtil;
import com.ulic.ulweb.ulweb2.util.FormatUtil;

public class ContentService implements IContentService {  
	
	private static Log log = LogFactory.getLog(ContentService.class);
	
	private IAttachmentService attachmentService;
	
	private IContentDao contentDao;
	
	private IMonitorDao monitorDao;
	
	private IContentTmplService contentTmplService;
	
	private IColumnService columnService;


	public IMonitorDao getMonitorDao() {
		return monitorDao;
	}

	public void setMonitorDao(IMonitorDao monitorDao) {
		this.monitorDao = monitorDao;
	}

	public void setColumnService(IColumnService columnService) {
		this.columnService = columnService;
	}

	public void setAttachmentService(IAttachmentService attachmentService) {
		this.attachmentService = attachmentService;
	}

	public void setContentDao(IContentDao contentDao) {
		this.contentDao = contentDao;
	}

	public void setContentTmplService(IContentTmplService contentTmplService) {
		this.contentTmplService = contentTmplService;
	}
	
	public ContentEntity getContentById(int id) {
		
		return contentDao.getById(id);
	}

	public ContentEntity saveContent(ContentEntity c) {

		return contentDao.save(c);
	}

	public boolean updateContent(ContentEntity c) {

		return contentDao.update(c);
	}

	public boolean delContentById(int id) {
		
		ContentEntity c = contentDao.getById(id);
		if (c == null) {
			return false;
		} else {
			c.setContentName(c.getContentName() + "-" + new Date());
			c.setIsDelete(1);
			return contentDao.update(c);
		}
	}
	
	public PageEntity listContentByColumnId(PageEntity pe) {

		return contentDao.findByPropertyMap(pe);
	}
	

	public PageEntity listContentByColumnId(PageEntity pe, boolean withAttachments) {

		pe = contentDao.findByProperties(pe);
		List l = pe.getObjectList();
		
		if (withAttachments) {
			Iterator it = l.iterator();
			while (it.hasNext()) {
				ContentEntity c = (ContentEntity) it.next();
				List al;
				try {
					al = attachmentService.listAttachmentByContentId(c.getContentId());
					c.setAttachmentList(al);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
		return pe;
	}
	
	public List getClicksGoodByContentid(int contentId) {

		
		List list = contentDao.getClicksGoodListByContentid(contentId);
		List clicksGoodList = new ArrayList();
		if(list.size()<1){
			for(int i=1;i<=6;i++){
				ContentClicksGoodEntity c = new ContentClicksGoodEntity();
				c.setClicksNums(0);
				c.setContentId(contentId);
				c.setType(i);
				clicksGoodList.add(c);
			}
		}else{
			
			for(int i=1;i<=6;i++){
				boolean ifPass = true;
				for(int j=0;j<list.size();j++){
					ContentClicksGoodEntity c = (ContentClicksGoodEntity)list.get(j);
					if(i==c.getType()){
						clicksGoodList.add(c);
						ifPass = false;
						break;
					}
				}
				if(ifPass){
					ContentClicksGoodEntity c = new ContentClicksGoodEntity();
					c.setClicksNums(0);
					c.setContentId(contentId);
					c.setType(i);
					clicksGoodList.add(c);
				}
				
			}
		}
		
		return clicksGoodList;
	}
	
	
	public ContentClicksGoodEntity getClicksGood(int contentId,int type) {

		ContentClicksGoodEntity c = contentDao.getClicksGood(contentId, type);

		return c;
	}
	
	public PageEntity listContentByColumnId(PageEntity pe, boolean withAttachments,int clickNum,int columnId) {

		
		List list = contentDao.getTopClickNumListById(columnId);
		String contentIds = " ";
		List objectList = new ArrayList();
		if(list.size()<clickNum){
			clickNum = list.size();
		}
		for(int i=0;i<clickNum;i++){
			//BigDecimal tt = (BigDecimal)((Object[])list.get(i))[0];
			MonitorClicksEntity mce = (MonitorClicksEntity)list.get(i);
			contentIds+=mce.getContentId()+",";
			
		}
		contentIds = contentIds.substring(0, contentIds.length()-1);
		if(!"".equals(contentIds)){
			objectList = contentDao.getLastContentByContentIds(contentIds);
		}
		pe.setObjectList(objectList);
		List l = pe.getObjectList();
		
		List objectOrderList = new ArrayList();
		
		for(int i=0;i<clickNum;i++){
			List al;
			MonitorClicksEntity mce = (MonitorClicksEntity)list.get(i);
			int contentId = mce.getContentId();
			long clickN = mce.getClicksNums();
			for(int n=0;n<l.size();n++){
				ContentEntity c = (ContentEntity) l.get(n);
				try {
					
					if(contentId==c.getContentId()){
						al = attachmentService.listAttachmentByContentId(contentId);
						for(int j=0;j<al.size();j++){
							AttachmentEntity attachmentEntity = (AttachmentEntity)al.get(j);
							attachmentEntity.setClickNum(clickN);
							c.setAttachmentList(al);
						}
						objectOrderList.add(c);
					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		}
		pe.setObjectList(objectOrderList);
		return pe;
	}
	
	public PageEntity listContentByParentId(PageEntity pe, int parentId) {
		if (parentId == 0) {
			pe.setObjectList(new ArrayList());
		} else {
			pe = contentDao.findByParentId(pe, parentId);
		}
		return pe;
	}

	public String showContent(int id) {
		
		ContentEntity con = this.getContentById(id);
		ContentTmplEntity tmpl = null;
		try {
			tmpl = columnService.getContentTmplByColumnId(con.getColumnId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (tmpl == null) {
			tmpl = contentTmplService.getTmplById(-1);
			
		}
		String htmlStr = tmpl.getTmplContentString();
		if (htmlStr == null) {
			return null;
		}
		
		Map conMap;
		try {
			conMap = EntityUtil.getObjMap(con);
		} catch (Exception e) {
			conMap = new HashMap();
			e.printStackTrace();
		}
		
		Set s = FormatUtil.getTmplAttributes(htmlStr);

		Iterator it = s.iterator();
		while (it.hasNext()) {
			String attName = (String) it.next();
			Object attValue;
			if ((attValue = conMap.get(attName)) != null) {
				log.debug("attName:" + attName);
				//log.debug("htmlStr:" + htmlStr);
				htmlStr = htmlStr.replace("{!" + attName + "}", 
						FormatUtil.objectToString(attValue));
			} else {
				htmlStr = htmlStr.replace("{!" + attName + "}", "");
			}
		}
		//System.out.println(htmlStr);
		return htmlStr;
	}

	public List getContentListById(int oldId) {
		// TODO Auto-generated method stub
		return contentDao.getListById(oldId);
	}

	public void saveContentClicks(int contentId) {
		// TODO Auto-generated method stub
		/*MonitorClicksEntity mc = monitorDao.getByContentId(contentId);
		
		if(mc!=null&&mc.getId()>1){
			mc.setClicksNums(mc.getClicksNums()+1);
			monitorDao.updateTonitorClick(mc);
		}else{
			monitorDao.addTonitorClick(contentId, 1);
		}*/
		
		MonitorClicksEntity mc = new MonitorClicksEntity();
		mc.setContentId(contentId);
		monitorDao.updateTonitorClick(mc);
		
		//return contentDao.getListById(oldId);
	}
	public void addContentClicks(int contentId) {
		// TODO Auto-generated method stub
		monitorDao.addTonitorClick(contentId, 0);
		
		//return contentDao.getListById(oldId);
	}
	
	public void saveClicksGood(int contentId,int type) {
		// TODO Auto-generated method stub
		ContentClicksGoodEntity cce = contentDao.getClicksGood(contentId, type);
		
		if(cce!=null&&cce.getId()>1){
			cce.setClicksNums(cce.getClicksNums()+1);
			contentDao.updateClicksGood(cce);
		}else{
			contentDao.addClicksGood(contentId, type, 1);
		}
		
		//return contentDao.getListById(oldId);
	}
	
	public long getContentClicks(int contentId) {
		// TODO Auto-generated method stub
		MonitorClicksEntity mc = monitorDao.getByContentId(contentId);
		
		if(mc==null){
			return 0;
		}else{
			return mc.getClicksNums();
		}
		
	}
	
	public ContentEntity getLastContentByColumnId(int columnId) {
		// TODO Auto-generated method stub
		return contentDao.getLastContentByColumnId(columnId);
	}

}

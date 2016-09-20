package com.ulic.ulweb.ulweb2.service;

import java.util.List;

import com.ulic.ulweb.frame.service.IService;
import com.ulic.ulweb.ulweb2.entity.ContentClicksGoodEntity;
import com.ulic.ulweb.ulweb2.entity.ContentEntity;
import com.ulic.ulweb.ulweb2.entity.PageEntity;

public interface IContentService extends IService {

	/**
	 * 增加content。返回带有contentId的content
	 */
	public ContentEntity saveContent(ContentEntity c);
	
	/**
	 * 修改content。返回修改后的content，不带附件。
	 * 注意：content记录的附件个数在修改content之前需要从附件表中先读出放入content后，再进行更新。
	 */
	public boolean updateContent(ContentEntity c);
	
	/**
	 * 根据ID得到content
	 */
	public ContentEntity getContentById(int id);
	
	/**
	 * 根据ID删除content。返回删除后的content
	 * 注意：删除时仅标识content为删除，对附件无影响。
	 */
	public boolean delContentById(int id);
	
	
	/**
	 * 根据columnId得到content列表，使用SQL分页
	 * @param pe
	 * @return
	 */
	public PageEntity listContentByColumnId(PageEntity pe);
	
	/**
	 * 根据columnId得到content的列表，可选择content中是否带有附件。
	 */
	public PageEntity listContentByColumnId(PageEntity pe, boolean withAttachments);

	/**
	 * 根据parentId得到该栏目所有直接下级栏目中的内容
	 */
	public PageEntity listContentByParentId(PageEntity pe, int parentId);
	
	/**
	 * 把内容和模板结合起来显示出来
	 */
	public String showContent(int id);

	//往期电子化报纸
	public List getContentListById(int oldId);

	//得到排序最高的content
	public ContentEntity getLastContentByColumnId(int columnId);
		
	/**
	 * 附件添加完成通知，返回false说明传入的id不存在，返回true说明调用成功
	 * 当所有附件添加完成时调用此方法，此方法被调用后，修改content的状态，让这一条处理等待附件处理中
	 */
	//public boolean setContentAttachmentUploadOver(int contentId);
	
	/**
	 * 得到一组状态的content列表
	 * 根据content的状态返回一个列表，用于timerTask的列表任务
	 */
	//public List<ContentEntity> listContentByStatus();
	
	public PageEntity listContentByColumnId(PageEntity pe, boolean withAttachments,int clickNum,int columnId);
	public void saveContentClicks(int contentId);
	public long getContentClicks(int contentId);
	public List getClicksGoodByContentid(int contentId);
	public ContentClicksGoodEntity getClicksGood(int contentId,int type);
	public void saveClicksGood(int contentId,int type);
	public void addContentClicks(int contentId) ;
}

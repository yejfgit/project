package com.ulic.message;

/**
 * 待办事项条目
 * @author wengxf
 * 2012-11-8
 */
public class TaskItem implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String itemId;
	
	private String title;
	
	private String url;
	
	private String applyUserRealName;
	
	private String applyDate;
	
	private String currentUserName;
	
	// 所属系统
	private String system;
	
	// 类型：1-新增任务，2-完成任务
	private int type;

	public String getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}

	public String getApplyUserRealName() {
		return applyUserRealName;
	}

	public void setApplyUserRealName(String applyUserRealName) {
		this.applyUserRealName = applyUserRealName;
	}

	public String getCurrentUserName() {
		return currentUserName;
	}

	public void setCurrentUserName(String currentUserName) {
		this.currentUserName = currentUserName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	
}

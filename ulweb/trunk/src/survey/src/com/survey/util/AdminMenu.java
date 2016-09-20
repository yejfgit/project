package com.survey.util;

/**
 * 菜单结构
 * @author wengxf
 *
 */
public class AdminMenu {
	private String menuName;
	
	private String menuUrl;
	
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public AdminMenu(String menuName, String menuUrl) {
		super();
		this.menuName = menuName;
		this.menuUrl = menuUrl;
	}
}
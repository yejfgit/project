package com.ulic.portal.demo.web.action;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.stereotype.Controller;

import com.ulic.portal.pub.web.action.BaseAction;


/**
 * Action
 * @author wengxf
 * 2013-2-20
 */
// 基础路径
@Controller
public class BirdAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	

	@Action(value = "/bird/test1")
    public String test1() {
		
		System.out.println("bird test1");

		return null;
    }
	
	@Action(value = "/bird/test2")
    public String test2() {
		
		System.out.println("bird test2");

		return null;
    }
	
	
}

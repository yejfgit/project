package com.ulic.portal.demo.web.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ulic.portal.demo.entity.Dog;
import com.ulic.portal.demo.entity.Home;
import com.ulic.portal.demo.service.DogService;
import com.ulic.portal.pub.web.action.BaseAction;


/**
 * Action
 * @author wengxf
 * 2013-2-20
 */
// 基础路径
@Controller
public class DogAction extends BaseAction {

	private static Log log = LogFactory.getLog(DogAction.class);
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private DogService dogService;

	@Action(value = "/dog/test1")
    public String test1() {
		
//		Dog d = dogService.getDogById(4);
//		log.debug(d.getName());
//		log.debug(d.getHome().getName());
	
		Home h = dogService.getHomeById(1);
		log.debug(h.getName());
		log.debug(h.getDogs().size());
		
		return null;
    }
	
	@Action(value = "/dog/test2")
    public String test2() {
		
		
		return null;
    }
	
	
}

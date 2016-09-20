package com.ulic.ulweb.ulweb.web.action.dept;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ulic.ulweb.frame.action.BaseAction;
import com.ulic.ulweb.ulweb.entity.UlColumn;
import com.ulic.ulweb.ulweb.service.IUlColumnService;
import com.ulic.ulweb.ulweb.service.IUlContentService;
import com.ulic.ulweb.ulweb.service.UtilService;

public class Peixun3Action extends BaseAction {


	private IUlContentService cons = (IUlContentService) this
			.getService("contentService");

	private IUlColumnService cols = (IUlColumnService) this
			.getService("columnService");

	/**
	 * 首页
	 */
	public ActionForward index(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List zuixinList = cons.getListByOrganId("peixun3",7);
		int countProcesser = ((UtilService)this.getService("utilService")).getCountProcesser("peixun");
		
		request.setAttribute("countProcesser", countProcesser);	
		request.setAttribute("zuixinList", zuixinList);
		return new ActionForward("/dept/peixun3/index.jsp");
	}
}

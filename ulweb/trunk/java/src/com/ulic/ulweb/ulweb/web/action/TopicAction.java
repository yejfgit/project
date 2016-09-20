package com.ulic.ulweb.ulweb.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ulic.ulweb.frame.action.BaseAction;
import com.ulic.ulweb.ulweb.service.IUlColumnService;
import com.ulic.ulweb.ulweb.service.IUlContentService;

/**
 * 内部网专栏列表
 * @author wengxf
 *
 */
public class TopicAction extends BaseAction{

	public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		IUlColumnService cols = (IUlColumnService)this.getService("columnService");
		//IUlContentService cons = (IUlContentService)this.getService("contentService");
		List list = cols.getColumnsByParentId(0, "topic");
		
		request.setAttribute("list", list);

		return mapping.findForward("list");
	}
}

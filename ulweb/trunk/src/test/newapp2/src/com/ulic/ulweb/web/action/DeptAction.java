package com.ulic.ulweb.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ulic.ulweb.service.IColumnService;

/**
 * ������
 * 
 */
public class DeptAction extends BaseAction {

	private IColumnService columnService;

	public void setColumnService(IColumnService columnService) {
		this.columnService = columnService;
	}

	/**
	 * ��
	 */
	public ActionForward index(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String organName = "zongban";
		System.out.println("****************************");
		System.out.println(columnService != null);
		request.setAttribute("output", "dept index");

		return new ActionForward("/jsp/dept/" + organName + "/index.jsp");
	}

	/**
	 * �б���
	 */
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		return new ActionForward("list.jsp");
	}

	/**
	 * ��ϸ��
	 */
	public ActionForward detail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		return new ActionForward("detail.jsp");
	}

}

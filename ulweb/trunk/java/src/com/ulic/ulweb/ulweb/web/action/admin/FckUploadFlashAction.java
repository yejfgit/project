package com.ulic.ulweb.ulweb.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ulic.ulweb.frame.action.BaseAction;
import com.ulic.ulweb.frame.constant.Constant;
import com.ulic.ulweb.ulweb.util.ResourceUtil;
import com.ulic.ulweb.ulweb.util.UploadBean;

public class FckUploadFlashAction extends BaseAction{
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {	
		String rand = "" + (int) (Math.random() * 1000000);
		String path = Constant.getUploadPath() + rand;	

		// move file outside
		path = ResourceUtil.getFilesRootDir() + path.substring(path.indexOf("files/"), path.length());
		
		UploadBean ub = new UploadBean(this.getServlet().getServletConfig(), request, response, path);
		String path1 = ub.getDummyPath();		
		ActionForward af = new ActionForward();
		af.setPath("/editor/fckeditor/editor/dialog/fck_flash.jsp?filePath=" + path1);
		af.setRedirect(true);
		return af;
	}
}

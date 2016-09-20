package com.ulic.ulweb.ulweb.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.ulic.ulweb.frame.action.BaseAction;
import com.ulic.ulweb.frame.constant.ChangeConstant;
import com.ulic.ulweb.frame.constant.Constant;
import com.ulic.ulweb.ulweb.entity.UlConfig;
import com.ulic.ulweb.ulweb.service.UtilService;
import com.ulic.ulweb.ulweb.util.CheckUserRight;
import com.ulic.ulweb.ulweb.util.ResourceUtil;

public class AdAction extends BaseAction{
	public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(CheckUserRight.checkUser(request) < 3){
			request.setAttribute("errorMessage", "只有不受限管理员才能作此操作");
			return mapping.findForward("error");
		}
		SmartUpload su = new SmartUpload();
		su.initialize(this.getServlet().getServletConfig(), request, response);
		Request req = su.getRequest();		
		su.upload();		
		Files files = su.getFiles();	
		File file = files.getFile(0);		
		String path = Constant.getUploadPath();
		
		// move file outside
		path = ResourceUtil.getFilesRootDir() + path.substring(path.indexOf("files/"), path.length());
		
		java.io.File f = new java.io.File(path);
		if (!f.exists()) {
			f.mkdirs();
		}
		String subpath = path.substring(path.indexOf("files/"), path.length());
		String tempPath = null;
		int tempType = 0;
		if(!file.isMissing()){
			int ran = ((int)(Math.random() * 100000));
			file.saveAs(path +  ran + "." + file.getFileExt(),SmartUpload.SAVE_PHYSICAL);
			tempPath = subpath + ran + "." + file.getFileExt();
			if(file.getFileExt().equals("gif") || file.getFileExt().equals("jpg") ||
					file.getFileExt().equals("png") || file.getFileExt().equals("bmp") || 
					file.getFileExt().equals("GIF") || file.getFileExt().equals("JPG") ||
					file.getFileExt().equals("PNG") || file.getFileExt().equals("BMP")){
				tempType = 1;		
			}else if(file.getFileExt().equals("swf") || file.getFileExt().equals("SWF")){					
				tempType = 2;
			}
			
		}
		if(tempType == 0){
			request.setAttribute("errorMessage", "上传的文件类型不正确");
			return mapping.findForward("addPage");
		}
		request.setAttribute("name", req.getParameter("name"));
		request.setAttribute("path", tempPath);
		request.setAttribute("type", tempType);		
		return mapping.findForward("confirmPage");
	}
	
	public ActionForward confirm(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(CheckUserRight.checkUser(request) < 3){
			request.setAttribute("errorMessage", "只有不受限管理员才能作此操作");
			return mapping.findForward("error");
		}
		String path = this.getStringValue(request, "path");
		String pname = this.getStringValue(request, "name");
//		int pType = this.getIntValue(request, "type", 0);
		if(pname.length() == 0 ||  path.length() == 0){
			request.setAttribute("errorMessage", "没有得到图片名字和类型的数据，这里是adAction的confirm");
			return mapping.findForward("error");
		}
		UtilService us = (UtilService)this.getService("utilService");
		UlConfig c = us.getByName(pname);
		if(c == null){
			request.setAttribute("errorMessage", "没有得到相应的设置项,这里是adAction的confirm");
			return mapping.findForward("error");
		}
		c.setConstantData(path);
		us.updateConfig(c);
		ChangeConstant cc = new ChangeConstant();
		cc.changeStrig(pname ,path);		
		request.setAttribute("errorMessage","更改成功");
		return mapping.findForward("error");
	}
		
}

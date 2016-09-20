package com.ulic.ulweb.ulweb2.web.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
import org.apache.struts.util.LabelValueBean;

import com.ulic.ulweb.ulweb2.entity.ContentEntity;
import com.ulic.ulweb.ulweb2.service.IContentService;
import com.ulic.ulweb.ulweb2.util.ConfigManager;
import com.ulic.ulweb.ulweb2.util.DepressUtil;

public class NewspaperAdmin extends TopAction {

	private IContentService cons = (IContentService) this
	.getService("contentAdminService");
		
	public ActionForward historyList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		
		int historyColumnId = Integer.parseInt(ConfigManager.getHistoryColumId());
		List historylist = cons.getContentListById(historyColumnId);		
		List historyLabelList = new ArrayList();
		for (Iterator it = historylist.iterator(); it.hasNext();) {
			ContentEntity content =  (ContentEntity) it.next();
			LabelValueBean typeOption = new LabelValueBean(content.getContentName()
					, "" + content.getSubTitle());
			historyLabelList.add(typeOption);
		}
		request.setAttribute("historyLabelList", historyLabelList);
		
		return mapping.findForward("history");
	}
	
	public String upload(FormFile file) throws IOException{
		
		InputStream is = file.getInputStream();
		
		File dir = ConfigManager.getPublishFile();
		String subPath = file.getFileName();
		
		File publishFile = new File(dir,subPath);
		
		OutputStream os = new FileOutputStream(publishFile);
		byte[] buf = new byte[10240];
		int len = 0;
		while((len=is.read(buf))!=-1){
			os.write(buf,0,len);
		}
		os.close();
		is.close();
		file.destroy();
		return subPath;
		
	}
	
	public ActionForward intoLoadPage(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		return mapping.findForward("publish");
	}
	
	public ActionForward publish(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
//		 上传附件
		Hashtable fileh = form.getMultipartRequestHandler().getFileElements();
		if(fileh==null){
			request.setAttribute("info", "请您选择需上传的附件");
		}
		
		for (Enumeration e = fileh.keys(); e.hasMoreElements();) {
			String key = (String) e.nextElement();

			FormFile file = (FormFile) fileh.get(key);
			String subPath = upload(file);
			
			StringBuffer sb = new StringBuffer();

			//windows下路径
			//sb.append(ConfigManager.getPublishFile().toString()+"\\"+ subPath);
			//String adress = sb.toString().substring(0, sb.toString().indexOf(".")) + "\\Index.htm";

			//linux下路径
			sb.append(ConfigManager.getPublishFile().toString()+"/"+ subPath);
			DepressUtil.deCompress(sb.toString(), ConfigManager.getPublishFile().toString());		
			String adress = "/newapp" + sb.toString().substring(sb.toString().indexOf("T")+1 , sb.toString().indexOf(".")) + "/index.html";

			
			request.setAttribute("info", "上传已成功！地址为：<a href='"+ adress +"' target='_blank'>"+ adress +"</a>");
		}
		return mapping.findForward("publish");
	}
	
}

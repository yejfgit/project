package com.survey.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.survey.service.IAttachmentService;
import com.survey.util.DateUtil;
import com.survey.util.ResourceUtil;
import com.survey.util.ServiceLocator;
import com.survey.util.StringUtil;
import com.survey.util.file.FileUploadUtil;
import com.survey.util.file.IFileHandler;
import com.survey.vo.Attachment;



public class AttachmentAction extends BaseAction {

	private IAttachmentService as = (IAttachmentService) ServiceLocator.getService("attachmentService");
	
	
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		int surveyId = StringUtil.parseInt(request.getParameter("surveyId"));
		
		List attList = as.getAttachmentListBySurveyId(surveyId);
		
		request.setAttribute("attachmentList", attList);
		
		if (request.getParameter("edit") != null) {
			request.setAttribute("edit", 1);
		} else {
			request.setAttribute("edit", 0);
		}
		
		return mapping.findForward("list");
	}
	
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		int surveyId = StringUtil.parseInt(request.getParameter("surveyId"));
		
		request.setAttribute("surveyId", surveyId);	
		return mapping.findForward("newAtt");
	}
	
	
	private final static String rootPath = ResourceUtil.getProperty("root_path");
	
	public ActionForward save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		final int surveyId = StringUtil.parseInt(request.getParameter("surveyId"));
		
		FileUploadUtil fu = new FileUploadUtil(
				10, 100, "uploadFile", form, 
				new IFileHandler() {
					
			public String getFilePath(String fileName, int fileSize) {
				// 针对每一个上传的文件进行业务处理
				Attachment att = new Attachment();
				String filePath = DateUtil.getDatePath();
				
				File fd = new File(rootPath + filePath);
				if (!fd.exists()) {
					fd.mkdirs();
				}
				
				String fileType = FileUploadUtil.getFileType(fileName);
				String fileRealName = String.valueOf(System.currentTimeMillis()) + "." + fileType;
				att.setFileName(fileName);
				att.setFilePath(filePath);
				att.setFileRealName(fileRealName);
				att.setSurveyId(surveyId);
				
				
				as.saveAttachment(att);
				
				return rootPath + filePath + fileRealName;
			}
			
		});
		fu.upload();
		
		
				
		return mapping.findForward("newAttDone");
	}

	public ActionForward del(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		int id = StringUtil.parseInt(request.getParameter("id"));
		
		as.delAttachment(id);
		
		return mapping.findForward("newAttDone");
	}
	
	
	/**
	 * 得到附件
	 */
	public ActionForward getAttachment(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		int attId = StringUtil.parseInt(request.getParameter("id"));
		Attachment att = as.getAttachmentById(attId);
		
		InputStream fis = new FileInputStream(rootPath + att.getFilePath() + 
				att.getFileRealName()); 
		byte[] b = new byte[fis.available()];
		fis.read(b);
		
		response.setHeader("Content-disposition",
	    		"attachment; filename=\"" + 
	    		new String(att.getFileName().getBytes("gbk"),"iso8859-1") + 
	    		"\"" );
		OutputStream os = response.getOutputStream();
		os.write(b);
		os.close();
		fis.close();
		
		return null;
	}

}

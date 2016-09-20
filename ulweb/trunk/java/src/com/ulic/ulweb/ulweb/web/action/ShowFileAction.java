package com.ulic.ulweb.ulweb.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ulic.ulweb.frame.action.BaseAction;
import com.ulic.ulweb.ulweb.util.ResourceUtil;

public class ShowFileAction extends BaseAction{
	

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest req,
			HttpServletResponse resp) throws Exception {

		String filePath = this.getStringValue(req, "filePath");
		filePath = filePath.replace("\\", "/");
		if ("".equals(filePath)) {
			resp.getOutputStream().println("filePath not found");
			return null;
		}
		String fileRealPath = req.getScheme() + "://" + req.getServerName()
				+ ":" + req.getServerPort() + "/" + filePath;
		//System.out.println(fileRealPath);
		resp.sendRedirect(fileRealPath);
		
//		this.getServlet().getServletContext().getContext("/")
//		.getRequestDispatcher("/" + filePath).forward(req, resp);

//		String fileRealPath = ResourceUtil.getFilesRootDir() + filePath;
//
//		File f = new File(fileRealPath);
//		
//		//System.out.println(f.getAbsolutePath());
//		
//		if (!f.exists() || !f.isFile()) {
//			resp.getOutputStream().println("file not found");
//			return null;
//		}
//
//		InputStream is = new BufferedInputStream(new FileInputStream(f));
//		
//		String fileName = filePath.substring(filePath.lastIndexOf("/") + 1, filePath.length());
//		String fileType = filePath.substring(filePath.lastIndexOf("."), filePath.length());
//		int fileSize = is.available();
//		
//		resp.addHeader("Content-Disposition", "FileName=" + fileName);
//		resp.setContentType(fileType);
//		resp.setContentLength(fileSize);
//
//		//System.out.println(fileName + "," + fileType + "," + fileSize);
//		//System.out.println(is.available());
//		
//		byte[] content = null;
//		if (is.available() > 0) {
//			content = new byte[is.available()];
//			is.read(content);
//		} else {
//			resp.getOutputStream().println("file has no size");
//			return null;
//		}
//
//		try {
//
//			ServletOutputStream out = resp.getOutputStream();
//			BufferedOutputStream bos = new BufferedOutputStream(out);
//
//			bos.write(content, 0, content.length);
//			bos.flush();
//			bos.close();
//
//		} catch (IOException ioe) {
//			
//		}
		
		return null;
	}

	
}

package com.ulic.ulweb.ulweb2.web.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.adobe.edc.sdk.SDKException;
import com.adobe.edc.sdk.infomodel.PDRLException;
import com.adobe.edc.sdk.infomodel.Policy;
import com.ulic.ulweb.ulweb.web.action.admin.ContentAction;
import com.ulic.ulweb.ulweb2.entity.AttachmentEntity;
import com.ulic.ulweb.ulweb2.entity.ContentEntity;
import com.ulic.ulweb.ulweb2.entity.CusEdcprincipalentitytype;
import com.ulic.ulweb.ulweb2.entity.Edcprincipaluserentity;
import com.ulic.ulweb.ulweb2.entity.UlPolicy;
import com.ulic.ulweb.ulweb2.service.IAttachmentService;
import com.ulic.ulweb.ulweb2.service.IContentService;
import com.ulic.ulweb.ulweb2.service.IGroupService;
import com.ulic.ulweb.ulweb2.service.impl.task.AttachmentEventListener;
import com.ulic.ulweb.ulweb2.service.impl.task.ContentEventListener;
import com.ulic.ulweb.ulweb2.service.impl.task.ConverListerer2;
import com.ulic.ulweb.ulweb2.service.impl.task.PolicyService;
import com.ulic.ulweb.ulweb2.service.impl.task.SecureListerer;
import com.ulic.ulweb.ulweb2.util.ConfigManager;

public class AttachmentAdminAction extends TopAction {

	private IAttachmentService attachmentService = (IAttachmentService) this
			.getService("attachmentAdminService");

	private IContentService cons = (IContentService) this
			.getService("contentAdminService");

	private IGroupService groupService = (IGroupService) this
			.getService("groupAdminService");

	private static long lastGetTime = 0L;
	
	private static Policy[] policyAry = null;
	
   //取policy的间隔时间
	private static final long interval = 60000 * 5;//5分钟

	public ActionForward next(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		UploadForm formBean = (UploadForm) form;
		
		String pageId = request.getParameter("pageId");
		
		Policy[] policyAry = null;
		try {
			policyAry = getPolicys();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		request.setAttribute("policyAry", policyAry);

		String policyName = formBean.getPolicyName();

		String policyId = formBean.getApolicy();
		// 没有policyName说明需要新建策略
		if (policyName == null || "".equals(policyName)) {
			policyId = getPolicyId(formBean, policyName, request);
		}

		ContentEntity content = cons.getContentById(formBean.getContentId());

		UlPolicy ulpolicy = getULPolicy(formBean, policyId, policyName, request);
		// 保存
		String username = (String) request.getSession().getAttribute("username");

		
		
		// 上传附件
		Hashtable fileh = form.getMultipartRequestHandler().getFileElements();
		
		for (Enumeration e = fileh.keys(); e.hasMoreElements();) {
			String key = (String) e.nextElement();

			FormFile file = (FormFile) fileh.get(key);
			
			log.debug(file.getFileName());

			if (!check(file, request)) {
//				return mapping.findForward("input");
				continue;
			}
			String subPath = upload(file, content);

			//int size = formBean.getAttachmentListSize();
			saveAttachment(formBean, ulpolicy, subPath, file.getFileName(),
					username, 0, content);

		}


		
		/**
		 * 更新顺序
		 */
		String[] flags = (String[]) request.getParameterValues("flag");
		String[] ids = request.getParameterValues("idList");
		String[] orders = (String[]) request.getParameterValues("orderList");

		updateOrder(flags, ids, orders);

		List<AttachmentEntity> attachmentList = attachmentService
		.listAttachmentByContentId(formBean.getContentId());
		
		content = cons.getContentById(content.getContentId());
		content.setAttachmentSum(attachmentList.size());
		cons.updateContent(content);
		
		request.setAttribute("attachmentList", attachmentList);
		String contentId = request.getParameter("contentId");
		request.setAttribute("contentId", contentId);
		request.setAttribute("pageId", pageId);
		return mapping.findForward("next");

	}

	private void updateOrder(String[] flags, String[] ids, String[] orders)
			throws Exception {

		if (flags == null || flags.length < 0) {
			return;
		}
		for (int i = 0; i < flags.length; i++) {
			if ("Y".equals(flags[i])) {
				int odr;
				try {
					odr = Integer.valueOf(orders[i]);
				} catch (RuntimeException e) {
					odr = -100;
				}
				if (odr > 99 || odr < -99) {
					continue;
				}
				attachmentService.updateOrder(Integer.valueOf(ids[i]), odr);
			}
		}

	}

	public ActionForward getPolicy(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Policy[] policyAry = null;
		try {
			policyAry = getPolicys();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Policy Server Connection Exception: " + e.getMessage());
			e.printStackTrace();
		}
		request.setAttribute("policyAry", policyAry);
		return mapping.findForward("input");
	}

	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String contentId = request.getParameter("contentId");
		String pageId = request.getParameter("pageId");
		List<AttachmentEntity> attachmentList = attachmentService
				.listAttachmentByContentId(Integer.valueOf(contentId));
		request.setAttribute("attachmentList", attachmentList);
		request.setAttribute("contentId", contentId);
		request.setAttribute("pageId", pageId);
		return getPolicy(mapping, form, request, response);

	}

	private Policy[] getPolicys() throws SDKException {
		// TODO 设定缓存
		//policyAry = null;
		if (policyAry == null
				|| ((System.currentTimeMillis() - lastGetTime) >interval && lastGetTime > 0L)) {

			log.debug(" get policy ...... policyAry = " + policyAry );
			PolicyService policyService = PolicyService.getInstance(
					ConfigManager.getViewPolicyUsername(), ConfigManager
							.getViewPolicyPassword());
			// 仅按照administrator查找organizational策略
			policyAry = policyService.listPolicy(null);
			policyService.close();
			lastGetTime = System.currentTimeMillis();
		}else{
			log.debug(" get policy from cache.");
		}
		return policyAry;
	}

	private AttachmentEntity saveAttachment(UploadForm formBean,
			UlPolicy ulPolicy, String subPath, String showName,
			String uploadUser, int order,ContentEntity content) throws Exception {
		int toPdf = formBean.getIsToPdf();
	

		AttachmentEntity ae = new AttachmentEntity();
		ae.setAttachmentPath(subPath);
		ae.setShowName(showName);

		ae.setContent(content);

		ae.setNeedGenerate(toPdf);
		ae.setNeedSecure((ulPolicy != null) ? 1 : 0);
		ae.setUploadUser(uploadUser);
		ae.setUlPolicy(ulPolicy);
		ae.setAttachmentOrder(order);
		ae.setUpdateTime(new Date());
		/**
		 * 如果是pdf文件，直接将状态设置为待加密
		 */


		if (ae.getNeedGenerate() == 1) {
			ae.setStatus(0);// 待转换
		} else {
			if (ae.getNeedSecure() == 1) {
				ae.setStatus(3); // 待加密
			} else {
				ae.setStatus(6); // 不处理
			}
		}

		attachmentService.addAttachment(ae);
		AttachmentEventListener.handleStatus(ae);
		notifyListener();

		return ae;
	}

	private void notifyListener() {
		ConverListerer2 converListerer = ConverListerer2.getInstance();
		synchronized (converListerer) {
			converListerer.notifyAll();
		}

		SecureListerer secureListener = SecureListerer.getInstance();
		synchronized (secureListener) {
			secureListener.notifyAll();
		}
	}

	private UlPolicy getULPolicy(UploadForm formBean, String policyId,
			String policyName, HttpServletRequest request) throws Exception {
		UlPolicy ulPolicy = null;

		String apolicy = formBean.getApolicy();
		if (apolicy != null && "newPolicy".equals(apolicy)) {

			String newReadRanger = request.getParameter("newReadRange");
			newReadRanger = URLDecoder.decode(newReadRanger, "UTF-8");
			String userNames = null;
			String groupNames = null;
			if ("userDefined".equals(formBean.getNewReadRange())) {
				groupNames = formBean.getNewGroupNames();
				userNames = formBean.getNewUserNames();
			} else {
				if ("all".equals(newReadRanger)) {
					groupNames = "全系统";
				} else if ("parentCompany".equals(newReadRanger)) {
					groupNames = "总公司各部门";
				} else if ("subsidiary".equals(newReadRanger)) {
					groupNames = "各分公司";
				}
			}
			String secure = formBean.getNewPolicySecure();
			String desc = formBean.getNewPolicydesc();
			if ("1".equals(secure)) {
				secure = "可读，可打印";
			} else {
				secure = "只读，不可打印";
			}

			
			ulPolicy = new UlPolicy(policyId, "自定义策略", desc, secure,
					groupNames, userNames);
		} else if (policyId != null && !"noPolicy".equals(policyId)) {
			ulPolicy = attachmentService.getUlPolicyById(policyId);
			if (ulPolicy == null) {
				ulPolicy = new UlPolicy(policyId, policyName, "", "  ", "", "");
			}
		}
		return ulPolicy;
	}

	/**
	 * // 判断是否需要添加策略
	 * 
	 * @param formBean
	 * @param request
	 * @return
	 * @throws PDRLException
	 * @throws SDKException
	 * @author linda.hou
	 * @throws UnsupportedEncodingException
	 * @date 2010-5-5 下午03:10:36
	 */
	private String getPolicyId(UploadForm formBean, String policyName,
			HttpServletRequest request) throws PDRLException, SDKException,
			UnsupportedEncodingException {
		String apolicy = formBean.getApolicy();

		if (apolicy != null && "newPolicy".equals(apolicy)) {
			PolicyService policyService = PolicyService.getInstance(
					ConfigManager.getCreatePolicyUsername(), ConfigManager
							.getCreatePolicePassword());

			String newReadRanger = request.getParameter("newReadRange");
			newReadRanger = URLDecoder.decode(newReadRanger, "UTF-8");
			String users = null;
			policyName = UUID.randomUUID().toString();
			if ("userDefined".equals(formBean.getNewReadRange())) {

				String groups = formBean.getNewGroupIds();

				users = formBean.getNewUserIds();
				users = addUser(users, ConfigManager
						.getCreatePolicyUsername());
				apolicy = policyService.registpolicy(policyName, formBean
						.getNewPolicydesc(), formBean.getNewPolicySecure(),
						groups, users);

			} else {
				List<CusEdcprincipalentitytype> groupList = null;

				users = formBean.getNewUserIds();
				//将创建策略的人加入此策略中
				users = addUser(users, ConfigManager
						.getCreatePolicyUsername());
				
				if ("all".equals(newReadRanger)) {
					apolicy = policyService.registpolicyForAllUsers(policyName, formBean
							.getNewPolicydesc(), formBean.getNewPolicySecure(), users);

				} else if ("parentCompany".equals(newReadRanger)) {
					groupList = groupService.listGroupByType("B");
					apolicy = policyService.registpolicy(policyName, formBean
							.getNewPolicydesc(), formBean.getNewPolicySecure(),
							groupList, users);
					
				} else if ("subsidiary".equals(newReadRanger)) {
					groupList = groupService.listGroupByType("C");
					apolicy = policyService.registpolicy(policyName, formBean
							.getNewPolicydesc(), formBean.getNewPolicySecure(),
							groupList, users);
					
				}

			}

			policyService.close();

		} else {
			return apolicy;
		}
		return apolicy;
	}

	private boolean check(FormFile file, HttpServletRequest request)
			throws FileNotFoundException, IOException {
		if (file == null || file.getFileName() == null
				|| "".equals(file.getFileName().trim())) {

			//request.setAttribute("message", "请重新选择文件");
			return false;
		}
		if (file.getFileData().length == 0) {
			request.setAttribute("message", file.getFileName() + " 是空文件");
			return false;
		}

		if (file.getFileData().length > ContentAction.uploadSize * 1024 * 1024) {
			request.setAttribute("message", file.getFileName() + " 大于5M");
			return false;
		}

		return true;

	}

	public ActionForward finish(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		int contentId = this.getIntValue(request, "contentId");
		ContentEntity c = cons.getContentById(contentId);
		String deptId = c.getOrganId();
		String pageId = request.getParameter("pageId");
		deptId = (deptId == null ? "0000" : deptId);
		
		if (AttachmentEventListener.getInstance().isAllAttachmentDone(c)) {
			c.setIsProcessing(0);
		} else {
			c.setIsProcessing(1);
		}
		cons.updateContent(c);
		ContentEventListener.onContentEdit(c);
		return new ActionForward(
				"/web/admin/content/contentAdmin.do?method=list&deptId="
				+ deptId + "&columnId=" + c.getColumnId()+"&pageId="+pageId, 
				true);
	}

	public ActionForward sortOrder(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		UploadForm formBean = (UploadForm) form;

		Policy[] policyAry = getPolicys();
		request.setAttribute("policyAry", policyAry);
		/**
		 * 获取附件列表
		 */
		String[] flags = (String[]) request.getParameterValues("flag");
		String[] ids = request.getParameterValues("idList");
		String[] orders = (String[]) request.getParameterValues("orderList");

		updateOrder(flags, ids, orders);

		List<AttachmentEntity> attachmentList = attachmentService
				.listAttachmentByContentId(formBean.getContentId());
		request.setAttribute("attachmentList", attachmentList);
		request.setAttribute("contentId", formBean.getContentId());
		return mapping.findForward("input");
	}

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String contentId = request.getParameter("contentId");
		List<AttachmentEntity> list = attachmentService
				.listAttachmentByContentId(Integer.valueOf(contentId));
      
        
		request.setAttribute("contentId", contentId);
		request.setAttribute("list", list);
		return mapping.findForward("list");
	}
	

	public ActionForward del(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String attachmentId = request.getParameter("attachmentId");
		AttachmentEntity ae = attachmentService.getAttachmentById(Integer.valueOf(attachmentId));
		ae.setIsDelete(1);
		attachmentService.updateAttachment(ae);
		
		ContentEntity c = cons.getContentById(ae.getContent().getContentId());
		List attList = attachmentService.listAttachmentByContentId(c.getContentId());
		c.setAttachmentSum(attList.size());
		cons.updateContent(c);
		ContentEventListener.onContentEdit(c);
		
		return new ActionForward("/web/admin/attachment/attachmentAdmin.do?method=list&contentId=" + ae.getContent().getContentId(), true);
	}
	

	public ActionForward download(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// path是指欲下载的文件的路径。

		String path = request.getParameter("path");
		path = URLDecoder.decode(path, "UTF-8");
		String showName = request.getParameter("showName");
		showName = URLDecoder.decode(showName, "UTF-8");
		File file = new File(ConfigManager.getUploadFile(), path);
		if (!file.exists()) {
			request.setAttribute("message", path + " 不存在");
			return mapping.findForward("list");
		}
		// 取得文件名。
		String filename = getDownloadFileName(path, showName);

		// 以流的形式下载文件。
		InputStream fis = new BufferedInputStream(new FileInputStream(file));
		byte[] buffer = new byte[fis.available()];
		fis.read(buffer);
		fis.close();
		try {
			// 清空response
			response.reset();
			// 设置response的Header
			response.addHeader("Content-Disposition", "attachment;filename="
					+ new String(filename.getBytes("gbk"), "ISO-8859-1"));
			response.addHeader("Content-Length", "" + file.length());
			OutputStream toClient = new BufferedOutputStream(response
					.getOutputStream());
			response.setContentType("application/octet-stream");
			toClient.write(buffer);
			toClient.flush();
		} catch (IOException e) {

		}
		return null;
	}

	public ActionForward getGroups(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<CusEdcprincipalentitytype> groupA = groupService
				.listGroupByType("A");
		List<CusEdcprincipalentitytype> groupB = groupService
				.listGroupByType("B");
		List<CusEdcprincipalentitytype> groupC = groupService
				.listGroupByType("C");

		request.setAttribute("groupA", groupA);
		request.setAttribute("groupC", groupC);
		request.setAttribute("groupB", groupB);
		// request.setAttribute("newGroups", newGroups);
		return mapping.findForward("group");
	}

	/**
	 * 要下载的文件名称由 showName的名称加上要下载地址的扩展名
	 * 
	 * @param path
	 * @param showName
	 * @return
	 */
	private String getDownloadFileName(String path, String showName) {
		String fileName = null;
		// 后缀名的起始位置
		int index = path.lastIndexOf(".");
		String suffer = path.substring(index);
		int index2 = showName.indexOf(".");
		String perfix = showName.substring(0, index2);
		fileName = perfix + suffer;
		return fileName;

	}

	/**
	 * 上传文件
	 * 
	 * @param fileBean
	 * @return 返回文件上传后的存储位置
	 * @throws Exception
	 */
	private String upload(FormFile file,ContentEntity content) throws Exception {

		InputStream is = file.getInputStream();

		File dir = ConfigManager.getUploadFile();

		String organId = content.getOrganId();
		String subPath = getDir(organId, file.getFileName());
		File destFile = new File(dir, subPath);

		File parentFile = destFile.getParentFile();
		if (!parentFile.exists()) {
			parentFile.mkdirs();
		}
		OutputStream os = new FileOutputStream(destFile);
		// 上传文件
		byte[] buf = new byte[10240];
		int len = 0;
		while ((len = is.read(buf)) != -1) {
			os.write(buf, 0, len);
		}
		os.close();
		is.close();
		file.destroy();
		return subPath;

	}

	private String getDir(String contentId, String fileName) {
		Calendar calendar = Calendar.getInstance();
		String year = String.valueOf(calendar.get(Calendar.YEAR));
		String month = String.valueOf(calendar.get(Calendar.MONDAY) + 1);
		String day = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
		StringBuilder sb = new StringBuilder("files");
		sb.append("/").append(contentId).append("/").append(year).append("/")
				.append(month).append("/").append(day);

		String extendName = fileName.substring(fileName.lastIndexOf("."));
		sb.append("/").append(String.valueOf(System.nanoTime())).append(
				extendName);

		return sb.toString();
	}

	public ActionForward findUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// UploadForm dynForm = (UploadForm) form;
		// String uidString = dynForm.getUidString();
		String uidString = request.getParameter("uidString");
		List<Edcprincipaluserentity> list = groupService.findUsers(uidString);
		request.setAttribute("userList", list);
		request.setAttribute("uidString", uidString);
		return mapping.findForward("userlist");
	}

	private String addUser(String users, String username) {
		String cannoName = getCanonNameByUidString(username);
		if (users == null || "".equals(users.trim())) {
			users = cannoName;
		} else {
			users += "%" + cannoName;
		}

		return users;
	}

	private String getCanonNameByUidString(String uidString) {
		Edcprincipaluserentity user = groupService.getUserById(uidString);
		String cannoName = user.getEdcprincipalentity().getCanonicalname();
		return cannoName;
	}


	
}

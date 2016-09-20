package com.ulic.ulweb.frame.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import com.ulic.ulweb.frame.constant.Constant;
import com.ulic.ulweb.frame.service.IService;
import com.ulic.ulweb.frame.service.ServiceLocator;

public abstract class BaseAction extends DispatchAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return super.execute(mapping, form, request, response);
	}

	protected Timestamp getTimestamp(HttpServletRequest req, String key)
			throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.setLenient(false); //heli add
		String temp = req.getParameter(key) + " 0:0:0";
		Timestamp t = null;
		if ((temp == null) || (temp.trim().length() == 0)) {
			return null;
		}
		try {
			Date d = sdf.parse(temp);
			t = new Timestamp(d.getTime());
		} catch (ParseException e) {
			// e.printStackTrace();
			throw new Exception(e);
		}
		return t;
	}

	protected Timestamp getTimestamp2(HttpServletRequest req, String key)
			throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false); //heli add
		String temp = req.getParameter(key);
		Timestamp t = null;
		if ((temp == null) || (temp.trim().length() == 0)) {
			return null;
		}
		try {
			Date d = sdf.parse(temp);
			t = new Timestamp(d.getTime());
		} catch (ParseException e) {
			// e.printStackTrace();
			throw new Exception(e);
		}
		return t;
	}
	protected String getStringValue(HttpServletRequest req, String key){
		return getStringValue(req,key,"");
	}
	protected String getStringValue(HttpServletRequest req, String key, String s) {
		String temp = req.getParameter(key);
		if ((temp == null) || (temp.trim().length() == 0)) {
			return s;
		}
		return temp.trim();
	}

	protected int getIntValue(HttpServletRequest req, String key, int i) {
		String str = req.getParameter(key);
		if ((str == null) || (str.trim().length() == 0)) {
			return i;
		}
		try {
			return Integer.parseInt(str.trim());
		} catch (NumberFormatException exc) {
			return i;
		}
	}

	protected boolean getBooleanValue(HttpServletRequest req, String key,
			boolean b) {
		String str = req.getParameter(key);
		if (str == null || str.trim().length() == 0) {
			return b;
		}
		return Boolean.parseBoolean(str.trim());
	}

	protected long getLongValue(HttpServletRequest req, String key, long i)
			throws NumberFormatException {
		String str = req.getParameter(key);
		if ((str == null) || (str.trim().length() == 0)) {
			return i;
		}
		try {
			return Long.parseLong(str.trim());
		} catch (NumberFormatException exc) {
			throw new NumberFormatException(key + "不是数值类型");
		}
	}

	protected String getUTFParameter(HttpServletRequest req, String key,
			String defStr) throws Exception {
		String str = req.getParameter(key);
		if ((str == null) || (str.trim().length() == 0)) {
			return defStr;
		}
		try {
			return new String(str.trim().getBytes("ISO-8859-1"), "utf-8");
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	protected String getGB2312Parameter(HttpServletRequest req, String key,
			String defStr) throws Exception {
		String str = req.getParameter(key);
		if ((str == null) || (str.trim().length() == 0)) {
			return defStr;
		}
		try {
			return new String(str.trim().getBytes("ISO-8859-1"), "gb2312");
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	protected String[] getValues(HttpServletRequest req, String key) {
		String[] strarr = req.getParameterValues(key);
		if (strarr == null) {
			return new String[0];
		}
		return strarr;
	}

	protected static String getOptionValue(String s1, String s2) {
		if (s1 != null && s2 != null) {
			if (s1.equals(s2)) {
				return "selected";
			}
		}
		return "";
	}

	protected static String getCheckedValue(String s1, String s2) {
		if (s1 != null && s2 != null) {
			if (s1.equals(s2)) {
				return "checked";
			}
		} 
		return "";
	}

	protected IService getService(String serviceName) {
		return ServiceLocator.getServiceProxy(serviceName);
	}

	protected void copyProperties(Object dest, Object src) throws Exception {
		try {
			BeanUtils.copyProperties(dest, src);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void outToWeb(HttpServletResponse response, String s) {
		PrintWriter pw = null;
		try {
			//清理缓存
			response.setHeader("Pragma","No-cache");
			response.setHeader("Cache-Control","no-cache");
			response.setDateHeader("Expires", 0);

			((ServletRequest) response).setCharacterEncoding("UTF-8");
			pw = response.getWriter();
			pw.write(s);
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			pw.close();
		}
	}

	protected void setSessionUser(HttpServletRequest req, Object bean) {
		req.getSession().setAttribute(Constant.LOGIN_USER, bean);
	}

	protected Object getSessionUser(HttpServletRequest req) {
		return req.getSession().getAttribute(Constant.LOGIN_USER);
	}

	protected int getPageNo(HttpServletRequest req, String key) {
		int pageNo = this.getIntValue(req, key, 1);
		if (pageNo < 1) {
			pageNo = 1;
		}
		return pageNo;
	}

	protected String UrlEncode(String Url) {
		try {
			return URLEncoder.encode(Url, "UTF-8");
		} catch (Exception e) {
			return "";
		}
	}

	protected String UrlDecoder(String Url) {
		try {
			return URLDecoder.decode(Url, "UTF-8");
		} catch (Exception e) {
			return "";
		}
	}

	public static Timestamp getTimestamp1(String key) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Timestamp t = null;
		if ((key == null) || (key.trim().length() == 0)) {
			return null;
		}
		try {
			Date d = sdf.parse(key);
			t = new Timestamp(d.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return t;
	}

	public static void main(String[] args) {
		String ss = "1998-2-6";
		try {
			Timestamp t = BaseAction.getTimestamp1(ss);
			Calendar c = Calendar.getInstance();
			c.setTimeInMillis(t.getTime());
			System.out.println(c.get(Calendar.YEAR));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void deleteFile(String path) {
		File file = new File(Constant.getFileRealPath(path));
		if (file.exists()) {
			file.delete();
		}
	}
}
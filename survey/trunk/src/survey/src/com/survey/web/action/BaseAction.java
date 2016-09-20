package com.survey.web.action;


import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.actions.DispatchAction;

import com.survey.service.ILibraryService;
import com.survey.util.ServiceLocator;
import com.survey.vo.User;
import com.survey.vo.UserContextVO;


public class BaseAction extends DispatchAction{
	
	protected ILibraryService ls = (ILibraryService) ServiceLocator.getService("libraryService");
	
	public int getIntValue(HttpServletRequest req,String str){
		try{
			return Integer.parseInt(req.getParameter(str));
		}catch(Exception e){
			return 0;
		}
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
//����û��Ƿ���Ȩ�ޣ�����session��Ȩ�޵�ƴ�����ֽ��м�⡣��Ȩ�޷���true,��Ȩ�޷���false	

	public boolean checkPasswordRule(String password){
		char pw[] = password.toCharArray();
		boolean shuzi = false;
		boolean daxie = false;
		boolean xiaoxie = false;
		boolean bawei = false;
		
		for(char p : pw){
			if(((byte) p) >= 48 && ((byte) p) <= 57){shuzi = true;break;}			
		}
		for(char p : pw){
			if(((byte) p) >= 65 && ((byte) p) <= 90){daxie = true;break;}			
		}
		for(char p : pw){
			if(((byte) p) >= 97 && ((byte) p) <= 122){xiaoxie = true;break;}			
		}
		if(pw.length > 7)bawei = true;
		
		if(!shuzi)log.info("========û����");
		if(daxie)log.info("========�д�д");
		if(xiaoxie)log.info("========��Сд");		
		if(!bawei)log.info("========����8λ");
		
		return (shuzi && (daxie || xiaoxie) && bawei);
		
	}
	
	public boolean checkSession(HttpServletRequest request){
		try{
			
			UserContextVO uc = (UserContextVO)request.getSession().getAttribute("userContextVO");
			if (uc.getUserId() > 0) {
				return true;
			} else {
				return false;
			}
		}catch(Exception e){
			return false;
		}
	}
	
	/**
	 * �õ���ǰsession�е��û�id��
	 * @return
	 */
	public int getCurrentUserId(HttpServletRequest request){
		try {
			int userId =  ((User)request.getSession().getAttribute("user")).getId();
			//log.info(userId);
			return userId;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}
	
	/**
	 * �õ���ǰsession�е�UserContextVO
	 * ���Ϊ�գ��򷵻�null,����ע����null
	 * @return
	 */
	public UserContextVO getUserContext(HttpServletRequest request){
		try {
			return ((UserContextVO)request.getSession().getAttribute("userContextVO"));
						
		} catch (Exception e) {
			// TODO: handle exception
			return new UserContextVO();
		}
	}
	
	
	
	/**
	 * �õ���ǰsession�еĲ���id��
	 * @return
	 */
	public int getCurrentDeptId(HttpServletRequest request){
		try {
			int userId =  ((UserContextVO)request.getSession().getAttribute("userContextVO")).getToaDeptId();
			//log.info(userId);
			return userId;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}
	
	/**
	 * �õ���ǰsession �е��û���Ӣ��
	 * ���ò������򷵻�""
	 * @return
	 */
	public String getCurrentUserName(HttpServletRequest request){
		try {
			String userName = ((UserContextVO)request.getSession().getAttribute("userContextVO")).getUserName();
			//log.info(userName);
			return userName;
		} catch (Exception e) {
			// TODO: handle exception
			return "";
		}
	}
	
	/**
	 * �õ���ǰsesson �еĲ������
	 * ���ò������򷵻�""
	 * @return
	 */
	public String getCurrentDeptName(HttpServletRequest request){
		try {
			String realName =  ((UserContextVO)request.getSession().getAttribute("userContextVO")).getDeptName();
			//log.info(realName);
			return realName;
		} catch (Exception e) {
			// TODO: handle exception
			return "";
		}
	}
	
	/**
	 * �õ���ǰsesson �е��û���ʵ��ƣ�������
	 * ���ò������򷵻�""
	 * @return
	 */
	public String getCurrentUserRealName(HttpServletRequest request){
		try {
			String realName =  ((UserContextVO)request.getSession().getAttribute("userContextVO")).getRealName();
			//log.info(realName);
			return realName;
		} catch (Exception e) {
			// TODO: handle exception
			return "";
		}
	}
	
	
	
	/**
	 * ��õ�ǰʱ�䣬������ݿ�ʱ��Ϳ���̨ʱ�䲻ͬ�� ����ʹ���˲�ͬ��ʱ����ʾ
	 * @return
	 */
	public Date getCurrentDate(){
		Date date = new Date(System.currentTimeMillis());
		Date datePrint = new Date(System.currentTimeMillis() + 8*60*60*1000);
		System.out.println(datePrint.toGMTString());
		return date;
	}

	
	
}

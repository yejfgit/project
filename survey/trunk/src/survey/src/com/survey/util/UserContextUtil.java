package com.survey.util;

import org.hibernate.Session;

import com.survey.vo.UserContextVO;

/**
 * 
 * �û������Ķ���
 * @author yijt
 *
 */
public class UserContextUtil {
	/**
	 * 
	 */
	public static final String USER_CONTEXT_NAME = "userContext";
	/**
	 * 
	 */
	private static ThreadLocal instance = new ThreadLocal();

	/**
	 * ��ʼ���û�������
	 * @param userContext �û�������
	 * @return �ɹ�����0��ʧ�ܷ���-1
	 */
	public static int initUserContext(UserContextVO userContext) {
		if (userContext == null) {
			return -1;
		}
		instance.set(userContext);
		return 0;
	}
    /**
     * 
     * �ͷ��û�������
     * @return �ɹ�����0��ʧ�ܷ���-1
     */
	public static int destoryUserContext() {
		instance.set(new Object());
	
		return 0;
	}

	/**
	 * 
	 * �õ���ǰ�û�������
	 * @return ���ص�ǰ�û�������
	 */
		
	public static UserContextVO getUserContext() {
		UserContextVO userCtx = null;
		Object obj = instance.get();
		if (obj instanceof UserContextVO) {
			userCtx = (UserContextVO) obj;
		}
		if (userCtx == null) {
			userCtx = new UserContextVO();
/*		zi jin de 
*/
			userCtx.setUserId(1);
			userCtx.setModuleId(-1);
			userCtx.setRespId(-1);		
			userCtx.setUserName("deng lu qian");
		}
		return userCtx;
	}

}

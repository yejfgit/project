package com.survey.util;

import com.survey.util.UserContextUtil;
import com.survey.vo.UserContextVO;


/**
 * 用户上下文工具（用ThreadLocal保存用户会话信息）
 * @author wengxf
 *
 */
public class ContextUtil {

	/**
	 * 得到当前上下文数据
	 * @return
	 */
	private static UserContextVO getCurrentContext() {
		return ((UserContextVO)UserContextUtil.getUserContext());
	}
	
	/**
	 * 得到当前用户
	 * @return
	 */
//	public static TOaUser getCurrentUser(){
//		return ((UserContextVO)UserContextUtil.getUserContext()).getUser();
//	}
	
	/**
	 * 得到当前户的部门ID
	 * @return
	 */
	public static int getCurrentUserDeptId() {
		return ((UserContextVO)UserContextUtil.getUserContext()).getToaDeptId();
	}
	
	/**
	 * 得到当前用户的部门全名
	 * @return
	 */
	public static String getCurrentUserDeptFullName() {
		return ((UserContextVO)UserContextUtil.getUserContext()).getDeptFullName();
	}
	
	/**
	 * 得到当前用户ID
	 * @return
	 */
	public static int getCurrentUserId() {
//		return ((UserContextVO)UserContextUtil.getUserContext()).getUser().getId();
		return UserContextUtil.getUserContext().getUser().getId();
	}
	/**
	 * 得到当前用户部门ID
	 * @return
	 */
	public static int getCurrentDeptId() {
		return UserContextUtil.getUserContext().getUser().getDeptId();
	}
	
	/**
	 * 检测当前用户权限
	 * @param request
	 * @param rightName
	 * @return
	 */
//	public static boolean checkRight(String rightName) {
//
//		try {
//			UserContextVO uc = getCurrentContext();
//			return uc.checkRight(rightName);
//
//		} catch (Exception e) {
//			return false;
//	}

//	}
	
}

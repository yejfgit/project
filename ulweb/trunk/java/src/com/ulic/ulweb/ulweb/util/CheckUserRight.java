package com.ulic.ulweb.ulweb.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class CheckUserRight {

/*	
	public static String getStrRoleid(List roleList) {
		
		String strRoleid = "0";
		RoleDetail role = new RoleDetail();
		if(roleList.size() != 0){
			for(int i = 0; i < roleList.size(); i++) {
				role = (RoleDetail)roleList.get(i);
				if(i == 0){
					strRoleid = "" + role.getRoleId();
				}else{
					strRoleid += ", " + role.getRoleId();
				}
			}
		}
		return strRoleid;
	}
*/
	public static int checkUser(HttpServletRequest req){
		HttpSession session = req.getSession();
		try{
			if(session.getAttribute("aClass") == null ){
				return -1;
			}else if((Integer)session.getAttribute("aClass") == 9 ){
				return 9;
			}else if((Integer)session.getAttribute("aClass") == 2 ){
				return 2;
			}else if((Integer)session.getAttribute("aClass") == 1 ){
				return 1;
			}else if((Integer)session.getAttribute("aClass") == 0 ){
				return 0;
			}else if(session.getAttribute("name") == null || session.getAttribute("name") == "未登录"){
				return -1;
			}else{
				return 0;
			}
		}catch(Exception e){
			return -1;
		}
	}
	
}

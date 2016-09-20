package com.ulic.ulweb.ulweb.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserClassRight {

	public static int getUserClass(HttpServletRequest request){
		HttpSession session = request.getSession();
		if(session.getAttribute("rClass") == null){
			return 0;
		}else{
			return (Integer)session.getAttribute("rClass");
		}		
	}
	
	public static String getUserDept(HttpServletRequest request){
		HttpSession session = request.getSession();
		if(session.getAttribute("dept") == null){
			return "";
		}else{
			return ((Integer)session.getAttribute("dept")).toString();
		}
	}
	
}

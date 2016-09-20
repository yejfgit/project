package com.ulic.ulweb.ulweb2.web.filter;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.ulic.ulweb.frame.service.ServiceLocator;
import com.ulic.ulweb.ulweb2.dao.IContentDao;
import com.ulic.ulweb.ulweb2.dao.IMonitorDao;
import com.ulic.ulweb.ulweb2.entity.MonitorEntity;



public class MonitorFilter implements Filter {


	private static int no1 = 8;
	private static int no2 = 3146;	
	public void destroy() {
		// TODO Auto-generated method stub
		Date endTime = new Date();
		System.out.println(endTime);
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		IContentDao cons = (IContentDao) ServiceLocator.getService("contentAdminDao");
		IMonitorDao mt = (IMonitorDao) ServiceLocator.getService("monitorDao");
		HttpServletRequest hsrq = (HttpServletRequest) request; 
		String url = hsrq.getRequestURI();
		String ip = hsrq.getRemoteAddr();
		
		StringBuffer sb = new StringBuffer();
		
		url = url.replace(hsrq.getContextPath(), "");
		sb.append(url);
		String qs = hsrq.getQueryString();
		if (qs!=null){
			sb.append("?" + qs);
			
			int cid = Integer.parseInt(qs.substring(qs.lastIndexOf("=")+1));	
			int columnId = cons.getById(cid).getColumnId();
			if(columnId==no1||columnId==no2){
				MonitorEntity m = new MonitorEntity();
				m.setAccessTime(new Date());
				m.setIp(ip);
				m.setUrl(sb.toString());
				
				mt.save(m);
			}
			System.out.println(cid);
		}
		request.getRequestDispatcher("asda").forward(request, response);
		chain.doFilter(request, response);
		
	}
	


	public void init(FilterConfig arg0) throws ServletException {
		Date startTime = new Date();
		System.out.println(startTime);
		
	}



}

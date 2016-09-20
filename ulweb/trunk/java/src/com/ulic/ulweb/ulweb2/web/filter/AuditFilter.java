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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ulic.ulweb.frame.service.ServiceLocator;
import com.ulic.ulweb.ulweb2.dao.IAuditDao;
import com.ulic.ulweb.ulweb2.entity.AuditEntity;


/**
 * 审计
 * @author unionlife
 *
 */
public class AuditFilter implements Filter {

	Log log = LogFactory.getLog(AuditFilter.class);

	public void init(FilterConfig fc) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest hsrq = (HttpServletRequest) request;
		StringBuffer sb = new StringBuffer();
		String url = hsrq.getRequestURI();
		if (url.indexOf("/forF5.jsp") != -1) {
			chain.doFilter(request, response);
		} else {
			url = url.replace(hsrq.getContextPath(), "");
			sb.append(url);
			String qs = hsrq.getQueryString();
			if (qs != null) {
				sb.append("?" + qs);
			}
			if (sb.indexOf("check") != -1) {
				sb.append("; " + listMap(hsrq.getParameterMap()));
			}
			if(!"/index.do".equals(sb.toString())){
//				log.info(hsrq.getRemoteAddr() + "; " + new Date() + "; " + sb.toString());
				AuditEntity a = new AuditEntity(hsrq.getRemoteAddr(), new Date(), sb.toString());
				IAuditDao ad = (IAuditDao) ServiceLocator.getService("auditDao");
				ad.save(a);
			}

		}
		chain.doFilter(request, response);
	}

	private String listMap(Map map) {
		StringBuffer sb = new StringBuffer();
		Set s = map.keySet();
		Iterator iter = s.iterator();
		if (s.size() > 0) {
			sb.append("?");
		}
		int i = 0;
		while (iter.hasNext()) {
			String k = (String) iter.next();
			String[] v = (String[]) map.get(k);
			if (i > 0) {
				sb.append("&");
			}
			sb.append("" + k + "=" + v[0]);
			i++;
		}
		return sb.toString();
	}
	
	public void destroy() {

	}
}

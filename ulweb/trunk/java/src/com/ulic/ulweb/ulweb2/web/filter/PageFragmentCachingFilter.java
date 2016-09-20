package com.ulic.ulweb.ulweb2.web.filter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.FilterChain;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.constructs.blocking.BlockingCache;
import net.sf.ehcache.constructs.web.AlreadyGzippedException;
import net.sf.ehcache.constructs.web.GenericResponseWrapper;
import net.sf.ehcache.constructs.web.PageInfo;
import net.sf.ehcache.constructs.web.filter.CachingFilter;

public abstract class PageFragmentCachingFilter extends CachingFilter
{
  protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
    throws Exception
  {
    PageInfo pageInfo = buildPageInfo(request, response, chain);

    writeResponse(response, pageInfo);
  }

  protected PageInfo buildPage(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
    throws AlreadyGzippedException, Exception
  {
    ByteArrayOutputStream outstr = new ByteArrayOutputStream();
    GenericResponseWrapper wrapper = new GenericResponseWrapper(response, outstr);
    chain.doFilter(request, wrapper);
    wrapper.flush();

    long timeToLiveSeconds = this.blockingCache.getCacheConfiguration().getTimeToLiveSeconds();
    
	HttpServletRequest hsrq = (HttpServletRequest) request;
	StringBuffer sb = new StringBuffer();
	String url = hsrq.getRequestURI();
	
	url = url.replace(hsrq.getContextPath(), "");
	sb.append(url);
	String qs = hsrq.getQueryString();
	if (qs != null) {
		sb.append("?" + qs);
	}
	if (sb.indexOf("check") != -1) {
		sb.append("; " + listMap(hsrq.getParameterMap()));
	}
//	System.out.println( wrapper.getContentType());

	if(!"application/octet-stream".equals(wrapper.getContentType())){
    	return new PageInfo(wrapper.getStatus(), wrapper.getContentType(), wrapper.getCookies(), outstr.toByteArray(), false, timeToLiveSeconds, wrapper.getAllHeaders());
    }else{
		request.getRequestDispatcher(url).forward(request,
				response);
    }
   
    return new PageInfo(0, wrapper.getContentType(), wrapper.getCookies(), outstr.toByteArray(), false, timeToLiveSeconds, wrapper.getAllHeaders());
//	return new PageInfo(wrapper.getStatus(), wrapper.getContentType(), wrapper.getCookies(), outstr.toByteArray(), false, timeToLiveSeconds, wrapper.getAllHeaders());
  }

  protected void writeResponse(HttpServletResponse response, PageInfo pageInfo)
    throws IOException
  {
    byte[] cachedPage = pageInfo.getUngzippedBody();

    String page = new String(cachedPage, response.getCharacterEncoding());

    String implementationVendor = response.getClass().getPackage().getImplementationVendor();
    if(!"application/octet-stream".equals(pageInfo.getContentType())){
        if ((implementationVendor != null) && (implementationVendor.equals("\"Evermind\"")))
            response.getOutputStream().print(page);
          else
            response.getWriter().write(page);
    }

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
}
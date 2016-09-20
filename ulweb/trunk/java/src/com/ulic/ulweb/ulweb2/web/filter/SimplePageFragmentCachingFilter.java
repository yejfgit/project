package com.ulic.ulweb.ulweb2.web.filter;

import javax.servlet.http.HttpServletRequest;
import net.sf.ehcache.CacheManager;

public class SimplePageFragmentCachingFilter extends PageFragmentCachingFilter
{
  public static final String NAME = "SimplePageFragmentCachingFilter";

  protected String calculateKey(HttpServletRequest httpRequest)
  {
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(httpRequest.getRequestURI()).append(httpRequest.getQueryString());
    String key = stringBuffer.toString();
    return key;
  }

  protected CacheManager getCacheManager()
  {
    return CacheManager.getInstance();
  }

  protected String getCacheName()
  {
    String cacheName = super.getCacheName();
    if (cacheName == null) {
      return "SimplePageFragmentCachingFilter";
    }
    return cacheName;
  }
}
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DomainAction.java

package com.ulic.ulweb.ulweb.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ulic.ulweb.frame.action.BaseAction;
import com.ulic.ulweb.ulweb.dao.AdminDAO;
import com.ulic.ulweb.ulweb.dao.DomainDAO;
import com.ulic.ulweb.ulweb.dao.DomainTest;

public class DomainAction extends BaseAction
{
    public DomainDAO domainDAO;
    public DomainTest domainTest;

    public DomainAction()
    {
        domainDAO = new DomainDAO();
        domainTest = new DomainTest();
    }

    public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        //IDomainService ds = (IDomainService)getService("domainService");
        String baseDn = getStringValue(request, "baseDn", "ou=ULIC,dc=ulic,dc=com,dc=cn");
        String searbase = getStringValue(request, "searbase", "dc=ulic,dc=com,dc=cn");
        String filter = getStringValue(request, "filter", "(&(objectclass=user))");
        String attrs = getStringValue(request, "attrs");
        request.setAttribute("message", (new StringBuilder(String.valueOf(domainDAO.test(baseDn, searbase, filter, attrs)))).append(request.getRemoteUser()).toString());
        ActionForward af = new ActionForward();
        af.setName("ok");
        af.setPath("/admin/domain/result.jsp");
        return af;
    }

    public ActionForward test(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        ActionForward af = new ActionForward();
        af.setName("ok");
        af.setPath("/admin/domain/result.jsp");
        return af;
    }

    public ActionForward check(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        //IDomainService ds = (IDomainService)getService("domainService");
        String username = getStringValue(request, "username", "!@#$%^&*()");
        String password = getStringValue(request, "password", "!@#$%^&*()");
        String result = domainTest.check(username, password);
        ActionForward af = new ActionForward();
        request.setAttribute("message", result);
        af.setName("ok");
        af.setPath("/admin/domain/result.jsp");
        return af;
    }

    public ActionForward modify(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        //IDomainService ds = (IDomainService)getService("domainService");
        String filter = getStringValue(request, "filter", "");
        if(!filter.equals(""))
            request.setAttribute("message", domainTest.modify(filter));
        ActionForward af = new ActionForward();
        af.setName("ok");
        af.setPath("/admin/domain/result.jsp");
        return af;
    }

    public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        //IDomainService ds = (IDomainService)getService("domainService");
        request.setAttribute("message", domainTest.delete());
        ActionForward af = new ActionForward();
        af.setName("ok");
        af.setPath("/admin/domain/result.jsp");
        return af;
    }

    public ActionForward ssl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        //IDomainService ds = (IDomainService)getService("domainService");
        request.setAttribute("message", domainTest.ssl());
        ActionForward af = new ActionForward();
        af.setName("ok");
        af.setPath("/admin/domain/result.jsp");
        return af;
    }

    public ActionForward un(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
    	String host = "http://localhost:8080/";
    	//System.out.println(request.getRemoteHost());
        String get = request.getHeader("referer");
        String userdomain = getStringValue(request, "userdomain");
        String username = getStringValue(request, "username");
        ActionForward af = new ActionForward();
        if(get != null && get.indexOf(host, 0) != -1 && userdomain.equals("ULIC"))
            request.setAttribute("message", (new StringBuilder(String.valueOf(get))).append("您好，登录成功！转向...").append(userdomain).append("\\").append(username).toString());
        else
            request.setAttribute("message", (new StringBuilder(String.valueOf(get))).append("对不起， 您不在ULIC域上，无法登录").toString());
        af.setName("ok");
        af.setPath("/admin/domain/result.jsp");
        return af;
    }

    public ActionForward modifynew(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        //IDomainService ds = (IDomainService)getService("domainService");
        request.setAttribute("message", domainTest.modifynew());
        ActionForward af = new ActionForward();
        af.setName("ok");
        af.setPath("/admin/domain/result.jsp");
        return af;
    }

    //临时调整域
    public ActionForward edit(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        //IDomainService ds = (IDomainService)getService("domainService");
        StringBuffer sb = new StringBuffer();
    	
    	//-------- AD Begin -----------------
    	
    	//DirContext ctx;
        //Hashtable env;
		
		//------- Domain start ------
		
//        
//        env = new Hashtable();
//        env.put(Context.INITIAL_CONTEXT_FACTORY,	"com.sun.jndi.ldap.LdapCtxFactory");
//        //以下是正式环境，domain admin：edituser/edituser
//        env.put(Context.PROVIDER_URL,				"ldap://10.18.8.1:389");
//        env.put(Context.SECURITY_AUTHENTICATION,	"simple");
//        env.put(Context.SECURITY_PRINCIPAL,			"edituser@ulic.com.cn");
//        env.put(Context.SECURITY_CREDENTIALS,		"edituser");
//        String searchbase = "dc=ulic, dc=com, dc=cn";
//
//        //以下是筛选条件   可以选择改名的用户列表具备的条件
//        //String filter = "(mail=wengxf*)";
//
//        ctx = new InitialDirContext(env);
//        
//        SearchControls constraints = new SearchControls();   
//        constraints.setSearchScope(SearchControls.SUBTREE_SCOPE);
//        
//        //String filter = "(department=*中心支公司*)";   
//        String filter = "";
//    	
//        NamingEnumeration results = ctx.search(searchbase,filter,constraints);
//        int count = 0;
//        while(results != null && results.hasMoreElements()) {
//        	count++;
//	        SearchResult sr = (SearchResult)results.next();
//	        String dn = sr.getName() + "," + searchbase;
//	        sb.append("&lt;" + count + "&gt;" + dn + "<br>");
//
//	        //以下从域获得查询到的用户的displayname，cn，company，department......属性的值
//	        
//			String department = null;
//			String department2 = null;
//
//			if(ctx.getAttributes(dn).get("department") != null) {
//				department = ctx.getAttributes(dn).get("department").getAll().nextElement().toString();
//	        }else {
//	        	department = "";
//	        }
//
//	        
//	        department2 = department.replace("中支", "中心支公司");
//        
//	        try{
//		        ModificationItem[] mods = new ModificationItem[1];
//		        mods[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE,
//		        		new BasicAttribute("department",department2));
//
//		        ctx.modifyAttributes(dn, mods);
//		        
//	        }catch(NamingException e){
//	        	sb.append("edit failed<br />"+e);
//	        }
//
//        }
//
//        ctx.close();
//        

    	//-------- AD End -------------------
        
        sb.append("empty");
    	request.setAttribute("message", sb.toString());
    	
        ActionForward af = new ActionForward();
        af.setName("ok");
        af.setPath("/admin/domain/result.jsp");
        return af;
    }
    
    public ActionForward ADlogin(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
    {
		String host = "http://localhost:8080/";
		String msg = "";
	    String referer = request.getHeader("referer");
	    String userdomain = getStringValue(request, "userdomain");
	    String computername = getStringValue(request, "computername");
	    String username = getStringValue(request, "username");
	    
	    //System.out.println(computername.indexOf("ulic", 0));
	    
	    if (referer == null || referer.indexOf(host) == -1) {
	    	msg = "对不起，这个登录页面不合法";
	    } else if (!userdomain.equals("ULIC") || computername.indexOf("ULIC", 0) == -1) {
	    	msg = "对不起，您还没有加入ULIC域";
	    } else {
	    	AdminDAO ad = new AdminDAO();
	    	String realname = ad.findAdUserRealName(username);
	    	if (realname == null) {
	    		msg = "对不起，您在ULIC域中还没有合法信息";
	    	} else {
	    		msg = realname + ", 您好！ 欢迎进入系统...";
	    	}

	    }
	    request.setAttribute("message", msg);
	    
	    ActionForward af = new ActionForward();
	    af.setName("ok");
	    af.setPath("/admin/domain/result.jsp");
	    return af;
    }
    
}

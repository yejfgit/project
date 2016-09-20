package com.ulic.ulweb.ulweb.dao;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.ModificationItem;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.Control;
import javax.naming.ldap.InitialLdapContext;

import com.ulic.ulweb.frame.dao.BaseDao;



class FastBindConnectionControl implements Control {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public byte[] getEncodedValue() {
        return null;
    }

    public String getID() {
        return "1.2.840.113556.1.4.1781";
    }

    public boolean isCritical() {
        return true;
    }
}


public class DomainTest extends BaseDao {
	
	private DirContext ctx;
    private Hashtable<String, String> env;
    public Control[] connCtls = null;

    //public String searchbase = "dc=ulic,dc=com,dc=cn";
    public String searchbase = "ou=ulic,dc=def,dc=com";
    public String filter = "(cn=*)";
    //public static String MY_ATTRS[] = {"cn","mail","company","department"};
    public static String MY_ATTRS[] = {"cn","mail"};
    
	public String check(String username,String password) throws Exception {	//approved!
		StringBuffer sb= new StringBuffer();
		
		//------- Domain start ------
		
        env = new Hashtable<String, String>();
        env.put(Context.INITIAL_CONTEXT_FACTORY,	"com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL,				"ldap://10.18.8.1:389");
        //env.put(Context.PROVIDER_URL,				"ldap://10.11.6.131:389");
        env.put(Context.SECURITY_AUTHENTICATION,	"simple");
        env.put(Context.SECURITY_PRINCIPAL,			username + "@ulic.com.cn");
        env.put(Context.SECURITY_CREDENTIALS,		password);
        
        
        try {
        	ctx = new InitialDirContext(env);
        	sb.append("adcheckpass");
        } catch (NamingException e) {
        	//sb.append(e);
        	sb.append("adcheckfail");
        }
        
        
//        SearchControls constraints = new SearchControls();
//        constraints.setSearchScope(SearchControls.SUBTREE_SCOPE);
//        constraints.setReturningAttributes(MY_ATTRS);
//        NamingEnumeration results = ctx.search(searchbase,filter,constraints);
//
//        int totalResults = 0;
//        while(results.hasMoreElements()){
//        	SearchResult sr = (SearchResult)results.next();
//        	sb.append(totalResults + "Name:" + sr.getName() + "<br>");
//        	
//        	Attributes attrs = sr.getAttributes();
//
//            try {
//	            for(NamingEnumeration ae = attrs.getAll(); ae.hasMore(); ) {
//	            	Attribute attr = (Attribute) ae.next();
//	            	sb.append("Attribute-" + attr.getID() + ": ");
//	            	for(NamingEnumeration e = attr.getAll(); e.hasMore(); ) {
//	            		sb.append(e.next() + "<br>");
//	            	}
//	            }
//            }catch(NamingException e) {
//            	System.err.println("Problem listing membership: " + e);
//            }
//            totalResults++;
//            sb.append("<br>");
//        }
//        ctx.close();
        
		//------- Domain end   ------
		
		return sb.toString();
	}

	public String modify(String filter) throws Exception {	//approved!
		StringBuffer sb= new StringBuffer();
		String displayname = null;
		String cn = null;
		String company = null;
		String department = null;
		String displayname2 = null;
		String ch = null;
		String dn = null;
		
		//------- Domain start ------
		
        env = new Hashtable<String, String>();
        env.put(Context.INITIAL_CONTEXT_FACTORY,	"com.sun.jndi.ldap.LdapCtxFactory");
        //env.put(Context.PROVIDER_URL,				"ldap://10.11.6.131:389");
        //以下是正式环境，domain admin：edituser/edituser
        env.put(Context.PROVIDER_URL,				"ldap://10.18.8.1:389");
        env.put(Context.SECURITY_AUTHENTICATION,	"simple");
        env.put(Context.SECURITY_PRINCIPAL,			"edituser@ulic.com.cn");
        env.put(Context.SECURITY_CREDENTIALS,		"edituser");
        String searchbase = "dc=ulic, dc=com, dc=cn";

        //以下是筛选条件   可以选择改名的用户列表具备的条件
        //String filter = "(company=河北*)";

        ctx = new InitialDirContext(env);
        
        SearchControls constraints = new SearchControls();   
        constraints.setSearchScope(SearchControls.SUBTREE_SCOPE);
        NamingEnumeration<SearchResult> results = ctx.search(searchbase,filter,constraints);
        
        while(results != null && results.hasMoreElements()) {
	        SearchResult sr = (SearchResult)results.next();
	        dn = sr.getName() + "," + searchbase;
	        sb.append(dn + "<br>");

	        //以下从域获得查询到的用户的displayname，cn，company，department属性的值
	        displayname = ctx.getAttributes(dn).get("displayname").getAll().nextElement().toString();
	        cn = ctx.getAttributes(dn).get("cn").getAll().nextElement().toString();
	        
	        //去除cn中的空格，去除cn名的括号后部分
	        if(cn != null) {

		        cn = cn.trim();
		        if(cn.indexOf("(") != -1) {
		        	ch = cn.substring(cn.indexOf("("));
		        	//sb.append(ch);
		        	cn = cn.replace(ch, "");
		        }else if(cn.indexOf("（") != -1){
		        	ch = cn.substring(cn.indexOf("（"));
		        	//sb.append(ch);
		        	cn = cn.replace(ch, "");
		        }
	        }else{
	        	cn = "";
	        }
	       
	        //把company和department改成缩写
	        
	        company = ctx.getAttributes(dn).get("company").getAll().nextElement().toString();
	        if(company != null) {
	        	company = company.replace("分公司", "");
	        }else{
	        	company = "";
	        }
	        if(ctx.getAttributes(dn).get("department") != null) {
	        	department = ctx.getAttributes(dn).get("department").getAll().nextElement().toString();
	        }else {
	        	department = "";
	        }
	        department = department.replace("中心支公司", "");
	        department = department.replace("中支", "");

	        
	        //以下合成修改后的displayname形式
	        displayname2 = cn + "(" + company + "" + department + ")";
	        sb.append(" " + displayname + " 已被改成了 " + displayname2 + "<br><br>");
	        
	        //sb.append("company: " + company + "<br>department: " + department + "<br>");
	 
	        try{
		        ModificationItem[] mods = new ModificationItem[1];
		        mods[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE,
		        		new BasicAttribute("displayname",displayname2));

		        ctx.modifyAttributes(dn, mods);
		        
	        }catch(NamingException e){
	        	sb.append("modify failed<br />"+e);
	        }

        }

        ctx.close();
		//------- Domain end   ------

		return sb.toString();
	}
	
	
	//临时安排的域调整函数
	public String edit() throws Exception {	//approved!
		StringBuffer sb= new StringBuffer("");
	//	String filterarray[] = {"北京","湖北"};
		
		
		//------- Domain start ------
		
        env = new Hashtable<String, String>();
        env.put(Context.INITIAL_CONTEXT_FACTORY,	"com.sun.jndi.ldap.LdapCtxFactory");
        //env.put(Context.PROVIDER_URL,				"ldap://10.11.6.131:389");
        //以下是正式环境，domain admin：edituser/edituser
        env.put(Context.PROVIDER_URL,				"ldap://10.18.8.1:389");
        env.put(Context.SECURITY_AUTHENTICATION,	"simple");
        env.put(Context.SECURITY_PRINCIPAL,			"edituser@ulic.com.cn");
        env.put(Context.SECURITY_CREDENTIALS,		"edituser");
        String searchbase = "dc=ulic, dc=com, dc=cn";

        //以下是筛选条件   可以选择改名的用户列表具备的条件
        //String filter = "(mail=wengxf*)";

        ctx = new InitialDirContext(env);
        
        SearchControls constraints = new SearchControls();   
        constraints.setSearchScope(SearchControls.SUBTREE_SCOPE);
        
    //    int i = 0;
    //下面是最外层while    
    //while( i < filterarray.length ) {    
    	
        //String filter = "(company=" + filterarray + "分公司)";
    	//String filter = "(givenname=*\\(*)";
        String filter = "(department=*中心支公司*部)";
        //String filter = "(mail=zhangjf*)";
        
    	
        NamingEnumeration<SearchResult> results = ctx.search(searchbase,filter,constraints);
        int count = 0;
        while(results!=null && results.hasMoreElements()) {
        	count++;
	        SearchResult sr = (SearchResult)results.next();
	        String dn = sr.getName() + "," + searchbase;
	        sb.append("&lt;" + count + "&gt;" + dn + "<br>");

	        //以下从域获得查询到的用户的displayname，cn，company，department......属性的值
	        
			String department = null;
			String displayname = null;
			String department2 = null;
			String displayname2 = null;
			//String ch = null;
	        //String department = ctx.getAttributes(dn).get("department").getAll().nextElement().toString();

			if(ctx.getAttributes(dn).get("department") != null) {
				department = ctx.getAttributes(dn).get("department").getAll().nextElement().toString();
	        }else {
	        	department = "";
	        }
			
	        if(ctx.getAttributes(dn).get("displayname") != null) {
	        	displayname = ctx.getAttributes(dn).get("displayname").getAll().nextElement().toString();
	        }else {
	        	displayname = "";
	        }

	        String del = department.substring(5 + department.lastIndexOf("中心支公司"));
	        sb.append(del + " ");
	        
	        department2 = department.replace(del, "");
	        displayname2 = displayname.replace(del, "");
	        sb.append(department2 + " " + displayname2 + "<br>");
	        
	        
	        try{
		        ModificationItem[] mods = new ModificationItem[2];
		        mods[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE,
		        		new BasicAttribute("department",department2));
		        mods[1] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE,
		        		new BasicAttribute("displayname",displayname2));
		        ctx.modifyAttributes(dn, mods);
		        
	        }catch(NamingException e){
	        	sb.append("modify failed<br />"+e);
	        }

        }
    //以下是最外层while的 “}”   
    //    i++;
    //}

        ctx.close();
		//------- Domain end   ------

		return sb.toString();
	}
	
	
	
	
	public String delete() throws Exception {	//approveed!
		StringBuffer sb= new StringBuffer();
	    env = new Hashtable<String, String>();
	    env.put(Context.INITIAL_CONTEXT_FACTORY,	"com.sun.jndi.ldap.LdapCtxFactory");
	    env.put(Context.PROVIDER_URL,				"ldap://10.11.6.131:389");
	    env.put(Context.SECURITY_AUTHENTICATION,	"simple");
	    env.put(Context.SECURITY_PRINCIPAL,			"pdfpolicy@def.com");
	    env.put(Context.SECURITY_CREDENTIALS,		"policyView");
	        
	    ctx = new InitialDirContext(env);
	    String name="cn=xxx,ou=zongbu,ou=ulic,dc=def,dc=com";
	    try{
	    	ctx.destroySubcontext(name);
	    }catch(NamingException e){
	    	sb.append("delete failed!<br />" + e);
	    }
	
		return sb.toString();
	}
	
	public String ssl() throws Exception {	//rejected!
		StringBuffer sb = new StringBuffer();

	        env.put(Context.INITIAL_CONTEXT_FACTORY,	"com.sun.jndi.ldap.LdapCtxFactory");
	        env.put(Context.PROVIDER_URL,				"ldap://10.11.6.131:636");
	        env.put(Context.SECURITY_AUTHENTICATION,	"simple");
	        
		    env.put(Context.SECURITY_PRINCIPAL,			"CN=Administrator,CN=Users,DC=def,DC=com");	
		    //"cn=pdfpolicy, ou=zongbu, ou=ulic, dc=def, dc=com"
		    env.put(Context.SECURITY_CREDENTIALS,		"1234321");
	        
	        env.put(Context.SECURITY_PROTOCOL,"ssl");
	        String keystore = "/usr/java/jdk1.5.0/jre/lib/security/cacerts";
	        System.setProperty("javax.net.ssl.trustStore",keystore);
	        
//	        try {
//	        connCtls = new Control[] { new FastBindConnectionControl() };
//	        } catch (Exception ea) {
//	        	sb.append(ea);
//	        }
	        
	        
	        //ctx = new InitialDirContext(env);
	        try {
	        	ctx = new InitialLdapContext(env, null);	//connCtls
	            sb.append("approved!");
	            
	        } catch (NamingException e) {
	        	sb.append("Naming exception: " + e);
	        }

        
	
//	        //authentication start
//	        String username = "wengxf";
//	        String password = "1234321";	        
//	        try {
//	            lctx.addToEnvironment(Context.SECURITY_PRINCIPAL, username);
//	            lctx.addToEnvironment(Context.SECURITY_CREDENTIALS, password);
//	            lctx.reconnect(connCtls);
//	            System.out.println(username + " is authenticated");
//	            sb.append("authenticated!");
//	        }
//
//	        catch (AuthenticationException e) {
//	            System.out.println(username + " is not authenticated");
//	            System.out.println(e);
//	            sb.append("refused!");
//	        } catch (NamingException e) {
//	            System.out.println(username + " is not authenticated");
//	            System.out.println(e);
//	            sb.append("refused!");
//	        }
//	        //authentication end
	        
	        
	        

        
        return sb.toString();
	}
	
	public String modifynew() throws Exception {	//testing!

		StringBuffer sb= new StringBuffer();
		String displayname = null;
		String cn = null;
		String company = null;
		String department = null;
		String displayname2 = null;
		String ch = null;
		String dn = null;
		
		//------- Domain start ------
		
        env = new Hashtable<String, String>();
        env.put(Context.INITIAL_CONTEXT_FACTORY,	"com.sun.jndi.ldap.LdapCtxFactory");
        //env.put(Context.PROVIDER_URL,				"ldap://10.11.6.131:389");
        //以下是正式环境，domain admin：edituser/edituser
        env.put(Context.PROVIDER_URL,				"ldap://10.18.8.1:389");
        env.put(Context.SECURITY_AUTHENTICATION,	"simple");
        env.put(Context.SECURITY_PRINCIPAL,			"edituser@ulic.com.cn");
        env.put(Context.SECURITY_CREDENTIALS,		"edituser");
        String searchbase = "ou=new, ou=account, ou=ulic, dc=ulic, dc=com, dc=cn";

        //以下是筛选条件   可以选择改名的用户列表具备的条件
        String filter = "(cn=*)";

        ctx = new InitialDirContext(env);
        
        SearchControls constraints = new SearchControls();   
        constraints.setSearchScope(SearchControls.SUBTREE_SCOPE);
        NamingEnumeration<SearchResult> results = ctx.search(searchbase,filter,constraints);
        
        while(results != null && results.hasMoreElements()) {
	        SearchResult sr = (SearchResult)results.next();
	        dn = sr.getName() + "," + searchbase;
	        sb.append(dn + "<br>");

	        //以下从域获得查询到的用户的displayname，cn，company，department属性的值
	        displayname = ctx.getAttributes(dn).get("displayname").getAll().nextElement().toString();
	        cn = ctx.getAttributes(dn).get("cn").getAll().nextElement().toString();
	        
	        //去除cn中的空格，去除cn名的括号后部分
	        if(cn != null) {
		        
	        	cn = cn.trim();
		        if(cn.indexOf("(") != -1) {
		        	ch = cn.substring(cn.indexOf("("));
		        	//sb.append(ch);
		        	cn = cn.replace(ch, "");
		        }else if(cn.indexOf("（") != -1){
		        	ch = cn.substring(cn.indexOf("（"));
		        	//sb.append(ch);
		        	cn = cn.replace(ch, "");
		        }
	        }else{
	        	cn = "";
	        }
	       
	        //把company和department改成缩写
	        
	        company = ctx.getAttributes(dn).get("company").getAll().nextElement().toString();
	        if(company != null) {
	        	company = company.replace("分公司", "");
	        }else{
	        	company = "";
	        }
	        if(ctx.getAttributes(dn).get("department") != null) {
	        	department = ctx.getAttributes(dn).get("department").getAll().nextElement().toString();
	        }else {
	        	department = "";
	        }
	        department = department.replace("中心支公司", "");
	        department = department.replace("中支", "");

	        
	        //以下合成修改后的displayname形式
	        displayname2 = cn + "(" + company + "" + department + ")";
	        sb.append(" " + displayname + " 已被改成了 " + displayname2 + "<br><br>");
	        
	        //sb.append("company: " + company + "<br>department: " + department + "<br>");
	 
	        try{
		        ModificationItem[] mods = new ModificationItem[1];
		        mods[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE,
		        		new BasicAttribute("displayname",displayname2));

		        ctx.modifyAttributes(dn, mods);
		        
	        }catch(NamingException e){
	        	sb.append("modify failed<br />"+e);
	        }

        }

        ctx.close();
		//------- Domain end   ------

		return sb.toString();
		
		
	}
	
	
}

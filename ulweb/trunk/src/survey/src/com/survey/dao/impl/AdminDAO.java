package com.survey.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.survey.dao.DBpool;
import com.survey.util.ConfigManager;
import com.survey.vo.User;


public class AdminDAO extends HibernateDaoSupport {
	

	/**
	 * 进行LDAP验证 by wengxf 2011-4-6
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public boolean adCheck(String username, String password) throws Exception {
		//到域上验证该用户名和密码	by wengxf20080828
	    Hashtable<String, String> env;
		
		env = new Hashtable<String, String>();
        env.put(Context.INITIAL_CONTEXT_FACTORY,	"com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL,				ConfigManager.getString("ldap.server.url"));
        env.put(Context.SECURITY_AUTHENTICATION,	"simple");
        env.put(Context.SECURITY_PRINCIPAL,
        	ConfigManager.getString("ldap.search.prefix", ".", ",")
        		+ username
        		+ ConfigManager.getString("ldap.search.suffix", ".", ","));
        env.put(Context.SECURITY_CREDENTIALS,		password);
        
        try {
        	new InitialDirContext(env);
        	return true;
        }catch(NamingException e) {
        	return false;
        }
	}
	
}

package com.ulic.ulweb.ulweb.dao;

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

import com.ulic.ulweb.frame.dao.CommonDAO;
import com.ulic.ulweb.frame.dao.DBpool;
import com.ulic.ulweb.frame.util.PasswordDigest;
import com.ulic.ulweb.ulweb.entity.UlRoleClass;
import com.ulic.ulweb.ulweb2.util.ConfigManager;

public class AdminDAO {
	
	public List<UlRoleClass> getAllUserId() throws SQLException{
		List<UlRoleClass> list = new ArrayList<UlRoleClass>();
		Statement st = null;
		Connection conn = DBpool.getConnection();
		ResultSet rs = null;
		try{
			 st = conn.createStatement();
			 String sql = "select user_id, real_name from t_users order by user_id desc";
			 rs = st.executeQuery(sql);
			 while(rs.next()){
				 UlRoleClass r = new UlRoleClass();
				 r.setRoleId(rs.getInt(1));
				 r.setName(rs.getString(2));
				 list.add(r);				 
			 }
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			st.close();
			conn.close();
		}
		
		return list;
	}
	
	public List<UlRoleClass> getUserByName(String name) throws SQLException{
		List<UlRoleClass> list = new ArrayList<UlRoleClass>();
		Statement st = null;
		Connection conn = DBpool.getConnection();
		ResultSet rs = null;
		try{
			 st = conn.createStatement();
			 String sql = "select user_id, real_name from t_users where real_name like '%"
				 + name + "%' order by user_id desc";
			 rs = st.executeQuery(sql);
			 while(rs.next()){
				 UlRoleClass r = new UlRoleClass();
				 r.setRoleId(rs.getInt(1));
				 r.setName(rs.getString(2));
				 list.add(r);				 
			 }
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			st.close();
			conn.close();
		}
		
		return list;
	}
	
	public UlRoleClass getById(int id) throws SQLException{
		Connection conn = DBpool.getConnection();
		Statement st = null;
		ResultSet rs = null;
		UlRoleClass r = new UlRoleClass();
		try{
			 st = conn.createStatement();
			 String sql = "select user_id, real_name from t_users where user_id = " + id + " order by user_id desc";
			 rs = st.executeQuery(sql);
			if(rs.next()){				
				 r.setRoleId(rs.getInt(1));
				 r.setName(rs.getString(2));				 			 
			 }
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			st.close();
			conn.close();
		}		
		return r;
	}
	
	
	public UlRoleClass loginCheck(String name, String pw) throws SQLException{
		 UlRoleClass r = new UlRoleClass();
		 //PasswordDigest digest = new PasswordDigest("SHA-512");
		 //String epw=digest.digest(new String(pw));
		 Statement st = null;
			Connection conn = DBpool.getConnection();
			ResultSet rs = null;
			try{
				 st = conn.createStatement();
				 String sql = "select * from t_users where login_name = '"
					 + name + "'";
				 rs = st.executeQuery(sql);
				 if(rs.next()){				
					 if( adCheck(name,pw) == true ){		/*epw.equals(rs.getString("password"))*/
						 r.setRoleId(rs.getInt("user_id"));
						 r.setName(rs.getString("real_name"));	
						 r.setLoginOk(1);
					 }else{
						 r.setLoginOk(2);
					 }
				 }else{
					 r.setLoginOk(3);
				 }
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				st.close();
				conn.close();
			}
			
		 return r;
	}
	
	
	/**
	 * 进行LDAP验证 by wengxf 2011-4-6
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	private boolean adCheck(String username, String password) throws Exception {
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
	
	public String findAdUserRealName(String username) throws Exception {
		//	by wengxf20080828
		//查找符合该用户名distinguishName的域中的人真实姓名CN
		String realname = null;
		/*AD start*/
		DirContext ctx;
	    Hashtable<String, String> env;
		env = new Hashtable<String, String>();
        env.put(Context.INITIAL_CONTEXT_FACTORY,	"com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL,				ConfigManager.getString("ldap.server.url"));
        env.put(Context.SECURITY_AUTHENTICATION,	"simple");
        env.put(Context.SECURITY_PRINCIPAL,			ConfigManager.getString("ldap.userdn", ".", ","));
        env.put(Context.SECURITY_CREDENTIALS,		ConfigManager.getString("ldap.userdn.pwd"));
        ctx = new InitialDirContext(env);
        
        String MY_ATTRS[] = {"cn","mail"};
        String filter = "("
        	+ ConfigManager.getString("ldap.search.prefix", ".", ",")
        	+ username
        	+ ")";
		SearchControls constraints = new SearchControls();
		constraints.setSearchScope(SearchControls.SUBTREE_SCOPE);
		constraints.setReturningAttributes(MY_ATTRS);
		NamingEnumeration results = ctx.search(
				ConfigManager.getString("ldap.basedn", ".", ","), 
				filter, 
				constraints);
		
		if(results.hasMoreElements()) {
			SearchResult sr = (SearchResult)results.next();
			Attributes attrs = sr.getAttributes();
			Attribute attr = attrs.get("cn");
			NamingEnumeration ne = attr.getAll();
			realname = ne.next().toString();
			
		}
		else {
			realname = null;
		}

		/*AD end*/
		//如果找到了这个登录名mail登录名，返回对应的真实姓名CN，否则返回空null
		return realname;
	}
	
	public boolean addAdUser(String username, String realname) throws Exception {
		//从域中取出用户添加到用户库t_users中		by wengxf20080828
		Connection conn = DBpool.getConnection();
		Statement st = null;
		try{
			 st = conn.createStatement();
			 String sql = "insert into t_users(user_id,login_name,real_name) " +
			 			  "values(seq_user_id.nextval,'" + username + "','" + realname + "')";
			 st.execute(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			st.close();
			conn.close();
		}	
		
		return true;
	}
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DomainDAO.java

package com.ulic.ulweb.ulweb.dao;

import com.ulic.ulweb.frame.dao.BaseDao;
import com.ulic.ulweb.ulweb.entity.UserInformationObject;
import java.io.PrintStream;
import java.util.*;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.*;

public class DomainDAO extends BaseDao
{

    public DomainDAO()
    {
    }

    public String test(String baseDn, String searbase, String filter, String attrs)
        throws Exception
    {
        setEnvironment();
        ctx = new InitialDirContext(env);
        StringBuffer sb = new StringBuffer();
        SearchControls constraints = new SearchControls();
        constraints.setSearchScope(2);
        NamingEnumeration results = ctx.search(searbase, filter, constraints);
        int count = 0;
        while(results != null && results.hasMoreElements()) 
        {
            count++;
            sb.append((new StringBuilder("&lt;")).append(count).append("&gt;&nbsp;").toString());
            SearchResult sr = (SearchResult)(SearchResult)results.next();
            String dn = (new StringBuilder(String.valueOf(sr.getName()))).append(",").append(searbase).toString();
            sb.append((new StringBuilder("Distinguished   Name is:")).append(dn).append("+++").append(sr.getName()).append("<br>").toString());
            Attributes ars = ctx.getAttributes(dn);
            if(ars == null)
            {
                sb.append((new StringBuilder("Entry   ")).append(dn).append("   has   none   of   the   specified   attributes\n").toString());
            } else
            {
                for(int i = 0; i < MY_ATTRS.length; i++)
                {
                    Attribute attr = ars.get(MY_ATTRS[i]);
                    if(attr != null)
                    {
                        sb.append((new StringBuilder(String.valueOf(MY_ATTRS[i]))).append(":").toString());
                        for(Enumeration vals = attr.getAll(); vals.hasMoreElements(); sb.append((new StringBuilder("\t")).append(vals.nextElement()).toString()));
                        sb.append("<br />");
                    } else
                    {
                        sb.append((new StringBuilder(String.valueOf(MY_ATTRS[i]))).append(":\tnull").toString());
                    }
                }

                sb.append("<br />");
            }
        }
        return sb.toString();
    }

    public List getAllPersonNames()
        throws Exception
    {
        setEnvironment();
        ctx = new InitialDirContext(env);
        List t = new ArrayList();
        StringBuffer sb = new StringBuffer();
        SearchControls constraints = new SearchControls();
        constraints.setSearchScope(2);
        for(NamingEnumeration results = ctx.search(MY_SEARCHBASE, MY_FILTER, constraints); results != null && results.hasMoreElements();)
        {
            SearchResult sr = (SearchResult)(SearchResult)results.next();
            String dn = (new StringBuilder(String.valueOf(sr.getName()))).append(",").append(MY_SEARCHBASE).toString();
            System.out.println((new StringBuilder("Distinguished   Name   is   ")).append(dn).toString());
            Attributes ars = ctx.getAttributes(dn, MY_ATTRS);
            if(ars == null)
            {
                sb.append((new StringBuilder("Entry   ")).append(dn).append("   has   none   of   the   specified   attributes\n").toString());
            } else
            {
                for(int i = 0; i < MY_ATTRS.length; i++)
                {
                    Attribute attr = ars.get(MY_ATTRS[i]);
                    if(attr != null)
                    {
                        sb.append((new StringBuilder(String.valueOf(MY_ATTRS[i]))).append(":").toString());
                        for(Enumeration vals = attr.getAll(); vals.hasMoreElements(); sb.append((new StringBuilder("\t")).append(vals.nextElement()).toString()));
                        sb.append("\n");
                    } else
                    {
                        sb.append((new StringBuilder(String.valueOf(MY_ATTRS[i]))).append(":\tnull").toString());
                    }
                }

                sb.append("\n");
            }
        }

        t.add(sb.toString());
        return t;
    }

    private void setEnvironment()
    {
        env = new Hashtable();
        env.put("java.naming.factory.initial", "com.sun.jndi.ldap.LdapCtxFactory");
        env.put("java.naming.provider.url", "ldap://10.18.8.1:389");
        env.put("java.naming.security.authentication", "simple");
        env.put("java.naming.security.principal", "edituser@ulic.com.cn");
        env.put("java.naming.security.credentials", "edituser");
    }

    private void createGroup()
        throws NamingException
    {
        Attributes attr;
        try
        {
            attr = ctx.getAttributes("dc=ulic,dc=com,dc=cn");
        }
        catch(NamingException ne)
        {
            Attribute objclass = new BasicAttribute("objectclass");
            objclass.add("top");
            objclass.add("groupofuniquenames");
            Attribute cn = new BasicAttribute("cn", "student");
            Attributes attrs = new BasicAttributes();
            attrs.put(objclass);
            attrs.put(cn);
            ctx.bind("dc=ulic,dc=com,dc=cn", null, attrs);
            System.out.println("Group created.n");
        }
    }

    private void closeConnection()
    {
        try
        {
            ctx.close();
        }
        catch(NamingException ne)
        {
            System.out.println(ne);
        }
    }

    private boolean isUserexist(String uid)
    {
        try
        {
            Attributes attrs = findUser(uid);
            return attrs != null;
        }
        catch(NamingException ne)
        {
            return false;
        }
    }

    private void putAttribute(Attributes attrs, String attrName, String attrValue)
    {
        if(attrValue != null && attrValue.length() != 0)
        {
            Attribute attr = new BasicAttribute(attrName, attrValue);
            attrs.put(attr);
        }
    }

    private String getAttribute(Attributes attrs, String attrName)
        throws NamingException
    {
        Attribute attr = attrs.get(attrName);
        if(attr == null)
            return "";
        else
            return (String)attr.get();
    }

    private Attributes findUser(String uid)
        throws NamingException
    {
        return ctx.getAttributes((new StringBuilder("uid=")).append(uid).append(",").append("dc=ulic,dc=com,dc=cn").toString());
    }

    public void createUser(UserInformationObject userobj)
        throws NamingException
    {
        if(userobj == null)
            throw new NamingException("No user informationn");
        String uid = userobj.getProperty("4");
        if(uid == null || uid.length() == 0)
            throw new NamingException("No uid you specifyn");
        if(isUserexist(uid))
            throw new NamingException((new StringBuilder("The user(uid: ")).append(uid).append(") is exist!n").toString());
        String firstName = userobj.getProperty("1");
        if(firstName == null || firstName.length() == 0)
            throw new NamingException("No first name you specify!n");
        String lastName = userobj.getProperty("2");
        if(lastName == null || lastName.length() == 0)
            throw new NamingException("No last name you specify!n");
        String commonName = userobj.getProperty("3");
        if(commonName == null || commonName.length() == 0)
        {
            throw new NamingException("No common name you specify!n");
        } else
        {
            String password = userobj.getProperty("5");
            String email = userobj.getProperty("6");
            String phone = userobj.getProperty("7");
            String fax = userobj.getProperty("8");
            Attributes attrs = new BasicAttributes();
            Attribute objclass = new BasicAttribute("objectclass");
            objclass.add("top");
            objclass.add("person");
            objclass.add("organizationalPerson");
            objclass.add("inetorgperson");
            attrs.put(objclass);
            putAttribute(attrs, "cn", commonName);
            putAttribute(attrs, "givenname", firstName);
            putAttribute(attrs, "sn", lastName);
            putAttribute(attrs, "uid", uid);
            putAttribute(attrs, "userpassword", password);
            putAttribute(attrs, "mail", email);
            putAttribute(attrs, "telephonenumber", phone);
            putAttribute(attrs, "facsimiletelephonenumber", fax);
            ctx.bind((new StringBuilder("uid=")).append(uid).append(",").append("dc=ulic,dc=com,dc=cn").toString(), null, attrs);
            System.out.println((new StringBuilder("User(uid: ")).append(uid).append(") created.n").toString());
            return;
        }
    }

    public void modifyUser(UserInformationObject userobj)
        throws NamingException
    {
        if(userobj == null)
            throw new NamingException("No user information!n");
        String uid = userobj.getProperty("4");
        if(uid == null || uid.length() == 0)
            throw new NamingException("No uid you specify!n");
        if(!isUserexist(uid))
            throw new NamingException((new StringBuilder("The user(uid: ")).append(uid).append(") does not exist!n").toString());
        int size = userobj.size();
        if(size > 1)
        {
            String password = userobj.getProperty("5");
            String email = userobj.getProperty("6");
            String phone = userobj.getProperty("7");
            String fax = userobj.getProperty("8");
            String commonName = userobj.getProperty("3");
            String firstName = userobj.getProperty("1");
            String lastName = userobj.getProperty("2");
            Attributes attrs = new BasicAttributes();
            putAttribute(attrs, "cn", commonName);
            putAttribute(attrs, "givenname", firstName);
            putAttribute(attrs, "sn", lastName);
            putAttribute(attrs, "userpassword", password);
            putAttribute(attrs, "mail", email);
            putAttribute(attrs, "telephonenumber", phone);
            putAttribute(attrs, "facsimiletelephonenumber", fax);
            ctx.modifyAttributes((new StringBuilder("uid=")).append(uid).append(",").append("dc=ulic,dc=com,dc=cn").toString(), 2, attrs);
            System.out.println((new StringBuilder("User(uid: ")).append(uid).append(") information modified.n").toString());
        } else
        {
            throw new NamingException("No modify information you specify!n");
        }
    }

    public void deleteUser(String uid)
        throws NamingException
    {
        if(!isUserexist(uid))
        {
            throw new NamingException((new StringBuilder("The user(uid: ")).append(uid).append(") does not exist!n").toString());
        } else
        {
            ctx.destroySubcontext((new StringBuilder("uid=")).append(uid).append(",").append("dc=ulic,dc=com,dc=cn").toString());
            System.out.println((new StringBuilder("User(uid: ")).append(uid).append(") deleted.n").toString());
            return;
        }
    }

    public void selectUser(String uid)
        throws NamingException
    {
        System.out.println((new StringBuilder("select user(uid: ")).append(uid).append(")...").toString());
        try
        {
            Attributes attrs = findUser(uid);
            System.out.println("-----------------------------");
            System.out.println((new StringBuilder("User(uid: ")).append(uid).append(") listing...").toString());
            System.out.println((new StringBuilder("First Name: ")).append(getAttribute(attrs, "givenname")).toString());
            System.out.println((new StringBuilder("Last Name: ")).append(getAttribute(attrs, "sn")).toString());
            System.out.println((new StringBuilder("Common Name: ")).append(getAttribute(attrs, "cn")).toString());
            System.out.println((new StringBuilder("User ID: ")).append(getAttribute(attrs, "uid")).toString());
            System.out.println((new StringBuilder("E-Mail: ")).append(getAttribute(attrs, "mail")).toString());
            System.out.println((new StringBuilder("Phone: ")).append(getAttribute(attrs, "telephonenumber")).toString());
            System.out.println((new StringBuilder("Fax: ")).append(getAttribute(attrs, "facsimiletelephonenumber")).toString());
            System.out.println("List completed.");
            System.out.println("-----------------------------n");
        }
        catch(NamingException ne)
        {
            throw new NamingException((new StringBuilder("The user(uid: ")).append(uid).append(") is not exist!n").toString());
        }
    }

    public void selectUser(String uid[])
    {
        for(int i = 0; i < uid.length; i++)
            try
            {
                selectUser(uid[i]);
            }
            catch(NamingException ne)
            {
                System.out.println(ne);
            }

    }

    protected void finalize()
    {
        closeConnection();
    }

    private DirContext ctx;
    private Hashtable env;
    private static final String LDAP_URL = "ldap://10.18.8.1:389";
    private static final String MANAGER_DN = "edituser@ulic.com.cn";
    private static final String MANAGER_PASSWORD = "edituser";
    private static final String AUTH_TYPE = "simple";
    private static final String CONTEXT_FACTORY = "com.sun.jndi.ldap.LdapCtxFactory";
    private static final String BASE_DN = "dc=ulic,dc=com,dc=cn";
    public static String MY_SEARCHBASE = "dc=ulic,dc=com,dc=cn";
    public static String MY_FILTER = "(&(objectclass=user))";
    public static String MY_ATTRS[] = {
        "cn", "givenname", "mail", "displayname", "company", "department"
    };

}

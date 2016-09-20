// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   UlDomainServiceImpl.java

package com.ulic.ulweb.ulweb.service.impl;

import com.ulic.ulweb.frame.service.BaseService;
import com.ulic.ulweb.ulweb.dao.DomainDAO;
import com.ulic.ulweb.ulweb.dao.DomainTest;
import com.ulic.ulweb.ulweb.service.IDomainService;
import java.util.List;

public class UlDomainServiceImpl extends BaseService
    implements IDomainService
{

    public UlDomainServiceImpl()
    {
        domainDAO = new DomainDAO();
        domainTest = new DomainTest();
    }

    public DomainDAO getDomainDAO()
    {
        return domainDAO;
    }

    public void setDomainDAO(DomainDAO domainDAO)
    {
        this.domainDAO = domainDAO;
    }

    public List getAllPersonNames()
        throws Exception
    {
        return domainDAO.getAllPersonNames();
    }

    public String test(String baseDn, String searbase, String filter, String attrs)
        throws Exception
    {
        return domainDAO.test(baseDn, searbase, filter, attrs);
    }

    public String check(String username, String password)
        throws Exception
    {
        return domainTest.check(username, password);
    }

    public String modify(String filter)
        throws Exception
    {
        return domainTest.modify(filter);
    }

    public String delete()
        throws Exception
    {
        return domainTest.delete();
    }

    public String ssl()
        throws Exception
    {
        return domainTest.ssl();
    }

    public String edit()
        throws Exception
    {
        return domainTest.edit();
    }

    public String modifynew()
        throws Exception
    {
        return domainTest.modifynew();
    }

    public DomainDAO domainDAO;
    public DomainTest domainTest;
}

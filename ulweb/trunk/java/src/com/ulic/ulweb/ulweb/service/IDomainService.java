// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   IDomainService.java

package com.ulic.ulweb.ulweb.service;

import com.ulic.ulweb.frame.service.IService;
import java.util.List;

public interface IDomainService
    extends IService
{

    public abstract List getAllPersonNames()
        throws Exception;

    public abstract String test(String s, String s1, String s2, String s3)
        throws Exception;

    public abstract String check(String s, String s1)
        throws Exception;

    public abstract String modify(String s)
        throws Exception;

    public abstract String modifynew()
        throws Exception;

    public abstract String delete()
        throws Exception;

    public abstract String ssl()
        throws Exception;

    public abstract String edit()
        throws Exception;
}

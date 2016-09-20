package com.ulic.ulweb.frame.dao;

import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBpool {
		//public static final String DS_ULICWEB="hr";	del by wxf 20080828
		public static final String DS_ULICWEB="oracle";
	    public static final String DS_ULICUM="jdbc/ulicum";
	    
	    public static Connection getConnectionInternal(String dataSourceName)
	    {
	        try
	        {
				Context initCtx = new InitialContext();
				Context rootCtx = (Context) initCtx.lookup("java:/comp/env");
				DataSource ds = (DataSource)rootCtx.lookup(dataSourceName);
				return ds.getConnection();
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	            return null;
	        }
	    }
	    public static Connection getConnection()
	    {
	        return getConnectionInternal(DS_ULICWEB);
	    }
	    
	    public static Connection getUmConnection()
	    {
	        return getConnectionInternal(DS_ULICUM);
	    }
}

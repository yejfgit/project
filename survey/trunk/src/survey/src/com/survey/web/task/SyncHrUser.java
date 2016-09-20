package com.survey.web.task;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.survey.util.DataSourceUtil;
import com.survey.util.DateUtil;

public class SyncHrUser implements Runnable{
	
	static final String mutex = "";
	public void run() {
		// TODO Auto-generated method stub
		synchronized(mutex){
			System.out.println("--------------------------sycn begin"+ System.currentTimeMillis());
			
			String procStr = "sv_p_syncHrUserData.p_syncHrUserData()";
			String[] procPara = null;
//			String dateStr = DateUtil.getSysDateStr();
//			procPara = dateStr.split("-");
//			System.out.println(procPara[0] + procPara[1] + procPara[2]);
//			procPara[2] = procPara[1];
//			procPara[1] = "1";
			callProcedure(procStr, procPara);
			
			
			System.out.println("--------------------------sycn end"+ System.currentTimeMillis());
		}
	}
	
	public void callProcedure(final String procStr, final Object[] procPara){
		String sql = "{call " + procStr + "}";
		try
		{
			Connection conn = DataSourceUtil.getConnection();
			CallableStatement cs = conn.prepareCall(sql);
			if( procPara != null )
			{
				for(int i=1; i<=procPara.length; i++)
				{
					cs.setString(i, (String)procPara[i-1]);
				}
			}
			cs.executeUpdate();
//	 	cs.execute();
//		 cs.executeQuery();
			cs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		SyncHrUser su = new SyncHrUser();
		su.run();
	}

}

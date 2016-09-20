package com.ulic.ulweb.frame.constant;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import com.ulic.ulweb.ulweb.entity.UlConfig;

public class Constant {
	
	public static String contextPath = "";
	
	public static final String FIND = "find";
	public static final String COUNT = "count";
	public static final String GET = "get";
	public static final String LOAD = "load";
	public static final String CREATE = "create";
	public static final String USER_PASSWORD_NOT_NULL = "";
	public static final String LOGIN_USER = "loginUser";
	public static String SAVEPATH = null;
	public static final String systemCode = "s_ul_web";
	public static String realPath = null;
	
//暂时问题上报系统
	public static StringBuffer sb1 = new StringBuffer();
	public static StringBuffer sb2 = new StringBuffer();
	public static int sbcount = 0;
//管理员用的每页行数
	public static  int listNum = 5;	
//栏目号
	public static  int gongwen = 1;
	public static  int gonggao = 2;	
	public static  int hezhongbobao = 51;
//公文模板
	public static int documentModel = 1;
//信息快递
	public static  int xinxikuaidi = 46;
	public static  int hezhongjianbao = 47;
	public static  int jigoufazhankuaixun = 50;
	public static  int hangyezixun = 48;
//理赔专栏
	public static  int lipeizhuanlan = 41;
	public static  int lipeizhuankan = 42;
	public static  int lipeianli = 43;
	public static  int lipeixinwen = 44;
//邮件地址簿	
	public static  int youjiandizhibu = 53;
	public static String youjiandizhi = null;
	public static String youjianshijian = null;
//合众人风采
	public static  int hezhongrenfengcai = 45;
	public static  int yejibobao = 54;
//常用表格下载
	public static  int changyongbiaogexiazai = 49;
	public static int biaogeit = 1;
	public static int biaogehr = 1;
	public static int biaogeof = 1;
	public static  int neibupeixunziliao = 55;
	public static  int itziyuangongxiang = 52;
	public static  List<Integer> quickLinkSingle = new ArrayList<Integer>();
	
	
//首页的设置，图片和flash	
	public static String mainPaget = null; 
//	public static String mainPaget2 = null;
	public static String mainPagep1 = null;
//	public static String mainPagep12 = null;
	public static String mainPagep2 = null;
//	public static String mainPagep22 = null;
	public static String mainPagep3 = null;
//	public static String mainPagep32 = null;
	public static String mainPagep4 = null;
//	public static String mainPagep42 = null;
	public static String mainPageb = null;
//	public static String mainPageb2 = null;
	public static String mainPagea = null;
//	public static String mainPagea2 = null;
	
//广告栏目
	public static int ad = 82;
	
	
//这里是业绩播报的数值
	public static  int gexianbaofei = 0;
	public static  int tuanxianbaofei = 0;
	public static  int yindaibaofei = 0;
//浏览者每页行数
	public static  int indexPageSize = 20;

//能够修改业绩播报的ip
	public static  String ip = "127.0.0.1";
//初始化要在首页显示的栏目
	public static void initQuickLinkSingle(){
//		quickLinkSingle.add(youjiandizhibu);
		quickLinkSingle.add(hezhongjianbao);
		quickLinkSingle.add(jigoufazhankuaixun);
		quickLinkSingle.add(hangyezixun);
		quickLinkSingle.add(lipeizhuankan);
		quickLinkSingle.add(lipeianli);
		quickLinkSingle.add(lipeixinwen);
		quickLinkSingle.add(hezhongrenfengcai);
		quickLinkSingle.add(yejibobao);
		
		
	}
	
//首页右侧的链接 核心业务系统等
	public static List<UlConfig> linkList = new ArrayList<UlConfig>();
	
	
//检查快捷栏目	
	public static Boolean isInQuickLinkSingle(int columnId){
		for(int i = 0; i < quickLinkSingle.size(); i++){
			if(columnId == quickLinkSingle.get(i).intValue()) return true;
		}
		return false;
	}
	
	public static String getFileRealPath(String path) {
		return realPath + "/" + path;
	}

	public static String getMonthPath(){
		Calendar createDate = Calendar.getInstance();
		String year = String.valueOf(createDate.get(Calendar.YEAR));
		String month = String.valueOf(createDate.get(Calendar.MONTH) + 1);
		return year + "/" + month + "/";
	}
	
	public static String getDatePath(){
		Calendar createDate = Calendar.getInstance();
		String year = String.valueOf(createDate.get(Calendar.YEAR));
		String month = String.valueOf(createDate.get(Calendar.MONTH) + 1);
		String date = String.valueOf(createDate.get(Calendar.DAY_OF_MONTH));
		return year + "/" + month + "/" + date + "/";
	}
		
	
	public static String getdeptPath(String deptName){
		return Constant.SAVEPATH + deptName + "/" + getDatePath();
	}
	
	public static String getUploadPath(){
		return Constant.SAVEPATH  + getDatePath();
	}
	

	public static void makeDir(String path) {
		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
		}
	}
	
	public static void loadInitPath() throws IOException {
		InputStream in = Constant.class.getClassLoader().getResourceAsStream("/com/ulic/ulweb/config/config.properties");
		Properties p = new Properties();
		try {
			p.load(in);
			Constant.SAVEPATH = p.getProperty("uploadfilepath");
		}
		catch (IOException e) {
			e.printStackTrace();
			throw new IOException();
		}
	}
	public static int compare(Timestamp t1, Timestamp t2) {
		return t1.compareTo(t2);
	}
	public static boolean hasFile(String path) {
		boolean b = false;
		File file = new File(path);
		if (!file.exists()) {
			b = false;
		}
		else {
			b = true;
		}
		return b;
	}


}
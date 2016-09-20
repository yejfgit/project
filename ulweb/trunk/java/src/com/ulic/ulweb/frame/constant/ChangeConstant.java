package com.ulic.ulweb.frame.constant;

public class ChangeConstant {

	public void change(String name, String date){
		int tempdate = 0;
		try{
			tempdate = Integer.parseInt(date);
		}catch(Exception e){
			tempdate = -1;
		}
		if(tempdate == -1){
			this.changeStrig(name, date);
		}else{
			this.changeInt(name, tempdate);
		}
	}
	
	
	public void changeStrig(String name, String date){
		if(name.equals("mainPagea")){
			Constant.mainPagea = date;
//		}else if(name.equals("mainPagea2")){
//			Constant.mainPagea2 = date;
		}else if(name.equals("mainPageb")){
			Constant.mainPageb = date;
//		}else if(name.equals("mainPageb2")){
//			Constant.mainPageb2 = date;
		}else if(name.equals("mainPagep1")){
			Constant.mainPagep1 = date;
//		}else if(name.equals("mainPagep12")){
//			Constant.mainPagep12 = date;
		}else if(name.equals("mainPagep2")){
			Constant.mainPagep2 = date;
//		}else if(name.equals("mainPagep22")){
//			Constant.mainPagep22 = date;
		}else if(name.equals("mainPagep3")){
			Constant.mainPagep3 = date;
//		}else if(name.equals("mainPagep32")){
//			Constant.mainPagep32 = date;
		}else if(name.equals("mainPagep4")){
			Constant.mainPagep4 = date;
//		}else if(name.equals("mainPagep42")){
//			Constant.mainPagep42 = date;
		}else if(name.equals("mainPaget")){
			Constant.mainPaget = date;
//		}else if(name.equals("mainPaget2")){
//			Constant.mainPaget2 = date;
		}
	}
	
	public void changeInt(String name, int date){
		if(name.equals("listNum")){
			Constant.listNum = date;
		}else if(name.equals("gongwen")){
			Constant.gongwen = date;
		}else if(name.equals("gonggao")){
			Constant.gonggao = date;
		}else if(name.equals("hezhongbobao")){
			Constant.hezhongbobao = date;
		}else if(name.equals("documentModel")){
			Constant.documentModel = date;			
		}else if(name.equals("xinxikuaidi")){
			Constant.xinxikuaidi = date;
		}else if(name.equals("hezhongjianbao")){
			Constant.hezhongjianbao = date;
		}else if(name.equals("jigoufazhankuaixun")){
			Constant.jigoufazhankuaixun = date;
		}else if(name.equals("hangyezixun")){
			Constant.hangyezixun = date;
		}else if(name.equals("lipeizhuanlan")){
			Constant.lipeizhuanlan = date;
		}else if(name.equals("lipeizhuankan")){
			Constant.lipeizhuankan = date;
		}else if(name.equals("lipeianli")){
			Constant.lipeianli = date;
		}else if(name.equals("lipeixinwen")){
			Constant.lipeixinwen = date;
		}else if(name.equals("youjiandizhibu")){
			Constant.youjiandizhibu = date;
		}else if(name.equals("hezhongrenfengcai")){
			Constant.hezhongrenfengcai = date;
		}else if(name.equals("yejibobao")){
			Constant.yejibobao = date;
		}else if(name.equals("changyongbiaogexiazai")){
			Constant.changyongbiaogexiazai = date;
		}else if(name.equals("neibupeixunziliao")){
			Constant.neibupeixunziliao = date;
		}else if(name.equals("itziyuangongxiang")){
			Constant.itziyuangongxiang = date;
		}else if(name.equals("gexianbaofei")){
			Constant.gexianbaofei = date;
		}else if(name.equals("tuanxianbaofei")){
			Constant.tuanxianbaofei =date;
		}else if(name.equals("yindaibaofei")){
			Constant.yindaibaofei = date;
		}else if(name.equals("indexPageSize")){
			Constant.indexPageSize = date;
		}else if(name.equals("biaogeit")){
			Constant.biaogeit = date;
		}else if(name.equals("biaogehr")){
			Constant.biaogehr = date;
		}else if(name.equals("biaogeof")){
			Constant.biaogeof = date;
		}else if(name.equals("ad")){
			Constant.ad = date;
		}
			
			
			
	}
}

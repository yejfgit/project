package com.ulic.ulweb.ulweb.web.action.admin;

import java.util.List;

import com.ulic.ulweb.frame.action.BaseAction;
import com.ulic.ulweb.frame.constant.Constant;
import com.ulic.ulweb.ulweb.entity.UlAttachment;
import com.ulic.ulweb.ulweb.entity.UlConfig;
import com.ulic.ulweb.ulweb.entity.UlContent;
import com.ulic.ulweb.ulweb.entity.UlReport;
import com.ulic.ulweb.ulweb.service.IUlAttachmentService;
import com.ulic.ulweb.ulweb.service.IUlReportService;
import com.ulic.ulweb.ulweb.service.UtilService;
import com.ulic.ulweb.ulweb.util.PorjectTask;
import com.ulic.ulweb.ulweb.web.action.IndexAction;

public class InitAction extends BaseAction{
	
//	081016 add init all things here
	public void initAll(){

		this.initUlweb();
		//this.getReport();
		this.getMailaddress();
		
		Constant.initQuickLinkSingle();
		IndexAction indexa = new IndexAction();
		indexa.initList();
		
		new PorjectTask().start();
		
	}	
	
	public void getReport() {
		try{
		IUlReportService rs = (IUlReportService)this.getService("reportService");
		UlReport r = rs.getReport();
			if(r != null){
				Constant.gexianbaofei = r.getPersonal();
				Constant.tuanxianbaofei = r.getGroup();
				Constant.yindaibaofei = r.getBank();
			}
		}catch(Exception e){
			System.out.println("********* init false ************");
			e.printStackTrace();
		}
		
	}
	
	public int getMailaddress(){
		int i = 0;
		try{			
			IUlAttachmentService as = (IUlAttachmentService)this.getService("attachmentService");
			UlContent c = as.getLastContentInColumnId(Constant.youjiandizhibu);
			if(c != null){
				UlAttachment a = as.getByContentIdAndOrder(c.getContentId(), 1);
				if(a != null){
					Constant.youjiandizhi = a.getAttachmentPath();
					Constant.youjianshijian = c.getUploadTime().toString().substring(5,c.getUploadTime().toString().indexOf(" "));
					i = 1;
				}
			}
		}catch(Exception e){
			System.out.println("********* init false ************");
			e.printStackTrace();
		}
		return i;
	}
	
	public int initUlweb() {
		int initOk = 1;
		try{
			UtilService us = (UtilService)this.getService("utilService");
			List<UlConfig> l = us.getConfigList();
			Constant.listNum = this.getConfigInt(l, "listNum", Constant.listNum);
			Constant.gongwen = this.getConfigInt(l, "gongwen", Constant.gongwen);
			Constant.gonggao = this.getConfigInt(l, "gonggao", Constant.gonggao);
			Constant.hezhongbobao = this.getConfigInt(l, "hezhongbobao", Constant.hezhongbobao);
			Constant.xinxikuaidi = this.getConfigInt(l, "xinxikuaidi", Constant.xinxikuaidi);
			Constant.hezhongjianbao = this.getConfigInt(l, "hezhongjianbao", Constant.hezhongjianbao);
			Constant.jigoufazhankuaixun = this.getConfigInt(l, "jigoufazhankuaixun", Constant.jigoufazhankuaixun);
			Constant.hangyezixun = this.getConfigInt(l, "hangyezixun", Constant.hangyezixun);
			Constant.lipeizhuanlan = this.getConfigInt(l, "lipeizhuanlan", Constant.lipeizhuanlan);
			Constant.lipeizhuankan = this.getConfigInt(l, "lipeizhuankan", Constant.lipeizhuankan);
			Constant.lipeianli = this.getConfigInt(l, "lipeianli", Constant.lipeianli);
			Constant.lipeixinwen = this.getConfigInt(l, "lipeixinwen", Constant.lipeixinwen);
			Constant.youjiandizhibu = this.getConfigInt(l, "youjiandizhibu", Constant.youjiandizhibu);
			Constant.hezhongrenfengcai = this.getConfigInt(l, "hezhongrenfengcai", Constant.hezhongrenfengcai);
			Constant.yejibobao = this.getConfigInt(l, "yejibobao", Constant.yejibobao);
			Constant.changyongbiaogexiazai = this.getConfigInt(l, "changyongbiaogexiazai", Constant.changyongbiaogexiazai);
			Constant.biaogeit = this.getConfigInt(l, "biaogeit", Constant.biaogeit);
			Constant.biaogehr = this.getConfigInt(l, "biaogehr", Constant.biaogehr);
			Constant.biaogeof = this.getConfigInt(l, "biaogeof", Constant.biaogeof);			
			Constant.neibupeixunziliao = this.getConfigInt(l, "neibupeixunziliao", Constant.neibupeixunziliao);
			Constant.itziyuangongxiang = this.getConfigInt(l, "itziyuangongxiang", Constant.itziyuangongxiang);
			Constant.indexPageSize = this.getConfigInt(l, "indexPageSize", Constant.indexPageSize);
			Constant.documentModel = this.getConfigInt(l, "documentModel", Constant.documentModel);
			Constant.mainPagea = this.getConfigStr(l, "mainPagea", Constant.mainPagea);			
//			Constant.mainPagea2 = this.getConfigStr(l, "mainPagea2", Constant.mainPagea2);			
			Constant.mainPagep1 = this.getConfigStr(l, "mainPagep1", Constant.mainPagep1);			
//			Constant.mainPagep12 = this.getConfigStr(l, "mainPagep12", Constant.mainPagep12);			
			Constant.mainPagep2 = this.getConfigStr(l, "mainPagep2", Constant.mainPagep2);			
//			Constant.mainPagep22 = this.getConfigStr(l, "mainPagep22", Constant.mainPagep22);			
			Constant.mainPagep3 = this.getConfigStr(l, "mainPagep3", Constant.mainPagep3);			
//			Constant.mainPagep32 = this.getConfigStr(l, "mainPagep32", Constant.mainPagep32);			
			Constant.mainPagep4 = this.getConfigStr(l, "mainPagep4", Constant.mainPagep4);			
//			Constant.mainPagep42 = this.getConfigStr(l, "mainPagep42", Constant.mainPagep42);			
			Constant.mainPaget = this.getConfigStr(l, "mainPaget", Constant.mainPaget);			
//			Constant.mainPaget2 = this.getConfigStr(l, "mainPaget2", Constant.mainPaget2);			
			Constant.mainPageb = this.getConfigStr(l, "mainPageb", Constant.mainPageb);			
//			Constant.mainPageb2 = this.getConfigStr(l, "mainPageb2", Constant.mainPageb2);			
			
//			this.getLinkList(l);
			
		}catch(Exception e){
			initOk = 0;
			System.out.println("********* init false ************");
			e.printStackTrace();			
		}
		return initOk;
		
	}
	
	public int getConfigInt(List<UlConfig> l, String k, int oldValue){
		int temp1 = oldValue;		
		for(int i = 0; i < (l == null ? 0 : l.size()); i++){
			if(l.get(i).getConstantName().equals(k)){
				try{
				temp1 = Integer.parseInt(l.get(i).getConstantData());
				}catch(Exception e){
					System.out.println("**** init data format wrong ****");
				}
				break;
			}			
		}
		return temp1;		
	}
	
	public String getConfigStr(List<UlConfig> l, String k, String oldStr){
		String temp1 = oldStr;		
		for(int i = 0; i < (l == null ? 0 : l.size()); i++){
			if(l.get(i).getConstantName().equals(k)){
				temp1 = l.get(i).getConstantData();
				break;
			}			
		}
		return temp1;
	}
	
	public void getLinkList(List<UlConfig> l){		
		for(int i = 0 ; i < (l == null ? 0 : l.size()); i++){
			if(l.get(i).getConstantName().equals("indexlink")) Constant.linkList.add(l.get(i));
		}		
	}
}

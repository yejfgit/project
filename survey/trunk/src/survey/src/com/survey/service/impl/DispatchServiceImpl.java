package com.survey.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.survey.dao.IBaseDao;
import com.survey.dao.IDeptDao;
import com.survey.dao.IMissionDao;
import com.survey.dao.ISurveyDao;
import com.survey.dao.IUserDao;
import com.survey.service.IDispatchService;
import com.survey.service.IMissionService;
import com.survey.util.ConfigManager;
import com.survey.util.ContextUtil;
import com.survey.util.StringUtil;
import com.survey.util.UlicSendMail;
import com.survey.vo.DispatchUser;
import com.survey.vo.Mission;
import com.survey.vo.Survey;
import com.survey.vo.TSendEmail;
import com.survey.vo.TSvUsers;
import com.survey.vo.TUmOrgan;
import com.survey.vo.TUmUser;
import com.survey.vo.User;


public class DispatchServiceImpl implements IDispatchService {
	
	private IBaseDao baseDaoImpl;
	
	private IUserDao userDao;
	
	private IDeptDao deptDao;
	
	private IMissionDao missionDao;
	
	private ISurveyDao surveyDao;
	
	private IMissionService missionService;
	
	
	public IMissionService getMissionService() {
		return missionService;
	}


	public void setMissionService(IMissionService missionService) {
		this.missionService = missionService;
	}


	public IBaseDao getBaseDaoImpl() {
		return baseDaoImpl;
	}


	public void setBaseDaoImpl(IBaseDao baseDaoImpl) {
		this.baseDaoImpl = baseDaoImpl;
	}


	public IMissionDao getMissionDao() {
		return missionDao;
	}


	public void setMissionDao(IMissionDao missionDao) {
		this.missionDao = missionDao;
	}


	public ISurveyDao getSurveyDao() {
		return surveyDao;
	}


	public void setSurveyDao(ISurveyDao surveyDao) {
		this.surveyDao = surveyDao;
	}


	public IUserDao getUserDao() {
		return userDao;
	}


	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public IDeptDao getDeptDao() {
		return deptDao;
	}


	public void setDeptDao(IDeptDao deptDao) {
		this.deptDao = deptDao;
	}


	public String dispatchSurvey(String msg, int surveyId,String path) {
		// TODO Auto-generated method stub
		List<String> userList = new ArrayList();
		String[] dispatchObj = msg.split(";");
		for (int i=0;i<dispatchObj.length;i++){
			String[] dispatchObj2 = dispatchObj[i].split(",");
			if(StringUtil.parseInt(dispatchObj2[1]) == 1){
				userList.add(dispatchObj2[0]);
			}else{
//				List users = deptDao.getUsersByDeptId(StringUtil.parseInt(dispatchObj2[0]));
				List users = deptDao.getTSvUsersByDeptId(StringUtil.parseInt(dispatchObj2[0]));
				for(int j=0;j<users.size();j++){
					TSvUsers user = (TSvUsers) users.get(j);
					userList.add(user.getEmpId());
				}
			}
		}
		
		Survey survey = surveyDao.getSurveyById(surveyId);
		TUmUser fqUser = userDao.getUmUserByUserId(survey.getOwnerId());
		TUmOrgan fqOrgan = deptDao.getOrganById(StringUtil.parseInt(fqUser.getUmOrgan()));
		//将没有邮箱的用户反馈给问卷发起人
		StringBuffer noEmail = new StringBuffer();
		for(int k = 0;k<userList.size();k++){
//			TUmUser user = userDao.getUmUserByUserId(StringUtil.parseInt(userList.get(k)));
//			根据empId查找umUser
			DispatchUser user = userDao.getDispatchUserByEmpId(userList.get(k));
			
			Mission mn = missionService.requestMission(StringUtil.parseInt(user.getUmUserId()), survey, StringUtil.parseInt(user.getUmOrgan()));
			
			String to = user.getWorkEmail();
			
//			System.out.println("=========================="+to1+"=====================");
//			String to = "zhangch003@ulic.com.cn";
            String subject = "您的新问卷："+survey.getName()+"";
            
            String root = ConfigManager.getString("webURL");
            String url = root + path + "/mission.do?method=jump" +
    				"&userId=" + user.getUmUserId() + 
    				"&missionId=" + mn.getId(); 
    		
    		String mailTips = survey.getMailTips();
    		
    		if(mailTips==null){
    			mailTips = "";
    		}
    		
		    String body =mailTips +
		    			"<span>&nbsp;&nbsp;&nbsp;&nbsp;" +
		    		"请点击：<a href=\"" + url + "\" target=_blank>开始答卷</a> ，及时完成答卷。谢谢！<br><br></span>"+
		    		"<div>&nbsp;&nbsp;&nbsp;&nbsp;" +
		    		"问卷发起人："+fqUser.getRealName()+"("+fqOrgan.getFullName()+")</div>";
			if(to==null||to==""||to==" "){
				noEmail.append(user.getEmpName());
				noEmail.append("(");
				noEmail.append(user.getUserName());
				noEmail.append(")");
				noEmail.append(";");
			}else{
				
				TSendEmail sendEmial = new TSendEmail();
				sendEmial.setSurveyId(surveyId);
				//sendEmial.setEmail("survey@ulic.com.cn");
				sendEmial.setEmail(to);
				sendEmial.setFcd(new Date());
				sendEmial.setFcu(Integer.parseInt(fqUser.getUmUserId()));
				sendEmial.setIfCopySend(0);
				sendEmial.setIfSend(0);
				sendEmial.setMissionId(mn.getId());
				sendEmial.setSendType(0);
				sendEmial.setUserId(Integer.parseInt(user.getUmUserId()));
				surveyDao.saveEntity(sendEmial);
				//UlicSendMail.sendMail(to, subject, body,"");
			}
		}
		
		if(noEmail.length()!=0){
			String to = fqUser.getMail();
			String subject = "在线问卷系统温馨提示";
			String body = noEmail.toString()+"<br>" +
					"以上用户邮箱信息不正确，将无法正常答卷，请尽快与系统管理员联系。";
			
			UlicSendMail.sendMail(to, subject, body,"");
		}
		return noEmail.toString();
	}

	
	
}

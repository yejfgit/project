package com.survey.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.survey.dao.IUserDao;
import com.survey.dao.impl.BaseDao;
import com.survey.service.IUserService;
import com.survey.vo.DispatchUser;
import com.survey.vo.TSvUsers;
import com.survey.vo.TUmUser;
import com.survey.vo.User;
import com.survey.vo.UserContextVO;


public class UserServiceImpl implements IUserService {  
	
	private IUserDao userDao;
	
	private BaseDao baseDao;

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public TUmUser getUmUserByUserId(int userId) {
		return this.userDao.getUmUserByUserId(userId);
	}
	
	public TUmUser getUmUserByUserName(String userName){
		return this.userDao.getUmUserByUserName(userName);
	}
	
	public User getUserById(int id) {
		return this.userDao.getUserById(id);
	}
	
	public User getByUserName(String name){
		return this.userDao.getByUserName(name);
	}

	public User getUserByUserName(String name) {
		return this.userDao.getUserByUserName(name);
	}

	public TUmUser saveUmUser(String userName, String mail) {
		

		
		TUmUser u = new TUmUser();
		u.setUserName(mail.substring(0, mail.indexOf("@")));
		u.setRealName(userName);
		u.setMail(mail);
		u.setUmOrgan("900001");
		u.setUserType(0);
		u.setIsActivie("Y");
		u.setCreateDate(new Date());
		u.setUpdateDate(new Date());
		u = (TUmUser) baseDao.save(u);
		
		return u;
	}

	public List getUserListByUserNameOrRealName(String userName) {
		if (userName == null || userName.equals("")) {
			return new ArrayList();
		}
		
		StringBuffer sb = new StringBuffer(); 
		sb.append("select uu.um_user_id umUserId, uo.um_organ_id umOrgan, " +
				"uu.real_name realName, uu.user_name userName, uo.full_name deptFullName " +
				"from t_um_user uu, t_um_organ uo " +
				"where uu.is_activie = 'Y' " +
				"and uu.um_organ = uo.um_organ_id " +
				"and (uu.user_name like '" + userName + "%' or uu.real_name like '" + userName + "%') " +
				"and uu.um_organ !=900001 " +
				"order by uu.user_name asc ");

		
		final String sql = sb.toString();

		List list = baseDao.getList(sql, TUmUser.class);
		
		return list;
	}

	public UserContextVO login(String userName, String remoteAddress) {
	
	
		// 初始化用户
		User user = userDao.getByUserName(userName);
		
		if (user == null) {
			// 用户不存在
			return null;
		}

		UserContextVO userContext = new UserContextVO();

		userContext.setUser(user);						
		return userContext;

	}

	public DispatchUser getDispatchUserByUmUserId(int userId) {
		// TODO Auto-generated method stub
		return this.userDao.getDispatchUserByUmUserId(userId);
	}

	public List getDisPatchUserListByUserNameOrRealName(String userName) {
		// TODO Auto-generated method stub
		if (userName == null || userName.equals("")) {
			return new ArrayList();
		}
		
		StringBuffer sb = new StringBuffer(); 
		sb.append("select uu.um_user_id umUserId, uo.um_organ_id umOrgan, "+
				"uu.real_name realName, uu.user_name userName, uo.full_name deptFullName, "+
				"s.position_name positionName,s.work_email workEmail,s.empid empId "+
				"from t_um_user uu, t_um_organ uo,t_sv_users s "+
				"where uu.is_activie = 'Y' "+
				"and uu.employee_number = s.empid "+
				"and uu.um_organ = uo.um_organ_id "+
				"and (uu.user_name like '" + userName + "%' or uu.real_name like '" + userName + "%') " +
				"and uu.um_organ !=900001 "+
				"order by uu.user_name asc");

		
		final String sql = sb.toString();

		List list = baseDao.getList(sql, DispatchUser.class);
		
		return list;
	}

	public List getTSvUsersByPositionName(String positionName,int organId) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();	
		sb.append("select t.empid empId,t.emp_name empName,t.position_name positionName,t.deptid deptId "+
				"from t_sv_users t "+
				"where t.deptid in "+
				"(select a.code from ( "+
				"select d.um_organ_id , d.full_name,d.um_org_code code , "+
				"parent_id  "+
				"from t_um_organ d "+ 
				"connect by prior um_organ_id = parent_id start with um_organ_id in ('"+organId+"')) a ) " +
				"and t.position_name like '%"+positionName+"%' "+ 
				"order by nlssort (t.emp_name,'NLS_SORT=SCHINESE_PINYIN_M') asc");
		
		List list = baseDao.getList(sb.toString(), TSvUsers.class);
		return list;
	}
}

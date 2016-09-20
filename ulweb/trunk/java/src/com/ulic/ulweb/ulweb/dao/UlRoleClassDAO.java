package com.ulic.ulweb.ulweb.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ulic.ulweb.frame.dao.BaseDao;
import com.ulic.ulweb.frame.dao.ResultObjectCall;

import com.ulic.ulweb.ulweb.entity.UlRoleClass;

public class UlRoleClassDAO extends BaseDao{
	public void create(UlRoleClass ur) throws SQLException {
		PreparedStatement pstm = this
			.getPreparedStatement("insert into ul_role_class(role_id, role_class, is_admin, column_id, organ_id, user_name) values(?,?,?,?,?,?)");
		pstm.setInt(1, ur.getRoleId());
		pstm.setInt(2, ur.getRoleClass());
		pstm.setInt(3, ur.getIsAdmin());
		pstm.setString(4, ur.getColumnId());
		pstm.setString(5, ur.getDept());
		pstm.setString(6, ur.getName());
		this.execute(pstm);
		
	}
	
	public void delete(int id) throws SQLException {
		PreparedStatement pstm = this.getPreparedStatement("delete from ul_role_class where role_id=?");
		pstm.setInt(1,id);
		this.execute(pstm);
	}
	
	public void update(UlRoleClass ur) throws SQLException {
		PreparedStatement pstm = this
			.getPreparedStatement("update ul_role_class set role_class=?, is_admin=?, column_id=?, organ_id = ?, user_name = ? where role_id=?");
		pstm.setInt(1, ur.getRoleClass());
		pstm.setInt(2, ur.getIsAdmin());
		pstm.setString(3, ur.getColumnId());
		pstm.setInt(6, ur.getRoleId());
		pstm.setString(4, ur.getDept());
		pstm.setString(5, ur.getName());
		this.execute(pstm);
	}
	
	public UlRoleClass getById(int id) throws SQLException {
		PreparedStatement pstm = this
			.getPreparedStatement("SELECT * FROM ul_role_class WHERE role_id=?");
			pstm.setInt(1, id);
			return (UlRoleClass) this.getObject(pstm, new ResultObjectCall() {
				public Object getResultObject(ResultSet rs) throws SQLException {
					UlRoleClass ur = new UlRoleClass();
					ur.setRoleId(rs.getInt("role_id"));
					ur.setRoleClass(rs.getInt("role_class"));
					ur.setIsAdmin(rs.getInt("is_admin"));
					ur.setColumnId(rs.getString("column_id"));
					ur.setDept(rs.getString("organ_id"));
					ur.setName(rs.getString("user_name"));
					return ur;
				}
			});
	}
	
	public int getUserRoleMaxClass(String strRoleid) throws SQLException {	
		PreparedStatement pstm = this
			.getPreparedStatement("SELECT max(role_class) FROM ul_role_class WHERE role_id in (" + strRoleid + ")");
	
		int i = this.getNumericalValue(pstm);	
		if(i == 0){
			return 1;
		}else{
			return i;
		}
		
	}
	
	public int getUserAdminClass(String strRoleid) throws SQLException {	
		
		PreparedStatement pstm = this
			.getPreparedStatement("SELECT max(is_admin) FROM ul_role_class WHERE role_id in (" + strRoleid + ")");
		return this.getNumericalValue(pstm);
		
	}
	
	public int getUserAdminClass(int roleId) throws SQLException {
		PreparedStatement pstm = this
		.getPreparedStatement("SELECT is_admin FROM ul_role_class WHERE role_id = ? ");
		pstm.setInt(1, roleId);
	return this.getNumericalValue(pstm);
	}
	
	
	public String getUserRightColumn(String strRoleid) throws SQLException {
	
		
		PreparedStatement pstm = this
			.getPreparedStatement("SELECT column_id FROM ul_role_class WHERE role_id in (" + strRoleid + ")");
		return (String) this.getObject(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {
				StringBuffer sb = new StringBuffer();
				if(rs.next()){
					sb.append(rs.getString(1));
				}
				while(rs.next()) {
					sb.append(rs.getString(1));				
				}
				return sb.toString();
			}
		});
	}
	
	public String getUserRightColumn(int roleId) throws SQLException{
	
		PreparedStatement pstm = this
		.getPreparedStatement("SELECT column_id FROM ul_role_class WHERE role_id = ?");
		pstm.setInt(1, roleId);
		return this.getStringValue(pstm);
	}
	
	public List getRoleList() throws SQLException{
		PreparedStatement pstm = this
		.getPreparedStatement("select * from ul_role_class r, ul_organ o where r.organ_id = o.organ_id(+) order by role_id");
		return this.executeQuery(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {
				UlRoleClass rc = new UlRoleClass();
				rc.setName(rs.getString("user_name"));
				rc.setRoleId(rs.getInt("role_id"));
				rc.setRoleClass(rs.getInt("role_class"));
				rc.setIsAdmin(rs.getInt("is_admin"));
				rc.setColumnId(rs.getString("column_id"));
				rc.setDept(rs.getString("organ_name"));
				return rc;
			}
		});
	}
	
	public String getUserDept(int roleId) throws SQLException{
		PreparedStatement pstm = this
			.getPreparedStatement("SELECT organ_id FROM ul_role_class WHERE role_id = ?");
		pstm.setInt(1, roleId);
		return this.getStringValue(pstm);
	}
	
	public UlRoleClass getAdminAllInfo(int roleId) throws SQLException{
		UlRoleClass r = null;
		PreparedStatement pstm = this
			.getPreparedStatement("SELECT r.*, o.organ_name  FROM ul_role_class r, ul_organ o WHERE role_id = ? and r.organ_id = o.organ_id");
		pstm.setInt(1, roleId);
		r = (UlRoleClass) this.getObject(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {
				UlRoleClass ur = new UlRoleClass();
				ur.setRoleId(rs.getInt("role_id"));
				ur.setRoleClass(rs.getInt("role_class"));
				ur.setIsAdmin(rs.getInt("is_admin"));
				ur.setColumnId(rs.getString("column_id"));
				ur.setDept(rs.getString("organ_name"));
				ur.setName(rs.getString("user_name"));
				return ur;
			}
		});		
		return r;
	}
}


















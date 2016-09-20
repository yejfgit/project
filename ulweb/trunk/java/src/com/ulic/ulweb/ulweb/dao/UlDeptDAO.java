package com.ulic.ulweb.ulweb.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ulic.ulweb.frame.dao.BaseDao;
import com.ulic.ulweb.frame.dao.ResultObjectCall;
import com.ulic.ulweb.ulweb.entity.UlDept;

public class UlDeptDAO extends BaseDao{
	public void create(UlDept d) throws SQLException{
		PreparedStatement pstm = this.getPreparedStatement("insert into ul_organ(organ_id, organ_name, organ_model) values(?,?,?)");
		pstm.setString(1,d.getDeptId());
		pstm.setString(2,d.getDeptName());
		pstm.setInt(3,d.getDeptModel());
		this.execute(pstm);
	}
	
	public void delete(String id) throws SQLException{
		PreparedStatement pstm = this.getPreparedStatement("delete from ul_organ where organ_id = ?");
		pstm.setString(1, id);
		this.execute(pstm);
	}
	
	public int update(UlDept d) throws SQLException{
		PreparedStatement pstm = this.getPreparedStatement("update ul_organ set organ_name = ?, organ_model = ? where organ_id = ?");
		pstm.setString(1, d.getDeptName());
		pstm.setInt(2, d.getDeptModel());
		pstm.setString(3, d.getDeptId());
		return this.executeUpdate(pstm);
	}
	
	public List getList() throws SQLException{
		PreparedStatement pstm = this.getPreparedStatement("select organ_id, organ_name, organ_model from ul_organ");
		return this.executeQuery(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {					
				UlDept d = new UlDept();
				d.setDeptId(rs.getString(1));
				d.setDeptName(rs.getString(2));
				d.setDeptModel(rs.getInt(3));
				return d;				
			}	
		});
	}
	
	public UlDept getDept(String id) throws SQLException {
		PreparedStatement pstm = this
		.getPreparedStatement("select organ_id, organ_name, organ_model from ul_organ where organ_id = ?");
		pstm.setString(1, id);
		return (UlDept) this.getObject(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {					
				UlDept d = new UlDept();
				d.setDeptId(rs.getString(1));
				d.setDeptName(rs.getString(2));
				d.setDeptModel(rs.getInt(3));
				return d;		
			}
		});
	}
	
}

package com.ulic.ulweb.ulweb.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ulic.ulweb.frame.dao.BaseDao;
import com.ulic.ulweb.frame.dao.ResultObjectCall;
import com.ulic.ulweb.ulweb.entity.UlVoteAdmin;

public class UlVoteAdminDAO extends BaseDao{

	public void add(UlVoteAdmin va) throws SQLException{
		PreparedStatement pstm = this.getPreparedStatement("insert into ul_vote_admin(vote_admin_id,  user_id, is_disable, vote_right, user_name) "
				+ "values(seq_vote_admin_id.nextval, ?,0, ?, ?)");
	
		pstm.setInt(1, va.getUserId());			
		pstm.setInt(2, va.getVoteAdminId());
		pstm.setString(3, va.getUserName());
		this.execute(pstm);
		
	}
	
	public void delete(int id) throws SQLException {
		PreparedStatement pstm = this.getPreparedStatement("delete from ul_vote_admin where vote_admin_id=?");
		pstm.setInt(1,id);
		this.execute(pstm);
	}
	
	public void setDisable(int id) throws SQLException {
		PreparedStatement pstm = this.getPreparedStatement("update ul_vote_admin set is_disable = 1 where vote_admin_id=?");
		pstm.setInt(1,id);
		this.execute(pstm);
	}
	
	public void update(UlVoteAdmin va) throws SQLException {
		PreparedStatement pstm = this.getPreparedStatement("update ul_vote_admin set user_id=?, is_disable=?, vote_right = ?, "
				+ " user_name = ? where vote_admin_id=?");
		pstm.setInt(1, va.getUserId());
		pstm.setInt(2, va.getIsDisable());
		pstm.setInt(3, va.getVoteAdminId());
		pstm.setInt(4, va.getVoteRight());
		pstm.setString(5, va.getUserName());
		this.executeUpdate(pstm);
	}
	
	public UlVoteAdmin getById(int id) throws SQLException {
		PreparedStatement pstm = this.getPreparedStatement("select * from ul_vote_admin where vote_admin_id=?");
		pstm.setInt(1, id);
		return (UlVoteAdmin)this.getObject(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {
				return getva(rs);
			}
		});	
		
	}
	
	public UlVoteAdmin getByUserId(int userId) throws SQLException {
		PreparedStatement pstm = this.getPreparedStatement("select * from ul_vote_admin where user_id=?");
		pstm.setInt(1, userId);
		return (UlVoteAdmin)this.getObject(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {
				return getva(rs);
			}
		});	
		
	}
	
	public List getUserList() throws SQLException{
		PreparedStatement pstm = this
		.getPreparedStatement("SELECT * FROM ul_vote_admin "
				+ " order by upload_time desc");		
		return this.executeQuery(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {
				return getva(rs);
			}
		});
	}
	
	private UlVoteAdmin getva(ResultSet rs) throws SQLException {
		UlVoteAdmin va = new UlVoteAdmin();
		va.setVoteAdminId(rs.getInt("vote_admin_id"));
		va.setUserId(rs.getInt("user_id"));
		va.setInsertTime(rs.getTimestamp("insert_time"));
		va.setIsDisable(rs.getInt("is_disable"));
		va.setVoteRight(rs.getInt("vote_right"));
		va.setUserName(rs.getString("user_name"));
		return va;
		
	}
	
}

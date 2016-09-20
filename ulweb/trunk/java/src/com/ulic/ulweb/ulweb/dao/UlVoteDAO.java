package com.ulic.ulweb.ulweb.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ulic.ulweb.frame.dao.BaseDao;
import com.ulic.ulweb.frame.dao.ResultObjectCall;

import com.ulic.ulweb.ulweb.entity.UlVote;

public class UlVoteDAO extends BaseDao{
	public void create(UlVote uv) throws SQLException {
		PreparedStatement pstm = this
			.getPreparedStatement("insert into ul_vote(vote_id,  vote_title, is_ip_limit, is_invalidate,"
					+ " vote_class, chack_vote_class, vote_admin_id, vote_type) "
					+ "values(seq_vote_id.nextval, ?,?,?,?,?,?, ?)");
	
		pstm.setString(1, uv.getVoteTitle());
		pstm.setInt(2, uv.getIsIpLimit());
		pstm.setInt(3, uv.getIsInvalidate());
		pstm.setInt(4, uv.getVoteClass());
		pstm.setInt(5, uv.getChackVoteClass());
		pstm.setInt(6, uv.getVoteAdminId());
		pstm.setInt(7, uv.getVoteType());
			
		this.execute(pstm);
		
	}
	
	public void delete(int id) throws SQLException {
		PreparedStatement pstm = this.getPreparedStatement("delete from ul_vote where vote_id=?");
		pstm.setInt(1,id);
		this.execute(pstm);
	}
	

	public void setInvalidate(int id) throws SQLException {
		PreparedStatement pstm = this.getPreparedStatement("update ul_vote set is_invalidate = 1 where vote_id=?");
		pstm.setInt(1,id);
		this.executeUpdate(pstm);
	}
	
	public void update(UlVote uv) throws SQLException {
		PreparedStatement pstm = this
			.getPreparedStatement("update ul_vote set vote_title=?, is_ip_limit=?, is_invalidate=?, "
					+ " vote_class=?, chack_vote_class=?, vote_admin_id=?, vote_type = ? where vote_id=?");
		pstm.setInt(7, uv.getVoteId());
		pstm.setString(1, uv.getVoteTitle());
		pstm.setInt(2, uv.getIsIpLimit());
		pstm.setInt(3, uv.getIsInvalidate());
		pstm.setInt(4, uv.getVoteClass());
		pstm.setInt(5, uv.getChackVoteClass());
		pstm.setInt(6, uv.getVoteType());
		pstm.setInt(7, uv.getVoteAdminId());
		this.executeUpdate(pstm);
	}
	
	public UlVote getById(int id) throws SQLException {
		PreparedStatement pstm = this
			.getPreparedStatement("SELECT * FROM ul_vote WHERE vote_id=?");
			pstm.setInt(1, id);
			return (UlVote) this.getObject(pstm, new ResultObjectCall() {
				public Object getResultObject(ResultSet rs) throws SQLException {
					
					return getVote(rs);
				}
			});
	}
	
	public UlVote getVote(ResultSet rs) throws SQLException{
		UlVote uv = new UlVote();
		uv.setVoteId(rs.getInt("vote_id"));
		uv.setVoteTitle(rs.getString("vote_title"));
		uv.setIsIpLimit(rs.getInt("is_ip_limit"));
		uv.setIsInvalidate(rs.getInt("is_invalidate"));
		uv.setInsertTime(rs.getTimestamp("insert_time"));
		uv.setVoteClass(rs.getInt("vote_class"));
		uv.setChackVoteClass(rs.getInt("chack_vote_class"));
		uv.setVoteAdminId(rs.getInt("vote_admin_id"));
		uv.setVoteType(rs.getInt("vote_type"));
		return uv;
	}
	
	
}

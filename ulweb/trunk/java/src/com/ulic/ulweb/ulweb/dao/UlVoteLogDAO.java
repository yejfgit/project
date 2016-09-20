package com.ulic.ulweb.ulweb.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ulic.ulweb.frame.dao.BaseDao;
import com.ulic.ulweb.frame.dao.ResultObjectCall;

import com.ulic.ulweb.ulweb.entity.UlVoteLog;

public class UlVoteLogDAO extends BaseDao{

	public void add(UlVoteLog uv) throws SQLException{
		PreparedStatement pstm = this.getPreparedStatement("insert into ul_vote_log(vote_log_id, vote_id, ip, vote_user_name) values(seq_vote_log_id.nextval, ?,?,?)");
		
		pstm.setInt(1, uv.getVoteId());
		pstm.setString(2, uv.getIp());
		pstm.setString(3, uv.getVoteUserName());
		this.execute(pstm);
		
		
	}
	
	public void delete(int id) throws SQLException {
		PreparedStatement pstm = this.getPreparedStatement("delete from ul_vote_log where vote_log_id=?");
		pstm.setInt(1,id);
		this.execute(pstm);
	}
	
	public void update(UlVoteLog uv) throws SQLException {
		PreparedStatement pstm = this
			.getPreparedStatement("update ul_vote_log set vote_id=?, ip=?, vote_user_name=? where vote_log_id=?");
		pstm.setInt(1, uv.getVoteId());
		pstm.setString(2, uv.getIp());
		pstm.setString(3, uv.getVoteUserName());
		pstm.setInt(4, uv.getVotelogId());
		this.execute(pstm);
	}
	
	public UlVoteLog getById(int id) throws SQLException {
		PreparedStatement pstm = this.getPreparedStatement("select * from ul_vote_log where vote_log_id=?");
		pstm.setInt(1, id);
		return (UlVoteLog)this.getObject(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {
				UlVoteLog uv = new UlVoteLog();
				uv.setVotelogId(rs.getInt("vote_log_id"));
				uv.setVoteId(rs.getInt("vote_id"));
				uv.setIp(rs.getString("ip"));
				uv.setVoteUserName(rs.getString("vote_user_name"));
				uv.setVoteTime(rs.getTimestamp("vote_time"));
				return uv;
			}
		});
				
	}
		
	
}

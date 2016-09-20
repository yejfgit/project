package com.ulic.ulweb.ulweb.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ulic.ulweb.frame.dao.BaseDao;
import com.ulic.ulweb.frame.dao.ResultObjectCall;

import com.ulic.ulweb.ulweb.entity.UlVoteQuestion;

public class UlVoteQuestionDAO extends BaseDao{
	public void add(UlVoteQuestion uv) throws SQLException{
		PreparedStatement pstm = this.getPreparedStatement("insert into ul_vote_question(question_id, vote_id, question_type, question_name) values(seq_question_id.nextval,?,?,?)");
		pstm.setInt(1, uv.getVoteId());
		pstm.setInt(2, uv.getQuestionType());
		pstm.setString(3, uv.getQuestionName());
		this.execute(pstm);
	
		
	}
	
	public void delete(int id) throws SQLException {
		PreparedStatement pstm = this.getPreparedStatement("delete from ul_vote_question where question_id=?");
		pstm.setInt(1,id);
		this.execute(pstm);
	}
	
	public void update(UlVoteQuestion uv) throws SQLException {
		PreparedStatement pstm = this
			.getPreparedStatement("update ul_vote_question set vote_id=?, question_type=?, question_name=? where question_id=?");
		pstm.setInt(1, uv.getVoteId());
		pstm.setInt(2, uv.getQuestionType());
		pstm.setString(3, uv.getQuestionName());
		pstm.setInt(4, uv.getQuestionId());
		this.execute(pstm);
	}
	
	public UlVoteQuestion getById(int id) throws SQLException {
		PreparedStatement pstm = this.getPreparedStatement("select * from ul_vote_question where question_id=?");
		pstm.setInt(1, id);
		return (UlVoteQuestion)this.getObject(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {
				UlVoteQuestion uv = new UlVoteQuestion();
				uv.setQuestionId(rs.getInt("question_id"));
				uv.setVoteId(rs.getInt("vote_id"));
				uv.setQuestionType(rs.getInt("question_type"));
				uv.setQuestionName(rs.getString("question_name"));
				uv.setInsertTime(rs.getTimestamp("insert_time"));
				return uv;
			}
		});
				
	}
}

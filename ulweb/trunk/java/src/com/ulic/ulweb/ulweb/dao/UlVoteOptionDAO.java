package com.ulic.ulweb.ulweb.dao;

import java.io.StringReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ulic.ulweb.frame.dao.BaseDao;
import com.ulic.ulweb.frame.dao.ResultObjectCall;

import com.ulic.ulweb.ulweb.entity.UlVoteOption;

public class UlVoteOptionDAO extends BaseDao{
	public void add(UlVoteOption uv) throws SQLException{
		PreparedStatement pstm = this
			.getPreparedStatement("insert into ul_vote_option(option_id,  question_id, amount, base_num, option_name, option_content, option_path, option_type) values(seq_option_id.nextval, ?,?,?,?,?,?,?,?)");
		pstm.setInt(1, uv.getQuestionId());
		pstm.setInt(2, uv.getAmount());
		pstm.setInt(3, uv.getBaseMun());
		pstm.setString(4, uv.getOptionName());
//		pstm.setString(5, uv.getOptionContent());
		pstm.setCharacterStream(5,new StringReader(uv.getOptionContent()),uv.getOptionContent().length() );
		pstm.setString(6, uv.getOptionPath());
		pstm.setInt(8, uv.getOptionType());
		this.execute(pstm);
		
		
	}
	
	public void delete(int id) throws SQLException {
		PreparedStatement pstm = this.getPreparedStatement("delete from ul_vote_option where option_id=?");
		pstm.setInt(1,id);
		this.execute(pstm);
	}
	
	public void update(UlVoteOption uv) throws SQLException {
		PreparedStatement pstm = this
			.getPreparedStatement("update ul_vote_option set question_id=?, amount=?, base_num=?, option_name=?, option_content=?, option_path=?, option_type=? where option_id=?");
		pstm.setInt(1, uv.getQuestionId());
		pstm.setInt(2, uv.getAmount());
		pstm.setInt(3, uv.getBaseMun());
		pstm.setString(4, uv.getOptionName());
//		pstm.setString(5, uv.getOptionContent());
		pstm.setCharacterStream(5,new StringReader(uv.getOptionContent()),uv.getOptionContent().length() );
		pstm.setString(6, uv.getOptionPath());
		pstm.setInt(7, uv.getOptionType());
		pstm.setInt(8, uv.getOptionId());
		this.execute(pstm);
	}
	
	public UlVoteOption getById(int id) throws SQLException {
		PreparedStatement pstm = this.getPreparedStatement("select * from ul_vote_log where vote_log_id=?");
		pstm.setInt(1, id);
		return (UlVoteOption)this.getObject(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {
				UlVoteOption uv = new UlVoteOption();
				uv.setOptionId(rs.getInt("option_id"));
				uv.setQuestionId(rs.getInt("question_id"));
				uv.setAmount(rs.getInt("amount"));
				uv.setBaseMun(rs.getInt("base_num"));
				uv.setOptionName(rs.getString("option_name"));
				uv.setOptionContent(rs.getString("option_content"));
				uv.setOptionPath(rs.getString("option_path"));
				uv.setOptionType(rs.getInt("option_type"));
				uv.setInsertTime(rs.getTimestamp("insert_time"));
				return uv;
			}
		});
				
	}
		
}

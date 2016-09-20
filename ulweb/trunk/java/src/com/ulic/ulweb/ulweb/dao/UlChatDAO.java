package com.ulic.ulweb.ulweb.dao;

import java.io.StringReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ulic.ulweb.frame.dao.BaseDao;
import com.ulic.ulweb.frame.dao.ResultObjectCall;
import com.ulic.ulweb.ulweb.entity.UlChat;

public class UlChatDAO extends BaseDao{
	public void save(UlChat c) throws SQLException{
		PreparedStatement pstm = this
			.getPreparedStatement("insert into ul_chat(ip, content, report_time) values(?,?,sysdate)");
		pstm.setString(1, c.getIp());
//		pstm.setString(2, c.getContent());
		pstm.setCharacterStream(2,new StringReader(c.getContent()),c.getContent().length() );
		this.execute(pstm);
		
	}
	
	public List getChatHis(int page, int pageSize) throws SQLException{
		PreparedStatement pstm = this
			.getPreparedStatement("select * from ul_chat order by report_time desc", page, pageSize);
		return this.executeQuery(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {
				UlChat c = new UlChat();
				c.setIp(rs.getString("ip"));
				c.setContent(rs.getString("content"));
				c.setTime(rs.getTimestamp("report_time"));
				return c;
			}
		});
		
	}
}

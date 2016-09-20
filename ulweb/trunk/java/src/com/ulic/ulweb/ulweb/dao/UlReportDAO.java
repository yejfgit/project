package com.ulic.ulweb.ulweb.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ulic.ulweb.frame.dao.BaseDao;
import com.ulic.ulweb.frame.dao.ResultObjectCall;
import com.ulic.ulweb.ulweb.entity.UlReport;

public class UlReportDAO extends BaseDao{
	public void add(UlReport r) throws SQLException {
		PreparedStatement pstm = this
			.getPreparedStatement("insert into ul_report(save_time, ip, personal_amount, group_amount, bank_amount) values(sysdate,?,?,?,?)");
		pstm.setString(1, r.getIp());
		pstm.setInt(2, r.getPersonal());
		pstm.setInt(3, r.getGroup());
		pstm.setInt(4, r.getBank());
		this.execute(pstm);
	}
	
	public List getAllReport() throws SQLException{
		PreparedStatement pstm = this
			.getPreparedStatement("select * from ul_report order by save_time desc",1,50);
		return this.executeQuery(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {				
				UlReport r = new UlReport();
				r.setSaveTime(rs.getTimestamp("save_time"));
				r.setBank(rs.getInt("bank_amount"));
				r.setGroup(rs.getInt("group_amount"));
				r.setPersonal(rs.getInt("personal_amount"));
				return r;				
			}	
		});
	}
	
	public UlReport getReport() throws SQLException{
		PreparedStatement pstm = this
			.getPreparedStatement("select * from ul_report order by save_time desc", 1, 1);
		return (UlReport)this.getObject(pstm, new ResultObjectCall() {
				public Object getResultObject(ResultSet rs) throws SQLException {
					UlReport r = new UlReport();
					r.setSaveTime(rs.getTimestamp("save_time"));
					r.setBank(rs.getInt("bank_amount"));
					r.setGroup(rs.getInt("group_amount"));
					r.setPersonal(rs.getInt("personal_amount"));
					return r;
				}
		});
	}
	
}

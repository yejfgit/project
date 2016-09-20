package com.ulic.ulweb.ulweb.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ulic.ulweb.frame.dao.BaseDao;
import com.ulic.ulweb.frame.dao.ResultObjectCall;
import com.ulic.ulweb.ulweb.entity.UlConfig;
import com.ulic.ulweb.ulweb.entity.UlContent;
import com.ulic.ulweb.ulweb.entity.UlDocumentModel;

public class UtilDAO extends BaseDao{

	public List getConfigList() throws SQLException{
		PreparedStatement pstm = this
			.getPreparedStatement("select config_id, constant_name, column_name, constant_data, ip, "
					+ " to_char(update_time, 'YYMMDD') time, update_user, descript from ul_config order by config_id ");
		
		return this.executeQuery(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {
				UlConfig c = new UlConfig();
				c.setConfigId(rs.getInt("config_id"));
				c.setConstantName(rs.getString("constant_name"));
				c.setColumnName(rs.getString("column_name"));
				c.setConstantData(rs.getString("constant_data"));
				c.setIp(rs.getString("ip"));
				c.setDate(rs.getString("time"));
				c.setUpdateUser(rs.getString("update_user"));
				c.setDesc(rs.getString("descript"));
				return c;
			}
		});
	}
	
	public UlConfig getById(int id) throws SQLException{
		PreparedStatement pstm = this
			.getPreparedStatement("select config_id, constant_name, column_name, constant_data, ip, "
					+ " to_char(update_time, 'YYMMDD') time, update_user, descript from ul_config where config_id = ?");
		pstm.setInt(1, id);
		return (UlConfig) this.getObject(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {
				UlConfig c = new UlConfig();
				c.setConfigId(rs.getInt("config_id"));
				c.setConstantName(rs.getString("constant_name"));
				c.setColumnName(rs.getString("column_name"));
				c.setConstantData(rs.getString("constant_data"));
				c.setIp(rs.getString("ip"));
				c.setDate(rs.getString("time"));
				c.setUpdateUser(rs.getString("update_user"));
				c.setDesc(rs.getString("descript"));
				return c;				
			}
		});
		
	}
	
	public UlConfig getByName(String name) throws SQLException{
		PreparedStatement pstm = this
			.getPreparedStatement("select config_id, constant_name, column_name, constant_data, ip, "
					+ " to_char(update_time, 'YYMMDD') time, update_user, descript from ul_config where constant_name = ?");
		pstm.setString(1, name);
		return (UlConfig) this.getObject(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {
				UlConfig c = new UlConfig();
				c.setConfigId(rs.getInt("config_id"));
				c.setConstantName(rs.getString("constant_name"));
				c.setColumnName(rs.getString("column_name"));
				c.setConstantData(rs.getString("constant_data"));
				c.setIp(rs.getString("ip"));
				c.setDate(rs.getString("time"));
				c.setUpdateUser(rs.getString("update_user"));
				c.setDesc(rs.getString("descript"));
				return c;				
			}
		});
		
	}
	
	public int updateConfig(UlConfig c) throws SQLException{
		PreparedStatement pstm = this
			.getPreparedStatement("update ul_config set column_name = ? , constant_data = ? , ip = ?, "
					+ " update_time = sysdate, update_user = ? , descript = ? where config_id = ?");
		pstm.setString(1, c.getColumnName());
		pstm.setString(2, c.getConstantData());
		pstm.setString(3, c.getIp());
		pstm.setString(4, c.getUpdateUser());
		pstm.setString(5, c.getDesc());
		pstm.setInt(6, c.getConfigId());
		
		return this.executeUpdate(pstm);
	}
	
	public void add(UlConfig c) throws SQLException{
		PreparedStatement pstm = this
			.getPreparedStatement("insert into ul_config values(?,?,?,?,?,sysdate, ?, ?)");
		pstm.setInt(1, c.getConfigId());
		pstm.setString(2, c.getConstantName());
		pstm.setString(3, c.getColumnName());
		pstm.setString(4, c.getConstantData());
		pstm.setString(5, c.getIp());
		pstm.setString(6, c.getUpdateUser());
		pstm.setString(7, c.getDesc());
		this.execute(pstm);
		
	}
	
	public void addDocumentModel(UlDocumentModel d) throws SQLException{
		PreparedStatement pstm = this
			.getPreparedStatement("insert into ul_document_model values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		pstm.setInt(1, d.getId());
		pstm.setString(2, d.getHead());		
		pstm.setString(3, d.getHr1());
		pstm.setString(5, d.getSeal());
		pstm.setString(4, d.getTitle());
		pstm.setString(6, d.getPage2Blank());
		pstm.setString(7, d.getZhutici());
		pstm.setString(8, d.getChaosong());
		pstm.setString(9, d.getDayin());
		pstm.setString(10, d.getGongdayin());
		pstm.setString(11, d.getChengban());
		pstm.setString(12, d.getDianhua());
		pstm.setString(13, d.getGongsi());
		pstm.setString(14, d.getShijian());
		pstm.setString(15, d.getBottom());
		pstm.setString(16, d.getAdd1());
		pstm.setString(17, d.getAdd2());
		pstm.setString(18, d.getAdd3());
		this.execute(pstm);		
	}
	
	public UlDocumentModel getDM(ResultSet r) throws SQLException{
		UlDocumentModel d = new UlDocumentModel();
		d.setId(r.getInt(1));
		d.setHead(r.getString(2));		
		d.setHr1(r.getString(3));
		d.setTitle(r.getString(4));
		d.setSeal(r.getString(5));		
		d.setPage2Blank(r.getString(6));
		d.setZhutici(r.getString(7));
		d.setChaosong(r.getString(8));
		d.setDayin(r.getString(9));
		d.setGongdayin(r.getString(10));
		d.setChengban(r.getString(11));
		d.setDianhua(r.getString(12));
		d.setGongsi(r.getString(13));
		d.setShijian(r.getString(14));
		d.setBottom(r.getString(15));
		d.setAdd1(r.getString(16));
		d.setAdd2(r.getString(17));
		d.setAdd3(r.getString(18));
		return d;
	}
	
	public int editDocumentModle(UlDocumentModel d) throws SQLException{
		PreparedStatement pstm = this
			.getPreparedStatement("update ul_document_model set html_head=?, "
					+ "html_title=?, html_hr1=?, html_seal=?, html_2page_blank=?, "
					+ "html_zhutici=?, html_dayin=?, html_gongdayin=?, html_chengban=?, "
					+ "html_dianhua=?, html_gongsi=?, html_bottom=?, html_add1=?, "
					+ "html_add2=?, html_add3 = ?, html_chaosong = ?, html_shijian = ? where model_id = ?");		
		pstm.setString(1, d.getHead());
		pstm.setString(2, d.getTitle());
		pstm.setString(3, d.getHr1());
		pstm.setString(4, d.getSeal());
		pstm.setString(5, d.getPage2Blank());
		pstm.setString(6, d.getZhutici());
		pstm.setString(7, d.getDayin());
		pstm.setString(8, d.getGongdayin());
		pstm.setString(9, d.getChengban());
		pstm.setString(10, d.getDianhua());
		pstm.setString(11, d.getGongsi());
		pstm.setString(12, d.getBottom());
		pstm.setString(13, d.getAdd1());
		pstm.setString(14, d.getAdd2());
		pstm.setString(15, d.getAdd3());
		pstm.setString(16, d.getChaosong());
		pstm.setString(17, d.getShijian());
		pstm.setInt(18, d.getId());
		return this.executeUpdate(pstm);
	}
	
	public UlDocumentModel getDocumentModelById(int id) throws SQLException{
		PreparedStatement pstm = this
			.getPreparedStatement("select * from ul_document_model where model_id = ?");
		pstm.setInt(1, id);
		return (UlDocumentModel) this.getObject(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {
				return getDM(rs);
			}
		});
	}
	
	public List getDocumentModelList() throws SQLException{
		PreparedStatement pstm = this
			.getPreparedStatement("select model_id from ul_document_model");
		return this.executeQuery(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {
				UlDocumentModel d = new UlDocumentModel();
				d.setId(rs.getInt(1));
				return d;
			}
		});
	}
	
	//080116增加访问统计功能
	public int getCountProcesser(String dept) throws SQLException{
		PreparedStatement pstm = this
			.getPreparedStatement("select seq_count_" + dept + ".nextval from dual");		
		
		return this.getNumericalValue(pstm);
	}
}

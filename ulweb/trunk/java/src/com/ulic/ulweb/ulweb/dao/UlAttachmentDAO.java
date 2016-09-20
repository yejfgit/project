package com.ulic.ulweb.ulweb.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ulic.ulweb.frame.dao.BaseDao;
import com.ulic.ulweb.frame.dao.ResultObjectCall;

import com.ulic.ulweb.ulweb.entity.UlAttachment;


public class UlAttachmentDAO extends BaseDao{
	public void create(UlAttachment att) throws SQLException {
		PreparedStatement pstm = this
			.getPreparedStatement("insert into ul_attachment(attachment_id, attachment_path, is_delete, content_id, show_name, attachment_order, attachment_type) values(seq_attachment_id.nextval, ?,?,?,?,?,?)");
		
		pstm.setString(1, att.getAttachmentPath());
		pstm.setInt(2, att.getIsdelete());
		pstm.setInt(3, att.getContentId());
		pstm.setString(4, att.getShowName());
		pstm.setInt(5, att.getAttachmentOrder());
		pstm.setInt(6, att.getAttachmentType());
		this.execute(pstm);
		
	}
	
	public void delete(int id) throws SQLException {
		PreparedStatement pstm = this.getPreparedStatement("update ul_attachment set is_delete=1 where attachment_id=?");
		pstm.setInt(1,id);
		this.execute(pstm);
	}
	
	public int delete(int id, String oid) throws SQLException{
		PreparedStatement pstm = this.getPreparedStatement("update ul_attachment set is_delete=1 where attachment_id in "
				+ "(select attachment_id from (select attachment_id, ROWNUM rn from ul_attachment where content_id = ? and is_delete = 0 order by attachment_id ) aa where aa.rn in (" + oid + "))");
		pstm.setInt(1, id);
		return this.executeUpdate(pstm);
	}
	
	public void trueDelete(int id) throws SQLException {
		PreparedStatement pstm = this.getPreparedStatement("delete from ul_attachment where attachment_id=?");
		pstm.setInt(1,id);
		this.execute(pstm);
	}
	
	public void update(UlAttachment att) throws SQLException {
		PreparedStatement pstm = this.getPreparedStatement("update ul_attachment set attachment_path=?, is_delete=?, content_id=?, show_name=?, attachment_order=?, attachment_type = ? where attachment_id=?");
		pstm.setString(1, att.getAttachmentPath());
		pstm.setInt(2, att.getIsdelete());
		pstm.setInt(3, att.getContentId());
		pstm.setString(4, att.getShowName());
		pstm.setInt(5, att.getAttachmentOrder());
		pstm.setInt(7, att.getAttachmentId());
		pstm.setInt(6, att.getAttachmentType());
		this.execute(pstm);
	}
	
	public UlAttachment getById(int id) throws SQLException {
		PreparedStatement pstm = this
			.getPreparedStatement("SELECT * FROM ul_attachment WHERE attachment_id=? and is_delete = 0");
			pstm.setInt(1, id);
			return (UlAttachment) this.getObject(pstm, new ResultObjectCall() {
				public Object getResultObject(ResultSet rs) throws SQLException {
					UlAttachment att = new UlAttachment();
					att.setAttachmentId(rs.getInt("attachment_id"));
					att.setAttachmentPath(rs.getString("attachment_path"));
					att.setContentId(rs.getInt("content_id"));				
					att.setShowName(rs.getString("show_name"));
					att.setAttachmentOrder(rs.getInt("attachment_order"));
					att.setAttachmentType(rs.getInt("attachment_type"));
					return att;
				}
			});
	}
	
	public UlAttachment getByContentIdAndOrder(int contentId, int order) throws SQLException {
		PreparedStatement pstm = this
			.getPreparedStatement("SELECT * FROM ul_attachment WHERE content_id=? and  is_delete = 0 order by attachment_order, attachment_id", order, 1);
			pstm.setInt(1, contentId);			
			return (UlAttachment) this.getObject(pstm, new ResultObjectCall() {
				public Object getResultObject(ResultSet rs) throws SQLException {
					UlAttachment att = new UlAttachment();
					att.setAttachmentId(rs.getInt("attachment_id"));
					att.setAttachmentPath(rs.getString("attachment_path"));
					att.setContentId(rs.getInt("content_id"));				
					att.setShowName(rs.getString("show_name"));
					att.setAttachmentOrder(rs.getInt("attachment_order"));
					att.setAttachmentType(rs.getInt("attachment_type"));
					return att;
				}
			});
	}
	
	public List getattachmentByContentId(int id) throws SQLException {
		PreparedStatement pstm = this
			.getPreparedStatement("select attachment_id, attachment_path, content_id, show_name, attachment_order, attachment_type from ul_attachment where content_id = ? and is_delete = 0 order by attachment_order");
		pstm.setInt(1, id);
		return this.executeQuery(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {
				UlAttachment ua = new UlAttachment();
				ua.setAttachmentId(rs.getInt(1));
				ua.setAttachmentPath(rs.getString(2));	
				ua.setContentId(rs.getInt(3));
				ua.setShowName(rs.getString(4));
				ua.setAttachmentOrder(rs.getInt(5));
				ua.setAttachmentType(rs.getInt(6));
				return ua;
			}
		});
		
	}
	
	public UlAttachment getLastAttByColumnId(int columnId) throws SQLException{
		PreparedStatement pstm = this
		.getPreparedStatement("SELECT * FROM ul_attachment WHERE content_id = "
				+ "(select c1.content_id from "
				+ "(select c.content_id, c.ROWNUM rn from ul_content c where c.column_id = ? and c.is_delete = 0 order by c.content_id desc)  c1 "
				+ " where c1.rn < 2 )"
				+ " and is_delete = 0 order by attachment_id desc");
		pstm.setInt(1, columnId);
		return (UlAttachment) this.getObject(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {
				UlAttachment att = new UlAttachment();
				att.setAttachmentId(rs.getInt("attachment_id"));
				att.setAttachmentPath(rs.getString("attachment_path"));
				att.setContentId(rs.getInt("content_id"));				
				att.setShowName(rs.getString("show_name"));
				att.setAttachmentOrder(rs.getInt("attachment_order"));
				att.setAttachmentType(rs.getInt("attachment_type"));
				return att;
			}
		});
	}
	
//	070516增加的用来得到一个内容下最大的attachment_order
	public int getMaxAttachmentOrderByContentId(int contentId) throws SQLException {
		PreparedStatement pstm = this.getPreparedStatement("select max(a.attachment_order) from ul_attachment a where a.content_id = ?");
		pstm.setInt(1,contentId);
		return this.getNumericalValue(pstm);
	}
	
// 070516增加的用来得到内容的附件个数
	public int getAttachmentNumByContentId(int contentId) throws SQLException {
		PreparedStatement pstm = this.getPreparedStatement("select count(*) from ul_attachment a where a.is_delete = 0 and  a.content_id = ? " );
		pstm.setInt(1,contentId);
		return this.getNumericalValue(pstm);
	}
	
	
	
	
	
}

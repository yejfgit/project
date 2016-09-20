package com.ulic.ulweb.ulweb.dao;

import java.io.StringReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ulic.ulweb.frame.dao.BaseDao;
import com.ulic.ulweb.frame.dao.ResultObjectCall;

import com.ulic.ulweb.ulweb.entity.UlAttachment;
import com.ulic.ulweb.ulweb.entity.UlContent;
import com.ulic.ulweb.ulweb.entity.UlContentWithAtt;
import com.ulic.ulweb.ulweb.entity.UlDocument;
import com.ulic.ulweb.ulweb.entity.UlTemplate;

public class UlContentDAO extends BaseDao{

	public int create(UlContent uc) throws SQLException {
		PreparedStatement pstm = this
			.getPreparedStatement("insert into ul_content(content_id, column_id, content_name, content, "
					+ "upload_user, organ_id, is_delete, attachment_sum, key_word, show_others_class, "
					+ "show_organ_class, is_quick_link, have_content, quick_time, on_index, display_type, quick_time_int, sub_title, "
					+ " upload_dept_str) values(seq_content_id.nextval, ?,?,?,?,?,?,?,?,?,?,?,?,"
					+ "(sysdate + " + uc.getQuickTime() + "),?,?,?,?,?)");
		
		pstm.setInt(1, uc.getColumnId());
//		System.out.println("1111    "+uc.getContentName()); 
		pstm.setString(2, uc.getContentName());
		//pstm.setString(3, uc.getContent()); 
		pstm.setCharacterStream(3,new StringReader(uc.getContent()),uc.getContent().length() ) ;

		pstm.setString(4, uc.getUploadUser());
//		pstm.setInt(4, 21);
		pstm.setString(5, uc.getOrganId());
		pstm.setInt(6, uc.getIsDelete());
		pstm.setInt(7, uc.getAttachmentSum());
		pstm.setString(8, uc.getKeyWord());
		pstm.setInt(9, uc.getShowOthersClass());
		pstm.setInt(10, uc.getShowOrganClass());	
		pstm.setInt(11, uc.getIsQuickLink());
		pstm.setInt(12, uc.getHaveContent());
		pstm.setInt(13, uc.getOnIndex());
		pstm.setInt(14, uc.getDisplayType());
		pstm.setInt(15, uc.getQuickTime());
		pstm.setString(16, uc.getSubTitle());
		pstm.setString(17, uc.getUploadDeptStr());
//		pstm.setTimestamp(18,uc.getUploadTime());
		this.execute(pstm);		
		pstm =this.getPreparedStatement("select seq_content_id.currval from dual");
		return this.getNumericalValue(pstm);
	}
	
	
	public int createForMoveData(UlContent uc) throws SQLException {
		PreparedStatement pstm = this
			.getPreparedStatement("insert into ul_content(content_id, column_id, content_name, content, "
					+ "upload_user, organ_id, is_delete, attachment_sum, key_word, show_others_class, "
					+ "show_organ_class, is_quick_link, have_content, quick_time, on_index, display_type, quick_time_int, sub_title, "
					+ " upload_dept_str, upload_time) values(seq_content_id.nextval, ?,?,?,?,?,?,?,?,?,?,?,?,"
					+ "(sysdate + " + uc.getQuickTime() + "),?,?,?,?,?,?)");
		
		pstm.setInt(1, uc.getColumnId());
//		System.out.println("1111    "+uc.getContentName()); 
		pstm.setString(2, uc.getContentName());
		//pstm.setString(3, uc.getContent()); 
		pstm.setCharacterStream(3,new StringReader(uc.getContent()),uc.getContent().length() ) ;

		pstm.setString(4, uc.getUploadUser());
//		pstm.setInt(4, 21);
		pstm.setString(5, uc.getOrganId());
		pstm.setInt(6, uc.getIsDelete());
		pstm.setInt(7, uc.getAttachmentSum());
		pstm.setString(8, uc.getKeyWord());
		pstm.setInt(9, uc.getShowOthersClass());
		pstm.setInt(10, uc.getShowOrganClass());	
		pstm.setInt(11, uc.getIsQuickLink());
		pstm.setInt(12, uc.getHaveContent());
		pstm.setInt(13, uc.getOnIndex());
		pstm.setInt(14, uc.getDisplayType());
		pstm.setInt(15, uc.getQuickTime());
		pstm.setString(16, uc.getSubTitle());
		pstm.setString(17, uc.getUploadDeptStr());
		pstm.setTimestamp(18,uc.getUploadTime());
		
		this.execute(pstm);		
		pstm =this.getPreparedStatement("select seq_content_id.currval from dual");
		return this.getNumericalValue(pstm);
	}
	
	
	public int addContentDocument(UlContent uc) throws SQLException {
		PreparedStatement pstm = this
			.getPreparedStatement("insert into ul_content(content_id, column_id, content_name, content, "
					+ "upload_user, organ_id, is_delete, attachment_sum, key_word, show_others_class, "
					+ "show_organ_class, is_quick_link, have_content, document_num, document_word, upload_dept_str) "
					+ " values(seq_content_id.nextval, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,0)");
		
		pstm.setInt(1, uc.getColumnId());
		pstm.setString(2, uc.getContentName());
//		pstm.setString(3, uc.getContent());
		pstm.setCharacterStream(3,new StringReader(uc.getContent()),uc.getContent().length() );
		pstm.setString(4, uc.getUploadUser());
//		pstm.setInt(4, 21);
		pstm.setString(5, uc.getOrganId());
		pstm.setInt(6, 0);
		pstm.setInt(7, uc.getAttachmentSum());
		pstm.setString(8, uc.getKeyWord());
		pstm.setInt(9, uc.getShowOthersClass());
		pstm.setInt(10, uc.getShowOrganClass());	
		pstm.setInt(11, 0);
		pstm.setInt(12, uc.getHaveContent());
		pstm.setString(13,uc.getDocumentNum());
		pstm.setString(14, uc.getDocumentWord());
		this.execute(pstm);		
		pstm =this.getPreparedStatement("select seq_content_id.currval from dual");
		return this.getNumericalValue(pstm);
	}
	
	
	public void updateAttachmentSum(int contentId, int attachmentSum) throws SQLException{
		PreparedStatement pstm = this
		.getPreparedStatement("update ul_content set attachment_sum=? where content_id=?");
		pstm.setInt(2, contentId);
		pstm.setInt(1, attachmentSum);
		this.executeUpdate(pstm);
	}
	
	public int delete(int id) throws SQLException {
		PreparedStatement pstm = this.getPreparedStatement("select column_id from ul_content where content_id=? and is_delete = 0");
		pstm.setInt(1,id);
		int i = this.getNumericalValue(pstm);
		if(i == 0){
			return 0;
		}
		pstm = this.getPreparedStatement("update ul_content set is_delete = 1 where content_id=?");
		pstm.setInt(1,id);
		this.execute(pstm);
		return i;
	}
	
	public void trueDelete(int id) throws SQLException {
		PreparedStatement pstm = this.getPreparedStatement("delete from ul_content where content_id=?");
		pstm.setInt(1,id);
		this.execute(pstm);
	}
	
	public void deleteListFromTo(int startContentId, int endContentId) throws SQLException{
		PreparedStatement pstm = this.getPreparedStatement("delete from ul_content where display_type = 9 and content_id >= ? and content_id <= ? ");
		pstm.setInt(1,startContentId);
		pstm.setInt(2, endContentId);
		this.execute(pstm);
	}
	
	public void deleteListFrom(int startContentId) throws SQLException{
		PreparedStatement pstm = this.getPreparedStatement("delete from ul_content where display_type = 9 and content_id >= ? ");
		pstm.setInt(1,startContentId);		
		this.execute(pstm);
	}
	
	
	public int update(UlContent uc) throws SQLException {
		PreparedStatement pstm = this.getPreparedStatement("update ul_content set update_time=sysdate, column_id=?, content_name=?, "
				+ "content=?, attachment_sum=?, key_word=?, is_quick_link=?, display_type = ?, have_content = ?, "
				+ "  quick_time = (sysdate + " + uc.getQuickTime() + "), on_index = ?, quick_time_int = ?, sub_title = ?, upload_dept_str = ?"
				+ " where content_id=?");
		pstm.setInt(1, uc.getColumnId());
		pstm.setString(2, uc.getContentName());
//		pstm.setString(3, uc.getContent());
		pstm.setCharacterStream(3,new StringReader(uc.getContent()),uc.getContent().length() );
		pstm.setInt(4, uc.getAttachmentSum());
		pstm.setString(5, uc.getKeyWord());
		pstm.setInt(6,uc.getIsQuickLink());
		pstm.setInt(7, uc.getDisplayType());
		pstm.setInt(8, uc.getHaveContent());
		pstm.setInt(9, uc.getOnIndex());
		pstm.setInt(10, uc.getQuickTime());	
		pstm.setString(11, uc.getSubTitle());
		pstm.setString(12, uc.getUploadDeptStr());
		pstm.setInt(13,uc.getContentId());
		return this.executeUpdate(pstm);
	}
	
	public int updateContentDocument(UlContent uc) throws SQLException {
		PreparedStatement pstm = this.getPreparedStatement("update ul_content set update_time=sysdate,  content_name=?, "
				+ " attachment_sum=?, key_word=?, show_organ_class = ?, show_others_class = ?,  "
				+ " upload_user = ?, document_num = ? , document_word = ?, content = ? "
				+ " where content_id=?");
	
		pstm.setString(1, uc.getContentName());
		pstm.setInt(2, uc.getAttachmentSum());
		pstm.setString(3, uc.getKeyWord());		
		pstm.setInt(4, uc.getShowOrganClass());
		pstm.setInt(5, uc.getShowOthersClass());
		pstm.setString(6, uc.getUploadUser());
		pstm.setString(7, uc.getDocumentNum());
		pstm.setString(8, uc.getDocumentWord());
		pstm.setCharacterStream(9,new StringReader(uc.getContent()),uc.getContent().length() ) ;
		pstm.setInt(10,uc.getContentId());
		return this.executeUpdate(pstm);
	}
	
	public UlContent getById(int id) throws SQLException {
		PreparedStatement pstm = this
			.getPreparedStatement("SELECT t.content_id, t.column_id, "
					+ "t.content_name, t.content, t.upload_time, t.upload_user, t.organ_id, t.is_delete, "
					+ "t.attachment_sum, t.key_word, t.update_time, t.show_others_class, t.show_organ_class, "
					+ "t.is_quick_link, t.document_num, t.document_word, t.quick_time_int, t.have_content, "
					+ "t.on_index, t.display_type, t.sub_title, t.upload_dept_str, c.column_name, c.parent_id, c.column_level "
					+ " FROM ul_content t, ul_column c "
					+ "WHERE content_id=? and t.is_delete = 0 and t.column_id = c.column_id");
			pstm.setInt(1, id);
			return (UlContent) this.getObject(pstm, new ResultObjectCall() {
				public Object getResultObject(ResultSet rs) throws SQLException {
					UlContent uc = new UlContent();
					uc.setContentId(rs.getInt("content_id"));
					uc.setColumnId(rs.getInt("column_id"));
					uc.setContentName(rs.getString("content_name"));
					uc.setContent(rs.getString("content"));
					uc.setUploadTime(rs.getTimestamp("upload_time"));
					uc.setUploadUser(rs.getString("upload_user"));
					uc.setOrganId(rs.getString("organ_id"));
					uc.setIsDelete(rs.getInt("is_delete"));
					uc.setAttachmentSum(rs.getInt("attachment_sum"));
					uc.setKeyWord(rs.getString("key_word"));
					uc.setUpdateTime(rs.getTimestamp("update_time"));
					uc.setShowOthersClass(rs.getInt("show_others_class"));
					uc.setShowOrganClass(rs.getInt("show_organ_class"));
					uc.setIsQuickLink(rs.getInt("is_quick_link"));
					uc.setDocumentNum(rs.getString("document_num"));
					uc.setDocumentWord(rs.getString("document_word"));
					uc.setQuickTime(rs.getInt("quick_time_int"));
					uc.setHaveContent(rs.getInt("have_content"));
					uc.setOnIndex(rs.getInt("on_index"));
					uc.setDisplayType(rs.getInt("display_type"));
					uc.setColumn_name(rs.getString("column_name"));
					uc.setParentId(rs.getInt("parent_id"));
					uc.setColumnLevel(rs.getInt("column_level"));
					uc.setSubTitle(rs.getString("sub_title"));
					uc.setUploadDeptStr(rs.getString("upload_dept_str"));
					
					return uc;
				}
			});
	}
	
	public List getListWithoutContentByCid(int id) throws SQLException {
		PreparedStatement pstm = this
		.getPreparedStatement("SELECT * FROM ul_content "
				+ "WHERE column_id=? and is_delete = 0 order by upload_time desc");
		pstm.setInt(1, id);
		return this.executeQuery(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {
				return getUc(rs);
			}
		});
	}
	
	public List getListWithoutContentByCid(int columnid, int pageNum, int pageSize) throws SQLException {
		PreparedStatement pstm = this
		.getPreparedStatement("SELECT * "
				+ "FROM ul_content WHERE column_id=? and is_delete = 0 order by upload_time desc", pageNum, pageSize);
		pstm.setInt(1, columnid);
		return this.executeQuery(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {
				return getUc(rs);
			}
		});
	}
	
	public List getListByCidUsedDocument(int columnid, int pageSize, int pageNum) throws SQLException {
		PreparedStatement pstm = this
		.getPreparedStatement("SELECT content_id, column_id, content_name,  upload_time, upload_user, organ_id, is_delete, "
				+ "attachment_sum, key_word, update_time, show_others_class, show_organ_class, is_quick_link, "
				+ "document_num, document_word, have_content FROM ul_content "
				+ "WHERE column_id in (select uc.column_id from ul_column uc where parent_id = ?) and is_delete = 0 order by upload_time desc", pageNum, pageSize);
		pstm.setInt(1, columnid);
		return this.executeQuery(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {
				UlContent uc = new UlContent();
				uc.setContentId(rs.getInt(1));
				uc.setColumnId(rs.getInt(2));
				uc.setContentName(rs.getString(3));
				uc.setUploadTime(rs.getTimestamp(4));
				uc.setUploadUser(rs.getString(5));
				uc.setOrganId(rs.getString(6));
				uc.setIsDelete(rs.getInt(7));
				uc.setAttachmentSum(rs.getInt(8));
				uc.setKeyWord(rs.getString(9));
				uc.setUpdateTime(rs.getTimestamp(10));
				uc.setShowOthersClass(rs.getInt(11));
				uc.setShowOrganClass(rs.getInt(12));					
				uc.setIsQuickLink(rs.getInt(13));
				uc.setDocumentNum(rs.getString(14));
				uc.setDocumentWord(rs.getString(15));
				uc.setHaveContent(rs.getInt(16));
				return uc;
				
			}	
		});
			
	}
	
//070606增加的公文的查看用，以columnId来查询	
	public List getListByColumnIdDocument(int columnid, int pageSize, int pageNum) throws SQLException {
		PreparedStatement pstm = this
		.getPreparedStatement("SELECT content_id, column_id, content_name,  upload_time, upload_user, organ_id, is_delete, "
				+ "attachment_sum, key_word, update_time, show_others_class, show_organ_class, is_quick_link, "
				+ "document_num, document_word, have_content FROM ul_content "
				+ "WHERE is_delete = 0 and column_id = ? order by upload_time desc", pageNum, pageSize);
		pstm.setInt(1, columnid);
		return this.executeQuery(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {
				UlContent uc = new UlContent();
				uc.setContentId(rs.getInt(1));
				uc.setColumnId(rs.getInt(2));
				uc.setContentName(rs.getString(3));
				uc.setUploadTime(rs.getTimestamp(4));
				uc.setUploadUser(rs.getString(5));
				uc.setOrganId(rs.getString(6));
				uc.setIsDelete(rs.getInt(7));
				uc.setAttachmentSum(rs.getInt(8));
				uc.setKeyWord(rs.getString(9));
				uc.setUpdateTime(rs.getTimestamp(10));
				uc.setShowOthersClass(rs.getInt(11));
				uc.setShowOrganClass(rs.getInt(12));					
				uc.setIsQuickLink(rs.getInt(13));
				uc.setDocumentNum(rs.getString(14));
				uc.setDocumentWord(rs.getString(15));
				uc.setHaveContent(rs.getInt(16));
				return uc;
				
			}	
		});
			
	}
	
	public List getListByParentColumnIdDocument(int columnid, int pageSize, int days) throws SQLException {
		PreparedStatement pstm = this
		.getPreparedStatement("SELECT content_id, column_id, content_name,  upload_time, upload_user, organ_id, is_delete, "
				+ "attachment_sum, key_word, update_time, show_others_class, show_organ_class, is_quick_link, "
				+ "document_num, document_word, have_content FROM ul_content "
				+ "WHERE is_delete = 0 and column_id in (select column_id from ul_column where " +
				"parent_id = ?) and upload_time >trunc(sysdate - " + days + " )  order by upload_time desc", 1, pageSize);
		pstm.setInt(1, columnid);
		return this.executeQuery(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {
				UlContent uc = new UlContent();
				uc.setContentId(rs.getInt(1));
				uc.setColumnId(rs.getInt(2));
				uc.setContentName(rs.getString(3));
				uc.setUploadTime(rs.getTimestamp(4));
				uc.setUploadUser(rs.getString(5));
				uc.setOrganId(rs.getString(6));
				uc.setIsDelete(rs.getInt(7));
				uc.setAttachmentSum(rs.getInt(8));
				uc.setKeyWord(rs.getString(9));
				uc.setUpdateTime(rs.getTimestamp(10));
				uc.setShowOthersClass(rs.getInt(11));
				uc.setShowOrganClass(rs.getInt(12));					
				uc.setIsQuickLink(rs.getInt(13));
				uc.setDocumentNum(rs.getString(14));
				uc.setDocumentWord(rs.getString(15));
				uc.setHaveContent(rs.getInt(16));
				return uc;
				
			}	
		});
			
	}
	
	
	public List getListWoContentWOrganClassByCid(int columnid, int oClass, int pageSize, int pageNum) throws SQLException {
		PreparedStatement pstm = this
		.getPreparedStatement("SELECT * FROM ul_content "
				+ "WHERE column_id=? and show_organ_class<=? and is_delete = 0 order by upload_time desc", pageNum, pageSize);
		pstm.setInt(1, columnid);
		pstm.setInt(2, oClass);
		return this.executeQuery(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {
				return getUc(rs);
				
			}	
		});
	}
	
	public List getListWoContentWOtherClassByCid(int columnid, int oClass, int pageSize, int pageNum) throws SQLException {
		PreparedStatement pstm = this
		.getPreparedStatement("SELECT * FROM ul_content "
				+ "WHERE column_id=? and show_others_class<=? and is_delete = 0 and is_processing = 0 order by upload_time desc", pageNum, pageSize);
		pstm.setInt(1, columnid);
		pstm.setInt(2, oClass);
		return this.executeQuery(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {
				return getUc(rs);
				
			}	
		});
	}
	
	public List getListWoContentWOrganClassKeyword(int oClass, String keyWord, int columnId, int pageSize, int pageNum) throws SQLException {
		PreparedStatement pstm = this
		.getPreparedStatement("SELECT * FROM ul_content "
				+ "WHERE show_organ_class<=? and key_word = ? and column_id = ? and is_delete = 0 order by upload_time desc", pageNum, pageSize);
		pstm.setInt(1, oClass);
		pstm.setString(2, keyWord);
		pstm.setInt(3, columnId);
		return this.executeQuery(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {
				return getUc(rs);
				
			}	
		});
	}
	
	public List getListWoContentWOtherClassKeyword(int oClass, String keyWord, int columnId, int pageSize, int pageNum) throws SQLException {
		PreparedStatement pstm = this
		.getPreparedStatement("SELECT * "
				+ "FROM ul_content WHERE show_others_class<=? and key_word = ? and column_id = ? and is_delete = 0 order by upload_time desc", pageNum, pageSize);
		pstm.setInt(1, oClass);
		pstm.setString(2, keyWord);
		pstm.setInt(3, columnId);
		return this.executeQuery(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {
				
				return getUc(rs);
				
			}	
		});
	}
		
	
	public UlContent getUc(ResultSet rs) throws SQLException{
		UlContent uc = new UlContent();
		uc.setContentId(rs.getInt("content_id"));
		uc.setColumnId(rs.getInt("column_id"));
		uc.setContentName(rs.getString("content_name"));
		uc.setUploadTime(rs.getTimestamp("upload_time"));
		uc.setUploadUser(rs.getString("upload_user"));
		uc.setOrganId(rs.getString("organ_id"));
		uc.setIsDelete(rs.getInt("is_delete"));
		uc.setAttachmentSum(rs.getInt("attachment_sum"));
		uc.setKeyWord(rs.getString("key_word"));
		uc.setUpdateTime(rs.getTimestamp("update_time"));
		uc.setShowOthersClass(rs.getInt("show_others_class"));
		uc.setShowOrganClass(rs.getInt("show_organ_class"));
		uc.setIsQuickLink(rs.getInt("is_quick_link"));
		uc.setHaveContent(rs.getInt("have_content"));
		uc.setDisplayType(rs.getInt("display_type"));
		uc.setSubTitle(rs.getString("sub_title"));
		uc.setUploadDeptStr(rs.getString("upload_dept_str"));
		uc.setContent("");
		return uc;
	}
	
	public UlContent getUcHaveContent(ResultSet rs) throws SQLException{
		UlContent uc = new UlContent();
		uc.setContentId(rs.getInt("content_id"));
		uc.setColumnId(rs.getInt("column_id"));
		uc.setContentName(rs.getString("content_name"));
		uc.setContent(rs.getString("content"));
		uc.setUploadTime(rs.getTimestamp("upload_time"));
		uc.setUploadUser(rs.getString("upload_user"));
		uc.setOrganId(rs.getString("organ_id"));
		uc.setIsDelete(rs.getInt("is_delete"));
		uc.setAttachmentSum(rs.getInt("attachment_sum"));
		uc.setKeyWord(rs.getString("key_word"));
		uc.setUpdateTime(rs.getTimestamp("update_time"));
		uc.setShowOthersClass(rs.getInt("show_others_class"));
		uc.setShowOrganClass(rs.getInt("show_organ_class"));
		uc.setIsQuickLink(rs.getInt("is_quick_link"));
		uc.setHaveContent(rs.getInt("have_content"));
		uc.setDisplayType(rs.getInt("display_type"));
		uc.setSubTitle(rs.getString("sub_title"));
		uc.setUploadDeptStr(rs.getString("upload_dept_str"));
		
		return uc;
	}
	
	public int getTotlePage(int columnId, int pageSize) throws SQLException{
		PreparedStatement pstm = this.getPreparedStatement("select count(*) from ul_content where column_id=?   and is_delete = 0");
		pstm.setInt(1, columnId);
		int i = this.getNumericalValue(pstm);
		
		return (i == 0 ? 1 : ((i-1)/pageSize + 1));
	}
	
	public int getTotlePageFor2LevelColumn(int columnId, int pageSize) throws SQLException{
		PreparedStatement pstm = this.getPreparedStatement("select count(*) from ul_content "
				+ "where (column_id=? or column_id in (select uc.column_id from ul_column uc where parent_id = ?))  and is_delete = 0");
		pstm.setInt(1, columnId);
		pstm.setInt(2, columnId);
		int i = this.getNumericalValue(pstm);
		
		return (i == 0 ? 1 : ((i -1)/pageSize + 1));
	}
	
	public int getTotleColumn(int columnId) throws SQLException{
		PreparedStatement pstm = this.getPreparedStatement("select count(*) from ul_content where column_id=? and is_delete = 0");
		pstm.setInt(1, columnId);
		int i = this.getNumericalValue(pstm);
		return i;
	}
	
	public int getNewNum(int columnId, int days) throws SQLException{
		PreparedStatement pstm = this.getPreparedStatement("select count(*) from ul_content where column_id in "
				+ "(select column_id from ul_column where parent_id = ? and is_delete = 0) and is_delete = 0 and upload_time > trunc(sysdate - " + days + " ) ");
		pstm.setInt(1, columnId);
		int i = this.getNumericalValue(pstm);
		return i;
	}
	
	public void unSetQuickLinkSingle(int columnId) throws SQLException{
		PreparedStatement pstm = this.getPreparedStatement("update ul_content set on_index = 0 "
				+ "where content_id in (select content_id from ul_content where column_id = ? and on_index = 1 and is_delete = 0)");
		pstm.setInt(1, columnId);
		this.execute(pstm);
	}
	
//首页要显示的内容
	public List getIndexContent(String deptId, int userClass) throws SQLException{
		PreparedStatement pstm = this.getPreparedStatement("SELECT * FROM ul_content "
				+ "WHERE organ_id = ? and show_others_class<=? and is_delete = 0 and on_index = 1 order by column_id ");
		pstm.setString(1, deptId);
		pstm.setInt(2, userClass);
		return this.executeQuery(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {				
				return getUc(rs);				
			}	
		});
	}
	
//得到最新10份上传记录
	public List getByUploadUser(String userName, int page, int pageSize) throws SQLException {
		PreparedStatement pstm = this.getPreparedStatement("select t.content_id, t.column_id, "
				+ "t.content_name, t.content, t.upload_time, t.upload_user, t.organ_id, t.is_delete, "
				+ "t.attachment_sum, t.key_word, t.update_time, t.show_others_class, t.show_organ_class, "
				+ "t.is_quick_link, t.document_num, t.document_word, t.quick_time_int, t.have_content, "
				+ "t.on_index, t.display_type, c.column_name, c.parent_id, c.column_level "
				+ " from ul_content t, ul_column c where t.is_delete = 0 and t.column_id = c.column_id and t.upload_user = ? order by t.upload_time desc", page, pageSize);
		pstm.setString(1, userName);
		return this.executeQuery(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {				
				return getAllC(rs);				
			}	
		});
	}
	
	public UlContent getAllC(ResultSet rs) throws SQLException{
		UlContent uc = new UlContent();
		uc.setContentId(rs.getInt("content_id"));
		uc.setColumnId(rs.getInt("column_id"));
		uc.setContentName(rs.getString("content_name"));
//		uc.setContent(rs.getString("content"));
		uc.setUploadTime(rs.getTimestamp("upload_time"));
		uc.setUploadUser(rs.getString("upload_user"));
		uc.setOrganId(rs.getString("organ_id"));
		uc.setIsDelete(rs.getInt("is_delete"));
		uc.setAttachmentSum(rs.getInt("attachment_sum"));
		uc.setKeyWord(rs.getString("key_word"));
		uc.setUpdateTime(rs.getTimestamp("update_time"));
		uc.setShowOthersClass(rs.getInt("show_others_class"));
		uc.setShowOrganClass(rs.getInt("show_organ_class"));
		uc.setIsQuickLink(rs.getInt("is_quick_link"));
		uc.setDocumentNum(rs.getString("document_num"));
		uc.setDocumentWord(rs.getString("document_word"));
		uc.setQuickTime(rs.getInt("quick_time_int"));
		uc.setHaveContent(rs.getInt("have_content"));
		uc.setOnIndex(rs.getInt("on_index"));
		uc.setDisplayType(rs.getInt("display_type"));
		uc.setColumn_name(rs.getString("column_name"));
		uc.setParentId(rs.getInt("parent_id"));
		uc.setColumnLevel(rs.getInt("column_level"));
		return uc;
	}
	
	public List getCheck(String checkWord, int page, int pageSize) throws SQLException{
		PreparedStatement pstm = this.getPreparedStatement("select * "
				+ "  from ul_content " + checkWord + " order by upload_time desc" , page, pageSize);
			return this.executeQuery(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {				
				return getUc(rs);				
			}	
		});
	}
	
	public int getCheckTotlePage(String checkWord, int pageSize) throws SQLException{
		PreparedStatement pstm = this.getPreparedStatement("select count(*) from ul_content " + checkWord + "order by upload_time desc");
		int i = this.getNumericalValue(pstm);
		return (i == 0 ? 1 : ((i-1)/pageSize + 1));
	}
	
	public void addDocument(UlDocument d) throws SQLException{
		PreparedStatement pstm = this
			.getPreparedStatement("insert into ul_document values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
		pstm.setInt(1, d.getDocumentId());
		pstm.setString(2, d.getDocumentNum());
//		pstm.setString(3, d.getContent());
		pstm.setCharacterStream(3,new StringReader(d.getContent()),d.getContent().length() );
		pstm.setString(4, d.getDate1());
		pstm.setString(5, d.getDocumentWord());
		pstm.setString(6, d.getChaosong());
		pstm.setString(7, d.getDayin());
		pstm.setString(8, d.getGongdayin());
		pstm.setString(9, d.getChengban());
		pstm.setString(10, d.getDianhua());
		pstm.setString(11, d.getGongsi());
		pstm.setString(12, d.getShijian());
		pstm.setString(13, d.getDocumentName());
		this.execute(pstm);		
		
	}
	
	public int updateDocument(UlDocument d) throws SQLException {
		PreparedStatement pstm = this.getPreparedStatement("update ul_document set document_num = ? , content = ?,"
				+ " date1 = ? , document_word = ? , chaosong = ? , dayin = ?, gongdayin = ? , chengban = ? , "
				+ " dianhua = ? , gongsi = ? , shijian = ?, document_name = ? where document_id = ?");
		
		pstm.setString(1,d.getDocumentNum());
//		pstm.setString(2,d.getContent());
		pstm.setCharacterStream(2,new StringReader(d.getContent()),d.getContent().length() );
		pstm.setString(3,d.getDate1());
		pstm.setString(4,d.getDocumentWord());
		pstm.setString(5,d.getChaosong());
		pstm.setString(6,d.getDayin());
		pstm.setString(7,d.getGongdayin());
		pstm.setString(8,d.getChengban());
		pstm.setString(9,d.getDianhua());
		pstm.setString(10,d.getGongsi());
		pstm.setString(11,d.getShijian());		
		pstm.setString(12, d.getDocumentName());
		pstm.setInt(13, d.getDocumentId());
		return this.executeUpdate(pstm);
	}
	
	public UlDocument getDocument(int id) throws SQLException{
		PreparedStatement pstm = this.getPreparedStatement("select * from ul_document where document_id = ?");
		pstm.setInt(1, id);
		return (UlDocument) this.getObject(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {
				UlDocument d = new UlDocument();
				d.setDocumentId(rs.getInt(1));
				d.setDocumentNum(rs.getString(2));
				d.setContent(rs.getString(3));
				d.setDate1(rs.getString(4));
				d.setDocumentWord(rs.getString(5));
				d.setChaosong(rs.getString(6));
				d.setDayin(rs.getString(7));
				d.setGongdayin(rs.getString(8));
				d.setChengban(rs.getString(9));
				d.setDianhua(rs.getString(10));
				d.setGongsi(rs.getString(11));
				d.setShijian(rs.getString(12));		
				d.setDocumentName(rs.getString(13));
				return d;
				
			}	
		});
	}
	
	public UlContent getLastContentInColumnId(int columnId) throws SQLException{
		PreparedStatement pstm = this.getPreparedStatement("select * from ul_content where column_id = ? and is_delete = 0 order by content_id desc", 1 , 1);
		pstm.setInt(1, columnId);
		return (UlContent) this.getObject(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {
				
				return getUcHaveContent(rs);
			}	
		});
			
	}
//071217 修改为只选出一条
	public List getTemplateByColumnId(int columnId, int ptype , String dept) throws SQLException{
		PreparedStatement pstm = this.getPreparedStatement("select * "
				+ "  from ul_template where column_id in ( ? , 99999 ) " 
				+ "and template_ptype = ? and is_delete = 0 and template_dept = ? order by column_id, save_time desc ", 1, 1);
		pstm.setInt(1, columnId);
		pstm.setInt(2, ptype);
		pstm.setString(3, dept);
		return this.executeQuery(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {				
				return getT(rs);				
			}	
		});
		
	}
	
	public List getTemplateListByDeptName(String deptName) throws SQLException{
		PreparedStatement pstm = this.getPreparedStatement("select * "
				+ "  from ul_template where template_dept = ? and is_delete = 0 order by save_time desc ");
		pstm.setString(1, deptName);
		return this.executeQuery(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {				
				return getT(rs);				
			}	
		});
		
	}
	
	public List getTemplateListByDeptName(String deptName, int isDelete) throws SQLException{
		PreparedStatement pstm = this.getPreparedStatement("select * "
				+ "  from ul_template where  is_delete <= ? and template_dept = ?  order by save_time desc ");
		pstm.setString(2, deptName);
		pstm.setInt(1, isDelete);
		return this.executeQuery(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {				
				return getT(rs);				
			}	
		});
		
	}
	
	public UlTemplate getTemplateListByid(int templateId) throws SQLException{
		PreparedStatement pstm = this.getPreparedStatement("select * "
				+ "  from ul_template where template_id = ? ");
		pstm.setInt(1, templateId);
		return (UlTemplate) this.getObject(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {
				return getT(rs);
			}	
		});
		
	}
	
	public void saveTemplate(UlTemplate t) throws SQLException{
		PreparedStatement pstm = this.getPreparedStatement("insert into ul_template values(seq_template_id.nextval, " +
				"?,?,?,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?)");
		pstm.setString(1, t.getTemplateName());
		pstm.setInt(2,t.getTemplatePtype());
		pstm.setInt(3, t.getColumnId());
		pstm.setString(4,t.getTemplateDept());
		pstm.setString(5, t.getTemplateDesc());
		pstm.setString(6, t.getCss());
		pstm.setString(7, t.getUserId());
		pstm.setInt(8, t.getIsDelete());
		pstm.setInt(9, t.getPageSize());
		pstm.setString(10,t.getPic1());
		pstm.setString(11,t.getPic2());
		pstm.setString(12,t.getPic3());
		pstm.setString(13,t.getPic4());
		pstm.setString(14,t.getPic5());
		pstm.setString(15,t.getPic6());
		pstm.setString(16, t.getFlash());
		this.execute(pstm);
		
	}
	
	public int editTemplate(UlTemplate t) throws SQLException{
		PreparedStatement pstm = this.getPreparedStatement("update ul_template set  " +
				"template_name = ?, template_ptype = ?, template_dept = ?, template_desc = ?, css = ?, user_id = ?, " +
				"is_delete = ?, page_size = ?,  pic1 = ?, pic2 = ?, pic3 = ? , " +
				"pic4 = ? , pic5 = ? , pic6 = ? , flash = ? where template_id = ?");
		pstm.setString(1, t.getTemplateName());
		pstm.setInt(2,t.getTemplatePtype());
		pstm.setString(3,t.getTemplateDept());
		pstm.setString(4, t.getTemplateDesc());
		pstm.setString(5, t.getCss());
		pstm.setString(6, t.getUserId());
		pstm.setInt(7, t.getIsDelete());
		pstm.setInt(8, t.getPageSize());
		pstm.setString(9,t.getPic1());
		pstm.setString(10,t.getPic2());
		pstm.setString(11,t.getPic3());
		pstm.setString(12,t.getPic4());
		pstm.setString(13,t.getPic5());
		pstm.setString(14,t.getPic6());
		pstm.setString(15, t.getFlash());
		pstm.setInt(16, t.getTemplateId());
		return this.executeUpdate(pstm);
	}
	
	public void deleteTemplate(int templateId, int isDelete) throws SQLException{
		PreparedStatement pstm = this.getPreparedStatement("update ul_template set is_delete = ? where template_id = ?");
		pstm.setInt(1, isDelete);
		pstm.setInt(2, templateId);
		this.executeUpdate(pstm);
	}
	
	public UlTemplate getT(ResultSet rs) throws SQLException{
		UlTemplate t = new UlTemplate();	
		t.setTemplateId(rs.getInt("template_id"));
		t.setTemplateName(rs.getString("template_name"));
		t.setTemplatePtype(rs.getInt("template_ptype"));
		t.setColumnId(rs.getInt("column_id"));
		t.setTemplateDept(rs.getString("template_dept"));
		t.setTemplateDesc(rs.getString("template_desc"));	
		t.setCss(rs.getString("css"));
		t.setSaveTime(rs.getTimestamp("save_time"));
		t.setUserId(rs.getString("user_id"));
		t.setIsDelete(rs.getInt("is_delete"));
		t.setPageSize(rs.getInt("page_size"));
		t.setPic1(rs.getString("pic1"));
		t.setPic2(rs.getString("pic2"));
		t.setPic3(rs.getString("pic3"));
		t.setPic4(rs.getString("pic4"));
		t.setPic5(rs.getString("pic5"));
		t.setPic6(rs.getString("pic6"));
		t.setFlash(rs.getString("flash"));
			
		return t;
		
	}
	
	
	

//	070511增加的得到带有附件的内容列表
	/*废弃不用的
		public List getContentListWithAtt(int columnId, int pageSize, int pageNum) throws SQLException {
			int max, min;
			min = (pageNum - 1) * pageSize;
			max = pageNum * pageSize;
			PreparedStatement pstm = this
			.getPreparedStatement("select c.*, a.attachment_path, a.show_name, a.attachment_order from ul_content c, " +
					"ul_attachment a where c.content_id in (select t3.content_id from " +
					"(select t2.*, rownum as rn from (select t1.content_id from  ul_content t1 " +
					"where t1.column_id = ? and t1.is_delete = 0  order by t1.content_id desc) t2  where rownum <= ? ) t3 " +
					"where t3.rn > ? ) and a.content_id(+) = c.content_id " +
					"order by c.upload_time desc , a.attachment_order");
			pstm.setInt(1, columnId);
			pstm.setInt(2, max);
			pstm.setInt(3, min);
			
			List list = new ArrayList();
			ResultSet rs = null;
			
			UlContent c = null;
			try {
				rs = pstm.executeQuery();
				while (rs.next()) {
					if(c != null ){
						if(rs.getInt("content_id") != c.getContentId()){
							list.add(c);
							
						}else{
							
						}
					}
					
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				throw e;
			}
			finally {
				if (pstm != null) {
					try {
						pstm.close();
					}
					catch (SQLException e) {
						System.out.println(e.toString());
					}
				}
				if (rs != null) {
					try {
						rs.close();
					}
					catch (SQLException e) {
						System.out.println(e.toString());
					}
				}
			}
			return list;
		}
		
*/			
		
		private UlAttachment getAtt(ResultSet rs) throws SQLException{
			UlAttachment a = new UlAttachment();
			a.setContentId(rs.getInt("content_id"));
			a.setAttachmentPath(rs.getString("attachment_path"));
			a.setShowName(rs.getString("show_name"));
			a.setAttachmentOrder(rs.getInt("attachment_order"));
			return a;
		}
		

		public List<UlContentWithAtt> getContentListWithAtt(int columnId, int isNeedContent, int pageSize, int pageNum) throws SQLException {
//	为了减少运算次数，此处为以ID来排序
			PreparedStatement pstm = this.getPreparedStatement("SELECT * "
					+ "FROM ul_content WHERE column_id=? and is_delete = 0 order by content_id desc", pageNum, pageSize);
			pstm.setInt(1, columnId);
			StringBuffer sb = new StringBuffer();
			List<UlContentWithAtt> listc =  null;
			if(isNeedContent == 1){
				 listc =  this.executeQuery(pstm, new ResultObjectCall() {
						public Object getResultObject(ResultSet rs) throws SQLException {
							return getcAndContentAnda(rs);
						}
					});
			}else{
				 listc =  this.executeQuery(pstm, new ResultObjectCall() {
						public Object getResultObject(ResultSet rs) throws SQLException {
							return getcAnda(rs);
						}
					});
			}
			
			for(int i = 0 ; i < (listc == null ? 0 : listc.size()); i++){
				sb.append(listc.get(i).getContentId() + ", ");
			}
			pstm = this.getPreparedStatement("SELECT content_id, attachment_path, show_name, attachment_order "
					+ "FROM ul_attachment WHERE content_id in (" + sb.toString() + " 0) and is_delete = 0 " 
					+ "order by content_id desc, attachment_order ");
			List<UlAttachment> lista =  this.executeQuery(pstm, new ResultObjectCall() {
											public Object getResultObject(ResultSet rs) throws SQLException {
												return getAtt(rs);
											}
										});
//	t用来记录lista里的第几个被加到listc里了		 
			int t = 0 ;
			for(int j = 0 ; j < (listc == null ? 0 : listc.size()); j++){
				for(int k = t ; k < (lista == null ? 0 : lista.size()) ; k++){
					if(listc.get(j).getContentId() == lista.get(k).getContentId()){
						listc.get(j).addAtt(lista.get(k));
						t++;
					}else{
						break;
					}
				}
			}
			
			return listc;		
		}
		
		private UlContentWithAtt getcAndContentAnda(ResultSet rs) throws SQLException{
			UlContentWithAtt uc = new UlContentWithAtt();
//把content放在前面
			uc.setContent(rs.getString("content"));
			uc.setContentId(rs.getInt("content_id"));
			uc.setColumnId(rs.getInt("column_id"));
			uc.setContentName(rs.getString("content_name"));
			uc.setUploadTime(rs.getTimestamp("upload_time"));
			uc.setUploadUser(rs.getString("upload_user"));
			uc.setOrganId(rs.getString("organ_id"));
			uc.setIsDelete(rs.getInt("is_delete"));
			uc.setAttachmentSum(rs.getInt("attachment_sum"));
			uc.setKeyWord(rs.getString("key_word"));
			uc.setUpdateTime(rs.getTimestamp("update_time"));
			uc.setShowOthersClass(rs.getInt("show_others_class"));
			uc.setShowOrganClass(rs.getInt("show_organ_class"));
			uc.setIsQuickLink(rs.getInt("is_quick_link"));
			uc.setHaveContent(rs.getInt("have_content"));
			uc.setSubTitle(rs.getString("sub_title"));
			uc.setUploadDeptStr(rs.getString("upload_dept_str"));
			
			return uc;
		}
		
		private UlContentWithAtt getcAnda(ResultSet rs) throws SQLException{
			UlContentWithAtt uc = new UlContentWithAtt();
			uc.setContentId(rs.getInt("content_id"));
			uc.setColumnId(rs.getInt("column_id"));
			uc.setContentName(rs.getString("content_name"));
			uc.setUploadTime(rs.getTimestamp("upload_time"));
			uc.setUploadUser(rs.getString("upload_user"));
			uc.setOrganId(rs.getString("organ_id"));
			uc.setIsDelete(rs.getInt("is_delete"));
			uc.setAttachmentSum(rs.getInt("attachment_sum"));
			uc.setKeyWord(rs.getString("key_word"));
			uc.setUpdateTime(rs.getTimestamp("update_time"));
			uc.setShowOthersClass(rs.getInt("show_others_class"));
			uc.setShowOrganClass(rs.getInt("show_organ_class"));
			uc.setIsQuickLink(rs.getInt("is_quick_link"));
			uc.setHaveContent(rs.getInt("have_content"));
			uc.setSubTitle(rs.getString("sub_title"));
			uc.setUploadDeptStr(rs.getString("upload_dept_str"));
			uc.setContent("");
			return uc;
		}
		
//		070514增加的得到带有内容的内容列表	
		public List getListWithContentByCid(int columnid, int pageNum, int pageSize) throws SQLException {
			PreparedStatement pstm = this
			.getPreparedStatement("SELECT * "
					+ "FROM ul_content WHERE column_id=? and is_delete = 0 order by upload_time desc", pageNum, pageSize);
			pstm.setInt(1, columnid);
			return this.executeQuery(pstm, new ResultObjectCall() {
				public Object getResultObject(ResultSet rs) throws SQLException {
					return getUcHaveContent(rs);
				}
			});
		}
		
		
//	 070514增加的查找已删除的内容列表
		public List getListIsDeleted(int columnId, String dept,  int isDelete, int pageNum, int pageSize) throws SQLException {
			
			StringBuffer sb = new StringBuffer();
			if(columnId != 0){
				sb.append(" and column_id = " + columnId);
			}
			if( dept != null){
				sb.append(" and organ_id = '" + dept + "' ");
			}
			
			PreparedStatement pstm = this
			.getPreparedStatement("SELECT * "
					+ "FROM ul_content WHERE is_delete = 1 " + sb.toString() + " order by upload_time desc", pageNum, pageSize);
			
			return this.executeQuery(pstm, new ResultObjectCall() {
				public Object getResultObject(ResultSet rs) throws SQLException {
					return getUc(rs);
				}
			});
		}
		
		
//  070515增加恢复删除文件功能
		public int  cancleDelete(int contentId) throws SQLException {
			PreparedStatement pstm = this.getPreparedStatement("update ul_content set is_delete = 0 where content_id=?");
			pstm.setInt(1,contentId);
			return this.executeUpdate(pstm);
			
		}
	
//	070516增加为部门主页准备的内容列表----有内容的
		public List getListWithContentByCustom(String sqlString, int pageNum, int pageSize) throws SQLException {
			PreparedStatement pstm = this
			.getPreparedStatement(sqlString, pageNum, pageSize);			
			return this.executeQuery(pstm, new ResultObjectCall() {
				public Object getResultObject(ResultSet rs) throws SQLException {
					return getUcHaveContent(rs);
				}
			});
		}
	
//		070516增加为部门主页准备的内容列表----没有内容的
		public List getListByCustom(String sqlString, int pageNum, int pageSize) throws SQLException {
			PreparedStatement pstm = this
			.getPreparedStatement(sqlString, pageNum, pageSize);
			return this.executeQuery(pstm, new ResultObjectCall() {
				public Object getResultObject(ResultSet rs) throws SQLException {
					return getUc(rs);
				}
			});
		}
	
//	070516增加的得到自定义数字的    一般用来统计		
		public int getIntByCustom(String sqlString) throws SQLException {
			PreparedStatement pstm = this.getPreparedStatement(sqlString);
			return this.getNumericalValue(pstm);
		}
	
//	070517增加的用于得到部门的所有在主页快捷位置显示的内容
		public List getQuickLinkByDept(String dept, int pageNum, int pageSize) throws SQLException {
			PreparedStatement pstm = this
			.getPreparedStatement("select * from ul_content c " +
					"where c.is_delete = 0 and  c.quick_time > trunc(sysdate) and c.organ_id = ? " +
					"and c.is_quick_link = 1 order by c.upload_time desc", pageNum, pageSize);
			pstm.setString(1, dept);
			return this.executeQuery(pstm, new ResultObjectCall() {
				public Object getResultObject(ResultSet rs) throws SQLException {
					return getUc(rs);
				}
			});
		}
	
		
//		080304 增加直接选取前几个的和最近几天的。
			public List getContentByNearDayIndept(String dept, int day , int pageSize) throws SQLException{
				PreparedStatement pstm = this
				.getPreparedStatement("select * from ul_content c " +
						"where c.is_delete = 0 and  c.organ_id = ?   " +
						"and c.upload_time > trunc(sysdate - ? ) order by c.upload_time desc", 1, pageSize);
				pstm.setString(1, dept);
				pstm.setInt(2, day);
				return this.executeQuery(pstm, new ResultObjectCall() {
					public Object getResultObject(ResultSet rs) throws SQLException {
						return getUc(rs);
					}
				});
			}
			
			public List getContentByDeptId(String dept, int pageNum, int pageSize) throws SQLException{
				PreparedStatement pstm = this
				.getPreparedStatement("select * from ul_content c " +
						"where c.is_delete = 0 and  c.organ_id = ?   " +
						" order by c.upload_time desc", pageNum, pageSize);
				pstm.setString(1, dept);
				return this.executeQuery(pstm, new ResultObjectCall() {
					public Object getResultObject(ResultSet rs) throws SQLException {
						return getUc(rs);
					}
				});
			}	
			public int getTotlePageByDept(String dept, int pageSize) throws SQLException{
				PreparedStatement pstm = this.getPreparedStatement("select count(*) from ul_content where organ_id=?   and is_delete = 0");
				pstm.setString(1, dept);
				int i = this.getNumericalValue(pstm);
				
				return (i == 0 ? 1 : ((i-1)/pageSize + 1));
			}


			public List getListByOrganId(String dept_name,int num) throws SQLException {
				PreparedStatement pstm = this
				.getPreparedStatement("select * "+
						"from "+ 
						"(select * "+
						"		from ul_content c where c.is_delete = 0 "+
						"		and c.column_id in "+
						"		(select t.column_id from ul_column t where t.organ_id like '%"+dept_name+"%' and t.is_delete = 0) "+
						"order by c.upload_time desc ) a where rownum <= " + num);
	
				return this.executeQuery(pstm, new ResultObjectCall() {
					public Object getResultObject(ResultSet rs) throws SQLException {
						return getUc(rs);
					}
				});
			}
	
	
	
	
	
	
	
	
}

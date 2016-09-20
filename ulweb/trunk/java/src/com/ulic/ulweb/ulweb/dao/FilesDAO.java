package com.ulic.ulweb.ulweb.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.ulic.ulweb.frame.dao.BaseDao;
import com.ulic.ulweb.frame.dao.ResultObjectCall;
import com.ulic.ulweb.ulweb.entity.Attachment;
import com.ulic.ulweb.ulweb.entity.Files;

public class FilesDAO extends BaseDao{
	public List getByColumnId(int cid, int page, int pageSize) throws SQLException{
		PreparedStatement pstm = this
			.getPreparedStatement("select * from files where columnid = ? and used = 1 order by uploadtime desc", page, pageSize);
		pstm.setInt(1, cid);
		return this.executeQuery(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {
				return getFiles(rs);
			}
		});
	}
	
	public int getByColumnIdforPageSum(int cid, int pageSize) throws SQLException{
		PreparedStatement pstm = this
			.getPreparedStatement("select count(*) from files where columnid = ? and used = 1");
		pstm.setInt(1, cid);
		int i = this.getNumericalValue(pstm);
		return (i == 0 ? 1 : (i/pageSize + 1));
		
	}	
	
	public List getByColumnIdAndKeyword(int cid, String keyword, int page, int pageSize) throws SQLException{
		PreparedStatement pstm = this
			.getPreparedStatement("select * from files where columnid = ? and keyword = ? and used = 1 order by uploadtime desc", page, pageSize);
		pstm.setInt(1, cid);
		pstm.setString(2, keyword);
		return this.executeQuery(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {
				return getFiles(rs);
			}
		});
	}
	
	public int getByColumnIdAndKeywordForPageNum(int cid, String keyword, int pageSize) throws SQLException{
		PreparedStatement pstm = this
			.getPreparedStatement("select count(*) from files where columnid = ? and keyword = ? and used = 1");
		pstm.setInt(1, cid);
		pstm.setString(2, keyword);		
		int i = this.getNumericalValue(pstm);
		return (i == 0 ? 1 : (i/pageSize + 1));
	}
	
	public Files getById(int id) throws SQLException{
		PreparedStatement pstm = this
			.getPreparedStatement("select * from files where fileid = ?");
		pstm.setInt(1, id);
		return (Files) this.getObject(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException { 
				return getFile(rs);
			}
		});
			
	}
	
	public Files getCandA1ById(int id) throws SQLException{
		PreparedStatement pstm = this
			.getPreparedStatement("select f.*, a.att_name, a.docid from files f, attachments a where f.fileid = ? and f.fileid = a.fileid(+) order by a.docid", 1,1);
		pstm.setInt(1, id);
		return (Files) this.getObject(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException { 				
				return getFilesAndAttachment(rs);
			}
		});
			
	}
	
	public Attachment getByContentId(int contentId ,int docno) throws SQLException{
		PreparedStatement pstm = this
			.getPreparedStatement("select * from attachments where fileid = ? and used = 1 order by docid", (docno + 1), 1);
		pstm.setInt(1,contentId);
		return (Attachment) this.getObject(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException { 
				return getAttachment(rs);
			}
		});
	}
	
	public Attachment getAttachmentForMoveDataByContentId(int contentId ,int docno) throws SQLException{
		PreparedStatement pstm = this
			.getPreparedStatement("select * from attachments where fileid = ? and used = 1  order by docid", (docno + 1), 1);
		pstm.setInt(1,contentId);
		return (Attachment) this.getObject(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException { 
				return getAttachment(rs);
			}
		});
	}
	
	public Files getFiles(ResultSet rs) throws SQLException{
		Files f = new Files();
		f.setFileid(rs.getInt("fileid"));
		f.setTitle(rs.getString("title"));
		f.setColumnid(rs.getInt("columnid"));
		f.setUploaduser(rs.getString("uploaduser"));
		f.setUploadtime(rs.getTimestamp("uploadtime"));		
		if(rs.getString("content") == null){
			f.setHaveContent(0);
		}else{
			f.setHaveContent(1);
		}		
		f.setUsed(1);
		f.setDocno(rs.getInt("docno"));
		f.setKeyword(rs.getString("keyword"));
		return f;
	}
	
	public Files getFile(ResultSet rs) throws SQLException{
		Files f = new Files();
		f.setFileid(rs.getInt("fileid"));
		f.setTitle(rs.getString("title"));
		f.setColumnid(rs.getInt("columnid"));
		f.setUploaduser(rs.getString("uploaduser"));
		f.setUploadtime(rs.getTimestamp("uploadtime"));	
		f.setContent(rs.getString("content"));
		f.setUsed(1);
		f.setDocno(rs.getInt("docno"));
		f.setKeyword(rs.getString("keyword"));
		return f;
	}
	
	public Files getFilesAndAttachment(ResultSet rs) throws SQLException{
		Files f = new Files();
		f.setFileid(rs.getInt("fileid"));
		f.setTitle(rs.getString("title"));
		f.setColumnid(rs.getInt("columnid"));
		f.setUploaduser(rs.getString("uploaduser"));
		f.setUploadtime(rs.getTimestamp("uploadtime"));
		f.setContent(rs.getString("content"));
		f.setUsed(1);
		f.setDocno(rs.getInt("docno"));
		f.setKeyword(rs.getString("keyword"));
		f.setAttName(rs.getString("att_name"));
		f.setDocid(rs.getInt("docid"));		
		return f;
	}
	
	public Attachment getAttachment(ResultSet rs) throws SQLException{
		Attachment a = new Attachment();
		a.setAttName(rs.getString("att_name"));
		a.setAused(rs.getInt("used"));
		a.setFileid(rs.getInt("fileid"));
		a.setRealName(rs.getString("real_name"));
		a.setDocid(rs.getInt("docid"));
		return a;
	}
	
	
	public List getContentIdForMoveData(String condition, int pageSize, Timestamp startTime) throws SQLException{
		PreparedStatement pstm = this
			.getPreparedStatement("select fileid, uploadtime from files where used = 1 and uploadtime > ?  " + condition + " order by uploadtime", 1, pageSize);
		pstm.setTimestamp(1, startTime);
		System.out.println("--" + startTime.toString() + "--" + condition);
		return this.executeQuery(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {
			
				return rs.getInt("fileid");
			}
		});
	}
	
}

	
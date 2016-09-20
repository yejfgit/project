package com.ulic.ulweb.ulweb.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ulic.ulweb.frame.constant.Constant;
import com.ulic.ulweb.frame.dao.BaseDao;
import com.ulic.ulweb.frame.dao.ResultObjectCall;

import com.ulic.ulweb.ulweb.entity.UlColumn;

public class UlColumnDAO extends BaseDao{
	public void create(UlColumn uc) throws SQLException {
		PreparedStatement pstm = this
			.getPreparedStatement("insert into ul_column(column_id, column_name, organ_id, " +
					"column_level, parent_id, is_delete, include_column, show_to_user, " +
					"include_content, column_order, show_others_class, show_organ_class, open_column, " +
					" column_eid) " +
					"values(seq_column_id.nextval, ?,?,?,?,?,?,?,?,?,?,?,?,?)");
		
		pstm.setString(1, uc.getColumnName());
		pstm.setString(2, uc.getOrganId());
		pstm.setInt(3, uc.getColumnLevel());
		pstm.setInt(4, uc.getParentId());
		pstm.setInt(5, uc.getIsdelete());
		pstm.setInt(6, uc.getIncludeColumn());
		pstm.setInt(7, uc.getShowToUser());
		pstm.setInt(8, uc.getIncludeContent());
		pstm.setInt(9, uc.getColumnOrder());
		pstm.setInt(10, uc.getShowOthersClass());
		pstm.setInt(11, uc.getShowOrganClass());
		pstm.setInt(12, uc.getOpenColumn());
		// save english name
		pstm.setString(13, uc.getColumnEId());
		
		this.execute(pstm);
	
	}
	
	public String delete(int id) throws SQLException {
		PreparedStatement pstm = this.getPreparedStatement("select organ_id from ul_column where column_id=?");
		pstm.setInt(1, id);
		String dept = this.getStringValue(pstm);		
		if(dept == null){
			return "error";
		}else{
			pstm = this.getPreparedStatement("update ul_column set column_name = column_name || '-' || sysdate, is_delete=1 where column_id=?");
			pstm.setInt(1,id);
			this.execute(pstm);
			return dept;
		}
		
	}
	
	
	public void trueDelete(int id) throws SQLException {
		PreparedStatement pstm = this.getPreparedStatement("delete from ul_column where column_id=?");
		pstm.setInt(1,id);
		this.execute(pstm);
	}
	
	public void update(UlColumn uc) throws SQLException {
		PreparedStatement pstm = this.getPreparedStatement("update ul_column set column_name=?, " +
				"organ_id=?, column_level=?, parent_id=?, is_delete=?, include_column=?, show_to_user=?, " +
				"include_content=?, column_order=?, show_others_class=?, show_organ_class=?, open_column=?, column_eid=? where column_id=?");
		
		pstm.setString(1, uc.getColumnName());
		pstm.setString(2, uc.getOrganId());
		pstm.setInt(3, uc.getColumnLevel());
		pstm.setInt(4, uc.getParentId());
		pstm.setInt(5, uc.getIsdelete());
		pstm.setInt(6, uc.getIncludeColumn());
		pstm.setInt(7, uc.getShowToUser());
		pstm.setInt(8, uc.getIncludeContent());
		pstm.setInt(9, uc.getColumnOrder());
		pstm.setInt(10, uc.getShowOthersClass());
		pstm.setInt(11, uc.getShowOrganClass());
		pstm.setInt(12, uc.getOpenColumn());
		pstm.setInt(14, uc.getColumnId());
		// update english name
		//System.out.println("****************eid length:" + uc.getColumnEId().length());
		pstm.setString(13, uc.getColumnEId());
		this.execute(pstm);
	}
	
	public UlColumn getById(int id) throws SQLException {
		PreparedStatement pstm = this
			.getPreparedStatement("SELECT s.column_id, s.column_name, s.organ_id, s.column_level, s.parent_id, s.is_delete, "
					+ " s.include_column, s.show_to_user, s.include_content, s.column_order, s.show_others_class, "
					+ " s.show_organ_class, s.open_column, p.column_name pname, s.column_eid FROM ul_column s, ul_column p WHERE s.column_id=? and s.is_delete = 0 and s.parent_id = p.column_id(+)");
			pstm.setInt(1, id);
			return (UlColumn) this.getObject(pstm, new ResultObjectCall() {
				public Object getResultObject(ResultSet rs) throws SQLException {					
					UlColumn uc = new UlColumn();
					uc.setColumnId(rs.getInt(1));
					uc.setColumnName(rs.getString(2));
					uc.setOrganId(rs.getString(3));
					uc.setColumnLevel(rs.getInt(4));
					uc.setParentId(rs.getInt(5));
					uc.setIsdelete(rs.getInt(6));
					uc.setIncludeColumn(rs.getInt(7));
					uc.setShowToUser(rs.getInt(8));
					uc.setIncludeContent(rs.getInt(9));
					uc.setColumnOrder(rs.getInt(10));
					uc.setShowOthersClass(rs.getInt(11));
					uc.setShowOrganClass(rs.getInt(12));
					uc.setOpenColumn(rs.getInt(13));
					uc.setParentName(rs.getString(14));
					uc.setColumnEId(rs.getString(15));
					return uc;
				}
			});
	}
	
	public UlColumn getByIdForShow(int id) throws SQLException {
		PreparedStatement pstm = this
			.getPreparedStatement("select c.*, d.organ_name, p.column_name pname from ul_column c," +
					" ul_organ d, ul_column p  where c.column_id = ? and c.is_delete = 0 " +
					"and c.organ_id = d.organ_id and c.parent_id = p.column_id(+)");
		pstm.setInt(1, id);
		return (UlColumn) this.getObject(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {	
				UlColumn c = new UlColumn();
				c.setColumnId(rs.getInt("column_id"));
				c.setColumnName(rs.getString("column_name"));
				c.setOrganId(rs.getString("organ_name"));
				c.setColumnLevel(rs.getInt("column_level"));
				c.setIncludeContent(rs.getInt("include_content"));
				c.setParentId(rs.getInt("parent_id"));
				c.setParentName(rs.getString("pname"));		
				c.setShowToUser(rs.getInt("show_to_user"));
				return c;			
			}
		});
	}
	
	/**
	 * get columnId by corresponding english name in column_eid
	 */
	public int getColumnIdByEId(String oId, String eId) throws SQLException {

		PreparedStatement pstm = this
			.getPreparedStatement("select t.column_id from ul_column t " +
					" where t.column_eid = ? " +
							" and t.organ_id = ? ");
		pstm.setString(1, eId);
		pstm.setString(2, oId);
		return this.getNumericalValue(pstm);
	}
	
	public List getListByParentId(int id, String dept) throws SQLException {
		PreparedStatement pstm = this
		.getPreparedStatement("SELECT column_id, column_name, organ_id, column_level, parent_id, is_delete, " +
				"include_column, show_to_user, include_content, column_order, show_others_class, " +
				"show_organ_class, open_column FROM ul_column WHERE parent_id=? and is_delete = 0 " +
				" and organ_id = ? order by column_order,column_id ");
		pstm.setInt(1, id);		
		pstm.setString(2, dept);
		return this.executeQuery(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {				
				return getUlColumn(rs);				
			}	
		});
	}
	
	public List getListByParentIdForShow(int id, String dept, int showToUser) throws SQLException {
		PreparedStatement pstm = this
		.getPreparedStatement("SELECT column_id, column_name, organ_id, column_level, parent_id, is_delete, " +
				"include_column, show_to_user, include_content, column_order, show_others_class, " +
				"show_organ_class, open_column FROM ul_column WHERE parent_id=? and is_delete = 0 and show_to_user >= ?" +
				" and organ_id = ? order by column_order,column_id ");
		pstm.setInt(1, id);		
		pstm.setString(3, dept);
		pstm.setInt(2, showToUser);
		return this.executeQuery(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {				
				return getUlColumn(rs);				
			}	
		});
	}
	
	
	public List getSameLevelListById(int id) throws SQLException {
		PreparedStatement pstm = this
		.getPreparedStatement("SELECT column_id, column_name, organ_id, column_level, parent_id, " +
				"is_delete, include_column, show_to_user, include_content, column_order, " +
				"show_others_class, show_organ_class, open_column "
				+ "FROM ul_column WHERE parent_id=("
				+ "select parent_id from ul_column where column_id = ? and parent_id != 0 " +
						"and is_delete = 0) and include_content = 1 order by column_order ");
		pstm.setInt(1, id);		
		return this.executeQuery(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {				
				return getUlColumn(rs);				
			}	
		});
	}
	
	public List getListWOrganClassByParentId(int id, int oClass) throws SQLException {
		PreparedStatement pstm = this
		.getPreparedStatement("SELECT column_id, column_name, organ_id, column_level, " +
				"parent_id, is_delete, include_column, show_to_user, include_content, column_order, " +
				"show_others_class, show_organ_class, open_column FROM ul_column " +
				"WHERE parent_id= ? and is_delete = 0 and show_organ_class<=? order by column_order,column_id ");
		pstm.setInt(1, id);		
		pstm.setInt(2, oClass);
		return this.executeQuery(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {				
				return getUlColumn(rs);				
			}	
		});
	}
	
	public List getListWOtherClassByParentId(int id, int oClass) throws SQLException {
		PreparedStatement pstm = this
		.getPreparedStatement("SELECT column_id, column_name, organ_id, column_level, parent_id, " +
				"is_delete, include_column, show_to_user, include_content, column_order, " +
				"show_others_class, show_organ_class, open_column FROM ul_column " +
				"WHERE is_delete = 0 and parent_id=? and show_others_class<=? order by column_order,column_id ");
		pstm.setInt(1, id);	
		pstm.setInt(2, oClass);
		return this.executeQuery(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {				
				return getUlColumn(rs);				
			}	
		});
	}
	
	public List getListByColumnIds(String ids) throws SQLException {		
		PreparedStatement pstm = this
		.getPreparedStatement("SELECT column_id, column_name, o.organ_name, column_level, parent_id, is_delete, "
				+ " include_column, show_to_user, include_content, column_order, show_others_class,"
				+ " show_organ_class, open_column FROM ul_column c, ul_organ o WHERE column_id in (" 
				+ ids + ") and c.organ_id = o.organ_id and c.is_delete = 0 order by c.column_order ");
//		pstm.setString(1, ids);
		return this.executeQuery(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {
				return getUlColumn(rs);
			}	
		});
	}
	
	public List getListWCheckByKeyword(String ids, String keyWord) throws SQLException {
		PreparedStatement pstm = this
		.getPreparedStatement("SELECT column_id, column_name, organ_id, column_level, parent_id, " +
				"is_delete, include_column, show_to_user, include_content, column_order, " +
				"show_others_class, show_organ_class, open_column FROM ul_column " +
				"WHERE column_id in (?) and is_delete = 0 and column_name like '%" + keyWord + "%' order by column_order,column_id ");
		pstm.setString(1, ids);
//		pstm.setString(2, keyWord);
		return this.executeQuery(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {
				return getUlColumn(rs);				
			}	
		});
	}
	/*	
	public List getListByColumnLevelAndDept(int columnLevel, String dept) throws SQLException {
		PreparedStatement pstm = this
		.getPreparedStatement("SELECT column_id, column_name, organ_id, column_level,
		 parent_id, is_delete, include_column, show_to_user, include_content, column_order, show_others_class,
		  show_organ_class, open_column FROM ul_column WHERE column_level = ? and organ_id = ? and open_column = 0 
		  and is_delete = 0 and column_id != "
				+ Constant.gongwen + " order by column_order ");
		pstm.setInt(1, columnLevel);
		pstm.setString(2,dept);
		return this.executeQuery(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {
				return getUlColumn(rs);				
			}	
		});
	}
	
	public List getListByDeptForColumn( String dept) throws SQLException {
		PreparedStatement pstm = this
		.getPreparedStatement("SELECT column_id, column_name, organ_id, column_level, parent_id, 
		is_delete, include_column, show_to_user, include_content, column_order, show_others_class,
		 show_organ_class, open_column FROM ul_column WHERE organ_id = ? and open_column = 0 and is_delete = 0 and column_id != "
				+ Constant.gongwen + " order by column_order ");		
		pstm.setString(1,dept);
		return this.executeQuery(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {
				return getUlColumn(rs);				
			}	
		});
	}
*/
	public List getListByColumnLevelAndDept(int columnLevel, String dept, int showToUser) throws SQLException {
		PreparedStatement pstm = this
		.getPreparedStatement("SELECT column_id, column_name, organ_id, column_level, parent_id," +
				" is_delete, include_column, show_to_user, include_content, column_order, " +
				"show_others_class, show_organ_class, open_column FROM ul_column " +
				"WHERE column_level = ? and organ_id = ? and open_column = 0 and is_delete = 0 and show_to_user >= ? "
				+ " order by  column_order,  column_id ");
		pstm.setInt(1, columnLevel);
		pstm.setString(2,dept);
		pstm.setInt(3, showToUser);
		return this.executeQuery(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {
				return getUlColumn(rs);				
			}	
		});
	}
	
	public List getListByDeptForColumn( String dept) throws SQLException {
		PreparedStatement pstm = this
		.getPreparedStatement("SELECT column_id, column_name, organ_id, column_level, parent_id, " +
				"is_delete, include_column, show_to_user, include_content, column_order, show_others_class," +
				" show_organ_class, open_column FROM ul_column WHERE organ_id = ? and open_column = 0 and is_delete = 0  "
				+ " order by include_content, column_order,  column_id ");		
		pstm.setString(1,dept);
		return this.executeQuery(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {
				return getUlColumn(rs);				
			}	
		});
	}	
		
		
	public UlColumn getUlColumn(ResultSet rs) throws SQLException {
		UlColumn uc = new UlColumn();
		uc.setColumnId(rs.getInt(1));
		uc.setColumnName(rs.getString(2));
		uc.setOrganId(rs.getString(3));
		uc.setColumnLevel(rs.getInt(4));
		uc.setParentId(rs.getInt(5));
		uc.setIsdelete(rs.getInt(6));
		uc.setIncludeColumn(rs.getInt(7));
		uc.setShowToUser(rs.getInt(8));
		uc.setIncludeContent(rs.getInt(9));
		uc.setColumnOrder(rs.getInt(10));
		uc.setShowOthersClass(rs.getInt(11));
		uc.setShowOrganClass(rs.getInt(12));
		uc.setOpenColumn(rs.getInt(13));
		return uc;
	}
	
	public int getColumnLevelAndNoSameName(UlColumn c) throws SQLException {
		PreparedStatement pstm = this
		.getPreparedStatement("SELECT * from ul_column where column_name = ? and parent_id = ? and organ_id = ? and is_delete = 0");
		pstm.setString(1, c.getColumnName());
		pstm.setInt(2, c.getParentId());
		pstm.setString(3, c.getOrganId());
		ResultSet rs = pstm.executeQuery();
		if(rs.next()){
			rs.close();
			pstm.close();
			return 0;
		}else{
			rs.close();
			pstm.close();
			if(c.getParentId() == 0) {
				return 1;
			}else{
				pstm = this.getPreparedStatement("select column_level from ul_column where column_id = ?");
				pstm.setInt(1, c.getParentId());
				rs = pstm.executeQuery();
				if(rs.next()){
					int i = rs.getInt(1) + 1;
					rs.close();
					pstm.close();
					return i;
				}else{
					rs.close();
					pstm.close();
					return 9;
				}				
				
			}
			
		}
		
	}
	
	public List getAllListJustUsedRight() throws SQLException{
		PreparedStatement pstm = this
		.getPreparedStatement("select column_id, column_name, parent_id, include_content,organ_id " +
				"from ul_column where is_delete = 0 and open_column = 0 order by organ_id");
		
		return this.executeQuery(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {
				UlColumn c = new UlColumn();
				c.setColumnId(rs.getInt(1));
				c.setColumnName(rs.getString(2));
				c.setParentId(rs.getInt(3));
				c.setIncludeContent(rs.getInt(4));						
				return c;
			}
		});
	}
	
	public List getListForContentByDeptId(String id) throws SQLException{
		PreparedStatement pstm = this
		.getPreparedStatement("select column_id, column_name, parent_id, include_content, column_order from ul_column "
				+ "where organ_id = ? and is_delete = 0 and open_column = 0 and column_id != ? and parent_id != "
				+ "? order by  column_order,  column_id");
		pstm.setString(1, id);
		pstm.setInt(2, Constant.gongwen);
		pstm.setInt(3, Constant.gongwen);
		return this.executeQuery(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {
				UlColumn c = new UlColumn();
				c.setColumnId(rs.getInt(1));
				c.setColumnName(rs.getString(2));
				c.setParentId(rs.getInt(3));	
				c.setIncludeContent(rs.getInt(4));
				return c;
			}
		});
	}
	
	public int getColumnLevelMax3(int columnId) throws SQLException{
		PreparedStatement pstm = this
			.getPreparedStatement("select * from ul_column c where c.column_id = ? or" +
					" c.parent_id = ? or c.parent_id in (select c2.column_id from ul_column" +
					" c2 where c2.parent_id = ?)order by c.column_level desc",1,1);	
		pstm.setInt(1, columnId);
		pstm.setInt(2, columnId);
		pstm.setInt(3, columnId);
		Integer level = (Integer) this.getObject(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {					
				
				return rs.getInt("parent_id") ;
			}
		});
		int levelInt = level.intValue();
		if(levelInt == 0){
			return 1;
		}else if(levelInt == columnId){
			return 2;
		}else{
			return 3;
		}
	
	}

//071108 为查询的类型提供所有栏目	
	public List getListByDeptForColumn( String dept, int isDelete, int showToUser, int includeContent, int openColumn) throws SQLException {
		PreparedStatement pstm = this
		.getPreparedStatement("SELECT column_id, column_name, organ_id, column_level, parent_id, " +
				"is_delete, include_column, show_to_user, include_content, column_order, show_others_class," +
				" show_organ_class, open_column FROM ul_column WHERE organ_id = ? and is_delete = ?" +
				" and show_to_user = ? and include_content = ? and open_column = ?  "
				+ " order by column_level, column_order,  column_id ");		
		pstm.setString(1,dept);
		pstm.setInt(2, isDelete);
		pstm.setInt(3, showToUser);
		pstm.setInt(4, includeContent);
		pstm.setInt(5, openColumn);
		return this.executeQuery(pstm, new ResultObjectCall() {
			public Object getResultObject(ResultSet rs) throws SQLException {
				return getUlColumn(rs);				
			}	
		});
	}	

}

package com.ulic.ulweb.ulweb.service;

import java.sql.SQLException;
import java.util.List;

import com.ulic.ulweb.frame.service.IService;
import com.ulic.ulweb.ulweb.entity.UlColumn;
import com.ulic.ulweb.ulweb.entity.UlContent;
import com.ulic.ulweb.ulweb.entity.UlContentWithAtt;
import com.ulic.ulweb.ulweb.entity.UlDocument;
import com.ulic.ulweb.ulweb.entity.UlRoleClass;
import com.ulic.ulweb.ulweb.entity.UlTemplate;

public interface IUlContentService extends IService{
	public int addContent(UlContent uc) throws Exception;
	public int daleteContent(int id) throws Exception;
	public int updateContent(UlContent uc) throws Exception;
	public UlContent getContentById(int id) throws Exception;
	public List getContentListWithoutContentByColumnId(int id) throws Exception;
	public List getContentByColumnIdDocument(int id, int page, int pageNum) throws Exception;
	public List getContentByColumnId(int id, int pageNum, int pageSize) throws Exception;
	public List getContentByColumnEId(String oId, String eId, int pageNum, int pageSize) throws Exception;
	public List getContentListWoContentWOrganClassByCid(int id, int oClass, int pageSize, int pageNum) throws Exception;
	public List getContentListWoContentWOtherClassByCid(int id, int oClass, int pageSize, int pageNum) throws Exception;
	public List getChackContentWOrganClassByKeyword(int oClass, String keyWord, int columnId, int pageSize, int pageNum) throws Exception;
	public List getChackContentWOtherClassByKeyword(int oClass, String keyWord, int columnId, int pageSize, int pageNum) throws Exception;
	public List getListForContentByDeptId(String deptId) throws Exception;
	public UlRoleClass getUlRoleClassById(int id) throws Exception;
	public String getUserRightColumn(String roleId) throws Exception;
	public String getUserRightColumn(int roleId) throws Exception;
	public List getListByColumnIds(String strColumnId) throws Exception;
	public List getListByColumnLevelAndDept(int level, String deptid, int showToUser) throws Exception;
	public List getColumnListByDeptId(String dept) throws Exception;
	public int getContentTotlePage(int columnId , int pageSize) throws Exception;
	public int getContentTotleListSum(int columnId) throws Exception;
	public void updateAttachmentSum(int contentId, int attachmentSum) throws Exception;
	public int getNewNum(int columnId, int days) throws Exception;
	public void unSetQuickLinkSingle(int columnId) throws Exception;
	public List getIndexContent(String deptId, int userClass) throws Exception;
	public List getByUploadUser(String userName, int page, int pageSize) throws Exception ;
	public List getCheck(String checkWord, int page, int pageSize) throws Exception;
	public int getCheckTotlePage(String checkWord, int pageSize) throws Exception;
	public UlColumn getByIdForShow(int id) throws Exception;
	public List getListByParentId(int id, String dept) throws Exception;
	public List getSameLevelListById(int id) throws Exception;
	public UlDocument getDocument(int id) throws  Exception;
	public int updateDocument(UlDocument d) throws  Exception;
	public void addDocument(UlDocument d) throws  Exception;
	public int addContentDocument(UlContent uc) throws Exception;
	public int updateContentDocument(UlContent uc) throws Exception;
	public int getTotlePageFor2LevelColumn(int columnId, int pageSize) throws Exception;
	public List getTemplateByColumnId(int columnId, int ptype , String dept) throws Exception;
	public List getTemplateListByDeptName(String deptName) throws Exception;
	public UlTemplate getTemplateListByid(int templateId) throws  Exception;
	public void saveTemplate(UlTemplate t) throws Exception;
	public int editTemplate(UlTemplate t) throws  Exception;
	public void deleteTemplate(int templateId, int isDelete) throws Exception;
	public void deleteListFromTo(int startContentId, int endContentId) throws Exception;
	public void deleteListFrom(int startContentId) throws Exception;
	public int createForMoveData(UlContent uc) throws Exception;
	public List getListIsDeleted(int columnId, String dept,  int isDelete, int pageNum, int pageSize) throws Exception;
	public List getListWithContentByCid(int columnid, int pageNum, int pageSize) throws Exception;
	public List<UlContentWithAtt> getContentListWithAtt(int columnId, int isNeedContent, int pageSize, int pageNum) throws Exception;
	public List<UlContentWithAtt> getContentListWithAttByEId(String oId, String eId, int isNeedContent, int pageSize, int pageNum) throws Exception;
	public int  cancleDelete(int contentId) throws Exception; 
	public List getListWithContentByCustom(String sqlString, int pageNum, int pageSize) throws Exception;
	public List getListByCustom(String sqlString, int pageNum, int pageSize) throws Exception;
	public int getIntByCustom(String sqlString) throws Exception;
	public List getQuickLinkByDept(String dept, int pageNum, int pageSize) throws Exception;
	public List getListByColumnIdDocument(int columnid, int pageSize, int pageNum) throws Exception;
	public List getTemplateListByDeptName(String deptName, int isDelete) throws SQLException;
//071101 add 能得到最后一个带内容的条目
	public UlContent getLastContentInColumnId(int columnId) throws Exception;
	public UlContent getLastContentInColumnEId(String oId, String eId) throws Exception;
	
	public List getContentByNearDayIndept(String dept, int day , int pageSize) throws SQLException;
	public List getContentByDeptId(String dept, int pageNum, int pageSize) throws SQLException;
	public int getTotlePageByDept(String dept, int pageSize) throws SQLException;
//080410 add 查最近几天的公文	
	public List getListByParentColumnIdDocument(int columnid, int pageSize, int days) throws SQLException;

/**
 * 查部门主页最新公文
 * @param dept_name
 * @return
 * @throws SQLException 
 */
	public List getListByOrganId(String dept_name,int num) throws SQLException;
	
	public List getContentWithContentStrByColumnId(int gonggao, int i, int j)throws SQLException;
	
}

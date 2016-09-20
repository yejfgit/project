package com.ulic.ulweb.ulweb.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.ulic.ulweb.frame.service.BaseService;
import com.ulic.ulweb.ulweb.dao.UlColumnDAO;
import com.ulic.ulweb.ulweb.dao.UlContentDAO;
import com.ulic.ulweb.ulweb.dao.UlRoleClassDAO;
import com.ulic.ulweb.ulweb.entity.UlColumn;
import com.ulic.ulweb.ulweb.entity.UlContent;
import com.ulic.ulweb.ulweb.entity.UlContentWithAtt;
import com.ulic.ulweb.ulweb.entity.UlDocument;
import com.ulic.ulweb.ulweb.entity.UlRoleClass;
import com.ulic.ulweb.ulweb.entity.UlTemplate;
import com.ulic.ulweb.ulweb.service.IUlContentService;

public class UlContentServiceImpl extends BaseService implements IUlContentService{ 
	private UlContentDAO contentDAO = new UlContentDAO();
	private UlColumnDAO columnDAO =  new UlColumnDAO();
	private UlRoleClassDAO roleClassDAO = new UlRoleClassDAO();
	
	
	public UlContentDAO getContentDAO() {
		return contentDAO;
	}

	public void setContentDAO(UlContentDAO contentDAO) {
		this.contentDAO = contentDAO;
	}

	public int addContent(UlContent uc) throws Exception{
		return contentDAO.create(uc);
	}

	public int daleteContent(int id) throws Exception{
		return contentDAO.delete(id);
	}
	
	public int updateContent(UlContent uc) throws Exception{
		return contentDAO.update(uc);
	}
	
	public UlContent getContentById(int id) throws Exception{
		return contentDAO.getById(id);
	}
	
	public List getContentListWithoutContentByColumnId(int id) throws Exception{
		return contentDAO.getListWithoutContentByCid(id);
	}
	

	public List getContentListWoContentWOrganClassByCid(int id, int oClass, int pageSize, int pageNum) throws Exception {
		// TODO Auto-generated method stub 
		return contentDAO.getListWoContentWOrganClassByCid(id, oClass, pageSize, pageNum); 
	}  
 
	public List getContentListWoContentWOtherClassByCid(int id, int oClass, int pageSize, int pageNum) throws Exception {
		// TODO Auto-generated method stub
		return contentDAO.getListWoContentWOtherClassByCid(id, oClass, pageSize, pageNum);
	}

	public List getChackContentWOrganClassByKeyword(int oClass, String keyWord, int columnId, int pageSize, int pageNum) throws Exception {
		// TODO Auto-generated method stub
		return contentDAO.getListWoContentWOrganClassKeyword(oClass, keyWord, columnId, pageSize, pageNum);
	}

	public List getChackContentWOtherClassByKeyword(int oClass, String keyWord, int columnId, int pageSize, int pageNum) throws Exception {
		// TODO Auto-generated method stub
		return contentDAO.getListWoContentWOtherClassKeyword(oClass, keyWord, columnId, pageSize, pageNum);
	}

	public List getListForContentByDeptId(String deptId) throws Exception {
		// TODO Auto-generated method stub
		return columnDAO.getListForContentByDeptId(deptId);
	}

	public UlRoleClass getUlRoleClassById(int id) throws Exception {
		// TODO Auto-generated method stub
		return roleClassDAO.getById(id);
	}

	public UlColumnDAO getColumnDAO() {
		return columnDAO;
	}

	public void setColumnDAO(UlColumnDAO columnDAO) {
		this.columnDAO = columnDAO;
	}

	public UlRoleClassDAO getRoleClassDAO() {
		return roleClassDAO;
	}

	public void setRoleClassDAO(UlRoleClassDAO roleClassDAO) {
		this.roleClassDAO = roleClassDAO;
	}

	public String getUserRightColumn(String strRoleId) throws Exception {
		// TODO Auto-generated method stub
		return roleClassDAO.getUserRightColumn(strRoleId);
	}
	
	public String getUserRightColumn(int roleId) throws Exception {
		// TODO Auto-generated method stub
		return roleClassDAO.getUserRightColumn(roleId);
	}

	public List getListByColumnIds(String strColumnId) throws Exception {
		// TODO Auto-generated method stub
		return columnDAO.getListByColumnIds(strColumnId);
	}

	public List getListByColumnLevelAndDept(int level, String deptid, int showToUser) throws Exception {
		// TODO Auto-generated method stub
		return columnDAO.getListByColumnLevelAndDept(level,deptid, showToUser);
	}

	public List getColumnListByDeptId(String dept) throws Exception {
		// TODO Auto-generated method stub
		return columnDAO.getListForContentByDeptId(dept);
	}

	public List getContentByColumnId(int id, int pageNum, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		return contentDAO.getListWithoutContentByCid(id, pageNum, pageSize);
	}
	
	public List getContentWithContentStrByColumnId(int id, int pageNum, int pageSize) throws SQLException {
		// TODO Auto-generated method stub
		return contentDAO.getListWithContentByCid(id, pageNum, pageSize);
	}

	public List getContentByColumnEId(String oId, String eId, int pageNum, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		int id = columnDAO.getColumnIdByEId(oId, eId);
		return contentDAO.getListWithoutContentByCid(id, pageNum, pageSize);
	}

	public int getContentTotlePage(int columnId , int pageSize) throws Exception {
		// TODO Auto-generated method stub
		return contentDAO.getTotlePage(columnId , pageSize);
	}

	public int getContentTotleListSum(int columnId) throws Exception {
		// TODO Auto-generated method stub
		return contentDAO.getTotleColumn(columnId);
	}

	public void updateAttachmentSum(int contentId, int attachmentSum) throws Exception {
		// TODO Auto-generated method stub
		contentDAO.updateAttachmentSum(contentId, attachmentSum);
	}

	public int getNewNum(int columnId, int days) throws Exception {
		// TODO Auto-generated method stub
		return contentDAO.getNewNum(columnId, days);
	}

	public List getContentByColumnIdDocument(int id, int page, int pageNum) throws Exception {
		// TODO Auto-generated method stub
		return contentDAO.getListByCidUsedDocument(id, page, pageNum);
	}

	public void unSetQuickLinkSingle(int columnId) throws Exception {
		// TODO Auto-generated method stub
		contentDAO.unSetQuickLinkSingle(columnId);
	}

	public List getIndexContent(String deptId, int userClass) throws Exception {
		// TODO Auto-generated method stub
		return contentDAO.getIndexContent(deptId, userClass);
	}

	public List getByUploadUser(String userName, int page, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		return contentDAO.getByUploadUser(userName, page, pageSize);
	}

	public List getCheck(String checkWord, int page, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		return contentDAO.getCheck(checkWord, page, pageSize);
	}

	public int getCheckTotlePage(String checkWord, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		return contentDAO.getCheckTotlePage(checkWord, pageSize);
	}

	public UlColumn getByIdForShow(int id) throws Exception {
		// TODO Auto-generated method stub
		return columnDAO.getByIdForShow(id);
	}

	public List getListByParentId(int id, String dept) throws Exception {
		// TODO Auto-generated method stub
		return columnDAO.getListByParentId(id, dept);
	}

	public List getSameLevelListById(int id) throws Exception {
		// TODO Auto-generated method stub
		return columnDAO.getSameLevelListById(id);
	}

	public UlDocument getDocument(int id) throws Exception {
		// TODO Auto-generated method stub
		return contentDAO.getDocument(id);
	}

	public int updateDocument(UlDocument d) throws Exception {
		// TODO Auto-generated method stub
		return contentDAO.updateDocument(d);
	}

	public void addDocument(UlDocument d) throws Exception {
		// TODO Auto-generated method stub
		contentDAO.addDocument(d);
	}

	public int addContentDocument(UlContent uc) throws Exception {
		// TODO Auto-generated method stub
		return contentDAO.addContentDocument(uc);
	}

	public int updateContentDocument(UlContent uc) throws Exception {
		// TODO Auto-generated method stub
		return contentDAO.updateContentDocument(uc);
	}

	public int getTotlePageFor2LevelColumn(int columnId, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		return contentDAO.getTotlePageFor2LevelColumn(columnId, pageSize);
	}

	public List getTemplateByColumnId(int columnId, int ptype , String dept) throws Exception {
		// TODO Auto-generated method stub
		return contentDAO.getTemplateByColumnId(columnId, ptype, dept);
	}

	public List getTemplateListByDeptName(String deptName) throws Exception {
		// TODO Auto-generated method stub
		return contentDAO.getTemplateListByDeptName(deptName);
	}

	public UlTemplate getTemplateListByid(int templateId) throws Exception {
		// TODO Auto-generated method stub
		return contentDAO.getTemplateListByid(templateId);
	}

	public void saveTemplate(UlTemplate t) throws Exception {
		// TODO Auto-generated method stub
		contentDAO.saveTemplate(t);
		
	}

	public int editTemplate(UlTemplate t) throws Exception {
		// TODO Auto-generated method stub
		return contentDAO.editTemplate(t);
	}

	public void deleteTemplate(int templateId, int isDelete) throws Exception {
		// TODO Auto-generated method stub
		contentDAO.deleteTemplate(templateId, isDelete);
	}

	public void deleteListFromTo(int startContentId, int endContentId) throws Exception {
		// TODO Auto-generated method stub
		contentDAO.deleteListFromTo(startContentId, endContentId);
	}

	public void deleteListFrom(int startContentId) throws Exception {
		// TODO Auto-generated method stub
		contentDAO.deleteListFrom(startContentId);
	}

	public int createForMoveData(UlContent uc) throws Exception {
		// TODO Auto-generated method stub
		return contentDAO.createForMoveData(uc);
	}

	public List getListIsDeleted(int columnId, String dept, int isDelete, int pageNum, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		return contentDAO.getListIsDeleted(columnId, dept, isDelete, pageNum, pageSize);
	}

	public List getListWithContentByCid(int columnid, int pageNum, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		return contentDAO.getListWithContentByCid(columnid, pageNum, pageSize);
	}

	public List<UlContentWithAtt> getContentListWithAtt(int columnId, int isNeedContent, int pageSize, int pageNum) throws Exception {
		// TODO Auto-generated method stub
		return contentDAO.getContentListWithAtt(columnId, isNeedContent, pageSize, pageNum);
	}
	
	public List<UlContentWithAtt> getContentListWithAttByEId(String oId, String eId, int isNeedContent, int pageSize, int pageNum) throws Exception {
		// TODO Auto-generated method stub
		int columnId = columnDAO.getColumnIdByEId(oId, eId);
		return contentDAO.getContentListWithAtt(columnId, isNeedContent, pageSize, pageNum);
	}

	public int cancleDelete(int contentId) throws Exception {
		// TODO Auto-generated method stub
		return contentDAO.cancleDelete(contentId);
	}

	public List getListWithContentByCustom(String sqlString, int pageNum, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		return contentDAO.getListWithContentByCustom(sqlString, pageNum, pageSize);
	}

	public List getListByCustom(String sqlString, int pageNum, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		return contentDAO.getListByCustom(sqlString, pageNum, pageSize);
	}

	public int getIntByCustom(String sqlString) throws Exception {
		// TODO Auto-generated method stub
		return contentDAO.getIntByCustom(sqlString);
	}

	public List getQuickLinkByDept(String dept, int pageNum, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		return contentDAO.getQuickLinkByDept(dept, pageNum, pageSize);
	}

	public List getListByColumnIdDocument(int columnid, int pageSize, int pageNum) throws Exception {
		// TODO Auto-generated method stub
		return contentDAO.getListByColumnIdDocument(columnid, pageSize, pageNum);
	}

	public List getTemplateListByDeptName(String deptName, int isDelete) throws SQLException {
		// TODO Auto-generated method stub
		return contentDAO.getTemplateListByDeptName(deptName, isDelete);
	}

//071101 add for get a content with content in a column
	public UlContent getLastContentInColumnId(int columnId) throws Exception {
		// TODO Auto-generated method stub
		return contentDAO.getLastContentInColumnId(columnId);
	}
	
	public UlContent getLastContentInColumnEId(String oId, String eId) throws Exception {
		// TODO Auto-generated method stub
		int columnId = columnDAO.getColumnIdByEId(oId, eId);
		return contentDAO.getLastContentInColumnId(columnId);
	}

	public List getContentByNearDayIndept(String dept, int day, int pageSize) throws SQLException {
		// TODO Auto-generated method stub
		return contentDAO.getContentByNearDayIndept(dept, day ,pageSize);
	}

	public List getContentByDeptId(String dept, int pageNum, int pageSize) throws SQLException {
		// TODO Auto-generated method stub
		return contentDAO.getContentByDeptId(dept, pageNum, pageSize);
	}
	public int getTotlePageByDept(String dept, int pageSize) throws SQLException{
		return contentDAO.getTotlePageByDept(dept, pageSize);
	}

	public List getListByParentColumnIdDocument(int columnid, int pageSize, int days) throws SQLException {
		// TODO Auto-generated method stub
		return contentDAO.getListByParentColumnIdDocument(columnid, pageSize, days);
	}

	public List getListByOrganId(String dept_name,int num) throws SQLException {
		// TODO Auto-generated method stub
		return contentDAO.getListByOrganId(dept_name,num);
	}
}

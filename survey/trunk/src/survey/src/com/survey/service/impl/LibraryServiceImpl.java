package com.survey.service.impl;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.alibaba.fastjson.JSONObject;
import com.survey.dao.IBaseDao;
import com.survey.dao.IMissionDao;
import com.survey.dao.ISurveyDao;
import com.survey.dao.IUserDao;
import com.survey.service.ILibraryService;
import com.survey.service.ISurveyService;
import com.survey.util.ContextUtil;
import com.survey.util.StringUtil;
import com.survey.vo.CategoryVO;
import com.survey.vo.LOption;
import com.survey.vo.LQuestion;
import com.survey.vo.LQuestionVO;
import com.survey.vo.Library;
import com.survey.vo.Mission;
import com.survey.vo.Option;
import com.survey.vo.PageVO;
import com.survey.vo.Question;
import com.survey.vo.Survey;
import com.survey.vo.TextAnswer;


public class LibraryServiceImpl implements ILibraryService {   
 
	private IBaseDao baseDaoImpl;
	
	private ISurveyDao surveyDao;
	
	public ISurveyDao getSurveyDao() {
		return surveyDao;
	}

	public void setSurveyDao(ISurveyDao surveyDao) {
		this.surveyDao = surveyDao;
	}

	public IBaseDao getBaseDaoImpl() {
		return baseDaoImpl;
	}

	public void setBaseDaoImpl(IBaseDao baseDaoImpl) {
		this.baseDaoImpl = baseDaoImpl;
	}


	public Library saveLibraryInfo(String libraryInfo) {
		// TODO Auto-generated method stub
		Library l = parseSurveyInfoXml(libraryInfo);
		
		l.setCreateTime(new Date());
		l = (Library) baseDaoImpl.save(l);
		
		Iterator iter1 = l.getQuestionList().iterator();
		int queSeq = 0;
		int objSeq = 0;
		while (iter1.hasNext()) {
			LQuestion q = (LQuestion) iter1.next();
			q.setLibraryId(l.getId());

			q = (LQuestion) baseDaoImpl.save(q);
			
			Iterator iter2 = q.getOptionList().iterator();
			int optSeq = 0;
			while (iter2.hasNext()) {
				LOption o = (LOption) iter2.next();
				o.setQuestionId(q.getId());
				o.setSeq(++optSeq);
				o = (LOption) baseDaoImpl.save(o);
				
			}
		}	
		return l;
	}
	
	/**
	 * 解析题库
	 * @param surveyInfoXml
	 * @return
	 */
	private static Library parseSurveyInfoXml(String surveyInfoXml) {
		
		Library library = new Library();
		
		try {
			SAXReader sr = new SAXReader();
			Document d = sr.read(new ByteArrayInputStream(surveyInfoXml.getBytes("UTF-8")));
			
			// 解析survey
			Element eSurvey = d.getRootElement();
			library.setName(eSurvey.elementText("name"));
			library.setOwnerId(Integer.parseInt(eSurvey.elementText("owner")));
		
			// 遍历所有question
			Iterator iter1 = eSurvey.elements("question").iterator();
			List queList = new ArrayList();
			while (iter1.hasNext()) {
				Element eQuestion = (Element) iter1.next();
				
				LQuestion que = new LQuestion();
				que.setName(eQuestion.elementText("name"));
				que.setType(StringUtil.parseInt(eQuestion.elementText("type")));
				que.setCategory(eQuestion.elementText("category"));

				// 遍历所有option
				Iterator iter2 = eQuestion.elements("option").iterator();
				
				List optList = new ArrayList();
				while (iter2.hasNext()) {
					Element eOpt = (Element) iter2.next();
					LOption opt = new LOption();
					opt.setName(eOpt.elementText("name"));	
					optList.add(opt);
				}
				que.setOptionList(optList);
				queList.add(que);
				
			}
			library.setQuestionList(queList);

		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return library;
	}

	public Library getLibraryInfo(int libraryId) {
		// TODO Auto-generated method stub
		Library l = (Library) baseDaoImpl.getById(Library.class, libraryId);
		//题目集合
		String queSql = "select t.id id,t.name name,t.library_id libraryId,t.category category,t.type type,t.seq seq "+
		"from t_sv_lquestion t where t.library_id =? order by t.seq asc,t.id desc ";
		List paramList2 = new ArrayList();
		paramList2.add(libraryId);
		
		List lqueList = baseDaoImpl.getList(queSql, LQuestion.class, paramList2);
		//选项集合
		Iterator iter1 = lqueList.iterator();
			while (iter1.hasNext()) {
				LQuestion lq = (LQuestion) iter1.next();
				
				List loptList = baseDaoImpl.getListByProperty("LOption", "questionId", lq.getId());
				lq.setOptionList(loptList);
			}

		l.setQuestionList(lqueList);
		
		//分类集合
		l.setCategorys(this.getCategorys(libraryId));
		
		return l;
	}
	
	private List getCategorys(int libraryId){
		//获取试卷题目类型
		String sql = "select distinct t.type type,tb.type_name typeName from t_sv_lquestion t,t_sv_question_type_tbl tb "+
				"where t.type = tb.type_id "+
				"and t.library_id = ?";
		List paramList = new ArrayList();
		paramList.add(libraryId);
		List<LQuestionVO> lques = baseDaoImpl.getList(sql, LQuestionVO.class, paramList);
		
		for (int i = 0; i < lques.size(); i++) {
			//分类集合
			String sql2 = "select count(1) num,t.category category from t_sv_lquestion t where t.library_id = ? " +
					"and t.type=? group by t.category";
			List paramList2 = new ArrayList();
			paramList2.add(libraryId);
			paramList2.add(lques.get(i).getType());
			
			List categorys = baseDaoImpl.getList(sql2, CategoryVO.class, paramList2);
			
			lques.get(i).setCategorys(categorys);
		}
		
		return lques;
	}
	
	public Map getLibraryInfoPvo(PageVO pvo, int libraryId) {
		// TODO Auto-generated method stub
		//显示页的问题号
		StringBuffer sb = new StringBuffer();
		
		Map map = new HashMap();
		String sql = "select t.id id,t.name name,t.library_id libraryId,t.category category,t.type type,t.seq seq "+
					"from t_sv_lquestion t where t.library_id ="+libraryId+" order by t.seq asc,t.id desc ";
		pvo = baseDaoImpl.getListInPage(pvo, sql, LQuestion.class);
		
		List lqueList = new ArrayList();
		if(pvo!=null){
			lqueList = pvo.getObjectList();
			Iterator iter1 = lqueList.iterator();
			while (iter1.hasNext()) {
				LQuestion lq = (LQuestion) iter1.next();
				
				List loptList = baseDaoImpl.getListByProperty("LOption", "questionId", lq.getId());
				lq.setOptionList(loptList);
				
				//将页面显示问题号拼接成字符串，以便更新时删除
				sb.append(lq.getId());
				sb.append(",");
			}
		}else{
			pvo = new PageVO();
		}
		map.put("pvo", pvo);
		
		//页面第一道问题的seq
		if(lqueList.size()!=0){
			LQuestion lq = (LQuestion)lqueList.get(0);
			map.put("firstSeq", lq.getSeq());
		}else{
			map.put("firstSeq", 0);
		}
		
		
		//分类集合
		String cateSql = "select count(1) num,t.category category from t_sv_lquestion t where t.library_id = ? group by t.category";
		List paramList = new ArrayList();
		paramList.add(libraryId);
		
		Library l = (Library) baseDaoImpl.getById(Library.class, libraryId);
		List categorys = baseDaoImpl.getList(cateSql, LQuestion.class,paramList);
		l.setCategorys(categorys);
		map.put("library", l);
		
		map.put("queIds", sb.toString());
		
		return map;
	}

	public Library updateLibraryInfo(String libraryInfo, int libraryId) {
		// TODO Auto-generated method stub
//		删除原有题库
		Library oldLibrary = (Library) baseDaoImpl.getById(Library.class, libraryId);
		oldLibrary.setIsDelete(1);
		baseDaoImpl.update(oldLibrary);
		
		//保存题库
		Library l = parseSurveyInfoXml(libraryInfo);
		l.setCreateTime(new Date());
		baseDaoImpl.save(l);
		//保存问题
		Iterator iter1 = l.getQuestionList().iterator();
		while (iter1.hasNext()) {
			LQuestion lq = (LQuestion) iter1.next();
			lq.setLibraryId(l.getId());
			baseDaoImpl.save(lq);
			//保存选项
			Iterator iter2 = lq.getOptionList().iterator();
			int optSeq = 0;
			while (iter2.hasNext()) {
				LOption o = (LOption) iter2.next();
				o.setQuestionId(lq.getId());
				o.setSeq(++optSeq);
				baseDaoImpl.save(o);
			}
		}
		return l;	
	}

	public void deleteLibrary(int libraryId) {
		// TODO Auto-generated method stub
		Library library = (Library) baseDaoImpl.getById(Library.class, libraryId);
		library.setIsDelete(1);
		
		baseDaoImpl.update(library);
	}

	public PageVO getLibraryListPvo(PageVO pvo, String libraryName) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append( "select s.id id,s.name name,s.owner_id ownerId,s.is_delete isDelete,s.create_time createTime " +
				"from t_sv_library s "+
				"where s.is_delete = 0 " +
				"and s.owner_id = '" + ContextUtil.getCurrentUserId()+"'");
		
		if(libraryName!=null&&libraryName.length()!=0){
			sb.append(" and s.name like '%"+libraryName+"%'");
		}
		sb.append(" order by s.id desc");
		
		String sql = sb.toString();
		pvo = baseDaoImpl.getListInPage(pvo, sql, Library.class);
		return pvo;
	}

	public Survey createSurvey(int type, String sids) {
		// TODO Auto-generated method stub	
		Survey s = new Survey(type);
		s = (Survey) surveyDao.saveEntity(s);
		
		this.createQue(s.getId(), sids);	
		return s;
	}
	
	private void createQue(int surveyId,String sids){
		String[] queIds = sids.split(",");
		for (int i = 0; i < queIds.length; i++) {
			LQuestion lq = (LQuestion) baseDaoImpl.getById(LQuestion.class, StringUtil.parseInt(queIds[i]));
			List<LOption> los = baseDaoImpl.getListByProperty("LOption", "questionId", StringUtil.parseInt(queIds[i]));
			//保存问题
			Question q = new Question();
			q.setType(lq.getType());
			q.setName(lq.getName());
			q.setSurveyId(surveyId);
			q.setScore(new BigDecimal(0));
			q.setSeq(i+1);
			q.setObjSeq(i+1);
			baseDaoImpl.save(q);
			
			//保存选项
			for (Iterator iter = los.iterator(); iter.hasNext();) {
				LOption e = (LOption) iter.next();
				
				Option o = new Option();
				o.setName(e.getName());
				o.setSeq(e.getSeq());
				o.setQuestionId(q.getId());
				o.setScore(new BigDecimal(0));
				
				baseDaoImpl.save(o);
			}
		}
	}

	public Survey createSurveyRandom(int type, String cts,int libraryId) {
		// TODO Auto-generated method stub
		List<CategoryVO> categoryList = JSONObject.parseArray(cts,CategoryVO.class);
		String sids = this.queRandom(categoryList, libraryId);
		Survey s = this.createSurvey(type, sids);
		
		return s;
	}
	
	//生成随机题目id
	private String queRandom(List categoryList,int libraryId){
		//存储随机选出题号
		StringBuffer sb = new StringBuffer();
		
		String sql = "select a.id id from "+
					"(select  t.id,t.name,t.library_id,t.category,t.type  from t_sv_lquestion t "+
							"where t.library_id = ? "+
							"and t.category = ? " +
							"and t.type = ? "+
							"order by dbms_random.value ) a "+
					"where rownum <= ?";

		for (int i = 0; i < categoryList.size(); i++) {
			CategoryVO category = (CategoryVO) categoryList.get(i);
			List paramList = new ArrayList();
			paramList.add(libraryId);
			paramList.add(category.getCategory());
			paramList.add(category.getType());
			paramList.add(category.getNum());
			
			List<LQuestion> list = baseDaoImpl.getList(sql, LQuestion.class,paramList);
			
			for (LQuestion lq : list) {
				sb.append(lq.getId());
				sb.append(",");
			}
		}
		return sb.toString();
	}

	public Library getLibrary(int libraryId) {
		// TODO Auto-generated method stub
		return (Library) baseDaoImpl.getById(Library.class, libraryId);
	}

	public void saveLibrary(Library l) {
		// TODO Auto-generated method stub
		baseDaoImpl.save(l);
	}

	public void savelqo(List queList) {
		// TODO Auto-generated method stub
		for (int i = 0; i < queList.size(); i++) {
			LQuestion lq = (LQuestion) queList.get(i);
			if(lq.getOptionList().size()!=0){
				for (int j = 0; j < lq.getOptionList().size(); j++) {
					LOption lo = (LOption) lq.getOptionList().get(j);
					baseDaoImpl.save(lo);
				}
			}
		}
	}

	public void saveLq(LQuestion lq) {
		// TODO Auto-generated method stub
		baseDaoImpl.save(lq);
	}

	public LQuestion getLQuetion(int lquetionId) {
		// TODO Auto-generated method stub
		LQuestion lq = (LQuestion) baseDaoImpl.getById(LQuestion.class, lquetionId);
		List list = baseDaoImpl.getListByProperty("LOption", "questionId", lq.getId());
		lq.setOptionList(list);
		
		return lq;
	}

	public void updateQue(String queInfo, int lquetionId) {
		// TODO Auto-generated method stub
		LQuestion oldlq = (LQuestion) baseDaoImpl.getById(LQuestion.class, lquetionId);
		//删除试题下选项
		String sql = "delete from t_sv_loption t where t.question_id = ? ";
		List paramList = new ArrayList();
		paramList.add(lquetionId);
		baseDaoImpl.executeUpdate(sql, paramList);
		
		//更新试题
		Library l = parseQueInfoXml(queInfo);
		
		Iterator iter1 = l.getQuestionList().iterator();
		while (iter1.hasNext()) {
			LQuestion lq = (LQuestion) iter1.next();
			oldlq.setName(lq.getName());

			baseDaoImpl.update(oldlq);
			//保存选项
			Iterator iter2 = lq.getOptionList().iterator();
			int optSeq = 0;
			while (iter2.hasNext()) {
				LOption o = (LOption) iter2.next();
				o.setQuestionId(oldlq.getId());
				o.setSeq(++optSeq);
				baseDaoImpl.save(o);
			}
		}
	}
	
	/**
	 * 解析题库
	 * @param surveyInfoXml
	 * @return
	 */
	private static Library parseQueInfoXml(String queInfoXml) {
		
		Library library = new Library();
		
		try {
			SAXReader sr = new SAXReader();
			Document d = sr.read(new ByteArrayInputStream(queInfoXml.getBytes("UTF-8")));
			
			// 解析survey
			Element eSurvey = d.getRootElement();

			// 遍历所有question
			Iterator iter1 = eSurvey.elements("question").iterator();
			List queList = new ArrayList();
			while (iter1.hasNext()) {
				Element eQuestion = (Element) iter1.next();
				
				LQuestion que = new LQuestion();
				que.setName(eQuestion.elementText("name"));
				que.setType(StringUtil.parseInt(eQuestion.elementText("type")));
				que.setCategory(eQuestion.elementText("category"));

				// 遍历所有option
				Iterator iter2 = eQuestion.elements("option").iterator();
				
				List optList = new ArrayList();
				while (iter2.hasNext()) {
					Element eOpt = (Element) iter2.next();
					LOption opt = new LOption();
					opt.setName(eOpt.elementText("name"));	
					optList.add(opt);
				}
				que.setOptionList(optList);
				queList.add(que);
				
			}
			library.setQuestionList(queList);

		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return library;
	}

	public Library updateLibraryInfo(String libraryInfo, int libraryId, String queIds, int seq) {
		// TODO Auto-generated method stub

		Library l = parseSurveyInfoXml(libraryInfo);
		Library oldLibrary = (Library) baseDaoImpl.getById(Library.class, libraryId);
		oldLibrary.setName(l.getName());
		baseDaoImpl.update(oldLibrary);
		
		//删除该页面显示的问题
		if(queIds.length()!=0&&!"".equals(queIds)){
			queIds = queIds.substring(0, queIds.length()-1);
			String sql = "delete from t_sv_lquestion t where t.id in ("+queIds+")";
			baseDaoImpl.executeUpdate(sql);
		}
		
		//保存问题
		Iterator iter1 = l.getQuestionList().iterator();
		while (iter1.hasNext()) {
			LQuestion lq = (LQuestion) iter1.next();
			lq.setLibraryId(oldLibrary.getId());
			lq.setSeq(seq++);
			System.out.println("==============================="+seq);
			baseDaoImpl.save(lq);
			//保存选项
			Iterator iter2 = lq.getOptionList().iterator();
			int optSeq = 0;
			while (iter2.hasNext()) {
				LOption o = (LOption) iter2.next();
				o.setQuestionId(lq.getId());
				o.setSeq(++optSeq);
				baseDaoImpl.save(o);
			}
		}
		return oldLibrary;	
	}
	
}

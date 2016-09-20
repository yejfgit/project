package com.ulic.portal.search.searching.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.ParallelMultiSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.Searcher;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.TopFieldCollector;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.ulic.portal.pub.vo.PageSupport;
import com.ulic.portal.search.indexing.dao.CusSystemDao;
import com.ulic.portal.search.indexing.entity.CusSystem;
import com.ulic.portal.search.indexing.util.UnicodeUtil;
import com.ulic.portal.search.searching.dao.SearchDao;
import com.ulic.portal.search.searching.entity.Footprint;
import com.ulic.portal.search.searching.util.PinyinUtil;
import com.ulic.portal.search.searching.util.UlAnalyzer;
import com.ulic.portal.search.searching.vo.FootprintVO;


@Service
@Transactional(propagation = Propagation.REQUIRED)
public class SearchService {
	
	@Resource
	private CusSystemDao cusSystemDao;
	
	@Resource
	private SearchDao searchDao;
	
	/**
	 * 根据搜索方式获取不同的搜索器
	 * @return
	 * @throws IOException 
	 * @throws CorruptIndexException 
	 */
	private ParallelMultiSearcher getSearcher(String source) throws CorruptIndexException, IOException{	
		List sysList = new ArrayList();
		
		if(source==null||source.equals("all")){
			sysList = cusSystemDao.getList("CusSystem");
		}else{
			sysList.add(cusSystemDao.getCusSystem(source));
		}
		
		//多索引文件查询
		IndexSearcher[] searchers = new IndexSearcher[sysList.size()];
		for (int i = 0; i < searchers.length; i++) {
			CusSystem sys = (CusSystem) sysList.get(i);
			searchers[i] = new IndexSearcher(FSDirectory.open(new File(sys.getSysIndexPath())));
		}
		ParallelMultiSearcher searcher = new ParallelMultiSearcher(searchers);
		
		return searcher;
	}
	
	/**
	 * 根据不同需求获取排序器
	 * @param obj
	 * @return
	 */
	private Sort getSort(Object obj){	
		Sort sort = new Sort(new SortField[]{new SortField("content", SortField.SCORE),new SortField("title", SortField.SCORE)});
		return sort;
	}
	
	/**
	 * query对象 
	 * @param queryStr
	 * @return
	 * @throws ParseException
	 */
	private Query getQuery(String queryStr) throws ParseException{	
	    //根据关键字构造一个数组      
	    String[] key = new String[]{queryStr,queryStr};     
	    //同时声明一个与之对应的字段数组      
	    String[] fields = {"title", "content"};   
	    //声明BooleanClause.Occur[]数组,它表示多个条件之间的关系      
	    BooleanClause.Occur[] flags=new BooleanClause.Occur[]{BooleanClause.Occur.SHOULD,BooleanClause.Occur.SHOULD};   
		
	    Query query = MultiFieldQueryParser.parse(Version.LUCENE_CURRENT,key,fields,flags,new IKAnalyzer(true));
		
		return query;
	}
	
	/**
	 * 保存用户搜索痕迹
	 * @param queryString
	 */
	public void saveFootPrint(String queryString,String ip){
		Footprint fp = new Footprint();
		fp.setQueryString(queryString);
		fp.setUserId(43711);
		fp.setIp(ip);
		fp.setCreateDate(new Date());
		fp.setPinyin(PinyinUtil.hanziToPinyin(queryString));
		fp.setPinyinHead(PinyinUtil.stringArrayToString(PinyinUtil.getHeadByString(queryString)).toLowerCase());
		
		searchDao.save(fp);
	}
	
	/**
	 * 获取相关的查询条件
	 * @param queryString
	 * @return
	 */
	public List getFootprintList(String queryString){
		//为更全面获取痕迹，去除空格
		queryString = queryString.replace(" ", "").toLowerCase();
		System.out.println(queryString);
		List list = searchDao.getFootprintList(queryString);
		return list;
	}

	/**
	 * 分页查询结果
	 * @param ps
	 * @return
	 */
	public PageSupport getResultList(PageSupport pageSupport, String queryStr, String source) {
		// TODO Auto-generated method stub
		
		int totalHits = 0;
		List resultList = new ArrayList();
		try {
			//获取搜索器
			ParallelMultiSearcher searcher = getSearcher(source);
			//获取搜索语句
			Query query = this.getQuery(queryStr);
			//获取排序器
			Sort sort = getSort(null);
			
			//分页从索引中获取词条
			int start = this.getPageStart(pageSupport);
			int howmany = pageSupport.getPageSize();
			TopFieldCollector results = TopFieldCollector.create(sort, start+howmany, false, false, false, false);
			searcher.search(query, results);
			TopDocs h = results.topDocs(start, howmany);
			
			//组装展现结果，设置高亮
			Highlighter highlighter = new Highlighter(new SimpleHTMLFormatter("<b>", "</b>"), new QueryScorer(query));
			totalHits = h.totalHits;
			
			//获取所搜结果
			resultList = this.getResult(searcher, h, highlighter);
		} catch (Exception e) {
			e.printStackTrace();
		}
		pageSupport.fillPageList(resultList, totalHits, pageSupport.getPageSize(), pageSupport.getCurrentPage());
		return pageSupport;
	}

	/**
	 * 获取相关搜索
	 * @param queryStr
	 * @return
	 */
	public List getRelativeList(String queryStr) {
		// TODO Auto-generated method stub
		//显示相关性条数		
		int count = 0;
		List relativeList = new ArrayList();
		String str = UlAnalyzer.analyze(queryStr);
		String[] queryStr1 = str.split(";");
		
		List list = searchDao.getRelativeList(queryStr1,queryStr);
		
		if(list.size()>10){
			count=10;
		}else{
			count =list.size();
		}
		
		for (int i = 0; i < count; i++) {
			FootprintVO fp = (FootprintVO) list.get(i);
			fp.setUrl(UnicodeUtil.toEncodedUnicode(fp.getQueryString(),true));
			relativeList.add(fp);
		}
		return relativeList;
	}
	
	/**
	 * 获取搜索结果
	 * @param searcher
	 * @param h
	 * @param hl
	 * @return
	 * @throws CorruptIndexException
	 * @throws IOException
	 * @throws InvalidTokenOffsetsException
	 */
	public List getResult(ParallelMultiSearcher searcher,TopDocs h,Highlighter hl) throws CorruptIndexException, IOException, InvalidTokenOffsetsException{
		List resultList = new ArrayList();
		
		for (int i = 0; i < h.scoreDocs.length; i++) {
			Document d = searcher.doc(h.scoreDocs[i].doc);
			
			String showTitle = hl.getBestFragment(new IKAnalyzer(true), "title", d.get("title"));
			if (showTitle == null) {
				showTitle = d.get("title");
			}
			
			//拼装并高亮显示title
			showTitle = "【" + d.get("system") + "】" + showTitle;
			
			//拼装并高亮显示content
			String content = d.get("content").replaceAll("<[^>]+>", "").replace("\n", "<br />");
			String showContent = hl.getBestFragment(new IKAnalyzer(true), "content", content);
			if (showContent == null) {
				//显示content摘要
				if(content.length() > 100){
					showContent = content.substring(0, 100);
				}else{
					showContent = content;
				}
			}
			String url = d.get("url");
				
			Map result = new HashMap();
			result.put("title", showTitle);
			result.put("content", showContent);
			result.put("url", url);
			resultList.add(result);
			}
		
		return resultList;
	}
	
	/**
	 * 获取页面词条起始号
	 * @param ps
	 * @return
	 */
	private int getPageStart(PageSupport ps){
		int start = 0;
		if (ps.getCurrentPage() < 1) {
			start = 0;
		}else {
			start = (ps.getCurrentPage() - 1) * ps.getPageSize();
		}
		return start;
	}
}

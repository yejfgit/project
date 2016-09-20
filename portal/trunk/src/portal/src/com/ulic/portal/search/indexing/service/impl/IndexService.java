package com.ulic.portal.search.indexing.service.impl;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.index.IndexWriter.MaxFieldLength;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.LockObtainFailedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.ulic.portal.search.indexing.dao.CusSystemDao;
import com.ulic.portal.search.indexing.entity.CusSystem;
import com.ulic.portal.search.indexing.service.ConvertFactory;
import com.ulic.portal.search.indexing.service.IIndexService;
import com.ulic.portal.search.indexing.vo.UlDocument;

/**
 * 索引service
 * @author zhangch003
 *
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class IndexService implements IIndexService {
	
	/**
	 * 自动注入Dao
	 */
	@Resource
	private CusSystemDao cusSystemDao;

	public void createIndex(UlDocument ud) {
		// TODO Auto-generated method stub
		//获取客户系统相关信息
		CusSystem cusSys = cusSystemDao.getCusSystem(ud.getSystem());
		
		ud = tranferDocument(ud,cusSys);
		try {
			IndexWriter iw = getIndexWriter(ud,cusSys);
			
			Document document = new Document();
			document.add(new Field("id", ud.getSystem()+ud.getId(), Field.Store.YES, Field.Index.ANALYZED));
			document.add(new Field("title", ud.getTitile(), Field.Store.YES, Field.Index.ANALYZED));
			document.add(new Field("content", ud.getContent(), Field.Store.YES, Field.Index.ANALYZED));
			document.add(new Field("url", cusSys.getSysPath()+ud.getUrl(), Field.Store.YES, Field.Index.NOT_ANALYZED));
			document.add(new Field("system", ud.getSystem(), Field.Store.YES, Field.Index.NOT_ANALYZED));
			iw.addDocument(document);
			
			iw.commit();
			iw.optimize();
			iw.close();
		} catch (CorruptIndexException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LockObtainFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteIndex(UlDocument ud) {
		// TODO Auto-generated method stub
		try {
			//获取客户系统相关信息
			CusSystem cusSys = cusSystemDao.getCusSystem(ud.getSystem());
			IndexWriter iw = getIndexWriter(ud,cusSys);
			
			iw.deleteDocuments(new Term("id",ud.getId()));	
		} catch (CorruptIndexException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LockObtainFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateIndex(Object obj) {
		// TODO Auto-generated method stub

	}

	private IndexWriter getIndexWriter(UlDocument ud,CusSystem cusSys) throws CorruptIndexException, LockObtainFailedException, IOException{
		
		IndexWriter iw = new IndexWriter(
				FSDirectory.open(new File(cusSys.getSysIndexPath())), 
				new IKAnalyzer(true),MaxFieldLength.UNLIMITED);
		
		return iw;	
	}
	
	private UlDocument tranferDocument(UlDocument ud,CusSystem cusSys){
		
		//获取附件型文件全文
		if(ud.getType()==2){
			String content = ConvertFactory.convert(cusSys.getSysPath()+ud.getUrl());
			ud.setContent(content);
		}	
		return ud;
	}

}

package com.ulic.portal.search.indexing.service;

import com.ulic.portal.search.indexing.util.ConvertDoc;
import com.ulic.portal.search.indexing.util.ConvertExcel;
import com.ulic.portal.search.indexing.util.ConvertPdf;
import com.ulic.portal.search.indexing.util.ConvertPpt;

public class ConvertFactory {
	
	public static String convert(String path){
		String content = null;
		
		if (path.endsWith(".doc")) {
			ConvertDoc.readDoc(path);
		}else if(path.endsWith(".pdf")){
			ConvertPdf.readPdf(path);
		}else if(path.endsWith(".xls")){
			ConvertExcel.readExcel(path);
		}else if(path.endsWith(".ppt")){
			content = ConvertPpt.readPowerPoint(path);
		}
		return content;
	}
}

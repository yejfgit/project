package com.ulic.portal.search.indexing.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.poi.hslf.HSLFSlideShow;
import org.apache.poi.hslf.model.Slide;
import org.apache.poi.hslf.model.TextRun;
import org.apache.poi.hslf.usermodel.SlideShow;
import org.apache.poi.hwpf.extractor.WordExtractor;

public class ConvertDoc {
	
	public static String readDoc(String path) {   
		
		InputStream fis = null;
		try {
			fis = new FileInputStream(path);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		
		String content = "";   
	    try {
	    	WordExtractor we = new WordExtractor(fis);
	    	content = we.getText();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
		return content;
	}
	
	public static void main(String[] args){
		
		String path="D:/testPpt/ibm.ppt";
		String contents = readDoc(path);
		
		System.out.println(contents);
	}
}
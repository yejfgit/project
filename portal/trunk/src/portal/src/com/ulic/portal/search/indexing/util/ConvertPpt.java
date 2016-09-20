package com.ulic.portal.search.indexing.util;

import java.io.FileInputStream;

import org.apache.poi.hslf.HSLFSlideShow;
import org.apache.poi.hslf.model.Slide;
import org.apache.poi.hslf.model.TextRun;
import org.apache.poi.hslf.usermodel.SlideShow;

public class ConvertPpt {
	
	public static String readPowerPoint(String path) {   
		
		StringBuffer content = new StringBuffer("");   
		try {   
		SlideShow ss = new SlideShow(new HSLFSlideShow(new FileInputStream(   
		path)));// is   
//		 为文件的InputStream，建立SlideShow   
		Slide[] slides = ss.getSlides();// 获得每一张幻灯片   
		for (int i = 0; i < slides.length; i++) {   
		TextRun[] t = slides[i].getTextRuns();// 为了取得幻灯片的文字内容，建立TextRun   
		for (int j = 0; j < t.length; j++) {   
		content.append(t[j].getText());// 这里会将文字内容加到content中去   
		}   
		}   
		} catch (Exception ex) {   
		System.out.println(ex.toString());   
		}   
		return content.toString();
	}
	
	public static void main(String[] args){
		
		String path="D:/testPpt/ibm.ppt";
		String contents = readPowerPoint(path);
		
		System.out.println(contents);
	}
}
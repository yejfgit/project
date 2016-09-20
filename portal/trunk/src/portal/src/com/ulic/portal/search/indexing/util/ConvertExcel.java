package com.ulic.portal.search.indexing.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.apache.poi.hslf.HSLFSlideShow;
import org.apache.poi.hslf.model.Slide;
import org.apache.poi.hslf.model.TextRun;
import org.apache.poi.hslf.usermodel.SlideShow;

public class ConvertExcel {
	
	public static String readExcel(String path) {   
		
		InputStream fis = null;
		try {
			fis = new FileInputStream(path);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}

		StringBuffer sb = new StringBuffer();
	    try {
	      Workbook workbook = Workbook.getWorkbook(fis);
	      Sheet[] sheets = workbook.getSheets();
	      for (int i = 0; i < sheets.length; ++i) {
	        Sheet sheet = sheets[i];
	        int nbCol = sheet.getColumns();
	        for (int j = 0; j < nbCol; ++j) {
	          Cell[] cells = sheet.getColumn(j);
	          for (int k = 0; k < cells.length; ++k)
	            sb.append(cells[k].getContents() + " ");
	        }
	      }
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	    }
		return  sb.toString();
	}
	
	public static void main(String[] args){
		
		String path="D:/testPpt/ibm.ppt";
		String contents = readExcel(path);
		
		System.out.println(contents);
	}
}
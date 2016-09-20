package com.ulic.portal.search.indexing.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import org.apache.poi.hslf.HSLFSlideShow;
import org.apache.poi.hslf.model.Slide;
import org.apache.poi.hslf.model.TextRun;
import org.apache.poi.hslf.usermodel.SlideShow;
import org.pdfbox.pdmodel.PDDocument;
import org.pdfbox.util.PDFTextStripper;

public class ConvertPdf {
	
	public static String readPdf(String path) {   
		
		InputStream fis = null;
		try {
			fis = new FileInputStream(path);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		
		String content = "";
		PDDocument pdf = null;
		   try {
			   pdf = PDDocument.load(fis);
		   if (pdf.isEncrypted()) {
			   pdf.decrypt("");
		   }
		      StringWriter writer = new StringWriter();
		      PDFTextStripper stripper = new PDFTextStripper();
		      stripper.writeText(pdf, writer);
		      content = writer.getBuffer().toString();
		    } catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		      if (pdf != null) {
		        try {
		        	pdf.close();
		        } catch (IOException ex) {
		          ex.printStackTrace();
		        }
		      }
		    }  
		return content;
	}
	
	public static void main(String[] args){
		
		String path="D:/testPpt/ibm.ppt";
		String contents = readPdf(path);
		
		System.out.println(contents);
	}
}
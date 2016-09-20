package com.ulic.portal.search.searching.util;

import java.io.IOException;
import java.io.StringReader;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

public class UlAnalyzer {

	public static String analyze(String str){
		IKSegmenter iks = new IKSegmenter(new StringReader(str), true);
		Lexeme le = null;
		StringBuffer sb = new StringBuffer();
		try {
			while ((le = iks.next()) != null) {
				sb.append(le.getLexemeText());
				sb.append(";");

				System.out.println(le.getLexemeText());
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(sb.toString());
		return sb.toString();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		analyze("首期财务培训班2012的通知的确");
	}

}

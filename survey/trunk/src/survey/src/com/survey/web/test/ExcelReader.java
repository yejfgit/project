package com.survey.web.test;

import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ExcelReader {
	
	public static void main(String[] args) throws Exception {
		Workbook book = Workbook.getWorkbook(new File("D:/杂七杂八/批量导入试题/test.xls"));
		Sheet sheet = book.getSheet(0);
		
		int rows = sheet.getRows();
		for (int i = 1; i < rows; i++) {
			Cell[] cell = sheet.getRow(i);
			for (int j = 0; j < cell.length; j++) {
				System.out.print(sheet.getCell(j, i).getContents() + " ");
			}
			System.out.println();
		}

		
		
	}
}

package com.tools.gen.extjs;

import com.tools.gen.dto.DTOModelUseTableNames.TableName;
/**
 * EXTJS
 * @author zhengliexin 2012-8-30
 *
 */
public class MainGridGen {

	
	private static TableName tableName = TableName.pt_jhgnhb;
	
	 static boolean isGenReader = true;//是否生成Store下的Reader
	 static boolean isGenTableCoum = true;//是否生成列
	 static boolean isNeedMapping = false;//是否生成映射
	
	
	public static void main(String[] args) {
		
		GridStoreGen g = new GridStoreGen();
		
		g.genSrcAction(tableName);
	}
}

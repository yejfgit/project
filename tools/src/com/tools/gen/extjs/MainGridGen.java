package com.tools.gen.extjs;

import com.tools.gen.dto.DTOModelUseTableNames.TableName;
/**
 * EXTJS
 * @author zhengliexin 2012-8-30
 *
 */
public class MainGridGen {

	
	private static TableName tableName = TableName.pt_jhgnhb;
	
	 static boolean isGenReader = true;//�Ƿ�����Store�µ�Reader
	 static boolean isGenTableCoum = true;//�Ƿ�������
	 static boolean isNeedMapping = false;//�Ƿ�����ӳ��
	
	
	public static void main(String[] args) {
		
		GridStoreGen g = new GridStoreGen();
		
		g.genSrcAction(tableName);
	}
}

package com.tools.gen.dto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;

import com.tools.gen.dto.DTOModelUseTableNames.TableName;

/**
 * ��select�������ģ��
 * 
 * @author WQ
 * 
 */
public class MainDTOGen2 {

	//javaģ�͵�����ģ��·��
	static String toPath_pro_java = "D:\\myworkspace\\svn\\his\\BackSource\\YILZ_HIS_TransObj_JAR\\src\\";
	static String toPath_file = "com\\yilz\\his\\model\\commonmodule\\dto";//ģ��·��
	static String toPath_extfile = "com\\yilz\\his\\model\\commonmodule\\ext";//��չģ��·��

	//.netģ�͵���������·��
	static String toPath_all_net = "D:\\myworkspace";
	//static String toPath_all_net ="D:\\myworkspace\\svn\\his\\FrontSource\\Yilz.NursingStation\\ʵ�����סԺ��ʿ����վ\\model\\mobilepc\\dto";
	//.net EXT ��չģ�͵���������·��
	static String toPath_all_extnet = "D:\\myworkspace";
	//static String toPath_all_extnet ="D:\\myworkspace\\svn\\his\\FrontSource\\Yilz.NursingStation\\ʵ�����סԺ��ʿ����վ\\model\\mobilepc\\extdto";
	//.net�����ռ�  --"com.yilz.his.model.dto";
	static String net_namespace = toPath_file.replace("\\", ".");
	//.net��չ�����ռ�  --"com.yilz.his.model.extdto";
	static String netext_namespace = toPath_extfile.replace("\\", ".");

	// �Ƿ���Ҫ����java�ļ�
	final static boolean isGenJavaCode = true;
	// �Ƿ���Ҫ����.net�ļ�
	final static boolean isGenNetCode = true;
	// �Ƿ�����java��չ�ļ�
	final static boolean isGenJavaExtDTO = true;
	// �Ƿ�����.net��չ�ļ�
	final static boolean isGenNetExtDTO = true;

	public static void main(String[] args) {
		byte[] b = new byte[2048];
		int n = 0;
		String sqlStr="";
		String beanName = "";
		try {
			// ��ʾ��Ϣ
			System.out.println("������SELECT���(�����������plsqldev��ʽ��)��");
			while (true) {
				// ��ȡ����
				n = System.in.read(b);
				// ת��Ϊ�ַ���
				String temp = new String(b, 0, n - 2);
				if (temp.equalsIgnoreCase("quit")) {
					break; // ����ѭ��
				}			
				sqlStr+=temp;
				
			}
		} catch (Exception e) {
			System.out.println("SELECT����������");
		}
		
		try {
			// ��ʾ��Ϣ
			System.out.println("������JavaBean�����֣�");
			while (true) {
				// ��ȡ����
				n = System.in.read(b);
				// ת��Ϊ�ַ���
				String temp = new String(b, 0, n - 2);
				if (temp.equalsIgnoreCase("quit")) {
					break; // ����ѭ��
				}			
				beanName+=temp;
				
			}
		} catch (Exception e) {
			System.out.println("JavaBean�������������");
		}
		//System.out.println("++++++++++++++" + sqlStr);
		//System.out.println("--------------" + beanName);
		
		 System.out.println("gen table " + beanName + "  now......");
		 /** ��ģ������ **/
		
		 GenAllViewDTOModel g = new GenAllViewDTOModel(); Map<String,
		 StringBuilder> map = g.genSrcAction(sqlStr, beanName);
		 
		 StringBuilder javaContext = map.get("javaContext"); StringBuilder
		 netContext = map.get("netContext");
		 
		 if (isGenJavaCode) g.writeFile(beanName, javaContext);
		 
		 if (isGenNetCode) g.writeFileForNet(beanName, netContext);
		 
		 if (isGenJavaExtDTO) new
		 GenAllExtDTOModel().doGenJavaExtDTOAction(beanName);
		 
		 if (isGenNetExtDTO) new
		 GenAllExtDTOModel().doGenNetExtDTOAction(beanName);
		 
		 System.out.println("gen finished ......");
		 
	}

}

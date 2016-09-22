package com.tools.gen.dto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;

import com.tools.gen.dto.DTOModelUseTableNames.TableName;

/**
 * 用select语句生成模型
 * 
 * @author WQ
 * 
 */
public class MainDTOGen2 {

	//java模型的生成模型路径
	static String toPath_pro_java = "D:\\myworkspace\\svn\\his\\BackSource\\YILZ_HIS_TransObj_JAR\\src\\";
	static String toPath_file = "com\\yilz\\his\\model\\commonmodule\\dto";//模型路径
	static String toPath_extfile = "com\\yilz\\his\\model\\commonmodule\\ext";//扩展模型路径

	//.net模型的生成完整路径
	static String toPath_all_net = "D:\\myworkspace";
	//static String toPath_all_net ="D:\\myworkspace\\svn\\his\\FrontSource\\Yilz.NursingStation\\实体类库住院护士工作站\\model\\mobilepc\\dto";
	//.net EXT 扩展模型的生成完整路径
	static String toPath_all_extnet = "D:\\myworkspace";
	//static String toPath_all_extnet ="D:\\myworkspace\\svn\\his\\FrontSource\\Yilz.NursingStation\\实体类库住院护士工作站\\model\\mobilepc\\extdto";
	//.net命名空间  --"com.yilz.his.model.dto";
	static String net_namespace = toPath_file.replace("\\", ".");
	//.net扩展命名空间  --"com.yilz.his.model.extdto";
	static String netext_namespace = toPath_extfile.replace("\\", ".");

	// 是否需要生成java文件
	final static boolean isGenJavaCode = true;
	// 是否需要生成.net文件
	final static boolean isGenNetCode = true;
	// 是否生成java扩展文件
	final static boolean isGenJavaExtDTO = true;
	// 是否生成.net扩展文件
	final static boolean isGenNetExtDTO = true;

	public static void main(String[] args) {
		byte[] b = new byte[2048];
		int n = 0;
		String sqlStr="";
		String beanName = "";
		try {
			// 提示信息
			System.out.println("请输入SELECT语句(建议语句先用plsqldev格式化)：");
			while (true) {
				// 读取数据
				n = System.in.read(b);
				// 转换为字符串
				String temp = new String(b, 0, n - 2);
				if (temp.equalsIgnoreCase("quit")) {
					break; // 结束循环
				}			
				sqlStr+=temp;
				
			}
		} catch (Exception e) {
			System.out.println("SELECT语句输入出错");
		}
		
		try {
			// 提示信息
			System.out.println("请输入JavaBean的名字：");
			while (true) {
				// 读取数据
				n = System.in.read(b);
				// 转换为字符串
				String temp = new String(b, 0, n - 2);
				if (temp.equalsIgnoreCase("quit")) {
					break; // 结束循环
				}			
				beanName+=temp;
				
			}
		} catch (Exception e) {
			System.out.println("JavaBean的名字输入出错");
		}
		//System.out.println("++++++++++++++" + sqlStr);
		//System.out.println("--------------" + beanName);
		
		 System.out.println("gen table " + beanName + "  now......");
		 /** 单模型生成 **/
		
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

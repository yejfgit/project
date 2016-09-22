package com.tools.gen.extdto;


/**
 * 扩展模型生成
 * @author zhengliexin 2011-12-28
 *
 */
public class MainExtDTOGen {

	//java模型的生成模型路径
	static String toPath_pro_java = "F:\\startWordSpace\\YILZ_HIS_TransObj_JAR\\src\\";
	static String toPath_file = "com\\yilz\\his\\model\\emr\\dto";//普通模型路径
	static String toPath_extfile = "com\\yilz\\his\\model\\emr\\ext";//扩展模型路径

	//.net EXT 扩展模型的生成完整路径
	static String toPath_all_extnet = "F:\\startWordSpace\\YILZ_HIS_TransObj_JAR\\src\\com\\yilz\\his\\model\\emr\\ext";
	//.net命名空间  --"com.yilz.his.model.dto";
	static String net_namespace = toPath_file.replace("\\", ".");
	//.net扩展命名空间  --"com.yilz.his.model.extdto";
	static String netext_namespace = toPath_extfile.replace("\\", ".");

	//是否需要生成java文件
	final static boolean isGenJavaCode = true;
	//是否需要生成.net文件
	final static boolean isGenNetCode = true;
	
	//比对名
	private static Object[][] keyValues = ExtDTOPropertyAndType.SP_SF_YJGZ00_YJD000ExtDTO;
	
	
	public static void main(String[] args) {

		System.out.println("gen Ext Mode now......");
		
		GenExtDTOModel g = new GenExtDTOModel();

		if (isGenJavaCode) g.genJavaCode(keyValues);

		if(isGenNetCode)  g.genNetCode(keyValues);

		System.out.println("gen finished ......");
	}
	
}

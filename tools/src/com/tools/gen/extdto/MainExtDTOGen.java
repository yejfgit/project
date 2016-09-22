package com.tools.gen.extdto;


/**
 * ��չģ������
 * @author zhengliexin 2011-12-28
 *
 */
public class MainExtDTOGen {

	//javaģ�͵�����ģ��·��
	static String toPath_pro_java = "F:\\startWordSpace\\YILZ_HIS_TransObj_JAR\\src\\";
	static String toPath_file = "com\\yilz\\his\\model\\emr\\dto";//��ͨģ��·��
	static String toPath_extfile = "com\\yilz\\his\\model\\emr\\ext";//��չģ��·��

	//.net EXT ��չģ�͵���������·��
	static String toPath_all_extnet = "F:\\startWordSpace\\YILZ_HIS_TransObj_JAR\\src\\com\\yilz\\his\\model\\emr\\ext";
	//.net�����ռ�  --"com.yilz.his.model.dto";
	static String net_namespace = toPath_file.replace("\\", ".");
	//.net��չ�����ռ�  --"com.yilz.his.model.extdto";
	static String netext_namespace = toPath_extfile.replace("\\", ".");

	//�Ƿ���Ҫ����java�ļ�
	final static boolean isGenJavaCode = true;
	//�Ƿ���Ҫ����.net�ļ�
	final static boolean isGenNetCode = true;
	
	//�ȶ���
	private static Object[][] keyValues = ExtDTOPropertyAndType.SP_SF_YJGZ00_YJD000ExtDTO;
	
	
	public static void main(String[] args) {

		System.out.println("gen Ext Mode now......");
		
		GenExtDTOModel g = new GenExtDTOModel();

		if (isGenJavaCode) g.genJavaCode(keyValues);

		if(isGenNetCode)  g.genNetCode(keyValues);

		System.out.println("gen finished ......");
	}
	
}

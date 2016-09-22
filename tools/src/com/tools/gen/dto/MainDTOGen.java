package com.tools.gen.dto;

import java.util.Map;

import com.tools.gen.dto.DTOModelUseTableNames.TableName;
/**
 * ģ������������
 * @author lancuiyun 2014-12-10
 *
 */
public class MainDTOGen {

	//mobilePC 
	//javaģ�͵�����ģ��·��
	static String toPath_pro_java = "F:\\";
	static String toPath_file = toPath_pro_java+"";//ģ��·��
	static String toPath_extfile = "";//��չģ��·��

	//.netģ�͵���������·��
	static String toPath_all_net = "F:\\";
	
	//.net EXT ��չģ�͵���������·��
	static String toPath_all_extnet = "D:\\hospitalinfosystem\\v5.0\\net_yj\\Yilz.Yj.Entity\\model\\yj\\view\\ext";
	
//	//emr
//	//javaģ�͵�����ģ��·��
//	static String toPath_pro_java = "E:\\Java\\YILZ_HIS_TransObj_JAR\\src\\";
//	static String toPath_file = "com\\yilz\\his\\model\\emr\\dto";//ģ��·��
//	static String toPath_extfile = "com\\yilz\\his\\model\\emr\\ext";//��չģ��·��
//	//.netģ�͵���������·��
//	static String toPath_all_net = "E:\\Java\\YILZ_HIS_TransObj_JAR\\src\\com\\yilz\\his\\model\\emr\\dto";
//	//.net EXT ��չģ�͵���������·��
//	static String toPath_all_extnet = "E:\\Java\\YILZ_HIS_TransObj_JAR\\src\\com\\yilz\\his\\model\\emr\\ext";
	
	//.net�����ռ�  --"com.yilz.his.model.dto";
	static String net_namespace = toPath_file.replace("\\", ".");
	//.net��չ�����ռ�  --"com.yilz.his.model.extdto";
	static String netext_namespace = toPath_extfile.replace("\\", ".");
	
	//java����
	static String java_package="";
	
	//�Ƿ���Ҫ����java�ļ�
	final static boolean isGenJavaCode = true;
	//�Ƿ���Ҫ����.net�ļ�
	final static boolean isGenNetCode = true;
	//�Ƿ�����java��չ�ļ�
	final static boolean isGenJavaExtDTO = false;
	//�Ƿ�����.net��չ�ļ�
	final static boolean isGenNetExtDTO = false;


	//�Ƿ�ģ������
	private final static boolean isSingleModeGen = true;
	
	private static TableName tableName = TableName.VW_BQ_YZZXB0_YJYPYZ;

	public static void main(String[] args) {

		if(!isSingleModeGen){

			for (TableName tab : TableName.values()) {

				System.out.println("gen table " + tab + "  now......");

				GenAllViewDTOModel g = new GenAllViewDTOModel();
				Map<String, StringBuilder> map = g.genSrcAction(tab);

				StringBuilder javaContext = map.get("javaContext");
				StringBuilder netContext = map.get("netContext");

				if (isGenJavaCode){

					System.out.print("gen java Code begin");

					g.writeFile(tab, javaContext);

					System.out.println(">>>>>>>>>>Good!!!java Code Gen SUCCESSFUL!!!");
				}

				if(isGenNetCode){

					System.out.print("gen net Code begin ");

					g.writeFileForNet(tab, netContext);

					System.out.println(">>>>>>>>>>Good!!!.net Code Gen SUCCESSFUL!!!");
				}

				if(isGenJavaExtDTO){

					System.out.print("gen java ext Code begin ");

					new GenAllExtDTOModel().doGenJavaExtDTOAction(tab);

					System.out.println(">>>>>>>>>>Good!!!java ext Code Gen SUCCESSFUL!!!");
				}

				if(isGenNetExtDTO){

					System.out.print("gen net ext Code begin ");

					new GenAllExtDTOModel().doGenNetExtDTOAction(tab);

					System.out.println(">>>>>>>>>>Good!!!.net ext Code Gen SUCCESSFUL!!!");
				}

				System.out.println("gen table " + tab + "  end\n");
			}
		}else{

			System.out.println("gen table " + tableName + "  now......");

			/**��ģ������**/
			GenAllViewDTOModel g = new GenAllViewDTOModel();
			Map<String, StringBuilder> map = g.genSrcAction(tableName);

			StringBuilder javaContext = map.get("javaContext");
			StringBuilder netContext = map.get("netContext");

			if(isGenJavaCode) g.writeFile(tableName, javaContext);

			if(isGenNetCode)  g.writeFileForNet(tableName, netContext);

			if(isGenJavaExtDTO) new GenAllExtDTOModel().doGenJavaExtDTOAction(tableName);

			if(isGenNetExtDTO) new GenAllExtDTOModel().doGenNetExtDTOAction(tableName);
		}


		System.out.println("gen finished ......");
	}


}

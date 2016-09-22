package com.tools.gen.dto;

import java.io.File;

import com.tools.gen.common.ToolsUtils;
import com.tools.gen.dto.DTOModelUseTableNames.TableName;
/**
 * 生成扩展模型文件
 * @author zhengliexin 2011-12-27
 *
 */
public class GenAllExtDTOModel {

//	public static void main(String[] args) {
//
//		GenAllExtDTOModel g = new GenAllExtDTOModel();
//
//		System.out.println(g.genJavaExtDTO(TableName.BQ_BRTZXX));
//
//	}

	void doGenJavaExtDTOAction(TableName tabname){

		File desFile = new File(MainDTOGen.toPath_pro_java + MainDTOGen.toPath_extfile+"\\"+classExtNameStly(tabname)+".java");

		if(!desFile.exists()){

			StringBuilder context = this.genJavaExtDTO(tabname);

			ToolsUtils.writeFile(context, desFile);

		}else{


		}
	}


	void doGenNetExtDTOAction(TableName tabname){

		File desFile = new File(MainDTOGen.toPath_all_extnet+"\\"+classExtNameStly(tabname)+".cs");

		if(!desFile.exists()){

			StringBuilder context = this.genNetExtDTO(tabname);

			ToolsUtils.writeFile(context, desFile);

		}else{

		}
	}



	private StringBuilder genJavaExtDTO(TableName tabname){


		StringBuilder sb = new StringBuilder();

		/** java **/
		sb.append("package "+MainDTOGen.toPath_extfile.replace("\\", ".")+";\n\n");
		sb.append("import java.io.Serializable;\n");
		sb.append("import "+ MainDTOGen.net_namespace + "."+ classNameStly(tabname)+";\n");
		sb.append("\npublic class  "+ classExtNameStly(tabname) + " extends " + classNameStly(tabname) + " implements Serializable {\n");

		sb.append("\n\n}");


		return sb;
	}


	private StringBuilder genNetExtDTO(TableName tabname){

		StringBuilder netsb = new StringBuilder();

		/** .net **/
		netsb.append("using System;\n");
		netsb.append("using System.Collections;\n");
		netsb.append("using " + MainDTOGen.net_namespace + ";\n");
		netsb.append("\nnamespace " + MainDTOGen.netext_namespace + "\n");
		netsb.append("{\n");
		netsb.append("\t[Serializable]\n");
		netsb.append("\tpublic class "+ classExtNameStly(tabname) + " : " + classNameStly(tabname) + "\n\t{\n");

		netsb.append("\n\t}\n}");

		return netsb;
	}



	private String classExtNameStly(TableName name){

		String resStr = "";

		resStr = lowerToUp(name.toString().toLowerCase())+"ExtDTO";

		return resStr;
	}

	private String classNameStly(TableName name){

		String resStr = "";

		resStr = lowerToUp(name.toString().toLowerCase())+"DTO";

		return resStr;
	}


	private String lowerToUp (String str) {

		String resStr =str.replaceFirst(str.substring(0, 1),str.substring(0, 1).toUpperCase());

		return resStr;
	}


	/**>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>**/
	/***********************************************************************************/
	/***********************************************************************************/
	void doGenJavaExtDTOAction(String tabname){

		File desFile = new File(MainDTOGen.toPath_pro_java + MainDTOGen.toPath_extfile+"\\"+classExtNameStly(tabname)+".java");

		if(!desFile.exists()){

			StringBuilder context = this.genJavaExtDTO(tabname);

			ToolsUtils.writeFile(context, desFile);

		}else{


		}
	}
	
	private StringBuilder genJavaExtDTO(String tabname){


		StringBuilder sb = new StringBuilder();

		/** java **/
		sb.append("package "+MainDTOGen.toPath_extfile.replace("\\", ".")+";\n\n");
		sb.append("import java.io.Serializable;\n");
		sb.append("import "+ MainDTOGen.net_namespace + "."+ classNameStly(tabname)+";\n");
		sb.append("\npublic class  "+ classExtNameStly(tabname) + " extends " + classNameStly(tabname) + " implements Serializable {\n");

		sb.append("\n\n}");


		return sb;
	}
	private String classNameStly(String name){

		String resStr = "";

		resStr = lowerToUp(name.toString().toLowerCase())+"DTO";

		return resStr;
	}
	private String classExtNameStly(String name){

		String resStr = "";

		resStr = lowerToUp(name.toString().toLowerCase())+"ExtDTO";

		return resStr;
	}
	void doGenNetExtDTOAction(String tabname){

		File desFile = new File(MainDTOGen.toPath_all_extnet+"\\"+classExtNameStly(tabname)+".cs");

		if(!desFile.exists()){

			StringBuilder context = this.genNetExtDTO(tabname);

			ToolsUtils.writeFile(context, desFile);

		}else{

		}
	}
	private StringBuilder genNetExtDTO(String tabname){

		StringBuilder netsb = new StringBuilder();

		/** .net **/
		netsb.append("using System;\n");
		netsb.append("using System.Collections;\n");
		netsb.append("using " + MainDTOGen.net_namespace + ";\n");
		netsb.append("\nnamespace " + MainDTOGen.netext_namespace + "\n");
		netsb.append("{\n");
		netsb.append("\t[Serializable]\n");
		netsb.append("\tpublic class "+ classExtNameStly(tabname) + " : " + classNameStly(tabname) + "\n\t{\n");

		netsb.append("\n\t}\n}");

		return netsb;
	}
	/***********************************************************************************/
	/***********************************************************************************/
	/**<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<**/

}

package com.framework.mq.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * fastjson alibaba ������ת��ΪJson����
 * 
 * @author tangtulip@163.com 2012-1-12
 * 
 */
public class JsonUtil {

	/**
	 * ������ת��json�ַ��� ������ڿ�ͷ����û��'[' ']'����˷���
	 * ��Ҫ���Extjs������Ҳ�����ݼ�����
	 * 
	 * @param obj
	 * @return
	 */
	public static String getJsonExtjsFromObject(Object obj) {
		if (null == obj)
			return "";

		String json = JSON.toJSONString(obj);
		StringBuffer result = new StringBuffer();
		if (!(obj instanceof ArrayList)) {
			result.append("[").append(json).append("]");
			json = result.toString();
		}

		return json;
	}

	/**
	 * ������ת��json�ַ���
	 * @Title: getJsonFromObject2
	 * @Description: TODO
	 * @param @param obj
	 * @param @return
	 * @return String
	 * @throws
	 * @author WQ
	 * @date 2014-8-4
	 * @version V1.0
	 */
	public static String getJsonFromObject(Object obj) {

		String json = "";

		if (obj instanceof ArrayList) {

			json = JSONArray.toJSONString(obj);

		} else {

			json = JSON.toJSONString(obj);

		}
		return json;
	}

	
	/**
	 * ת�ɾ���ʵ����� ��ʽ��[model.PatientYdhlDTO@12a0f6c]
	 * 
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static Object jsonToObject(String json,String startFlag, Class clazz) {

		if (null ==json || json.equals("") || null == clazz)
			return null;

		JSONObject jsonObj = JSON.parseObject(json);  
		JSONObject result = jsonObj.getJSONObject(startFlag);  
		Object obj= JSON.parseObject(result.toJSONString(),clazz);  

		return obj;

	}
	/**
	 * ת�ɾ���ʵ����� ��ʽ��[model.PatientYdhlDTO@12a0f6c]
	 * 
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static List jsonToList(String json, Class clazz) {

		if (StringUtils.isBlank(json) || null == clazz)
			return null;

		List list = JSON.parseArray(json, clazz);

		return list;

	}
	
	
	/**
	 * ת�ɾ���ʵ����� ��ʽ��[model.PatientYdhlDTO@12a0f6c]
	 * 
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static List JsonToList(String json, String startFlag,Class clazz) {

		if (null ==json || json.equals("") || null == clazz)
			return null;

		JSONObject jsonObj = JSON.parseObject(json);  
		JSONArray result = jsonObj.getJSONArray(startFlag);  
		
		
		if(null == result)
			return null;
		
		List list = JSON.parseArray(result.toJSONString(), clazz);

		return list;

	}

	/**
	 * ת�ɾ���ʵ����� ��ʽ��[model.PatientYdhlDTO@12a0f6c]
	 * 
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static Object JsonToObject(String json, Class clazz) {

		if (StringUtils.isBlank(json) || null == clazz)
			return null;

		Object obj = JSON.parseObject(json, clazz);

		return obj;

	}

	/**
	 * ת�ɶ������ݼ� ���ݼ���ʽ�磺[{"age":0,"charge":10}, {"age":9,"charge":10}]
	 * 
	 * @param json
	 * @return
	 */
	public static List toList(String json) {
		if (StringUtils.isBlank(json))
			return null;

		List result = JSONObject.parseArray(json, List.class);

		return result;
	}

//	public static void main(String[] args) {
//
//		// Person dto=new Person();
//		// dto.setAge(10);
//		// dto.setName("aa");
//		//
//		// String ss = getJsonFromObject2(dto);
//		// System.out.println("������"+ ss);
//		//
//		// String ss2 = getJsonFromObject(dto);
//		//
//		// System.out.println("�����鷽ʽ:"+ss2);
//		//
//		// Person s = (Person)JsonToFormObject(ss, Person.class);
//		//
//		// System.out.println(s.toString());
//		//
//		// List list = JsonToFormList(ss2, Person.class);
//		//
//		// System.out.println(list.get(0).toString());
//		//
//
//	}

}

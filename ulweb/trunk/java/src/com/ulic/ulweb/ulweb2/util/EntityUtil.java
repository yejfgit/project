package com.ulic.ulweb.ulweb2.util;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class EntityUtil {
	public static Map getObjMap(Object o) throws Exception {

		Map<String, Object> objMap = new HashMap<String, Object>();
		
		Class c = o.getClass();
		Method[] m = c.getDeclaredMethods();
		String mName;
		String fName;
		for (int i = 0; i < m.length; i++) {
			//System.out.println(m[i].getName());
			mName = m[i].getName();
			if (mName.startsWith("get")) {
				fName = mName.substring(3, 4).toLowerCase() + mName.substring(4);
				Object fValue = m[i].invoke(o, new Object[] {});
				objMap.put(fName, fValue);
			}
		}
		return objMap;
	}

}

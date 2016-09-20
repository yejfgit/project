package com.survey.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.transform.ResultTransformer;

public class IgnoreCaseTransformer implements ResultTransformer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final Class resultClass;

	private Map setMethods = new HashMap();

	public IgnoreCaseTransformer(Class resultClass) {
		if (resultClass == null)
			throw new IllegalArgumentException("resultClass cannot be null");

		Method[] ms = resultClass.getMethods();
		for (int i = 0; i < ms.length; i++) {
			String mn = ms[i].getName();
			if (mn.startsWith("set") && mn.length() >= 4
					&& ms[i].getParameterTypes().length == 1) {
				String p = mn.substring(3);
				setMethods.put(p.toUpperCase(), ms[i]);
			}
		}
		this.resultClass = resultClass;

	}

	public Object transformTuple(Object[] tuple, String[] aliases) {
		Object result = null;
		try {
			result = resultClass.newInstance();
			for (int i = 0; i < tuple.length; i++) {
				if (tuple[i] != null) {
					Method m = (Method) setMethods.get(aliases[i]);
					if (m != null) {
						Class c = m.getParameterTypes()[0];
						Class valueClass = tuple[i].getClass();
						if (c.equals(tuple.getClass())
								|| (c.isAssignableFrom(valueClass))) {
							m.invoke(result, new Object[] { tuple[i] });
						} else {

							String valstr = tuple[i].toString();

							if (java.util.Date.class
									.isAssignableFrom(valueClass)
									|| valueClass.equals(java.util.Date.class)) {
								java.util.Date t = (Date) tuple[i];
								if (java.sql.Timestamp.class
										.isAssignableFrom(c)) {
									m
											.invoke(
													result,
													new Object[] { new java.sql.Timestamp(
															t.getTime()) });
								}else

								if (java.sql.Date.class.isAssignableFrom(c)) {
									m.invoke(result,
											new Object[] { new java.sql.Date(t
													.getTime()) });
								}

							} else if (String.class.isAssignableFrom(c)) {
								m.invoke(result, new Object[] { valstr });
							} else if (int.class.isAssignableFrom(c)) {
								m.invoke(result, new Object[] { Integer
										.valueOf(valstr) });
							} else if (long.class.isAssignableFrom(c)) {
								m.invoke(result, new Object[] { Long
										.valueOf(valstr) });
							} else if (BigDecimal.class.isAssignableFrom(c)) {
								m.invoke(result, new Object[] { new BigDecimal(
										valstr) });
							} else if (Integer.class.isAssignableFrom(c)) {
								m.invoke(result, new Object[] { new Integer(
										valstr) });
							} else if (BigInteger.class.isAssignableFrom(c)) {
								m.invoke(result, new Object[] { new BigInteger(
										valstr) });
							} else if (Long.class.isAssignableFrom(c)) {
								m.invoke(result,
										new Object[] { new Long(valstr) });
							} else if (boolean.class.isAssignableFrom(c)) {
								m.invoke(result,
										new Object[] {  Boolean.valueOf(valstr) });
							} else if (Boolean.class.isAssignableFrom(c)) {
								m.invoke(result,
										new Object[] {  Boolean.valueOf(valstr) });
							}
						}
					}

				}
			}
		} catch (InstantiationException e) {

			e.printStackTrace();
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		} catch (IllegalArgumentException e) {

			e.printStackTrace();
		} catch (InvocationTargetException e) {

			e.printStackTrace();
		}

		return result;
	}

	public List transformList(List collection) {
		return collection;
	}

}

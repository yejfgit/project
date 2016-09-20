package com.ulic.ulweb.frame.service;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.SQLException;
import com.ulic.ulweb.frame.constant.Constant;
import com.ulic.ulweb.frame.dao.ConnectionFactory;

public class ServiceProxy implements InvocationHandler, Serializable {
	private Object service;
	private ServiceProxy(Object service) {
		this.service = service;
	}
	public static Object newInstance(Object obj) {
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),
				new ServiceProxy(obj));
	}
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		String methodName = method.getName();
		if (methodName.startsWith(Constant.FIND) || methodName.startsWith(Constant.COUNT)
				|| methodName.startsWith(Constant.GET) || methodName.startsWith(Constant.LOAD)) {
			return this.invoke(method, args);
		}
		else {
			return this.transactionInvoke(method, args);
		}
	}
	private Object transactionInvoke(Method method, Object[] args) throws IllegalArgumentException,
			IllegalAccessException, InvocationTargetException, Exception {
		Object res = null;
		try {
			ConnectionFactory.beginTransaction();
			res = method.invoke(service, args);
			ConnectionFactory.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			try {
				ConnectionFactory.rollback();
			}
			catch (Exception e1) {
				e.printStackTrace();
			}
			throw e;
		}
		finally {
			try {
				ConnectionFactory.closeConnection();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}
	private Object invoke(Method method, Object[] args) throws IllegalArgumentException,
			IllegalAccessException, InvocationTargetException, Exception {
		Object res = null;
		try {
			res = method.invoke(service, args);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw  e;
		}
		finally {
			try {
				ConnectionFactory.closeConnection();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}
}
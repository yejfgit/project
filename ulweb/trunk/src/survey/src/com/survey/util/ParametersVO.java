package com.survey.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ParametersVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String beanName;

	private Class interfaceClass;

	private String methodName;

	private Object[] args;

	private Class[] classNames;

	private boolean compressFlag = false;

	private byte[] classesObject;

	private void compress() {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream o = new ObjectOutputStream(baos);
			if (this.classNames != null) {
				o.writeObject(this.classNames);
				o.flush();
				this.classesObject = baos.toByteArray();
				this.classNames = null;
				this.compressFlag = true;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void uncompress() {
		try {
			if (this.compressFlag) {
				ObjectInputStream ois = new ObjectInputStream(
						new ByteArrayInputStream(this.classesObject));
				Object obj = ois.readObject();
				this.classNames = (Class[]) obj;
				this.compressFlag = false;
				this.classesObject = null;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Object[] getArgs() {
		return args;
	}

	public void setArgs(Object[] args) {
		this.args = args;
	}

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public Class[] getClassNames() {
		uncompress();
		return classNames;
	}

	public void setClassNames(Class[] classNames) {

		this.classNames = classNames;
		compress();
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public Class getInterfaceClass() {
		return interfaceClass;
	}

	public void setInterfaceClass(Class interfaceClass) {
		this.interfaceClass = interfaceClass;
	}

}

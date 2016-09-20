/**
 * GetJobResultsResponseType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package com.ulic.ulweb.ulweb2.service.convert;

import java.io.InputStream;

import javax.activation.DataHandler;

public class GetJobResultsResponseType implements java.io.Serializable {
	private int jobStatus;
	private java.lang.String jdfData;
	private java.lang.String psLogData;
	private java.lang.String resultURL;
	private java.lang.String jdfURL;
	private java.lang.String psLogURL;
	private int returnCode;
	private java.lang.String returnMessage;

	private DataHandler dataHandler=null;

	public DataHandler getDataHandler() {
		return dataHandler;
	}

	public void setDataHandler(DataHandler dataHandler) {
		this.dataHandler = dataHandler;
	}

	public GetJobResultsResponseType() {
	}

	public int getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(int jobStatus) {
		this.jobStatus = jobStatus;
	}

	public java.lang.String getJdfData() {
		return jdfData;
	}

	public void setJdfData(java.lang.String jdfData) {
		this.jdfData = jdfData;
	}

	public java.lang.String getPsLogData() {
		return psLogData;
	}

	public void setPsLogData(java.lang.String psLogData) {
		this.psLogData = psLogData;
	}

	public java.lang.String getResultURL() {
		return resultURL;
	}

	public void setResultURL(java.lang.String resultURL) {
		this.resultURL = resultURL;
	}

	public java.lang.String getJdfURL() {
		return jdfURL;
	}

	public void setJdfURL(java.lang.String jdfURL) {
		this.jdfURL = jdfURL;
	}

	public java.lang.String getPsLogURL() {
		return psLogURL;
	}

	public void setPsLogURL(java.lang.String psLogURL) {
		this.psLogURL = psLogURL;
	}

	public int getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(int returnCode) {
		this.returnCode = returnCode;
	}

	public java.lang.String getReturnMessage() {
		return returnMessage;
	}

	public void setReturnMessage(java.lang.String returnMessage) {
		this.returnMessage = returnMessage;
	}

	private java.lang.Object __equalsCalc = null;

	public synchronized boolean equals(java.lang.Object obj) {
		if (!(obj instanceof GetJobResultsResponseType))
			return false;
		GetJobResultsResponseType other = (GetJobResultsResponseType) obj;
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		if (__equalsCalc != null) {
			return (__equalsCalc == obj);
		}
		__equalsCalc = obj;
		boolean _equals;
		_equals = true
				&& this.jobStatus == other.getJobStatus()
				&& ((this.jdfData == null && other.getJdfData() == null) || (this.jdfData != null && this.jdfData
						.equals(other.getJdfData())))
				&& ((this.psLogData == null && other.getPsLogData() == null) || (this.psLogData != null && this.psLogData
						.equals(other.getPsLogData())))
				&& ((this.resultURL == null && other.getResultURL() == null) || (this.resultURL != null && this.resultURL
						.equals(other.getResultURL())))
				&& ((this.jdfURL == null && other.getJdfURL() == null) || (this.jdfURL != null && this.jdfURL
						.equals(other.getJdfURL())))
				&& ((this.psLogURL == null && other.getPsLogURL() == null) || (this.psLogURL != null && this.psLogURL
						.equals(other.getPsLogURL())))
				&& this.returnCode == other.getReturnCode()
				&& ((this.returnMessage == null && other.getReturnMessage() == null) || (this.returnMessage != null && this.returnMessage
						.equals(other.getReturnMessage())));
		__equalsCalc = null;
		return _equals;
	}

	private boolean __hashCodeCalc = false;

	public synchronized int hashCode() {
		if (__hashCodeCalc) {
			return 0;
		}
		__hashCodeCalc = true;
		int _hashCode = 1;
		_hashCode += getJobStatus();
		if (getJdfData() != null) {
			_hashCode += getJdfData().hashCode();
		}
		if (getPsLogData() != null) {
			_hashCode += getPsLogData().hashCode();
		}
		if (getResultURL() != null) {
			_hashCode += getResultURL().hashCode();
		}
		if (getJdfURL() != null) {
			_hashCode += getJdfURL().hashCode();
		}
		if (getPsLogURL() != null) {
			_hashCode += getPsLogURL().hashCode();
		}
		_hashCode += getReturnCode();
		if (getReturnMessage() != null) {
			_hashCode += getReturnMessage().hashCode();
		}
		__hashCodeCalc = false;
		return _hashCode;
	}

	// Type metadata
	private static org.apache.axis.description.TypeDesc typeDesc = new org.apache.axis.description.TypeDesc(
			GetJobResultsResponseType.class);

	static {
		typeDesc.setXmlType(new javax.xml.namespace.QName(
				"http://ns.adobe.com/pdfgen/ws7", "getJobResultsResponseType"));
		org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("jobStatus");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"http://ns.adobe.com/pdfgen/ws7", "jobStatus"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "int"));
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("jdfData");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"http://ns.adobe.com/pdfgen/ws7", "jdfData"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("psLogData");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"http://ns.adobe.com/pdfgen/ws7", "psLogData"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("resultURL");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"http://ns.adobe.com/pdfgen/ws7", "resultURL"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("jdfURL");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"http://ns.adobe.com/pdfgen/ws7", "jdfURL"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("psLogURL");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"http://ns.adobe.com/pdfgen/ws7", "psLogURL"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("returnCode");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"http://ns.adobe.com/pdfgen/ws7", "returnCode"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "int"));
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("returnMessage");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"http://ns.adobe.com/pdfgen/ws7", "returnMessage"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		typeDesc.addFieldDesc(elemField);
	}

	/**
	 * Return type metadata object
	 */
	public static org.apache.axis.description.TypeDesc getTypeDesc() {
		return typeDesc;
	}

	/**
	 * Get Custom Serializer
	 */
	public static org.apache.axis.encoding.Serializer getSerializer(
			java.lang.String mechType, java.lang.Class _javaType,
			javax.xml.namespace.QName _xmlType) {
		return new org.apache.axis.encoding.ser.BeanSerializer(_javaType,
				_xmlType, typeDesc);
	}

	/**
	 * Get Custom Deserializer
	 */
	public static org.apache.axis.encoding.Deserializer getDeserializer(
			java.lang.String mechType, java.lang.Class _javaType,
			javax.xml.namespace.QName _xmlType) {
		return new org.apache.axis.encoding.ser.BeanDeserializer(_javaType,
				_xmlType, typeDesc);
	}

}

/**
 * GetJobResultsRequestType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package com.ulic.ulweb.ulweb2.service.convert;

public class GetJobResultsRequestType  implements java.io.Serializable {
    private java.lang.String jobID;
    private int resultAttachmentFormat;
    private java.lang.String locale;

    public GetJobResultsRequestType() {
    }

    public java.lang.String getJobID() {
        return jobID;
    }

    public void setJobID(java.lang.String jobID) {
        this.jobID = jobID;
    }

    public int getResultAttachmentFormat() {
        return resultAttachmentFormat;
    }

    public void setResultAttachmentFormat(int resultAttachmentFormat) {
        this.resultAttachmentFormat = resultAttachmentFormat;
    }

    public java.lang.String getLocale() {
        return locale;
    }

    public void setLocale(java.lang.String locale) {
        this.locale = locale;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetJobResultsRequestType)) return false;
        GetJobResultsRequestType other = (GetJobResultsRequestType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.jobID==null && other.getJobID()==null) || 
             (this.jobID!=null &&
              this.jobID.equals(other.getJobID()))) &&
            this.resultAttachmentFormat == other.getResultAttachmentFormat() &&
            ((this.locale==null && other.getLocale()==null) || 
             (this.locale!=null &&
              this.locale.equals(other.getLocale())));
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
        if (getJobID() != null) {
            _hashCode += getJobID().hashCode();
        }
        _hashCode += getResultAttachmentFormat();
        if (getLocale() != null) {
            _hashCode += getLocale().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetJobResultsRequestType.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ns.adobe.com/pdfgen/ws7", "getJobResultsRequestType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jobID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ns.adobe.com/pdfgen/ws7", "jobID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultAttachmentFormat");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ns.adobe.com/pdfgen/ws7", "resultAttachmentFormat"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("locale");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ns.adobe.com/pdfgen/ws7", "locale"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}

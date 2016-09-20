/**
 * GetConfigRequestType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package com.ulic.ulweb.ulweb2.service.convert;

public class GetConfigRequestType  implements java.io.Serializable {
    private java.lang.String securitySettingName;
    private java.lang.String jobOptionSettingName;
    private java.lang.String filetypeSettingName;
    private java.lang.String locale;

    public GetConfigRequestType() {
    }

    public java.lang.String getSecuritySettingName() {
        return securitySettingName;
    }

    public void setSecuritySettingName(java.lang.String securitySettingName) {
        this.securitySettingName = securitySettingName;
    }

    public java.lang.String getJobOptionSettingName() {
        return jobOptionSettingName;
    }

    public void setJobOptionSettingName(java.lang.String jobOptionSettingName) {
        this.jobOptionSettingName = jobOptionSettingName;
    }

    public java.lang.String getFiletypeSettingName() {
        return filetypeSettingName;
    }

    public void setFiletypeSettingName(java.lang.String filetypeSettingName) {
        this.filetypeSettingName = filetypeSettingName;
    }

    public java.lang.String getLocale() {
        return locale;
    }

    public void setLocale(java.lang.String locale) {
        this.locale = locale;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetConfigRequestType)) return false;
        GetConfigRequestType other = (GetConfigRequestType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.securitySettingName==null && other.getSecuritySettingName()==null) || 
             (this.securitySettingName!=null &&
              this.securitySettingName.equals(other.getSecuritySettingName()))) &&
            ((this.jobOptionSettingName==null && other.getJobOptionSettingName()==null) || 
             (this.jobOptionSettingName!=null &&
              this.jobOptionSettingName.equals(other.getJobOptionSettingName()))) &&
            ((this.filetypeSettingName==null && other.getFiletypeSettingName()==null) || 
             (this.filetypeSettingName!=null &&
              this.filetypeSettingName.equals(other.getFiletypeSettingName()))) &&
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
        if (getSecuritySettingName() != null) {
            _hashCode += getSecuritySettingName().hashCode();
        }
        if (getJobOptionSettingName() != null) {
            _hashCode += getJobOptionSettingName().hashCode();
        }
        if (getFiletypeSettingName() != null) {
            _hashCode += getFiletypeSettingName().hashCode();
        }
        if (getLocale() != null) {
            _hashCode += getLocale().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetConfigRequestType.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ns.adobe.com/pdfgen/ws7", "getConfigRequestType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("securitySettingName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ns.adobe.com/pdfgen/ws7", "securitySettingName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jobOptionSettingName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ns.adobe.com/pdfgen/ws7", "jobOptionSettingName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("filetypeSettingName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ns.adobe.com/pdfgen/ws7", "filetypeSettingName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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

/**
 * SubmitJobRequestType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package com.ulic.ulweb.ulweb2.service.convert;

public class SubmitJobRequestType  implements java.io.Serializable {
    private java.lang.String filename;
    private java.lang.String sourceURL;
    private int sourceType;
    private java.lang.String jobConfig;
    private java.lang.String xmpData;
    private java.lang.String locale;

    public SubmitJobRequestType() {
    }

    public java.lang.String getFilename() {
        return filename;
    }

    public void setFilename(java.lang.String filename) {
        this.filename = filename;
    }

    public java.lang.String getSourceURL() {
        return sourceURL;
    }

    public void setSourceURL(java.lang.String sourceURL) {
        this.sourceURL = sourceURL;
    }

    public int getSourceType() {
        return sourceType;
    }

    public void setSourceType(int sourceType) {
        this.sourceType = sourceType;
    }

    public java.lang.String getJobConfig() {
        return jobConfig;
    }

    public void setJobConfig(java.lang.String jobConfig) {
        this.jobConfig = jobConfig;
    }

    public java.lang.String getXmpData() {
        return xmpData;
    }

    public void setXmpData(java.lang.String xmpData) {
        this.xmpData = xmpData;
    }

    public java.lang.String getLocale() {
        return locale;
    }

    public void setLocale(java.lang.String locale) {
        this.locale = locale;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SubmitJobRequestType)) return false;
        SubmitJobRequestType other = (SubmitJobRequestType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.filename==null && other.getFilename()==null) || 
             (this.filename!=null &&
              this.filename.equals(other.getFilename()))) &&
            ((this.sourceURL==null && other.getSourceURL()==null) || 
             (this.sourceURL!=null &&
              this.sourceURL.equals(other.getSourceURL()))) &&
            this.sourceType == other.getSourceType() &&
            ((this.jobConfig==null && other.getJobConfig()==null) || 
             (this.jobConfig!=null &&
              this.jobConfig.equals(other.getJobConfig()))) &&
            ((this.xmpData==null && other.getXmpData()==null) || 
             (this.xmpData!=null &&
              this.xmpData.equals(other.getXmpData()))) &&
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
        if (getFilename() != null) {
            _hashCode += getFilename().hashCode();
        }
        if (getSourceURL() != null) {
            _hashCode += getSourceURL().hashCode();
        }
        _hashCode += getSourceType();
        if (getJobConfig() != null) {
            _hashCode += getJobConfig().hashCode();
        }
        if (getXmpData() != null) {
            _hashCode += getXmpData().hashCode();
        }
        if (getLocale() != null) {
            _hashCode += getLocale().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SubmitJobRequestType.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ns.adobe.com/pdfgen/ws7", "SubmitJobRequestType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("filename");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ns.adobe.com/pdfgen/ws7", "filename"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sourceURL");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ns.adobe.com/pdfgen/ws7", "sourceURL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sourceType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ns.adobe.com/pdfgen/ws7", "sourceType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jobConfig");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ns.adobe.com/pdfgen/ws7", "jobConfig"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("xmpData");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ns.adobe.com/pdfgen/ws7", "xmpData"));
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

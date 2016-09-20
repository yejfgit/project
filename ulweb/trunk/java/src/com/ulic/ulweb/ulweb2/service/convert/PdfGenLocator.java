/**
 * PdfGenLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package com.ulic.ulweb.ulweb2.service.convert;

public class PdfGenLocator extends org.apache.axis.client.Service implements com.ulic.ulweb.ulweb2.service.convert.PdfGen {
 
    // Use to get a proxy class for PdfGenInterface
    private java.lang.String PdfGenInterface_address = "http://172.86.50.41:8080/pdfg-ws/services/PdfGenInterface";
    public PdfGenLocator(String sWebServiceURL){
        this.PdfGenInterface_address=sWebServiceURL;
    }
    public java.lang.String getPdfGenInterfaceAddress() {
        return PdfGenInterface_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PdfGenInterfaceWSDDServiceName = "PdfGenInterface";

    public java.lang.String getPdfGenInterfaceWSDDServiceName() {
        return PdfGenInterfaceWSDDServiceName;
    }

    public void setPdfGenInterfaceWSDDServiceName(java.lang.String name) {
        PdfGenInterfaceWSDDServiceName = name;
    }

    public com.ulic.ulweb.ulweb2.service.convert.PdfGenInterface getPdfGenInterface() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(PdfGenInterface_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPdfGenInterface(endpoint);
    }

    public com.ulic.ulweb.ulweb2.service.convert.PdfGenInterface getPdfGenInterface(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.ulic.ulweb.ulweb2.service.convert.PdfGenInterfaceSoapBindingStub _stub = new com.ulic.ulweb.ulweb2.service.convert.PdfGenInterfaceSoapBindingStub(portAddress, this);
            _stub.setPortName(getPdfGenInterfaceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.ulic.ulweb.ulweb2.service.convert.PdfGenInterface.class.isAssignableFrom(serviceEndpointInterface)) {
                com.ulic.ulweb.ulweb2.service.convert.PdfGenInterfaceSoapBindingStub _stub = new com.ulic.ulweb.ulweb2.service.convert.PdfGenInterfaceSoapBindingStub(new java.net.URL(PdfGenInterface_address), this);
                _stub.setPortName(getPdfGenInterfaceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        String inputPortName = portName.getLocalPart();
        if ("PdfGenInterface".equals(inputPortName)) {
            return getPdfGenInterface();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ns.adobe.com/pdfgen/ws7", "PdfGen");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("PdfGenInterface"));
        }
        return ports.iterator();
    }

}

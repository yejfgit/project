package com.ulic.ulweb.ulweb2.service.convert;
///**
// * AAESLocator.java
// *
// * This file was auto-generated from WSDL
// * by the Apache Axis WSDL2Java emitter.
// */
//
//package com.adobe.ns.pdfgen.ws7;
//
//public class AAESLocator extends org.apache.axis.client.Service implements com.adobe.ns.pdfgen.ws7.AAES {
//
//    // Use to get a proxy class for AAESPort
//    private final java.lang.String AAESPort_address = "http://172.86.50.41:8080/pdfg-ws/services/AAESPort";
//
//    public java.lang.String getAAESPortAddress() {
//        return AAESPort_address;
//    }
//
//    // The WSDD service name defaults to the port name.
//    private java.lang.String AAESPortWSDDServiceName = "AAESPort";
//
//    public java.lang.String getAAESPortWSDDServiceName() {
//        return AAESPortWSDDServiceName;
//    }
//
//    public void setAAESPortWSDDServiceName(java.lang.String name) {
//        AAESPortWSDDServiceName = name;
//    }
//
//    public com.adobe.ns.pdfgen.ws7.AAESPort getAAESPort() throws javax.xml.rpc.ServiceException {
//       java.net.URL endpoint;
//        try {
//            endpoint = new java.net.URL(AAESPort_address);
//        }
//        catch (java.net.MalformedURLException e) {
//            throw new javax.xml.rpc.ServiceException(e);
//        }
//        return getAAESPort(endpoint);
//    }
//
//    public com.adobe.ns.pdfgen.ws7.AAESPort getAAESPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
//        try {
//            com.adobe.ns.pdfgen.ws7.AAESPortSoapBindingStub _stub = new com.adobe.ns.pdfgen.ws7.AAESPortSoapBindingStub(portAddress, this);
//            _stub.setPortName(getAAESPortWSDDServiceName());
//            return _stub;
//        }
//        catch (org.apache.axis.AxisFault e) {
//            return null;
//        }
//    }
//
//    /**
//     * For the given interface, get the stub implementation.
//     * If this service has no port for the given interface,
//     * then ServiceException is thrown.
//     */
//    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
//        try {
//            if (com.adobe.ns.pdfgen.ws7.AAESPort.class.isAssignableFrom(serviceEndpointInterface)) {
//                com.adobe.ns.pdfgen.ws7.AAESPortSoapBindingStub _stub = new com.adobe.ns.pdfgen.ws7.AAESPortSoapBindingStub(new java.net.URL(AAESPort_address), this);
//                _stub.setPortName(getAAESPortWSDDServiceName());
//                return _stub;
//            }
//        }
//        catch (java.lang.Throwable t) {
//            throw new javax.xml.rpc.ServiceException(t);
//        }
//        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
//    }
//
//    /**
//     * For the given interface, get the stub implementation.
//     * If this service has no port for the given interface,
//     * then ServiceException is thrown.
//     */
//    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
//        if (portName == null) {
//            return getPort(serviceEndpointInterface);
//        }
//        String inputPortName = portName.getLocalPart();
//        if ("AAESPort".equals(inputPortName)) {
//            return getAAESPort();
//        }
//        else  {
//            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
//            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
//            return _stub;
//        }
//    }
//
//    public javax.xml.namespace.QName getServiceName() {
//        return new javax.xml.namespace.QName("http://ns.adobe.com/pdfgen/ws7", "AAES");
//    }
//
//    private java.util.HashSet ports = null;
//
//    public java.util.Iterator getPorts() {
//        if (ports == null) {
//            ports = new java.util.HashSet();
//            ports.add(new javax.xml.namespace.QName("AAESPort"));
//        }
//        return ports.iterator();
//    }
//
//}

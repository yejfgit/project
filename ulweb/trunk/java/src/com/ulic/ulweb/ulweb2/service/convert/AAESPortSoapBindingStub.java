package com.ulic.ulweb.ulweb2.service.convert;
///**
// * AAESPortSoapBindingStub.java
// *
// * This file was auto-generated from WSDL
// * by the Apache Axis WSDL2Java emitter.
// */
//
//package com.indigopacific.adobe.ns.pdfgen.ws7;
//
//import org.apache.axis.constants.Style;
//import org.apache.axis.constants.Use;
//
//public class AAESPortSoapBindingStub extends org.apache.axis.client.Stub implements com.indigopacific.adobe.ns.pdfgen.ws7.AAESPort {
// //   private java.util.Vector cachedSerClasses = new java.util.Vector();
// //   private java.util.Vector cachedSerQNames = new java.util.Vector();
// //   private java.util.Vector cachedSerFactories = new java.util.Vector();
// //   private java.util.Vector cachedDeserFactories = new java.util.Vector();
//
//    static org.apache.axis.description.OperationDesc [] _operations;
//
//    static {
//        _operations = new org.apache.axis.description.OperationDesc[5];
//        org.apache.axis.description.OperationDesc oper;
//        oper = new org.apache.axis.description.OperationDesc();
//        oper.setName("createPDF");
//        oper.addParameter(new javax.xml.namespace.QName("", "sourceURL"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
//        oper.addParameter(new javax.xml.namespace.QName("", "sourceFilename"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
//        oper.addParameter(new javax.xml.namespace.QName("", "jobOptions"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
//        oper.addParameter(new javax.xml.namespace.QName("", "mimeType"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
//        oper.addParameter(new javax.xml.namespace.QName("", "status"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, org.apache.axis.description.ParameterDesc.OUT, false, false);
//        oper.addParameter(new javax.xml.namespace.QName("", "errorMessage"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.OUT, false, false);
//        oper.addParameter(new javax.xml.namespace.QName("", "jobID"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.OUT, false, false);
//        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
//        oper.setStyle(Style.getStyle("rpc"));
//        oper.setUse(Use.getUse("encoded"));
//        _operations[0] = oper;
//
//        oper = new org.apache.axis.description.OperationDesc();
//        oper.setName("createPDFBase64");
//        oper.addParameter(new javax.xml.namespace.QName("", "sourceData"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
//        oper.addParameter(new javax.xml.namespace.QName("", "sourceFilename"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
//        oper.addParameter(new javax.xml.namespace.QName("", "jobOptions"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
//        oper.addParameter(new javax.xml.namespace.QName("", "mimeType"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
//        oper.addParameter(new javax.xml.namespace.QName("", "status"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, org.apache.axis.description.ParameterDesc.OUT, false, false);
//        oper.addParameter(new javax.xml.namespace.QName("", "errorMessage"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.OUT, false, false);
//        oper.addParameter(new javax.xml.namespace.QName("", "jobID"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.OUT, false, false);
//        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
//        oper.setStyle(Style.getStyle("rpc"));
//        oper.setUse(Use.getUse("encoded"));
//        _operations[1] = oper;
//
//        oper = new org.apache.axis.description.OperationDesc();
//        oper.setName("createPDFStatus");
//        oper.addParameter(new javax.xml.namespace.QName("", "jobID"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
//        oper.addParameter(new javax.xml.namespace.QName("", "status"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, org.apache.axis.description.ParameterDesc.OUT, false, false);
//        oper.addParameter(new javax.xml.namespace.QName("", "errorMessage"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.OUT, false, false);
//        oper.addParameter(new javax.xml.namespace.QName("", "resultURL"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.OUT, false, false);
//        oper.addParameter(new javax.xml.namespace.QName("", "resultFilename"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.OUT, false, false);
//        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
//        oper.setStyle(Style.getStyle("rpc"));
//        oper.setUse(Use.getUse("encoded"));
//        _operations[2] = oper;
//
//        oper = new org.apache.axis.description.OperationDesc();
//        oper.setName("createPDFBase64Status");
//        oper.addParameter(new javax.xml.namespace.QName("", "jobID"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
//        oper.addParameter(new javax.xml.namespace.QName("", "status"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, org.apache.axis.description.ParameterDesc.OUT, false, false);
//        oper.addParameter(new javax.xml.namespace.QName("", "errorMessage"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.OUT, false, false);
//        oper.addParameter(new javax.xml.namespace.QName("", "resultData"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.OUT, false, false);
//        oper.addParameter(new javax.xml.namespace.QName("", "resultFilename"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.OUT, false, false);
//        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
//        oper.setStyle(Style.getStyle("rpc"));
//        oper.setUse(Use.getUse("encoded"));
//        _operations[3] = oper;
//
//        oper = new org.apache.axis.description.OperationDesc();
//        oper.setName("deleteJob");
//        oper.addParameter(new javax.xml.namespace.QName("", "jobID"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
//        oper.addParameter(new javax.xml.namespace.QName("", "status"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, org.apache.axis.description.ParameterDesc.OUT, false, false);
//        oper.addParameter(new javax.xml.namespace.QName("", "errorMessage"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.OUT, false, false);
//        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
//        oper.setStyle(Style.getStyle("rpc"));
//        oper.setUse(Use.getUse("encoded"));
//        _operations[4] = oper;
//
//    }
//
//    public AAESPortSoapBindingStub() throws org.apache.axis.AxisFault {
//         this(null);
//    }
//
//    public AAESPortSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
//         this(service);
//         super.cachedEndpoint = endpointURL;
//    }
//
//    public AAESPortSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
//        if (service == null) {
//            super.service = new org.apache.axis.client.Service();
//        } else {
//            super.service = service;
//        }
//    }
//
//    private org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
//        try {
//            org.apache.axis.client.Call _call =
//                    (org.apache.axis.client.Call) super.service.createCall();
//            if (super.maintainSessionSet) {
//                _call.setMaintainSession(super.maintainSession);
//            }
//            if (super.cachedUsername != null) {
//                _call.setUsername(super.cachedUsername);
//            }
//            if (super.cachedPassword != null) {
//                _call.setPassword(super.cachedPassword);
//            }
//            if (super.cachedEndpoint != null) {
//                _call.setTargetEndpointAddress(super.cachedEndpoint);
//            }
//            if (super.cachedTimeout != null) {
//                _call.setTimeout(super.cachedTimeout);
//            }
//            if (super.cachedPortName != null) {
//                _call.setPortName(super.cachedPortName);
//            }
//            java.util.Enumeration keys = super.cachedProperties.keys();
//            while (keys.hasMoreElements()) {
//                java.lang.String key = (java.lang.String) keys.nextElement();
//                _call.setProperty(key, super.cachedProperties.get(key));
//            }
//            return _call;
//        }
//        catch (java.lang.Throwable t) {
//            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", t);
//        }
//    }
//
//    public void createPDF(java.lang.String sourceURL, java.lang.String sourceFilename, java.lang.String jobOptions, java.lang.String mimeType, javax.xml.rpc.holders.IntHolder status, javax.xml.rpc.holders.StringHolder errorMessage, javax.xml.rpc.holders.StringHolder jobID) throws java.rmi.RemoteException {
//        if (super.cachedEndpoint == null) {
//            throw new org.apache.axis.NoEndPointException();
//        }
//        org.apache.axis.client.Call _call = createCall();
//        _call.setOperation(_operations[0]);
//        _call.setUseSOAPAction(true);
//        _call.setSOAPActionURI("");
//        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
//        _call.setOperationName(new javax.xml.namespace.QName("http://ns.adobe.com/pdfgen/ws7", "createPDF"));
//
//        setRequestHeaders(_call);
//        setAttachments(_call);
//        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sourceURL, sourceFilename, jobOptions, mimeType});
//
//        if (_resp instanceof java.rmi.RemoteException) {
//            throw (java.rmi.RemoteException)_resp;
//        }
//        else {
//            extractAttachments(_call);
//            java.util.Map _output;
//            _output = _call.getOutputParams();
//            try {
//                status.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "status"))).intValue();
//            } catch (java.lang.Exception _exception) {
//                status.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "status")), int.class)).intValue();
//            }
//            try {
//                errorMessage.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "errorMessage"));
//            } catch (java.lang.Exception _exception) {
//                errorMessage.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "errorMessage")), java.lang.String.class);
//            }
//            try {
//                jobID.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "jobID"));
//            } catch (java.lang.Exception _exception) {
//                jobID.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "jobID")), java.lang.String.class);
//            }
//        }
//    }
//
//    public void createPDFBase64(java.lang.String sourceData, java.lang.String sourceFilename, java.lang.String jobOptions, java.lang.String mimeType, javax.xml.rpc.holders.IntHolder status, javax.xml.rpc.holders.StringHolder errorMessage, javax.xml.rpc.holders.StringHolder jobID) throws java.rmi.RemoteException {
//        if (super.cachedEndpoint == null) {
//            throw new org.apache.axis.NoEndPointException();
//        }
//        org.apache.axis.client.Call _call = createCall();
//        _call.setOperation(_operations[1]);
//        _call.setUseSOAPAction(true);
//        _call.setSOAPActionURI("");
//        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
//        _call.setOperationName(new javax.xml.namespace.QName("http://ns.adobe.com/pdfgen/ws7", "createPDFBase64"));
//
//        setRequestHeaders(_call);
//        setAttachments(_call);
//        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sourceData, sourceFilename, jobOptions, mimeType});
//
//        if (_resp instanceof java.rmi.RemoteException) {
//            throw (java.rmi.RemoteException)_resp;
//        }
//        else {
//            extractAttachments(_call);
//            java.util.Map _output;
//            _output = _call.getOutputParams();
//            try {
//                status.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "status"))).intValue();
//            } catch (java.lang.Exception _exception) {
//                status.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "status")), int.class)).intValue();
//            }
//            try {
//                errorMessage.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "errorMessage"));
//            } catch (java.lang.Exception _exception) {
//                errorMessage.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "errorMessage")), java.lang.String.class);
//            }
//            try {
//                jobID.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "jobID"));
//            } catch (java.lang.Exception _exception) {
//                jobID.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "jobID")), java.lang.String.class);
//            }
//        }
//    }
//
//    public void createPDFStatus(java.lang.String jobID, javax.xml.rpc.holders.IntHolder status, javax.xml.rpc.holders.StringHolder errorMessage, javax.xml.rpc.holders.StringHolder resultURL, javax.xml.rpc.holders.StringHolder resultFilename) throws java.rmi.RemoteException {
//        if (super.cachedEndpoint == null) {
//            throw new org.apache.axis.NoEndPointException();
//        }
//        org.apache.axis.client.Call _call = createCall();
//        _call.setOperation(_operations[2]);
//        _call.setUseSOAPAction(true);
//        _call.setSOAPActionURI("");
//        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
//        _call.setOperationName(new javax.xml.namespace.QName("http://ns.adobe.com/pdfgen/ws7", "createPDFStatus"));
//
//        setRequestHeaders(_call);
//        setAttachments(_call);
//        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {jobID});
//
//        if (_resp instanceof java.rmi.RemoteException) {
//            throw (java.rmi.RemoteException)_resp;
//        }
//        else {
//            extractAttachments(_call);
//            java.util.Map _output;
//            _output = _call.getOutputParams();
//            try {
//                status.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "status"))).intValue();
//            } catch (java.lang.Exception _exception) {
//                status.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "status")), int.class)).intValue();
//            }
//            try {
//                errorMessage.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "errorMessage"));
//            } catch (java.lang.Exception _exception) {
//                errorMessage.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "errorMessage")), java.lang.String.class);
//            }
//            try {
//                resultURL.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "resultURL"));
//            } catch (java.lang.Exception _exception) {
//                resultURL.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "resultURL")), java.lang.String.class);
//            }
//            try {
//                resultFilename.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "resultFilename"));
//            } catch (java.lang.Exception _exception) {
//                resultFilename.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "resultFilename")), java.lang.String.class);
//            }
//        }
//    }
//
//    public void createPDFBase64Status(java.lang.String jobID, javax.xml.rpc.holders.IntHolder status, javax.xml.rpc.holders.StringHolder errorMessage, javax.xml.rpc.holders.StringHolder resultData, javax.xml.rpc.holders.StringHolder resultFilename) throws java.rmi.RemoteException {
//        if (super.cachedEndpoint == null) {
//            throw new org.apache.axis.NoEndPointException();
//        }
//        org.apache.axis.client.Call _call = createCall();
//        _call.setOperation(_operations[3]);
//        _call.setUseSOAPAction(true);
//        _call.setSOAPActionURI("");
//        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
//        _call.setOperationName(new javax.xml.namespace.QName("http://ns.adobe.com/pdfgen/ws7", "createPDFBase64Status"));
//
//        setRequestHeaders(_call);
//        setAttachments(_call);
//        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {jobID});
//
//        if (_resp instanceof java.rmi.RemoteException) {
//            throw (java.rmi.RemoteException)_resp;
//        }
//        else {
//            extractAttachments(_call);
//            java.util.Map _output;
//            _output = _call.getOutputParams();
//            try {
//                status.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "status"))).intValue();
//            } catch (java.lang.Exception _exception) {
//                status.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "status")), int.class)).intValue();
//            }
//            try {
//                errorMessage.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "errorMessage"));
//            } catch (java.lang.Exception _exception) {
//                errorMessage.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "errorMessage")), java.lang.String.class);
//            }
//            try {
//                resultData.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "resultData"));
//            } catch (java.lang.Exception _exception) {
//                resultData.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "resultData")), java.lang.String.class);
//            }
//            try {
//                resultFilename.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "resultFilename"));
//            } catch (java.lang.Exception _exception) {
//                resultFilename.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "resultFilename")), java.lang.String.class);
//            }
//        }
//    }
//
//    public void deleteJob(java.lang.String jobID, javax.xml.rpc.holders.IntHolder status, javax.xml.rpc.holders.StringHolder errorMessage) throws java.rmi.RemoteException {
//        if (super.cachedEndpoint == null) {
//            throw new org.apache.axis.NoEndPointException();
//        }
//        org.apache.axis.client.Call _call = createCall();
//        _call.setOperation(_operations[4]);
//        _call.setUseSOAPAction(true);
//        _call.setSOAPActionURI("");
//        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
//        _call.setOperationName(new javax.xml.namespace.QName("http://ns.adobe.com/pdfgen/ws7", "deleteJob"));
//
//        setRequestHeaders(_call);
//        setAttachments(_call);
//        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {jobID});
//
//        if (_resp instanceof java.rmi.RemoteException) {
//            throw (java.rmi.RemoteException)_resp;
//        }
//        else {
//            extractAttachments(_call);
//            java.util.Map _output;
//            _output = _call.getOutputParams();
//            try {
//                status.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "status"))).intValue();
//            } catch (java.lang.Exception _exception) {
//                status.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "status")), int.class)).intValue();
//            }
//            try {
//                errorMessage.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "errorMessage"));
//            } catch (java.lang.Exception _exception) {
//                errorMessage.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "errorMessage")), java.lang.String.class);
//            }
//        }
//    }
//
//}

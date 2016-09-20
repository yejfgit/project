/**
 * PdfGenInterfaceSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package com.ulic.ulweb.ulweb2.service.convert;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.Vector;

import javax.activation.DataHandler;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;

import org.apache.axis.AxisEngine;
import org.apache.axis.AxisFault;
import org.apache.axis.Message;
import org.apache.axis.NoEndPointException;
import org.apache.axis.attachments.AttachmentPart;
import org.apache.axis.attachments.Attachments;
import org.apache.axis.client.Call;
import org.apache.axis.constants.Style;
import org.apache.axis.constants.Use;
import org.apache.axis.description.OperationDesc;
import org.apache.axis.description.ParameterDesc;
import org.apache.axis.encoding.ser.BeanDeserializerFactory;
import org.apache.axis.encoding.ser.BeanSerializerFactory;
import org.apache.axis.holders.DateHolder;
import org.apache.axis.soap.SOAPConstants;
import org.apache.axis.utils.JavaUtils;

import com.ulic.ulweb.ulweb2.service.convert.SubmitJobResponseType;

public class PdfGenInterfaceSoapBindingStub extends org.apache.axis.client.Stub
		implements PdfGenInterface {
	private Vector cachedSerClasses = new Vector();

	private Vector cachedSerQNames = new Vector();

	private Vector cachedSerFactories = new Vector();

	private Vector cachedDeserFactories = new Vector();

	static OperationDesc[] _operations;

	static {
		_operations = new OperationDesc[6];
		OperationDesc oper = new OperationDesc();
		oper.setName("submitJob");
		oper.addParameter(new javax.xml.namespace.QName(
				"http://ns.adobe.com/pdfgen/ws7", "request"),
				new javax.xml.namespace.QName("http://ns.adobe.com/pdfgen/ws7",
						"SubmitJobRequestType"),
				com.ulic.ulweb.ulweb2.service.convert.SubmitJobRequestType.class,
				org.apache.axis.description.ParameterDesc.IN, false, false);
		oper.setReturnType(new QName("http://ns.adobe.com/pdfgen/ws7",
				"SubmitJobResponseType"));
		oper.setReturnClass(SubmitJobResponseType.class);
		oper.setReturnQName(new QName("http://ns.adobe.com/pdfgen/ws7",
				"submitJobReturn"));
		oper.setStyle(Style.getStyle("wrapped"));
		oper.setUse(Use.getUse("literal"));

		_operations[0] = oper;

		oper = new OperationDesc();
		oper.setName("submitWebCaptureJob");
		oper.addParameter(
				new QName("http://ns.adobe.com/pdfgen/ws7", "request"),
				new QName("http://ns.adobe.com/pdfgen/ws7",
						"SubmitJobRequestType"), SubmitJobRequestType.class,
				ParameterDesc.IN, false, false);
		oper.setReturnType(new QName("http://ns.adobe.com/pdfgen/ws7",
				"SubmitJobResponseType"));
		oper.setReturnClass(SubmitJobResponseType.class);
		oper.setReturnQName(new javax.xml.namespace.QName(
				"http://ns.adobe.com/pdfgen/ws7", "submitWebCaptureJobReturn"));
		oper.setStyle(Style.getStyle("wrapped"));
		oper.setUse(Use.getUse("literal"));
		_operations[1] = oper;

		oper = new OperationDesc();
		oper.setName("getJobResults");
		oper.addParameter(
				new QName("http://ns.adobe.com/pdfgen/ws7", "request"),
				new QName("http://ns.adobe.com/pdfgen/ws7",
						"getJobResultsRequestType"),
				GetJobResultsRequestType.class, ParameterDesc.IN, false, false);
		oper.setReturnType(new QName("http://ns.adobe.com/pdfgen/ws7",
				"getJobResultsResponseType"));
		oper.setReturnClass(GetJobResultsResponseType.class);
		oper.setReturnQName(new QName("http://ns.adobe.com/pdfgen/ws7",
				"getJobResultsReturn"));
		oper.setStyle(Style.getStyle("wrapped"));
		oper.setUse(Use.getUse("literal"));
		_operations[2] = oper;

		oper = new OperationDesc();
		oper.setName("getJobResultsAsURL");
		oper.addParameter(
				new QName("http://ns.adobe.com/pdfgen/ws7", "request"),
				new QName("http://ns.adobe.com/pdfgen/ws7",
						"getJobResultsRequestType"),
				com.ulic.ulweb.ulweb2.service.convert.GetJobResultsRequestType.class,
				org.apache.axis.description.ParameterDesc.IN, false, false);
		oper.setReturnType(new QName("http://ns.adobe.com/pdfgen/ws7",
				"getJobResultsResponseType"));
		oper
				.setReturnClass(com.ulic.ulweb.ulweb2.service.convert.GetJobResultsResponseType.class);
		oper.setReturnQName(new QName("http://ns.adobe.com/pdfgen/ws7",
				"getJobResultsAsURLReturn"));
		oper.setStyle(Style.getStyle("wrapped"));
		oper.setUse(Use.getUse("literal"));
		_operations[3] = oper;

		oper = new OperationDesc();
		oper.setName("getConfigurationXML");
		oper.addParameter(
				new QName("http://ns.adobe.com/pdfgen/ws7", "request"),
				new QName("http://ns.adobe.com/pdfgen/ws7",
						"getConfigRequestType"),
				com.ulic.ulweb.ulweb2.service.convert.GetConfigRequestType.class,
				org.apache.axis.description.ParameterDesc.IN, false, false);
		oper.setReturnType(new QName("http://ns.adobe.com/pdfgen/ws7",
				"getConfigResponseType"));
		oper
				.setReturnClass(com.ulic.ulweb.ulweb2.service.convert.GetConfigResponseType.class);
		oper.setReturnQName(new QName("http://ns.adobe.com/pdfgen/ws7",
				"getConfigurationXMLReturn"));
		oper.setStyle(Style.getStyle("wrapped"));
		oper.setUse(Use.getUse("literal"));
		_operations[4] = oper;

		oper = new OperationDesc();
		oper.setName("deleteJob");
		oper.addParameter(
				new QName("http://ns.adobe.com/pdfgen/ws7", "request"),
				new QName("http://ns.adobe.com/pdfgen/ws7",
						"deleteJobRequestType"),
				com.ulic.ulweb.ulweb2.service.convert.DeleteJobRequestType.class,
				org.apache.axis.description.ParameterDesc.IN, false, false);
		oper.setReturnType(new QName("http://ns.adobe.com/pdfgen/ws7",
				"deleteJobResponseType"));
		oper.setReturnClass(DeleteJobResponseType.class);
		oper.setReturnQName(new QName("http://ns.adobe.com/pdfgen/ws7",
				"deleteJobReturn"));
		oper.setStyle(Style.getStyle("wrapped"));
		oper.setUse(Use.getUse("literal"));
		_operations[5] = oper;

	}

	public PdfGenInterfaceSoapBindingStub() throws org.apache.axis.AxisFault {
		this(null);
	}

	public PdfGenInterfaceSoapBindingStub(java.net.URL endpointURL,
			javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
		this(service);
		super.cachedEndpoint = endpointURL;
	}

	public PdfGenInterfaceSoapBindingStub(javax.xml.rpc.Service service)
			throws org.apache.axis.AxisFault {
		if (service == null) {
			super.service = new org.apache.axis.client.Service();
		} else {
			super.service = service;
		}
		java.lang.Class cls;
		QName qName;
		java.lang.Class beansf = BeanSerializerFactory.class;
		java.lang.Class beandf = BeanDeserializerFactory.class;
		// java.lang.Class enumsf =
		// org.apache.axis.encoding.ser.EnumSerializerFactory.class;
		// java.lang.Class enumdf =
		// org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
		// java.lang.Class arraysf =
		// org.apache.axis.encoding.ser.ArraySerializerFactory.class;
		// java.lang.Class arraydf =
		// org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
		// java.lang.Class simplesf =
		// org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
		// java.lang.Class simpledf =
		// org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
		qName = new QName("http://ns.adobe.com/pdfgen/ws7",
				"deleteJobResponseType");
		cachedSerQNames.add(qName);
		cls = com.ulic.ulweb.ulweb2.service.convert.DeleteJobResponseType.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new QName("http://ns.adobe.com/pdfgen/ws7",
				"SubmitJobRequestType");
		cachedSerQNames.add(qName);
		cls = SubmitJobRequestType.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new QName("http://ns.adobe.com/pdfgen/ws7",
				"deleteJobRequestType");
		cachedSerQNames.add(qName);
		cls = DeleteJobRequestType.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new QName("http://ns.adobe.com/pdfgen/ws7",
				"getJobResultsResponseType");
		cachedSerQNames.add(qName);
		cls = com.ulic.ulweb.ulweb2.service.convert.GetJobResultsResponseType.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new QName("http://ns.adobe.com/pdfgen/ws7",
				"getConfigResponseType");
		cachedSerQNames.add(qName);
		cls = com.ulic.ulweb.ulweb2.service.convert.GetConfigResponseType.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new QName("http://ns.adobe.com/pdfgen/ws7",
				"SubmitJobResponseType");
		cachedSerQNames.add(qName);
		cls = com.ulic.ulweb.ulweb2.service.convert.SubmitJobResponseType.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new QName("http://ns.adobe.com/pdfgen/ws7",
				"getJobResultsRequestType");
		cachedSerQNames.add(qName);
		cls = com.ulic.ulweb.ulweb2.service.convert.GetJobResultsRequestType.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new QName("http://ns.adobe.com/pdfgen/ws7",
				"getConfigRequestType");
		cachedSerQNames.add(qName);
		cls = com.ulic.ulweb.ulweb2.service.convert.GetConfigRequestType.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

	}

	private Call createCall() throws RemoteException {
		try {
			Call _call = (Call) super.service.createCall();
			if (super.maintainSessionSet) {
				_call.setMaintainSession(super.maintainSession);
			}
			if (super.cachedUsername != null) {
				_call.setUsername(super.cachedUsername);
			}
			if (super.cachedPassword != null) {
				_call.setPassword(super.cachedPassword);
			}
			if (super.cachedEndpoint != null) {
				_call.setTargetEndpointAddress(super.cachedEndpoint);
			}
			if (super.cachedTimeout != null) {
				_call.setTimeout(super.cachedTimeout);
			}
			if (super.cachedPortName != null) {
				_call.setPortName(super.cachedPortName);
			}
			java.util.Enumeration keys = super.cachedProperties.keys();
			while (keys.hasMoreElements()) {
				java.lang.String key = (java.lang.String) keys.nextElement();
				_call.setProperty(key, super.cachedProperties.get(key));
			}
			// All the type mapping information is registered
			// when the first call is made.
			// The type mapping information is actually registered in
			// the TypeMappingRegistry of the service, which
			// is the reason why registration is only needed for the first call.
			synchronized (this) {
				if (firstCall()) {
					// must set encoding style before registering serializers
					_call.setEncodingStyle(null);
					for (int i = 0; i < cachedSerFactories.size(); ++i) {
						java.lang.Class cls = (java.lang.Class) cachedSerClasses
								.get(i);
						QName qName = (QName) cachedSerQNames.get(i);
						java.lang.Class sf = (java.lang.Class) cachedSerFactories
								.get(i);
						java.lang.Class df = (java.lang.Class) cachedDeserFactories
								.get(i);
						_call.registerTypeMapping(cls, qName, sf, df, false);
					}
				}
			}
			return _call;
		} catch (java.lang.Throwable t) {
			throw new AxisFault("Failure trying to get the Call object", t);
		}
	}

	public SubmitJobResponseType submitJob(SubmitJobRequestType request)
			throws java.rmi.RemoteException {
		// request.setLocale(Env.getPreviewScal() + "");
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		}
		Call _call = createCall();
		_call.setOperation(_operations[0]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setEncodingStyle(null);
		_call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
		_call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
		_call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new QName("http://ns.adobe.com/pdfgen/ws7",
				"submitJob"));

		setRequestHeaders(_call);
		setAttachments(_call);
		Object _resp = _call.invoke(new Object[] { request });

		if (_resp instanceof RemoteException) {
			throw (java.rmi.RemoteException) _resp;
		} else {
			extractAttachments(_call);
			try {
				return (SubmitJobResponseType) _resp;
			} catch (Exception _exception) {
				return (SubmitJobResponseType) JavaUtils.convert(_resp,
						SubmitJobResponseType.class);
			}
		}
	}

	public com.ulic.ulweb.ulweb2.service.convert.SubmitJobResponseType submitWebCaptureJob(
			com.ulic.ulweb.ulweb2.service.convert.SubmitJobRequestType request)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[1]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new QName("http://ns.adobe.com/pdfgen/ws7",
				"submitWebCaptureJob"));

		setRequestHeaders(_call);
		setAttachments(_call);
		Object _resp = _call.invoke(new Object[] { request });

		if (_resp instanceof RemoteException) {
			throw (RemoteException) _resp;
		} else {
			extractAttachments(_call);
			try {
				return (SubmitJobResponseType) _resp;
			} catch (Exception _exception) {
				return (SubmitJobResponseType) org.apache.axis.utils.JavaUtils
						.convert(_resp, SubmitJobResponseType.class);
			}
		}
	}

	public GetJobResultsResponseType getJobResults(
			GetJobResultsRequestType request) throws RemoteException {
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		}
		Call _call = createCall();
		_call.setOperation(_operations[2]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new QName("http://ns.adobe.com/pdfgen/ws7",
				"getJobResults"));

		setRequestHeaders(_call);
		setAttachments(_call);
		Object _resp = _call.invoke(new Object[] { request });

		if (_resp instanceof RemoteException) {
			throw (RemoteException) _resp;
		} else {
			if (_resp instanceof RemoteException) {
				throw (RemoteException) _resp;
			} else {

				try {
					GetJobResultsResponseType resp = (GetJobResultsResponseType) _resp;
					resp
							.setDataHandler(getDataByCall(_call, request
									.getJobID()));
					return resp;
				} catch (Exception _exception) {
					return (GetJobResultsResponseType) JavaUtils.convert(_resp,
							GetJobResultsResponseType.class);
				}
			}
		}
	}

	public GetJobResultsResponseType getJobResultsAsURL(
			GetJobResultsRequestType request) throws RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[3]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new QName("http://ns.adobe.com/pdfgen/ws7",
				"getJobResultsAsURL"));

		setRequestHeaders(_call);
		setAttachments(_call);
		Object _resp = _call.invoke(new Object[] { request });

		if (_resp instanceof RemoteException) {
			throw (RemoteException) _resp;
		} else {
			extractAttachments(_call);
			try {
				return (GetJobResultsResponseType) _resp;
			} catch (java.lang.Exception _exception) {
				return (GetJobResultsResponseType) org.apache.axis.utils.JavaUtils
						.convert(_resp, GetJobResultsResponseType.class);
			}
		}
	}

	public GetConfigResponseType getConfigurationXML(
			GetConfigRequestType request) throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		}
		Call _call = createCall();
		_call.setOperation(_operations[4]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new QName("http://ns.adobe.com/pdfgen/ws7",
				"getConfigurationXML"));

		setRequestHeaders(_call);
		setAttachments(_call);
		Object _resp = _call.invoke(new Object[] { request });

		if (_resp instanceof java.rmi.RemoteException) {
			throw (java.rmi.RemoteException) _resp;
		} else {
			extractAttachments(_call);
			try {
				return (com.ulic.ulweb.ulweb2.service.convert.GetConfigResponseType) _resp;
			} catch (java.lang.Exception _exception) {
				return (com.ulic.ulweb.ulweb2.service.convert.GetConfigResponseType) org.apache.axis.utils.JavaUtils
						.convert(
								_resp,
								com.ulic.ulweb.ulweb2.service.convert.GetConfigResponseType.class);
			}
		}
	}

	public com.ulic.ulweb.ulweb2.service.convert.DeleteJobResponseType deleteJob(
			com.ulic.ulweb.ulweb2.service.convert.DeleteJobRequestType request)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[5]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new QName("http://ns.adobe.com/pdfgen/ws7",
				"deleteJob"));

		setRequestHeaders(_call);
		setAttachments(_call);
		Object _resp = _call.invoke(new Object[] { request });

		if (_resp instanceof java.rmi.RemoteException) {
			throw (java.rmi.RemoteException) _resp;
		} else {
			extractAttachments(_call);
			try {
				return (com.ulic.ulweb.ulweb2.service.convert.DeleteJobResponseType) _resp;
			} catch (java.lang.Exception _exception) {
				return (com.ulic.ulweb.ulweb2.service.convert.DeleteJobResponseType) org.apache.axis.utils.JavaUtils
						.convert(
								_resp,
								com.ulic.ulweb.ulweb2.service.convert.DeleteJobResponseType.class);
			}
		}
	}

	/**
	 * 
	 * myAddAttachment: hand code to add the document to convert as a SOAP
	 * attachment in the SOAP message for the submitJob method.
	 * 
	 * @param call
	 * @param sourceFile :
	 *            points to an accessible file path to pick up the document to
	 *            be sent as a SOAP attachment (e.g. "C:\input.doc")
	 * @param attachmentFormat
	 */
	private void myAddAttachment(Call call, DataHandler dhSource,
			int attachmentFormat) {
		// File infile = new File(sourceFile);
		// if (infile.exists()) {
		String propType;
		String propVal;
		// set SOAP attachment type:
		if (attachmentFormat == 0) {
			// DIME format
			propType = Call.ATTACHMENT_ENCAPSULATION_FORMAT;
			propVal = Call.ATTACHMENT_ENCAPSULATION_FORMAT_DIME;
		} else {
			// MIME format
			propType = Call.ATTACHMENT_ENCAPSULATION_FORMAT;
			propVal = Call.ATTACHMENT_ENCAPSULATION_FORMAT_MIME;
		}
		call.setProperty(propType, propVal);
		// add the attachment
		// DataHandler dhSource = new DataHandler(new FileDataSource(
		// sourceFile));
		call.addAttachmentPart(dhSource);
		// }
	}

	
    
	/**
	 * 获取转换后的输出流
	 * @param call
	 * @param jobid
	 * @return
	 * @throws IOException
	 * @throws SOAPException
	 */
	private DataHandler getDataByCall(Call call, String jobid)
			throws IOException, SOAPException {
		DataHandler dataHandler = null;
		Message respMsg = call.getResponseMessage();
		Attachments messageAttachments = respMsg.getAttachmentsImpl();
		if (null == messageAttachments)
			return null;

		int attachmentCount = messageAttachments.getAttachmentCount();

		if (attachmentCount == 0)
			return null;
		// AttachmentPart attachments[] = new AttachmentPart[attachmentCount];
		Iterator it = messageAttachments.getAttachments().iterator();
		// int count = 0;
		if (it.hasNext()) {
			AttachmentPart part = (AttachmentPart) it.next();

			return part.getDataHandler();

		}

		return dataHandler;
	}

	public GetJobResultsResponseType getJobResults(
			GetJobResultsRequestType request, DataHandler dhSource)
			throws java.rmi.RemoteException {
		// request.setLocale("" + Env.getPreviewScal() + "");

		org.apache.axis.client.Call _call = createCall();

		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}

		_call.setOperation(_operations[2]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new QName("http://ns.adobe.com/pdfgen/ws7",
				"getJobResults"));

		setRequestHeaders(_call);
		setAttachments(_call);
		Object _resp = _call.invoke(new Object[] { request });

		if (_resp instanceof java.rmi.RemoteException) {
			throw (java.rmi.RemoteException) _resp;
		} else {
			// extractAttachments(_call);
			// InputStream is[]={null,null};

			// try {
			// if(request.getJobID().startsWith("indigo-")){
			// this.myGetAttachment(_call);
			// }
			// else{
			// this.getAttachment(_call);
			// }
			// } catch (Exception e) {
			//                    
			// e.printStackTrace();
			// }

			try {
				GetJobResultsResponseType resp = (GetJobResultsResponseType) _resp;
				// resp.setInputStream(is);
				return resp;
			} catch (java.lang.Exception _exception) {
				return (GetJobResultsResponseType) JavaUtils.convert(_resp,
						GetJobResultsResponseType.class);
			}
		}
	}

	public SubmitJobResponseType submitJob(SubmitJobRequestType request,
			DataHandler dhSource, int attachmentFormat) throws RemoteException {
		// request.setLocale(Env.getPreviewScal() + "");
		_call = createCall();
		// comment the original setAttachments() call:
		setAttachments(_call);
		//
		// NOTE: add source file as SOAP attachment BEFORE calling
		// call.invoke():
		//
		myAddAttachment(_call, dhSource, attachmentFormat);

		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}

		_call.setOperation(_operations[0]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setEncodingStyle(null);
		_call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
		_call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
		_call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new QName("http://ns.adobe.com/pdfgen/ws7",
				"submitJob"));

		setRequestHeaders(_call);
		setAttachments(_call);
		Object _resp = _call.invoke(new Object[] { request });

		if (_resp instanceof RemoteException) {
			throw (RemoteException) _resp;
		} else {
			extractAttachments(_call);
			try {
				return (SubmitJobResponseType) _resp;
			} catch (Exception _exception) {
				return (SubmitJobResponseType) JavaUtils.convert(_resp,
						SubmitJobResponseType.class);
			}
		}
	}
	// getJobResults() method with code to extract converted file
	// as SOAP attachment:

}

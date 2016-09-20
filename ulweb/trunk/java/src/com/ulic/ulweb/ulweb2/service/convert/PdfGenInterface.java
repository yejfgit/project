/**
 * PdfGenInterface.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package com.ulic.ulweb.ulweb2.service.convert;

import java.rmi.RemoteException;

import javax.activation.DataHandler;

public interface PdfGenInterface extends java.rmi.Remote {
	
	public SubmitJobResponseType submitJob(SubmitJobRequestType request)
			throws RemoteException;

	public SubmitJobResponseType submitWebCaptureJob(
			SubmitJobRequestType request) throws RemoteException;

	public GetJobResultsResponseType getJobResults(
			GetJobResultsRequestType request) throws RemoteException;

	public GetJobResultsResponseType getJobResultsAsURL(
			GetJobResultsRequestType request) throws RemoteException;

	public com.ulic.ulweb.ulweb2.service.convert.GetConfigResponseType getConfigurationXML(
			com.ulic.ulweb.ulweb2.service.convert.GetConfigRequestType request)
			throws RemoteException;

	public com.ulic.ulweb.ulweb2.service.convert.DeleteJobResponseType deleteJob(
			com.ulic.ulweb.ulweb2.service.convert.DeleteJobRequestType request)
			throws RemoteException;

	public com.ulic.ulweb.ulweb2.service.convert.SubmitJobResponseType submitJob(
			SubmitJobRequestType request, DataHandler dhSource,
			int attachmentFormat) throws RemoteException;

	public GetJobResultsResponseType getJobResults(
			GetJobResultsRequestType request, DataHandler dhSource)
			throws RemoteException;
}

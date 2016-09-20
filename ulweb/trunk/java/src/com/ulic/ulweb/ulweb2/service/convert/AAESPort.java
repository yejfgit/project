/**
 * AAESPort.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package com.ulic.ulweb.ulweb2.service.convert;

public interface AAESPort extends java.rmi.Remote {
    public void createPDF(java.lang.String sourceURL,
            java.lang.String sourceFilename, java.lang.String jobOptions,
            java.lang.String mimeType, javax.xml.rpc.holders.IntHolder status,
            javax.xml.rpc.holders.StringHolder errorMessage,
            javax.xml.rpc.holders.StringHolder jobID)
            throws java.rmi.RemoteException;

    public void createPDFBase64(java.lang.String sourceData,
            java.lang.String sourceFilename, java.lang.String jobOptions,
            java.lang.String mimeType, javax.xml.rpc.holders.IntHolder status,
            javax.xml.rpc.holders.StringHolder errorMessage,
            javax.xml.rpc.holders.StringHolder jobID)
            throws java.rmi.RemoteException;

    public void createPDFStatus(java.lang.String jobID,
            javax.xml.rpc.holders.IntHolder status,
            javax.xml.rpc.holders.StringHolder errorMessage,
            javax.xml.rpc.holders.StringHolder resultURL,
            javax.xml.rpc.holders.StringHolder resultFilename)
            throws java.rmi.RemoteException;

    public void createPDFBase64Status(java.lang.String jobID,
            javax.xml.rpc.holders.IntHolder status,
            javax.xml.rpc.holders.StringHolder errorMessage,
            javax.xml.rpc.holders.StringHolder resultData,
            javax.xml.rpc.holders.StringHolder resultFilename)
            throws java.rmi.RemoteException;

    public void deleteJob(java.lang.String jobID,
            javax.xml.rpc.holders.IntHolder status,
            javax.xml.rpc.holders.StringHolder errorMessage)
            throws java.rmi.RemoteException;
}

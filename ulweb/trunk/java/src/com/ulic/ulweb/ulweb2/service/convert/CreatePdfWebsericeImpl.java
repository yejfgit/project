package com.ulic.ulweb.ulweb2.service.convert;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.rmi.RemoteException;
import java.util.UUID;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.xml.rpc.ServiceException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ulic.ulweb.ulweb2.service.convert.DeleteJobRequestType;
import com.ulic.ulweb.ulweb2.service.convert.DeleteJobResponseType;
import com.ulic.ulweb.ulweb2.service.convert.GetConfigRequestType;
import com.ulic.ulweb.ulweb2.service.convert.GetConfigResponseType;
import com.ulic.ulweb.ulweb2.service.convert.GetJobResultsRequestType;
import com.ulic.ulweb.ulweb2.service.convert.GetJobResultsResponseType;
import com.ulic.ulweb.ulweb2.service.convert.PdfGenInterface;
import com.ulic.ulweb.ulweb2.service.convert.PdfGenLocator;
import com.ulic.ulweb.ulweb2.service.convert.SubmitJobRequestType;
import com.ulic.ulweb.ulweb2.service.convert.SubmitJobResponseType;

public class CreatePdfWebsericeImpl implements Cloneable{

	private Long id;

	PdfGenInterface pdfGenInterface = null;

	private static final Log log = LogFactory
			.getLog(CreatePdfWebsericeImpl.class);

	public static void main(String[] agrs) {
		try {
			CreatePdfWebsericeImpl service = new CreatePdfWebsericeImpl(
					"http://172.86.50.27:8080/pdfg-ws/services/PdfGenInterface?wsdl");
			for (int i = 0; i < 5; i++) {

				service.getResultFile("c:/testpath/in/test.doc", "Standard", "hibetnate.doc");

			}
			/*
			 * FileOutputStream out=new
			 * FileOutputStream("C:\\hibernate_reference.pdf"); byte[] b=new
			 * byte[in[0].available()]; in[0].read(b); out.write(b);
			 * out.close(); in[0].close();
			 */

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// public static void main(String[] agrs) {
	// String filename = "法定代表人身份证明（惠洲).doc";
	// String t = filename.substring(filename.lastIndexOf("."), filename
	// .length());
	// filename = UUID.randomUUID().toString() + t;
	// System.err.println(filename);
	// }

	public static void write(InputStream in, String re) throws IOException {
		FileOutputStream out = new FileOutputStream(re);
		byte[] b = new byte[in.available()];
		in.read(b);
		out.write(b);
		out.close();
		in.close();
	}

	public CreatePdfWebsericeImpl() {

	}

	public CreatePdfWebsericeImpl(String serverUrl) throws Exception {
		this.serverUrl = serverUrl;
		init();
	}

	private void init() throws Exception {
		PdfGenLocator pdfGenLocator = new PdfGenLocator(serverUrl);
		try {
			pdfGenInterface = pdfGenLocator.getPdfGenInterface();
		} catch (ServiceException e) {
			LOG.error("Creat WebSerice Error：" + e.getMessage(), e);
			throw new Exception("Creat WebSerice Error：" + e.getMessage());
		}
	}

	private Log LOG = LogFactory.getLog(CreatePdfWebsericeImpl.class);

	private String serverUrl = "http://localhost:8080/pdfg-ws/services/PdfGenInterface?wsdl";

	private static String DEFAULT_LOCAL_NAME = "";

	private static String DEFAULT_SECURITY_LEVEL = "";

	private static String DEFAULT_OUTPDF_TYPE = "";

	private static String DEFAULT_FILE_TYPE = "";

	private static File DEFAULT_XMP_FILE = new File(""); // TODO

	private String localName = DEFAULT_LOCAL_NAME;

	private String securityLevel = DEFAULT_SECURITY_LEVEL;

	private String outPdfType = DEFAULT_OUTPDF_TYPE;

	private String fileType = DEFAULT_FILE_TYPE;

	private java.io.File xmpFile = DEFAULT_XMP_FILE;

	private String serverName;

	private String officeType;

	private int timeout = 500000;

	private String ip;

	private String url;

	private String port;

	private int workload;

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	public String getOfficeType() {
		return officeType;
	}

	public void setOfficeType(String officeType) {
		this.officeType = officeType;
	}

	public String getOutPdfType() {
		return outPdfType;
	}

	public void setOutPdfType(String outPdfType) {
		this.outPdfType = outPdfType;
	}

	public String getSecurityLevel() {
		return securityLevel;
	}

	public void setSecurityLevel(String securityLevel) {
		this.securityLevel = securityLevel;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public java.io.File getXmpFile() {
		return xmpFile;
	}

	public void setXmpFile(java.io.File xmpFile) {
		this.xmpFile = xmpFile;
	}

	public String getServerUrl() {
		return serverUrl;

	}

	public void setServerUrl(String serverUrl) throws Exception {

		this.serverUrl = serverUrl;

		init();
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public int getWorkload() {
		return workload;
	}

	public void setWorkload(int workload) {
		this.workload = workload;
	}

	public String createByFile(DataHandler dhSource, String filetype,
			String fileid, String filename) throws Exception {

		if (dhSource == null) {
			log.error("[createByFile] The data is null...");
			throw new Exception("the date is null！");
		}
		if (filename == null || filename.trim().length() < 1) {
			throw new Exception("the filename is not valid！");
		}
		if (filetype == null || filetype.trim().length() < 1) {
			throw new Exception("the file type is not valid...");
		}
		if (filename.indexOf('.') == -1) {
			throw new Exception("the file suffix is unknown ！");

		}
		String t = filename.substring(filename.lastIndexOf("."), filename
				.length());
		filename = UUID.randomUUID().toString() + t;
		// String sSourceFilename = srcFile;
		// File sourceFile = new File(sSourceFilename);

		int retCode = -1;// 0 正常，非0 ：出错
		int attachmentFormat = 0; // 0 = DIME; non-zero = MIME

		// init req/resp for submitJob():
		//
		SubmitJobRequestType submitJobRequestTypeRef = new SubmitJobRequestType();
		SubmitJobResponseType submitJobResponseTypeRef = new SubmitJobResponseType();
		//
		// conversion result objects
		//

		// create reference objects for the web service methods
		//
		GetConfigRequestType getConfigRequestTypeRef = new GetConfigRequestType();
		GetConfigResponseType getConfigResponseTypeRef = new GetConfigResponseType();
		//
		// build a locator object to find a reference to the web service
		// *** NOTE: The URL of the Adobe PDF Generator web service
		// is specified in the source of the PdfGenLocator class
		//

		// example job configuration settings (ask your system
		// administrator for available PDFG job configuration
		// settings)

		//
		getConfigRequestTypeRef.setSecuritySettingName(securityLevel);
		getConfigRequestTypeRef.setJobOptionSettingName(outPdfType);
		getConfigRequestTypeRef.setFiletypeSettingName(fileType);
		// getConfigRequestTypeRef.se
		try {
			getConfigResponseTypeRef = pdfGenInterface
					.getConfigurationXML(getConfigRequestTypeRef);
		} catch (RemoteException e1) {

			e1.printStackTrace();
		}

		submitJobRequestTypeRef.setJobConfig(getConfigResponseTypeRef
				.getConfigXML());

		retCode = getConfigResponseTypeRef.getReturnCode();
		if (retCode != 0) {// 出错

			LOG.error("getConfigurationXML(); Error Code: " + retCode);

			throw new Exception("getConfigurationXML(); Error Code: " + retCode);

		}
		//
		// set the name of the input filename
		//
		submitJobRequestTypeRef.setFilename(filename);
		//
		// set the xmp data; since no xmp data is required in this
		// example
		// we'll set it to null
		//
		submitJobRequestTypeRef.setXmpData(null);

		// submitJobRequestTypeRef.setSourceURL("c:\\test.doc");
		submitJobRequestTypeRef.setLocale(localName);
		// submitJobRequestTypeRef.
		// submitJobRequestTypeRef.setSourceType(0);
		//
		// submit the job request
		//

		try {
			submitJobResponseTypeRef = pdfGenInterface.submitJob(
					submitJobRequestTypeRef, dhSource, attachmentFormat);
			// dhSource.getDataSource().

		} catch (RemoteException e) {
			LOG.error("submit the officeFile error:" + e.getMessage());
			// e.printStackTrace();
			throw new Exception("submit the officeFile error:" + e.getMessage());

		}
		retCode = submitJobResponseTypeRef.getReturnCode();
		if (retCode != 0) {// 转换出错

			// System.err.println("SubmitJob(); Error: "
			// + submitJobResponseTypeRef.getReturnMessage());
			throw new Exception("SubmitJob(); Error Message: "
					+ submitJobResponseTypeRef.getReturnMessage());
		}

		//
		// get the conversion job id
		//
		return submitJobResponseTypeRef.getJobID();

	}

	public String createByURL(String sourceURL) throws Exception {
		// String sSourceFilename = "";
		// File sourceFile = new File(sourceURL);

		int retCode = -1;
		// int attachmentFormat = 0; // 0 = DIME; non-zero = MIME

		// init req/resp for submitJob():
		//
		SubmitJobRequestType submitJobRequestTypeRef = new SubmitJobRequestType();
		SubmitJobResponseType submitJobResponseTypeRef = new SubmitJobResponseType();
		//
		// conversion result objects
		//

		// create reference objects for the web service methods
		//
		GetConfigRequestType getConfigRequestTypeRef = new GetConfigRequestType();
		GetConfigResponseType getConfigResponseTypeRef = new GetConfigResponseType();

		// example job configuration settings (ask your system
		// administrator for available PDFG job configuration
		// settings)
		//
		getConfigRequestTypeRef.setSecuritySettingName(this.securityLevel);
		getConfigRequestTypeRef.setJobOptionSettingName(this.outPdfType);
		getConfigRequestTypeRef.setFiletypeSettingName(this.fileType);
		try {
			getConfigResponseTypeRef = pdfGenInterface
					.getConfigurationXML(getConfigRequestTypeRef);
		} catch (RemoteException e1) {

			e1.printStackTrace();
		}
		submitJobRequestTypeRef.setJobConfig(getConfigResponseTypeRef
				.getConfigXML());

		retCode = getConfigResponseTypeRef.getReturnCode();
		String reMessage = getConfigResponseTypeRef.getReturnMessage();
		if (retCode != 0) {
			//
			// the return code indicates an error, so print the error and
			// exit the method
			//
			LOG
					.error("Get result from PDF-G error：getConfigurationXML(); Error Message: "
							+ reMessage);

			throw new Exception(
					"Get result from PDF-G error：getConfigurationXML(); Error Message: "
							+ reMessage);
			// throw new Exception("getConfigurationXML(); Error Code: " +
			// retCode);
		}
		//
		// set the name of the input filename
		//
		// submitJobRequestTypeRef.setFilename(sourceFile.getName());
		//
		// set the xmp data; since no xmp data is required in this example
		// we'll set it to null
		//
		submitJobRequestTypeRef.setXmpData(null);

		submitJobRequestTypeRef.setSourceURL(sourceURL);
		submitJobRequestTypeRef.setLocale(localName);
		// submitJobRequestTypeRef.s
		// submitJobRequestTypeRef.setSourceType(1);
		//
		// submit the job request
		//

		try {
			submitJobResponseTypeRef = pdfGenInterface
					.submitWebCaptureJob(submitJobRequestTypeRef);
		} catch (RemoteException e) {
			LOG
					.error("Error happened when submit job to converserver,the exception is RemoteException,"
							+ e.getMessage());
			e.printStackTrace();
			throw new Exception(
					"Error happened when submit job to converserver,the exception is RemoteException,"
							+ e.getMessage());

		}
		retCode = submitJobResponseTypeRef.getReturnCode();
		if (retCode != 0) {
			String reSummitMessage = submitJobResponseTypeRef
					.getReturnMessage();
			LOG.error("SubmitJob(); Error Code:" + retCode);
			throw new Exception("SubmitJob(); Error Message: "
					+ reSummitMessage);
		}
		// sourceFile.delete();
		//
		// get the conversion job id
		//
		return submitJobResponseTypeRef.getJobID();
	}

	public void getResultFile(String jobId) throws Exception {

		if (jobId == null || jobId.trim().length() < 1) {
			log.error("[ConvertServer:getResultFile]Param is not valid, jobId:"
					+ jobId);
			throw new Exception(
					"[ConvertServer:getResultFile]Param is not valid, jobId:"
							+ jobId);
		}
		GetJobResultsRequestType getJobResultsRequestTypeRef = new GetJobResultsRequestType();
		GetJobResultsResponseType getJobResultsReponseTypeRef = new GetJobResultsResponseType();
		getJobResultsRequestTypeRef.setJobID(jobId);
		getJobResultsRequestTypeRef.setLocale(localName);
		getJobResultsRequestTypeRef.setResultAttachmentFormat(0);

		int jobStatus = -1;// 0：成功 1:转换中...
		int retCode = -1;
		int times = 0;
		do {//
			// wait 2000 milliseconds so this loop
			// doesn't kill the CPU
			//
			log.debug("Get the result file from PDF-G,jobId:" + jobId);
			try {
				Thread.sleep(10000);

				getJobResultsReponseTypeRef = pdfGenInterface.getJobResults(
						getJobResultsRequestTypeRef, null);

			} catch (Exception x) {
				times++;
				log.error(x.getMessage());
				x.printStackTrace();
				// 重试3次退出
				if (times > 3) {
					break;
				}
			}
			//
			// get the job status and return code
			//
			// getJobResultsReponseTypeRef.
			jobStatus = getJobResultsReponseTypeRef.getJobStatus();
			retCode = getJobResultsReponseTypeRef.getReturnCode();
		} while ((retCode == 0) && (jobStatus == 1));
		//
		// check the return codes and status to see
		// if there was a problem
		//
		if ((retCode != 0) || (jobStatus != 0)) {
			//
			// the return code and/or status indicates an error,
			// so print the error and exit the method
			//
			log.error("SubmitJob(); Error Code: " + retCode);
			throw new Exception("SubmitJob(); Error Code: " + retCode);
		}
		//
		// display the name of the resulting output file (if it exists)
		//

	}

	public boolean deleteFile(String jobId) throws Exception {
		if (jobId == null || jobId.trim().length() < 1) {
			log.error("[ConvertServer:deleteFile]Param is not valid, jobId:"
					+ jobId);
			throw new Exception(
					"[ConvertServer:deleteFile]Param is not valid, jobId:"
							+ jobId);
		}
		DeleteJobRequestType deleteJobRequestTypeRef = new DeleteJobRequestType();
		deleteJobRequestTypeRef.setJobID(jobId);
		DeleteJobResponseType deleteResponse;
		int delRetCode = -1;
		try {
			deleteResponse = pdfGenInterface.deleteJob(deleteJobRequestTypeRef);

			delRetCode = deleteResponse.getReturnCode();
		} catch (RemoteException e) {

			log.error(e.getMessage());
			throw new Exception("DeleteFile Error: " + e.getMessage());

		}
		if (delRetCode != 0) {
			log.error("[deleteFile] Error Message: "
					+ deleteResponse.getReturnMessage());
			throw new Exception("deleteFile; Error Message: "
					+ deleteResponse.getReturnMessage());
		}
		return true;
	}

	public void getResultFile(String srcFile, String filetype, String filename)
			throws Exception {
		String jobId = createByFile(srcFile, filetype, filename);
		getResultFile(jobId);
		deleteFile(jobId);
	}

	public String createByFile(String srcFile, String filetype, String filename)
			throws Exception {
		File file = new File(srcFile);
		return this.createByFile(file, filetype, filename);
	}

	public String createByFile(File srcfile, String filetype, String filename)
			throws Exception {
		if (!srcfile.exists()) {
			log
					.error("[CreatePdfWebsericeImpl:createByFile] File not exist,filename:"
							+ srcfile.getAbsolutePath());
			throw new Exception(
					"[CreatePdfWebsericeImpl:createByFile] File not exist,filename:"
							+ srcfile.getAbsolutePath());
		}
		DataHandler dhSource = null;
		ByteArrayOutputStream bos = null;
		FileInputStream fis = null;
		String id = null;
		try {

			dhSource = new DataHandler(new FileDataSource(srcfile));

			id = createByFile(dhSource, filetype, filetype, filename);
		} finally {
			if (dhSource != null) {
				try {
					dhSource.getInputStream().close();
					dhSource = null;
				} catch (IOException e) {
					dhSource = null;
					e.printStackTrace();
				}
			}
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		}

		return id;

	}

	public String createByFile(InputStream srcInputStream, String filetype,
			String filename) throws Exception {
		DataHandler dhSource = new DataHandler(new ByteArrayDataSource(
				srcInputStream, "application/octet-stream"));
		return createByFile(dhSource, filetype, filetype, filename);

	}

	public String createByFile(byte[] srcContent, String filetype,
			String filename) throws Exception {
		DataHandler dhSource = new DataHandler(new ByteArrayDataSource(
				srcContent, "application/octet-stream"));
		return createByFile(dhSource, filetype, filetype, filename);
	}

	public Object clone() throws CloneNotSupportedException {
		CreatePdfWebsericeImpl clone = null;
		clone = (CreatePdfWebsericeImpl) super.clone();
		return clone;
	}

	public boolean isOK() {
		GetConfigRequestType getConfigRequestTypeRef = new GetConfigRequestType();

		try {
			// GetConfigResponseType getConfigResponseTypeRef = new
			// GetConfigResponseType();
			GetConfigResponseType getConfigResponseTypeRef = pdfGenInterface
					.getConfigurationXML(getConfigRequestTypeRef);
			if (getConfigResponseTypeRef != null) {
				return true;
			}
		} catch (RemoteException e1) {
			log.fatal("[isOK]the url:" + this.serverUrl + " is error "
					+ e1.getMessage());
			return false;
		}
		return true;
	}

	public Long getId() {

		return this.id;
	}

	public void setId(Long id) {
		this.id = id;

	}

	public boolean equals(Object o) {
		if(o!=null&&o instanceof CreatePdfWebsericeImpl){
			CreatePdfWebsericeImpl other = (CreatePdfWebsericeImpl) o;
			if (other.getId().equals(this.id)) {
				return true;
			}
		}

		return false;

	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
}

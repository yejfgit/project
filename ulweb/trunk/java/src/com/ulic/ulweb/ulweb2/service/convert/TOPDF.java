package com.ulic.ulweb.ulweb2.service.convert;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.rmi.RemoteException;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.xml.rpc.ServiceException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ulic.ulweb.ulweb2.service.impl.task.Constant;
import com.ulic.ulweb.ulweb2.util.ConfigManager;

public class TOPDF implements Cloneable{

	private Long id;

	private static Log _logger = LogFactory.getLog(TOPDF.class);

	private static String DEFAULT_LOCAL_NAME = "1";// "zh_CN";

//	private static String DEFAULT_SECURITY_LEVEL = "No Security";
//
//	private static String DEFAULT_OUTPDF_TYPE = "Standard";
//
//	private static String DEFAULT_FILE_TYPE = "Standard";

//	private String securityLevel = DEFAULT_SECURITY_LEVEL;
//
//	private String outPdfType = DEFAULT_OUTPDF_TYPE;
//
//	private String fileType = DEFAULT_FILE_TYPE;

	PdfGenInterface pdfGenInterface = null;

	private String serverURL = null;

//	private static final Log log = LogFactory.getLog(TOPDF.class);

	private static TOPDF service = null;

	public static void main(String[] agrs) {
		try {
			TOPDF service = new TOPDF();

			service.toPDF("D:\\test.txt",
					new File("D:/网络参数1.pdf"),"test.txt");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private TOPDF() throws Exception {
		StringBuilder sb = new StringBuilder();
		String ip = ConfigManager.config
				.getString(Constant._pdf_IP);
		String port = ConfigManager.config
				.getString(Constant._pdf_port);
		sb.append("http://").append(ip).append(":").append(port).append(
				"/pdfg-ws/services/PdfGenInterface?wsdl");
		this.serverURL = sb.toString();
		init();
	}

	private TOPDF(String serverUrl) throws Exception {
		this.serverURL = serverUrl;
		init();
	}

	public static TOPDF getInstance() {
		if (service == null) {
			synchronized (DEFAULT_LOCAL_NAME.intern()) {
				if (service == null) {
					try {
						service = new TOPDF();
					} catch (Exception e) {
						service = null;
					}
				}
			}
		}

		return service;
	}

	private void init() throws Exception {
		PdfGenLocator pdfGenLocator = new PdfGenLocator(serverURL);
		try {
			pdfGenInterface = pdfGenLocator.getPdfGenInterface();
		} catch (ServiceException e) {
			_logger.error("Creat WebSerice Error：" + e.getMessage(), e);
			throw new Exception("Creat WebSerice Error：" + e.getMessage());
		}
	}

	/**
	 * 提交转换任务
	 * 
	 * @param dhSource
	 * @param filetype
	 * @param fileid
	 * @param filename
	 * @return
	 * @throws Exception
	 */
	private String createByFile(DataHandler dhSource, String filename)
			throws Exception {

		if (dhSource == null) {
			_logger.error("[createByFile] The data is null...");
			throw new Exception("the date is null！");
		}
		if (filename == null || filename.trim().length() < 1) {
			throw new Exception("the filename is not valid！");
		}
		if (filename.indexOf('.') == -1) {
			throw new Exception("the file suffix is unknown ！");

		}
		int retCode = -1;// 0 正常，非0 ：出错
		int attachmentFormat = 0; // 0 = DIME; non-zero = MIME

		SubmitJobRequestType submitJobRequestTypeRef = new SubmitJobRequestType();
		SubmitJobResponseType submitJobResponseTypeRef = null;

		GetConfigRequestType getConfigRequestTypeRef = new GetConfigRequestType();
		GetConfigResponseType getConfigResponseTypeRef = null;

		// 设置提交配置
		getConfigRequestTypeRef.setSecuritySettingName(ConfigManager.config.getString(Constant._sercurity_level));
		getConfigRequestTypeRef.setJobOptionSettingName(ConfigManager.config.getString(Constant._out_pdf_type));
		getConfigRequestTypeRef.setFiletypeSettingName(ConfigManager.config.getString(Constant._file_type));

		try {
			getConfigResponseTypeRef = pdfGenInterface
					.getConfigurationXML(getConfigRequestTypeRef);
			retCode = getConfigResponseTypeRef.getReturnCode();

			if (retCode != 0) {// 出错

				_logger.error("getConfigurationXML(); Error Code: " + retCode);
				throw new Exception("getConfigurationXML(); Error Code: "
						+ retCode);
			}

			submitJobRequestTypeRef.setJobConfig(getConfigResponseTypeRef
					.getConfigXML());

			submitJobRequestTypeRef.setFilename(filename);
			submitJobRequestTypeRef.setXmpData(null);

			// submitJobRequestTypeRef.setSourceURL("c:\\test.doc");
			submitJobRequestTypeRef.setLocale(DEFAULT_LOCAL_NAME);

			submitJobResponseTypeRef = pdfGenInterface.submitJob(
					submitJobRequestTypeRef, dhSource, attachmentFormat);
			retCode = submitJobResponseTypeRef.getReturnCode();

			if (retCode != 0) {// 转换出错

				throw new Exception("SubmitJob(); Error Message: "
						+ submitJobResponseTypeRef.getReturnMessage());
			}
		} catch (Exception e1) {

			e1.printStackTrace();
			return null;
		}

		return submitJobResponseTypeRef.getJobID();

	}

	private File getResultFile(String jobId, File destFile) throws Exception {

		if (jobId == null || jobId.trim().length() < 1) {
			_logger.error("Param is not valid, jobId:" + jobId);
			throw new Exception("Param is not valid, jobId:" + jobId);
		}
		GetJobResultsRequestType getJobResultsRequestTypeRef = new GetJobResultsRequestType();
		GetJobResultsResponseType getJobResultsReponseTypeRef = null;
		getJobResultsRequestTypeRef.setJobID(jobId);
		getJobResultsRequestTypeRef.setLocale(DEFAULT_LOCAL_NAME);
		getJobResultsRequestTypeRef.setResultAttachmentFormat(0);

		int jobStatus = -1;// 0：成功 1:转换中...
		int retCode = -1;
		int times = 0;
		int i = 0;
		do {

			_logger.debug("Get the result file from PDF-G,jobId:" + jobId);
			try {
				getJobResultsReponseTypeRef = pdfGenInterface
						.getJobResults(getJobResultsRequestTypeRef);
				jobStatus = getJobResultsReponseTypeRef.getJobStatus();
				retCode = getJobResultsReponseTypeRef.getReturnCode();
				++i;

			} catch (Exception x) {
				times++;
				_logger.error(x.getMessage());
				x.printStackTrace();
				// 重试3次退出
				if (times > 3) {
					break;
				}
			}
			Thread.sleep(1000);
		} while ((retCode == 0) && (jobStatus == 1));

		if ((retCode != 0) || (jobStatus != 0)) {
			//
			// the return code and/or status indicates an error,
			// so print the error and exit the method
			//
			_logger.error(" Error Code: " + retCode);
			_logger.info(getJobResultsReponseTypeRef.getReturnMessage());
			throw new Exception("Error Code: " + retCode);
		}

		// 转换成功后，将pdf存盘
		File parent = destFile.getParentFile();
		if (!parent.exists()) {
			parent.mkdirs();
		}
		OutputStream out = new FileOutputStream(destFile);
		getJobResultsReponseTypeRef.getDataHandler().writeTo(out);
		out.flush();
		out.close();

		return destFile;
	}

	/**
	 * 将文件转换成pdf文件
	 * 
	 * @param srcFile
	 * @param filetype
	 * @param filename
	 * @return
	 * @throws Exception
	 */
	public boolean toPDF(String srcFile, File destFile,String name) throws Exception {
		String jobId = commitJob(srcFile, name);
//		String jobId = commitJob(srcFile, "网络参数.txt");
		getResultFile(jobId, destFile);
		deleteFile(jobId);
		return true;
	}

	private String commitJob(String filePath, String filename) throws Exception {
		File srcFile = new File(filePath);
		if (!srcFile.exists()) {
			_logger.error(" File not exist,filename:" + srcFile.getAbsolutePath());
			throw new Exception(" File not exist,filename:"
					+ srcFile.getAbsolutePath());
		}
		DataHandler dhSource = null;
		String id = null;
		try {

			dhSource = new DataHandler(new FileDataSource(srcFile));

			id = createByFile(dhSource, filename);
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

		}

		return id;

	}

	private boolean deleteFile(String jobId) throws Exception {
		if (jobId == null || jobId.trim().length() < 1) {
			_logger.error("[ConvertServer:deleteFile]Param is not valid, jobId:"
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

			_logger.error(e.getMessage());
			throw new Exception("DeleteFile Error: " + e.getMessage());

		}
		if (delRetCode != 0) {
			_logger.error("[deleteFile] Error Message: "
					+ deleteResponse.getReturnMessage());
			throw new Exception("deleteFile; Error Message: "
					+ deleteResponse.getReturnMessage());
		}
		return true;
	}

	public Object clone() throws CloneNotSupportedException {
		TOPDF clone = null;
		clone = (TOPDF) super.clone();
		return clone;
	}

	public Long getId() {

		return this.id;
	}

	public void setId(Long id) {
		this.id = id;

	}

	public boolean equals(Object o) {
		if(o!=null&&o instanceof TOPDF){
			TOPDF other = (TOPDF) o;
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

package test.pdf;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

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

/**
 * Sample Java client for PDF Generator web service (WSDL). For simplicity this
 * class basically consists of one big generatePDF() method which does all the
 * work of turning a DOC file into a PDF via the web service.
 * 
 * @author slegge
 * 
 */
public class WebServiceClient {

	public static void main(String[] args) {
		//
		// specify the web service URL
		// specify the name of the input file and the output directory
		//
		String sWebServiceURL = "http://172.86.50.27:8080/pdfg-ws/services/PdfGenInterface?wsdl";
		String sSourceDir = "c:/testpath/in";
		String sSourceFilename = "test.doc";
		String sOutputDir = "c:/testpath/out";
		//
		// OPTIONAL: specify the name of the xml config if needed;
		// by default this example does not use a config file
		//
		String sXmlConfigFileName = "";
		//
		// conver the xml config file to a string
		//
		String sConfigXML = "";
		File xmlConfigFile = new File(sXmlConfigFileName);
		//
		// convert the config xml file to a string
		//
		try {
			FileInputStream fis = new FileInputStream(xmlConfigFile);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int buffSize = 1024;
			int bytesToWrite = -1;
			byte[] buff = new byte[buffSize];
			while ((bytesToWrite = fis.read(buff)) != -1) {
				baos.write(buff, 0, bytesToWrite);
			}
			fis.close();
			sConfigXML = baos.toString();
		} catch (Exception x) {
			x.printStackTrace();
		}
		try {
			WebServiceClient.generatePDF(sWebServiceURL, sSourceDir,
					sSourceFilename, sOutputDir, sConfigXML);
		} catch (Exception x) {
			System.err.println("ERROR: " + x.getMessage());
			x.printStackTrace();
		}
	}

	public static String generatePDF(String sWebServiceURL, String sSourceDir,
			String sSourceFilename, String sOutputDir, String sConfigXML)
			throws Exception {

		File sourceFile = new File(sSourceFilename);
		File outDir = new File(sOutputDir);
		//
		// declare utility variables used throughout this method
		//
		String jobId = "-9999";
		int jobStatus = -1;
		int retCode = -1;
		int attachmentFormat = 0; // 0 = DIME; non-zero = MIME

		// init req/resp for submitJob():
		SubmitJobRequestType submitJobRequestTypeRef = new SubmitJobRequestType();
		SubmitJobResponseType submitJobResponseTypeRef = new SubmitJobResponseType();

		File outputFile = null;
		File jdfFile = null;
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
		PdfGenLocator pdfGenLocator = new PdfGenLocator(sWebServiceURL);
		//
		// look up a reference to the web service
		//
		PdfGenInterface pdfGenInterface = pdfGenLocator.getPdfGenInterface();
		//
		// set job configuration XML
		//
		getConfigResponseTypeRef = pdfGenInterface
				.getConfigurationXML(getConfigRequestTypeRef);
		if (sConfigXML.equals("")) {
			//
			// example job configuration settings (ask your system
			// administrator for available PDFG job configuration
			// settings)
			//
			getConfigRequestTypeRef.setSecuritySettingName("No Security");
			getConfigRequestTypeRef.setJobOptionSettingName("Standard");
			getConfigRequestTypeRef.setFiletypeSettingName("Standard");

			submitJobRequestTypeRef.setJobConfig(getConfigResponseTypeRef
					.getConfigXML());
		} else {
			submitJobRequestTypeRef.setJobConfig(sConfigXML);
		}
		//
		// check the return status of the call to getConfigurationXML()
		//
		retCode = getConfigResponseTypeRef.getReturnCode();
		if (retCode != 0) {
			//
			// the return code indicates an error, so print the error and
			// exit the method
			//
			System.err.println("getConfigurationXML(); Error Code: " + retCode);
			throw new Exception("getConfigurationXML(); Error Code: " + retCode);
		}
		//
		// set the name of the input filename
		//
		submitJobRequestTypeRef.setFilename(sourceFile.getName());
		//
		// set the xmp data; since no xmp data is required in this example
		// we'll set it to null
		//
		submitJobRequestTypeRef.setXmpData(null);
		//
		// submit the job request
		//
		submitJobResponseTypeRef = pdfGenInterface
				.submitJob(submitJobRequestTypeRef);
		retCode = submitJobResponseTypeRef.getReturnCode();
		if (retCode != 0) {
			//
			// the return code indicates an error, so print the error and
			// exit the method
			//
			System.err.println("SubmitJob(); Error Code: " + retCode);
			throw new Exception("SubmitJob(); Error Code: ");
		}
		GetJobResultsRequestType getJobResultsRequestTypeRef = new GetJobResultsRequestType();
		GetJobResultsResponseType getJobResultsReponseTypeRef = new GetJobResultsResponseType();
		//
		// get the conversion job id
		//
		jobId = submitJobResponseTypeRef.getJobID();
		//
		// set up parameters for the job results request
		//
		getJobResultsRequestTypeRef.setJobID(jobId);
		getJobResultsRequestTypeRef.setResultAttachmentFormat(attachmentFormat);
		//
		// create the output dir, in case it does not exist
		//
		outDir.mkdirs();
		//
		// build a filename for the output using the name of the input file
		//
		String sOutputFilename = sourceFile.getName();
		//
		// if there's an extension on the filename, trim it
		//
		int i = sOutputFilename.lastIndexOf(".");
		if (i > -1) {
			sOutputFilename = sOutputFilename.substring(0, i);
		}
		sOutputFilename = outDir.getAbsolutePath() + "/" + sOutputFilename
				+ ".pdf";
		outputFile = new File(sOutputFilename);
		//
		// request the job status continuously until we get some result
		//
		do {
			//
			// wait 200 milliseconds so this loop
			// doesn't kill the CPU
			//
			try {
				Thread.sleep(200);
			} catch (InterruptedException x) {
			}
			//
			// get the job results
			//
			System.out.println("Checking for job results ...");
			getJobResultsReponseTypeRef = pdfGenInterface
					.getJobResults(getJobResultsRequestTypeRef);
			//
			// get the job status and return code
			//
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
			System.err.println("SubmitJob(); Error Code: " + retCode);
			throw new Exception("SubmitJob(); Error Code: " + retCode);
		}
		//
		// display the name of the resulting output file (if it exists)
		//
		if (outputFile.exists()) {
			System.out.println("ResultFile: " + outputFile.getCanonicalPath());
		} else {

			System.out.println("ResultFile: null (no attachment found OR "
					+ "problem extracting SOAP attachment)");
		}
		//
		// check if the result contains JDF data
		//
		String jdfDataStr = getJobResultsReponseTypeRef.getJdfData();
		if ((jdfDataStr != null) && (jdfDataStr.length() > 0)) {
			//
			// there is JDF data so output it to a file with extension .jdf
			//
			String sOldFilename = sourceFile.getName();
			String sNewFilename = "";
			String sNewExtension = ".jdf";
			int lastDot = sOldFilename.lastIndexOf(".");
			if (lastDot != -1) {
				sNewFilename = sOldFilename.substring(0, lastDot)
						+ sNewExtension;
			} else {
				sNewFilename = sOldFilename + sNewExtension;
			}
			jdfFile = new File(outDir, sNewFilename);
			//
			// display the name of the jdf file
			//
			if (jdfFile.exists()) {
				System.out.println("Jdf File: " + jdfFile.getCanonicalPath());
			}
		}
		//
		// we are done, do delete the job
		//
		DeleteJobRequestType deleteJobRequestTypeRef = new DeleteJobRequestType();
		deleteJobRequestTypeRef.setJobID(jobId);
		DeleteJobResponseType deleteResponse = pdfGenInterface
				.deleteJob(deleteJobRequestTypeRef);
		int delRetCode = deleteResponse.getReturnCode();
		if (delRetCode != 0) {
			System.err.println("deleteJob(); Error Code: " + retCode);
		}
		return sOutputFilename;
	}
}
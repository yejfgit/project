package com.ulic.ulweb.ulweb2.service.impl.task;

import java.io.File;
import java.io.IOException;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SecureDocHttpClient2 {
	
	private static Log _logger = LogFactory.getLog(SecureDocHttpClient2.class);
	
	private static String url;

	private String username;

	private String password;

	SecureDocHttpClient2(String username, String password, String ip,
			String port) {
		this.username = username;
		this.password = password;
		StringBuffer sb = new StringBuffer();
		sb.append("http://").append(ip).append(":").append(port).append(
				"/UnionLifeWebService/SecureDocServlet");
		this.url = sb.toString();
	}

	public static void main(String[] args) {
		SecureDocHttpClient2 sh = new SecureDocHttpClient2("pdfshare",
				"pdfshare", "10.18.2.108", "8080");
		byte[] securedDocContent;
		try {
			//			
			String inFilePath = "http://10.53.32.108:80/ulweb/pdfResult/1274152106969.pdf";
			sh.secure("4E7BB454-8AC1-464E-1E83-47E4D8376163", inFilePath,
					new File("d:\\dummydummy11.pdf"), "testee.pdf");
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @param policy
	 * @param path
	 * @param destFile
	 * @author linda.hou
	 * @throws IOException
	 * @date 2010-5-14 上午10:49:52
	 */
	public void secure(String policyId, String inFilePath, File destFile,
			String name) throws IOException {
		byte[] securedDocContent = getHttpResponsePost(policyId, inFilePath,
				name);
		if (securedDocContent != null && securedDocContent.length > 0) {
			java.io.OutputStream out = new java.io.FileOutputStream(destFile);
			out.write(securedDocContent);
			out.close();
			out = null;
		}

	}

	private byte[] getHttpResponse(String endPoint) throws IOException {
		HttpClient httpClient = new HttpClient();
		// 创建GET方法的实例
		GetMethod getMethod = new GetMethod(endPoint);
		// 使用系统提供的默认的恢复策略
		getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
				new DefaultHttpMethodRetryHandler());

		byte[] responseBody = null;
		try {
			// 执行getMethod
			int statusCode = httpClient.executeMethod(getMethod);
			if (statusCode != HttpStatus.SC_OK) {
				System.err.println("Method failed: "
						+ getMethod.getStatusLine());
			}
			// 读取内容
			responseBody = getMethod.getResponseBody();
			// 处理内容
			// _logger.debug(new String(responseBody));
		} catch (HttpException e) {
			// 发生致命的异常，可能是协议不对或者返回的内容有问题
			_logger.error("Please check your provided http address!");
			e.printStackTrace();
		} catch (IOException e) {
			// 发生网络异常
			e.printStackTrace();
		} finally {
			// 释放连接
			getMethod.releaseConnection();
		}

		return responseBody;
	}

	private byte[] getHttpResponsePost(String policyId, String inFilePath,
			String name) throws IOException {
		HttpClient httpClient = new HttpClient();
		byte[] responseBody = null;
		PostMethod postMethod = new PostMethod(url);
		// 填入各个表单域的值
		NameValuePair[] data = {
				new NameValuePair("policyId", policyId),
				new NameValuePair("inFilePath", inFilePath),// "http://172.86.50.58:8080/UnionLifeWebService/test.pdf"
				new NameValuePair("userName", username),
				new NameValuePair("pwd", password),
				new NameValuePair("fileName", name) };
		// pwd=12345^a&fileName=mydoc.pdf
		// 将表单的值放入postMethod中
		postMethod.setRequestBody(data);
		// 执行postMethod
		int statusCode = httpClient.executeMethod(postMethod);

		if (statusCode == HttpStatus.SC_OK) {
			responseBody = postMethod.getResponseBody();
		}

		return responseBody;

	}

}

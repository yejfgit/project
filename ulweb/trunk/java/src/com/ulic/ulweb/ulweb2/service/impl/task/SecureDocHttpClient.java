package com.ulic.ulweb.ulweb2.service.impl.task;

import java.io.IOException;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;


public class SecureDocHttpClient {

    public  static void main(String[] args) throws IOException{
        SecureDocHttpClient sh = new SecureDocHttpClient();
    	byte[] securedDocContent = sh.getHttpResponsePost("http://172.86.50.58:8080/UnionLifeWebService/SecureDocServlet");
    	if(securedDocContent!=null){
    		java.io.File file = new java.io.File("c:\\dummydummy.pdf");
            java.io.OutputStream out = new java.io.FileOutputStream(file);
            out.write(securedDocContent);
            out.close();
            out = null;
    	}


    }
    private byte[] getHttpResponse(String endPoint) throws IOException{
    	  HttpClient httpClient = new HttpClient();
    	  //创建GET方法的实例
    	  GetMethod getMethod = new GetMethod(endPoint);
    	  //使用系统提供的默认的恢复策略
    	  getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
    	    new DefaultHttpMethodRetryHandler());

    	  byte[] responseBody=null;
    	  try {
    	   //执行getMethod
    	   int statusCode = httpClient.executeMethod(getMethod);
    	   if (statusCode != HttpStatus.SC_OK) {
    	    System.err.println("Method failed: "
    	      + getMethod.getStatusLine());
    	   }
    	   //读取内容
    	   responseBody = getMethod.getResponseBody();
    	   //处理内容
    	     // System.out.println(new String(responseBody));
    	  } catch (HttpException e) {
    	    //发生致命的异常，可能是协议不对或者返回的内容有问题
    	    System.out.println("Please check your provided http address!");
    	    e.printStackTrace();
    	  } catch (IOException e) {
    	   //发生网络异常
    	    e.printStackTrace();
    	  } finally {
    	   //释放连接
    	    getMethod.releaseConnection();
    	  }

       return responseBody;
    }


    private byte[] getHttpResponsePost(String endPoint) throws IOException{
    	HttpClient httpClient = new HttpClient();
    	 byte[] responseBody=null;
    	String url = endPoint;
        PostMethod postMethod = new PostMethod(url);
//     填入各个表单域的值
        NameValuePair[] data = { new NameValuePair("policyId", "3470059E-62C9-4C81-D894-23E236308D93"),
        new NameValuePair("inFilePath", "http://172.86.50.58:8080/UnionLifeWebService/test.pdf"),
        new NameValuePair("userName", "administrator"),
        new NameValuePair("pwd", "password"),new NameValuePair("fileName", "mydoc.pdf")};
     //   pwd=12345^a&fileName=mydoc.pdf
//     将表单的值放入postMethod中
       postMethod.setRequestBody(data);
//     执行postMethod
       int statusCode = httpClient.executeMethod(postMethod);

       if (statusCode ==HttpStatus.SC_OK) {
    	  responseBody = postMethod.getResponseBody();
       }

        return responseBody;

    }





}

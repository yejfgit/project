package com.ulic.portal.demo.server;


import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;




public class TaskServerClient {

	public static void main(String[] args) {
		
		
		// 调用WebService
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(ITestServer.class);
		factory.setAddress("http://10.53.31.9:6080/portal/services/test");
		ITestServer service = (ITestServer) factory.create();
		
		TaskVO t = new TaskVO();
		t.setTaskName("通知通知");
		service.addTask(t);
		
	}
	
}

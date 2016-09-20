package com.ulic.portal.demo.server;



import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;



@SOAPBinding(style = SOAPBinding.Style.RPC)
@WebService
public interface ITestServer {
	@WebMethod
	public void addTask(TaskVO task);
}

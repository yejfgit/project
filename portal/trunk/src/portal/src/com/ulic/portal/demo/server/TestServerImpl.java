package com.ulic.portal.demo.server;

import org.springframework.stereotype.Service;

@Service(value = "testServer")
public class TestServerImpl implements ITestServer {

	public void addTask(TaskVO task) {
		
		System.out.println(task.getTaskName());
		
	}
}

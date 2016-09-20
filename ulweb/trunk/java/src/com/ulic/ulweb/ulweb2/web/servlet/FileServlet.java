package com.ulic.ulweb.ulweb2.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FileServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String url = request.getRequestURL().toString();
		//System.out.println(url);
		
		String filePath = "/" + url.substring(url.indexOf("files/"), url.length());
		//System.out.println(filePath);
		
		this.getServletContext().getContext("/").getRequestDispatcher(filePath)
		.forward(request, response);

		//response.sendRedirect(filePath);
		
	}

	
	
}

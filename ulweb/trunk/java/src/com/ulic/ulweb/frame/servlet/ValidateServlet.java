package com.ulic.ulweb.frame.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ValidateServlet extends HttpServlet {
	// ����ͻ����ύ���ݵ� "Post" ����
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ���� XHTML ��ʽ��ҳ����ͻ���

		response.setContentType("text/html;charset=gb2312");
		// ����ҳ�治����

		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		// ����û��������֤��
		String validateCode = request.getParameter("validateCode");
		// ��ȡ������session�е���֤��

		HttpSession session = request.getSession();
		String codeNumbers = (String) session.getAttribute("codeNumbers");
		String url = request.getContextPath() + "/validate.jsp";
		if (codeNumbers == null) {
			response.sendRedirect(url);
			return;
		}
		PrintWriter out = response.getWriter();
		// ��ʼ���� XHTML �ĵ�
		out.println("<?xml version = \"1.0\"?>");
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD " + "XHTML 1.0 Strict//EN\" \"http://www.w3.org"
				+ "/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
		out.println("<html xmlns = \"http://www.w3.org/1999/xhtml\">");
		// �����ĵ���head����
		out.println("<head>");
		out.println("<title>У����֤���Servlet</title>");
		out.println("</head>");
		// �����ĵ���body����
		out.println("<body>");
		// У���û��������֤���session�е���֤���Ƿ���ͬ

		if (codeNumbers.equals(validateCode)) {
			out.println("<h1><font color=\"green\">������ͬ,У��ɹ�</font></h1> ");
		}
		else {
			out.println("<h1><font color=\"red\">�������,У��ʧ��</font> <br>");
			out.println("<p>������<a href=\"" + url + "\">������֤��</a><h1></p>");
		}
		out.println("</body>");
		// ���� XHTML �ĵ�
		out.println("</html>");
		out.close(); // �ر���

	}
	// ����ͻ����ύ���ݵ� "get" ����, ��doPostһ��

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}

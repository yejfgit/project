package com.ulic.ulweb.frame.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ValidateServlet extends HttpServlet {
	// 处理客户端提交数据的 "Post" 请求
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 发送 XHTML 格式的页面给客户端

		response.setContentType("text/html;charset=gb2312");
		// 设置页面不缓存

		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		// 获得用户输入的验证码
		String validateCode = request.getParameter("validateCode");
		// 获取保存在session中的验证码

		HttpSession session = request.getSession();
		String codeNumbers = (String) session.getAttribute("codeNumbers");
		String url = request.getContextPath() + "/validate.jsp";
		if (codeNumbers == null) {
			response.sendRedirect(url);
			return;
		}
		PrintWriter out = response.getWriter();
		// 开始生成 XHTML 文档
		out.println("<?xml version = \"1.0\"?>");
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD " + "XHTML 1.0 Strict//EN\" \"http://www.w3.org"
				+ "/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
		out.println("<html xmlns = \"http://www.w3.org/1999/xhtml\">");
		// 生成文档的head部分
		out.println("<head>");
		out.println("<title>校验认证码的Servlet</title>");
		out.println("</head>");
		// 生成文档的body部分
		out.println("<body>");
		// 校验用户输入的验证码和session中的验证码是否相同

		if (codeNumbers.equals(validateCode)) {
			out.println("<h1><font color=\"green\">输入相同,校验成功</font></h1> ");
		}
		else {
			out.println("<h1><font color=\"red\">输入错误,校验失败</font> <br>");
			out.println("<p>请重新<a href=\"" + url + "\">输入验证码</a><h1></p>");
		}
		out.println("</body>");
		// 结束 XHTML 文档
		out.println("</html>");
		out.close(); // 关闭流

	}
	// 处理客户端提交数据的 "get" 请求, 和doPost一样

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}

package com.ulic.ulweb.frame.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ulic.ulweb.frame.dao.ConnectionFactory;
import com.ulic.ulweb.frame.page.HtmlPage;

public class ExeCtrl extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
			IOException {
		String jspStr = "webapp/photoblog/sign_in.jsp";
		HtmlPage page = HtmlPage.getPage(req.getParameter("page"));
		if (page == null) {
			resp.sendRedirect(jspStr);
			return;
		}
		try {
			ConnectionFactory.beginTransaction();
			jspStr = page.execute(req, resp);
			ConnectionFactory.commit();
		}
		catch (Exception e) {
			try {
				ConnectionFactory.rollback();
			}
			catch (SQLException e1) {
				e1.printStackTrace();
			}
			jspStr = "webapp/util/viewInf.jsp";
		}
		finally {
			try {
				ConnectionFactory.closeConnection();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		req.getRequestDispatcher(jspStr).forward(req, resp);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
			IOException {
		doGet(req, resp);
	}
}

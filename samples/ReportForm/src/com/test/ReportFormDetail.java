package com.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperRunManager;

public class ReportFormDetail extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ReportFormUtil report = new ReportFormUtil();

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		Map<String, Object> parameters = new HashMap<String, Object>();

		String MC0000 = request.getParameter("MC0000");
		// MC0000 =URLDecoder.decode(MC0000, "UTF-8");
		// MC0000 =URLDecoder.decode(MC0000, "UTF-8");
		// MC0000 =URLDecoder.decode(MC0000, "UniGB-UCS2-H");

		if ("房屋及建筑物".equals(MC0000)) {

			parameters.put("DAH000", "0101");
		} else if ("家电".equals(MC0000)) {

			parameters.put("DAH000", "7801");
		} else if ("其他设备".equals(MC0000)) {

			parameters.put("DAH000", "9901");
		} else if ("总计".equals(MC0000)) {

			parameters.put("DAH000", "");
		} else {

			parameters.put("DAH000", "0101");
		}

		ServletContext servletContext = this.getServletContext();
		try {
			JasperCompileManager.compileReportToFile(servletContext
					.getRealPath("detail/report1Detail.jrxml"), servletContext
					.getRealPath("detail/report1Detail.jasper"));
		} catch (JRException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		String str2 = servletContext.getRealPath("detail/report1Detail.jasper");

		Connection conn = ReportFormConn.getdbConnection();

		try {
			JasperRunManager
					.runReportToHtmlFile(str2, servletContext
							.getRealPath("detail/report1Detail.html"),
							parameters, conn);
			String htmlStr = report.getLocalHtmlStream(servletContext
					.getRealPath("detail/report1Detail.html"));

			response.setContentType("application/html");
			response.sendRedirect("detail/report1Detail.html");
			response.setContentLength(htmlStr.length());
			ServletOutputStream output = response.getOutputStream();

			output.write(htmlStr.getBytes(), 0, htmlStr.length());

			output.flush();
			output.close();

			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (JRException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doGet(req, resp);
		doPost(req, resp);
	}

}

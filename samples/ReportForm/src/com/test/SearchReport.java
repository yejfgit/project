package com.test;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

import org.hsqldb.lib.StringUtil;

public class SearchReport extends HttpServlet {

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

		String search = request.getParameter("search");
		/*
		 * String ID0000 = request.getParameter("ID0000");
		 * 
		 * 
		 * if (!StringUtil.isEmpty(ID0000)) { parameters.put("ID0000", new
		 * Integer(ID0000)); } else {
		 * 
		 * parameters.put("ID0000", 0); }
		 */
		if (!StringUtil.isEmpty(MC0000)) {
			parameters.put("MC0000", MC0000);
		}/*
		 * else { parameters.put("MC0000", ""); }
		 */

		if ("1".equals(search)) {
			ServletContext servletContext = this.getServletContext();
			String str2 = report.getJasperFile(servletContext
					.getRealPath("/report1.jrxml"));
			/*
			 * File file = new File(str2); report.fill(parameters,
			 * file.getAbsolutePath()); report.html(file.getAbsolutePath());
			 */

			report.fill(parameters, str2);
			String[] strArry = str2.split("report1.jasper");
			String str3 = strArry[0] + "report1.jrprint";
			report.html(str3);

			request.setAttribute("searchUrl", "report1.html");
			request.setAttribute("search", "search");

			getServletContext().getRequestDispatcher("/index.jsp").forward(
					request, response);
		} else {
			ServletContext servletContext = this.getServletContext();

			String str2 = report.getJasperFile(servletContext
					.getRealPath("/report1_detail.jrxml"));

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

			File file = new File(str2);
			Connection conn = ReportFormConn.getdbConnection();
			String str;
			try {
				str = JasperRunManager.runReportToHtmlFile(file.getPath(),
						parameters, conn);
				response.setContentType("application/html");
				response.sendRedirect("/report1_detail.html");
				response.setContentLength(str.length());
				ServletOutputStream output = response.getOutputStream();

				output.write(str.getBytes(), 0, str.length());

				output.flush();
				output.close();
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

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

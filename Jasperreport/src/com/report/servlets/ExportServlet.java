/*
 * JasperReports - Free Java Reporting Library.
 * Copyright (C) 2001 - 2014 TIBCO Software Inc. All rights reserved.
 * http://www.jaspersoft.com
 *
 * Unless you have purchased a commercial license agreement from Jaspersoft,
 * the following license terms apply:
 *
 * This program is part of JasperReports.
 *
 * JasperReports is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JasperReports is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with JasperReports. If not, see <http://www.gnu.org/licenses/>.
 */
package com.report.servlets;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.report.scriptlets.WebappDataSource;

import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JRAbstractExporter;
import net.sf.jasperreports.engine.JRConstants;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRXmlExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRPptxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 */
public class ExportServlet extends HttpServlet {

	private static final long serialVersionUID = JRConstants.SERIAL_VERSION_UID;

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		ServletContext context = this.getServletConfig().getServletContext();
		String reportFileName ="";
		String docType = "";
		try {

			reportFileName = context.getRealPath("/reports/printPage.jasper");
			docType = request.getParameter("DOCTYPE");
			File reportFile = new File(reportFileName);
			if (!reportFile.exists())
				throw new JRRuntimeException(
						"File WebappReport.jasper not found. The report design must be compiled first.");

			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("ReportTitle", "Address Report");
			parameters.put("BaseDir", reportFile.getParentFile());

			// 普通List对象转成J

			JasperPrint jasperPrint = JasperFillManager.fillReport(reportFileName, parameters, new WebappDataSource());
			List<JasperPrint> jpList = new ArrayList<JasperPrint>();
			jpList.add(jasperPrint);

			JRAbstractExporter exporter = getJRExporter(docType, response);
			exporter.setExporterInput(SimpleExporterInput.getInstance(jpList));

			OutputStream outputStream = response.getOutputStream();
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));

			try {
				exporter.exportReport();
			} catch (JRException e) {
				throw new ServletException(e);
			} finally {
				if (outputStream != null) {
					try {
						outputStream.close();
					} catch (IOException ex) {
					}
				}
			}

		} catch (JRException e) {
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>JasperReports - Web Application Sample</title>");
			out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"../stylesheet.css\" title=\"Style\">");
			out.println("</head>");

			out.println("<body bgcolor=\"white\">");

			out.println("<span class=\"bnew\">JasperReports encountered this error :</span>");
			out.println("<pre>");

			e.printStackTrace(out);

			out.println("</pre>");

			out.println("</body>");
			out.println("</html>");
		}

	}

	/**
	 * 传入类型，获取输出器
	 * 
	 * @param docType
	 * @return
	 */
	private JRAbstractExporter getJRExporter(String docType, HttpServletResponse response) {

		DefaultJasperReportsContext ctx = DefaultJasperReportsContext.getInstance();
		JRAbstractExporter exporter = null;
		String resType = "";

		if ("PDF".equals(docType)) {
			resType = "application/pdf";
			exporter = new JRPdfExporter(ctx);
		} else if ("DOCX".equals(docType)) {
			resType = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
			response.setHeader("Content-Disposition", "inline; filename=\"file.docx\"");
			exporter = new JRDocxExporter(ctx);
		} else if("XLS".equals(docType)){
			exporter = new JRDocxExporter(ctx);
			response.setHeader("Content-Disposition", "inline; filename=\"file.xls\"");
		}else if ("PPTX".equals(docType)) {
			response.setContentType("application/vnd.openxmlformats-officedocument.presentationml.presentation");
			response.setHeader("Content-Disposition", "inline; filename=\"file.pptx\"");
			exporter = new JRPptxExporter(ctx);
		} else if ("XML".equals(docType)) {
			exporter = new JRXmlExporter(ctx);
		} else if ("RTF".equals(docType)) {
			resType = "application/pdf";
			exporter = new JRRtfExporter(ctx);
		}

		return exporter;

	}

}

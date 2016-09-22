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

import java.io.PrintWriter;
import java.net.URLDecoder;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.report.scriptlets.WebappDataSource;
import com.report.utils.ReportConnUtil;
import com.report.utils.ReportUtils;

import net.sf.jasperreports.engine.JRBand;
import net.sf.jasperreports.engine.JRConstants;
import net.sf.jasperreports.engine.JRElement;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRQuery;
import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.JRStaticText;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignBand;
import net.sf.jasperreports.engine.design.JRDesignElement;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.j2ee.servlets.BaseHttpServlet;
import net.sf.jasperreports.j2ee.servlets.XlsxServlet;

/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 */
public class XlsxFillServlet extends XlsxServlet {

	private static final long serialVersionUID = JRConstants.SERIAL_VERSION_UID;

	/**
		 *
		 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ServletContext context = this.getServletConfig().getServletContext();
		response.setContentType("text/html");
		
		//1 直接看固定打印格式  2动态变化的打印格式
		String type= request.getParameter("type");

		try {
			/*if("1".equals(type)){
				String reportFileName = context.getRealPath("/reports/printPage.jasper");
				File reportFile = new File(reportFileName);
				if (!reportFile.exists())
					throw new JRRuntimeException(
							"File WebappReport.jasper not found. The report design must be compiled first.");
	
				Map<String, Object> parameters = new HashMap<String, Object>();
				parameters.put("ReportTitle", "Address Report");
				parameters.put("BaseDir", reportFile.getParentFile());
	
				JasperPrint jasperPrint = JasperFillManager.fillReport(reportFileName, parameters, new WebappDataSource());
	
				request.getSession().setAttribute(BaseHttpServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);
			}else if("2".equals(type)){	
				 //传入报表的jrxml文件name
				 String fileName = request.getParameter("FILE_NAME");
				 String reportFileName = context.getRealPath(fileName);
					File reportFile = new File(reportFileName);
					if (!reportFile.exists())
						throw new JRRuntimeException(
								"File WebappReport.jrxml not found.");
					
				 String[] dataIndexArrayTemp= request.getParameterValues("dataIndexArray");		 		 
				 String[]  dataIndexArray=ReportUtils.getStringArr(dataIndexArrayTemp);
				 //得到的需要动态展示的数据列的dataIndex的值的数组
				 String[] noFilterColTemp= request.getParameterValues("noFilterColArray");	
				 String[]  noFilterCol=ReportUtils.getStringArr(noFilterColTemp);
				 String[] noFilterValTemp= request.getParameterValues("noFilterValArray");	
				 String[]  noFilterVal=ReportUtils.getStringArr(noFilterValTemp);
				//得到页面上的要去拼接sql的的name、条件（>,<,=）、value、连接符（and、or）
				 String[] filterColArrayTemp= request.getParameterValues("filterColArray");	
				 String[]  filterColArray=ReportUtils.getStringArr(filterColArrayTemp);
				 String[] filterConArrayTemp= request.getParameterValues("filterConArray");	
				 String[]  filterConArray=ReportUtils.getStringArr(filterConArrayTemp);				 
				 String[] filterConValArrayTemp= request.getParameterValues("filterConValArray");	
				 String[]  filterConValArray=ReportUtils.getStringArr(filterConValArrayTemp);
				 String[] filterConValTypeArrayTemp= request.getParameterValues("filterConValTypeArray");	
				 String[]  filterConValTypeArray=ReportUtils.getStringArr(filterConValTypeArrayTemp);
				 String[] relationshipArrayTemp= request.getParameterValues("relationshipArray");	
				 String[]  relationshipArray=ReportUtils.getStringArr(relationshipArrayTemp);
				 
				 
			
					
				JasperDesign jdesign  = JRXmlLoader.load(reportFile.getPath());

				Map<String, Object> params = new HashMap<String, Object>();
				 
				params.put("dynamiccolumn", Arrays.asList(dataIndexArray));
				//将传入参数和值写入params
				params= ReportUtils.putValueInParamsMap(params,noFilterCol,noFilterVal);
				//params.put("YKBMBH","5398");
				//除去jrxml模板中不要显示列
				jdesign= ReportUtils.dynamiccolumn(jdesign,params);  
				//给修改后的jrxml进行格式整理
				jdesign= ReportUtils.setStyle(jdesign);
				//给jrxml的query的sql进行拼装处理
				jdesign=ReportUtils.modifyQuery(jdesign,filterColArray,
						filterConArray,filterConValTypeArray,filterConValArray,relationshipArray);
				// 报表修改完成后，以修改后报表进行编译，并输出  
		        JasperReport jreport = JasperCompileManager.compileReport(jdesign);   
		        						        		
				JasperPrint jasperPrint = JasperFillManager.fillReport(jreport, params, ReportConnUtil.getConnection());
				request.getSession().setAttribute(BaseHttpServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);	 												
			}else if("3".equals(type)){	*/
				 //传入报表的jrxml文件name
				 String fileName = request.getParameter("FILE_NAME");
				 File reportFile = new File(context.getRealPath(fileName));
					if (!reportFile.exists())
						throw new JRRuntimeException(
								"File WebappReport.jasper not found. The report design must be compiled first.");
			;
				 String[] dataIndexArrayTemp= request.getParameterValues("dataIndexArray");		 		 
				 String[]  dataIndexArray=ReportUtils.getStringArr(dataIndexArrayTemp);
				 //得到的需要动态展示的数据列的dataIndex的值的数组
				 String[] noFilterColTemp= request.getParameterValues("noFilterColArray");	
				 String[]  noFilterCol=ReportUtils.getStringArr(noFilterColTemp);
				 String[] noFilterValTemp= request.getParameterValues("noFilterValArray");	
				 String[]  noFilterVal=ReportUtils.getStringArr(noFilterValTemp);
				//得到页面上的要去拼接sql的的name、条件（>,<,=）、value、连接符（and、or）
				 String[] filterColArrayTemp= request.getParameterValues("filterColArray");	
				 String[]  filterColArray=ReportUtils.getStringArr(filterColArrayTemp);
				 String[] filterConArrayTemp= request.getParameterValues("filterConArray");	
				 String[]  filterConArray=ReportUtils.getStringArr(filterConArrayTemp);				 
				 String[] filterConValArrayTemp= request.getParameterValues("filterConValArray");	
				 String[]  filterConValArray=ReportUtils.getStringArr(filterConValArrayTemp);
				 String[] filterConValTypeArrayTemp= request.getParameterValues("filterConValTypeArray");	
				 String[]  filterConValTypeArray=ReportUtils.getStringArr(filterConValTypeArrayTemp);
				 String[] relationshipArrayTemp= request.getParameterValues("relationshipArray");	
				 String[]  relationshipArray=ReportUtils.getStringArr(relationshipArrayTemp);
				 
				 //JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(reportFile.getPath());
				 JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(reportFile.getPath());
					
				//JasperDesign jdesign  = JRXmlLoader.load(reportFile.getPath());

				Map<String, Object> params = new HashMap<String, Object>();
				 
				//params.put("dynamiccolumn", Arrays.asList(dataIndexArray));
				params.put("addWhereSQL", ReportUtils.modifyQueryJasperString(jasperReport, filterColArray, filterConArray, filterConValTypeArray, filterConValArray, relationshipArray));
				
				//将传入参数和值写入params
				params= ReportUtils.putValueInParamsMap(params,noFilterCol,noFilterVal);
				//params.put("YKBMBH","5398");
				 if(dataIndexArray!=null&&dataIndexArray.length>0&&dataIndexArray[0]!=null&&!"null".equals(dataIndexArray[0])){	
				
				//除去jrxml模板中不要显示列
					jasperReport= ReportUtils.dynamiccolumnJasper(jasperReport,dataIndexArray);  
					//给修改后的jrxml进行格式整理
					jasperReport= ReportUtils.setStyleJasper(jasperReport,dataIndexArray);
				 }
				//给jrxml的query的sql进行拼装处理
				/*jdesign=ReportUtils.modifyQueryJasper(jdesign,filterColArray,
						filterConArray,filterConValTypeArray,filterConValArray,relationshipArray);*/
				// 报表修改完成后，以修改后报表进行编译，并输出  
		       // JasperReport jreport = JasperCompileManager.compileReport(jdesign);   
		        						        		
				JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, ReportConnUtil.getConnection());
				request.getSession().setAttribute(BaseHttpServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);	 												
			/*}*/
				
				super.service(request, response);
			
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
		}catch(SQLException e){
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>JasperReports - Web Application Sample</title>");
			out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"../stylesheet.css\" title=\"Style\">");
			out.println("</head>");

			out.println("<body bgcolor=\"white\">");

			out.println("<span class=\"bnew\">sql encountered this error :</span>");
			out.println("<pre>");

			e.printStackTrace(out);

			out.println("</pre>");

			out.println("</body>");
			out.println("</html>");
		}
		

	}
	
	@Override
	protected void setResponseHeader(HttpServletResponse response) {
		response.setHeader("Content-Disposition", "inline; filename=\"file2.xlsx\"");
	}
	
}

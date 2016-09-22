<%--
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
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page errorPage="error.jsp" %>
<%@ page import="datasource.*" %>
<%@ page import="net.sf.jasperreports.engine.*" %>
<%@ page import="net.sf.jasperreports.engine.util.*" %>
<%@ page import="net.sf.jasperreports.engine.export.*" %>
<%@ page import="net.sf.jasperreports.j2ee.servlets.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>

<html>
<head>
<script type="text/javascript" src="jatoolsPrinter.js"></script>
<script type="text/javascript">

function doPrint(how)
{
    
//打印文档对象
    var myDoc ={ 
        documents: document,    // 打印页面(div)们在本文档中
       copyrights  :    '杰创软件拥有版权  www.jatools.com'              // 版权声明,必须 

       };
         
    // 调用打印方法
    alert(how);
      var jatoolsPrinter = getJatoolsPrinter();     
    if(how == '打印预览...')
    jatoolsPrinter.printPreview(myDoc);   // 打印预览
                 
   else if(how == '打印...')
      jatoolsPrinter.print(myDoc ,true);   // 打印前弹出打印设置对话框
                
   else
      jatoolsPrinter.print(myDoc ,false);       // 不弹出对话框打印
}
</script>
</head>
<body>
<br>
<input type="button" value="打印预览..." onClick="doPrint('打印预览...')">
<input type="button" value="打印..." onClick="doPrint('打印...')">
<input type="button" value="打印" onClick="doPrint('打印')">
<br>


<%
	File reportFile = new File(application.getRealPath("/reports/WebappReport.jasper"));
    if (!reportFile.exists())
		throw new JRRuntimeException("File WebappReport.jasper not found. The report design must be compiled first.");

	JasperReport jasperReport = (JasperReport)JRLoader.loadObjectFromFile(reportFile.getPath());

	Map parameters = new HashMap();
	parameters.put("ReportTitle", "Address Report");
	parameters.put("BaseDir", reportFile.getParentFile());
	File str= reportFile.getParentFile();
				
	JasperPrint jasperPrint = 
		JasperFillManager.fillReport(
			jasperReport, 
			parameters, 
			new WebappDataSource()
			);
				
	HtmlExporter exporter = new HtmlExporter();

	session.setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);
	
	exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
	exporter.setParameter(JRExporterParameter.OUTPUT_WRITER, out);
	exporter.setParameter(JRHtmlExporterParameter.IMAGES_URI, "../servlets/image?image=");
	
	exporter.exportReport();
%>

<!-- 插入打印控件 -->
   <object id="ojatoolsPrinter" codebase="jatoolsPrinter.cab#version=5,4,0,0"
        classid="clsid:B43D3361-D075-4BE2-87FE-057188254255" width="0" height="0">
            <embed id="ejatoolsPrinter" type="application/x-vnd.jatoolsPrinter"
            pluginspage="jatoolsPrinter.exe" width="0" height="0"
            />
</body>
</html>

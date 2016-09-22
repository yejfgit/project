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
<%@ page import="modifyClasss.HtmlExporterModify" %>
<%@ page import="modifyClasss.JRXhtmlExporterModify" %>
<%@ page import="taoda.javabean.BillDataSource" %>
<%
	String path = request.getContextPath();
	String searchUrl = request.getAttribute("searchUrl") + "";
	String search = request.getAttribute("search") + "";
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/" + searchUrl;

	System.out.println(basePath);
	System.out.println(search);
%>
<html>
<head>
<script type="text/javascript" src="jatoolsPrinter.js"></script>
<script type="text/javascript">

function doPrint(how)
{
    
//打印文档对象
    var myDoc ={ 
                settings:
                        {
                        //A4字为210*297毫米
                        pageWidth: 595,    //自定义纸张宽度（单位为十分之一毫米）
                        pageHeight: 842,  //自定义纸张高度（单位为十分之一毫米）
                        orientation: 1     //打印方向
                        },
                    enableScreenOnlyClass:true, // 使所有使用 screen-only 样式类的对象，只在预览、显示时可见，打印时隐藏
                    documents: document, // 打印页面(div)们在本文档中
                    marginIgnored: true,
                   settingsID: 'mydocc', //打印设置的ID保存在注册表中
                   copyrights  :    '杰创软件拥有版权  www.jatools.com'   
       };
         
    // 调用打印方法
    //alert(how);
      var jatoolsPrinter = getJatoolsPrinter();     
    if(how == '打印预览')
    jatoolsPrinter.printPreview(myDoc,true);   // 打印预览
                 
   else if(how == '打印（弹出框）')
      jatoolsPrinter.print(myDoc ,true);   // 打印前弹出打印设置对话框
                
   else
      jatoolsPrinter.print(myDoc ,false);       // 不弹出对话框打印
}


</script>
</head>
<body>
<br>

<input type="button" value="打印预览..." onClick="doPrint('打印预览')">
<input type="button" value="打印（弹出框）" onClick="doPrint('打印（弹出框）')">
<input type="button" value="直接打印" onClick="doPrint('直接打印')">
<br>


<%
	File reportFile = new File(application.getRealPath("/reports/taoda.jasper"));
    if (!reportFile.exists())
		throw new JRRuntimeException("File WebappReport.jasper not found. The report design must be compiled first.");
	JasperReport jasperReport = (JasperReport)JRLoader.loadObjectFromFile(reportFile.getPath());
	
	
	
	Map imagesMap = new HashMap();           
   	session.setAttribute("IMAGES_MAP", imagesMap);
	Map parameters = new HashMap();  
	
				
	JasperPrint jasperPrint = 
		JasperFillManager.fillReport(
			jasperReport, 
			parameters, 
			new BillDataSource()
			);
			
			//HtmlExporterModify exporter = new HtmlExporterModify();	
			//JRXhtmlExporter exporter = new JRXhtmlExporter();	
			
			//HtmlExporter exporter = new HtmlExporterModify();;	
			JRXhtmlExporterModify	exporter = new JRXhtmlExporterModify();		
	  		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_WRITER, out);
            exporter.setParameter(JRHtmlExporterParameter.IMAGES_MAP, imagesMap);
            String imgServDirUrl = "/images/";
            File imgRealDir = new File(request.getRealPath(File.separator)
                    + imgServDirUrl);
            if (!imgRealDir.exists()) {
                imgRealDir.mkdirs();
            }
            exporter.setParameter(JRHtmlExporterParameter.IMAGES_URI, request
                    .getContextPath()
                    + imgServDirUrl);
            exporter.setParameter(JRHtmlExporterParameter.IMAGES_DIR,
                    imgRealDir);
            exporter.setParameter(
                    JRHtmlExporterParameter.IS_OUTPUT_IMAGES_TO_DIR,
                    Boolean.TRUE);

            exporter.setParameter(
                    JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN,
                    Boolean.FALSE);
            exporter.exportReport();
            
            
            
            
            
                /*     File reportFile = new File(application
                    .getRealPath("/jasper/taoda.jasper"));
            JasperReport jasperReport = (JasperReport) JRLoader
                    .loadObject(reportFile.getPath());
            Map parameters = new HashMap();

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/DataName", "user", "password");
            JasperPrint jasperPrint = JasperFillManager.fillReport(
                    jasperReport, parameters, conn);

            JRXhtmlExporter exporter = new JRXhtmlExporter();
            StringBuffer sbuffer = new StringBuffer();

            Map imagesMap = new HashMap();
            session.setAttribute("IMAGES_MAP", imagesMap);

            exporter
                    .setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_WRITER, out);
            exporter
                    .setParameter(JRHtmlExporterParameter.IMAGES_MAP, imagesMap);
            String imgServDirUrl = "/images/";
            File imgRealDir = new File(request.getRealPath(File.separator)
                    + imgServDirUrl);
            if (!imgRealDir.exists()) {
                imgRealDir.mkdirs();
            }
            exporter.setParameter(JRHtmlExporterParameter.IMAGES_URI, request
                    .getContextPath()
                    + imgServDirUrl);
            exporter.setParameter(JRHtmlExporterParameter.IMAGES_DIR,
                    imgRealDir);
            exporter.setParameter(
                    JRHtmlExporterParameter.IS_OUTPUT_IMAGES_TO_DIR,
                    Boolean.TRUE);

            exporter.setParameter(
                    JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN,
                    Boolean.FALSE);
            exporter.exportReport();
            conn.close();*/
	
		
/*				
	HtmlExporter exporter = new HtmlExporterModify();
	session.setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);	
	exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
	exporter.setParameter(JRExporterParameter.OUTPUT_WRITER, out);
//	exporter.setParameter(JRHtmlExporterParameter.IMAGES_URI, "../servlets/image?image=");
	
	exporter.exportReport();*/
%>

<!-- 插入打印控件 -->
   <object id="ojatoolsPrinter" codebase="jatoolsPrinter.cab#version=5,4,0,0"
        classid="clsid:B43D3361-D075-4BE2-87FE-057188254255" width="0" height="0">
            <embed id="ejatoolsPrinter" type="application/x-vnd.jatoolsPrinter"
            pluginspage="jatoolsPrinter.exe" width="0" height="0"
            />
</body>
</html>

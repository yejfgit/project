/*

 */
package com.report.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.groovy.util.StringUtil;

import com.report.ext.HtmlExporterExt;
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
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;
import net.sf.jasperreports.j2ee.servlets.ImageServlet;
import net.sf.jasperreports.web.util.WebHtmlResourceHandler;

/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 */
public class HtmlServlet extends HttpServlet {
	/**
	 *
	 */
	private static final long serialVersionUID = JRConstants.SERIAL_VERSION_UID;

	/**
	 *
	 */
	/* (non-Javadoc) ����ͨ��sql��ʽȥ���ɱ���
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	ServletContext context = this.getServletConfig().getServletContext();
		
	//1 ֱ�ӿ��̶�����  2��̬�仯�Ĵ�ӡ��ʽ(Ҳ���Դ�ӡ�̶�����)
	  // String type= request.getParameter("type");
	   String fileName = request.getParameter("FILE_NAME");
	   response.setContentType("text/html");
	   response.setCharacterEncoding("UTF-8");
	   PrintWriter out = response.getWriter();
	   	   	   
	   try {
		/*if("1".equals(type)){
		//String fileName = request.getParameter("FILE_NAME");// "/reports/WebappReport.jasper"
				
			File reportFile = new File(context.getRealPath(fileName));
			if (!reportFile.exists())
				throw new JRRuntimeException(
						"File WebappReport.jasper not found. The report design must be compiled first.");

			JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(reportFile.getPath());
			
			//�õ���д����sql�еĴ���������ƺ�ֵ
		   String[] noFilterColTemp= request.getParameterValues("noFilterColArray");	
		   String[]  noFilterCol=ReportUtils.getStringArr(noFilterColTemp);
		   String[] noFilterValTemp= request.getParameterValues("noFilterValArray");	
		   String[]  noFilterVal=ReportUtils.getStringArr(noFilterValTemp);


			Map<String, Object> params = new HashMap<String, Object>();
			
			//�����������ֵд��params
			params=ReportUtils.putValueInParamsMap(params,noFilterCol,noFilterVal);
			//parameters.put("ReportTitle", "Address Report");
			//parameters.put("BaseDir", reportFile.getParentFile());

			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params,ReportConnUtil.getConnection());

			HtmlExporter exporter = new HtmlExporterExt();

			request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);

			exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			SimpleHtmlExporterOutput output = new SimpleHtmlExporterOutput(out);
			output.setImageHandler(new WebHtmlResourceHandler("image?image={0}"));
			exporter.setExporterOutput(output);

			exporter.exportReport();
		
		}else if("2".equals(type)){
			//ServletContext context = this.getServletConfig().getServletContext();
			// request.setCharacterEncoding("UTF-8");
			 //���뱨���jrxml�ļ�name
			 //String fileName = request.getParameter("FILE_NAME");
			  //�õ�����Ҫ��̬չʾ�������е�dataIndex��ֵ������
			 String[] dataIndexArrayTemp= request.getParameterValues("dataIndexArray");		 		 
			 String[]  dataIndexArray=ReportUtils.getStringArr(dataIndexArrayTemp);
			
			//�õ���д����sql�еĴ���������ƺ�ֵ
			 String[] noFilterColTemp= request.getParameterValues("noFilterColArray");	
			 String[]  noFilterCol=ReportUtils.getStringArr(noFilterColTemp);
			 String[] noFilterValTemp= request.getParameterValues("noFilterValArray");	
			 String[]  noFilterVal=ReportUtils.getStringArr(noFilterValTemp);
			 
			 //�õ�ҳ���ϵ�Ҫȥƴ��sql�ĵ�name��������>,<,=����value�����ӷ���and��or��
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
			 		 		 		
			 response.setContentType("text/html");
			 response.setCharacterEncoding("UTF-8");
			 PrintWriter out = response.getWriter();
									
			JasperDesign jdesign = null;
			File reportFile = new File(context.getRealPath(fileName));
				
				
			jdesign = JRXmlLoader.load(reportFile.getPath());
			
			Map<String, Object> params = new HashMap<String, Object>();
			
			params.put("dynamiccolumn", Arrays.asList(dataIndexArray));
				
				//�����������ֵд��params
			params=ReportUtils.putValueInParamsMap(params,noFilterCol,noFilterVal);
			//params.put("YKBMBH","5398");
				
			//��ȥjrxmlģ���в�Ҫ��ʾ��
			jdesign=ReportUtils.dynamiccolumn(jdesign,params);  
			//���޸ĺ��jrxml���и�ʽ����
			jdesign= ReportUtils.setStyle(jdesign);
			//��jrxml��query��sql����ƴװ����
			jdesign=ReportUtils.modifyQuery(jdesign,filterColArray,
					filterConArray,filterConValTypeArray,filterConValArray,relationshipArray);
				 
			// �����޸���ɺ����޸ĺ󱨱���б��룬�����  
		    JasperReport jreport = JasperCompileManager.compileReport(jdesign);   
			//�����ݷ�װ��JasperReport��	 		 																		            			
		    JasperPrint jasperPrint = JasperFillManager.fillReport(jreport, params,ReportConnUtil.getConnection());

			HtmlExporter exporter = new HtmlExporterExt();

			request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);

			exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			SimpleHtmlExporterOutput output = new SimpleHtmlExporterOutput(out);
			output.setImageHandler(new WebHtmlResourceHandler("image?image={0}"));
			exporter.setExporterOutput(output);

			exporter.exportReport();
			
		}else if("3".equals(type)){*/
			
			 File reportFile = new File(context.getRealPath(fileName));
				if (!reportFile.exists())
					throw new JRRuntimeException(
							"File WebappReport.jasper not found. The report design must be compiled first.");

			//Ҫȥ������
			 String[] dataIndexArrayTemp= request.getParameterValues("dataIndexArray");		 		 
			 String[]  dataIndexArray=ReportUtils.getStringArr(dataIndexArrayTemp);
			 //System.out.println("dataIndexArray.length:"+dataIndexArray.length);
			
			//�õ���д����sql�еĴ���������ƺ�ֵ
			 String[] noFilterColTemp= request.getParameterValues("noFilterColArray");	
			 String[]  noFilterCol=ReportUtils.getStringArr(noFilterColTemp);
			 String[] noFilterValTemp= request.getParameterValues("noFilterValArray");	
			 String[]  noFilterVal=ReportUtils.getStringArr(noFilterValTemp);
			 
			 //�õ�ҳ���ϵ�Ҫȥƴ��sql�ĵ�name��������>,<,=����value�����ӷ���and��or��
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
			 		 		 		
			 JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(reportFile.getPath());
			
			 Map<String, Object> params = new HashMap<String, Object>();
			 
			 //if(dataIndexArray!=null&&dataIndexArray.length>0){
			
				// params.put("dynamiccolumn", Arrays.asList(dataIndexArray));
			// }
			 
			 params.put("addWhereSQL", ReportUtils.modifyQueryJasperString(jasperReport, filterColArray, filterConArray, filterConValTypeArray, filterConValArray, relationshipArray));
				
				//�����������ֵд��params
			 params=ReportUtils.putValueInParamsMap(params,noFilterCol,noFilterVal);
			//params.put("YKBMBH","5398");
				
			 if(dataIndexArray!=null&&dataIndexArray.length>0&&dataIndexArray[0]!=null&&!"null".equals(dataIndexArray[0])){		
				 //��ȥjrxmlģ���в�Ҫ��ʾ��
				 jasperReport=ReportUtils.dynamiccolumnJasper(jasperReport,dataIndexArray);  
				//���޸ĺ��jrxml���и�ʽ����
				 jasperReport= ReportUtils.setStyleJasper(jasperReport,dataIndexArray);
			 }
			
			//��jrxml��query��sql����ƴװ����
			/* jasperReport=ReportUtils.modifyQueryJasper(jasperReport,filterColArray,
					filterConArray,filterConValTypeArray,filterConValArray,relationshipArray);
				 */
			// �����޸���ɺ����޸ĺ󱨱���б��룬�����  
		   // JasperReport jreport = JasperCompileManager.compileReport(jasperReport);   
			//�����ݷ�װ��JasperReport��	 		 																		            			
		    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params,ReportConnUtil.getConnection());

			HtmlExporter exporter = new HtmlExporterExt();

			request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);

			exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			SimpleHtmlExporterOutput output = new SimpleHtmlExporterOutput(out);
			output.setImageHandler(new WebHtmlResourceHandler("image?image={0}"));
			exporter.setExporterOutput(output);

			exporter.exportReport();
			
		/*}*/
												
		} catch (JRException e) {
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
 
}

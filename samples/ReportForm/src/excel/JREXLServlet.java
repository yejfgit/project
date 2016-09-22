
package excel;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRXlsAbstractExporter;
import net.sf.jasperreports.engine.export.JRXlsAbstractExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.FileBufferedOutputStream;
import net.sf.jasperreports.engine.util.JRLoader;

import com.test.ReportFormUtil;

import dy.javabean.WebappDataSource;

public class JREXLServlet extends HttpServlet {
	  
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * 生成Excel表格
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//File jasperFile = null;
		/*try {
			Configuration config = new  PropertiesConfiguration("config.properties");
			jasperFile = new File(config.getString("project.info.report.jasper"));
		} catch (ConfigurationException e2) {
			e2.printStackTrace();
		}*/
		ReportFormUtil  report= new ReportFormUtil();		
		ServletContext servletContext = this.getServletContext();
		
		String str2 =report.getJasperFile(servletContext.getRealPath("reports/printPage.jrxml"));
	      
	     File jasperFile = new File(str2);
		//File reportFile = new File(application.getRealPath("/reports/printPage.jasper"));
	   //JasperReport jasperReport = (JasperReport)JRLoader.loadObjectFromFile(reportFile.getPath());
	    if (!jasperFile.exists())
			throw new JRRuntimeException("File WebappReport.jasper not found. The report design must be compiled first.");
		
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		String pageFrom =  request.getParameter("pageFrom");
		String pageTo =  request.getParameter("pageTo");


		if(pageFrom != null&&!"".equals(pageFrom)){
			parameters.put("pageFrom", Integer.parseInt(pageFrom));
		}
		if(pageTo != null&&!"".equals(pageTo)){
			parameters.put("pageTo", Integer.parseInt(pageTo));
		}
		
		JasperPrint jasperPrint = null;
		try {
			JasperReport jasperReport = (JasperReport) JRLoader
					.loadObject(jasperFile);
			jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,
					new WebappDataSource());						
		} catch (JRException e) {
			e.printStackTrace();
		}

		if(null != jasperPrint){
			FileBufferedOutputStream fbos = new FileBufferedOutputStream();
			JRXlsAbstractExporter exporter = new JRXlsExporter();
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, fbos);
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JRXlsAbstractExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
			exporter.setParameter(JRXlsAbstractExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
			/**不分页**/
			exporter.setParameter(JRXlsExporterParameter.IGNORE_PAGE_MARGINS,Boolean.TRUE);
			/**解决勾选stretch with overflow的折行问题**/
			exporter.setParameter(JRXlsExporterParameter.IS_COLLAPSE_ROW_SPAN,Boolean.TRUE);
			try {				
				exporter.exportReport();
				fbos.close();
				if (fbos.size() > 0) {
					response.setContentType("application/xls");
					response.setHeader("Content-Disposition", "inline; filename=\"ProjectInfo.xls\"");
					response.setContentLength(fbos.size());
					ServletOutputStream ouputStream = response.getOutputStream();
					try {
						fbos.writeData(ouputStream);
						fbos.dispose();
						ouputStream.flush();
					} finally {
						if (null != ouputStream) {
							ouputStream.close();
						}
					}
				}
			} catch (JRException e1) {
				e1.printStackTrace();
			}finally{
				if(null !=fbos){
					fbos.close();
					fbos.dispose();
				}
			}
		}

	}
}

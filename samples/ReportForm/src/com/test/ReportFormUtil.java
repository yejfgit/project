package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.util.AbstractSampleApp;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;

public class ReportFormUtil extends AbstractSampleApp {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String getJasperFile(String fileName){
		String jasperFile= null;
		 try {
			jasperFile=JasperCompileManager.compileReportToFile(fileName);
		
			
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jasperFile;
	}
	
	public void fill(Map<String, Object> parameters,String jasperFileUrl)
	{
		//Map<String, Object> parameters = new HashMap<String, Object>();
		//parameters.put("MaxOrderID", new Integer(12500));
				
		try {
			JasperFillManager.fillReportToFile(
					jasperFileUrl, 
					parameters, 
					ReportFormConn.getdbConnection());
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	
	public void fill(Map<String, Object> parameters)
	{
		//Map<String, Object> parameters = new HashMap<String, Object>();
		//parameters.put("MaxOrderID", new Integer(12500));
		
		File[] files = getFiles(new File("E:\\iReport_jrxml"), "jasper");
		for(int i = 0; i < files.length; i++)
		{
			File reportFile = files[i];
			long start = System.currentTimeMillis();
			try {
				JasperFillManager.fillReportToFile(
					reportFile.getAbsolutePath(), 
					parameters, 
					ReportFormConn.getdbConnection()
					);
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.err.println("Report : " + reportFile + ". Filling time : " + (System.currentTimeMillis() - start));
		}
	}
	
	
	/**
	 *
	 */
	public void pdf() throws JRException
	{
		File[] files = getFiles(new File("build/reports"), "jrprint");
		for(int i = 0; i < files.length; i++)
		{
			File reportFile = files[i];
			long start = System.currentTimeMillis();
			JasperExportManager.exportReportToPdfFile(
				reportFile.getAbsolutePath()
				);
			System.err.println("Report : " + reportFile + ". PDF export time : " + (System.currentTimeMillis() - start));
		}
	}

	/**
	 *
	 */
	public void html(String fileUrl)
	
	{
			//File[] files = getFiles(new File(""), "jrprint");
			
			//fileUrl.
			long start = System.currentTimeMillis();
			try {
				JasperExportManager.exportReportToHtmlFile(
						fileUrl
					);
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.err.println("Report : " + fileUrl + ". HTML export time : " + (System.currentTimeMillis() - start));
		
	}

	
	/**
	 *
	 */
	public void html()
	{
		File[] files = getFiles(new File("build/reports"), "jrprint");
		for(int i = 0; i < files.length; i++)
		{
			File reportFile = files[i];
			long start = System.currentTimeMillis();
			try {
				JasperExportManager.exportReportToHtmlFile(
					reportFile.getAbsolutePath()
					);
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.err.println("Report : " + reportFile + ". HTML export time : " + (System.currentTimeMillis() - start));
		}
	}


	/**
	 *
	 */
	@SuppressWarnings("deprecation")
	public void xhtml() throws JRException
	{
		File[] files = getFiles(new File("build/reports"), "jrprint");
		for(int i = 0; i < files.length; i++)
		{
			File sourceFile = files[i];
			long start = System.currentTimeMillis();

			JasperPrint jasperPrint = (JasperPrint)JRLoader.loadObject(sourceFile);

			File destFile = new File(sourceFile.getParent(), jasperPrint.getName() + ".x.html");
			
			net.sf.jasperreports.engine.export.JRXhtmlExporter exporter = 
				new net.sf.jasperreports.engine.export.JRXhtmlExporter();

			exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			exporter.setExporterOutput(new SimpleHtmlExporterOutput(destFile));
			//exporter.setParameter(JRHtmlExporterParameter.ZOOM_RATIO, new Float(3f));

			exporter.exportReport();

			System.err.println("Report : " + sourceFile + ". XHTML export time : " + (System.currentTimeMillis() - start));
		}
	}


	/**
	 *
	 */
	public static final Date truncateToMonth(Date date)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		return calendar.getTime();
	}


	@Override
	public void test() throws JRException {
		// TODO Auto-generated method stub
		
	}

	
    public static String getLocalHtmlStream(String path) throws Exception {
	         File f = new File(path);
	         if(!f.exists() && !f.getAbsolutePath().endsWith("html")) {
	             return "";
	         } //
	         InputStream in = new FileInputStream(f) ;
	         StringBuffer b = new StringBuffer();
	         int c;
	         while((c =in.read()) != -1) {
	             b.append((char)c);
	         }
	         return b.toString();
	  }
				
/*
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charrset=GBK"); 
		ResultSet resultSet = null; 
		Connection con = ReportFormUtil.getdbConnection();    
		      PreparedStatement statement; 
		try { 
		statement = con.prepareStatement(     
		            "select * from fruitSell "      
		         ); 
		     resultSet = statement.executeQuery();  
		} catch (SQLException e) { 
		// TODO Auto-generated catch block 
		e.printStackTrace(); 
		}      
		            
		      JRResultSetDataSource result =     
		         new JRResultSetDataSource( resultSet );    
		      JasperReport jasperReport; 
		try { 
		jasperReport = JasperCompileManager.compileReport(getServletContext().getRealPath("reports/fruitSell.jrxml")); 
		   
		      JasperPrint jasperPrint =     
		         JasperFillManager.fillReport(     
		            jasperReport, new HashMap(), result     
		         );    
		            
		      JasperExportManager.exportReportToPdfFile(    
		         jasperPrint, "reports/fruitSell1.pdf"  
		      ); 
		} catch (JRException e) { 
		// TODO Auto-generated catch block 
		e.printStackTrace(); 
		} 
		getServletContext().getRequestDispatcher("/doIndex.jsp").forward(request, response); 
		
		//super.doPost(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
	}

*/
	/*@Override
	public void test() throws JRException {
		// TODO Auto-generated method stub
		
	}
	
	
	*/
	

}

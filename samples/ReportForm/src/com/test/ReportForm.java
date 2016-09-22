package com.test;

import java.io.File;
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
import net.sf.jasperreports.engine.JasperRunManager;

import org.hsqldb.lib.StringUtil;

public class ReportForm extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//LogFactory
		//response.setContentType("text/html;charrset=GBK"); 
		//ResultSet resultSet = null; 
		//Connection con = ReportFormUtil.getdbConnection();    
		//PreparedStatement statement; 
		ReportFormUtil  report= new ReportFormUtil();		  
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		Map<String, Object>  parameters= new HashMap<String, Object>();
					
		String ID0000 = request.getParameter("ID0000");
		String MC0000 = request.getParameter("MC0000");
		
		if(!StringUtil.isEmpty(ID0000)){
			parameters.put("ID0000", new Integer(ID0000));
		}
		if(!StringUtil.isEmpty(MC0000)){
			parameters.put("MC0000", MC0000);	      
		}	
		//report.fill(parameters);
		     //fill();
			//	pdf();
		//report.html();//FIXMESAMPLES move to xhtml everywhere
			//	xhtml();
				
		//获得输出流  
	        //ServletOutputStream outputStream = response.getOutputStream();  	    
	        
	    /*  File file = new File("E:\\iReport_jrxml\\report1.jasper");*/
							
        ServletContext servletContext = this.getServletContext();
	      
	      String str2 =report.getJasperFile(servletContext.getRealPath("/report1.jrxml"));
	      
	      File file = new File(str2);
	      
	     // File file = new File(servletContext.getRealPath("/report1.jasper"));
	      // InputStream inputStream =new  FileInputStream(file);
	        
		        //获得输入流  
		      // InputStream inputStream = getServletConfig().getServletContext().getResourceAsStream("report1.jasper"); 	      
	      		Connection conn =ReportFormConn.getdbConnection();
		
		       try {
				String str = JasperRunManager.runReportToHtmlFile(file.getPath(), parameters, conn);
				response.setContentType("application/html"); 
				response.sendRedirect("report1.html");
				response.setContentLength(str.length());				
				ServletOutputStream output = response.getOutputStream();
				
				output.write(str.getBytes(), 0, str.length());
				
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
			}
		       		       
		        /*    //生成网页的PDF文件  
		            try {
						//JasperRunManager.runReportToPdfStream(inputStream, outputStream,parameters, ReportFormUtil.getdbConnection());
		            	
		            	//JasperRunManager.runReportToHtmlFile("E:\\iReport_jrxml\\report1.jasper", "E:\\iReport_jrxml\\report1.html", parameters, ReportFormUtil.getdbConnection());
		            	
		            	
		            	
					} catch (JRException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  */
		           //设置PDF格式  
		           // response.setContentType("application/pdf");  
		            //outputStream.flush();  
		            //outputStream.close();           
						      		      	     		   
		//getServletContext().getRequestDispatcher("/index.jsp").forward(request, response); 
		
		//super.doPost(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doGet(req, resp);
		doPost(req, resp);
	}

}

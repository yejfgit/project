package com.test;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.*;
import javax.servlet.http.*;
import com.sun.image.codec.jpeg.*;//sun��˾���ṩ��jpgͼƬ�ļ��ı���api

import javax.imageio.ImageIO;
import javax.imageio.stream.*;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRGraphics2DExporter;
import net.sf.jasperreports.engine.export.JRGraphics2DExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * 
 * ��ʾ�ļ���Servlet
 * ����ӱ����ļ��ж�ȡͼƬ��
 * 
 */
public class ShowPic extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {

	private static final String GIF = "image/gif;charset=GB2312";// �趨���������

	private static final String JPG = "image/jpeg;charset=GB2312";

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public ShowPic() {
		super();
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//String spec = request.getParameter("spec");// ���ͼƬ�����͵ı�־
		
		ReportFormUtil  report= new ReportFormUtil();	
		
        ServletContext servletContext = this.getServletContext();
	      
	      String str2 =report.getJasperFile(servletContext.getRealPath("/report1.jrxml"));
	      
	            
			Map parameters = new HashMap();
			JasperPrint jasperPrint = null;
			JRGraphics2DExporter exporter = null;
			try {
				jasperPrint = JasperFillManager.fillReport(
						(JasperReport) JRLoader.loadObject(new File(str2)),//jasper����
						parameters,//�����б�
						new JREmptyDataSource()//����Դ��Ϣ
				);
				exporter = new JRGraphics2DExporter();
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//����graphics�����
			//����һ��Ӱ�����
			BufferedImage bufferedImage = new BufferedImage(jasperPrint.getPageWidth() * 4, jasperPrint.getPageHeight() * 4, BufferedImage.TYPE_INT_RGB);
			//ȡgraphics
			Graphics2D g = (Graphics2D) bufferedImage.getGraphics();
			//������Ӧ������Ϣ
			exporter.setParameter(JRGraphics2DExporterParameter.GRAPHICS_2D, g);
			exporter.setParameter(JRGraphics2DExporterParameter.ZOOM_RATIO, Float.valueOf(4));
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			try {
				exporter.exportReport();
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			g.dispose();//�ͷ���Դ��Ϣ
			//�����bufferedImage�������յ�Ӱ��ͼ����Ϣ,����ͨ����������뵽cm����.
			ImageIO.write(bufferedImage, "JPEG", new File("d:/aa.jpg"));
	      	      	      	      	      	      	      	      				

		//String imagePath = "D:\\temp\\1.jpg";
		
		

//		response.reset();
//
//		OutputStream output = response.getOutputStream();// �õ������
//		if (imagePath.toLowerCase().endsWith(".jpg"))// ʹ�ñ��봦���ļ����������
//		{
//			response.setContentType(JPG);// �趨���������
//			// �õ�ͼƬ����ʵ·��
//
//			// �õ�ͼƬ���ļ���
//			InputStream imageIn = new FileInputStream(new File(imagePath));
//			// �õ�����ı����������ļ�������jpg��ʽ����
//			JPEGImageDecoder decoder = JPEGCodec.createJPEGDecoder(imageIn);
//			// �õ�������ͼƬ����
//			BufferedImage image = decoder.decodeAsBufferedImage();
//			// �õ�����ı�����
//			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(output);
//			encoder.encode(image);// ��ͼƬ�����������
//			imageIn.close();// �ر��ļ���
//		}
//		if (imagePath.toLowerCase().endsWith(".gif"))// ��ʹ�ñ��봦���ļ����������
//		{
//			response.setContentType(GIF);
//			ServletContext context = getServletContext();// �õ���������
//			InputStream imageIn = context.getResourceAsStream(imagePath);// �ļ���
//			BufferedInputStream bis = new BufferedInputStream(imageIn);// ���뻺����
//			BufferedOutputStream bos = new BufferedOutputStream(output);// ���������
//			byte data[] = new byte[4096];// �����ֽ���
//			int size = 0;
//			size = bis.read(data);
//			while (size != -1) {
//				bos.write(data, 0, size);
//				size = bis.read(data);
//			}
//			bis.close();
//			bos.flush();// ������������
//			bos.close();
//		}
//		output.close();
	}
}
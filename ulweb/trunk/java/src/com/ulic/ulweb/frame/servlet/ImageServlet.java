package com.ulic.ulweb.frame.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ImageServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.reset();
		response.setContentType("image/png");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		HttpSession session = request.getSession();
		int width = 60, height = 20;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		this.setProperty(g, width, height);
		Random random = new Random();
		this.drawLine(g, random, width, height);
		g.setColor(getRandColor(160, 200));
		String sRand = this.drawNumber(g, random);
		g.dispose();
		session.removeAttribute("rand");
		session.setAttribute("rand", sRand);
		ServletOutputStream sos = response.getOutputStream();
		ImageIO.write(image, "JPEG", sos);
		sos.flush();
		sos.close();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
	private Color getRandColor(int fc, int bc) {
		Random random = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}
	private void drawLine(Graphics g, Random random, int width, int height) {
		for (int i = 0; i < 155; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}
	}
	private String drawNumber(Graphics g, Random random) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 4; i++) {
			int number = (int) (Math.random() * 10);
			sb.append(number);
		}
		String rand = sb.toString();
		g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random
				.nextInt(110)));
		g.drawString(rand, 13 * 1 + 6, 16);
		return rand;
	}
	private void setProperty(Graphics g, int width, int height) {
		g.setColor(getRandColor(200, 250));
		g.fillRect(0, 0, width, height);
		g.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		g.setColor(new Color(255, 255, 255));
		g.drawRect(0, 0, width - 1, height - 1);
	}
}
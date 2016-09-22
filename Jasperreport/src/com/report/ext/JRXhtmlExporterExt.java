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

/*
 * Contributors:
 * Alex Parfenov - aparfeno@users.sourceforge.net
 * Adrian Jackson - iapetus@users.sourceforge.net
 * David Taylor - exodussystems@users.sourceforge.net
 * Lars Kristensen - llk@users.sourceforge.net
 */

package com.report.ext;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.geom.Dimension2D;
import java.io.IOException;
import java.util.List;

import net.sf.jasperreports.engine.ImageMapRenderable;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRImageRenderer;
import net.sf.jasperreports.engine.JRLineBox;
import net.sf.jasperreports.engine.JRPen;
import net.sf.jasperreports.engine.JRPrintElement;
import net.sf.jasperreports.engine.JRPrintElementIndex;
import net.sf.jasperreports.engine.JRPrintImage;
import net.sf.jasperreports.engine.JRPrintImageAreaHyperlink;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JRWrappingSvgRenderer;
import net.sf.jasperreports.engine.Renderable;
import net.sf.jasperreports.engine.RenderableUtil;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.engine.export.HtmlFont;
import net.sf.jasperreports.engine.export.HtmlResourceHandler;
import net.sf.jasperreports.engine.export.JRXhtmlExporter;
import net.sf.jasperreports.engine.type.ModeEnum;
import net.sf.jasperreports.engine.type.RenderableTypeEnum;
import net.sf.jasperreports.engine.type.ScaleImageEnum;
import net.sf.jasperreports.engine.util.JRColorUtil;
import net.sf.jasperreports.engine.util.JRStringUtil;
import net.sf.jasperreports.engine.util.Pair;
import net.sf.jasperreports.export.ExportInterruptedException;
import net.sf.jasperreports.export.ExporterInputItem;
import net.sf.jasperreports.export.HtmlExporterConfiguration;
import net.sf.jasperreports.export.WriterExporterOutput;


/**
 * Exports a JasperReports document to XHTML format.

 * @deprecated Replaced by {@link HtmlExporter}.
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 */
public class JRXhtmlExporterExt extends JRXhtmlExporter
{
	


	protected void exportReportToWriter() throws JRException, IOException
	{
		HtmlExporterConfiguration configuration = getCurrentConfiguration();
		String htmlHeader = configuration.getHtmlHeader();
		String betweenPagesHtml = configuration.getBetweenPagesHtml();
		String htmlFooter = configuration.getHtmlFooter();

		if (htmlHeader == null)
		{
			String encoding = ((WriterExporterOutput)getExporterOutput()).getEncoding();

			writer.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
			writer.write("<html>\n");
			writer.write("<head>\n");
			writer.write("  <title></title>\n");
			writer.write("  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=" + encoding + "\"/>\n");
			writer.write("  <style type=\"text/css\">\n");
			writer.write("    a {text-decoration: none}\n");
			writer.write("  </style>\n");
			writer.write("</head>\n");
			writer.write("<body text=\"#000000\" link=\"#000000\" alink=\"#000000\" vlink=\"#000000\">\n");
			writer.write("<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n");
			writer.write("<tr><td width=\"50%\">&nbsp;</td><td align=\"center\">\n");
			writer.write("\n");
		}
		else
		{
			writer.write(htmlHeader);
		}

		List<ExporterInputItem> items = exporterInput.getItems();

		for(reportIndex = 0; reportIndex < items.size(); reportIndex++)
		{
			ExporterInputItem item = items.get(reportIndex);

			setCurrentExporterInputItem(item);

			List<JRPrintPage> pages = jasperPrint.getPages();
			if (pages != null && pages.size() > 0)
			{
				PageRange pageRange = getPageRange();
				int startPageIndex = (pageRange == null || pageRange.getStartPageIndex() == null) ? 0 : pageRange.getStartPageIndex();
				int endPageIndex = (pageRange == null || pageRange.getEndPageIndex() == null) ? (pages.size() - 1) : pageRange.getEndPageIndex();

				JRPrintPage page = null;
				for(pageIndex = startPageIndex; pageIndex <= endPageIndex; pageIndex++)
				{
					if (Thread.interrupted())
					{
						throw new ExportInterruptedException();
					}

					page = pages.get(pageIndex);
					
					//add by liudong
					writer.write("<div id='page"+ (pageIndex + 1)+"'>\n");

					writer.write("<a name=\"" + JR_PAGE_ANCHOR_PREFIX + reportIndex + "_" + (pageIndex + 1) + "\"></a>\n");
					

					/*   */
					exportPage(page);
					//add by liudong
					writer.write("</div>\n");

					if (reportIndex < items.size() - 1 || pageIndex < endPageIndex)
					{
						if (betweenPagesHtml == null)
						{
							writer.write("<br/>\n<br/>\n");
						}
						else
						{
							writer.write(betweenPagesHtml);
						}
					}

					writer.write("\n");
				}
			}
		}

		if (fontsToProcess != null && fontsToProcess.size() > 0)// when no fontHandler and/or resourceHandler, fonts are not processed 
		{
			HtmlResourceHandler fontHandler = 
				getExporterOutput().getFontHandler() == null
				? getFontHandler()
				: getExporterOutput().getFontHandler();
			for (HtmlFont htmlFont : fontsToProcess.values())
			{
				writer.write("<link class=\"jrWebFont\" rel=\"stylesheet\" href=\"" + fontHandler.getResourcePath(htmlFont.getId()) + "\">\n");
			}
		}
		
//		if (!isOutputResourcesToDir)
		{
			writer.write("<![if IE]>\n");
			writer.write("<script>\n");
			writer.write("var links = document.querySelectorAll('link.jrWebFont');\n");
			writer.write("setTimeout(function(){ if (links) { for (var i = 0; i < links.length; i++) { links.item(i).href = links.item(i).href; } } }, 0);\n");
			writer.write("</script>\n");
			writer.write("<![endif]>\n");
		}

		if (htmlFooter == null)
		{
			writer.write("</td><td width=\"50%\">&nbsp;</td></tr>\n");
			writer.write("</table>\n");
			writer.write("</body>\n");
			writer.write("</html>\n");
		}
		else
		{
			writer.write(htmlFooter);
		}

		writer.flush();//FIXMEEXPORT other exporters always perform flush
	}

	/**
	 *
	 */
	protected void exportImage(JRPrintImage image) throws JRException, IOException
	{
		writer.write("<span");

		appendId(image);

		float xAlignFactor = 0f;

		switch (image.getHorizontalImageAlign())
		{
			case RIGHT :
			{
				xAlignFactor = 1f;
				break;
			}
			case CENTER :
			{
				xAlignFactor = 0.5f;
				break;
			}
			case LEFT :
			default :
			{
				xAlignFactor = 0f;
			}
		}

		float yAlignFactor = 0f;

		switch (image.getVerticalImageAlign())
		{
			case BOTTOM :
			{
				yAlignFactor = 1f;
				break;
			}
			case MIDDLE :
			{
				yAlignFactor = 0.5f;
				break;
			}
			case TOP :
			default :
			{
				yAlignFactor = 0f;
			}
		}

		StringBuffer styleBuffer = new StringBuffer();
		appendPositionStyle(image, image, styleBuffer);
		appendSizeStyle(image, image, styleBuffer);
		appendBackcolorStyle(image, styleBuffer);
		
		boolean addedToStyle = appendBorderStyle(image.getLineBox(), styleBuffer);
		if (!addedToStyle)
		{
			appendPen(
				styleBuffer,
				image.getLinePen(),
				null
				);
		}

		if (styleBuffer.length() > 0)
		{
			writer.write(" style=\"");
			writer.write(styleBuffer.toString());
			writer.write("\"");
		}

		writer.write(">");

		if (image.getAnchorName() != null)
		{
			writer.write("<a name=\"");
			writer.write(image.getAnchorName());
			writer.write("\"></a>");
		}
		
		Renderable renderer = image.getRenderable();
		Renderable originalRenderer = renderer;
		boolean imageMapRenderer = renderer != null 
				&& renderer instanceof ImageMapRenderable
				&& ((ImageMapRenderable) renderer).hasImageAreaHyperlinks();

		boolean hasHyperlinks = false;

		if(renderer != null)
		{
			if (imageMapRenderer)
			{
				hasHyperlinks = true;
				hyperlinkStarted = false;
			}
			else
			{
				hasHyperlinks = startHyperlink(image);
			}
			
			writer.write("<img");
			String imagePath = null;
			String imageMapName = null;
			List<JRPrintImageAreaHyperlink> imageMapAreas = null;
	
			ScaleImageEnum scaleImage = image.getScaleImageValue();
			
			if (renderer != null)
			{
				if (renderer.getTypeValue() == RenderableTypeEnum.IMAGE && rendererToImagePathMap.containsKey(renderer.getId()))
				{
					imagePath = rendererToImagePathMap.get(renderer.getId());
				}
				else
				{
					if (image.isLazy())
					{
						imagePath = ((JRImageRenderer)renderer).getImageLocation();
					}
					else
					{
						HtmlResourceHandler imageHandler = 
							getImageHandler() == null 
							? getExporterOutput().getImageHandler() 
							: getImageHandler();
						if (imageHandler != null)
						{
							JRPrintElementIndex imageIndex = getElementIndex();
							String imageName = getImageName(imageIndex);

							if (renderer.getTypeValue() == RenderableTypeEnum.SVG)
							{
								renderer =
									new JRWrappingSvgRenderer(
										renderer,
										new Dimension(image.getWidth(), image.getHeight()),
										ModeEnum.OPAQUE == image.getModeValue() ? image.getBackcolor() : null
										);
							}

							byte[] imageData = renderer.getImageData(jasperReportsContext);

							if (imageHandler != null)
							{
								imageHandler.handleResource(imageName, imageData);

								imagePath = imageHandler.getResourcePath(imageName);
							}
						}
					}
	
					rendererToImagePathMap.put(renderer.getId(), imagePath);
				}
				
				if (imageMapRenderer)
				{
					Rectangle renderingArea = new Rectangle(image.getWidth(), image.getHeight());
					
					if (renderer.getTypeValue() == RenderableTypeEnum.IMAGE)
					{
						imageMapName = imageMaps.get(new Pair<String,Rectangle>(renderer.getId(), renderingArea));
					}
	
					if (imageMapName == null)
					{
						imageMapName = "map_" + getElementIndex().toString();
						imageMapAreas = ((ImageMapRenderable) originalRenderer).getImageAreaHyperlinks(renderingArea);//FIXMECHART
						
						if (renderer.getTypeValue() == RenderableTypeEnum.IMAGE)
						{
							imageMaps.put(new Pair<String,Rectangle>(renderer.getId(), renderingArea), imageMapName);
						}
					}
				}
			}
	
			writer.write(" src=\"");
			if (imagePath != null)
			{
				writer.write(imagePath);
			}
			writer.write("\"");
			//add by liudong
			writer.write(" class=\"screen-only\"");
						
			int availableImageWidth = image.getWidth() - image.getLineBox().getLeftPadding().intValue() - image.getLineBox().getRightPadding().intValue();
			if (availableImageWidth < 0)
			{
				availableImageWidth = 0;
			}
		
			int availableImageHeight = image.getHeight() - image.getLineBox().getTopPadding().intValue() - image.getLineBox().getBottomPadding().intValue();
			if (availableImageHeight < 0)
			{
				availableImageHeight = 0;
			}
		
			switch (scaleImage)
			{
				case FILL_FRAME :
				{
					int leftDiff = 0;
					int topDiff = 0;
					int widthDiff = 0;
					int heightDiff = 0;

					JRLineBox box = image.getLineBox();
					if (box != null)
					{
						leftDiff = box.getLeftPadding().intValue();
						topDiff = box.getTopPadding().intValue();
						widthDiff = 
							getInsideBorderOffset(box.getLeftPen().getLineWidth().floatValue(), false)
							+ getInsideBorderOffset(box.getRightPen().getLineWidth().floatValue(), true);
						heightDiff =
							getInsideBorderOffset(box.getTopPen().getLineWidth().floatValue(), false)
							+ getInsideBorderOffset(box.getBottomPen().getLineWidth().floatValue(), true);
					}
					
					writer.write(" style=\"position:absolute;left:");
					writer.write(toSizeUnit(leftDiff));
					writer.write(";top:");
					writer.write(toSizeUnit(topDiff));
					writer.write(";width:");
					writer.write(toSizeUnit(availableImageWidth - widthDiff));
					writer.write(";height:");
					writer.write(toSizeUnit(availableImageHeight - heightDiff));
					writer.write("\"");
		
					break;
				}
				case CLIP :
				{
					double normalWidth = availableImageWidth;
					double normalHeight = availableImageHeight;
		
					if (!image.isLazy())
					{
						// Image load might fail. 
						Renderable tmpRenderer = 
							RenderableUtil.getInstance(jasperReportsContext).getOnErrorRendererForDimension(renderer, image.getOnErrorTypeValue());
						Dimension2D dimension = tmpRenderer == null ? null : tmpRenderer.getDimension(jasperReportsContext);
						// If renderer was replaced, ignore image dimension.
						if (tmpRenderer == renderer && dimension != null)
						{
							normalWidth = dimension.getWidth();
							normalHeight = dimension.getHeight();
						}
					}

					int leftDiff = 0;
					int topDiff = 0;
					int widthDiff = 0;
					int heightDiff = 0;

					JRLineBox box = image.getLineBox();
					if (box != null)
					{
						leftDiff = box.getLeftPadding().intValue();
						topDiff = box.getTopPadding().intValue();
						widthDiff = 
							getInsideBorderOffset(box.getLeftPen().getLineWidth().floatValue(), false)
							+ getInsideBorderOffset(box.getRightPen().getLineWidth().floatValue(), true);
						heightDiff =
							getInsideBorderOffset(box.getTopPen().getLineWidth().floatValue(), false)
							+ getInsideBorderOffset(box.getBottomPen().getLineWidth().floatValue(), true);
					}
					
					writer.write(" style=\"position:absolute;left:");
					writer.write(toSizeUnit((int)(leftDiff + xAlignFactor * (availableImageWidth - widthDiff - normalWidth))));
					writer.write(";top:");
					writer.write(toSizeUnit((int)(topDiff + yAlignFactor * (availableImageHeight - heightDiff - normalHeight))));
					writer.write(";width:");
					writer.write(toSizeUnit((int)normalWidth));
					writer.write(";height:");
					writer.write(toSizeUnit((int)normalHeight));
					writer.write(";clip:rect(");
					writer.write(toSizeUnit((int)(yAlignFactor * (normalHeight - availableImageHeight + heightDiff))));
					writer.write(",");
					writer.write(toSizeUnit((int)(xAlignFactor * normalWidth + (1 - xAlignFactor) * (availableImageWidth - widthDiff))));
					writer.write(",");
					writer.write(toSizeUnit((int)(yAlignFactor * normalHeight + (1 - yAlignFactor) * (availableImageHeight - heightDiff))));
					writer.write(",");
					writer.write(toSizeUnit((int)(xAlignFactor * (normalWidth - availableImageWidth + widthDiff))));
					writer.write(")\"");

					break;
				}
				case RETAIN_SHAPE :
				default :
				{
					double normalWidth = availableImageWidth;
					double normalHeight = availableImageHeight;
		
					if (!image.isLazy())
					{
						// Image load might fail. 
						Renderable tmpRenderer = 
							RenderableUtil.getInstance(jasperReportsContext).getOnErrorRendererForDimension(renderer, image.getOnErrorTypeValue());
						Dimension2D dimension = tmpRenderer == null ? null : tmpRenderer.getDimension(jasperReportsContext);
						// If renderer was replaced, ignore image dimension.
						if (tmpRenderer == renderer && dimension != null)
						{
							normalWidth = dimension.getWidth();
							normalHeight = dimension.getHeight();
						}
					}
		
					int leftDiff = 0;
					int topDiff = 0;
					int widthDiff = 0;
					int heightDiff = 0;

					JRLineBox box = image.getLineBox();
					if (box != null)
					{
						leftDiff = box.getLeftPadding().intValue();
						topDiff = box.getTopPadding().intValue();
						widthDiff = 
							getInsideBorderOffset(box.getLeftPen().getLineWidth().floatValue(), false)
							+ getInsideBorderOffset(box.getRightPen().getLineWidth().floatValue(), true);
						heightDiff =
							getInsideBorderOffset(box.getTopPen().getLineWidth().floatValue(), false)
							+ getInsideBorderOffset(box.getBottomPen().getLineWidth().floatValue(), true);
					}
					
					if (availableImageHeight > 0)
					{
						double ratio = normalWidth / normalHeight;
		
						if( ratio > (double)availableImageWidth / (double)availableImageHeight )
						{
							writer.write(" style=\"position:absolute;left:");
							writer.write(toSizeUnit(leftDiff));
							writer.write(";top:");
							writer.write(toSizeUnit((int)(topDiff + yAlignFactor * (availableImageHeight - heightDiff - (availableImageWidth - widthDiff) / ratio))));
							writer.write(";width:");
							writer.write(toSizeUnit(availableImageWidth - widthDiff));
							writer.write("\"");
						}
						else
						{
							writer.write(" style=\"position:absolute;left:");
							//writer.write(String.valueOf(leftDiff));
							writer.write(toSizeUnit((int)(leftDiff + xAlignFactor * (availableImageWidth - widthDiff - ratio * (availableImageHeight - heightDiff)))));
							writer.write(";top:");
							writer.write(toSizeUnit(topDiff));
							writer.write(";height:");
							writer.write(toSizeUnit(availableImageHeight - heightDiff));
							writer.write("\"");
						}
					}
				}
			}
			
			if (imageMapName != null)
			{
				writer.write(" usemap=\"#" + imageMapName + "\"");
			}
			
			writer.write(" alt=\"\"");
			
			if (hasHyperlinks)
			{
				writer.write(" border=\"0\"");
			}
			
			if (image.getHyperlinkTooltip() != null)
			{
				writer.write(" title=\"");
				writer.write(JRStringUtil.xmlEncode(image.getHyperlinkTooltip()));
				writer.write("\"");
			}
			
			writer.write("/>");

			endHyperlink();
			
			if (imageMapAreas != null)
			{
				writer.write("\n");
				writeImageMap(imageMapName, image, imageMapAreas);
			}
		}
		writer.write("</span>\n");
	}




	private boolean appendPen(StringBuffer sb, JRPen pen, String side)
	{
		boolean addedToStyle = false;
		
		float borderWidth = pen.getLineWidth().floatValue();
		if (0f < borderWidth && borderWidth < 1f)
		{
			borderWidth = 1f;
		}

		String borderStyle = null;
		switch (pen.getLineStyleValue())
		{
			case DOUBLE :
			{
				borderStyle = "double";
				break;
			}
			case DOTTED :
			{
				borderStyle = "dotted";
				break;
			}
			case DASHED :
			{
				borderStyle = "dashed";
				break;
			}
			case SOLID :
			default :
			{
				borderStyle = "solid";
				break;
			}
		}

		if (borderWidth > 0f)
		{
			sb.append("border");
			if (side != null)
			{
				sb.append("-");
				sb.append(side);
			}
			
			sb.append(": ");
			sb.append(toSizeUnit((int)borderWidth));
			
			sb.append(" ");
			sb.append(borderStyle);

			sb.append(" ");
			sb.append(JRColorUtil.getCssColor(pen.getLineColor()));
			sb.append("; ");

			addedToStyle = true;
		}

		return addedToStyle;
	}

	
	

	/**
	 *
	 */
	private void appendId(JRPrintElement element) throws IOException
	{
		String dataAttr = getDataAttributes(element);
		if (dataAttr != null)
		{
			writer.write(dataAttr);
		}
	}
	
	

	




	
}


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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.engine.ImageMapRenderable;
import net.sf.jasperreports.engine.JRAnchor;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRImageRenderer;
import net.sf.jasperreports.engine.JRPrintElementIndex;
import net.sf.jasperreports.engine.JRPrintImage;
import net.sf.jasperreports.engine.JRPrintImageAreaHyperlink;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JRWrappingSvgRenderer;
import net.sf.jasperreports.engine.Renderable;
import net.sf.jasperreports.engine.ReportContext;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.engine.export.HtmlFont;
import net.sf.jasperreports.engine.export.HtmlResourceHandler;
import net.sf.jasperreports.engine.export.tabulator.TableCell;
import net.sf.jasperreports.engine.type.HorizontalImageAlignEnum;
import net.sf.jasperreports.engine.type.ModeEnum;
import net.sf.jasperreports.engine.type.RenderableTypeEnum;
import net.sf.jasperreports.engine.type.ScaleImageEnum;
import net.sf.jasperreports.engine.type.VerticalImageAlignEnum;
import net.sf.jasperreports.engine.util.HyperlinkData;
import net.sf.jasperreports.engine.util.JRStringUtil;
import net.sf.jasperreports.engine.util.Pair;
import net.sf.jasperreports.export.ExportInterruptedException;
import net.sf.jasperreports.export.ExporterInputItem;
import net.sf.jasperreports.export.HtmlExporterConfiguration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * Exports a JasperReports document to HTML format. It has character output type
 * and exports the document to a grid-based layout.
 * 
 * @deprecated Replaced by {@link HtmlExporter}.
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 */
public class HtmlExporterExt extends HtmlExporter {

	private List<HyperlinkData> hyperlinksData = new ArrayList<HyperlinkData>();

	/**
	 *
	 */
	protected void exportReportToWriter() throws JRException, IOException {
		HtmlExporterConfiguration configuration = getCurrentConfiguration();
		String htmlHeader = configuration.getHtmlHeader();
		String betweenPagesHtml = configuration.getBetweenPagesHtml();
		String htmlFooter = configuration.getHtmlFooter();
		boolean flushOutput = configuration.isFlushOutput();// FIXMEEXPORT maybe
															// move flush flag
															// to output

		if (htmlHeader == null) {
			String encoding = getExporterOutput().getEncoding();

			writer
					.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
			writer.write("<html>\n");
			writer.write("<head>\n");
			writer.write("  <title></title>\n");
			writer
					.write("  <meta http-equiv=\"Content-Type\" content=\"text/html; charset="
							+ encoding + "\"/>\n");
			writer.write("  <style type=\"text/css\">\n");
			writer.write("    a {text-decoration: none}\n");
			writer.write("  </style>\n");
			writer.write("</head>\n");
			writer
					.write("<body  text=\"#000000\" link=\"#000000\" alink=\"#000000\" vlink=\"#000000\">\n");
			writer
					.write("<table  width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n");
			writer
					.write("<tr><td width=\"50%\">&nbsp;</td><td align=\"center\">\n");
			writer.write("\n");
		} else {
			writer.write(htmlHeader);
		}

		List<ExporterInputItem> items = exporterInput.getItems();

		for (reportIndex = 0; reportIndex < items.size(); reportIndex++) {
			ExporterInputItem item = items.get(reportIndex);

			setCurrentExporterInputItem(item);

			List<JRPrintPage> pages = jasperPrint.getPages();
			if (pages != null && pages.size() > 0) {
				PageRange pageRange = getPageRange();
				int startPageIndex = (pageRange == null || pageRange
						.getStartPageIndex() == null) ? 0 : pageRange
						.getStartPageIndex();
				int endPageIndex = (pageRange == null || pageRange
						.getEndPageIndex() == null) ? (pages.size() - 1)
						: pageRange.getEndPageIndex();

				JRPrintPage page = null;
				for (pageIndex = startPageIndex; pageIndex <= endPageIndex; pageIndex++) {
					if (Thread.interrupted()) {
						throw new ExportInterruptedException();
					}

					page = pages.get(pageIndex);

					writer
							.write("<a name=\"" + JR_PAGE_ANCHOR_PREFIX
									+ reportIndex + "_" + (pageIndex + 1)
									+ "\"></a>\n");
					writer.write("<div id='page" + (pageIndex + 1) + "'>\n");

					/*   */
					exportPage(page);
					writer.write("</div>\n");

					if (reportIndex < items.size() - 1
							|| pageIndex < endPageIndex) {
						if (betweenPagesHtml == null) {
							writer.write("<br/>\n<br/>\n");
						} else {
							writer.write(betweenPagesHtml);
						}
					}

					writer.write("\n");
				}
			}
		}

		ReportContext reportContext = getReportContext();
		if (fontsToProcess != null && fontsToProcess.size() > 0)// when no
																// fontHandler
																// and/or
																// resourceHandler,
																// fonts are not
																// processed
		{
			@SuppressWarnings("deprecation")
			HtmlResourceHandler fontHandler = getExporterOutput()
					.getFontHandler() == null ? getFontHandler()
					: getExporterOutput().getFontHandler();
			ObjectMapper mapper = null;
			ArrayNode webFonts = null;

			if (reportContext != null) {
				mapper = new ObjectMapper();
				webFonts = mapper.createArrayNode();
				reportContext.setParameterValue(
						"net.sf.jasperreports.html.webfonts", webFonts); // FIXME:
																			// use
																			// constant
			}

			for (HtmlFont htmlFont : fontsToProcess.values()) {
				if (reportContext != null) {
					ObjectNode objNode = mapper.createObjectNode();
					objNode.put("id", htmlFont.getId());
					objNode.put("path", fontHandler.getResourcePath(htmlFont
							.getId()));
					webFonts.add(objNode);
				} else {
					writer
							.write("<link class=\"jrWebFont\" rel=\"stylesheet\" href=\""
									+ fontHandler.getResourcePath(htmlFont
											.getId()) + "\">\n");
				}
			}
		}

		// place hyperlinksData on reportContext
		if (hyperlinksData.size() > 0) {
			reportContext.setParameterValue(
					"net.sf.jasperreports.html.hyperlinks", hyperlinksData);
		}

		// if (!isOutputResourcesToDir)
		if (reportContext == null) // generate script tag on static export only
		{
			writer.write("<![if IE]>\n");
			writer.write("<script>\n");
			writer
					.write("var links = document.querySelectorAll('link.jrWebFont');\n");
			writer
					.write("setTimeout(function(){ if (links) { for (var i = 0; i < links.length; i++) { links.item(i).href = links.item(i).href; } } }, 0);\n");
			writer.write("</script>\n");
			writer.write("<![endif]>\n");
		}

		if (htmlFooter == null) {
			writer.write("</td><td width=\"50%\">&nbsp;</td></tr>\n");
			writer.write("</table>\n");
//			writer.write("</body>\n");
//			writer.write("</html>\n");
		} else {
			writer.write(htmlFooter);
		}

		if (flushOutput) {
			writer.flush();
		}
	}

	protected void writeImage(JRPrintImage image, TableCell cell)
			throws IOException, JRException {
		startCell(image, cell);

		int imageWidth = image.getWidth() - image.getLineBox().getLeftPadding()
				- image.getLineBox().getRightPadding();
		if (imageWidth < 0) {
			imageWidth = 0;
		}

		int imageHeight = image.getHeight()
				- image.getLineBox().getTopPadding()
				- image.getLineBox().getBottomPadding();
		if (imageHeight < 0) {
			imageHeight = 0;
		}

		StringBuilder styleBuffer = new StringBuilder();
		ScaleImageEnum scaleImage = image.getScaleImageValue();
		if (scaleImage != ScaleImageEnum.CLIP) {
			// clipped images are absolutely positioned within a div
			setImageHorizontalAlignmentStyle(image, styleBuffer);
			setImageVerticalAlignmentStyle(image, styleBuffer);
		} else if (imageHeight > 0) {
			// some browsers need td height so that height: 100% works on the
			// div used for clipped images.
			// we're using the height without paddings because that's closest to
			// the HTML size model.
			styleBuffer.append("height: ");
			styleBuffer.append(toSizeUnit(imageHeight));
			styleBuffer.append("; ");
		}

		appendElementCellGenericStyle(cell, styleBuffer);
		appendBackcolorStyle(cell, styleBuffer);

		boolean addedToStyle = appendBorderStyle(cell.getBox(), styleBuffer);
		if (!addedToStyle) {
			appendPen(styleBuffer, image.getLinePen(), null);
		}

		appendPaddingStyle(image.getLineBox(), styleBuffer);

		writeStyle(styleBuffer);

		finishStartCell();

		if (image.getAnchorName() != null) {
			writer.write("<a name=\"");
			writer.write(image.getAnchorName());
			writer.write("\"/>");
		}

		if (image.getBookmarkLevel() != JRAnchor.NO_BOOKMARK) {
			writer.write("<a name=\"");
			writer.write(JR_BOOKMARK_ANCHOR_PREFIX + reportIndex + "_"
					+ pageIndex + "_" + cell.getElementAddress());
			writer.write("\"/>");
		}

		Renderable renderer = image.getRenderable();
		Renderable originalRenderer = renderer;
		boolean imageMapRenderer = renderer != null
				&& renderer instanceof ImageMapRenderable
				&& ((ImageMapRenderable) renderer).hasImageAreaHyperlinks();

		boolean hasHyperlinks = false;

		if (renderer != null) {
			boolean startedDiv = false;
			if (scaleImage == ScaleImageEnum.CLIP) {
				writer
						.write("<div style=\"width: 100%; height: 100%; position: relative; overflow: hidden;\">\n");
				startedDiv = true;
			}

			boolean hyperlinkStarted;
			if (imageMapRenderer) {
				hyperlinkStarted = false;
				hasHyperlinks = true;
			} else {
				hyperlinkStarted = startHyperlink(image);
				hasHyperlinks = hyperlinkStarted;
			}

			writer.write("<img");
			String imagePath = null;
			String imageMapName = null;
			List<JRPrintImageAreaHyperlink> imageMapAreas = null;

			if (renderer.getTypeValue() == RenderableTypeEnum.IMAGE
					&& rendererToImagePathMap.containsKey(renderer.getId())) {
				imagePath = rendererToImagePathMap.get(renderer.getId());
			} else {
				if (image.isLazy()) {
					imagePath = ((JRImageRenderer) renderer).getImageLocation();
				} else {
					@SuppressWarnings("deprecation")
					HtmlResourceHandler imageHandler = getImageHandler() == null ? getExporterOutput()
							.getImageHandler()
							: getImageHandler();
					if (imageHandler != null) {
						JRPrintElementIndex imageIndex = getElementIndex(cell);
						String imageName = getImageName(imageIndex);

						if (renderer.getTypeValue() == RenderableTypeEnum.SVG) {
							renderer = new JRWrappingSvgRenderer(
									renderer,
									new Dimension(image.getWidth(), image
											.getHeight()),
									ModeEnum.OPAQUE == image.getModeValue() ? image
											.getBackcolor()
											: null);
						}

						byte[] imageData = renderer
								.getImageData(jasperReportsContext);

						if (imageHandler != null) {
							imageHandler.handleResource(imageName, imageData);

							imagePath = imageHandler.getResourcePath(imageName);
						}
					}
				}

				rendererToImagePathMap.put(renderer.getId(), imagePath);
			}

			if (imageMapRenderer) {
				Rectangle renderingArea = new Rectangle(image.getWidth(), image
						.getHeight());

				if (renderer.getTypeValue() == RenderableTypeEnum.IMAGE) {
					imageMapName = imageMaps.get(new Pair<String, Rectangle>(
							renderer.getId(), renderingArea));
				}

				if (imageMapName == null) {
					imageMapName = "map_" + getElementIndex(cell).toString()
							+ "-" + originalRenderer.getId();// use
																// renderer.getId()?
					imageMapAreas = ((ImageMapRenderable) originalRenderer)
							.getImageAreaHyperlinks(renderingArea);// FIXMECHART

					if (renderer.getTypeValue() == RenderableTypeEnum.IMAGE) {
						imageMaps.put(new Pair<String, Rectangle>(renderer
								.getId(), renderingArea), imageMapName);
					}
				}
			}

			writer.write(" src=\"");
			if (imagePath != null) {
				writer.write(imagePath);
			}
			writer.write("\"");
			// add by liudong
			writer.write(" class=\"screen-only\"");

			switch (scaleImage) {
			case FILL_FRAME: {
				writer.write(" style=\"width: ");
				writer.write(toSizeUnit(imageWidth));
				writer.write("; height: ");
				writer.write(toSizeUnit(imageHeight));
				writer.write("\"");

				break;
			}
			case CLIP: {
				int positionLeft;
				int positionTop;

				HorizontalImageAlignEnum horizontalAlign = image
						.getHorizontalImageAlign();
				VerticalImageAlignEnum verticalAlign = image
						.getVerticalImageAlign();
				if (horizontalAlign == HorizontalImageAlignEnum.LEFT
						&& verticalAlign == VerticalImageAlignEnum.TOP) {
					// no need to compute anything
					positionLeft = 0;
					positionTop = 0;
				} else {
					double[] normalSize = getImageNormalSize(image,
							originalRenderer, imageWidth, imageHeight);
					// these calculations assume that the image td does not
					// stretch due to other cells.
					// when that happens, the image will not be properly
					// aligned.
					float xAlignFactor = horizontalAlign == HorizontalImageAlignEnum.RIGHT ? 1f
							: (horizontalAlign == HorizontalImageAlignEnum.CENTER ? 0.5f
									: 0f);
					float yAlignFactor = verticalAlign == VerticalImageAlignEnum.BOTTOM ? 1f
							: (verticalAlign == VerticalImageAlignEnum.MIDDLE ? 0.5f
									: 0f);
					positionLeft = (int) (xAlignFactor * (imageWidth - normalSize[0]));
					positionTop = (int) (yAlignFactor * (imageHeight - normalSize[1]));
				}

				writer.write(" style=\"position: absolute; left:");
				writer.write(toSizeUnit(positionLeft));
				writer.write("; top: ");
				writer.write(toSizeUnit(positionTop));
				// not setting width, height and clip as it doesn't seem needed
				// plus it fixes clip for lazy images
				writer.write(";\"");

				break;
			}
			case RETAIN_SHAPE:
			default: {

				if (imageHeight > 0) {
					double[] normalSize = getImageNormalSize(image,
							originalRenderer, imageWidth, imageHeight);
					double ratio = normalSize[0] / normalSize[1];

					if (ratio > (double) imageWidth / (double) imageHeight) {
						writer.write(" style=\"width: ");
						writer.write(toSizeUnit(imageWidth));
						writer.write("\"");
					} else {
						writer.write(" style=\"height: ");
						writer.write(toSizeUnit(imageHeight));
						writer.write("\"");
					}
				}
			}
			}

			if (imageMapName != null) {
				writer.write(" usemap=\"#" + imageMapName + "\"");
			}

			writer.write(" alt=\"\"");

			if (hasHyperlinks) {
				writer.write(" border=\"0\"");
			}

			if (image.getHyperlinkTooltip() != null) {
				writer.write(" title=\"");
				writer.write(JRStringUtil
						.xmlEncode(image.getHyperlinkTooltip()));
				writer.write("\"");
			}

			writer.write("/>");

			if (hyperlinkStarted) {
				endHyperlink();
			}

			if (startedDiv) {
				writer.write("</div>");
			}

			if (imageMapAreas != null) {
				writer.write("\n");
				writeImageMap(imageMapName, image, imageMapAreas);
			}
		}

		endCell();
	}

}

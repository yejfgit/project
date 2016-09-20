
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
	
    <title>影像下载</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
     <LINK href="style/ul.css" type="text/css" rel=stylesheet>
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>

  <body>
   
	<table cellpadding="0" width="760" cellspacing="0" border="0" align="center" >
		<tr>
			<td>
				<table width=100% cellPadding=0 
                  cellSpacing=0 bgcolor="#FFFFFF"   >
						<!--DWLayoutTable tile-->
						<tr> 
						  <td width="4" height="4"></td>
						  <td width="106"></td>
						  <td width="1"></td>
						  <td width="637"></td>
						</tr>
						<tr> 
						  <td height="60" colspan="3" valign="top"><img src="images/index/logo.gif" width="117" height="60"></td>
						  <td rowspan="4" valign="top" width="639" background="images/index/shuye.jpg" style="background-repeat:no-repeat;"></td>
						</tr>
						<tr> 
						  <td height="1"></td>
						  <td></td>
						  <td></td>
						</tr>
						<tr> 
						  <td height="9"></td>
						  <td rowspan="2" valign="top" align="center">和 你 在 一 起</td>
						  <td></td>
						</tr>
						<tr> 
						  <td height="30"></td>
						  <td></td>
						  <td></td>
						</tr>
						<tr> 
						  <td height="2"></td>
						  <td></td>
						  <td></td>
						  <td></td>
						</tr>
					  </table>
			</td>
		</tr>
		<tr><!--   title    -->
			<td><iframe src="frame/indextitle.jsp" width="760" height="40" frameborder="0" scrolling="no" ></iframe>
			</td>
		</tr>
		<tr><!-- 		titlepic		-->
			<td align="center"></td>
		</tr>
		<tr>
			<!--			content			-->
			<td >
					<table width="100%" style="border-left: gray 1px solid;border-right: gray 1px solid;">
						<tr>
							<td></td>
							<td width="20%"></td>
							<td width="68%"></td>
						</tr>
						<tr>
							
							  <td colspan="3" valign="top">
							  		<table border="0" width="100%" >
										<tr>
											<td colspan="5" align="center" style="font-weight:bold;color:#ff3333;font-size:20px;">
											直击两会
											</td>				
										</tr>
										<tr><td height="20"></td></tr>


										<tr>
												<td style="border:gray 1px solid;">
													<table cellpadding="0" cellspacing="0" border="0" width="100%" >
														<tr><td height="5"></td><td></td></tr>
														<tr>
															<td style="color:#FF6699;font-size:14px;" rowspan="3" width="120" align="center">金融界-中国网两会特别策划<br><br>
																<img src="/newapp/video/tebiecehua.jpg" width="200" height="120" border="0" />
															</td>
															<td> 
															</td>
														</tr>
														<tr><td> 
															&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
														</td></tr>
														<tr><td align="right">
																<a href="video/tebiecehua.wmv" style="color:#0000FF" >请右键使用目标另存为下载</a>&nbsp;&nbsp;
														</td></tr>
													</table>														
												</td>
											</tr>	
											
											
											<tr><td>&nbsp;</td></tr>
											

										
										
										
										<tr>
												<td style="border:gray 1px solid;">
													<table cellpadding="0" cellspacing="0" border="0" width="100%" >
														<tr><td height="5"></td><td></td></tr>
														<tr>
															<td style="color:#FF6699;font-size:14px;" rowspan="3" width="120" align="center">对话企业家——网易采访董事长<br><br>
																<img src="/newapp/video/duihuaqiyejia.jpg" width="200" height="120" border="0" />
															</td>
															<td> 
															</td>
														</tr>
														<tr><td> 
															&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
														</td></tr>
														<tr><td align="right">
																<a href="video/duihuaqiyejia.wmv" style="color:#0000FF" >请右键使用目标另存为下载</a>&nbsp;&nbsp;
														</td></tr>
													</table>														
												</td>
											</tr>	
											
											
											<tr><td>&nbsp;</td></tr>
											
											
										
										
										
										
											<tr>
												<td style="border:gray 1px solid;">
													<table cellpadding="0" cellspacing="0" border="0" width="100%" >
														<tr><td height="5"></td><td></td></tr>
														<tr>
															<td style="color:#FF6699;font-size:14px;" rowspan="3" width="120" align="center">第一财经专访<br><br>
																<img src="/newapp/video/diyicaijing.jpg" width="200" height="120" border="0" />
															</td>
															<td> 
															</td>
														</tr>
														<tr><td> 
															&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
														</td></tr>
														<tr><td align="right">
																<a href="video/diyicaijing.wmv" style="color:#0000FF" >请右键使用目标另存为下载</a>&nbsp;&nbsp;
														</td></tr>
													</table>														
												</td>
											</tr>	
											
											
											<tr><td>&nbsp;</td></tr>
											
											
												
											
											
											
											
											
												
											
											
											
											
											<tr><td height="330"></td></tr>								
									</table>
							  
							  
							  
							   </td>
						</tr>
						
					</table>
			</td>
		</tr>
		<tr>
			<td>
				<jsp:include page="../frame/indexbottom.jsp" />
			</td>
		</tr>
		<tr><td height="30"></td></tr>
	</table>
   
   
  </body>
</html>

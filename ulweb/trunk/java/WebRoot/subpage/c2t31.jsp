
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.ulweb.entity.UlColumn" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <%
		UlColumn c = (UlColumn)request.getAttribute("c");
		String ptype = (String)(request.getAttribute("ptype") == null ? "" : request.getAttribute("ptype"));		
		int scid = (request.getAttribute("scid") == null ? 0 : ((Integer)(request.getAttribute("scid"))).intValue());		
		
		UlColumn cp = null;
		List<UlColumn> cl = null;
		List<UlContent> list = (List<UlContent>)request.getAttribute("list");
		if(c != null ){
			
				cp = (UlColumn)request.getAttribute("cp");
				cl = (List<UlColumn>)request.getAttribute("cl");
			
		}else{
			request.setAttribute("errorMessage","请不要从地址栏直接输入jsp地址进行链接");
			response.sendRedirect(basePath + "error/errorpage.jsp");
		}
	
	
	%>
    <title><%=(c == null ? "" : c.getColumnName())%></title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
     <LINK href="style/ul.css" type="text/css" rel=stylesheet>
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  </head>
  <script language="JavaScript" src="script/list.js"></script>
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
						  <td rowspan="4" valign="top" width="639" background="images/index/lipei.jpg" style="background-repeat:no-repeat;"></td>
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
					<table width="100%" style="border-right: gray 1px solid;">
						<tr>
							<td></td>
							<td width="2%"></td>
							<td width="68%"></td>
						</tr>
						<tr>
							<td width="30%" valign="top">
								<table width="100%" style="border: gray 1px solid;">
									<tr><td height="10"></td></tr>
									<tr><td align="center">
										<table cellpadding="0" cellspacing="0" border="0" width="200" align="center">		
											<tr>												
              							        <td>
													<table border="0" width="100%" cellspacing="0">														
														<tr>
															<td align="center" style="color:#ff6600;font-size:14px;border-bottom: 1px gray solid; text-align:center;"  >
																<strong>真情服务  历久弥新<br>
																2008年客服系列活动<br>
															专栏二</strong> </td>
														</tr>
														<tr>
														  <td align="center">&nbsp;</td>
													  </tr>
														<tr><td align="center">
			<a href="list.do?method=zongbu&scid=908&ptype=31&columnId=907" style="font-size:14px;"><font color='#3399ff'>客服活动概述</font></a>
														</td></tr>
														<%
															for(int i = 0; i < (cl == null ? 0 : cl.size()); i++){
															if (!cl.get(i).getColumnName().equals("客服活动概述")) {
														%>
														<tr>
															<td align="center">
																<a style="font-size:14px;" href="list.do?method=zongbu&scid=<%=cl.get(i).getColumnId()%>&ptype=30&columnId=<%=cp.getColumnId()%>" >
																<%
							if(cl.get(i).getColumnId() == c.getColumnId()){
								out.print("<font color='#3399ff'>");
								out.println(cl.get(i).getColumnName());
								out.print("</font>");
							}else{
								out.print(cl.get(i).getColumnName());
							}
																	%>		
																</a>															</td>
														</tr>
														
														<%
														}
															}
														%>
														<tr><td align="center">
			<a href="list.do?method=zongbu&scid=224&ptype=13&columnId=221" style="font-size:14px;">2007活动回顾</a>
														</td></tr>
													</table>
												
												</td>
											</tr>
											
										</table>								
									</td></tr>
									<tr><td height="15"></td></tr>
									
									<tr><td></td></tr>
									<tr valign="bottom"><td align="center">
										<img src="images/index/yilabao.jpg" border="0" width="220" /></td></tr>

								</table>
							</td>
							<td></td>
						  <td valign="top"><img src="images/index/kefu08intro1.jpg"></td>
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

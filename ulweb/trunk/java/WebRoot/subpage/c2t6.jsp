
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
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>
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
															<td align="center" style="color:#ff6600;font-size:14px;border-bottom: 1px gray solid;"  >
																<%=(cp == null ? "" : cp.getColumnName())%>
															</td>
														</tr>
														<%
															String cName = null;	
															int indexStr = 0;														
															for(int i = 0; i < (cl == null ? 0 : cl.size()); i++){
														%>
														<tr>
															<td  align="center">
																<a href="list.do?method=zongbu&scid=<%=cl.get(i).getColumnId()%>&ptype=<%=ptype%>&columnId=<%=cp.getColumnId() + (request.getParameter("pageSize") == null ? "" : ("&pageSize=" + request.getParameter("pageSize")))%>" >
																<%
																indexStr = cl.get(i).getColumnName().indexOf("——");																
																if(indexStr == -1){
																	cName = cl.get(i).getColumnName();
																}else{
																	cName = cl.get(i).getColumnName().substring(0,indexStr);
																}
																if(cl.get(i).getColumnId() == c.getColumnId()){
																	out.print("<font color='#3399ff'>");
																	out.println(cName);
																	out.print("</font>");
																}else{
																	out.println(cName);
																}
																	%>		
																</a>
															</td>															
														</tr>
														
														<%
															}
														%>
														<tr><td align="center">
																<a href="list.do?method=zongbu&ptype=19&columnId=527&scid=549">2008年合众助学行</a>
														</td></tr>
													</table>
												
												</td>
											</tr>
											
										</table>								
									</td></tr>
									
									
									<tr><td></td></tr>
									<tr valign="bottom"><td align="center">										
										<img src="images/index/zhuxue.jpg" border="0" width="220" /></td></tr>
								
								</table>
							</td>
							<td></td>
							  <td valign="top">
							  		<%
										String titlet = null;
										String titles = null;
										if(c != null){
											int indextStr = c.getColumnName().indexOf("——");
											if(indextStr != -1){
												titlet = c.getColumnName().substring(0,indextStr);
												titles = c.getColumnName().substring(indextStr , c.getColumnName().length()); 
											}else{
												titlet = c.getColumnName();
												titles = "";
											}
										}else{
											titlet = "";
											titles = "";
										}
									%>
							  		<table border="0" width="100%" >
										<tr>
											<td colspan="5" align="center" style="color:#ff3333;font-size:20px;font-weight:bold;">
												<%=titlet%>
											</td>
										</tr>
										<tr>
											<td align="right" style="color:#ff3333;font-size:20px;font-weight:bold;" colspan="5">
												<%=titles%>
												
											</td>
										</tr>
										 <%
											
												if(list != null){
													for(int i = 0; i < list.size(); i++){					
														out.println("<tr><td height='20'  ></td>");
														out.println("<td colspan='3' valign='middle'  ><img src='images/index/a6.gif' width='8' height='8'> ");
														if(list.get(i).getHaveContent() == 0 && list.get(i).getAttachmentSum() != 0){
															out.print("<a target='_blank' href='show.do?c=" + list.get(i).getContentId() + "&a=1'>");
															out.println(list.get(i).getContentName() + "&nbsp;/" + list.get(i).getUploadTime().toString().substring(0,list.get(i).getUploadTime().toString().indexOf(" ")) + "</a>");					
															out.println("</td><td></td></tr>");			
															if(list.get(i).getAttachmentSum() > 1){
																out.print("<tr><td></td><td>");
																for(int j = 2; j <= list.get(i).getAttachmentSum() ; j++){
																	out.print("<a target='_blank' href='show.do?c=" + list.get(i).getContentId() + "&a=" + j + "'>");
																	out.print("附件" + (j - 1) + "</a> &nbsp;&nbsp;");
																}
																out.print("</td><td></td></tr>");
															}
														}else{
															out.print("<a target='_blank' href='show.do?c=" + list.get(i).getContentId() + "'>");
															out.println(list.get(i).getContentName() + "&nbsp;/" + list.get(i).getUploadTime().toString().substring(0,list.get(i).getUploadTime().toString().indexOf(" ")) + "</a>");					
															out.println("</td><td></td></tr>");			
															if(list.get(i).getAttachmentSum() > 0){
																out.print("<tr><td></td><td>");
																for(int j = 1; j <= list.get(i).getAttachmentSum() ; j++){
																	out.print("<a target='_blank' href='show.do?c=" + list.get(i).getContentId() + "&a=" + j + "'>");
																	out.print("附件" + j + "</a> &nbsp;&nbsp;");
																}
																out.print("</td><td></td></tr>");
															}
														}
																
													}
												}
												
											%>
											<tr><td height="20" colspan="5"></td></tr>
											<tr>
											<form action="list.do?method=zongbu" method="post" name="forms" id="idforms">
											<input type="hidden" name="columnId" id="idccolumnId" value="<%=(cp == null ? "" : cp.getColumnId())%>" />
											<input type="hidden" name="ptype" id="idptype" value="<%=ptype%>" />
											<input type="hidden" name="scid" id="idscid" value="<%=scid%>" />
											<input type="hidden" name="pageSize" id="idpageSize" value="<%=(request.getParameter("pageSize") == null ? "" : request.getParameter("pageSize"))%>" />
												<td colspan="5" align="center">
													<%
														int pageSum = 1;
														int pageNow = 1;					
														if(request.getAttribute("pageSum") != null){
									
															pageSum = (Integer)request.getAttribute("pageSum");
														}
														if(request.getAttribute("page") != null){
															pageNow = (Integer)request.getAttribute("page");
														}
														if(pageSum > 1){
															out.print("现在是第" + pageNow + "页&nbsp;&nbsp;&nbsp;");
															out.print("共" + pageSum + "页 &nbsp;&nbsp;");
															if(pageNow != 1){
																out.print("<a href='javascript:gotoP(" + (pageNow - 1) + ");'>上一页</a>&nbsp;&nbsp;");
															}						
															out.print("<a href='javascript:gotoPage();' >转到</a>&nbsp;第");
															out.print("<input id='idpage' name='page' size='3' maxlength='3' type='text'></input>页");
															if(pageNow != pageSum){
																out.print("<a href='javascript:gotoP(" + (pageNow + 1) + ");'>下一页</a>&nbsp;&nbsp;");
															}
														}
													%>
												</td>
												</form>
											</tr>									
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

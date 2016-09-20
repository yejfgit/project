
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.ulweb.entity.UlColumn,com.ulic.ulweb.ulweb.util.DisplayOnPage" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<%
		DisplayOnPage d = new DisplayOnPage();
		d.setRequest(request);
		UlColumn c = (UlColumn)request.getAttribute("c");		
		List<UlContent> list = (List<UlContent>)request.getAttribute("list");
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
	
    <title>IT资源共享</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
     <LINK href="style/ul.css" type="text/css" rel=stylesheet>
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">

    -->
  <script  language="JavaScript" src="script/list.js"></script>
<style>
.9b2 {
	color:#FF3333;
}
.9b2 a:hover {
	color:#FF3333;
}
p { margin: 8px;}
</style>

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
						  <td rowspan="4" valign="top" width="639" background="images/index/itcomputer.jpg" style="background-repeat:no-repeat;"></td>
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
												
                      <td align="center" style="color:#6633FF;">
					  <br>
					  技术无限
					  <br>
					  <br>
					  开创未来
					  <br>					   </td>
											</tr>
										</table>								
									</td></tr>
									<tr><td height="15"></td></tr>
									
									<tr><td></td></tr>
									<tr valign="bottom"><td align="center">
										<img src="images/index/itleftcomputer1.jpg" border="0" width="220" />
										<br>
										<img src="images/index/itleftcomputer2.jpg" border="0" width="220" />
										
										</td></tr>
									<tr><td height="10"></td></tr>
									<tr valign="bottom">
								<td align="center" >&nbsp; </td>
							  </tr>
								</table>							</td>
							<td></td>
						  <td colspan="2" valign="top"><table border="0" width="100%" >
                            <tr>
                              <td colspan="5" align="center"><font color="#FF3333" style="font-size:20px"><strong><%=(c == null ? "" : c.getColumnName())%></strong> </font> </td>
                            </tr>
<tr><td>
<%=d.divContentNotime("list", 0)%>
</td></tr>
                            <tr>
                              <form action="list.do?method=zongbu" method="post" name="forms" id="idforms">
                                <input type="hidden" name="columnId" id="idccolumnId" value="<%=(c == null ? "" : c.getColumnId())%>" />
                                <input type="hidden" name="ptype" id="idptype" value="<%=request.getAttribute("ptype")%>" />
                                <td colspan="5"><br /><br /><%
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
                          </table></TD>
                      </TR>
                                  <TR align="left" valign="middle"> 
                                    <td 
                                height=26></TD>
                                    <td>&nbsp;</TD>
                                    <td>&nbsp;</TD>
                                    <td width="204"></TD>
                                    <td></TD>
                                    <td></TD>
                                    <td></TD>
                                  </TR>			
									</table>
							  
							  
							  
	      </td>
						</tr>
						<tr><td><jsp:include page="../frame/indexbottom.jsp" /></td></tr>
					</table>
		
   
  </body>
</html>

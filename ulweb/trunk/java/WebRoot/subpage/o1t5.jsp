
<%@ page language="java" import="java.util.*,com.ulic.ulweb.frame.constant.Constant,com.ulic.ulweb.ulweb.entity.Files" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
	<%
		int newColumnId = 0;		
	
	%>
    <title>合众人寿</title>
    
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
  <script  language="JavaScript" src="script/oldFile.js"></script>
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
												
                      <td>&nbsp; </td>
											</tr>
											
										</table>								
									</td></tr>
									<tr><td height="15"></td></tr>
									
									<tr><td></td></tr>
									<tr valign="bottom"><td align="center">
										<img src="images/index/qianbi.jpg" border="0" width="220" /></td></tr>
									<tr><td height="10"></td></tr>
									<tr valign="bottom">
								<td align="center" >&nbsp; </td>
							  </tr>
								</table>
							</td>
							<td></td>
							  <td valign="top">
							  		<table border="0" width="100%" >
										<tr>
											<td colspan="5" align="center">
												<table width="100%" cellpadding="0" cellspacing="0" border="0">
													<tr>
														<td width="70%" align="center">
																<font color="#FF3333" style="font-size:20px"><strong>
												<%
													int columnId = ((Integer)request.getAttribute("columnId")).intValue();
													switch (columnId ){
														case 3 : out.print("合众播报");
															newColumnId = Constant.hezhongbobao;
															break;
														case 1 : out.print("公告");
															newColumnId = Constant.gonggao;
															break;
														case 70 : out.print("合众简报");
															newColumnId = Constant.hezhongjianbao;
															break;
														case 71 : out.print("机构发展快讯");
															newColumnId = Constant.jigoufazhankuaixun;
															break;
														case 73 : out.print("行业资讯");
															newColumnId = Constant.hangyezixun;
															break;														
														
													}
												%></strong>
												</font>
														</td>
														<td  align="center">
															<a href="list.do?method=zongbu&ptype=5&columnId=<%=newColumnId%>" >2007年4月以后的数据</a>
														</td>
													</tr>
												</table>
											</td>
										</tr>
										<%
											List<Files> list = (List<Files>)request.getAttribute("list");
												if(list != null){
													for(int i = 0; i < list.size(); i++){					
														out.println("<tr><td height='20'  ></td>");
														out.println("<td colspan='3' valign='middle'  ><img src='images/index/a6.gif' width='8' height='8'> ");
														if(list.get(i).getHaveContent() == 0 && list.get(i).getDocno() != 0){
															out.print("<a target='_blank' href='showOld.do?c=" + list.get(i).getFileid() + "&a=0'>");
															out.println(list.get(i).getTitle() + "&nbsp;/" + list.get(i).getUploadtime().toString().substring(0,list.get(i).getUploadtime().toString().indexOf(" ")) + "</a>");					
															out.println("</td><td></td></tr>");			
															if(list.get(i).getDocno() > 1){
																out.print("<tr><td></td><td>");
																for(int j = 2; j <= list.get(i).getDocno() ; j++){
																	out.print("<a target='_blank' href='showOld.do?c=" + list.get(i).getFileid() + "&a=" + (j - 1) + "'>");
																	out.print("附件" + (j - 1) + "</a> &nbsp;&nbsp;");
																}
																out.print("</td><td></td></tr>");
															}
														}else{
															out.print("<a target='_blank' href='showOld.do?c=" + list.get(i).getFileid() + "'>");
															out.println(list.get(i).getTitle() + "&nbsp;/" + list.get(i).getUploadtime().toString().substring(0,list.get(i).getUploadtime().toString().indexOf(" ")) + "</a>");					
															out.println("</td><td></td></tr>");			
															if(list.get(i).getDocno() > 0){
																out.print("<tr><td></td><td>");
																for(int j = 1; j <= list.get(i).getDocno() ; j++){
																	out.print("<a target='_blank' href='showOld.do?c=" + list.get(i).getFileid() + "&a=" + (j - 1) + "'>");
																	out.print("附件" + j + "</a> &nbsp;&nbsp;");
																}
																out.print("</td><td></td></tr>");
															}
														}
																
													}
												}
												
											%>
											<tr>
											<form action="oldFile.do?method=list&sp=/subpage/o1t5.jsp" method="post" name="forms" id="idforms">
											<input type="hidden" name="columnId" id="idccolumnId" value="<%=columnId%>" />
											
												<td colspan="5">
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

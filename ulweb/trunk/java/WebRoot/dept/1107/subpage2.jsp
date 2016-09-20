
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlTemplate,com.ulic.ulweb.ulweb.entity.UlColumn,com.ulic.ulweb.ulweb.entity.UlContent" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  
<head>
<base href="<%=basePath%>">
<title>营销部</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<LINK href="style/ul.css" type="text/css" rel=stylesheet>
<%
		UlTemplate t = (UlTemplate)request.getAttribute("template");
		List<UlColumn> list1 = (List<UlColumn>)request.getAttribute("cList1");
		List<UlColumn> list2 = (List<UlColumn>)request.getAttribute("cList2");
		List<UlContent> list = (List<UlContent>)request.getAttribute("contentList");
		UlColumn column = (UlColumn)request.getAttribute("column");
		
	%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<%
	 if(t.getCss() != null){
		out.print(t.getCss());
		}
	%>
</head>
  	<script type="text/javascript" src="script/l2page.js"></script>
	
  <body  bgcolor="#DDEADD">
<table width="770" cellpadding="0" cellspacing="0" border="0" align="center" bgcolor="#ffffff" >
		<tr>
			<td width="100%" align="center">
				<img src="<%=t.getPic1()%>"  border="0" />
			</td>
		</tr>
		
		<tr><td height="5"></td></tr>
		<tr><td></td></tr>
		<tr><td align="right">
			<table cellpadding="5"  cellspacing="4" border="0" class="list1">
				<tr>
					
					<td align="center" background="<%=t.getPic2()%>" id="idtl1" width="80">
						<a href="dept2l.do?method=index&dept=<%=column.getOrganId()%>">首页</a>
					</td>
					
					
					<%
						for(int i = 0 ; i < (list1 == null ? 0 : list1.size()); i++){
					%>
					
					<td width="80" align="center" background="<%=t.getPic2()%>" >
						<a href="dept2l.do?method=sub1&columnId=<%=list1.get(i).getColumnId()%>"><%=list1.get(i).getColumnName()%></a>						
					</td>
					<%
						}
					%>
					<td ></td>
				</tr>
			</table>
		
		</td></tr>
		<tr>
			<td>
				<table width="100%" cellspacing="0" cellpadding="0" border="0" align="center" id="mainContent"> 
					<tr>
						<td width="20"></td>
						<td align="center"  width="150" valign="top" s>
							<table  cellpadding="5" cellspacing="5" border="0" class="list2" width="105">
								<tr><td height="20" style="background-image:none;"></td></tr>
																
								<%
									for(int i = 0; i < (list2 == null ? 0 : list2.size()); i++){
								%>
								<tr>
									<td align="center" background="<%
										if(list2.get(i).getColumnId() == column.getColumnId()){
											out.print( t.getPic4() );
										}else{
											out.print( t.getPic3() );
										}
									%>"
									>
										<a href="dept2l.do?method=sub2&columnId=<%=list2.get(i).getColumnId()%>"><%=list2.get(i).getColumnName()%></a>
									</td>
								</tr>
								<%
									}
								%>
								
						
								<tr><td align="center">								
								</td></tr>
								
								
							</table>
						</td>
						
						
						<td width="20"></td>						
						<td  valign="top">
							<table border="0" cellpadding="0" cellspacing="0" width="100%">
								<tr><td height="20"></td></tr>
								<tr>
									<td height="30" >
										
									</td>
								</tr>
								<tr><td height="20"></td></tr>
								<tr>
									<td>
										<table cellpadding="0" cellspacing="0" border="0" width="100%" class="contentList">
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
											</table></td></tr>
											
											<tr><td valign="bottom"><table border="0" width="100%">
											
											<tr>
											<form  method="post" name="forms" id="idforms">
											<input type="hidden" name="columnId" id="idcolumnId" value="<%=(column == null ? "" : column.getColumnId())%>" />
											
												<td colspan="5">
													<%
														int totlePage = 1;
														int pageNow = 1;					
														if(request.getAttribute("totlePage") != null){
									
															totlePage = (Integer)request.getAttribute("totlePage");
														}
														if(request.getAttribute("page") != null){
															pageNow = (Integer)request.getAttribute("page");
														}
														if(totlePage > 1){
															out.print("现在是第" + pageNow + "页&nbsp;&nbsp;&nbsp;");
															out.print("共" + totlePage + "页 &nbsp;&nbsp;");
															if(pageNow != 1){
																out.print("<a href='javascript:goto2P(" + (pageNow - 1) + ");'>上一页</a>&nbsp;&nbsp;");
															}						
															out.print("<a href='javascript:goto2Page();' >转到</a>&nbsp;第");
															out.print("<input id='idpage' name='page' size='3' maxlength='3' type='text'></input>页");
															if(pageNow != totlePage){
																out.print("<a href='javascript:goto2P(" + (pageNow + 1) + ");'>下一页</a>&nbsp;&nbsp;");
															}
														}
													%>
												</td>
												</form>
											</tr>			
											<tr><td height="50"></td></tr>
											
										</table>
									</td>
								</tr>
								
							</table>
						</td>
						
						
						<td width="20"></td>
						
					</tr>
					
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td align="left">&nbsp;&nbsp;&nbsp;
							<img src="images/index/logo1.jpg" border="0" />
						</td>
					
						<td align="center">
							<img src="<%=t.getPic5()%>" border="0" />
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr><td align="center"><img src="<%=t.getPic6()%>" border="0"/></td></tr>
		<tr>
			<td  width="100%" height="20">
				<iframe src="dept/1110/indexbottom.jsp" height="100" width="100%" frameborder="0" scrolling="no" ></iframe>
			</td>
		</tr>
		
	</table>
  </body>
</html>

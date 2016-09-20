
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlContentWithAtt,com.ulic.ulweb.ulweb.entity.UlColumn" pageEncoding="UTF-8"%>

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
  <script  language="JavaScript" src="script/list.js"></script>
  <script>
function gotoPA(page){
	document.getElementById("idforms").action = "list.do?method=zongbuHaveAtt&page=" + page;
	document.getElementById("idforms").submit();
}

function gotoPageA(){
	document.getElementById("idforms").action = "list.do?method=zongbuHaveAtt&page=" + document.getElementById("idpage").value;
	document.getElementById("idforms").submit();
}
  
  
  </script>
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
		<tr>
			<td align="center">
			
			
			</td>
		</tr>
		
		<tr><td valign="top" style="text-align: center; font-weight:bold;color:#ff3333;font-size:20px;"><%=c.getColumnName() %></td></tr>
		
		<tr><td valign="top">
	<table>
<%
List<UlContentWithAtt> list = (List<UlContentWithAtt>) request.getAttribute("list");

for (int i = 0; list != null && i < list.size(); i++) {
String imgSrc = "images/index/zhijilianghui.jpg";
if (list.get(i).getAttachmentSum() > 0 && list.get(i).getAtt(0) != null) {
	imgSrc = list.get(i).getAtt(0).getAttachmentPath();
}

 %>
	<tr>
		<td style="border:gray 1px solid;">
			<table cellpadding="0" cellspacing="0" border="0" width="750" >
				<tr><td height="5"></td><td></td></tr>
				<tr>
					<td style="color:#FF6699;font-size:14px;" rowspan="1" width="120" align="center">
						<%=list.get(i).getContentName() %><br><br>
						<img src="showfile.do?filePath=<%=imgSrc %>" width="200" height="150" border="0" /></td><td> </td>
				</tr>
				<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>
				<tr><td align="right">
					<a href="<%=list.get(i).getSubTitle() %>" style="color:#0000FF" >请右键使用目标另存为下载</a>&nbsp;&nbsp;
				</td></tr>
			</table>														
		</td>
	</tr>					
	<tr><td>&nbsp;</td></tr>


<% } %>
<tr>
	<td>
											<form action="list.do?method=zongbuHaveAtt" method="post" name="forms" id="idforms">
											<input type="hidden" name="columnId" id="idccolumnId" value="<%=(c == null ? "" : c.getColumnId())%>" />
											<input type="hidden" name="ptype" id="idptype" value="<%=request.getAttribute("ptype")%>" />
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
																out.print("<a href='javascript:gotoPA(" + (pageNow - 1) + ");'>上一页</a>&nbsp;&nbsp;");
															}						
															out.print("<a href='javascript:gotoPageA();' >转到</a>&nbsp;第");
															out.print("<input id='idpage' name='page' size='3' maxlength='3' type='text'></input>页");
															if(pageNow != pageSum){
																out.print("<a href='javascript:gotoPA(" + (pageNow + 1) + ");'>下一页</a>&nbsp;&nbsp;");
															}
														}
													%>	
													</form>
	</td>
</tr>
	</table>
		</td></tr>
		
		<tr>
			<td>
				<jsp:include page="../frame/indexbottom.jsp" />
			</td>
		</tr>
		<tr><td height="30"></td></tr>
	</table>
   
   
  </body>
</html>

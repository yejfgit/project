
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlColumn" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>栏目信息</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>
   <script language="JavaScript" src="script/common.js"></script>
  <%
  		UlColumn c = (UlColumn)request.getAttribute("c");
  %>
  <body>
   	<table align="center" border="1" cellspacing="0" width="450">
		<tr>
			<td>
				栏目名称:
			</td>
			<td>
				<%=c.getColumnName()%>
			</td>
		</tr>
		<tr>
			<td>
				上级栏目:
			</td>
			<td>
				<%
					if(c.getParentName() == null){
						out.print("此栏目没有上级栏目");
					}else{
						%>
						<a href="javascript:openwin('<%=basePath%>admin/column.do?method=show&c=<%=c.getParentId()%>');" ><%=c.getParentName()%></a>
						<%
					}				
				
				%>
			</td>
		</tr>
		<tr>
			<td>
				所属部门:
			</td>
			<td>
				<%=c.getOrganId()%>
			</td>
		</tr>
		<tr>
			<td>
				包含内容:
			</td>
			<td>
				<%
					if(c.getIncludeContent() == 1){
						out.print("此栏目用于放置内容");
					}else{
						out.print("此栏目用于放置栏目");
					}
				%>
			</td>
		</tr>
		<tr>
			<td>
				栏目等级:
			</td>
			<td>
				此栏目为<%=c.getColumnLevel()%>级栏目
			</td>
		</tr>
	</table>
	<script language="JavaScript">
  		window.resizeTo(450,400);
  </script>
  </body>
</html>

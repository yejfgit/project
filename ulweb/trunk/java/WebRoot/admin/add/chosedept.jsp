
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'chosedept.jsp' starting page</title>
    
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
   <table width="760">
   <form name="form1" action="admin/content.do?method=list" method="post">
   	<tr>
		<td align="center">
			<%=request.getAttribute("deptList")%>
		</td>
	</tr>
	<tr>
		<td align="center">
			<input type="submit" value="确定" />
			&nbsp;
			<input type="button" onClick="javascript:window.localhref='index.jsp';" value="回主页" />
		</td>
	</tr>
	</form>
   </table>
  </body>
</html>

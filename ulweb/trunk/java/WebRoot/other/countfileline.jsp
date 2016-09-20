
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'countfileline.jsp' starting page</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>
  
  <body>
    <table align="center" border="1" cellspacing="0" width="500">
	<form action="countFileLine.do?method=count" method="post">
		<tr>
			<td>
				文件夹位置
			</td>
			<td>
				<input type="text" name="fPath" id="idfPath"></input>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="确定"/>
			</td>
		</tr>
		</form>
	</table>
  </body>
</html>

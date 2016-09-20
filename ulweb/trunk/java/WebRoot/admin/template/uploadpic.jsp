
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>uploadpic</title>
    
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
   <table align="center">
   	<form action="admin/template.do?method=uploadPic" method="post" enctype="multipart/form-data">
		<input type="hidden" value="<%=request.getParameter("name")%>" name="name" />
   		<tr>
			<td>
				图片上传:
			</td>
		</tr>
		<tr>
			<td>
				<input type="file" name="pic"></input>
			</td>
		</tr>
		<tr>
			<td align="center">
				<input type="submit" value="确定"/>
				&nbsp;&nbsp;
				<input type="button" value="取消" onClick="javascript:window.close();"/>
			</td>
		</tr>
	</form>
   </table>
  </body>
</html>

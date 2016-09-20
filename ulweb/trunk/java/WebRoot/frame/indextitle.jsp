<%@ page pageEncoding="UTF-8" language="java" import="java.sql.*,com.ulic.ulweb.frame.constant.Constant" errorPage="" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
 <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 <LINK href="style/ul.css" type="text/css" rel=stylesheet>
<title>ulweb</title>
</head>


  <body >
   <table width="760" bgcolor="#b4de54" height="36" cellpadding="0" cellspacing="0" border="0">
	  	<tr>
			
			<td width="90%" align="right">
				<a href="index.do" target="_parent" >返回首页</a>
			</td>
			<td width="10%"></td>
			
		</tr>
	  </table>
</body>
</html>

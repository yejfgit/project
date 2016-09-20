<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Json Test</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script language="javascript" src="js/ajax.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function(){
			var userName=document.getElementById("userName").value;
			var gender = document.getElementById("gender").value;
			var password = document.getElementById("old").value;
			var hobby = document.getElementById("hobby").value;

			var user = {"name":userName,"gender":gender,"password":password,"hobby":hobby}
			var obj = user.parseJSON();
			
			Ajax a = new Ajax();
			var tableId = "test";
			a.sendPost("json.do?method=jsonGo",obj,tableId)
		}
	</script>
  </head>
  
  <body>
	<table>
		<tr><td>姓名:<input type="text" id="userName"/></td></tr>
		<tr><td>性别:<input type="text" id="gender"/></td></tr>
		<tr><td>年龄:<input type="text" id="old"/></td></tr>
		<tr><td>爱好:<input type="text" id="hobby"/></td></tr>
		<tr><td><input type="button" value="提交" onclick="doit()"></td></tr>
	</table>
	
	<div id="test"></div>
  </body>
</html>

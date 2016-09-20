
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
        <base href="<%=basePath%>">
    <title>部门列表</title>
    
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
   <table align="center" border="0" cellpadding="0" cellspacing="0" width="450">
   		<tr>
			<td>
				<table align="center" border="1" width="100%" cellpadding="2" cellspacing="0"> 
					<%=request.getAttribute("list")%>
				</table>
			</td>
		</tr>
		<tr>
			<form name="form1" method="post" action='admin/add/adddept.jsp'>
				<td align="center"> 
					<input type="submit" value="添加" />
					
				</td>
			</form>
		</tr>
   </table>
  </body>
</html>

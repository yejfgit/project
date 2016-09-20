
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'chatpage.jsp' starting page</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <META HTTP-EQUIV="refresh" CONTENT="10;">
	 <LINK href="style/ul.css" type="text/css" rel=stylesheet>
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>
  
  <body>
   <table align="center" border="0" width="100%">
   		<tr>
			<td>
				<%
				if((Constant.sbcount % 200) < 100){
					out.print(Constant.sb1.toString());
					out.print(Constant.sb2.toString());
				}else{
					out.print(Constant.sb2.toString());
					out.print(Constant.sb1.toString());
				}
			%>
			</td>
		</tr>
   </table>
  </body>
</html>

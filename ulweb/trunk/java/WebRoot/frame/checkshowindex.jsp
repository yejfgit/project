
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <base href="<%=basePath%>">
    
    <title>My JSP 'logout.jsp' starting page</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
  </head>
   
  <body>
   <table border="0"  align="center">
   		<tr>
			<td align="center" style="color:#E40EFC;font-size:18px;">
				
				<br>
				<br>
				<br>
				使用方法：
				<br>
				在标题处填写所要查找的文件名
				<br>
				时间和类型可以不选，默认为所有
				<br>
				文号仅用于2007-04-07以后添加的带有文号的公文
			</td>
		</tr>
   </table>

</body>
</html>

   
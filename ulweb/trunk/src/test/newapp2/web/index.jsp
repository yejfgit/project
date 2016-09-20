<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<html>
  <head>
   	<base href="<%=basePath %>" />
    
    <title>消息页面</title>

	<link rel="stylesheet" type="text/css" href="css/css.css">


  </head>
  
<body>

<%=request.getAttribute("output") %>


</body>
</html>

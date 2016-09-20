<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ include file="/jsp/include/head.jsp" %>

<%
response.setHeader("Pragma","No-Cache");
response.setHeader("Cache-Control","No-Cache");
response.setDateHeader("Expires", 0);
%>

<html>  
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>处理完毕</title>
<style type="text/css">
<!--
.tt {
	font-family: "Times New Roman", Times, serif;
	font-size: 14px;
	color: #336699;
	text-decoration: none;
}
--> 
</style>
<link type="text/css"  href="<%=request.getContextPath()%>/css/css.css"  rel="stylesheet">	
 
</head>
<script Language="JavaScript" src="<%=request.getContextPath()%>/js/common.js"> </script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/Attachment.js.jsp"></script>
<body onload="">
处理完毕，即将关闭窗口


<script>

var t = setTimeout('window.close();', 100);

</script>
</body>
</html>
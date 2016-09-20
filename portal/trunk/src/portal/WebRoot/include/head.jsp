<%@ taglib prefix="s" uri="/struts-tags" %>

<%
String basePath = request.getScheme() + "://" + 
	request.getServerName() + ":" + request.getServerPort() + 
	request.getContextPath() + "/" ;
%>
<base href="<%=basePath%>" />
<script type="text/javascript" src="script/common.js"></script>
<script type="text/javascript" src="script/ajax.js"></script>
<script type="text/javascript" src="script/page.js"></script>
<script type="text/javascript" src="script/jquery-1.7.2.min.js"></script>
<link href="css/main.css" rel="stylesheet" type="text/css" />


<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="struts-html.tld" prefix="html" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>historyList</title>
 <script type="text/javascript">
    	function selectHistory(value){

 		window.top.location.href=value;
    	}
 </script>
  </head>
  <body style="margin: 0px">
<div><html:select style="width:78px;height:20px;" name="newspaperForm" property="content.contentName" onchange="selectHistory(this.options[this.selectedIndex].value)">
<option>往期回顾</option>
<html:optionsCollection name="historyLabelList" /></html:select></div>	
  </body>
</html>

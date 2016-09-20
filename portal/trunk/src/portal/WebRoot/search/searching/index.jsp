<%@ page language="java" pageEncoding="UTF-8"%>
<jsp:directive.page import="java.util.Map"/>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>合众搜索</title>
    <%@ include file="/include/head.jsp"%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="search/script/searching.js"></script>
	<link href="search/css/searching.css" rel="stylesheet" type="text/css" />
  </head>
  
<body onclick="document.getElementById('myDiv1').style.display='none';">
<h4>合众搜索v0.03</h4>
<form name="f1" method="get" action="search/search" onsubmit="if (document.getElementsByName('queryString')[0].value == '') return false;">
<input type="hidden" name="source" value="all">
<table>
<tr>
	<td>
	<strong>综合</strong>&nbsp;&nbsp;&nbsp;&nbsp;<span><a href="javascript:void(0)" onclick="goColumn('ulweb2');return false;">内部网</a></span>
	</td>
</tr>
<tr>
	<td>
	<input type="text" style="width: 400px; font-size: 16px;" name="queryString" onkeyup="doSubmit1()" onkeydown="doUpAndDown()" value="<%= request.getAttribute("queryString") != null ? (String)request.getAttribute("queryString") : ""%>" />
	<input type="submit" value="搜索" />
	<div id="myDiv1" style="width: 400px;border:1px solid ;background-color: #ffffff ;position: absolute;left: 3px;top: 85px;display: none ;"></div>
	</td> 
</tr>
</table>
</form>


  <s:iterator value="pageSupport.items">

<li>
	<p class="title"><a href="<s:property value="url" />" target="_blank"><s:property value="title" escape="false"/></a></p>
	<p class="content"><s:property value="content" escape="false" /></p>
	<p class="url"><s:property value="url" /></p>
</li>

</s:iterator>

<br /><br /><br />
  ${pageSupport.pageContent}
<br />
<div style="width:800px;height:20px">
<s:if test="relativeList.size!=0"> 
<div style="float: left;widows: 50px;">
	<strong>&nbsp;&nbsp;&nbsp;&nbsp;相关搜索：</strong>
</div>
<div style="float:left">
	<table>
			<%int i=0; %>
			<tr>
				<td>
			<s:iterator value="relativeList">	
	
						<%i++; %>
						<a href="search/search?source=all&queryString=<s:property value='url' escape='false' />"><s:property value="queryString" escape="false" /></a>&nbsp;&nbsp;&nbsp;&nbsp;
			    <% if (i % 5 ==0) {  %>
						</td></tr><tr><td>
				<% }else {%>
					</td><td>
				<% } %>
				</s:iterator>
			</table>	
</div>
</div>
</s:if>
<br /><br /> 
<center><a href="version.txt" target="_blank">版本记录</a></center>

  </body>
</html>

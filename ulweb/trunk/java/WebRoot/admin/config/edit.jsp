﻿
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlConfig" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>设置</title>
    
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
  	<%
		UlConfig c = (UlConfig)request.getAttribute("c");
	%>
  <body>
   <table width="550" align="center">
   		<form action="admin/config.do?method=edit" method="post" name="form1" >
   		<tr>
			<td>
				id值
			</td>
			<td>
				<input type="text" name="configId" value="<%=c.getConfigId()%>" ></input>
			</td>
		</tr>
		<tr>
			<td>
				constant_name
			</td>
			<td>
				<input type="text" name="constantName" value="<%=c.getConstantName()%>" ></input>
			</td>
		</tr>
		<tr>
			<td>
				名字(column_name)
			</td>
			<td>
				<input type="text" name="columnName" value="<%=c.getColumnName()%>" ></input>
			</td>
		</tr>
		<tr>
			<td>
				数据(constant_data)
			</td>
			<td>
				<input type="text" name="constantData" value="<%=c.getConstantData()%>"></input>
			</td>
		</tr>
		<tr>
			<td>
				描述
			</td>
			<td>
				<input  type="text" name="desc" value="<%=c.getDesc()%>" ></input>
			</td>
		</tr>		
		<tr>
			<td align="center" colspan="2">
				<input type="submit" value="确定"/>
			</td>
		</tr>
		</form>
   </table>
    <script language="JavaScript">
  		window.resizeTo(590,500);
  </script>
  </body>
</html>

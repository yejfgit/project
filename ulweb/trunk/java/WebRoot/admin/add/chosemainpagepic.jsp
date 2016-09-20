
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>更改首页图片</title>
    
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
  		String ppath = request.getParameter("ppath");		
  %>
  <body>
    <table align="center" width="756" cellpadding="2" cellspacing="0" border="0">
		<form action="admin/ad.do?method=add" enctype="multipart/form-data" method="post" name="form1" id="idform1">
			<input name="name"  type="hidden" value="<%=request.getParameter("name")%>">
		<tr>
			<td>
				现在的首页图片:
			</td>
		</tr>
		<tr>
			<td align="center">
				<%
	   		if(ppath != null && ppath.length() > 3){
				if((ppath.substring((ppath.length() -3), ppath.length())).equals("swf")){	  
				
		%>
		
					  <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0" >
                          <param name="movie" value="<%=ppath%>">
                          <param name="quality" value="high">
                          <embed src="<%=ppath%>" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash"  ></embed></object> 
                      
		<%
			}else{
		%>
		 
	 		   <img src="<%=ppath%>" border="0">		
		
		<%
			}}
		%>
			</td>
		</tr>
		
		<tr>
			<td>
				请选择新的图片或flash:
			</td>
		</tr>
		<tr>
			<td align="center">
				<input type="file" name="files" />
			</td>
		</tr>
		<tr>
			<td align="center">
				<input type="submit" value="确定">
				&nbsp;&nbsp;
				<input type="button" value="返回" onClick="javascript:window.location.href='changeindex.jsp';">
			</td>
		</tr>
		</form>
	</table>
  </body>
</html>

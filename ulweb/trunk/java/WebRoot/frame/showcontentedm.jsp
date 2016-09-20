<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlContent" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style>
  	P{
		margin:0cm;
	}
  </style>
<title>关注</title>
</head>

  <%
  		UlContent c = (UlContent)request.getAttribute("c");
  
  %>
 

<body style="background-image:url('images/ed/messagebackground.jpg')">
<div >
	<%
			out.print((c.getContent() == null ? "" : c.getContent()));
	%>
</div>
</body>
</html>

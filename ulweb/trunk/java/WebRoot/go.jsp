<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String url = request.getParameter("url");
//System.out.println(url);
response.sendRedirect(url);

%>


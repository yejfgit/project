
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlDocumentModel" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

out.print(request.getAttribute("sb"));
%>

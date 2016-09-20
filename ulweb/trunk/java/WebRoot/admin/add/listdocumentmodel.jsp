
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlDocumentModel" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>公文模板列表</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>
  <%
  		List<UlDocumentModel> l = (List<UlDocumentModel>)request.getAttribute("list");
  %>
  <body>
  	<table width="250" align="center">
		<tr><td colspan="2" align="center"> 
			<%=(request.getAttribute("errorMessage") == null ? "" : request.getAttribute("errorMessage"))%>
		</td></tr>
		<tr><td width="100"></td>
			<td>
				列表
			</td>
		</tr>
		
		<%
			for(int i = 0 ; i < (l == null ? 0 : l.size()) ; i++){
		%>
			<tr><td></td>
				<td>
					<a href="admin/document.do?method=bEditModel&modelId=<%=l.get(i).getId()%>"> <%=l.get(i).getId()%> </a>
				</td>
			</tr>
		
		<%
			}
		%>
	</table>
  
</body>
</html>

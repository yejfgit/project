
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlRoleClass,com.ulic.ulweb.ulweb.entity.UlColumn" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员信息</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>
   <script language="JavaScript" src="script/common.js"></script>
  <body>
  <%
  		UlRoleClass r = (UlRoleClass)request.getAttribute("r");
		List<UlColumn> l = (List<UlColumn>)request.getAttribute("list");
  %>
  <table width="450" align="center" border="1" cellspacing="0">
  	<tr>
		<td width="150">
			姓名:
		</td>
		<td>
			<%=r.getName()%>
		</td>
	</tr>
	<tr>
		<td>
			部门:
		</td>
		<td>
			<%=r.getDept()%>
		</td>
	</tr>
	<tr>
		<td>
			管理级别:
		</td>
		<td>
			<%
				if(r.getIsAdmin() == 9){
					out.print("超级管理员</td></tr>");
				}else if(r.getIsAdmin() == 2){
					out.print("部门管理员</td></tr>");
				}else if(r.getIsAdmin() == 1){
					%>
					栏目管理员
		</td></tr>
	<tr>
		<td valign="top">
			管理的栏目:
		</td>
		<td>
			<%
				for(int i = 0; i < (l == null ? 0 : l.size()); i++){
					%>
					<a href="javascript:openwin('<%=basePath%>admin/column.do?method=show&c=<%=l.get(i).getColumnId()%>');"  ><%=l.get(i).getColumnName()%></a>				
					<br>					
					<%
				}
			%>
		</td>
	</tr>
					
			<%
				}
			%>
		
	
  </table>
  <script language="JavaScript">
  		window.resizeTo(450,400);
  </script>
  </body>
</html>

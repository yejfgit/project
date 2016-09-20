
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlConfig" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>系统设置</title>
    
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
  		List<UlConfig> l = (List<UlConfig>)request.getAttribute("list");
  %>
  <body>
    <table align="center" width="750" border="0">
		<tr><td width="20%"></td>
			<td width="15"></td>
			<td width="20%"></td>
			<td width="45%"></td>
		</tr>
		<tr>
			<td colspan="4">
				
			</td>
		</tr>
		<%
			for(int i = 0; i < (l == null ? 0 : l.size()); i++){
						
		%>
		<tr style="border-bottom:1px gray solid;">
			<td align="center" >
				<a href="admin/config.do?method=bEdit&configId=<%=l.get(i).getConfigId()%>" target="_blank"><%=l.get(i).getColumnName()%></a>
				</td>
				<td>
					id:<%=l.get(i).getConfigId()%>
				</td>
				<td>
				值:&nbsp;&nbsp;<%=l.get(i).getConstantData()%>				
				</td>
				<td>
					<%=l.get(i).getDesc()%>
				</td>
			
		</tr>
		<%
			}
		%>
		<tr>
			<td align="center" colspan="4">
				<a href="admin/config/save.jsp" target="_blank">添加</a>
			</td>
		</tr>
		<tr><td colspan="4" height="20"></td></tr>
		<tr>
			<td colspan="4"><a href="admin/config.do?method=getInit" target="_blank">初始化数据(不要点这个，可能会出问题)</a></td>
		</tr>
	</table>
  </body>
</html>

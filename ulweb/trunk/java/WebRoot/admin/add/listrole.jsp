
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlRoleClass" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理人员</title>
    
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
 <script language="JavaScript" src="script/common.js"></script>
  <body>
   
  <table border="1"  cellspacing="0" align="center" width="550">
     
	 	<tr>
			<td colspan="4" height="40">
				点击管理员名称可查看该管理员的详细信息
				
			</td>
		</tr>  			
  		<tr>
				<td>
					角色名称
				</td>
				<td>
					部门
				</td>
				<td>
					管理级别
				</td>
				<td>
					操作
				</td>
		</tr>
		<%	
		List<UlRoleClass> list = (List<UlRoleClass>)request.getAttribute("listu");
		
		for(int i = 0; i < (list == null ? 0 : list.size()); i++ ){			
			if(i%2 == 0){
				out.println("<tr><td>");
			}else{
				out.println("<tr bgcolor='#a0ceff'><td >");
			}			
			out.print("<a href=\"javascript:openwint('" + basePath + "admin/addRoleClass.do?method=showuser&roleId=" + list.get(i).getRoleId() + "', 'roleuser');\" >");
			out.println(list.get(i).getName());
			out.println("</a></td><td>");
			out.println(list.get(i).getDept());
			out.println("</td><td>");
			if(list.get(i).getIsAdmin() == 1){
				out.print("栏目管理员");
			}else if(list.get(i).getIsAdmin() == 2){
				out.print("部门管理员");
			}else if(list.get(i).getIsAdmin() == 3){
				out.print("总公司管理员");
			}else if(list.get(i).getIsAdmin() == 9){
				out.print("超级管理员");
			}
			out.println("</td><td>");
			out.println("<a href='admin/addRoleClass.do?method=bedit&roleId=" + list.get(i).getRoleId() );
			out.println("'>设置</a>&nbsp;&nbsp;<a href='admin/addRoleClass.do?method=delete&roleId=" + list.get(i).getRoleId() + "'>删除</a></td></tr>");
						
		}	
		
		%>
		<tr>
			<td colspan="4" align="center">
				<a href="admin/addRoleClass.do?method=bAdd">增加新的管理员</a>
			</td>
		</tr>
	</table>
  </body>
</html>

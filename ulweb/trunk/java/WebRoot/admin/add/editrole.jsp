
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'editrole.jsp' starting page</title>
    
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
   <script language="JavaScript" src="script/add.js"></script>  
	
  <body>
   <table border="0" cellpadding="0" cellspacing="0" align="center" width="750">
   	<form action="admin/addRoleClass.do?method=save" method="post" name="form1" id="idform1">
		<input name="roleId" type="hidden" value='<%=request.getAttribute("roleId")%>'/>
		<input type="hidden" name="roleClass" value="1"/>
   		<tr>
			<td>
				<table border="1" width="100%" cellspacing="0">
					<tr>
						<td width="30%">
							管理员
						</td>
						<td>
							<%=request.getAttribute("roleName")%>
						</td>
					</tr>					
					<tr>
						<td>
							管理员级别
						</td>
						<td>
							<select name="isAdmin" id="idisAdmin" >
								<option value="0">普通用户</option>
								<option value="1">栏目管理员</option>
								<option value="2">部门管理员</option>
								<option value="3">总公司管理员</option>
								<option value="9">超级管理员</option>
							  </select>
							
						</td>
					</tr>
					<tr>
						<td >
							管理员部门
						</td>						
						<td>
							<select name="deptId" id="iddeptId">
								<%=request.getAttribute("deptList")%>
							</select>
						</td>
					</tr>
					<tr>
						<td align="right">
							<input type="button" onClick="editRole();" value="确定" />&nbsp;
						</td>
						<td>
						&nbsp;
							<input type="button" onClick="javascript:window.location.href='<%=basePath%>admin/addRoleClass.do?method=list';" value="取消" />
						</td>
					</tr>
				</table>
			</td>
		</tr>
		</form>
   </table>
   <script language="JavaScript">
   		<%
			if(request.getAttribute("isAdmin") != null){
				out.print("document.getElementById('idisAdmin').value = '" + request.getAttribute("isAdmin") + "';" ); 
			}
			if(request.getAttribute("deptId") != null){
				out.print("document.getElementById('iddeptId').value = '" + request.getAttribute("deptId") + "';" );
			}
		%>
		
   </script>
  </body>
</html>

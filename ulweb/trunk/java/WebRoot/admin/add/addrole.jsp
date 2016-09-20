
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlRoleClass" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>增加管理员</title>
    
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
		<input type="hidden" name="roleClass" value="1"/>
   		<tr>
			<td>
				<table border="1" width="100%" cellspacing="0">
					<tr>
						<td width="30%">
							管理员 （<a href="admin/add/addadrole.jsp" target="_self"><font color="blue">从域中添加</font></a>）
						</td>
						<td>
							<select name="userId" id="idUserId">
								
							<%
								List<UlRoleClass> l = (List<UlRoleClass>)request.getAttribute("list");
								for(int i = 0 ; i < (l == null ? 0 : l.size()); i++ ) {
									out.println("<option value='" + l.get(i).getRoleId() + "'>" + l.get(i).getName() + "</option>");
								}
							%>
							</select>
							 <!-- <input type="button" onClick="javascript:window.open('../frame/showadminuser.jsp','checkuser');" value="输入姓名选择" />
						-->
						</td>
					</tr>					
					<tr>
						<td>
							管理员级别
						</td>						
						<td>
							<select name="isAdmin" id="idisAdmin" >								
								<option value="1">栏目管理员</option>
								<option value="2">部门管理员</option>								
								
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
							<input  onClick="javascript:window.location.href='<%=basePath%>admin/addRoleClass.do?method=list';" type="button" value="取消" />
						</td>
					</tr>
				</table>
			</td>
		</tr>
		</form>
   </table>
  </body>
</html>

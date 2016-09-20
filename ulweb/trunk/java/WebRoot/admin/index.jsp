
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>内部网后台管理页</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>
  
  <body>
  
  <table border="0" cellpadding="1" cellspacing="1" width="100%" align="center">
  	<tr>
		<td>
			<table border="0" cellpadding="0" cellspacing="0" width="100%">
				<tr>
					<td height="10">
						
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td align="center" style="border-bottom: gray 1px solid">
		欢迎您 <%
    	out.println(session.getAttribute("name"));
		int admin = (session.getAttribute("aClass") == null ? 0 :((Integer)session.getAttribute("aClass")).intValue());
   		if(admin == 0){
			response.sendRedirect(basePath + "admin/login.jsp");
		}
   
	%>
	
	<%
		if(admin > 5){
	%>
	<a href="web/admin/newspaper/newspaperAdmin.do?method=intoLoadPage" target="frame">发布电子报纸</a>
	<A href="admin/addRoleClass.do?method=list" target="frame">角色列表</A>
	<a href="web/admin/contentTmpl/contentTmplAdmin.do?method=list" target="frame">内容模板列表</a>
	<a href="web/admin/dept/deptAdmin.do?method=list" target="frame">部门列表</a>
	
	<a href="admin/add/changeindex.jsp" target="frame">更改主页图片</a>
	
	<%
		}
		if(admin == 2){
	%>		
	<a href="admin/template.do?method=list"  target="frame">修改主页设置</a>
	<%
		}
		if(admin > 1){
	%>		
	<a href="web/admin/column/columnAdmin.do?method=list" target="frame">栏目列表</a>
	<a href="web/admin/content/contentAdmin.do?method=list" target="frame">内容列表</a>
	
	<%
		} else {
	%>	
	<a href="web/admin/content/contentAdmin.do?method=list" target="frame">内容列表</a>
	
	<%
		}
	%>
	
	<a href="index.do">去主页</a>
	<a href="frame/logout.jsp">退出</a>
		</td>
	</tr>
	<tr>
		<td align="center">
		<iframe name="frame" id="idframe" src="admin/pic.jsp" frameborder="0" width="996" height="800"></iframe>
		</td>
	</tr>
  </table>
  
  	
	
	
  </body>
</html>

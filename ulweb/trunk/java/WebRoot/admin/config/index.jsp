
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>这是不是一般管理员应该看到的</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>
  
  <body >
  <table border="0" cellpadding="1" cellspacing="1" width="760" align="center">
  <tr>
  	<td align="center" style="color:red"> 
		请注意:如果您只是一般管理员，请不要修改此处的设置，这里很危险
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
   if(admin == 9){
	%>
	
	<a href="admin/config/indexset.jsp" target="frame">主页设置</a>
	<a href="admin/domain/index.jsp" target="frame">域测试</a>
	<a href="admin/config.do?method=beforeMoveData" target="frame">移动数据</a>
	<A href="admin/config.do?method=list" target="frame">页面属性设置</A>
	<a href="admin/config/sendmail.jsp" target="frame">发邮件测试</a>
	<a href="admin/config/watching.jsp" target="frame">监测</a>
<!-- <a href="admin/add/adddocumentmodel.jsp" target="frame">公文模板添加</a>
	<a href="admin/document.do?method=listModel" target="frame">公文模列表</a>
	<a href="admin/report.do?method=getReport" target="frame">读取业绩播报</a>
	<a href="#" >预留</a>
-->
	<a href="index.do">去主页</a>
	<a href="frame/logout.jsp">退出</a>
	<%
		}
	%>
		</td>
	</tr>
	<tr>
		<td>
		<iframe name="frame" id="idframe" src="" frameborder="0" width="760" height="1100"></iframe>
		</td>
	</tr>
  </table>
  
	
	
  </body>
</html>

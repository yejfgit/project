
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <base href="<%=basePath%>">
    <title>My JSP 'editdept.jsp' starting page</title>
    
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
  
  <body>
    <table width="450" border="0" cellspacing="0" cellpadding="0" align="center">
	<form action="admin/dept.do?method=update" method="post" name="form1">
	<input type="hidden" name="deptId" value='<%=request.getAttribute("deptId")%>' />
  <tr>
  	
    <td>
		<table width="450" border="1" cellspacing="0" cellpadding="0" align="center">
		  <tr>
			<td>部门编号</td>
				<td><%=request.getAttribute("deptId")%></td>
				  </tr>
				  <tr>
					<td>部门名称</td>
					<td><input name="deptName" type="text" size="20" maxlength="20" value='<%=request.getAttribute("deptName")%>'></td>
				  </tr>
				  <tr>
					<td>选用模板</td>
					<td><select name="deptModel" >
							  <option value="1">模板1</option>
							  <option value="2">模板2</option>
							  <option value="3">模板3</option>
							  <option value="4">模板4</option>
							</select></td>
				  </tr>
		</table>
	</td>
  </tr>
  <tr>
  	<td align="center">
					<input type="submit" value="确定" />
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" onClick="javascript:window.location.href='<%=basePath%>admin/dept.do?method=list';" value="取消" />
	</td>
  </tr>
  </form>
</table>
<script language="JavaScript">
	document.getElementsByName("deptModel")[0].value = '<%=request.getAttribute("deptModel")%>';
</script>
  </body>
</html>

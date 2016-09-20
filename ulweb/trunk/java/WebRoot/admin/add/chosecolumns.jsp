
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'chosecolumns.jsp' starting page</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
      <LINK href="style/ul.css" type="text/css" rel=stylesheet>
	 	<link rel="StyleSheet" href="style/dtree.css" type="text/css" />
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>
    <script language="JavaScript" src="script/add.js"></script>  
     <script language="JavaScript" src="script/dtree.js"></script>
  <body>
 
  
<table width="760" border="0" cellpadding="0" cellspacing="0" align="center">
  <!--DWLayoutDefaultTable-->
  <form action="admin/addRoleClass.do?method=save" name="form1" id="idform1" method="post">
  <input type="hidden" value="1" name="isAdmin" />
  <input type="hidden" value="<%=request.getAttribute("deptId")%>" name="deptId"/>
  <input type="hidden" value='<%=request.getAttribute("roleId")%>' name="roleId" />
  <input type="hidden" value='<%=request.getAttribute("roleClass")%>' name="roleClass" />
  <tr> 
  <td width="20%"></td>
    <td align="left" width="60%">
		<%=request.getAttribute("columns")%>
	</td>
    <td width="20%"></td>
  </tr>
  <tr>
    <td align="center" colspan="3"> 
			<input type="submit" value="确定" />&nbsp;
			<input type="reset" value="重置" />
	
	</td>
   
  </tr>
  </form>
</table>
</body>
</html>

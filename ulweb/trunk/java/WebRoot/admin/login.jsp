

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
 <base href="<%=basePath%>">
<title>用户登录</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

</head>
  <script language="JavaScript" src="script/submitcheck.js"></script>
<script language="javascript" src="script/md5.js" ></script>

   <body>
  <form action="admin/login.do" method="post" name="form1" >   
    <table align="center">
	<tr><td colspan="2">&nbsp;</td></tr> 
		<tr>
			<td colspan="2" align="center">  
					管理员登录（<font color="red">UM</font>用户名和密码）  
			</td>
		</tr>
    	<tr>
    		<td>
    			用户名:
    		</td>
    		<td>
    		   <input name="userName" id="iduserName"  type="text"></input>
    		</td>
    	</tr>
    	<tr>
    		<td>
    			密码:
    		</td>
    		<td>
    			<input name="pw" type="password"></input>
    		</td>
    	</tr>
    	<tr>
    		<td colspan="2" align="center">
    			 <input type="submit" value="确定" />
    		&nbsp;&nbsp;
    			 <input type="reset" value="清除" />
    		</td>
    	</tr>
    	<tr>
    		<td colspan="2" align="center"></td>
    	</tr>	
    	<tr>
    		<td colspan="2">
    			<%
					if(request.getAttribute("errorMessage") != null){
						out.print(request.getAttribute("errorMessage"));
					}
				%>
    		</td>
    	</tr>
    	
    	<tr>
    		<td colspan="2">
    			<br />如需找回密码或修改密码，<br />请进入UM系统管理界面<br />
    			<a href="http://ummanager.ulic.com.cn/ummanager/index.jsp" target="_blank">统一用户管理系统</a>
    		</td>
    	</tr>    	
    		
    	
    </table>
 	
	</form>
	<script language="JavaScript"> 
		document.getElementById("iduserName").focus();
	</script>
  </body>
</html>

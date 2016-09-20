

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
  <form action="admin/addRoleClass.do?method=findAdUserRealName" method="post" name="form1" >   
    <table align="center">
	<tr><td colspan="2">&nbsp;</td></tr> 
		<tr>
			<td colspan="2" align="center">
					从域上查找用户的真实姓名
			</td>
		</tr>
    	<tr>
    		<td>
    			域用户名:
    		</td>
    		<td>
    		   <input name="username" id="iduserName"  type="text"></input>
    		</td>
    	</tr>
    	<tr>
    		<td>
    			
    		</td>
    		<td>
    			
    		</td>
    	</tr>
    	<tr>
    		<td colspan="2" align="center">
    			 <input type="submit" value="查找" />
    		&nbsp;&nbsp;
    			 <input type="reset" value="清除" />
    		</td>
    	</tr>
    	<tr>
    		<td colspan="2" align="center"></td>
    	</tr>	
    	<tr>
    		<td colspan="2">
    			
    		</td>
    	</tr>
    		
    	
    </table>
 	
	</form>
	
	<div id="notfoundbox">请输入正确的域用户登录名，即办公邮箱的登录名@之前的部分</div>
	
	<div id="addbox">
	<form action="admin/addRoleClass.do?method=addAdUser" method="post" name="form2"> 
	  
	  <input type="hidden" name="username" value="<%
					if(request.getAttribute("username") != null){
						out.print(request.getAttribute("username"));
					}
				%>">
	  
	  <input type="hidden" name="realname" value="<%
					if(request.getAttribute("realname") != null){
						out.print(request.getAttribute("realname"));
					}
				%>">
				
				已找到域上用户。  
				登录名：<font color="blue"><%
					if(request.getAttribute("username") != null){
						out.print(request.getAttribute("username"));
					}
				%></font>&nbsp;&nbsp;
				
				真实姓名：<font color="blue"><%
					if(request.getAttribute("realname") != null){
						out.print(request.getAttribute("realname"));
					}
				%></font>&nbsp;&nbsp;&nbsp;&nbsp;是否添加到用户库中	
	  <input type="submit" value="添加">
	</form>
	</div>
<!-- keep -->	

	<script language="JavaScript"> 
	if(document.form2.realname.value == '') {
		addbox.style.display= 'none';
		notfoundbox.style.display= '';
	}else {
		addbox.style.display= '';
		notfoundbox.style.display= 'none';
	}
		document.getElementById("iduserName").focus();
	</script>
  </body>
</html>

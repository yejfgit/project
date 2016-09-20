<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
<base href="<%=basePath%>" />
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

   <body style="background:url(../survey/images/2008731905499_2.jpg);background-position: top center;">
 <table>
  <tr> 
    <td height="" length="100"></td>
    <td colspan="5" valign="top"><img src="../survey/images/logos1.jpg"></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr></table>
  <form action="login.do" method="post" name="form1" >   
<input type="hidden" name="toUrl" value="<logic:notEmpty name="toUrl"><bean:write name="toUrl" /></logic:notEmpty>" />  
  
  
    <table align="center">
	<tr><td height="100px" colspan="2">&nbsp;</td></tr> 
		<tr>
			<td colspan="2" align="center">   
					<strong>用户登录</strong>   
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
    	
    </table>
 	
	</form>
	<script language="JavaScript"> 
		document.getElementById("iduserName").focus();
	</script>
  </body>
</html>

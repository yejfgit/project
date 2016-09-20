<%@ page pageEncoding="UTF-8" language="java" import="java.sql.*" errorPage="" %>
<html>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>bottom</title>
<LINK href="style/ul.css" type="text/css" rel=stylesheet>

</head>

<body style="margin-bottom:-20;">
<table border="0" width="100%">
	<tr>
		<td>
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
        <!--DWLayoutTable-->
        <tr> 
          <td width="25%" height="24">&nbsp;</td>
          <td width="50%" valign="middle" align="center"><a target="_blank" href="index.do">公司首页</a>&nbsp; 
            |&nbsp; 关于合众 |&nbsp; <a href="http://10.18.1.141:9080/jira/secure/Dashboard.jspa" target="_blank">问题上报</a>&nbsp; 
            |&nbsp;<a href="admin/login.jsp" target="_blank">系统管理</a>&nbsp; 
          </td>
          <td width="25%">&nbsp;</td>
        </tr>
        <tr> 
          <td height="16" colspan="3" valign="top"><hr size=1 color="black"></td>
        </tr>
        <!--DWLayoutTable-->
      </table>
		</td>
	</tr>
	<tr>
		<td>
			<table width="100%" align="center" >
					<tr> 
						<td height=36 width="25%" valign="top"  bgcolor="#94c245"><!--DWLayoutEmptyCell-->&nbsp;</td>
						<td  align="center" valign="top" class="9b" >Copyright Reserved,Union 
						  Life Insurance Company,Ltd. <br>
						  建议使用分辨率800*600浏览 <br>
						  2004年10月14日</td>
						<td  valign="top" width="25%" bgcolor="#94c245"><!--DWLayoutEmptyCell-->&nbsp;</td>
					  </tr>
				</table>
		</td>	
	</tr>
</table>
</body>
</html>

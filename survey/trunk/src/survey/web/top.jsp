<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ include file="/jsp/include/head.jsp" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main_Top</title>
<link href="css/css.css" rel="stylesheet" type="text/css">
<script language="javascript"> 
 
</script>
</head>

<body>
<table width="100%" bgcolor="#9bcf00">
	<tr>
		<td height="5px"></td>
	</tr>
	<tr>
		<td width="10%"></td>
		<td align="left" style="color:white;" width="30%"><a href="survey.do?method=adminList" target="mainFrame"><img src="../survey/images/logo3.png"></img></a></td>
		<td align="right" width="45%" height="30" colspan="2">
			<table>
				<tr>
					<td align="center" height="32" colspan="2"style="font-size:25px;"><strong></strong></td>
				</tr>
				<tr>
					<td colspan="2"  align="center">
						&nbsp;<bean:write name="organName" />&nbsp;&nbsp;<bean:write name="userName" />&nbsp;&nbsp;|
						&nbsp;&nbsp;<a href="um_logout" style="color:#333333" target="_parent">退出</a>
						</td>
				</tr>
			</table>
		</td>
		<td width="15%"></td>
	</tr>
</table>
<table width="100%" style="height:8px" bgcolor="7bb803">
	<tr>
		<td style="height:1px"></td>
	</tr>
</table>
<table width="100%" height="30px" bgcolor="#555555">
	<tr>
		<td>&nbsp;</td>
	</tr>
</table>
</body>
</html>

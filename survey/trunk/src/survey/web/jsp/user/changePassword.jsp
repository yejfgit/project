<%@ page language="java" contentType="text/html; charset=utf-8" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
		<link href="css/css.css" rel="stylesheet" type="text/css">
		<script language="javascript" src="js/common.js"></script>
		<script language="javascript" src="js/boxover.js"></script>
<script type="text/javascript">
function doSubmit() {
	p0 = document.getElementById('password0').value;
	p1 = document.getElementById('password1').value;
	p2 = document.getElementById('password2').value;
	
	if (p0 == '' || p1 == '' || p2 == '') {
		alert('请输入原密码、新密码、重复新密码');
		return false;
	}
	if (p1 != p2) {
		alert('请保证新密码和重复新密码一致');
		return false;
	}
	document.f1.submit();
}
</script>

</head>
<body>

<form name="f1" method="post" action="user.do?method=changePassword">
<table width="100%" height="24"  border="0" cellpadding="0" cellspacing="0" background="images/index_02.gif">
  <tr>
    <td class="bigtitlebg">&nbsp;&nbsp;&nbsp; &nbsp;<img src="images/icon_05.gif" width="16" height="17"><span class="bigtitle">&nbsp; 外发问卷</span></td>
  </tr>
</table>
<table align="center" style="vertical-align:middle">
<tr>
	<td height="50px">&nbsp;</td>
</tr>
<tr>
	<td>输入原密码：<input type="password" id="password0" name="password0" value=""></td>
</tr>
<tr>
	<td>输入新密码：<input type="password" id="password1" name="password1" value=""></td>
</tr>
<tr>
	<td>重复新密码：<input type="password" id="password2" name="password2" value=""></td>
</tr>
<tr>
	<td align="center"><input type="button" class="btn-01" value="修改密码" onclick="doSubmit()"></td>
</tr>
</table>
</form>

</body>
</html>
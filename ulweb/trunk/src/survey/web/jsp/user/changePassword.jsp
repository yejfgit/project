<%@ page language="java" contentType="text/html; charset=utf-8" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>

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
输入原密码：<input type="password" id="password0" name="password0" value=""><br />
输入新密码：<input type="password" id="password1" name="password1" value=""><br />
重复新密码：<input type="password" id="password2" name="password2" value=""><br />
<input type="button" value="修改密码" onclick="doSubmit()">
</form>

</body>
</html>
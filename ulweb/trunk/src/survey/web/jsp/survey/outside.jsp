<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="struts-bean.tld" prefix="bean" %>
<%@ taglib uri="struts-html.tld" prefix="html" %>
<%@ taglib uri="struts-logic.tld" prefix="logic" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<script>
function doSubmit() {
	var userName = document.getElementById('userName').value;
	var mail = document.getElementById('mail').value;
	if (userName == '' || mail == '' || mail.indexOf('@') == -1) {
		alert('请输入正确的姓名和邮箱');
		return false;
	}
	
	document.f1.submit();
}

</script>

</head>
<body>

<form name="f1" method="post" action="mail.do?method=sendMailOutside">
选择问卷：
						<html:select name="mailForm" property="surveyId">
							<html:optionsCollection name="surveyLabelList" />
						</html:select><br>
姓名：<input type="text" id="userName" name="userName" value="" /><br>
邮箱：<input type="text" id="mail" name="mail" value="" /><br>
<input type="button" value="发送" onclick="doSubmit()" />

</form>

</body>
</html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="struts-bean.tld" prefix="bean" %>
<%@ taglib uri="struts-html.tld" prefix="html" %>
<%@ taglib uri="struts-logic.tld" prefix="logic" %>

<%
String basePath = request.getScheme() + "://" + 
	request.getServerName() + ":" + request.getServerPort() + 
	request.getContextPath() + "/" ;
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
		<link href="css/css.css" rel="stylesheet" type="text/css">
		<script language="javascript" src="js/common.js"></script>
		<script language="javascript" src="js/boxover.js"></script>

<base href="<%=basePath%>" target="_self" />
<script>

var index = 0;

function done(){
		window.showModalDialog("../survey/jsp/survey/done.htm", 
		window, 'dialogWidth:240px;dialogHeight:180px;Resizable:0;help:no;scroll:yes;status:No;center:yes;edge:Raised;');

}

function doSubmit() {
	
	var surveyId = document.getElementById("surveyId").value;
	
	var ret = '';
	for (var i = 1; i <= index; i++) {
		var userName = document.getElementById('userName' + i).value;
		var mail = document.getElementById('mail' + i).value;
		
		if (userName == '' || mail == '') {
			continue;
		}
		if (mail.indexOf('@') == -1) {
			alert('请输入正确的邮箱');
			return false;
		}
		if(userName!=null&&userName!="")
		//alert(userName);

		ret += strEncode(userName) + ',' + mail + ';';
	}

	if (ret == '') {
		alert('请输入需要下发的用户姓名和邮箱');
		return false;
	}
	
	
	document.f1.action = "mail.do?method=sendMailOutside&user="+ret+"&surveyId="+surveyId;
	document.f1.submit();
	
	//location.href = "mail.do?method=sendMailOutside&user="+ret+"&surveyId="+surveyId;
	
	//window.showModalDialog("mail.do?method=sendMailOutside&user="+ret+"&surveyId="+surveyId, 
	//window, 'dialogWidth:240px;dialogHeight:180px;Resizable:0;help:no;scroll:yes;status:No;center:yes;edge:Raised;');
	
}

function doMore() {
	var html = '';
	for (var i = 0; i < 5; i++) {
		index++;
		html += '姓名：<input type="text" id="userName' + index + '" value="" />&nbsp;邮箱：<input type="text" id="mail' + index + '" value="" style="width:200px" /><br>';
	}
	document.getElementById('inputBox').innerHTML += html + '<br>';
	
}

function doCloseAndRefresh(){
		window.close();
}

function strEncode(str) {
	return encodeURI(encodeURI(str));
}

</script>

</head>
<body>

<form name="f1" method="post" action="mail.do?method=sendMailOutside">
  <table align="center" width="80%" height="24"  border="0" cellpadding="0" cellspacing="0">
  <tr>
  	<td height="20px"></td>
  </tr>
  <tr style="font-size: 16px">
    <td style="background-color:#676b6d;color:white;" align="center" height="25px" width="15%"><strong>问卷下发</strong></td>
    <td align="center" width="70%">&nbsp;
    	<strong>问卷名称：<logic:notEmpty name="survey" property="name"><bean:write name="survey" property="name" /></logic:notEmpty></strong>
    </td>
	<td align="center" height="30px" width="15%"></td>
  </tr>
</table>
<input type="hidden" name="user" value="" />
<input type="hidden" name="surveyId" value="<bean:write name="survey" property="id" />" />
<table align="center" width="80%">
<tr><td height="10px"></td></tr>
<tr><td width="20px" ></td></tr>
<tr><td height="20px" width="20px"></td></tr>
<tr><td width="20px"></td><td>						
<div id="inputBox"></div>
</td></tr>
<tr><td width="20px"></td><td>
<div>
<input type="button" style="height: 25px;border: 1px;"  value="更多" onclick="doMore()">
</div></td></tr>
</table>
<br />
<div style="text-align: center;">
<input type="button" style="background-color:#0e9cdf;height: 25px;color: white;border: 1px;"  value="下发问卷" onclick="doSubmit()">
</div>
</form>

<script>

doMore();

</script>


</body>
</html>
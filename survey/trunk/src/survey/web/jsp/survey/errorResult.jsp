<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="struts-bean.tld" prefix="bean" %>
<%@ taglib uri="struts-html.tld" prefix="html" %>
<%@ taglib uri="struts-logic.tld" prefix="logic" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>问卷得分</title>

  

<script>
window.top.document.getElementById('leftTime').innerHTML = '未成功提交！';
function goBack(){
		window.history.back(-1);
		var btnDiv = window.parent.document.getElementById('btns');
        btnDiv.style.display = 'block';
        window.top.document.getElementById('leftTime').innerHTML = '';
        window.parent.frames[0].location.reload();
}
</script>
<style>
.btn-01 {
	height: 25px;
	width: 70px;
	font-size: 14px;
	font-weight: bold;
	font-family: Arial, Helvetica, sans-serif;
	cursor: hand;
}

body {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 14px;
	color: #0D2A4C;
	margin: 0px;
	background-color:#f8f8f0;
}

</style>




</head>

<body>

<form name="f1" method="post" action="">
<table>
  <tr> 
    <td>&nbsp;</td>
  </tr>
  <tr><td height="100px" width="60px"></td>
  <td>

			<table width="100%" height="60" border="0" cellpadding="0"
				cellspacing="0" align="center" background="">
				<tr>
					<td class="bigtitlebg">
                       <strong> 提示信息：</strong><bean:write name="survey" property="tips" filter="false" />
					</td>
				</tr>
				<tr>
				<td class="bigtitlebg">
                      &nbsp;
					</td>
				</tr>
				<tr><td class="bigtitlebg">
                       <strong> <bean:write name="mission" property="errorMsg" /><br>不符合我们的统计要求，请您仔细阅读提示信息后,点击<input class="btn-01" type="button" value="返回问卷" style="background-color:#f8f8f0;color:#555555;" onclick="goBack();">,重新作答提交，谢谢！</strong>
				</td></tr>
			</table>
	</td></tr>
</table>
</form>

</body>
</html>


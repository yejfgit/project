<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="struts-bean.tld" prefix="bean" %>
<%@ taglib uri="struts-html.tld" prefix="html" %>
<%@ taglib uri="struts-logic.tld" prefix="logic" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>回答问卷</title>


<script language="javascript" src="js/ajax.js"></script>

<script type="text/javascript">
parent.document.getElementById("loading").style.display = 'none';
</script>

<style>
body {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 14px;
	color: #0D2A4C;
	margin: 0px;
	background-color:#f8f8f0;
}
</style>


</head>

<body><br><form name="f1" method="post" action="">
<input type="hidden" name="surveyId" id="surveyId" value="<bean:write name="survey" property="id" />">
<input type="hidden" id="answerInfo" name="answerInfo" value="" />
<table>
<tr>
<td colspan="100" valign="top">
<tr>
<td width="50px">&nbsp;</td>
<td>感谢您的参与，已有&nbsp;<strong><bean:write name="fm"/></strong>&nbsp;人参与了此次调查！&nbsp;&nbsp;
</td></tr>
</table>
<br>

<div align="center" id="leftTime"></div>  
<script>  
  
</script> 





<div id="attachmentList"></div>
<script>

loadAttachmentList();

</script>

<br>



<logic:iterate id="e" name="survey" property="questionList">
<br>
<script>optArray[<bean:write name="e" property="seq" />] = 0;</script>
<input type="hidden" id="question<bean:write name="e" property="seq" />" name="question<bean:write name="e" property="seq" />" value="<bean:write name="e" property="id" />" />
<table width="95%">
<td width="20px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td width="90%">
	<logic:notEqual value="4" name="e" property="type" >
	<div>	
题目<bean:write name="e" property="seq" />：<bean:write name="e" property="name" />
<logic:iterate id="e2" name="e" property="optionList">
	<script>++optArray[<bean:write name="e" property="seq" />];</script>
		<div>
		<bean:write name="e2" property="name" />
		<table width="100%">
			<tr>
				<td width="85%">
					<table width="100%" cellspacing="0" cellpadding="0">
						<tr>
							<td style="background-image:url(../survey/images/zhz1.png)" height="12px" width="<bean:write name="e2" property="tdWidth" />%"></td>
							<td align="left"  height="12px">&nbsp;<bean:write name="e2" property="countNum" />人选择,占比<bean:write name="e2" property="percent" />%</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		</div>
	</logic:iterate>

</div>
</logic:notEqual>

<logic:equal value="4" name="e" property="type" >
	<div style="width:100%;background-color: #0e9cdf;font-size: 14px;height: 30px;line-height:30px;color: white ">
	&nbsp;&nbsp;<bean:write name="e" property="name" />
	</div>
</logic:equal>

</td>
</table>
</logic:iterate>

<br>

<br />

</form>

</body>
</html>


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

var optArray = new Array();


function showDialog(url) {
	window.showModalDialog(url,window,'dialogWidth:800px;dialogHeight:300px;Resizable:0;help:no;scroll:yes;status:No;center:yes;edge:Raised;');
}
function doAddAtt() {
	var surveyId = document.getElementById('surveyId').value;
	showDialog('attachment.do?method=add&surveyId=' + surveyId);
	loadAttachmentList();
}

function doDelAtt(id) {
	if (!confirm('确实要删除吗？')) {
		return false;
	}

	showDialog('attachment.do?method=del&id=' + id);
	loadAttachmentList();

}

function loadAttachmentList() {
	tableId = 'attachmentList';
	var surveyId = document.getElementById('surveyId').value;
	send_request('attachment.do?method=list&edit=1&surveyId=' + surveyId);
}

function doSubmit() {
	document.f1.action = 'survey.do?method=adminList';
	document.f1.submit();


}

function doCopy() {
	var surveyId = document.getElementById('surveyId').value;
	location.href = 'survey.do?method=copy&surveyId=' + surveyId;


}


function tag(n, v) {
	return '<' + n + '>' + v + '</' + n + '>';
}

function g(id) {
	return document.getElementById(id);
}

function v(id) {
	return g(id).value;
}


</script>




</head>

<body>
 <table>
  <tr> 
    <td height="" length="100"></td>
    <td colspan="5" valign="top"><img src="../survey/images/logos.jpg"></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr></table>
<form name="f1" method="post" action="">
<input type="hidden" name="surveyId" id="surveyId" value="<bean:write name="survey" property="id" />">
<input type="hidden" id="answerInfo" name="answerInfo" value="" />
<table align="center">
<td height="32" colspan="10" style="color:;font-size:20px;"><strong>问卷名称：<bean:write name="survey" property="name" /></strong></td>
</table>
<table align="center">
<tr>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td height="21">&nbsp;</td>
</tr>
<tr>
<td colspan="100" valign="top"><hr>
时间限制：<bean:write name="survey" property="timeLimit" />分钟&nbsp;&nbsp;
题目顺序：<logic:equal value="1" name="survey" property="isShuffle">随机</logic:equal>
<logic:equal value="0" name="survey" property="isShuffle">正常</logic:equal>
</td>
</tr>
</table>
<br>

<div align="center" id="leftTime"></div>  
<script>  
  
</script> 





<div id="attachmentList"></div>
<script>

loadAttachmentList();

</script>

<input type="button" value="增加附件"  onclick="doAddAtt()" />

<br>



<logic:iterate id="e" name="survey" property="questionList">
<br>
<script>optArray[<bean:write name="e" property="seq" />] = 0;</script>
<input type="hidden" id="question<bean:write name="e" property="seq" />" name="question<bean:write name="e" property="seq" />" value="<bean:write name="e" property="id" />" />
<table>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td><div>
	题目<bean:write name="e" property="seq" />：<bean:write name="e" property="name" />

<logic:iterate id="e2" name="e" property="optionList">
	<script>++optArray[<bean:write name="e" property="seq" />];</script>
		<div>
		&nbsp;&nbsp;
		
		<logic:equal value="1" name="e" property="type">
			<input type="radio" id="optionItem<bean:write name="e" property="seq" />" name="optionItem<bean:write name="e" property="seq" />" value="<bean:write name="e2" property="id" />" />
		</logic:equal>
		<logic:equal value="2" name="e" property="type">
			<input type="checkbox" id="optionItem<bean:write name="e" property="seq" />" name="optionItem<bean:write name="e" property="seq" />" value="<bean:write name="e2" property="id" />" />
		</logic:equal>
		
		<bean:write name="e2" property="name" />
		</div>
	</logic:iterate>

</div></td>
</table>
</logic:iterate>

<br>

<br />

<div align="center"> 
<input type="button" value="复制问卷"  onclick="doCopy()" />

<input type="button" value="返回"  onclick="doSubmit()" /></div>

</form>

</body>
</html>


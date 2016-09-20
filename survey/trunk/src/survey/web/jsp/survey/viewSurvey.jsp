<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="struts-bean.tld" prefix="bean" %>
<%@ taglib uri="struts-html.tld" prefix="html" %>
<%@ taglib uri="struts-logic.tld" prefix="logic" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>回答问卷</title>
		<script language="javascript" src="js/common.js"></script>
		<script language="javascript" src="js/boxover.js"></script>
<link href="css/css.css" rel="stylesheet" type="text/css">
<script language="javascript" src="js/ajax.js"></script>
<style>
　　html { 
　　overflow-y:auto!important; 
　　*overflow-y:scroll; 
　　} 

</style>
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
	var type=document.getElementById("surveyType").value;
	document.f1.action = 'survey.do?method=WJList&type='+type;
	document.f1.submit();


}

function doCopy() {
	var surveyId = document.getElementById('surveyId').value;
	location.href = 'survey.do?method=copy&surveyId=' + surveyId;


}

function doEdit() {
	
	var bUn = "<bean:write name="bUn"/>";
	var num1 = "<bean:write name="unB"/>";
	if(bUn>0||num1>0){
		if (!confirm('修改此问卷需关闭已下发的任务，确实要修改吗？')) {
			return false;
		}
	}
	
	var surveyId = document.getElementById('surveyId').value;
	location.href = 'survey.do?method=edit&surveyId=' + surveyId;


}

function doDelete() {

	if (!confirm('确实要删除吗？')) {
		return false;
	}
	var surveyId = document.getElementById('surveyId').value;
	window.location.href='survey.do?method=delete&surveyId='+surveyId;


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

function findRight(){
	var type = v("surveyType");
	if(type==1){
		var cb = document.getElementsByTagName("input")

		for(i=0;i<cb.length;i++){
			if(cb[i].value==1){
				cb[i].checked=true;
			}
		}
		
	}

}

//查看主观题答案列表
function viewTextAnswer(questionId){
	window.open("survey.do?method=viewTextAnswer&questionId="+questionId);
}

//按钮改变颜色
function overChangeBtn(btn){
	btn.style.backgroundColor="#9bcf00";
}

function outChangeBtn(btn){
	btn.style.backgroundColor="#0e9cdf";
}

//进度条改变颜色
function overChangeTd(btn){
	btn.style.backgroundImage="url(../survey/images/zhz2.png)";
}

function outChangeTd(btn){
	btn.style.backgroundImage="url(../survey/images/zhz1.png)";
}

</script>

<style>
table{
	font-size:14px;
}

.btn{
	background-color:#0e9cdf;
	height: 25px;
	color: white;
	border: 1px;
	border-color: #828282;
}

</style>

</head>

<body onload="findRight()">
<form name="f1" method="post" action="">

<input type="hidden" name="surveyType" id="surveyType" value="<bean:write name="survey" property="type" />">
<input type="hidden" name="surveyId" id="surveyId" value="<bean:write name="survey" property="id" />">
<input type="hidden" id="answerInfo" name="answerInfo" value="" />
<table align="center" width="80%" height="24"  border="0" cellpadding="0" cellspacing="0" style="background-color: white;">
  <tr style="color:#0e9cdf;font-size:14px;vertical-align:bottom;">
  	<td height="30px" ><strong><a href="survey.do?method=WJList&type=<bean:write name="survey" property="type" />" style="color:#0e9cdf;" target="mainFrame">首页</a> >> 查看问卷</strong>&nbsp;&nbsp;</td>
  	<td align="right"><a href="#" style="color: #0e9cdf" onclick="doEdit(); return false;"><img src="../survey/images/newImages/edit.bmp" />修改</a>
	&nbsp;&nbsp;
	<a href="survey.do?method=setSurvey&id=<bean:write name="survey" property="id" />" style="color: #0e9cdf"><img src="../survey/images/newImages/set.bmp" />设置</a>
	&nbsp;&nbsp;
	<a href="survey.do?method=copy&surveyId=<bean:write name="survey" property="id" />" style="color: #0e9cdf"><img src="../survey/images/newImages/copy.bmp" />复制</a>
	&nbsp;&nbsp;
	<a href="#" onclick="doDelete()" style="color: #0e9cdf"><img src="../survey/images/newImages/del.bmp" />删除</a>
	&nbsp;&nbsp;
	
	</td>
  </tr>
  <tr style="font-size: 18px">
	<td height="32" colspan="10" align="center" style="color:;font-size:24px;"><strong>问卷名称：<bean:write name="survey" property="name" /></strong></td>
  </tr>
  <tr>
  	<td height="30px"></td>
  </tr>
</table>

<table width="80%" align="center" style="table-layout:fixed ; word-break: break-all; overflow:hidden;background-color: white; ">
<tr>
	<td width="100%">



<a name="viewResult"></a>
<logic:iterate id="e" name="survey" property="questionList">
<br>
<script>optArray[<bean:write name="e" property="seq" />] = 0;</script>
<input type="hidden" id="question<bean:write name="e" property="seq" />" name="question<bean:write name="e" property="seq" />" value="<bean:write name="e" property="id" />" />
<div>

<logic:equal value="1" name="e" property="type" >
	题目<bean:write name="e" property="seq" />：<bean:write name="e" property="name" />&nbsp;&nbsp;（单选题）&nbsp;&nbsp;
	<logic:equal name="survey" value="1" property="type">（<bean:write name="e" property="score" />分）</logic:equal>
		<logic:iterate id="e2" name="e" property="optionList">
		<script>++optArray[<bean:write name="e" property="seq" />];</script>
		<div>
		<input type="radio" id="optionItem<bean:write name="e" property="seq" />" name="optionItem<bean:write name="e" property="seq" />" value="<bean:write name="e2" property="score" />" />
		<bean:write name="e2" property="name" />&nbsp;&nbsp;&nbsp;&nbsp;<logic:equal name="survey" value="2" property="type">（<bean:write name="e2" property="score" />分）</logic:equal>
		<table width="100%">
			<tr>
				<td width="85%">
					<table width="100%" cellspacing="0" cellpadding="0">
						<tr>
							<td style="background-image:url(../survey/images/zhz1.png)" height="12px" onmouseover="overChangeTd(this)" onmouseout="outChangeTd(this)" width="<bean:write name="e2" property="tdWidth" />%"></td>
							<td align="left"  height="12px">&nbsp;<bean:write name="e2" property="countNum" />人选择,占比<bean:write name="e2" property="percent" />%</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		</div>
		</logic:iterate>
		<hr>
</logic:equal>

<logic:equal value="2" name="e" property="type" >
	题目<bean:write name="e" property="seq" />：<bean:write name="e" property="name" />&nbsp;&nbsp;（多选题<logic:notEqual value="0" name="e" property="maxCheck">，最多选择<bean:write name="e" property="maxCheck" />个选项</logic:notEqual><logic:notEqual value="0" name="e" property="maxCheck">，最少选择<bean:write name="e" property="minCheck" />个选项</logic:notEqual>）&nbsp;&nbsp;
	<logic:equal name="survey" value="1" property="type">（<bean:write name="e" property="score" />分）</logic:equal>
		<logic:iterate id="e2" name="e" property="optionList">
		<script>++optArray[<bean:write name="e" property="seq" />];</script>
		<div>
		<input type="checkbox" id="optionItem<bean:write name="e" property="seq" />" name="optionItem<bean:write name="e" property="seq" />" value="<bean:write name="e2" property="score" />" />
		<bean:write name="e2" property="name" />&nbsp;&nbsp;&nbsp;&nbsp;<logic:equal name="survey" value="2" property="type">（<bean:write name="e2" property="score" />分）</logic:equal>
		<table width="100%">
			<tr>
				<td width="85%">
					<table width="100%" cellspacing="0" cellpadding="0">
						<tr>
							<td style="background-image:url(../survey/images/zhz1.png)" height="12px" onmouseover="overChangeTd(this)" onmouseout="outChangeTd(this)" width="<bean:write name="e2" property="tdWidth" />%"><br></td>
							<td align="left"  height="12px">&nbsp;<bean:write name="e2" property="countNum" />人选择,占比<bean:write name="e2" property="percent" />%</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		</div>
		</logic:iterate>
		<hr>
</logic:equal>

<logic:equal value="3" name="e" property="type" >
	题目<bean:write name="e" property="seq" />：<bean:write name="e" property="name" />&nbsp;&nbsp;（问答题）&nbsp;&nbsp;
	<logic:equal name="survey" value="1" property="type">（<bean:write name="e" property="score" />分）</logic:equal>
		<div>
		</br>
		&nbsp;&nbsp;
		<a href="javascript:void(0)" style="color: #0e9cdf" onclick="viewTextAnswer(<bean:write name="e" property="id" />)"><img src="../survey/images/newImages/textView.bmp" />查看答案和评分</a>
		</div>
		<hr>
</logic:equal>

<logic:equal value="4" name="e" property="type" >
	<div style="width:100%;background-color: #c1eb80;font-size: 14px;height: 25px;line-height:30px;color: black ">
	<bean:write name="e" property="name" />&nbsp;&nbsp;	
	</div>
</logic:equal>

</div>
</logic:iterate>


<table width="100%" align="center">
<tr>
	<td height="30px">
		&nbsp;
	</td>
</tr>
<tr>
<td colspan="100" valign="top">
<strong>问卷类型：</strong><logic:equal value="1" name="survey" property="type">考试&nbsp;&nbsp;</logic:equal>
<logic:equal value="2" name="survey" property="type">调查 &nbsp;</logic:equal>
<strong>时间限制：</strong><bean:write name="survey" property="timeLimit" />分钟&nbsp;&nbsp;
<logic:equal value="2" name="survey" property="type">
<strong>问卷最高分：</strong><bean:write name="survey" property="maxScore" />&nbsp;&nbsp;
<strong>问卷最低分：</strong><bean:write name="survey" property="minScore" />&nbsp;&nbsp;
</logic:equal>
<logic:equal value="1" name="survey" property="type">
<strong>卷面总分：</strong><bean:write name="survey" property="surveyScore" />分&nbsp;&nbsp;
</logic:equal>

<strong>结果密级：</strong><logic:equal value="0" name="survey" property="isOpen">公开</logic:equal>
<logic:equal value="1" name="survey" property="isOpen">保密</logic:equal>&nbsp;&nbsp;
<br><strong>自动关闭未完成问卷：</strong><bean:write name="survey" property="hurryTimes" />天&nbsp;(在指定天数内，系统将每天对未完成问卷用户进行邮件提示。逾期将自动关闭未完成问卷。)
</td>
</tr>
<tr>
<td>&nbsp;</td>
</tr>
<tr><td colspan="100" width="95%"valign="top" ><strong>卷面提示信息：</strong></td></tr>
<tr>
<td>&nbsp;</td>
</tr>
<tr><td bgcolor="#EFF6FB" ><bean:write name="survey" property="tips" filter="false" /></td></tr>
<tr>
<td>&nbsp;</td>
</tr>
<tr><td colspan="100" width="95%" valign="top"><strong>邮件提示信息：</strong></td></tr>
<tr>
<td>&nbsp;</td>
</tr>
<tr><td bgcolor="#EFF6FB" ><bean:write name="survey" property="mailTips" filter="false" /></td></tr>
<tr>
<td>&nbsp;</td>
</tr>
<tr><td colspan="100" width="95%" valign="top"><strong>邮件催办问卷信息：</strong></td></tr>
<tr>
<td>&nbsp;</td>
</tr>
<tr><td bgcolor="#EFF6FB" ><bean:write name="survey" property="hurryTips" filter="false" /></td></tr>
<tr>
<td>&nbsp;</td>
</tr>
<tr><td colspan="100" width="95%" valign="top"><strong>邮件关闭问卷信息：</strong></td></tr>
<tr>
<td>&nbsp;</td>
</tr>
<tr><td bgcolor="#EFF6FB" ><bean:write name="survey" property="closeTips" filter="false" /></td></tr>
<tr>
<td>&nbsp;</td>
</tr>
<tr>
<td>
<div id="attachmentList"></div>
<script>

loadAttachmentList();

</script>

<input type="button" style=" vertical-align:middle;background-color: white;" value="卷面增加附件"  onclick="doAddAtt()" />

<br>
</td>
</tr>
</table>
<div align="center"> 
	<button type="button" id="a" onclick="doSubmit()" onmouseover="overChangeBtn(this)" onmouseout="outChangeBtn(this)" class="btn">返回</button>
</div>
</td>
</tr>
</table>
</form>
</body>
</html>


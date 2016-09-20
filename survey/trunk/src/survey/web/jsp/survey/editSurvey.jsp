<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="struts-bean.tld" prefix="bean" %>
<%@ taglib uri="struts-html.tld" prefix="html" %>
<%@ taglib uri="struts-logic.tld" prefix="logic" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改问卷</title>




<script type="text/javascript">

queCount = 0;
optArray = new Array();

function addItem() {


}


function addQue() {
	++queCount;
	optArray[queCount] = 0;
	
	var queDivHtml = '<div id="queDiv' + queCount + '"><br>题目：<input type="text" id="queName' + queCount + '" />&nbsp;类型：<input type="checkbox" id="queType' + queCount + '" />&nbsp;&nbsp;<input type="button" value="增加选项" onclick="addOpt(' + queCount + ')" />&nbsp;<input type="button" value="X" onclick="delQue(' + queCount + ')" /></div>';
	
	g("queBox").innerHTML += queDivHtml;


}

function delQue(queDivSeq) {
	g("queBox").removeChild(g("queDiv" + queDivSeq));
}


function addOpt(queDivSeq) {
	optCount = ++optArray[queDivSeq];
	
	optDivHtml = '<div id="optDiv' + queDivSeq + '-' + optCount + '">&nbsp;&nbsp;选项：<input type="text" id="optName' + optCount + '" />&nbsp;分值：<input type="text" id="optScore' + optCount + '" size="5" value="0" />&nbsp;<input type="button" value="x" onclick="delOpt(' + queDivSeq + ', ' + optCount + ')" /></div>';
	
	g("queDiv" + queDivSeq).innerHTML += optDivHtml;

}

function delOpt(queDivSeq, optDivSeq) {
	g("queDiv" + queDivSeq).removeChild(g("optDiv" + queDivSeq + "-" + optDivSeq));
}

function test() {
	alert(g("queBox").innerHTML);
}

function doSubmit1() {

	if (v("surveyName") == '') {
		alert('请输入问卷的名称');
		return false;
	}


	qb = '<survey>'
	qb += '<name>' + v("surveyName") + '</name>';
	qb += '<owner>' + v("ownerId") + '</owner>';
	for (q = 1; q <= queCount; q++) {
		if (g("queDiv" + q) == undefined) continue;
	
		qn = tag('name', v("queName" + q));
		if (g("queType" + q).checked) {
			t = 2;
		} else {
			t = 1;
		}
		qt = tag('type', t);
		ob = '';
		for (o = 1; o <= optArray[q]; o++) {
			if (g("optDiv" + q + "-" + o) == undefined) continue;
	
			on = tag('name', v("optName" + o));
			os = tag('score', v("optScore" + o));
			ob += tag('option', on + os);
	
		}
		qb += tag('question', qn + qt + ob);
	}
	qb += '</survey>';
	
	if (!confirm(qb)) {
		return false;
	}
	
	g("surveyInfo").value = qb;
	
	document.f1.action = 'survey.do?method=save';
	document.f1.submit();

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

function doSubmit(){
	document.f1.action = 'survey.do?method=update';
	document.f1.submit();
}

</script>




</head>

<body>

<form name="f1" method="post" action="">


<input type="hidden" id="answerInfo" name="answerInfo" value="" />

问卷名称：<input id="surveyName" name="surveyName" type="text" 
							 value="<bean:write name="survey" property="name" />">
<br>

<logic:iterate id="e" name="survey" property="questionList">
<br>
<script>optArray[<bean:write name="e" property="seq" />] = 0;</script>
<input type="hidden" id="question<bean:write name="e" property="seq" />" name="question<bean:write name="e" property="seq" />" value="<bean:write name="e" property="id" />" />
<div>
	题目:<bean:write name="e" property="seq" />：<input id="surveyName" name="survey.name" type="text" class="input1"
							style="" value="<bean:write name="e" property="name" />">

</div>
</logic:iterate>

<br>
<input type="button" value="提交修改" onclick="doSubmit()" />

</form>

</body>
</html>


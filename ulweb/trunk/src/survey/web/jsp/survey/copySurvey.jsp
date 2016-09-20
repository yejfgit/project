<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="struts-bean.tld" prefix="bean" %>
<%@ taglib uri="struts-html.tld" prefix="html" %>
<%@ taglib uri="struts-logic.tld" prefix="logic" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>创建问卷</title>
		<link href="../survey/css/css.css" rel="stylesheet" type="text/css">



<script>

queCount = 0;
optArray = new Array();

function addItem() {


}


function addQue() {
	++queCount;
	optArray[queCount] = 0;
	
	var queDivHtml = '<div id="queDiv' + queCount + '"><br>题目' + queCount + '：<input type="text"  style="width:400px" id="queName' + queCount + '" />&nbsp;<input type="checkbox" id="queType' + queCount + '" />不定项&nbsp;&nbsp;<input type="button" value="增加选项" onclick="addOpt(' + queCount + ')" />&nbsp;<input type="button" value="X" onclick="delQue(' + queCount + ')" /></div>';
	
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


function doSubmit() {

	if (v("surveyName") == '') {
		alert('请输入问卷的名称');
		return false;
	}


	qb = '<survey>'
	qb += '<name>' + v("surveyName") + '</name>';
	qb += '<owner>' + v("ownerId") + '</owner>';
	qb += '<time>' + v("timeLimit") + '</time>';
	if (g("isShuffle").checked) {
			sf = 1;
		} else {
			sf = 0;
		}
	qb += '<shuffle>' + sf + '</shuffle>';
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
	
	if (!confirm('确定创建此问卷吗？')) {
		return false;
	}
	
	g("surveyInfo").value = qb;
	
	//alert(qb);
	
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
</script>




</head>

<body>
 <table>
  <tr> 
    <td colspan="5" valign="top"><img src="../survey/images/logos1.jpg"></td>
    <td>&nbsp;</td>
  </tr></table>
  <hr width="100%" size="2">

<form name="f1" method="post" action="">

<input type="hidden" id="ownerId" name="ownerId" value="<bean:write name="ownerId" />" />
<input type="hidden" id="surveyInfo" name="surveyInfo" value="" />
			<table width="100%" height="60" border="0" cellpadding="0"
				cellspacing="0" background="">
				<tr>
						<td width="98%" nowrap class="font14pxblod"
												style="font-weight: normal;">
						<strong>创建问卷：</strong>
					</td>
				</tr>
			</table>

<table align="center">
<tr>
<td align="center">问卷名称：<input type="text" id="surveyName" name="surveyName" value="" />&nbsp;&nbsp;
时间限制：<input type="text" id="timeLimit" name="timeLimit" size="5" value="<bean:write name="survey" property="timeLimit" />" />分钟&nbsp;&nbsp;

<logic:equal value="1" name="survey" property="isShuffle"><input type="checkbox" id="isShuffle" name="isShuffle" checked="checked" /></logic:equal>
<logic:equal value="0" name="survey" property="isShuffle"><input type="checkbox" id="isShuffle" name="isShuffle" /></logic:equal>
随机题目顺序<br />

</td>
</tr>
</table>
<br>
<tr>
题目名称：<input type="button" value="增加题目" onclick="addQue()" />(勾选类型后，题目变为不定项选择题)
</tr>
<div id="queBox"></div>


<table align="center">
<tr><td>&nbsp;</td></tr>
<tr><td>&nbsp;</td></tr>
<tr><td>&nbsp;</td></tr>
<tr><td>&nbsp;</td></tr>
<tr><td><input type="button" value="创建问卷" onclick="doSubmit()" /></td></tr></table>


</form>


<script type="text/javascript">

<logic:iterate id="e" name="survey" property="questionList">
	
	addQue();
	g('queName' + queCount).value = '<bean:write name="e" property="name" />';

	<logic:iterate id="e2" name="e" property="optionList">
		addOpt(queCount);
		//alert(g('optDiv' + queCount + '-' + optArray[queCount]).getElementsByTagName('input')[0].value);
		g('optDiv' + queCount + '-' + optArray[queCount]).getElementsByTagName('input')[0].value = '<bean:write name="e2" property="name" />';
		g('optDiv' + queCount + '-' + optArray[queCount]).getElementsByTagName('input')[1].value = '<bean:write name="e2" property="score" />';
	</logic:iterate>

</logic:iterate>

</script>



</body>
</html>


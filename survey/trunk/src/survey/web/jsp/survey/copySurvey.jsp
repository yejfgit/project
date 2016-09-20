<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="struts-bean.tld" prefix="bean" %>
<%@ taglib uri="struts-html.tld" prefix="html" %>
<%@ taglib uri="struts-logic.tld" prefix="logic" %>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>创建问卷</title>
		<link href="../survey/css/css.css" rel="stylesheet" type="text/css">
			<script type="text/javascript" src="editor/fckeditor/fckeditor.js"></script>


<script>

queCount = 0;
optArray = new Array();

var optArray = new Array();

function showDialog(url) {
	window.showModalDialog(url,window,'dialogWidth:800px;dialogHeight:300px;Resizable:0;help:no;scroll:yes;status:No;center:yes;edge:Raised;');
}
function doAddAtt() {
	var surveyId = document.getElementById('surveyId').value;
	showDialog('attachment.do?method=add&surveyId=' + surveyId);
}

function doDelAtt(id) {
	if (!confirm('确实要删除吗？')) {
		return false;
	}

	showDialog('attachment.do?method=del&id=' + id);
	loadAttachmentList();

}

function addQue() {
	++queCount;
	optArray[queCount] = 0;
	
	var queDivHtml = '<div id="queDiv' + queCount + '"><br>题目' + queCount + '：<input type="text"  style="width:400px" id="queName' + queCount + '" />&nbsp;题目分数：<input type="text" style="width:20px" id="queScore' + queCount + '" value="0"/>&nbsp;<input type="checkbox" id="queType' + queCount + '"/>不定项&nbsp;&nbsp;<input type="button" value="增加选项" onclick="addOpt(' + queCount + ')" />&nbsp;<input type="button" value="X" onclick="delQue(' + queCount + ')" /></div>';
	
	g("queBox").innerHTML += queDivHtml;


}

function delQue(queDivSeq) {
	g("queBox").removeChild(g("queDiv" + queDivSeq));
}


function addOpt(queDivSeq) {
	optCount = ++optArray[queDivSeq];
	
	optDivHtml = '<div id="optDiv' + queDivSeq + '-' + optCount + '">&nbsp;&nbsp;选项：<input type="text" id="optName' + queDivSeq + '-' + optCount + '" />&nbsp;分值：<input type="text" id="optScore' + queDivSeq + '-' + optCount + '" size="5" value="0" />&nbsp;<input type="button" value="x" onclick="delOpt(' + queDivSeq + ', ' + optCount + ')" /></div>';
	
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
	
	var t = document.getElementById("selectType"); 
	

	qb = '<survey>'
	qb += '<name>' + v("surveyName") + '</name>';
	qb += '<owner>' + v("ownerId") + '</owner>';
	qb += '<time>' + v("timeLimit") + '</time>';
	qb += '<minScore>' + v("minScore") + '</minScore>';
	qb += '<maxScore>' + v("maxScore") + '</maxScore>';
	qb += '<type>' + t.options[t.selectedIndex].value + '</type>';
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
	
			on = tag('name', v("optName" + q + "-" + o));
			os = tag('score', v("optScore" + q + "-" + o));
			ob += tag('option', on + os);
	
		}
		qs = tag('queScore', v("queScore" + q));
		qb += tag('question', qn + qt + qs + ob);
	}
	qb += '</survey>';
	
	//alert(qb);
	
	if (!confirm('确定创建此问卷吗？')) {
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
</script>

<style>
　　html { 
　　overflow-y:auto!important; 
　　*overflow-y:scroll; 
　　} 

</style>


</head>

<body>
<form name="f1" method="post" action="">

<input type="hidden" id="ownerId" name="ownerId" value="<bean:write name="ownerId" />" />
<input type="hidden" id="surveyInfo" name="surveyInfo" value="" />
<table width="100%" height="24"  border="0" cellpadding="0" cellspacing="0" background="images/index_02.gif">
  <tr>
    <td class="bigtitlebg">&nbsp;&nbsp;&nbsp;&nbsp;<img src="images/icon_05.gif" width="16" height="17"><span class="bigtitle">&nbsp; 创建问卷</span></td>
  </tr>
</table>
<table align="center">
<tr><td><strong>常规设置:</strong></td></tr>
<tr>
<td align="center">问卷名称：<input type="text" id="surveyName" name="surveyName" value="" />&nbsp;&nbsp;
问卷类型：<select id="selectType">
  <option value ="1">考试</option>
  <option value ="2">调查</option>
</select>
</td>
</tr>
<tr>
<td>问卷提示信息：		<script type="text/javascript">
			
			var t = '<bean:write name="survey" property="tips" filter="false"/>';
			var oFCKeditor = new FCKeditor( 'tips' ) ;
			oFCKeditor.BasePath	= "<%=basePath%>editor/fckeditor/" ;
			oFCKeditor.Height	= 200 ;
			oFCKeditor.Value	= t;
			oFCKeditor.Create() ;
		</script></td>
</tr>
<tr><td>邮件提示信息：
			<script type="text/javascript">
			var oFCKeditor = new FCKeditor( 'mailTips' ) ;
			oFCKeditor.BasePath	= "<%=basePath%>editor/fckeditor/" ;
			oFCKeditor.Height	= 200 ;
			oFCKeditor.Value	= '<bean:write name="survey" property="mailTips" filter="false"/>';
			oFCKeditor.Create() ;
		</script>
</td>

</tr>

<tr><td>
<strong>高级设置：（0为不限）</strong>
</td></tr>
<tr><td>时间限制：<input type="text" id="timeLimit" name="timeLimit" size="5" value="<bean:write name="survey" property="timeLimit" />" />分钟&nbsp;&nbsp;
<logic:equal value="1" name="survey" property="isShuffle"><input type="checkbox" id="isShuffle" name="isShuffle" checked="checked" /></logic:equal>
<logic:equal value="0" name="survey" property="isShuffle"><input type="checkbox" id="isShuffle" name="isShuffle" /></logic:equal>
随机题目顺序&nbsp;&nbsp;
问卷最高分数：<input type="text" id="minScore" name="maxScore" size="5" value="<bean:write name="survey" property="maxScore"/>" />&nbsp;&nbsp;
问卷最低分数：<input type="text" id="maxScore" name="minScore" size="5" value="<bean:write name="survey" property="minScore"/>" />&nbsp;&nbsp;
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
	g('queScore' + queCount).value = '<bean:write name="e" property="score" />';
	
	<logic:iterate id="e2" name="e" property="optionList">
		addOpt(queCount);
		//alert(g('optDiv' + queCount + '-' + optArray[queCount]).getElementsByTagName('input')[0].value);
		g('optName' + queCount + '-' + optArray[queCount]).value = '<bean:write name="e2" property="name" />';
		g('optScore' + queCount + '-' + optArray[queCount]).value = '<bean:write name="e2" property="score" />';
	</logic:iterate>

</logic:iterate>

</script>



</body>
</html>


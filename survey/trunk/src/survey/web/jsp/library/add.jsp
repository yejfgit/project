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
<title>创建题库</title>
		<link href="../survey/css/css.css" rel="stylesheet" type="text/css">
			<script type="text/javascript" src="editor/fckeditor/fckeditor.js"></script>
			<script language="javascript" src="js/jquery-1.7.1.min.js"></script>



<script>
$(document).ready(function(){
$(".cdiv").click(function(){
    $(".allTips").slideToggle("slow");
  });
});

queCount = 0;
queSeq = 0;
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
	
	var queDivHtml = '<div id="queDiv' + queCount + '" style="display:inline;" nowrap><br>&nbsp;&nbsp;&nbsp;&nbsp;题目' + queCount + '：<input type="text"  style="width:400px" id="queName' + queCount + '" />&nbsp;&nbsp;<input type="checkbox" onclick="choose('+queCount+')" id="queType' + queCount + '" value="1" />不定项&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="增加选项" onclick="addOpt(' + queCount + ')" />&nbsp;<input type="button" value="X" onclick="delQue(' + queCount + ')" /></div>'+
	'<div id="queLim' + queCount + '" style="display:none">最大选择数：<input type="text" style="width:10px;" id="maxCheck' + queCount + '" name="maxCheck' + queCount + '" value="0">&nbsp;最小选择数：<input type="text" style="width:10px;" id="minCheck' + queCount + '" value="0"></div>';
	
	g("queBox").innerHTML += queDivHtml;
	
	for(var i=0;i<4;i++){
		addOpt(queCount);
	}

}

function addBDXQue() {
	++queCount;
	++queSeq
	optArray[queCount] = 0;
	
	var queDivHtml = '<div id="queDiv' + queCount + '" nowrap class="queDivCol" ><br>&nbsp;&nbsp;&nbsp;&nbsp;<strong>题目' + queSeq + '：</strong><input type="text"  style="width:580px" id="queName' + queCount + '" />&nbsp;&nbsp;<input type="hidden" id="queType' + queCount + '" value="2" />（多选题）&nbsp;&nbsp;&nbsp;&nbsp;分类：<input type="text" style="width:50px;" id="category' + queCount + '" name="category' + queCount + '" value="">&nbsp;&nbsp;&nbsp;&nbsp;'+
		'<button type="button" id="a" onclick="addOpt(' + queCount + ')" style=" vertical-align:top;background-color: white;"><img src="images/newImages/survey_img/add.gif" width="16" height="16" style="vertical-align:top" />增加选项</button>&nbsp;'+
		'<input type="button" value=" x " style="background-color: white;" onclick="delQue(' + queCount + ')" /></div>';

	
	g("queBox").innerHTML += queDivHtml;
	
	for(var i=0;i<4;i++){
		addOpt(queCount);
	}

}

function addDXQue() {
	++queCount;
	++queSeq
	optArray[queCount] = 0;
	
	var queDivHtml = '<div id="queDiv' + queCount + '" nowrap class="queDivCol"><br>&nbsp;&nbsp;&nbsp;&nbsp;<strong>题目' + queSeq + '：</strong><input type="text"  style="width:580px" id="queName' + queCount + '" />&nbsp;&nbsp;<input type="hidden" id="queType' + queCount + '" value="1" /> （单选题）&nbsp;&nbsp;&nbsp;&nbsp;分类：<input type="text" style="width:50px;" id="category' + queCount + '" name="category' + queCount + '" value="">&nbsp;&nbsp;&nbsp;&nbsp;'+
	'<button type="button" id="a" onclick="addOpt(' + queCount + ')" style=" vertical-align:top;background-color: white;"><img src="images/newImages/survey_img/add.gif" width="16" height="16" style="vertical-align:top" />增加选项</button>&nbsp;'+
	'<input type="button" value=" x " style="background-color: white;" onclick="delQue(' + queCount + ')" /></div></div>';
	g("queBox").innerHTML += queDivHtml;
	
	for(var i=0;i<4;i++){
		addOpt(queCount);
	}

}

function addWDQue() {
	++queCount;
	++queSeq
	var queDivHtml = '<div id="queDiv' + queCount + '" vertical-align="bottom" nowrap class="queDivCol"><br>&nbsp;&nbsp;&nbsp;&nbsp;<strong>题目' + queSeq + '：</strong><textarea rows="4" cols="50"  style="width:690px;vertical-align:bottom" id="queName' + queCount + '" >新建问答题</textarea>&nbsp;&nbsp;<input type="hidden" id="queType' + queCount + '" value="3" />（问答题）&nbsp;&nbsp;分类：<input type="text" style="width:50px;" id="category' + queCount + '" name="category' + queCount + '" value="">&nbsp;&nbsp;&nbsp;&nbsp;'+
	'<input type="button" value=" x " style="background-color: white;" onclick="delQue(' + queCount + ')" /></br></div>';

	g("queBox").innerHTML += queDivHtml;
	
}

function delQue(queDivSeq) {
	g("queBox").removeChild(g("queDiv" + queDivSeq));
}

function delFgx(fgxDivSeq) {
	g("queBox").removeChild(g("fgxDiv" + fgxDivSeq));
}

function addOpt(queDivSeq) {
	optCount = ++optArray[queDivSeq];
	
	optDivHtml = '<div id="optDiv' + queDivSeq + '-' + optCount + '" style="width:850px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;选项：<input type="text" style="width:300px;" id="optName' + queDivSeq + '-' + optCount + '" />&nbsp;<input type="button" value=" x " style="background-color: white;" onclick="delOpt(' + queDivSeq + ', ' + optCount + ')" /></div>';
	
	g("queDiv" + queDivSeq).innerHTML += optDivHtml;

}

function delOpt(queDivSeq, optDivSeq) {
	g("queDiv" + queDivSeq).removeChild(g("optDiv" + queDivSeq + "-" + optDivSeq));
}


function doSubmit() {

	if (v("libraryName") == '') {
		alert('请输入题库的名称');
		return false;
	}

	var t = document.getElementById("selectType"); 
	
	qb = '<library>'
	qb += '<name>' + v("libraryName") + '</name>';
	qb += '<owner>' + v("ownerId") + '</owner>';
	
	for (q = 1; q <= queCount; q++) {
		if (g("queDiv" + q) == undefined) continue;
		qn = tag('name', v("queName" + q));
		t = g("queType" + q).value;
		qt = tag('type', t);
		ob = '';
		
		for (o = 1; o <= optArray[q]; o++) {
			if (g("optDiv" + q + "-" + o) == undefined) continue;
			on = tag('name', v("optName" + q + "-" + o));
			ob += tag('option', on);

		}
		//alert(q);
		qc = tag('category', v("category" + q));
		qb += tag('question', qn + ob + qt + qc);
	}
	qb += '</library>';
	
	alert(qb);
	
	if (!confirm('确定创建此题库吗？')) {
		return false;
	}
	
	var isJumpSet=1;
	/**
	var isJumpSet;
	if (!confirm('您的问卷已经保存成功！请问是否立刻进行详细设置完善问卷？')) {
		isJumpSet=0;
	}else{
		isJumpSet=1;
	}*/
	
	g("surveyInfo").value = qb;

	document.f1.action = 'library.do?method=save&isJumpSet='+isJumpSet;
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


//按钮改变颜色
function overChangeBtn(btn){
	btn.style.backgroundColor="#9bcf00";
}

function outChangeBtn(btn){
	btn.style.backgroundColor="#0e9cdf";
}
</script>
<style>
.bque{
	font-size:14px;
}
.allTips{
	display:none;
	
}

.queDivCol{
	background-color:#EFF6FB;
	display:inline;
	width：1100px;
	
}

.btn{
	background-color:#0e9cdf;
	height: 25px;
	color: white;
	border: 1px;
	border-color: #828282;
}

html{ 
　　overflow-y:auto!important; 
　　*overflow-y:scroll; 
	overflow-x:auto!important; 
　　*overflow-x:scroll; 
　　} 

</style>



</head>

<body>
<form name="f1" method="post" action="">

<input type="hidden" id="ownerId" name="ownerId" value="<bean:write name="ownerId" />" />
<input type="hidden" id="surveyInfo" name="surveyInfo" value="" />
<table align="center" width="80%" height="24"  border="0" cellpadding="0" cellspacing="0">
  <tr>
  	<td height="30px" style="color:#0e9cdf;font-size:14px;vertical-align:bottom;"><strong><strong><a href="library.do?method=list" style="color:#0e9cdf;" target="mainFrame">首页</a> >> 新建题库</strong></td>
  </tr>
  <tr>
	<td align="center" style="font-size:14px;"><strong>题库名称：</strong><input type="text" style="width:300px;font-size: 14px;" id="libraryName" name="libraryName" />&nbsp;&nbsp;
		<span style="color: red">*</span>
    </td>
  </tr>
</table>

<table align="center" width="80%">
	<tr>
		<td>
		<div id="queBox"></div>
		</td>
	</tr>
</table>
<table align="center" width="1000px">
<tr><td>&nbsp;</td></tr>
<tr><td>&nbsp;</td></tr>
<tr><td>&nbsp;</td></tr>
<tr>

	<td align="center" bgcolor="#cccccc" height="30px">
	<button type="button" id="a" onclick="addDXQue()" style=" vertical-align:middle;background-color: white;"><img src="images/newImages/survey_img/danxuan.gif" width="16" height="16" style="vertical-align:middle" /> 单选题</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<button type="button" id="a" onclick="addBDXQue()" style=" vertical-align:middle;background-color: white;"><img src="images/newImages/survey_img/duoxuan.gif" width="16" height="16" style="vertical-align:middle" /> 多选题</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<button type="button" id="a" onclick="addWDQue()" style=" vertical-align:middle;background-color: white;"><img src="images/newImages/survey_img/wenda.gif" width="16" height="16" style="vertical-align:middle" /> 问答题</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</td></tr>
<tr>
	<td  height="50px" align="center">
	<button type="button" id="a" onclick="doSubmit()" class="btn" onmouseover="overChangeBtn(this)" onmouseout="outChangeBtn(this)"><img src="images/newImages/survey_img/save.bmp" width="16" height="16" style="vertical-align:middle" /> 创建题库</button>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<button type="button" id="a" onclick="history.go(-1);" class="btn" onmouseover="overChangeBtn(this)" onmouseout="outChangeBtn(this)">返回</button>
	</td>
</tr>
</table>

</form>

</body>
</html>


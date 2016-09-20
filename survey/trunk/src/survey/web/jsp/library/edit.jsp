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
<title>修改题库</title>
		<link href="../survey/css/css.css" rel="stylesheet" type="text/css">
			<script type="text/javascript" src="editor/fckeditor/fckeditor.js"></script>
			<script language="javascript" src="js/jquery-1.7.1.min.js"></script>
			<script language="javascript" src="js/page.js"></script>

<script>

queCount = 1;
queSeq = 0;
optArray = new Array();

var optArray = new Array();

function addBDXQue() {
	++queCount;
	++queSeq
	optArray[queCount] = 0;
	
	var queDivHtml = '<div id="queDiv' + queCount + '" nowrap class="queDivCol" ><br>&nbsp;&nbsp;&nbsp;&nbsp;<strong>题目' + queSeq + '：</strong><input type="text"  style="width:580px" id="queName' + queCount + '" />&nbsp;&nbsp;<input type="hidden" id="queType' + queCount + '" value="2" />（多选题）&nbsp;&nbsp;&nbsp;&nbsp;分类：<input type="text" style="width:50px;" id="category' + queCount + '" name="category' + queCount + '" value="">&nbsp;&nbsp;&nbsp;&nbsp;'+
		'<button type="button" id="a" onclick="addOpt(' + queCount + ')" style=" vertical-align:top;background-color: white;"><img src="images/newImages/survey_img/add.gif" width="16" height="16" style="vertical-align:top" />增加选项</button>&nbsp;'+
		'<input type="button" value=" x " style="background-color: white;" onclick="delQue(' + queCount + ')" /></div>';

	
	g("queBox").innerHTML += queDivHtml;
	
}

function addDXQue() {
	++queCount;
	++queSeq
	optArray[queCount] = 0;
	
	var queDivHtml = '<div id="queDiv' + queCount + '" nowrap class="queDivCol"><br>&nbsp;&nbsp;&nbsp;&nbsp;<strong>题目' + queSeq + '：</strong><input type="text"  style="width:580px" id="queName' + queCount + '" />&nbsp;&nbsp;<input type="hidden" id="queType' + queCount + '" value="1" /> （单选题）&nbsp;&nbsp;&nbsp;&nbsp;分类：<input type="text" style="width:50px;" id="category' + queCount + '" name="category' + queCount + '" value="">&nbsp;&nbsp;&nbsp;&nbsp;'+
	'<button type="button" id="a" onclick="addOpt(' + queCount + ')" style=" vertical-align:top;background-color: white;"><img src="images/newImages/survey_img/add.gif" width="16" height="16" style="vertical-align:top" />增加选项</button>&nbsp;&nbsp;'+
	'<input type="button" value=" x " style="background-color: white;" onclick="delQue(' + queCount + ')" /></div></div>';
	g("queBox").innerHTML += queDivHtml;
	

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


function addOpt(queDivSeq) {
	optCount = ++optArray[queDivSeq];
	
	optDivHtml = '<div id="optDiv' + queDivSeq + '-' + optCount + '" style="width:850px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;选项：<input type="text" style="width:300px;" id="optName' + queDivSeq + '-' + optCount + '" />&nbsp;&nbsp;<input type="button" value=" x " style="background-color: white;" onclick="delOpt(' + queDivSeq + ', ' + optCount + ')" /></div>';
	
	g("queDiv" + queDivSeq).innerHTML += optDivHtml;

}

function delOpt(queDivSeq, optDivSeq) {
	g("queDiv" + queDivSeq).removeChild(g("optDiv" + queDivSeq + "-" + optDivSeq));
}


function doSubmit(pageNum) {

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
		qc = tag('category', v("category" + q));
		qb += tag('question', qn + qt + ob + qc);
	}
	qb += '</library>';
	
	//alert(qb);
	
	if (!confirm('确定修改此题库吗？')) {
		return false;
	}
	
	g("surveyInfo").value = qb;
	
	var lid = v("libraryId");
	var queIds = document.getElementById('queIds').value;
	var seq = document.getElementById('firstSeq').value;

	document.f1.action = 'library.do?method=update&pageNum='+pageNum+'&libraryId='+lid+'&queIds='+queIds+'&seq='+seq;
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

function choose(id){
	var a = "queLim"+id;
	var b =  document.getElementById(a).style.display;
	if(b=="none"){
		document.getElementById(a).style.display="block";
	}else{
		document.getElementById(a).style.display="none";
		//清空Div内所有value
		document.getElementById("maxCheck"+id).value=0;
		document.getElementById("minCheck"+id).value=0
	}

}

//检查特殊设置
function checkSpecial(){
	var isShuffle = document.getElementById("isShuffle");
	var isOpen = document.getElementById("isOpen");
	
	if(isShuffle.value==1){
		isShuffle.checked=true;
	}
	if(isOpen.value==1){
		isOpen.checked=true;
	}

}

//按钮改变颜色
function overChangeBtn(btn){
	btn.style.backgroundColor="#9bcf00";
}

function outChangeBtn(btn){
	btn.style.backgroundColor="#0e9cdf";
}

function doQuery(pageNum){
	var libraryId = document.getElementById('libraryId').value;
	location.href = 'library.do?method=edit&pageNum='+pageNum+'&libraryId='+libraryId;
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
<input type="hidden" id="libraryId" name="libraryId" value="<bean:write name="library" property="id" />" />
<input type="hidden" id="queIds" name=queIds" value="<bean:write name="queIds" />">
<input type="hidden" id="firstSeq" name=firstSeq" value="<bean:write name="firstSeq" />">

<table align="center" width="80%" height="24"  border="0" cellpadding="0" cellspacing="0">
  <tr>
  	<td height="30px" style="color:#0e9cdf;font-size:14px;vertical-align:bottom;"><strong><strong><a href="library.do?method=list" style="color:#0e9cdf;" target="mainFrame">首页</a> >> 修改题库</strong></td>
  </tr>
  <tr style="font-size: 14px">
	<td align="center"><strong>题库名称：</strong><input type="text" style="width:300px;" id="libraryName" name="libraryName" value="<bean:write name="library" property="name" />" >&nbsp;&nbsp;
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
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<button type="button" id="a" style=" vertical-align:middle;" onclick="doSubmit(<logic:notEmpty name="pagevo"><bean:write name="pagevo" property="pageNum" /></logic:notEmpty><logic:empty name="pagevo">1</logic:empty>)" class="btn" onmouseover="overChangeBtn(this)" onmouseout="outChangeBtn(this)"><img src="images/newImages/survey_img/save.bmp" width="16" height="16" style="vertical-align:middle" /> 保存修改</button>
</td></tr>
</table>

<input type="hidden" name="pageNum" value="<logic:notEmpty name="pagevo"><bean:write name="pagevo" property="pageNum" /></logic:notEmpty><logic:empty name="pagevo">1</logic:empty>" />
<logic:notEmpty name="pagevo">
			
</br>
<table width="70%" align="center" height="18"  border="0" bordercolor="#828282" align="center" cellpadding="2"
				cellspacing="0" style="table-layout:fixed;font-size:12px">
  <tr>
    <td align="right">

			<table width="100%" border="0" align="center" cellpadding="2"
				cellspacing="0" style="table-layout:fixed;">
				<tr>
					<td align="right">
					第<bean:write name="pagevo" property="pageNum" />页
					共<bean:write name="pagevo" property="pageTotalNum" />页
					
					<logic:equal name="pagevo" property="hasPrevButton" value="1">
						<input type="button" name="bprev" value="上一页" style="background-color:#0e9cdf;height: 25px;color: white;border: 1px;border-color: #828282 " type="button" onmouseover="overChangeBtn(this)" onmouseout="outChangeBtn(this)" onClick="prevPage();">
					</logic:equal>
					<logic:equal name="pagevo" property="hasPrevButton" value="0">
						<input type="button" name="bprev" value="上一页" style=" vertical-align:top;background-color:white" disabled="disabled">
					</logic:equal>
					<logic:equal name="pagevo" property="hasNextButton" value="1">
						<input type="button" name="bnext" value="下一页" style="background-color:#0e9cdf;height: 25px;color: white;border: 1px;border-color: #828282 " type="button" onmouseover="overChangeBtn(this)" onmouseout="outChangeBtn(this)" onClick="nextPage();">
					</logic:equal>
					<logic:equal name="pagevo" property="hasNextButton" value="0">
						<input type="button" name="bnext" value="下一页" style=" vertical-align:top;background-color:white" disabled="disabled">
					</logic:equal>
					&nbsp;&nbsp;
					转到第
					<input type="text" name="jumpPageNum" value="" size="1" onkeypress="if(event.keyCode==13){jumpPage();return false;}" />
					页
					<a href="javascript:void(0)" style="color: #333333;" onclick="jumpPage();return false;">确定</a>
					
					
					</td>
				</tr>
			</table>

	</td>
  </tr>
</table>
</br></br>
</logic:notEmpty>

</form>
<script type="text/javascript">

<logic:iterate id="e" name="pagevo" property="objectList">
	
	<logic:equal name="e" property="type" value="1">
	addDXQue();
	g('queName' + queCount).value = '<bean:write name="e" property="name" />';
	g('category' + queCount).value = '<bean:write name="e" property="category" />';	
	</logic:equal>
	
	<logic:equal name="e" property="type" value="2">
	addBDXQue();
	g('queName' + queCount).value = '<bean:write name="e" property="name" />';	
	g('category' + queCount).value = '<bean:write name="e" property="category" />';
	</logic:equal>

	<logic:equal name="e" property="type" value="3">
	addWDQue();
	g('queName' + queCount).value = '<bean:write name="e" property="name" />';
	g('category' + queCount).value = '<bean:write name="e" property="category" />';	
	</logic:equal>

	<logic:iterate id="e2" name="e" property="optionList">
		addOpt(queCount);
		//alert(g('optDiv' + queCount + '-' + optArray[queCount]).getElementsByTagName('input')[0].value);
		g('optName' + queCount + '-' + optArray[queCount]).value = '<bean:write name="e2" property="name" />';
	</logic:iterate>

</logic:iterate>

</script>
</body>
</html>


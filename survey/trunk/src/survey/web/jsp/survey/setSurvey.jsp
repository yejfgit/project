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
	
	var queDivHtml = '<div id="queDiv' + queCount + '"><br>&nbsp;&nbsp;&nbsp;&nbsp;题目' + queCount + '：<input type="text"  style="width:400px" id="queName' + queCount + '" />&nbsp;题目分数：<input type="text" style="width:20px" id="queScore' + queCount + '" value="0"/>&nbsp;<input type="checkbox"  id="queType' + queCount + '"/>不定项&nbsp;&nbsp;<input type="button" value="增加选项" onclick="addOpt(' + queCount + ')" />&nbsp;<input type="button" value="X" onclick="delQue(' + queCount + ')" /></div>';
	
	g("queBox").innerHTML += queDivHtml;
	
}

function addBDXQue() {
	++queCount;
	++queSeq
	optArray[queCount] = 0;
	
	var queDivHtml = '<div id="queDiv' + queCount + '"><br>&nbsp;&nbsp;&nbsp;&nbsp;题目' + queSeq + '：<input type="text"  style="width:400px" id="queName' + queCount + '" />&nbsp;&nbsp;题目分数：<input type="text" style="width:20px" id="queScore' + queCount + '" value="0"/><input type="hidden" id="queType' + queCount + '" value="2" />（不定项）&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="增加选项" onclick="addOpt(' + queCount + ')" />&nbsp;<input type="button" value="X" onclick="delQue(' + queCount + ')" /></div>';

	g("queBox").innerHTML += queDivHtml;
	

}

function addDXQue() {
	++queCount;
	++queSeq
	optArray[queCount] = 0;
	
	var queDivHtml = '<div id="queDiv' + queCount + '"><br>&nbsp;&nbsp;&nbsp;&nbsp;题目' + queSeq + '：<input type="text"  style="width:400px" id="queName' + queCount + '" />&nbsp;&nbsp;题目分数：<input type="text" style="width:20px" id="queScore' + queCount + '" value="0"/><input type="hidden" id="queType' + queCount + '" value="1" /> （单选）&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="增加选项" onclick="addOpt(' + queCount + ')" />&nbsp;<input type="button" value="X" onclick="delQue(' + queCount + ')" /></div>';

	g("queBox").innerHTML += queDivHtml;
	
}

function addWDQue() {
	++queCount;
	++queSeq
	var queDivHtml = '<div id="queDiv' + queCount + '"><br>&nbsp;&nbsp;&nbsp;&nbsp;题目' + queSeq + '：<textarea rows="3" cols="25"  style="width:600px;" id="queName' + queCount + '" >新建问答题</textarea>&nbsp;&nbsp;题目分数：<input type="text" style="width:20px" id="queScore' + queCount + '" value="0"/><input type="hidden" id="queType' + queCount + '" value="3" />（问答题）&nbsp;<input type="button" value="X" onclick="delQue(' + queCount + ')" /></div>';
	g("queBox").innerHTML += queDivHtml;
	
}

function addFgx() {
	++queCount;
	var queDivHtml = '<div id="queDiv' + queCount + '"><br>&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" style="width:600px;background-color:#CCCCCC;" id="queName' + queCount + '" value="我是华丽分割线" ><input type="hidden" style="width:20px" id="queScore' + queCount + '" value="0"/><input type="hidden" id="queType' + queCount + '" value="4" />&nbsp;<input type="button" value="X" onclick="delQue(' + queCount + ')" /></div>';
	g("queBox").innerHTML += queDivHtml;
	
}

function delQue(queDivSeq) {
	g("queBox").removeChild(g("queDiv" + queDivSeq));
}


function addOpt(queDivSeq) {
	optCount = ++optArray[queDivSeq];
	
	optDivHtml = '<div id="optDiv' + queDivSeq + '-' + optCount + '">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;选项：<input type="text" id="optName' + queDivSeq + '-' + optCount + '" />&nbsp;<input type="checkbox" id="optScore' + queDivSeq + '-' + optCount + '" onchange="isRight(this)" size="5" value="0" />(勾选为正确答案)&nbsp;<input type="button" value="x" onclick="delOpt(' + queDivSeq + ', ' + optCount + ')" /></div>';
	g("queDiv" + queDivSeq).innerHTML += optDivHtml;

}

function delOpt(queDivSeq, optDivSeq) {
	g("queDiv" + queDivSeq).removeChild(g("optDiv" + queDivSeq + "-" + optDivSeq));
}


function doSubmit() {

	if(document.getElementById('hurryTimes').value>30||document.getElementById('hurryTimes').value==0){
		alert("未完成提醒天数不能等于0，并且不能大于30天");
		
		return false;
	}
	var limit = /^\+?[1-9][0-9]*$/;
	if(!limit.test(document.getElementById('hurryTimes').value)){
		alert("天数只能为正整数！");
		
		return false;
	}
	
	if (!confirm('您确定保存问卷设置吗？')) {
		return false;
	}
	
	var isShuffle = document.getElementById("isShuffle");
	if(isShuffle.checked==true){
		isShuffle=1;
	}else{
		isShuffle=0;
	}
	
	var isOpen = document.getElementById("isOpen");
	if(isOpen.checked==true){
		isOpen=1;
	}else{
		isOpen=0;
	}
	

	document.f1.action = 'survey.do?method=updateSetSurvey&isShuffle='+isShuffle+'&isOpen='+isOpen;
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

function choice(id){
	var a = "queLim"+id;
	var b =  document.getElementById(a).style.display;
	if(b=="none"){
		document.getElementById(a).style.display="block";
	}else{
		document.getElementById(a).style.display="none";
	}

}

function isRight(opt){
	if(opt.checked==true){
		opt.value=1;
	}else if(opt.checked==false){
		opt.value=0;
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

</script>
<style>
.bque{
	font-size:14px;
}
.allTips{
	display:none;
	
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

table{
	font-size:14px;
}

</style>



</head>

<body>
<form name="f1" method="post" action="">

<input type="hidden" id="ownerId" name="survey.ownerId" value="<bean:write name="surveyForm" property="survey.ownerId" />" />
<input type="hidden" id="surveyId" name="survey.id" value="<bean:write name="surveyForm" property="survey.id" />" />
<input type="hidden" id="surveyType" name="survey.type" value="<bean:write name="surveyForm" property="survey.type" />" />
<table align="center" width="80%" height="24"  border="0" cellpadding="0" cellspacing="0">
  <tr>
  	<td height="30px" style="color:#0e9cdf;font-size:14px;vertical-align:bottom;"><strong><strong><a href="survey.do?method=adminList" style="color:#0e9cdf;" target="mainFrame">首页</a> >> 问卷设置</strong></td>
  </tr>
  <tr style="font-size: 18px">
		<td align="center" style="font-size:20px;"><strong>问卷名称：
		<logic:equal value="1" name="surveyForm" property="survey.type">[考试]</logic:equal>
		<logic:equal value="2" name="surveyForm" property="survey.type">[调查]</logic:equal>
		<bean:write name="surveyForm" property="survey.name" /></strong>&nbsp;&nbsp;
    </td>
  </tr>
  <tr>
  	<td height="30px"></td>
  </tr>
</table>

<table align="center" width="80%">
<tr>
<td style="font-size: 16px" class=bque>
<strong>高级设置：（0为不限）</strong>
</td>
</tr>
<tr>
<td>
时间限制：<input type="text" id="timeLimit" name="survey.timeLimit" size="5" value="<bean:write name="surveyForm" property="survey.timeLimit"/>" />分钟<br>
自动关闭逾期未完成问卷：<input type="text" id="hurryTimes" name="survey.hurryTimes" size="5" value="<bean:write name="surveyForm" property="survey.hurryTimes" />">天&nbsp;&nbsp;(在指定天数内，系统将每天对未完成问卷用户进行邮件提示。逾期将自动关闭未完成问卷)<br>
<div style="display:none">随机题目顺序：<input type="checkbox" id="isShuffle" name="survey.isShuffle" value="<bean:write name="surveyForm" property="survey.isShuffle"/>" />&nbsp;&nbsp;</div> 

<logic:equal value="1" name="surveyForm" property="survey.type">
<div style="display:none;"><input type="checkBox" id="isOpen" name="survey.isOpen" value="<bean:write name="surveyForm" property="survey.isOpen"/>" /></div>
</logic:equal>

<logic:equal value="2" name="surveyForm" property="survey.type">
问卷最高分数：<input type="text" id="maxScore" name="survey.maxScore" size="5" value="<bean:write name="surveyForm" property="survey.maxScore"/>" />&nbsp;&nbsp; 
问卷最低分数：<input type="text" id="minScore" name="survey.minScore" size="5" value="<bean:write name="surveyForm" property="survey.minScore"/>" />&nbsp;&nbsp;
是否对考生保密调查结果：<input type="checkbox" id="isOpen" name="survey.isOpen" value="<bean:write name="surveyForm" property="survey.isOpen"/>" /> 
</logic:equal>
</td>
</tr>
<tr>
<td><br></td>
</tr>
<tr>
	<td style="font-size: 16px" class=bque>
		<strong>提示信息设置：</strong>
	</td>
</tr>
<tr><td>&nbsp;</td></tr>
<tr><td>卷面提示信息：<script type="text/javascript">
			var t = '<bean:write name="surveyForm" property="survey.tips" filter="false"/>';
			
			var oFCKeditor = new FCKeditor( 'tips' ) ;
			oFCKeditor.BasePath	= "<%=basePath%>editor/fckeditor/" ;
			oFCKeditor.Height	= 200 ;
			oFCKeditor.Value	= t;
			oFCKeditor.Create() ;
		</script></td>
</tr>
<tr><td>&nbsp;</td></tr>
<tr><td>邮件提示信息：
			<script type="text/javascript">
			var oFCKeditor = new FCKeditor( 'mailTips' ) ;
			oFCKeditor.BasePath	= "<%=basePath%>editor/fckeditor/" ;
			oFCKeditor.Height	= 200 ;
			oFCKeditor.Value	= '<bean:write name="surveyForm" property="survey.mailTips" filter="false"/>';
			oFCKeditor.Create() ;
		</script>
</td></tr>
<tr>
<td class="bque"><div class="cdiv" onmouseover="this.style.cursor='hand'">
<strong>点击设置更多提示信息▼：</strong>
</div>
</td>
</tr>
<tr><td>
<div class="allTips"><table align="center" width="100%">


<tr><td>&nbsp;</td></tr>
<tr><td>邮件催办信息：
			<script type="text/javascript">
			var oFCKeditor = new FCKeditor( 'hurryTips' ) ;
			oFCKeditor.BasePath	= "<%=basePath%>editor/fckeditor/" ;
			oFCKeditor.Height	= 200 ;
			oFCKeditor.Value	= '<bean:write name="surveyForm" property="survey.hurryTips" filter="false"/>';
			oFCKeditor.Create() ;
		</script>
</td></tr>
<tr><td>&nbsp;</td></tr>
<tr><td>邮件关闭信息：
			<script type="text/javascript">
			var oFCKeditor = new FCKeditor( 'closeTips' ) ;
			oFCKeditor.BasePath	= "<%=basePath%>editor/fckeditor/" ;
			oFCKeditor.Height	= 200 ;
			oFCKeditor.Value	= '<bean:write name="surveyForm" property="survey.closeTips" filter="false"/>';
			oFCKeditor.Create() ;
		</script>
</td></tr>

</table></div>
</td>
</tr>
<tr>
<td>
&nbsp;
</td>
</tr>

<tr>
<td>
&nbsp;
</td>
</tr>
</table>

<table align="center">
<tr><td align="center">
	<button type="button" id="a" onclick="doSubmit()" class="btn" onmouseover="overChangeBtn(this)" onmouseout="outChangeBtn(this)"><img src="images/newImages/survey_img/save.bmp" width="16" height="16" style="vertical-align:middle" /> 保存设置</button>
		&nbsp;&nbsp;
	<button type="button" id="a" onclick="history.go(-1);" class="btn" onmouseover="overChangeBtn(this)" onmouseout="outChangeBtn(this)">返回</button>
	</br>

	</td>
</tr>
</table>


</form>
<script>
checkSpecial();
</script>
</script>
</body>
</html>


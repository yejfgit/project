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
<title>创建考试问卷</title>
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
	
	var queDivHtml = '<div id="queDiv' + queCount + '"><br>&nbsp;&nbsp;&nbsp;&nbsp;<strong>题目' + queSeq + '：</strong><input type="text"  style="width:400px" id="queName' + queCount + '" />&nbsp;题目分数：<input type="text" style="width:20px" id="queScore' + queCount + '" value="0"/>&nbsp;<input type="checkbox"  id="queType' + queCount + '"/>不定项&nbsp;&nbsp;<input type="button" value="增加选项" onclick="addOpt(' + queCount + ')" />&nbsp;<input type="button" value="X" onclick="delQue(' + queCount + ')" /></div>';
	
	g("queBox").innerHTML += queDivHtml;
	
	for(var i=0;i<4;i++){
		addOpt(queCount);
	}

}

function addBDXQue() {
	++queCount;
	++queSeq
	optArray[queCount] = 0;
	
	var queDivHtml = '<div id="queDiv' + queCount + '" nowrap class="queDivCol"><br>&nbsp;&nbsp;&nbsp;&nbsp;<strong>题目' + queSeq + '：</strong><input type="text"  style="width:490px" id="queName' + queCount + '" />'+
	'&nbsp;&nbsp;题目分数：<input type="text" style="width:20px" id="queScore' + queCount + '" value="0"/><input type="hidden" id="queType' + queCount + '" value="2" />（多选题）&nbsp;&nbsp;&nbsp;&nbsp;'+
	'<button type="button" id="a" onclick="addOpt(' + queCount + ')" style=" vertical-align:top;background-color: white;"><img src="images/newImages/survey_img/add.gif" width="16" height="16" style="vertical-align:top" />增加选项</button>&nbsp;&nbsp;'+
	'<input type="button" value=" x " style="background-color: white;" onclick="delQue(' + queCount + ')" />'+
	'<div style="width:850px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;多选题得分规则：错选不得分，少选得该题目50%分数。</div></div>';

	g("queBox").innerHTML += queDivHtml;
	
	for(var i=0;i<4;i++){
		addOpt(queCount);
	}

}

function addDXQue() {
	++queCount;
	++queSeq
	optArray[queCount] = 0;
	
	var queDivHtml = '<div id="queDiv' + queCount + '" nowrap name="'+queSeq+'" class="queDivCol"><br>&nbsp;&nbsp;&nbsp;&nbsp;<strong>题目' + queSeq + '：</strong><input type="text"  style="width:500px" id="queName' + queCount + '" />&nbsp;&nbsp;题目分数：<input type="text" style="width:20px" id="queScore' + queCount + '" value="0"/><input type="hidden" id="queType' + queCount + '" value="1" /> （单选题）'+
	'<button type="button" id="a" onclick="addOpt(' + queCount + ')" style=" vertical-align:top;background-color: white;"><img src="images/newImages/survey_img/add.gif" width="16" height="16" style="vertical-align:top" />增加选项</button>&nbsp;&nbsp;'+
	'<input type="button" value=" x " style="background-color: white;" onclick="delQue(' + queCount + ')" /></div>';

	g("queBox").innerHTML += queDivHtml;
	
	for(var i=0;i<4;i++){
		addOpt(queCount);
	}

}

function addWDQue() {
	++queCount;
	++queSeq
	var queDivHtml = '<div id="queDiv' + queCount + '" vertical-align="bottom" nowrap class="queDivCol"><br>&nbsp;&nbsp;&nbsp;&nbsp;<strong>题目' + queSeq + '：</strong><textarea rows="4" cols="50"  style="width:595px;vertical-align:bottom" id="queName' + queCount + '" >新建问答题</textarea>&nbsp;&nbsp;题目分数：<input type="text" style="width:20px" id="queScore' + queCount + '" value="0"/><input type="hidden" id="queType' + queCount + '" value="3" />（问答题）&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+
	'<input type="button" value=" x " style="background-color: white;" onclick="delQue(' + queCount + ')" /></br></div>';
	g("queBox").innerHTML += queDivHtml;
	
}

function addFgx() {
	++queCount;
	var queDivHtml = '<div id="queDiv' + queCount + '" nowrap class="queDivCol"><br>&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" style="width:740px;font-size:16px;" id="queName' + queCount + '" value="" ><input type="hidden" style="width:20px" id="queScore' + queCount + '" value="0"/><input type="hidden" id="queType' + queCount + '" value="4" />&nbsp;（分割线）&nbsp;&nbsp;'+
	'<input type="button" value=" x " style="background-color: white;" onclick="delQue(' + queCount + ')" /></br></div>';
	g("queBox").innerHTML += queDivHtml;
	
}

function delQue(queDivSeq) {
	g("queBox").removeChild(g("queDiv" + queDivSeq));
}


function addOpt(queDivSeq) {
	optCount = ++optArray[queDivSeq];
	var type = document.getElementById("queType" + queDivSeq).value;

	if(type==1){
		optDivHtml = '<div id="optDiv' + queDivSeq + '-' + optCount + '" style="width:850px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;选项：<input type="text" id="optName' + queDivSeq + '-' + optCount + '" style="width:300px;" />&nbsp;'+
		'<input type="radio" id="optScore' + queDivSeq + '-' + optCount + '" name="optScore' + queDivSeq + '" onchange="isRight(this)" size="5" value="0" />(勾选为正确答案)&nbsp;&nbsp;&nbsp;&nbsp;'+
		'<input type="button" value=" x " style="background-color: white;" onclick="delOpt(' + queDivSeq + ', ' + optCount + ')" /></div>';
		g("queDiv" + queDivSeq).innerHTML += optDivHtml;
	}else{
		optDivHtml = '<div id="optDiv' + queDivSeq + '-' + optCount + '" style="width:850px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;选项：<input type="text" id="optName' + queDivSeq + '-' + optCount + '"  style="width:300px;" />&nbsp;'+
		'<input type="checkbox" id="optScore' + queDivSeq + '-' + optCount + '" name="optScore' + queDivSeq + '" onchange="isRight(this)" size="5" value="0" />(勾选为正确答案)&nbsp;&nbsp;&nbsp;&nbsp;'+
		'<input type="button" value=" x " style="background-color: white;" onclick="delOpt(' + queDivSeq + ', ' + optCount + ')" /></div>';
		g("queDiv" + queDivSeq).innerHTML += optDivHtml;
	}
	


}

function delOpt(queDivSeq, optDivSeq) {
	g("queDiv" + queDivSeq).removeChild(g("optDiv" + queDivSeq + "-" + optDivSeq));
}


function doSubmit(isSave) {
	var surveyScore = 0;
	
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
	qb += '<type>' + v("surveyType") + '</type>';
	if (g("isShuffle").checked) {
			sf = 1;
		} else {
			sf = 0;
		}
	qb += '<shuffle>' + sf + '</shuffle>';
	if (g("isOpen").checked) {
			op = 1;
		} else {
			op = 0;
		}
	qb += '<open>' + op + '</open>';
	for (q = 1; q <= queCount; q++) {
		if (g("queDiv" + q) == undefined) continue;
	
		qn = tag('name', v("queName" + q));
		t = g("queType" + q).value;
		qt = tag('type', t);
		ob = '';
		
		var checkedNum = 0;
		for (o = 1; o <= optArray[q]; o++) {
			if (g("optDiv" + q + "-" + o) == undefined) continue;
	
			on = tag('name', v("optName" + q + "-" + o));
			os = tag('score', v("optScore" + q + "-" + o));
			//判断是否此题勾选正确答案
			if(v("optScore" + q + "-" + o)>0){
				checkedNum++;
			}
			
			ob += tag('option', on + os);
	
		}
		if(t==1&&checkedNum==0){
			alert("有单选题未勾选正确答案!")
			return false;
		}
		if(t==2&&checkedNum==0){

			alert("有多选题未勾选正确答案!")
			return false;
		}
		qs = tag('queScore', v("queScore" + q));
		qb += tag('question', qn + qt + qs + ob);
		
		surveyScore += parseInt(v("queScore" + q));
	}
	qb += '</survey>';
	
	//alert(qb);
	if(isSave==0)
		if (!confirm('卷面总分为  '+surveyScore+'分  确定下发此问卷吗？')) {
			return false;
		}
	else
		if (!confirm('卷面总分为  '+surveyScore+'分  确定保存此问卷吗？')) {
		return false;
	    }
	g("surveyInfo").value = qb;
	
	var isJumpSet=1;
	
	document.f1.action = 'survey.do?method=save&isJumpSet='+isJumpSet+"&isSave="+isSave;
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
	/**
	if(opt.checked==true){
		opt.value=1;
	}else if(opt.checked==false){
		opt.value=0;
	}
	*/
	var check = document.getElementsByName(opt.name);
	for(i=0;i<check.length;i++){
		if(check[i].checked==true){
			check[i].value=1;
		}else if(check[i].checked==false){
			check[i].value=0;
		}
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

.queDivCol{
	background-color:#EFF6FB;
	display:inline;
	width：1100px;
	
}

　　html { 
　　overflow-y:auto!important; 
　　*overflow-y:scroll; 
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

<body onload="addDXQue();">
<form name="f1" method="post" action="">

<input type="hidden" id="ownerId" name="ownerId" value="<bean:write name="ownerId" />" />
<input type="hidden" id="surveyInfo" name="surveyInfo" value="" />
<input type="hidden" id="surveyType" name="surveyType" value="1" />
<table align="center" width="80%" height="24"  border="0" cellpadding="0" cellspacing="0" style="background-color: white;border: 1px solid #ddd">
  <tr>
  		<td height="30px" style="color:#0e9cdf;font-size:16px;vertical-align:bottom;background-color:white;padding:10px 20px">
  		<a href="survey.do?method=WJList&type=1" style="color:#0e9cdf;" target="mainFrame">首页</a> 
  		>> <strong>问卷设计</strong>
  		>>问卷下发
  		>>完成分析</td>
  </tr>
  <tr style="font-size: 14px;">
		<td align="left" style="padding:20px 30px"><strong>问卷名称：</strong><input type="text" style="width:300px;" id="surveyName" name="surveyName" />&nbsp;&nbsp;
		<span style="color: red">*</span>
    </td>
  </tr>
</table>
<!--  -->
<table align="center" width="80%">
<tr>
<td class=bque>

<td>
  <input type="hidden" id="isOpen" name="isOpen" value="0" />&nbsp;&nbsp; 
</td>
</tr>
</table>
<div id="div2" style="width:82%;float:right;">
<tr>
<td class=bque>
</td>
</tr>
<table align="left" width="85%">
	<div style="display: block;">
	<tr>
<td class=bque>
<strong>高级设置：（0为不限）</strong>

时间限制：<input type="text" id="timeLimit" name="timeLimit" size="5" value="0" />分钟&nbsp;&nbsp;
<input type="checkbox" id="isShuffle" name="isShuffle" />随机题目顺序&nbsp;&nbsp;
<input type="hidden" id="maxScore" name="maxScore" size="5" value="0" />&nbsp;&nbsp; 
<input type="hidden" id="minScore" name="minScore" size="5" value="0" />&nbsp;&nbsp;
催办次数：<input type="text" id="hurryTimes" name="hurryTimes" value="0"> 
<input type="hidden" id="isOpen" name="isOpen" value="0" />&nbsp;&nbsp; </td>
</tr>
<tr><td>卷面提示信息：<script type="text/javascript">
			var t = '欢迎使用合众人寿在线问卷、考试系统!';
			
			var oFCKeditor = new FCKeditor( 'tips' ) ;
			oFCKeditor.BasePath	= "<%=basePath%>editor/fckeditor/" ;
			oFCKeditor.Height	= 200 ;
			oFCKeditor.Value	= t;
			oFCKeditor.Create() ;
		</script></td>
    </tr>
<tr>
</div>
</tr>
</table>
<div id="div2" style="width:82%;float:right;">
<table align="left" width="86%" style="background-color: white;margin-left: 20px">

	<tr>
		<td>
		<div id="queBox"></div>
		</td>
	</tr>
	<tr>
	<td  height="50px" align="center">
			<button type="button" id="a" onclick="doSubmit(0)" class="btn" onmouseover="overChangeBtn(this)" onmouseout="outChangeBtn(this)"><img src="images/newImages/survey_img/xiafa.png" width="16" height="16" style="vertical-align:middle" /> 下发问卷</button>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="button" id="a" onclick="doSubmit(1);" class="btn" onmouseover="overChangeBtn(this)" onmouseout="outChangeBtn(this)"><img src="images/newImages/survey_img/save.bmp" width="16" height="16" style="vertical-align:middle" />保存问卷</button>
		</td>
</tr>
</table>
</div>
<div id="div3" class="div3" style="width:18%;float:left;height:200px;position: absolute;">
<table align="right" width="45%" style="background-color: white;">
	<tr><td>&nbsp;</td></tr>
	<tr><td>&nbsp;</td></tr>
	<tr><td>&nbsp;</td></tr>
	<tr><td>&nbsp;</td></tr>
	<tr><td>&nbsp;</td></tr>
	<tr><td align="center" bgcolor="#cccccc" height="30px" style="vertical-align:middle;width:100%;float:left;height:20px"><span style="font-size: 16px;"><Strong>选择题型</Strong></span></td></tr>
	
    <tr><td style="width:100%;text-align:center;height:30px;"><button type="button" id="a" onclick="addDXQue()" style=" vertical-align:middle;background-color: white;"><img src="images/newImages/survey_img/danxuan.gif" width="16" height="16" style="vertical-align:middle" /> 单选题</button></td></tr>
	<tr><td style="width:100%;text-align:center;height:30px;"><button type="button" id="a" onclick="addBDXQue()" style=" vertical-align:middle;background-color: white;"><img src="images/newImages/survey_img/duoxuan.gif" width="16" height="16" style="vertical-align:middle" /> 多选题</button></td></tr>
	<tr><td style="width:100%;text-align:center;height:30px;"><button type="button" id="a" onclick="addWDQue()" style=" vertical-align:middle;background-color: white;"><img src="images/newImages/survey_img/wenda.gif" width="16" height="16" style="vertical-align:middle" /> 问答题</button></td></tr>
	<tr><td style="width:100%;text-align:center;height:30px;"><button type="button" id="a" onclick="addFgx()" style=" vertical-align:middle;background-color: white;"><img src="images/newImages/survey_img/fengexian.gif" width="16" height="16" style="vertical-align:middle" /> 分割线</button></td></tr>
</table>
</div>

</form>

</body>
</html>


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
	
	var queDivHtml = '<div id="queDiv' + queCount + '" nowrap class="queDivCol" ><br><input type="button" value=" x " style="background-color: #F08080;" onclick="delQue(' + queCount + ')" /><strong>&nbsp;&nbsp;&nbsp;&nbsp;题目' + queSeq + '：</strong><input type="text"  style="width:400px" id="queName' + queCount + '" />&nbsp;&nbsp;<input type="hidden" id="queType' + queCount + '" value="2" />（多选题）&nbsp;&nbsp;最大选择数：<input type="text" style="width:10px;" id="maxCheck' + queCount + '" name="maxCheck' + queCount + '" value="0">&nbsp;'+
		'最小选择数：<input type="text" style="width:10px;" id="minCheck' + queCount + '" value="0">&nbsp;&nbsp;'+
		'<button type="button" id="a" onclick="addOpt(' + queCount + ')" style=" vertical-align:top;background-color: white;"><img src="images/newImages/survey_img/add.gif" width="16" height="16" style="vertical-align:top" />增加选项</button>&nbsp;'+
		'<br/></div>';

	
	g("queBox").innerHTML += queDivHtml;
	
	for(var i=0;i<4;i++){
		addOpt(queCount);
	}

}

function addDXQue() {
	++queCount;
	++queSeq
	optArray[queCount] = 0;
	
	var queDivHtml = '<div id="queDiv' + queCount + '" nowrap class="queDivCol"><br><input type="button" value=" x " style="background-color: #F08080;" onclick="delQue(' + queCount + ')" /> &nbsp;&nbsp;&nbsp;&nbsp;题目' + queSeq + '：<input type="text"  style="width:580px" id="queName' + queCount + '" />&nbsp;&nbsp;<input type="hidden" id="queType' + queCount + '" value="1" /> <br>（单选题）&nbsp;&nbsp;&nbsp;&nbsp;'+
	'<button type="button" id="a" onclick="addOpt(' + queCount + ')" style=" vertical-align:top;background-color: white;"><img src="images/newImages/survey_img/add.gif" width="16" height="16" style="vertical-align:top" />增加选项</button>&nbsp;'+
	'</div>'+
	'<div id="queLim' + queCount + '" style="display:none">&nbsp;&nbsp;&nbsp;&nbsp;最大选择数：<input type="text" style="width:10px;" id="maxCheck' + queCount + '" name="maxCheck' + queCount + '" value="0">&nbsp;最小选择数：<input type="text" style="width:10px;" id="minCheck' + queCount + '" value="0"></div>';
	g("queBox").innerHTML += queDivHtml;
	
	for(var i=0;i<4;i++){
		addOpt(queCount);
	}

}

function addWDQue() {
	++queCount;
	++queSeq
	var queDivHtml = '<div id="queDiv' + queCount + '" vertical-align="bottom" nowrap class="queDivCol"><br><input type="button" value=" x " style="background-color: #F08080;" onclick="delQue(' + queCount + ')" /> &nbsp;&nbsp;&nbsp;&nbsp;<strong>题目' + queSeq + '：</strong><textarea rows="4" cols="50"  style="width:690px;vertical-align:bottom" id="queName' + queCount + '" >新建问答题</textarea>&nbsp;&nbsp;<input type="hidden" id="queType' + queCount + '" value="3" />（问答题）&nbsp;&nbsp;'+
	'</br></div>';

	g("queBox").innerHTML += queDivHtml;
	
}

function addFgx() {
	++queCount;
	var queDivHtml = '<div id="queDiv' + queCount + '" nowrap class="queDivCol"><br><input type="button" value=" x " style="background-color: #F08080;" onclick="delQue(' + queCount + ')" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" style="width:740px;font-size:16px;" id="queName' + queCount + '" value="" ><input type="hidden" style="width:20px" id="queScore' + queCount + '" value="0"/><input type="hidden" id="queType' + queCount + '" value="4" />&nbsp;（分割线）&nbsp;&nbsp;'+
	'</br></div>';

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
	
	optDivHtml = '<div id="optDiv' + queDivSeq + '-' + optCount + '" style="width:850px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;选项：<input type="text" style="width:300px;" id="optName' + queDivSeq + '-' + optCount + '" />&nbsp;分值：<input type="text" style="width:20px;" id="optScore' + queDivSeq + '-' + optCount + '" size="5" value="0" />&nbsp;<input type="button" value=" x " style="background-color:  #F08080;" onclick="delOpt(' + queDivSeq + ', ' + optCount + ')" /></div>';
	
	g("queDiv" + queDivSeq).innerHTML += optDivHtml;

}

function delOpt(queDivSeq, optDivSeq) {
	g("queDiv" + queDivSeq).removeChild(g("optDiv" + queDivSeq + "-" + optDivSeq));
}


function doSubmit(isSave) {

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
	
	
	qb += '<type>' + document.getElementById("surveyType").value + '</type>';
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
		for (o = 1; o <= optArray[q]; o++) {
			if (g("optDiv" + q + "-" + o) == undefined) continue;
			on = tag('name', v("optName" + q + "-" + o));
			os = tag('score', v("optScore" + q + "-" + o));
			ob += tag('option', on + os);

		}
		//alert(q);
		if(t==1||t==2){
			var aa = v("maxCheck" + q);
			qmaxc = tag('maxCheck',aa );
			qminc = tag('minCheck', v("minCheck" + q));
			
		}else{
			qmaxc = tag('maxCheck',	0);
			qminc = tag('minCheck', 0);
		}

				
		qb += tag('question', qn + qt  + qmaxc + qminc + ob);
	}
	qb += '</survey>';
	
	//alert(qb);
	if(isSave==0)
	{
		if (!confirm('确定下发此问卷吗？')) {
			return false;
		}
	}
	else
	{
		if (!confirm('确定保存此问卷吗？')) {
			return false;
		}
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
	document.f1.action = 'survey.do?method=save&isJumpSet='+isJumpSet+'&isSave='+isSave;
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
	
	document.getElementById("queType' + queCount + ")
	
	if(b=="none"){
		document.getElementById(a).style.display="block";
	}else{
		document.getElementById(a).style.display="none";
		//清空Div内所有value
		document.getElementById("maxCheck"+id).value=0;
		document.getElementById("minCheck"+id).value=0
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
.div3{
	position:absolute;
	top: 70px;
}
</style>



</head>

<body onload="addDXQue();">
<form name="f1" method="post" action="">

<input type="hidden" id="ownerId" name="ownerId" value="<bean:write name="ownerId" />" />
<input type="hidden" id="surveyInfo" name="surveyInfo" value="" />
<input type="hidden" id="surveyType" name="surveyType" value="2" />
<table align="center" width="80%" height="24"  border="0" cellpadding="0" cellspacing="0" style="border: 1px solid #ddd;" class="titBar2">
  <tr >
  	<td height="30px" class="titBar3"><a href="survey.do?method=WJList&type=2"  target="mainFrame">返回首页</a>
  	</td>
    <td colspan="2" class="titBar">
  	<strong>问卷设计</strong>>>问卷下发>>结果分析</td>
  </tr>
 </table>
<br>
<div style="width:80%;margin: 0 auto;">
	<div style="width: 20%;float: left; position: fixed; margin: 0;">
		<div style="width: 75%;height: 160px;border: solid 1px #DDDEE3;">
			<div class="tdTitle">问卷设置</div>
			<div class="setC">
				题目顺序：<input type="checkbox" id="isShuffle" name="isShuffle" />随机
			</div>
			<div class="setC">
				最高分数：<input type="text" id="maxScore" name="maxScore" size="1" value="0" />
			</div>
			<div class="setC">
				最低分数：<input type="text" id="minScore" name="minScore" size="1" value="0" />
			</div>
			<div class="setC" >
				时间限制：<input type="text" id="timeLimit" name="timeLimit" size="1" value="0" />分钟<br>（0为不限）
			</div>
		</div>
		<div style="width: 75%;border: solid 1px #DDDEE3;margin-top: 15px;">
			<div class="tdTitle" >选择题型</div>
			<div class="setC" >
				<button type="button" id="a" onclick="addDXQue()" style=" vertical-align:middle;background-color: white;"><img src="images/newImages/survey_img/danxuan.gif" width="16" height="16" style="vertical-align:middle" /> 单选题</button>
			</div>
			<div class="setC">
				<button type="button" id="a" onclick="addBDXQue()" style=" vertical-align:middle;background-color: white;"><img src="images/newImages/survey_img/duoxuan.gif" width="16" height="16" style="vertical-align:middle" /> 多选题</button>
			</div>
			<div class="setC">
				<button type="button" id="a" onclick="addWDQue()" style=" vertical-align:middle;background-color: white;"><img src="images/newImages/survey_img/wenda.gif" width="16" height="16" style="vertical-align:middle" /> 问答题</button>
			</div>
			<div class="setC">
				<button type="button" id="a" onclick="addFgx()" style=" vertical-align:middle;background-color: white;"><img src="images/newImages/survey_img/fengexian.gif" width="16" height="16" style="vertical-align:middle" /> 分割线</button>
			</div>
		</div>
	</div>
	<div style="width: 80%;float: right;">
		<div style="background-color: white;">
			<div class="setC3">
				<strong>问卷名称：</strong><input type="text" style="width:300px;font-size: 14px;" id="surveyName" name="surveyName" />&nbsp;&nbsp;
				<span style="color: red">*</span>
			</div>
			<script type="text/javascript">
				var t = '欢迎使用合众人寿在线问卷、考试系统!';
				
				var oFCKeditor = new FCKeditor( 'tips' ) ;
				oFCKeditor.BasePath	= "<%=basePath%>editor/fckeditor/" ;
				oFCKeditor.Height	= 120 ;
				oFCKeditor.Value	= t;
				oFCKeditor.Create() ;
			</script>
		</div>
		<div id="queBox" style="margin-top: 15px;background-color: white;border: 1px solid #ddd"></div>
		
		<div id="div2" style="width:100%;">
			<table align="left" width="100%" style="background-color: white;margin-top: 15px;">
				<tr>
					<td>
						
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
	</div>
</div>






</form>

</body>
</html>


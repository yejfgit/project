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
<script language="javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript">

var optArray = new Array();
var canLeave = 0;
var checkedList = 0;




function doSubmit(leftTime) {

	if (!confirm('确实要提交问卷吗？')) {
		return false;
	}
	
	var btnDiv = window.parent.document.getElementById("btns");
 	btnDiv.style.display = "none";
	execSubmit(leftTime);
	
}


function execSubmit(leftTime) {
	canLeave = 1;

	var answerInfo = '<mission>';
	count = 1;
	for (i = 1; i < optArray.length; i++) {
		if (optArray[i] == undefined) continue;
		
		var que = tag('question', v('question' + i));
		var optionItems = document.getElementsByName('optionItem' + i);
		optInfo = '';
		
		for (j = 0; j < optionItems.length; j++) {

			if (optionItems[j].checked||optionItems[j].type==3) {
				optInfo += tag('option', optionItems[j].value);
				//alert(optInfo);
				
			    count++;
			}
		}
		
		answerInfo += tag('answer', que + optInfo);

	}

/*
    if (count<optArray.length) {
		alert('您还有没作答的问题！');
		return false;
	}
*/
	answerInfo += '</mission>';


	
	// alert(answerInfo);
	//return false;
	
	window.top.document.getElementById('leftTime').innerHTML = '已提交问卷！'; 
	clearInterval(window.top.timer);
	
	document.f1.answerInfo.value = answerInfo;
	document.f1.action = 'mission.do?method=submit&leftTime='+leftTime;
	document.f1.submit();


}


function saveDraft(leftTime) {
		
	if (!confirm('确实要保存草稿吗？')) {
		return false;
	}

	canLeave = 1;

	var answerInfo = '<mission>';
	count = 1;
	for (i = 1; i < optArray.length; i++) {
		if (optArray[i] == undefined) continue;
		
		var que = tag('question', v('question' + i));
		var optionItems = document.getElementsByName('optionItem' + i);
		optInfo = '';
		
		for (j = 0; j < optionItems.length; j++) {
			if (optionItems[j].checked||optionItems[j].type==3) {
				optInfo += tag('option', optionItems[j].value);
			
			    count++;
			} 
		}
		
		answerInfo += tag('answer', que + optInfo);

	}

/*
    if (count<optArray.length) {
		alert('您还有没作答的问题！');
		return false;
	}
*/
	answerInfo += '</mission>';


	
	//alert(answerInfo);
	//return false;
	
	window.top.document.getElementById('leftTime').innerHTML = '已成功保存草稿！'; 
	clearInterval(window.top.timer);
	
	leftTime = Math.floor(leftTime/60);
	
	document.f1.answerInfo.value = answerInfo;
	document.f1.action = 'mission.do?method=draft&leftTime='+leftTime;
	document.f1.target='frame1';
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

function checkIt(id){
	
	window.top.document.getElementById(id).style.backgroundColor="#9bcf00"
	
}

function findDone(){
	var type = document.getElementById("missionType").value;
	if(type==5){
		var cb = document.getElementsByTagName("input");

		for(i=0;i<cb.length;i++){

			if(cb[i].size==1){
				
				cb[i].checked=true;
				window.top.document.getElementById(cb[i].seq).style.backgroundColor="#9bcf00"
			}
		}
		
		var ta = document.getElementsByTagName("textarea");
		
		for(i=0;i<ta.length;i++){
			
			if(ta[i].value!=""){
				window.top.document.getElementById(ta[i].seq).style.backgroundColor="#9bcf00"
			}
		}
		
	}	
}


</script>

<style>
body {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 14px;
	color: #0D2A4C;
	margin: 0px;
	background-color:#f8f8f0;
}
</style>

</head>

<body onselectstart="return false" 
onpaste="return false" 
oncopy="return false;" 
oncut="return false;" 
oncontextmenu="window.event.returnValue=false;"
onload="findDone()";>
<form name="f1" method="post" action="" type="redirect" >

<input type="hidden" id="missionId" name="missionId" value="<bean:write name="missionId" />" />
<input type="hidden" id="userId" name="userId" value="<bean:write name="userId" />" />
<input type="hidden" id="missionType" name="missionType" value="<bean:write name="missionType" />" />
<input type="hidden" name="surveyId" id="surveyId" value="<bean:write name="survey" property="id" />">

<input type="hidden" id="answerInfo" name="answerInfo" value="" />

<% int idx = 0; %>
<logic:iterate id="e" name="survey" property="questionList">
<br>
<script>optArray[<bean:write name="e" property="seq" />] = 0;</script>
<input type="hidden" id="question<bean:write name="e" property="seq" />" name="question<bean:write name="e" property="seq" />" value="<bean:write name="e" property="id" />" />
<table width="95%" >
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td width="95%">
	<logic:notEqual value="4" name="e" property="type" >
	<div>
	题目<%=++idx %>：<a name="<%=idx %>"><bean:write name="e" property="name" />&nbsp;&nbsp;<logic:equal name="e" value="2" property="type">（多选题<logic:notEqual value="0" name="e" property="maxCheck">，最多选择<bean:write name="e" property="maxCheck" />个选项</logic:notEqual><logic:notEqual value="0" name="e" property="maxCheck">，最少选择<bean:write name="e" property="minCheck" />个选项</logic:notEqual>）</logic:equal></a>&nbsp;&nbsp;
	<logic:notEqual value="3" name="e" property="type">
	<logic:iterate id="e2" name="e" property="optionList">
	<script>++optArray[<bean:write name="e" property="seq" />];</script>
		<div>
		&nbsp;&nbsp;
		<logic:equal value="1" name="e" property="type">
			<input seq="<bean:write name="e" property="seq" />" size="<bean:write name="e2" property="countNum" />" type="radio" id="optionItem<bean:write name="e" property="seq" />" name="optionItem<bean:write name="e" property="seq" />" value="<bean:write name="e2" property="id" />" onclick="checkIt(<%=idx %>)" />
		</logic:equal>
		<logic:equal value="2" name="e" property="type">
			<input seq="<bean:write name="e" property="seq" />" size="<bean:write name="e2" property="countNum" />" type="checkbox" id="optionItem<bean:write name="e" property="seq" />" name="optionItem<bean:write name="e" property="seq" />" value="<bean:write name="e2" property="id" />" onclick="checkIt(<%=idx %>)" />
		</logic:equal>
			
		<bean:write name="e2" property="name" />
		</div>
	</logic:iterate>
	</logic:notEqual>
	
	<logic:equal value="3" name="e" property="type">
		<logic:notEmpty name="e" property="optionList">
		<logic:iterate id="e2" name="e" property="optionList">
		<script>++optArray[<bean:write name="e" property="seq" />];</script>
		<div>
		&nbsp;&nbsp;
		 <textarea type="3" seq="<bean:write name="e" property="seq" />" name="optionItem<bean:write name="e" property="seq" />" cols="80" rows="5" onclick="checkIt(<%=idx %>)" ><logic:notEmpty name="e2" property="text"><bean:write name="e2" property="text" /></logic:notEmpty></textarea>
		</div>
		</logic:iterate>
		</logic:notEmpty>
		
		<logic:empty name="e" property="optionList">
		<script>++optArray[<bean:write name="e" property="seq" />];</script>
		<div>
		&nbsp;&nbsp;
		 <textarea type="3" name="optionItem<bean:write name="e" property="seq" />" cols="80" rows="5" onclick="checkIt(<%=idx %>)" ></textarea>
		</div>
		</logic:empty>
	</logic:equal>
	</div>
	</logic:notEqual>
	
	<logic:equal value="4" name="e" property="type" >
	<div style="width:100%;background-color: #0e9cdf;font-size: 14px;line-height:30px;color: white;">
	&nbsp;<bean:write name="e" property="name" />
	</div>
	</logic:equal>
</td>
</table>
</logic:iterate>

<br>
<script>parent.document.getElementById("loading").style.display = 'none';
		parent.document.getElementById("tips").style.display = 'none';
</script>
</form>

</body>
</html>


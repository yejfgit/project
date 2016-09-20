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
<script type="text/javascript">



function loadAttachmentList() {
	tableId = 'attachmentList';
	var surveyId = document.getElementById('surveyId').value;
	send_request('attachment.do?method=list&surveyId=' + surveyId);
}




var optArray = new Array();
var canLeave = 0;





function doSubmit() {

	if (!confirm('确实要提交问卷吗？')) {
		return false;
	}
	
	execSubmit();


}


function execSubmit() {
	canLeave = 1;

	var answerInfo = '<mission>';
	count = 1;
	for (i = 1; i < optArray.length; i++) {
		if (optArray[i] == undefined) continue;
		
		var que = tag('question', v('question' + i));
		var optionItems = document.getElementsByName('optionItem' + i);
		optInfo = '';
		
		for (j = 0; j < optionItems.length; j++) {

			if (optionItems[j].checked) {
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

	document.f1.answerInfo.value = answerInfo;
	document.f1.action = 'mission.do?method=submit';
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

<body onselectstart="return false" 
onpaste="return false" 
oncopy="return false;" 
oncut="return false;" 
oncontextmenu="window.event.returnValue=false;">
 <table>
  <tr> 
    <td colspan="5" valign="top"><img src="../survey/images/logos1.jpg"></td>
    <td>&nbsp;</td>
  </tr></table>
<form name="f1" method="post" action="" type="redirect" >

<input type="hidden" id="missionId" name="missionId" value="<bean:write name="missionId" />" />
<input type="hidden" name="surveyId" id="surveyId" value="<bean:write name="survey" property="id" />">

<input type="hidden" id="answerInfo" name="answerInfo" value="" />
<table align="center">
<td height="32" colspan="10" style="color:;font-size:20px;">问卷名称：<bean:write name="survey" property="name" /></td>
</table>
<table align="center">
<tr>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>姓名：<logic:notEmpty name="userName"><bean:write name="userName" /></logic:notEmpty></td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td height="21">&nbsp;</td>
</tr>
<tr>
<td colspan="100" valign="top"><hr> &nbsp;</td>
</tr>
</table>
<br>

<div align="center" id="timeLimit">&nbsp;</div>
<div align="center" id="leftTime" style="color: blue">&nbsp;</div>  
<script>  
    
    var timeLimit = <bean:write name="survey" property="timeLimit" />;
    
    if (timeLimit > 0) {

	    document.getElementById('timeLimit').innerHTML = '此次问卷的答题时间是：' + timeLimit + '分钟，请您及时作答，到时后系统将自动提交。';   
	    var leftTime = timeLimit * 60;
	    function showLeftTime(){  
	        var leftMinutes = parseInt(leftTime/60);  
	        var leftSeconds = parseInt(leftTime%60);  
	          
	        if(leftTime < 0){  
	            //document.getElementById('leftTime').innerHTML = '您的问卷已超时，请您尽快提交';
	            alert('您的答卷时间已到，系统将自动提交。');
	            execSubmit();
	        }else{  
	            document.getElementById('leftTime').innerHTML = '剩余时间：'+leftMinutes+'分'+leftSeconds+'秒';  
	        }  
	        leftTime--;  
	    }  
	    var timer = setInterval('showLeftTime()',1000);  
    
    }
    
    
    
    
    window.onbeforeunload = function() {
    	if (canLeave == 0) {
	    	return "如果刷新或关闭本窗口，您的答案将全部清空。";
	    }
    };

</script> 




<div id="attachmentList"></div>
<script>

loadAttachmentList();

</script>




<% int idx = 0; %>
<logic:iterate id="e" name="survey" property="questionList">
<br>
<script>optArray[<bean:write name="e" property="seq" />] = 0;</script>
<input type="hidden" id="question<bean:write name="e" property="seq" />" name="question<bean:write name="e" property="seq" />" value="<bean:write name="e" property="id" />" />
<table>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td><div>
	题目<%=++idx %>：<bean:write name="e" property="name" />

	<logic:iterate id="e2" name="e" property="optionList">
	<script>++optArray[<bean:write name="e" property="seq" />];</script>
		<div>
		&nbsp;&nbsp;
		
		<logic:equal value="1" name="e" property="type">
			<input type="radio" id="optionItem<bean:write name="e" property="seq" />" name="optionItem<bean:write name="e" property="seq" />" value="<bean:write name="e2" property="id" />" />
		</logic:equal>
		<logic:equal value="2" name="e" property="type">
			<input type="checkbox" id="optionItem<bean:write name="e" property="seq" />" name="optionItem<bean:write name="e" property="seq" />" value="<bean:write name="e2" property="id" />" />
		</logic:equal>
		
		<bean:write name="e2" property="name" />
		</div>
	</logic:iterate>

</div></td>
</table>
</logic:iterate>

<br>
<div align="center"> <input type="button" value="提交问卷"  onclick="doSubmit()" /></div>

</form>

</body>
</html>


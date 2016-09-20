<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="struts-bean.tld" prefix="bean" %>
<%@ taglib uri="struts-html.tld" prefix="html" %>
<%@ taglib uri="struts-logic.tld" prefix="logic" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>回答问卷</title>
		<script language="javascript" src="js/common.js"></script>
		<script language="javascript" src="js/boxover.js"></script>
		<script language="javascript" src="js/json.js"></script>
		<link href="css/css.css" rel="stylesheet" type="text/css">
		<script language="javascript" src="js/ajax.js"></script>
<style>
　　html { 
　　overflow-y:auto!important; 
　　*overflow-y:scroll; 
　　} 

</style>
<script type="text/javascript">

var optArray = new Array();


function showDialog(url) {
	window.showModalDialog(url,window,'dialogWidth:800px;dialogHeight:300px;Resizable:0;help:no;scroll:yes;status:No;center:yes;edge:Raised;');
}

function doSubmit() {
	document.f1.action = 'library.do?method=list';
	document.f1.submit();
}

function doEdit() {
	
	var libraryId = document.getElementById('libraryId').value;
	location.href = 'library.do?method=edit&libraryId=' + libraryId;


}

function doDelete() {

	if (!confirm('确实要删除吗？')) {
		return false;
	}
	var libraryId = document.getElementById('libraryId').value;
	window.location.href='library.do?method=del&libraryId='+libraryId;


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

function findRight(){
	var type = v("surveyType");
	if(type==1){
		var cb = document.getElementsByTagName("input")

		for(i=0;i<cb.length;i++){
			if(cb[i].value==1){
				cb[i].checked=true;
			}
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

function createSurvey(type) {
	var sids="";
	var slist = document.getElementsByName("queId");
	for(i=0;i<slist.length;i++){
		if(slist[i].checked==true){
			sids+=slist[i].value+",";
		}
	}
	
	if(sids==""||sids.length==0){
		alert("请选择试题！");
		return false;
	}
	
	document.f1.action = 'library.do?method=createSurvey&type='+type+'&sids='+sids;
	document.f1.submit();
}

function createSurveyRandom() {
	var cts="[";
	var slist = document.getElementsByName("ct");
	
	for(i=0;i<slist.length;i++){
		if(slist[i].value!=0){
			if(!/^[0-9]*$/.test(slist[i].value)){
        		alert("请正确输入题目数量！");
        		return false;
    		}
			var categoryVO = new CategoryVO(slist[i].typeId,slist[i].id,slist[i].value);
			cts+=categoryVO.toJSONString()+",";
		}
	}
	
	cts+="]";

	if(cts==""||cts.length==0){
		alert("请选择试题！");
		return false;
	}
	var types = document.getElementsByName("type");
	var type = 1;
	for(i=0;i<types.length;i++){
		if(types[i].checked==true){
			type = types[i].value;
		}
	}

	document.getElementById("policy").value=cts;

	document.f1.action = 'library.do?method=createSurveyRandom&type='+type;
	document.f1.submit();
}

function CategoryVO(type,category,num){
	this.type = type;
	this.category = category;
	this.num = num;
}


</script>

<style>
table{
	font-size:14px;
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

<body>
<form name="f1" method="post" action="">

<input type="hidden" name="library.id" id="libraryId" value="<bean:write name="library" property="id" />">
<input type="hidden" name="library.policy" id="policy" >
<table align="center" width="80%" height="24"  border="0" cellpadding="0" cellspacing="0">
  <tr style="color:#0e9cdf;font-size:14px;vertical-align:bottom;">
  	<td height="30px" ><strong><a href="library.do?method=list" style="color:#0e9cdf;" target="mainFrame">首页</a> >> 查看题库</strong>&nbsp;&nbsp;</td>
  	<td align="right"><a href="#" style="color: #0e9cdf" onclick="doEdit(); return false;"><img src="../survey/images/newImages/edit.bmp" />修改</a>
	&nbsp;&nbsp;
	<a href="#" onclick="doDelete()" style="color: #0e9cdf"><img src="../survey/images/newImages/del.bmp" />删除</a>
	&nbsp;&nbsp;
	
	</td>
  </tr>
  <tr style="font-size: 18px">
	<td height="32" colspan="10" align="center" style="color:;font-size:24px;"><strong>题库名称：<bean:write name="library" property="name" /></strong></td>
  </tr>
  <tr>
  	<td height="30px">
  	</td>
  </tr>
</table>

<table align="center" width="80%">

	<logic:iterate id="e" name="library" property="categorys">
	<tr>
		<td width="10%"><strong><bean:write name="e" property="typeName" />：</strong></td>
		<td width="90%">
				<logic:iterate id="e2" name="e" property="categorys">
					<bean:write name="e2" property="category" />：<input type="text" size="3" typeId="<bean:write name="e" property="type" />" id="<bean:write name="e2" property="category" />" name="ct" value="<bean:write name="e2" property="num" />">个；&nbsp;&nbsp;
				</logic:iterate>
		</td>
	</tr>
	</logic:iterate>
  <tr>
  	<td colspan="2" align="center">
  		<input type="radio" id="type" name="type" value="2" checked>调查&nbsp;&nbsp;<input type="radio" id="type" name="type" value="1">考试&nbsp;&nbsp;&nbsp;&nbsp;
		<button type="button" id="a" onclick="createSurveyRandom()" onmouseover="overChangeBtn(this)" onmouseout="outChangeBtn(this)" class="btn">随机生成问卷</button> &nbsp;&nbsp;
  	</td>
  </tr>
</table>

<table width="80%" align="center" style="table-layout:fixed ; word-break: break-all; overflow:hidden; ">
<tr>
	<td width="100%">
<%int i=0; %>
<logic:iterate id="e" name="library" property="questionList">
<br>
<script>optArray[<bean:write name="e" property="id" />] = 0;</script>
<input type="hidden" id="question<bean:write name="e" property="id" />" name="question<bean:write name="e" property="id" />" value="<bean:write name="e" property="id" />" />
<div>
<input type="checkbox" id="queId" name="queId" value="<bean:write name="e" property="id" />">
<logic:equal value="1" name="e" property="type" >
	题目<%=++i %>：<bean:write name="e" property="name" />&nbsp;&nbsp;（单选题）&nbsp;&nbsp;分类：<bean:write name="e" property="category" />
		<logic:iterate id="e2" name="e" property="optionList">
		<script>++optArray[<bean:write name="e" property="id" />];</script>
		<div>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" id="optionItem<bean:write name="e" property="id" />" name="optionItem<bean:write name="e" property="id" />" value="" />
		<bean:write name="e2" property="name" />&nbsp;&nbsp;&nbsp;&nbsp;
		</div>
		</logic:iterate>
		<hr>
</logic:equal>

<logic:equal value="2" name="e" property="type" >
	题目<%=++i %>：<bean:write name="e" property="name" />&nbsp;&nbsp;（多选题）&nbsp;&nbsp;分类：<bean:write name="e" property="category" />
		<logic:iterate id="e2" name="e" property="optionList">
		<script>++optArray[<bean:write name="e" property="id" />];</script>
		<div>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" id="optionItem<bean:write name="e" property="id" />" name="optionItem<bean:write name="e" property="id" />" value="" />
		<bean:write name="e2" property="name" />&nbsp;&nbsp;&nbsp;&nbsp;
		</div>
		</logic:iterate>
		<hr>
</logic:equal>

<logic:equal value="3" name="e" property="type" >
	题目<%=++i %>：<bean:write name="e" property="name" />&nbsp;&nbsp;（问答题）&nbsp;&nbsp;分类：<bean:write name="e" property="category" />
		<hr>
</logic:equal>

</div>
</logic:iterate>

<div align="center">
	<button type="button" id="a" onclick="createSurvey(2)" onmouseover="overChangeBtn(this)" onmouseout="outChangeBtn(this)" class="btn">生成调查问卷</button> &nbsp;&nbsp; 
	<button type="button" id="a" onclick="createSurvey(1)" onmouseover="overChangeBtn(this)" onmouseout="outChangeBtn(this)" class="btn">生成考试问卷</button> &nbsp;&nbsp;
	<button type="button" id="a" onclick="doSubmit()" onmouseover="overChangeBtn(this)" onmouseout="outChangeBtn(this)" class="btn">返回</button>
</div>
</td>
</tr>
</table>
</form>
</body>
</html>


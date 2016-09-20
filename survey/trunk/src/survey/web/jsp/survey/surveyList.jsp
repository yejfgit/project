<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="struts-bean.tld" prefix="bean" %>
<%@ taglib uri="struts-html.tld" prefix="html" %>
<%@ taglib uri="struts-logic.tld" prefix="logic" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">

<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title></title>
		<link href="../survey/css/css.css" rel="stylesheet" type="text/css">
		<script language="javascript" src="../survey/js/common.js"></script>
		<script language="javascript" src="../survey/js/boxover.js"></script>
		<script LANGUAGE="JavaScript">

function doDelete(id,num){
	var surveyType=document.getElementById("surveyType").value;
	if(num>0){
		if (!confirm('删除此问卷会关闭已下发的任务，确实要删除吗？')) {
			return false;
		}
	}else{
		if (!confirm('确实要删除吗？')) {
			return false;
		}
	}
	location.href='survey.do?method=delete&surveyId='+id+'&type='+surveyType;
}

function doEdit(id,num){
	
	if(num>0){
		if (!confirm('修改此问卷需关闭已下发的任务，确实要修改吗？')) {
			return false;
		}
	}
	
//	window.open("survey.do?method=edit&surveyId="+id);
//	location.href="survey.do?method=adminList";
	window.location.href='survey.do?method=edit&surveyId='+id;
	//window.open("survey.do?method=edit&surveyId="+id);
	
}

//下发问卷
function dispatch(id){
	window.showModalDialog("dispatch.do?method=index&surveyId="+id , window, 'dialogWidth:900px;dialogHeight:600px;Resizable:0;help:no;status:No;center:yes;edge:Raised;');
	//window.open('dispatch.do?method=index&surveyId='+id);
	//window.location.href = window.location.href;
	window.location.reload();
}


//按钮改变颜色
function overChangeBtn(btn){
	btn.style.backgroundColor="#9bcf00";
}

function outChangeBtn(btn){
	btn.style.backgroundColor="#0e9cdf";
}

function overChangeBtn1(btn){
	btn.style.backgroundColor="#EBB10F"
}

function outChangeBtn1(btn){
	btn.style.backgroundColor="#EBB10F"
}

//改变A标签字体颜色
function overChangeA(a){
	a.style.color="#0e9cdf";
}

function outChangeA(a){
	a.style.color="#333333";
}

//改变A标签字体颜色
function overChangeA1(a){
	a.style.color="#0e9cdf";
}

function outChangeA1(a){
	a.style.color="white";
}

function addKs(){
	location.href="survey.do?method=addKs";
}

function addDc(){
	location.href="survey.do?method=addDc";
}

function blink(){

	for(i=0;i<aa.length;i++)
	{
		setTimeout('toBlink(obj[i])', 100);
	}
}

function toBlink(obj){
	var color = obj.style.color;
	if(color=="white"){
		color = "#0e9cdf";
	}else if(color = "#0e9cdf"){
		color=="white";
	}
}


//分页相关操作
function doQueryByName(){
	
	var surveyName = document.getElementById("surveyName").value;
	var type=document.getElementById("surveyType").value; 
	window.location.href = 'survey.do?method=WJList&type='+type+'&surveyName='+strEncode(surveyName);
}

function doQuery(pageNum){
	
	var surveyName = document.getElementById("surveyName").value;
	var type=document.getElementById("surveyType").value;
	location.href = 'survey.do?method=WJList&type='+type+'&pageNum='+pageNum+'&surveyName='+strEncode(surveyName);
}

function nextPage() {

	pageNum = document.getElementsByName("pageNum")[0].value;
	if (pageNum == 0) {
		pageNum = 1;
	}
	document.getElementsByName("pageNum")[0].value = Math.abs(pageNum) + 1;
	//alert(document.getElementsByName("pageNum")[0].value);
	doQuery(Math.abs(pageNum) + 1);
}

function prevPage() {
	pageNum = document.getElementsByName("pageNum")[0].value;
	if (pageNum == 0) {
		pageNum = 1;
	}
	document.getElementsByName("pageNum")[0].value = Math.abs(pageNum) - 1;
	doQuery(Math.abs(pageNum) - 1);
}

function jumpPage() {

	pageNum = document.getElementsByName("jumpPageNum")[0].value;
	if (!(/^\d+$/g.test(pageNum))) {
		document.getElementsByName("jumpPageNum")[0].value = '';
		return false;
	}
	//alert(pageNum);
	document.getElementsByName("pageNum")[0].value = pageNum;
	doQuery(pageNum);
}

function strEncode(str) {
	return encodeURI(encodeURI(str));
}

function show(){
	window.showModalDialog("http://10.17.2.3:8080/show/index.html" , window, 'dialogWidth:1024px;dialogHeight:768px;Resizable:0;help:no;status:No;center:yes;edge:Raised;');
}
function showNew(){
	window.showModalDialog("http://10.17.2.3:8080/show_new/index.html" , window, 'dialogWidth:1024px;dialogHeight:768px;Resizable:0;help:no;status:No;center:yes;edge:Raised;');
}

function goLibrary(){
	location.href="library.do?method=list";
}
<!--
-->
</SCRIPT>
<style>

</style>
</head>

<body style="margin-top: 0;">
<form id="f1" name="f1" method="post" action="">
<input type="hidden" id="surveyType" value="<logic:notEmpty name="type"><bean:write name="type" /></logic:notEmpty>" >&nbsp;&nbsp;
<!-- <table align="center" width="70%" height="24"  border="0" cellpadding="0" cellspacing="0">
  <tr>
  	<td height="20px"></td>
  </tr>
</table> -->
<logic:empty name="pagevo">
<table width="72%" border="0"  bordercolor="#828282" align="center" cellpadding="0"
				cellspacing="0" style="table-layout:fixed">
<tr>
    <td height="400px" align="center">
			<span style="font-size: 25px;">欢迎使用在线问卷系统，赶快来<logic:equal value="2" name="type"><a href="#" onclick="addDc()">创建</a>您的第一份调查问卷吧！	</logic:equal><logic:equal value="1" name="type"><a href="#" onclick="addKs()">创建</a>您的第一份考试问卷吧！</logic:equal>
  			</span>
   </td>
</tr>
</table>
</logic:empty>
<logic:notEmpty name="pagevo">
<div >
<table style="width: 1024px; height: 40px" align="center" cellpadding="0"
				cellspacing="0" border="0" >
<tr>
	<td >
		<logic:equal value="2" name="type">
		<input name="new" style=""  class="addButton" type="button" onmouseover="overChangeBtn1(this)" onmouseout="outChangeBtn1(this)" onclick="addDc()" value="新建调查问卷">&nbsp;&nbsp;&nbsp;
		</logic:equal>
		<logic:equal value="1" name="type">
    	<input name="new" class="addButton" type="button" onmouseover="overChangeBtn1(this)" onmouseout="outChangeBtn1(this)" onclick="addKs()" value="新建考试问卷">&nbsp;&nbsp;&nbsp;
    	</logic:equal>
    	<!-- 
    	<a style="color: white;" href="#" onclick="show();return false;" onmouseover="overChangeA1(this)" onmouseout="outChangeA1(this)">
    		如何创建问卷？
    	</a>&nbsp;&nbsp;
    	<a style="color: white;" href="#" onclick="showNew();return false;" onmouseover="overChangeA1(this)" onmouseout="outChangeA1(this)">
    		新版本，新功能！
    	</a>
    	 -->
    </td>
    
	<td width="40%" height="27" align="right" valign="center" >
	<input name="new" style="background-color:white;height: 25px;border: 1px;border-color: #828282 " type="hidden" onmouseover="overChangeBtn1(this)" onmouseout="outChangeBtn1(this)" onclick="goLibrary()" value="进入题库">&nbsp;&nbsp;&nbsp;
		<input type="text" id="surveyName" style="height: 20px" value="<logic:notEmpty name="surveyName"><bean:write name="surveyName" /></logic:notEmpty>" >&nbsp;&nbsp;
		<img alt="搜索" src="images/search.png" onclick="doQueryByName()" style="height: 30px; width: 30px;position: relative;top: 10px;">
	</td>
</tr>

	<%
		int i = 0;
	%>
</table>
</div>

<br>
<table style="width: 1024px;border: 0px;" bordercolor="#828282" align="center" cellpadding="0"
				cellspacing="0" style="table-layout:fixed;border: 0px solid #ddd;border-bottom:0px;background-color:white;">
<tr>
    <td width="100%" colspan="2">
		<table width="100%" border="0" style="background-color: #F9F9F9;font-size: 15px;border-bottom: 1px solid #9ED18E;border-top: 2px solid #34A637">
			<tr>
				<td height="45px" width="25%" align="left" style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all;text-align: left;padding-left: 15px;">问卷名称</td>
				<td height="45px" width="15%" align="center" style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all;text-align: left;padding-left: 5px;">创建时间</td>
				<td height="45px" width="10%" align="center" style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all;text-align: left;padding-left: 5px;">完成情况</td>
				<td height="45px" width="50%" align="center" style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all;text-align: left;padding-left: 5px;">操作</td>
			</tr>
		</table>
	</td>
</tr>
<logic:iterate id="element" name="pagevo" property="objectList" indexId="index1">

	<tr onMouseOver="this.bgColor='#F8F1C5'" onMouseOut="this.bgColor='ffffff'" >
		<td width="100%" colspan="2" style="border-bottom: 1px solid #ddd">
			<table width="100%" border="0">
				<tr>
				
				<td align="left" width="25%" style="font-size: 14px;padding-left: 15px;" >
					<bean:write name="element" property="name" />
				</td>
				<td align="left" width="15%" style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all;color: #333333;font-size: 14px;">
					<bean:write name="element" property="createTime" />				
				</td>
				<td height="35px" width="10%" align="center" nowrap style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all;text-align: left;padding-left: 5px;">
					<logic:notEqual value="0" name="element" property="dispatchNum">
					<bean:write name="element" property="finishedNum" />&nbsp;/&nbsp;<bean:write name="element" property="dispatchNum" />
					</logic:notEqual>
					<logic:equal value="0" name="element" property="dispatchNum">
					&nbsp;0 / 0
					</logic:equal>
				</td>
				<td align="right" width="50%" nowrap style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all;color:#828282;text-align: left;padding-left: 5px;">
					<a href="survey.do?method=view&surveyId=<bean:write name="element" property="id" />#viewResult" onclick="" style="color: #0e9cdf"><img src="../survey/images/newImages/viewSurvey.bmp" />查看</a>
							&nbsp;&nbsp;
					<a href="#" style="color: #0e9cdf" onclick="doEdit(<bean:write name="element" property="id" />, <bean:write name="element" property="num" />); return false;"><img src="../survey/images/newImages/edit.bmp" />修改</a>
							&nbsp;&nbsp;
					<a href="dispatch.do?method=index&surveyId=<bean:write name="element" property="id" />"  style="color: #0e9cdf"><img src="../survey/images/newImages/fabu.bmp">下发</a>
							&nbsp;&nbsp;
					
					<logic:notEqual value="0" name="element" property="dispatchNum">
					<a href="mission.do?method=monitor&surveyId=<bean:write name="element" property="id" />" onclick="" style="color: #0e9cdf"><img src="../survey/images/newImages/report.bmp" />结果分析</a>
					</logic:notEqual>
					<logic:equal value="0" name="element" property="dispatchNum">
					<img src="../survey/images/newImages/report1.bmp" />结果分析
					</logic:equal>
					&nbsp;&nbsp;
					<!--<a href="#" onclick="" style="color: #0e9cdf"><img src="../survey/images/newImages/print.bmp" />打印</a>-->
					
					<a href="survey.do?method=copy&surveyId=<bean:write name="element" property="id" />" style="color: #0e9cdf"><img src="../survey/images/newImages/copy.bmp" />复制</a>
							&nbsp;&nbsp;
					<a href="#" onclick="doDelete(<bean:write name="element" property="id" />,<bean:write name="element" property="num" />)" style="color: #0e9cdf"><img src="../survey/images/newImages/del.bmp" />删除</a>
							&nbsp;&nbsp;
					<a href="survey.do?method=setSurvey&id=<bean:write name="element" property="id" />" style="color: #0e9cdf"><img src="../survey/images/newImages/set.bmp" />设置</a>
							&nbsp;&nbsp;
					
				
					
					
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					
				</td>
				</tr>
			</table>
		</td>
	</tr>

   </logic:iterate>
 
</table>
 </logic:notEmpty>
 <logic:notEmpty name="pagevo">
<input type="hidden" name="pageNum" value="<logic:notEmpty name="pagevo"><bean:write name="pagevo" property="pageNum" /></logic:notEmpty><logic:empty name="pagevo">1</logic:empty>" />

<table width="1024px" align="center" height="28px"  border="0" bordercolor="#828282" align="center" cellpadding="2"
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

</logic:notEmpty>
</br>
</br>
</br>
</form>
</div>
</body>
</html>


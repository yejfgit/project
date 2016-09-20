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

function doDelete(id){
	if (!confirm('确实要删除吗？')) {
		return false;
	}

	location.href='library.do?method=del&libraryId='+id;
}

function doEdit(id,num){
	
	if(num>0){
		if (!confirm('确实要修改吗？')) {
			return false;
		}
	}
	
	location.href='library.do?method=edit&libraryId='+id;
	
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
	btn.style.color="#0e9cdf"
}

function outChangeBtn1(btn){
	btn.style.color="#333333"
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

function addLib(){
	location.href="library.do?method=add";
}


function batchAdd(lid){
	location.href="import.do?method=toImport&libraryId="+lid;
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
	
	var libraryName = document.getElementById("libraryName").value;
	window.location.href = 'library.do?method=list&libraryName='+strEncode(libraryName);
}

function doQuery(pageNum){
	
	var libraryName = document.getElementById("libraryName").value;

	location.href = 'library.do?method=list&pageNum='+pageNum+'&libraryName='+strEncode(libraryName);
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

function goSurvey(){
	location.href="survey.do?method=adminList";
}
<!--
-->
</SCRIPT>

</head>

<body>
<form id="f1" name="f1" method="post" action="">
<table align="center" width="70%" height="24"  border="0" cellpadding="0" cellspacing="0">
  <tr>
  	<td height="20px"></td>
  </tr>
</table>

<table width="72%" border="1" bordercolor="#828282" align="center" cellpadding="0"
				cellspacing="0" style="table-layout:fixed">
<tr bgcolor="#828282" height="35px">
	<td>
		&nbsp;&nbsp;&nbsp;&nbsp;
    	<input name="new" style="background-color:white;height: 25px;border: 1px;border-color: #828282 " type="button" onmouseover="overChangeBtn1(this)" onmouseout="outChangeBtn1(this)" onclick="addLib()" value="+ 新建题库">&nbsp;&nbsp;&nbsp;
    	<input name="new" style="background-color:white;height: 25px;border: 1px;border-color: #828282 " type="button" onmouseover="overChangeBtn1(this)" onmouseout="outChangeBtn1(this)" onclick="batchAdd(0)" value="+ 导入题库">&nbsp;&nbsp;&nbsp;
    	<a style="color: white;" href="#" onclick="show();return false;" onmouseover="overChangeA1(this)" onmouseout="outChangeA1(this)">
   
    	</a>&nbsp;&nbsp;
    </td>
	<td width="40%" height="27" align="right"  >
	<input name="new" style="background-color:white;height: 25px;border: 1px;border-color: #828282 " type="button" onmouseover="overChangeBtn1(this)" onmouseout="outChangeBtn1(this)" onclick="goSurvey()" value="进入试卷库">&nbsp;&nbsp;&nbsp;
		<input type="text" id="libraryName" value="<logic:notEmpty name="libraryName"><bean:write name="libraryName" /></logic:notEmpty>" >&nbsp;&nbsp;
		<input type="button" style="background-color: white" onclick="doQueryByName()" onmouseover="overChangeBtn1(this)" onmouseout="outChangeBtn1(this)" value="搜索"> &nbsp;&nbsp;
	</td>
</tr>
<logic:notEmpty name="pagevo">
	<%
		int i = 0;
	%>
<logic:iterate id="element" name="pagevo" property="objectList" indexId="index1">

	<tr onMouseOver="this.bgColor='#F8F1C5'"onMouseOut="this.bgColor='ffffff'">
		<td width="100%" colspan="2">
			<table width="100%" border="0">
				<tr>
				<%
					i++;
					if(i%2==0){
	 			%>
				<td height="25" width="5px" align="center" style="border:0px;border-color:#0e9cdf ;background-color:#0e9cdf ">
					&nbsp;
				</td>
				<% 
					}
					if(i%2==1){
				%>
				<td height="25" width="5px" align="center" style="border:0px;border-color:#9bcf00 ;background-color:#9bcf00 ">
					&nbsp;
				</td>
				<%
					}
	 			%>
				<td height="25" width="3%" align="center" style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all">
				
				</td>
				<td align="left" width="50%" style="font-size: 14px;">
					<a style="color: #333333;" href="library.do?method=view&libraryId=<bean:write name="element" property="id" />" onmouseover="overChangeA(this)" onmouseout="outChangeA(this)">
					<bean:write name="element" property="name" /></strong></a>
				</td>
				<td align="left" width="45%" style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all;color: #333333;font-size: 14px;">
					&nbsp;&nbsp;<bean:write name="element" property="createTime" />				
				</td>
				</tr>
				<tr style="color: #0e9cdf">
				<td height="25" width="10px" align="center" nowrap style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all">
					&nbsp;
				</td>
				<td height="25" width="3%" align="center" nowrap style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all">
					&nbsp;
				</td>
				<td align="left" width="60%" nowrap style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all;color:#828282">
					<a href="#" style="color: #0e9cdf" onclick="doEdit(<bean:write name="element" property="id" />); return false;"><img src="../survey/images/newImages/edit.bmp" />修改</a>
							&nbsp;&nbsp;
					<a href="#" onclick="batchAdd(<bean:write name="element" property="id" />)" style="color: #0e9cdf"><img src="../survey/images/newImages/fabu.bmp">导入试题</a>
							&nbsp;&nbsp;
				</td>
				<td align="left" width="35%" nowrap style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all;color:#828282">
					&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="doDelete(<bean:write name="element" property="id" />)" style="color: #0e9cdf"><img src="../survey/images/newImages/del.bmp" />删除</a>
							&nbsp;&nbsp;
				</td>
				</tr>
			</table>
		</td>
	</tr>

   </logic:iterate>
  </logic:notEmpty>
</table>
<input type="hidden" name="pageNum" value="<logic:notEmpty name="pagevo"><bean:write name="pagevo" property="pageNum" /></logic:notEmpty><logic:empty name="pagevo">1</logic:empty>" />
<logic:notEmpty name="pagevo">
			

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

</logic:notEmpty>
</br>
</br>
</br>
</form>
</body>
</html>


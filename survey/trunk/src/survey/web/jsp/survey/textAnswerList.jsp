<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="struts-bean.tld" prefix="bean" %>
<%@ taglib uri="struts-html.tld" prefix="html" %>
<%@ taglib uri="struts-logic.tld" prefix="logic" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">

<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>查看答案</title>
		<link href="../survey/css/css.css" rel="stylesheet" type="text/css">
		<script language="javascript" src="../survey/js/common.js"></script>
		<script language="javascript" src="../survey/js/boxover.js"></script>
		<script LANGUAGE="JavaScript">

function doDelete(id){
		if (!confirm('确实要删除吗？')) {
			return false;
	}
	location.href='survey.do?method=delete&surveyId='+id;
}

function doEdit(id,num){
	
	if(num>0){
		if (!confirm('修改此问卷需关闭已下发的任务，确实要修改吗？')) {
			return false;
		}
	}
	
	window.showModalDialog("survey.do?method=edit&surveyId="+id);
	location.herf="survey.do?method=adminList";
}

//分页相关操作
function doQuery(pageNum){
	var questionId = document.getElementById('questionId').value;

	location.href = 'survey.do?method=viewTextAnswer&questionId='+questionId+'&pageNum='+pageNum;
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

//主观题评分
function mark(id){
	var score = document.getElementById(id).value;
	var queScore = document.getElementById("questionScore").value;
	var questionId = document.getElementById("questionId").value;
	var surveyType = document.getElementById("surveyType").value;

	if(surveyType==1&&parseInt(score) > parseInt(queScore)){
		alert("本题所给分数大于题目分数");
		return false;
	}

	pageNum = document.getElementsByName("pageNum")[0].value;
	
	location.href = 'survey.do?method=markTextAnswer&id='+id+'&score='+score+'&pagNum='+pageNum+'&questionId='+questionId;
}

//按钮改变颜色
function overChangeBtn(btn){
	btn.style.backgroundColor="#9bcf00";
}

function outChangeBtn(btn){
	btn.style.backgroundColor="#0e9cdf";
}

<!--
-->
</SCRIPT>

<style>
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
<form id="f1" name="f1" method="post" action="">
<input type="hidden" id="questionId" value="<bean:write name="questionId" />">
<input type="hidden" id="questionScore" value="<bean:write name="queScore" />">
<input type="hidden" id="surveyType" value="<bean:write name="surveyType" />">
<table align="center" width="80%" height="24"  border="0" cellpadding="0" cellspacing="0" style="table-layout:fixed ; word-break: break-all; overflow:hidden; ">
  <tr>
  	<td height="30px" style="color:#0e9cdf;font-size:14px;vertical-align:bottom;"><strong><strong><a href="survey.do?method=adminList" style="color:#0e9cdf;" target="mainFrame">首页</a> >> 查看问卷 >> 查看答案和评分</strong></td>
  </tr>
  <tr style="font-size: 18px">
	<td align="center" style="font-size:20px;vertical-align: top;" width="100%"><strong><bean:write name="queName"  />(<bean:write name="queScore"  />分)</strong>
    </td>
  </tr>
  <tr>
  	<td height="30px"></td>
  </tr>
</table>

			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td>
						<img src="../images/_blank.gif" width="2" height="7"></td>
				</tr>
			</table>

<table width="80%" align="center" border="1" bordercolor="#828282" align="center" cellpadding="2"
				cellspacing="0" style="table-layout:fixed;font-size:12px">
<tr bgcolor="#828282">
<td width="5%" height="27" align="center" class="tabtitle">序号</td>
<td width="45%" height="27" align="center" class="tabtitle">答案</td>
<td width="20%" height="27" align="center" class="tabtitle">机构</td>
<td width="10%" height="27" align="center" class="tabtitle">用户名</td>
<td width="15%" height="27" align="center" class="tabtitle">评分</td>
</tr>	
             
<logic:notEmpty name="pagevo">
<logic:iterate id="element" name="pagevo" property="objectList" indexId="index1">

    <tr onMouseOver="this.bgColor='#F8F1C5'" onMouseOut="this.bgColor='ffffff'">
  <td nowrap style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all" align="center"><%=++index1%></td>
  <td align="left"><bean:write name="element" property="text" />&nbsp;</td>
    <td height="25" align="center">
	   <bean:write name="element" property="fullName" />
    </td>
    <td nowrap style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all" align="center"><bean:write name="element" property="realName" /></td>
     <td nowrap style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all" align="center">
     <logic:equal value="0" name="element" property="isRead">
     <input type="text" size="1" id="<bean:write name="element" property="id" />" value="<bean:write name="element" property="score" />">分
     <input type="button" value="评分" id="read" class="btn" onmouseover="overChangeBtn(this)" onmouseout="outChangeBtn(this)" onclick="mark(<bean:write name="element" property="id" />)">
     
     </logic:equal>
     <logic:equal value="1" name="element" property="isRead">
     <bean:write name="element" property="score" />分
     </logic:equal>
     </td>
	</tr>



</logic:iterate>
</logic:notEmpty>
</table>


<input type="hidden" name="pageNum" value="<logic:notEmpty name="pagevo"><bean:write name="pagevo" property="pageNum" /></logic:notEmpty><logic:empty name="pagevo">1</logic:empty>" />
<logic:notEmpty name="pagevo">
			

<table width="80%" align="center" height="18"  border="0" bordercolor="#828282" align="center" cellpadding="2"
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
						<input type="button" name="bprev" value="上一页" class="btn" onmouseover="overChangeBtn(this)" onmouseout="outChangeBtn(this)" onClick="prevPage();">
					</logic:equal>
					<logic:equal name="pagevo" property="hasPrevButton" value="0">
						<input type="button" name="bprev" value="上一页" style=" vertical-align:top;background-color:white" disabled="disabled">
					</logic:equal>
					<logic:equal name="pagevo" property="hasNextButton" value="1">
						<input type="button" name="bnext" value="下一页" class="btn" onmouseover="overChangeBtn(this)" onmouseout="outChangeBtn(this)" onClick="nextPage();">
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

</form>
</body>
</html>


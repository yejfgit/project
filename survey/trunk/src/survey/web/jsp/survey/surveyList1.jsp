<%@ page language="java" pageEncoding="UTF-8"%>
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
	location.href='survey.do?method=delete&surveyId='+id;
}

function doEdit(id,num){
	
	if(num>0){
		if (!confirm('修改此问卷需关闭已下发的任务，确实要修改吗？')) {
			return false;
		}
	}
	
//	window.open("survey.do?method=edit&surveyId="+id);
//	location.href="survey.do?method=adminList";
	location.href="survey.do?method=edit&surveyId="+id;
}

//下发问卷
function dispatch(id){
	window.showModalDialog("dispatch.do?method=index&surveyId="+id , window, 'dialogWidth:700px;dialogHeight:570px;Resizable:0;help:no;status:No;center:yes;edge:Raised;');
	//window.open('dispatch.do?method=index&surveyId='+id);
}


//按钮改变颜色
function overChangeBtn(btn){
	btn.style.backgroundColor="#9bcf00";
}

function outChangeBtn(btn){
	btn.style.backgroundColor="#0e9cdf";
}

//改变A标签字体颜色
function overChangeA(a){
	a.style.color="#0e9cdf";
}

function outChangeA(a){
	a.style.color="#333333";
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


<!--
-->
</SCRIPT>
</head>

<body>
<table align="center" width="80%" height="24"  border="0" cellpadding="0" cellspacing="0">
  <tr>
  	<td height="40px"></td>
  </tr>
  <tr style="font-size: 18px">
    <td style="background-color: #676b6d;color:white;" align="center" height="35px" width="15%"><strong>我的问卷</strong></td>
    <td width="55%">&nbsp;</td>
    <td align="right" width="30%">
    	<input name="new" style="background-color:#0e9cdf;height: 25px;color: white;border: 1px " type="button" onmouseover="overChangeBtn(this)" onmouseout="outChangeBtn(this)" onclick="addDc()" value="+ 新建调查问卷">&nbsp;&nbsp;&nbsp;&nbsp;
    	<input name="new" style="background-color:#0e9cdf;height: 25px;color: white;border: 1px " type="button" onmouseover="overChangeBtn(this)" onmouseout="outChangeBtn(this)" onclick="addKs()" value="+ 新建考试问卷">
    </td>
  </tr>
  <tr>
  	<td height="50px"></td>
  </tr>
</table>

<table width="80%" border="1" bordercolor="#828282" align="center" cellpadding="2"
				cellspacing="0" style="table-layout:fixed">
<tr>
<td width="100%" height="27" bgcolor="#828282" ></td>
</tr>
	<logic:iterate id="element" name="sList" indexId="index1" >
	<tr onMouseOver="this.bgColor='#F8F1C5'"onMouseOut="this.bgColor='ffffff'">
		<td width="100%">
			<table width="100%" border="0">
				<tr>
				<td height="25" width="8%" align="center" style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all">
					<%=++index1%>
				</td>
				<td align="left" width="50%" style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all;font-size: 18px;">
					<a style="color: #333333;" href="survey.do?method=view&surveyId=<bean:write name="element" property="id" />" onmouseover="overChangeA(this)" onmouseout="outChangeA(this)"><strong><bean:write name="element" property="name" /></strong></a>
				</td>
				<td align="left" width="45%" style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all;color: #333333;font-size: 14px;">
					<strong><logic:equal value="1" name="element" property="type" >考试</logic:equal>
					<logic:equal value="2" name="element" property="type" >调查</logic:equal></strong>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<bean:write name="element" property="createTime" />				
				</td>
				</tr>
				<tr style="color: #0e9cdf">
				<td height="25" width="5%" align="center" nowrap style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all">
					&nbsp;
				</td>
				<td align="left" width="60%" nowrap style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all">
					<a href="survey.do?method=setSurvey&id=<bean:write name="element" property="id" />" style="color: #0e9cdf"><img src="../survey/images/newImages/set.bmp" />设置</a>
							&nbsp;&nbsp;
					<a href="#" style="color: #0e9cdf" onclick="doEdit(<bean:write name="element" property="id" />, <bean:write name="element" property="num" />)"><img src="../survey/images/newImages/edit.bmp" />修改</a>
							&nbsp;&nbsp;
					<a href="survey.do?method=copy&surveyId=<bean:write name="element" property="id" />" style="color: #0e9cdf"><img src="../survey/images/newImages/copy.bmp" />复制</a>
							&nbsp;&nbsp;
					<a href="#" onclick="doDelete(<bean:write name="element" property="id" />)" style="color: #0e9cdf"><img src="../survey/images/newImages/del.bmp" />删除</a>
							&nbsp;&nbsp;
					<!--<a href="#" onclick="" style="color: #0e9cdf"><img src="../survey/images/newImages/print.bmp" />打印</a>-->
				</td>
				<td align="left" width="35%" nowrap style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all">

					<a href="javascript:void(0)" onclick="dispatch(<bean:write name="element" property="id" />)" style="color: #0e9cdf"><img src="../survey/images/newImages/fabu.bmp">下发</a>
							&nbsp;&nbsp;
					<a href="mission.do?method=monitor&surveyId=<bean:write name="element" property="id" />" onclick="" style="color: #0e9cdf"><img src="../survey/images/newImages/monitor.bmp" />监控</a>
							&nbsp;&nbsp;
					<a href="report.do?method=times&surveyId=<bean:write name="element" property="id" />" onclick="" style="color: #0e9cdf"><img src="../survey/images/newImages/report.bmp" />分数汇总</a>
							&nbsp;&nbsp;
					<a href="report.do?method=requestDetail&surveyId=<bean:write name="element" property="id" />" onclick="" style="color: #0e9cdf"><img src="../survey/images/newImages/report.bmp" />下发明细</a>
							&nbsp;&nbsp;
					<a href="report.do?method=times2&surveyId=<bean:write name="element" property="id" />" onclick="" style="color: #0e9cdf"><img src="../survey/images/newImages/report.bmp" />调查明细（运营专用）</a>
							&nbsp;&nbsp;
				</td>
				</tr>
			</table>
		</td>
	</tr>
   </logic:iterate>
</table>
</br>
</br>
</br>
</body>
</html>


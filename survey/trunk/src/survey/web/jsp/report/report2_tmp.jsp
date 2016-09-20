<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="struts-bean.tld" prefix="bean"%>
<%@ taglib uri="struts-html.tld" prefix="html"%>
<%@ taglib uri="struts-logic.tld" prefix="logic"%>

<!-- 用印和打印次数报表 -->
<%@page import="java.util.Date"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<link href="../survey/css/css.css" rel="stylesheet" type="text/css">
		<script language="javascript" src="../survey/js/common.js"></script>
		<script language="javascript" src="../survey/js/boxover.js"></script>
		<script LANGUAGE="JavaScript">
<!--
function doQuery() {
	if (document.getElementsByName("startDate")[0].value == '' 
		|| document.getElementsByName("startDate")[0].value == '') {
		 alert("请输入开始日期！");
		 return false;
	}
	if(document.getElementsByName("endDate")[0].value == null 
	   || document.getElementsByName("endDate")[0].value == '') {
	     alert("请输入结束日期！"); 
	     return false;
	}

	var surveyId = document.getElementById("surveyId").value;

	document.all.form1.action = "report.do?method=report2&surveyId="+surveyId;
	document.all.form1.submit();
}


function doExport() {
	
	var surveyId = document.getElementById("surveyId").value;
	
	document.all.form1.action = "report.do?method=report2&export=xls&surveyId="+surveyId;
	document.all.form1.submit();
}

function doReset(){
	var surveyId = document.getElementById("surveyId").value;
	window.location.href("report.do?method=times2&surveyId="+surveyId);
}

function selectDeptTree() {
		//window.open("../survey/jsp/report/queryDeptTree.htm")
		window.showModalDialog("../survey/jsp/report/queryDeptTree.htm", 
		window, 'dialogWidth:260px;dialogHeight:530px;Resizable:0;help:no;scroll:yes;status:No;center:yes;edge:Raised;');
	}

//-->
</script>


	</head>

	<body>
  <form id="form1" name="form1" method="post" action="">
			<script src="../survey/js/SophyCalendar.js" charset="gb2312"
				type="text/javascript"></script>
<input type="hidden" id="surveyId" value="<bean:write name="survey" property="id" />">
<table align="center" width="80%" height="24"  border="0" cellpadding="0" cellspacing="0">
  <tr>
  	<td height="40px"></td>
  </tr>
  <tr style="font-size: 18px">
    <td style="background-color:#676b6d;color:white;" align="center" height="35px" width="15%"><strong>调查明细</strong></td>
    <td width="88%">&nbsp;
    	<strong>问卷名称：<bean:write name="survey" property="name" /></strong>&nbsp;&nbsp;&nbsp;&nbsp;
    	<input type="button" name="Submit1" style="background-color:#0e9cdf;height: 25px;color: white;border: 1px " value=" 导出 " onclick="doExport()">
    </td>

  </tr>
  <tr>
  	<td height="30px"></td>
  </tr>
</table>

			<table width="80%" align="center" border="0" cellpadding="5" cellspacing="0"
				background="" class="bg1">
				<tr>
					<td width="1%">
						&nbsp;
					</td>

					<td width="" align="left" nowrap>
						开始时间：
						<input name="startDate" type="text" class="input1" id="startDate"
							style="width:100px; cursor: hand"
							onclick="calendar.show('startDate')"
							value="<logic:notEmpty name="startDate"><bean:write name="startDate" /></logic:notEmpty>"
							readonly>
						<img src="../survey/images/icon_06.gif" width="24" height="19"
							style="cursor: hand" align="absbottom"
							onclick="calendar.show('startDate')">
						&nbsp;&nbsp; 结束时间：
						<input name="endDate" type="text" class="input1" id="endDate"
							style="width:100px; cursor: hand"
							onclick="calendar.show('endDate')"
							value="<logic:notEmpty name="endDate"><bean:write name="endDate" /></logic:notEmpty>"
							readonly>
						<img src="../survey/images/icon_06.gif" width="24" height="19"
							style="cursor: hand" align="absbottom"
							onclick="calendar.show('endDate')">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<td>
											任务所属部门：
					<input name="applyDeptId" type="hidden" id="selectDeptId" value="<logic:notEmpty name="applyDeptId"><bean:write name="applyDeptId" /></logic:notEmpty><logic:empty name="applyDeptId">21</logic:empty>" />
					<input id="deptName" type="text" style="width: 200px;cursor: hand"
						readonly="true" value="<logic:notEmpty name="deptName"><bean:write name="deptName" /></logic:notEmpty><logic:empty name="deptName">合众人寿</logic:empty>" onclick="selectDeptTree()" />
					<img src="../survey/images/open.gif" width="16" height="16"
						style="cursor: hand" align="middle" onClick="selectDeptTree()">
				</td>
				<tr>
					<td width="" align="left" nowrap>
						&nbsp;
					</td>
				<td colspan="3" align="center">
				<input name="Submit" type="button" style="background-color:#0e9cdf;height: 25px;color: white;border: 1px " value=" 查询 "onClick="doQuery()">
				&nbsp;&nbsp;
                <input name="Reset" type="reset" style="background-color:#0e9cdf;height: 25px;color: white;border: 1px " onclick="doReset()"  value=" 重置 ">
                </td>
				</tr>


			</table>

			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td>
						<img src="../images/_blank.gif" width="2" height="7">
						<table width="98%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td width="1%">
					</td>
				</tr>
			</table>

<table width="80%" border="1" align="center" cellpadding="2" cellspacing="0" style="table-layout:fixed">
<tr bgcolor="#828282">
<td width="10%" height="27" align="center"  class="tabtitle">问题结果</td>
<td width="45%" height="27" align="center"  class="tabtitle">是</td>
<td width="45%" height="27" align="center"  class="tabtitle">否</td>
</tr>
				<logic:notEmpty name="qList">
				<logic:iterate id="element" name="qList" indexId="index1">
					<tr onMouseOver="this.bgColor='#F8F1C5'"
						onMouseOut="this.bgColor='ffffff'">
						<td nowrap align="center"
							style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all">

							<strong>题目号:</strong>
							<bean:write name="element" property="questionSeq" />
						</td>
						<td align="center" nowrap
							style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all">

							<strong><bean:write name="element" property="isYes" />
							</strong>

						</td>
						<td align="center" nowrap
							style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all">
							<strong><bean:write name="element" property="isNo" />
							</strong>
						</td>

					</tr>

				</logic:iterate>
				</logic:notEmpty>
       			<logic:notEmpty name="tList">
				<logic:iterate id="element" name="tList" indexId="index1">
       				<tr>
					<td align="center">
						<strong>总计：</strong>
					</td>
					<td align="center">
						<strong><bean:write name="element" property="totalYes" />
					</td>
					<td align="center">
						<strong><bean:write name="element" property="totalNo" />
					</td>
				</tr>
				</logic:iterate>
				</logic:notEmpty>
			</table>
		</form>
	</body>
</html>

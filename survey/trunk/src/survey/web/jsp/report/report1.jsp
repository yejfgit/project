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

function doSubmit(){
	window.location.href="survey.do?method=adminList";
}

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
	
	document.all.form1.action = "report.do?method=times&surveyId="+surveyId ;
	document.all.form1.submit();
}

function doExport() {
	
	var surveyId = document.getElementById("surveyId").value;
	
	document.all.form1.action = "report.do?method=times&export=xls&surveyId="+surveyId;
	document.all.form1.submit();
}

function doReset(){
	var surveyId = document.getElementById("surveyId").value;
	window.location.href("report.do?method=times&surveyId="+surveyId);
}

function selectDeptTree() {
		//window.open("../survey/jsp/report/queryDeptTree.htm");
		
	

		window.showModalDialog("../survey/jsp/report/queryDeptTree.htm", 
		window, 'dialogWidth:250px;dialogHeight:500px;Resizable:0;help:no;scroll:yes;status:No;center:yes;edge:Raised;');
	}

//按钮改变颜色
function overChangeBtn(btn){
	btn.style.backgroundColor="#9bcf00";
}

function outChangeBtn(btn){
	btn.style.backgroundColor="#0e9cdf";
}

function mingxi(){
	var surveyId=document.getElementById("surveyId").value; 
	window.location.href="report.do?method=requestDetail&surveyId="+surveyId;
}
//-->
</script>
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
		<form id="form1" name="form1" method="post" action="">
			<script src="../survey/js/SophyCalendar.js" charset="gb2312"
				type="text/javascript"></script>
<input type="hidden" id="surveyId" value="<bean:write name="surveyId" />">
<table align="center" width="80%" height="24"  border="0" cellpadding="0" cellspacing="0">
  <tr>
  	<td height="30px" colspan="2" style="color:#0e9cdf;font-size:14px;vertical-align:middle;">&nbsp;&nbsp;
   <a href="survey.do?method=WJList&type=2" style="color:#0e9cdf;" target="mainFrame">首页</a>
   >><a href="survey.do?method=edit&surveyId=<bean:write name="surveyId" />" style="color:#0e9cdf;" target="mainFrame">问卷设计</a>
   >><a href="dispatch.do?method=index&surveyId=<bean:write name="surveyId" />" style="color:#0e9cdf;" target="mainFrame">问卷下发</a>
   >><strong> <a href="mission.do?method=monitor&surveyId=<bean:write name="surveyId" />" style="color:#0e9cdf;" target="mainFrame">结果分析</a>
    > <a href="report.do?method=times&surveyId=<bean:write name="surveyId" />" style="color:#0e9cdf;" target="mainFrame"><span style="font-size: 12px">分数汇总</span></a></strong></td>
  </tr>
  <tr><td>&nbsp;</td></tr>
  <tr style="font-size: 18px">
    <td width="" align="left" nowrap>
	</td>
    <td  align="center" width="90%">&nbsp;
    	<strong>问卷名称：<bean:write name="surveyName" /></strong>
    </td>
	<td style="" align="center" height="35px" >
	<!-- <input name="new" class="btn"  type="button" onmouseover="overChangeBtn(this)" onmouseout="outChangeBtn(this)" onclick="mingxi()" value="下发明细">
	 -->&nbsp;&nbsp;
	<input type="button" name="Submit1" class="btn" value="导出报表" onmouseover="overChangeBtn(this)" onmouseout="outChangeBtn(this)" onclick="doExport()">
	  
	</td>

  </tr>
  <tr>
  	<td height="30px"></td>
  </tr>
</table>
			<table width="80%" align="center" border="0" cellpadding="5" cellspacing="0" >
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
						&nbsp;&nbsp; </td>
						<td>结束时间：
						<input name="endDate" type="text" class="input1" id="endDate"
							style="width:100px; cursor: hand"
							onclick="calendar.show('endDate')"
							value="<logic:notEmpty name="endDate"><bean:write name="endDate" /></logic:notEmpty>"
							readonly>
						<img src="../survey/images/icon_06.gif" width="24" height="19"
							style="cursor: hand" align="absbottom"
							onclick="calendar.show('endDate')">
						&nbsp;&nbsp; </td>
					<td>任务所属部门：
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
				<input name="Submit" type="button" class="btn"  value=" 查询 " onmouseover="overChangeBtn(this)" onmouseout="outChangeBtn(this)" onClick="doQuery()">
				&nbsp;&nbsp;
                <input name="Reset" type="reset"  class="btn"  onclick="doReset()" onmouseover="overChangeBtn(this)" onmouseout="outChangeBtn(this)" value=" 重置 ">

                </td>
				</tr>
			</table>

<table width="80%" align="center" border="1" bordercolor="#828282" align="center" cellpadding="2"
				cellspacing="0" style="table-layout:fixed;font-size:12px">
<tr bgcolor="#828282">
<td width="10%" height="27" align="center"  class="tabtitle">序号</td>
<td width="30%" height="27" align="center"  class="tabtitle">机构名称</td>
<td width="20%" height="27" align="center" class="tabtitle">用户姓名</td>
<td width="13%" height="27" align="center"  class="tabtitle">选择题分数</td>
<td width="13%" height="27" align="center"  class="tabtitle">问答题分数</td>
<td width="13%" height="27" align="center"  class="tabtitle">总分</td>
</tr>


					<logic:notEmpty name="reportList">
						<logic:iterate id="element" name="reportList" indexId="index1">
							<tr onMouseOver="this.bgColor='#F8F1C5'"
								onMouseOut="this.bgColor='ffffff'">
								<td height="25" align="center" nowrap
									style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all">
									<%=++index1%>
								</td>
								<td align="center" nowrap
									style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all">
									<bean:write name="element" property="deptFullName" />
								</td>
								<td align="center" nowrap
									style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all">
									<bean:write name="element" property="userRealName" />
								</td>
								<td align="center" nowrap
									style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all">
									<bean:write name="element" property="xzScore" />
								</td>
								<td align="center" nowrap
									style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all">
									<bean:write name="element" property="wdScore" />&nbsp;
								</td>
								<td align="center" nowrap
									style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all">
									&nbsp;<bean:write name="element" property="totalScore" />&nbsp;
								</td>
							</tr>
						</logic:iterate>
					</logic:notEmpty>


			</table>



		</form>
	</body>
</html>

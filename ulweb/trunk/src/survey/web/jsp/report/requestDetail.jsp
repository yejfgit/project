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
	
	document.all.form1.action = "report.do?method=requestDetail";
	document.all.form1.submit();
}


function doExport() {
	document.all.form1.action = "report.do?method=requestDetail&export=xls";
	document.all.form1.submit();
}

function selectDeptTree() {
		//window.open("../survey/jsp/report/queryDeptTree.htm")
		
	

		window.showModalDialog("../survey/jsp/report/queryDeptTree.htm", 
		window, 'dialogWidth:250px;dialogHeight:500px;Resizable:0;help:no;scroll:yes;status:No;center:yes;edge:Raised;');
	}

//-->
</script>


	</head>

	<body>
	 <table>
  <tr> 
    <td colspan="5" valign="top"><img src="../survey/images/logos1.jpg"></td>
    <td>&nbsp;</td>
  </tr></table>
      <hr align="center" width="100%" size="2">
		<form id="form1" name="form1" method="post" action="">
			<script src="../survey/js/SophyCalendar.js" charset="gb2312"
				type="text/javascript"></script>
			<table width="100%" height="60" border="0" cellpadding="0"
				cellspacing="0" background="">
				<tr>
						<td width="98%" nowrap class="font14pxblod"
												style="font-weight: normal;"> 
						<strong>下发明细表</strong><strong>：</strong>
					</td>
				</tr>
			</table>

			<table width="100%" border="0" cellpadding="5" cellspacing="0"
				background="../images/index_04.gif" class="bg1">
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
						<td>机构： 
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
					<td>
						选择问卷：
						<html:select name="reportForm" property="surveyId">
							<html:optionsCollection name="surveyLabelList" />
						</html:select>
						&nbsp;&nbsp;
						问卷状态：
<html:select name="reportForm" property="surveyStatus">
	<html:optionsCollection name="surveyStatusLabelList" />
</html:select>

						&nbsp;&nbsp;
						&nbsp;&nbsp;
				<td>
				<input name="Submit" type="button" class="btn-02" value="查询"onClick="doQuery()">
				&nbsp;&nbsp;
                <input name="Reset" type="reset" class="btn-01" value="重置">
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
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td width="1%">
												<br>
											</td>
											<td width="98%" nowrap class="font14pxblod"
												style="font-weight: normal;">
												<strong>下发明细表</strong> <input type="button" name="Submit1" class="btn-01" value="导出" onclick="doExport()"> 
											</td>
											<td width="1%">
												<br>
											</td>
										</tr>
									</table>
								</td>
								<td width="99%" height="31" align="right">
									<br>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>


			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td>
						<img src="../images/_blank.gif" width="2" height="7"></td>
				</tr>
			</table>

			<table width="98%" border="1" align="center" cellpadding="2"
				cellspacing="0" style="table-layout:fixed">
				<tr>
					<td width="20%" align="center"> 
						<strong>机构</strong></td>
					<td width="20%" align="center"> 
						<strong>下发时间</strong></td>
					<td width="10%" height="27" align="center"><strong>下发对象姓名</strong><br></td>
					<td width="10%" height="27" align="center"> 
						<strong>下发数量</strong></td>
					<td width="10%" height="27" align="center"><strong>已答数量</strong></td>
					<td width="10%" height="27" align="center"><strong>未答数量</strong></td>
					<td width="10%" height="27" align="center"><strong>关闭数量</strong></td>
					<td width="10%" height="27" align="center"><strong>无效数量</strong></td>
				</tr>


					<logic:notEmpty name="reportList">
						<logic:iterate id="element" name="reportList" indexId="index1">
							<tr onMouseOver="this.bgColor='#F8F1C5'"
								onMouseOut="this.bgColor='ffffff'">
								<td height="25" align="center" nowrap
									style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all">
									<bean:write name="element" property="deptName" />
								</td>
								<td nowrap align="center"
									 style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all">
									<bean:write name="element" property="reqDate" />
								</td>
								<td align="center" nowrap
									style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all">
									<bean:write name="element" property="userName" />
								</td>
								<td align="center" nowrap
									style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all">
									<bean:write name="element" property="total" />
								</td>
								<td align="center" nowrap
									style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all">
									<bean:write name="element" property="done" />
								</td>
								<td align="center" nowrap
									style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all">
									<bean:write name="element" property="todo" />
								</td>
								<td align="center" nowrap
									style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all">
									<bean:write name="element" property="closed" />
								</td>
								<td align="center" nowrap
									style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all">
									<bean:write name="element" property="invalid" />
								</td>
								
							</tr>
						</logic:iterate>
					</logic:notEmpty>

				<logic:notEmpty name="total">
					<tr>
						
						<td align="center">
							<strong>总计</strong>
						</td>
						<td align="center">
							&nbsp;
						</td>
						<td align="center">
							&nbsp;
						</td>
							<td align="center" nowrap
									style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all">
									<bean:write name="total" property="total" />
								</td>
								<td align="center" nowrap
									style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all">
									<bean:write name="total" property="done" />
								</td>
								<td align="center" nowrap
									style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all">
									<bean:write name="total" property="todo" />
								</td>
								<td align="center" nowrap
									style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all">
									<bean:write name="total" property="closed" />
								</td>
								<td align="center" nowrap
									style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all">
									<bean:write name="total" property="invalid" />
								</td>
					</tr>
				</logic:notEmpty>
				
				
			</table>



		</form>
	</body>
</html>

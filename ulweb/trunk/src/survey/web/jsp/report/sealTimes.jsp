<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="struts-bean.tld" prefix="bean"%>
<%@ taglib uri="struts-html.tld" prefix="html"%>
<%@ taglib uri="struts-logic.tld" prefix="logic"%>

<!-- 用印和打印次数报表 -->
<%@page import="java.util.Date"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title></title>
		<link href="../css/css.css" rel="stylesheet" type="text/css">
		<script language="javascript" src="../js/common.js"></script>
		<script language="javascript" src="../js/boxover.js"></script>
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
	
	document.all.form1.action = "sealReport.do?method=sealTimesQuery";
	document.all.form1.submit();
}



//-->
</script>


	</head>

	<body>
		<form id="form1" name="form1" method="post" action="">
			<script src="../js/SophyCalendar.js" charset="gb2312"
				type="text/javascript"></script>

			<table width="100%" height="24" border="0" cellpadding="0"
				cellspacing="0" background="../images/index_02.gif">
				<tr>
					<td class="bigtitlebg">
						&nbsp;&nbsp;&nbsp;&nbsp;
						<img src="" height="17">
						<span class="bigtitle">&nbsp;&nbsp;统计信息<br> </span>
					</td>
				</tr>
			</table>

			<table width="100%" border="0" cellpadding="5" cellspacing="0"
				background="../images/index_04.gif" class="bg1">
				<tr>
					<td width="1%">
						&nbsp;
					</td>

					<td width="" align="left" nowrap>开始时间： 
						<input name="startDate" type="text" class="input1" id="startDate"
							style="width:100px; cursor: hand"
							onclick="calendar.show('startDate')"
							value="<logic:notEmpty name="startDate"><bean:write name="startDate" /></logic:notEmpty>"
							readonly>
						<img src="../images/icon_06.gif" width="24" height="19"
							style="cursor: hand" align="absbottom"
							onclick="calendar.show('startDate')">
						&nbsp;&nbsp; 结束时间：
						<input name="endDate" type="text" class="input1" id="endDate"
							style="width:100px; cursor: hand"
							onclick="calendar.show('endDate')"
							value="<logic:notEmpty name="endDate"><bean:write name="endDate" /></logic:notEmpty>"
							readonly>
						<img src="../images/icon_06.gif" width="24" height="19"
							style="cursor: hand" align="absbottom"
							onclick="calendar.show('endDate')">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
 
						 
 
								 
						 
						<input name="Submit" type="button" class="btn-02" value="查询"
							onClick="doQuery()">
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
												<strong>用印和打印次数报表</strong>
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
					<td width="10%" align="center">
						<strong>序号</strong>
					</td>
					<td width="30%" height="27" align="center">
						<strong>机构名称</strong>
					</td>
					<td width="20%" height="27" align="center">
						<strong>印章使用次数</strong>
					</td>
					<td width="20%" height="27" align="center"><strong>骑缝章使用次数</strong></td>
					<td width="20%" height="27" align="center"><strong>文件打印页数</strong></td>
					
				</tr>


					<logic:notEmpty name="list">
						<logic:iterate id="element" name="list" indexId="index1">
							<tr onMouseOver="this.bgColor='#F8F1C5'"
								onMouseOut="this.bgColor='ffffff'">
								<td height="25" align="center" nowrap
									style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all">
									<%=++index1%>
								</td>
								<td nowrap align="center"
									 style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all">
									<bean:write name="element" property="deptName" />
								</td>
								<td align="center" nowrap
									style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all">
									<bean:write name="element" property="normalSealTimes" />
								</td>
								<td align="center" nowrap
									style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all">
									<bean:write name="element" property="crossSealTimes" />
								</td>
								<td align="center" nowrap
									style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all">
									<bean:write name="element" property="printPages" />
								</td>

							</tr>
						</logic:iterate>
					</logic:notEmpty>

				<logic:notEmpty name="total">
					<tr>
						<td align="center">
							&nbsp;
						</td>
						<td align="center">
							<strong>总计</strong>
						</td>
							<td align="center" nowrap
									style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all">
									<bean:write name="total" property="normalSealTimes" />
								</td>
								<td align="center" nowrap
									style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all">
									<bean:write name="total" property="crossSealTimes" />
								</td>
								<td align="center" nowrap
									style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all">
									<bean:write name="total" property="printPages" />
								</td>
						
					</tr>
				</logic:notEmpty>
				
				
			</table>



		</form>
	</body>
</html>

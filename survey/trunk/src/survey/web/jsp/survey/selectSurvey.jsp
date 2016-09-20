<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="struts-bean.tld" prefix="bean" %>
<%@ taglib uri="struts-html.tld" prefix="html" %>
<%@ taglib uri="struts-logic.tld" prefix="logic" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>问卷选择</title>
<SCRIPT LANGUAGE="JavaScript">


<!--


-->
</SCRIPT>
</head>

<body>
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
												<strong>请选择需要您作答的问卷：</strong>&nbsp;
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
					<td width="10%" align="center">
						<strong>下发时间</strong>
					</td>
					<td width="30%" height="27" align="center">
						<strong>试卷名称</strong>
					</td>
				</tr>
				<logic:iterate id="element" name="sList" indexId="index1" >
							<tr onMouseOver="this.bgColor='#F8F1C5'"
								onMouseOut="this.bgColor='ffffff'">
								<td height="25" align="center" nowrap
									style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all">
									<%=++index1%>
								</td>
								<td nowrap align="center"
									 style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all">
                                     <bean:write name="element" property="requestTime" />
								</td>
								<td align="center" nowrap
									style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all">
									<a href="mission.do?method=answer&surveyId=<bean:write name="element" property="id" />"><bean:write name="element" property="name" />
								</td>
							</tr>
             </logic:iterate>

</body>
</html>


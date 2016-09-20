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
function closed(id)
{   
	if(confirm("确定要关闭？"))
	{
		window.location.href("mission.do?method=closeMission&missionId=" + id);
	}
}

</SCRIPT>
</head>

<body>
 <table>
  <tr> 
    <td colspan="5" valign="top"><img src="../survey/images/logos1.jpg"></td>
    <td>&nbsp;</td>
  </tr></table>
  <hr width="100%" size="2">
  	<form id="form1" name="form1" method="post" action="">
			<table width="100%" height="60" border="0" cellpadding="0"
				cellspacing="0" background="">
				<tr>
						<td width="98%" nowrap class="font14pxblod"
												style="font-weight: normal;">
						<strong>问卷监控：</strong>
					</td>
				</tr>
			</table>


<table width="98%" border="1" align="center" cellpadding="2"
				cellspacing="0" style="table-layout:fixed">
<tr>
<td align="center"><strong>机构名称</strong></td>
<td align="center"><strong>用户姓名</strong></td>
<td align="center"><strong>问卷名称</strong></td>
<td align="center">    
    	<strong>问卷状态</strong>
<td align="center"><strong>下发时间</strong></td>
<td align="center"><strong>开始时间</strong></td>
<td align="center"><strong>操作</strong></td>
</tr>
<logic:iterate id="element" name="ufList" >
<tr>
<td align="center"><bean:write name="element" property="deptFullName"/></td>
<td align="center"><bean:write name="element" property="realName" /></td>
<td align="center"><bean:write name="element" property="surveyName" /></td>
<td align="center">    
    <logic:equal value="1" name="element" property="isClosed">
    	已开始
	</logic:equal>
	<logic:notEqual value="1" name="element" property="isClosed">
    	未开始
	</logic:notEqual>
<td align="center"><bean:write name="element" property="requestTime" format="yyyy-MM-dd HH:mm:ss" /></td>
<td align="center"><bean:write name="element" property="beginTime" format="yyyy-MM-dd HH:mm:ss" /></td>	
<td align="center"><a onclick="closed(<bean:write name="element" property="missionId" />)"><input name="close" type="button" class="btn-01" value="关闭问卷" ></a></td>
</tr>
</logic:iterate>
</body>
</html>


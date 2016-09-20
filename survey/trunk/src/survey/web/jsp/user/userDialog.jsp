<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="struts-bean.tld" prefix="bean" %>
<%@ taglib uri="struts-html.tld" prefix="html" %>
<%@ taglib uri="struts-logic.tld" prefix="logic" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	response.setHeader("Pragma", "No-Cache");
	response.setHeader("Cache-Control", "No-Cache");
	response.setDateHeader("Expires", 0);
%>



<html>
<head>
<base target="_self" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>查询用户对话框</title>
<link href="css/css.css" rel="stylesheet" type="text/css">
<script language="javascript" src="js/common.js"></script>
<script language="javascript" src="js/boxover.js"></script>
<script LANGUAGE="JavaScript">
<!--
function check()
{
	var pattern1 = new RegExp("w*d*");
	var str1 = document.getElementsByName("user.userName")[0].value;
	var str2 = document.getElementsByName("user.realName")[0].value;
	if (pattern1.test(str1) == false || pattern1.test(str2) == false) {
		return false;
	}

	

}

function choose(dname,uid,uname,did) {
	if (dialogArguments.document.all.dname != undefined) {
		dialogArguments.document.all.dname.value = dname;
	}
	if (dialogArguments.document.all.uid != undefined) {
		dialogArguments.document.all.uid.value = uid;
	}
	if (dialogArguments.document.all.uname != undefined) {
		dialogArguments.document.all.uname.value = uname;
	}	
	if (dialogArguments.document.all.did != undefined) {
		dialogArguments.document.all.did.value = did;
	}
	
	window.close();
}

function doSubmit(){
	var userName = document.getElementsByName("userName")[0].value;
	//alert(1);
	document.form1.action="user.do?method=dispatchUserDialog&userName="+userName;
	document.form1.submit();
}

//-->
</script>

<style type="text/css">
<!--
#Layer1 {
	position:absolute;
	width:200px;
	height:115px;
	z-index:1;
	left: 39px;
	top: 379px;
	background-color: #FFFFFF;
	border: solid 1px #CCCCCC;
}

	.btn{
	background-color:#0e9cdf;
	height: 20px;
	color: white;
	border: 1px;
	border-color: #828282;
}
-->
</style>
</head>
<body>
<form name="form1" method="post" action="user.do?method=dispatchUserDialog">
<input name="dialogReturnId" type="hidden" value="">
<input name="dialogReturnName" type="hidden" value="">
<script  src="js/SophyCalendar.js"  charset="gb2312" type="text/javascript"></script>
<table width="100%"  border="0" cellpadding="0" cellspacing="0" background="images/index_01.gif">
  <tr>
    <td><img src="images/_blank.gif" width="2" height="1"></td>
  </tr>
</table>
<table width="100%" height="24"  border="0" cellpadding="0" cellspacing="0" >
  <tr>
    <td height="20px" style="color:#0e9cdf;font-size:12px;vertical-align:bottom;"><strong>&nbsp;&nbsp;首页 >> 下发 >> 选择用户</strong></td>
  </tr>
</table>

<table width="100%" border="0" cellpadding="5" cellspacing="0">
  

  <tr>
    <td width="1%">&nbsp;</td>
    <td align="left" nowrap>用户名或姓名：
      <input type="text" name="userName" style="width:200px" value="">
      &nbsp; &nbsp;
<input name="Submit" class="btn" onclick="doSubmit()" type="button" value="查询">
	   &nbsp; &nbsp;
<input name="Reset" class="btn" type="reset" value="重置"></td>
  </tr>
</table>


<table width="98%" align="center" border="1" bordercolor="#828282" align="center" cellpadding="2"
				cellspacing="0" style="table-layout:fixed;font-size:12px">

<tr bgcolor="#828282">
    <td width="20%" style="color:white" height="27" align="center">姓名</td>
    <td width="20%" style="color:white" align="center" >用户名</td>
    <td width="20%" style="color:white" align="center" >岗位</td>
    <td height="27" style="color:white" align="center" >所属部门</td>
	</tr>

<logic:iterate id="element" name="userList" indexId="index">
  <tr onMouseOver="this.bgColor='#F8F1C5'" onMouseOut="this.bgColor='ffffff'" style="cursor: hand;" 
  onClick="choose('<bean:write name="element" property="deptFullName" />','<bean:write name="element" property="empId" />','<bean:write name="element" property="realName" />（<bean:write name="element" property="positionName" />）',<bean:write name="element" property="umOrgan" />)">
    <td height="25" align="center" style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all">
   		<bean:write name="element" property="realName" />
    </td>
    <td nowrap style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all" align="center">
		<bean:write name="element" property="userName" />
	</td>
	<td nowrap style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all" align="center">
		<bean:write name="element" property="positionName" />
	</td>
    <td nowrap style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all" align="center">
		<bean:write name="element" property="deptFullName" />
	</td>

  </tr>
</logic:iterate>


</table>

</form>

</body>
</html>
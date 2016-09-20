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
	//alert("提交申请用印\n" + msg);
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
<table width="100%" height="24"  border="0" cellpadding="0" cellspacing="0" background="images/index_02.gif">
  <tr>
    <td class="bigtitlebg">&nbsp;&nbsp;&nbsp;&nbsp;<span class="bigtitle">&nbsp;&nbsp;查询用户</span></td>
  </tr>
</table>

<table width="100%" border="0" cellpadding="5" cellspacing="0" background="images/index_04.gif" class="bg1">
  

  <tr>
    <td width="1%">&nbsp;</td>
    <td align="left" nowrap>用户名或姓名：
      <input type="text" name="userName" style="width:200px" value="">
<input name="Submit" type="button" value="查询">
<input name="Reset" type="reset" value="重置"></td>
  </tr>
</table>


<table width="98%"  border="2" align="center" cellpadding="2" cellspacing="0" bordercolor="#EEF1F6" style="table-layout:fixed ">
  <tr>
    <td width="20%" height="27" align="center">姓名</td>
    <td width="20%" align="center" >用户名</td>
    <td width="20%" align="center" >岗位</td>
    <td height="27" align="center" >所属部门</td>
	</tr>

<logic:iterate id="element" name="userList" indexId="index">
  <tr onMouseOver="this.bgColor='#F8F1C5'" onMouseOut="this.bgColor='ffffff'" style="cursor: hand;" 
  onClick="choose('<bean:write name="element" property="deptFullName" />',<bean:write name="element" property="umUserId" />,'<bean:write name="element" property="realName" />',<bean:write name="element" property="umOrgan" />)">
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
<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="struts-bean.tld" prefix="bean" %>
<%@ taglib uri="struts-html.tld" prefix="html" %>
<%@ taglib uri="struts-logic.tld" prefix="logic" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link href="../survey/css/css.css" rel="stylesheet" type="text/css">
<script language="javascript" src="../survey/js/common.js"></script>
<script>

function list(deptId) {
	//alert(pid);
	document.getElementById("deptId").value = deptId;
	//alert(deptId);
	document.form1.action = "user.do?method=userList&deptId=" + deptId;
	document.form1.target = "DeptRight";
	document.form1.submit();
}


</script>
<style>
.sel {background-color:silver;}
</style>
</head>

<body style="overflow-x:hidden" background="../survey/images/index_04.gif" class="bg1">
<form method="post" name="form1" action="">
	<input type="hidden" id="deptId" name="dept.deptId" value="" />
</form>
<table border="0" cellspacing="0" cellpadding="0" height="80%">
<tr><td>
    </td>
</tr>
  <tr valign="top">
    <td height="223"><div id="menus" style="padding:5px">
    
<!-- tree start -->
<bean:write name="userForm" property="tree" filter="false" />
<!-- tree end -->

    </div></td>
  </tr>
  <tr valign="bottom">
    <td>&nbsp;</td>
  </tr>
</table>
<div align="right"></div>

<!-- 打开右侧列表的树节点 -->
<script>

<logic:iterate id="element" name="userForm" property="list" indexId="index">
o(<bean:write name="element" property="deptId" />,this);
</logic:iterate>


<logic:notEqual value="0" name="userForm" property="dept.deptId">
o(<bean:write name="userForm" property="dept.deptId" />,this);
list(<bean:write name="userForm" property="dept.deptId" />,'');
</logic:notEqual>


</script>
<script>parent.document.getElementById("loading").style.display = 'none';</script>
</body>
</html>

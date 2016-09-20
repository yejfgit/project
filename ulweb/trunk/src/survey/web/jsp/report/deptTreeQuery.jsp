<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="struts-bean.tld" prefix="bean" %>
<%@ taglib uri="struts-html.tld" prefix="html" %>
<%@ taglib uri="struts-logic.tld" prefix="logic" %>
<%@ taglib uri="c.tld" prefix="c" %>
<%
      response.setHeader("Pragma","No-Cache");
       response.setHeader("Cache-Control","No-Cache");
      response.setDateHeader("Expires", 0);
%>
<html>
<head>
<base target="_self">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>请选择部门</title>
<link href="../../../survey/css/css.css" rel="stylesheet" type="text/css">
<script language="javascript" src="../../../survey/js/common.js"></script>
<script>

function selectDept(id, name) {
//alert(id);
	dialogArguments.document.getElementById("selectDeptId").value = id;
	dialogArguments.document.getElementById("deptName").value = name;
	window.close();
}

function list(id, parentId, thisElement) {
	name = thisElement.innerHTML;
	if (document.getElementById('de' + parentId) != undefined && parentId != 1) {
		name = document.getElementById('de' + parentId).innerHTML + name;
	}
	//alert(id + ',' + name);
	selectDept(id, name);
}

                 
</script>

</head>

<body background="../../../images/index_04.gif" class="bg1">


<form method="post" name="form1" action="">
	<input type="hidden" id="deptId" name="dept.id" value="" />
</form>
<table border="0" cellspacing="0" cellpadding="0" height="80%">

  <tr valign="top">
    <td height="223"><div id="menus" style="padding:5px">
    
<!-- tree start -->
<bean:write name="userForm" property="tree" filter="false" />
<!-- tree end -->

    </div>
		<span id="view"></span>

        </td>
  </tr>
  <tr valign="bottom">
    <td>&nbsp;</td>
  </tr>
</table>
<div align="right"></div>

<script>parent.document.getElementById("loading").style.display = 'none';</script>
</body>
</html>

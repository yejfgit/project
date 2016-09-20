<%@ page language="java" contentType="text/html; charset=utf-8" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link href="../survey/css/css.css" rel="stylesheet" type="text/css">
<script language="javascript" src="../survey/js/common.js"></script>
</head>
<div id="loading" style="position:absolute; left: 75px; top: 75px"><img src="../survey/images/loading.gif" width="50"></div>
<body bgcolor="#E4E9F3">
<table width="100%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><img src="../survey/images/_blank.gif" width="2" height="7"></td>
  </tr>
</table>
<table width="220"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="1%" background="../survey/images/tab_02.gif"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="1%"><img src="../survey/images/tab_07.gif" width="33" height="31"></td>
          <td width="98%" nowrap class="font14pxblod">组织架构</td>
          <td width="1%"><img src="../survey/images/tab_08.gif" width="82" height="31"></td>
        </tr>
    </table></td>
    <td width="99%" height="31" align="right" background="../survey/images/tab_05.gif"><img src="../survey/images/tab_09.gif" width="10" height="31"></td>
  </tr>
</table>
<table width="220" height="100%"  border="2" align="center" cellpadding="0" cellspacing="0" bordercolor="#EEF1F6" bgcolor="#FFFFFF" class="tab-border" >
  <tr>
    <td align="center" valign="top" background="survey/images/index_04.gif" class="bg1">
    	<iframe name="DeptTree" src="user.do?method=tree" frameborder="0" height="90%" width="210"></iframe>
    </td>
  </tr>
</table>
</body>
</html>

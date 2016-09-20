<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="struts-bean.tld" prefix="bean" %>
<%@ taglib uri="struts-html.tld" prefix="html" %>
<%@ taglib uri="struts-logic.tld" prefix="logic" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link href="../../survey/css/css.css" rel="stylesheet" type="text/css">
<link href="../../survey/css/dtree.css" rel="stylesheet" type="text/css">
<script src="../../survey/js/dtree.js" language="javascript"></script>

</head>

<body style="overflow-x:hidden" background="../../survey/images/index_04.gif" class="bg1">
<table border="0" cellspacing="0" cellpadding="0" height="80%">
<tr><td>
    </td>
</tr>
  <tr valign="top">
    <td height="223">&nbsp;<span id="menus"></span>

        </td>
  </tr>
  <tr valign="bottom">
    <td>&nbsp;</td>
  </tr>
</table>
<div align="right"></div>

<script type='text/javascript'>
/* 说明：
变量treeUrl：是树页面所在的相对系统路径
函数add：参数(id, pid, name, url, title, target, icon, iconOpen, open)
 */
var treeUrl = '../../';
d = new dTree('d',treeUrl);

d.add(0,-1,"管理列表");
<% int index = 0;%>
<logic:iterate id="element" name="surveyForm" property="list">
	d.add(
	<%=++index%>,
	0,
	"<bean:write name="element" property="menuName" />",
	"<bean:write name="element" property="menuUrl" />",
	"",
	"DeptRight1",
	treeUrl + "survey/images/close.gif",
	treeUrl + "survey/images/close.gif",
	false
	);
</logic:iterate>


//document.write(d);
menus.innerHTML = d;
</script>
</body>
</html>

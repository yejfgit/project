
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="struts-bean.tld" prefix="bean"%>
<%@ taglib uri="struts-html.tld" prefix="html"%>
<%@ taglib uri="struts-logic.tld" prefix="logic"%>

<%
	response.setHeader("Pragma", "No-Cache");
	response.setHeader("Cache-Control", "No-Cache");
	response.setDateHeader("Expires", 0);

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>内容列表</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<LINK href="style/ul.css" type="text/css" rel=stylesheet>
		<LINK href="style/dtree.css" type="text/css" rel=stylesheet>
		<!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	</head>

	<script type="text/javascript" src="js/common.js"></script>
	<script language="JavaScript" src="script/ajax.js"></script>
	<script language="JavaScript" src="script/dtree.js"
		type="text/javascript"></script>
	<script language="JavaScript" src="jsp/admin/content/content.js"></script>
	<body>
		<table align="center" border="1" cellpadding="0" cellspacing="0"
			width="750">
			<form action="" method="post" name="form1" id="idform1">
				<html:hidden name="contentForm" property="dept.deptId" />
				<input type="hidden" name="columnId" value="<bean:write name="columnId" />" />
				<logic:notEmpty name="pageId"><input type="hidden" name="pageId" id="pageId" value="<bean:write name="pageId" />" /></logic:notEmpty>
			<tr>
				<td>
					<table width="750" cellpadding="0" cellspacing="0" height="114">
						<tr>
							<td width="300" valign="top" align="left">
								<table align="left" bgcolor="#CCCCCC" cellpadding="0"
									cellspacing="0" width="300">
									<tr>
										<td height="20"></td>
									</tr>

									<logic:iterate id="element" name="contentForm"
										property="deptList">
										<tr>
											<td align='center'>
												<a
													href='web/admin/content/contentAdmin.do?method=list&deptId=<bean:write name="element" property="deptId" />'>
													<bean:write name="element" property="deptName" /> </a>
											</td>
										</tr>
									</logic:iterate>

									<tr>
										<td height="20" style="border-top:gray 1px solid;">
											&nbsp;
										</td>
									</tr>
									<tr>
										<td valign="top">


											<script type='text/javascript'>
/* 说明：
变量treeUrl：是树页面所在的相对系统路径
函数add：参数(id, pid, name, url, title, target, icon, iconOpen, open)
 */
var treeUrl = '';
d = new dTree('d',treeUrl);

d.add(0,-1,'<bean:write name="contentForm" property="dept.deptName" />');




<% int index1 = 0;%>

<logic:iterate id="element" name="contentForm" property="columnList">
	d.add(
	<bean:write name="element" property="columnId" />,
	<bean:write name="element" property="parentId" />,
	'<bean:write name="element" property="columnName" />',
	<logic:equal value="1" name="element" property="includeColumn">
	"",
	</logic:equal>
	<logic:equal value="0" name="element" property="includeColumn">
	"javascript:list(<bean:write name="element" property="columnId" />)",
	</logic:equal>	
	"",	
	"",
	<logic:equal value="1" name="element" property="includeColumn">
	"images/dtree/folder.gif",
	"images/dtree/folderopen.gif",
	</logic:equal>
	<logic:equal value="0" name="element" property="includeColumn">
	"",
	"",
	</logic:equal>	
	false
	);
	
</logic:iterate>

document.write(d);
//menus.innerHTML = d;
</script>


										</td>
									</tr>
								</table>
							</td>
							<td valign="top">
								<div align="center">
								</div>
								<table width="100%" align="center" border="0">
									<tr>
										<td align="center" valign="top" id="idcontentList">



										</td>
									</tr>
									<tr>
										<td colspan="2" align="center"
											style="border-top:gray 1px solid;">
										</td>
									</tr>
								</table>
							</td>
						</tr>

						</form>
					</table>
<script>
cid = gn("columnId").value;
p = document.getElementById("pageId");

if(p!=null){
	pageId = p.value
	list1(cid,pageId);
}else{
if (cid != 0){
list(cid);
}
}
</script>				
	</body>
</html>

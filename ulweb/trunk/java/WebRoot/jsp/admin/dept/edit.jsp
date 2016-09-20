
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="struts-bean.tld" prefix="bean"%>
<%@ taglib uri="struts-html.tld" prefix="html"%>
<%@ taglib uri="struts-logic.tld" prefix="logic"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>修改部门</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<LINK href="style/ul.css" type="text/css" rel=stylesheet>
		<!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

		<script>

</script>
		<script type="text/javascript" src="js/common.js"></script>
		<script type="text/javascript" src="jsp/admin/dept/dept.js"></script>
	</head>

	<body>
		<table width="450" border="0" cellspacing="0" cellpadding="0"
			align="center">
			<form action="web/admin/dept/deptAdmin.do?method=editSave"
				method="post" id="form1" name="form1">
				<html:hidden name="deptForm" property="dept.deptId" />
			<tr>

				<td>
					<table width="450" border="1" cellspacing="0" cellpadding="0"
						align="center">
						<tr>
							<td align="right">
								部门编号：
							</td>
							<td>
								<bean:write name="deptForm" property="dept.deptId" />
							</td>
						</tr>
						<tr>
							<td align="right">
								部门名称：
							</td>
							<td>
								<html:text name="deptForm" property="dept.deptName" />
						</tr>
						<tr>
							<td align="right">
								内容模板：
							</td>
							<td>
								<input type="hidden" name="tmplId" value="0" />
								<input type="hidden" name="tmplName" value="" />
								<html:text name="deptForm" property="dept.contentTmplName"
									readonly="true" />
								<html:hidden name="deptForm" property="dept.contentTmplId" />
								<input type="button" value="选择" onclick="selectConTmpl()" />
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td align="center">
					<input type="button" value="确定" onclick="doEditSave()" />
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button"
						onClick="javascript:window.location.href='deptAdmin.do?method=list'"
						value="取消" />
				</td>
			</tr>
			</form>
		</table>

	</body>
</html>

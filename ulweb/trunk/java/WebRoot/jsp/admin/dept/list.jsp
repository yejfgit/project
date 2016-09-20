
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
		<title>部门列表</title>

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
	</head>



	<body>
		<table align="center" border="0" cellpadding="0" cellspacing="0"
			width="450">
			<tr>
				<td>
					<table align="center" border="1" width="100%" cellpadding="2"
						cellspacing="0">
						<tr>
							<td>
								部门名称
							</td>
							<td>
								内容模板
							</td>
							<td>
								操作
							</td>
						</tr>

						<logic:iterate id="element" name="deptForm" property="list">
							<tr>
								<td>
									<bean:write name="element" property="deptName" />
								</td>
								<td>
									<bean:write name="element" property="contentTmplName" />
									&nbsp;
								</td>
								<td>
									<a
										href="web/admin/dept/deptAdmin.do?method=edit&id=<bean:write name="element" property="deptId" />">修改</a>
									<a
										href="web/admin/dept/deptAdmin.do?method=del&id=<bean:write name="element" property="deptId" />"
										onclick="return confirm('确定要删除吗？')" style="color:red">删除</a>
								</td>
							</tr>
						</logic:iterate>

					</table>
				</td>
			</tr>
			<tr>

				<td align="center">
					<input type="button" value="添加"
						onclick="location.href='deptAdmin.do?method=add'" />

				</td>

			</tr>
		</table>
	</body>
</html>


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
		<title>修改内容模板</title>

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

		<script type="text/javascript"
			src="jsp/admin/contentTmpl/contentTmpl.js"></script>
	</head>

	<body>
		<table width="450" border="0" cellspacing="0" cellpadding="0"
			align="center">
			<form
				action="web/admin/contentTmpl/contentTmplAdmin.do?method=editSave"
				method="post" id="form1" name="form1" onsubmit="return checkForm()">
				<html:hidden name="contentTmplForm" property="contentTmpl.tmplId" />
			<tr>

				<td>
					<table width="450" border="1" cellspacing="0" cellpadding="0"
						align="center">
						<tr>
							<td align="right">
								内容模板名称：
							</td>
							<td>
								<bean:write name="contentTmplForm"
									property="contentTmpl.tmplName" />
							</td>
						</tr>
						<tr>
							<td align="right">
								代码：
							</td>
							<td>
								<html:textarea name="contentTmplForm"
									property="contentTmpl.tmplContentString"
									style="width:300px;height:400px" />
						</tr>

					</table>
				</td>
			</tr>
			<tr>
				<td align="center">
					[
					<a href="javascript:;" onclick="previewTmpl()">预览</a>]
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" value="确定" onclick="doEditSave()" />
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button"
						onClick="javascript:location.href='contentTmplAdmin.do?method=list';"
						value="取消" />
				</td>
			</tr>
			</form>
		</table>

	</body>
</html>

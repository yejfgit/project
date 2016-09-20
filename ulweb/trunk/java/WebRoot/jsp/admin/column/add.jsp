
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
		<title>增加栏目</title>

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
		<table border="0" cellspacing="0" cellpadding="0" width="450"
			align="center">
			<input type="hidden" name="column.openColumn" value="0" />
			<input type="hidden" name="column.showOthersClass" value="0" />
			<input type="hidden" name="column.showOrganClass" value="0" />
			<input type="hidden" name="column.includeContent" value="0" />

			<input type="hidden" name="column.parentId"
				value="<bean:write name="columnForm" property="parentColumn.columnId" />" />
<input type="hidden" name="column.organId"
				value="<bean:write name="columnForm" property="parentColumn.organId" />" />				
			<tr>
				<td>

					<table border="1" align="center" width="100%" cellspacing="0">
						<tr>
							<td colspan="2" align="center">
								&nbsp;
								<span class="9red">添加栏目</span>
							</td>
						</tr>
						<tr>
							<td>
								上级栏目
							</td>
							<td id="idparentName">
								<bean:write name="columnForm" property="parentColumn.columnName" />

							</td>
						</tr>
						<tr>
							<td>
								栏目名称
							</td>
							<td>
								<input name="column.columnName" id="idcolumnName" type="text"
									value="" />
							</td>
						</tr>

						<tr>
							<td>
								英文名称
							</td>
							<td>
								<input name="column.columnEid" id="" type="text" value="" />
							</td>
						</tr>

						<tr>
							<td>
								这个栏目用于放
							</td>
							<td>
								<input type="radio" value="1" name="column.includeColumn">
								栏目
								<input type="radio" value="0" name="column.includeColumn"
									checked>
								内容
							</td>
						</tr>

						<tr>
							<td>
								是否在页面显示
							</td>
							<td>
								<input type="radio" value="1" name="column.showToUser">
								显示
								<input type="radio" value="0" name="column.showToUser" checked>
								不显示
							</td>
						</tr>

						<tr>
							<td>
								栏目排序
							</td>
							<td>
								<input type="text" name="column.columnOrder" value="5" size="5"
									maxlength="2"></input>
							</td>
						</tr>
						<tr>
							<td valign="top">
								选择内容模板
							</td>
							<td valign="top">
								<input type="hidden" name="tmplId" value="0" />
								<input type="hidden" name="tmplName" value="" />
								<input type="text" name="column.contentTmplName" value=""
									readonly />
								<input type="hidden" name="column.contentTmplId" value="0" />
								<input type="button" value="选择" onclick="selectConTmpl()" />
							</td>
						</tr>

					</table>
				</td>
			</tr>
			<tr>
				<td height="10"></td>
			</tr>
			<tr>
				<td align="center">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td>
								<input type="button" value="添加此栏目"
									onClick="javascript:addColumn();" />
							</td>
							<td width="20"></td>
							<td>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>

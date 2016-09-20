
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
		<title>修改栏目</title>

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
			<tr>
				<td>
					<table border="1" width="100%" align="center" cellpadding="2"
						cellspacing="0">
						<html:hidden name="columnForm" property="column.columnId" />
						<tr>
							<td colspan="2" align="center">
								修改栏目
							</td>
						</tr>
						<tr>
							<td>
								上级栏目
							</td>
							<td id="idparentName">

								<logic:equal value="0" name="columnForm"
									property="column.parentId">
栏目为一级栏目，无上级栏目</logic:equal>
								<logic:notEqual value="0" name="columnForm"
									property="column.parentId">
									<bean:write name="columnForm"
										property="parentColumn.columnName" />
								</logic:notEqual>
							</td>
						</tr>

						<tr>
							<td>
								上级栏目号修改为
							</td>
							<td>
								<html:text name="columnForm" property="column.parentId" />
							</td>
						</tr>

						<tr>
							<td>
								栏目名称
							</td>
							<td>
								<html:text name="columnForm" property="column.columnName" />
							</td>
						</tr>

						<tr>
							<td>
								英文名称
							</td>
							<td>
								<html:text name="columnForm" property="column.columnEid" />
							</td>
						</tr>


						<tr>
							<td>
								这个栏目用于放
							</td>
							<td>
								<logic:equal value="1" name="columnForm"
									property="column.includeColumn">
栏目</logic:equal>
								<logic:equal value="0" name="columnForm"
									property="column.includeColumn">
内容</logic:equal>
							</td>
						</tr>
						<tr>
							<td>
								是否在页面显示
							</td>
							<td>
								<html:radio name="columnForm" property="column.showToUser"
									value="1"></html:radio>
								显示
								<html:radio name="columnForm" property="column.showToUser"
									value="0"></html:radio>
								不显示
							</td>
						</tr>

						<tr>
							<td>
								栏目显示顺序
							</td>
							<td>
								<html:text name="columnForm" property="column.columnOrder" />
							</td>
						</tr>
						<tr>
							<td valign="top">
								选择内容模板
							</td>
							<td valign="top">
								<input type="hidden" name="tmplId" value="0" />
								<input type="hidden" name="tmplName" value="" />
								<html:text name="columnForm" property="column.contentTmplName"
									readonly="true" />
								<html:hidden name="columnForm" property="column.contentTmplId" />
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
								<input type="button" value="确定更改"
									onClick="javascript:editColumn();" />
							</td>
							<td width="20"></td>
							<td>
								<input type="button" onClick="javascript:deleteColumn();"
									value="删除此栏目" />
							</td>
							<td width="20"></td>
							<td>
								<logic:equal value="1" name="columnForm"
									property="column.includeColumn">
									<input type="button"
										onClick="javascript:toAddColumn(<bean:write name="columnForm" property="column.columnId" />,'<bean:write name="columnForm" property="column.columnName" />');"
										value="在此栏目下添加新栏目" />
								</logic:equal>

							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>

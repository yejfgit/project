
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

<%
	response.setHeader("Pragma", "No-Cache");
	response.setHeader("Cache-Control", "No-Cache");
	response.setDateHeader("Expires", 0);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>" target="_self">
		<title>选择内容模板</title>

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
		<script type="text/javascript" src="js/common.js"></script>
		<script type="text/javascript"
			src="jsp/admin/contentTmpl/contentTmpl.js"></script>
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
								选择内容模板
							</td>
						</tr>

						<logic:iterate id="element" name="contentTmplForm" property="list">
							<tr>
								<td>
									<a href="javascript:;"
										onclick="chooseTmpl(<bean:write name="element" property="tmplId" />,'<bean:write name="element" property="tmplName" />');"><bean:write
											name="element" property="tmplName" />
									</a>
								</td>
							</tr>
						</logic:iterate>

					</table>
				</td>
			</tr>

		</table>
	</body>
</html>

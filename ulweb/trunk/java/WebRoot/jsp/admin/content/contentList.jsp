
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

		<title>显示内容列表</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<LINK href="style/dtree.css" type="text/css" rel=stylesheet>
		<!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">


		<script type="text/javascript">

</script>

	</head>

	<body>
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr align="center">
				<td valign="top">
					<a href="javascript:toAdd();" style="color: red; font-size: 18px;">添加</a>
				</td>
			</tr>
			<tr>
				<td>
					<html:hidden name="contentForm" property="column.columnId" />
					<table width="100%" border="1" cellpadding="0" cellspacing="0">
						<tr>
							<td>
								内容标题
							</td>
							<td>
								发布时间
							</td>
							<td>
								发布人
							</td>
							<td>
								修改时间
							</td>
							<td width="10%">
								操作
							</td>
						</tr>
						<logic:iterate id="element" name="contentForm"
							property="contentList">
							<tr>
								<td>
									<a
										href='show.do?c=<bean:write name="element" property="contentId" />'
										target="_blank" style='color: <bean:write name="element"
											property="contentColor" />'><bean:write name="element"
											property="contentName" />
									</a>
									<logic:equal value="1" name="element" property="isProcessing">
										<span style="color:red">[处理中]</span>
									</logic:equal>
								</td>
								<td>
									<bean:write name="element" property="uploadTime" format="yyyy-MM-dd HH:mm:ss" />
								</td>
								<td>
									<bean:write name="element" property="uploadUser" />
								</td>
								<td>
									<bean:write name="element" property="updateTime" format="yyyy-MM-dd HH:mm:ss" />
								</td>
								<td>
									<a
										href='web/admin/content/contentAdmin.do?method=edit&id=<bean:write name="element" property="contentId" />&pageId=<bean:write name="contentForm" property="page.pageNum"
						filter="false" /> '>修改</a>
									<br>
									<a
										href='web/admin/content/contentAdmin.do?method=del&id=<bean:write name="element" property="contentId" />'
										onclick="return confirm('确定要删除吗？')" style="color:red">删除</a>
								</td>
							</tr>
						</logic:iterate>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<bean:write name="contentForm" property="page.pageTag"
						filter="false" />


				</td>
			</tr>
		</table>
	</body>
</html>

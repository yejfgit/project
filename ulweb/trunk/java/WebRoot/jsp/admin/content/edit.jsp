
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

		<title>修改内容</title>

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
	<script language="JavaScript" src="js/common.js"></script>
	<script language="JavaScript" src="jsp/admin/content/content.js"></script>
	<script type="text/javascript" src="editor/fckeditor/fckeditor.js"></script>
	<script language="JavaScript" src="script/dtree.js"
		type="text/javascript"></script>

	<body>
		
		<table width="750" border="0" cellspacing="0" cellpadding="0"
			align="center" style="border-left:gray 1px solid;">
			<form action="web/admin/content/contentAdmin.do?method=editSave"
				method="post" name="form1" id="idform1">
				<input type="hidden" name="pageId" id="pageId" value="<bean:write name="pageId"/>">
				<input type="hidden" name="content.contentString" id="idcontent" />
				<html:hidden name="contentForm" property="content.columnId" />
				<html:hidden name="contentForm" property="content.organId" />
			<tr>


				<td>
					<table border="1" cellpadding="0" cellspacing="0" width="100%">

						<tr>
							<td width="35%">
								上级栏目:
							</td>
							<td id="idcolumnInfo">
								<bean:write name="contentForm" property="column.columnName" />
							</td>
						</tr>
						<tr>
							<td>
								标题(必添):
							</td>
							<td>
								<html:text name="contentForm" property="content.contentName" />
							</td>
						</tr>
						<tr>
							<td>
								副标题:
							</td>
							<td>
								<html:text name="contentForm" property="content.subTitle" />
							</td>
						</tr>
						<tr>
							<td>
								关键字:
							</td>
							<td>
								<html:text name="contentForm" property="content.keyWord" />
							</td>
						</tr>

						<tr>
							<td>
								上传部门:
							</td>
							<td>
								<html:text name="contentForm" property="content.uploadDeptStr" />
							</td>
						</tr>

						<tr>
							<td>
								文号:
							</td>
							<td>
								<html:text name="contentForm" property="content.documentNum" />
							</td>
						</tr>

						<tr>
							<td>
								重要程度(与主页设计有关):
							</td>
							<td>
								<html:select name="contentForm" property="content.displayType">
									<html:option value="0">
										一般(显示为默认暗绿色)
									</html:option>
									<html:option value="8">
										需要注意(显示为黄色)
									</html:option>
									<html:option value="9">
										重要(显示为红色)
									</html:option>
									<html:option value="2">
										黑色
									</html:option>
									<html:option value="3">
										蓝色
									</html:option>
									<html:option value="4">
										绿色
									</html:option>
									<html:option value="5">
										蓝绿
									</html:option>
									<html:option value="6">
										淡紫
									</html:option>
									<html:option value="7">
										紫色
									</html:option>

								</html:select>
							</td>
						</tr>


						<tr>
							<td valign="top">
								排序:
								<br>
							</td>
							<td valign="top">
								<html:text name="contentForm" property="content.orderNum" />
							</td>
						</tr>
						<tr>
							<td colspan="2">
								内容:
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<table cellpadding="0" border="0" cellspacing="0" width="100%">
									<tr>
										<td>
											<script type="text/javascript">
									var oFCKeditor = new FCKeditor( 'FCKeditor1' ) ;
									oFCKeditor.BasePath	= "<%=basePath%>editor/fckeditor/" ;
									oFCKeditor.Height	= 400 ;
									oFCKeditor.Value	= '<bean:write name="contentForm" property="content.contentString" filter="false" />';
									oFCKeditor.Create() ;
								</script>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td>
								附件:
							</td>
							<td>
								<a href="<%=request.getContextPath()%>/web/admin/attachment/attachmentAdmin.do?method=list&contentId=<bean:write name="contentForm" property="content.contentId" />" target="_blank">详细</a>
							</td>
						</tr>
						<tr>
							<td>
								是否继续添加附件
							</td>
							<td id="idfiles">
								<input type="radio" name="att" value="1">
								有
								<input type="radio" value="0" name="att" id="idattNull" checked>
								否
							</td>
						</tr>
						<tr>
							<td colspan="2" align="center">
								<input type="button" onClick="subEditFrm();" value="确定" />
								&nbsp;&nbsp;
								<input type="button" onClick="cancel()"
									value="取消" />
							</td>
						</tr>
					</table>
				</td>
			</tr>
			</form>
		</table>

	</body>
</html>

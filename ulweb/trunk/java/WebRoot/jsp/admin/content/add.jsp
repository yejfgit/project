
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

		<title>添加内容</title>

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
			<form action="web/admin/content/contentAdmin.do?method=addSave"
				method="post" name="form1" id="idform1">
				<input type="hidden" name="content.attachmentSum" value="0" />
				<input type="hidden" name="content.contentString" id="idcontent" />
				<input type="hidden" name="content.columnId" id="idcolumnId"
					value='<bean:write name="contentForm" property="column.columnId" />' />
<input type="hidden" name="content.organId" id="idorganId"
					value='<bean:write name="contentForm" property="column.organId" />' />					
			<tr>



				<td>
					<table border="1" cellpadding="0" cellspacing="0" width="100%">

						<tr>
							<td width="35%">
								所属栏目:
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
								<input type="text" name="content.contentName" id="idcontentName"
									maxlength="100" size="20" style="color:#004A1B;" />
							</td>
						</tr>

						<tr>
							<td>
								副标题:
							</td>
							<td>
								<input type="text" name="content.subTitle" id="idsubTitle"
									maxlength="100" size="20" value="" />
							</td>
						</tr>

						<tr>
							<td>
								关键字:
							</td>
							<td>
								<input type="text" maxlength="20" size="20"
									name="content.keyWord" value="" />
							</td>
						</tr>

						<tr>
							<td>
								发布部门:
							</td>
							<td>
								<input type="text" name="content.uploadDeptStr"
									id="iduploadDeptStr" maxlength="20" value="" size="20" />
							</td>
						</tr>

						<tr>
							<td valign="top">
								文号:
							</td>
							<td valign="top">
								<input type="text" name="content.documentNum" maxlength="20"
									value="" size="20">
							</td>
						</tr>
						<tr>
							<td>
								重要程度(与主页设计有关):
							</td>
							<td>
								<select name="content.displayType" id="iddisplaytype">
									<option value="0">
										一般(显示为默认暗绿色)
									</option>
									<option value="8">
										需要注意(显示为黄色)
									</option>
									<option value="9">
										重要(显示为红色)
									</option>
									<option value="2">
										黑色
									</option>
									<option value="3">
										蓝色
									</option>
									<option value="4">
										绿色
									</option>
									<option value="5">
										蓝绿
									</option>
									<option value="6">
										淡紫
									</option>
									<option value="7">
										紫色
									</option>

								</select>
							</td>
						</tr>


						<tr>
							<td valign="top">
								排序:
								<br>
							</td>
							<td valign="top">
								<input type="text" maxlength="20" size="20"
									name="content.orderNum" value="" />
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
									oFCKeditor.Value	= "";
									oFCKeditor.Create() ;
								</script>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td>
								是否添加附件:
							</td>
							<td id="idfiles">
								<input type="radio" name="att" value="1">
								有
								<input type="radio" value="0" id="idattNull" name="att" checked>
								无
							</td>
						</tr>

						<tr>
							<td colspan="2" align="center">
								<input type="button" onClick="subFrm();" value="确定" />
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

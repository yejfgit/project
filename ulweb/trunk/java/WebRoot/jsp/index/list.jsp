<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="struts-bean.tld" prefix="bean"%>
<%@ taglib uri="struts-html.tld" prefix="html"%>
<%@ taglib uri="struts-logic.tld" prefix="logic"%>
<%@ taglib uri="ulweb-list.tld" prefix="ulweb"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
			
	String enName = request.getParameter("eId");
	String keyWord = request.getParameter("keyWord");
	String strId = request.getParameter("id");
	String strPage = request.getParameter("pageNum");
	
	int columnId;
	try {
		columnId = Integer.parseInt(strId);
	} catch (Exception e) {
		columnId = 0;
	}
	
	int pageNum;
	try {
		pageNum = Integer.parseInt(strPage);
	} catch (Exception e) {
		pageNum = 1;
	}	


%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title></title>
		<style type="text/css">
<!--

-->
</style>
		<link href="dept/baofei2/main.css" rel="stylesheet" type="text/css" />
		<script src="dept/baofei2/main.js"></script>
	</head>

	<body>
		<table width="800" border="0" align="center" cellpadding="0"
			cellspacing="0">



<tr><td align="right">
	<br />
</td></tr>

			<tr>
				<td>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="20%" valign="top" bgcolor="#EDEDED">

								<table width="100%">
									<tr>
										<td valign="top" bgcolor="#C0C0C0" class="index_col_title">
<ulweb:list beanName="c" entityName="ColumnEntity" pageNum="1" pageSize="1" conditions="columnEid=<%=enName %>:s;" />

											<logic:iterate id="element" name="c" property="objectList">
												<li>
													<bean:write name="element" property="columnName" />
												</li>
											</logic:iterate>
										</td>
									</tr>
									<tr>
										<td height="25" bgcolor="#C0C0C0" class="index_col_title">
<ulweb:column beanName="sl" deptId="baofei" enName="<%=enName %>" columnId="<%=columnId %>" withSub="1" />
<bean:write name="sl" property="columnName" />										
										</td>
									</tr>
									<tr>
										<td>
<logic:iterate id="element" name="sl" property="subColumns">
	<li>
		<a href="jsp/index/list.jsp?id=<bean:write name="element" property="columnId" />"><bean:write name="element" property="columnName" /></a>
	</li>
</logic:iterate>
										</td>
									</tr>
									<tr><td>&nbsp;</td></tr>
									<tr>
										<td valign="top" bgcolor="#FFFFFF"><br /></td>
									</tr>
								</table>

							</td>
							<td valign="top">

								<table>
									<tr><td valign="top">
<ulweb:navbar beanName="nb"  deptId="0000" enName="<%=enName%>" columnId="<%=columnId %>" />
<bean:write name="nb" />
</td></tr><tr>
										<td>
											<ulweb:content beanName="cl" deptId="0000"
												enName="<%=enName%>"
												columnId="<%=columnId %>"
												keyWord="<%=keyWord %>"
												conditions="isDelete=0:i;isProcessing=0:i;"
												pageNum="<%=pageNum %>" />

		<logic:iterate id="element" name="cl" property="objectList">
		<li>
			<bean:write name="element" property="contentNameLink" filter="false" />
			<bean:write name="element" property="attachmentLink" filter="false" />
		</li>
		</logic:iterate>
											
										</td>
									</tr><tr><td valign="top">
<bean:write name="cl" property="pageTag" filter="false" />
</td></tr>
								</table>

							</td>
						</tr>
					</table>
				</td>
			</tr>
			


		</table>




	</body>
</html>

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
		<title>列表 - 保费部</title>
		<style type="text/css">
<!--

-->
</style>
		<link href="dept/baofei2/main.css" rel="stylesheet" type="text/css" />
		<script src="dept/baofei2/main.js"></script>
	</head>

	<body>
		<table width="800" border="0" align="center" cellpadding="0"
			cellspacing="0" bgcolor="#FFFFFF">

<jsp:include flush="true" page="head.jsp"></jsp:include>



			<tr>
				<td>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="20%" valign="top" bgcolor="#E3E3E3">

								<table width="100%">
<tr><td>&nbsp;</td></tr>
									<tr>
										<td height="25" bgcolor="#C0C0C0" class="index_col_title" style="color: #CC0026" align="center">
<ulweb:column beanName="sl" deptId="baofei" enName="<%=enName %>" columnId="<%=columnId %>" withSub="1" />
<bean:write name="sl" property="columnName" />										
										</td>
									</tr>
									<tr>
										<td height="150">
<logic:iterate id="element" name="sl" property="subColumns">
	<li style="list-style: none">
		》<a href="dept/baofei2/list.jsp?id=<bean:write name="element" property="columnId" />"><bean:write name="element" property="columnName" /></a>
	</li>
</logic:iterate>
										</td>
									</tr>
									<tr><td>&nbsp;</td></tr>
									<tr>
										<td valign="top">

<img src="dept/baofei2/images/contact2.jpg" />

										</td>
									</tr>
								</table>

							</td>
							<td valign="top" style=" border: solid 1px #CCCCCC">
 
								<table>
<tr><td align="right">
	<a href="dept/baofei2/index.jsp">返回首页</a>
</td></tr>								
									<tr><td valign="middle" width="700" height="25" style="border-top: solid 1px #CCCCCC; border-bottom: solid 1px #CCCCCC">

<ulweb:navbar beanName="nb" deptId="baofei" enName="<%=enName%>" columnId="<%=columnId %>" />

&nbsp;&nbsp;
<script>
var navbar = '<bean:write name="nb" />';
navbar = navbar.replace('保费部 &gt; ', '');
document.writeln(navbar);
</script>
</td></tr><tr>
										<td valign="top" height="300" style="padding-left: 10px;">

											<ulweb:content beanName="cl" deptId="baofei"
												enName="<%=enName%>"
												columnId="<%=columnId %>"
												keyWord="<%=keyWord %>"
												conditions="isDelete=0:i;isProcessing=0:i;"
												pageNum="<%=pageNum %>" />

											<logic:iterate id="element" name="cl" property="objectList">
												<li>
			<bean:write name="element" property="contentNameLink" filter="false" />
			<bean:write name="element" property="new" filter="false" />&nbsp;&nbsp;&nbsp;&nbsp;
			<bean:write name="element" property="uploadTime" format="yyyy-MM-dd" />&nbsp;&nbsp;&nbsp;&nbsp;
			<bean:write name="element" property="attachmentLink" filter="false" />
			<bean:define id="cid" name="element" property="columnId" />

<% if (enName == null && columnId == 0) { %>
<ulweb:column beanName="cc" deptId="baofei" columnId="<%=Integer.parseInt(cid.toString()) %>" />
[&nbsp;<bean:write name="cc" property="columnName" />&nbsp;]	
<% } %>
												</li>
											</logic:iterate>
	
										</td>
									</tr><tr><td valign="top" style="padding-left: 10px">
<bean:write name="cl" property="pageTag" filter="false" />
</td></tr>
<tr><td>&nbsp;</td></tr>
								</table>

							</td>
						</tr>
					</table>
				</td>
			</tr>
			
<jsp:include flush="true" page="foot.jsp"></jsp:include>

		</table>




	</body>
</html>

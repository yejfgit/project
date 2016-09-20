
<%@ taglib uri="struts-bean.tld" prefix="bean"%>
<%@ taglib uri="struts-html.tld" prefix="html"%>
<%@ taglib uri="struts-logic.tld" prefix="logic"%>
<%@ taglib uri="ulweb-list.tld" prefix="ulweb"%>

<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.ulweb.entity.UlAttachment,com.ulic.ulweb.frame.constant.Constant,com.ulic.ulweb.ulweb.web.action.IndexAction" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//if(request.getAttribute("from") == null) response.sendRedirect(basePath + "index.do");
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>">
    
    <title>信息管理中心</title>
    <script type="text/javascript" src="js/top.js"></script>
	<script type="text/javascript" src="js/common.js"></script>
	<link href="css/main1zhn.css" rel="stylesheet" type="text/css" />
    <script language="JavaScript" src="script/list.js"></script>

	<script>
	
	</script>

  </head>
  

<body style="background-color:#CCCCCC">
<table align="center">
<tr>
	<td colspan="3" height="200px">
	</td>
</tr>
<tr>
<td >
<a href="dept/it/fabu.jsp" target="_blank"><img border="2px" style="border-color:#000000" height="116" width="250" src="dept/it/images/1.jpg"></a>&nbsp;&nbsp;&nbsp;&nbsp;
</td>
<td >
<a href="dept/it/zixun.jsp" target="_blank"><img border="2px" style="border-color:#000000" height="116" width="250" src="dept/it/images/2.jpg"></a>&nbsp;&nbsp;&nbsp;&nbsp;
</td>
<td >
<a href="http://it/Lists/system/AllItems.aspx" target="_blank"><img border="2px" style="border-color:#000000" height="116" width="250" src="dept/it/images/3.jpg"></a>
</td>
</tr>

<tr>
	<td height="100">
	</td>
</tr>
<tr>
<td >
<a href="http://it/service/meeting/default.aspx" target="blank"><img border="2px" style="border-color:#000000" height="116" width="250" src="dept/it/images/4.jpg"></a>&nbsp;&nbsp;&nbsp;&nbsp;
</td>
<td >
<a href="http://it/training/default.aspx" target="_blank"><img border="2px" style="border-color:#000000" height="116" width="250" src="dept/it/images/5.jpg"></a>&nbsp;&nbsp;&nbsp;&nbsp;
</td>
<td >
<ulweb:content beanName="cl" deptId="0000" enName="mail_address" pageNum="1" pageSize="1" conditions="isDelete=0:i;" />
		<logic:iterate id="element" name="cl" property="objectList">
			  <a href="show.do?c=<bean:write name="element" property="contentId" />"><img border="2px" style="border-color:#000000" height="116" width="250" src="dept/it/images/6.jpg"></a>
		</logic:iterate>
</td>
</tr>
</table>
</body>
</html>

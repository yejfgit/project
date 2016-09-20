<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
<head>
	<html:base />

	<title>查看附件列表</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
table { border-collapse:collapse;}
th,
td { padding:5px; border:1px solid #000; font-size:12px;}
</style>
	
	<script type="text/javascript">
function detail(attachmentId){
   var form = document.getElementById("listform");
   form.action +="?method=detail&attachmentId="+attachmentId;
   form.submit();
   
}

function download(path,showName){
 
  showName =encodeURI(showName);
  showName =encodeURI(showName);
  var form = document.getElementById("listform");
  form.action ="<%=request.getContextPath()%>/web/admin/attachment/attachmentAdmin.do?method=download&path="+path+"&showName="+showName;
   form.submit();
   form.action ="";
}
</script>
</head>
<logic:notEmpty name="message">
	<bean:write name="message" />
</logic:notEmpty>
<base target="_self"/>
<body>
	<form
		action="<%=request.getContextPath()%>/web/admin/attachment/attachmentAdmin.do"
		id="listform" method="post">
		<table border="1" id="listTable" align="center" >
			<tr align="center">
				<td width="10%">
					附件名称
				</td>
				<td width="10%">
					策略名称
				</td>
				<td width="15%">
					策略描述
				</td>
				<td width="10%">
					密级
				</td>
				<td width="15%">
					权限组
				</td>
				<td width="15%">
					权限用户
				</td>
				<td width="10%">
					状态
				</td>				
				<td width="15%">
					操作
				</td>
				
				
			</tr>
			<logic:notEmpty name="list">
			<logic:notEmpty name="contentId">
			    <input type="hidden" value="<bean:write name="contentId"/>" name="contentId">
			</logic:notEmpty>
				<logic:iterate id="attachment" name="list">
				    
					<tr align="left">
						<td>
							<bean:write name="attachment" property="showName" />

						</td>
						<td>
						 <logic:notEmpty name="attachment" property="ulPolicy">
							<bean:write name="attachment" property="ulPolicy.policyName" />
						</logic:notEmpty> 
						</td>
						<td>
						<logic:notEmpty name="attachment" property="ulPolicy">
							<bean:write name="attachment" property="ulPolicy.policyDesc" />
						</logic:notEmpty> 
						</td>
						<td>
						<logic:notEmpty name="attachment" property="ulPolicy">
							<bean:write name="attachment" property="ulPolicy.secure" />
						</logic:notEmpty> 
						</td>
						<td>
						<logic:notEmpty name="attachment" property="ulPolicy">
							<bean:write name="attachment" property="ulPolicy.groups" />
						</logic:notEmpty> 
						</td>
						<td>
						<logic:notEmpty name="attachment" property="ulPolicy">
							<bean:write name="attachment" property="ulPolicy.users" />
						</logic:notEmpty> 
						</td>
						<td>
						<bean:write name="attachment" property="statusString"/>
						</td>
						<td>
						
						
						

						<logic:notEmpty name="attachment" property="displayPath">
							<a href="javascript:download('<bean:write name="attachment" property="displayPath"/>','<bean:write name="attachment" property="showName"/>')" >下载文件</a>

						</logic:notEmpty>
						
						<logic:equal value="true" name="attachment" property="canDelete">
							<a href="<%=request.getContextPath() %>/web/admin/attachment/attachmentAdmin.do?method=del&attachmentId=<bean:write name="attachment" property="attachmentId" />" onclick="return confirm('确实要删除该附件吗？')"><img src="<%=request.getContextPath() %>/images/admin/attachment/delete.jpg" border="0" />删除</a>
						</logic:equal>

						
						</td>
					
					</tr>
				</logic:iterate>
			</logic:notEmpty>
		</table>
	</form>
</body>
</html:html>

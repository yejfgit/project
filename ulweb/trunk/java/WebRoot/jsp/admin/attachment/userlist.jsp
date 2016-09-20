<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
<head>
	<html:base />

	<title>查询用户列表</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	

	<script type="text/javascript">
function selectedUser(uidString,friendlyName,cannoName){
//  alert( "id = " + id + " name = " + name);
     var ary = new Array();
     ary[1]= friendlyName+"("+uidString+")";
     ary[0]= cannoName;
     window.returnValue =ary.join("%");
     window.close();
     
     
}

function submit(){
   
 var uidString = document.getElementById("uidString").value;
 if(uidString == null || uidString==""){
   alert("请输入查询条件");
   return;
 }
  var f = document.getElementById("userListForm");
	f.target = '_self';
	f.submit();

}

</script>
</head>
<base target="_self">
<body>

	<form
		action="<%=request.getContextPath()%>/web/admin/attachment/attachmentAdmin.do?method=findUser"
		method="post" id="userListForm">
		<br>
		<table align="center">
			<tr>
				<td>
				    <logic:empty name="uidString">
				      <input type="text" name="uidString" id="uidString" value="">
				    </logic:empty>
				    <logic:notEmpty name="uidString">
				    
				    <input type="text" name="uidString" id="uidString" value="<bean:write name="uidString" />">
				    </logic:notEmpty>
				</td>
				<td>
					<input type="button" onclick="submit()" name="query" value="查询">
				</td>
			</tr>
		</table>
		<br>
		用户列表：
		<br>
		<table border="1" align="center">
			<tr>
				<td>
					用户名
				</td>
				<td>
					真实姓名
				</td>
				<td>
					email
				</td>
			</tr>


			<logic:notEmpty name="userList">


				<logic:iterate id="user" name="userList">
					<tr style="cursor:pointer"
						onclick="selectedUser('<bean:write name="user" property="uidstring"/>','<bean:write name="user" property="edcprincipalentity.friendlyname"/>','<bean:write name="user" property="edcprincipalentity.canonicalname"/>')">
						<td>
							<bean:write name="user" property="uidstring" />
						</td>
						<td>
							<bean:write name="user"
								property="edcprincipalentity.friendlyname" />
						</td>
						<td>
							<bean:write name="user"
								property="edcprincipalentity.friendlyemail" />
						</td>
					</tr>
				</logic:iterate>
			</logic:notEmpty>
			<logic:notEmpty name="uidString">
			<logic:empty  name="userList">
			
			    <tr>
			     <td colspan="3"> 未查询到相关数据</td>
			    </tr>
			</logic:empty>
			</logic:notEmpty>

		</table>

	</form>
</body>
</html:html>

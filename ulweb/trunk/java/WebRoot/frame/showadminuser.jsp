
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlRoleClass" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>选择人员</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <LINK href="style/ul.css" type="text/css" rel=stylesheet>
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>
  
  <body>
  <table align="center" border="0" width="400" >  
  	<form action="admin/addRoleClass.do?method=getUser" method="post" name="form1" id="idform1">
	
  	 <%
   		List<UlRoleClass> l = (List<UlRoleClass>)request.getAttribute("list");
		if(l == null){
			%>
			<tr><td colspan="3" height="50"></td></tr>
				<tr><td width="50"></td>
					<td align="left" colspan="2">
						<%=(request.getAttribute("noName") == null ? "" : request.getAttribute("noName"))%>人员名称:
					</td>
					
				</tr>
				<tr><td width="50"></td>
					<td align="left">
						<input type="text" name="userName" id="idname" maxlength="20" size="20"></input>
					</td>
					<td>
						<input type="submit" value="<%=(request.getAttribute("retry") == null ? "" : request.getAttribute("retry"))%>查找" />
					</td>
				</tr>
				<script language="JavaScript">
					document.getElementById("idname").focus();
				</script>
			<%
		}else if(l.size() == 1){
			%>
				<script language="JavaScript">
					opener.document.getElementById("iduserId").value = <%=l.get(0).getRoleId()%>;
					window.close();
				</script>
			<%
		} else {
			for(int i = 0 ; i < l.size(); i++ ) {
				%>
					<tr>
						<td colspan="2">
							<input type="radio" name="userId" value="<%=l.get(i).getRoleId()%>" /><%=l.get(i).getName()%>
						</td>
					</tr>
				<%
			}
			%>
				<tr>
					<td colspan="2" align="center">
						<input type="button"  value="确定" onClick="javascript:checkOk();" />
					</td>
				</tr>
			<%
		}
   %>
   </form>
  </table>
   <script  language="JavaScript">
   		window.resizeTo(450,400);
		function checkOk(){
			if(document.form1.userId.value = ""){
				alert("请选择人员");				
			}else{
				for(var i = 0; i < document.form1.userId.length; i++){
					if(document.form1.userId[i].checked){
						opener.document.getElementById("iduserId").value = document.form1.userId[i].value;
						break;
					}
				}				
				window.close();
			}
		}
   </script>
  </body>
</html>

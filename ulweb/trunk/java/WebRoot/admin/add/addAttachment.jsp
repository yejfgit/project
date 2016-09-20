
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加附件</title>
    
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
  <script language="JavaScript" src="script/content.js"></script> 
  <body>
<table width="550" border="1" align="center" cellpadding="0" cellspacing="0">
	<form action='admin/content.do?method=addAttachment' method="post" name="form1" enctype="multipart/form-data">
	<input type="hidden" name="contentId" value='<%=request.getAttribute("contentId")%>' />
	<input type="hidden" name="columnId" value='<%=request.getAttribute("columnId")%>' />
	<input type="hidden" name="deptId" value='<%=request.getAttribute("deptId")%>' />
	<input type="hidden" name="attSum" value="<%=(request.getAttribute("attSum") == null ? "0" : request.getAttribute("attSum")) %>"/>
  <!--DWLayoutTable-->
  <tr> 
   	<td height="25">
			内容标题
	</td>
	<td>
		<%=request.getParameter("contentName")%>
	</td>
  </tr>
  <tr>
  	<td colspan="2">
		请注意 ： 附件大小不能超过5M
	</td>
  </tr>
  <tr>
   	<td valign="top">
		<input type="button" onClick="addFile();" value="增加附件个数"></input>
	</td>
	<td id="idfiles">
		<table cellpadding="0" cellspacing="0" border="0" width="100%">
			<tbody id="idtbody">
				<tr>
					<td>
						<input type="file" name="files"></input>
					</td>
				</tr>
			</tbody>
		</table>
	</td>
  </tr>
  <tr>
		<td>
		<input type="submit" value="完成" />
		</td>
		<td>
		<input type="reset" value="重置" />
		</td>
  	
  </tr>
  </form>
</table>
</body>
</html>


<%@ page language="java" import="java.util.*,com.ulic.ulweb.frame.constant.Constant" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'report.jsp' starting page</title>
    
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
    <script type="text/javascript" src="editor/fckeditor/fckeditor.js"></script>
  <body>
   <table width="760" border="0" align="center" style="border-left:gray 1px solid; border-right:gray 1px solid;">
   <tr><td></td></tr>
   	<tr><td width="10"></td>
		<td>
			<iframe src="frame/chatpage.jsp" width="740" height="500"></iframe>
		</td>
		<td width="10"></td>
	</tr>
	<tr><td colspan="3"></td></tr>
	<form action="chat.do?method=save" method="post" name="form1" id="idform1" onSubmit="javascript:document.getElementById('idcontent').value=FCKeditorAPI.GetInstance('FCKeditor1').GetXHTML(true);">
	<input type="hidden" name="content"  id="idcontent"></input>
	<tr>
	<td></td>
		<td >
								<script type="text/javascript">
									var oFCKeditor = new FCKeditor( 'FCKeditor1' ) ;
									oFCKeditor.BasePath	= "<%=basePath%>editor/fckeditor/" ;
									oFCKeditor.Height	= 200 ;
									oFCKeditor.Value	= "";
									oFCKeditor.Create() ;
								</script>
		</td>
		<td></td>
	</tr>
	<tr><td colspan="3"><input name="tijiao" type="submit" value="发送"></td></tr>
	</form>
   </table>
   
  </body>
</html>


<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'listcontent.jsp' starting page</title>
    
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
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>
    <script language="JavaScript" src="script/content.js"></script>
	 <script language="JavaScript" src="script/ajax.js"></script>
	  <script language="JavaScript" src="script/dtree.js" type="text/javascript" ></script> 
  <body>
 <table align="center" border="1" cellpadding="0" cellspacing="0" width="750">
 	<form action="admin/content.do?method=bEdit" method="post" name="form1" id="idform1">
		<input type="hidden"  id="iddeptId" name="deptId"  value='<%=request.getAttribute("deptId")%>'/>
		<input type="hidden" id="idcolumnId" name="columnId" />
 	<tr>
		<td>
			<table width="750" cellpadding="0" cellspacing="0">
				<tr>
					<td width="300">
						<table align="left" bgcolor="#CCCCCC"  cellpadding="0" cellspacing="0" width="300">
							<tr>
								<td>									
										<%=request.getAttribute("columnList")%>									
								</td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%">
							<tr>
								<td id="idcontentList">
																
								</td>
							</tr>
							<tr>
								
                  <td align="center" valign="bottom" height="25"> <a href="javascript:toAdd();"><font color="#FF0000">添加</font></a>	
                  </td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	</form>
 </table>
  </body>
</html>

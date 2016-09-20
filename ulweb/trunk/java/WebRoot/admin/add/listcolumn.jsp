
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlDept" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <base href="<%=basePath%>">
    
	<%
		if(request.getAttribute("from") == null) response.sendRedirect(basePath + "admin/column.do?method=list");
	%>
    <title>栏目列表</title>
    
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
   
   <script language="JavaScript" src="script/ajax.js"></script>
     <script language="JavaScript" src="script/dtree.js" type="text/javascript" ></script> 
   <script language="JavaScript" src="script/column.js"></script>
  <body>
   <table align="center" border="1" cellpadding="0" cellspacing="0" width="750">
 	<form action="admin/column.do?method=delete" method="post" name="form1" id="idform1">
		<input type="hidden"  id="iddeptId" name="deptId"  value='<%=request.getAttribute("deptId")%>'/>		
		
 	<tr>
		<td>
			<table width="750" cellpadding="0" cellspacing="0">
				<tr>
					<td width="300"  valign="top" align="left">
						<table align="left" bgcolor="#CCCCCC"  cellpadding="0" cellspacing="0" width="300">
							<tr><td height="20"></td></tr>
							<%
								if(request.getAttribute("deptList") != null){
									List<UlDept> list = (List)request.getAttribute("deptList");
									for(int i = 0; i < (list == null ? 0 : list.size()); i++){
										out.print("<tr><td align='center'>");
										out.print("<a href='admin/column.do?method=list&deptId=");
										out.print(list.get(i).getDeptId());
										out.print("'>");
										out.print(list.get(i).getDeptName() + "</a>");
										out.print("</td></tr>");
			
									}
			
								}
							%>
							<tr><td height="20" style="border-top:gray 1px solid;">&nbsp;</td></tr>
							<tr>
								<td valign="top">									
										<%=request.getAttribute("columnList")%>									
								</td>
							</tr>
						</table>
					</td>
					<td valign="top">
						<table width="100%" align="center" border="0">
							<tr>
								<td  align="center" id="idcolumn">
										请从左侧选择栏目进行修改或添加
								</td>
							</tr>
							<tr>
								
						  <td align="center" valign="bottom" height="25">
						  </td>
							</tr>
						</table>
					</td>
				</tr>
				<tr><td colspan="2" align="center" style="border-top:gray 1px solid;">
					</td></tr>
			</table>
		</td>
	</tr>
	
	</form>
 </table>
  </body>
</html>

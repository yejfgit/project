<%@ page contentType="text/html; charset=UTF-8" language="java"  errorPage="" %>
<%@page import="java.util.*" %>
<%@page import="com.ulic.ulweb.ulweb.entity.UlDept" %>
<%@page import="com.ulic.ulweb.ulweb.entity.UlContent" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <%
		if(request.getAttribute("from") == null) response.sendRedirect(basePath + "admin/content.do?method=list");
	%>
    <title>内容列表</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
     <LINK href="style/ul.css" type="text/css" rel=stylesheet>
	   <LINK href="style/dtree.css" type="text/css" rel=stylesheet>
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
  </head>
   <script language="JavaScript" src="script/listContent.js"></script>
	 <script language="JavaScript" src="script/ajax.js"></script>
	  <script language="JavaScript" src="script/dtree.js" type="text/javascript" ></script> 	   
  <body>
 <table align="center" border="1" cellpadding="0" cellspacing="0" width="750">
 	<form action="admin/content.do?method=bEdit" method="post" name="form1" id="idform1">
		<input type="hidden"  id="iddeptId" name="deptId"  value='<%=request.getAttribute("deptId")%>'/>
		<input type="hidden" id="idcolumnName" name="columnName"></input>
		<input type="hidden" id="idcolumnId" name="columnId" ></input>
 	<tr>
		<td>
			<table width="750" cellpadding="0" cellspacing="0">
				<tr>
					<td width="300" align="center" valign="top">
						<table align="left" bgcolor="#CCCCCC"  cellpadding="0" cellspacing="0" width="300">
							<tr><td height="20"></td></tr>
							<%
								if(request.getAttribute("deptList") != null){
									List<UlDept> list = (List)request.getAttribute("deptList");
									for(int i = 0; i < (list == null ? 0 : list.size()); i++){
										out.print("<tr><td align='center'>");
										out.print("<a href='admin/content.do?method=list&deptId=");
										out.print(list.get(i).getDeptId());
										out.print("'>");
										out.print(list.get(i).getDeptName() + "</a>");
										out.print("</td></tr>");
			
									}
			
								}
							%>
							<tr><td height="20" style="border-top:gray 1px solid;">&nbsp;</td></tr>
							<tr>
								<td>									
										<%=request.getAttribute("columnList")%>									
								</td>
							</tr>
						</table>
					</td>
					<td width="450">
						<table width="100%" border="0">
							<tr><td  align="center" style="border-top:gray 1px solid;">
	 <a href="javascript:toAdd();" style="color:red; font-size:18px;" >添加</a>	
	</td></tr>
							
							<tr>
								<td  id="idcontentList">
										<%
											if(request.getAttribute("contentList") != null){
												out.print(request.getAttribute("contentList"));
											}else{
												out.print("您没有上传过文件");
											}
										
										%>
								</td>
							</tr>
							<tr>
								
						  <td align="center" valign="bottom" height="25"  id="idtest">
						  </td>
							</tr>
							<tr>
							
								<td valign="bottom">
									<table width="100%" border="0" align="center">
										<tr>
											<td width="73" align="right">
												查找标题:
											</td>
											<td colspan="3">
												<input value="" name="ccName" id="idccName" type="text" size="25" maxlength="25"></input>
											</td>
											<td width="131">
												<input type="button" onClick="javascript:findContant();" value="查找"></input>
											</td>
											<td width="50"></td>
											
										</tr>
										<tr>
											<td align="right">
												时间从:
											</td>
											<td width="72">
												<input value="" name="ts" type="text" id="idts" size="10" maxlength="10"></input>
											</td>
											<td width="20" align="right">
												至:</td>
											<td width="70">
												<input value="" type="text" name="te" id="idte" size="10" maxlength="10"></input>
											</td>
											<td colspan="2">
												
											</td>
											
										</tr>
									</table>
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


<%@ page language="java" import="java.util.*,java.net.URLEncoder" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <base href="<%=basePath%>">
    <title>修改栏目</title>
    
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
     <table border="0" cellspacing="0" cellpadding="0" width="450" align="center">		
		<tr>
			<td >
				<table border="1" width="100%" align="center" cellpadding="2"  cellspacing="0">
					<input type="hidden" name="columnId" id="idcolumnId" value='<%=request.getAttribute("columnId")%>' />
					
					<tr>						
       			   <td colspan="2" align="center"> 修改栏目</td>
					</tr>
					<tr>
						<td>
							上级栏目
						</td>
						<td id="idparentName">							
								<%=(request.getAttribute("parentName") == null ? "栏目为一级栏目，无上级栏目" : request.getAttribute("parentName"))%>
						</td>
					</tr>
					
					<tr>
						<td>
							上级栏目号修改为
						</td>
						<td>							
							<input type="text" name="parentColumn" id="idparentColumn" value='<%=request.getAttribute("parentId")%>' />
						</td>
					</tr>	
									
					<tr>
						<td>
							栏目名称
						</td>
						<td>
							<input name="columnName" id="idcolumnName" type="text" value='<%=request.getAttribute("columnName")%>'></input>
						</td>
					</tr>

					<tr>
						<td>
							英文名称
						</td>
						<td>
							<input name="eId" id="" type="text" value="<%=request.getAttribute("eId")%>" />
						</td>
					</tr>

					
					<tr>
						<td>
							这个栏目用于放
						</td>
						<td>
							<%=request.getAttribute("include")%>
						</td>						
					</tr>
					<tr>
						<td>
							是否在页面显示
						</td>
						<td>
							<input type="radio" value="1" name="showToUser" <%=request.getAttribute("show")%> >显示</input>
							<input type="radio" value="0" name="showToUser" <%=request.getAttribute("notShow")%> >不显示</input>
						</td>
					</tr>
<!--
					<tr>
						<td>
							设置查看级别
						</td>
						<td>
							所有人<input name="showOtherClass" type="text" onKeyUp="checkShowClass();" size="5" maxlength="5" value='<%=request.getAttribute("showOtherClass")%>'></input>
							本部门<input type="text" name="showOrganClass" size="5" maxlength="5" onKeyUp='checkNum("showOrganClass");' value='<%=request.getAttribute("showOrganClass")%>' ></input>
						</td>
					</tr>
-->
					<tr>
						<td>
							栏目显示顺序
						</td>
						<td>
							<input name="columnOrder" type="text" onKeyUp='checkNum("columnOrder");' value='<%=request.getAttribute("columnOrder")%>'></input>
						</td>
					</tr>
					<tr>
						<td>
							是否是开放栏目
						</td>
						<td>
							<%=request.getAttribute("openColumn")%>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr><td height="10"></td></tr>
		<tr>
			<td align="center">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
							<input type="button" value="确定更改" onClick="javascript:editColumn();" />
						</td>
						<td width="20"></td>
						<td>
						<input type="button" onClick="javascript:deleteColumn();" value="删除此栏目"/>
						</td>
						<td width="20"></td>
						<td>
						<%
							if(((String)request.getAttribute("include")).equals("栏目")){
						%>
							<input type="button" onClick="javascript:toAddColumn(<%=request.getAttribute("columnId")%>,'<%=URLEncoder.encode((String)request.getAttribute("columnName"),"gb2312")%>');" value="在此栏目下添加新栏目" />
						<%
							}
						%>
						</td>
					</tr>
				</table>				
			</td>
		</tr>		
	</table>
  </body>
</html>


<%@ page language="java" import="java.util.*,java.net.URLDecoder" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
        <base href="<%=basePath%>">
    <title>增加栏目</title>
    
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
		<input type="hidden" name="openColumn" value="0"/>
		<input type="hidden" name="showOthersClass" value="0" />
		<input type="hidden" name="showOrganClass" value="0" />
		<input type="hidden" name="parentColumn" id="idparentColumn" value="<%=(request.getParameter("cid") == null ? "0" : request.getParameter("cid"))%>" />
		<tr>
			<td >
			
				<table border="1" align="center" width="100%" cellspacing="0">
					<tr>
						<td colspan="2" align="center">
							&nbsp;	<span class="9red">添加栏目</span>
						</td>
					</tr>					
					<tr>
						<td>
							上级栏目
						</td>
						<td id="idparentName">							
								
								<%=new String(request.getParameter("cName").getBytes("ISO-8859-1"),"gb2312")%>
								
						</td>
					</tr>
					<tr>
						<td>
							栏目名称
						</td>
						<td>
							<input name="columnName" id="idcolumnName" type="text" value="" />
						</td>
					</tr>

					<tr>
						<td>
							英文名称
						</td>
						<td>
							<input name="eId" id="" type="text" value="" />
						</td>
					</tr>
					
					<tr>
						<td>
							这个栏目用于放
						</td>
						<td>
							<input type="radio" value="1" name="include">栏目</input>
							<input type="radio" value="2" name="include" checked >内容</input>
						</td>						
					</tr>
					
					<tr>
						<td>
							是否在页面显示
						</td>
						<td>
							<input type="radio" value="1" name="showToUser" >显示</input>
							<input type="radio" value="0" name="showToUser" checked>不显示</input>
						</td>
					</tr>
					
					<tr>
						<td>
							栏目排序
						</td>
						<td>
							<input type="text" name="columnOrder" value="9" size="5" maxlength="2" ></input>
						</td>
					</tr>
					<!--
					<tr>
						<td>
							是否是开放栏目
						</td>
						<td>
							<input type="radio" value="1" name="openColumn">是</input>
							<input type="radio" value="0" name="openColumn" checked>否</input>
						</td>
					</tr>
					-->
				</table>
			</td>
		</tr>
		<tr><td height="10"></td></tr>
		<tr>
			<td align="center">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
							<input type="button" value="添加此栏目" onClick="javascript:addColumn();" />
						</td>
						<td width="20"></td>
						<td>						
						</td>
					</tr>
				</table>				
			</td>
		</tr>		
	</table>	
  </body>
</html>

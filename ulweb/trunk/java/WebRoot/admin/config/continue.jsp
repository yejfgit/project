
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>老数据迁移</title>
    
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
  	  <script  type="text/javascript" src="script/movedata.js" ></script>
  <body>

  
  <table align="center">
  	<tr>
		
		</td>
		<td width="450">
			
		
   <table width="100%" align="center">
   		<form  method="post" name="form1"  id="idform1">
		<input type="hidden" value="0" name="firstMove">
		<input type="hidden" name="firstContentId" value="<%=request.getAttribute("firstContentId")%>"/>
			<input type="hidden" name="lastContentId" value="<%=request.getAttribute("lastContentId")%>"/>
		<input type="hidden" name="oldColumnId" value="<%=request.getAttribute("oldColumnId")%>"  />
		<input type="hidden" name="oldKeyword" value="<%=request.getAttribute("oldKeyword")%>" />
		<input type="hidden" name="moveNum" value="<%=request.getAttribute("moveNum")%>"/ >
		<input type="hidden" name="moveAll" value="<%=request.getAttribute("moveAll")%>"/> 
		<input type="hidden" name="newColumnId"  value="<%=request.getAttribute("newColumnId")%>" />
		<input type="hidden" name="dept" value="<%=request.getAttribute("dept")%>"/>
		<tr>
			<td colspan="2">
				移动成功：<%=request.getAttribute("rowNum")%>条
			</td>
		</tr>
		<tr>
			<td>
				开始于：
			</td>
			<td>
				<%=request.getAttribute("firstContentId")%>
			</td>
		</tr>
		<tr>
			<td>
				结束于：
			</td>
			<td>
			<%=request.getAttribute("lastContentId")%>
			</td>
		</tr>
		<tr>
			<td>
			
			</td>
			<td>
			
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				老数据库
			</td>
		</tr>
   		<tr>
			<td>
				栏目编号
			</td>
			<td> 
              <%=request.getAttribute("oldColumnId")%>
            </td>
		</tr>
		<tr>
			<td>
				关键字
			</td>
			<td>
				<%=request.getAttribute("oldKeyword")%> 
			</td>
		</tr>
		
		<tr>
			<td>
				移动个数
			</td>
			<td>
				<%=request.getAttribute("moveNum")%>
			</td>
		</tr>
		<tr>
			<td>
				移动所有
			</td>
			<td>
				<%=request.getAttribute("moveAll")%>
			</td>
		</tr>
		<tr>
			<td colspan="2"> 
				<hr>
				
				<hr>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">新数据</td>
		</tr>
		<tr>
			<td>
				新栏目编号
			</td>
			<td>
				<%=request.getAttribute("newColumnId")%>
			</td>
		</tr>
		
		<tr>
			<td align="center" >
				<input  type="button" onClick="javascript:startMove()" value="继续移动"/>
			</td>
			<td>
				<input type="button" onClick="javascript:cancleThisTime();"  value="删除本次移动的数据"/>
				
				<input type="button" onClick="javascript:cancleAll();"  value="删除所有移动的数据"/>
			</td>
		</tr>
		</form>
		<tr>
			<td colspan="2">
		<!--
		
		<%=request.getAttribute("strContentId")%>
		
		-->
			</td>
		</tr>
   </table>
   </td>
	</tr>
  </table>
  </body>
</html>

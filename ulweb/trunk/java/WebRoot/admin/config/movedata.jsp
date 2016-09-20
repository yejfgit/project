
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlColumn" pageEncoding="UTF-8"%>
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
   
	<style>
	p{
		margin:0cm;
	}
	</style>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>
  	
  <body>
  
  <%
  		List<UlColumn> list = (List<UlColumn>)request.getAttribute("columnList");
  %>
 <script  type="text/javascript" src="script/movedata.js" ></script>
  <table >
  	<tr>
		<td width="300" valign="top" align="left">
		<%
			for(int i = 0; i < (list == null ? 0 : list.size()); i++){
				if(list.get(i).getIncludeContent() == 1){
					 out.print("<p >====");
				out.println(list.get(i).getColumnName() + "--" + list.get(i).getColumnId() + "</p>");
				}else{
					 out.print("<p style='color:red;'>");
					out.println(list.get(i).getColumnName() + "--" + list.get(i).getColumnId() + "</p>");
				}
				
			}
		%>
		
		
		</td>
		<td width="450" valign="top">
			
		
   <table width="100%" align="center">
   		<form action="admin/config.do?method=moveData" method="post" id="idform1" name="form1" >
		<input type="hidden" value="1" name="firstMove">
		<input type="hidden" value="" name="startTime">
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
				<input type="text" name="oldColumnId" ></input>
			</td>
		</tr>
		<tr>
			<td>
				关键字
			</td>
			<td>
				<input type="text" name="oldKeyword" value="no" ></input>
			</td>
		</tr>
		
		<tr>
			<td>
				移动个数
			</td>
			<td>
				<input type="text" name="moveNum" value="50" ></input>
			</td>
		</tr>
		<tr>
			<td>
				移动所有
			</td>
			<td>
				<input type="text" name="moveAll" value="1" ></input>
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
				<input type="text" name="newColumnId" ></input>
			</td>
		</tr>
		<tr>
			<td>
				部门编号
			</td>
			<td>
				<input type="text" name="dept" value="peixun" ></input>String型:0000
			</td>
		</tr>
		<tr>
			<td align="center" colspan="2">
				<input type="button" onClick="javascript:startMove();" value="确定"/>
			</td>
		</tr>
		
		</form>
   </table>
   </td>
	</tr>
  </table>
  </body>
</html>

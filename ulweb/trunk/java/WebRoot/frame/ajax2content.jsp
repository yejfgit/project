
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>ajaxContent</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
      <LINK href="style/dtree.css" type="text/css" rel=stylesheet>
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>
  
  <body>
  <table width="100%" border="0" cellpadding="0" cellspacing="0">
  	<input type="hidden" name="condition" id="idcondition" value="<%=request.getAttribute("condition")%>" />
  <tr>
  	<td>
		 <%=request.getAttribute("contentList")%>
	</td>
  </tr>  
   <tr>
   		<td>
			<%
					int pageSum = 1;
					int pageNow = 1;					
					if(request.getAttribute("totlePage") != null){

						pageSum = (Integer)request.getAttribute("totlePage");
					}
					if(request.getAttribute("page") != null){
						pageNow = (Integer)request.getAttribute("page");
					}
					
					if(pageSum > 1){
						out.print("共" + pageSum + "页 &nbsp;&nbsp;");
						if(pageNow != 1){
							out.print("<a href='javascript:gotoP(" + (pageNow - 1) + ");'>上一页</a>&nbsp;&nbsp;");
						}						
						out.print("<a href='javascript:gotoPage();' >转到</a>&nbsp;第");
						out.print("<input id='idpage' name='page' size='3' maxlength='3' type='text'></input>页");
						if(pageNow != pageSum){
							out.print("<a href='javascript:gotoP(" + (pageNow + 1) + ");'>下一页</a>&nbsp;&nbsp;");
						}
					}
				%>
		</td>
   </tr>
   </table>
  </body>
</html>

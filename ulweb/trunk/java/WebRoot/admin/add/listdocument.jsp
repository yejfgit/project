
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlContent" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>公文列表</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
     <LINK href="style/ul.css" type="text/css" rel=stylesheet>
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <style>
  	#hebao<%=request.getAttribute("columnId")%>{
		color:red;
	}
  </style>
  </head>
 <script language="JavaScript" src="script/show.js"></script>
  <body>
    <table border="1" width="550" align="center" cellspacing="0">
		<form action='admin/document.do?method=getDocumentList' method='post' name='form1' id='idform1'> 
		<input type="hidden" value="<%=request.getAttribute("columnId")%>" name="columnId"/>
		<tr><td colspan="2" align="center">
			<a href="admin/document.do?method=getDocumentList&columnId=3" id="hebao3">合保人</a>
			<a href="admin/document.do?method=getDocumentList&columnId=4" id="hebao4">合保会纪</a>
			<a href="admin/document.do?method=getDocumentList&columnId=5" id="hebao5">合保办</a>
			<a href="admin/document.do?method=getDocumentList&columnId=6" id="hebao6">合保发</a>
			<a href="admin/document.do?method=getDocumentList&columnId=7" id="hebao7">合保复</a>
			<a href="admin/document.do?method=getDocumentList&columnId=567" id="hebao567">合保工会发</a>
			<a href="admin/document.do?method=getDocumentList&columnId=1287" id="hebao1287">合保党发</a>
			
		</td></tr>
		<%
					int pageSum = 1;
					int pageNow = 1;					
			List<UlContent> list = (List<UlContent>)request.getAttribute("list");
			if(list != null){
				for(int i=0 ; i < list.size(); i++){
					out.println("<tr><td ><a href='showDocument.do?c=" + list.get(i).getContentId() + "' target='_blank'>" );
					out.print(list.get(i).getContentName() + "</a>&nbsp;" + list.get(i).getUploadTime().toString().substring(0,list.get(i).getUploadTime().toString().indexOf(" ")) + "</td>");
					out.print("<td width='15%'><a href='admin/document.do?method=bEdit&cId=" + list.get(i).getContentId() + "'>修改</a>&nbsp;");
					out.println("<a href='admin/document.do?method=delete&contentId=" + list.get(i).getContentId() + "'>删除</a></td></tr>");					
				}
			}
			
			out.println("<tr><td colspan='2'>");
					
					if(request.getAttribute("pageSum") != null){
						pageSum = (Integer)request.getAttribute("pageSum");
					}
					if(request.getAttribute("pageNow") != null){
						pageNow = (Integer)request.getAttribute("pageNow");
					}
					if(pageSum > 1){
						out.print("共" + pageSum + "页 &nbsp;&nbsp;现在是第" + pageNow + "页&nbsp;&nbsp;");
						if(pageNow != 1){
							out.print("<a href='javascript:gotoP(" + (pageNow - 1) + ");'>上一页</a>&nbsp;&nbsp;");
						}
						out.print("<a href='javascript:gotoPage();' >转到</a>&nbsp;第");
						out.print("<input id='idpage' name='page' size='3' maxlength='3' type='text'></input>页");						
						if(pageNow != pageSum){
							out.print("<a href='javascript:gotoP(" + (pageNow + 1) + ");'>下一页</a>&nbsp;&nbsp;");
						}
					}
					out.print("</td></tr>");
		%>
		
		<tr>
			<td align="center" colspan="2"> 
				<a href="javascript:add();" >添加</a>
			</td>
		</tr>
		</form>
	</table>
  </body>
</html>

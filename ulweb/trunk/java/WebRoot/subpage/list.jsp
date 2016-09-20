
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.ulweb.entity.UlAttachment" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
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
  <script language="JavaScript" src="script/show.js"></script>
  <body>
  <table align="center" width="760" cellspacing="0">
  	
  	 <%
		List<UlContent> list = (List<UlContent>)request.getAttribute("list");
			if(list != null){
				for(int i = 0; i < list.size(); i++){					
					out.println("<tr><td height='20'  ></td>");
					out.println("<td colspan='3' valign='middle'  ><img src='images/index/a6.gif' width='8' height='8'> ");
					if(list.get(i).getHaveContent() == 0 && list.get(i).getAttachmentSum() != 0){
						out.print("<a target='_blank' href='show.do?c=" + list.get(i).getContentId() + "&a=1'>");
						out.println(list.get(i).getContentName() + "&nbsp;/" + list.get(i).getUploadTime().toString().substring(0,list.get(i).getUploadTime().toString().indexOf(" ")) + "</a>");					
						out.println("</td><td></td></tr>");			
						if(list.get(i).getAttachmentSum() > 1){
							out.print("<tr><td></td><td>");
							for(int j = 2; j <= list.get(i).getAttachmentSum() ; j++){
								out.print("<a target='_blank' href='show.do?c=" + list.get(i).getContentId() + "&a=" + j + "'>");
								out.print("附件" + (j - 1) + "</a> &nbsp;&nbsp;");
							}
							out.print("</td><td></td></tr>");
						}
					}else{
						out.print("<a target='_blank' href='show.do?c=" + list.get(i).getContentId() + "'>");
						out.println(list.get(i).getContentName() + "&nbsp;/" + list.get(i).getUploadTime().toString().substring(0,list.get(i).getUploadTime().toString().indexOf(" ")) + "</a>");					
						out.println("</td><td></td></tr>");			
						if(list.get(i).getAttachmentSum() > 0){
							out.print("<tr><td></td><td>");
							for(int j = 1; j <= list.get(i).getAttachmentSum() ; j++){
								out.print("<a target='_blank' href='show.do?c=" + list.get(i).getContentId() + "&a=" + j + "'>");
								out.print("附件" + j + "</a> &nbsp;&nbsp;");
							}
							out.print("</td><td></td></tr>");
						}
					}
							
				}
			}
			
		%>
		<tr>
			<td colspan="5">
				<%
					int pageSum = 1;
					int pageNow = 1;
					int columnId = (Integer)request.getAttribute("columnId");
					if(request.getAttribute("pageSum") != null){
						pageSum = (Integer)request.getAttribute("pageSum");
					}
					if(request.getAttribute("pageNow") != null){
						pageNow = (Integer)request.getAttribute("pageNow");
					}
					if(pageSum > 1){
						if(pageNow != 1){
							out.print("<a href='list.do?c=" + columnId + "&page=" + (pageNow - 1) + "'>上一页</a>&nbsp;&nbsp;");
						}
						out.print("<form action='list.do?c=" + columnId + "' method='post' name='form1' id='idform1'> ");
						out.print("<a href='gotoPage();' >转到</a>&nbsp;第");
						out.print("<input id='idpage' name='page' size='3' maxlength='3' type='text'></input>页");
						out.print("</form>");
						if(pageNow != pageSum){
							out.print("<a href='list.do?c=" + columnId + "&page=" + (pageNow + 1) + "'>下一页</a>&nbsp;&nbsp;");
						}
					}
				%>
			</td>
		</tr>
		
  </table>
  
  </body>
</html>

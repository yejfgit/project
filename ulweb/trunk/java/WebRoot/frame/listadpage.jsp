
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlContent" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>合众人寿</title>
    
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
  
  
<script language="javascript">

function resizewindow(w,h){

window.resizeTo(w,h);

}

</script>
<body onload=resizewindow(550,500)>
	<table width="750" border="0" align="center">
		<tr>
			<td>
				<table width="100%">
					<tr>
						<td>
							所有列表:
						</td>
					</tr>
					 <%
			List<UlContent> listx = (List<UlContent>)request.getAttribute("list");
			if(listx != null){
				for(int i = 0; i < (listx == null ? 0 : listx.size()); i++){					
					out.println("<tr><td height='20'  ></td>");
					out.println("<td colspan='3' valign='middle'  ><img src='images/index/a6.gif' width='8' height='8'> ");
					if(listx.get(i).getHaveContent() == 0 && listx.get(i).getAttachmentSum() != 0){
						out.print("<a target='_blank' href='showAd.do?method=show&c=" + listx.get(i).getContentId() + "&a=1'>");
						out.println(listx.get(i).getContentName() + "&nbsp;/" + listx.get(i).getUploadTime().toString().substring(0,listx.get(i).getUploadTime().toString().indexOf(" ")) + "</a>");					
						out.println("</td><td></td></tr>");			
						if(listx.get(i).getAttachmentSum() > 1){
							out.print("<tr><td></td><td>");
							for(int j = 2; j <= listx.get(i).getAttachmentSum() ; j++){
								out.print("<a target='_blank' href='showAd.do?method=show&c=" + listx.get(i).getContentId() + "&a=" + j + "'>");
								out.print("附件" + (j - 1) + "</a> &nbsp;&nbsp;");
							}
							out.print("</td><td></td></tr>");
						}
					}else{
						out.print("<a target='_blank' href='showAd.do?method=show&c=" + listx.get(i).getContentId() + "'>");
						out.println(listx.get(i).getContentName() + "&nbsp;/" + listx.get(i).getUploadTime().toString().substring(0,listx.get(i).getUploadTime().toString().indexOf(" ")) + "</a>");					
						out.println("</td><td></td></tr>");			
						if(listx.get(i).getAttachmentSum() > 0){
							out.print("<tr><td></td><td>");
							for(int j = 1; j <= listx.get(i).getAttachmentSum() ; j++){
								out.print("<a target='_blank' href='showAd.do?method=show&c=" + listx.get(i).getContentId() + "&a=" + j + "'>");
								out.print("附件" + j + "</a> &nbsp;&nbsp;");
							}
							out.print("</td><td></td></tr>");
						}
					}
							
				}
			}
			
		%>
				</table>
			</td>
		</tr>
		<tr>
		<form action="oldFile.do?method=list" method="post" name="forms" id="idforms">
		
			<td colspan="5">
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
						out.print("现在是第" + pageNow + "页&nbsp;&nbsp;&nbsp;");
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
			</form>
			</tr>
	</table>
  </body>
</html>

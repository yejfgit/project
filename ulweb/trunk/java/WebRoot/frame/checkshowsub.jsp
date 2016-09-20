
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlContent" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查询分页</title>
    
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
  <script language="JavaScript" src="script/check.js"></script>
  <body>
		<table width="100%" cellpadding="0" align="center" cellspacing="0">
              <tr> 
                <td width="30"></td>
                <td width="180"></td>
                <td width="400"></td>
                <td></td>
                <td></td>
              </tr>
              <tr>
                <td background="images/index/titleb1.gif"  height="22"></td>
                <td background="images/index/titleb2.gif"style="background-repeat: repeat;" > &nbsp;
                查找结果
                </td>
                <td background="images/index/titleb3.gif" style="background-repeat: no-repeat;" ></td>
                <td width="150"></td>
              </tr>
              <tr> 
                <td colspan="5"> <table width="100%">
                    
  	 <%
	 
		List<UlContent> list = (List<UlContent>)request.getAttribute("list");
			if(list != null){
				for(int i = 0; i < list.size(); i++){					
					out.println("<tr><td height='20'  ></td>");
					out.println("<td colspan='3' valign='middle'  ><img src='images/index/a6.gif' width='8' height='8'> ");
					int cid = list.get(i).getColumnId();
					
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
						
						
					} else if (cid == 3 || cid == 4 || cid == 5 || cid == 6 || cid == 7 || cid == 567 || cid == 1287) {
						out.print("<a target='_blank' href='showDocument.do?c=" + list.get(i).getContentId() + "'>");
						out.println(list.get(i).getContentName() + "&nbsp;&nbsp;&nbsp;&nbsp;/" + list.get(i).getUploadTime().toString().substring(0,list.get(i).getUploadTime().toString().indexOf(" ")) + "</a>");					
						out.println("</td><td></td></tr>");			
						if(list.get(i).getAttachmentSum() > 0){
							out.print("<tr><td></td><td>");
							for(int j = 1; j <= list.get(i).getAttachmentSum() ; j++){
								out.print("<a target='_blank' href='show.do?c=" + list.get(i).getContentId() + "&a=" + j + "'>");
								out.print("附件" + j + "</a> &nbsp;&nbsp;");
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
		<form action="check.do?method=zongbu" method="post" name="forms" id="idforms">
		<input type="hidden" name="condition" id="idcondition" value="<%=request.getAttribute("condition")%>" />
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
		
                  </table></td>
              </tr>
			  <tr><td colspan="5" height="20"></td></tr>
              <tr> 
                <td valign="bottom" colspan="5">
					<table width="100%">
						<tr>
							<td>
								
							</td>
						</tr>
					
					</table>
				</td>
              </tr>
            </table>
  </body>
</html>

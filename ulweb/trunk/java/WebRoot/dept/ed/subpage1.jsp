
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlTemplate,com.ulic.ulweb.ulweb.entity.UlColumn,com.ulic.ulweb.ulweb.entity.UlContent" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  
<head>
<base href="<%=basePath%>">
<title>人才成长中心</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<LINK href="style/ul.css" type="text/css" rel=stylesheet>
<%
		UlTemplate t = (UlTemplate)request.getAttribute("template");
		List<UlColumn> l = (List<UlColumn>)request.getAttribute("columnList");		
		
		List<UlContent> list = (List<UlContent>)request.getAttribute("contentList");	
		
		String titleColor[] = {"#000000","#ffffff","#000000","#0066ff","#009900","#00dddd","#ffccff","#9900cc","#ffcc00","#ff0000"};
		
	%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<LINK href="dept/ed/ed.css" type="text/css" rel=stylesheet>

<style >

.aleft{		
	
}
.aright{
	width:100px;
	font-size:11px;
	float:right;
}
</style>
</head>
  	<script type="text/javascript" src="script/ed.js"></script>

<body   <%=(t.getPic1() == null ? "" : ("background='" + t.getPic1() + "'") )%>  style="margin-top:-20;">

  <div style="width:100%;text-align:center;" >
	<div  class="divCenter">
		<div style="width:100%;height:150px;<%=(t.getPic2() == null ? "" : ("background-image:url('" + t.getPic2() + "');"))%>" >
			<div style="padding:10px 0px 0px 20px;text-align:left;height:50px;">
				<%=t.getImg3()%>
			</div>
			<div style="width:100%;height:70px;text-align:center;font-size:36px;font-family:'黑体';font-style:italic;font-weight:bold;color:#ffffff;">
				人 才 成 长 中 心
			</div>
			<div style="padding:0px 20px 0px 0px;width:100%;text-align:right;font-size:18px;font-family:'黑体';font-style:italic;font-weight:bold;color:#ffffff;">
				Elite Development Center
			</div>			
		</div>
		<div class="divContent" style="height:450px;width:80%;text-align:left;">
			
			<%		
			if(list != null){
				out.print("<table border='0' width='100%'>");
				for(int i = 0; i < list.size(); i++){					
					out.println("<tr><td>");					
					if(list.get(i).getHaveContent() == 0 && list.get(i).getAttachmentSum() != 0){
						out.print("<a target='_blank' href='show.do?c=" + list.get(i).getContentId() + "&a=1' style='color:" + titleColor[list.get(i).getDisplayType()] + "'>");
						out.println(list.get(i).getContentName() + "&nbsp;/"+ "</a>" );					
							
						if(list.get(i).getAttachmentSum() > 1){
							out.print(" &nbsp; &nbsp; ");
							for(int j = 2; j <= list.get(i).getAttachmentSum() ; j++){
								out.print("<a target='_blank' href='show.do?c=" + list.get(i).getContentId() + "&a=" + j + "'>");
								out.print("附件" + (j - 1) + "</a> &nbsp;&nbsp;");
							}							
						}
						out.println("</td><td width='100'>" + list.get(i).getDay() + "</td></tr>" );	
						
					}else{
						out.print("<a target='_blank' href='show.do?c=" + list.get(i).getContentId() + "' style='color:" + titleColor[list.get(i).getDisplayType()] + "'>");
						out.println(list.get(i).getContentName() + "&nbsp;/" + "</a>");					
								
						if(list.get(i).getAttachmentSum() > 0){
							out.print(" &nbsp; &nbsp; ");
							for(int j = 1; j <= list.get(i).getAttachmentSum() ; j++){
								out.print("<a target='_blank' href='show.do?c=" + list.get(i).getContentId() + "&a=" + j + "'>");
								out.print("附件" + j + "</a> &nbsp;&nbsp;");
							}							
						}
							out.println("</td><td width='100'>" + list.get(i).getDay() + "</td></tr>" );	
					}
				//	out.print("<br />");	
			//		out.print("</p>");	
				}
				out.print("</table>");
			}
			
			%>
		</div>
		<div>
		<form  method="post" name="forms" id="idforms">
			<input type="hidden" value="<%=request.getParameter("background")%>" name="background" />
			<input type="hidden" name="columnId" id="idcolumnId" value="<%=request.getAttribute("columnId")%>" />		
		
				<%
					int totlePage = 1;
					int pageNow = 1;					
					if(request.getAttribute("totlePage") != null){

						totlePage = (Integer)request.getAttribute("totlePage");
					}
					if(request.getAttribute("page") != null){
						pageNow = (Integer)request.getAttribute("page");
					}
					if(totlePage > 1){
						out.print("现在是第" + pageNow + "页&nbsp;&nbsp;&nbsp;");
						out.print("共" + totlePage + "页 &nbsp;&nbsp;");
						if(pageNow != 1){
							out.print("<a href='javascript:goto1P(" + (pageNow - 1) + ");'>上一页</a>&nbsp;&nbsp;");
						}						
						out.print("<a href='javascript:goto1Page();' >转到</a>&nbsp;第");
						out.print("<input id='idpage' name='page' size='3' maxlength='3' type='text'></input>页");
						if(pageNow != totlePage){
							out.print("<a href='javascript:goto1P(" + (pageNow + 1) + ");'>下一页</a>&nbsp;&nbsp;");
						}
					}
				%>		
			</form>
		</div>
		<div class="divleft">
		
		</div>
	</div>
	
<div>
  <iframe src="dept/ed/indexbottom.jsp" height="100" width="100%" frameborder="0" scrolling="no" ></iframe>
</div>	
  </div>
</body>
</html>


<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.ulweb.entity.UlAttachment" pageEncoding="UTF-8"%>
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
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
   <style>
  	P{
		margin:0cm;
	}
  </style>
  </head>
  
  <%
  		UlContent c = (UlContent)request.getAttribute("c");
		List<UlAttachment> a = (List<UlAttachment>)request.getAttribute("a");
		
  
  %>
<script language="javascript">

function resizewindow(w,h){

window.resizeTo(w,h);

}

</script>
<body onload=resizewindow(550,500)>
	<table width="100%" border="0" align="center">
		<tr>
			<td>
				<table width="100%">
					<tr><td width="10%"></td>
						<td>
							<%=(c == null ? "" : c.getContent())%>
						</td>
						<td width="10%"></td>
					</tr>
				</table>
		
				
			</td>
		</tr>
		<tr>
			<td>
				<table align="center" width="100%">
					<tr><td width="20%"></td>
						<td align="center">
							<%
								if(a != null){			
			for(int i = 0; i < a.size(); i++){
				out.print("<a href='" + a.get(i).getAttachmentPath() + "' target='_blank' >附件" + (i + 1 ) + "</a>&nbsp;&nbsp;&nbsp;");
			}					
		}
							%>
						</td>
						<td width="20%"></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td align="center">
				<a href="/" onclick="javascript:window.close(); return false;"><font color="#808080">关闭本窗口</font></a>
			</td>
		</tr>
	</table>
  </body>
</html>

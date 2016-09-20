
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.ulweb.entity.UlAttachment,com.ulic.ulweb.frame.constant.Constant" pageEncoding="UTF-8"%>
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
//		List<UlAttachment> a = (List<UlAttachment>)request.getAttribute("a");
		
  
  %>
 
 <script language="javascript">

function resizewindow(w,h){

window.resizeTo(w,h);

}

</script>
<body onload=resizewindow(850,650)>

<table width="760" border="0" cellpadding="0" cellspacing="0" align="center">
  <!--DWLayoutTable-->
  <tr> 
    <td width="1" height="5"></td>
    <td width="33"></td>
    <td width="21"></td>
    <td width="167"></td>
    <td width="86"></td>
    <td width="36"></td>
    <td width="36"></td>
    <td width="38"></td>
    <td width="8"></td>
    <td width="12"></td>
  </tr>
  <tr> 
    
    <td colspan="10" valign="top" align="center"><img src="images/hr/contenttitle.jpg"></td>
   
  </tr>
  <tr> 
    <td height="10"></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr align="left" valign="middle"> 
  
    <td height="32" colspan="10" ><%=c.getContentName()%></td>
  </tr>
  <tr>
  	<td colspan="10" align="right">
		<%=(c.getSubTitle() == null ? "" : c.getSubTitle())%>
	</td>
	
  </tr>
  <tr> 
    <td height="21" colspan="10" valign="top">发布时间：<%=c.getUploadTime().toString().substring(0,c.getUploadTime().toString().indexOf(" ")) %></td>
   
  </tr>
    <tr> 
   
    <td colspan="10" valign="top"><% 
		out.print("发布部门:" + (c.getUploadDeptStr() == null ? "" : c.getUploadDeptStr()));
		
	%></td>
   
  </tr>
   <tr> 
  
    <td colspan="10"  align="right">
  <%
  		if(c.getAttachmentSum() > 0){		
			for(int i = 0; i < c.getAttachmentSum(); i++){
				out.print("<a href='show.do?c=" + c.getContentId() + "&a=" + (i + 1) + "'>附件" + (i + 1 ) + "</a>&nbsp;&nbsp;&nbsp;");
			}		
			
		}
  
  %></td>
   
  </tr>
  <tr> 
  
    <td colspan="10" height="30" valign="top"><hr> &nbsp;</td>
  
  </tr>
  <tr> 
    <td height=18 colspan="10" valign="top">
	<%
		out.print((c.getContent() == null ? "请点击查看附件" : c.getContent()));
	%>
	<br></td>
  
  </tr>
  
  <tr> 
    <td height=28  colspan="10"></td>
   
  </tr>
  <tr align="center"> 
  	
    <td height="14" colspan="10"  align="left" style="color:#808080">版权(c) 2005, 
      合众人寿保险股份有限公司 版权所有</td>
  </tr>
 
  <tr>
    <td height="24"></td>
    <td colspan="5"></td>
   
    <td colspan="5" valign="top"><a href="#" onClick="javascript:window.close(); return false;" style="color:#808080;">关闭本窗口</a></td>
   
  </tr>
  <tr>
    <td height="8"></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
</table>

</body>
</html>

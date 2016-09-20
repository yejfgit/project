
<%@ page language="java" import="java.util.*, com.ulic.ulweb.ulweb.entity.UlContent" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>合众人寿公文</title>
    
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
  %>
 <script language="javascript">

function resizewindow(){

window.resizeTo(screen.width,screen.height);

}

</script>
<body onload=resizewindow()>

 
    <table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
  
	<tr>
		<td>
			
			<table width="100%" align="center" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td height="50"></td>
        </tr>
        <tr> 
          <td width="100%"> <table width="100%">
              <tr> 
                <td align="center" style="color:#ff0000;font-size:40px"> 合众人寿保险股份有限公司文件 
                </td>
              </tr>
            </table></td>
        </tr>
        <tr>
          <td height="80"></td>
        </tr>
        <tr> 
          <td> <table width="100%" border="0" align="center">
              <tr> 
                <td align="center" style="font-size:18px;"> 
                  <%=c.getDocumentNum()%>
                </td>
              </tr>
            </table></td>
        </tr>
        <tr> 
          <td width="100%"> <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr> 
                <td width="10%"></td>
                <td height="2" ><hr color="#FF0000" size="1"  noshade></td>
                <td width="10%"></td>
              </tr>
            </table></td>
        </tr>
        <tr> 
          <td> <table border="0" cellspacing="0" align="center" width="100%">
              <tr>
                <td height="50"></td>
              </tr>
              <tr>
                <td align="center" style="font-size:24px"> 
                  <%=c.getContentName()%>
                </td>
              </tr>
              <tr>
                <td height="30"></td>
              </tr>
              <tr> 
                <td > <table width="100%" border="0">
                    <tr> 
                      <td width="1%"></td>
                      <td width="98%"></td>
                      <td width="1%"></td>
                    </tr>
                    <tr> 
                      <td></td>
                      <td  style="font-size:10.5pt;"> 
                        <%=c.getContent()%>
                      </td>
                      <td></td>
                    </tr>
                  </table></td>
              </tr>
            </table></td>
        </tr>
        <tr>
          <td height="20"> </td>
        </tr>
       
        <tr>
          <td height="30"></td>
        </tr>
      </table>
			
		</td>
	</tr>
  <tr>
			<td align="left">
			
			<table width="100%" border="0"> 
			<tr><td colspan="3"  height="5"></td></tr>
				<tr>
					<td width="5%"></td>
					<td width="90%" align="left" style="color:#3366cc;font-size:16px;"><%=(request.getAttribute("a") == null ? "" : request.getAttribute("a"))%></td>
					<td width="5%"></td>
				</tr>
			</table>
				
			</td>
		</tr>
  
</table>

</body>
</html>

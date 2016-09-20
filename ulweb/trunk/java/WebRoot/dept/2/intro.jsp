
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'intro.jsp' starting page</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
     <LINK href="../../style/ul.css" type="text/css" rel=stylesheet>
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>
  
  <body class="bodymargin">
    <table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td>
				<table border="0" cellpadding="0" cellspacing="0" height="240">
					<tr>
          <td height="20"><font color="#4cac27">&nbsp;部门简介</font></td>
        </tr>
					<tr>
						<td background="../../images/1/tiaowen.gif" style="background-repeat:repeat-x;" width="420" height="20">
							
						</td>
					</tr>
					<tr>
						<td>
							<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td width="420" height="200" valign="top">
									<br>
										字，字，字，这里全是字：
										<p>
											字，字，字，字，字，字，字，字，字，字，
											
											
										</p>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
  </body>
</html>


<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlTemplate" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>更改首页图片</title>
    
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
  	<%
		UlTemplate t = (UlTemplate)request.getAttribute("template");
	%>
	<script language="JavaScript" src="script/template.js"></script> 
  <body>
  	
    <table align="center" width="750" cellpadding="0" cellspacing="0" border="0">
		<tr>
			<td>
				<table width="100%" align="center">
					<form action="admin/template.do?method=changePic" name="form1" id="idform1" method="post">
						<input type="hidden" name="templateId" id="idtemplateId" value="<%=request.getParameter("templateId")%>"/>
						<input type="hidden" name="pic1" id="idpic1" value="<%=t.getPic1()%>" />
						<input type="hidden" name="pic2" id="idpic2" value="<%=t.getPic2()%>" />
						<input type="hidden" name="pic3" id="idpic3" value="<%=t.getPic3()%>" />
						<input type="hidden" name="pic4" id="idpic4" value="<%=t.getPic4()%>" />
						<input type="hidden" name="pic5" id="idpic5" value="<%=t.getPic5()%>" />
						<input type="hidden" name="pic6" id="idpic6" value="<%=t.getPic6()%>" />
						<input type="hidden" name="docName2" id="iddocName2" value="<%=t.getDocName2()%>" />
						<input type="hidden" name="docPath2" id="iddocPath2" value="<%=t.getDocPath2()%>" />
						<input type="hidden" name="docName3" id="iddocName3" value="<%=t.getDocName3()%>" />
						<input type="hidden" name="docPath3" id="iddocPath3" value="<%=t.getDocPath3()%>" />
						<input type="hidden" name="docName4" id="iddocName4" value="<%=t.getDocName4()%>" />
						<input type="hidden" name="docPath4" id="iddocPath4" value="<%=t.getDocPath4()%>" />
						<input type="hidden" name="docName5" id="iddocName5" value="<%=t.getDocName5()%>" />
						<input type="hidden" name="docPath5" id="iddocPath5" value="<%=t.getDocPath5()%>" />
						<input type="hidden" name="docName6" id="iddocName6" value="<%=t.getDocName6()%>" />
						<input type="hidden" name="docPath6" id="iddocPath6" value="<%=t.getDocPath6()%>" />
						<input type="hidden" name="docName7" id="iddocName7" value="<%=t.getDocName7()%>" />
						<input type="hidden" name="docPath7" id="iddocPath7" value="<%=t.getDocPath7()%>" />
						<input type="hidden" name="docName8" id="iddocName8" value="<%=t.getDocName8()%>" />
						<input type="hidden" name="docPath8" id="iddocPath8" value="<%=t.getDocPath8()%>" />
						<input type="hidden" name="docName9" id="iddocName9" value="<%=t.getDocName9()%>" />
						<input type="hidden" name="docPath9" id="iddocPath9" value="<%=t.getDocPath9()%>" />
						<input type="hidden" name="css" id="idcss" value="<%=t.getCss()%>"/>
						
					<tr>
						<td>
							<a href="admin/template/uploadpic.jsp?name=pic1" target="_blank">
							<img src="<%=t.getPic1()%>" id="picpic1" border="0" />
							</a>
						</td>
					</tr>
					<tr>
						<td>
							<a href="admin/template/uploadpic.jsp?name=pic2" target="_blank">
							<img src="<%=t.getPic2()%>" id="picpic2" border="0" />
							</a>
						</td>
					</tr>
					<tr>
						<td>
							<a href="admin/template/uploadpic.jsp?name=pic3" target="_blank">
							<img src="<%=t.getPic3()%>" id="picpic3" border="0" />
							</a>
						</td>
					</tr>
					<tr>
						<td>
							<a href="admin/template/uploadpic.jsp?name=pic4" target="_blank">
							<img src="<%=t.getPic4()%>" id="picpic4" border="0" />
							</a>
						</td>
					</tr>
					<tr>
						<td>
							<a href="admin/template/uploadpic.jsp?name=pic5" target="_blank">
							<img src="<%=t.getPic5()%>" id="picpic5" border="0" />
							</a>
						</td>
					</tr><tr>
						<td>
							<a href="admin/template/uploadpic.jsp?name=pic6" target="_blank">
							<img src="<%=t.getPic6()%>" id="picpic6" border="0" />
							</a>
						</td>
					</tr>
					<tr>
						<td>
						要显示的名称：
							<input type="text" name="docName1" id="iddocName1" value="<%=t.getDocName1()%>" />
							<br>
						现在的文件:
						<input type="text" name="docPath1" id="iddocPath1" disabled value="<%=t.getDocPath1()%>" />
						<a href="admin/template/uploadpic.jsp?name=docPath1" target="_blank">更改</a>
						
						</td>
					</tr>
					
					<tr>
						<td>
							<input type="button" onClick="javascript:subForm();" value="确定使用">
						</td>
					</tr>
					<tr>
						<td>
							<input type="button" onClick="javascript:view();" value="预览">
						</td>
					</tr>
					</form>
				</table>
			</td>
		</tr>
	</table>
  </body>
</html>

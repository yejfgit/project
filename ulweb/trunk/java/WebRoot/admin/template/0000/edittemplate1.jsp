
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlTemplate" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  
<head>
<base href="<%=basePath%>">
<title>edittemplate</title>
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
<style type="text/css">
  	img{
	cursor: hand;
		
	}
  </style>
</head>
  
  <%
  		UlTemplate t = (UlTemplate)request.getAttribute("template");
  %>
    <script  language="JavaScript">
  	function openwin(url,winname)
{   
    window.open("<%=basePath%>admin/template/" + url,winname,"width=350,height=200,resizable=yes,left=250,top=150,");    
}
  
  </script>
  
  <body>
 <table width="750" cellpadding="0" align="center" cellspacing="0" border="0">
   	<form action="admin/template.do?method=edit" method="post">
	<input type="hidden" name="templateId" value="<%=t.getTemplateId()%>" id="idtemplateId"/>
	<input type="hidden" name="pic1" id="idpic1" value="<%=(t.getPic1() == null ? "" : t.getPic1())%>"/>
	<input type="hidden" name="pic2" id="idpic2"  value="<%=(t.getPic2() == null ? "" : t.getPic2())%>"/>
	<input type="hidden" name="pic3" id="idpic3"  value="<%=(t.getPic3() == null ? "" : t.getPic3())%>"/>
	<input type="hidden" name="pic4" id="idpic4"  value="<%=(t.getPic4() == null ? "" : t.getPic4())%>"/>
	<input type="hidden" name="pic5" id="idpic5"  value="<%=(t.getPic5() == null ? "" : t.getPic5())%>"/>
	<input type="hidden" name="pic6" id="idpic6"  value="<%=(t.getPic6() == null ? "" : t.getPic6())%>"/>
	<input type="hidden" name="flash" id="idflash"  value="<%=(t.getFlash() == null ? "" : t.getFlash())%>"/>
		<tr>
			<td>
				<table width="100%" align="center">
					<tr>
						<td colspan="4" align="center">此模板为<%=t.getTemplatePtype()%>级模板</td>
					</tr>
					<tr>
						<td>
							设置模板名称:
						</td>
						<td>
							<input type="text" name="templateName" id="idtemplateName" value="<%=(t.getTemplateName() == null ? "" : t.getTemplateName())%>"></input>
						</td>
					
						<td>
							每页显示行数:
						</td>
						<td>
							<input type="text" name="pageSize" id="idpageSize" value="<%=t.getPageSize()%>"></input>
						</td>
						
					</tr>
					<tr>
						<td>
							css
						</td>
						<td>
							<textarea name="css" id="idcss" rows="3"><%=(t.getCss() == null ? "" : t.getCss())%></textarea>
						</td>
						<td>
							描述:
						</td>
						<td>
							<textarea name="templateDesc" id="idtemplateDesc" rows="3"><%=(t.getTemplateDesc() == null ? "" : t.getTemplateDesc())%></textarea>
						</td>
						
					</tr>
					<tr>
						<td colspan="4">
							<table width="100%">
								<tr>
									<td>
										
										<img src="<%=t.getPic1()%>" border="0" id="imgpic1" onClick="javascript:openwin('uploadpic.jsp?name=pic1','pic');"/>
									</td>
								</tr>
								<tr>
									<td>
										
										<img src="<%=t.getPic2()%>" border="0" id="imgpic2" onClick="javascript:openwin('uploadpic.jsp?name=pic2','pic');"/>
									</td>
								</tr>
								<tr>
									<td>
										
										<img src="<%=t.getPic3()%>" border="0" id="imgpic3" onClick="javascript:openwin('uploadpic.jsp?name=pic3','pic');"/>
									</td>
								</tr>
								<tr>
									<td>
										
										<img src="<%=t.getPic4()%>" border="0" id="imgpic4" onClick="javascript:openwin('uploadpic.jsp?name=pic4','pic');"/>
									</td>
								</tr>
								<tr>
									<td>
										
										<img src="<%=t.getPic5()%>" border="0" id="imgpic5" onClick="javascript:openwin('uploadpic.jsp?name=pic5','pic');"/>
									</td>
								</tr>
								<tr>
									<td>
										
										<img src="<%=t.getPic6()%>" border="0" id="imgpic6" onClick="javascript:openwin('uploadpic.jsp?name=pic6','pic');"/>
									</td>
								</tr>
								<tr>
									<td>
										
										<img src="<%=t.getFlash()%>" border="0" id="imgflash" onClick="javascript:openwin('uploadpic.jsp?name=flash','pic');"/>这里是放flash的，由于格式的不同，在此处看不到
									</td>
								</tr>
								
							</table>
						
						
						</td>
					</tr>					
					<tr>
						<td colspan="4" align="center">
							<input type="submit" value="确定"></input>
							&nbsp;&nbsp;
							<input type="button" value="取消" onClick="javascript:window.location.href='<%=basePath%>admin/template.do?method=list';"></input>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		</form>
   </table>
  </body>
</html>

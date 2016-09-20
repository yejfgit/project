
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
 function save(){
  	document.getElementById("idform1").action = "admin/template.do?method=edit";
  document.getElementById("idform1").target = "_self";
	document.getElementById("idform1").submit();
  }
  
  function view(){
  document.getElementById("idform1").action = "vDept2l.do?method=index";
  document.getElementById("idform1").target = "_blank";
  document.getElementById("idform1").submit();
  }
  
  
  </script>
  
  <body>
 <table width="750" cellpadding="0" align="center" cellspacing="0" border="0">
   	<form id="idform1" method="post">
	<input type="hidden" name="dept" value="ed"/>	
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
						<td colspan="2" align="center">此模板为首页模板</td>
						<td>
							每页显示行数:
						</td>
						<td>
							<input type="text" name="pageSize" id="idpageSize" value="<%=t.getPageSize()%>"></input>
						</td>
					</tr>
					<tr>
						<td>
							模板名称:
						</td>
						<td>
							<input type="text" name="templateName" id="idtemplateName" value="<%=(t.getTemplateName() == null ? "" : t.getTemplateName())%>"></input>
						</td>
					<td>
							描述:
						</td>
						<td>
							<input type="text" name="templateDesc" id="idtemplateDesc"  value="<%=(t.getTemplateDesc() == null ? "" : t.getTemplateDesc())%>"/>
							
						</td>
						
						
					</tr>
					<tr>
						<td>
							css
						</td>
						<td colspan="3">
							<textarea name="css" cols="70" id="idcss" rows="5"><%=(t.getCss() == null ? "" : t.getCss())%></textarea>
						</td>
							
								
						
					</tr>
					<tr>
						<td colspan="4">
							<table width="100%" cellspacing="0" cellpadding="0" border="0">								
								<tr>
									<td align="center">	背景图片								
										<img src="<%=t.getPic1()%>" border="0" title="背景图片" id="imgpic1" onClick="javascript:openwin('uploadpic.jsp?name=pic1','pic');"/>
									</td>
								</tr>
								<tr>
									<td align="center">	左上角logo							
										<img src="<%=t.getPic4()%>" border="0" title="左上角的logo" id="imgpic4" onClick="javascript:openwin('uploadpic.jsp?name=pic4','pic');"/>
										<br>
											背景图片：							
										<img src="<%=t.getPic2()%>" border="0" title="左上角的logo" id="imgpic2" onClick="javascript:openwin('uploadpic.jsp?name=pic2','pic');"/>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr><td colspan="4">
						<table width="100%">
							<tr><td valign="top" width="25%" align="center" style="border-left:1px gray solid;">
							中心最新动态
							<br><br><br><br>
							图片展示位置
							<br><br>
							合作单位连接
							</td>
								<td height="300" valign="top">
									<table width="100%">
										<tr>
											<td height="400" width="350" align="left;" valign="top" style="border:1px gray solid;">中部图片<br>
								<img src="<%=t.getPic3()%>" border="0" id="imgpic3" title="新闻图片:适宜高度105，适宜宽度140" onClick="javascript:openwin('uploadpic.jsp?name=pic3','pic');"/>											
											文字<br>
											<br><br>
											<center>文字内容等</center>
											</td>
											<td valign="top" style="font-family:'宋体';color:#008080;font-size:16px;font-style: oblique;border:1px gray solid;">右侧位置
											</td>
										</tr>
										
									</table>								</td>
							</tr>
							</table>
						</td>
					</tr>		
					
								
								
									
					<tr>
						<td colspan="4" align="center">
							<input type="button" onClick="javascript:save();" value="确定"></input>
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

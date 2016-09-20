
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlColumn" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>增加模板</title>
    
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
  <script  language="JavaScript">
  	function openwin(url,winname)
{   
    window.open("<%=basePath%>admin/template/" + url,winname,"width=350,height=200,resizable=yes,left=250,top=150,");    
}
 function save(){
  	document.getElementById("idform1").action = "admin/template.do?method=add";
  document.getElementById("idform1").target = "_self";
	document.getElementById("idform1").submit();
  }
  
  function view(){
  document.getElementById("idform1").action = "vDept2l.do?method=index";
  document.getElementById("idform1").target = "_blank";
  document.getElementById("idform1").submit();
  }
  
  </script>
  <%
  		List<UlColumn> l = (List<UlColumn>)request.getAttribute("list");
  %>
  <body>
   <table width="750" cellpadding="0" align="center" cellspacing="0" border="0">
   	<form  id="idform1" method="post">
	<input type="hidden" name="dept" value="ed"/>
	<input type="hidden" name="columnId" id="idcolumnId" value="99999"/>
	<input type="hidden" name="pic1" id="idpic1" value=""/>
	<input type="hidden" name="pic2" id="idpic2"  value=""/>
	<input type="hidden" name="pic3" id="idpic3" value=""/>
	<input type="hidden" name="pic4" id="idpic4"  value=""/>
	<input type="hidden" name="pic5" id="idpic5"  value=""/>
	<input type="hidden" name="pic6" id="idpic6" value=""/>
	<input type="hidden" name="flash" id="idflash"  value=""/>
	<input type="hidden" name="templatePtype" value="<%=request.getAttribute("templatePtype")%>"/>
		<tr>
			<td>
				<table width="100%" align="center">
					<tr>
						<td>模板:</td>
						<td>首页模板</td>
						<td>
							每页显示行数:
						</td>
						<td>
							<input type="text" name="pageSize" id="idpageSize" value="10"></input>
						</td>
					</tr>
					<tr>
						<td>
							设置模板名称:
						</td>
						<td>
							<input type="text" name="templateName" id="idtemplateName"></input>
						</td>
						<td>
							描述:
						</td>
						<td>
						<input type="text" name="templateDesc" id="idtemplateDesc" ></input>
							
						</td>
						
						
					</tr>
					<tr>
						<td>
							css
						</td>
						<td colspan="3">
							<textarea name="css" id="idcss" cols="70" rows="5"></textarea>
						</td>
						
						
					</tr>
					<tr>
						<td colspan="4">
							<table width="100%" cellspacing="0" cellpadding="0" border="0">								
								<tr>
									<td align="center">	背景图片								
										<img src="" border="0" title="背景图片" id="imgpic1" onClick="javascript:openwin('uploadpic.jsp?name=pic1','pic');"/>
									</td>
								</tr>
								<tr>
									<td align="center">	左上角logo																	
										<img src="" border="0" title="左上角的logo" id="imgpic4" onClick="javascript:openwin('uploadpic.jsp?name=pic4','pic');"/>
										<br>
										&nbsp;&nbsp;
										背景图片：																	
										<img src="" border="0" title="左上角的logo" id="imgpic2" onClick="javascript:openwin('uploadpic.jsp?name=pic2','pic');"/>
										
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
								<img src="" border="0" id="imgpic3" title="新闻图片:适宜高度105，适宜宽度140" onClick="javascript:openwin('uploadpic.jsp?name=pic3','pic');"/>											
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

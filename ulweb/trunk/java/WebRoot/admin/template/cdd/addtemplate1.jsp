
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
  document.getElementById("idform1").action = "vDept2l.do?method=sub2";  
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
	<input type="hidden" name="dept" value="cdd"/>
	<input type="hidden" name="cId" value="1"/>
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
						<td>请选择栏目</td>
						<td><select name="columnId" id="idcolumnId">
							<option value="99999" selected>默认模板</option>
							<%
								for(int i = 0 ; i < (l == null ? 0 : l.size()); i++){
									if(l.get(i).getIncludeContent() == 1){
										out.println("<option value='" + l.get(i).getColumnId() + "'>");
										out.print(l.get(i).getColumnName() + "</option>");
									}
								}
							%>
						</select></td>
						<td  >
						每页显示行数:
						</td>
						<td>
							<input type="text" name="pageSize" id="idpageSize" value="10"/>
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
							<input type="text" name="templateDesc" id="idtemplateDesc"></input>
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
					<tr><td width="100%" colspan="4">
						<table width="100%">
							<tr>
								<td align="center">
									网页上部flash<br>
									<img src="" border="0" id="imgpic1" onClick="javascript:openwin('uploadpic.jsp?name=pic1','pic');"/>
								</td>
							</tr>
							
							<tr><td>
							<table width="100%"><tr><td>&nbsp;</td>
							<td width="540" valign="top" align="center">&nbsp;</td>
							</tr>
							</table>
								</td>
							</tr>
						</table>
						</td>
					</tr>					
					<tr>
						<td colspan="4" align="center">
							<input type="button" onClick="javascript:save();" value="确定"></input>
							&nbsp;&nbsp;
							<input type="button" value="取消" onClick="javascript:window.location.href='<%=basePath%>admin/template.do?method=list';"></input>
							&nbsp;&nbsp;
						</td>
					</tr>
				</table>
			</td>
		</tr>
		</form>
   </table>
  </body>
</html>

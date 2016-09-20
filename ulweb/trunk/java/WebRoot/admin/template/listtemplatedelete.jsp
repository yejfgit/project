
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlTemplate" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>templateList</title>
    
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
  
  <body>
   <table border="0" cellpadding="0" cellspacing="0" align="center" width="740">
   		<tr>
			<td>
				<table width="100%">
					<tr>
						<td>
							
							<table width="100%">
								<%
									
									if(request.getAttribute("list") == null){
								%>
								<tr>
									<td colspan="5">
										您还没有建立任何模板
									</td>
								</tr>
								<%
									}else{
									List<UlTemplate> list = (List<UlTemplate>)request.getAttribute("list");
								%>
								<tr>
									<td width="20%">
										模板名称
									</td>
									<td width="15%">对应栏目等级</td>
									<td width="15%">
										设置
									</td>
									<td>
										描述
									</td>
									
								</tr>
								<%
										for(int i = 0; i < list.size(); i++){
											
								%>
								<tr>
									<td>
										<%=list.get(i).getTemplateName()%>
									</td>
									<td>
										<%=list.get(i).getTemplatePtype()%>
									</td>
									<td>
										<a href="admin/template.do?method=bEdit&templateId=<%=list.get(i).getTemplateId()%>">修改</a>
										&nbsp; <a  href="admin/template.do?method=delete&templateId=<%=list.get(i).getTemplateId()%>">删除</a>
									</td>
									
									<td>
										<%=list.get(i).getTemplateDesc()%>
									</td>
								</tr>
								<%
										}
									}
								%>
							</table>
						</td>
					</tr>
					
					<tr>
						
			          <td align="center"> 
					    <a href="admin/template.do?method=bAdd&templatePtype=9">增加主页的模板</a>
						&nbsp;&nbsp;
		  				<a href="admin/template.do?method=bAdd&templatePtype=1">增加新的一级模板</a>
						&nbsp;&nbsp;
						<a href="admin/template.do?method=bAdd&templatePtype=2">增加新的二级模板</a>
						&nbsp;&nbsp;
						<a href="admin/template.do?method=bAdd&templatePtype=3">增加新的三级模板</a>
					  </td>
					</tr>
				</table>
			</td>
		</tr>
   </table>
  </body>
</html>

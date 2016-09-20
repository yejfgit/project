
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
	<input type="hidden" name="dept" value="1110"/>	
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
									<td>
										<img src="<%=t.getPic1()%>" border="0" id="imgpic1" onClick="javascript:openwin('uploadpic.jsp?name=pic1','pic');"/>
									</td>
									<td>
									
										<img src="<%=t.getPic2()%>" border="0" id="imgpic2" onClick="javascript:openwin('uploadpic.jsp?name=pic2','pic');"/>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr><td colspan="4">
						<table width="100%">
							<tr>
								
								<td width="75%">
									<table width="100%" cellpadding="0" cellspacing="0" border="0">
										<tr>
											<td>
											title1:
												代理业务部
											</td>
										</tr>
										<tr>
											<td>
												<img src="<%=t.getPic3()%>" border="0" id="imgpic3" onClick="javascript:openwin('uploadpic.jsp?name=pic3','pic');"/>
												
											</td>
										</tr>
										<tr><td height="5"></td></tr>
										<tr>
											<td>
											<img src="<%=t.getPic4()%>" border="0" id="imgpic4" onClick="javascript:openwin('uploadpic.jsp?name=pic4','pic');"/>
																				
																		
											合众人寿代理业务部： 
合众人寿代理业务部成立于2005年2月，成立两年以来，与公司共成长，在已开设的十二家分支机构都有飞速的业务发展。
											</td>
											
										</tr>
										<tr>
											<td>
																		
											目前已与中国工商银行、中国农业银行、中国建设银行、交通银行、邮政储汇局等国有、股份制商业银行和其它金融机构建立了合作关系
											</td>
										</tr>
										<tr>
											<td>
											
																				
											目前已上市的产品有：鼎瑞防癌理财计划、长红分红两全理财计划、金长红B款（万能型），产品特色鲜明，投放市场后得到了广大客户的喜爱，一年以来赢得了广大客户的良好口碑，也赢得了合作渠道的信任。
											</td>
											
										</tr>
										<tr>
											<td>
																						
											 2006年合众人寿被中国消费者基金会评为：“维护消费者权益，诚信服务满意单位”。合众人寿代理业务部将继续秉承规范经营、稳健发展、合作双赢的发展方针，立志于发展我国的民族银行保险事业。 
											</td>
										</tr>
									</table>
								</td>
								<td align="center" valign="top">
									<br>
									list1:
									<br>
									这个是table的<br>
									<br>
									<br>
									部门介绍  <br>
													企划前沿  <br>
													渠道合作  <br>
													银保前线  <br>
													培训园地  <br>
													部门动态  <br>
													销售支持  <br>
								</td>
							</tr>
						</table>
					</td></tr>
					<tr><td colspan="4" align="center" >
						<img src="<%=t.getPic6()%>" border="0" id="imgpic6" onClick="javascript:openwin('uploadpic.jsp?name=pic6','pic');"/>
					</td></tr>
							
									
					<tr>
						<td colspan="4" align="center">
							<input type="button" onClick="javascript:save();" value="确定"></input>
							&nbsp;&nbsp;
							<input type="button" value="取消" onClick="javascript:window.location.href='<%=basePath%>admin/template.do?method=list';"></input>
							&nbsp;&nbsp;
							<input type="button" value="预览" onClick="javascript:view();"/>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		</form>
   </table>
  </body>
</html>

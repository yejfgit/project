
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
	<input type="hidden" name="dept" value="1107"/>	
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
					<tr><td colspan="4" style="color:red;font-size:14px;">
					首页背景
					<img src="<%=t.getPic1()%>" border="0" id="imgpic1" onClick="javascript:openwin('uploadpic.jsp?name=pic1','pic');"/></td></tr>
					<tr>
						<td colspan="4"  valign="top">
						背景为pane1,2,3,
						字体为titlelist1,2,3
								
								<table border="1"><tr><td>
									营销公告通知
								</td><td>
									业务报表
								</td>
								<td>
									交流园地
								</td><td>
									服务部专区
								</td><td>
									日常工作
								</td>
								<td>机构动态
								</td>
								</tr>
								</table>
												
						</td>
					</tr>
					<tr>
						<td colspan="4">
						
						<table width="100%" cellpadding="0" cellspacing="0" border="0">
					<tr>
						<td width="300" valign="top">
							<table cellpadding="0" cellspacing="0" border="0" width="100%">
								<tr><td height="50"></td></tr>
								<tr><td class="title1" align="center">营销部</td></tr>
								<tr><td>标题为title1 </td></tr>
								<tr>
									<td align="center" style="margin-top:50px;">
										<img src="<%=t.getPic2()%>" border="0" id="imgpic2" onClick="javascript:openwin('uploadpic.jsp?name=pic2','pic');"/>		
									</td>
								</tr>
							
							</table>
								
						</td>
						<td align="left" valign="top">
							<table cellpadding="0"  align="center" cellspacing="0" border="0" width="95%">
								<tr><td height="20"></td></tr>
								<tr>
									<td width="30"></td>
									<td rowspan="2" width="50" ><img src="<%=t.getPic3()%>" border="0" id="imgpic3" onClick="javascript:openwin('uploadpic.jsp?name=pic3','pic');"/>
												</td>
									<td></td>
								</tr>
								<tr>
									<td width="10"><img src="<%=t.getPic4()%>" alt="背景小图" border="0" id="imgpic4" onClick="javascript:openwin('uploadpic.jsp?name=pic4','pic');"/>
												</td>
									
									<td ></td>
								</tr>
								<tr>
									<td colspan="3">
										部门简介具体内容
										<br>
										标题为title2,内容为content1
										
											
									<p>

总公司营销部主要职责是制定个险营销政策、制度、流程；提供个险营销策略、方法、工具等销售支持；协助总经理室进行机构、队伍的有效管理。		</p>
		
		                            <p>
总公司营销部下设四个室：人员管理室，业务管理室，企划室及督导室。各室之间的职能分工如下：
		</p>
		<p>
人员管理室：主要负责《基本法》拟定、实施及维护；佣金管理、聘才管理、业务队伍管理政策、制度的制定；队伍品质管理、核心业务系统的维护及改善等。
		</p>
		<p>
业务管理室：主要负责计划目标拟定、指标定义及数据实现、业务报表及MIS系统维护、经营分析报表、综合开拓、营销业务制度管理等。
		</p>
		<p>
企划室：主要负责竞赛方案拟定及评估；产品市场调研及包装推动；荣誉体系的建立；电脑建议书系统的开发、维护；行销辅助品的开发、制作；行销活动的策划及组织；营销定期会议的组织实施等。
		</p>
		<p>
督导室：主要负责总部政策、制度、方案在分公司的推动和执行评估；分公司业务计划的实施追踪和评估；分公司业务问题的改善追踪和评估；分支机构业务沟通及协调等。
		</p>


									</td>
								</tr>
							</table>
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

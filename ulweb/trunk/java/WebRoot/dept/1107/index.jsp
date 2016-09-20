
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlTemplate,com.ulic.ulweb.ulweb.entity.UlColumn" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  
<head>
<base href="<%=basePath%>">
<title>营销部</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<LINK href="style/ul.css" type="text/css" rel=stylesheet>

<%
		UlTemplate t = (UlTemplate)request.getAttribute("template");
		List<UlColumn> l = (List<UlColumn>)request.getAttribute("columnList");		
		
	%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<%
		if(t.getCss() != null){
			out.print(t.getCss());
		}
	 %>
</head>
  	 <script language="JavaScript" >
	 function openwinn(url)
{
    window.open(url,'',"width=" + screen.width + ",height=" + screen.height + ",scrollbars=yes,resizable=yes,left=0,top=0,menubar=yes,location=yes,toolbar=yes");   

}
	 </script>
	
  <body   bgcolor="#DDEADD">
<table width="770" cellpadding="0" cellspacing="0" border="0" align="center" class="table1" bgcolor="#ffffff" background="<%=t.getPic1()%>"  style="background-repeat:repeat;">
	<tr><td height="30"></td></tr>
		<tr>
			<td  style="border-top:2px #33CCFF solid;border-bottom:1px #CC66CC solid;">
				<table cellpadding="0" cellspacing="0" border="0" width="100%" class="titletable">
					<tr align="left">
						<td width="20" height="100"></td>
								<%
									for(int i = 0; i < (l == null ? 0 : l.size()); i++){
								%>
								
									<td align="left" >
										<table width="80" cellpadding="0" cellspacing="0" border="0" class="pane<%=(i + 1)%>"  >
<tr bgcolor="#FFFFFF"><td height="0" width="1"></td><td width="1"></td><td width="1"></td><td width="74"></td><td width="1"></td><td width="1"></td><td width="1"></td>

<tr><td height="1" colspan="3" bgcolor="#FFFFFF"></td><td bgcolor="#999999" ></td><td colspan="3" bgcolor="#FFFFFF" ></td></tr>
<tr><td height="1" colspan="2" bgcolor="#FFFFFF"></td><td bgcolor="#999999"></td><td  ></td><td bgcolor="#999999"></td><td colspan="2" bgcolor="#FFFFFF"></td></tr>
<tr><td height="1" bgcolor="#FFFFFF"></td><td bgcolor="#999999" ></td><td colspan="3" ></td><td bgcolor="#999999" ></td><td bgcolor="#FFFFFF" ></td></tr>
<tr>

<td bgcolor="#999999" ></td><td colspan="5" valign="top"  onClick="javascritp:window.location.href='<%=basePath%>dept2l.do?method=sub1&columnId=<%=l.get(i).getColumnId()%>';"  >

<div style="width:78px;height:100px;cursor:hand;" id="iddiv<%=(i + 1)%>"  class="titlelist<%=(i + 1)%>">
<%=l.get(i).getColumnName()%>
</div>
<div style="text-align:right;margin-right:10px;height:20px;">&gt;&gt;</div>

</td>

<td bgcolor="#999999" ></td></tr>
<tr><td height="1"   bgcolor="#FFFFFF"></td><td bgcolor="#999999" ></td><td colspan="3" ></td><td bgcolor="#999999" ></td><td bgcolor="#FFFFFF" ></td></tr>
<tr><td height="1" colspan="2" bgcolor="#FFFFFF"></td><td bgcolor="#999999"></td><td  class="pane<%=(i + 1)%>"></td><td bgcolor="#999999"></td><td  bgcolor="#FFFFFF"colspan="2"></td></tr>
<tr><td height="1"  colspan="3" bgcolor="#FFFFFF"></td><td bgcolor="#999999" ></td><td colspan="3" bgcolor="#FFFFFF" ></td></tr>
<tr bgcolor="#FFFFFF"><td  height="1" width="1"></td><td width="1"></td><td width="1"></td><td ></td><td width="1"></td><td width="1"></td><td width="1"></td>
</table>
									</td>
									<td width="5"></td>					
								<%
									}
								%>
						<td></td>
					</tr>			
				</table>
				
			</td>			
		</tr>
		
		<tr><td></td></tr>
		
		<tr><td >
				<table width="100%" cellpadding="0" cellspacing="0" border="0">
					<tr>
						<td width="300" valign="top">
							<table cellpadding="0" cellspacing="0" border="0" width="100%">
								<tr><td height="50"></td></tr>
								<tr><td align="center" class="title1">营销部主页</td></tr>
								<tr><td height="20"></td></tr>
								<tr>
									<td align="center" style="margin-top:50px;">
										<img src="<%=t.getPic2()%>" border="0" />
									</td>
								</tr>
							</table>
								
						</td>
						<td valign="top"  align="left">
							<table cellpadding="0"  align="center" cellspacing="0" border="0" width="95%">
								<tr><td height="20" ></td></tr>
								<tr>
									<td width="30" style="background-position:bottom;background-repeat:repeat-x;" background="<%=t.getPic4()%>"  >
									<p style="margin-left:50px;"><img src="<%=t.getPic3()%>" border="0" ></p>
									</td>
								</tr>
								
								
								<tr><td height="20" ></td></tr>
								<tr>
									<td  class="title2">
										部门简介
									</td>
								</tr>
								<tr><td class="content1">
									
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


								</td></tr>
								<tr><td  height="10"></td></tr>
						  </table>
						</td>
					</tr>				
					
				</table>
						
		</td></tr>
		
		<tr><td><iframe frameborder="0" height="100" scrolling="no" src="dept/1107/indexbottom.jsp" width="100%"></iframe></td></tr>
	</table>
  </body>
</html>

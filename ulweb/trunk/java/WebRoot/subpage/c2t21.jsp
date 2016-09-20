
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.ulweb.entity.UlColumn" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <%
		UlColumn c = (UlColumn)request.getAttribute("c");
		String ptype = (String)(request.getAttribute("ptype") == null ? "" : request.getAttribute("ptype"));		
		int scid = (request.getAttribute("scid") == null ? 0 : ((Integer)(request.getAttribute("scid"))).intValue());		
		
		UlColumn cp = null;
		List<UlColumn> cl = null;
//		List<UlContent> list = (List<UlContent>)request.getAttribute("list");
		if(c != null ){
			
				cp = (UlColumn)request.getAttribute("cp");
				cl = (List<UlColumn>)request.getAttribute("cl");
			
		}else{
			request.setAttribute("errorMessage","请不要从地址栏直接输入jsp地址进行链接");
			response.sendRedirect(basePath + "error/errorpage.jsp");
		}
	
	
	%>
    <title><%=(c == null ? "" : c.getColumnName())%></title>
    
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
  <style>
.div1{
background-image:url(images/index/c2t13_clip_image004.gif);
background-repeat:no-repeat;
background-position:0px 690px;
font-size:14px;

}
p{
margin:5px 5px 0px 10px;
}

  </style>
  
  </head>
  <script language="JavaScript" src="script/list.js"></script>
  <body>
  
	<table cellpadding="0" width="760" cellspacing="0" border="0" align="center" >
		<tr>
		  <td>
				<table width=100% cellPadding=0 
                  cellSpacing=0 bgcolor="#FFFFFF"   >
						<!--DWLayoutTable tile-->
						<tr> 
						  <td width="4" height="4"></td>
						  <td width="106"></td>
						  <td width="1"></td>
						  <td width="637"></td>
						</tr>
						<tr> 
						  <td height="60" colspan="3" valign="top"><img src="images/index/logo.gif" width="117" height="60"></td>
						  <td rowspan="4" valign="top" width="639" background="images/index/080922fuwunian1.jpg" style="background-repeat:no-repeat;"><!--DWLayoutEmptyCell-->&nbsp;</td>
						</tr>
						<tr> 
						  <td height="1"></td>
						  <td></td>
						  <td></td>
						</tr>
						<tr> 
						  <td height="9"></td>
						  <td rowspan="2" valign="top" align="center">和 你 在 一 起</td>
						  <td></td>
						</tr>
						<tr> 
						  <td height="30"></td>
						  <td></td>
						  <td></td>
						</tr>
						<tr> 
						  <td height="2"></td>
						  <td></td>
						  <td></td>
						  <td></td>
						</tr>
		    </table>		    </td>
		</tr>
		<tr><!--   title    -->
			<td><iframe src="frame/indextitle.jsp" width="760" height="40" frameborder="0" scrolling="no" ></iframe></td>
		</tr>
		<tr><!-- 		titlepic		-->
			<td align="center"></td>
		</tr>
		<tr>
			<!--			content			-->
			<td >
					<table width="100%" style="border-right: gray 1px solid;">
						<tr>
							<td></td>
							<td width="2%"></td>
							<td width="68%"></td>
						</tr>
						<tr>
							<td width="30%" valign="top">
								<table width="100%" style="border: gray 1px solid;">
									<tr><td height="10"></td></tr>
									<tr><td align="center">
										<table cellpadding="0" cellspacing="0" border="0" width="200" align="center">		
											<tr>												
              							        <td>
													<table border="0" width="100%" cellspacing="0">														
														<tr>
															<td align="center" style="color:#ff6600;font-size:14px;border-bottom: 1px gray solid;"  >
																<%=(cp == null ? "" : cp.getColumnName())%>															</td>
														</tr>
														
															
														<%
															for(int i = 0; i < (cl == null ? 0 : cl.size()); i++){
														%>
														<tr>
															<td  align="center">
																<a style="font-size:14px;line-height:20px;" href="list.do?method=zongbu&scid=<%=cl.get(i).getColumnId()%>&ptype=22&columnId=<%=cp.getColumnId()%>" >
																<%
						
								out.print(cl.get(i).getColumnName());
																%>		
																</a>															</td>
														</tr>
														
														<%
															}
														%>
														<tr><td align="center">
															<a style="font-size:14px;line-height:20px;"  href="mailto:houkun@ulic.com.cn">合理化建议</a>
														</td></tr>
													</table>												</td>
											</tr>
										</table>								
									</td></tr>
									<tr><td height="15"></td></tr>
									
									<tr><td></td></tr>
									<tr valign="bottom"><td align="center"><img src="images/index/080922fuwunian2.jpg" border="0" width="150" /></td>
									</tr>
									
									<tr><td align="center">
										<br><br><br>
										专栏维护员：侯琨
										<br>
										88295
										<br>
										<br><br>
									</td></tr>
									
									
								</table>
							</td>
							<td></td>
							  <td valign="top">
							  		<table border="0" >
										
										<tr>
											<td width="100%" colspan="5" >
												<div style="font-size:12px;" class="div1">
												<br />
															<p style="font-size:16px; text-align:center;">合众人寿2008服务年</p>								
												<p>	
												&nbsp;&nbsp;&nbsp;&nbsp;
												 2008年是合众人寿发展的重要一年，是公司由创业期转向发展期的第一年。这一年，合众人寿总保费收入规模将达50亿，人力规模迈上新台阶，各项核心业务指标将上新高度，基本完成全国范围内的网点布局，迅速进入中型保险公司行列。2008年将成为合众发展史中里程碑似的一年。
												
												</p>
												<p>&nbsp;&nbsp;&nbsp;&nbsp;
	 2007年是合众人寿快速发展的一年，公司保费收入突破30亿元，同比增长87.8%；已开设16家分公司，75家中心支公司，273家营销服务部，内勤员工达四千多人，外勤队伍五万多人。一个覆盖发达地区的销售网络已基本形成。
	 </p>
	 <p>&nbsp;&nbsp;&nbsp;&nbsp;
党的十七大，对金融行业的发展做出新的要求，给保险业带来巨大的发展机遇。同时，保险业也将面对市场主体增加、监管更加严格、竞争愈加激烈的更加严峻的竞争格局。面对新的发展机遇和更加激烈的市场竞争，公司如何才能保持持续、稳健、科学、又好又快地发展，如何较好地实现我们阶段性的战略规划目标，将是我们现阶段的重要课题！为此，董事长明确了迈向未来的成长步伐，未来每年公司将确定一个经营管理主题，并确定2008年是“服务年”。董事长指出，“服务”是合众的核心竞争力，希望通过服务，深入贯彻“合众保险，理赔不难”的服务理念，将合众的服务品牌继续做大做强。陈炳根总裁也指出，合众对服务的追求没有止境，公司业务和内含价值的快速增长正是检验我们服务水平的最佳标准。如果每一位员工每一天都能够在高效服务和为客户、同事解决问题这些方面多走一步，合众将成为客户在寿险解决方案上的最优选择之一。

</p>

<p>&nbsp;&nbsp;&nbsp;&nbsp;
“服务年”活动的开展，对于营造良好的服务氛围、树立服务思想、提高服务意识和效率、提升公司品牌、增强公司市场竞争力，都具有十分重要的意义。我们希望通过服务年，达到两个目的，一是树立全员服务意识，即总公司为分公司服务，分公司为中支服务，中支为营销服务部服务，内勤为外勤服务，外勤为客户服务，全员为业务发展服务；二是提高主动服务思想，即在服务上“比别人多走一步”，用真诚的态度、专业的技能、细致的方式和高效的结果，让业务一线满意，让客户满意，让分支机构满意，从而促进公司经营管理的规范，提升公司业务的发展。
</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;
但“服务”这两个字不是简单的口号，而是所有员工实实在在的行动。总公司各部门、各分支机构，要将服务年活动落到实处，广泛开展服务技能、服务理念的培训，美化服务环境，规范服务礼仪，优化服务流程，创新服务举措，提高服务效率，给我们的内外客户以真诚、专业、高效、细致的服务。
</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;
	 2008年，我们以服务为先导，以服务促效益，以服务促发展，以品质为目标。“2008服务年”的开展，合众人寿必将迈向新的发展境界，将为公司第二阶段战略目标的实现打下坚实的基础。
	 
	 </p>


												
												</div>										  </td>
										</tr>
								</table>						      </td>
						</tr>
					</table>			</td>
		</tr>
		<tr>
			<td>
				<jsp:include page="../frame/indexbottom.jsp" />			</td>
		</tr>
		<tr><td height="30"></td></tr>
	</table>
   
   
  </body>
</html>

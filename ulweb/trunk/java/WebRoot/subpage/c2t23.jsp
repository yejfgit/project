
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

font-size:14px;

}
p{
margin:10px;
padding: 10px;
line-height:20px
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
						  <td rowspan="4" valign="middle" align="center"  width="639" background="images/index/zhixing.jpg" style="background-repeat:no-repeat;"><div style="width:100%;text-align:center;font-size:24px;font-family:'黑体';font-style:italic;font-weight:bold;color:#ffffff;">
			我的执行，我的责任       ----2009合众执行年
		</div></td>
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
																<a style="font-size:14px;line-height:20px;" href="list.do?method=zongbu&scid=<%=cl.get(i).getColumnId()%>&ptype=24&columnId=<%=cp.getColumnId()%>" >
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
									<tr><td height="400"></td></tr>
									
									<tr><td></td></tr>
									<tr valign="bottom"><td align="center"></td>
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
										  <tr align="center" valign="middle"> 
    <td height="32" colspan="10" style="color:#ff0000;font-size:18px;">2009合众执行年</td>
  </tr>
										<tr>
											<td width="100%" colspan="5" >
												<div style="font-size:12px;" class="div1">


	<p class="MsoNormal" style="MARGIN: 0cm 0cm 0pt; TEXT-INDENT: 28pt; mso-char-indent-count: 2.0"><span lang="EN-US" style="FONT-SIZE: 14pt"><font face="Times New Roman">2009</font></span><span style="FONT-SIZE: 14pt; FONT-FAMILY: 宋体; mso-hansi-font-family: 'Times New Roman'; mso-ascii-font-family: 'Times New Roman'">年是合众进入发展期的第二年，也是公司向内涵式发展转型更加深入的一年，公司在快速发展中取得了优秀的业绩，规模不断发展壮大，公司的日常经营管理也变得异常复杂：每天都会新增大量的个人客户和企业客户；每天都有大量新契约保费产生；每天都会发生数以万计的职场租金、资产折旧等经营成本费用及管理费用；每天都要对新老客户服务进行服务&hellip;&hellip;，任何一个环节都可能隐含着重大风险。靠什么管理日益庞大的公司和复杂的业务？</span><span lang="EN-US" style="FONT-SIZE: 14pt"><o:p></o:p></span></p>
<p class="MsoNormal" style="MARGIN: 0cm 0cm 0pt; TEXT-INDENT: 28pt; mso-char-indent-count: 2.0"><span style="FONT-SIZE: 14pt; FONT-FAMILY: 宋体; mso-hansi-font-family: 'Times New Roman'; mso-ascii-font-family: 'Times New Roman'">公司要从初创的成功成为优秀乃至卓越的企业，实现员工与公司共同成长的目标，我们目前的经营管理水平与发展期战略的要求还存在较大的差距，纠其根本原因是公司的执行体系存在一定的问题。世界上很多优秀的企业，他们拥有卓越的</span><span lang="EN-US" style="FONT-SIZE: 14pt"><font face="Times New Roman">CEO</font></span><span style="FONT-SIZE: 14pt; FONT-FAMILY: 宋体; mso-hansi-font-family: 'Times New Roman'; mso-ascii-font-family: 'Times New Roman'">、一流的人才以及远大而美好的愿景，而且聘请了优秀的咨询人员作为顾问，但他们的企业经营最终却失败了。他们拥有成功需要的一切资源，唯独缺少合理运用这些资源，脚踏实地走向成功的</span><span lang="EN-US" style="FONT-SIZE: 14pt"><font face="Times New Roman">&ldquo;</font></span><span style="FONT-SIZE: 14pt; FONT-FAMILY: 宋体; mso-hansi-font-family: 'Times New Roman'; mso-ascii-font-family: 'Times New Roman'">执行</span><span lang="EN-US" style="FONT-SIZE: 14pt"><font face="Times New Roman">&rdquo;</font></span><span style="FONT-SIZE: 14pt; FONT-FAMILY: 宋体; mso-hansi-font-family: 'Times New Roman'; mso-ascii-font-family: 'Times New Roman'">能力。没有执行，一切美妙的战略、愿景都将是空中楼阁。</span><span lang="EN-US" style="FONT-SIZE: 14pt"><o:p></o:p></span></p>
<p class="MsoNormal" style="MARGIN: 0cm 0cm 0pt; TEXT-INDENT: 28.5pt"><span style="FONT-SIZE: 14pt; FONT-FAMILY: 宋体; mso-hansi-font-family: 'Times New Roman'; mso-ascii-font-family: 'Times New Roman'">公司正在按照十年发展规划的正确方向前进，发展目标十分明确，但同时也意识到：有价值的战略、有意义的变革最终只能来自实际、有效的执行工作，跨越目标与结果之间鸿沟的唯一途径也是执行。因此，公司确定</span><span lang="EN-US" style="FONT-SIZE: 14pt"><font face="Times New Roman">2009</font></span><span style="FONT-SIZE: 14pt; FONT-FAMILY: 宋体; mso-hansi-font-family: 'Times New Roman'; mso-ascii-font-family: 'Times New Roman'">年为合众的执行年，这是公司及董事会做出的重要决策。当然，这只是公司建立执行文化的开始，今后要一直把这种文化建立下去，要贯穿公司经营管理及服务的始终。</span><span lang="EN-US" style="FONT-SIZE: 14pt"><o:p></o:p></span></p>
<p class="MsoNormal" style="MARGIN: 0cm 0cm 0pt; TEXT-INDENT: 28pt; mso-char-indent-count: 2.0"><span style="FONT-SIZE: 14pt; FONT-FAMILY: 宋体; mso-hansi-font-family: 'Times New Roman'; mso-ascii-font-family: 'Times New Roman'">执行就是将计划落到实处，执行就是对结果负责，执行就是立即去行动，执行就是绝对的服从，执行就是勇于承担责任。简而言之，执行不单是战术，也是战略；不单是行为，也是系统的方法；最重要的，它不是被动完成，而是主动解决，而这，恰恰是我们工作中最需要的态度。不论是执行的三要素也好，还是执行的三流程也好，最终就是两个字</span><span lang="EN-US" style="FONT-SIZE: 14pt"><font face="Times New Roman">&mdash;&mdash;&ldquo;</font></span><span style="FONT-SIZE: 14pt; FONT-FAMILY: 宋体; mso-hansi-font-family: 'Times New Roman'; mso-ascii-font-family: 'Times New Roman'">责任</span><span lang="EN-US" style="FONT-SIZE: 14pt"><font face="Times New Roman">&rdquo;</font></span><span style="FONT-SIZE: 14pt; FONT-FAMILY: 宋体; mso-hansi-font-family: 'Times New Roman'; mso-ascii-font-family: 'Times New Roman'">。这就是执行文化的关键。由</span><span lang="EN-US" style="FONT-SIZE: 14pt"><font face="Times New Roman">&ldquo;</font></span><span style="FONT-SIZE: 14pt; FONT-FAMILY: 宋体; mso-hansi-font-family: 'Times New Roman'; mso-ascii-font-family: 'Times New Roman'">责任</span><span lang="EN-US" style="FONT-SIZE: 14pt"><font face="Times New Roman">&rdquo;</font></span><span style="FONT-SIZE: 14pt; FONT-FAMILY: 宋体; mso-hansi-font-family: 'Times New Roman'; mso-ascii-font-family: 'Times New Roman'">开始，到&ldquo;责任</span><span lang="EN-US" style="FONT-SIZE: 14pt"><font face="Times New Roman">&rdquo;</font></span><span style="FONT-SIZE: 14pt; FONT-FAMILY: 宋体; mso-hansi-font-family: 'Times New Roman'; mso-ascii-font-family: 'Times New Roman'">结束，这就是解决执行力不强的根本因素。</span><span lang="EN-US" style="FONT-SIZE: 14pt"><o:p></o:p></span></p>





												
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

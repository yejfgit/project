
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
line-height:23px;

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
						  <td rowspan="4" valign="top" width="639" background="images/index/shuye.jpg" style="background-repeat:no-repeat;"><!--DWLayoutEmptyCell-->&nbsp;</td>
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
														<tr><td align="center">
															<a style="font-size:14px;line-height:20px;"  href="list.do?method=zongbu&scid=224&ptype=13&columnId=221">活动简介</a>
															
															</td></tr>
															<tr><td align="center">
															<a style="font-size:14px;line-height:20px;color:#3399ff;"  href="list.do?method=zongbu&scid=224&ptype=14&columnId=221">客户亲笔感谢信</a>
														</td></tr>
														<%
															for(int i = 0; i < (cl == null ? 0 : cl.size()); i++){
														%>
														<tr>
															<td  align="center">
																<a style="font-size:14px;line-height:20px;" href="list.do?method=zongbu&scid=<%=cl.get(i).getColumnId()%>&ptype=15&columnId=<%=cp.getColumnId()%>" >
																<%
						
								out.print(cl.get(i).getColumnName());
							
																	%>		
																</a>															</td>
														</tr>
														
														<%
															}
														%>
													</table>												</td>
											</tr>
										</table>								
									</td></tr>
									<tr><td height="15"></td></tr>
									
									<tr><td></td></tr>
									<tr valign="bottom"><td align="center">
										<img src="images/index/mengyang1.jpg" border="0" width="220" /></td></tr>
									
									
								</table>							</td>
							<td></td>
							  <td valign="top">
							  		<table border="0" >
										
										<tr>
											<td width="100%" colspan="5" >
												<div style="color:#ff6600;" class="div1">
												<br />
												<p style="text-align:center;font-size:24px;font-weight:bold;font-family:'华文行楷';">客户的满意是我们最好的回报</p>
											
												<p> &nbsp; &nbsp; &nbsp; &nbsp;在哈尔滨本部的体检过程中，有一位客户被公司工作人员的热情服务深深感动，
												事后亲自送上其亲笔在大红纸上写的感谢信，为黑龙江分公司的VIP客户免费体检活动增添了亮丽的一笔，
												也是对合众人寿真情服务精神的最真实写照。
							
												<img src="images/index/c2t13_clip_image005.jpg" border="0" >
												<br>
											   以下为感谢信的内容：
											   <p style="font-size:16px;text-align:center;font-weight:bold;">感  谢  信</p>
											   尊敬的合众保险公司领导及员工：<br>
											   
											   &nbsp; &nbsp; &nbsp; &nbsp; 我是通过门静女士成为贵公司VIP客户的，并有幸应邀参加了本月16日贵公司组织的体检活动。
											   那天天气很冷，但公司人员周到的服务、热情的关怀却让我感到春天般的温暖，并留下了难以忘却、常忆常新的感动。
											   
											   <br>&nbsp; &nbsp; &nbsp; &nbsp;那天我7点40就到了体检地点，往楼上走时，我暗自责怪自己来的太早了，没想到一到三楼，
											   就看到了贵公司欢迎VIP客户参加体检活动的大红横幅，紧接着就有两位男士放下手头的工作
											   （后来我知道是贵公司运营部徐凯经理和谢文峰主任，以下人员的名字也是后来知道的）笑容可掬地迎上来，
											   得知我体检之后还要回单位有急事时，就立即和体检单位负责人联系，为我一个人先办理了体检手续，在体检过程中，
											   医生建议我加一项检查，徐凯经理、刘桂宇主任和张薇女士知道后就马上与体检单位沟通联系，没耽误我一分钟时间，
											   就为我及时补办了检查项目，并且享受到了团体优惠价格。
											   
											   <br>&nbsp; &nbsp; &nbsp; &nbsp;在两个多小时的体检过程中，我始终感受到公司对客户的关心和关爱，感受到公司工作人员体贴细心的服务。检查结束时，
											   工作人员还一直等待着我，几位经理和主任都迎上前来，热情地询问检查情况。
											   张薇、齐文静、吴洋、柳婷等四位女士也身披礼仪绶带，向我露出了祝福的微笑，后来我才知道，
											   他们为了提前做好服务准备工作，大多都是提前半个多小时就到了体检现场，有的人连早饭都没有吃。
											   因为我当时体检后走的很匆忙，连声感谢都没有来得及说，一直感到十分内疚，在这里请允许我发自肺腑地说声：
											   谢谢！你们辛苦了！从你们身上，我看到了你们公司的形象，你们员工队伍的整体素质。
											   一滴水能映出太阳的光辉，你们每个人都是企业的形象代言人，每个人都是企业的一面旗帜。
											   <br>
											   &nbsp; &nbsp; &nbsp; &nbsp;简单的一次体检活动，由于组织得力、服务到位，极大地拉近了企业和客户的距离，加深了企业和客户的情感，
											   这一切都是因为有你们。你们是桥梁，是纽带，你们用热心的服务让企业文化有血有肉。
											   真挚的祝愿你们及公司领导和全体同仁，祝你们事业有成、身体健康、精神愉快，祝愿贵公司蒸蒸日上、如日中天！
											   <br>
											   &nbsp; &nbsp; &nbsp; &nbsp;最后我想送你们一句能打动人心、合铸人力的话，也是带有企业诉求语性质的一句话：
											   <br>
											   <span style="font-size:16px;font-weight:bold;">&nbsp; &nbsp; &nbsp; &nbsp;合众人寿你我他,幸福人生是一家!</span>


												<p style="text-align:right;width:auto;">    合众客户：马曾良 &nbsp; &nbsp; &nbsp; &nbsp;</p>
												<p style="text-align:right;width:auto;">   2007年11月19日 &nbsp; &nbsp; &nbsp; &nbsp; </p>
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

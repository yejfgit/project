
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
															<a style="font-size:14px;line-height:20px;color:#3399ff;"  href="list.do?method=zongbu&scid=224&ptype=13&columnId=221">活动简介</a>
															
															</td></tr>
															<tr><td align="center">
															<a style="font-size:14px;line-height:20px;"  href="list.do?method=zongbu&scid=224&ptype=14&columnId=221">客户亲笔感谢信</a>
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
												<div style="color:#333399;" class="div1">
												<br />
												<p style="text-align:center;font-size:18px;font-weight:bold;">客户联谊传真情  冬日体检暖人怀 </p>
												<p style="text-align:right;"> ――2007年度客户联谊会及VIP客户免费体检活动纪实 </p>
												
												<p> &nbsp; &nbsp; &nbsp;“这个寒冷的冬日因为你们（合众人寿）的贴心服务而变得温暖起来”这是一位客户在参加了公司组织的免费体检之后向客服人员道出的真情实感。
												 <br>&nbsp; &nbsp; &nbsp;2007年岁末，为了回馈广大客户，进一步加强公司与客户之间的交流，
												我公司在全系统范围内举行了客户联谊会和VIP客户免费体检活动。
												这是合众人寿自成立以来首次大范围的统一开展的大型客户回馈活动，得到了公司各级领导的高度关注和大力支持，
												各分公司也都以极大的热情投入到此次活动的组织实施中来。
													  <img src="images/index/c2t13_clip_image002.jpg"  width="300" height="159" hspace="12" align="right">
													<br> &nbsp; &nbsp; &nbsp;总公司运营中心把11月定为“合众人寿VIP客户免费体检月”，
													各机构均以丰富多彩的形式举办大型客户联谊会和VIP客户免费体检的系列活动。
													活动旨在更好地维系公司与客户之间的良好关系，为社会大众传递更专业、更科学的健康理念和理财技巧，
													同时提高百姓关注健康、关爱生命的意识。<br>												
											   &nbsp; &nbsp; &nbsp;据了解，各机构根据当地具体情况，在举办客户联谊会时采用了不同的形式，力求凸现多元化、个性化服务特色。其中既有精彩纷呈的专业知识讲座期待客户光临，也有饕餮盛宴静候来宾，内容可谓丰富多样；期间还穿插部分精彩演出节目和抽奖活动，同时也邀请所有参与客户填写客户调查问卷，及时了解广大客户对公司各项服务工作的建议和诉求。与此同时，专门针对个险VIP客户的免费体检活动也一并展开，各分公司先期陆续与入围客户取得联系，进行预约工作；在得到客户确认后，公司会指定当地的专业体检中心或甲等医院为客户提供优质的体检服务，同时医务人员将根据每位客户的身体实际状况给出相应的保健医疗建议。事后公司也专门委派工作人员把客户的体检报告书专程送达给客户本人，力求送上周到而温暖的真情服务。总之，无论是丰富新颖的联谊会内容，还是服务到位的体检过程，无不体现出公司重视服务工作、真心回馈广大客户的一片热忱。
											
												<img src="images/index/c2t13_clip_image006.gif" width="184" height="226" border="0" align="left" hspace="12" style="margin-left:110px;">
												<p>&nbsp; &nbsp; &nbsp;本次活动在12个省市的广大客户中得到了普遍的欢迎和一致的认可。不少客户和业务人员纷纷表示，希望今后公司能多组织类似的活动，增加客户与公司间的交流和互动，将更温馨更实惠的服务项目带给广大的合众客户。从活动组织情况看，各机构均取得了良好的活动效果；联谊会累计参加人数达2146人，前往公司指定机构进行免费体检的客户也愈五百多人，收集客户调查问卷1820件；客户亲笔写就的感谢信是对公司服务的诚挚认可，众多客户的现场签单更是活动举办结出的累累硕果。虽然是首次活动规模有限，但机构工作人员倾情付出和客户们的热情参予，使得整个活动显得更加温暖亲切，各项数据统计结果均超出了预计规模，达到了促进客户与公司沟通交流、拓展业务、拉动万能险续期的初衷，公司首次附加值服务活动取得了成功，也为2007年度的系列客户服务活动画上了一个圆满的句号。
												 <br>
												 &nbsp; &nbsp; &nbsp;此次为期一个多月的系列客服活动，也是合众人寿继今年“5.15全国客户服务宣传日活动”成功举办后的又一项全国性客户服务推广工作。公司希望通过一系列的相关活动，不断拉近公司与客户之间的距离，在加强品牌宣传的同时树立良好企业形象，真正将“合众和你在一起”落到实处。今后，公司客户服务部会更好的将真情服务理念融入各项工作中去，进一步拓展服务方式和服务渠道，力求把客户服务工作做的更细、更好，为全面提升合众人寿的品牌效应和服务水平，打造业内优秀的服务团队不断地做出新的努力！ </p>
												<p style="text-align:right;width:auto;">    （总公司运营中心 客户服务部） </p>
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


<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlTemplate,com.ulic.ulweb.ulweb.entity.UlColumn" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  
<head>
<base href="<%=basePath%>">
<title>代理业务部</title>
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
<style type="text/css">
  	.indexContent td{
	font-family: "宋体";
	font-size: 14px;
	color: #000080;
	line-height: 2;
	
		
	}
	.bolds{
		text-indent: 2em;
		font-family: "宋体";
		font-size: 16px;
		color: #000099;
		font-weight:bold;
	}
	.boldh{		
		font-family: "华文新魏";
		font-size: 18px;
		color: #800080;
		font-weight:bold;
	
	}
	
  </style>
<%
		if(t.getCss() != null){
			out.print(t.getCss());
		}
	 %>
</head>
  	
	
  <body bgcolor="#DDEADD">
<table width="770" cellpadding="0" cellspacing="0" border="0" align="center" bgcolor="#ffffff" >
		<tr><td height="5"></td></tr>
		<tr>
			<td>
				<table id="topImg" cellpadding="0" cellspacing="0" border="0" width="100%">
					<tr>
						
						<td  align="right" valign="top">
							<img src="<%=t.getPic1()%>"  border="0"/>
						</td>
						
						<td  align="left" valign="top">
							<img src="<%=t.getPic2()%>" border="0"/>
						</td>
						
					</tr>
				</table>
			</td>
		</tr>
		
		<tr><td height="15"></td></tr>
		<tr><td></td></tr>
		<tr><td height="5"></td></tr>
		<tr>
			<td>
				<table width="100%" cellspacing="0" cellpadding="0" border="0" align="center" id="mainContent"> 
					<tr>
						<td width="10"></td>
											
						<td width="10"></td>						
						<td  valign="top">
							<table border="0" cellpadding="0" cellspacing="0" width="100%">
								<tr>
									
                <td height="25"  class="title1">代理业务部 </td>
								</tr>
								<tr>
									<td height="10" background="<%=t.getPic3()%>" style="background-repeat:repeat;">
										
									</td>
								</tr>
								<tr>
									<td>
										<table cellpadding="0" cellspacing="0" class="indexContent" border="0" width="100%">
											<tr><td height="5"></td></tr>
											<tr>
												<td width="40" align="right">
													<img src="<%=t.getPic4()%>" border="0" >
													
												</td>
												<td>
													<table width="100%" class="content1" align="center"><tr>
                            <td> <div class="bolds">
                               银行保险释义：</div>
							   银行保险是保险公司通过银行、邮政以及其它金融机构销售网络提供的服务平台以及客户群进行保险理财产品销售的一种销售模式。 
                              随着我国经济持续稳定健康协调发</td></tr></table>
												</td>
											</tr>
											<tr>
												
                      <td colspan="2" class="content2">展 ，保险的功能越来越完善，除了提供传统的医疗、意外保障之外，银行保险产品还具备有教育、养老、投资理财的功能，与其它的金融理财产品相互补充，共同发展，成为现代社会每个家庭不可或缺的一种重要的理财方式。 
                        <div class="bolds">银行保险特点：</div>
													
													
&nbsp;&nbsp;&nbsp;&nbsp;<font class="boldh">手续简便</font>&nbsp;
 银行保险产品在柜面购买，对消费者而言更加方便、快捷；<br>

&nbsp;&nbsp;&nbsp;&nbsp;<font class="boldh">合法安全</font>&nbsp;
银行保险产品是经国家保监会批准，在银行和其他金融机构销售的理财产品，受国家法律保护，消费者的资金合法安全。
<br>

&nbsp;&nbsp;&nbsp;&nbsp;<font class="boldh">收益保障两不误</font>&nbsp;

客户通过银行、邮政等金融机构购买保险产品，降低公司经营成本，产品费率降低，使消费者得到了更多的实惠；并且保险产品在为客户提供满期收益的同时，还提供充足的保障，让客户安枕无忧；

													<div class="bolds">合众人寿代理业务部：</div>
合众人寿代理业务部成立于2005年2月，成立两年以来，与公司共成长，在已开设的十二家分支机构都有飞速的业务发展。目前已与中国工商银行、中国农业银行、中国建设银行、交通银行、邮政储汇局等国有、股份制商业银行和其它金融机构建立了合作关系，搭建了良好的销售、服务平台。已上市产品特色鲜明，投放市场后得到了广大客户的喜爱，赢得了广大客户的良好口碑，也赢得了合作渠道的信任。
2006年合众人寿被中国消费者基金会评为：“维护消费者权益，诚信服务满意单位”。合众人寿代理业务部将继续秉承规范经营、稳健发展、合作双赢的发展方针，立志于发展我国的民族银行保险事业。



												</td>
											</tr>
											
										</table>
									</td>
								</tr>
								<tr>
									<td>
										
									</td>
								</tr>
							</table>
						</td>
						
						
						<td width="10"></td>
						<td width="140" valign="top" align="center">
							
							<table class="list1" align="center" cellpadding="2" cellspacing="" border="0" >
							<tr><td height="40" valign="top"></td></tr>
							<tr><td align="center"><a href="dept/1110/004.gif" target="_blank">部门架构</a> </td></tr>
							<tr><td height="5"></td></tr>
								<%
									for(int i = 0; i < (l == null ? 0 : l.size()); i++){
								%>
								<tr>
									<td align="center">&nbsp;&nbsp;&nbsp;
										<a href="dept2l.do?method=sub1&columnId=<%=l.get(i).getColumnId()%>" ><%=l.get(i).getColumnName()%></a>&nbsp;&nbsp;&nbsp;
									</td>
								</tr>
								<tr><td height="5"></td></tr>
								<%
									}
								%>
								<tr><td height="50"></td></tr>
								<tr>
									<td valign="bottom"  align="right" style="border:none;">
										
									</td>
								</tr>
							</table>
							<br>
            <div> 
              <p><img src="images/index/logo1.jpg" border="0"/> </p>
              <span class="boldh"></span></div>
							
						</td>
						<td width="5"></td>
					</tr>
					
				</table>
			</td>
		</tr>
		<tr><td align="center" valign="top">
			<img src="<%=t.getPic6()%>" border="0"/>
		</td></tr>
		
		<tr>
			<td  width="100%" height="20">
				<iframe src="dept/1110/indexbottom.jsp" height="110" width="100%" frameborder="0" scrolling="no" ></iframe>
			</td>
		</tr>
	</table>
  </body>
</html>

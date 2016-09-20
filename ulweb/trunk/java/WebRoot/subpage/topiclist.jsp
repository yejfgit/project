
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlContentWithAtt,com.ulic.ulweb.ulweb.entity.UlColumn" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>专栏</title>
    
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
  <script  language="JavaScript" src="script/listWithAtt.js"></script>
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
						  <td rowspan="4" valign="top" width="639" background="images/index/qun.jpg" style="background-repeat:no-repeat;"></td>
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
					  </table>
			</td>
		</tr>
		<tr><!--   title    -->
			<td><iframe src="frame/indextitle.jsp" width="760" height="40" frameborder="0" scrolling="no" ></iframe>
			</td>
		</tr>
		<tr><!-- 		titlepic		-->
			<td align="center"></td>
		</tr>
		<tr>
			<!--			content			-->
			<td >
					<table width="100%" style="border-right: gray 1px solid;" >
						<tr>
							<td></td>
							<td width="2%"></td>
							<td width="68%"></td>
						</tr>
						<tr>
							<td width="30%" valign="top">
								<table width="100%" style="border: gray 1px solid;">
									
									<tr valign="bottom"><td align="center"><img src="images/index/xiezuo.jpg" border="0" width="220" /></td>
									</tr>
								
									<tr valign="bottom">
								
							  </tr>
								</table>
							</td>
							<td></td>
							  <td valign="top">
							  		<table border="0" width="100%" >
										<tr>
											<td colspan="5" align="center">
												<font color="#FF3333" style="font-size:20px"><strong>专栏</strong>
												</font>
											</td>
										</tr>

												<td colspan="5"><div>
												  <table width="100%" border="0" cellspacing="0" cellpadding="0">


		 <tr >           
                <td  colspan="2"  height="25" valign="middle" align="center" class="9green1" >
				 	<a href='list.do?method=zongbu&ptype=25&columnId=814'>党务工作专栏</a>
				</td>
        </tr>
		 <tr > 
		 
		 
		 <tr >           
                <td  colspan="2"  height="25" valign="middle" align="center" class="9green1" >
				 	<a href='list.do?method=zongbu&scid=627&ptype=21&columnId=607'>2008服务年专栏</a>
				</td>
        </tr>
		 <tr >           
                <td  colspan="2"  height="25" valign="middle" align="center" class="9green1" >
				 	<a href='list.do?method=zongbu&ptype=1&columnId=587'>管理干部培训资料</a>
				</td>
        </tr>
			
		 <tr >           
                <td  colspan="2"  height="25" valign="middle" align="center" class="9green1" >
				 	<a href='list.do?method=zongbu&ptype=19&columnId=527&scid=549'>2008合众助学行</a>
				</td>
        </tr>
		<tr > 
                <td  colspan="2"  height="25" valign="middle" align="center" class="9green1" >
					<a href='list.do?method=zongbu&ptype=15&columnId=427'>抗震救灾，我们在行动</a>
				</td>
        </tr>	
		
		 <tr > 
                <td  colspan="2"  height="25" valign="middle" align="center" class="9green1" >
					<!--<a href='list.do?method=zongbu&ptype=11&columnId=53'>合众人寿首届高峰会</a>-->
<a href='market.do?method=subPage1&columnId=667'>早安合众</a>
				</td>
        </tr>		 
	   
		 <tr >           
                <td  colspan="2"  height="25" valign="middle" align="center" class="9green1" >
				 	<a href='list.do?method=zongbu&ptype=1&columnId=70'>财务大集中专栏</a>
				</td>
        </tr>
		
		 <tr >           
                <td  colspan="2"  height="25" valign="middle" align="center" class="9green1" >
				 	<a href='list.do?method=zongbu&ptype=31&columnId=907'>2008客服活动专栏二</a>
				</td>
        </tr>

		 <tr >           
                <td  colspan="2"  height="25" valign="middle" align="center" class="9green1" >
				 	<a href='zhixing.do?method=index&ct1=0' target="_blank">2009执行年专栏</a>
				</td>

        </tr>
		 <tr >           
                <td  colspan="2"  height="25" valign="middle" align="center" class="9green1" >
				 	<a href='list.do?method=zongbu&ptype=1&columnId=1630' target="_blank">五周年征文活动专栏</a>
				</td>


        </tr>

                                                 </table>
												
												
												
												</div></td>

											</tr>		
											<tr><td align="left" colspan="5"></td></tr>							
									</table>
							  
							  
							  
							   </td>
						</tr>
						
					</table>
			</td>
		</tr>
		<tr>
			<td>
				<jsp:include page="../frame/indexbottom.jsp" />
			</td>
		</tr>
		<tr><td height="30"></td></tr>
	</table>
   
   
  </body>
</html>

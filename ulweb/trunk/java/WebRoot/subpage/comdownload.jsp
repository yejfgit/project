
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.ulweb.entity.UlColumn" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
   
    <title>合众人寿</title>
    
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
  <script  language="JavaScript" src="script/list.js"></script>
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
						  <td rowspan="4" valign="top" width="639" background="images/index/shuye.jpg" style="background-repeat:no-repeat;"></td>
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
												
                      <td>&nbsp; </td>
											</tr>
											
										</table>								
									</td></tr>
									<tr><td height="15"></td></tr>
									
									<tr><td></td></tr>
									<tr valign="bottom"><td align="center">
										<img src="images/index/qianbi.jpg" border="0" width="220" /></td></tr>
									<tr><td height="10"></td></tr>
									<tr valign="bottom">
								<td align="center" >&nbsp; </td>
							  </tr>
								</table>
							</td>
							<td></td>
							  <td valign="top">
							  		<table border="0" width="100%" >
										<tr>
											
                <td  colspan="3" align="center"> <font color="#FF3333" style="font-size:20px">品牌宣传资料下载
                  </font> </td>
					</tr>
					
					
                    <tr> <td width="10%"></td>
                      <td height="20" valign="middle" bgcolor="#FFFFFF"><a href="tools/doc/design_requirement.doc" target="_blank">设计需求表</a></td>
                   <td width="10%"></td>
					 </tr>
                    <tr> <td width="10%"></td>
                      <td height="20" valign="middle" bgcolor="#FFFFFF"><a href="tools/070407/00000034.doc" target="_blank">分公司筹备品牌指导手册</a></td>
                   <td width="10%"></td>
					 </tr>
                    <tr> <td width="10%"></td>
                      <td height="20" valign="middle" bgcolor="#FFFFFF"><a href="tools/070416/VI.rar">VI下载</a>
					
                      </td><td width="10%"></td>
                    </tr>	
									
					 <tr> <td width="10%"></td>
                      <td height="20" valign="middle" bgcolor="#FFFFFF"><a href="tools/070416/VI_logo.rar" >VI元素(logo)</a> 
                      </td><td width="10%"></td>
                    </tr>
						
					 <tr> <td width="10%"></td>
                      <td height="20" valign="middle" bgcolor="#FFFFFF"><a href="tools/070416/ad.rar" >广告下载</a> 
                      </td><td width="10%"></td>
                    </tr>
					 <tr> <td width="10%"></td>
                      <td height="20" valign="middle" bgcolor="#FFFFFF"><a href="tools/070416/design.rar" >设计流程规范</a> 
                      </td><td width="10%"></td>
                    </tr>
				
					<tr> <td width="10%"></td>
                      <td height="20" valign="middle" bgcolor="#FFFFFF"><a href="tools/070416/rongyu.rar" >公司荣誉奖项</a> 
                      </td><td width="10%"></td>
                    </tr>
					<tr> <td width="10%"></td>
                      <td height="20" valign="middle" bgcolor="#FFFFFF"><a href="tools/doc/jianjie.doc" >公司简介</a> 
                      </td><td width="10%"></td>
                    </tr>
							
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

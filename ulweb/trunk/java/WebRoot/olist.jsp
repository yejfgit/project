<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="struts-bean.tld" prefix="bean"%>
<%@ taglib uri="struts-html.tld" prefix="html"%>
<%@ taglib uri="struts-logic.tld" prefix="logic"%>
<%@ taglib uri="ulweb-list.tld" prefix="ulweb"%>

<%

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
			
	String enName = request.getParameter("eId");
	String keyWord = request.getParameter("keyWord");
	String strId = request.getParameter("id");
	String strPage = request.getParameter("pageNum");
	
	int columnId;
	try {
		columnId = Integer.parseInt(strId);
	} catch (Exception e) {
		columnId = 0;
	}
	
	int pageNum;
	try {
		pageNum = Integer.parseInt(strPage);
	} catch (Exception e) {
		pageNum = 1;
	}	


%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
   
    <title><ulweb:navbar beanName="nb"  deptId="0000" enName="<%=enName%>" columnId="<%=columnId %>" />
<bean:write name="nb" /></title>
    
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
  <script language="JavaScript" src="script/list.js"></script>
  
<style>
li {line-height: 20px; list-style: none; }


</style>
  
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
              							        <td>
													<table border="0" width="100%" cellspacing="0">														
														<tr>
															<td align="center" style="color:#ff6600;font-size:14px;border-bottom: 1px gray solid;"  >
&nbsp;&nbsp;																
<ulweb:column beanName="sl" deptId="0000" enName="<%=enName %>" columnId="<%=columnId %>" withSub="1" />
<bean:write name="sl" property="columnName" />		

<logic:iterate id="element" name="sl" property="subColumns">
	<li>
		<a href="list.jsp?id=<bean:write name="element" property="columnId" />"><bean:write name="element" property="columnName" /></a>
	</li>
</logic:iterate>


																
															</td>
														</tr>
														<tr><td>
														
														
														
														</td></tr>
													</table>
												
												</td>
											</tr>
											
										</table>								
									</td></tr>
									<tr><td height="15"></td></tr>
									
									<tr><td></td></tr>
									<tr valign="bottom"><td align="center">
										<img src="images/index/computer.jpg" border="0" width="220" /></td></tr>
									<tr><td height="10"></td></tr>
									<tr valign="bottom">
								<td align="center" >&nbsp; </td>
							  </tr>
								</table>
							</td>
							<td></td>
							  <td valign="top">
							  		<table border="0" width="100%" >
										<tr><td valign="top" style="font-weight: bold; color: #ff0000">
										
<bean:write name="nb" />
<br>
</td></tr>


<!-- Description Begin -->
<tr><td colspan="5" align="right">打开pdf文件可使用：pdfshare  &nbsp;&nbsp;&nbsp;密码：pdfshare &nbsp;&nbsp;&nbsp;
											<br />
												pdf阅读器下载:<a href="http://it/service/itshare/AdbeRdr70_enu.rar" target="_blank" class=9b style="color:#0000FF">Acrobat Reader7.0 安装软件</a>
												</td>
										</tr>
										<tr><td>&nbsp;</td></tr>
<!-- Description End -->


<tr>
											<td colspan="5" align="center">
												<font color="#FF3333" style="font-size:20px"><strong></strong>
												</font>
											</td>
										</tr>
										 
											<tr>
											<td>
											
<ulweb:content beanName="cl" deptId="0000"
												enName="<%=enName%>"
												columnId="<%=columnId %>"
												keyWord="<%=keyWord %>"
												conditions="isDelete=0:i;isProcessing=0:i;"
												pageNum="<%=pageNum %>" />

		<logic:iterate id="element" name="cl" property="objectList">
		<li>
			<bean:write name="element" property="contentNameLink" filter="false" />&nbsp;&nbsp;
			<bean:write name="element" property="uploadTime" format="yyyy-MM-dd" />&nbsp;&nbsp;&nbsp;&nbsp;
			<bean:write name="element" property="attachmentLink" filter="false" />
		</li>
		</logic:iterate>
											
</td>
<tr><td>
<br>
<bean:write name="cl" property="pageTag" filter="false" />	
											
												</td>
											
											</tr>									
									</table>
							  
							  
							  
							   </td>
						</tr>
						
					</table>
			</td>
		</tr>
		<tr>
			<td>
				<jsp:include page="frame/indexbottom.jsp" />
			</td>
		</tr>
		<tr><td height="30"></td></tr>
	</table>
   
   
  </body>
</html>

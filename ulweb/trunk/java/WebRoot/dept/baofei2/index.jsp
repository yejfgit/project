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
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>首页 - 保费部</title>
		<style type="text/css">
<!--

-->
</style>
		<link href="dept/baofei2/main.css" rel="stylesheet" type="text/css" />
		<script src="dept/baofei2/main.js"></script>
	</head>

	<body>
		<table width="800" border="0" align="center" cellpadding="0"
			cellspacing="0" bgcolor="#FFFFFF">

<jsp:include flush="true" page="head.jsp"></jsp:include>

			<tr>
				<td>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="67%" align="center" valign="middle" style="padding: 3px">

								<!-- newsAd Begin -->
								<script language="javascript">
var imgUrl=new Array();
var imgLink=new Array();
var text=new Array();
var adNum=0;
var buttonShow=1;
var buttonPos=2; //RU:1，RD:2，LU:3，LD:4



<ulweb:content beanName="cl" deptId="baofei" enName="tupian" conditions="isDelete=0:i;isProcessing=0:i;" withAtt="1" />
<% int index=1; %>
<logic:iterate id="element" name="cl" property="objectList">

	<logic:notEmpty name="element" property="attachmentList">
		<logic:iterate id="e" name="element" property="attachmentList">
imgUrl[<%=index%>]="<bean:write name="e" property="displayPath" filter="false" />";
imgLink[<%=index%>]="<bean:write name="element" property="subTitle" filter="false" />";
text[<%=index%>]="<bean:write name="element" property="keyWord" filter="false" />";			
<% index++; %>
		</logic:iterate>
	</logic:notEmpty>
</logic:iterate>




</script>
								<script language="javascript" src="dept/baofei2/newsAd.js"></script>
								<table id=newsTable border="0" cellspacing="0" cellpadding="0" style="border: solid 1px #CCCCCC; ">
									<script language="javascript">dakularButtons();</script>
									<tr>
										<td>
											<a
												onMouseOver="displayStatusMsg();return document.returnValue"
												onMouseOut="status='';" class=px14-lh24
												href="javascript:jump2url()"><img
													style="FILTER: revealTrans(duration=1,transition=23); border:0px solid #000000"
													src="javascript:nextAd()" width=530 height=370 border=0
													name=imgUrlrotator alt=""> </a>
										</td>
									</tr>
								</table>
								<!-- newsAd End -->

							</td>
							<td width="33%">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="25" bgcolor="#C0C0C0" class="index_col_title">
											部门快讯
										</td>
									</tr>
									<tr>
										<td height="100" valign="top" bgcolor="#EDEDED">
											<ul>
												<ulweb:content beanName="kx" deptId="baofei"
													enName="kuaixun" conditions="isDelete=0:i;" pageSize="3" />

												<logic:iterate id="element" name="kx" property="objectList">
													<li>
			<bean:write name="element" property="contentNameLink" filter="false" />
			<bean:write name="element" property="new" filter="false" />&nbsp;&nbsp;&nbsp;&nbsp;
			
			<bean:write name="element" property="attachmentLink" filter="false" />
																	

													</li>
												</logic:iterate>
											</ul>
										</td>
									</tr>
									<tr>
										<td height="25" bgcolor="#C0C0C0" class="index_col_title">
											业绩播报
										</td>
									</tr>
									<tr>
										<td height="100" valign="top" bgcolor="#EDEDED">
											<ul>
												<ulweb:content beanName="sb" deptId="baofei" enName="bobao"
													conditions="isDelete=0:i;" pageSize="4" />

												<logic:iterate id="element" name="sb" property="objectList">
													<li>
																<bean:write name="element" property="contentNameLink" filter="false" />
																<bean:write name="element" property="new" filter="false" />&nbsp;&nbsp;&nbsp;&nbsp;
			<bean:write name="element" property="attachmentLink" filter="false" />
													</li>
												</logic:iterate>
											</ul>
										</td>
									</tr>
									<tr>
										<td height="25" bgcolor="#C0C0C0" class="index_col_title">
											竞赛追踪
										</td>
									</tr>
									<tr>
										<td height="100" valign="top" bgcolor="#EDEDED">
											<ul>
												<ulweb:content beanName="zz" deptId="baofei"
													enName="zhuizong" conditions="isDelete=0:i;" pageSize="3" />

												<logic:iterate id="element" name="zz" property="objectList">
													<li>
																<bean:write name="element" property="contentNameLink" filter="false" />
																<bean:write name="element" property="new" filter="false" />&nbsp;&nbsp;&nbsp;&nbsp;
			<bean:write name="element" property="attachmentLink" filter="false" />
													</li>
												</logic:iterate>
											</ul>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>


<jsp:include flush="true" page="foot.jsp"></jsp:include>

		</table>




	</body>
</html>

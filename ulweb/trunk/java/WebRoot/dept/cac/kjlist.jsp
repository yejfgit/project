
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

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.ulweb.entity.UlAttachment,com.ulic.ulweb.frame.constant.Constant,com.ulic.ulweb.ulweb.web.action.IndexAction" pageEncoding="UTF-8"%>
<title>
<ulweb:navbar beanName="nb"  deptId="cac" enName="<%=enName%>" columnId="<%=columnId %>" />
<bean:write name="nb" /></title>
 <base href="<%=basePath%>" />
<link href="css/main.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="dept/peixun3/ycsf_css.css">
<script language="JavaScript" src="script/list.js"></script>
<script language="JavaScript" type="text/JavaScript">

</script>

<script type="text/javascript" language="JavaScript1.2" src="dept/peixun3/images/stm31.js"></script><style>
.st_tbcss,.st_tdcss,.st_divcss,.st_ftcss{border:none;padding:0px;margin:0px;}
.STYLE1 {
	color: #FF0000;
	font-weight: bold;
}
.STYLE2 {color: #FFFFFF}
.STYLE3 {color: #FFFFFF; font-weight: bold; }
</style></head>
<body  style="background-color: #eee" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<table style="background-color: #eee" width="100%"  border="0" cellspacing="0" cellpadding="0">
	<tbody><tr>
		<td align="center">
<table width="980px" border="0" cellspacing="0" cellpadding="0" style="background-color: #fff">
  <tbody><tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0" >
      <tbody><tr>
       <td width="300" height="145" background="dept/cac/images/newBg_2Picture.png" >
						</td>
						<td width="680" height="145" background="dept/cac/images/newBgpicture2.png">
						</td>
        </tr>
    </tbody></table></td>
  </tr>
  <tr>
    <td><table width="980px" border="0" cellspacing="0" cellpadding="0" style="background:url(dept/cac/images/newHead.png);">
      <tbody><tr>
				        <td width="112px" height="33px" align="center"><a href="cacCheck.do?method=index" target="_self"><font color="#ffffff" style="font-size:16px;font-family:宋体"><strong>首页</strong></font></a></td>
				        <td  width="112px" height="33px" align="center"><a href="dept/cac/kjlist.jsp?id=5664" target="_self"><font color="#ffffff" style="font-size:16px;font-family:宋体"><strong>部门介绍</strong></font></a></td>
				        <td  width="112px" height="33px" align="center"><a href="dept/cac/kjlist.jsp?id=5484" target="_self"><font color="#ffffff" style="font-size:16px;font-family:宋体"><strong>中心汇</strong></font></a></td>
				        <td width="112px" height="33px" align="center"><a href="dept/cac/kjlist.jsp?id=5485" target="_self"><font color="#ffffff" style="font-size:16px;font-family:宋体"><strong>集中云</strong></font></a></td>
				        <td  width="112px" height="33px" align="center"><a href="dept/cac/kjlist.jsp?id=5486" target="_self"><font color="#ffffff" style="font-size:16px;font-family:宋体"><strong>风采秀</strong></font></a></td>
				        <td  width="112px" height="33px" align="center"><a href="dept/cac/kjlist.jsp?id=5504" target="_self"><font color="#ffffff"style="font-size:16px;font-family:宋体"><strong>知识窗</strong></font></a></td>
				        <td  width="112px" align="center"><a href="dept/cac/kjlist.jsp?id=5506" target="_self"><font color="#ffffff" style="font-size:16px;font-family:宋体"><strong>数据库</strong></font></a></td>
					    <td  width="170px" height="33px" align="right">
						<script language="JavaScript" type="text/JavaScript">
							var day="";
							var month="";
							var ampm="";
							var ampmhour="";
							var myweekday="";
							var year="";
							mydate=new Date();
							myweekday=mydate.getDay();
							mymonth=mydate.getMonth()+1;
							myday= mydate.getDate();
							myyear= mydate.getYear();
							year=(myyear > 200) ? myyear : 1900 + myyear;
							if(myweekday == 0)
							weekday=" 星期日 ";
							else if(myweekday == 1)
							weekday=" 星期一 ";
							else if(myweekday == 2)
							weekday=" 星期二 ";
							else if(myweekday == 3)
							weekday=" 星期三 ";
							else if(myweekday == 4)
							weekday=" 星期四 ";
							else if(myweekday == 5)
							weekday=" 星期五 ";
							else if(myweekday == 6)
							weekday=" 星期六 ";
							document.write("<font color= #ffffff style= font-size:12px;font-family:宋体>"+year+"年"+mymonth+"月"+myday+"日 "+weekday+"</font>");
						</script></td>
					</tr>
    </tbody></table></td>
  </tr>
  <tr style="height:25px;">
    <td width="100%">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" style="background-color: #fff;height:23px;">
			<tr>
				<td width="3%" align="right"><img src="dept/cac/images/arrow3.gif"></td>
				<td width="97%" align="left">&nbsp;<span style="width: 100px; padding: 0px 0px; color: #000000;font-size:14px;font-family:宋体">您现在的位置：</span><span style="color: #000000;font-size:14px;font-family:宋体"><ulweb:navbar beanName="nb"  deptId="cac" enName="<%=enName%>" columnId="<%=columnId %>" /></span>
<bean:write name="nb" /></td>	
			</tr>
		</tbody></table>
	</td><td>
  </td></tr>
</table>
<table style="width:980px;cellspacing:0px;cellpadding:0px; border-right:gray 0px solid;margin-top:0px">
	<tbody><tr valign="top">
		<td  >
		<!----------正文左栏---------------->
			<table width="100%" border="0" cellspacing="0" cellpadding="0" style="background-color: #fff" >
				<tbody>
				<tr ><td height="2px"></td></tr>
				<tr>
					<td background="dept/cac/images/newHead.png" width="233px" height="29px" align="center" > 
						<font color= #ffffff size="4"><strong>栏&nbsp;&nbsp;目&nbsp;&nbsp;导&nbsp;&nbsp;航</strong></font>
					</td>
				</tr>
				<tr>
					<td  style="border:solid 1px #eee;border-top:solid 0px gray;height:560px;width:230px; valign:top" valign="top" align="center">
					
					<ulweb:column beanName="sl" deptId="cac" enName="<%=enName %>" columnId="<%=columnId %>" withSub="1" />
					<div class="men"><font style="font-size:12px;font-family:宋体"><strong id="g"><bean:write name="sl" property="columnName" /></strong></font></div>		
					<ul class="menli">
					<logic:iterate id="element" name="sl" property="subColumns">
					<li id="g">·<a href="dept/cac/kjlist.jsp?id=<bean:write name="element" property="columnId" />"><bean:write name="element" property="columnName" /></a>
					</li>
					</logic:iterate>
					</ul>
				</td></tr>
			</tbody></table>
		</td>
		<td width="750px" valign="top" >
		<!----------正文右栏---------------->
			<table width="100%" border="0" cellspacing="0" cellpadding="0" >
				<tbody><tr>
					<td width="750px">
					
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tbody><tr>
								<td background="dept/cac/images/button_9.gif" width="750px" height="32px">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tbody><tr>
											<td width="180" align="center"><font color="#ffffff"><strong><ulweb:navbar beanName="nb"  deptId="cac" enName="<%=enName%>" columnId="<%=columnId %>" /></strong></font></td>
											<td></td>
										</tr>
									</tbody></table>
								</td>
							</tr>
							<tr>
							<td>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tbody><tr>
										<td background="dept/cac/images/Article_class_22_10.gif" width="750" align="left" valign="top" height="550px">
											<table width="98%" border="0" cellspacing="0" cellpadding="0">
												<tbody><tr>
													<td width="6"></td>
													<td>
													<div class="newlist">


<DIV class="con">
<ul>


<ulweb:content beanName="cl" deptId="cac"
												enName="<%=enName%>"
												columnId="<%=columnId %>"
												keyWord="<%=keyWord %>"
												conditions="isDelete=0:i;isProcessing=0:i;"
												pageNum="<%=pageNum %>" />

		<logic:iterate id="element" name="cl" property="objectList">
			<li>
			·<bean:write name="element" property="contentNameLink" filter="false" />&nbsp;&nbsp;
			<bean:write name="element" property="new" filter="false" />&nbsp;&nbsp;
			<bean:write name="element" property="attachmentLink" filter="false" /><span class="fri">[<bean:write name="element" property="uploadTime" format="yyyy-MM-dd" />]</span></li>
		</logic:iterate>
<bean:define id="cid" name="element" property="columnId" />

<% if (enName == null && columnId == 0) { %>
<ulweb:column beanName="cc" deptId="cac" columnId="<%=Integer.parseInt(cid.toString()) %>" />
[&nbsp;<bean:write name="cc" property="columnName" />&nbsp;]	
<% } %>

</ul>

<!--next-->
<DIV class="next"><bean:write name="cl" property="pageTag" filter="false" />	</DIV>
<!--next-->

</DIV>


</div>
													</td>
												</tr>
											</tbody></table>
										</td>
									</tr>
									<tr><td background="dept/cac/images/Article_class_22_11.gif" width="750" height="14"></td></tr>
								</tbody></table>
							</td>
							</tr>
						</tbody></table>
					
					</td>
				</tr>
			</tbody></table>


		</td>
	</tr>
</tbody></table>
</td></tr></tbody></table></body></html>
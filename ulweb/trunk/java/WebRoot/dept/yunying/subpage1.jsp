
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlTemplate,com.ulic.ulweb.ulweb.entity.UlColumn,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.ulweb.entity.UlContentWithAtt,com.ulic.ulweb.ulweb.util.DisplayOnPage" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<HTML>
<HEAD>
<TITLE>运营中心</TITLE>

<link rel="stylesheet" href="style/ul.css" type="text/css" /> 

<%
		UlTemplate t = (UlTemplate)request.getAttribute("template");
		DisplayOnPage d = new DisplayOnPage();
		d.setRequest(request);
//		UlColumn pc = (UlColumn)request.getAttribute("parentColumn");
		UlColumn c = (UlColumn)request.getAttribute("column");
	%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style>
p{
	margin:0px ;
	padding:5px 0px 5px 10px;
	border-bottom:2px #e6e6e6 solid;	
}

div{width:100%; color:#7AABAC;}
</style>
</HEAD>
<script type="text/javascript" src="script/yunying.js"></script>
<script language=javascript>
function openwin(url,winname)
{
    //window.open(url,winname,"width=600,height=500,scrollbars=yes,resizable=yes");    //共用一个窗口
    window.open(url,"","width=600,height=500,scrollbars=yes,resizable=yes,top=10,left=100");    //开多个窗口
}
function openwinfull(url)
{
    //window.open(url,winname,"width=600,height=500,scrollbars=yes,resizable=yes");    //共用一个窗口
    window.open(url,"","width=" + (screen.width - 30) + ",height=" + (screen.height - 30) + ",scrollbars=yes,resizable=yes,top=10,left=10");    //开多个窗口
}
</SCRIPT>
<body bgcolor="#E6E6E6">
<center>	
	<div style="width:780px;">
		<div style="background-color:#ffffff;">
			<table width="100%" cellpadding="0" cellspacing="0"><tr><td align="left" width="420">
			<img src="images/yunying/hezong.jpg" border="0"  align="left">
			</td><td align="right" valign="middle" style="padding-right:30px; font-size:48px; color:#5d5d5d; font-family:'黑体';">
			<%=c.getColumnName()%>
			</td></tr></table>
		</div>
		<div style="background-color:#FFFFFF; height:500px; text-align:left;">
		
		<hr  color="#E6E6E6">
		<%if(c.getColumnId() == 370){%>
		
		<p>■<a target='_blank' href='yunying.do?method=subPage1&columnId=467&ptype=tt' style='color:#000000'> 客户服务指南</a></p>
		
		<%}%>
			<%=d.divContentYunying("contentList",3,"","■")%>
			


			
					
		<%if(c.getColumnId() == 371){%>
		
		<div style="padding: 0px 100px 0px 0px;">
		<div style="text-align: center; width:150px; padding: 5px ;float: left;">
			<a target='_blank' href='show.do?c=29319&a=1'><img src="images/yunying/zdjbsc.jpg" border="0"></a>
<br>
用户名：pdfshare<br>
密码：pdfshare		
</div>

<div style="text-align: center; width:150px; padding: 5px;float: left">
			<a target='_blank' href='yunying.do?method=subPage1&columnId=2345'><img src="images/yunying/hbxsy.jpg" border="0"></a>

</div>

</div>
		
		<%}%>

			<%=d.toPage(1)%>			
		</div>

		
	</div>
	
</center>
</body>
</HTML>
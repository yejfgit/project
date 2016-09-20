
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
		UlColumn pc = (UlColumn)request.getAttribute("parentColumn");
		UlColumn c = (UlColumn)request.getAttribute("column");
		List<UlColumn> l = (List<UlColumn>)request.getAttribute("columnList");
	%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style>
p{
	margin:0px ;
	padding:5px 0px 5px 10px;
	border-bottom:2px #e6e6e6 solid;	
}

div{width:100%; color:#7AABAC;background-color:#ffffff;}
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
		<div style="">
			<table width="100%" cellpadding="0" cellspacing="0"><tr><td align="left" width="420">
			<img src="images/yunying/hezong.jpg" border="0"  align="left">
			</td><td align="right" valign="middle" style="padding-right:30px; font-size:48px; color:#5d5d5d; font-family:'黑体';">
			<%=pc.getColumnName()%>
			</td></tr></table>
		</div>
		<div>
		<hr  color="#E6E6E6">
			<table width="760" cellpadding="0" height="20" align="center" cellspacing="0" border="0" class="toptable1">
              <tr>            
               	<%
					for(int i = 0; i < (l == null ? 0 : l.size()); i++){
				%>
                <td width="80" align="center" style="border-left:2px #7aabac solid;"> 
                  <a href="yunying.do?method=subPage2&columnId=<%=l.get(i).getColumnId()%>" style=" font-weight:bold; color:#7aabac"><%=l.get(i).getColumnName()%></a> 
                </td>
				<%
					}
				%>
				<td>&nbsp;</td>
				</tr>
			</table>
		</div>
		<div style=" height:500px; text-align:left;">
		
		<hr  color="#E6E6E6">
		
			<%=d.divContentYunying("contentList",3,"","■")%>
			
			<br><br>
			
			<%=d.toPage(2)%>
		</div>
	</div>
</center>
</body>
</HTML>
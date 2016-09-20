
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlTemplate,com.ulic.ulweb.ulweb.entity.UlColumn,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.ulweb.entity.UlContentWithAtt,com.ulic.ulweb.ulweb.util.DisplayOnPage" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<HTML>
<HEAD>
<TITLE>培训部主页</TITLE>

<link rel="stylesheet" href="style/ul.css" type="text/css" /> 
<link rel="stylesheet" href="dept/peixun/peixun.css" type="text/css" />

<%
		UlTemplate t = (UlTemplate)request.getAttribute("template");
		DisplayOnPage d = new DisplayOnPage();
		d.setRequest(request);
	//	UlColumn pc = (UlColumn)request.getAttribute("parentColumn");
		UlColumn c = (UlColumn)request.getAttribute("column");
	%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style>
p{
	margin:0px;	
}
.subcolumn div{
	
	text-align:left;
	padding:5px 0px 0px 20px;	
	
}
</style>
</HEAD>
<script type="text/javascript" src="script/peixun.js"></script>
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
<body   style="background-image:url('images/peixun/bg.gif');margin-top:-20px;">
<center>	
	<div style="width:778px;height:13px;background-color:#ff9900;"></div>
	<div style="width:778px;background-color:#ffcc33;">
		 <table width="100%" height="120" cellpadding="0" cellspacing="0" border="0">  
              <tr> 
                <td width="230" height="83" align="center"><img src="images/peixun/titleLogo.jpg" /></td>
                <td width="548" height="120" rowspan="2" bgcolor="#ffcc33" ><img src="images/peixun/renyuan.jpg" border="0" width="548" height="120"></td>
              </tr>
              <tr> 
                <td width="230" height="37" align="center"> <SCRIPT>
					today=new Date();
					var day; var date; 
					hour=new Date().getHours();
					if(today.getDay()==0)day='星期日'
					else if(today.getDay()==1)day='星期一'
					else if(today.getDay()==2)day='星期二'
					else if(today.getDay()==3)day='星期三'
					else if(today.getDay()==4)day='星期四'
					else if(today.getDay()==5)day='星期五'
					else if(today.getDay()==6)day='星期六'
					dateMD=(today.getMonth() + 1 )+'月'+today.getDate()+'日';
					dateMD2=(today.getYear())+'-'+(today.getMonth() + 1 )+'-'+today.getDate()+'';
					date=(today.getYear())+'年'+(today.getMonth() + 1 )+'月'+today.getDate()+'日';
					document.write(date + ' ' + day + ' ' );
					</SCRIPT> 				<br />					</td>
              </tr>
            </table>
	</div>
	<div style="width:778px;height:13px;background-color:#ff9900;"></div>	
	<div style="width:778px;height:30px;background-color:#ffcc33;"></div>		
	<div style="width:778px; background-color:#ffffff; ">
		<table width="778" height="600" cellpadding="0" cellspacing="0" border="0"  background="images/peixun/trs.gif" style="background-repeat:no-repeat">
<tr><td height="38" colspan="3"></td></tr>
<tr valign="top">
	
	<td valign="top" align="right" colspan="3" height="40">
		<table cellspacing="0" cellpadding="0" border="0">
			<tr>
				<td width="30" height="30"><img src="images/peixun/rl.jpg"></td>
				  <td align="center" valign="middle" width="60" bgcolor="#FF9933" ><a href="peixun.do?method=index">
				  	<font class="sTitlel3" color="#FFFFFF" >首页</font></a></td>
				
					 <td align="center" valign="middle" width="65" bgcolor="#FF9933" >
				  <a href="peixun.do?method=subPage1&columnId=298" ><font class="sTitlel3" color="#FFFFFF" >机构之声</font></a></td>
				  <td align="center" valign="middle" width="65" bgcolor="#FF9933" >
				  <a href="peixun.do?method=subPage1&columnId=274" ><font class="sTitlel3" color="#FFFFFF" >文件通知</font></a></td>
				  <td align="center" valign="middle" width="65" bgcolor="#FF9933" >
				  <a href="peixun.do?method=subPage1&columnId=278" ><font class="sTitlel3" color="#FFFFFF">培训之窗</font></a></td>
				  <td align="center" valign="middle" width="65" bgcolor="#FF9933" >
				  <a href="peixun.do?method=subPage1&columnId=283"><font class="sTitlel3" color="#FFFFFF">教学园地</font></a></td>
				  <td align="center" valign="middle" width="65" bgcolor="#FF9933">
				  <a href="peixun.do?method=subPage1&columnId=287" ><font class="sTitlel3" color="#FFFFFF">训练家园</font></a></td>
				  <td align="center" valign="middle" width="65" bgcolor="#FF9933" >
				  <a href="peixun.do?method=subPage1&columnId=290" ><font class="sTitlel3" color="#FFFFFF">培训管理</font></a></td>
				  <td align="center" valign="middle" width="65" bgcolor="#FF9933" >
				  <a href="peixun.do?method=subPage1&columnId=296" ><font class="sTitlel3" color="#FFFFFF">考试专栏</font></a>	
				</td>
      				<td><img src="images/peixun/rr.jpg"></td>
			</tr>
		</table>
	</td>
</tr>
	<tr>
		<td width="200" align="center" valign="top">
			<table cellpadding="0" cellspacing="0" border="0">
				
				
				<tr>
					<td align="center">
						<img src="images/peixun/withyou.gif" width="170">		
					</td>
				</tr>
			</table>
			
		</td>
		<td width="50"></td>
		<td width="538" valign="top">
			<table width="550" cellpadding="5" cellspacing="0" border="0">
				<tr><td height="20"></td></tr>
				<tr>
					<td>
						<font class="sTitlel3" color="#FF0000"><%=c.getColumnName()%></font>
					</td>
				</tr>
				<tr><td height="5"></td></tr>
				<tr>
					<td>
						<%=d.divContent("contentList",0)%>
					</td>
				</tr>
				<tr><td height="20"></td></tr>
				<tr>
					<td>
						<%=d.toPage(1)%>
					</td>
				</tr>
			</table>
		</td>
	</tr>	
</table>
		
	</div>
</center>
</body>
</HTML>
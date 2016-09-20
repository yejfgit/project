
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlTemplate,com.ulic.ulweb.ulweb.entity.UlColumn,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.ulweb.entity.UlContentWithAtt,com.ulic.ulweb.ulweb.util.DisplayOnPage" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<HTML>
<HEAD>
<TITLE>营销部主页</TITLE>

<link rel="stylesheet" href="style/ul.css" type="text/css" /> 
<link rel="stylesheet" href="dept/market/market.css" type="text/css" />
<style>
.columnlist{
	float:left;
	width:23%;
	padding:15px 0px 0px 20px;
}
.columnlist div{
	width:100%;
	text-align:left;
	padding:5px 0px 5px 10px;
}
.contentlist p{
	margin:0px;
	width:100%;
	height:20px;
	padding:0px 0px 0px 15px;
	background-image:url("images/market/main_personal_button03.gif");
	background-repeat:no-repeat;
	background-position:0px 2px;
}
</style>


<%
		UlTemplate t = (UlTemplate)request.getAttribute("template");
		UlColumn c = (UlColumn)request.getAttribute("column");
		DisplayOnPage d = new DisplayOnPage();
		d.setRequest(request);
		
	%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

</HEAD>
<script type="text/javascript" src="script/market.js"></script>
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
<body  >
<center>
<div style="width:950px;">
	<div style="background-image:url('images/budongchan/head.jpg');height:145px;width:100%;">
	</div>
	


<!----      菜单  ---->
	<div style="width:100%;background-image:url('images/market/mail_top_bg_1.png');float:left;height:20px;">
	<div style="width:60%;float:left;padding:5px 0px 3px 0px;text-align:top;font-size:16px;" class="menu1">
		<div style="width:55px;border:none;">
		</div>

		<div>
		<a href="showone.do?c=155" target="_blank">营销部介绍&nbsp;</a>	</div>
		<div>
		<a href="showone.do?c=156" target="_blank">营销通讯录&nbsp;</a>		</div>
		<div style="width:90px;">
		<a href="market.do?method=subPage1&columnId=157" target="_blank">常用表格下载&nbsp;</a>		</div>
		<div style="width:65px;">
		<a href="admin/login.jsp" target="_blank">后台管理&nbsp;</a>		</div>
			
		
	</div>	
	<div id="countdownie" style="width:40%;float:left;text-align:bottom;padding:5px 0px 0px 30px;font-size:16px;color:#FFFFFF;">
					<script language="JavaScript">
					var myDate = new Date();
myDate.getFullYear();  
function setcountdown(theyear,themonth,theday){
yr=theyear;mo=themonth;da=theday
}
setcountdown(myDate.getFullYear(),12,31)
var occasion=""
var message_on_occasion=""
var countdownwidth='480px'
var countdownheight='20px'
var opentags='<font face="宋体"><small>'
var closetags='</small></font>'
var montharray=new Array("Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec")
var crosscount=''
function start_countdown(){
if (document.layers)
document.countdownnsmain.visibility="show"
else if (document.all||document.getElementById)
crosscount=document.getElementById&&!document.all?document.getElementById("countdownie") : countdownie
countdown()
}
if (document.all||document.getElementById)
window.onload=start_countdown
function countdown(){
var today=new Date()
var todayy=today.getYear()
if (todayy < 1000)
todayy+=1900
var todaym=today.getMonth()
var todayd=today.getDate()
var todayh=today.getHours()
var todaymin=today.getMinutes()
var todaysec=today.getSeconds()
var todaystring=montharray[todaym]+" "+todayd+", "+todayy+" "+todayh+":"+todaymin+":"+todaysec
futurestring=montharray[mo-1]+" "+da+", "+yr
dd=Date.parse(futurestring)-Date.parse(todaystring)
dday=Math.floor(dd/(60*60*1000*24)*1)
dhour=Math.floor((dd%(60*60*1000*24))/(60*60*1000)*1)
dmin=Math.floor(((dd%(60*60*1000*24))%(60*60*1000))/(60*1000)*1)
dsec=Math.floor((((dd%(60*60*1000*24))%(60*60*1000))%(60*1000))/1000*1)
if(dday<=0&&dhour<=0&&dmin<=0&&dsec<=1&&todayd==da){
if (document.layers){
document.countdownnsmain.document.countdownnssub.document.write(opentags+message_on_occasion+closetags)
document.countdownnsmain.document.countdownnssub.document.close()
}
else if (document.all||document.getElementById)
crosscount.innerHTML=opentags+message_on_occasion+closetags
return
}
else{
if (document.layers){
document.countdownnsmain.document.countdownnssub.document.write(opentags+dday+ " days, "+dhour+" hours, "+dmin+" minutes, and "+dsec+" seconds left until "+occasion+closetags)
document.countdownnsmain.document.countdownnssub.document.close()
}
else if (document.all||document.getElementById)
crosscount.innerHTML=opentags+"年末倒计时： "+dday+ " 天 "+dhour+" 小时 "+dmin+" 分 "+dsec+" 秒 "
}
setTimeout("countdown()",1000)
}
					</script>
	</div>
	</div>
	
	
<!---  中间部分  --->		
	<div style="width:100%;height:400px;float:left;background-color:#ffffff;">
		<div style="width:100%;float:left;padding:10px 0px 30px 60px;text-align:left;">
			<a href="market.do?method=index">部门主页</a>	
				&gt;&gt;
			<%=c.getParentName()%>
		</div>
		<div class="columnlist">
			<%=d.divColumn("columnList", "market.do?method=subPage2&", 0,"#0066cc")%>
		</div>
		
		<div style="float:left;width:75%;text-align:left;">
			<div style="width:100%;color:#ff0000;padding:5px 0px 5px 30px;font-weight:bold;">
				
			</div>			
			<div style="padding:20px 0px 10px 10px;height:350px;" class="contentlist">
				<%=d.divContent("contentList",0)%>
			</div>
			
			<div style="padding:20px 0px 10px 20px;">
				<%=d.toPage(2)%>
			</div>
			<div style="padding:10px 0px 10px 50px;">
				Copyright<img src="images/market/c.jpg" border="0">2007 版权所有 合众人寿总公司营销部
			</div>
		</div>
	</div>
	
	
</div>	
</center>
</body>
</HTML>
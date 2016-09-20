<%@ taglib uri="struts-bean.tld" prefix="bean"%>
<%@ taglib uri="struts-html.tld" prefix="html"%>
<%@ taglib uri="struts-logic.tld" prefix="logic"%>
<%@ taglib uri="ulweb-list.tld" prefix="ulweb"%>

<html>
<head>
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlTemplate,com.ulic.ulweb.ulweb.entity.UlColumn,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.ulweb.entity.UlContentWithAtt,com.ulic.ulweb.ulweb.util.DisplayOnPage" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<title>合众人寿营销部 &gt;&gt; 营销部首页</title>
<link href="css/main.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" href="dept/market2/market.css" type="text/css" />
<style type="text/css">
A{TEXT-DECORATION: none;}
A:hover{COLOR: #CC0000;}
A:link {color: #000000;}
A:visited {color: #000000;}

BODY
{
FONT-SIZE: 9pt;background:#f6f6f6
}
TD
{
FONT-FAMILY:宋体;FONT-SIZE: 9pt;line-height: 150%; 

}
Input
{
BACKGROUND-COLOR: #E7F7DB; 
BORDER-BOTTOM: #007500 1px solid;
BORDER-LEFT: #007500 1px solid;
BORDER-RIGHT: #007500 1px solid;
BORDER-TOP: #007500 1px solid;
COLOR: #000000;
HEIGHT: 18px;
border-color: #007500 #007500 #007500 #007500; font-size: 9pt
}
Button
{
FONT-SIZE: 9pt;HEIGHT: 20px; 

}
Select
{
FONT-SIZE: 9pt;HEIGHT: 20px;

}
.border
{
border: 1px solid #007500;

}
.border2
{
background:#ffffff;BORDER-bottom: #007500 1px solid; 
}
.title_txt
{
background:url(dept/market2/images/topBar_bg_20.gif);

}
.title
{
background:url(dept/market2/images/title.gif);height: 22;

}
.tdbg
{
background:#ffffff;line-height: 150%; 
}
.txt_css
{
background:url(dept/market2/images/txt_css.gif);height: 36;
}
.title_lefttxt
{
filter: DropShadow(Color=#ffffff, OffX=2, OffY=2, Positive=2)
}
.title_left
{
background:url(dept/market2/images/title_left1.gif);height: 26;
}
.tdbg_left
{
background:#E7F7DB
line-height: 150%;
}
.title_left2
{
background:#E7F7DB;height:8;
}
.tdbg_left2
{
background:url(dept/market2/images/tdbg_left2.gif);height: 13;

}
.tdbg_leftall
{
background:#E7F7DB;BORDER-left: #56B02B 1px solid; BORDER-right: #56B02B 1px solid; 
}
.title_maintxt
{
color: #000000;filter:Glow(Color=#ffffff, Strength=3)
}
.title_main
{
background:url(dept/market2/images/title_main.gif);height: 22;
}
.tdbg_main
{
background:url(dept/market2/images/tdbg_main2.GIF);line-height: 100%;

}
.title_main2
{
background:url(dept/market2/images/maintop.gif);height: 202;
}
.tdbg_main2
{
background:url(dept/market2/images/tdbg_main3.GIF);height: 27;
}
.tdbg_mainall
{
background:url(dept/market2/images/kt01-p1.GIF);
}
.title_righttxt
{
filter: DropShadow(Color=#ffffff, OffX=2, OffY=2, Positive=2)
}
.title_right
{
background:url(dept/market2/images/title_right1.gif);height: 26;
}
.tdbg_right
{
background:#F2FBEB;

}
.title_right2
{
background:url(dept/market2/images/title_main.gif);height: 22;
}
.tdbg_right2
{
background:url(dept/market2/images/title_main.gif);height: 22;
}
.tdbg_rightall
{
background:#E7F7DB;BORDER: #56B02B 1px solid; 

}
.topborder
{
background-image: url(dept/market2/images/topborder.gif);
}
.nav_top
{
background-image: url(dept/market2/images/nav_top.gif);height: 25;
}
.nav_main
{
line-height: 150%;background:url(dept/market2/images/nav_main.gif);
line-height: 150%;height: 134;
}
.nav_bottom
{
background-image: url(dept/market2/images/nav_bottom.gif);

}
.nav_menu
{
background:url(dept/market2/images/nav_menu.gif);height: 24;
}
.menu
{
background-color: #56B02B;width:97%;border: 1px;

}
td.MenuBody
{
background-color: #E7F7DB;
}
.STYLE2 {
	color: #FFFFFF;
	font-size: 12pt;
	font-weight: bold;
}
</style>
</script>
<script type="text/javascript" src="js/common.js"></script>
<script language="JavaScript" type="text/JavaScript">
//下拉菜单相关代码
 var h;
 var w;
 var l;
 var t;
 var topMar = 1;
 var leftMar = -2;
 var space = 1;
 var isvisible;
 var MENU_SHADOW_COLOR='#999999';//定义下拉菜单阴影色
 var global = window.document
 global.fo_currentMenu = null
 global.fo_shadows = new Array

function HideMenu() 
{
 var mX;
 var mY;
 var vDiv;
 var mDiv;
	if (isvisible == true)
{
		vDiv = document.all("menuDiv");
		mX = window.event.clientX + document.body.scrollLeft;
		mY = window.event.clientY + document.body.scrollTop;
		if ((mX < parseInt(vDiv.style.left)) || (mX > parseInt(vDiv.style.left)+vDiv.offsetWidth) || (mY < parseInt(vDiv.style.top)-h) || (mY > parseInt(vDiv.style.top)+vDiv.offsetHeight)){
			vDiv.style.visibility = "hidden";
			isvisible = false;
		}
}
}

function ShowMenu(vMnuCode,tWidth) {
	vSrc = window.event.srcElement;
	vMnuCode = "<table id='submenu' cellspacing=1 cellpadding=3 style='width:"+tWidth+"' class=menu onmouseout='HideMenu()'><tr height=23><td nowrap align=left class=MenuBody>" + vMnuCode + "</td></tr></table>";

	h = vSrc.offsetHeight;
	w = vSrc.offsetWidth;
	l = vSrc.offsetLeft + leftMar+4;
	t = vSrc.offsetTop + topMar + h + space-2;
	vParent = vSrc.offsetParent;
	while (vParent.tagName.toUpperCase() != "BODY")
	{
		l += vParent.offsetLeft;
		t += vParent.offsetTop;
		vParent = vParent.offsetParent;
	}

	menuDiv.innerHTML = vMnuCode;
	menuDiv.style.top = t;
	menuDiv.style.left = l;
	menuDiv.style.visibility = "visible";
	isvisible = true;
    makeRectangularDropShadow(submenu, MENU_SHADOW_COLOR, 4)
}

function makeRectangularDropShadow(el, color, size)
{
	var i;
	for (i=size; i>0; i--)
	{
		var rect = document.createElement('div');
		var rs = rect.style
		rs.position = 'absolute';
		rs.left = (el.style.posLeft + i) + 'px';
		rs.top = (el.style.posTop + i) + 'px';
		rs.width = el.offsetWidth + 'px';
		rs.height = el.offsetHeight + 'px';
		rs.zIndex = el.style.zIndex - i;
		rs.backgroundColor = color;
		var opacity = 1 - i / (i + 1);
		rs.filter = 'alpha(opacity=' + (100 * opacity) + ')';
		el.insertAdjacentElement('afterEnd', rect);
		global.fo_shadows[global.fo_shadows.length] = rect;
	}
}
</script>
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


<script language="JavaScript" type="text/JavaScript">
//菜单列表
var menu_skin="&nbsp;<a style=font-size:9pt;line-height:14pt; href='SetCookie.asp?Action=SetSkin&ClassID=0&SkinID=1'>牧虫典雅</a><br>&nbsp;<a style=font-size:9pt;line-height:14pt; href='SetCookie.asp?Action=SetSkin&ClassID=0&SkinID=2'>雅虎秋梦</a><br>&nbsp;<a style=font-size:9pt;line-height:14pt; href='SetCookie.asp?Action=SetSkin&ClassID=0&SkinID=3'>灰色畅想</a><br>&nbsp;<a style=font-size:9pt;line-height:14pt; href='SetCookie.asp?Action=SetSkin&ClassID=0&SkinID=4'>绿雨飘香</a><br>&nbsp;<a style=font-size:9pt;line-height:14pt; href='SetCookie.asp?Action=SetSkin&ClassID=0&SkinID=5'>幽绿芭蕾</a><br>&nbsp;<a style=font-size:9pt;line-height:14pt; href='SetCookie.asp?Action=SetSkin&ClassID=0&SkinID=6'>晴空幽蓝</a><br>&nbsp;<a style=font-size:9pt;line-height:14pt; href='SetCookie.asp?Action=SetSkin&ClassID=0&SkinID=7'>书卷飘香</a><br>&nbsp;<a style=font-size:9pt;line-height:14pt; href='SetCookie.asp?Action=SetSkin&ClassID=0&SkinID=8'>蓝天动力</a><br>&nbsp;<a style=font-size:9pt;line-height:14pt; href='SetCookie.asp?Action=SetSkin&ClassID=0&SkinID=9'>动力空间</a><br>";
</script>
</div>
<style>
.mianDiv{width: 1000px;margin: auto;height: auto;border: 0px solid red}
.top1{margin: 1px 5px;border: 0px solid blue;height: 200px;}
.top2{margin: 1px 5px;border: 0px solid blue;height: 29px;}

.bottom1{margin: 1px 5px;border: 0px solid blue;height: 132px;}
.bottom2{margin: 1px 5px;border: 0px solid blue;height: 83px;}
.middle1{margin: 1px 5px;border: 0px solid blue;height: auto;overflow: hidden}
.middle1_left{margin: 1px 5px 1px 1px;border: 0px solid blue;width: 250px;float: left;height: 680px;}
.middle1_middle{margin: 1px 5px;border: 0px solid blue;width: 360px;float: left;height: 680px;}
.middle1_right{margin: 1px 1px 1px 5px;;border: 0px solid blue;width: 350px;float: left;height: 680px;}
.middle1_middle_m{margin: 5px 0px 0px 0px;;border: 0px solid blue;width: 355px;height: auto;}
.middle1_middle_b{margin: 5px 0px 0px 0px;;border: 0px solid blue;width: 355px;height: 235;}
.middle1_right_t{margin: 10px 0px 0px 0px;;border: 0px solid blue;width: 345px;height: 235;}
.middle1_right_m{margin: 7px 0px 0px 0px;;border: 0px solid blue;width: 345px;height: auto;}
.middle1_right_b{margin: 5px 0px 0px 0px;;border: 0px solid blue;width: 345px;height: 235;}
.Lcon1_new{ border:1PX solid #ddd;line-height:30px; padding:5px;width: 100%;border-bottom-width: 0px}
.tabSelTd{border-right: 1px solid #ddd;border-bottom: 0px solid #ddd;text-align: center;cursor: pointer;color: red;font-weight: bold;}
.tabTd{border-right: 1px solid #ddd;border-bottom: 1px solid #ddd;text-align: center;cursor: pointer;background-color:#F0F0F0}
.ul_left{text-align: left}
.textF{width: 210px;overflow: hidden;white-space: nowrap;text-overflow: ellipsis;margin-right: 20px;-o-text-overflow:ellipsis;-webkit-text-overflow:ellipsis;}
.menuTop{margin-top: 10px;color: white;text-align: center;height: 38px;width: 100%;line-height: 38px;font-weight: bold;}

.mydiv {
background-color: #ddd;
border: 1px solid #ddd;
text-align: center;
line-height: 40px;
font-size: 12px;
font-weight: bold;
z-index:999;
width: 990px;
height: 500px;
top:150px;
margin-top:0px;
position:fixed!important;/* FF IE7*/
position:absolute;/*IE6*/

}
.bg,.popIframe {
background-color: #666; display:none;
width: 100%;
height: 100%;
left:0;
top:0;/*FF IE7*/
filter:alpha(opacity=30);/*IE*/
opacity:0.5;/*FF*/
z-index:1;
position:fixed!important;/*FF IE7*/
position:absolute;/*IE6*/
_top:       expression(eval(document.compatMode &&
            document.compatMode=='CSS1Compat') ?
            documentElement.scrollTop + (document.documentElement.clientHeight-this.offsetHeight)/2 :/*IE6*/
            document.body.scrollTop + (document.body.clientHeight - this.clientHeight)/2);
}
.popIframe {
filter:alpha(opacity=0);/*IE*/
opacity:0;/*FF*/
}

</style>
</head>
<%
		UlTemplate t = (UlTemplate)request.getAttribute("template");
		DisplayOnPage d = new DisplayOnPage();
		d.setRequest(request);
		List<UlContentWithAtt> list1 = (List<UlContentWithAtt>)request.getAttribute("lanmu");
%>
<!-- <body bgcolor="#ffffff" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0"> -->
<body style="margin:0px;" onload="showImage(10);" bgcolor="#ffffff" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<script type="text/javascript">
var h = 0;  //设置当前显示高度
function loadImage(url,callback){
    var img = new Image();
    img.src = url;
    if(img.complete){   //判断图片是否加载完成
        callback.call(img);
        return;
    }
    img.onload = function(){    //图片加载
        callback.call(img);
    }
}
function showDiv(){
document.getElementById("popDiv").style.left = (document.body.clientWidth -990)/2 + "px";	
document.getElementById('popDiv').style.display='block';
document.getElementById('popIframe').style.display='block';
document.getElementById('bg').style.display='block';
}
function closeDiv(){
h=10;
document.getElementById('popDiv').style.display='none';
document.getElementById('bg').style.display='none';
document.getElementById('popIframe').style.display='none';
}
function imgLoaded(){
    //document.getElementById("myImgs").src = this.src;   //获得图片地址
    showImage(1);     //图片展开
}

function showImage(num){
	if(h<num){
		showDiv();
		h=h+1;
		document.getElementById('forNum').innerHTML = num-h+1;
	}else{
		closeDiv();
		return false;
	}
	setTimeout("showImage("+num+")",1000);
    
}





</script>

<div id="popDiv" class="mydiv" style="display:none;">
	<ulweb:content beanName="cl" deptId="market" enName="tctp" pageNum="1" pageSize="1" conditions="isDelete=0:i;isProcessing=0:i;" withAtt="1" />
	<logic:iterate id="element" name="cl" property="objectList">
		<logic:notEmpty name="element" property="attachmentList">
			<logic:iterate id="e" name="element" property="attachmentList">
				<img src="<bean:write name="e" property="displayPath" />" style="width: 990px;height: 500px;"/> 
				<!-- <img src="dept/market2/images/sc.png" style="width: 990px;height: 132px"/>-->
			</logic:iterate>
		</logic:notEmpty>
	</logic:iterate>
	<div id="forNum" style="position:absolute;left: 5px;right: 5px;width: 50px;height: 50px;font-size: 26px;color: red;font-weight: bold;">10</div>
	<div id="delShowImg" style="position:absolute;right: 5px;right: 5px;width: 50px;height: 50px;font-size: 20px;color: red;font-weight: bold;cursor: pointer;" onclick="closeDiv();">X</div>
	
</div>
<div id="bg" class="bg" style="display:none;"></div>
<iframe id='popIframe' class='popIframe' frameborder='0' ></iframe>


<div class="mianDiv"><!--  mianDiv-->
	<div class="top1">
		<ulweb:content beanName="cl" deptId="market" enName="dingbutp" pageNum="1" pageSize="1" conditions="isDelete=0:i;isProcessing=0:i;" withAtt="1" />
		<logic:iterate id="element" name="cl" property="objectList">
			<logic:notEmpty name="element" property="attachmentList">
				<logic:iterate id="e" name="element" property="attachmentList">
					<img src="<bean:write name="e" property="displayPath" />" style="width: 990px;height: 200px;"/>
				</logic:iterate>
			</logic:notEmpty>
		</logic:iterate>
	</div>
	<div class="top2"><!-- top2 -->
		<table width="100%" border="0" cellspacing="0" cellpadding="0" background="dept/market2/images/dao.png">
      		<tbody>
      			<tr >
					<td  width="35" height="42"></td>
			        <td  width="75" height="29" align="center"><a href="http://ulweb/" target="_self"><font color="#ffffff"><strong>网站首页</strong></font></a></td>
					<td  width="20" height="29"></td>
			        <td  width="85" align="center"><strong><a href="show.do?c=6329" target="_self"><font color="#ffffff">营销部介绍</font></a></strong></td>
			        <td  width="20" align="center">&nbsp;</td>
			        <td  width="77" height="29" align="center"><a href="show.do?c=226052" target="_self"><font color="#ffffff"><strong>营销通讯录</strong></font></a></td>
					<td  width="28" height="29"></td>
			        <td  width="90" height="29" align="center"><a href="market2.do?method=subPage1&columnId=5609" target="_blank"><strong><font color="#ffffff">营销行事历</font></strong></a></td>
			        <td  width="20" align="center">&nbsp;</td>
			        <!-- <td  width="82" height="29" align="center"><a href="admin/login.jsp" target="_self"><strong><font color="#ffffff">后台管理</font></strong></a></td>
					<td  width="8" height="29"></td>
					 -->
			        <td  width="350" height="29" align="right">
			       
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
					document.write("<font color=#ffffff> 欢迎您访问总公司营销部主页，今天是"+year+"年"+mymonth+"月"+myday+"日 "+weekday+"</font>");
					</script></td>
					<td width="1"></td>
				</tr>
    		</tbody>
    </table>
	</div><!-- top2 -->
	<div class="middle1"><!--  middle1-->
		<div class="middle1_left"><!-- middle1_left -->
			<div style="float:left;width:250px;border: 2px solid #C8E8F0;margin-top: 10px;">
				<div class="menuTop" style="margin-top: 0px;background: url('dept/market2/images/gg.png');">
					<a href="market.do?method=subPage1&columnId=148" style="color:#fff;font-weight:bold;line-height: 42px" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;公告</a>
				</div>
				<div class="rightContent1" id="marquees" style="overflow:hidden; height:100;line-height: 25px;" onMouseOver="setMouse(1);"  onmouseout="setMouse(0)">
					
						<%=d.divContent("gonggao",0)%>
					
				</div>
			</div>

			<div class="menuTop" style="background: url('dept/market2/images/lk.png');">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业务系统链接
			</div>
			<div class="righttitle31">
				<div style="background: url('dept/market2/images/link1.png');width: 250px;height: 44px;line-height: 41px;padding-left: 95px;color: #2F11E9;font-weight: bold;">
					<a href="http://ulcbs/" target="_blank"  style="color: #2F11E9">核心业务系统</a>
				</div>
				<div style="background: url('dept/market2/images/link2.png');width: 250px;height: 44px;line-height: 41px;padding-left: 95px;color: #2F11E9;font-weight: bold;">
					<a href="http://oa/" target="_blank" style="color: #2F11E9">OA系统</a>
				</div>
				<div style="background: url('dept/market2/images/link3.png');width: 250px;height: 44px;line-height: 41px;padding-left: 95px;color: #2F11E9;font-weight: bold;">
					<a href="http://mis/" target="_blank" style="color: #2F11E9">企业决策支持系统</a>
				</div>
				<div style="background: url('dept/market2/images/link4.png');width: 250px;height: 44px;line-height: 41px;padding-left: 95px;color: #2F11E9;font-weight: bold;">
					<a href="http://sales/" target="_blank" style="color: #2F11E9">营销管理系统</a>
				</div>
				<div style="background: url('dept/market2/images/link5.png');width: 250px;height: 44px;line-height: 41px;padding-left: 95px;color: #2F11E9;font-weight: bold;">
					<a href="http://esales/esales/login.jsp" target="_blank" style="color: #2F11E9">行销支持系统</a>
				</div>
				<div style="background: url('dept/market2/images/link6.png');width: 250px;height: 44px;line-height: 41px;padding-left: 95px;color: #2F11E9;font-weight: bold;">
					<a href="http://itsm.ulic.com.cn:9090/maximo/" target="_blank" style="color: #2F11E9">IT服务管理平台</a>
				</div>
			</div>
			<div  class="menuTop" style="background: url('dept/market2/images/sc.png');">
				站内搜索
			</div>
			<div class="righttitle21" style="background: url('dept/market2/images/searchBg.png') no-repeat;color:#fff ">
				<form action="market2.do?method=check" id="idform1" name="form1" method="post" >
				<div >
					关键字&nbsp;
					<input type="text" name="tName" size="12">					
				</div>
				<div>
					类 &nbsp; 型&nbsp;
					<select  name="type" id="idtype" style="width:90px">
					<option value="0">不限</option>
					<%=d.optionColumn("columnForCheck")%>
             	   </select>
				</div>
				
				<div style="text-align:center;">
					<input type="submit" value="提交" />
				</div>
				</form>
				<div style="text-align:left; padding:0px 0px 0px 0px;">
				</div>
			</div>

					
		</div><!-- middle1_left -->
		<div class="middle1_middle"><!-- middle1_middle -->
			<script language="javascript">
				var imgUrl=new Array();
				var imgLink=new Array();
				var text=new Array();
				var adNum=0;
				var buttonShow=1;
				var buttonPos=2; //RU:1，RD:2，LU:3，LD:4
				
				
				
				<ulweb:content beanName="cl" deptId="market" enName="tupianhd" pageNum="1" pageSize="10" conditions="isDelete=0:i;isProcessing=0:i;" withAtt="1" />
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
			<script language="javascript" src="dept/market2/newsAd.js"></script>
			<table id=newsTable border="0" cellspacing="0" cellpadding="0" style="border: solid 2px #C8E8F0; ">
				<script language="javascript">dakularButtons();</script>
				<tr>
					<td>
						<a onMouseOver="displayStatusMsg();return document.returnValue" onMouseOut="status='';" class=px14-lh24 href="javascript:jump2url()">
							<img style="FILTER: revealTrans(duration=1,transition=23); border:0px solid #000000" src="#" width=355 height=225 border=0 name=imgUrlrotator alt=""> 
						</a>
						<script>nextAd();</script>
					</td>
				</tr>
			</table>
			
			<div class="middle1_middle_m">
				<ulweb:content beanName="cl" deptId="market" enName="zjzbtp" pageNum="1" pageSize="1" conditions="isDelete=0:i;isProcessing=0:i;" withAtt="1" />
				<logic:iterate id="element" name="cl" property="objectList">
					<logic:notEmpty name="element" property="attachmentList">
						<logic:iterate id="e" name="element" property="attachmentList">
							<a href="<bean:write name="element" property="subTitle" />">
								<img src="<bean:write name="e" property="displayPath" />" style="width: 355px;height: 175px;"/>
							</a>
						</logic:iterate>
					</logic:notEmpty>
				</logic:iterate>
				
			</div>
			<div class="middle1_middle_b"><!-- middle1_middle_b -->
				<div >
					    <p style="text-align: left">
						<table cellpadding="0" cellspacing="0" border="0" class="Lcon1_new">
							<tr>
								<td onmouseover="tagSel1('mgzz2', 1, 3)" class="tabSelTd" id="tag_mgzz21">
									<font id="mgzz2_f_1"
										class="tabsel">个险营销速报</font> </a>
								</td>
								<td onmouseover="tagSel1('mgzz2', 2, 3)" class="tabTd" id="tag_mgzz22">
									<font id="mgzz2_f_2"
										class="tab">个险人力日报</font> </a>
								</td>
								<td onmouseover="tagSel1('mgzz2', 3, 3)" class="tabTd" id="tag_mgzz23">
									<font id="mgzz2_f_3"
										class="tab">方案报表</font> </a>
								</td>
			
								
								
							</tr>
						</table>
						</p>
					</div>
					<div class="za" style="height: 198px;overflow:auto;border-top-width: 0px;">
						<div id="mgzz21" style="display: block;Height: 195px;">
							<ul class="ul_left" style="text-align: left;">
								<ulweb:content beanName="cl" deptId="market" enName="subao"
									pageNum="1" pageSize="5"
									conditions="isDelete=0:i;isProcessing=0:i;" />
								<logic:iterate id="element" name="cl" property="objectList">
									<li style="line-height: 30px;">
										
									   <a href="show.do?c=<bean:write name="element" property="contentId" />" target="_blank" title="<bean:write name="element" property="contentName" />" 
										<logic:equal name="element" property="displayType" value="9">style="color:#ff0000"</logic:equal> class="textF">
											<script>document.writeln("<bean:write name="element" property="contentName" />".substring(0,28));</script>
										</a>
										
										<span class="fri">
											<bean:write name="element" property="updateTime" format="yyyy-MM-dd" />
										</span>
										<bean:write name="element" property="new" filter="false" />
									</li>
								</logic:iterate>
									<li style="line-height: 24px;text-align: right">
										<a href="market2.do?method=subPage1&columnId=149" target="_blank" >
											更多
										</a>
									</li>
							</ul>
						</div>
						
						<div id="mgzz22" style="display: none;Height: 195px;">
							<ul class="ul_left" style="text-align: left;">
								<ulweb:content beanName="cl" deptId="market" enName="gexianrenlirenbao"
									pageNum="1" pageSize="5"
									conditions="isDelete=0:i;isProcessing=0:i;" />
								<logic:iterate id="element" name="cl" property="objectList">
									<li style="line-height: 30px;">
									   <a href="show.do?c=<bean:write name="element" property="contentId" />" target="_blank" title="<bean:write name="element" property="contentName" />" 
										<logic:equal name="element" property="displayType" value="9">style="color:#ff0000"</logic:equal> class="textF">
											<script>document.writeln("<bean:write name="element" property="contentName" />".substring(0,28));</script>
										</a>
										<span class="fri">
											<bean:write name="element" property="updateTime" format="yyyy-MM-dd" />
										</span>
										<bean:write name="element" property="new" filter="false" />
									</li>
								</logic:iterate>
									<li style="line-height: 24px;text-align: right">
										<a href="market2.do?method=subPage1&columnId=248" target="_blank" >
											更多
										</a>
									</li>
							</ul>
						</div>
						
						
						<div id="mgzz23" style="display: none;Height: 195px;">
							<ul class="ul_left" style="text-align: left;">
								<ulweb:content beanName="cl" deptId="market" enName="fabaobiao"
									pageNum="1" pageSize="5"
									conditions="isDelete=0:i;isProcessing=0:i;" />
								<logic:iterate id="element" name="cl" property="objectList">
									<li style="line-height: 30px;">
									   <a href="show.do?c=<bean:write name="element" property="contentId" />" target="_blank" title="<bean:write name="element" property="contentName" />" 
										<logic:equal name="element" property="displayType" value="9">style="color:#ff0000"</logic:equal> class="textF">
											<script>document.writeln("<bean:write name="element" property="contentName" />".substring(0,28));</script>
										</a>
										<span class="fri">
											<bean:write name="element" property="updateTime" format="yyyy-MM-dd" />
										</span>
										<bean:write name="element" property="new" filter="false" />
									</li>
								</logic:iterate>
									<li style="line-height: 24px;text-align: right">
										<a href="market2.do?method=subPage1&columnId=5612" target="_blank" >
											更多
										</a>
									</li>
							</ul>
						</div>
						 
						
						
					</div>
			</div><!-- middle1_middle_b -->
		</div><!-- middle1_middle -->
		<div class="middle1_right"><!-- middle1_right -->
			<div class="middle1_right_t"><!-- middle1_right_t -->
				<div >
					    <p style="text-align: left">
						<table cellpadding="0" cellspacing="0" border="0" class="Lcon1_new">
							<tr>
								<!-- <td >
									<img src="images/biao.jpg" />
									&nbsp;
								</td>
								 -->
								<td onmouseover="tagSel1('mgzz', 1, 4)" class="tabSelTd" id="tag_mgzz1">
									<font id="mgzz_f_1"class="tabsel" >营销文件</font> 
								</td>
								<td class="tabTd" onmouseover="tagSel1('mgzz', 2, 4)" id="tag_mgzz2">
									<font id="mgzz_f_2"class="tab">竞赛激励</font> </a>
								</td>
								<td class="tabTd" onmouseover="tagSel1('mgzz', 3, 4)" id="tag_mgzz3">
									<font id="mgzz_f_3"class="tab">行业动态</font> </a>
								</td>
								<td class="tabTd" onmouseover="tagSel1('mgzz', 4, 4)" id="tag_mgzz4">
									<font id="mgzz_f_4"class="tab">营销风采</font> </a>
								</td>

								
							</tr>
						</table>
						</p>
					</div>
					<div class="za" style="height: 198px;overflow:auto;border-top-width: 0px;">
						<div id="mgzz1" style="display: block;Height: 195px;">
							<ul class="ul_left" style="text-align: left;">
								<ulweb:content beanName="cl" deptId="market" enName="wenjian"
									pageNum="1" pageSize="5"
									conditions="isDelete=0:i;isProcessing=0:i;" />
								<logic:iterate id="element" name="cl" property="objectList">
									<li style="line-height: 30px;">
									   <a href="show.do?c=<bean:write name="element" property="contentId" />" target="_blank" title="<bean:write name="element" property="contentName" />" 
										<logic:equal name="element" property="displayType" value="9">style="color:#ff0000"</logic:equal> class="textF">
											<script>document.writeln("<bean:write name="element" property="contentName" />".substring(0,28));</script>
										</a>
										<span class="fri">
											<bean:write name="element" property="updateTime" format="yyyy-MM-dd" />
										</span>
										<bean:write name="element" property="new" filter="false" />
									</li>
								</logic:iterate>
									<li style="line-height: 24px;text-align: right">
										<a href="market2.do?method=subPage1&columnId=204" target="_blank" >
											更多
										</a>
									</li>
							</ul>
						</div>
						 
						<div id="mgzz2" style="display: none;Height: 195px;">
							<ul class="ul_left">
								<ulweb:content beanName="cl" deptId="market" enName="jingshai"
									pageNum="1" pageSize="5"
									conditions="isDelete=0:i;isProcessing=0:i;" />
								<logic:iterate id="element" name="cl" property="objectList">
									<li style="line-height: 30px;">
									   <a href="show.do?c=<bean:write name="element" property="contentId" />" target="_blank" title="<bean:write name="element" property="contentName" />" 
										<logic:equal name="element" property="displayType" value="9">style="color:#ff0000"</logic:equal> class="textF">
											<script>document.writeln("<bean:write name="element" property="contentName" />".substring(0,28));</script>
										</a>
										<span class="fri">
											<bean:write name="element" property="updateTime" format="yyyy-MM-dd" />
										</span>
										<bean:write name="element" property="new" filter="false" />
									</li>
								</logic:iterate>
									<li style="line-height: 24px;text-align: right">
										<a href="market2.do?method=subPage1&columnId=165" target="_blank" >
											更多
										</a>
									</li>
							</ul>
						</div>
						
						<div id="mgzz3" style="display: none;Height: 195px;">
							<ul class="ul_left">
								<ulweb:content beanName="cl" deptId="market" enName="dongtai"
									pageNum="1" pageSize="5"
									conditions="isDelete=0:i;isProcessing=0:i;" />
								<logic:iterate id="element" name="cl" property="objectList">
									<li style="line-height: 30px;">
									   <a href="show.do?c=<bean:write name="element" property="contentId" />" target="_blank" title="<bean:write name="element" property="contentName" />" 
										<logic:equal name="element" property="displayType" value="9">style="color:#ff0000"</logic:equal> class="textF">
											<script>document.writeln("<bean:write name="element" property="contentName" />".substring(0,28));</script>
										</a>
										<span class="fri">
											<bean:write name="element" property="updateTime" format="yyyy-MM-dd" />
										</span>
										<bean:write name="element" property="new" filter="false" />
									</li>
								</logic:iterate>
									<li style="line-height: 24px;text-align: right">
										<a href="market2.do?method=subPage1&columnId=5610" target="_blank" >
											更多
										</a>
									</li>
							</ul>
						</div>
						
						<div id="mgzz4" style="display: none;Height: 195px;">
							<ul class="ul_left">
								<ulweb:content beanName="cl" deptId="market" enName="fengcai"
									pageNum="1" pageSize="5"
									conditions="isDelete=0:i;isProcessing=0:i;" />
								<logic:iterate id="element" name="cl" property="objectList">
									<li style="line-height: 30px;">
									   <a href="show.do?c=<bean:write name="element" property="contentId" />" target="_blank" title="<bean:write name="element" property="contentName" />" 
										<logic:equal name="element" property="displayType" value="9">style="color:#ff0000"</logic:equal> class="textF">
											<script>document.writeln("<bean:write name="element" property="contentName" />".substring(0,28));</script>
										</a>
										<span class="fri">
											<bean:write name="element" property="updateTime" format="yyyy-MM-dd" />
										</span>
										<bean:write name="element" property="new" filter="false" />
									</li>
								</logic:iterate>
									<li style="line-height: 24px;text-align: right">
										<a href="market2.do?method=subPage1&columnId=5611" target="_blank" >
											更多
										</a>
									</li>
							</ul>
						</div>
						
					</div>
			</div><!-- middle1_right_t -->
			<div class="middle1_right_m">
				
				<ulweb:content beanName="cl" deptId="market" enName="zjybtp" pageNum="1" pageSize="1" conditions="isDelete=0:i;isProcessing=0:i;" withAtt="1" />
				<logic:iterate id="element" name="cl" property="objectList">
					<logic:notEmpty name="element" property="attachmentList">
						<logic:iterate id="e" name="element" property="attachmentList">
							<a href="<bean:write name="element" property="subTitle" />">
								<img src="<bean:write name="e" property="displayPath" />" style="width: 345px;height: 175px;"/>
							</a>
							
						</logic:iterate>
					</logic:notEmpty>
				</logic:iterate>
			</div>
			<div class="middle1_right_b"><!-- middle1_right_b -->
				<div >
					    <p style="text-align: left">
						<table cellpadding="0" cellspacing="0" border="0" class="Lcon1_new">
							<tr>
								<td onmouseover="tagSel1('mgzz3', 1, 3)" class="tabSelTd" id="tag_mgzz31">
									<font id="mgzz3_f_1"
										class="tabsel">早安合众</font> </a>
								</td>
								<td onmouseover="tagSel1('mgzz3', 2, 3)" class="tabTd" id="tag_mgzz32">&nbsp;
									<font id="mgzz3_f_2"
										class="tab">品质管理</font> </a>
								</td>
								<td id="tag_mgzz33" onmouseover="tagSel1('mgzz3', 3, 3)" class="tabTd">
									<font id="mgzz3_f_3"
										class="tab">荣誉星空</font> </a>
								</td>
								
							</tr>
						</table>
						</p>
					</div>
					<div class="za" style="height: 198px;overflow:auto;border-top-width: 0px;">
						<div id="mgzz31" style="display:block;Height: 195px;">
							<ul class="ul_left">
								<ulweb:content beanName="cl" deptId="market" enName="zaoan"
									pageNum="1" pageSize="5"
									conditions="isDelete=0:i;isProcessing=0:i;" />
								<logic:iterate id="element" name="cl" property="objectList">
									<li style="line-height: 30px;">
									   <a href="show.do?c=<bean:write name="element" property="contentId" />" target="_blank" title="<bean:write name="element" property="contentName" />" 
										<logic:equal name="element" property="displayType" value="9">style="color:#ff0000"</logic:equal> class="textF">
											<script>document.writeln("<bean:write name="element" property="contentName" />".substring(0,28));</script>
										</a>
										<span class="fri">
											<bean:write name="element" property="updateTime" format="yyyy-MM-dd" />
										</span>
										<bean:write name="element" property="new" filter="false" />
									</li>
								</logic:iterate>
									<li style="line-height: 24px;text-align: right">
										<a href="market2.do?method=subPage1&columnId=667" target="_blank" >
											更多
										</a>
									</li>
							</ul>
						</div>
						 
						 <div id="mgzz32" style="display: none;Height: 195px;">
							<ul class="ul_left">
								<ulweb:content beanName="cl" deptId="market" enName="glbaobiao" 
									pageNum="1" pageSize="5"
									conditions="isDelete=0:i;isProcessing=0:i;" />
								<logic:iterate id="element" name="cl" property="objectList">
									<li style="line-height: 30px;">
									   <a href="show.do?c=<bean:write name="element" property="contentId" />" target="_blank" title="<bean:write name="element" property="contentName" />" 
										<logic:equal name="element" property="displayType" value="9">style="color:#ff0000"</logic:equal> class="textF">
											<script>document.writeln("<bean:write name="element" property="contentName" />".substring(0,28));</script>
										</a>
										<span class="fri">
											<bean:write name="element" property="updateTime" format="yyyy-MM-dd" />
										</span>
										<bean:write name="element" property="new" filter="false" />
									</li>
								</logic:iterate>
									<li style="line-height: 24px;text-align: right">
										<a href="market2.do?method=subPage1&columnId=5613" target="_blank" >
											更多
										</a>
									</li>
							</ul>
						</div>
						
						<div id="mgzz33" style="display: none;Height: 195px;">
							<ul class="ul_left">
								<ulweb:content beanName="cl" deptId="market" enName="dudao"
									pageNum="1" pageSize="5"
									conditions="isDelete=0:i;isProcessing=0:i;" />
								<logic:iterate id="element" name="cl" property="objectList">
									<li style="line-height: 30px;">
									   <a href="show.do?c=<bean:write name="element" property="contentId" />" target="_blank" title="<bean:write name="element" property="contentName" />" 
										<logic:equal name="element" property="displayType" value="9">style="color:#ff0000"</logic:equal> class="textF">
											<script>document.writeln("<bean:write name="element" property="contentName" />".substring(0,28));</script>
										</a>
										<span class="fri">
											<bean:write name="element" property="updateTime" format="yyyy-MM-dd" />
										</span>
										<bean:write name="element" property="new" filter="false" />
									</li>
								</logic:iterate>
									<li style="line-height: 24px;text-align: right">
										<a href="market2.do?method=subPage1&columnId=5614" target="_blank" >
											更多
										</a>
									</li>
							</ul>
						</div>
						
						
					</div>
			</div><!-- middle1_right_b -->
		</div><!-- middle1_right -->
	
	</div><!--  middle1-->
	
	<div class="bottom1">
		<ulweb:content beanName="cl" deptId="market" enName="dibutp" pageNum="1" pageSize="1" conditions="isDelete=0:i;isProcessing=0:i;" withAtt="1" />
		<logic:iterate id="element" name="cl" property="objectList">
			<logic:notEmpty name="element" property="attachmentList">
				<logic:iterate id="e" name="element" property="attachmentList">
					<img src="<bean:write name="e" property="displayPath" />" style="width: 990px;height: 132px;"/>
				</logic:iterate>
			</logic:notEmpty>
		</logic:iterate>
	</div>
	<div class="bottom2">
		<table width="990" border="0" cellspacing="0" cellpadding="0" align="center" background="dept/market2/images/foot.png">
	  		<tbody>
	  			<tr>
					<td  width="990" height="83" align="center"><br>&nbsp;您是本站第<span class="topNav2"><%=request.getAttribute("countProcesser")%></span>位访客</span> | <a href="admin/login.jsp" target="_blank">系统管理</a>
						<br>
						&nbsp;Copyright2008 版权所有 合众人寿总公司营销部
					</td>
	  			</tr>
  			</tbody>
  		</table>
	</div>


<SCRIPT language=JavaScript>
<!--
var mousein=0;
var old=document.all.marquees.innerHTML;
var oldpos=document.all.marquees.scrollTop;
function mup(){
	theTimer2=setTimeout("mup()", 100);
	if(mousein==0){
		var pos=document.all.marquees.scrollTop;
		document.all.marquees.scrollTop+=1;
	}
	if(pos!=document.all.marquees.scrollTop){
		pos++;
	}else{
		document.all.marquees.innerHTML+=old;
	}
	if(document.all.marquees.innerHTML.length>10000){
		document.all.marquees.innerHTML=old;
		document.all.marquees.scrollTop=oldpos;
	}
}
function setMouse(value){
	mousein=value;
}
mup();



function tagSel1(grp, idx, len) {
	try {
		for (i = 1; i <= len; i++) {
			if (i == idx) {
				gi(grp + i).style.display = "block";
				gi("tag_" + grp + i).className = "tabSelTd";
				
			} else {
				gi(grp + i).style.display = "none";
				gi("tag_" + grp + i).className = "tabTd";
			}
		}
	}
	catch (e) {
	}
}


//-->
</SCRIPT>

	
</div><!--  mianDiv-->

</body></html>
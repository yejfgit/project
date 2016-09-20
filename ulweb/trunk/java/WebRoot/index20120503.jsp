
<%@ taglib uri="struts-bean.tld" prefix="bean"%>
<%@ taglib uri="struts-html.tld" prefix="html"%>
<%@ taglib uri="struts-logic.tld" prefix="logic"%>
<%@ taglib uri="ulweb-list.tld" prefix="ulweb"%>

<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.ulweb.entity.UlAttachment,com.ulic.ulweb.frame.constant.Constant,com.ulic.ulweb.ulweb.web.action.IndexAction" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//if(request.getAttribute("from") == null) response.sendRedirect(basePath + "index.do");
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>合众人寿内网主页</title>
<script type="text/javascript" src="js/top.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<link href="css/main1zhn.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">

/*
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

function imgLoaded(){
    document.getElementById("myImgs").src = this.src;   //获得图片地址
    showImage(this.height);     //图片展开
}
function showImage(height){
    if(h < height){
        h = h + 5;
    }else{
        setTimeout("hideImage("+height+")",3000);   //图片全部展开后，设置多少秒之后关闭图片
        return;
    }
    var div = document.getElementById("myDiv");
    var img = document.getElementById("myImgs");
    div.style.display = "block";
    div.style.height = h + "px";
    setTimeout("showImage("+height+")",30);
}
function hideImage(height){
    //alert(height);
    if(h > 0){
        h = h - 5;
    }else{
        var divs = document.getElementById("myDiv");
        divs.style.display = "none";    //图片关闭后隐藏该层
        return;
    }
    var div = document.getElementById("myDiv");
    var img = document.getElementById("myImgs");
    div.style.display = "block";
    div.style.height = h + "px";
    setTimeout("hideImage("+height+")",30);
}
*/

</script>

</head>

<!--<body style="margin:0px;" onload="loadImage('images/zhn.jpg',imgLoaded);">-->
<body>
<DIV class=BOX>

<!--<div id="myDiv" style="display:none; overflow:hidden;z-index: 200"><img src="images/zhn.jpg" id="myImgs" /></div>-->
<jsp:include flush="true" page="headzhn.jsp"></jsp:include>



<DIV class=PageBody>
<div class="bank10"></div>
<!--left-->
<div class="left">
<!--notice-->
<p><img src="images/l1.jpg" width="259" height="10" /></p>
<div class="Lcon" style="height: 270px;">
<p align="center"><img src="images/zx1.jpg" border="0" usemap="#Map2" />
<map name="Map2" id="Map2"><area shape="rect" coords="190,14,229,32" href="list.jsp?id=6" target="_blank" /></map></p>
<div class=bank5></div>
<ul>
<ulweb:contentquery beanName="cl" deptId="0000" enName="gongwen" pageNum="1" pageSize="9" />
		<logic:iterate id="element" name="cl" property="objectList">
			<li><div class="break" style="width: 220px">·<a href="show.do?c=<bean:write name="element" property="contentId" />" target="_blank" title="<bean:write name="element" property="contentName" />" <logic:equal name="element" property="displayType" value="9">style="color:#ff0000"</logic:equal> ><bean:write name="element" property="contentName" /></a></div></li>
		</logic:iterate>
</ul>
</div>
<p><img src="images/l3.jpg" width="259" height="9" /></p>
<!--notice-->

<div class=bank5></div>
<p><a href="dangjian.do?method=index" target="_blank"><img src="images/hz.jpg" border="0" /></a>
</p>

<div class=bank5></div>
<p><a href="http://it/dept/gonghui/default.aspx" target="_blank"><img src="images/hz_gh.jpg" border="0" /></a>
</p>
<div class=bank5></div>


<!--yjkb-->
<p><img src="images/l1.jpg" width="259" height="10" /></p>
<div class="Lcon" style="height: 210px;">
<p><span class="fri"><a href="list.jsp?id=2684" target="_blank"><img src="images/more.jpg" /></a></span><img src="images/yj.jpg" /></p>
<div  class=bank5></div>
<ul>
<ulweb:content beanName="cl" deptId="qihua" enName="yeji" pageNum="1" pageSize="7" conditions="isDelete=0:i;isProcessing=0:i;" />
		<logic:iterate id="element" name="cl" property="objectList">
			<li><div class="break" style="width: 220px">·<bean:write name="element" property="contentNameLink" filter="false" /></div></li>
		</logic:iterate>
</ul>
</div>
<p><img src="images/l3.jpg" width="259" height="9" /></p>
<!--yjkb-->


<div class=bank5></div>


<!--mr-->
<p><img src="images/l1.jpg" width="259" height="10" /></p>
<div class="Lcon" style="height: 210px;">
<p>
<table cellpadding="0" cellspacing="0" border="0" style="padding-top: 3px;">
<tr>
<td><img src="images/m1_0.jpg" /></td>
<td><a href="market.do?method=subPage1&columnId=149" target="_blank"><img id="tag_rpt1" src="images/m1_1.jpg" class="tagSel" onmouseover="tagSelect('rpt', 1, 3)" /></a></td>
<td><a href="dept/baofei2/list.jsp?id=2584" target="_blank"><img id="tag_rpt2" src="images/m1_2.jpg" class="tag" onmouseover="tagSelect('rpt', 2, 3)" /></a></td>
<td><a href="list.jsp?id=38" target="_blank"><img id="tag_rpt3" src="images/m1_3.jpg" class="tag" onmouseover="tagSelect('rpt', 3, 3)" /></a></td>
</tr></table>
</p>
<div  class=bank5></div>


<!-- rpt01 -->
<div id="rpt1" style="display:block">
<ul>
<ulweb:content beanName="cl" deptId="market" enName="subao" pageNum="1" pageSize="7" conditions="isDelete=0:i;isProcessing=0:i;" />
		<logic:iterate id="element" name="cl" property="objectList">
			<li><div class="break" style="width: 220px">·<bean:write name="element" property="contentNameLink" filter="false" /></div></li>
		</logic:iterate>
</ul>
</div>

<!-- rpt02 -->
<div id="rpt2" style="display:none">
<ul>
<ulweb:content beanName="cl" deptId="baofei" enName="bobao" pageNum="1" pageSize="7" conditions="isDelete=0:i;isProcessing=0:i;" />
		<logic:iterate id="element" name="cl" property="objectList">
			<li><div class="break" style="width: 220px">·<bean:write name="element" property="contentNameLink" filter="false" /></div></li>
		</logic:iterate>
</ul>
</div>

<!-- rpt03 -->
<div id="rpt3" style="display:none">
<ul>
<ulweb:content beanName="cl" deptId="1110" enName="bobao" pageNum="1" pageSize="7" conditions="isDelete=0:i;isProcessing=0:i;" />
		<logic:iterate id="element" name="cl" property="objectList">
			<li><div class="break" style="width: 220px">·<bean:write name="element" property="contentNameLink" filter="false" /></div></li>
		</logic:iterate>
</ul>
</div>



</div>
<p><img src="images/l3.jpg" width="259" height="9" /></p>
<!--mr-->

<div class=bank5></div>



<!--zt-->

	<p><img src="images/l1.jpg" width="259" height="10" /></p>
	<div id="topic1" class="Lcon" style="height: 210px;">
		<p><span class="fri"><img src="images/more.jpg" /></span><img src="images/m2.jpg" /></p>
		<div class=bank5></div>
		<ulweb:content beanName="cl" deptId="0000" enName="topic" pageNum="1" pageSize="7" conditions="isDelete=0:i;isProcessing=0:i;" />
			<logic:iterate id="element" name="cl" property="objectList">
				<DIV class="title"><a href="<bean:write name="element" property="subTitle" />" target="_blank"><bean:write name="element" property="contentName" /></a></DIV>
			</logic:iterate>
		<div class=bank></div>
	</div>
	

<p><img src="images/l3.jpg" width="259" height="9" /></p>


<!--zt-->


<div class=bank5></div>


<!--xz 
<div class="xz" style="height: 180px;">
<p><img src="images/xz.jpg" width="207" height="28" /><a href="list.jsp?id=21" target="_blank"><img src="images/mor.jpg" width="50" height="28" /></a></p>
<ul class="h20">
<ulweb:content beanName="cl" deptId="0000" enName="biaoge" pageNum="1" pageSize="5" conditions="isDelete=0:i;isProcessing=0:i;" />
		<logic:iterate id="element" name="cl" property="objectList">
			<li>·<bean:write name="element" property="contentNameLink" filter="false" /></li>
		</logic:iterate>
</ul>
<div class="bank5"></div>
</div>
xz-->




</div>
<!--left-->

<!--main-->
<div class="main">
<!--Mid-->
<DIV class="Mid">
<p><!-- newsAd Begin -->
								<script language="javascript">
var imgUrl=new Array();
var imgLink=new Array();
var text=new Array();
var adNum=0;
var buttonShow=1;
var buttonPos=2; //RU:1，RD:2，LU:3，LD:4



<ulweb:content beanName="cl" deptId="0000" enName="tupian0" pageNum="1" pageSize="10" conditions="isDelete=0:i;isProcessing=0:i;" withAtt="1" />
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
								<script language="javascript" src="js/newsAd.js"></script>
								<table id=newsTable border="0" cellspacing="0" cellpadding="0" style="border: solid 1px #CCCCCC; ">
									<script language="javascript">dakularButtons();</script>
									<tr>
										<td>
											<a
												onMouseOver="displayStatusMsg();return document.returnValue"
												onMouseOut="status='';" class=px14-lh24
												href="javascript:jump2url()"><img
													style="FILTER: revealTrans(duration=1,transition=23); border:0px solid #000000"
													src="javascript:nextAd()" width=470 height=200 border=0
													name=imgUrlrotator alt=""> </a>
										</td>
									</tr>
								</table>
								<!-- newsAd End -->

</p>
<div class="bank5"></div>

<!--xz-->
<div class="Lcon1">
<p>
<table cellpadding="0" cellspacing="0" border="0"><tr>
<td><img src="images/biao.jpg" />&nbsp</td>
<td><a href="list.jsp?id=8" target="_blank"><img id="tag_mgzz1" src="images/bobao.jpg" class="tagSel" onmouseover="tagSelect('mgzz', 1, 2)" /></a></td>
<td></td>
<td><a href="list.jsp?id=3465" target="_blank"><img id="tag_mgzz2" src="images/meiti.jpg" class="tag" onmouseover="tagSelect('mgzz', 2, 2)" /></a></td>
</tr></table>
</p>
</div>
<div class="za" style="height: 260px">
<div id="mgzz1" style="display: block">
<ul>
<ulweb:content beanName="cl" deptId="0000" enName="bobao" pageNum="1" pageSize="4" conditions="isDelete=0:i;isProcessing=0:i;" />
		<logic:iterate id="element" name="cl" property="objectList">
<li><span class="fri"><bean:write name="element" property="uploadTime" format="yyyy-MM-dd" /></span>·<a href="show.do?c=<bean:write name="element" property="contentId" />" target="_blank" title="<bean:write name="element" property="contentName" />" <logic:equal name="element" property="displayType" value="9">style="color:#ff0000"</logic:equal> ><script>document.writeln("<bean:write name="element" property="contentName" />".substring(0,28));</script></a></li>
		</logic:iterate>
</ul>
<div class=line_x></div>
<ul>
<ulweb:content beanName="cl" deptId="0000" enName="bobao" pageNum="2" pageSize="4" conditions="isDelete=0:i;isProcessing=0:i;" />
		<logic:iterate id="element" name="cl" property="objectList">
<li><span class="fri"><bean:write name="element" property="uploadTime" format="yyyy-MM-dd" /></span>·<a href="show.do?c=<bean:write name="element" property="contentId" />" target="_blank" title="<bean:write name="element" property="contentName" />" <logic:equal name="element" property="displayType" value="9">style="color:#ff0000"</logic:equal> ><script>document.writeln("<bean:write name="element" property="contentName" />".substring(0,28));</script></a></li>
		</logic:iterate>
</ul>
</div>

<div id="mgzz2" style="display: none">
<ul>
<ulweb:content beanName="cl" deptId="0000" enName="meiti1" pageNum="1" pageSize="4" conditions="isDelete=0:i;isProcessing=0:i;" />
		<logic:iterate id="element" name="cl" property="objectList">
<li><span class="fri"><bean:write name="element" property="uploadTime" format="yyyy-MM-dd" /></span>·<a href="show.do?c=<bean:write name="element" property="contentId" />" target="_blank" title="<bean:write name="element" property="contentName" />" <logic:equal name="element" property="displayType" value="9">style="color:#ff0000"</logic:equal> ><script>document.writeln("<bean:write name="element" property="contentName" />".substring(0,28));</script></a></li>
		</logic:iterate>
</ul>
<div class=line_x></div>
<ul>
<ulweb:content beanName="cl" deptId="0000" enName="meiti1" pageNum="2" pageSize="4" conditions="isDelete=0:i;isProcessing=0:i;" />
		<logic:iterate id="element" name="cl" property="objectList">
<li><span class="fri"><bean:write name="element" property="uploadTime" format="yyyy-MM-dd" /></span>·<a href="show.do?c=<bean:write name="element" property="contentId" />" target="_blank" title="<bean:write name="element" property="contentName" />" <logic:equal name="element" property="displayType" value="9">style="color:#ff0000"</logic:equal> ><script>document.writeln("<bean:write name="element" property="contentName" />".substring(0,28));</script></a></li>
		</logic:iterate>
</ul>
</div>

</div>
<!--xz-->
<div class="bank5"></div>

<!-- tupian 2 -->


<div class="Hnav"><span class="fri"><a href="list.jsp?id=2671" target="_blank"><img src="images/mor1.jpg" /></a></span><img src="images/tushuo1.jpg"  /></div>
<div class="Hcon">
<table width="100%" height="120 border="0" cellspacing="0" cellpadding="0"><tr><td>
<UL class="Pic">
<ulweb:content beanName="cl" deptId="0000" enName="tupian" pageNum="1" pageSize="1" conditions="isDelete=0:i;isProcessing=0:i;" withAtt="1" />
<logic:iterate id="element" name="cl" property="objectList">
	<logic:empty name="element" property="attachmentList">
		<LI>
			<p><img src="images/o.jpg" width="116" height="85" class="bor"/></p>
			<p class="w115"><bean:write name="element" property="contentNameLink" filter="false" /></p>
		</LI>
	</logic:empty>
	<logic:notEmpty name="element" property="attachmentList">
		<logic:iterate id="e" name="element" property="attachmentList">
			<LI>
				<p><a href="show.do?c=<bean:write name="element" property="contentId" />" target="_blank"><img src="<bean:write name="e" property="displayPath" />" width="116" height="85" class="bor"/></a></p>
				<p class="w115"><bean:write name="element" property="contentNameLink" filter="false" /></p>
			</LI>
		</logic:iterate>
	</logic:notEmpty>
</logic:iterate>

<!-- tupian 3 -->
<ulweb:content beanName="cl" deptId="0000" enName="tupian" pageNum="2" pageSize="1" conditions="isDelete=0:i;isProcessing=0:i;" withAtt="1" />
<logic:iterate id="element" name="cl" property="objectList">
	<logic:empty name="element" property="attachmentList">
		<LI>
			<p><img src="images/o.jpg" width="116" height="85" class="bor"/></p>
			<p class="w115"><bean:write name="element" property="contentNameLink" filter="false" /></p>
		</LI>
	</logic:empty>
	<logic:notEmpty name="element" property="attachmentList">
		<logic:iterate id="e" name="element" property="attachmentList">
			<LI>
				<p><a href="show.do?c=<bean:write name="element" property="contentId" />" target="_blank"><img src="<bean:write name="e" property="displayPath" />" width="116" height="85" class="bor"/></a></p>
				<p class="w115"><bean:write name="element" property="contentNameLink" filter="false" /></p>
			</LI>
		</logic:iterate>
	</logic:notEmpty>
</logic:iterate>

<!-- tupian 4 -->
<ulweb:content beanName="cl" deptId="0000" enName="tupian" pageNum="3" pageSize="1" conditions="isDelete=0:i;isProcessing=0:i;" withAtt="1" />
<logic:iterate id="element" name="cl" property="objectList">
	<logic:empty name="element" property="attachmentList">
		<LI>
			<p><img src="images/o.jpg" width="116" height="85" class="bor"/></p>
			<p class="w115"><bean:write name="element" property="contentNameLink" filter="false" /></p>
		</LI>
	</logic:empty>
	<logic:notEmpty name="element" property="attachmentList">
		<logic:iterate id="e" name="element" property="attachmentList">
			<LI>
				<p><a href="show.do?c=<bean:write name="element" property="contentId" />" target="_blank"><img src="<bean:write name="e" property="displayPath" />" width="116" height="85" class="bor"/></a></p>
				<p class="w115"><bean:write name="element" property="contentNameLink" filter="false" /></p>
			</LI>
		</logic:iterate>
	</logic:notEmpty>
</logic:iterate>



</UL>
</td></tr></table>
</div>
<p><img src="images/bot1.jpg" /></p>
<!--合众播报-->

<div class="bank5"></div>


<!--公告-->
<div class="Hnav"><span class="fri"><a href="list.jsp?id=1" target="_blank"><img src="images/mor1.jpg" /></a></span><img src="images/hz2.jpg"  /></div>
<div class="Hcon" style="height: 260px">
<ul class="H24">

<ulweb:content beanName="cl" deptId="0000" enName="gonggao" pageNum="1" pageSize="5" conditions="isDelete=0:i;isProcessing=0:i;" />
		<logic:iterate id="element" name="cl" property="objectList">
			<li><span class="fri"><bean:write name="element" property="uploadTime" format="yyyy-MM-dd" /></span>·<a href="show.do?c=<bean:write name="element" property="contentId" />" target="_blank" title="<bean:write name="element" property="contentName" />" <logic:equal name="element" property="displayType" value="9">style="color:#ff0000"</logic:equal> ><script>document.writeln("<bean:write name="element" property="contentName" />".substring(0,28));</script></a></li>
		</logic:iterate>

</ul>
<div class=line_x></div>
<ul class="H24">

<ulweb:content beanName="cl" deptId="0000" enName="gonggao" pageNum="2" pageSize="5" conditions="isDelete=0:i;isProcessing=0:i;" />
		<logic:iterate id="element" name="cl" property="objectList">
			<li><span class="fri"><bean:write name="element" property="uploadTime" format="yyyy-MM-dd" /></span>·<a href="show.do?c=<bean:write name="element" property="contentId" />" target="_blank" title="<bean:write name="element" property="contentName" />" <logic:equal name="element" property="displayType" value="9">style="color:#ff0000"</logic:equal> ><script>document.writeln("<bean:write name="element" property="contentName" />".substring(0,28));</script></a></li>
		</logic:iterate>
</ul>
</div>
<p><img src="images/bot1.jpg" /></p>
<!--公告-->

</DIV>
<!--MidEND-->

<script>
//document.getElementById("newyear").style.display='block';


function showLink() {
//alert(document.body.clientWidth);

	document.getElementById("link2").style.top="130px"
	document.getElementById("link2").style.left = document.body.clientWidth / 2 + 32 + 'px';
	document.getElementById("link2").style.display = '';
	document.getElementById("xt2").style.borderLeft = '';
	document.getElementById("xt2").style.borderRight = '';
	document.getElementById("xt3").style.borderRight = '';
	
	document.getElementById("link3").style.top="130px"
	document.getElementById("link3").style.left = document.body.clientWidth / 2 + 32-226-226 + 'px';
	document.getElementById("link3").style.display = '';
	
	document.getElementById("link4").style.top="130px"
	document.getElementById("link4").style.left = document.body.clientWidth / 2 + 32-226 + 'px';
	document.getElementById("link4").style.display = '';
	
//	if(lighz!=0){
//		if(lighz1==0){
//			document.getElementById(lighz).style.filter="Alpha(Opacity=100)";
//		}
//	}

//	document.getElementById("c").style.Alpha(Opacity=100);
	
	/*
	try {
		document.getElementById("newyear").style.display='none';
	} catch (e) {}
	*/
}

function hideLink() {
	document.getElementById("link2").style.display = 'none';
	document.getElementById("link3").style.display = 'none';
	document.getElementById("link4").style.display = 'none';
}

function showLinkQ(a) {
	d = a.id
	document.getElementById(d).style.filter="Alpha(Opacity=100)";
	
}
function hideLinkQ(b) {
	var c = b.id
	document.getElementById(c).style.filter="Alpha(Opacity=80)";
}
</script>

<!--right-->
<DIV class="right">
<div id="linkbox" onmouseover="showLink()" onmouseout="hideLink()">
<p><img src="images/xt.jpg" /></p>
<div id="link1" class="xt" style="height: 330px">
<ul>
<ulweb:content beanName="cl" deptId="0000" enName="link" pageNum="1" pageSize="11" conditions="isDelete=0:i;isProcessing=0:i;" />
		<logic:iterate id="element" name="cl" property="objectList">
			<li>·<a href="<bean:write name="element" property="subTitle" />" target="_blank"><bean:write name="element" property="contentName" /></a></li>
		</logic:iterate>

</ul>
</div>

<div id="link2" onmouseout="hideLinkQ(this)" onmouseover="showLinkQ(this)"  style="position: absolute; width: 230px; display: none;filter: Alpha(Opacity=80);">
<p><img src="images/xt09.jpg" /></p>
<div id="xt2"  class="xt">
<ul>
<ulweb:content beanName="cl" deptId="0000" enName="link" pageNum="2" pageSize="11" conditions="isDelete=0:i;isProcessing=0:i;" />
		<logic:iterate id="element" name="cl" property="objectList">
			<li>·<a href="<bean:write name="element" property="subTitle" />" target="_blank"><bean:write name="element" property="contentName" /></a></li>
		</logic:iterate>
</ul>
</div>
<p><img src="images/xt004.jpg" /></p>
</div>

<div id="link4" onmouseout="hideLinkQ(this)" onmouseover="showLinkQ(this)" style="position: absolute; width: 230px; display: none; filter: Alpha(Opacity=80);">
<p><img src="images/xt09.jpg" /></p>
<div id="xt2"  class="xt" style="height:330px">
<ul>
<ulweb:content beanName="cl" deptId="0000" enName="link" pageNum="3" pageSize="11" conditions="isDelete=0:i;isProcessing=0:i;" />
		<logic:iterate id="element" name="cl" property="objectList">
			<li>·<a href="<bean:write name="element" property="subTitle" />" target="_blank"><bean:write name="element" property="contentName" /></a></li>
		</logic:iterate>
</ul>
</div>
<p><img src="images/xt004.jpg" /></p>
</div>

<div id="link3" onmouseout="hideLinkQ(this)" onmouseover="showLinkQ(this)" style="position: absolute; width: 230px; display: none ;filter: Alpha(Opacity=80);">
<p><img src="images/xt08.jpg" /></p>
<div id="xt3" class="xt" style="height:330px">
<ul>
<ulweb:content beanName="cl" deptId="0000" enName="link" pageNum="4" pageSize="11" conditions="isDelete=0:i;isProcessing=0:i;" />
		<logic:iterate id="element" name="cl" property="objectList">
			<li>·<a href="<bean:write name="element" property="subTitle" />" target="_blank"><bean:write name="element" property="contentName" /></a></li>
		</logic:iterate>
</ul>
</div>
<p><img src="images/xt003.jpg" /></p>
</div>

<p><img src="images/xt2.jpg" /></p>
</div>
<div class=bank5></div>


<!--xz-->
<div class="za" style="height: 220px">
<p>
<table cellpadding="0" cellspacing="0" border="0"><tr>
<td><img src="images/za_0.jpg" /></td>
<td><a href="pinxuan.do?method=subPage&cName=newspaper&columnId=726" target="_blank"><img id="tag_mgz1" src="images/za_1.jpg" class="tagSel" onmouseover="tagSelect('mgz', 1, 2)" /></a></td>
<td><a href="pinxuan.do?method=subPage&cName=newspaper&columnId=727" target="_blank"><img id="tag_mgz2" src="images/za_2.jpg" class="tag" onmouseover="tagSelect('mgz', 2, 2)" /></a></td>
<td><img src="images/za_3.jpg" /></td>
</tr></table>
</p>

<div id="mgz1" style="display: block">
<ul>
<ulweb:content beanName="cl" deptId="pinxuan" enName="baoxianbao" pageNum="1" pageSize="7" conditions="isDelete=0:i;isProcessing=0:i;" />
		<logic:iterate id="element" name="cl" property="objectList">
			<li><div class="break" style="width: 200px">·<a href="show.do?c=<bean:write name="element" property="contentId" />" target="_blank" title="<bean:write name="element" property="contentName" />"><bean:write name="element" property="contentName" /></a></div></li>
		</logic:iterate>
</ul>
</div>

<div id="mgz2" style="display: none">
<ul>
<ulweb:content beanName="cl" deptId="pinxuan" enName="shidian" pageNum="1" pageSize="7" conditions="isDelete=0:i;isProcessing=0:i;" />
		<logic:iterate id="element" name="cl" property="objectList">
			<li><div class="break" style="width: 200px">·<a href="show.do?c=<bean:write name="element" property="contentId" />" target="_blank" title="<bean:write name="element" property="contentName" />"><bean:write name="element" property="contentName" /></a></div></li>
		</logic:iterate>
</ul>
</div>

</div>
<!--xz-->

<p><!-- newsAd Begin -->
<script language="javascript">
var imgUrl1=new Array();
var imgLink1=new Array();
var text1=new Array();
var adNum1=0;
var buttonShow1=1;
var buttonPos1=2; //RU:1��RD:2��LU:3��LD:4



<ulweb:content beanName="cl" deptId="0000" enName="gongyi1" pageNum="1" pageSize="4" conditions="isDelete=0:i;isProcessing=0:i;" withAtt="1" />
<% int index1=1; %>
<logic:iterate id="element" name="cl" property="objectList">

	<logic:notEmpty name="element" property="attachmentList">
		<logic:iterate id="e" name="element" property="attachmentList">
imgUrl1[<%=index1%>]="<bean:write name="e" property="displayPath" filter="false" />";
imgLink1[<%=index1%>]="<bean:write name="element" property="subTitle" filter="false" />";
text1[<%=index1%>]="<bean:write name="element" property="keyWord" filter="false" />";			
<% index1++; %>
		</logic:iterate>
	</logic:notEmpty>
</logic:iterate>
</script>
							<script language="javascript" src="js/newsAd3.js"></script>
								<table id=newsTable1 border="0" cellspacing="0" cellpadding="0" style="border: solid 1px #CCCCCC; ">
									<script language="javascript">dakularButtons1();</script>
									<tr>
										<td><img src="images/gongyi1.jpg" /><a href="list.jsp?id=3524" target="_blank"><img src="images/mor.jpg" width="50" height="28" /></a>
											<a
												onMouseOver="displayStatusMsg1();return document.returnValue"
												onMouseOut="status='';" class=px14-lh24
												href="javascript:jump2url1()"><img
													style="FILTER: revealTrans(duration=1,transition=23); border:0px solid #000000"
													src="javascript:nextAd1()" width=224 height=136 border=0
													name=imgUrl1rotator alt=""> </a>
										</td>
									</tr>
								</table>
								<!-- newsAd End -->
<!--xz-->
<div class="za" style="height: 210px">
<p><img src="images/shipin.jpg" /><a href="list.do?method=zongbuHaveAtt&ptype=videoslianghui&columnId=2305" target="_blank"><img src="images/mor.jpg" width="50" height="28" /></a></p>
<ul>
<ulweb:content beanName="cl" deptId="0000" enName="shipinbb" pageNum="1" pageSize="4" withAtt="1" conditions="isDelete=0:i;isProcessing=0:i;" />
		<logic:iterate id="element" name="cl" property="objectList">
		 <logic:notEmpty name="element" property="attachmentList">
		  <logic:iterate id="e" name="element" property="attachmentList">
			 <p align="center"><a href="<bean:write name="element" property="subTitle" />" target="_blank" title="<bean:write name="element" property="contentName" />"><img src="<bean:write name="e" property="displayPath" />" width="150" height="90" class="bor"/></a></p>
		 </logic:iterate>
	     </logic:notEmpty>
	     <logic:empty name="element" property="attachmentList">
			<li>·<a href="<bean:write name="element" property="subTitle" />" target="_blank" title="<bean:write name="element" property="contentName" />"><script>document.writeln("<bean:write name="element" property="contentName" />".substring(0,15));</script></a></li>
	     </logic:empty>
		</logic:iterate>
</ul>
</div>

<!--xz-->






</DIV>
<!--rightEND-->

<div class="bank5"></div>


<p>
<ulweb:content beanName="cl" deptId="0000" enName="tupian2" pageNum="1" pageSize="1" conditions="isDelete=0:i;isProcessing=0:i;" withAtt="1" />
<logic:empty name="cl" property="objectList">
	<img src="images/bann.jpg" width="711" height="100" />
</logic:empty>

<logic:iterate id="element" name="cl" property="objectList">
	<logic:notEmpty name="element" property="subTitle">
		<a href="<bean:write name="element" property="subTitle" />" target="_blank">
	</logic:notEmpty>
	<logic:notEmpty name="element" property="attachmentList">
		<logic:iterate id="e" name="element" property="attachmentList">
			<img src="<bean:write name="e" property="displayPath" />" width="711" height="100" />
		</logic:iterate>
	</logic:notEmpty>
	<logic:notEmpty name="element" property="subTitle"></a></logic:notEmpty>
</logic:iterate>
</p>




</div>
<!--main-->


<div class="bank5"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="80" align="left" valign="top"><a href="http://it/service/itshare" target="_blank"><img src="images/k1.jpg"  /></a></td>
    <td align="center" valign="top"><a href="market.do?method=subPage2&columnId=169" target="_blank"><img src="images/k2.jpg" alt=""  /></a></td>
    <td align="center" valign="top"><a href="http://ulweb/tools/doc/pcserve.doc" target="_blank"><img src="images/k3.jpg" alt=""  /></td>
  
    <td align="center" valign="top"><a href="subpage/itsm.jsp" target="_blank"><img src="images/k4.jpg" alt=""  /></a></td>
    <td align="center" valign="top"><a href="http://fmis.ulic.com.cn:8000/OA_HTML/ulic/ManagementCenter.htm" target="_blank"><img src="images/k5.jpg" alt="" /></a></td>
    <td align="right" valign="top"><a href="pinxuan.do?method=subPage&cName=download" target="_blank"><img src="images/k6.jpg" alt=""  /></a></td>
  </tr>
</table>



<jsp:include flush="true" page="foot.jsp"></jsp:include>


</DIV>






<!-- Scroll Begin -->

<ulweb:content beanName="cl" deptId="0000" enName="flash" pageNum="1" pageSize="1" conditions="isDelete=0:i;isProcessing=0:i;" />
<logic:iterate id="element" name="cl" property="objectList">

	


<div id="Float21789" style="z-index: 1000; top:-1000px; left:-1000px; width: 400px; height:300px; position: absolute; border: solid 1px #000000; background-color: #FFFFFF">
	<center>
		<table width="100%"><tr>
<td align="left"><strong><bean:write name="element" property="keyWord" /></strong></td>
<td align="right"><a href="<bean:write name="element" property="subTitle" />" title="最大化" target="_blank"><strong>□</strong></a>&nbsp;<a href="javascript:;" title="关闭" onclick="closeVideo();return false;"><strong>×</strong></a></td>
</tr></table>
<object id="Flash1" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="400" height="300">
          <param name="movie" value="<bean:write name="element" property="subTitle" />" />
          <param name="quality" value="high" />
          <embed src="<bean:write name="element" property="subTitle" />" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="400" height="300"></embed>
        </object>
</center>
</div>
<script language=JavaScript type=text/javascript>
	//alert(document.documentElement.clientHeight);
	
	function closeVideo()  {
			document.getElementById("Float21789").style.display = 'none';
			try {
				var o = document.getElementById("Flash1");
				if (o != undefined) {
					o.parentNode.removeChild(o);
				}
			} catch (e) {
				return false;
			}
		}
	
    var csdnScrollTop=function(){
        return document.documentElement.scrollTop?document.documentElement.scrollTop:document.body.scrollTop;
        };
        function mymove21789(){
        
//document.getElementById("Float21789").style.top=csdnScrollTop() + document.documentElement.clientHeight - 30 - 300 +'px';
//document.getElementById("Float21789").style.right=3+'px';
document.getElementById("Float21789").style.top=csdnScrollTop() + document.documentElement.clientHeight / 2 - 160  +'px';
document.getElementById("Float21789").style.left=document.documentElement.clientWidth / 2 - 200 + 'px';

setTimeout("mymove21789();",50);
        }
        mymove21789();
</script>


</logic:iterate>






<!--<div id="dl1" style="z-index: 100; top:-1000px; left:10px; width: 80px; height:350px; position: absolute;background-color: #FFFFFF">
<img src="images/dl1.jpg" onclick="closeDl()" title="点击此处关闭" style="cursor:hand" />
<!-- <center><a href="javascript:void(0)" onclick="closeDl()">关闭</a></center> -->
</div>
<div id="dl2" style="z-index: 100; top:-1000px; right:10px; width: 80px; height:350px; position: absolute;background-color: #FFFFFF">
<img src="images/dl2.jpg" onclick="closeDl()" title="点击此处关闭" style="cursor:hand" />
<!-- <center><a href="javascript:void(0)" onclick="closeDl()">关闭</a></center> -->
</div> 

<script language=JavaScript type=text/javascript>
/*	//alert(document.documentElement.clientHeight);
	
	function closeDl()  {
			document.getElementById("dl1").style.display = 'none';
			document.getElementById("dl2").style.display = 'none';
	}
	
    var csdnScrollTop=function(){
        return document.documentElement.scrollTop?document.documentElement.scrollTop:document.body.scrollTop;
        };
        function mymove21789(){
        
//document.getElementById("Float21789").style.top=csdnScrollTop() + document.documentElement.clientHeight - 30 - 300 +'px';
//document.getElementById("Float21789").style.right=3+'px';
document.getElementById("dl1").style.top=csdnScrollTop() + 130  +'px';
document.getElementById("dl1").style.left= 10 + 'px';
document.getElementById("dl2").style.top=csdnScrollTop() + 130  +'px';
document.getElementById("dl2").style.right= 10 + 'px';

setTimeout("mymove21789();",100);
        }
        mymove21789();*/
</script>





<!-- Scroll End -->		



</body>
</html>

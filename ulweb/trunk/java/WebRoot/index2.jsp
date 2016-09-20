
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
<link href="css/main.css" rel="stylesheet" type="text/css" />
</head>

<body>
<DIV class=BOX>


<jsp:include flush="true" page="head.jsp"></jsp:include>


<DIV class=PageBody>
<div class="bank10"></div>
<!--left-->
<div class="left">
<!--notice-->
<p><img src="images/l1.jpg" width="259" height="10" /></p>
<div class="Lcon" style="height: 200px;">
<p align="center"><img src="images/zx1.jpg" border="0" usemap="#Map2" />
<map name="Map2" id="Map2"><area shape="rect" coords="190,14,229,32" href="list.jsp?id=6" target="_blank" /></map></p>
<div class=bank5></div>
<ul>
<ulweb:content beanName="cl" deptId="0000" enName="gongwen" pageNum="1" pageSize="6" conditions="isDelete=0:i;isProcessing=0:i;" />
		<logic:iterate id="element" name="cl" property="objectList">
			<li>·<a href="show.do?c=<bean:write name="element" property="contentId" />" target="_blank" title="<bean:write name="element" property="contentName" />" <logic:equal name="element" property="displayType" value="9">style="color:#ff0000"</logic:equal> ><script>document.writeln("<bean:write name="element" property="contentName" />".substring(0,17));</script></a></li>
		</logic:iterate>
</ul>
</div>
<p><img src="images/l3.jpg" width="259" height="9" /></p>
<!--notice-->

<div class=bank5></div>
<p><img src="images/hz.jpg" border="0" usemap="#Map3" />
<map name="Map3" id="Map3"><area shape="rect" coords="207,21,247,37" href="dangjian.do?method=index" target="_blank" /></map></p>
<div class=bank5></div>



<!--yjkb-->
<p><img src="images/l1.jpg" width="259" height="10" /></p>
<div class="Lcon" style="height: 240px;">
<p><span class="fri"><a href="list.jsp?id=2684" target="_blank"><img src="images/more.jpg" /></a></span><img src="images/yj.jpg" /></p>
<div  class=bank5></div>
<ul>
<ulweb:content beanName="cl" deptId="qihua" enName="yeji" pageNum="1" pageSize="8" conditions="isDelete=0:i;isProcessing=0:i;" />
		<logic:iterate id="element" name="cl" property="objectList">
			<li>·<bean:write name="element" property="contentNameLink" filter="false" /></li>
		</logic:iterate>
</ul>
</div>
<p><img src="images/l3.jpg" width="259" height="9" /></p>
<!--yjkb-->


<div class=bank5></div>

<!--mr-->
<p><img src="images/l1.jpg" width="259" height="10" /></p>
<div class="Lcon" style="height: 240px;">
<p><span class="fri"><a href="market.do?method=subPage1&columnId=149" target="_blank"><img src="images/more.jpg" /></a></span><img src="images/m1.jpg" /></p>
<div  class=bank5></div>
<ul>
<ulweb:content beanName="cl" deptId="market" enName="subao" pageNum="1" pageSize="8" conditions="isDelete=0:i;isProcessing=0:i;" />
		<logic:iterate id="element" name="cl" property="objectList">
			<li>·<bean:write name="element" property="contentNameLink" filter="false" /></li>
		</logic:iterate>
</ul>
</div>
<p><img src="images/l3.jpg" width="259" height="9" /></p>
<!--mr-->

<div class=bank5></div>



<!--zt-->

	<p><img src="images/l1.jpg" width="259" height="10" /></p>
	<div id="topic1" class="Lcon" style="height: 280px;">
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



<ulweb:content beanName="cl" deptId="0000" enName="tupian0" pageNum="1" pageSize="5" conditions="isDelete=0:i;isProcessing=0:i;" withAtt="1" />
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

<!--合众播报-->
<div class="Hnav"><span class="fri"><a href="list.jsp?id=8" target="_blank"><img src="images/mor1.jpg" /></a></span><img src="images/hz1.jpg"  /></div>
<div class="Hcon">



<!-- tupian 1 -->
<ulweb:content beanName="cl" deptId="0000" enName="tupian" pageNum="1" pageSize="1" conditions="isDelete=0:i;isProcessing=0:i;" withAtt="1" />
<logic:iterate id="element" name="cl" property="objectList">

<table width="100%" border="0" cellspacing="0" cellpadding="0">
<tr>
<td width="43%" align="left" valign="top">

	<logic:empty name="element" property="attachmentList">
		<img src="images/pi.jpg" width="184" height="121"  class="bor"/>
	</logic:empty>
	<logic:notEmpty name="element" property="attachmentList">
		<logic:iterate id="e" name="element" property="attachmentList">
			<a href="show.do?c=<bean:write name="element" property="contentId" />" target="_blank"><img src="<bean:write name="e" property="displayPath" />" width="184" height="121"  class="bor"/></a>
		</logic:iterate>
	</logic:notEmpty>

</td>
<td width="57%" align="left" valign="top" style="padding-left:15px;"><p id="red"><strong><a href="show.do?c=<bean:write name="element" property="contentId" />" target="_blank" id=red><bean:write name="element" property="contentName" /></a></strong></p>
<p><bean:define id="title1" name="element" property="contentString" />
<%
	int wordLen = 60;
	String str1 = title1.toString();
	if (str1 != null) {
		str1 = str1.replaceAll("<[^<>]*>", "").replaceAll("[\n\r]", "").replace(" ", "").replace("　", "");
		str1 = str1.length() > wordLen ? str1.substring(0, wordLen) + "..." : str1;
		str1 = "&nbsp;&nbsp;&nbsp;&nbsp;" + str1;
		out.println(str1);
	}
 %>
<span id="g">[<a href="show.do?c=<bean:write name="element" property="contentId" />" target="_blank">详细全文</a>]</span> </p></td>
</tr>
</table>

</logic:iterate>


<div class=line_x></div>
<ul class="H24">
<ulweb:content beanName="cl" deptId="0000" enName="bobao" pageNum="1" pageSize="5" conditions="isDelete=0:i;isProcessing=0:i;" />
		<logic:iterate id="element" name="cl" property="objectList">
			<li><span class="fri"><bean:write name="element" property="uploadTime" format="yyyy-MM-dd" /></span>
			·<a href="show.do?c=<bean:write name="element" property="contentId" />" target="_blank" title="<bean:write name="element" property="contentName" />"><script>document.writeln("<bean:write name="element" property="contentName" />".substring(0,28));</script></a></li>
		</logic:iterate>

</ul>
<div class=line_x></div>
<table width="100%" height="120" border="0" cellspacing="0" cellpadding="0"><tr><td>
<UL class="Pic">

<!-- tupian 2 -->
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

<!-- tupian 3 -->
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

<!-- tupian 4 -->
<ulweb:content beanName="cl" deptId="0000" enName="tupian" pageNum="4" pageSize="1" conditions="isDelete=0:i;isProcessing=0:i;" withAtt="1" />
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
			<li><span class="fri"><bean:write name="element" property="uploadTime" format="yyyy-MM-dd" /></span>·<a href="show.do?c=<bean:write name="element" property="contentId" />" target="_blank" title="<bean:write name="element" property="contentName" />"><script>document.writeln("<bean:write name="element" property="contentName" />".substring(0,28));</script></a></li>
		</logic:iterate>

</ul>
<div class=line_x></div>
<ul class="H24">

<ulweb:content beanName="cl" deptId="0000" enName="gonggao" pageNum="2" pageSize="5" conditions="isDelete=0:i;isProcessing=0:i;" />
		<logic:iterate id="element" name="cl" property="objectList">
			<li><span class="fri"><bean:write name="element" property="uploadTime" format="yyyy-MM-dd" /></span>·<a href="show.do?c=<bean:write name="element" property="contentId" />" target="_blank" title="<bean:write name="element" property="contentName" />"><script>document.writeln("<bean:write name="element" property="contentName" />".substring(0,28));</script></a></li>
		</logic:iterate>
</ul>
</div>
<p><img src="images/bot1.jpg" /></p>
<!--公告-->

</DIV>
<!--MidEND-->

<script>

function showLink() {
//alert(document.body.clientWidth);

	document.getElementById("link2").style.left = document.body.clientWidth / 2 + 262 + 'px';
	document.getElementById("link2").style.display = '';
}

function hideLink() {
	document.getElementById("link2").style.display = 'none';
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

<div id="link2" style="position: absolute; top: 506px; z-index: 1000; width: 230px; display: none">
<div class="xt">
<ul>
<ulweb:content beanName="cl" deptId="0000" enName="link" pageNum="2" pageSize="11" conditions="isDelete=0:i;isProcessing=0:i;" />
		<logic:iterate id="element" name="cl" property="objectList">
			<li>·<a href="<bean:write name="element" property="subTitle" />" target="_blank"><bean:write name="element" property="contentName" /></a></li>
		</logic:iterate>

</ul>
</div>
<p><img src="images/xt2.jpg" /></p>

</div>

<p><img src="images/xt2.jpg" /></p>
</div>
<div class=bank5></div>


<!--xz-->
<div class="za" style="height: 220px">
<p><img src="images/za.jpg" /><a href="dept/baofei2/list.jsp?id=2584" target="_blank"><img src="images/mor.jpg" width="50" height="28" /></a></p>
<ul>
<ulweb:content beanName="cl" deptId="baofei" enName="bobao" pageNum="1" pageSize="7" conditions="isDelete=0:i;isProcessing=0:i;" />
		<logic:iterate id="element" name="cl" property="objectList">
			<li>·<bean:write name="element" property="contentNameLink" filter="false" /></li>
		</logic:iterate>
</ul>
</div>
<!--xz-->

<div class="bank5"></div>

<ulweb:content beanName="cl" deptId="0000" enName="lianghui" pageNum="1" pageSize="1" conditions="isDelete=0:i;isProcessing=0:i;" withAtt="1" />
<logic:iterate id="element" name="cl" property="objectList">
	<logic:empty name="element" property="attachmentList">
			<p><img src="images/index/tebiejiangshu.jpg" width="229" height="170" /></p>
	</logic:empty>
	<logic:notEmpty name="element" property="attachmentList">
		<logic:iterate id="e" name="element" property="attachmentList">
			<p><logic:notEmpty name="element" property="subTitle"><a href="<bean:write name="element" property="subTitle" />" target="_blank"></logic:notEmpty>
			<img src="<bean:write name="e" property="displayPath" />" width="229" height="170" />
			<logic:notEmpty name="element" property="subTitle"></a></logic:notEmpty></p>
		</logic:iterate>
	</logic:notEmpty>
</logic:iterate>





<div class="bank5"></div>

<!--yjkb
<p><img src="images/y1.jpg"  /></p>
<div class="Lcon">
<p><img src="images/wj.jpg" /></p>
<div  class=bank5></div>
<form id="form1" name="form1" method="post" action="">
<p><strong>010某某调查问题名称？</strong></p>
<p>国家统计局公布的2009年70个大中城市房屋销售价格上涨1.5%的数据，引起社会各界的广泛关注。</p>
<p><input type="checkbox" name="checkbox" id="checkbox" />选项答案1</p>
<p>
  <input type="checkbox" name="checkbox2" id="checkbox2" />
  选项答案1</p>
<p> 
  <input type="checkbox" name="checkbox3" id="checkbox3" />
  选项答案1  </p>
<p>
  <input type="checkbox" name="checkbox4" id="checkbox4" />
  选项答案1</p>
  <p align="right"><input name="button" type="image" id="button" value="提交" src="images/t1.jpg" />&nbsp;<input name="button" type="image" id="button" value="提交" src="images/t2.jpg" /></p>
</form>
</div>
<p><img src="images/y2.jpg" /></p>
yjkb-->

<!--xz-->
<div class="za" style="height: 210px">
<p><img src="images/shipin.jpg" /><a href="list.do?method=zongbuHaveAtt&ptype=videoslianghui&columnId=2305" target="_blank"><img src="images/mor.jpg" width="50" height="28" /></a></p>
<ul>
<ulweb:content beanName="cl" deptId="0000" enName="lianghui" pageNum="1" pageSize="6" conditions="isDelete=0:i;isProcessing=0:i;" />
		<logic:iterate id="element" name="cl" property="objectList">
			<li>·<a href="<bean:write name="element" property="subTitle" />" target="_blank" title="<bean:write name="element" property="contentName" />"><script>document.writeln("<bean:write name="element" property="contentName" />".substring(0,15));</script></a></li>
		</logic:iterate>
</ul>
</div>
<!--xz-->






</DIV>
<!--rightEND-->

<div class=bank5></div>


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




<div id="Float21789" style="z-index: 1000; right: 3px; width: 100px; height:100px; position: absolute; top: 200px; border: solid 1px #CCCCCC; background-color: #FFFFFF">
	<center>
		<table width="100%"><tr>
		<td align="left"><strong>信息安全宣传活动</strong></td>
<td align="right"><a href="javascript:;" title="关闭" onclick="closeVideo()"><strong>×</strong></a></td>
</tr>
<tr>
<td colspan="2">
<iframe id="frame1" src="ppt.htm" width="510" height="405" frameborder="0" marginheight="0" marginwidth="0" ></iframe>
</td>
</tr>


</table>





</center>
</div>
<script language=JavaScript type=text/javascript>
	//alert(document.documentElement.clientHeight);
	
	function maxVideo() {
		//document.getElementById("frame1").style.width = '';
	}
	
	
	function closeVideo()  {
			document.getElementById("Float21789").style.display = 'none';
		}
	
    var csdnScrollTop=function(){
        return document.documentElement.scrollTop?document.documentElement.scrollTop:document.body.scrollTop;
        };
        function mymove21789(){
        
document.getElementById("Float21789").style.top=csdnScrollTop() + document.documentElement.clientHeight / 2 - 195  +'px';
//document.getElementById("Float21789").style.right=3+'px';
document.getElementById("Float21789").style.left=document.documentElement.clientWidth / 2 - 245 + 'px';
setTimeout("mymove21789();",50);
        }
        mymove21789();
</script>



<!-- Scroll End -->		



</body>
</html>

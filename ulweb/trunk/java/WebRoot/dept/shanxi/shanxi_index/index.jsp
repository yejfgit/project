﻿<%@ taglib uri="struts-bean.tld" prefix="bean"%>
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
<title>内网首页</title>
<link rel="stylesheet" type="text/css" href="css/main.css" />
<script src="js/main.js" language="javascript"></script>

</head>

<body>
<div class="w985 pb10">
	<div class="navbg">
		<ul class="title1">
			<li class="plr7 fl"><a class="whi" href="#">分公司通讯录</a></li>
			<li class="plr7 fl"><a class="whi" href="#">视频会议室预定</a></li>
			<li class="plr7 fl"><a class="whi" href="http://mail/" target="blank">网页邮箱</a></li>
			<li class="plr7 fl"><a class="whi" href="#">常用表格下载</a></li>
			<li class="plr7 fl"><a class="whi" href="/newapp/frame/checkshow.jsp" target="blank">文件查询</a></li>
		</ul>
		<ul class="title2">
			<li class="plr5 fl"><a class="whi" href="#">营销部</a></li>
			<li class="plr5 fl"><a class="whi" href="#">培训部</a></li>
			<li class="plr5 fl"><a class="whi" href="#">银保部</a></li>
			<li class="plr5 fl"><a class="whi" href="#">团体业务部</a></li>
			<li class="plr5 fl"><a class="whi" href="#">人事部</a></li>
			<li class="plr5 fl"><a class="whi" href="#">财务部 </a></li>
			<li class="plr5 fl"><a class="whi" href="#">运营管理部</a></li>
			<li class="plr5 fl"><a class="whi" href="#">办公室</a></li>
		</ul>
		<div class="w985 jsc lh24"><span id="toptim1" class="fl fwb plr5"></span><span id="toptimr" class="fl fwb plr5"></span> <span class="rlk fr">
		<a class="plr5 bla fwb" href="javascript:window.external.addFavorite('http://??.com','网页名字')">加入收藏</a>
		<a class="plr5 bla fwb" onclick="javascript:this.style.behavior='url(#default#homepage)';this.setHomePage('http://??.com/')"  href="javascript:">设为首页</a>
		<a class="plr5 bla fwb" href="#">总公司内网</a>
		<a class="plr5 bla fwb" href="http://www.unionlife.com.cn">合众官网</a></span></div>
	</div>
</div>
<div class="w985">
	<div class="ml fl">
		<div class="ml1t"  ><div style="padding-left:200px; padding-top:20px;"> <a href="/newapp/dept/shanxi/shanxi_second/list.jsp?id=3284" target="blank"><img src="images/nw00071_r16_more.jpg" /></a></div></div>
		<div class="ml260">
			<ul class="mlul" style="width:240px;overflow-x:hidden;white-space:nowrap">
			<ulweb:content beanName="cl" deptId="shanxi" enName="gongwen" pageNum="1" pageSize="6" conditions="isDelete=0:i;isProcessing=0:i;" />
			<logic:iterate id="element" name="cl" property="objectList">
			<li><div class="break" style="width: 180px">·<a href="/newapp/show.do?c=<bean:write name="element" property="contentId" />" target="_blank" title="<bean:write name="element" property="contentName" />" <logic:equal name="element" property="displayType" value="9">style="color:#ff0000"</logic:equal> ><bean:write name="element" property="contentName" /></a></div></li>
			</logic:iterate>
			
			</ul>
		</div>
		<div class="ml1b"></div>
		<div class="ml3t"><div style="padding-left:200px; padding-top:10px;"> <a href="/newapp/dept/shanxi/shanxi_second/list.jsp?id=3285" target="blank"><img src="images/nw00071_r16_more.jpg" /></a></div></div>
		<div class="ml260">
			<ul class="mlul" style="width:240px;overflow-x:hidden;white-space:nowrap">
						<ulweb:content beanName="cl" deptId="shanxi" enName="gonggao" pageNum="1" pageSize="6" conditions="isDelete=0:i;isProcessing=0:i;" />
		<logic:iterate id="element" name="cl" property="objectList">
			<li><div class="break" style="width: 180px">·<a href="/newapp/show.do?c=<bean:write name="element" property="contentId" />" target="_blank" title="<bean:write name="element" property="contentName" />" <logic:equal name="element" property="displayType" value="9">style="color:#ff0000"</logic:equal> ><bean:write name="element" property="contentName" /></a></div></li>
		</logic:iterate>
			
			</ul>
		</div>
		<div class="ml1b"></div>
		<div class="ml2t"><div style="padding-left:200px; padding-top:10px;"> <a href="/newapp/dept/shanxi/shanxi_second/list.jsp?id=3286" target="blank"><img src="images/nw00071_r16_more.jpg" /></a></div></div>
		<div class="ml260">
			<ul class="mlul" style="width:240px;overflow-x:hidden;white-space:nowrap">
			
						<ulweb:content beanName="cl" deptId="shanxi" enName="yeji" pageNum="1" pageSize="6" conditions="isDelete=0:i;isProcessing=0:i;" />
		<logic:iterate id="element" name="cl" property="objectList">
			<li><div class="break" style="width: 180px">·<a href="/newapp/show.do?c=<bean:write name="element" property="contentId" />" target="_blank" title="<bean:write name="element" property="contentName" />" <logic:equal name="element" property="displayType" value="9">style="color:#ff0000"</logic:equal> ><bean:write name="element" property="contentName" /></a></div></li>
		</logic:iterate>
			
			</ul>
		</div>
		<div class="ml1b"></div>
	</div>
	<div class="mm">
		<a href="/newapp/dept/shanxi/shanxi_second/list.jsp?id=3287" target="blank"><p class="bq" style="padding:0 0 0 30px;line-height:30px;font-size:14px;color:#363">工作通知书</p></a>
		<ul class="nrul2" style="overflow-x:hidden;white-space:nowrap">
					<ulweb:content beanName="cl" deptId="shanxi" enName="tongzhi" pageNum="1" pageSize="7" conditions="isDelete=0:i;isProcessing=0:i;" />
		<logic:iterate id="element" name="cl" property="objectList">
			<li><span class="fri" style="align:right;"><bean:write name="element" property="uploadTime" format="yyyy-MM-dd" /></span><a href="/newapp/show.do?c=<bean:write name="element" property="contentId" />" target="_blank" title="<bean:write name="element" property="contentName" />"><script>document.writeln("<bean:write name="element" property="contentName" />".substring(0,28));</script></a>
			</li>
		</logic:iterate>
		</ul>
		<div class="qh">
			<div class="bq"> <a href="/newapp/dept/shanxi/shanxi_second/list.jsp?id=3288" target="blank"><span id="tab1" class="border_b">新闻播报</span></a> 
				<!--				<span id="tab2">合众公告</span>--> 
				<!--以上是被隐藏的切换标签--> 
			</div>
			<div id="nr1">
<ulweb:content beanName="cl" deptId="shanxi" enName="tupian" pageNum="1" pageSize="1" conditions="isDelete=0:i;isProcessing=0:i;" withAtt="1" />
<logic:iterate id="element" name="cl" property="objectList">

<table width="100%" border="0" cellspacing="0" cellpadding="0">
<tr align="center">
<td width="4%"></td>
<td width="43%" height="125px" align="center" valign="">

	<logic:empty name="element" property="attachmentList">
		<img src="images/pi.jpg" width="184" height="121"  class="bor"/>
	</logic:empty>
	<logic:notEmpty name="element" property="attachmentList">
		<logic:iterate id="e" name="element" property="attachmentList">
			<a href="/newapp/show.do?c=<bean:write name="element" property="contentId" />" target="_blank"><img src="/newapp/<bean:write name="e" property="displayPath" />" width="184" height="121"  class="bor"/></a>
		</logic:iterate>
	</logic:notEmpty>

</td>
<td width="48%" align="left" valign="middle" style="padding-left:15px;"><p id="red"><strong><a href="/newapp/show.do?c=<bean:write name="element" property="contentId" />" target="_blank" id=red><bean:write name="element" property="contentName" /></a></strong></p>
<p><bean:define id="title1" name="element" property="contentString" />
<%
	int wordLen = 50;
	String str1 = title1.toString();
	if (str1 != null) {
		str1 = str1.replaceAll("<[^<>]*>", "").replaceAll("[\n\r]", "").replace(" ", "").replace("　", "");
		str1 = str1.length() > wordLen ? str1.substring(0, wordLen) + "..." : str1;
		str1 = "&nbsp;&nbsp;&nbsp;&nbsp;" + str1;
		out.println(str1);
	}
 %>
<span id="g">[<a href="/newapp/show.do?c=<bean:write name="element" property="contentId" />" target="_blank">详细全文</a>]</span> </p></td>
<td width="18%">&nbsp;</td>
</tr>
</table>

</logic:iterate>
				<ul class="nrul">
					
							<ulweb:content beanName="cl" deptId="shanxi" enName="bobao" pageNum="1" pageSize="4" conditions="isDelete=0:i;isProcessing=0:i;" />
		<logic:iterate id="element" name="cl" property="objectList">
			<li>
			<span class="fri" style="align:right;"><bean:write name="element" property="uploadTime" format="yyyy-MM-dd" /></span><a href="/newapp/show.do?c=<bean:write name="element" property="contentId" />" target="_blank" title="<bean:write name="element" property="contentName" />"><script>document.writeln("<bean:write name="element" property="contentName" />".substring(0,28));</script></a>
				</li>
		</logic:iterate>
				</ul>
				<div class="w468">

					<UL class="Pic">
<ulweb:content beanName="cl" deptId="shanxi" enName="tupian" pageNum="2" pageSize="1" conditions="isDelete=0:i;isProcessing=0:i;" withAtt="1" />
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
						<p><a href="/newapp/show.do?c=<bean:write name="element" property="contentId" />" target="_blank"><img src="/newapp/<bean:write name="e" property="displayPath" />" width="116" height="85" class="bor"/></a></p>
				<p class="w115"><bean:write name="element" property="contentNameLink" filter="false" /></p>
			</LI>
		</logic:iterate>
	</logic:notEmpty>
</logic:iterate>

<!-- tupian 3 -->
<ulweb:content beanName="cl" deptId="shanxi" enName="tupian" pageNum="3" pageSize="1" conditions="isDelete=0:i;isProcessing=0:i;" withAtt="1" />
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
				<p><a href="/newapp/show.do?c=<bean:write name="element" property="contentId" />" target="_blank"><img src="/newapp/<bean:write name="e" property="displayPath" />" width="116" height="85" class="bor"/></a></p>
				<p class="w115"><bean:write name="element" property="contentNameLink" filter="false" /></p>
			</LI>
		</logic:iterate>
	</logic:notEmpty>
</logic:iterate>

<!-- tupian 4 -->
<ulweb:content beanName="cl" deptId="shanxi" enName="tupian" pageNum="4" pageSize="1" conditions="isDelete=0:i;isProcessing=0:i;" withAtt="1" />
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
								<p><a href="/newapp/show.do?c=<bean:write name="element" property="contentId" />" target="_blank"><img src="/newapp/<bean:write name="e" property="displayPath" />" width="116" height="85" class="bor"/></a></p>
				<p class="w115"><bean:write name="element" property="contentNameLink" filter="false" /></p>
			</LI>
		</logic:iterate>
	</logic:notEmpty>
</logic:iterate>



</UL>
				</div>
			</div>

		</div>
	</div>
	<div id="mr">
		<div class="mrt"><div style="padding-left:180px; padding-top:10px;"> <img src="images/nw00071_r16_more.jpg" /></div></div>
		<div class="mrlist">
			<ul class="mrlist_ul">
		<ulweb:content beanName="cl" deptId="shanxi" enName="link" pageNum="1" pageSize="11" conditions="isDelete=0:i;isProcessing=0:i;" />
		<logic:iterate id="element" name="cl" property="objectList">
			<li>·<a href="<bean:write name="element" property="subTitle" />" target="_blank"><bean:write name="element" property="contentName" /></a></li>
		</logic:iterate>
			</ul>
		</div>
		<div class="mrb"></div>
		<div id="mr_po">
			<ul>
			</ul>
		</div>
		<div class="zwfg">
			<div class="zwfgtp"><div style="padding-left:180px; padding-top:10px;overflow-x:hidden;white-space:nowrap"> <a href="/newapp/dept/shanxi/shanxi_second/list.jsp?id=3291" target="blank"><img src="images/nw00071_r16_more.jpg" /></a></div></div>
			<ul class="mrlist_ul" style="width:170px;overflow-x:hidden;white-space:nowrap">
					<ulweb:content beanName="cl" deptId="shanxi" enName="fengcai" pageNum="1" pageSize="9" conditions="isDelete=0:i;isProcessing=0:i;" />
		<logic:iterate id="element" name="cl" property="objectList">
			<li><div class="break" style="width: 180px"><a href="/newapp/show.do?c=<bean:write name="element" property="contentId" />" target="_blank" title="<bean:write name="element" property="contentName" />" <logic:equal name="element" property="displayType" value="9">style="color:#ff0000"</logic:equal> ><bean:write name="element" property="contentName" /></a></div></li>
		</logic:iterate>
			</ul>
		</div>
	</div>
</div>
<div class="w985 bot tc"> <a href="/newapp/dept/shanxi/shanxi_index/index.jsp" class="bla">首页</a> | <a href="http://www.unionlife.com.cn/" class="bla">关于合众</a> | <a href="/newapp/admin/login.jsp" class="bla">系统管理</a><ulweb:content beanName="cl" deptId="0000" enName="mail_address" pageNum="1" pageSize="1" conditions="isDelete=0:i;" />
		<logic:iterate id="element" name="cl" property="objectList">
			  |  <a href="/newapp/show.do?c=<bean:write name="element" property="contentId" />">邮箱地址簿更新</a>[<bean:write name="element" property="updateTime" format="yyyy-MM-dd" />]
		</logic:iterate> </div>
<script language="javascript">
time();

</script>
</body>
</html>

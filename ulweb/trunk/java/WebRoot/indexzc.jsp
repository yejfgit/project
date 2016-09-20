
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
<title>内网首页</title>
<link rel="stylesheet" type="text/css" href="dept/zcweb/css/main.css" />

<script type="text/javascript" src="js/top.js"></script>
<script type="text/javascript" src="js/common.js"></script>



</head>

<body>
<!--[if IE 8]>
<style type="text/css">
.ml260h{height:205px;}
.zwfg{width:228px;height:265px;border:1px solid #c8c8c8;overflow:hidden}
</style>
<![endif]-->
<!--[if IE 7]>
<style type="text/css">
.ml260h{height:210px;}
.zwfg{width:228px;height:280px;border:1px solid #c8c8c8;overflow:hidden}
</style>
<![endif]-->
<div class="w985"> <span id="toptim1"></span> <span id="toptimr"></span>
	<ul class="topul">
		<li><a href="#" class="bla">设为首页</a></li>
		<li><a href="#" class="bla">加入收藏</a></li>
		<li><a href="#" class="bla">网站地图</a></li>
		<li><a href="#" class="bla">合众内网</a></li>
		<li><a href="#" class="bla">合众首页</a></li>
	</ul>
</div>
<div class="nav">
	<div class="navl"></div>
	<div class="navm">
		<div class="logo pt25 fl"> <a href="#"><img src="dept/zcweb/images/nw0007_r2_c2.jpg" width="132" height="62" alt="合众人寿"/></a> </div>
		<div class="fl navtab10">
			<div class="navtabl fl"></div>
			<div class="navtabm fl">
				<ul>
					<li><a class="bai lh30" href="http://ehr/hr/share/addressList.do">通讯录</a></li>
					<li><a class="bai lh30" href="#">常用软件</a></li>
					<li><a class="bai lh30" href="#">网页邮箱</a></li>
					<li><a class="bai lh30" href="#">常用表格下载</a></li>
					<li><a class="bai lh30" href="#">文件查询</a></li>
					<li><a class="bai lh30" href="#">员工手册</a></li>
				</ul>
			</div>
			<div class="navtabr fl"></div>
		</div>
		<div class="navbr1">
<p style="padding-left:40px; padding-top: 5px">
<ulweb:content beanName="cl" deptId="0000" enName="dept1" pageNum="1" pageSize="8" conditions="isDelete=0:i;isProcessing=0:i;" />

		<logic:iterate id="element" name="cl" property="objectList">
			<a href='<bean:write name="element" property="subTitle" />' target="_blank"><bean:write name="element" property="contentName" /></a> | 
		</logic:iterate>
</p>
<span>&nbsp;</span>
<p style="padding-left:40px;">
<ulweb:content beanName="cl" deptId="0000" enName="dept2" pageNum="1" pageSize="8" conditions="isDelete=0:i;isProcessing=0:i;" />

		<logic:iterate id="element" name="cl" property="objectList">
			<a href='<bean:write name="element" property="subTitle" />' target="_blank">
			<bean:write name="element" property="contentName" />
			</a> | 
		</logic:iterate>
</p>
		</div>
		<!--	<div class="fl g83">总公司PC维护热线 88333</div>--> 
	</div>
	<div class="navr"></div>
</div>
<div class="w985">
	<div class="ml fl">
		<div class="ml1t"><span class="pr10 fr pt20">more</span></div>
		<div class="ml260" style="overflow-x:hidden;white-space:nowrap">
			<ul class="mlul">
		<ulweb:contentquery beanName="cl" deptId="0000" enName="gongwen" pageNum="1" pageSize="14" />
		<logic:iterate id="element" name="cl" property="objectList">
			<li><div class="break" style="width: 220px">·<a href="show.do?c=<bean:write name="element" property="contentId" />" target="_blank" title="<bean:write name="element" property="contentName" />" <logic:equal name="element" property="displayType" value="9">style="color:#ff0000"</logic:equal> ><bean:write name="element" property="contentName" /></a></div></li>
		</logic:iterate>
			</ul>
		</div>
		<div class="ml1b"></div>
		<div class="ml2t"><span class="fr lh30 pr10">more</span></div>
		<div class="ml260 ml260h" style="overflow-x:hidden;white-space:nowrap">
			<ul class="mlul">
		<ulweb:contentquery beanName="cl" deptId="0000" enName="gongwen" pageNum="1" pageSize="8" />
		<logic:iterate id="element" name="cl" property="objectList">
			<li><div class="break" style="width: 220px">·<a href="show.do?c=<bean:write name="element" property="contentId" />" target="_blank" title="<bean:write name="element" property="contentName" />" <logic:equal name="element" property="displayType" value="9">style="color:#ff0000"</logic:equal> ><bean:write name="element" property="contentName" /></a></div></li>
		</logic:iterate>
			</ul>
		</div>
		<div class="ml1b"></div>
	</div>
	<div class="mm">
<div id="tabpic"> 
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
													src="#" width=470 height=200 border=0
													name=imgUrlrotator alt=""> </a><script>nextAd();</script>
										</td>
									</tr>
								</table>
								<!-- newsAd End -->

</p></div>
		<div class="qh">
			<div class="bq"> <span id="tab1" class="border_b">合众资产播报</span> 
				<!--				<span id="tab2">合众公告</span>--> 
				<!--以上是被隐藏的切换标签--> 
			</div>
			<div id="nr1">
<ulweb:content beanName="cl" deptId="0000" enName="tupian" pageNum="1" pageSize="1" conditions="isDelete=0:i;isProcessing=0:i;" withAtt="1" />
<logic:iterate id="element" name="cl" property="objectList">

<table width="100%" border="0" cellspacing="0" cellpadding="0">
<tr>
<td width="43%" align="left" valign="">

	<logic:empty name="element" property="attachmentList">
		<img src="images/pi.jpg" width="184" height="121"  class="bor"/>
	</logic:empty>
	<logic:notEmpty name="element" property="attachmentList">
		<logic:iterate id="e" name="element" property="attachmentList">
			<a href="show.do?c=<bean:write name="element" property="contentId" />" target="_blank"><img src="<bean:write name="e" property="displayPath" />" width="184" height="121"  class="bor"/></a>
		</logic:iterate>
	</logic:notEmpty>

</td>
<td width="57%" align="left" valign="middle" style="padding-left:15px;"><p id="red"><strong><a href="show.do?c=<bean:write name="element" property="contentId" />" target="_blank" id=red><bean:write name="element" property="contentName" /></a></strong></p>
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
				<ul class="nrul">
		<ulweb:content beanName="cl" deptId="0000" enName="bobao" pageNum="1" pageSize="5" conditions="isDelete=0:i;isProcessing=0:i;" />
		<logic:iterate id="element" name="cl" property="objectList">
			<li>
			<span class="fri" style="align:right;"><bean:write name="element" property="uploadTime" format="yyyy-MM-dd" /></span>·<a href="show.do?c=<bean:write name="element" property="contentId" />" target="_blank" title="<bean:write name="element" property="contentName" />"><script>document.writeln("<bean:write name="element" property="contentName" />".substring(0,28));</script></a>
				</li>
		</logic:iterate>
	
				</ul>
				<div class="w468">
<div class="Hcon">
<table width="100%" height="120 border="0" cellspacing="0" cellpadding="0"><tr>
<td>
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
				<p><a href="<bean:write name="element" property="subTitle" />" target="_blank"><img src="<bean:write name="e" property="displayPath" />" width="116" height="85" class="bor"/></a></p>
				<p class="w115"><a href="<bean:write name="element" property="subTitle" />" target="_blank"><bean:write name="element" property="contentName" filter="false" /></a></p>
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
				</div>
			</div>
			<!--<div id="nr2">
				<dl class="nrdl">
					<dt style="float:left"><a href="#"><img src="dept/zcweb/images/nw00071_r5_c2.jpg" width="184" height="121" alt="何种安心宝" class="fl"/></a></dt>
					<dd>
						<p class="red">"合众安心宝"新品上市发布会在京召开</p>
						<p class="psj">4月28日上午十点,合众人寿于北京合众大厦国际展厅隆重召开了安心保新品上市发布会</p><p class="tr"><a href="#" class="gre">[详细全文]</a></p>
					</dd>
				</dl>
				<ul class="nrul">
					<li><a href="#" class="bla">关爱贫困学童&nbsp;捐助爱心之水一记广西分公司成功举行和</a><span>2012-5-28</span></li>
					<li><a href="#" class="bla">关爱贫困学童&nbsp;捐助爱心之水一记广西分公司成功举行和</a><span>2012-5-28</span></li>
					<li><a href="#" class="bla">关爱贫困学童&nbsp;捐助爱心之水一记广西分公司成功举行和</a><span>2012-5-28</span></li>
					<li><a href="#" class="bla">关爱贫困学童&nbsp;捐助爱心之水一记广西分公司成功举行和</a><span>2012-5-28</span></li>
					<li><a href="#" class="bla">关爱贫困学童&nbsp;捐助爱心之水一记广西分公司成功举行和</a><span>2012-5-28</span></li>
				</ul>
				<div class="w468">
					<dl class="fl nrdl2">
						<dt><a href="#"><img src="dept/zcweb/images/nw00071_r12_c14.jpg" width="116" height="85" alt="地震捐款" /></a></dt>
						<dd><a href="#" class="bla">测试测试测试测试测试测试测试测试测试测试</a></dd>
					</dl>
					<dl class="fl nrdl2">
						<dt><a href="#"><img src="dept/zcweb/images/nw00071_r12_c14.jpg" width="116" height="85" alt="地震捐款" /></a></dt>
						<dd><a href="#" class="bla">测试测试测试测试测试测试测试测试测试测试</a></dd>
					</dl>
					<dl class="fl nrdl2">
						<dt><a href="#"><img src="dept/zcweb/images/nw00071_r12_c14.jpg" width="116" height="85" alt="地震捐款" /></a></dt>
						<dd><a href="#" class="bla">测试测试测试测试测试测试测试测试测试测试</a></dd>
					</dl>
				</div>
			</div>--> 
			<!--以上是被隐藏的切换内容--> 
		</div>
	</div>
	<div class="mri">
	<div id="mr">
		<div class="mrt"></div>
		<div class="mrlist" style="overflow-x:hidden;white-space:nowrap" >
			<ul class="mlul">
		<ulweb:contentquery beanName="cl" deptId="0000" enName="gongwen" pageNum="1" pageSize="14" />
		<logic:iterate id="element" name="cl" property="objectList">
			<li><div class="break" style="width: 170px">·<a href="show.do?c=<bean:write name="element" property="contentId" />" target="_blank" title="<bean:write name="element" property="contentName" />" <logic:equal name="element" property="displayType" value="9">style="color:#ff0000"</logic:equal> ><bean:write name="element" property="contentName" /></a></div></li>
		</logic:iterate>
			</ul>
		</div>
		<div class="mrb"></div>
		<div id="mr_po">
			<ul>
				<li><a href="#">测试测试</a></li>
				<li><a href="#">测试测试</a></li>
				<li><a href="#">测试测试</a></li>
				<li><a href="#">测试测试</a></li>
				<li><a href="#">测试测试</a></li>
				<li><a href="#">测试测试</a></li>
				<li><a href="#">测试测试</a></li>
				<li><a href="#">测试测试</a></li>
			</ul>
		</div>
		
	</div><div class="zwfg" style="overflow-x:hidden;white-space:nowrap" >
			<div class="zwfgtp"><span class="fr lh30 pr10">more</span></div>
			<ul class="mlul">
		<ulweb:contentquery beanName="cl" deptId="0000" enName="gongwen" pageNum="1" pageSize="8" />
		<logic:iterate id="element" name="cl" property="objectList">
			<li><div class="break" style="width: 170px">·<a href="show.do?c=<bean:write name="element" property="contentId" />" target="_blank" title="<bean:write name="element" property="contentName" />" <logic:equal name="element" property="displayType" value="9">style="color:#ff0000"</logic:equal> ><bean:write name="element" property="contentName" /></a></div></li>
		</logic:iterate>
			</ul>
		</div></div>
</div>
<div class="w985 bot tc"> <a href="#" class="bla">首页</a> | <a href="#" class="bla">关于合众</a> | <a href="#" class="bla">系统管理</a> | <a href="#" class="bla">邮箱地址簿更新[2012-05-03]</a> </div>
</body>
</html>

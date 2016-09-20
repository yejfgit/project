

<%@ taglib uri="struts-bean.tld" prefix="bean"%>
<%@ taglib uri="struts-html.tld" prefix="html"%>
<%@ taglib uri="struts-logic.tld" prefix="logic"%>
<%@ taglib uri="ulweb-list.tld" prefix="ulweb"%>

<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.ulweb.entity.UlAttachment,com.ulic.ulweb.frame.constant.Constant,com.ulic.ulweb.ulweb.web.action.IndexAction" pageEncoding="UTF-8"%>
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


<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><ulweb:navbar beanName="nb"  deptId="0000" enName="<%=enName%>" columnId="<%=columnId %>" />
<bean:write name="nb" /></title>
<link rel="stylesheet" type="text/css" href="css/second.css" />
<script src="js/main.js" language="javascript"></script>
<script language="JavaScript" src="js/list.js"></script>
<base href="<%=basePath%>"> 
</head>

<body>
				<div class="w985 pb10">
					<div class="navbg">
						<ul class="title1">
							<li class="plr7 fl"><a class="whi" href="#">分公司通讯录</a></li>
							<li class="plr7 fl"><a class="whi" href="#">视频会议室预定</a></li>
							<li class="plr7 fl"><a class="whi" href="#">网页邮箱</a></li>
							<li class="plr7 fl"><a class="whi" href="#">常用表格下载</a></li>
							<li class="plr7 fl"><a class="whi" href="#">文件查询</a></li>
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
<!------------------------------主要部分---------------------->
			<div class="w985">
							<div class="ml fl">
									<div class="ml1t"  ></div>
									<div class="ml3t"  >
									<strong><ulweb:column beanName="sl" deptId="0000" enName="<%=enName %>" columnId="<%=columnId %>" withSub="1" />
<div class="men"><strong id="g"><bean:write name="sl" property="columnName" /></strong></div>		
<ul class="menli">
<logic:iterate id="element" name="sl" property="subColumns">
	<li id="g">·<a href="list.jsp?id=<bean:write name="element" property="columnId" />"><bean:write name="element" property="columnName" /></a>
	</li>
</logic:iterate></strong>
									</div>
									<div class="ml2t"  ></div>
							 </div>
							 <div class="mainbody">
										 <div class="banner">
												<img src="images/cbg2.jpg"  />
										 </div>
										 <div class="newslist" >
														 <ul>
<ulweb:content beanName="cl" deptId="0000"
												enName="<%=enName%>"
												columnId="<%=columnId %>"
												keyWord="<%=keyWord %>"
												conditions="isDelete=0:i;isProcessing=0:i;"
												pageNum="<%=pageNum %>" />

		<logic:iterate id="element" name="cl" property="objectList">
			<li>
			·<bean:write name="element" property="contentNameLink" filter="false" />&nbsp;&nbsp;
			<bean:write name="element" property="new" filter="false" />&nbsp;&nbsp;
			<bean:write name="element" property="attachmentLink" filter="false" /></li>
		</logic:iterate>
<bean:define id="cid" name="element" property="columnId" />

<% if (enName == null && columnId == 0) { %>
<ulweb:column beanName="cc" deptId="0000" columnId="<%=Integer.parseInt(cid.toString()) %>" />
[&nbsp;<bean:write name="cc" property="columnName" />&nbsp;]	
<% } %>
														 </ul>
														 <!--next-->
<DIV><bean:write name="cl" property="pageTag" filter="false" />	</DIV>
<!--next-->
										 </div>
						</div>
			</div>
	<div class="w985 bot tc">
		<a href="/newapp/dept/shanxi/shanxi_index/index.jsp" class="bla">首页</a> | <a href="http://www.unionlife.com.cn/" class="bla">关于合众</a> | <a href="/newapp/admin/login.jsp" class="bla">系统管理</a><ulweb:content beanName="cl" deptId="0000" enName="mail_address" pageNum="1" pageSize="1" conditions="isDelete=0:i;" />
		<logic:iterate id="element" name="cl" property="objectList">
			  |  <a href="/newapp/show.do?c=<bean:write name="element" property="contentId" />">邮箱地址簿更新</a>[<bean:write name="element" property="updateTime" format="yyyy-MM-dd" />]
		</logic:iterate>
	</div>
<map name="Map" id="Map"><area shape="rect" coords="56,3,124,21" href="#" /><area shape="rect" coords="153,3,231,20" href="#" /><area shape="rect" coords="265,2,394,25" href="#" /><area shape="rect" coords="430,0,528,25" href="#" /><area shape="rect" coords="565,-1,640,25" href="#" /><area shape="rect" coords="676,3,760,24" href="#" /></map>
</body>
</html>

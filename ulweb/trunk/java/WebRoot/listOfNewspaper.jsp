
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
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><ulweb:navbar beanName="nb"  deptId="0000" enName="<%=enName%>" columnId="<%=columnId %>" />
<bean:write name="nb" /></title>
<script type="text/javascript" src="js/top.js"></script>
<script language="JavaScript" src="script/list.js"></script>
<link href="css/main.css" rel="stylesheet" type="text/css" />
</head>

<body>
<DIV class=BOX>

<jsp:include flush="true" page="head.jsp"></jsp:include>


<DIV class=PageBody>
<div class="bank10"></div>
<!--left-->
<div class="w211">
<p><img src="images/cbg1.jpg" /></p>



<ulweb:column beanName="sl" deptId="0000" enName="history" columnId="3166" withSub="1" />
<div class="men"><strong id="g"><bean:write name="sl" property="columnName" /></strong></div>		
<ul class="menli">
<logic:iterate id="element" name="sl" property="subColumns">
	<li id="g">·<a href="<bean:write name="element" property="subTitle" />"><bean:write name="element" property="columnName" /></a>
	</li>
</logic:iterate>
</ul>


<p><img src="images/bgpic.jpg" /></p>
</div>


<!--left-->

<!--main-->
<div class="w770">
<p><img src="images/cbg2.jpg" /></p>
<div class="place"><bean:write name="nb" /></div>

<div>
<!-- Description Begin --> 
&nbsp;&nbsp;&nbsp;&nbsp;<a href="http://10.13.6.11/tools/itresource/AdbeRdr70_enu.rar" target="_blank" style="color: blue">pdf阅读器下载</a>
&nbsp;&nbsp;<span style="color: blue">*</span>如果需要登录，请使用域用户名和密码。
<!-- Description End -->
</div>

<div class="newlist">


<DIV class="con">
<ul>


<ulweb:content beanName="cl" deptId="0000"
												enName="history"
												columnId="3166"
												keyWord="<%=keyWord %>"
												conditions="isDelete=0:i;isProcessing=0:i;"
									/>

		<logic:iterate id="element" name="cl" property="objectList">
			<li><span class="fri"><bean:write name="element" property="uploadTime" format="yyyy-MM-dd" /></span>
			·<a href="<bean:write name="element" property="subTitle" />"><bean:write name="element" property="contentName" filter="false" /></a>&nbsp;&nbsp;
			<bean:write name="element" property="new" filter="false" />&nbsp;&nbsp;
			<bean:write name="element" property="attachmentLink" filter="false" /></li>
		</logic:iterate>
<bean:define id="cid" name="element" property="columnId" />

<% if (enName == null && columnId == 0) { %>
<ulweb:column beanName="cc" deptId="0000" columnId="<%=Integer.parseInt(cid.toString()) %>" />
[&nbsp;<bean:write name="cc" property="columnName" />&nbsp;]	
<% } %>

</ul>


</DIV>


</div>



</div>


<!--main-->



<jsp:include flush="true" page="foot.jsp"></jsp:include>


</DIV>

<map name="Map" id="Map"><area shape="rect" coords="56,3,124,21" href="#" /><area shape="rect" coords="153,3,231,20" href="#" /><area shape="rect" coords="265,2,394,25" href="#" /><area shape="rect" coords="430,0,528,25" href="#" /><area shape="rect" coords="565,-1,640,25" href="#" /><area shape="rect" coords="676,3,760,24" href="#" /></map>
</body>
</html>

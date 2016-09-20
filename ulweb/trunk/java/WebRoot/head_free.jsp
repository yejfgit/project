
<%@ taglib uri="struts-bean.tld" prefix="bean"%>
<%@ taglib uri="struts-html.tld" prefix="html"%>
<%@ taglib uri="struts-logic.tld" prefix="logic"%>
<%@ taglib uri="ulweb-list.tld" prefix="ulweb"%>

<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.ulweb.entity.UlAttachment,com.ulic.ulweb.frame.constant.Constant,com.ulic.ulweb.ulweb.web.action.IndexAction" pageEncoding="UTF-8"%>

<!--hd--->

<DIV class="hd">
<!-- 新年图片 -->
<div style="display: none" id="newyear"><a href="javascript:;" title="点击关闭" onclick="this.style.display='none';return false;"><img src="images/2011.jpg" width="985" border="0" /></a></div>
<!-- 新年图片 -->
<div class="top">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
<tr>
<td height="24" align="left">您好！今天是<script type="text/javascript">
	var dt = new Date();
	var weekday;
	switch (dt.getDay()) {
		case 0: weekday = "日"; break;
		case 1: weekday = "一"; break;
		case 2: weekday = "二"; break;
		case 3: weekday = "三"; break;
		case 4: weekday = "四"; break;
		case 5: weekday = "五"; break;
		case 6: weekday = "六"; break;
	}	
	document.writeln(dt.getFullYear() + "年" + (dt.getMonth() + 1) + "月" + dt.getDate() + "日 星期" + weekday);
	
	setTimeout('document.getElementById("newyear").style.display="none"', 5000);
</script></td>
<td align="right" id="g">
保险“三假”举报电话 <strong>027-85481548</strong> &nbsp;
    <img src="images/h2-03.jpg" width="17" height="15"  align="absmiddle"/><a href="http://www.unionlife.com.cn/" target="_blank">公司外网</a></td>
</tr>
</table>
</div>
<div class="nav">
<table width="985" border="0" cellspacing="0" cellpadding="0" height="84">
<tr>
<td width="19%" align="left" valign="top"><div class="logo"><a href="index.do"><img src="images/logo.jpg" /></a></div></td>
<td width="83%" align="left" valign="top" style="padding-top:15px;">
<p style="padding-bottom:10px;"><img src="images/nav.jpg" width="780" height="23" border="0" usemap="#Map" /></p>
<table cellpadding="0" cellspacing="0" border="0" width="100%">

<tr>
<td width="627">

<p style="padding-left:40px; padding-top: 5px">
		
			<a href='market.do?method=index' target="_blank">营销部</a> | 
		
			<a href='yunying.do?method=index' target="_blank">运营中心</a> | 
		
			<a href='wukong.do?method=index' target="_blank">物控部</a> | 
		
			<a href='http://ulweb/app/dept/qihua/mainNew.jsp' target="_blank">战略企划部</a> | 
		
			<a href='peixun2.do?method=index' target="_blank">培训部</a> | 
		
			<a href='dept2l.do?method=index&amp;dept=1110' target="_blank">银行保险部</a> | 
		
			<a href='caiwu.do?method=index' target="_blank">财务部</a> | 

</p>
<p style="padding-left:40px;">


		
			<a href='hr.do?method=subPage1&amp;dept=hr' target="_blank">
			人力资源部
			</a> | 
		
			<a href='dept/baofei2/index.jsp' target="_blank">
			保费部
			</a> | 
		
			<a href='pinxuan.do?method=index' target="_blank">
			品牌服务网站
			</a> | 
		
			<a href='falv.do?method=index' target="_blank">
			法律合规部
			</a> | 


</p>
</td>


<td align="left" valign="top">
<ulweb:content beanName="cl" deptId="0000" enName="service_promise" pageNum="1" pageSize="1" conditions="isDelete=0:i;isProcessing=0:i;" />
		<logic:iterate id="element" name="cl" property="objectList"><a href='<bean:write name="element" property="subTitle" />' target="_blank"><img src="images/service_promise.gif" /></a></logic:iterate>
</td>



</tr>

</table>



</td>

</tr>
</table>
</div>
</DIV>

<map name="Map" id="Map">
<area shape="rect" coords="9,1,78,22" href="http://10.13.6.12/hr/share/addressList.do" target="_blank" />
<area shape="rect" coords="106,0,182,22" href="list.jsp?id=1328" target="_blank" />
<area shape="rect" coords="218,-1,347,22" href="http://10.18.8.41" target="_blank" />
<area shape="rect" coords="383,0,481,25" href="list.jsp?id=21" target="_blank" />
<area shape="rect" coords="518,-2,593,24" href="frame/checkshow.jsp" target="_blank" />
<area shape="rect" coords="622,1,752,22" href="http://10.17.2.2:9080/jira/secure/Dashboard.jspa" target="_blank" />
</map>

<!--include file = "header.asp"-->
<!--hd结束--->

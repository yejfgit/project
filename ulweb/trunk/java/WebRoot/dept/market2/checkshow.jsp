<%@ taglib uri="struts-bean.tld" prefix="bean"%>
<%@ taglib uri="struts-html.tld" prefix="html"%>
<%@ taglib uri="struts-logic.tld" prefix="logic"%>
<%@ taglib uri="ulweb-list.tld" prefix="ulweb"%>
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

<%
		UlTemplate t = (UlTemplate)request.getAttribute("template");
	
		DisplayOnPage d = new DisplayOnPage();
		d.setRequest(request);
		
	%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style>
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
</HEAD>
<script type="text/javascript" src="dept/market2/market.js"></script>
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
<style>
.top1{margin: 1px 5px;border: 0px solid blue;height: 200px;}
.top2{margin: 1px 5px;border: 0px solid blue;height: 29px;}
.bottom1{margin: 1px 5px;border: 0px solid blue;height: 132px;}
.bottom2{margin: 1px 5px;border: 0px solid blue;height: 83px;}
</style>
<body  >
<center>
<div style="width:990px;">
	<div class="top1">
		<ulweb:content beanName="cl" deptId="market" enName="dingbutp" pageNum="1" pageSize="1" conditions="isDelete=0:i;isProcessing=0:i;" withAtt="1" />
		<logic:iterate id="element" name="cl" property="objectList">
			<logic:notEmpty name="element" property="attachmentList">
				<logic:iterate id="e" name="element" property="attachmentList">
					<img src="<bean:write name='e' property='displayPath' />" style="width: 990px;height: 200px;"/>
				</logic:iterate>
			</logic:notEmpty>
		</logic:iterate>
	</div>
	<div class="top2"><!-- top2 -->
		<table width="100%" border="0" cellspacing="0" cellpadding="0" background="dept/market2/images/dao.png">
      		<tbody>
      			<tr >
					<td  width="35" height="42"></td>
			        <td  width="75" height="29" align="center"><a href="market2.do?method=index" target="_self"><font color="#ffffff"><strong>营销主页</strong></font></a></td>
					<td  width="20" height="29"></td>
			        <td  width="85" align="center"><strong><a href="show.do?c=6329" target="_self"><font color="#ffffff">营销部介绍</font></a></strong></td>
			        <td  width="20" align="center">&nbsp;</td>
			        <td  width="77" height="29" align="center"><a href="show.do?c=226052" target="_self"><font color="#ffffff"><strong>营销通讯录</strong></font></a></td>
					<td  width="28" height="29"></td>
			        <td  width="90" height="29" align="center"><a href="market2.do?method=subPage1&columnId=5609" target="_blank"><strong><font color="#ffffff">营销行事历</font></strong></a></td>
			        <td  width="20" align="center">&nbsp;</td>
	
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
					document.write("<font color=#ffffff> 今天是"+year+"年"+mymonth+"月"+myday+"日 "+weekday+"</font>");
					</script></td>
					<td width="1"></td>
				</tr>
    		</tbody>
    </table>
	</div><!-- top2 -->
	
<!---  中间部分  --->		
	<div style="width:100%;float:left;background-color:#ffffff;">
		<div style="width:100%;float:left;padding:10px 0px 30px 60px;text-align:left;">
			<a href="market.do?method=index">部门主页</a>	
				
			<%=request.getParameter("keyWord")==null?"":"&gt;&gt;" + request.getParameter("keyWord")%>
		</div>
		<div style="float:left;width:23%;">
			
		</div>
		
		<div style="float:left;width:75%;height:400px;text-align:left;">
			<div style="width:100%;color:#ff0000;padding:5px 0px 5px 30px;font-weight:bold;">
				
			</div>			
			<div style="padding:20px 0px 10px 10px;height:350px;" class="contentlist">
				<%=d.divContent("contentList",0)%>
			</div>
			
			<div style="padding:20px 0px 10px 20px;">
				<%=d.toCheckPage()%>
			</div>
		</div>
	</div>
	
	
	<div class="bottom1">
		<ulweb:content beanName="cl" deptId="market" enName="dibutp" pageNum="1" pageSize="1" conditions="isDelete=0:i;isProcessing=0:i;" withAtt="1" />
		<logic:iterate id="element" name="cl" property="objectList">
			<logic:notEmpty name="element" property="attachmentList">
				<logic:iterate id="e" name="element" property="attachmentList">
					<img src="<bean:write name='e' property='displayPath' />" style="width: 990px;height: 132px;"/>
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
	
	
</div>	
</center>
</body>
</HTML>
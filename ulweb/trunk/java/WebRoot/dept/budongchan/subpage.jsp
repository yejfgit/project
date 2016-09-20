<%@ taglib uri="struts-bean.tld" prefix="bean"%>
<%@ taglib uri="struts-html.tld" prefix="html"%>
<%@ taglib uri="struts-logic.tld" prefix="logic"%>
<%@ taglib uri="ulweb-list.tld" prefix="ulweb"%>

<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlColumn,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.ulweb.entity.UlContentWithAtt,com.ulic.ulweb.ulweb.util.DisplayOnPage" pageEncoding="UTF-8"%><%

	DisplayOnPage d = new DisplayOnPage();
	d.setRequest(request);
	UlColumn c = (UlColumn)request.getAttribute("column");
	
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>不动产中心主页</title>

<link rel="stylesheet" href="budongchan.css" type="text/css" />
<link rel="stylesheet" href="dept/budongchan/budongchan.css" type="text/css" />
<script type="text/javascript" src="dept/budongchan/budongchan.js"></script>
<style type="text/css">
<!--
-->
.leftlink{

	font-size:20px;
	border:0;
}

</style>
</style>

</head>

<body onresize="resizeNav();">
<table width="950" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td><img src="images/budongchan/head.jpg" width="950" height="144" /></td>
      </tr>
      <tr>
         <td height="30"><table width="100%" height="100%" align="center" cellpadding="0" cellspacing="0" style="background-image:url(images/budongchan/menu_bg.gif)">
        <tr>
          <tr>
			<td width="46"><div class="topnav">&nbsp;&nbsp;</div></td>
            <td width="46"><div class="topnav"><a href="budongchan.do?method=index"><strong>首页</strong></a></div></td>
            <td width="77"><div class="topnav"><a href="budongchan.do?method=showLast&columnId=<bean:write name="jieshao"/>"><strong>部门简介</strong></a></div></td>
            <td width="77"><div class="topnav"><a href="budongchan.do?method=subPage&columnId=<bean:write name="zhongxin"/>"><strong>中心动态</strong></a></div></td>
            
            <td width="77"><div class="topnav"><a href="budongchan.do?method=subPage&columnId=<bean:write name="tongzhi"/>"><strong>工作通知</strong></a></div></td>
                       <td width="77"><div class="topnav"><a href="budongchan.do?method=subPage&columnId=<bean:write name="zhidu"/>"><strong>规章制度</strong></a></div></td>
            <td width="77"><div class="topnav"><a href="budongchan.do?method=subPage&columnId=<bean:write name="jiyao"/>"><strong>会议纪要</strong></a></div></td>

            <td width="77"><div class="topnav"><a href="budongchan.do?method=showLast&columnId=<bean:write name="shiji"/>"><strong>大事记</strong></a></div></td>
            <td width="191" align="center"><div class="topnav"><strong>
			<script language="JavaScript">
					<!--
					todayDate = new Date();
					date = todayDate.getDate();
					month= todayDate.getMonth()+1;
					year= todayDate.getYear();
					document.write("")
					document.write("")
					document.write(year);
					document.write("年");
					document.write(month);
					document.write("月");
					document.write(date);
					document.write("日");
					document.write(" ")
					if (todayDate.getDay() == 5) document.write("星期五")
					if (todayDate.getDay() == 6) document.write("星期六")
					if (todayDate.getDay() == 0) document.write("星期日")
					if (todayDate.getDay() == 1) document.write("星期一")
					if (todayDate.getDay() == 2) document.write("星期二")
					if (todayDate.getDay() == 3) document.write("星期三")
					if (todayDate.getDay() == 4) document.write("星期四")
					//--> 
					</script></strong></div>
			</td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="42">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="247" height="256" valign="top">
			<div style="padding:10px 0px 20px 23px;"><img src="images/budongchan/leftnavtitle.jpg" width="192" height="42" /></div>
			<div style="padding:5px 25px 0px 20px;">
			  <table width="100%" border="0" cellspacing="0" cellpadding="1">
                <tr>
                  <td width="45"><img src="images/budongchan/linkpoint1.jpg" width="30" height="30" /></td>
                  <td width="150" height="30">
				  <div class="leftlink"><a href="http://pom/" target="_blank"><span class="leftlink">POM系统</span></a></div>				  </td>
                </tr>
                <tr>
                  <td><img src="images/budongchan/linkpoint1.jpg" width="30" height="35" /></td>
                  <td height="30"><div class="leftlink"><a href="http://oa/" target="_blank"><span class="leftlink">OA系统</span></a></div></td>
                </tr>
                <tr>
                  <td><img src="images/budongchan/linkpoint1.jpg" width="30" height="35" /></td>
                  <td height="25"><div class="leftlink"><a href="http://ehr/" target="_blank"><span class="leftlink">人力资源系统</span></a></div></td>
                </tr>
                <tr>
                  <td><img src="images/budongchan/linkpoint1.jpg" width="30" height="35" /></td>
                  <td height="25"><div class="leftlink"><a href="http://fmis.ulic.com.cn:8000/oa_servlets/AppsLogin" target="_blank"><span class="leftlink">ERP系统</span></a></div></td>
                </tr>               
              </table>
			</div></td>
        <td rowspan="3" valign="top">
			<div style=" margin: 0px 0px 0px 30px; padding: 13px 2px 7px 58px; width: 582px; height: 22px; background-image: url('images/budongchan/listtitlebgsub.jpg')"><span class="listtitle1"><%=c.getColumnName()%></span></div>
			<div style=" margin: 10px 30px 10px 30px; padding:10px 0px 10px 10px; height:500px;" class="listcontentsub">
				<%=d.divContent("contentList",3).replace("<p>", "<p><img src=\"images/budongchan/dot.gif\" border=\"0\">&nbsp;")%>
			</div>
			
			<div style="padding:20px 30px 10px 30px; text-align:center;" class="listcontentsub">
				<%=d.toPage(1)%>
			</div>
		
		</td>
        </tr>
          </table>
        </div>
        </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td align="center"><div class="copyright" style="padding:10px 0px 3px 0px; border-bottom:solid 1px #999999;"><a href="index.do" target="_blank" class="copyright">首页</a>&nbsp;|&nbsp;关于合众 |&nbsp;<a href="admin/index.jsp" target="_blank" class="copyright">系统管理</a></div></td>
      </tr>
      <tr>
        <td height="30" align="center"><div class="copyright" style="padding:5px 0px 20px 0px;">合众人寿保险股份有限公司</div></td>
      </tr>
    </table></td>
  </tr>
</table>



</body>
</html>

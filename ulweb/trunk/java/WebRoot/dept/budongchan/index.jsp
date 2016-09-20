<%@ taglib uri="struts-bean.tld" prefix="bean"%>
<%@ taglib uri="struts-html.tld" prefix="html"%>
<%@ taglib uri="struts-logic.tld" prefix="logic"%>
<%@ taglib uri="ulweb-list.tld" prefix="ulweb"%>

<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlColumn,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.ulweb.entity.UlContentWithAtt,com.ulic.ulweb.ulweb.util.DisplayOnPage" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>不动产中心主页</title>

<link rel="stylesheet" href="caiwu.css" type="text/css" />
<link rel="stylesheet" href="dept/budongchan/budongchan.css" type="text/css" />
<script type="text/javascript" src="dept/budongchan/budongchan.js"></script>
<style type="text/css">
<!--
.scrollBar {
	scrollbar-face-color:#EFF4FA; 
	scrollbar-base-color:#EFF4FA; 
	scrollbar-arrow-color:#999999; 
	scrollbar-track-color:#EFF4FA; 
	scrollbar-shadow-color:#EFF4FA; 
	scrollbar-highlight-color:#EFF4FA; 
	scrollbar-3dlight-color:#8AAFD5; 
	scrollbar-darkshadow-Color:#8AAFD5; 
}
-->
.marspan{
	width:175px;
	overflow: hidden; 
	text-overflow:ellipsis;
	white-space:nowrap;
	word-break:keep-all;
	font-size:12px;

}

.tablespan{
	
	font-size:14px;
	width:200px;
	overflow: hidden; 
	text-overflow:ellipsis;
	white-space:nowrap;
	word-break:keep-all;
	
}

.leftlink{

	font-size:12px;
	border:0;
}

</style>

</head>

<body onresize="resizeNav();" >
<input type="hidden" id="jieshao" name="jieshao" value="3191"/>
<input type="hidden" id="jieshao" name="jieshao" value="3192"/>
<table width="950" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td><img src="images/budongchan/head.jpg" width="950" height="144" /></td>
      </tr>
      <tr>
        <td height="30"><table width="100%" height="100%" align="center" cellpadding="0" cellspacing="0" style="background-image:url(images/budongchan/menu_bg.gif)">
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
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="247"><div class="copyright" style=" color:#000099; line-height:20px; margin:5px 10px 5px 15px; padding:50px 22px 20px 18px; width:182px; height:161px; background-image:url(images/budongchan/news.jpg);">
 		  <marquee direction="up" width="180" height="150" scrollamount="1" scrolldelay="1" onmouseover="this.stop()" onmouseout="this.start()">		
          		<table style="table-layout:fixed">
          		<logic:iterate id="element" name="zuixinList">
					<tr><td> 
					<a href="show.do?c=<bean:write name="element" property="contentId"/>" title="<bean:write name="element" property="contentName"/>"/><span class="marspan"><bean:write name="element" property="contentName"/></span></a>
					<hr style="border:1px dashed black; height:1px"/>
					</td></tr>
				</logic:iterate>
				</table>
          </marquee>
	          
        </div></td>
        <td height="245" colspan="2">
			<div style="margin:0px 0px 0px 10px; padding:1px 1px 1px 1px; width:664px; height:222px; border:solid 1px #DDDDDD; text-align:center;">
<!-- newsAd Begin -->
<script language="javascript">
var imgUrl=new Array();
var imgLink=new Array();
var text=new Array();
var adNum=0;
var buttonShow=1;
var buttonPos=2; //RU:1，RD:2，LU:3，LD:4

<%	
	java.util.List<com.ulic.ulweb.ulweb.entity.UlContentWithAtt> indexPic = 
	(java.util.List<com.ulic.ulweb.ulweb.entity.UlContentWithAtt>) request.getAttribute("tupian");
	out.println("//size:" + indexPic.size());

  	for(int i = 0; i < indexPic.size(); i++){  

%>
imgUrl[<%=i+1%>]="<%=indexPic.get(i).getAtt(1).getAttachmentPath()%>";
imgLink[<%=i+1%>]="<%=(indexPic.get(i).getSubTitle() != null ? indexPic.get(i).getSubTitle() : "")%>";
text[<%=i+1%>]="<%=(indexPic.get(i).getKeyWord() != null ? indexPic.get(i).getKeyWord() : "")%>";
<% } %>
</script>
<script language="javascript" src="dept/budongchan/newsAd.js"></script>
<table id=newsTable border="0" cellspacing="0" cellpadding="0">
<script language="javascript">dakularButtons();
</script>
<tr><td><a onMouseOver="displayStatusMsg();return document.returnValue" onMouseOut="status='';" class=px14-lh24 href="javascript:jump2url()"><img style="FILTER: revealTrans(duration=1,transition=23); border:0px solid #000000" src="src="#" width=664 height=222 border=0 name=imgUrlrotator alt=""></a>
<script>nextAd();</script>
</td>
</tr>
</table>
<!-- newsAd End -->
			</div>		
		</td>
        </tr>
      <tr>
        <td valign="top">
			<div style="padding:10px 0px 20px 23px;"><img src="images/budongchan/leftnavtitle.jpg" width="192"  /></div>
			<div style="">
			  <table width="100%" border="0" cellspacing="0" cellpadding="1">
                <tr>
                  <td width="45" align="center"><img src="images/budongchan/linkpoint1.jpg" width="15" /></td>
                  <td width="150"><div class="leftlink"><a href="http://ulweb/" target="_blank"><span class="leftlink">合众内网</span></a></div>				  </td>
                </tr>
                <tr>
                  <td width="45" align="center"><img src="images/budongchan/linkpoint1.jpg" width="15"  /></td>
                  <td width="150"><div class="leftlink"><a href="http://pom/" target="_blank"><span class="leftlink">POM系统</span></a></div>				  </td>
                </tr>
                <tr>
                  <td width="45" align="center" ><img src="images/budongchan/linkpoint1.jpg" width="15"  /></td>
                  <td ><div class="leftlink"><a href="http://oa/" target="_blank"><span class="leftlink">OA系统</span></a></div></td>
                </tr>
                <tr>
                  <td width="45" align="center"><img src="images/budongchan/linkpoint1.jpg" width="15" /></td>
                  <td ><div class="leftlink"><a href="http://ehr/" target="_blank"><span class="leftlink">人力资源系统</span></a></div></td>
                </tr>
                <tr>
                  <td width="45" align="center"><img src="images/budongchan/linkpoint1.jpg" width="15"  /></td>
                  <td><div class="leftlink"><a href="http://ccrcoa/" target="_blank"><span class="leftlink">运营OA系统</span></a></div></td>
                </tr>
                <tr>
                  <td width="45" align="center"><img src="images/budongchan/linkpoint1.jpg" width="15"  /></td>
                  <td><div class="leftlink"><a href="http://fmis.ulic.com.cn:8000/oa_servlets/AppsLogin" target="_blank"><span class="leftlink">ERP系统</span></a></div></td>
                </tr>
               <tr>
                  <td width="45" align="center"><img src="images/budongchan/linkpoint1.jpg" width="15"  /></td>
                  <td ><div class="leftlink"><a href="http://www.chinaccrc.cn/" target="_blank"><span class="leftlink">合众优年生活</span></a></div></td>
                </tr>
                <tr>
                  <td width="45" align="center"><img src="images/budongchan/linkpoint1.jpg" width="15" /></td>
                  <td ><div class="leftlink"><a href="http://10.32.53.60/" target="_blank"><span class="leftlink">养老营销系统</span></a></div></td>
                </tr>  
               <tr>
                  <td width="45" align="center"><img src="images/budongchan/linkpoint1.jpg" width="15"/></td>
                  <td><div class="leftlink"><a href="http://10.51.21.231/" target="_blank"><span class="leftlink">养老运营系统</span></a></div></td>
                </tr>  
                               <tr>
                  <td width="45" align="center"><img src="images/budongchan/linkpoint1.jpg" width="15"/></td>
                  <td ><div class="leftlink"><a href="http://it/dept/budongchan/Lists/201/calendar.aspx" target="_blank"><span class="leftlink">会议室预定系统</span></a></div></td>
                </tr>                  
              </table>
			</div></td>
        <td width="344" valign="top"><table width="100%" height="256" border="0" cellpadding="0" cellspacing="0" >
          <tr>
            <td width="309" height="40" background="images/budongchan/listtitlebg1.jpg"><div class="listtitle1" style="padding:0px 0px 0px 55px; ">中心<span class="listtitle2">动态</span></div></td>
            <td align="left" valign="bottom"><a href="budongchan.do?method=subPage&columnId=<bean:write name="zhongxin"/>"><img src="images/budongchan/more.jpg" width="28" height="15" border="0" /></a></td>
          </tr>
          <tr>
          <td colspan="2">
           <div class="listcontent">
           <table style="table-layout:fixed;">
            <tr height="5px">
            </tr>
            <logic:iterate id="element" name="zhongxinList" indexId="index1">
            <tr>
            <td>
            <img src="images/budongchan/dot.gif" border="0"/>&nbsp;<a href="show.do?c=<bean:write name="element" property="contentId"/>" target="_blank" title="<bean:write name="element" property="contentName"/>" /><span class="tablespan"><bean:write name="element" property="contentName"/></span></a>
            </td>
			</tr>
            </logic:iterate>
            </table>
            </div>
            </td>
            </tr>
        </table></td>
        <td width="359" valign="top"><table width="100%" height="256" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="309" height="40" background="images/budongchan/listtitlebg2.jpg"><div class="listtitle1" style="padding:0px 0px 0px 55px; ">工作<span class="listtitle2">通知</span></div></td>
            <td align="left" valign="bottom"><a href="budongchan.do?method=subPage&columnId=<bean:write name="tongzhi"/>"><img src="images/budongchan/more.jpg" width="28" height="15" border="0" /></a></td>
          </tr>
          <tr>
          <td colspan="2">
           <div class="listcontent">
            <table style="table-layout:fixed">
            <tr height="5px">
            </tr>
            <logic:iterate id="element" name="tongzhiList" indexId="index1">
            <tr>
            <td>
            <img src="images/budongchan/dot.gif" border="0"/>&nbsp;<a href="show.do?c=<bean:write name="element" property="contentId"/>" target="_blank" title="<bean:write name="element" property="contentName"/>"/><span class="tablespan"><bean:write name="element" property="contentName"/></span></a>
            </td>
			</tr>
            </logic:iterate>
            </table>
            </div>
            </td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="253" valign="top">
        <div style="padding:5px 25px 0px 20px;">
        <a href="show.do?c=<bean:write name="contentId"/>" target="blank"><img src="images/budongchan/txl.jpg" style="border: solid 1px #DDDDDD;"/></a>
        </div>
        <div style="padding:5px 25px 0px 20px;">
        <a href="budongchan.do?method=subPage&columnId=4264" target="blank"><img src="images/budongchan/cybg.jpg" style="border: solid 1px #DDDDDD;"/></a>
        </div>
        <div style="padding:5px 25px 0px 20px;">
        <a href="http://10.18.2.107/promise_bdc.mht" target="blank"><img src="images/budongchan/bmzz.jpg" style="border: solid 1px #DDDDDD;"/></a>
        </div>
		</td>
        
        <td valign="top"><table width="100%" height="256" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="309" height="40" background="images/budongchan/listtitlebg3.jpg"><div class="listtitle1" style="padding:0px 0px 0px 55px; ">规章<span class="listtitle2">制度</span></div></td>
            <td align="left" valign="bottom"><a href="budongchan.do?method=subPage&columnId=<bean:write name="zhidu"/>"><img src="images/budongchan/more.jpg" width="28" height="15" border="0" /></a></td>
          </tr>
          <tr>
          <td colspan="2">
           <div class="listcontent">
           <table style="table-layout:fixed;">
            <tr height="5px">
            </tr>
            <logic:iterate id="element" name="zhiduList" indexId="index1">
            <tr>
            <td>
            <img src="images/budongchan/dot.gif" border="0"/>&nbsp;<a href="show.do?c=<bean:write name="element" property="contentId"/>" target="_blank" title="<bean:write name="element" property="contentName"/>"/><span class="tablespan"><bean:write name="element" property="contentName"/></span></a>
            </td>
			</tr>
            </logic:iterate>
            </table>
            </div>
            </td>
          </tr>
        </table></td>
        <td valign="top"><table width="100%" height="256" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="309" height="40" background="images/budongchan/listtitlebg4.jpg"><div class="listtitle1" style="padding:0px 0px 0px 55px; ">会议<span class="listtitle2">纪要</span></div></td>
            <td align="left" valign="bottom"><a href="budongchan.do?method=subPage&columnId=<bean:write name="jiyao"/>"><img src="images/budongchan/more.jpg" width="28" height="15" border="0" /></a></td>
          </tr>
          <tr>
          <td colspan="2">
           <div class="listcontent">
           <table style="table-layout:fixed">
            <tr height="5px">
            </tr>
            <logic:iterate id="element" name="jiyaoList" indexId="index1">
            <tr>
            <td>
            <img src="images/budongchan/dot.gif" border="0"/>&nbsp;<a href="show.do?c=<bean:write name="element" property="contentId"/>" target="_blank" title="<bean:write name="element" property="contentName"/>"/><span class="tablespan"><bean:write name="element" property="contentName"/></span></a>
            </td>
			</tr>
            </logic:iterate>
            </table>
            </div>
            </td>
          </tr>
        </table></td>
      </tr>

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

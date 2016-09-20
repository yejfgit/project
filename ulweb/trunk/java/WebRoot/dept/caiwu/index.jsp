
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlColumn,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.ulweb.entity.UlContentWithAtt,com.ulic.ulweb.ulweb.util.DisplayOnPage" pageEncoding="UTF-8"%><%

	DisplayOnPage d = new DisplayOnPage();
	d.setRequest(request);
	UlContent jieshao = (UlContent)request.getAttribute("jieshao");
	List<UlContent> gonggao = (List<UlContent>)request.getAttribute("gonggao");
	List<UlContent> zhuye = (List<UlContent>)request.getAttribute("zhuye");
	List<UlContent> shengri = (List<UlContent>)request.getAttribute("shengri");
	List<UlContentWithAtt> tupian = (List<UlContentWithAtt>)request.getAttribute("tupian");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>财务部主页</title>

<link rel="stylesheet" href="caiwu.css" type="text/css" />
<link rel="stylesheet" href="dept/caiwu/caiwu.css" type="text/css" />
<script type="text/javascript" src="dept/caiwu/caiwu.js"></script>
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
</style>

</head>

<body onresize="resizeNav();">
<table width="950" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td><img src="images/caiwu/head.jpg" width="950" height="110" /></td>
      </tr>
      <tr>
        <td height="33"><table width="100%" height="100%" align="center" cellpadding="0" cellspacing="0" bgcolor="#F2FEE7">
          <tr>
            <td width="191" align="center"><div class="topnav">
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
					</script></div>
			</td>
            <td width="46"><div class="topnav"><a href="caiwu.do?method=index">首页</a></div></td>
            <td width="77"><div class="topnav"><a href="dept/caiwu/intro.htm" target="_blank">部门简介</a></div></td>
            <td width="77"><div class="topnav"><a href="caiwu.do?method=subPage1&amp;columnId=55">工作通知</a></div></td>
            <td width="98"><div class="topnav"><a href="caiwu.do?method=subPage1&amp;columnId=56">财务部发文</a></div></td>
            <td width="77"><div class="topnav"><a href="caiwu.do?method=subPage1&amp;columnId=54">合众财苑</a></div></td>
            <td width="77"><div class="topnav"><a href="caiwu.do?method=subPage1&amp;columnId=57">监管法规</a></div></td>
            <td width="77"><div class="topnav"><a href="caiwu.do?method=subPage1&amp;columnId=58">机构动态</a></div></td>
            <td width="77"><div class="topnav"><a href="caiwu.do?method=subPage1&amp;columnId=60">公告栏</a></div></td>
            <td width="77"><div class="topnav"><a href="caiwu.do?method=subPage1&amp;columnId=1207">财税要闻</a></div></td>
            <td width="77"><div class="topnav"><a href="caiwu.do?method=subPage1&amp;columnId=64">凭证附件</a></div></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="30"><div class="birthday" style="padding:0px 10px 0px 10px;"><span style="width: 200px; padding: 0px 10px; color: #666666;">生日祝福：点击姓名即可发送 &gt;&gt;&gt; </span>
            <marquee onMouseOver="this.stop()" width="680" scrollamount="3"  onmouseout="this.start()">
				<%
						java.util.Date dt = new Date();
						String today = String.valueOf(dt.getMonth() + 1) + "-" + String.valueOf(dt.getDate());
						for(int i = 0; i < shengri.size(); i++){
							out.print("<font color=\"" + (shengri.get(i).getKeyWord().equals(today) ? "#FF0000" : "#005E10") + "\">☆</font><a href=\"mailto:" + shengri.get(i).getContentName() + "@ulic.com.cn?subject=Happy Birthday!\">");
							out.println(shengri.get(i).getKeyWord() + "&nbsp;" + shengri.get(i).getSubTitle() + "</a>&nbsp;&nbsp;");
						}

				%>
          </marquee></div></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="247"><div class="copyright" style=" color:#000099; line-height:20px; margin:5px 10px 5px 15px; padding:50px 22px 20px 18px; width:182px; height:161px; background-image:url(images/caiwu/news.jpg);">
<!-- <marquee direction="up" width="180" height="150" scrollamount="1" scrolldelay="100" onmouseover="this.stop()" onmouseout="this.start()">
 -->
 <div class="scrollBar" style="height: 100%;  overflow: auto; ">
				<%
						for(int i = 0; i < (gonggao == null ? 0 : gonggao.size() ); i++){
							out.print("<br>第" + (i + 1) + "条 (" + gonggao.get(i).getDay() + ")<br>" );
							out.println("<a href=\"show.do?c=" + gonggao.get(i).getContentId() + "\" target=\"_blank\">" + gonggao.get(i).getContentName() + "</a><br>***************");
						}
				
				
				%>
				</div>
<!-- 		
          </marquee>
 -->		          
        </div></td>
        <td height="245" colspan="2">
			<div style="margin:0px 0px 0px 10px; padding:1px 1px 1px 1px; width:664px; height:222px; border:solid 1px #DDDDDD; text-align:center;"><%
		if (tupian.size() > 0 && tupian.get(0).getAttachmentSum() > 0) {
			out.println("<a href=\"" + tupian.get(0).getAtt(1).getAttachmentPath() + "\" target=\"_blank\"><img src=\"" + tupian.get(0).getAtt(1).getAttachmentPath() + "\" border=\"0\" width=\"664\" height=\"222\"></a>");
		}
		
		%></div>		</td>
        </tr>
      <tr>
        <td height="256" valign="top">
			<div style="padding:10px 0px 20px 23px;"><img src="images/caiwu/leftnavtitle.jpg" width="192" height="42" /></div>
			<div style="padding:5px 25px 0px 20px;">
			  <table width="100%" border="0" cellspacing="0" cellpadding="1">
                <tr>
                  <td width="45"><img src="images/caiwu/linkpoint1.jpg" width="30" height="30" /></td>
                  <td width="150" height="25">
				  <div class="leftlink"><a href="http://fmis.ulic.com.cn:8000/oa_servlets/AppsLogin" target="_blank">ORACLE-ERP系统</a></div>				  </td>
                </tr>
                <tr>
                  <td><img src="images/caiwu/linkpoint1.jpg" width="30" height="30" /></td>
                  <td height="25"><div class="leftlink"><a href="https://atsprd.ulic.com.cn/" target="_blank">专业资金与财资管理系统</a></div></td>
                </tr>
                <tr>
                  <td><img src="images/caiwu/linkpoint1.jpg" width="30" height="30" /></td>
                  <td height="25"><div class="leftlink"><a href="http://10.51.2.18/erpwh" target="_blank">财务系统维护平台</a></div></td>
                </tr>
                <tr>
                  <td><img src="images/caiwu/linkpoint1.jpg" width="30" height="30" /></td>
                  <td height="25"><div class="leftlink"><a href="http://epmprd.ulic.com.cn:19000/workspace/index.jsp" target="_blank">预算系统（HYP）</a></div></td>
                </tr>
                <tr>
                  <td><img src="images/caiwu/linkpoint1.jpg" width="30" height="30" /></td>
                  <td height="25"><div class="leftlink"><a href="http://10.51.2.18/lybbs" target="_blank">财务论坛</a></div></td>
                </tr>
                <tr>
                  <td><img src="images/caiwu/linkpoint1.jpg" width="30" height="30" /></td>
                  <td height="25"><div class="leftlink"><a href="http://ulweb/newapp/show.do?c=55343" target="_blank">各机构所在地发票查询系统网址</a></div></td>
                </tr>                
              </table>
			</div></td>
        <td width="344"><table width="100%" height="256" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="309" height="40" background="images/caiwu/listtitlebg1.jpg"><div class="listtitle1" style="padding:0px 0px 0px 55px; ">工作<span class="listtitle2">通知</span></div></td>
            <td align="left" valign="bottom"><a href="caiwu.do?method=subPage1&amp;columnId=55"><img src="images/caiwu/more.jpg" width="28" height="15" border="0" /></a></td>
          </tr>
          <tr>
            <td colspan="2" valign="top"><div class="listcontent"><%=d.divContent("tongzhi",0).replace("<p>", "<p><img src=\"images/caiwu/dot.gif\" border=\"0\">&nbsp;")%></div></td>
            </tr>
        </table></td>
        <td width="359" valign="top"><table width="100%" height="256" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="309" height="40" background="images/caiwu/listtitlebg2.jpg"><div class="listtitle1" style="padding:0px 0px 0px 55px; ">财务部<span class="listtitle2">发文</span></div></td>
            <td align="left" valign="bottom"><a href="caiwu.do?method=subPage1&amp;columnId=56"><img src="images/caiwu/more.jpg" width="28" height="15" border="0" /></a></td>
          </tr>
          <tr>
            <td colspan="2"><div class="listcontent"><%=d.divContent("fawen",0).replace("<p>", "<p><img src=\"images/caiwu/dot.gif\" border=\"0\">&nbsp;")%></div></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="253" valign="top"><div style="padding:5px 25px 0px 20px;">
          <table width="100%" border="0" cellspacing="0" cellpadding="1">

            <tr>
              <td width="45"><img src="images/caiwu/linkpoint2.jpg" width="30" height="30" /></td>
              <td width="150" height="25"><div class="leftlink" onmouseover="homepage.style.display='block';"><a>主页链接</a>
                <div id="homepage" style=" text-align: left; padding: 10px 10px 10px 10px; width:300px; height:10px; border:solid 1px #D3D4D3; display: none;"; onmouseout="this.style.display='none';">
				<a href="http://ulweb" target="_blank" class="copyright">总公司</a>&nbsp;

<%
						for(int i = 0; i < (zhuye == null ? 0 : zhuye.size() ); i++){
							out.print("<a href=\"" + zhuye.get(i).getSubTitle() + "\" target=\"_blank\" class=\"copyright\">");
							out.println(zhuye.get(i).getContentName() + "</a>&nbsp;&nbsp;");
						}

				%>

				</div>
			<script type="text/javascript">
				function resizeNav() {
					document.getElementById("homepage").style.left = document.body.clientWidth / 2 - 407 + 'px';
					document.getElementById("homepage").style.top = 690 + 'px';
				}
			resizeNav();
			</script>
              </div></td>
            </tr>
          </table>
        </div>
		<div style="margin:15px 15px 10px 15px; padding:5px 5px 5px 10px; border:solid 1px #DDDDDD;">
			<form method="post" action="caiwu.do?method=check">
			  <table width="100%" border="0" cellspacing="4" cellpadding="0">
                <tr>
                  <td height="30" colspan="2" align="center"><strong>资料检索</strong></td>
                  </tr>
                <tr>
                  <td width="88" height="20"><span class="copyright">检索词：</span></td>
                  <td><input type="text" name="tName" style="width:115px;" /></td>
                </tr>
                <tr>
                  <td height="20"><span class="copyright">类别：</span></td>
                  <td>
				  	<select name="type" id="idtype" style="width:120px;">
						<option value="0">不限</option>
						<%=d.optionColumn("columnForCheck")%>
					</select></td>
                </tr>

                <tr>
                  <td height="30" colspan="2" align="center"><input type="submit" value="开始检索" /></td>
                  </tr>
              </table>
			</form>
		</div>		</td>
        <td valign="top"><table width="100%" height="256" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="309" height="40" background="images/caiwu/listtitlebg3.jpg"><div class="listtitle1" style="padding:0px 0px 0px 55px; ">监管<span class="listtitle2">法规</span></div></td>
            <td align="left" valign="bottom"><a href="caiwu.do?method=subPage1&amp;columnId=57"><img src="images/caiwu/more.jpg" width="28" height="15" border="0" /></a></td>
          </tr>
          <tr>
            <td colspan="2"><div class="listcontent"><%=d.divContent("fagui",0).replace("<p>", "<p><img src=\"images/caiwu/dot.gif\" border=\"0\">&nbsp;")%></div></td>
          </tr>
        </table></td>
        <td valign="top"><table width="100%" height="256" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="309" height="40" background="images/caiwu/listtitlebg4.jpg"><div class="listtitle1" style="padding:0px 0px 0px 55px; ">合众<span class="listtitle2">财苑</span></div></td>
            <td align="left" valign="bottom"><a href="caiwu.do?method=subPage1&amp;columnId=54"><img src="images/caiwu/more.jpg" width="28" height="15" border="0" /></a></td>
          </tr>
          <tr>
            <td colspan="2"><div class="listcontent"><%=d.divContent("zixun",0).replace("<p>", "<p><img src=\"images/caiwu/dot.gif\" border=\"0\">&nbsp;")%></div></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="252" valign="top">
			<div style="padding:10px 10px 10px 15px;"><a href="dept/caiwu/uliccas/index.htm" target="_blank"><img src="images/caiwu/link1.jpg" width="215" height="64" border="0" /></a></div>
			<div style="padding:5px 10px 10px 15px;"><a href="caiwu.do?method=subPage1&amp;columnId=59"><img src="images/caiwu/link2.jpg" width="215" height="64" border="0" /></a></div>
			
			<div style="padding:5px 10px 10px 15px;"><a href="caiwu.do?method=subPage1&amp;columnId=2344"><img src="images/caiwu/link4.jpg" width="215" height="64" border="0" /></a></div>
		</td>
        <td valign="top"><table width="100%" height="256" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="309" height="40" background="images/caiwu/listtitlebg5.jpg"><div class="listtitle1" style="padding:0px 0px 0px 55px; ">财税<span class="listtitle2">要闻</span></div></td>
            <td align="left" valign="bottom"><a href="caiwu.do?method=subPage1&amp;columnId=1207"><img src="images/caiwu/more.jpg" width="28" height="15" border="0" /></a></td>
          </tr>
          <tr>
            <td colspan="2"><div class="listcontent"><%=d.divContent("yaowen",0).replace("<p>", "<p><img src=\"images/caiwu/dot.gif\" border=\"0\">&nbsp;")%></div></td>
          </tr>
        </table></td>
        <td valign="top"><table width="100%" height="256" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="309" height="40" background="images/caiwu/listtitlebg6.jpg"><div class="listtitle1" style="padding:0px 0px 0px 55px; ">机构<span class="listtitle2">动态</span></div></td>
            <td align="left" valign="bottom"><a href="caiwu.do?method=subPage1&amp;columnId=58"><img src="images/caiwu/more.jpg" width="28" height="15" border="0" /></a></td>
          </tr>
          <tr>
            <td colspan="2"><div class="listcontent"><%=d.divContent("dongtai",0).replace("<p>", "<p><img src=\"images/caiwu/dot.gif\" border=\"0\">&nbsp;")%></div></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td align="center"><div class="copyright" style="padding:10px 0px 3px 0px; border-bottom:solid 1px #999999;"><a href="index.do" target="_blank" class="copyright">首页</a> | 关于合众 | 问题上报 | <a href="admin/index.jsp" target="_blank" class="copyright">系统管理</a></div></td>
      </tr>
      <tr>
        <td height="30" align="center"><div class="copyright" style="padding:5px 0px 20px 0px;">合众人寿保险股份有限公司 财务部 版权所有 2009</div></td>
      </tr>
    </table></td>
  </tr>
</table>



</body>
</html>

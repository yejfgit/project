<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlTemplate,com.ulic.ulweb.ulweb.entity.UlColumn,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.ulweb.entity.UlContentWithAtt,com.ulic.ulweb.ulweb.util.DisplayOnPage" pageEncoding="UTF-8"%>

<%
	DisplayOnPage d = new DisplayOnPage();
	d.setRequest(request);
		
	List<UlContent> intro = (List<UlContent>)request.getAttribute("intro");

	List<UlContentWithAtt> photo = (List<UlContentWithAtt>)request.getAttribute("photo");
	List<UlContentWithAtt> photo2 = (List<UlContentWithAtt>)request.getAttribute("photo2");

	int i;
	String introPath = "";
	for(i = 0; i < intro.size(); i++){
		introPath = "show.do?c=" + intro.get(0).getContentId() + "&a=1";
	}
		
		
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>培训部主页</title>

<style type="text/css">
<!--
.topNav ,a {
	font-family: "隶书";
	font-size: 20px;
	text-decoration:none;
	color:#000000;
}
.topNav a:hover {
	font-family: "隶书";
	font-size: 20px;
	text-decoration:underline;
	color:#000000;
}
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
td{
	font-size:14px;
	line-height:20px;
}
.topNav2 {color: #FF0000}
.centerTitle {
	font-family: "隶书";
	font-size: 24px;
	color: #FF0000;
}
.leftTitle {font-family: "隶书"; font-size: 22px; }
.leftCol a { 
	font-family:"宋体"; 
	font-size:14px;
	font-weight:bold;
	text-decoration:none;
	line-height:25px;
}
.leftCol a:hover { 
	text-decoration:underline;
}
.centerCol a { 
	font-family:"宋体"; 
	font-size:14px;
	text-decoration:none;
	line-height:25px;
}
.centerCol a:hover { 
	text-decoration:underline;
}
p { margin:5px;}

ul { margin: 0px; padding: 10px}

li { margin: 0px; padding: 0px}

#btn_search { background: url('images/peixun2/leftTitle.jpg') no-repeat;
 cursor: hand; border: solid 1px #cccccc;}

-->
</style>

<script type="text/javascript">

function G(id) {
	return document.getElementById(id);
}

function pressEnter(func) {
	if (event.keyCode == 13) {
		func();
	}
}


function search() {

	var keyWord = G("input_search").value;
	//alert(keyWord);
	keyWord = escape(keyWord);
	keyWord = keyWord.replace(/%/g, 'U')
	var url = "peixun2.do?method=search&keyWord=" + keyWord;
	location.href = url;
}

</script>

</head>

<body>
<table width="1000" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#105631">
  <tr>
    <td>&nbsp;</td>
    <td width="800"><table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
      <tr>
        <td width="800" height="200"><object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="800" height="200">
          <param name="movie" value="dept/peixun2/peixun3.swf" />
          <param name="quality" value="high" />
          <embed src="dept/peixun2/peixun3.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="800" height="200"></embed>
        </object></td>
      </tr>
      <tr>
        <td><div style="border-bottom:solid #111111 1px;"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="50" height="30">&nbsp;</td>
            <td width="300"><span class="topNav"><!-- 今天是 
<script type="text/javascript">
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
</script>
<br> -->
您是本站第<span class="topNav2"><%=request.getAttribute("countProcesser")%></span>位访客</span></td>
            <td class="topNav"><a href="<%=introPath%>" target="_blank">培训部风采</a></td>
            <td class="topNav"><a href="http://ulweb/newapp/index.do" target="_blank">总公司主页</a></td>
            <td class="topNav"><a href="admin/index.jsp" target="_blank">系统管理</a></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="15"></td>
      </tr>
      <tr>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="250" valign="top">
            
			<div style="padding:0px 0px 0px 15px;">
			  <table cellpadding="0" cellspacing="0"><tr><td>
			  <div style="width:175px; height:38px; background-image:url('images/peixun2/leftTitle.jpg')">
                <div class="leftTitle" style="padding:13px 0px 5px 0px; text-align:center;">2011重点项目</div>
			  </div>
			  </td><td width="10"></td><td>
			  <br />
			  </td></tr></table>
			  <div class="leftCol" style="padding:10px 0px 15px 5px;"><%=d.divColumn("zhongdian", "peixun2.do?method=subPage&", 0)%></div>
            </div>            
            
			<div style="padding:0px 0px 0px 15px;">
			  <table cellpadding="0" cellspacing="0"><tr><td>
			  <div style="width:175px; height:38px; background-image:url('images/peixun2/leftTitle.jpg')">
                <div class="leftTitle" style="padding:13px 0px 5px 0px; text-align:center;">业务员训练室</div>
			  </div>
			  </td><td width="10"></td><td>
			  <br />
			  </td></tr></table>
			  <div class="leftCol" style="padding:10px 0px 15px 5px;"><%=d.divColumn("yewu", "peixun2.do?method=subPage&", 0)%></div>
            </div>
			<div style="padding:0px 0px 0px 15px;">
			  <table cellpadding="0" cellspacing="0"><tr><td>
              <div>
                <div style="width:175px; height:38px; background-image:url('images/peixun2/leftTitle.jpg')">
                  <div class="leftTitle" style="padding:13px 0px 5px 0px; text-align:center;">主管训练室</div>
              </div>
              </div>
			  </td><td width="10"></td><td>
			  <br />
			  </td></tr></table>
			  <div class="leftCol" style="padding:10px 0px 15px 5px;"><%=d.divColumn("zhuguan", "peixun2.do?method=subPage&", 0)%></div>
            </div>			
			<div style="padding:0px 0px 0px 15px;">
			  <table cellpadding="0" cellspacing="0"><tr><td>
              <div>
                <div style="width:175px; height:38px; background-image:url('images/peixun2/leftTitle.jpg')">
                  <div class="leftTitle" style="padding:13px 0px 5px 0px; text-align:center;">训练管理室</div>
              </div>
              </div>
			  </td><td width="10"></td><td>
			  <br />
			  </td></tr></table>
			  <div class="leftCol" style="padding:10px 0px 15px 5px;">
			  <%=d.divColumn("xunlian", "peixun2.do?method=subPage&", 0)%></div>
            </div>			</td>
            <td width="300" valign="top">
			<div style="margin:5px 7px 15px 7px; width:285px; height:176px; background-image:url('images/peixun2/centerToday.jpg');">
			  <div style="height:35px"></div>
			  <div class="centerCol" style="padding:0px 10px 5px 15px; font-weight:bold;">
			  <marquee width="265" height="135" behavior="scroll" direction="up" scrollamount="1" scrolldelay="1" onmouseover="this.stop();" onmouseout="this.start();">

				<%=d.divContent("daodu",3)%>

			  </marquee>
			  </div>
</div>
			
			<div style="margin:0px 10px 10px 10px; border:solid #333333 1px;">
			  <div class="centerTitle" style="padding:10px 5px 5px 10px;">培训直通车<span style="padding: 0px 0px 0px 70px"><a href="peixun2.do?method=zhitongche">MORE...</a></span></div>
			  <div class="centerCol" style="padding:5px 5px 5px 10px;">
			<ul>
				<%=d.showContentList("zhitongche", 15, "show.do?")%>
</ul>
			  </div>
			  <div style="padding:5px 5px 5px 200px;"><img src="images/peixun2/centerSeal.jpg" width="70" height="50" /></div>
			</div>			</td>
            <td width="250" valign="top">
			<div style="margin:5px 5px 5px 5px; width:240px; height:190px; background-image:url('images/peixun2/rightAlbum.jpg');">
				<div style="padding:0px 15px 15px 0px;"><%
			  String photoPath = ""; 
			  for(i = 0; i < photo.size(); i++){
			  	if(photo.get(0).getAttachmentSum() <= 0) break;
				else {
			  		photoPath = photo.get(0).getAtt(1).getAttachmentPath();
					%><a href="<%=photoPath%>" target="_blank"><img src="<%=photoPath%>" width="225" height="175" border="0"></a><%
				}
			  } %></div>
			</div>
			<div style="margin:5px 5px 15px 5px;">
							<%
			  String photo2Path = "images/peixun2/photo2.jpg"; 
			  for(i = 0; i < photo2.size(); i++){
			  	if(photo2.get(0).getAttachmentSum() <= 0) break;
				else {
			  		photo2Path = photo2.get(0).getAtt(1).getAttachmentPath();
				}
			  } %>
			<img src="<%=photo2Path%>" width="240" height="130" border="0">
						</div>
					
			<div style="margin:5px 5px 15px 5px;">
			  <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td width="90" align="center" valign="middle"><div style="padding:5px 8px 5px 10px;">
                    <div style="width:69px; height:61px; background-image:url('images/peixun2/rightTitle.jpg')">
                      <div class="leftTitle" style="padding:13px 13px 7px 7px; text-align:center;">文件通知</div>
                    </div>
                  </div></td>
                  <td width="230"><div class="leftCol" style="padding:5px 5px 15px 5px;"><span style="padding:5px 0px 5px 0px;"><%=d.divColumn("wenjian", "peixun2.do?method=subPage&", 0)%></span></div></td>
                </tr>
                <tr>
                  <td align="center" valign="middle"><div style="padding:5px 8px 5px 10px;">
                    <div style="width:69px; height:61px; background-image:url('images/peixun2/rightTitle.jpg')">
                      <div class="leftTitle" style="padding:13px 13px 7px 7px; text-align:center;">系统链接</div>
                    </div>
                  </div></td>
                  <td><div class="leftCol" style="padding:5px 5px 15px 5px;">
                  <ul>
                  	<li>ETS培训管理系统</li>
                  	<li><a href="http://oa/" target="_blank">OA工作流系统</a></li>
                  	<li><a href="http://ehr/" target="_blank">人力资源管理系统</a></li>
                  </ul>
                  </div></td>
                </tr>
                <tr>
                	<td colspan="2">


<!-- Search Box Begin -->

			<div id="search">
				<input id="input_search" type="text" name="keyWord" value="" onkeypress="pressEnter(search)" />
				<input id="btn_search" type="button" name="submit" value="搜索" onclick="search()" />
			</div>
<!-- Search Box End -->


                	</td>
                </tr>
                
                
                
                
                
              </table>
			</div>			</td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td><div style="padding:5px 5px 15px 5px;">
          <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="100" align="center" valign="middle"><div style="width:69px; height:61px; background-image:url('images/peixun2/rightTitle.jpg')">
                <div class="leftTitle" style="padding:13px 13px 7px 7px; text-align:center;">机构之声</div>
              </div></td>
              <td><div class="leftCol" style="padding:5px 5px 5px 5px;"><span style="padding:5px 0px 5px 0px;"><%=d.divColumn("jigou", "peixun2.do?method=subPage&", 0).replace("</div><div>", "&nbsp;&nbsp;")%></span></div></td>
            </tr>
          </table>
        </div></td>
      </tr>
      <tr>
        <td><div style="padding:10px 5px 30px 5px; border-top:solid #111111 1px; color:#333333; text-align:center;">合众人寿保险股份有限公司 培训部</div></td>
      </tr>
    </table></td>
    <td>&nbsp;</td>
  </tr>
</table>
</body>
</html>

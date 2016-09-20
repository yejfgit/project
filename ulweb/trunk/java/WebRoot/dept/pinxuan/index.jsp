<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlTemplate,com.ulic.ulweb.ulweb.entity.UlColumn,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.ulweb.entity.UlContentWithAtt,com.ulic.ulweb.ulweb.util.DisplayOnPage" pageEncoding="UTF-8"%>

<%
		List<UlContent> view = (List<UlContent>)request.getAttribute("view");
		List<UlContent> share = (List<UlContent>)request.getAttribute("share");
		List<UlContentWithAtt> news_top = (List<UlContentWithAtt>)request.getAttribute("news_top");
		List<UlContent> news_normal = (List<UlContent>)request.getAttribute("news_normal");
		List<UlContentWithAtt> aboutus = (List<UlContentWithAtt>)request.getAttribute("aboutus");
		List<UlContentWithAtt> indexPic = (List<UlContentWithAtt>)request.getAttribute("indexPic");
		
		int vol, size, flag;
		String content, cn, path, imgPath, ext;
		

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>首页 - 合众人寿品牌服务网站</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="dept/pinxuan/pinxuan.css" type="text/css" />
<script type="text/javascript" src="script/pinxuan.js"></script>
<script type="text/javascript" src="dept/pinxuan/boxover.js"></script>

</head>
<body bgcolor="#ffffff">
<table width="1000" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
   <td><img src="images/pinxuan/spacer.gif" width="128" height="1" border="0" alt=""></td>
   <td><img src="images/pinxuan/spacer.gif" width="17" height="1" border="0" alt=""></td>
   <td><img src="images/pinxuan/spacer.gif" width="17" height="1" border="0" alt=""></td>
   <td><img src="images/pinxuan/spacer.gif" width="26" height="1" border="0" alt=""></td>
   <td><img src="images/pinxuan/spacer.gif" width="119" height="1" border="0" alt=""></td>
   <td><img src="images/pinxuan/spacer.gif" width="19" height="1" border="0" alt=""></td>
   <td><img src="images/pinxuan/spacer.gif" width="7" height="1" border="0" alt=""></td>
   <td><img src="images/pinxuan/spacer.gif" width="8" height="1" border="0" alt=""></td>
   <td><img src="images/pinxuan/spacer.gif" width="39" height="1" border="0" alt=""></td>
   <td><img src="images/pinxuan/spacer.gif" width="255" height="1" border="0" alt=""></td>
   <td><img src="images/pinxuan/spacer.gif" width="26" height="1" border="0" alt=""></td>
   <td><img src="images/pinxuan/spacer.gif" width="10" height="1" border="0" alt=""></td>
   <td><img src="images/pinxuan/spacer.gif" width="21" height="1" border="0" alt=""></td>
   <td><img src="images/pinxuan/spacer.gif" width="165" height="1" border="0" alt=""></td>
   <td><img src="images/pinxuan/spacer.gif" width="13" height="1" border="0" alt=""></td>
   <td><img src="images/pinxuan/spacer.gif" width="15" height="1" border="0" alt=""></td>
   <td><img src="images/pinxuan/spacer.gif" width="115" height="1" border="0" alt=""></td>
   <td><img src="images/pinxuan/spacer.gif" width="1" height="1" border="0" alt=""></td>
  </tr>

  <tr>
   <td rowspan="3">&nbsp;</td>
   <td colspan="14"></td>
   <td rowspan="3" colspan="2">&nbsp;</td>
   <td><img src="images/pinxuan/spacer.gif" width="1" height="10" border="0" alt=""></td>
  </tr>
  <tr>
   <td colspan="7"><a href="pinxuan.do?method=index"><img name="pinxuan2_r2_c2" src="images/pinxuan/logo.gif" width="213" height="25" border="0" alt=""></a></td>
   <td colspan="2">&nbsp;</td>
   <td colspan="5"><div><form action="pinxuan.do?method=check" method="post" name="form1" id="form1">
<span class="search">搜索</span>&nbsp;<input type="text" name="tName" style="width:126px; height:15px; border-color:#EEEEEE; background-color:#EFEFEF" />&nbsp;<input type="image" name="s1" src="images/pinxuan/go.gif" style="padding:0px; margin:0px;" />
</form></div></td>
   <td><img src="images/pinxuan/spacer.gif" width="1" height="25" border="0" alt=""></td>
  </tr>
  <tr>
   <td colspan="14" rowspan="3"><div>
     <table width="100%" border="0" cellspacing="0" cellpadding="0" background="images/pinxuan/i-topnavbg.gif">
       <tr>
         <td width="53" align="center">&nbsp;</td>
		 <td width="80" height="32" align="center"><div id="topnav0"><img src="images/pinxuan/redpoint.gif" width="28" height="32"></div></td>
         <td width="81" height="32" align="center"><div id="topnav1"><img src="images/pinxuan/redpoint.gif" width="28" height="32"></div></td>
         <td width="80" height="32" align="center"><div id="topnav2"><img src="images/pinxuan/redpoint.gif" width="28" height="32"></div></td>
         <td width="81" align="center"><div id="topnav3"><img src="images/pinxuan/redpoint.gif" width="28" height="32"></div></td>
         <td width="80" align="center"><div id="topnav4"><img src="images/pinxuan/redpoint2.gif" width="28" height="32"></div></td>
         <td width="81" align="center"><div id="topnav5"><img src="images/pinxuan/redpoint2.gif" width="28" height="32"></div></td>
         <td width="80" align="center"><div id="topnav6"><img src="images/pinxuan/redpoint2.gif" width="28" height="32"></div></td>
         <td width="81" align="center"><div id="topnav7"><img src="images/pinxuan/redpoint2.gif" width="28" height="32"></div></td>
         <td width="45" align="center"></td>
       </tr>
       <tr>
         <td align="center">&nbsp;</td>
<%@include file="topnav.jsp"%>
         <td align="center">&nbsp;</td>
       </tr>
     </table>
   </div></td>
   <td><img src="images/pinxuan/spacer.gif" width="1" height="20" border="0" alt=""></td>
  </tr>
  <tr>
   <td rowspan="5" valign="top"><div style="height:187px; border-top:#999999 solid 2px; padding-top:0px"><img name="pinxuan2_r4_c1" src="images/pinxuan/leftbg.gif" width="128" height="203" border="0" alt=""></div></td>
   <td colspan="2" rowspan="5" valign="top" bgcolor="#EFEFEF"><div style="height:203px; border-top:#999999 solid 2px; padding-top:0px; background:url(images/pinxuan/rightbg.gif) repeat-x;"></div></td>
   <td><img src="images/pinxuan/spacer.gif" width="1" height="12" border="0" alt=""></td>
  </tr>
  <tr>
    <td><img src="images/pinxuan/spacer.gif" width="1" height="21" border="0" alt=""></td>
  </tr>
  <tr>
   <td colspan="14"><img name="pinxuan2_r6_c2" src="images/pinxuan/topnavbottom.gif" width="742" height="15" border="0" alt=""></td>
   <td><img src="images/pinxuan/spacer.gif" width="1" height="15" border="0" alt=""></td>
  </tr>
  <tr>
   <td rowspan="3" valign="top" bgcolor="#EFEFEF"><img name="pinxuan2_r7_c2" src="images/pinxuan/colAleft.gif" width="17" height="180" border="0" alt=""></td>
   <td colspan="3" rowspan="3" valign="top"  bgcolor="#EFEFEF"><div style="margin:0px 0px 0px 0px; background:url(images/pinxuan/colAbg.gif) no-repeat;">
     <div class="colTitle3" style="; padding:18px 0px 0px 5px; height:18px;border-bottom:solid #CCCCCC 1px "><span style="letter-spacing:3px; font-size: 14px; "></span><span class="colMore">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="pinxuan.do?method=subPage&cName=view" class="colMore">More...</a></span></div>
	 
	 <%
	 	vol = 60;
	 	content = "暂无内容";
		
	 	for(int i = 0; i < (view == null ? 0 : view.size()); i++) {
	 %>
	 
	 <div style="padding:5px 5px 0px 0px">
	 	<div class="colTitleRed">
			&gt;&gt;&nbsp;<a href="show.do?c=<%=view.get(0).getContentId()%>" target="_blank" class="colTitleRed" title="header=[] body=[<%=view.get(0).getContentName()%>]"><%=(view.get(0).getContentName().length() < 10 ? view.get(0).getContentName() : view.get(0).getContentName().substring(0, 10))%></a></div>
		<div style="padding:10px 0px 0px 0px; color:#666666; height:80px">
	<%
			if (view.get(0).getHaveContent() > 0) {
				content = view.get(0).getContent().replaceAll("<([^<>]+)>", "").replace("&nbsp;", "");
				if(content.length() >= vol) content = content.substring(0, vol) + "...";
			} else {
				content = "暂无正文";
			}
			out.print(content);
	%>
		</div>
		<div style="padding:5px 0px 0px 0px; text-align:right" class="colMore2"><a href="show.do?c=<%=view.get(0).getContentId()%>" target="_blank" class="colMore2">全文</a></div>
	 </div>
	<%  } 
	 %>
   </div></td>
   <td rowspan="3" valign="top" bgcolor="#EFEFEF"><img name="pinxuan2_r7_c6" src="images/pinxuan/colAright.gif" width="19" height="180" border="0" alt=""></td>
   <td rowspan="3" valign="top" bgcolor="#EFEFEF"><img name="pinxuan2_r7_c7" src="images/pinxuan/centerbg.gif" width="7" height="180" border="0" alt=""></td>
   <td colspan="8" rowspan="3" align="center" valign="middle" bordercolor="#EFEFEF" style="border:solid #CCCCCC 1px;">

<%
	int imgFlag = 0;
	String fileName;
	String flashPath = "";
	ext = "";
	if(indexPic.size() <= 0) imgFlag = 0;	
	else {
		if(indexPic.get(0).getAttachmentSum() <= 0) imgFlag = 0;
		else {
			fileName = indexPic.get(0).getAtt(1).getAttachmentPath();
			ext = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
			//System.out.println(ext);
			if(ext.equals("gif") || ext.equals("jpg")) imgFlag = 1;
			else if(ext.equals("swf")) { imgFlag = 2; flashPath = fileName;  }
			else imgFlag = 0;
		}
	}

	
	
	
%>



<% if(imgFlag == 0) { %>
<div style="padding:3px;"><img src="images/pinxuan/subheadPic.gif" border="0" width="525" height="178"></div>

<% } else if (imgFlag == 1) {  %>

<div style="padding:3px;">
<!-- newsAd Begin -->
<script language="javascript">
var imgUrl=new Array();
var imgLink=new Array();
var text=new Array();
var adNum=0;
var buttonShow=1;
var buttonPos=2; //RU:1，RD:2，LU:3，LD:4
imgUrl[1]="images/pinxuan/subheadPic.gif";
imgLink[1]="";
text[1]="";
<%	int k = 1;
  	for(int i = 0; i < indexPic.size(); i++, k++){  
			fileName = indexPic.get(i).getAtt(1).getAttachmentPath();
			ext = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
 			if(!ext.equals("gif") && !ext.equals("jpg")) { k--; continue; }
%>
imgUrl[<%=k%>]="<%=indexPic.get(i).getAtt(1).getAttachmentPath()%>";
imgLink[<%=k%>]="<%=(indexPic.get(i).getSubTitle() != null ? indexPic.get(i).getSubTitle() : "")%>";
text[<%=k%>]="<%=(indexPic.get(i).getKeyWord() != null ? indexPic.get(i).getKeyWord() : "")%>";
<% } %>
</script>
<script language="javascript" src="dept/pinxuan/newsAd.js"></script>
<table id=newsTable border="0" cellspacing="0" cellpadding="0"><script language="javascript">dakularButtons();</script>
<tr><td><a onMouseOver="displayStatusMsg();return document.returnValue" onMouseOut="status='';" class=px14-lh24 href="javascript:jump2url()"><img style="FILTER: revealTrans(duration=1,transition=23); border:0px solid #000000" src="javascript:nextAd()" width=525 height=178 border=0 name=imgUrlrotator alt=""></a></td>
</tr>
</table>
<!-- newsAd End -->   </div>

<% } else {  %>

<div style="padding:3px;">
<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="525" height="178">
  <param name="movie" value="<%=flashPath%>" />
  <param name="quality" value="high" />
  <embed src="<%=flashPath%>" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="525" height="178"></embed>
</object>
</div>

<% } %>

</td>
   <td><img src="images/pinxuan/spacer.gif" width="1" height="139" border="0" alt=""></td>
  </tr>
  <tr>
   <td><img src="images/pinxuan/spacer.gif" width="1" height="18" border="0" alt=""></td>
  </tr>
  <tr>
   <td rowspan="12" bgcolor="#FFFFFF">&nbsp;</td>
   <td rowspan="6" valign="bottom" bgcolor="#EFEFEF"><img name="pinxuan2_r9_c16" src="images/pinxuan/colFright.gif" width="15" height="248" border="0" alt=""></td>
   <td rowspan="6" bgcolor="#EFEFEF">&nbsp;</td>
   <td><img src="images/pinxuan/spacer.gif" width="1" height="23" border="0" alt=""></td>
  </tr>
  <tr>
   <td colspan="11" bgcolor="#EFEFEF"></td>
   <td colspan="3"><img name="pinxuan2_r10_c13" src="images/pinxuan/colDbottom.gif" width="199" height="8" border="0" alt=""></td>
   <td><img src="images/pinxuan/spacer.gif" width="1" height="8" border="0" alt=""></td>
  </tr>
  <tr>
   <td rowspan="4" bgcolor="#EFEFEF">&nbsp;</td>
   <td colspan="3" rowspan="4" valign="top" bgcolor="#EFEFEF">

<div style="height:212px;margin-top:5px; background:url(images/pinxuan/colBbg0.gif) no-repeat;">
   		<div style=" padding:15px 0px 0px 0px; text-align:center; color:#0B7227; letter-spacing:3px; font-size:14px; font-weight:bold;">经验分享</div>
		<div style="padding:10px 5px 0px 5px; color:#0B7227; line-height:20px;"><table width="100%" cellpadding="0" cellspacing="0">
			<%
				for(int i = 0; i < (share == null ? 0 : share.size()); i++){
					cn = share.get(i).getContentName();
					if(cn.length() >= 9) cn = cn.substring(0, 9) + "...";
					out.println("<tr><td valign=\"top\"><img src=\"images/pinxuan/colBpoint.gif\" width=\"10\" height=\"12\" border=\"0\">&nbsp;</td><td class=\"colTextGreen\"><a href=\"show.do?c=" + share.get(i).getContentId() + "\" target=\"_blank\" class=\"colTextGreen\" title=\"header=[] body=[" + share.get(i).getContentName() + "]\">" + cn + "</a></td><tr>");
				}
			%>
		</table></div>
   </div>   </td>
   <td colspan="2" bgcolor="#EFEFEF">&nbsp;</td>
   <td colspan="2"><img name="pinxuan2_r11_c8" src="images/pinxuan/greenpoint1.gif" width="47" height="37" border="0" alt=""></td>
   <td colspan="6" bgcolor="#EFEFEF"><div style="margin:13px 5px 0px 8px; padding:0px 0px 5px 0px; border-bottom:solid #CCCCCC 1px"><span class="colTitle1">信息之窗</span>&nbsp;<span class="colTitle2">Information Window</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="colMore"><a href="pinxuan.do?method=subPage&cName=news" class="colMore">More...</a></span></div></td>
   <td><img src="images/pinxuan/spacer.gif" width="1" height="37" border="0" alt=""></td>
  </tr>
  <tr>
   <td colspan="2" rowspan="3" bgcolor="#EFEFEF">&nbsp;</td>
   <td colspan="4" rowspan="3" valign="top" bgcolor="#EFEFEF">

<!-- news Begin -->
<div>
	<%
		vol = 80;
		
		//-----------------------------------
		String path0, att;
		int attStart;
		//-----------------------------------
		
		for(int i = 0; i < (1 < news_top.size() ? 1 : news_top.size()); i++){
		
				//-----------------------------------
				List<UlContentWithAtt> list = news_top;
				att = "";
				attStart = 0;
				path0 = "show.do?c=" + list.get(i).getContentId();
				path = path0;
				if(list.get(i).getHaveContent() == 0 && list.get(i).getAttachmentSum() > 0){
					path = path0 + "&a=1";
					attStart = 1;
				}
				for(int j = attStart + 1; j <= list.get(i).getAttachmentSum() ; j++){
					att += "&nbsp;&nbsp;<a target=\"_blank\" href=\"" + path0 + "&a=" + j + "\" class=\"colText\">";
					att += "附件" + (j - attStart) + "</a>";
				}
				//-----------------------------------		
		
		
		
	%>
     <div style="padding:10px 0px 5px 10px;" class="colText"><span style="color:#E6213D;">-&gt;&nbsp;</span><a href="<%=path%>" target="_blank" class="colText" title="header=[] body=[<%=news_top.get(0).getContentName()%>]"><%=(news_top.get(0).getContentName().length() < 20 ? news_top.get(0).getContentName() : news_top.get(0).getContentName().substring(0, 20))%></a></div>
     <div style="padding:0px 10px 0px 40px; color:#333333; line-height:15px; height:45px;">
       <%
			
			if(news_top.get(0).getContent() != null){
				content = news_top.get(0).getContent().replaceAll("<([^<>]+)>", "").replace("&nbsp;", "");
				if(content.length() >= vol) content = content.substring(0, vol) + "...";
			}else if(news_top.get(0).getAttachmentSum() > 0){
				content = att;
			}else{
				content = "暂无正文...";
			}
			
			out.print(content);
	  %>
     </div>
	 <%  }  %>
     <div style="padding:10px 0px 10px 10px; line-height:20px;">
       <table width="100%" cellpadding="0" cellspacing="0">
         <%
				//size = 3;	//品宣动态总显示条数
				vol = 20;
				for(int i = 0; i < news_normal.size(); i++){
					cn = news_normal.get(i).getContentName();
					if(cn.length() >= vol) cn = cn.substring(0, vol) + "...";
					out.println("<tr><td width=\"20\" valign=\"top\" style=\"color:#E6213D;\">-&gt;&nbsp;</td><td class=\"colText\"><a href=\"show.do?c=" + news_normal.get(i).getContentId() + "\" target=\"_blank\" class=\"colText\" title=\"header=[] body=[" + news_normal.get(i).getContentName() + "]\">" + cn + "</a></td><tr>");
					
				}
		%>
       </table>
     </div>
</div>
<!-- news End -->   </td>
   <td colspan="2" bgcolor="#EFEFEF">&nbsp;</td>
   <td><img name="pinxuan2_r12_c14" src="images/pinxuan/colF1.gif" width="165" height="21" border="0" alt=""></td>
   <td bgcolor="#EFEFEF">&nbsp;</td>
   <td><img src="images/pinxuan/spacer.gif" width="1" height="22" border="0" alt=""></td>
  </tr>
  <tr>
   <td colspan="2"><img name="pinxuan2_r13_c12" src="images/pinxuan/colF4.gif" width="31" height="120" border="0" alt=""></td>
   <td><div style="text-align:center;">
   <%
   		flag = 0;
   		imgPath = "images/pinxuan/newsPic.gif";
   		if(news_top.size() > 0){
			if(news_top.get(0).getAttachmentSum() > 0){
				path = news_top.get(0).getAtt(1).getAttachmentPath();
				ext = path.substring(path.lastIndexOf(".") + 1, path.length());
				if(ext.equals("jpg") || ext.equals("gif")){
					flag = 1;
				}
			}
		}
		
		if(flag == 1){
   			imgPath = news_top.get(0).getAtt(1).getAttachmentPath();
			out.println("<a href=\"" + imgPath + "\" target=\"_blank\"><img src=\"" + imgPath + "\" width=\"163\" height=\"118\" border=\"0\"></a>");	
		}else{
			out.println("<img src=\"" + imgPath + "\" width=\"163\" height=\"118\" border=\"0\">");
		}
   %></div></td>
   <td><img name="pinxuan2_r13_c15" src="images/pinxuan/colF2.gif" width="13" height="120" border="0" alt=""></td>
   <td><img src="images/pinxuan/spacer.gif" width="1" height="120" border="0" alt=""></td>
  </tr>
  <tr>
   <td colspan="2" bgcolor="#EFEFEF">&nbsp;</td>
   <td><img name="pinxuan2_r14_c14" src="images/pinxuan/colF3.gif" width="165" height="37" border="0" alt=""></td>
   <td><img name="pinxuan2_r14_c15" src="images/pinxuan/colF3right.gif" width="13" height="38" border="0" alt=""></td>
   <td><img src="images/pinxuan/spacer.gif" width="1" height="38" border="0" alt=""></td>
  </tr>
  <tr>
   <td colspan="4" rowspan="2" bgcolor="#EFEFEF"></td>
   <td rowspan="5" bgcolor="#EFEFEF">&nbsp;</td>
   <td rowspan="3" colspan="3"><img name="pinxuan2_r15_c7" src="images/pinxuan/greenpoint2.gif" width="54" height="45" border="0" alt=""></td>
   <td colspan="6" background="images/pinxuan/colEbottom.gif"></td>
   <td colspan="2" background="images/pinxuan/colEbottom.gif"></td>
   <td><img src="images/pinxuan/spacer.gif" width="1" height="7" border="0" alt=""></td>
  </tr>
  <tr>
   <td colspan="6" rowspan="2"><div style="margin:13px 5px 0px 8px; padding:0px 0px 5px 0px; border-bottom:solid #CCCCCC 1px"><span class="colTitle1">新品速递</span>&nbsp;<span class="colTitle2">New Express</span></div></td>
   <td colspan="2" rowspan="5" bgcolor="#FFFFFF">&nbsp;</td>
   <td><img src="images/pinxuan/spacer.gif" width="1" height="4" border="0" alt=""></td>
  </tr>
  <tr>
   <td rowspan="4" bgcolor="#EFEFEF">&nbsp;</td>
   <td rowspan="2" colspan="3"><img name="pinxuan2_r17_c3" src="images/pinxuan/colCtitle.gif" width="162" height="57" border="0" alt=""></td>
   <td><img src="images/pinxuan/spacer.gif" width="1" height="34" border="0" alt=""></td>
  </tr>
  <tr>
   <td rowspan="3" colspan="9">
   
   <div style="padding:0px 0px 10px 0px;">



  <TABLE cellSpacing=0 cellPadding=0 width="500" height="80" align=center border=0>
  <TBODY>
  <TR>
    <TD>
      <DIV id=demo style="OVERFLOW: hidden; WIDTH: 100%; COLOR: #ffffff">
      <TABLE cellSpacing=0 cellPadding=0 align=left border=0 cellspace="0">
        <TBODY>
        <TR>
          <TD id=demo1 vAlign=top><table width="<%=aboutus.size() * 100%>" height="116"  border="0" cellpadding="0" cellspacing="0">
            <tr>
			<%   
			for(int i = 0; i < aboutus.size(); i++) {
			  %><td width="100"><div style="padding:0px 10px 0px 5px;"><%=(aboutus.get(i).getSubTitle() != null ? "<a href=\"" + aboutus.get(i).getSubTitle() + "\" target=\"_blank\">" : "")%><img src="<%=(aboutus.get(i).getAttachmentSum() > 0 ? aboutus.get(i).getAtt(1).getAttachmentPath() : "images/pinxuan/abtusPic.gif")%>" border="0" width="85" height="100"><%=(aboutus.get(i).getSubTitle() != null ? "</a>" : "")%></div></td><%  } %>
            </tr>
          </table></TD>
          <TD id=demo2 vAlign=top>&nbsp;</TD></TR></TBODY></TABLE></DIV>
    </TD></TR></TBODY></TABLE>

<script language=JavaScript>

var speed3=25;	//速度数值越大速度越慢
demo2.innerHTML=demo1.innerHTML
function Marquee(){
	if(demo2.offsetWidth-demo.scrollLeft<=0)
		demo.scrollLeft-=demo1.offsetWidth
	else{
		demo.scrollLeft++
	}
}
var MyMar=setInterval(Marquee,speed3)
demo.onmouseover=function() {clearInterval(MyMar)}
demo.onmouseout=function() {MyMar=setInterval(Marquee,speed3)}

</script>

</div>
	</td>
   <td><img src="images/pinxuan/spacer.gif" width="1" height="23" border="0" alt=""></td>
  </tr>
  <tr>
   <td colspan="3" valign="top" bgcolor="#C0C0C0"><div style=" margin-top:15px;text-align:center; color:#FFFFFF;">
     <span class="fax">Fax:010-58797766-88005</span><br>
       <br>
    <span class="email"><a href="mailto:tougao@ulic.com.cn" class="email">tougao@ulic.com.cn</a></span></div></td>
   <td><img src="images/pinxuan/spacer.gif" width="1" height="89" border="0" alt=""></td>
  </tr>
  <tr>
   <td colspan="3" bgcolor="#EFEFEF">&nbsp;</td>
   <td bgcolor="#EFEFEF">&nbsp;</td>
   <td><img src="images/pinxuan/spacer.gif" width="1" height="24" border="0" alt=""></td>
  </tr>
  <tr>
   <td height="80" colspan="6" rowspan="2" bgcolor="#4DAC26">&nbsp;</td>
   <td colspan="9"><img name="pinxuan2_r21_c7" src="images/pinxuan/colGbottom.gif" width="544" height="21" border="0" alt=""></td>
   <td height="80" colspan="2" rowspan="2" bgcolor="#4DAC26"></td>
   <td><img src="images/pinxuan/spacer.gif" width="1" height="21" border="0" alt=""></td>
  </tr>
  <tr>
   <td height="58" colspan="9" valign="top" bgcolor="#4DAC26"><div style=" height:16px color:#FFFFFF; margin-top:9px;padding:0px 0px 0px 90px">
     <table width="180" border="0" cellspacing="0" cellpadding="0">
       <tr>
         
         <td align="center" class="bottomnav_text"><a href="pinxuan.do?method=subPage&cName=address" class="bottomnav_text">品宣通讯录</a></td>
         <td align="center" class="bottomnav_text"><a href="pinxuan.do?method=subPage&cName=sitemap" class="bottomnav_text">网站地图</a></td>
		 <td align="center" class="bottomnav_text"><a href="admin/index.jsp" class="bottomnav_text" target="_blank">系统管理</a></td>
       </tr>
     </table>
   </div>
     <div style=" color:#FFFFFF; margin-top:7px;padding:0px 0px 0px 0px">（C）Copyright 2008 合众人寿保险股份有限公司品牌宣传版权所有</div></td>
   <td><img src="images/pinxuan/spacer.gif" width="1" height="42" border="0" alt=""></td>
  </tr>
</table>

<script type="text/javascript">
function topnavOut(){
	navOut(0);
}
topnavOut();
</script>

</body>
</html>

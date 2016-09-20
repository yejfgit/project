<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlTemplate,com.ulic.ulweb.ulweb.entity.UlColumn,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.ulweb.entity.UlContentWithAtt,com.ulic.ulweb.ulweb.util.DisplayOnPage" pageEncoding="UTF-8"%>

<%
		List<UlContent> share = (List<UlContent>)request.getAttribute("share");
		List<UlContent> view = (List<UlContent>)request.getAttribute("view");
		List<UlContentWithAtt> subheadPic = (List<UlContentWithAtt>)request.getAttribute("subheadPic");
		
		DisplayOnPage d = new DisplayOnPage();
		d.setRequest(request);

		//----2级栏目头部图片----------------------------------
		String imgPath = "";	//本栏目显示出来的图片地址
		String cName = (String)request.getAttribute("ptype");
		for(int i = 0; i < (subheadPic == null ? 0 : subheadPic.size()); i++){
			if(subheadPic.get(i).getContentName().indexOf(cName) != -1){
				if(subheadPic.get(i).getAttachmentSum() > 0){
					imgPath = "subheadPic.src=\"" + subheadPic.get(i).getAtt(1).getAttachmentPath() + "\";";
					subheadPic = null;
				}
			}
		}
		//-----------------------------------------------------------

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- saved from url=(0014)about:internet -->
<html>
<head>
<title>合众视角 - 合众人寿品牌宣传</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!--Fireworks 8 Dreamweaver 8 target.  Created Sat Sep 27 15:19:08 GMT+0800 2008-->
<link rel="stylesheet" href="dept/pinxuan/pinxuan.css" type="text/css" />
<script type="text/javascript" src="script/pinxuan.js"></script>
<script type="text/javascript" src="dept/pinxuan/boxover.js"></script>

</head>
<body bgcolor="#ffffff">

<!-- subpage header Start -->
<%@include file="subhead.jsp"%>
<table width="1000" align="center" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="114" bgcolor="#EFEFEF">&nbsp;</td>
        <td width="220" valign="top"><div style="">
          <div style=" margin:20px 20px 15px 25px; width:160px; height:220px; background-image:url(images/pinxuan/colBbg.gif); background-repeat:no-repeat;">
            <div style=" padding:20px 0px 0px 0px; text-align:center; color:#0B7227; letter-spacing:3px; font-size:14px; font-weight:bold;">经验分享</div>
            <div style="padding:10px 5px 0px 5px; color:#0B7227; line-height:20px;">
              <table width="100%" cellpadding="0" cellspacing="0">
                <%
				for(int i = 0; i < (share == null ? 0 : share.size()); i++){
					String cn = share.get(i).getContentName();
					if(cn.length() >= 9) cn = cn.substring(0, 9) + "...";
					out.println("<tr><td valign=\"top\"><img src=\"images/pinxuan/colBpoint.gif\" width=\"10\" height=\"12\" border=\"0\">&nbsp;</td><td class=\"colTextGreen\"><a href=\"show.do?c=" + share.get(i).getContentId() + "\" target=\"_blank\" class=\"colTextGreen\" title=\"header=[] body=[" + share.get(i).getContentName() + "]\">" + cn + "</a></td><tr>");
					//size -= Math.round(share.get(i).getContentName.length() / 10);
				}
			%>
              </table>
            </div>
          </div>
          </div></td>
        <td valign="top"><div style="border-left:#CCCCCC solid 1px;">
		<div style="height:23px; width:540px; margin-left:10px; border-bottom:#CCCCCC solid 1px; padding:1px 20px 1px 0px; text-align:right">
		  <div style="float:right; height:20px; padding-top:5px; font:宋体 12px; color:#666666">&nbsp;&gt;&gt;&nbsp;&nbsp;合众视角</div>
		  <div style=" float:right; width:30px; height:20px; text-align:center; "><a href="pinxuan.do?method=index"><img src="images/pinxuan/index.gif" width="30" height="20" border="0"></a></div>
		  </div>

		<div style="width:540px; height:200px; margin-left:5px; padding:10px 10px 10px 20px; line-height:15px; color:#666666;">
		  <table width="100%" border="0" cellspacing="0" cellpadding="0">

		  <%
		  	//-----------------------------------
		  	String path, path0, att;
			int attStart;
			//-----------------------------------		  
		  
		  	for(int i = 0; i < (view == null ? 0 : view.size()); i++) {
			
				//-----------------------------------
				List<UlContent> list = view;
				att = "";
				attStart = 0;
				path0 = "show.do?c=" + list.get(i).getContentId();
				path = path0;
				if(list.get(i).getHaveContent() == 0 && list.get(i).getAttachmentSum() > 0){
					path = path0 + "&a=1";
					attStart = 1;
				}
				for(int j = attStart + 1; j <= list.get(i).getAttachmentSum() ; j++){
					att += "&nbsp;&nbsp;<a target=\"_blank\" href=\"" + path0 + "&a=" + j + "\">";
					att += "附件" + (j - attStart) + "</a>";
				}
				//-----------------------------------			
			
		  %>

            <tr>
              <td width="20" valign="top"><span style="font-size:9px;">●</span></td>
              <td valign="top"><div style=" padding:3px; border-bottom:dotted #CCCCCC 1px;" class="listText"><a href="<%=path%>" target="_blank" class="listText"><%=(view.get(i).getContentName().length() < 30 ? view.get(i).getContentName() : view.get(i).getContentName().substring(0, 30) + "...")%></a><%=att%></div></td>
              <td width="100" valign="bottom"><div style="padding:3px;border-bottom:dotted #CCCCCC 1px;"><%=view.get(i).getDay()%></div></td>
            </tr>

			<%  } %>
          </table>

		</div>		
		<div style="padding:15px 10px 15px 40px;" class="listText">
		  <%=d.toPage(1)%>
		  </div>
		
		</div></td>
        <td width="114" bgcolor="#EFEFEF">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
 <%@include file="subfoot.jsp"%>
</table>
<!-- subpage header End -->




<script type="text/javascript">
function topnavOut(){
	navOut(-1);
}
topnavOut();
<%=imgPath%>

</script>

</body>
</html>

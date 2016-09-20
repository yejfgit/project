<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlTemplate,com.ulic.ulweb.ulweb.entity.UlColumn,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.ulweb.entity.UlContentWithAtt,com.ulic.ulweb.ulweb.util.DisplayOnPage" pageEncoding="UTF-8"%>

<%
		List<UlContent> share = (List<UlContent>)request.getAttribute("share");
		List<UlContent> address = (List<UlContent>)request.getAttribute("address");
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
<title>品宣通讯录 - 合众人寿品牌服务网站</title>
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
		  <div style="float:right; height:20px; padding-top:5px; font:宋体 12px; color:#666666">&nbsp;&gt;&gt;&nbsp;品宣通讯录&nbsp;</div>
		  <div style=" float:right; width:30px; height:20px; text-align:center; "><a href="pinxuan.do?method=index"><img src="images/pinxuan/index.gif" width="30" height="20" border="0"></a></div>
		  </div>
		
		
		<div style="margin:10px; height:100%;">
		  <%

			String content = "暂无内容";
			if(address != null){
				if(address.size() > 0){
					content = address.get(0).getContent();
				}
			}
			out.println(content);

		%>
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

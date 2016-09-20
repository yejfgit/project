<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlTemplate,com.ulic.ulweb.ulweb.entity.UlColumn,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.ulweb.entity.UlContentWithAtt,com.ulic.ulweb.ulweb.util.DisplayOnPage" pageEncoding="UTF-8"%>

<%
		List<UlContent> share = (List<UlContent>)request.getAttribute("share");
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
<title>经验分享 - 合众人寿品牌服务网站</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!--Fireworks 8 Dreamweaver 8 target.  Created Sat Sep 27 15:19:08 GMT+0800 2008-->
<link rel="stylesheet" href="dept/pinxuan/pinxuan.css" type="text/css" />
<script type="text/javascript" src="script/pinxuan.js"></script>

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
          <div style=" margin:20px 10px 15px 15px; width:170px; height:220px;"><a href="pinxuan.do?method=subPage&cName=newspaper"><img src="images/pinxuan/npSmall.gif" width="184" height="250" border="0"></a></div>
		  
		  </div></td>
        <td valign="top"><div style="border-left:#CCCCCC solid 1px;">
		<div style="height:23px; width:540px; margin-left:10px; border-bottom:#CCCCCC solid 1px; padding:1px 20px 1px 0px; text-align:right">
		  <div style="float:right; height:20px; padding-top:5px; font:宋体 12px; color:#666666">&nbsp;&gt;&gt;&nbsp;经验分享&nbsp;</div>
		  <div style=" float:right; width:30px; height:20px; text-align:center; "><a href="pinxuan.do?method=index"><img src="images/pinxuan/index.gif" width="30" height="20" border="0"></a></div>
		  </div>
		
		<div style="width:540px; height:200px; margin-left:5px; padding:10px 10px 10px 20px; line-height:15px; color:#666666;">
		  <table width="100%" border="0" cellspacing="0" cellpadding="0">
		  
		  <%
		  	//-----------------------------------
		  	String path, path0, att;
			int attStart;
			//-----------------------------------		  
		  
		  	for(int i = 0; i < (share == null ? 0 : share.size()); i++) {
			
				//-----------------------------------
				List<UlContent> list = share;
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
              <td valign="top"><div style=" padding:3px; border-bottom:dotted #CCCCCC 1px;" class="listText"><a href="<%=path%>" target="_blank" class="listText"><%=(share.get(i).getContentName().length() < 30 ? share.get(i).getContentName() : share.get(i).getContentName().substring(0, 30) + "...")%></a><%=att%></div></td>
              <td width="100" valign="bottom"><div style="padding:3px;border-bottom:dotted #CCCCCC 1px;"><%=share.get(i).getDay()%></div></td>
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
	navOut(6);
}
topnavOut();
<%=imgPath%>

</script>

</body>
</html>

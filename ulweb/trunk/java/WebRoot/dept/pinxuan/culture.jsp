<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlTemplate,com.ulic.ulweb.ulweb.entity.UlColumn,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.ulweb.entity.UlContentWithAtt,com.ulic.ulweb.ulweb.util.DisplayOnPage" pageEncoding="UTF-8"%>

<%
		UlColumn c = (UlColumn)request.getAttribute("column");
		List<UlColumn> columnList = (List<UlColumn>)request.getAttribute("columnList");
		List<UlContent> video = (List<UlContent>)request.getAttribute("culture");
		List<UlContent> video_intro = (List<UlContent>)request.getAttribute("culture_intro");
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
<title>企业文化 - 合众人寿品牌宣传</title>
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
        <td width="114" bgcolor="#EFEFEF">&nbsp;</td><%  if(columnList.size() > 0) {  %>
        <td width="220" valign="top">
		

		
		<div style="height:100%;">
          <div style="margin:2px; padding:2px; border:solid #999999 1px;">
 
 				<div style=" height:14px; background:url(images/pinxuan/sp-colBg.gif) repeat-y; padding:3px 0px 3px 0px; text-align:center; color:#666666; font-size:15px; font-weight:bold;">企业文化</div>

          </div>
		 <div style="padding:10px 10px 10px 25px;">
		 
			<table width="100%" border="0" cellspacing="2" cellpadding="2">
            
			<%
			    for(int i=0; i<(columnList == null ? 0 : columnList.size()); i++){
			%>
			
			<tr>
              <td width="25" valign="middle"><img src="images/pinxuan/sp-colPoint.gif"></td>
              <td valign="middle" class="colNpText"><a href="pinxuan.do?method=subPage&cName=culture&columnId=<%=columnList.get(i).getColumnId()%>" class="colNpText"><%=columnList.get(i).getColumnName()%></a></td>
            </tr>
			
			<%  }  %>
          </table>
		 </div>
	
		</div>
		

		</td><% } %>
        <td valign="top"><div style="border-left:#CCCCCC solid 1px;">
				<div style="height:23px; width:540px; margin-left:10px; border-bottom:#CCCCCC solid 1px; padding:1px 20px 1px 0px; text-align:right">
		  <div style="float:right; height:20px; padding-top:5px; font:宋体 12px; color:#666666">&nbsp;&gt;&gt;&nbsp;企业文化&nbsp;&gt;&gt;&nbsp;<%=c.getColumnName()%></div><div style=" float:right; width:30px; height:20px; text-align:center; "><a href="pinxuan.do?method=index"><img src="images/pinxuan/index.gif" width="30" height="20" border="0"></a></div>
		  </div>

		
<%
if(video_intro != null) {

%>
		<div style="width:<%=(columnList.size() > 0 ? "540" : "772")%>px; padding:20px 20px 30px 20px; line-height:15px; color:#666666;">
		  <%

			String vicontent = "暂无内容";
			if(video_intro.size() > 0){
				vicontent = video_intro.get(0).getContent();
			}
			out.println(vicontent);

		%>
		
		</div>
		
<%

} else {

%>
		<div>
<!--
		<div style="height:23px; width:540px; margin-left:10px; border-bottom:#CCCCCC solid 1px; padding:1px 20px 1px 0px; text-align:right"><div style="float:right; height:20px; padding-top:5px; font:宋体 12px; color:#666666">&nbsp;&gt;&gt;&nbsp;企业文化&nbsp;&gt;&gt;&nbsp;<%=c.getColumnName()%></div><div style=" float:right; width:30px; height:20px; text-align:center; "><a href="pinxuan.do?method=index"><img src="images/pinxuan/index.gif" width="30" height="20" border="0"></a></div> 
</div>
-->
		<div style="width:540px; height:200px; padding:20px 20px 30px 20px; line-height:15px; color:#666666;">
		
<%

			String vcontent = "暂无内容";
			if(video.size() > 0){
				vcontent = video.get(0).getContent();
			}
			out.println(vcontent);

		%>
		
		</div>
		  
		  <div style="padding:15px 10px 15px 40px;" class="listText">
		  <%=d.toPage(1)%>
		  </div>
		  
		  
		  
		  </div>
		  
		  <% }  %>
		  </div>
		  </td>
        <td width="114" bgcolor="#EFEFEF">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
<%@include file="subfoot.jsp"%>
</table>
<!-- subpage header End -->




<script type="text/javascript">
function topnavOut(){
	navOut(1);
}
topnavOut();
<%=imgPath%>

</script>

</body>
</html>

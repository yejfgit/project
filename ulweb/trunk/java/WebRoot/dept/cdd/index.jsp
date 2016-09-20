
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlTemplate,com.ulic.ulweb.ulweb.entity.UlColumn,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.ulweb.entity.UlContentWithAtt" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<HTML>
<HEAD>
<TITLE>机构发展部主页</TITLE>

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
<link rel="stylesheet" href="style/ul.css" type="text/css" /> 
<link rel="stylesheet" href="dept/cdd/cdd.css" type="text/css" />

<%
		UlTemplate t = (UlTemplate)request.getAttribute("template");
		
		List<UlColumn> columnListTop1 = (List<UlColumn>)request.getAttribute("columnListTop1");			
		List<UlColumn> columnForCheck = (List<UlColumn>)request.getAttribute("columnForCheck");			
		List<UlColumn> cList = null;		
		
		
		List<UlContent> listCenter1 = (List<UlContent>)request.getAttribute("contentListCenter1");
		List<UlContent> listRight1 = (List<UlContent>)request.getAttribute("contentListRight1");
		List<UlContentWithAtt> listRight2 = (List<UlContentWithAtt>)request.getAttribute("contentListRight2");		
		List<UlContent> listRight3 = (List<UlContent>)request.getAttribute("contentListRight3");
		List<UlContent> list = null;
		List<UlContentWithAtt> picList = null;
		
		UlContent cc = (UlContent)request.getAttribute("lingdaojiyu");
		
		String titleColor[] = {"#000000","#ffffff","#000000","#0066ff","#009900","#00dddd","#ffccff","#9900cc","#ffcc00","#ff0000"};
			
	%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style>
p{
margin:0px;
}
div{background-repeat:no-repeat;}
</style>
</HEAD>
<body  background="images/cdd/bg.jpg">
<div style="text-align:left;width:800px;">
<div id="masthead" >
	<div style="width:100%;height:132px;overflow:hidden;" > 
			<%
			if(t.getPic1() != null){
						%>
			<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0"  width="800" height="132" >
              <param name="movie" value="<%=t.getPic1()%>">
              <param name="quality" value="high">
              <embed src="<%=t.getPic1()%>" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="800"  height="132" ></embed>
	  </object>
			<%
						}
			%>
		
	</div>
	<div style="margin:5px 0px 5px 0px;border-top:1px green solid;border-bottom:1px gray solid;height:10px;overflow:hidden;background-color:#fff;"></div>
  <div id="globalNav" >
  	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td align="center" style='border-right:1px #006699 solid;'><a href="cdd.do?method=index" style="font-weight:bold;">部门首页</a></td>
			<td align="center" style='border-right:1px #006699 solid;'><a href="show.do?ptype=cdd&c=5284" target="_blank" style="font-weight:bold;">部门简介</a></td><%
		cList = columnListTop1;
		for(int i = 0 ; i < (cList == null ? 0 : cList.size()); i++){
			out.print("<td align='center' style='border-right:1px #006699 solid;'><a style=\"font-weight:bold;\" href='cdd.do?method=subPage1&dept=cdd&columnId=" + cList.get(i).getColumnId() + "'>");
			out.print(cList.get(i).getColumnName());
			out.print("</a></td>");
		}
					
  	%><td align="center" ><a href="mailto:guozj@ulic.com.cn" target="_blank" style="font-weight:bold;">合理化建议</a></td>
		</tr>
	</table>
  </div>  
<!--  <div style="background-color:#C6F2FD;height:5px;overflow:hidden;"></div> -->
</div>
<div style="width:800px;height:auto; background-color:#fff; border:1px #BCEFE9 solid;">	
	<div id="headlines">
		
	   <div style="background-image:url('images/cdd/smalltitle.gif'); text-align:left;  padding:8px 0px 0px 25px; height:30px; font-size:14px; font-weight:bold; " >
	 文件查询
	  </div>
	  <div id="advert"  style="height:130px;">
	  	  <form action="cdd.do?method=check" id="idform1" name="form1" method="post" >
			   <input type="hidden" value="cdd" name="dept" />
			   <input type="hidden" name="ptype" value="<%=(request.getParameter("ptype") == null ? "" : request.getParameter("ptype"))%>" />
			   <input type="hidden" value="/dept/cdd/checkshow" name="forward" />
		<div style="padding:8px 0px 0px 25px;">
			   
			标题：<input type="text" name="tName" size="18">
			<br>
			类型：<select  name="type" id="idtype" style="width:123px">
					<option value="0" selected>全部</option>
					<%
						cList = columnForCheck;
							for(int i = 0; i < (cList == null ? 0 : cList.size()); i++){
								out.println("<option value='" + cList.get(i).getColumnId() + "'>" + cList.get(i).getColumnName() + "</option>");
							}
						%>
                </select>
			<br>
			&nbsp;&nbsp;&nbsp;从：<input id="demo" name="ts" size="18" value="" type="text"  style="text-align:right;" />				
		  <br>
			&nbsp;&nbsp;&nbsp;至：<input id="demo1" name="te" size="18" value="" type="text" style="text-align:right;" />			
			<br>
			<center>
				<input style="margin-top:5px;" type="submit" value="查询" />
			</center>
			</div>	
		</form>
		
	  </div>
	  <div class="title1" style="background-image:url('images/cdd/smalltitle.gif'); text-align:left;  padding:5px 0px 0px 25px; height:30px; font-size:14px;">
	 机构文件
	  </div> 	
	  <div id="advert" style="padding:30px 0px 0px 0px;" >
		<ul>
			<li><a href="cdd.do?method=subPage1&dept=cdd&columnId=408">批筹文件 &nbsp;&gt;&gt;&gt; </a>	</li>
			
			<li><a href="cdd.do?method=subPage1&dept=cdd&columnId=409">开业文件 &nbsp;&gt;&gt;&gt; </a></li>
		
			<li><a href="cdd.do?method=subPage1&dept=cdd&columnId=410">撤销文件 &nbsp;&gt;&gt;&gt; </a></li>
			
			
		</ul>
		
	  </div> 
	  <div style="background-image:url('images/cdd/smalltitle.gif'); text-align:left; height:30px; padding:8px 0px 0px 25px; font-weight:bold; " >
	  <a href="http://ulweb/newapp/contact/contact.htm" target="_blank" style="color:#000; font-size:14px; font-weight:bold;">机构通讯</a>
	  </div> 	
	  <div id="advert" style="padding:30px 0px 0px 0px;" >
		<ul>
			<li>	信息维护员:郭志江	</li>
			
			<li>	电话:010-58797766-88289	</li>
		
			<li>	Email: guozj@ulic.com.cn	</li>
			
			<li>	<a href="mailto:guozj@ulic.com.cn" style="font-size:12px;" target="_blank">问题上报</a> &nbsp; &nbsp; &nbsp;
			 <a href="admin/login.jsp" target="_blank" style="font-size:12px;">系统管理</a>
			 </li>
		</ul>
		
	  </div> 
	</div>
<div class="picline1"></div>

<div id="content">
  <div class="feature">
  	<div class="titlecenter1" style="background-image:url('images/cdd/smalltitle.gif'); ">
		<div style="width:70%; float:left; text-align:left; padding:8px 0px 0px 25px; font-size:14px;">
		机构新闻
		</div>
		<div style="float:left; width:30%; padding:5px 0px 0px 20px;">
			<a href="cdd.do?method=subPage1&dept=cdd&columnId=128" style="font-size:12px;">more&gt;&gt;&gt;</a>
		</div>	
	</div>

  	<div style="height:133px;overflow:visible;margin:5px 0px 5px 0px;padding:5px 5px 5px 10px;">
		<%		
			list = listCenter1;
			if(list != null){
				for(int i = 0; i < list.size(); i++){					
					out.println("<p style=\"border-bottom:1px dotted #bbb;\">");					
					if(list.get(i).getHaveContent() == 0 && list.get(i).getAttachmentSum() != 0){
						out.print("<a target='_blank' href='show.do?c=" + list.get(i).getContentId() + "&a=1' style='color:" + titleColor[list.get(i).getDisplayType()] + "'>");
						out.println(list.get(i).getContentName() + "</a>");
						out.println(list.get(i).getNewPic(3) + "&nbsp;/" + list.get(i).getDay() );					
							
						if(list.get(i).getAttachmentSum() > 1){
							out.print("<br>");
							for(int j = 2; j <= list.get(i).getAttachmentSum() ; j++){
								out.print("<a target='_blank' href='show.do?c=" + list.get(i).getContentId() + "&a=" + j + "'>");
								out.print("附件" + (j - 1) + "</a> &nbsp;&nbsp;");
							}							
						}
					}else{
						out.print("<a target='_blank' href='show.do?ptype=cdd&c=" + list.get(i).getContentId() + "' style='color:" + titleColor[list.get(i).getDisplayType()] + "'>");
						out.println(list.get(i).getContentName() + "</a>");
						out.println(list.get(i).getNewPic(3) + "&nbsp;/" + list.get(i).getDay());					
								
						if(list.get(i).getAttachmentSum() > 0){
							out.print("<br>");
							for(int j = 1; j <= list.get(i).getAttachmentSum() ; j++){
								out.print("<a target='_blank' href='show.do?c=" + list.get(i).getContentId() + "&a=" + j + "'>");
								out.print("附件" + j + "</a> &nbsp;&nbsp;");
							}							
						}
					}
					out.print("</p>");	
				}
			}
			
			%>
	</div>
  </div> 
  <div class="titlecenter1" style="background-image:url('images/cdd/smalltitle.gif'); ">
		<div style="width:70%; float:left; text-align:left; padding:8px 0px 0px 25px; font-size:14px;">
		机构分布
		</div>
		<div style="float:left; width:30%; padding:5px 0px 0px 20px;">
			<a href="show.do?c=8908&ptype=nothing" style="font-size:12px;">more&gt;&gt;&gt;</a>
		</div>	
	</div>
	
  <!--<div style="height:5px;margin:5px 0px 5px 0px;width:100%;background-color:#C6F2FD;overflow:hidden;"></div>-->
  
  <div>
  
	<img usemap="#chinamap" src="<%=t.getPic2()%>" border="0" />
	
  </div>
</div>

<div class="picline1"></div>


<div id="navBar">
	<div style="height:30px;border-bottom:1px #000000 solid;padding:8px 0px 0px 25px;  font-size:14px;background-image:url('images/cdd/smalltitle.gif'); font-weight:bolder;">
		
			资源共享
			&nbsp; &nbsp; &nbsp;&nbsp; 
		<a href="cdd.do?method=subPage1&dept=cdd&columnId=129" style="font-size:12px;">more&gt;&gt;&gt;</a>
	</div>
	<div class="rightdiv1">		
 
<%		
			list = listRight1;
			if(list != null){
				for(int i = 0; i < list.size(); i++){					
					out.println("<p style=\"border-bottom:1px dotted #bbb;\">");					
					if(list.get(i).getHaveContent() == 0 && list.get(i).getAttachmentSum() != 0){
						out.print("<a target='_blank' href='show.do?c=" + list.get(i).getContentId() + "&a=1' style='color:" + titleColor[list.get(i).getDisplayType()] + "'>");
						out.println(list.get(i).getContentName() + "</a>");
						out.println(list.get(i).getNewPic(3) + "&nbsp;/" + list.get(i).getDay());					
							
						if(list.get(i).getAttachmentSum() > 1){
							out.print("<br>");
							for(int j = 2; j <= list.get(i).getAttachmentSum() ; j++){
								out.print("<a target='_blank' href='show.do?c=" + list.get(i).getContentId() + "&a=" + j + "'>");
								out.print("附件" + (j - 1) + "</a> &nbsp;&nbsp;");
							}							
						}
					}else{
						out.print("<a target='_blank' href='show.do?ptype=cdd&c=" + list.get(i).getContentId() + "' style='color:" + titleColor[list.get(i).getDisplayType()] + "'>");
						out.println(list.get(i).getContentName() + "</a>");
						out.println(list.get(i).getNewPic(3) + "&nbsp;/" + list.get(i).getDay() );					
								
						if(list.get(i).getAttachmentSum() > 0){
							out.print("<br>");
							for(int j = 1; j <= list.get(i).getAttachmentSum() ; j++){
								out.print("<a target='_blank' href='show.do?c=" + list.get(i).getContentId() + "&a=" + j + "'>");
								out.print("附件" + j + "</a> &nbsp;&nbsp;");
							}							
						}
					}
					out.print("</p>");	
				}
			}
			
			%>
		
	</div>
	  
	  
	  <div style="height:30px;width:100%;border-bottom:1px #000000 solid;background-image:url('images/cdd/smalltitle.gif');float:left; font-weight:bolder; padding:8px 0px 0px 25px; ; font-size:14px;">
		
			机构风采
	&nbsp; &nbsp; &nbsp;&nbsp; 
		<a href="cdd.do?method=subPage1&dept=cdd&columnId=130" style="font-size:12px;">more&gt;&gt;&gt;</a>
		
	</div>
	<div class="rightdiv1" style="text-align:center; width:100%; padding:15px 20px 10px 20px;background-image:url(images/cdd/kuang.jpg);">
		<marquee direction="up" scrollamount="2" style="height:100px; width:100%; text-align:center; background-color:#fff; " >
		 <%
		picList = listRight2;
		for(int i = 0; i < (picList == null ? 0 : picList.size()); i++){
				out.print("<a target='_blank' href='show.do?c=" + picList.get(i).getContentId() 
					+ "&ptype=ed' style='color:" + titleColor[picList.get(i).getDisplayType()] + "'>");
				out.println(picList.get(i).getAtt(1).getImg(160) + "</a><br>");			
								
			
		}						
	%>
		</marquee>
		
	</div>
	  
	  
	  <div style="height:30px;width:100%;border-bottom:1px #000000 solid;background-image:url('images/cdd/smalltitle.gif');float:left;font-weight:bolder; padding:8px 0px 0px 25px;  font-size:14px;">
	
			机构文章
			&nbsp; &nbsp; &nbsp;&nbsp; 
		<a href="cdd.do?method=subPage1&dept=cdd&columnId=131" style="font-size:12px;">more&gt;&gt;&gt;</a>
		</div>
		
	<div class="rightdiv1">
			
 
<%		
			list = listRight3;
			if(list != null){
				for(int i = 0; i < list.size(); i++){					
					out.println("<p style=\"border-bottom:1px dotted #bbb;\">");					
					if(list.get(i).getHaveContent() == 0 && list.get(i).getAttachmentSum() != 0){
						out.print("<a target='_blank' href='show.do?c=" + list.get(i).getContentId() + "&a=1' style='color:" + titleColor[list.get(i).getDisplayType()] + "'>");
						out.println(list.get(i).getContentName() + "</a>");
						out.println(list.get(i).getNewPic(3) + "&nbsp;/" + list.get(i).getDay());					
							
						if(list.get(i).getAttachmentSum() > 1){
							out.print("<br>");
							for(int j = 2; j <= list.get(i).getAttachmentSum() ; j++){
								out.print("<a target='_blank' href='show.do?c=" + list.get(i).getContentId() + "&a=" + j + "'>");
								out.print("附件" + (j - 1) + "</a> &nbsp;&nbsp;");
							}							
						}
					}else{
						out.print("<a target='_blank' href='show.do?ptype=cdd&c=" + list.get(i).getContentId() + "' style='color:" + titleColor[list.get(i).getDisplayType()] + "'>");
						out.println(list.get(i).getContentName() + "</a>");
						out.println(list.get(i).getNewPic(3) + "&nbsp;/" + list.get(i).getDay() );					
								
						if(list.get(i).getAttachmentSum() > 0){
							out.print("<br>");
							for(int j = 1; j <= list.get(i).getAttachmentSum() ; j++){
								out.print("<a target='_blank' href='show.do?c=" + list.get(i).getContentId() + "&a=" + j + "'>");
								out.print("附件" + j + "</a> &nbsp;&nbsp;");
							}							
						}
					}
					out.print("</p>");	
				}
			}
			
			%>
			
	  </div>
	</div>
	  
</div>
</div>
</div>
<%=t.getCss()%>
</body>
</HTML>
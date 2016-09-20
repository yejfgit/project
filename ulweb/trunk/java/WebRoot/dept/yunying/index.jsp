
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlTemplate,com.ulic.ulweb.ulweb.entity.UlColumn,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.ulweb.entity.UlContentWithAtt,com.ulic.ulweb.ulweb.util.DisplayOnPage" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<HTML>
<HEAD>
<TITLE>运营中心</TITLE>

<link rel="stylesheet" href="style/ul.css" type="text/css" /> 

<%
		UlTemplate t = (UlTemplate)request.getAttribute("template");
		DisplayOnPage d = new DisplayOnPage();
		d.setRequest(request);
		int picnum = 1;
		List<UlColumn> l = (List<UlColumn>)request.getAttribute("columnList");
	%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style>
div{width:100%; background-color:#ffffff; color:#7AABAC;}
.toptable1 tr td{
	border-left:2px #7aabac solid;	
}

p{
	margin:5px 0px 0px 0px;
}


</style>
</HEAD>
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
<body  style="text-align: center" bgcolor="#E6E6E6">
<center>	
	<div style="width:780px;"><img src="images/yunying/top.jpg" border="0"></div>
	
<div style="width:780px;">
		<hr width="770" color="#E6E6E6">
	  		<table width="760" cellpadding="0" height="20" align="center" cellspacing="0" border="0" class="toptable1">
              <tr>            
               	<%
					for(int i = 0; i < (l == null ? 0 : l.size()); i++){
				%>
                <td width="80" align="center" > 
                  <a href="yunying.do?method=subPage1&columnId=<%=l.get(i).getColumnId()%>"  target="_blank" style=" font-weight:bold; color:#7aabac"><%=l.get(i).getColumnName()%></a> 
                </td>
				<%
					}
				%>
				 <td width="80" align="center" > 
                  <a href="yunying.do?method=subPage2&columnId=375"  target="_blank" style=" font-weight:bold; color:#7aabac">客服部</a> 
                </td>
				 <td width="80" align="center" > 
                  <a href="dept/yunying/tongxunlu/tongxunlu.htm"  target="_blank" style=" font-weight:bold; color:#7aabac">运营通讯录</a> 
                </td>             
                <td  align="left" style="padding-left:30px;">
				<SCRIPT>
					today=new Date();
					var day; var date; var hello;
					hour=today.getHours();
					if(today.getDay()==0)day='星期日'
					else if(today.getDay()==1)day='星期一'
					else if(today.getDay()==2)day='星期二'
					else if(today.getDay()==3)day='星期三'
					else if(today.getDay()==4)day='星期四'
					else if(today.getDay()==5)day='星期五'
					else if(today.getDay()==6)day='星期六'
				
					if(hour < 6)hello='凌晨好'
					else if(hour < 9)hello='早上好'
					else if(hour < 12)hello='上午好'
					else if(hour < 14)hello='中午好'
					else if(hour < 18)hello='下午好'
					else if(hour < 23)hello='晚上好'
					else {hello='夜里好!'}
					dateMD=(today.getMonth() + 1 )+'月'+today.getDate()+'日';
					dateMD2=(today.getYear())+'-'+(today.getMonth() + 1 )+'-'+today.getDate()+'';
					date=(today.getYear())+'年'+(today.getMonth() + 1 )+'月'+today.getDate()+'日';
					document.write(date + ' ' + day + ' ' + hello );
					</SCRIPT>  
                </td>
                
              </tr>
	      </table>
	  
	        <hr width="770" color="#E6E6E6">
	
	</div>
	
	<div style="width:780px;">
		<table cellpadding="0" cellspacing="0" border="0" width="100%"><tr><td width="450" height="400" valign="top">
				<img src="images/yunying/lanmu01.jpg" border="0">
			<div style="padding:10px 0px 10px 0px; height:110px; line-height:16px; color:#808080;">
				<div style="padding:0px 10px 0px 10px; float:left; width:145px; height:110px;">
					<img src="images/yunying/left014.jpg" border="0" >
				</div>
				&nbsp;&nbsp;&nbsp;  
				合众人寿建立的是全面的以客户为中心的<b><font color="#7AABAC">集中后援运营模式</font></b>，将核心竞争优势业务集中处理，而将非核心竞争优势业务外包处理.<br>
				&nbsp;&nbsp; 
				从而有效支持销售业绩增长的同时合理控制风险、保证标准化的运作和可扩展的支持销售队伍、实现
				<b>资源的共享、保证产能的提升以降低劳动成本、确保服务质量。</b>
				
			</div>			
		
				<img src="images/yunying/lanmu02.jpg" border="0">
			<div style="padding:10px 0px 10px 10px; height:100%;">
				<%=d.divContentYunying("xinxi",3,"","<font style='color:#7AABAC'>■</font>")%>
				<br><br>
				<a href="yunying.do?method=subPage1&columnId=367">更多...</a>
			</div>
				</td>  
				<td width="15">&nbsp;</td>
			<td valign="top" >
				<div style="padding:0px 0px 0px 10px; border-left:3px #e6e6e6 solid; height:100%;">
					<div id="oTransContainer" 
								style="FILTER: progid:DXImageTransform.Microsoft.RevealTrans(enabled=ture,transition=23);
								 WIDTH: 310px; HEIGHT:120px; overflow:hidden; text-align:center; "> 
								
								 <img id=oDIV1 src="<%=t.getPic1()%>" name=oDIV1>
                          <%
									if(!t.getPic2().equals("")){
										out.print("<IMG id=oDIV2 src='" + t.getPic2() + "'  name=oDIV2 style='DISPLAY: none;'>");
										picnum++;
									}										
									if(!t.getPic3().equals("")){
										out.print("<IMG id=oDIV3 src='" + t.getPic3() + "'  name=oDIV3 style='DISPLAY: none;'>");
										picnum++;
									}
									if(!t.getPic4().equals("")){
										out.print("<IMG id=oDIV4 src='" + t.getPic4() + "'  name=oDIV4 style='DISPLAY: none;'>");
										picnum++;
									}
									if(!t.getPic5().equals("")){
										out.print("<IMG id=oDIV5 src='" + t.getPic5() + "'  name=oDIV5 style='DISPLAY: none;'>");
										picnum++;
									}
									if(!t.getPic6().equals("")){
										out.print("<IMG id=oDIV6 src='" + t.getPic6() + "' name=oDIV6 style='DISPLAY: none;'>");
										picnum++;
									}									
									
								%>
                    </div> <br><br>
					<img src="images/yunying/lanmu03.jpg" border="0">
					<div style="padding:5px 0px 10px 0px;">
						<%=d.divContentYunying("wenjian",3,"","<font style='color:#7AABAC'>■</font>")%>
						<br><br>
						<a href="yunying.do?method=subPage2&columnId=508" target="_blank">更多...</a>
					</div>
					<img src="images/yunying/lanmu04.jpg" border="0">
					<div style="padding:5px 0px 10px 0px;">
						<%=d.divContentYunying("jilu",3,"","<font style='color:#7AABAC'>■</font>")%>
						<br><br>
						<a href="yunying.do?method=subPage1&columnId=369">更多...</a>
					</div>
				</div>
			</td>                              
			</tr>
		</table>
		 <hr width="770" color="#E6E6E6">
		
	</div>
		<p align="center"><font color="#666666" size="2">Copyright (c) 2005&nbsp; 
      Department of Operations&nbsp; All Rights Reserved</font></p>
		
<script language="javascript">
	var NowFrame = 1;
var MaxFrame = <%=picnum%>;
var bStart = 0;
function fnToggle(){
	var next = NowFrame + 1;
	if(next == MaxFrame+1) {
		NowFrame = MaxFrame;
		next = 1;
	}
	if(bStart == 0){
		bStart = 1;
		setTimeout('fnToggle()', 3000);
		return;
	}else{
//随机效果	
		
		oTransContainer.style.filter="progid:DXImageTransform.Microsoft.RevealTrans(enabled=ture,transition=" + Math.round(Math.random()*23 + 1) + ");";	
	
//		oTransContainer.style.filter="progid:DXImageTransform.Microsoft.RevealTrans(enabled=ture,transition=23);";	
		oTransContainer.filters[0].Apply();
		document.images['oDIV'+next].style.display = "";
		document.images['oDIV'+NowFrame].style.display = "none";
		oTransContainer.filters[0].Play(duration=2);
		if(NowFrame == MaxFrame){
			NowFrame = 1;
		}else{
			NowFrame++;	
		}
	}	
setTimeout('fnToggle()', 8000);
}
fnToggle();


</script>
</body>
</HTML>
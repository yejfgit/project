
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.ulweb.entity.UlAttachment,com.ulic.ulweb.frame.constant.Constant,com.ulic.ulweb.ulweb.web.action.IndexAction" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//if(request.getAttribute("from") == null) response.sendRedirect(basePath + "index.do");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  
<head>
<title>合众人寿内网主页</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<LINK href="style/ul.css" type="text/css" rel=stylesheet>
<!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style>
			#leftTable{
				border-left:2px #e7e7e7 solid;border-right:2px #e7e7e7 solid;
			}
			#leftTable td{
				border-top:2px #e7e7e7 solid;
			}
			
		</style>
<style type="text/css">
<!--
.buttonindex {
	background-image: url(images/index/button070319.png);
	height: 32px;
	width: 100px;
	background-repeat: no-repeat;
	padding-top:10px;	
	border: 0px white none;
	color: white;
}
-->
</style>
</head> 

<script type="text/javascript" src="script/common.js"></script>
  <%
//  		List<UlContent> listq = (List<UlContent>)request.getAttribute("listq");
		List<UlContent> listq = (List<UlContent>)IndexAction.listq;
		String titleColor[] = {"#004A1B","#ffffff","#000000","#0066ff","#009900","#00dddd","#ffccff","#9900cc","#ffcc00","#ff0000"};
  %>
  <body bgcolor="#eeeeee">
<table width=756 height="100%" border=0 cellpadding=0 cellspacing=0 align="center" bgcolor="#FFFFFF" id="idlagetable" >
  <!--DWLayoutTable-->
  <tr> 
    <td height="72" colspan="9" valign="top">
		<table width="100%" cellPadding=0 
                  cellSpacing=0 bgcolor="#FFFFFF" border="0" >
        <!--DWLayoutTable-->
      
        <tr> 
          <td height="60" valign="top">
		  	<%
				if(Constant.mainPaget != null){
					out.println("<img src='images/index/logo1.jpg' /></td><td valign='top' alige='center'>");
					
					if((Constant.mainPaget.substring((Constant.mainPaget.length() -3), Constant.mainPaget.length())).equals("swf")){
						%>
							<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0"  width="640"  height="68">
                          <param name="movie" value="<%=Constant.mainPaget%>">
                          <param name="quality" value="high">
                          <embed src="<%=Constant.mainPaget%>" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="640" height="68"></embed></object>
						 <%
						}else{
								
								out.println("<img src='" + Constant.mainPaget + "' border='0' />");
			//					out.println("<a href=\"http://money.sohu.com/s2008/unionlife/\" target=\"_blank\" ><img src='" + Constant.mainPaget + "' border='0' /></a>");
								}
							}
			%>
		 </td>
        </tr>        
       
      </table>
	</td>
  </tr>
  <tr><td valign="top" colspan="9" height="10"><img src="images/index/linetop2.gif" border="0" height="5" width="100%" /></td></tr>
  <tr> 
    <td height="36" colspan="9" valign="middle" >
		<table width="100%" cellpadding="0" cellspacing="0" border="0">
	  	<tr>
			
			
         
		<td  align="center"> <input name="button" type="button"  class="buttonindex" onClick="javascript:openwinn('http://ehr/hr/share/addressList.do');" value="通讯录" /></td>
			<td  align="center">
				<input  class="buttonindex" type="button" value="IT 服务站" onClick="javascript:openwinn('http://it/service/')" />
			</td>
			<td  align="center">
				<input  class="buttonindex" type="button" value="outlook网页邮箱" onClick="javascript:window.location.href='https://10.18.8.20/owa';" />
			</td>
			<td align="center">
				<input  class="buttonindex" type="button" value="合理化建议" onClick="javascript:openwinn('singlepage/hlh/helihua.htm');" />
				
			</td>
			
			<td  align="center">
				<input  class="buttonindex" type="button" value="常用表格下载" onClick="javascript:window.location.href='list.do?method=zongbu&ptype=1&columnId=<%=Constant.changyongbiaogexiazai%>&scid=21';" />				
			</td>
			
			<td  align="center" style="color:#; ">
				<input  class="buttonindex" type="button" value="文件查询" onClick="javascript:window.location.href='frame/checkshow.jsp';" />				
				
								
			</td>
			
		</tr>
	  </table>
	</td>
  </tr> 
  <tr>
  	<td colspan="9" height="10" valign="bottom"><img border="0" width="100%" height="5" src="images/index/linetop1.gif"/></td>
  </tr> 
  <tr>
  	<td colspan="9">	
<table border="0" cellpadding="0" cellspacing="0">
<tr>
	
	<td height="1" width="140"></td>
	<td width="19"></td>
	<td width="390"></td>
	<td width="19"></td>
	<td width="188"></td>
	
</tr>
	<tr>
		<td id="idleft" valign="top" align="center" width="140">
		<table align="center" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td valign="top">
					<table width="100%" cellPadding=0 id="leftTable" cellSpacing=0 class="9green1" bgcolor="#ffffff"  >
        <!--DWLayoutTable-->
        <tr valign="middle" bgcolor="#d2edc0" >           
          <td  colspan="2" width="80%" height="26" valign="middle" >&nbsp;&nbsp;公文</td>          
        </tr>        
        <tr valign="middle"   > 
          <td height="20" valign="top" colspan="2" style="padding-left:15px;" ><font color="#FF0000">三天内新公文数：<%=IndexAction.gNum%>
					   
					  </font></td>
        <tr valign="middle" > 
                      <td height="26" align="right" colspan="2" valign="top"><a  href="list.do?method=zongbu&ptype=9&columnId=<%=Constant.gongwen%>&scid=6"><font face="System">more&nbsp;&gt;&gt;</font></a></td>
        </tr> 
        <tr valign="middle"  bgcolor="#e2f4dc"> 
          <td height="26" align="center" colspan="2" valign="middle" class="white"  ><font color="#000000">专栏</font></td>
        </tr>
		 <tr > 
                <td  colspan="2"  height="25" valign="middle" align="center" class="9green1" >
					<!--<a href='list.do?method=zongbu&ptype=11&columnId=53'>合众人寿首届高峰会</a>-->
<a href='market.do?method=subPage1&columnId=667'>早安合众</a>				</td>
        </tr>				
		 <tr >           
                <td  colspan="2"  height="25" valign="middle" align="center" class="9green1" >
				 	<a href='list.do?method=zongbu&ptype=25&columnId=814'>党务工作专栏</a>				</td>
        </tr>

		 <tr >           
                <td  colspan="2"  height="25" valign="middle" align="center" class="9green1" >
				 	<a href='list.do?method=zongbu&ptype=1&columnId=587'>管理干部培训资料</a>				</td>
        </tr>
	   
		 <tr >           
                <td  colspan="2"  height="25" valign="middle" align="center" class="9green1" >
				 	<a href='list.do?method=zongbu&ptype=1&columnId=70'>财务大集中专栏</a>				</td>
        </tr>
		
        <tr valign="middle" > 
                      <td height="26" align="right" colspan="2" valign="top"><a  href="subpage/topic.jsp"><font face="System">more&nbsp;&gt;&gt;</font></a></td>
        </tr> 

		
        <tr valign="middle" bgcolor="#f1fac5"> 
          <td height="26" colspan="2" valign="middle" align="center" ><font color="#000000">信息快递</font></td>         
        </tr>
        <tr valign="middle" > 
          <td height="25" valign="middle" style="padding-left:10px;"  class="9green1">   <%
		  for(int i = 0; i < (listq == null ? 0 : listq.size()); i++){
		  		if(Constant.hezhongjianbao == listq.get(i).getColumnId()){
		  			out.println("<a target='_blank' href='show.do?c=" + listq.get(i).getContentId());
					if(listq.get(i).getHaveContent() == 0){
						out.println("&a=1'>"); 
					}else{
						out.println("'>");
					}
					out.println("合众简报&nbsp;</a>" + listq.get(i).getUploadTime().toString().substring(5,listq.get(i).getUploadTime().toString().indexOf(" ")) );
					break;
				}
		  }		 
		  
		  %>
                      <td  valign="middle" align="right" class="9green1"><a  href='list.do?method=zongbu&ptype=4&columnId=<%=Constant.xinxikuaidi%>&scid=<%=Constant.hezhongjianbao%>'><font face="System">&gt;&gt;</font></a></td>
        </tr>
        <tr> 
          <td height="25" valign="middle" style="padding-left:10px;"  class="9green1"> <%
		  for(int i = 0; i < (listq == null ? 0 : listq.size()); i++){
		  		if(Constant.jigoufazhankuaixun == listq.get(i).getColumnId()){
		  			out.println("<a target='_blank' href='show.do?c=" + listq.get(i).getContentId());
					if(listq.get(i).getHaveContent() == 0){
						out.println("&a=1'>"); 
					}else{
						out.println("'>");
					}
					out.println("机构发展快讯&nbsp;</a>" + listq.get(i).getUploadTime().toString().substring(5,listq.get(i).getUploadTime().toString().indexOf(" "))  );
					break;
				}
		  }		 
		  
		  %>
                      <td  valign="middle" align="right" class="9green1"><a href='list.do?method=zongbu&ptype=4&columnId=<%=Constant.xinxikuaidi%>&scid=<%=Constant.jigoufazhankuaixun%>'><font face="System">&gt;&gt;</font></a></td>
        </tr>
        <tr > 
          <td height="25" valign="middle" style="padding-left:10px;"  class="9green1"> <%
		  for(int i = 0; i < (listq == null ? 0 : listq.size()); i++){
		  		if(Constant.hangyezixun == listq.get(i).getColumnId()){
		  			out.println("<a target='_blank' href='show.do?c=" + listq.get(i).getContentId());
					if(listq.get(i).getHaveContent() == 0){
						out.println("&a=1'>"); 
					}else{
						out.println("'>");
					}
					out.println("行业资讯&nbsp;</a>" + listq.get(i).getUploadTime().toString().substring(5,listq.get(i).getUploadTime().toString().indexOf(" ")) );
					break;
				}
		  }		 
		  
		  %>
                      <td valign="middle" align="right" class="9green1"><a href='list.do?method=zongbu&ptype=4&columnId=<%=Constant.xinxikuaidi%>&scid=<%=Constant.hangyezixun%>'><font face="System">&gt;&gt;</font></a></td>
        </tr>
		 
		 <!-- 理赔专栏 -->
      </table>				</td>
			 <tr>
			   <td align="center"><a href="subpage/downloadvideo.jsp" target="_blank"><img src="video/20090430licheng.jpg"  border="0" width="140" height="105"/></a></td>
			 </tr>
			<tr>
				<td><table width="100%" ><tr><td height="1"></td></tr>
						<tr><td><a href="http://www.unionlife.com.cn/unionlife/activities/act.do?method=actListByCategory&categoryid=2&ccid=2&columnid=1492" target="_blank"><img src='files/2009/4/23/56625.jpg'  border="0" width='140'/></a></td></tr>
<tr><td><a href="http://www.unionlife.com.cn/unionlife/activities/act.do?method=relatedView&categoryid=1&actId=227&relatedId=389&ccid=-390&columnid=1492" target="_blank"><img src='files/2009/7/3/73497.jpg'  border="0" width='140'/></a></td></tr>
<tr><td><a href="http://ulweb/newapp/show.do?c=27459&a=1" target="_blank"><img src='files/2009/9/27/87469.jpg'  border="0" width='140'/></a></td></tr>
						

					</table>				</td>
			</tr>
		</table>		
		
    </td>
	<td ></td>
<!--	中间			-->	
	
	
	
		<td id="idcenter" valign="top">
			<table align="center" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td>
						<table width="390" cellPadding=0 
                  cellSpacing=0 bgcolor="#FFFFFF" class="9green1"  >
        <!--DWLayoutTable-->
        <tr> 
          <td height="24" colspan="5" align="left" valign="middle"  background="images/index/smalltitle070319.gif"   style="background-repeat:no-repeat;">
		  	<table cellpadding="0" cellspacing="0" border="0" width="100%">
				<tr><td width="7%"></td>
					<td height="35" width="35%" align="left" style="color:#004618; font-size:14px;font-weight: bold;">
						合众播报 
					</td>
					<td colspan="2" align="right" valign="middle" ></td>
				</tr>
			</table>
		 </td>
        </tr>
        <tr> 
          <td width="15" height="1"  ></td>
          <td width="331"  ></td>
          <td  ></td>
          <td width="7"  ></td>
          <td width="22"></td>
        </tr>
		 <%
//			List<UlContent> listx = (List<UlContent>)request.getAttribute("listx");
			List<UlContent> listx = (List<UlContent>)IndexAction.listx;
			
			if(listx != null){
				for(int i = 0; i < (listx == null ? 0 : listx.size()); i++){					
					out.println("<tr><td height='20'  ></td>");
					out.println("<td colspan='3' valign='middle'  ><img src='images/index/a6.gif' width='8' height='8'> ");
					if(listx.get(i).getHaveContent() == 0 && listx.get(i).getAttachmentSum() != 0){
						out.print("<a target='_blank' href='show.do?c=" + listx.get(i).getContentId() + "&a=1' style='color:" + titleColor[listx.get(i).getDisplayType()] + "'>");
						out.println(listx.get(i).getContentName() + "&nbsp;/" + listx.get(i).getUploadTime().toString().substring(0,listx.get(i).getUploadTime().toString().indexOf(" ")) + "</a>");					
						out.println("</td><td></td></tr>");			
						if(listx.get(i).getAttachmentSum() > 1){
							out.print("<tr><td></td><td>");
							for(int j = 2; j <= listx.get(i).getAttachmentSum() ; j++){
								out.print("<a target='_blank' href='show.do?c=" + listx.get(i).getContentId() + "&a=" + j + "'>");
								out.print("附件" + (j - 1) + "</a> &nbsp;&nbsp;");
							}
							out.print("</td><td></td></tr>");
						}
					}else{
						out.print("<a target='_blank' href='show.do?c=" + listx.get(i).getContentId() + "'  style='color:" + titleColor[listx.get(i).getDisplayType()] + "'>");
						out.println(listx.get(i).getContentName() + "&nbsp;/" + listx.get(i).getUploadTime().toString().substring(0,listx.get(i).getUploadTime().toString().indexOf(" ")) + "</a>");					
						out.println("</td><td></td></tr>");			
						if(listx.get(i).getAttachmentSum() > 0){
							out.print("<tr><td></td><td>");
							for(int j = 1; j <= listx.get(i).getAttachmentSum() ; j++){
								out.print("<a target='_blank' href='show.do?c=" + listx.get(i).getContentId() + "&a=" + j + "'>");
								out.print("附件" + j + "</a> &nbsp;&nbsp;");
							}
							out.print("</td><td></td></tr>");
						}
					}
							
				}
			}
			
		%>
		
		
		
		
        <tr> 
          <td height="11"></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
        </tr>
		<tr><td  align="right" colspan="5">
					<a href="list.do?method=zongbu&ptype=3&columnId=<%=Constant.hezhongbobao%>"><font face="System">more&nbsp;&gt;&gt;&gt;</font></a>
				</td></tr>
      </table>
					</td>
				</tr>
				
				<tr><td height="10"></td></tr>
				<tr>
					<td>
					<table cellPadding=0  width="100%"
                  cellSpacing=0 bgcolor="#FFFFFF" style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; BORDER-BOTTOM: gray 1px solid" >
        <!--DWLayoutTable-->
      
	    <tr> 
                      <td><a href="list.do?method=zongbu&scid=1387&ptype=16&columnId=253" ><img src="images/index/adc1fx.jpg" border="0" /></a><img src="images/index/adc2.jpg"  border="0"/><a href="subpage/downloadvideo.jsp" ><img src="images/index/adc3.jpg" border="0" /></a></td>
      </table>
					</td>
				</tr>
				
				<tr><td height="10"></td></tr>
				<tr>
					<td>
					<table width="390" border="0" cellpadding="0" cellspacing="0" bgCOLOR="#E5E5E5" class="9green1">
        <!--DWLayoutTable-->
        <tr bgcolor="#ffffff"> 
          <td width="11" height="7"></td>
          <td width="1"></td>
          <td width="14"></td>
          <td width="28"></td>
          <td width="293"></td>
          <td width="28"></td>
          <td width="6"></td>
          <td width="10"></td>
        </tr>
        <tr bgcolor="#ffffff"> 
			<td height="24" colspan="8" align="left" valign="middle"  background="images/index/smalltitle070319.gif"   style="background-repeat:no-repeat;">
		  	<table cellpadding="0" cellspacing="0" border="0" width="100%">
				<tr><td width="7%"></td>
					<td height="35" width="35%" align="left" style="color:#004618; font-size:14px;font-weight: bold;"> 公　告　
					</td>
					<td colspan="2" align="right" valign="middle" ></td>
				</tr>
			</table>
		 </td>
        </tr>
       
        <tr> 
          <td  colspan="8" height="10"><hr size="1"></td>
          
        </tr>
       
           <%
//			List<UlContent> listg = (List<UlContent>)request.getAttribute("listg");
			List<UlContent> listg = (List<UlContent>)IndexAction.listg;
			
			if(listg != null){
				for(int i = 0; i < (listg == null ? 0 : listg.size()); i++){					
					out.println("<tr><td height='20'  ></td>");
					out.println("<td colspan='6' valign='middle'  > ");
					if(listg.get(i).getHaveContent() == 0 && listg.get(i).getAttachmentSum() != 0){
						out.print("<a target='_blank' href='show.do?c=" + listg.get(i).getContentId() + "&a=1'>");
						out.println(listg.get(i).getContentName() + "&nbsp;/" + listg.get(i).getUploadTime().toString().substring(0,listg.get(i).getUploadTime().toString().indexOf(" ")) + "</a>");					
						out.println("</td><td></td></tr>");			
						if(listg.get(i).getAttachmentSum() > 1){
							out.print("<tr><td></td><td colspan='6'>");
							for(int j = 2; j <= listg.get(i).getAttachmentSum() ; j++){
								out.print("<a target='_blank' href='show.do?c=" + listg.get(i).getContentId() + "&a=" + j + "'>");
								out.print("附件" + (j - 1) + "</a> &nbsp;&nbsp;");
							}
							out.print("</td><td></td></tr>");
						}
					}else{
						out.print("<a target='_blank' href='show.do?c=" + listg.get(i).getContentId() + "'>");
						out.println(listg.get(i).getContentName() + "&nbsp;/" + listg.get(i).getUploadTime().toString().substring(0,listg.get(i).getUploadTime().toString().indexOf(" ")) + "</a>");					
						out.println("</td></tr>");			
						if(listg.get(i).getAttachmentSum() > 0){
							out.print("<tr><td></td><td colspan='6'>");
							for(int j = 1; j <= listg.get(i).getAttachmentSum() ; j++){
								out.print("<a target='_blank' href='show.do?c=" + listg.get(i).getContentId() + "&a=" + j + "'>");
								out.print("附件" + j + "</a> &nbsp;&nbsp;");
							}
							out.print("</td><td></td></tr>");
						}
					}
							
				}
			}
			
		%>
        <tr> 
          <td height="18">&nbsp;</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
		<tr>
			<td colspan="8" align="right">  
				<a href="list.do?method=zongbu&ptype=5&columnId=<%=Constant.gonggao%>"><font face="System">more&nbsp;&gt;&gt;&gt;</font></a>
				
			</td>
		</tr>
		<tr><td height="5" colspan="8"></td></tr>
      </table>
					</td>
				</tr>
				<tr>
					<td width="100%">
						<table width="100%">
							<tr>
								<td>
									
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
		
		<td></td>
		
		<!--				右边			-->
		<td id="idright" valign="top">
			<table border="0" width="100%" align="center" class="9green1" cellpadding="0"  bgcolor="#e7e7e7" cellspacing="0" >
				
				<tr>
					<td valign="top"  onMouseOut="javascript:slowHiddenTd('idDept',20,1,10);" onMouseOver="javascript:slowDisplayTd('idDept',20,1,10);">
						<table width="100%" border="0" cellpadding="5" cellspacing="2"    >
						<tr>
                    <!--DWLayoutTable-->
                   <td height="26" align="center" valign="middle" bgcolor="#edf4dc">部门主页</td>
 
                    </tr>
										
                    <tr id="idDept1" style="display:none;"> 
                      <td height="20" valign="middle" bgcolor="#FFFFFF"><a href="javascript:openwinn('http://ulweb/newapp/market.do?method=index');" >营销部主页</a></td>
                    </tr>
                    <tr id="idDept2" style="display:none;"> 
                      <td height="20" valign="middle" bgcolor="#FFFFFF" ><a href="javascript:openwinn('http://ulweb/newapp/yunying.do?method=index');" >运营中心主页</a></td>
                    </tr>
                    <tr id="idDept3" style="display:none;"> 
                      <td height="20" valign="middle" bgcolor="#FFFFFF"><a href="javascript:openwinn('http://ulweb/newapp/wukong.do?method=index');" >物控部主页</a></td>
                    </tr>
                    <tr id="idDept4" style="display:none;"> 
                      <td height="20" valign="middle" bgcolor="#FFFFFF" ><a href="javascript:openwinn('http://ulweb/app/dept/qihua/mainNew.jsp');" >精算企划部主页</a></td>
                    </tr> 
					 <tr id="idDept5"  style="display:none;"> 
                      <td height="20" valign="middle" bgcolor="#FFFFFF"><a href="javascript:openwinn('http://ulweb/newapp/peixun2.do?method=index');" >培训部主页</a></td>
					</tr>
					 <tr id="idDept6"  style="display:none;"> 
                      <td height="20" valign="middle" bgcolor="#FFFFFF"><a href="javascript:openwinn('http://ulweb/newapp/dept2l.do?method=index&dept=1110');" >代理业务部主页</a></td>
					</tr>
					 <tr id="idDept7"  style="display:none;"> 
                      <td height="20" valign="middle" bgcolor="#FFFFFF"><a href="javascript:openwinn('http://ulweb/newapp/caiwu.do?method=index');" >财务部主页</a></td>
					</tr>

					 <tr id="idDept8"  style="display:none;"> 
                      <td height="20" valign="middle" bgcolor="#FFFFFF"><a href="javascript:openwinn('http://ulweb/newapp/hr.do?method=subPage1&dept=hr');" >人力资源部主页</a></td>
					</tr>

					 <tr id="idDept9"  style="display:none;"> 
                      <td height="20" valign="middle" bgcolor="#FFFFFF"><a href="javascript:openwinn('http://ulweb/newapp/baofei.do?method=index');" >保费部主页</a></td>
					</tr> <tr id="idDept10"  style="display:none;"> 
                      <td height="20" valign="middle" bgcolor="#FFFFFF"><a href="javascript:openwinn('http://ulweb/newapp/pinxuan.do?method=index');" >品牌服务网站</a></td>
					</tr>
					
					
					  </table>
					</td>
				</tr>
					  
                    <tr> 
                      <td height="26" align="center" valign="middle" bgcolor="#fff4dc">系统链接</td>
                    </tr>
					
					<tr><td  ><table cellspacing="2" bgcolor="#e7e7e7" cellpadding="5" border="0" width="100%">
					
					
                    <tr> 
                      <td height="20" valign="middle" bgcolor="#FFFFFF"><a href="http://ulcbs" target="_blank">核心业务系统</a></td>
                    </tr>
                    <tr> 
                      <td height="20" valign="middle" bgcolor="#FFFFFF"><a href="http://fmis.ulic.com.cn:8000/oa_servlets/AppsLogin" target="_blank">ORACLE-ERP系统</a></td>
                    </tr>
					
		<!--	
		    <tr> 
                      <td height="20" valign="middle" bgcolor="#FFFFFF"><a href="http://cmsprd.ulic.com.cn/cms/" target="_blank">资金管理系统(CMS)</a></td>
                    </tr>
		-->
					
                    <tr> 
                      <td height="20" valign="middle" bgcolor="#FFFFFF"><a href="http://oa" target="_blank">OA工作流系统</a></td>
                    </tr>
                    
                    <tr> 
                      <td height="20" valign="middle" bgcolor="#FFFFFF"><a href="http://10.17.1.63" target="_blank">高管经营分析系统</a></td>
                    </tr>                    
                    
                    <tr> 
                      <td height="20" valign="middle" bgcolor="#FFFFFF"><a href="http://olap" target="_blank">企业决策支持系统</a></td>
                    </tr>
		<!--					
                    <tr> 
                      <td height="20" valign="middle" bgcolor="#FFFFFF"><a href="http://aems:8083/aems/login.jsp" target="_blank">营销速报系统</a></td>
                    </tr>
		-->
                    <tr> 
                      <td height="20" valign="middle" bgcolor="#FFFFFF"><a href="http://jianyishu/life/index.jsp" target="_blank">建议书系统</a></td>
                    </tr>
                    <tr> 
                      <td height="20" valign="middle" bgcolor="#FFFFFF"><a href="http://10.18.1.141:9080/jira/secure/Dashboard.jspa" target="_blank">问题管理系统</a></td>
                    </tr>
					  <tr> 
                      <td height="20" valign="middle" bgcolor="#FFFFFF"><a href="http://ulcc/unicall" target="_self">电话中心系统</a></td>
                    </tr>
					  <tr> 
                      <td height="20" valign="middle" bgcolor="#FFFFFF"><a href="../app/salesmail.jsp" target="_blank">业务员邮件系统</a></td>
                    </tr>
		<!--
					 <tr> 
                      <td height="20" valign="middle" bgcolor="#FFFFFF"><a href="http://gams:8088/gams/login.jsp" target="_blank">团险活动管理系统</a></td>
                    </tr>
		-->
					 <tr> 
                      <td height="20" valign="middle" bgcolor="#FFFFFF"><a href="http://ehr" target="_blank">人力资源管理系统</a></td>
                    </tr>
					 <tr> 
                      <td height="20" valign="middle" bgcolor="#FFFFFF"><a href="http://10.17.2.15:8080/IESSPortal" target="_blank">电子印章系统</a></td>
                    </tr>
					<tr> 
                      <td height="20" valign="middle" bgcolor="#FFFFFF"><a href="http://ruleteamserver/teamserver" target="_blank">规则引擎系统</a></td>
                    </tr>
					<tr> 
                      <td height="20" valign="middle" bgcolor="#FFFFFF"><a href="http://10.13.6.13/smscenter" target="_self">统一短信平台</a></td>
                    </tr>
					<tr> 
                      <td height="20" valign="middle" bgcolor="#FFFFFF"><a href="http://ais" target="_blank">稽核信息系统</a></td>
                    </tr>
					<tr> 
                      <td height="20" valign="middle" bgcolor="#FFFFFF"><a href="http://aems:8083/aems/login.jsp" target="_blank">市场活动折页使用追踪</a></td>
                    </tr>
					
					
					</table></td></tr>
					
						
					 <tr> 
					  <td align="center" valign="middle" style="border-left:2px #e7e7e7 solid;border-right:2px #e7e7e7 solid;"><a href="tools/doc/pcserve.doc" target="_blank"><img src="images/index/3.JPG" border="0"></a></td>
					</tr>
					<tr>
						<td valign="top"  onMouseOut="javascript:slowHiddenTd('idhot',20,1,9);" onMouseOver="javascript:slowDisplayTd('idhot',20,1,9);">
						
						
								<table cellspacing="2" bgcolor="#e7e7e7" cellpadding="5" border="0" width="100%">
								 <tr> 
             			       	  <td height="26" align="center" valign="middle"  bgcolor="#f1fac3">热门链接</td>
								</tr>							
								
								<tr id="idhot1" style="display:none;"> 
								  <td height="20" valign="middle" bgcolor="#FFFFFF"><a href='list.do?method=zongbu&ptype=35&columnId=1328'>IT资源共享</a></td>
								</tr>
								<tr id="idhot2" style="display:none;"> 
								  <td height="20" valign="middle" bgcolor="#FFFFFF"><a href="http://fmis.ulic.com.cn:8000/OA_HTML/ulic/ManagementCenter.htm" target="_blank">ERP系统专栏</a></td>
								</tr>
								 <tr id="idhot3" style="display:none;"> 
								  <td height="20" valign="middle" bgcolor="#FFFFFF"><a href='subpage/itsm.jsp'>业务系统维护</a></td>
								</tr>
								
								<tr id="idhot4" style="display:none;">
									<td bgcolor="#FFFFFF">
										<a href="market.do?method=subPage1&columnId=149">每日报表(营销)</a>
									</td>
								</tr>
								<tr id="idhot5" style="display:none;">
									<td bgcolor="#FFFFFF">
										<a href="market.do?method=subPage2&columnId=169">资源共享(营销)</a>
									</td>
								</tr>
								<tr id="idhot6" style="display:none;">
									<td  bgcolor="#FFFFFF">
										<a href="oldFile.do?method=linkList&columnId=92&columnName=每日新闻">每日新闻(企划)</a>
									</td>
								</tr>
								<tr id="idhot7" style="display:none;">
									<td  bgcolor="#FFFFFF">
										<a href="oldFile.do?method=linkList&columnId=91&columnName=业绩播报">业绩播报(企划)</a>
									</td>
								</tr>
								<tr id="idhot8" style="display:none;">
									<td bgcolor="#FFFFFF" >
										<a href="oldFile.do?method=linkList&columnId=140&columnName=早会资讯">早会资讯(培训)</a>
									</td>
								</tr>
								<tr id="idhot9" style="display:none;">
									<td  bgcolor="#FFFFFF">
										<a href="oldFile.do?method=linkList&columnId=171&columnName=产品训练专题">产品训练专题(培训)</a>
									</td>
								</tr>
					
							</table>
						</td>
					</tr>
				
					
                    <tr> 
                      <td height="26" align="center" valign="middle"  bgcolor="#d2edc0">下载中心</td>
                    </tr>
					
					<tr><td  ><table cellspacing="2" bgcolor="#e7e7e7" cellpadding="5" border="0" width="100%">
					
					
					<tr> 
                      <td height="20" valign="middle" bgcolor="#FFFFFF"><a href='pinxuan.do?method=subPage&cName=download' target="_blank">品牌宣传资料下载</a></td>
                    </tr>
                  
                    <tr> 
                      <td height="20" valign="middle" bgcolor="#FFFFFF"><a href="tools/doc/mis2.0.doc" target="_blank">合众信息管理系统用户手册</a></td>
                    </tr>
                    <tr> 
                      <td height="20" valign="middle" bgcolor="#FFFFFF"><a href="tools/090430/bxf.doc" target="_blank">中华人民共和国保险法新旧对照及评述</a></td>
                    </tr>
                   </table></td></tr>
				   
				   
                
				
			</table>
		</td>
	</tr>
	
</table>
</td>
  </tr>
  
  <tr> 
    <td height="40" colspan="9" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
        <!--DWLayoutTable-->
        <tr> 
          <td width="207" height="24">&nbsp;</td>
          <td width="359" valign="middle" align="center">首页&nbsp; 
            |&nbsp; 关于合众 |&nbsp; <a href="http://10.18.1.141:9080/jira/secure/Dashboard.jspa" target="_blank">问题上报</a>&nbsp; 
            |&nbsp;<a href="admin/login.jsp" target="_blank">系统管理</a>&nbsp; 
          </td>
          <td width="192">&nbsp;</td>
        </tr>
        <tr> 
          <td height="16" colspan="3" valign="top"><hr size=1 color="black"></td>
        </tr>
        <!--DWLayoutTable-->
      </table></td>
  </tr>
  <tr> 
  		<td colspan="9" width="100%">
			<table cellpadding="0" width="100%" cellspacing="0" border="0">
				<tr>
						 <td height=36 valign="top" width="25%" bgcolor="#8ebe1b"><!--DWLayoutEmptyCell-->&nbsp;</td>
    <td align="center" valign="top" class="9b" width="50%" >Copyright Reserved,Union 
      Life Insurance Company,Ltd. <br>
      建议使用分辨率800*600浏览 <br>
      更新于2009年11月22日</td>
    <td valign="top" bgcolor="#8ebe1b" width="25%"><!--DWLayoutEmptyCell-->&nbsp;</td>
				</tr>
			</table>
		</td>
   
  </tr>
 
</table>



	<DIV class=div id="imgdiv091122" style="WIDTH: 800px; HEIGHT: 600px; Z-INDEX: 1000; POSITION: absolute;" 
align=center>
	<a href="javascript:closeimg();" style="font-size:16px; vertical-align:top;" >关闭<img src="images/index/close.gif" border="0" /></a>
	<br>
	<img src="images/index/091122dongshizhang.jpg" >
	</DIV>


<script language="javascript">
var displayimg = true;
	function closeimg(){
	document.getElementById("imgdiv091122").style.display = "none";
	document.getElementById("imgdiv091122").style.height = "1";
		displayimg = false;
	}
	
	<!--
function scall(){
	if(displayimg ){
 document.getElementById("imgdiv091122").style.top=document.body.scrollTop+(document.body.clientHeight-document.getElementById("imgdiv091122").offsetHeight)/2
 document.getElementById("imgdiv091122").style.left=document.body.scrollLeft+(document.body.clientWidth-document.getElementById("imgdiv091122").offsetWidth)/2;
 	}
}
window.onscroll=scall;
window.onresize=scall;
window.onload=scall;
scall();
//-->
</script>
  </body>
</html>

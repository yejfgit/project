
<%@ taglib uri="struts-bean.tld" prefix="bean"%>
<%@ taglib uri="struts-html.tld" prefix="html"%>
<%@ taglib uri="struts-logic.tld" prefix="logic"%>
<%@ taglib uri="ulweb-list.tld" prefix="ulweb"%>

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

body {}


-->
</style>

<script type="text/javascript">

	// 检查当前时间是否在指定时间范围内
	// 时间格式请按照 yyyymmddhhiiss， 时间为null或者''表示不限
	function isInTime(startTime, endTime) {
		if (startTime == null || startTime == '') startTime = '10000101000000';
		if (startTime.length != 14) return false;
		if (endTime == null || endTime == '') endTime = '30000101000000';
		if (endTime.length != 14) return false;
	
		var startDt = new Date();
		startDt.setYear(startTime.substring(0, 4));
		startDt.setMonth(startTime.substring(4, 6) - 1);
		startDt.setDate(startTime.substring(6, 8));
		startDt.setHours(startTime.substring(8, 10));
		startDt.setMinutes(startTime.substring(10, 12));
		startDt.setSeconds(startTime.substring(12, 14));

		var endDt = new Date();
		endDt.setYear(endTime.substring(0, 4));
		endDt.setMonth(endTime.substring(4, 6) - 1);
		endDt.setDate(endTime.substring(6, 8));
		endDt.setHours(endTime.substring(8, 10));
		endDt.setMinutes(endTime.substring(10, 12));
		endDt.setSeconds(endTime.substring(12, 14));

		var curDt = new Date();
		if(curDt.getTime() >= startDt.getTime()
		 && curDt.getTime() <= endDt.getTime()) {
			return true;
		} else {
			return false;
		}
		
	}

</script>

</head> 

<script type="text/javascript" src="script/common.js"></script>
  <%
//  		List<UlContent> listq = (List<UlContent>)request.getAttribute("listq");
		List<UlContent> listq = (List<UlContent>)IndexAction.listq;
		String titleColor[] = {"#004A1B","#ffffff","#000000","#0066ff","#009900","#00dddd","#ffccff","#9900cc","#ffcc00","#ff0000"};
  %>
<body bgcolor="#eeeeee">

<div id="head" style="width: 100%; height: 30px; z-index: -1; text-align: center; display: none">
	<div style="width: 756px; text-align: right; padding-top: 10px">
		<a href="javascript:;" onClick="body.style.background='none';document.getElementById('head').style.display='none'" style="color: #FFFFFF; background-color: #DA0000"><img src="images/index/close.gif" border="0">关闭</a>
	</div>
</div>


<table width="756" height="100%" border=0 cellpadding=0 cellspacing=0 align="center" bgcolor="#FFFFFF" id="idlagetable" >
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
							<div id="flash" style="display:block"><object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0"  width="640"  height="68">
                          <param name="movie" value="showfile.do?filePath=<%=Constant.mainPaget%>">
                          <param name="quality" value="high">
                          <embed src="<%=Constant.mainPaget%>" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="640" height="68"></embed></object></div>
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
				<input  class="buttonindex" type="button" value="常用表格下载" onClick="javascript:openwinn('list.jsp?id=<%=Constant.changyongbiaogexiazai%>')" />				
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
                      <td height="26" align="right" colspan="2" valign="top"><a  href="list.jsp?id=6"><font face="System">more&nbsp;&gt;&gt;</font></a></td>
        		 <tr >           
                <td  colspan="2"  height="25" valign="middle" align="center" class="9green1" >
				 	 <a href='dangjian.do?method=index' target="_blank">合众人寿党建网</a>				</td>
        </tr>    
        

        <tr valign="middle"  bgcolor="#e2f4dc"> 
          <td height="26" align="center" colspan="2" valign="middle" class="white"  ><font color="#000000">专栏</font></td>
        </tr>


<ulweb:content beanName="t" deptId="0000" enName="topic" pageNum="1" pageSize="10" conditions="isDelete=0:i;isProcessing=0:i;" />

		<logic:iterate id="element" name="t" property="objectList">
		<tr valign="middle"><td height="26" align="center" colspan="2" valign="middle" class="white">
			<a href='<bean:write name="element" property="subTitle" />' target="_blank">
			<bean:write name="element" property="contentName" />
			</a>
		</td></tr>
		</logic:iterate>

	
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
                      <td  valign="middle" align="right" class="9green1"><a  href='list.jsp?id=<%=Constant.hezhongjianbao%>'><font face="System">&gt;&gt;</font></a></td>
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
                      <td  valign="middle" align="right" class="9green1"><a href='list.jsp?id=<%=Constant.jigoufazhankuaixun%>'><font face="System">&gt;&gt;</font></a></td>
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
                      <td valign="middle" align="right" class="9green1"><a href='list.jsp?id=<%=Constant.hangyezixun%>'><font face="System">&gt;&gt;</font></a></td>
        </tr>
		 
		 <!-- 理赔专栏 -->
      </table>				</td></tr>
			 <tr>
			   <td align="center">



<img src="images/index/tebiejiangshu.jpg">

<a href="showfile.do?filePath=videos/20100209zhenqingyongyuan.wmv" target="_blank">右键“目标另存为”下载...</a>

</td>
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
					<a href="list.jsp?id=<%=Constant.hezhongbobao%>"><font face="System">more&nbsp;&gt;&gt;&gt;</font></a>
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
                      <td><a href="list.jsp?id=1387" target="_blank"><img src="images/index/adc1fx.jpg" border="0" /></a><a href="list.jsp?id=1649" target="_blank"><img src="images/index/xyy2.jpg" border="0"/></a><a href="list.do?method=zongbuHaveAtt&ptype=videoslianghui&columnId=2305" target="_blank"><img src="images/index/zhijilianghui.jpg" border="0" /></a></td>
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
						out.print("<a target='_blank' href='show.do?c=" + listg.get(i).getContentId() + "&a=1' style='color:" + titleColor[listg.get(i).getDisplayType()] + "'>");
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
						out.print("<a target='_blank' href='show.do?c=" + listg.get(i).getContentId() + "' style='color:" + titleColor[listg.get(i).getDisplayType()] + "'>");
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
				<a href="list.jsp?id=<%=Constant.gonggao%>"><font face="System">more&nbsp;&gt;&gt;&gt;</font></a>
				
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
					<td valign="top"  onMouseOut="javascript:slowHiddenTd('idDept',20,1,12);" onMouseOver="javascript:slowDisplayTd('idDept',20,1,12);">
						<table width="100%" border="0" cellpadding="5" cellspacing="2"    >
						<tr>
                    <!--DWLayoutTable-->
                   <td height="26" align="center" valign="middle" bgcolor="#edf4dc">部门主页</td>
                    </tr>
										
                    <tr id="idDept1" style="display:none;"> 
                      <td height="20" valign="middle" bgcolor="#FFFFFF"><a href="javascript:openwinn('market.do?method=index');" >营销部主页</a></td>
                    </tr>
                    <tr id="idDept2" style="display:none;"> 
                      <td height="20" valign="middle" bgcolor="#FFFFFF" ><a href="javascript:openwinn('yunying.do?method=index');" >运营中心主页</a></td>
                    </tr>
                    <tr id="idDept3" style="display:none;"> 
                      <td height="20" valign="middle" bgcolor="#FFFFFF"><a href="javascript:openwinn('wukong.do?method=index');" >物控部主页</a></td>
                    </tr>
                    <tr id="idDept4" style="display:none;"> 
                      <td height="20" valign="middle" bgcolor="#FFFFFF" ><a href="javascript:openwinn('http://ulweb/app/dept/qihua/mainNew.jsp');" >战略企划部主页</a></td>
                    </tr> 
					 <tr id="idDept5"  style="display:none;"> 
                      <td height="20" valign="middle" bgcolor="#FFFFFF"><a href="javascript:openwinn('peixun2.do?method=index');" >培训部主页</a></td>
					</tr>
					 <tr id="idDept6"  style="display:none;"> 
                      <td height="20" valign="middle" bgcolor="#FFFFFF"><a href="javascript:openwinn('dept2l.do?method=index&dept=1110');" >银行保险部主页</a></td>
					</tr>
					 <tr id="idDept7"  style="display:none;"> 
                      <td height="20" valign="middle" bgcolor="#FFFFFF"><a href="javascript:openwinn('caiwu.do?method=index');" >财务部主页</a></td>
					</tr>

					 <tr id="idDept8"  style="display:none;"> 
                      <td height="20" valign="middle" bgcolor="#FFFFFF"><a href="javascript:openwinn('hr.do?method=subPage1&dept=hr');" >人力资源部主页</a></td>
					</tr>

					 <tr id="idDept9"  style="display:none;"> 
                      <td height="20" valign="middle" bgcolor="#FFFFFF"><a href="javascript:openwinn('dept/baofei2/index.jsp');" >保费部主页</a></td>
					</tr> 
					
					<tr id="idDept10"  style="display:none;"> 
                      <td height="20" valign="middle" bgcolor="#FFFFFF"><a href="javascript:openwinn('pinxuan.do?method=index');" >品牌服务网站</a></td>
					</tr>
					
					<tr id="idDept11"  style="display:none;"> 
                      <td height="20" valign="middle" bgcolor="#FFFFFF"><a href="javascript:openwinn('falv.do?method=index');">法律合规部主页</a></td>
					</tr>
					
					<tr id="idDept12"  style="display:none;"> 
                      <td height="20" valign="middle" bgcolor="#FFFFFF"><a href="javascript:openwinn('http://it/dept/tuanxian/');">团体业务部主页</a></td>
					</tr>	
	
					
															
					  </table>
					</td>
				</tr>
					  
                    <tr> 
                      <td height="26" align="center" valign="middle" bgcolor="#fff4dc">系统链接</td>
                    </tr>
					
					<tr><td  ><table cellspacing="2" bgcolor="#e7e7e7" cellpadding="5" border="0" width="100%">
					
<ulweb:content beanName="cl" deptId="0000" enName="link" pageNum="1" pageSize="50" conditions="isDelete=0:i;isProcessing=0:i;" />

		<logic:iterate id="element" name="cl" property="objectList">
		<tr><td bgcolor="#ffffff">
			<a href='<bean:write name="element" property="subTitle" />' target="_blank">
			<bean:write name="element" property="contentName" />
			</a>
		</td></tr>
		</logic:iterate>
				
					
					</table></td></tr>
					
						
					 <tr> 
					  <td align="center" valign="middle" style="border-left:2px #e7e7e7 solid;border-right:2px #e7e7e7 solid;"><a href="http://ulweb/tools/doc/pcserve.doc" target="_blank"><img src="images/index/3.JPG" border="0"></a></td>
					</tr>
					<tr>
						<td valign="top"  onMouseOut="javascript:slowHiddenTd('idhot',20,1,9);" onMouseOver="javascript:slowDisplayTd('idhot',20,1,9);">
						
						
								<table cellspacing="2" bgcolor="#e7e7e7" cellpadding="5" border="0" width="100%">
								 <tr> 
             			       	  <td height="26" align="center" valign="middle"  bgcolor="#f1fac3">热门链接</td>
								</tr>							
								
								<tr id="idhot1" style="display:none;"> 
								  <td height="20" valign="middle" bgcolor="#FFFFFF"><a href='http://it/service/itshare'>IT资源共享</a></td>
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
                      <td height="20" valign="middle" bgcolor="#FFFFFF"><a href="http://ulweb/tools/doc/mis2.0.doc" target="_blank">合众信息管理系统用户手册</a></td>
                    </tr>
                    <tr> 
                      <td height="20" valign="middle" bgcolor="#FFFFFF"><a href="http://ulweb/tools/090430/bxf.doc" target="_blank">中华人民共和国保险法新旧对照及评述</a></td>
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
            |&nbsp; <a href="http://www.unionlife.com.cn/unionlife/content/1860/10809.jsp?columnid=1000&ccid=1860" target="_blank">关于合众</a> |&nbsp; <a href="http://10.18.1.141:9080/jira/secure/Dashboard.jspa" target="_blank">问题上报</a>&nbsp; 
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
      建议使用分辨率1024*768浏览 <br>   
      更新于2010年7月22日</td>
    <td valign="top" bgcolor="#8ebe1b" width="25%"><!--DWLayoutEmptyCell-->&nbsp;</td>
				</tr>
			</table>
		</td>
   
  </tr>
 
</table>



<!-- Scroll Begin -->

<div id="Float001" style="z-index: 1; right: 3px; width: 160px; position: absolute; top: 200px">
	<center>
		<div>
		<!-- Pics -->
			
		<ulweb:content beanName="t" deptId="0000" enName="ad" pageNum="1" pageSize="5" conditions="isDelete=0:i;isProcessing=0:i;" />
		<logic:iterate id="element" name="t" property="objectList">
			<a href='<bean:write name="element" property="subTitle" />' target="_blank"><img src="<bean:write name="element" property="keyWord" />" border="0" width="120" height="90"><br /><bean:write name="element" property="documentNum" /></a><br />
		</logic:iterate>		
			
		</div>
	</center>
</div>
<script language=JavaScript type=text/javascript>
    var csdnScrollTop = function() {
        return document.documentElement.scrollTop ? document.documentElement.scrollTop : document.body.scrollTop;
    };
    //alert(document.documentElement.scrollHeight);
    function mymove() {
	
    	document.getElementById("Float001").style.top = csdnScrollTop() + (document.documentElement.scrollHeight / 4) + 'px';
		document.getElementById("Float001").style.right = 3 + 'px';
		setTimeout("mymove();", 50);
    }
    mymove();

	
	
</script>

<!-- Scroll End -->	



  </body>
</html>

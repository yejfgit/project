<%@ taglib uri="struts-bean.tld" prefix="bean"%>
<%@ taglib uri="struts-html.tld" prefix="html"%>
<%@ taglib uri="struts-logic.tld" prefix="logic"%>
<%@ taglib uri="ulweb-list.tld" prefix="ulweb"%>
<html>
<head>
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.ulweb.entity.UlAttachment,com.ulic.ulweb.frame.constant.Constant,com.ulic.ulweb.ulweb.web.action.IndexAction" pageEncoding="UTF-8"%>
<title>合众人寿综合开拓部 &gt;&gt; 综合开拓部首页</title>
<link href="/newapp/css/main.css" rel="stylesheet" type="text/css" />

<style type="text/css">
A{TEXT-DECORATION: none;}
A:hover{COLOR: #CC0000;}
A:link {color: #000000;}
A:visited {color: #000000;}

BODY
{
FONT-SIZE: 9pt;background:#f6f6f6
}
TD
{
FONT-FAMILY:宋体;FONT-SIZE: 9pt;line-height: 150%; 

}
Input
{
BACKGROUND-COLOR: #E7F7DB; 
BORDER-BOTTOM: #007500 1px solid;
BORDER-LEFT: #007500 1px solid;
BORDER-RIGHT: #007500 1px solid;
BORDER-TOP: #007500 1px solid;
COLOR: #000000;
HEIGHT: 18px;
border-color: #007500 #007500 #007500 #007500; font-size: 9pt
}
Button
{
FONT-SIZE: 9pt;HEIGHT: 20px; 

}
Select
{
FONT-SIZE: 9pt;HEIGHT: 20px;

}
.border
{
border: 1px solid #007500;

}
.border2
{
background:#ffffff;BORDER-bottom: #007500 1px solid; 
}
.title_txt
{
background:url(images/topBar_bg_20.gif);

}
.title
{
background:url(images/title.gif);height: 22;

}
.tdbg
{
background:#ffffff;line-height: 150%; 
}
.txt_css
{
background:url(images/txt_css.gif);height: 36;
}
.title_lefttxt
{
filter: DropShadow(Color=#ffffff, OffX=2, OffY=2, Positive=2)
}
.title_left
{
background:url(images/title_left1.gif);height: 26;
}
.tdbg_left
{
background:#E7F7DB
line-height: 150%;
}
.title_left2
{
background:#E7F7DB;height:8;
}
.tdbg_left2
{
background:url(images/tdbg_left2.gif);height: 13;

}
.tdbg_leftall
{
background:#E7F7DB;BORDER-left: #56B02B 1px solid; BORDER-right: #56B02B 1px solid; 
}
.title_maintxt
{
color: #000000;filter:Glow(Color=#ffffff, Strength=3)
}
.title_main
{
background:url(images/title_main.gif);height: 22;
}
.tdbg_main
{
background:url(images/tdbg_main2.GIF);line-height: 100%;

}
.title_main2
{
background:url(images/maintop.gif);height: 202;
}
.tdbg_main2
{
background:url(images/tdbg_main3.GIF);height: 27;
}
.tdbg_mainall
{
background:url(images/kt01-p1.GIF);
}
.title_righttxt
{
filter: DropShadow(Color=#ffffff, OffX=2, OffY=2, Positive=2)
}
.title_right
{
background:url(images/title_right1.gif);height: 26;
}
.tdbg_right
{
background:#F2FBEB;

}
.title_right2
{
background:url(images/title_main.gif);height: 22;
}
.tdbg_right2
{
background:url(images/title_main.gif);height: 22;
}
.tdbg_rightall
{
background:#E7F7DB;BORDER: #56B02B 1px solid; 

}
.topborder
{
background-image: url(images/topborder.gif);
}
.nav_top
{
background-image: url(images/nav_top.gif);height: 25;
}
.nav_main
{
line-height: 150%;background:url(images/nav_main.gif);
line-height: 150%;height: 134;
}
.nav_bottom
{
background-image: url(images/nav_bottom.gif);

}
.nav_menu
{
background:url(images/nav_menu.gif);height: 24;
}
.menu
{
background-color: #56B02B;width:97%;border: 1px;

}
td.MenuBody
{
background-color: #E7F7DB;
}
.STYLE2 {
	color: #FFFFFF;
	font-size: 12pt;
	font-weight: bold;
}
</style>

<script language="JavaScript" type="text/JavaScript">
//下拉菜单相关代码
 var h;
 var w;
 var l;
 var t;
 var topMar = 1;
 var leftMar = -2;
 var space = 1;
 var isvisible;
 var MENU_SHADOW_COLOR='#999999';//定义下拉菜单阴影色
 var global = window.document
 global.fo_currentMenu = null
 global.fo_shadows = new Array

function HideMenu() 
{
 var mX;
 var mY;
 var vDiv;
 var mDiv;
	if (isvisible == true)
{
		vDiv = document.all("menuDiv");
		mX = window.event.clientX + document.body.scrollLeft;
		mY = window.event.clientY + document.body.scrollTop;
		if ((mX < parseInt(vDiv.style.left)) || (mX > parseInt(vDiv.style.left)+vDiv.offsetWidth) || (mY < parseInt(vDiv.style.top)-h) || (mY > parseInt(vDiv.style.top)+vDiv.offsetHeight)){
			vDiv.style.visibility = "hidden";
			isvisible = false;
		}
}
}

function ShowMenu(vMnuCode,tWidth) {
	vSrc = window.event.srcElement;
	vMnuCode = "<table id='submenu' cellspacing=1 cellpadding=3 style='width:"+tWidth+"' class=menu onmouseout='HideMenu()'><tr height=23><td nowrap align=left class=MenuBody>" + vMnuCode + "</td></tr></table>";

	h = vSrc.offsetHeight;
	w = vSrc.offsetWidth;
	l = vSrc.offsetLeft + leftMar+4;
	t = vSrc.offsetTop + topMar + h + space-2;
	vParent = vSrc.offsetParent;
	while (vParent.tagName.toUpperCase() != "BODY")
	{
		l += vParent.offsetLeft;
		t += vParent.offsetTop;
		vParent = vParent.offsetParent;
	}

	menuDiv.innerHTML = vMnuCode;
	menuDiv.style.top = t;
	menuDiv.style.left = l;
	menuDiv.style.visibility = "visible";
	isvisible = true;
    makeRectangularDropShadow(submenu, MENU_SHADOW_COLOR, 4)
}

function makeRectangularDropShadow(el, color, size)
{
	var i;
	for (i=size; i>0; i--)
	{
		var rect = document.createElement('div');
		var rs = rect.style
		rs.position = 'absolute';
		rs.left = (el.style.posLeft + i) + 'px';
		rs.top = (el.style.posTop + i) + 'px';
		rs.width = el.offsetWidth + 'px';
		rs.height = el.offsetHeight + 'px';
		rs.zIndex = el.style.zIndex - i;
		rs.backgroundColor = color;
		var opacity = 1 - i / (i + 1);
		rs.filter = 'alpha(opacity=' + (100 * opacity) + ')';
		el.insertAdjacentElement('afterEnd', rect);
		global.fo_shadows[global.fo_shadows.length] = rect;
	}
}
</script>
<script language="JavaScript" type="text/JavaScript">
//菜单列表
var menu_skin="&nbsp;<a style=font-size:9pt;line-height:14pt; href='SetCookie.asp?Action=SetSkin&ClassID=0&SkinID=1'>牧虫典雅</a><br>&nbsp;<a style=font-size:9pt;line-height:14pt; href='SetCookie.asp?Action=SetSkin&ClassID=0&SkinID=2'>雅虎秋梦</a><br>&nbsp;<a style=font-size:9pt;line-height:14pt; href='SetCookie.asp?Action=SetSkin&ClassID=0&SkinID=3'>灰色畅想</a><br>&nbsp;<a style=font-size:9pt;line-height:14pt; href='SetCookie.asp?Action=SetSkin&ClassID=0&SkinID=4'>绿雨飘香</a><br>&nbsp;<a style=font-size:9pt;line-height:14pt; href='SetCookie.asp?Action=SetSkin&ClassID=0&SkinID=5'>幽绿芭蕾</a><br>&nbsp;<a style=font-size:9pt;line-height:14pt; href='SetCookie.asp?Action=SetSkin&ClassID=0&SkinID=6'>晴空幽蓝</a><br>&nbsp;<a style=font-size:9pt;line-height:14pt; href='SetCookie.asp?Action=SetSkin&ClassID=0&SkinID=7'>书卷飘香</a><br>&nbsp;<a style=font-size:9pt;line-height:14pt; href='SetCookie.asp?Action=SetSkin&ClassID=0&SkinID=8'>蓝天动力</a><br>&nbsp;<a style=font-size:9pt;line-height:14pt; href='SetCookie.asp?Action=SetSkin&ClassID=0&SkinID=9'>动力空间</a><br>";
</script>

</head>
<body bgcolor="#ffffff" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" style="text-align: center" >
<table width=990" background="images/main_01.gif" border="0" cellspacing="0" cellpadding="0" align="center">
	<tbody>
	  <!-- 第1部分 -->
		<tr>
			<td >
				<table width="1000" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
					<tr>
						<td height="80" background="dept/zongtuo/images/bg_04.jpg">
						
						</td>
					</tr>
				</table>
			</td>
		</tr>
		  <!-- 第2部分 -->
		<tr>
		   <table width="990" border="0" cellpadding="0" align="center">
		   <tbody>
		   <tr>
			 <td>
				<table width="1000" border="0" cellspacing="0" cellpadding="0">
				<tbody>
					<tr>
						<td background="dept/zongtuo/images/main_1.gif" width="8" height="29"></td>
				        <td background="dept/zongtuo/images/main_0.gif" width="86" height="29" align="center"><a href="http://ulweb/newapp/zongTuo.do?method=index" target="_self"><font color="#FFFFFF"><strong>综拓部首页</strong></font></a></td>
						<td background="dept/zongtuo/images/main_1.gif" width="8" height="29"></td>
				        <td background="dept/zongtuo/images/main_0.gif" width="86" align="center"><a href="dept/zongtuo/ztlist.jsp?id=5348" target="_self"><font color="#FFFFFF"><strong>综拓风采</strong></font></a></td>
				        <td background="dept/zongtuo/images/main_1.gif" width="8" align="center">&nbsp;</td>
				        <td background="dept/zongtuo/images/main_0.gif" width="86" height="29" align="center"><a href="dept/zongtuo/ztlist.jsp?id=5345" target="_self"><font color="#FFFFFF"><strong>综拓动态</strong></font></a></td>
						<td background="dept/zongtuo/images/main_1.gif" width="8" height="29"></td>
				        <td background="dept/zongtuo/images/main_0.gif" width="86" height="29" align="center"><a href="dept/zongtuo/ztlist.jsp?id=5349" target="_self"><font color="#FFFFFF"><strong>综拓视点</strong></font></a></td>
				        <td background="dept/zongtuo/images/main_1.gif" width="8" align="center">&nbsp;</td>
				        <td background="dept/zongtuo/images/main_0.gif" width="86" height="29" align="center"><a href="dept/zongtuo/ztlist.jsp?id=5350" target="_self"><font color="#FFFFFF"><strong>下载中心</strong></font></a></td>
						<td background="dept/zongtuo/images/main_1.gif" width="8" height="29"></td>
				        <td background="dept/zongtuo/images/main_0.gif" width="86" align="center"><a href="dept/zongtuo/ztlist.jsp?id=5351" target="_self"><font color="#FFFFFF"><strong>数据报表</strong></font></a></td>
					    <td background="dept/zongtuo/images/main_1.gif" width="8" height="29"></td>
					    <td background="dept/zongtuo/images/main_0.gif" width="200" height="29" align="right">
						<script language="JavaScript" type="text/JavaScript">
						var day="";
						var month="";
						var ampm="";
						var ampmhour="";
						var myweekday="";
						var year="";
						mydate=new Date();
						myweekday=mydate.getDay();
						mymonth=mydate.getMonth()+1;
						myday= mydate.getDate();
						myyear= mydate.getYear();
						year=(myyear > 200) ? myyear : 1900 + myyear;
						if(myweekday == 0)
						weekday=" 星期日 ";
						else if(myweekday == 1)
						weekday=" 星期一 ";
						else if(myweekday == 2)
						weekday=" 星期二 ";
						else if(myweekday == 3)
						weekday=" 星期三 ";
						else if(myweekday == 4)
						weekday=" 星期四 ";
						else if(myweekday == 5)
						weekday=" 星期五 ";
						else if(myweekday == 6)
						weekday=" 星期六 ";
						document.write("<font color= #FFFFFF>"+year+"年"+mymonth+"月"+myday+"日 "+weekday+"</font>");
						</script></td>
						<td width="1"></td>
					</tr>
				   </tbody>
				</table>
			 </td>
			</tr>
			<tr>
			<td width="100%" background="dept/zongtuo/images/bg_03.jpg" height="100">
			</td>
		 </tr>
			<tr>
				<td>
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tbody>
						<tr>
							<td width="3%" align="right"><img src="dept/zongtuo/images/arrow3.gif"></td>
							<td width="67%">&nbsp;您现在的位置：&nbsp;<a href="http://ulweb/newapp/zongTuo.do?method=index">合众人寿综拓部</a>&nbsp;&gt;&gt;&nbsp;<a href="http://ulweb/newapp/zongTuo.do?method=index">综拓部首页</a></td>
							<td width="30%">
							</td>
						</tr>
					</tbody>
				</table>
				</td>
			</tr>
			</tbody>
			</table>
		</tr>
		
		<!-- 第三部分 -->
		<tr>
		 	 <td><table width="990" border="0" cellspacing="0" cellpadding="0" align="center">
                 <tbody>
                 <!-- 内容 -->
                 <tr>
                 <!-- 分两部分 -->
		            <!-- left -->
		             
                      <td>
                          <table width="100%" border="0" cellspacing="0" cellpadding="0">
                       		 <tbody>
                       		    <!-- logo -->
                       		    <tr>
                       		    	
                       		    </tr>
         					
         					 <tr>
            					<td background="dept/zongtuo/images/main_18.gif" width="710" height="200">
									<table width="710" height="260">
										<tbody>
										<tr>
										   
										    <td width="40%" align="center">
										       <p>
								<script language="javascript">
									var imgUrl=new Array();
									var imgLink=new Array();
									var text=new Array();
									var adNum=0;
									var buttonShow=1;
									var buttonPos=2; //RU:1，RD:2，LU:3，LD:4
									
									
									
									<ulweb:content beanName="cl" deptId="zongtuo" enName="tupian" pageNum="1" pageSize="10" conditions="isDelete=0:i;isProcessing=0:i;" withAtt="1" />
									<% int index=1; %>
									<logic:iterate id="element" name="cl" property="objectList">
									
										<logic:notEmpty name="element" property="attachmentList">
											<logic:iterate id="e" name="element" property="attachmentList">
									imgUrl[<%=index%>]="<bean:write name="e" property="displayPath" filter="false" />";
									imgLink[<%=index%>]="<bean:write name="element" property="subTitle" filter="false" />";
									text[<%=index%>]="<bean:write name="element" property="keyWord" filter="false" />";			
									<% index++; %>
											</logic:iterate>
										</logic:notEmpty>
									</logic:iterate>
									
									
									
									
									</script>
																	<script language="javascript" src="dept/zongtuo/newsAd.js"></script>
																	<table id=newsTable border="0" cellspacing="0" cellpadding="0" style="border: solid 1px #CCCCCC; " align="center">
																		<script language="javascript">dakularButtons();</script>
																		<tr>
																			<td>
																				<a
																					onMouseOver="displayStatusMsg();return document.returnValue"
																					onMouseOut="status='';" class=px14-lh24
																					href="javascript:jump2url()"><img
																						style="FILTER: revealTrans(duration=1,transition=23); border:0px solid #000000"
																						src="#" width=260 height=175 border=0
																						name=imgUrlrotator alt=""> </a><script>nextAd();</script>
																			</td>
																		</tr>
																	</table>
</p>
										    </td>
										    
										    <!-- right -->
										    <td width="60%" align="center">
										         <table width="96%">
													<tbody>
													   <tr>
										    				<td height="10"></td>
										    		   </tr>
										    		   
										    		   <tr>
										    		      <td width="100%">
										    		      		<table width="100%" valign="middle">
										    		      		<tbody>
										    		      		  <tr>
										    		      		    <td width="2%" align="left" >
										    		      		    </td>
										    		      		    <td width="60%" >
										    		      		       <div style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap;width:250;">									
																	<ulweb:content beanName="cl" deptId="zongtuo" enName="dongtai" pageNum="1" pageSize="11" conditions="isDelete=0:i;isProcessing=0:i;" />
																	<logic:iterate id="element" name="cl" property="objectList">
																	<img src="dept/zongtuo/images/3.gif" alt="普通文章" style="{align:left;vertical-align:middle;}">
																		<a href="<bean:write name="element" property="subTitle" />" target="_blank"><bean:write name="element" property="contentName" /></a>
																	<hr style="border:1px dashed black; height:1px"/>
																	</logic:iterate>
																					
														        </div>  
										    		      		    </td>
										    		      		  </tr>
										    		      		  </tbody>
										    		      		 </table>
										    		      </td>
										    		   </tr>
										    </td>
										</tr>
										</tbody>
									</table>
								</td>
							</tr>
							</tbody>
						</table>
			
			    	</td>
					<!-- right -->
						<td>
							<table width="100%" height="250" border="0" align="right" cellpadding="0" cellspacing="0">
          						<tbody>
           							 <tr>
           							 	 <td height="25" align="center" valign="middle" background="dept/zongtuo/images/main_17.gif"><span class="STYLE2">公告栏</span></td>
           							 </tr>
           							 
           							 <tr>
           							 		<td height="30">
								              	<div style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap;width:250;">									
								              	<ulweb:content beanName="cl" deptId="zongtuo" enName="gonggao" pageNum="1" pageSize="3" conditions="isDelete=0:i;isProcessing=0:i;" />
												<logic:iterate id="element" name="cl" property="objectList">
												<li><span class="fri">[<bean:write name="element" property="uploadTime" format="yyyy-MM-dd" />]</span>·<a href="show.do?c=<bean:write name="element" property="contentId" />" target="_blank" title="<bean:write name="element" property="contentName" />" <logic:equal name="element" property="displayType" value="9">style="color:#ff0000"</logic:equal> ><script>document.writeln("<bean:write name="element" property="contentName" />".substring(0,28));</script></a></li>
												</logic:iterate>
												</div>
											</td>
           							 </tr>
           							 <tr>
              								<td height="2" align="center" ></td>
          							  </tr>
          							  <tr>
                                			<td width="280" height="25" align="center" background="dept/zongtuo/images/main_17.gif"> <span class="STYLE2">友情链接</span></td>
         							  </tr>
         							  
         							  <tr>
								            <td background="dept/zongtuo/images/main_19.gif" width="280" height="105" align="center">
											<table cellspacing="0" cellpadding="0" width="90%" border="0">
												<tbody>
												  <tr>
												    <td>
												    	<div style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap;width:250;">									
															<ulweb:content beanName="cl" deptId="zongtuo" enName="lianjie" pageNum="1" pageSize="11" conditions="isDelete=0:i;isProcessing=0:i;" />
																	<logic:iterate id="element" name="cl" property="objectList">
																		<li>·<a href="show.do?c=<bean:write name="element" property="subTitle" />" target="_blank"><bean:write name="element" property="contentName" /></a></li>
																	</logic:iterate>
																					
														</div>  
													</td>
												</tr>
											   </tbody>
											</table></td>
                                     </tr>
           						</tbody>
           				     </table>
						</td>
			
			   </tr>
			<!-- 3 end -->
			</tbody>
			</table>
		   </td> 
		</tr>
		<tr>
           <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tbody><tr>
        		<td>&nbsp;</td>
        		</tr>
    			</tbody></table></td>
 	  </tr>	
       <!-- 第四部分 -->
       <tr>
		   <td>
		       <table width="100%" border="0" cellspacing="0" cellpadding="0" >
                  <tbody>
                  <!-- 分上下两部分 -->
                    <!-- 上部分 -->
                     <tr>
                       <!-- 分左右两部分 -->
                        <!-- left -->
                         <td>
                             <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tbody>
                                	<tr>
                                		<td background="dept/zongtuo/images/main_27.gif" width="509" height="31" align="right">
                                		  	<table width="100%"><tbody>
                                		  	    <tr>
                                		  	       <td height="2"></td>
                                		  	    </tr>
                                		  	    <tr>
                                		  	    <td width="45"></td>
                                		  	    <td><font size="3" color="#ffffff"><strong>综拓风采</strong></font></td>
                                		  	    <td align="right"><a href="dept/zongtuo/ztlist.jsp?id=5348">more...</a>&nbsp;&nbsp;&nbsp;</td>
                                		  	    </tr>
                                		  	    </tbody>
                                		  	</table>
                                		</td>
                                	</tr>
                                	<tr>
                                		<td background="dept/zongtuo/images/main_29.gif" width="509" height="215" align="center">
                                			<table width="95%" >
												<tbody>
													<tr>
														<td width="15%" align="center"><img src="dept/zongtuo/images/m_pic4.gif" width="131" height="147">
														</td>
														<td width="64%" valign="top" align="center">
														<div style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap;width:300;text-align: left">
																<ulweb:content beanName="cl" deptId="zongtuo" enName="fengcai" pageNum="1" pageSize="9" conditions="isDelete=0:i;isProcessing=0:i;" />
																		<logic:iterate id="element" name="cl" property="objectList">
																			<li><span class="fri">[<bean:write name="element" property="uploadTime" format="yyyy-MM-dd" />]</span>·<a href="show.do?c=<bean:write name="element" property="contentId" />" target="_blank" title="<bean:write name="element" property="contentName" />" <logic:equal name="element" property="displayType" value="9">style="color:#ff0000"</logic:equal> ><script>document.writeln("<bean:write name="element" property="contentName" />".substring(0,28));</script></a></li>
																		</logic:iterate>
														</div>
														</td>
													</tr>
												</tbody>
											</table>
                                		</td>
                                	</tr>
                                	
                                	
                                </tbody>
                              </table>
                         </td>
                        <!-- right -->
                         <td>
                         		<table width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tbody>
                                	<tr>
                                		<td background="dept/zongtuo/images/main_27.gif" width="509" height="31" align="right">
                                		  	<table width="100%"><tbody>
                                		  	    <tr>
                                		  	       <td height="2"></td>
                                		  	    </tr>
                                		  	    <tr>
                                		  	    <td width="45"></td>
                                		  	    <td><font size="3" color="#ffffff"><strong>综拓视点</strong></font></td>
                                		  	    <td align="right"><a href="dept/zongtuo/ztlist.jsp?id=5349">more...</a>&nbsp;&nbsp;&nbsp;</td>
                                		  	    </tr>
                                		  	    </tbody>
                                		  	</table>
                                		</td>
                                	</tr>
                                	<tr>
                                		<td background="dept/zongtuo/images/main_29.gif" width="509" height="215" align="center">
                                			<table width="95%" >
												<tbody>
													<tr>
														<td width="15%" align="center"><img src="dept/zongtuo/images/m_pic6.gif" width="131" height="147">
														</td>
														<td width="64%" valign="top" align="center">
														<div style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap;width:300;text-align: left">
																<ulweb:content beanName="cl" deptId="zongtuo" enName="shidian" pageNum="1" pageSize="9" conditions="isDelete=0:i;isProcessing=0:i;" />
																		<logic:iterate id="element" name="cl" property="objectList">
																			<li><span class="fri">[<bean:write name="element" property="uploadTime" format="yyyy-MM-dd" />]</span>·<a href="show.do?c=<bean:write name="element" property="contentId" />" target="_blank" title="<bean:write name="element" property="contentName" />" <logic:equal name="element" property="displayType" value="9">style="color:#ff0000"</logic:equal> ><script>document.writeln("<bean:write name="element" property="contentName" />".substring(0,28));</script></a></li>
																		</logic:iterate>
														</div>
														</td>
													</tr>
												</tbody>
											</table>
                                		</td>
                                	</tr>
                                	
                                	
                                </tbody>
                              </table>
                         </td>
                     </tr>
                     
                     <!-- 下部分 -->
                     <tr>
                        <!-- 分左右两部分 -->
                        <!-- left -->
                         <td>
                         		<table width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tbody>
                                	<tr>
                                		<td background="dept/zongtuo/images/main_27.gif" width="509" height="31" align="right">
                                		  	<table width="100%"><tbody>
                                		  	    <tr>
                                		  	       <td height="2"></td>
                                		  	    </tr>
                                		  	    <tr>
                                		  	    <td width="45"></td>
                                		  	    <td><font size="3" color="#ffffff"><strong>下载中心</strong></font></td>
                                		  	    <td align="right"><a href="dept/zongtuo/ztlist.jsp?id=5350">more...</a>&nbsp;&nbsp;&nbsp;</td>
                                		  	    </tr>
                                		  	    </tbody>
                                		  	</table>
                                		</td>
                                	</tr>
                                	<tr>
                                		<td background="dept/zongtuo/images/main_29.gif" width="509" height="215" align="center">
                                			<table width="95%" >
												<tbody>
													<tr>
														<td width="15%" align="center"><img src="dept/zongtuo/images/m_pic2.gif" width="131" height="147">
														</td>
														<td width="64%" valign="top" align="center">
														<div style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap;width:300;text-align: left">
																<ulweb:content beanName="cl" deptId="zongtuo" enName="xiazai" pageNum="1" pageSize="9" conditions="isDelete=0:i;isProcessing=0:i;" />
																		<logic:iterate id="element" name="cl" property="objectList">
																			<li><span class="fri">[<bean:write name="element" property="uploadTime" format="yyyy-MM-dd" />]</span>·<a href="show.do?c=<bean:write name="element" property="contentId" />" target="_blank" title="<bean:write name="element" property="contentName" />" <logic:equal name="element" property="displayType" value="9">style="color:#ff0000"</logic:equal> ><script>document.writeln("<bean:write name="element" property="contentName" />".substring(0,28));</script></a></li>
																		</logic:iterate>
														</div>
														</td>
													</tr>
												</tbody>
											</table>
                                		</td>
                                	</tr>
                                	
                                	
                                </tbody>
                              </table>
                         </td>
                        <!-- right -->
                         <td>
                         			<table width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tbody>
                                	<tr>
                                		<td background="dept/zongtuo/images/main_27.gif" width="509" height="31" align="right">
                                		  	<table width="100%"><tbody>
                                		  	    <tr>
                                		  	       <td height="2"></td>
                                		  	    </tr>
                                		  	    <tr>
                                		  	    <td width="45"></td>
                                		  	    <td><font size="3" color="#ffffff"><strong>数据报表</strong></font></td>
                                		  	    <td align="right"><a href="dept/zongtuo/ztlist.jsp?id=5351">more...</a>&nbsp;&nbsp;&nbsp;</td>
                                		  	    </tr>
                                		  	    </tbody>
                                		  	</table>
                                		</td>
                                	</tr>
                                	<tr>
                                		<td background="dept/zongtuo/images/main_29.gif" width="509" height="215" align="center">
                                			<table width="95%" >
												<tbody>
													<tr>
														<td width="20%" align="center"><img src="dept/zongtuo/images/m_pic5.gif" width="131" height="147"/>
														</td>
														<td width="64%" valign="top" align="center">
														<div style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap;width:300;text-align: left">
																<ulweb:content beanName="cl" deptId="zongtuo" enName="baobiao" pageNum="1" pageSize="9" conditions="isDelete=0:i;isProcessing=0:i;" />
																		<logic:iterate id="element" name="cl" property="objectList">
																			<li><span class="fri">[<bean:write name="element" property="uploadTime" format="yyyy-MM-dd" />]</span>·<a href="show.do?c=<bean:write name="element" property="contentId" />" target="_blank" title="<bean:write name="element" property="contentName" />" <logic:equal name="element" property="displayType" value="9">style="color:#ff0000"</logic:equal> ><script>document.writeln("<bean:write name="element" property="contentName" />".substring(0,28));</script></a></li>
																		</logic:iterate>
														</div>
														</td>
													</tr>
												</tbody>
											</table>
                                		</td>
                                	</tr>
                                	
                                	
                                </tbody>
                              </table>
                         </td>
                     </tr>
                     <!-- end -->
                  </tbody>
               </table>
		   </td>
		</tr>
		<!-- 第五部分 -->
		<!-- 
       <tr>
       		<td>
       		 <table width="990" border="0" cellspacing="0" cellpadding="0" align="center">
	  <tbody><tr>
		<td background="dept/zongtuo/images/main_41.gif" width="990" height="39" align="center">&nbsp;您是本站第<span class="topNav2"><%=request.getAttribute("countProcesser")%></span>位访客 | <a href="admin/login.jsp" target="_blank">系统管理</a>
		</td>
	  </tr>
  </tbody></table>
       		</td>
		
		</tr>
		 -->
  <!-- end -->
	</tbody>
</table>
</body>
</html>
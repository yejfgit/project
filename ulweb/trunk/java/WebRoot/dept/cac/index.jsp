
<%@ taglib uri="struts-bean.tld" prefix="bean"%>
<%@ taglib uri="struts-html.tld" prefix="html"%>
<%@ taglib uri="struts-logic.tld" prefix="logic"%>
<%@ taglib uri="ulweb-list.tld" prefix="ulweb"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.ulweb.entity.UlAttachment,com.ulic.ulweb.frame.constant.Constant,com.ulic.ulweb.ulweb.web.action.IndexAction" pageEncoding="UTF-8"%>
		<%@ page language="java" import="com.ulic.ulweb.ulweb.entity.UlColumn,com.ulic.ulweb.ulweb.entity.UlContentWithAtt,com.ulic.ulweb.ulweb.util.DisplayOnPage"%>
		<%
			List<UlContent> shengri = (List<UlContent>)request.getAttribute("shengri");
 		%>
 		
		<title>合众人寿会计集中作业中心 &gt;&gt; 中心首页</title>
		<link href="/newapp/css/main.css" rel="stylesheet" type="text/css" />
		<link href="style/ul.css" type="text/css" rel=stylesheet/>
		<style type="text/css">
			.d1{  width: 1000px; margin: auto; border-right: gray 0px solid;border-left: gray 0px solid;background-color: #fff;padding:0px 24px 0px 0px }
			.d2{margin:0px 0px;height:148px;border:0px solid;width:1024px; }
			.d3{height:33px;background:url(dept/cac/images/newHead.png) ;font-family:"宋体";FONT-SIZE: 14pt;}
			.d4{height:26px;padding:0px 0px 0px -2px;FONT-FAMILY:宋体;FONT-SIZE: 14pt;}
			.d5{width: 230px;float:right;}
			.d6{height:715px;width:750px;padding:0px 0px 0px 10px}
			.d6_1{height:210px;}
			.d6_1_1{height:220px;width:350px;margin:0px 0px;border:0px solid; }
			.d6_1_2{float:right}
			.d6_2{height:253px;border:0px solid ;margin:2px 0px;valign:middle}
			.d6_3{height:200px;border:0px solid ;margin:2px auto;valign:top;}
				A{TEXT-DECORATION: none;}
				A:hover{COLOR: #CC0000;}
				A:link {color: #000000;}
				A:visited {color: #000000;}
				
				BODY
				{
				FONT-SIZE: 9pt;background:#eee
				}
				TD
				{
				FONT-FAMILY:宋体;FONT-SIZE: 9pt;line-height: 150%; 
				
				}
				Input
				{
				BORDER-BOTTOM: ##FF00FF 1px solid;
				BORDER-LEFT: ##FF00FF 1px solid;
				BORDER-RIGHT: ##FF00FF 1px solid;
				BORDER-TOP: ##FF00FF 1px solid;
				COLOR: #000000;
				HEIGHT: 18px;
				border-color: #F5FFFA; 
				font-size: 9pt
				}
				Button
				{
				FONT-SIZE: 9pt;HEIGHT: 20px; ; 
				
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
				
				 .xtt{ background: no-repeat center bottom; border:1px solid #ccc; border-top:0px ; border-bottom:0px; padding:0 5px;}
				
				.xtt li{ background:url(dept/cac/images/title.png) no-repeat left bottom;  line-height:30px; font-size:14px;}
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
			function checkIsValidDate()
			{
			   if(DateObj2StandardFmt(document.all.form1.ts) && DateObj2StandardFmt(document.all.form1.te))
			   		
					return true;
				else
					return false;  
			}
			
			</script>
			<script language="JavaScript" type="text/JavaScript">
			//菜单列表
			var menu_skin="&nbsp;<a style=font-size:9pt;line-height:14pt; href='SetCookie.asp?Action=SetSkin&ClassID=0&SkinID=1'>牧虫典雅</a><br>&nbsp;<a style=font-size:9pt;line-height:14pt; href='SetCookie.asp?Action=SetSkin&ClassID=0&SkinID=2'>雅虎秋梦</a><br>&nbsp;<a style=font-size:9pt;line-height:14pt; href='SetCookie.asp?Action=SetSkin&ClassID=0&SkinID=3'>灰色畅想</a><br>&nbsp;<a style=font-size:9pt;line-height:14pt; href='SetCookie.asp?Action=SetSkin&ClassID=0&SkinID=4'>绿雨飘香</a><br>&nbsp;<a style=font-size:9pt;line-height:14pt; href='SetCookie.asp?Action=SetSkin&ClassID=0&SkinID=5'>幽绿芭蕾</a><br>&nbsp;<a style=font-size:9pt;line-height:14pt; href='SetCookie.asp?Action=SetSkin&ClassID=0&SkinID=6'>晴空幽蓝</a><br>&nbsp;<a style=font-size:9pt;line-height:14pt; href='SetCookie.asp?Action=SetSkin&ClassID=0&SkinID=7'>书卷飘香</a><br>&nbsp;<a style=font-size:9pt;line-height:14pt; href='SetCookie.asp?Action=SetSkin&ClassID=0&SkinID=8'>蓝天动力</a><br>&nbsp;<a style=font-size:9pt;line-height:14pt; href='SetCookie.asp?Action=SetSkin&ClassID=0&SkinID=9'>动力空间</a><br>";
			</script>
			<script language="JavaScript" src="script/date.js"></script>
			 <script language="JavaScript" src="script/check.js"></script>
           <script language="JavaScript" src="script/CheckData.js"></script>
	</head>



	<body bgcolor="#eee" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" style="text-align: center" >
  		<div class="d1">
  		
  			<div class="d2" style="width:1024px;">
  					<table width="100%" cellpadding="0px" style="margin: 0px 0px;width:100%;">
					<tr>
						<td width="310" height="150" background="dept/cac/images/newBg_2Picture.png">
						</td>
						<td width="714" height="150" background="dept/cac/images/newBgpicture2.png">
						</td>
					</tr>
				</table>
  			</div>
  			<!-- +++++++++++++++++++++++++++++++++++++++++++ -->
  			<div class="d3 d2" style="margin-top:2px;margin-right:1px;background-color: red;">
  				<table width="1024" border="0" cellspacing="0" cellpadding="0">
				<tbody>
					<tr>
				        <td width="145px" height="33px" align="center"><a href="cacCheck.do?method=index" target="_self"><font color="#ffffff" style="font-size:16px;font-family:宋体"><strong>首页</strong></font></a></td>
				        <td  width="145px" height="33px" align="center"><a href="dept/cac/kjlist.jsp?id=5664" target="_blank"><font color="#ffffff" style="font-size:16px;font-family:宋体"><strong>部门介绍</strong></font></a></td>
				        <td  width="145px" height="33px" align="center"><a href="dept/cac/kjlist.jsp?id=5484" target="_self"><font color="#ffffff" style="font-size:16px;font-family:宋体"><strong>中心汇</strong></font></a></td>
				        <td width="145px" height="33px" align="center"><a href="dept/cac/kjlist.jsp?id=5485" target="_self"><font color="#ffffff" style="font-size:16px;font-family:宋体"><strong>集中云</strong></font></a></td>
				        <td  width="145px" height="33px" align="center"><a href="dept/cac/kjlist.jsp?id=5486" target="_self"><font color="#ffffff" style="font-size:16px;font-family:宋体"><strong>风采秀</strong></font></a></td>
				        <td  width="145px" height="33px" align="center"><a href="dept/cac/kjlist.jsp?id=5504" target="_self"><font color="#ffffff"style="font-size:16px;font-family:宋体"><strong>知识窗</strong></font></a></td>
				        <td  width="145px" align="center"><a href="dept/cac/kjlist.jsp?id=5506" target="_self"><font color="#ffffff" style="font-size:16px;font-family:宋体"><strong>数据库</strong></font></a></td>
					    <td  width="200px" height="33px" align="right" >
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
							document.write("<font color= #ffffff style= font-size:12px;font-family:宋体><strong>"+year+"年"+mymonth+"月"+myday+"日 "+weekday+"</strong></font>");
						</script></td>
					</tr>
				   </tbody>
				</table>
  			</div>
  			<!-- +++++++++++++++++++++++++++++++++++++++++++ -->
  			<div class="d4 d2" style="padding:0px 0px 0px 0px;">
  				 <form action="cacCheck.do?method=index" id="idform2" name="form2" method="post"  >
            	<table style="padding:0px 0px 0px 0px;margin:0px 0px;width:100%">
            	
            		<tr>
            		<td width="20px" ></td>
            		<td width="30" height="33" style="background:url('dept/cac/images/newTubiao1.png');margin-left:-20px;">
            		<td height="10px">
								<div class="birthday" style="padding:0px 1px 0px 1px;float:left;">
									<span style="width: 100px; padding: 0px 0px; color: #FF6600;font-size:15px;font-family:宋体">生日祝福：</span><span style="width: 100px; padding: 0px 0px; color: #000000;font-size:14px;font-family:宋体">点击姓名即可发送 &gt;&gt;&gt; </span>
	                <marquee onMouseOver="this.stop()" width="720px" scrollamount="3"  onmouseout="this.start()">
					<%
						java.util.Date dt = new Date();
						String today = String.valueOf(dt.getMonth() + 1) + "-" + String.valueOf(dt.getDate());
						for(int i = 0; i < shengri.size(); i++){
							out.print("<font color=\"" + (shengri.get(i).getKeyWord().equals(today) ? "#FF0000" : "#000000")+"\" style=\"font-size:14px;font-family:宋体\" >☆</font><a style=\"color: #000000;font-size:14px;font-family:宋体\" href=\"mailto:" +(shengri.get(i).getContentName()).toString()+ "@ulic.com.cn?subject=Happy Birthday!\">");
							out.println(shengri.get(i).getKeyWord() + "&nbsp;" + shengri.get(i).getSubTitle() + "</a>&nbsp;&nbsp;");
						}

				%>
	          		</marquee></div></td>
					</tr>
			</table>
			     </form>
  			</div>
  			<!-- +++++++++++++++++++++++++++++++++++++++++++ -->
  			<div class="d5 d2">
  					<!-- &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& -->
  					<br/>
  					<div class="d6_2 d5" style="height:110px;background: url(dept/cac/images/erWeiMa.png);margin-left:25px"></div>
  					 <div class="d6_2 d5" style="height:210px">
  					<table width="230px" border="0" align="center" cellpadding="0" cellspacing="0" style="background:url(dept/cac/images/newBorderg_2.png) no-repeat;height:180px;padding: 0px 0px 0px 0px;">
          						<tbody>
          							<tr style="height:8px"></tr>
           							 <tr>
           							 	 <td height="30px" align="center" ><span style="width: 100px; padding: 0px 0px; color: #FF6600;font-size:14pt;font-family:宋体"><strong>月度考核报表</strong></span></td>
           							 </tr>
           							 <tr>
           							 		<td style="width:220px;padding: 0;">
           							 		 <div style="height: 180px;display: block;width:210px;text-align:left;">
								              	<div class="xtt" style="padding:0px 10px;overflow: hidden; text-overflow: ellipsis; white-space: nowrap;width:210px;text-align:left;border:0px;">									
								              	<ulweb:content beanName="cl" deptId="cac" enName="shujuku" pageNum="1" pageSize="3" conditions="isDelete=0:i;isProcessing=0:i;" />
												<logic:iterate id="element" name="cl" property="objectList">
												<li style="text-align:left;">·<a style="font-size:10pt;font-family:宋体;" href="show.do?c=<bean:write name="element" property="contentId" />" target="_blank" title="<bean:write name="element" property="contentName" />" <logic:equal name="element" property="displayType" value="9">style="color:#ff0000"</logic:equal> ><script>document.writeln("<bean:write name="element" property="contentName" />".substring(0,28));</script></a></li>
												</logic:iterate>
												</div>
												</div>
											</td>
           							 </tr>
           							 </tbody>
           			 </table>
  				</div>
  					
  					
  			
  				<!-- &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& -->
  					<br/>
  				<div class="d6_1 d5" style="height:152px">
  					<table width="100%" style="border: 0px solid; width: 227px;height:150px;background:url(dept/cac/images/newBorderg_1.png);">
  					<tr style="height:10px">
  					</tr>
									<tr ><td height="10" align="center">
									<span style="width: 100px; padding: 0px 0px; color: #FF6600;font-size:14pt;font-family:宋体"><strong>资&nbsp;料&nbsp;检&nbsp;索</strong></span>
									</td></tr>
									<tr><td align="center">
										 <form action="dept/cac/checkshow.jsp" id="idform1" name="form1" method="post" onSubmit="return checkIsValidDate();">
										<table cellpadding="0" cellspacing="0" border="0"  align="center">
											<tr>
												<td>
													<table width="200px" cellspacing="0" border="0">
														<tr>
															<td align="center">
																<span style="font-size:10pt;font-family:宋体"><strong>检索词:</strong></span>
															</td>
															<td align="left" height="28px">
																<input  type="text" name="tName" size="15" maxlength="30"  ></input>
															</td>
														</tr>
														<tr>
															<td align="left">
																<input type="hidden" name="ts" size="10" maxlength="10" onKeyUp="if(event.keyCode != 37 && event.keyCode != 39 && event.keyCode != 8)value=value.replace(/[^\d-]/g,'')" id="demo" value="2005-2-3"></input>
															</td>
														</tr>
														<tr>
															<td align="left">
																<input type="hidden" name="te" size="10" maxlength="10" id="demo1" onKeyUp="if(event.keyCode != 37 && event.keyCode != 39 && event.keyCode != 8)value=value.replace(/[^\d-]/g,'')" value="2008-12-31"></input><script type="text/javascript">dt=new Date();document.getElementById("demo1").value=dt.getYear()+"-"+(dt.getMonth()+1)+"-"+dt.getDate();</script>
															</td>
														</tr>
														<tr>
															<td align="right" height="28px">
																<span style="font-size:10pt;font-family:宋体"><strong>类别:&nbsp;</strong></span>
															</td>
															<td align="left">
																	<select name="typeName" style="border-color:#F5FFFA;width:100px;font-size:10pt;font-family:宋体">
																	<option value="0" selected="selected">不限</option>
																	<option value="5224">中心汇</option>
																	<option value="5226">集中云</option>
																	<option value="5227">风采秀</option>
																	<option value="5228">知识窗</option>
																	<option value="5229">数据库</option>
																	</select>
															</td>
														</tr>
														<tr>
															      <td colspan="2" align="center"> <input name="button"  type="submit"  value="开始检索"/>
															      </td>
														</tr>
													</table>
												
												</td>
											</tr>
		
	                                 </table>
	                                 	</form>								
									   </td>
					                </tr>
			      </table>
  				</div>
  				<!-- &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& -->
  				<div class="d6_2 d5">
  					<table  style="background:url(dept/cac/images/newBorderg_2.png) no-repeat;width:210px;height:210px">
			  				<tr style="height:6px"></tr>
			  				<tr>
							  <td width="" height="25px" style="width: 220px;" valign="middle">
							  	<span style="width: 220px;display: block; padding: 0px 0px; color: #FF6600;font-size:14pt;font-family:宋体;letter-spacing: 5px;text-align:center;"><strong>网站导航</strong></span>
							  </td>
							</tr>
							<tr>
										         <td>
							<div class="right" >
					           <div id="linkbox" style="position:relative; ">
					               
					                <div style="height: 180px;">
					                      <div id="link1" class="xtt" style="height: 150px;text-align:left;width:210px;border:0px;">
					                      
					  <ul>
					<ulweb:content beanName="cl" deptId="cac" enName="daohang" pageNum="1" pageSize="11" conditions="isDelete=0:i;isProcessing=0:i;" />
							<logic:iterate id="element" name="cl" property="objectList">
								<li>·<a style="font-size:10pt;font-family:宋体" href="<bean:write name="element" property="subTitle" />" target="_blank"><bean:write name="element" property="contentName" /></a></li>
							</logic:iterate>
					
					</ul>
					                       </div>
					                  </div>
					                  <div  style="display:inline;position:absolute; top:340px; left:91px;">
												<table style="position:relative;">
												<script>
													var lastlbt = 'lbt1';
													
													function changelbtColor(lbt){
														var last = document.getElementById(lastlbt);
														last.style.backgroundColor='#EFEFEF';
														last.style.color='#000000';
														
														lbt.style.backgroundColor='#4DAC26';
														lbt.style.color='#FFFFFF';
														lbt.style.cursor='hand'
														
														lastlbt = lbt.id;
													}
												</script>
										</table>
					                  </div>
					
					                  <div class=bank5></div>
					            </div>
					</div>
						 </td>
								 
					</tr>
			 	</table>
  				</div>
  			</div>
  			<!-- +++++++++++++++++++++++++++++++++++++++++++ -->
  			<div class="d6">
  				
  				
  				<div class="d6_3 d6">
  					<table style="width:740px;height:230px;margin-left:10px" >
  						<tr >
  							<td width="350">
  								<table width="350"  style="height: 200px;">
										<tbody>
										<tr style="height: 200px;">
										   
										    <td width="50%" align="center" style="height:180px">
										       <p>
								<script language="javascript">
									var imgUrl=new Array();
									var imgLink=new Array();
									var text=new Array();
									var adNum=0;
									var buttonShow=1;
									var buttonPos=2; //RU:1，RD:2，LU:3，LD:4
									<ulweb:content beanName="cl" deptId="cac" enName="tupian" pageNum="1" pageSize="10" conditions="isDelete=0:i;isProcessing=0:i;" withAtt="1" />
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
									
									
																	<script language="javascript" src="dept/cac/newsAd.js"></script>
																	<div style="position: relative;">
																	<table id="newsTable"  cellspacing="0" cellpadding="0" style="border: solid 0px red; " align="center">
																		<script language="javascript"> dakularButtons();</script>
																		<tr style="height:170px;">
																			<td>
																				<a
																					onmouseover="displayStatusMsg();return document.returnValue"
																					onmouseover="status='';" class=px14-lh24
																					href="javascript:jump2url()"><img
																						style="FILTER: revealTrans(duration=1,transition=23); border:0px solid #000000"
																						src="#" width="345px" height=190px border=0
																						name=imgUrlrotator alt=""/> </a>
																					
																					<script>nextAd();</script>
																					
																			</td>
																			
																		</tr>
																		
																	</table>
																	</div>
														</p>			
										    </td>
										    </tr>
										    </tbody>
										    </table>
  							</td>
  							
  							<td width="350px" >
  								<table style="width:350px;height:200px;valign:middle;margin-left:0px">
										    		      		<tbody>
										    		      		  <tr >
										    		      		    <td width="1%" align="center">
										    		      		          <div>
										    		      		          	<p><img src="dept/cac/images/body_7.gif" /></p>
										    		      		          </div>
										    		      		    </td>
										    		      		   
										    		      		    <td width="340px" valign="top";>
										    		      		       <div style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap;width:350px;text-align:left;">									
																	<ulweb:content beanName="cl" deptId="cac" enName="dongtai" pageNum="1" pageSize="11" conditions="isDelete=0:i;isProcessing=0:i;" />
																	<logic:iterate id="element" name="cl" property="objectList">
																	<strong>·</strong><a style="font-size:10pt;font-family:宋体" href="show.do?c=<bean:write name="element" property="contentId" />" target="_blank" title="<bean:write name="element" property="contentName" />" <logic:equal name="element" property="displayType" value="9">style="color:#ff0000"</logic:equal> ><script>document.writeln("<bean:write name="element" property="contentName" />".substring(0,28));</script></a><span class="fri">[<bean:write name="element" property="uploadTime" format="yyyy-MM-dd" />]</span>
																	<br/>
																	</logic:iterate>
																					
														        </div>  
										    		      		    </td>
										    		      		  <td width="4px" align="center">
										    		      		          <div>
										    		      		          	<p><img src="dept/cac/images/body_7.gif" /></p>
										    		      		          </div>
										    		      		    </td>  
										    		      		  </tr>
										    		      		  </tbody>
										    		      		 </table>
  							</td>
  						</tr>
  					</table>
  				</div>
  				
  				<div class="d6_2 d6">
  					<table width="740px" style="margin-left:8px;padding:0px;">
  						<tr>
  							<td width="350px" height="240px" >
  								<table style="width:350px;border:0px;cellpadding:0px;height:210px;">
                   
                                <tbody>
                                	<tr style="background: url(dept/cac/images/xiaHuaXian.png);margin-bottom:0px">
                                		<td width="350px" height="72px" align="left">
                                		  	<table width="100%"><tbody>
                                		  	    <tr>
                                		  	    <td width="70" height="46" background="dept/cac/images/newButton_1.png"></td>
                                		  	    <td><span style="width: 100px; padding: 0px 0px; color: #FF6600;font-size:14pt;font-family:宋体"><strong>中心汇</strong></span></td>
                                		  	    <td align="right"><a href="dept/cac/kjlist.jsp?id=5484"><span style="width: 100px; padding: 0px 0px; color: #FF6600;font-size:10pt;font-family:Arial"><strong>more...</strong></span></a></td>
                                		  	    </tr>
                                		  	    </tbody>
                                		  	</table>
                                		</td>
                                	</tr>
                                	<tr>
                                		<td style="width: 200px; height: 171px;background-color:#FDF5E6; align="center">
                                			<table style="width: 350px; height: 140px">
												<tbody>
													<tr>
														<td width="165px" align="center"><br />
														</td>
														<td width="100%" valign="top" align="center">
														<div style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap;width:300;text-align: left">
																<ulweb:content beanName="cl" deptId="cac" enName="jizhongying" pageNum="1" pageSize="9" conditions="isDelete=0:i;isProcessing=0:i;" />
																		<logic:iterate id="element" name="cl" property="objectList">
																			<li> <span class="fri">[<bean:write name="element" property="uploadTime" format="yyyy-MM-dd" />]</span> <a style=font-size:10pt;font-family:宋体 href="show.do?c=<bean:write name="element" property="contentId" />" target="_blank" title="<bean:write name="element" property="contentName" />" <logic:equal name="element" property="displayType" value="9"> style="color:#ff0000"</logic:equal> ><script>document.writeln("<bean:write name="element" property="contentName" />".substring(0,28));</script></a></li>
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
                            <td width="350px" height="240px" >
  								<table style="width:350px;border:0px;cellpadding:0px;height:210px;">
                   
                                <tbody>
                                	<tr style="background: url(dept/cac/images/xiaHuaXian.png);margin-bottom:0px">
                                		<td width="350px" height="72px" align="left">
                                		  	<table width="100%"><tbody>
                                		  	    <tr>
                                		  	    <td width="70" height="46px" background="dept/cac/images/newButton_2.png"></td>
                                		  	    <td><span style="width: 100px; padding: 0px 0px; color: #FF6600;font-size:14pt;font-family:宋体"><strong>集中云</strong></span></td>
                                		  	    <td align="right"><a href="dept/cac/kjlist.jsp?id=5485"><span style="width: 100px; padding: 0px 0px; color: #FF6600;font-size:10pt;font-family:Arial"><strong>more...</strong></span></a></td>
                                		  	    </tr>
                                		  	    </tbody>
                                		  	</table>
                                		</td>
                                	</tr>
                                	<tr>
                                		<td style="width: 200px; height: 171px;background-color:#FDF5E6;" align="center">
                                			<table s style="width: 350px; height: 140px">
												<tbody>
													<tr>
														<td width="180px" valign="top" align="center">
														<div style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap;width:300;text-align: left">
																<ulweb:content beanName="cl" deptId="cac" enName="jinronggang" pageNum="1" pageSize="9" conditions="isDelete=0:i;isProcessing=0:i;" />
																		<logic:iterate id="element" name="cl" property="objectList">
																			<li><span class="fri">[<bean:write name="element" property="uploadTime" format="yyyy-MM-dd" />]</span><a style="font-size:10pt;font-family:宋体" href="show.do?c=<bean:write name="element" property="contentId" />" target="_blank" title="<bean:write name="element" property="contentName" />" <logic:equal name="element" property="displayType" value="9">style="color:#ff0000"</logic:equal> ><script>document.writeln("<bean:write name="element" property="contentName" />".substring(0,28));</script></a></li>
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
  					</table>
  					
  				
  				</div>
  				<div class="d6_2 d6" style="margin-left: 15px;padding:0px 0px;">
  					<table width="740px" style="paddin-top:0px;">
  
  						<tr>
  							<td width="350px" height="240px" >
  							<table style="width:350px;border:0px;cellspacing:0px;cellpadding:0px 0px 0px 0px;height:210px;">
                                <tbody>
                                	<tr style="background: url(dept/cac/images/xiaHuaXian.png);margin-bottom: 2px">
                                		<td width="350px" height="72px" align="left" style="margin-top:0px;">
                                		  	<table width="100%" style=""><tbody>
                                		  	   
                                		  	    <tr>
                                		  	    <td width="70" height="46" background="dept/cac/images/newButton_3.png"></td>
                                		  	    <td ><span style="width: 100px; padding: 0px 0px; color: #FF6600;font-size:14pt;font-family:宋体"><strong>风采秀</strong></span></td>
                                		  	    <td align="right"><a href="dept/cac/kjlist.jsp?id=5486"><span style="width: 100px; padding: 0px 0px; color: #FF6600;font-size:10pt;font-family:Arial"><strong>more...</strong></span></a></td>
                                		  	    </tr>
                                		  	    </tbody>
                                		  	</table>
                                		</td>
                                	</tr>
                                	<tr>
                                		<td style="width: 200px; height: 171px;background-color:#FDF5E6;" align="center">
                                			<table style="width: 350px; height: 140px">
												<tbody>
													<tr>
														<td width="100%" valign="top" align="center">
														<div style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap;width:300;text-align: left">
																<ulweb:content beanName="cl" deptId="cac" enName="fengcaixiu" pageNum="1" pageSize="9" conditions="isDelete=0:i;isProcessing=0:i;" />
																		<logic:iterate id="element" name="cl" property="objectList">
																			<li><span class="fri">[<bean:write name="element" property="uploadTime" format="yyyy-MM-dd" />]</span><a style="font-size:10pt;font-family:宋体" href="show.do?c=<bean:write name="element" property="contentId" />" target="_blank" title="<bean:write name="element" property="contentName" />" <logic:equal name="element" property="displayType" value="9">style="color:#ff0000"</logic:equal> ><script>document.writeln("<bean:write name="element" property="contentName" />".substring(0,28));</script></a></li>
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
  							
  							<td width="350px" height="240px" >
  								<table style="width:350px;border:0px;cellspacing:0px;cellpadding:0px;height:210px;margin-left:0px">
                                <tbody>
                                	<tr style="background: url(dept/cac/images/xiaHuaXian.png);margin-bottom:0px">
                                		<td width="350px" height="72px" align="left">
                                		  	<table width="350px" ><tbody>
                 
                                		  	    <tr>
                                		  	     <td width="70" height="46px" background="dept/cac/images/newButton_4.png"></td>
                                		  	    <td><span style="width: 100px; padding: 0px 0px; color: #FF6600;font-size:14pt;font-family:宋体"><strong>知识窗</strong></span></td>
                                		  	    <td align="right"><a href="dept/cac/kjlist.jsp?id=5504"><span style="width: 100px; padding: 0px 0px; color: #FF6600;font-size:10pt;font-family:Arial"><strong>more...</strong></span></a></td>
                                		  	    </tr>
                                		  	    </tbody>
                                		  	</table>
                                		</td>
                                	</tr>
                                	<tr>
                                		<td style=" width: 200px; height: 169px;background-color:#FDF5E6;" align="center">
                                			<table style="width: 350px; height: 140px ">
												<tbody>
													<tr>
														<td width="100%" valign="top" align="center" >
														<div style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap;text-align: left">
																<ulweb:content beanName="cl" deptId="cac" enName="zhishichuang" pageNum="1" pageSize="9" conditions="isDelete=0:i;isProcessing=0:i;" />
																		<logic:iterate id="element" name="cl" property="objectList">
																			<li><span class="fri">[<bean:write name="element" property="uploadTime" format="yyyy-MM-dd" />]</span><a style="font-size:10pt;font-family:宋体" href="show.do?c=<bean:write name="element" property="contentId" />" target="_blank" title="<bean:write name="element" property="contentName" />"<logic:equal name="element" property="displayType" value="9">style="color:#ff0000"</logic:equal> ><script>document.writeln("<bean:write name="element" property="contentName" />".substring(0,28));</script></a></li>
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
  					</table>
  					
  				
  				</div>
  			</div>
  			<!-- +++++++++++++++++++++++++++++++++++++++++++ -->
  			<div>
  			    <table width="1024px" border="0" cellspacing="0" cellpadding="0" align="center">
	  <tbody><tr>
		<td background="dept/cac/images/main_41_1.gif" width="1000px" height="40px" align="center">Copyright2014 版权所有 合众人寿保险股份有限公司 会计集中作业中心</td>
	  </tr>
  </tbody></table>
  			</div>
  		</div>	
	</body>
	
</html>
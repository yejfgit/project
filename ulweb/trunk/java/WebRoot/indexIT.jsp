
<%@ taglib uri="struts-bean.tld" prefix="bean"%>
<%@ taglib uri="struts-html.tld" prefix="html"%>
<%@ taglib uri="struts-logic.tld" prefix="logic"%>
<%@ taglib uri="ulweb-list.tld" prefix="ulweb"%>

<%@ page language="java"
	import="java.util.*,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.ulweb.entity.UlAttachment,com.ulic.ulweb.frame.constant.Constant,com.ulic.ulweb.ulweb.web.action.IndexAction"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//if(request.getAttribute("from") == null) response.sendRedirect(basePath + "index.do");
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>信息管理中心主页</title>
		<script type="text/javascript" src="js/top.js"></script>
		<script type="text/javascript" src="js/common.js"></script>
		<link href="css/main1zhn.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript">

/**/
var h = 0;  //设置当前显示高度
function loadImage(url,callback){
    var img = new Image();
    img.src = url;
    if(img.complete){   //判断图片是否加载完成
        callback.call(img);
        return;
    }
    img.onload = function(){    //图片加载
        callback.call(img);
    }
}

function imgLoaded(){
    document.getElementById("myImgs").src = this.src;   //获得图片地址
    showImage(this.height);     //图片展开
}
function showImage(height){
    if(h < height){
        h = h + 50;
    }else{
        setTimeout("hideImage("+height+")",2000);   //图片全部展开后，设置多少秒之后关闭图片
        return;
    }
    var div = document.getElementById("myDiv");
    var img = document.getElementById("myImgs");
    div.style.display = "block";
    div.style.height = h + "px";
    setTimeout("showImage("+height+")",30);
}
function hideImage(height){
    //alert(height);
    if(h > 0){
        h = h - 50;
    }else{
        var divs = document.getElementById("myDiv");
        divs.style.display = "none";    //图片关闭后隐藏该层
        return;
    }
    var div = document.getElementById("myDiv");
    var img = document.getElementById("myImgs");
    div.style.display = "block";
    div.style.height = h + "px";
    setTimeout("hideImage("+height+")",30);
}


//function closePic(){
	//var pic = document.getElementById("myDiv");
	//pic.style.display = "none";
//}

function tagSelect1(grp, idx, len) {
	try {
		for (i = 1; i <= len; i++) {
			if (i == idx) {
				gi(grp + i).style.display = "block";
			} else {
				gi(grp + i).style.display = "none";
			}
		}
	}
	catch (e) {
	}
}
var preTabSel = "mgzz_f_1";
function tagSel(grp, idx, len) {
	gi(preTabSel).className = "tab";
	preTabSel = grp +"_f_"+ idx;
	gi(grp +"_f_"+ idx).className = "tabsel";
	try {
		for (i = 1; i <= len; i++) {
			if (i == idx) {
				gi(grp + i).style.display = "block";
				gi("tag_" + grp + i).className = "tagSel";
				
			} else {
				gi(grp + i).style.display = "none";
				gi("tag_" + grp + i).className = "tag";
			}
		}
	}
	catch (e) {
	}
}
</script>
		<style>
   .lbt{
	float:left;
	height:12px; 
	width:20px; 
	border:1px solid #000000; 
	background-color:#EFEFEF; 
	color:#000000; 
	font-size:12px; 
	overflow:hidden;
	line-height:12px;
    }
    .mainDiv{
	height:800px;
	width:1015px;
	overflow:auto;
	margin:0px auto;
	}
	.topDiv{
	background-repeat:no-repeat;
	text-align: left
	}
	.leftDiv{
	width:230px;
	margin-top:5px;
	height:450px;
	float:left;
	text-align: left
	}
    .rightDiv{
	width:500px;
	float:left;
	margin-left: 15px;
	margin-right: 10px;
	overflow: hidden;
    height: 590px;
    margin-top: 10px
	}
	.linkarea{
	margin: 20px;
	}
	.gif{
	width:500px;
	overflow:hidden;
	}
	.other{
	margin-top:15px;
	width:230px;
	float:left;
	margin-left: 0px;

	}
	.style1{
	width:497px;
	height:360px; 
	float:left;
	border:2px solid #dce6d5;
	margin-top: 5px;
	
	}
	.style2{
	width:365px;
	height:300px;
	float:left;
	margin-left: 10px;
	border:2px solid #dce6d5;
	}
	.ul_left{
	text-align: left;
	}
	.tab{
	font-weight: bold;font-size: 15px;color: #C8E7CC;text-decoration:none; 
	}
	.tabsel{
	font-weight: bold;font-size: 15px;color: #84cf84;text-decoration:none; 
	}
	.numberA{
	background-color:white;
	text-align:center;
	width: 110px;
	height: 110px; 
	line-height:110px;
	vertical-align:center;
	float: left;
	margin: 2px 0px 5px 5px;
	cursor: pointer;
	font-size: 30pt;
	color: #E2F6F4;
	font-weight: bold;
	}
	

</style>
	</head>

	<body style="text-align: center">
		<div class="mainDiv">
			<div class="topDiv"><img src="images/it_index.jpg" style="width: 990px;height: 80px" /></div>
			<div class="leftDiv">

				<div id="linkbox" style="position:relative ">
					<p>
						<img src="images/xt_1.bmp" />
					</p>
					<div id="link1" class="xt" style="height: 525px;display: block">
						<ul>
							<ulweb:content beanName="cl" deptId="it" enName="link"
								pageNum="1" pageSize="15"
								conditions="isDelete=0:i;isProcessing=0:i;" />
							<logic:iterate id="element" name="cl" property="objectList">
								<li>
									·
									<a href="<bean:write name="element" property="subTitle" />"
										target="_blank"><bean:write name="element"
											property="contentName" /> </a>
								</li>
							</logic:iterate>

						</ul>
					</div>

					<div id="link2" class="xt" style="display:none;height: 565px">

						<ul>
							<ulweb:content beanName="cl" deptId="0000" enName="link"
								pageNum="2" pageSize="18"
								conditions="isDelete=0:i;isProcessing=0:i;" />
							<logic:iterate id="element" name="cl" property="objectList">
								<li>
									·
									<a href="<bean:write name="element" property="subTitle" />"
										target="_blank"><bean:write name="element"
											property="contentName" /> </a>
								</li>
							</logic:iterate>
						</ul>
					</div>


					<div id="link3" class="xt" style="display:none;height: 565px">
						<ul>
							<ulweb:content beanName="cl" deptId="0000" enName="link"
								pageNum="3" pageSize="18"
								conditions="isDelete=0:i;isProcessing=0:i;" />
							<logic:iterate id="element" name="cl" property="objectList">
								<li>
									·
									<a href="<bean:write name="element" property="subTitle" />"
										target="_blank"><bean:write name="element"
											property="contentName" /> </a>
								</li>
							</logic:iterate>
						</ul>
					</div>


					<div id="link4" class="xt" style="display:none;height: 565px">
						<ul>
							<ulweb:content beanName="cl" deptId="0000" enName="link"
								pageNum="4" pageSize="18"
								conditions="isDelete=0:i;isProcessing=0:i;" />
							<logic:iterate id="element" name="cl" property="objectList">
								<li>
									·
									<a href="<bean:write name="element" property="subTitle" />"
										target="_blank"><bean:write name="element"
											property="contentName" /> </a>
								</li>
							</logic:iterate>
						</ul>
					</div>
					<div
						style="display:inline;position:absolute;bottom:8px; left:91px;">
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

							<tr align="center">
								<td>
									
								</td>
								<td style="height:12px;">
									<div style="display: none"><img src="images/new3.gif" />
										<div id='lbt1' class="lbt"
											style="background-color:#4DAC26;color:#FFFFFF;"
											onmouseover="changelbtColor(this);tagSelect1('link', 1, 4)">
											&nbsp;1&nbsp;
										</div>
										<div id='lbt2' class="lbt"
											onmouseover="changelbtColor(this);tagSelect1('link', 2, 4)">
											&nbsp;2&nbsp;
										</div>
										<div id='lbt3' class="lbt"
											onmouseover="changelbtColor(this);tagSelect1('link', 3, 4)">
											&nbsp;3&nbsp;
										</div>
										<div id='lbt4' class="lbt"
											onmouseover="changelbtColor(this);tagSelect1('link', 4, 4)">
											&nbsp;4&nbsp;
										</div>
									</div>
								</td>
							</tr>
						</table>
					</div>
					<p>
						<img src="images/xt2_1.JPG" />
					</p>
				</div>

			</div>

			<div class="rightDiv">
				<div class="gif">
					<script language="javascript">
var imgUrl=new Array();
var imgLink=new Array();
var text=new Array();
var adNum=0;
var buttonShow=1;
var buttonPos=2; //RU:1，RD:2，LU:3，LD:4



<ulweb:content beanName="cl" deptId="it" enName="tupian0" pageNum="1" pageSize="10" conditions="isDelete=0:i;isProcessing=0:i;" withAtt="1" />
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
					<script language="javascript" src="js/newsAd.js"></script>
					<table id=newsTable border="0" cellspacing="0" cellpadding="0"
						style="border: solid 1px #CCCCCC; ">
						<script language="javascript">dakularButtons();</script>
						<tr>
							<td>
								<a onMouseOver="displayStatusMsg();return document.returnValue"
									onMouseOut="status='';" class=px14-lh24
									href="javascript:jump2url()"><img
										style="FILTER: revealTrans(duration=1,transition=23); border:0px solid #000000"
										src="#" width="498" height=200 border=0 name=imgUrlrotator
										alt=""> </a>
								<script>nextAd();</script>
							</td>
						</tr>
					</table>
				</div>
				
				<div class="style1">
					<div class="Lcon1">
					    <p style="text-align: left">
						<table cellpadding="0" cellspacing="0" border="0">
							<tr>
								<td >
									<img src="images/biao.jpg" />
									&nbsp;
								</td>
								<td>
									<a href="itList.jsp?id=4844" target="_blank" id="tag_mgzz1"
										onmouseover="tagSel('mgzz', 1, 2)" class="tagSel" ><font id="mgzz_f_1"
										class="tabsel">IT播报</font> </a>
								</td>
								<td>&nbsp;
									<a href="itList.jsp?id=4846" target="_blank" id="tag_mgzz2"
										onmouseover="tagSel('mgzz', 2, 2)" class="tag"><font id="mgzz_f_2"
										class="tab">报告/纪要</font> </a>
								</td>
								
							</tr>
						</table>
						</p>
					</div>
					<div class="za" style="height: 316px;overflow:auto;">
						<div id="mgzz1" style="display: block;Height: 290px;">
							<ul class="ul_left">
								<ulweb:content beanName="cl" deptId="it" enName="bobao"
									pageNum="1" pageSize="20"
									conditions="isDelete=0:i;isProcessing=0:i;" withAtt="1"/>
								<logic:iterate id="element" name="cl" property="objectList">
									<li style="line-height: 28px;">
									    <!--
										<span class="fri"><bean:write name="element"
												property="updateTime" format="yyyy-MM-dd" /> </span>· -->
										<logic:notEmpty name="element" property="subTitle">
											<a
												href="<bean:write name="element" property="subTitle" />"
												target="_blank"
												title="<bean:write name="element" property="contentName" />"
												<logic:equal name="element" property="displayType" value="9">style="color:#ff0000"</logic:equal>><script>document.writeln("<bean:write name="element" property="contentName" />".substring(0,28));</script>
											</a>
										</logic:notEmpty>
										<logic:empty name="element" property="subTitle">
											<a
												href="show.do?c=<bean:write name="element" property="contentId" />"
												target="_blank"
												title="<bean:write name="element" property="contentName" />"
												<logic:equal name="element" property="displayType" value="9">style="color:#ff0000"</logic:equal>><script>document.writeln("<bean:write name="element" property="contentName" />".substring(0,28));</script>
											</a>
										</logic:empty>
										
									</li>
								</logic:iterate>
							</ul>
						</div>
						 
						<div id="mgzz2" style="display: none;Height: 290px;">
							<ul class="ul_left">
								<ulweb:content beanName="cl" deptId="it" enName="baogao"
									pageNum="1" pageSize="100"
									conditions="isDelete=0:i;isProcessing=0:i;" withAtt="1"/>
								<logic:iterate id="element" name="cl" property="objectList">
									<li style="line-height: 30px;">
									    <!-- 
										<span class="fri"><bean:write name="element"
												property="updateTime" format="yyyy-MM-dd" /> </span>· -->
										<logic:notEmpty name="element" property="subTitle">
											<a
												href="<bean:write name="element" property="subTitle" />"
												target="_blank"
												title="<bean:write name="element" property="contentName" />"
												<logic:equal name="element" property="displayType" value="9">style="color:#ff0000"</logic:equal>><script>document.writeln("<bean:write name="element" property="contentName" />".substring(0,28));</script>
											</a>
										</logic:notEmpty>
										<logic:empty name="element" property="subTitle">
											<a
												href="show.do?c=<bean:write name="element" property="contentId" />"
												target="_blank"
												title="<bean:write name="element" property="contentName" />"
												<logic:equal name="element" property="displayType" value="9">style="color:#ff0000"</logic:equal>><script>document.writeln("<bean:write name="element" property="contentName" />".substring(0,28));</script>
											</a>
										</logic:empty>
									</li>
								</logic:iterate>
							</ul>
						</div>
						
					</div>
				</div>
                 <%-- 
				<div class="style2">
					<div class="Lcon1">
						<p style="text-align: left">
						<table cellpadding="0" cellspacing="0" border="0">
							<tr>
								<td>
									<img src="images/biao.jpg" />
									&nbsp
								</td>
								<td>
									<a href="list.jsp?id=4925" target="_blank" ><font
										class="tab">内部资讯</font></a>
								</td>
							</tr>
						</table>
						</p>
					</div>
					
					<div class="za" style="height: 260px;overflow:auto;">
						<div id="nbzx" style="display: block">
							<ul class="ul_left">
								<ulweb:content beanName="cl" deptId="it" enName="zixun"
									pageNum="1" pageSize="20"
									conditions="isDelete=0:i;isProcessing=0:i;" />
								<logic:iterate id="element" name="cl" property="objectList">
									<li style="line-height: 30px;">
									<!-- 
										<span class="fri"><bean:write name="element"
												property="updateTime" format="yyyy-MM-dd" /> </span>· -->
										<a
											href="show.do?c=<bean:write name="element" property="contentId" />"
											target="_blank"
											title="<bean:write name="element" property="contentName" />"
											<logic:equal name="element" property="displayType" value="9">style="color:#ff0000"</logic:equal>><script>document.writeln("<bean:write name="element" property="contentName" />".substring(0,28));</script>
										</a>
									</li>
								</logic:iterate>
							</ul>
						</div>
				</div>
			--%>
			</div>
			
			<div class="other"><%-- <img  src="images/phone.jpg" width="180px" height="220px" />--%>
					 <a class="numberA" onmouseover="msOver(this,'dept/it/images/3hover.png')" onmouseout="msOut(this,'dept/it/images/3.png')" style="background: url('dept/it/images/3.png')  no-repeat left; "
					 href="http://10.17.2.20:9080/ITWeb/htm/webview.htm" target="_Blank">
				     </a>
				     <a class="numberA" onmouseover="msOver(this,'dept/it/images/1hover.png')" onmouseout="msOut(this,'dept/it/images/1.png')" style="background: url('dept/it/images/1.png')  no-repeat left; "
				     href="http://ulweb/newapp/show.do?c=188023"
				     ></a>
				     <a class="numberA" onmouseover="msOver(this,'dept/it/images/2hover.png')" onmouseout="msOut(this,'dept/it/images/2.png')" style="background: url('dept/it/images/2.png')  no-repeat left; "
				      href="http://10.17.2.20:9080/ITWeb/pingyou/pyym.html" target="_Blank">
				     </a>
				     
	
				     <a class="numberA">+</a>
				     

				</div>
			<script>
				function msOver(obj,imageUrl){
					obj.style.backgroundImage = "url("+imageUrl+")";
				}
				function msOut(obj,imageUrl){
					obj.style.backgroundImage = "url("+imageUrl+")";;
				}
			</script>
			<div style="margin-top: 10px;float: left;width: 1015px">
			<jsp:include flush="true" page="footIT.jsp"></jsp:include>
			</div>

	</body>
</html>

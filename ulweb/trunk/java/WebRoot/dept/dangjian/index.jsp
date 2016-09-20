<%@ page language="java" import="com.ulic.ulweb.ulweb.util.DisplayOnPage" pageEncoding="UTF-8"%>

<%
	DisplayOnPage d = new DisplayOnPage(request);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>党建网 - 首页</title>
<link href="dept/dangjian/main.css" rel="stylesheet" type="text/css" />
<script src="dept/dangjian/main.js"></script>
</head>

<body>

<div id="main">

<!-- include head -->
<jsp:include flush="true" page="head.jsp"></jsp:include>
	
	<div id="box1">
		<div id="cola">
			<div id="cola1">
				<div id="cola1_head" class="col_title">党委成员</div>
				 <div id="cola1_list">
					<ul>
						<li>党委书记：刘校君</li>
						<li><a href="/newapp/dept/dangjian/list002.jsp" target="_self" style="text-align:centrn;color:#CF070A;"><strong>合众人寿共产党员建功,<br/>为党旗争光彩承诺</strong></a></li>
						<li><p style="text-align:left;color:#CF070A">"美丽生活"<br><a href="dangjian.do?method=list&eId=zaixin" target="_self" style="color:#CF070A"><strong>征文</strong></a>
						     &nbsp;&nbsp;
						     <a href="/newapp/dept/dangjian/list005.jsp" target="_self" style="color:#CF070A"><strong>摄影&nbsp;</a></strong>&nbsp;比赛
					</ul>
					
					
				</div>
				<div id="cola1_img">
					<a href="dangjian.do?method=list&eId=luxian" target="_self"><img src="dept/dangjian/images/luxian2.jpg" alt="党的群众路线实践活动" width="231" height="134" /></a>
				</div>				
			</div>
			<div id="cola2">
				<div><img src="dept/dangjian/images/shuji_mail.jpg" alt="书记信箱" width="245" height="43" /></div>
				<div class="padding5">
					<a href="mailto:ulcp@ulic.com.cn" target="_blank">ulcp@ulic.com.cn</a>
				</div>
			</div>
		</div>
		
		<div id="colb">
			<div id="colb">
				<div id="colb_head" class="col_title">热点要闻</div>
				<div id="colb_body">
					
<!-- Flash Begin
<%=d.showSlideFlash("redian", 440, 315, 20, "dept/dangjian/focus.swf") %>
Flash End -->


<!-- newsAd Begin -->
<script language="javascript">
var imgUrl=new Array();
var imgLink=new Array();
var text=new Array();
var adNum=0;
var buttonShow=1;
var buttonPos=2; //RU:1，RD:2，LU:3，LD:4

<%	
	java.util.List<com.ulic.ulweb.ulweb.entity.UlContentWithAtt> indexPic = 
	(java.util.List<com.ulic.ulweb.ulweb.entity.UlContentWithAtt>) request.getAttribute("redian");
	out.println("//size:" + indexPic.size());

  	for(int i = 0; i < indexPic.size(); i++){  

%>
imgUrl[<%=i+1%>]="<%=indexPic.get(i).getAtt(1).getAttachmentPath()%>";
imgLink[<%=i+1%>]="<%=(indexPic.get(i).getSubTitle() != null ? indexPic.get(i).getSubTitle() : "")%>";
text[<%=i+1%>]="<%=(indexPic.get(i).getKeyWord() != null ? indexPic.get(i).getKeyWord() : "")%>";
<% } %>
</script>
<script language="javascript" src="dept/dangjian/newsAd.js"></script>
<table id=newsTable border="0" cellspacing="0" cellpadding="0"><script language="javascript">dakularButtons();</script>
<tr><td><a onMouseOver="displayStatusMsg();return document.returnValue" onMouseOut="status='';" class=px14-lh24 href="javascript:jump2url()"><img style="FILTER: revealTrans(duration=1,transition=23); border:0px solid #000000" src="javascript:nextAd()" width=440 height=315 border=0 name=imgUrlrotator alt=""></a></td>
</tr>
</table>
<!-- newsAd End -->


					
				</div>			
			</div>
			
		</div>
		
		
			
<!-- include right -->
<jsp:include flush="true" page="right.jsp"></jsp:include>



	</div>
	
	
	
	<div id="box2">
	
		<div id="cold">
			<div id="cold_head" class="col_title">网站评价专区</div>
			<div id="cold_body">
				<ul>
					<li><input type="radio" name="vote" value="1" />样式美观，内容丰富实用</li>
					<li><input type="radio" name="vote" value="2" />样式一般，内容尚可</li>
					<li><input type="radio" name="vote" value="3" />样式和内容都有待改善</li>
				</ul>
				<div id="box_vote_btn">
					<input type="button" id="btn_vote1" value="" />&nbsp;
					<input type="button" id="btn_vote2" value="" />
				</div>
			</div>
	
			<div id="box_jiceng">基层党支部：
				<select name="" onchange="location.href='dangjian.do?method=list&columnId='+this.value">
					<option value="0">---请选择---</option>
<%
	java.util.List<com.ulic.ulweb.ulweb.entity.UlColumn> cli = 
		(java.util.List<com.ulic.ulweb.ulweb.entity.UlColumn>) request.getAttribute("dangzuzhi");
	cli = cli == null ? new java.util.ArrayList() : cli;
	java.util.Iterator<com.ulic.ulweb.ulweb.entity.UlColumn> it = cli.iterator();
	while (it.hasNext()) {
		com.ulic.ulweb.ulweb.entity.UlColumn uc = it.next();
	%>
					<option value="<%=uc.getColumnId()%>"><%=uc.getColumnName() %></option>
	<%
	}				
	%>
					
				</select>
			</div>
	
	
		</div>

		
		
		
		<div id="cole">
			<div id="cole_head" class="col_title red"><a href="dangjian.do?method=list&eId=zuixin" target="_self">党建最新动态</a></div>
			<div id="cole_body">
				<marquee direction="up" scrollamount="1" scrolldelay="1"
				 height="140" onmouseover="this.stop()" onmouseout="this.start()">
					<ul>
						<%=d.showContentList("zuixin", 30, "dangjian.do?method=detail&") %>
					</ul>
				</marquee>
			</div>			
		</div>



	
		<div id="colf">
			<div id="colf">
				<div id="colf_head" class="col_title red"><a href="dangjian.do?method=list&eId=dangshi" target="_self">党史知识</a></div>
				<div id="colf_body">
					<ul>
						<%=d.showContentList("dangshi", 15, "dangjian.do?method=detail&") %>
					</ul>
				</div>
			</div>
				
		</div>
			
	
	
	</div>
	
	
<!-- include foot -->
<jsp:include flush="true" page="foot.jsp"></jsp:include>
</div>


</body>
</html>


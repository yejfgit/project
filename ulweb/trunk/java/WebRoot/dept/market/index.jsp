
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlTemplate,com.ulic.ulweb.ulweb.entity.UlColumn,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.ulweb.entity.UlContentWithAtt,com.ulic.ulweb.ulweb.util.DisplayOnPage" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<HTML>
<HEAD>
<TITLE>营销部主页</TITLE>

<link rel="stylesheet" href="style/ul.css" type="text/css" /> 
<link rel="stylesheet" href="dept/market/market.css" type="text/css" />

<%
		UlTemplate t = (UlTemplate)request.getAttribute("template");
		DisplayOnPage d = new DisplayOnPage();
		d.setRequest(request);
		List<UlContentWithAtt> list1 = (List<UlContentWithAtt>)request.getAttribute("lanmu");
	%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

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
<body  >
<center>
<div style="width:778px;">
	<div style="background-image:url('images/market/main_logo.jpg');height:95px;width:100%;">
		<div style="margin:75px 250px 0px 58px;width:470px;color:#ff0000;">
			<marquee onMouseOver="this.stop()" scrollamount="4"  onmouseout="this.start()">
                  欢迎您访问合众人寿总公司营销部主页！
            </marquee>
		</div>
	</div>
	


<!----      菜单  ---->
	<div style="width:100%;background-image:url('images/market/mail_top_bg.gif');float:left;height:20px;">
	<div style="width:70%;float:left;padding:5px 0px 3px 0px;text-align:left;" class="menu1">
		<div style="width:55px;border:none;">
		</div>

		<div>
		<a href="showone.do?c=155" target="_blank">营销部介绍</a>		</div>
		<div>
		<a href="showone.do?c=156" target="_blank">营销通讯录</a>		</div>
		<div style="width:100px;">
		<a href="cdd.do?method=index" target="_blank">机构发展部主页</a>		</div>
		<div>
		<a href="index.do">总公司主页</a>		</div>
		<div style="width:90px;">
		<a href="market.do?method=subPage1&columnId=157" >常用表格下载</a>		</div>
		<div style="width:65px;">
		<a href="admin/login.jsp" target="_blank">后台管理</a>		</div>
			
		
	</div>	
	<div style="width:30%;float:left;text-align:left;padding:5px 0px 0px 30px;">
					<script language="JavaScript">
					<!--
					todayDate = new Date();
					date = todayDate.getDate();
					month= todayDate.getMonth()+1;
					year= todayDate.getYear();
					document.write("今天是")
					document.write(" ")
					document.write(year);
					document.write("年");
					document.write(month);
					document.write("月");
					document.write(date);
					document.write("日");
					document.write(" ")
					if (todayDate.getDay() == 5) document.write("星期五")
					if (todayDate.getDay() == 6) document.write("星期六")
					if (todayDate.getDay() == 0) document.write("星期日")
					if (todayDate.getDay() == 1) document.write("星期一")
					if (todayDate.getDay() == 2) document.write("星期二")
					if (todayDate.getDay() == 3) document.write("星期三")
					if (todayDate.getDay() == 4) document.write("星期四")
					//--> 
					</script>
	</div>
	</div>
	
<!---- 中间块  ---->	
	<div style="width:100%;float:left;height:135px;padding:3px 0px 0px 0px;">
		<div style="float:left;width:578px;">
			<img src="<%=t.getPic4()%>" border="0" >
		</div>
		<div style="float:left;width:200px;">
			<div style="width:100%;height:15px;background-color:#aaaaaa;padding:5px 0px 0px 0px;">
				<a href="market.do?method=subPage1&columnId=148" style="color:#ff0000;font-weight:bold;" >公告</a>
			</div>
			<div class="rightContent1" id="marquees" style="overflow:hidden; height:195;" onMouseOver="setMouse(1);"  onmouseout="setMouse(0)">
				
					<%=d.divContent("gonggao",0)%>
				
			</div>
		</div>		
	</div>
	
		<div class="menu2" >
			<form action="market.do?method=check" id="idform2" name="form2" method="post" >
				
				<div style="background-color:#bb0000;float:left;width:94px;"><input type="hidden" name="keyWord" >
					科室快通道
				</div>
				<div>
				<a href="javascript:document.form2.keyWord.value='企划室';document.form2.submit();">企划室</a>				</div>
				<div>
				<a href="javascript:document.form2.keyWord.value='业管室';document.form2.submit();">业管室</a>				</div>
				<div>
				<a href="javascript:document.form2.keyWord.value='督导室';document.form2.submit();">督导室</a>				</div>
				<div>
				<a href="javascript:document.form2.keyWord.value='人管室';document.form2.submit();">人管室</a>				</div>
				
			</form>
		</div>
		
	
	
	
	
<!------最下边块   ---->
	<div class="div3">
		
		<div class="div190">
		 	<div class="lefttitle1">
				营销部文件及制度
			</div>
			
			<div class="leftcontent1" style="height:90px;text-align:left;">				
					<%=d.divContentNotime("wenjian",0)%>
			</div>
			<div style="text-align:right;padding:0px 20px 5px 0px;">
			<a href="market.do?method=subPage1&columnId=204">&gt;&gt;更多 </a></div>
			
			<div class="fengexian"><div class="fengexian1"></div><div class="fengexian2"></div><div class="fengexian3"></div></div>
				<div class="lefttitle1">
			保监会文件
			</div>
			<div class="leftcontent1" style="height:70px;text-align:left;">				
					<%=d.divContentNotime("baojianhui",0)%>
			</div>
			<div style="text-align:right;padding:0px 20px 5px 0px;">
			<a href="market.do?method=subPage1&columnId=248">&gt;&gt;更多 </a></div>
			
			<div class="fengexian"><div class="fengexian1"></div><div class="fengexian2"></div><div class="fengexian3"></div></div>
			
			<div class="lefttitle1">
				早安合众
			</div>
		
			
			<div class="leftcontent1">
				<%=d.divContentNotime("zaoan",0)%>
			</div>		
				<div style="text-align:right;padding:0px 20px 5px 0px;">
			<a href="market.do?method=subPage1&columnId=667">&gt;&gt;更多 </a></div>
			
			<div class="fengexian"><div class="fengexian1"></div><div class="fengexian2"></div><div class="fengexian3"></div></div>
				<div class="lefttitle1">
			产品园地
			</div>
			
			<div class="leftcontent1">
				<%=d.divColumn("chanpin", "market.do?method=subPage2&", 0)%>
			</div>
			<div class="fengexian"><div class="fengexian1"></div><div class="fengexian2"></div><div class="fengexian3"></div></div>
				<div class="lefttitle1">
			他山之石
			</div>
			
			<div class="leftcontent1">
				<%=d.divColumn("tashan", "market.do?method=subPage2&", 0)%>
			</div>
			
			<div class="fengexian"><div class="fengexian1"></div><div class="fengexian2"></div><div class="fengexian3"></div></div>
			
			
		</div>
		
		
		
		
<!-----------    中间部分        ---->		
		<div class="div398">
			<div class="centerdiv1">
				<div>
				<!--	<div class="centerdiv11" ></div> -->
					<div>
						<%=d.divContentJustDay("subao", -1 , "market")%>
						<div style="margin-bottom:0px;text-align:right;padding:0px 15px 0px 0px;background-image:none;height:20px;">
						<a href="market.do?method=subPage1&columnId=149">>>更多</a>						</div>
					</div>
				</div>
				<div>
				
					<div  >
						<%=d.divColumn("jili", "market.do?method=subPage2&", 0)%>
					</div>
				</div>
				<div>
					
					<div>
						<%=d.divColumn("ziyuan", "market.do?method=subPage2&", 0)%>
					</div>
				</div>
			</div>
			
			<div style="padding:0px 0px 10px 0px;">

  <TABLE cellSpacing=0 cellPadding=0 width="100%" height="70" align=center border=0>
  <TBODY>
  <TR>
    <TD>
      <DIV id=demo style="OVERFLOW: hidden; WIDTH: 100%; COLOR: #ffffff">
      <TABLE cellSpacing=0 cellPadding=0 align=left border=0 cellspace="0">
        <TBODY>
        <TR>
          <TD id=demo1 vAlign=top><table width="<%=list1.size() * 115%>" height="70"  border="0" cellpadding="0" cellspacing="0">
            <tr>
<%
						for(int i = 0 ; i < (list1 == null ? 0 : list1.size()); i++){
						
					%><td width="115"><div><a href="market.do?method=subPage1&columnId=<%=list1.get(i).getSubTitle()%>"><img src="<%=list1.get(i).getAtt(1).getAttachmentPath()%>" border="0" width="115" height="70"></a></div></td><%
						}
					%>
            </tr>
          </table></TD>
          <TD id=demo2 vAlign=top>&nbsp;</TD></TR></TBODY></TABLE></DIV>
    </TD></TR></TBODY></TABLE>

<script language=JavaScript>

var speed3=25;	//速度数值越大速度越慢
demo2.innerHTML=demo1.innerHTML
function Marquee(){
	if(demo2.offsetWidth-demo.scrollLeft<=0)
		demo.scrollLeft-=demo1.offsetWidth
	else{
		demo.scrollLeft++
	}
}
var MyMar=setInterval(Marquee,speed3)
demo.onmouseover=function() {clearInterval(MyMar)}
demo.onmouseout=function() {MyMar=setInterval(Marquee,speed3)}

</script>

</div>
			
			<div style="width:100%;color:red;text-align:right;padding:5px 30px 0px 0px;">
				<img src="images/market/shou.gif" border="0" height="25">请点击上方图片
			</div>	
			
			<div style="width:100%;color:red;text-align:left;padding:5px 0px 5px 20px;">
				<img src="images/market/main_top_button1.gif" border="0"><img src="images/market/main_top_button1.gif" border="0">各机构标保达成情况<%=(request.getAttribute("biaobao") == null ? "" : ((UlContent)request.getAttribute("biaobao")).getContentName())%>
			</div>			
			<div style="width:100%;">
				<%=d.contentOnPage("biaobao")%>
			</div>
			
			<div style="width:100%;padding:15px 0px 0px 0px;">
				您是本站第<span style="color:#990000;font-weight:bold;"><%=request.getAttribute("countProcesser")%></span>位访客
			<br />
			Copyright<img src="images/market/c.jpg" border="0">2008 版权所有 合众人寿总公司营销部
			</div>
			
		</div>
		
		
		
<!-----------    右边部分        ---->			
		<div class="div190" style="background-image:url('images/market/main_right_bg.gif')">
			<div class="righttitle1">
				督导园地
			</div>
			<div class="leftcontent1">
				<%=d.divColumn("dudao", "market.do?method=subPage2&", 0)%>
			</div>	
			
			<div class="righttitle3">
			
			</div>
			<div class="righttitle31">
				<div>
					<a href="http://ulcbs" target="_blank" ><img src="images/market/netbank_yjt.gif" border="0"></a>
				</div>
				<div>
					<a href="http://olap" target="_blank" ><img src="images/market/mobile.gif" border="0"></a>
				</div>
				<div style="display: none">
					<a href="http://aems:8083/aems/login.jsp" target="_blank" ><img src="images/market/main_personal_gryhdzb.gif" border="0"></a>
				</div>
				<div>
					<a href="http://jianyishu/life/index.jsp" target="_blank" ><img src="images/market/main_personal_gryhzyb.gif" border="0"></a>
				</div>
				<div>
					<a href="../app/salesmail.jsp" target="_blank" ><img src="images/market/netbank_creditcard.gif" border="0"></a>
				</div>
				<div>
					<a href="http://oa" target="_blank" ><img src="images/market/pda_load.gif" border="0"></a>
				</div>
				
			</div>
			
			<div class="righttitle2">
			
			</div>
			<div class="righttitle21">
				<form action="market.do?method=check" id="idform1" name="form1" method="post" >
				<div >
					关键字&nbsp;
					<input type="text" name="tName" size="12">					
					
				</div>
				<div>
					类 &nbsp; 型&nbsp;
					<select  name="type" id="idtype" style="width:90px">
					<option value="0">不限</option>
					<%=d.optionColumn("columnForCheck")%>
             	   </select>
				</div>
				
				<div style="text-align:center;">
					<input type="submit" value="提交" />
				</div>
				</form>
				<div style="text-align:left; padding:5px 0px 5px 30px;">
					系统管理员：蔡勇
				</div>
			</div>
			
		</div>
	</div>	
</div>	
</center>
<SCRIPT language=JavaScript>
<!--
var mousein=0;
var old=document.all.marquees.innerHTML;
var oldpos=document.all.marquees.scrollTop;
function mup(){
	theTimer2=setTimeout("mup()", 100);
	if(mousein==0){
		var pos=document.all.marquees.scrollTop;
		document.all.marquees.scrollTop+=1;
	}
	if(pos!=document.all.marquees.scrollTop){
		pos++;
	}else{
		document.all.marquees.innerHTML+=old;
	}
	if(document.all.marquees.innerHTML.length>10000){
		document.all.marquees.innerHTML=old;
		document.all.marquees.scrollTop=oldpos;
	}
}
function setMouse(value){
	mousein=value;
}
mup();
//-->
</SCRIPT>
<div  ><script language='javascript'>//var imagepath='dept/market/xinnian.jpg';var imagewidth=350;var imageheight=135;var imageclick='';</script><script src='script/ad.js'></script></div>
</body>
</HTML>
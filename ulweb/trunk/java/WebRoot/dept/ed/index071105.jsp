
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlTemplate,com.ulic.ulweb.ulweb.entity.UlColumn,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.ulweb.entity.UlContentWithAtt" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<HTML>
<HEAD>
<TITLE>合众人寿保险股份有限公司人才成长中心主页</TITLE>
<meta http-equiv="refresh" content="1200">

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

<link rel="stylesheet" href="dept/ed/ed.css" type="text/css" />

<%
		UlTemplate t = (UlTemplate)request.getAttribute("template");
		
		List<UlColumn> columnListTop1 = (List<UlColumn>)request.getAttribute("columnListTop1");		
		List<UlColumn> columnListRight1 = (List<UlColumn>)request.getAttribute("columnListRight1");				
		List<UlColumn> cList = null;
		
		List<UlContent> listLeft1 = (List<UlContent>)request.getAttribute("contentListLeft1");
		List<UlContentWithAtt> listLeft2 = (List<UlContentWithAtt>)request.getAttribute("contentListLeft2");		
		List<UlContent> listRight1 = (List<UlContent>)request.getAttribute("contentListRight1");
		List<UlContent> listRight2 = (List<UlContent>)request.getAttribute("contentListRight2");
		List<UlContent> list = null;
		
		UlContent content1 = (UlContent)request.getAttribute("contentNews1");
		String titleColor[] = {"#000000","#ffffff","#000000","#0066ff","#009900","#00dddd","#ffccff","#9900cc","#ffcc00","#ff0000"};
			
	%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<%=t.getCssOnPage()%>
</HEAD>
<body <%=(t.getPic1() == null ? "" : ("background='" + t.getPic1() + "'") )%> >
<div id="masthead" >
	<div style="width:100%;height:150px;<%=(t.getPic2() == null ? "" : ("background-image:url('" + t.getPic2() + "');"))%>" >
		<div style="padding:0px 0px 0px 20px;text-align:left;height:50px;">
			<%=t.getImg4()%>
		</div>
		<div style="width:100%;height:70px;text-align:center;font-size:36px;font-family:'黑体';font-style:italic;font-weight:bold;color:#ffffff;">
			人 才 成 长 中 心
		</div>
		<div style="padding:0px 20px 0px 0px;width:100%;text-align:right;font-size:18px;font-family:'黑体';font-style:italic;font-weight:bold;color:#ffffff;">
			Elite Development Center
		</div>			
	</div>
  <div id="globalNav"> 
  	<a href="show.do?ptype=ed&c=4600" target="_blank">关于我们</a><%
		cList = columnListTop1;
		for(int i = 0 ; i < (cList == null ? 0 : cList.size()); i++){
			out.print("&nbsp;|&nbsp;<a target='_blank' href='ed.do?method=subPage1&dept=ed&columnId=" + cList.get(i).getColumnId() + "'>");
			out.print(cList.get(i).getColumnName());
			out.print("</a>");
		}
					
  	%>&nbsp;|&nbsp;<a href="mailto:houkun@ulic.com.cn" target="_blank">意见和建议</a>
  </div>

  <MARQUEE scrollAmount=2  direction="right">
  <h2 id="pageName"><b>&#8212;&#8212;&#8212;学习<span style="font-size:9px;"> &middot; </span>成长<span style="font-size:9px;"> &middot; </span>价值&#8212;</b></h2>
  </MARQUEE> 
</div>


<div id="headlines">
  <h3>中心最新动态</h3>
  
  <MARQUEE onmouseover='javascript:this.stop();' onMouseOut="javascript:this.start();" scrollAmount=2 Direction='up'>
  
 
<%		
			list = listLeft1;
			if(list != null){
				for(int i = 0; i < list.size(); i++){					
					out.println("<p>");					
					if(list.get(i).getHaveContent() == 0 && list.get(i).getAttachmentSum() != 0){
						out.print("<a target='_blank' href='show.do?c=" + list.get(i).getContentId() + "&a=1' style='color:" + titleColor[list.get(i).getDisplayType()] + "'>");
						out.println(list.get(i).getContentName() + "&nbsp;/" + list.get(i).getDay() + "</a>");					
							
						if(list.get(i).getAttachmentSum() > 1){
							out.print("<br>");
							for(int j = 2; j <= list.get(i).getAttachmentSum() ; j++){
								out.print("<a target='_blank' href='show.do?c=" + list.get(i).getContentId() + "&a=" + j + "'>");
								out.print("附件" + (j - 1) + "</a> &nbsp;&nbsp;");
							}							
						}
					}else{
						out.print("<a target='_blank' href='show.do?ptype=ed&c=" + list.get(i).getContentId() + "' style='color:" + titleColor[list.get(i).getDisplayType()] + "'>");
						out.println(list.get(i).getContentName() + "&nbsp;/" + list.get(i).getDay() + "</a>");					
								
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
	<br>
	
  </MARQUEE>
	
  <div id="advert">
     <%
		
		for(int i = 0; i < (listLeft2 == null ? 0 : listLeft2.size()); i++){					
			
				out.print("<a target='_blank' href='show.do?c=" + listLeft2.get(i).getContentId() 
					+ "&ptype=ed' style='color:" + titleColor[listLeft2.get(i).getDisplayType()] + "'>");
				out.println(listLeft2.get(i).getAtt(1).getImg(100) + "<br>");				
				out.println(listLeft2.get(i).getContentName()  + "</a>");						
			
		}
					
								
	%>
	
  </div>
  <div  style="text-align:center;padding:10px;boder:1px gray solid;">
  	合作单位链接<br><br>
  	<select onChange="javascript:openwinfull(this.options[this.selectedIndex].value);" >
	  <option value="about:blank">请选择</option>
	  <option value="http://www.gsm.pku.edu.cn/">北大光华管理学院</option>
  	  <option value="http://www.ckgsb.com/">长江商学院</option>	
	  <option value="http://www.51job.com/">前程无忧</option>
  	</select>
  </div>
</div>

</div>

<h1>
  <!-- end masthead -->
</h1>

<div id="content">
  <div class="feature"><a href="show.do?c=<%=content1.getContentId()%>&a=1" target="_blank"> <%=t.getImg3()%></a>
    <h3><a href="show.do?c=<%=content1.getContentId()%>&a=1" target="_blank"><%=content1.getContentName()%></a></h3>
    <p>
	 　　<%=content1.getContent()%></p>
	
  </div>
  <div class="story">
    <h3 align="center" style="color:#006699;">人才成长中心欢迎你</h3>
	<p  style="margin-bottom:0px;">
	　　人才是公司发展的根本，公司历来重视对人力资本的培养，“学习、成长、价值”是我们对人才培养的价值观。合众深信，公司发展的长久之计是加强内部的人才培养与选拔，以使人才“造血”速度跟上企业迅猛发展的步伐。人才成长中心的目的是为适应公司战略发展需要，建立合众人才竞争优势，增强公司人才造血机制，完善人才梯队建设，明晰员工职业生涯发展规划，满足公司持续快速发展对人才的需要，并建立有合众特色的人才培养体系。中心主要负责制定公司人才成长战略规划并组织实施各项人才成长项目；推动改革创新，结合公司发展改革项目为公司培养中、高级管理人才。
	人才成长中心目前下设成长规划室、成长训练室、成长支持室。</p>	
	<p style="margin:0px;">
　　在未来几年，我们的发展目标是建立合众大学，合众大学的核心目标是建立一个“知识经营、知识创造”的平台，该平台将努力把知识转变为公司的产品和服务创新，丰富公司知识资产，并作为公司的知识库和人才基地，专注于为内部培训，帮助员工把知识转化为价值，将人才培养成为公司核心竞争力，为合众的长远发展提供永续的动力。</p>
<p style="margin:0px;">
　　为此，合众始终保持与先进企业看齐的培训投入水平。人才成长中心将从管理/领导力、金融服务、职业技能、网络学习、客户等五个方面构建完整的课程体系，通过建立人才发展体系，选拔、发展、考察、评估使用人才；形成管理/领导力发展核心课程体系，着重开发干部素质、管理知识、通用技能和客户培训领域的核心课程，并与国际著名的专业培训机构LIMRA、LOMA以及北京大学等国内著名学府共同开展职业培训。随着师资力量的扩充，中心将开发对外部VIP客户、合作伙伴的培训课程，为客户提供附加价值服务。</p>
<p style="margin:0px;">
　　公司要用未来十年的时间把合众大学建成业内一流的金融保险专业企业大学和人才基地，构建一个信息共享、价值最大化的知识经营平台，实现人才储备及发展，确保企业人才优势的长期稳定。</p>
<p style="margin:0px;">
　　当然，人才成长中心的建设需要全体同事的大力支持，请大家多提宝贵建议，希望通过这样的交流平台使我们能共同进步，与合众共同成长，合众和你在一起，我们也与合众在一起。</p>



   
  </div>
  <div class="story">
   
  </div>
</div>
<div id="navBar">
  <div id="search">
   <form action="ed.do?method=check" id="idform1" name="form1" method="post" target="_blank">
	   <input type="hidden" value="ed" name="dept" />
	   <input type="hidden" name="ptype" value="<%=(request.getParameter("ptype") == null ? "" : request.getParameter("ptype"))%>" />
	   <input type="hidden" value="/dept/ed/checkshow" name="forward" />  
      <label>项目查询</label>
      <input name="searchFor" type="text" size="10" />
      <input name="goButton" type="submit" value="查询" />
	  
    </form>
  </div>
   <div class="relatedLinks">
    <h3>合众人网络学习平台</h3>
    <ul>
	<%
		cList = columnListRight1;
		for(int i = 0 ; i < (cList == null ? 0 : cList.size()); i++){
			out.print("<li><a target='_blank' href='ed.do?method=subPage1&dept=ed&columnId=" + cList.get(i).getColumnId() + "'>");
			out.print(cList.get(i).getColumnName());			
			if(i < 3)out.print("<img src='images/index/new_01.gif' border='0' />");
			out.print("</a></li>");
		}  
	%> 
    
    </ul>
  </div>
   <div class="relatedLinks">
    <h3>网络调查系统</h3>
    <select onChange="javascript:window.open(this.options[this.selectedIndex].value);">
		<option value="about:blank">员工成长调查</option>
<%		
			list = listRight1;
			if(list != null){
				for(int i = 0; i < list.size(); i++){	
					if(list.get(i).getHaveContent() == 0 ){
						out.print("<option value='show.do?c=" + list.get(i).getContentId() + "&a=1' >" +  list.get(i).getContentName() + "</option>" );	
					}else{
						out.print("<option value='show.do?ptype=ed&c=" + list.get(i).getContentId() + "' >" + list.get(i).getContentName() + "</option>");	
					}					
				}
			}
			
			%>
	</select>
	<br><br>
	 <select onChange="javascript:window.open(this.options[this.selectedIndex].value);">
		<option value="about:blank">员工自助调查</option>
<%		
			list = listRight2;
			if(list != null){
				for(int i = 0; i < list.size(); i++){	
					if(list.get(i).getHaveContent() == 0 ){
						out.print("<option value='show.do?c=" + list.get(i).getContentId() + "&a=1' >" +  list.get(i).getContentName() + "</option>" );	
					}else{
						out.print("<option value='show.do?ptype=ed&c=" + list.get(i).getContentId() + "' >" + list.get(i).getContentName() + "</option>");	
					}					
				}
			}
			
			%>
	</select>
	<br><br>
  </div>
  <div class="relatedLinks">
    <h3>合众人交流平台</h3>
    <ul><li>合众人之智，为成长助力！</li>
      <li>好东西提供给我们与大家分享</li>
      <li style="text-align:right;padding:0px 30px 0px 0px;"><a href="ed.do?method=subPage1&dept=ed&columnId=104" target="_blank">这里</a></li>
    </ul>
  </div>
  

  <div class="relatedLinks">
    <h3><a href="show.do?ptype=ed&c=4601" target="_blank">合众大学</a></h3>
   
  </div>
 
  
</div>
<!--end navBar div -->
<div id="siteInfo"> 
  <div align="center">
  	<iframe src="dept/ed/indexbottom.jsp" height="100" width="100%" frameborder="0" scrolling="no" ></iframe>
  </div>
</div>
<script language="javascript">
	window.open("dept/ed/messages.jsp","deptmessage","width=300,height=360,scrollbars=no,resizable=no,top=200,left=100,toolbar=no");
</script>
</body>
</HTML>
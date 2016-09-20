
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlTemplate,com.ulic.ulweb.ulweb.entity.UlColumn,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.ulweb.entity.UlContentWithAtt" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<HTML>
<HEAD>
<TITLE>合众人寿保险股份有限公司2009执行年首页</TITLE>
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

<link rel="stylesheet" href="dept/zhixing/ed.css" type="text/css" />

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
		UlContent content2 = (UlContent)request.getAttribute("contentNews2");
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
			我的执行，我的责任       ----2009合众执行年
		</div>		
	</div>
  <div id="globalNav"> 
  	<%
		cList = columnListTop1;
		for(int i = 0 ; i < (cList == null ? 0 : cList.size()); i++){
			out.print("&nbsp;|&nbsp;<a target='_blank' href='zhixing.do?method=subPage1&dept=zhixing&columnId=" + cList.get(i).getColumnId() + "'>");
			out.print(cList.get(i).getColumnName());
			out.print("</a>");
		}
					
  	%>&nbsp;|&nbsp;<a href="mailto:houkun@ulic.com.cn" target="_blank">意见和建议</a>
  </div>

  <MARQUEE scrollAmount=2  direction="right">
  <h2 id="pageName"><b>&#8212;&#8212;执行每周一语&#8212;&#8212;</b></h2>
  </MARQUEE> 
</div>


<div id="headlines">
  <h3>最新动态</h3>
  
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

<div id="content" style="padding: 0px 0px 0px 20px">

<table border="0" >
										  <tr align="center" valign="middle"> 
    <td height="32" style="color:#ff0000;font-size:18px;">2009合众执行年</td>
  </tr>
										<tr>
											<td width="100%" >
												<div style="font-size:12px;" class="div1">


	<p class="MsoNormal" style="MARGIN: 0cm 0cm 0pt; TEXT-INDENT: 28pt; mso-char-indent-count: 2.0"><span lang="EN-US" style="FONT-SIZE: 14pt"><font face="Times New Roman">2009</font></span><span style="FONT-SIZE: 14pt; FONT-FAMILY: 宋体; mso-hansi-font-family: 'Times New Roman'; mso-ascii-font-family: 'Times New Roman'">年是合众进入发展期的第二年，也是公司向内涵式发展转型更加深入的一年，公司在快速发展中取得了优秀的业绩，规模不断发展壮大，公司的日常经营管理也变得异常复杂：每天都会新增大量的个人客户和企业客户；每天都有大量新契约保费产生；每天都会发生数以万计的职场租金、资产折旧等经营成本费用及管理费用；每天都要对新老客户服务进行服务&hellip;&hellip;，任何一个环节都可能隐含着重大风险。靠什么管理日益庞大的公司和复杂的业务？</span><span lang="EN-US" style="FONT-SIZE: 14pt"><o:p></o:p></span></p>
<p class="MsoNormal" style="MARGIN: 0cm 0cm 0pt; TEXT-INDENT: 28pt; mso-char-indent-count: 2.0"><span style="FONT-SIZE: 14pt; FONT-FAMILY: 宋体; mso-hansi-font-family: 'Times New Roman'; mso-ascii-font-family: 'Times New Roman'">公司要从初创的成功成为优秀乃至卓越的企业，实现员工与公司共同成长的目标，我们目前的经营管理水平与发展期战略的要求还存在较大的差距，纠其根本原因是公司的执行体系存在一定的问题。世界上很多优秀的企业，他们拥有卓越的</span><span lang="EN-US" style="FONT-SIZE: 14pt"><font face="Times New Roman">CEO</font></span><span style="FONT-SIZE: 14pt; FONT-FAMILY: 宋体; mso-hansi-font-family: 'Times New Roman'; mso-ascii-font-family: 'Times New Roman'">、一流的人才以及远大而美好的愿景，而且聘请了优秀的咨询人员作为顾问，但他们的企业经营最终却失败了。他们拥有成功需要的一切资源，唯独缺少合理运用这些资源，脚踏实地走向成功的</span><span lang="EN-US" style="FONT-SIZE: 14pt"><font face="Times New Roman">&ldquo;</font></span><span style="FONT-SIZE: 14pt; FONT-FAMILY: 宋体; mso-hansi-font-family: 'Times New Roman'; mso-ascii-font-family: 'Times New Roman'">执行</span><span lang="EN-US" style="FONT-SIZE: 14pt"><font face="Times New Roman">&rdquo;</font></span><span style="FONT-SIZE: 14pt; FONT-FAMILY: 宋体; mso-hansi-font-family: 'Times New Roman'; mso-ascii-font-family: 'Times New Roman'">能力。没有执行，一切美妙的战略、愿景都将是空中楼阁。</span><span lang="EN-US" style="FONT-SIZE: 14pt"><o:p></o:p></span></p>
<p class="MsoNormal" style="MARGIN: 0cm 0cm 0pt; TEXT-INDENT: 28.5pt"><span style="FONT-SIZE: 14pt; FONT-FAMILY: 宋体; mso-hansi-font-family: 'Times New Roman'; mso-ascii-font-family: 'Times New Roman'">公司正在按照十年发展规划的正确方向前进，发展目标十分明确，但同时也意识到：有价值的战略、有意义的变革最终只能来自实际、有效的执行工作，跨越目标与结果之间鸿沟的唯一途径也是执行。因此，公司确定</span><span lang="EN-US" style="FONT-SIZE: 14pt"><font face="Times New Roman">2009</font></span><span style="FONT-SIZE: 14pt; FONT-FAMILY: 宋体; mso-hansi-font-family: 'Times New Roman'; mso-ascii-font-family: 'Times New Roman'">年为合众的执行年，这是公司及董事会做出的重要决策。当然，这只是公司建立执行文化的开始，今后要一直把这种文化建立下去，要贯穿公司经营管理及服务的始终。</span><span lang="EN-US" style="FONT-SIZE: 14pt"><o:p></o:p></span></p>
<p class="MsoNormal" style="MARGIN: 0cm 0cm 0pt; TEXT-INDENT: 28pt; mso-char-indent-count: 2.0"><span style="FONT-SIZE: 14pt; FONT-FAMILY: 宋体; mso-hansi-font-family: 'Times New Roman'; mso-ascii-font-family: 'Times New Roman'">执行就是将计划落到实处，执行就是对结果负责，执行就是立即去行动，执行就是绝对的服从，执行就是勇于承担责任。简而言之，执行不单是战术，也是战略；不单是行为，也是系统的方法；最重要的，它不是被动完成，而是主动解决，而这，恰恰是我们工作中最需要的态度。不论是执行的三要素也好，还是执行的三流程也好，最终就是两个字</span><span lang="EN-US" style="FONT-SIZE: 14pt"><font face="Times New Roman">&mdash;&mdash;&ldquo;</font></span><span style="FONT-SIZE: 14pt; FONT-FAMILY: 宋体; mso-hansi-font-family: 'Times New Roman'; mso-ascii-font-family: 'Times New Roman'">责任</span><span lang="EN-US" style="FONT-SIZE: 14pt"><font face="Times New Roman">&rdquo;</font></span><span style="FONT-SIZE: 14pt; FONT-FAMILY: 宋体; mso-hansi-font-family: 'Times New Roman'; mso-ascii-font-family: 'Times New Roman'">。这就是执行文化的关键。由</span><span lang="EN-US" style="FONT-SIZE: 14pt"><font face="Times New Roman">&ldquo;</font></span><span style="FONT-SIZE: 14pt; FONT-FAMILY: 宋体; mso-hansi-font-family: 'Times New Roman'; mso-ascii-font-family: 'Times New Roman'">责任</span><span lang="EN-US" style="FONT-SIZE: 14pt"><font face="Times New Roman">&rdquo;</font></span><span style="FONT-SIZE: 14pt; FONT-FAMILY: 宋体; mso-hansi-font-family: 'Times New Roman'; mso-ascii-font-family: 'Times New Roman'">开始，到&ldquo;责任</span><span lang="EN-US" style="FONT-SIZE: 14pt"><font face="Times New Roman">&rdquo;</font></span><span style="FONT-SIZE: 14pt; FONT-FAMILY: 宋体; mso-hansi-font-family: 'Times New Roman'; mso-ascii-font-family: 'Times New Roman'">结束，这就是解决执行力不强的根本因素。</span><span lang="EN-US" style="FONT-SIZE: 14pt"><o:p></o:p></span></p>





												
												</div>										  </td>
										</tr>
								</table>						      </td>
						</tr>
					</table>

</div>
<div id="navBar">
  <div id="search">
   <form action="zhixing.do?method=check" id="idform1" name="form1" method="post" target="_blank">
	   <input type="hidden" value="zhixing" name="dept" />
	   <input type="hidden" name="ptype" value="<%=(request.getParameter("ptype") == null ? "" : request.getParameter("ptype"))%>" />
	   <input type="hidden" value="/dept/zhixing/checkshow" name="forward" />  
      <label>项目查询</label>
      <input name="searchFor" type="text" size="10" />
      <input name="goButton" type="submit" value="查询" />
	  
    </form>
  </div>
   <div class="relatedLinks">
    <h3>提升执行力学习平台</h3>
    <ul>
	<%
		cList = columnListRight1;
		for(int i = 0 ; i < (cList == null ? 0 : cList.size()); i++){
			out.print("<li><a target='_blank' href='zhixing.do?method=subPage1&dept=zhixing&columnId=" + cList.get(i).getColumnId() + "'>");
			out.print(cList.get(i).getColumnName());			
			if(i < 3)out.print("<img src='images/index/new_01.gif' border='0' />");
			out.print("</a></li>");
		}  
	%> 
    <li><a href="mailto:houkun@ulic.com.cn" target="_blank">联系我们</a></li>
    </ul>
  </div>
   <div class="relatedLinks">
    <h3>网络调查系统</h3>
    <select onChange="javascript:window.open(this.options[this.selectedIndex].value);">
		<option value="about:blank">执行力调查</option>
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
		<option value="about:blank">自助测试</option>
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
      <li style="text-align:right;padding:0px 30px 0px 0px;"><a href="zhixing.do?method=subPage1&dept=zhixing&columnId=1067" target="_blank">这里</a></li>
    </ul>
  </div>
 
  
</div>
<!--end navBar div -->
<div id="siteInfo"> 
  <div align="center">
  	<iframe src="dept/zhixing/indexbottom.jsp" height="100" width="100%" frameborder="0" scrolling="no" ></iframe>
  </div>
</div>
<script language="javascript">
//	window.open("dept/zhixing/messages.jsp","deptmessage","width=300,height=360,scrollbars=no,resizable=no,top=200,left=100,toolbar=no");
</script>
</body>
</HTML>
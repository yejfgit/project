<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlTemplate,com.ulic.ulweb.ulweb.entity.UlColumn,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.ulweb.entity.UlContentWithAtt,com.ulic.ulweb.ulweb.util.DisplayOnPage" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<HTML>

<HEAD>
<TITLE>市场部</TITLE>


<%
		UlTemplate t = (UlTemplate)request.getAttribute("template");
		DisplayOnPage d = new DisplayOnPage();
		d.setRequest(request);
		String colName = (String)request.getAttribute("colName");	//获得栏目(大类)简称,判断打开哪些div栏
		List<UlContentWithAtt> list1 = (List<UlContentWithAtt>)request.getAttribute("lanmu");
		List<UlContentWithAtt> list21 = (List<UlContentWithAtt>)request.getAttribute("chanpinzhanshi");
		
		List<UlContent> intro = (List<UlContent>)request.getAttribute("intro");
		List<UlContent> address = (List<UlContent>)request.getAttribute("address");		
		
		String chanpindongtaiId = request.getAttribute("chanpindongtaiId").toString();
		String jigoufenxiangId = request.getAttribute("jigoufenxiangId").toString();
		String tongyechanpinId = request.getAttribute("tongyechanpinId").toString();
		String xingxiaofuzhuId = request.getAttribute("xingxiaofuzhuId").toString();
		String huodongtongzhiId = request.getAttribute("huodongtongzhiId").toString();
		String jigoudongtaiId = request.getAttribute("jigoudongtaiId").toString();
		String tongyeshichangId = request.getAttribute("tongyeshichangId").toString();
		String yindaichanpinId = request.getAttribute("yindaichanpinId").toString();
		String link_jyenId = request.getAttribute("link_jyenId").toString();
		String link_fhzmId = request.getAttribute("link_fhzmId").toString();
		String link_jtmmId = request.getAttribute("link_jtmmId").toString();
		String link_wywnId = request.getAttribute("link_wywnId").toString();

%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="style/ul.css" type="text/css" /> 
<link rel="stylesheet" href="dept/shichang/shichang.css" type="text/css" />

</HEAD>


<body>
<div style="display:none">
  <div><%=d.divContentNotime("chanpindongtai",0)%></div>
	<hr>
	<div><%=request.getAttribute("jigoufenxiang")%></div>
	<div><%="colName = " + colName%></div>
</div>

<center>
<div style=" width:800;border-width:1px; border-color:#0066FF; border-style:solid; margin:10px 10px 10px 10px">
<table width="800" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td><div><img src="images/shichang/head_sc.jpg" alt="" width="800" height="100"></div></td>
      </tr>
      <tr>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="5%" height="20" class="navtop_text">				</td>
            <td width="35%" class="navtop_text">&nbsp;<script language="JavaScript">
					<!--
					todayDate = new Date();
					date = todayDate.getDate();
					month= todayDate.getMonth()+1;
					year= todayDate.getYear();
					document.write("")
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
				</script></td>
					  <%
	  String intropath = "#";
	  String addresspath = "#";
	  for(int i = 0; i < intro.size(); i++){
	  	intropath = "show.do?c=" + intro.get(0).getContentId();
	  }
	  for(int i = 0; i < address.size(); i++){
	  	addresspath = "show.do?c=" + address.get(0).getContentId();
	  }
	  
	  %>
            <td class="navtop_text">&nbsp;&nbsp;<a href="<%=intropath%>" target="_blank" class="navtop_text">部门介绍</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="<%=addresspath%>" target="_blank" class="navtop_text">市场部通讯录</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="admin/index.jsp" target="_blank" class="navtop_text">系统管理</a>&nbsp;&nbsp;</td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td width="100%" height="25" valign="middle"><table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" background="images/shichang/head_bg2.jpg">
          <tr>
            <td width="20%">&nbsp;</td>
            <td width="30%"><div class="navtop_text2">创新 进取 效率 协作</div></td>
            <td width="30%"><div class="navtop_text2">更好的产品     更好的服务</div></td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
        </table></td>
      </tr>
    </table>	</td>
  </tr>
  <tr>
  	<td height="10">&nbsp;</td>
  </tr>
  
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="20%" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="200" align="center" valign="middle"><div style=" width:70%; border-style:solid; border-width:1px; border-color:#6699FF"><table width="100%" border="0" cellpadding="0" cellspacing="3">
              <tr>
                <td height="15" align="center"></td>
              </tr>
			  <tr>
                <td height="25" align="center" bgcolor="#6699FF"><span class="navleft_text"><a href="shichang.do?method=index" class="navleft_text">首&nbsp;&nbsp;页</a></span></td>
              </tr>
              <tr>
                <td height="25" align="center" bgcolor="#1661F6"><span class="navleft_text"><a href="shichang.do?method=index&colName=gxcp" class="navleft_text">个险产品</a></span></td>
              </tr>
              <tr>
                <td height="25" align="center" bgcolor="#6699FF"><span class="navleft_text"><a href="shichang.do?method=subPage1&columnId=<%=yindaichanpinId%>" class="navleft_text">银代产品</a></span></td>
              </tr>
              <tr>
                <td height="25" align="center" bgcolor="#1661F6"><span class="navleft_text"><a href="shichang.do?method=index&colName=schd" class="navleft_text">市场活动</a></span></td>
              </tr>
              <tr>
                <td height="25" align="center" bgcolor="#6699FF"><span class="navleft_text"><a href="shichang.do?method=subPage1&columnId=<%=jigoufenxiangId%>" class="navleft_text">机构分享</a></span></td>
              </tr>
              <tr>
                <td height="25" align="center" bgcolor="#1661F6"><span class="navleft_text"><a href="shichang.do?method=index&colName=tydt" class="navleft_text">同业动态</a></span></td>
              </tr>
              <tr>
                <td height="15" align="center"></td>
              </tr>
            </table></div></td>
          </tr>
          <tr>
            <td height="100" align="center" valign="middle"><form method="post" action="shichang.do?method=check" name="form1" id="form1"><table width="80%" border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td height="25"><span class="navleft_find">查找
                    <label>
                    <input name="tName" type="text" id="keyword" size="10">
                    </label>
                </span></td>
              </tr>
              <tr>
                <td height="25"><span class="navleft_find">范围                  
                    <label>
                    <select name="type"><!-- 不限\个险产品\市场活动\机构分享\同业动态 -->
						<option value="0" selected >不限</option>
						<option value="409">个险产品</option>
						<option value="411">市场活动</option>
						<option value="412">机构分享</option>
						<option value="413">同业动态</option>
                      </select>
                    </label>
                </span></td>
              </tr>
              <tr>
                <td height="25" align="center"><input type="submit" name="s1" value="查找"></td>
              </tr> 
            </table>
            </form></td>
          </tr>
          <tr>
            <td height="50" align="center" valign="middle"><div class="withyou">和你在一起</div></td>
          </tr>
        </table></td>
        <td width="60%" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td>
			<!-- body center div -->
				<div class="body_nav">
					<div class="body_nav_text">首页&nbsp;&gt;&gt;&nbsp;<%=request.getAttribute("columnName")%></div>
				</div>
				<div class="bodycenter">
				<!-- index -->
					<div id="chanpindongtai" class="bodycenter_div" style="display:<%=(colName.equals("") || colName.equals("gxcp")?"block":"none")%>">
						<div class="divtitle_box">
						<div class="divtitle">产品动态</div>
						<div class="divtitle_more"><a href="shichang.do?method=subPage1&columnId=<%=chanpindongtaiId%>" class="divtitle_more">更多...</a><!-- 418 --></div>
						</div>
						<div class="divcontent">
							<%=((colName.equals("") || colName.equals("gxcp"))?d.divContent("chanpindongtai",0):"null")%>
						</div>
					</div>
					<div id="chanpinlianjie" class="bodycenter_div prd_link" style="display:<%=(colName.equals("")?"block":"none")%>">
						<div style="background-color:#66CCFF"><a href="shichang.do?method=subPage1&columnId=<%=link_jyenId%>" class="prd_link_a">家有儿女</a></div>
						<div style="background-color:#7A5AF0"><a href="shichang.do?method=subPage1&columnId=<%=link_fhzmId%>" class="prd_link_a">风华正茂</a></div>
						<div style="background-color:#1661F6"><a href="shichang.do?method=subPage1&columnId=<%=link_jtmmId%>" class="prd_link_a">家庭美满</a></div>
						<div style="background-color:#A55FDF"><a href="shichang.do?method=subPage1&columnId=<%=link_wywnId%>" class="prd_link_a">无忧晚年</a></div>
					</div>
					<div id="jigoufenxiang" class="bodycenter_div" style="display:<%=(colName.equals("")?"block":"none")%>">
						<div class="divtitle_box">
						<div class="divtitle">机构分享</div><div class="divtitle_more"><a href="shichang.do?method=subPage1&columnId=<%=jigoufenxiangId%>" class="divtitle_more">更多...</a></div></div>
						<div class="divcontent">
							<%=(colName.equals("")?d.divContent("jigoufenxiang",0):"null")%>						</div>
					</div>
					<div id="tongyechanpin" class="bodycenter_div" style="display:<%=(colName.equals("") || colName.equals("tydt") ?"block":"none")%>">
						<div class="divtitle_box">
						<div class="divtitle">同业产品动态</div><div class="divtitle_more"><a href="shichang.do?method=subPage1&columnId=<%=tongyechanpinId%>" class="divtitle_more">更多...</a></div></div>
						<div class="divcontent">
							<%=(colName.equals("") || colName.equals("tydt")?d.divContent("tongyechanpin",0):"null")%>						</div>
					</div>

					<div id="chanpinzhanshi" class="bodycenter_div" style="display:<%=(colName.equals("gxcp")?"block":"none")%>; border-bottom-style:none">
						<div class="divtitle_box">
						<div class="divtitle">产品展示</div></div>
						<div class="divcontent"><div style="width:400px;">
							<%
							if(colName.equals("gxcp")){
								for(int i = 0 ; i < (list21 == null ? 0 : list21.size()); i++){
									%>
									<div style=" width:100px; height:80px; text-align:center; padding:10px 20px 10px 20px;float:left;">
									<img src="<%=list21.get(i).getAtt(1).getAttachmentPath()%>" border="0" width="50" height="50"><a href="shichang.do?method=subPage1&columnId=<%=list21.get(i).getSubTitle()%>"><%=list21.get(i).getContentName()%></a>&nbsp;
									</div>

									<%
								}
							}
								
							
							
							%>	</div>					</div>
					</div>
					<div id="xingxiaofuzhu" class="bodycenter_div" style="display:<%=(colName.equals("gxcp")?"block":"none")%>">
						<div class="divtitle_box">
						<div class="divtitle">行销辅助品展示</div><span class="divtitle_more"><a href="shichang.do?method=subPage1&columnId=<%=xingxiaofuzhuId%>" class="divtitle_more">更多...</a></span></div>
						<div class="divcontent">
							<%=(colName.equals("gxcp")?d.divContent("xingxiaofuzhu",0):"null")%>						</div>
					</div>										
					
					<div id="huodongtongzhi" class="bodycenter_div" style="display:<%=(colName.equals("schd")?"block":"none")%>">
						<div class="divtitle_box">
						<div class="divtitle">活动通知</div><span class="divtitle_more"><a href="shichang.do?method=subPage1&columnId=<%=huodongtongzhiId%>" class="divtitle_more">更多...</a></span></div>
						<div class="divcontent">
							<%=(colName.equals("schd")?d.divContent("huodongtongzhi",0):"null")%>						</div>
					</div>
					<div id="jigoudongtai" class="bodycenter_div" style="display:<%=(colName.equals("schd")?"block":"none")%>">
						<div class="divtitle_box">
						<div class="divtitle">机构动态</div><span class="divtitle_more"><a href="shichang.do?method=subPage1&columnId=<%=jigoudongtaiId%>" class="divtitle_more">更多...</a></span></div>
						<div class="divcontent">
							<%=(colName.equals("schd")?d.divContent("jigoudongtai",0):"null")%>						</div>
					</div>
					
					<div id="tongyeshichang" class="bodycenter_div" style="display:<%=(colName.equals("tydt")?"block":"none")%>">
						<div class="divtitle_box">
						<div class="divtitle">同业市场动态</div><span class="divtitle_more"><a href="shichang.do?method=subPage1&columnId=<%=tongyeshichangId%>" class="divtitle_more">更多...</a></span></div>
						<div class="divcontent">
							<%=(colName.equals("tydt")?d.divContent("tongyeshichang",0):"null")%>						</div>
					</div>										
				</div>			</td>
          </tr>
        </table></td>
        <td width="20%" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><div>
			
			<marquee onMouseOver="this.stop()" scrollamount="2"  direction="up"  onmouseout="this.start()" style="width:150px;height:300px;" >
					<%
						for(int i = 0 ; i < (list1 == null ? 0 : list1.size()); i++){
						
					%>
				<a href="<%=list1.get(i).getSubTitle()%>" target="_blank"><img src="<%=list1.get(i).getAtt(1).getAttachmentPath()%>" border="0" width="115" height="70"></a>&nbsp;
					<%
						}
					%>
				
				
			</marquee>
				
				</div></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="60"><table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" background="images/shichang/foot_sc.jpg">
      <tr>
        <td>&nbsp;</td>
      </tr>
    </table></td>
  </tr>
</table>
</div>

</center>

</body>
</HTML>

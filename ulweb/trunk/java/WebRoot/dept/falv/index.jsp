<%@ page language="java" import="com.ulic.ulweb.ulweb.util.DisplayOnPage" pageEncoding="UTF-8"%>

<%
	DisplayOnPage d = new DisplayOnPage(request);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>法律合规部</title>
<link href="dept/falv/main.css" rel="stylesheet" type="text/css" />
<script src="dept/falv/main.js"></script>

<script>

</script>

</head>


<div id="main">

<jsp:include flush="true" page="head.jsp"></jsp:include>
	
	<div id="body">
		<div class="col_small">
			<div class="col_title">
				<h1><a href="falv.do?method=list&eId=zhidu_wenjian" target="_self">法律合规部制度文件</a></h1>
			</div>
			<div class="col_content">
				<ul>
					<%=d.showContentList("zhidu_wenjian", 15, "falv.do?method=detail&") %>					
				</ul>
			</div>
		</div>
		
		<div class="col_big">
			<div class="col_title">
				<h1>常用法律法规</h1>
			</div>
			<div class="col_sub_content">
				<div id="btn_a1" class="col_sub_btn_on" onmouseover="over_btn('a', 1)">
					<h2><a href="falv.do?method=list&eId=falv_fagui" target="_self">法律法规</a></h2>
				</div>
				<div id="btn_a2" class="col_sub_btn_off" onmouseover="over_btn('a', 2)">
					<h2><a href="falv.do?method=list&eId=sifa_jieshi" target="_self">司法解释</a></h2>
				</div>
				<div id="btn_a3" class="col_sub_btn_off" onmouseover="over_btn('a', 3)">
					<h2><a href="falv.do?method=list&eId=jianguan_wenjian" target="_self">监管文件</a></h2>
				</div>
										
				<div id="sheet_a1" class="col_sub_content_on">
					<ul>
						<%=d.showContentList("falv_fagui", 30, "falv.do?method=detail&") %>
					</ul>	
				</div>
				<div id="sheet_a2" class="col_sub_content_off">
					<ul>
						<%=d.showContentList("sifa_jieshi", 30, "falv.do?method=detail&") %>
					</ul>	
				</div>	
				<div id="sheet_a3" class="col_sub_content_off">
					<ul>
						<%=d.showContentList("jianguan_wenjian", 30, "falv.do?method=detail&") %>
					</ul>	
				</div>	

			</div>								
		</div>
		
		<div class="col_small">
			<div class="col_title">			
				<h1><a href="falv.do?method=list&eId=gonggao" target="_self">公告栏</a></h1>
			</div>
			
			<div>
			<marquee direction="up" scrollamount="1" scrolldelay="1" class="col_content"
			 onmouseover="this.stop()" onmouseout="this.start()">
				<ul>
					<%=d.showContentList("gonggao", 15, "falv.do?method=detail&") %>
				</ul>	
			</marquee>
			</div>	
			
		</div>
		
		<div class="col_small">
			<div class="col_title">			
				<h1><a href="falv.do?method=list&eId=gongzuo_dongtai" target="_self">工作动态</a></h1>
			</div>
			<div class="col_content">
				<ul>
					<%=d.showContentList("gongzuo_dongtai", 15, "falv.do?method=detail&") %>
				</ul>	
			</div>	
		</div>
	
		<div class="col_big">
			<div class="col_title">
				<h1>反洗钱专栏</h1>
			</div>
			<div class="col_sub_content">
				<div id="btn_b5" class="col_sub_btn_on" onmouseover="over_btn('b', 5)">
					<h2><a href="falv.do?method=list&eId=zhengce_fagui" target="_self">政策与法规</a></h2>
				</div>
				<div id="btn_b1" class="col_sub_btn_off" onmouseover="over_btn('b', 1)">
					<h2><a href="falv.do?method=list&eId=neikong_zhidu" target="_self">内控制度</a></h2>
				</div>
				<div id="btn_b2" class="col_sub_btn_off" onmouseover="over_btn('b', 2)">
					<h2><a href="falv.do?method=list&eId=gongzuo_tongzhi" target="_self">工作通知</a></h2>
				</div>
				<div id="btn_b3" class="col_sub_btn_off" onmouseover="over_btn('b', 3)">
					<h2><a href="falv.do?method=list&eId=peixun_xuanchuan" target="_self">培训与宣传</a></h2>
				</div>
				<div id="btn_b4" class="col_sub_btn_off" onmouseover="over_btn('b', 4)">
					<h2><a href="falv.do?method=list&eId=kehu_heimingdan" target="_self">客户黑名单</a></h2>
				</div>				

				<div id="sheet_b5" class="col_sub_content_on">
					<ul>
						<%=d.showContentList("zhengce_fagui", 30, "falv.do?method=detail&") %>
					</ul>	
				</div>	
				<div id="sheet_b1" class="col_sub_content_off">
					<ul>
						<%=d.showContentList("neikong_zhidu", 30, "falv.do?method=detail&") %>
					</ul>	
				</div>
				<div id="sheet_b2" class="col_sub_content_off">
					<ul>
						<%=d.showContentList("gongzuo_tongzhi", 30, "falv.do?method=detail&") %>
					</ul>	
				</div>	
				<div id="sheet_b3" class="col_sub_content_off">
					<ul>
						<%=d.showContentList("peixun_xuanchuan", 30, "falv.do?method=detail&") %>																
					</ul>	
				</div>	
				<div id="sheet_b4" class="col_sub_content_off">
					<ul>
						<%=d.showContentList("kehu_heimingdan", 30, "falv.do?method=detail&") %>
					</ul>	
				</div>					

			</div>								
		</div>		

<jsp:include flush="true" page="searchbox.jsp"></jsp:include>

		<div id="link1">
			<ul>
				<li class="bg_orange"><a href="http://ulcbs/" target="_blank">核心业务系统</a></li>
				<li class="bg_white"><a href="http://oa/" target="_blank">OA 工作流系统</a></li>
			</ul>
		</div>
		

		<div id="grp_content">
		
			<div id="body_pic">
			<%=d.showPic("tupian2", 1, 705, 100, "dept/falv/images/pic_body.jpg") %>
			</div>		
			
			<div class="col_small">
				<div class="col_title">			
					<h1>交流天地</h1>
				</div>
				<div class="col_content">
					<ul>
						<li><a href="falv.do?method=list&eId=gaoshan_yangzhi" target="_self">高山仰止</a></li>
						<li>bbs论坛</li>
					</ul>	
				</div>	
			</div>
		
			<div class="col_big">
				<div class="col_title">
					<h1><a href="falv.do?method=list&eId=peixun_yuandi" target="_self">培训园地</a></h1>
				</div>
				<div class="col_sub_content">
					<div id="sheet_b1" class="col_sub_content_on">
						<ul>
							<%=d.showContentList("peixun_yuandi", 30, "falv.do?method=detail&") %>
						</ul>	
					</div>
				</div>					
			</div>	
		</div>
		
		<div id="grp_link">
			<div class="link_combo">
				<div class="link_pic"><img src="dept/falv/images/link_pic1.jpg" width="69" height="53" /></div>
				<div class="link_title"><h1><a href="falv.do?method=list&eId=gongsi_guizhang" target="_self">公司规章制度</a></h1></div>
				<div class="link_desc"><p>公司规章制度</p></div>
			</div>
			<div class="link_combo">
				<div class="link_pic"><img src="dept/falv/images/link_pic2.jpg" width="75" height="64" /></div>
				<div class="link_title"><h1><a href="falv.do?method=list&eId=fanben_hetong" target="_self">公司范本合同下载</a></h1></div>
				<div class="link_desc"><p>提供公司非保险业务类合同范本，避免合规风险，提高工作效率。</p></div>
			</div>
			<div class="link_combo">
				<div class="link_pic"><img src="dept/falv/images/link_pic3.jpg" width="69" height="74" /></div>
				<div class="link_title"><h1><a href="falv.do?method=list&eId=dianzi_zazhi" target="_self">电子杂志</a></h1></div>
				<div class="link_desc"><p>普及法律知识，传播法律文化，树立法治思想。</p></div>
			</div>							
		
		</div>		

	</div>
	
<jsp:include flush="true" page="foot.jsp"></jsp:include>

</div>

<body>
</body>
</html>

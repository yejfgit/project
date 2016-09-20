<%@ page language="java" import="com.ulic.ulweb.ulweb.util.DisplayOnPage" pageEncoding="UTF-8"%>
<%DisplayOnPage d = new DisplayOnPage(request);%>
<!-- Page Head Begin -->
	<div id="head">
		<div id="head_pic"><img src="dept/falv/images/head_logo.jpg" width="480" height="100" />
		<%=d.showPic("tupian1", 1, 480, 100, "dept/falv/images/pic_head.jpg") %></div>
		<div id="head_nav">
			<ul>
				<li><a href="falv.do?method=detail&eId=jianjie" target="_blank">法律合规部简介</a></li>
				<li><a href="falv.do?method=detail&eId=tongxunlu" target="_blank">部门通讯录</a></li>
				<li><a href="falv.do?method=list&eId=biaoge" target="_self">常用表格下载</a></li>
			</ul>
			<p id="counter">欢迎光临法律合规部 今天是 
<script type="text/javascript">
	var dt = new Date();
	var weekday;
	switch (dt.getDay()) {
		case 0: weekday = "日"; break;
		case 1: weekday = "一"; break;
		case 2: weekday = "二"; break;
		case 3: weekday = "三"; break;
		case 4: weekday = "四"; break;
		case 5: weekday = "五"; break;
		case 6: weekday = "六"; break;
	}	
	document.writeln(dt.getFullYear() + "年" + (dt.getMonth() + 1) + "月" + dt.getDate() + "日 星期" + weekday);
</script>
 <!-- 您是第 10002568 位 -->
 			</p>
		</div>
	</div>
<!-- Page Head End -->
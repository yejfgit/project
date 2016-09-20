<%@ page language="java" import="com.ulic.ulweb.ulweb.util.DisplayOnPage" pageEncoding="UTF-8"%>

<%
	DisplayOnPage d = new DisplayOnPage(request);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>法律合规部 - <%=d.getContent().getContentName() %></title>

<link href="dept/falv/main.css" rel="stylesheet" type="text/css" />
<script src="dept/falv/main.js"></script>

<script>

</script>

</head>


<div id="main">

<jsp:include flush="true" page="head.jsp"></jsp:include>
	
	<div id="body">

		<div class="container">
			<div class="col_title">
				<h1><a href="falv.do?method=index">法律合规部首页</a><%=d.getNavBar() %></h1>
			</div>
			<div class="col_content">
				<%=d.showContentDetail("show.do?") %>
			</div>				
		</div>
		
		<div id="grp_right">
			<div class="col_small">
				<div class="col_title">			
					<h1>最近更新</h1>
				</div>
				
				<div class="col_content">
					<ul>
						<%=d.showContentList("recent_list", 15, "falv.do?method=detail&") %>	
					</ul>	
				</div>	
				
			</div>
	
<jsp:include flush="true" page="searchbox.jsp"></jsp:include>

		</div>

	</div>
	
<jsp:include flush="true" page="foot.jsp"></jsp:include>

</div>

<body>
</body>
</html>

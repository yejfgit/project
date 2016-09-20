<%@ page language="java" import="com.ulic.ulweb.ulweb.util.DisplayOnPage" pageEncoding="UTF-8"%>

<%
	DisplayOnPage d = new DisplayOnPage(request);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>党建网 - <%=d.getColumn().getColumnName() %></title>
<link href="dept/dangjian/main.css" rel="stylesheet" type="text/css" />
<script src="dept/dangjian/main.js"></script>
</head>

<body>

<div id="main">

<!-- include head -->
<jsp:include flush="true" page="head.jsp"></jsp:include>
	
	<div id="box1">
		<div id="collist">

			<div id="collist_head" class="col_title"><a href="dangjian.do?method=index">党建网</a><%=d.getNavBar() %></div>
			<div id="collist_body">
				<ul>
					<%=d.showContentList("contentList", 30, "show.do?")%>
				</ul>
			
				<div id="col_page">
					<%=d.showPageBar() %>
				</div>	
					
					
			</div>	

					
		</div>
			
		
<!-- include right -->
<jsp:include flush="true" page="right.jsp"></jsp:include>
			
			
			
	</div>
		
		
			
			


	</div>
	
	
	
<!-- include foot -->
<jsp:include flush="true" page="foot.jsp"></jsp:include>

</div>
</body>
</html>


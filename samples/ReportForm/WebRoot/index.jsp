<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<%
	String path = request.getContextPath();
	String searchUrl = request.getAttribute("searchUrl") + "";
	String search = request.getAttribute("search") + "";
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/" + searchUrl;

	System.out.println(basePath);
	System.out.println(search);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<!--<base href="<%=basePath%>">

		<title>My JSP 'index.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		-->
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
			
	-->
		<script type="text/javascript">
//window.onload=myfun();

	function myfun() {
	//document.getElementById('showReport').style.display = "block";
	var search = document.getElementById("search2222");
	//var search = document.getElementsByTagName(name)("search");
	  		//var search = document.getElementByName("search");
	  		 alert(search);
	  		if(search=="search" ){
	  		    alert("111");
	  		    search = document.getElementById("search");
	  		      //var strFormHtml = document.getElementById("showReport");
	  		    document.getElementById('showReport').style.display = "";
	  		     //strFormHtml.
	  		}else{
	  		   // document.getElementById('showReport').style.display = "none";
	  		}
  		}
  		function showReport() 
  		{ 
  			var url="report";  
			document.form1.action = url;  
			 document.form1.submit();
　　　　　}
        function searchReport() 
  		{ 
  		   	var url="searchReport?search=1";  
			document.form1.action = url;  
  		   	 document.form1.submit();
  			
　　　　}   
  </script>
	</head>

	<body>
		<form name="form1" action="searchReport" method="post">
			<input type="hidden" name="search" id="search2222"
				value="<%=search%>" /><!--


			ID:
			<input name="ID0000" id="ID0000" type="text" />-->

			名称：
			<input name=MC0000 id="MC0000" type="text" />
			<input type="button" name="btnLogin" value="查询"
				onclick="searchReport();" />

			<input type="button" name="btnLogin" value="预览"
				onclick="showReport();" />
		</form>
		<div id="showReport">

			<iframe src="<%=basePath%>" width="800" height="100000"
				frameborder="no" border="0" marginwidth="0" marginheight="0"
				scrolling="no" allowtransparency="yes"></iframe>
		</div>

	</body>
</html>

<%@ page language="java" contentType="text/html; charset=utf-8"%>
<html>
	<head>
		<title>cat query</title>
		<%@ include file="/include/head.jsp"%>
	</head>
	<body>
		<div>
		     <form action="guide/search" method="post">
		     <input type="text" name="guideSearch"/>
		     <input type="submit" value="搜索"/>
		     </form>
			 <s:iterator value="guideParentTypeList" var="category">
				<s:property value="name" />
				<s:iterator value="sameGuideList" var="product">
					<s:property value="%{#product.name}" />&nbsp;&nbsp;&nbsp;
				</s:iterator><br>
			</s:iterator> 
			<br><br>
			最新服务<br>&nbsp;&nbsp;&nbsp;&nbsp;
			<s:iterator value="newGuideList" >
				<s:property value="name" />
			</s:iterator>
			<br><br>
			最新评论<br>&nbsp;&nbsp;&nbsp;&nbsp;
			<s:iterator value="commentList" id="comment">
				<s:property value="commentDesc" />
			</s:iterator>  
			 
		</div>
	</body>
</html>

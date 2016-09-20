<%@ page language="java" contentType="text/html; charset=utf-8"%>
<jsp:directive.page import="com.ulic.portal.pub.vo.PageSupport"/>
<jsp:directive.page import="com.ulic.portal.guide.service.CommentService"/>
<jsp:directive.page import="com.ulic.portal.guide.entity.*"/>
<jsp:directive.page import="java.util.ArrayList"/>
<jsp:directive.page import="java.io.PrintWriter"/>
<html>
	<head>
		<title>cat query</title>
		<%@ include file="/include/head.jsp"%>
	</head>
<body>
<% 
String comment=request.getParameter("comment");
int guideId=Integer.parseInt(request.getParameter("guideId"));
String userId=request.getParameter("userId");


//取得评论分页列表
PageSupport ps = new PageSupport();
CommentService commentService=new CommentService();
commentService.getCommentList(ps,guideId);
java.util.List commentList=new ArrayList();
commentList=ps.getItems();


Comment c=new Comment();
for(int i=0;i<commentList.size();i++){
    c=(Comment)commentList.get(i);
    //prt.print(c.getCommentDesc()+";");
}
PrintWriter prt=response.getWriter();
prt.print(guideId);
response.getWriter().close();
//out.write(guideId);
%>
</body>
</html>
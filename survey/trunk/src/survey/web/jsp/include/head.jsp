
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<%
String basePath = request.getScheme() + "://" + 
	request.getServerName() + ":" + request.getServerPort() + 
	request.getContextPath() + "/" ;
%>
<base href="<%=basePath%>" />


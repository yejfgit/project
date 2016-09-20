<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>upload</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <script type="text/javascript">
function upload(){
    var path = document.getElementById("file0").value;
    var a =confirm("您确认要发布此份电子报？")
    
    if(path==""){
    	alert("请选择您要上传的附件");
    	return false;
    }
    
    if(path!="" && path.indexOf(".zip")==-1){
    	alert("您上传的附件格式不正确，文件扩展名应为.zip的压缩文件");
    	return false;
    }
    var f = document.getElementById("form")
    if(a==true){
    f.action ="<%=request.getContextPath()%>/web/admin/newspaper/newspaperAdmin.do?method=publish";
    f.target='_self';
    f.submit(); 
    }  
}  

     
    </script>
  </head>
  
  <body>
     <form action="" name="form"
		method="post" enctype="multipart/form-data">
    <table>
    <tr><td><input type="file" id="file0" name="file0" size="100" ></input></td></tr>
    <tr><td>&nbsp;</td></tr>
    <tr><td><input type="button" name"upfile" value="发布" onclick="upload()"></td></tr>
    <tr><td>
    <%
    	if(request.getAttribute("info")!=null){
    		out.print(request.getAttribute("info"));
    	}
    
     %>  
    </td></tr>
	</table>
    <table>
    <tr><td>&nbsp;</td></tr>
    <tr><td>&nbsp;</td></tr>
    <tr><td>1.请将制作完成电子报纸放入以日期命名的文件夹，并压缩为.zip格式后上传。如：20120315.zip</td></tr>
    <tr><td>2.每期报纸的首页必须命名为index.html</td></tr>
    <tr><td>3.上传完成后，将生成链接保存至往期回顾栏目内</td></tr>
    </table>
  </form>
  </body>
</html>

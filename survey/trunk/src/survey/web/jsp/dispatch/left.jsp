<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="struts-bean.tld" prefix="bean"%>
<%@ taglib uri="struts-html.tld" prefix="html"%>
<%@ taglib uri="struts-logic.tld" prefix="logic"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
<title>架构树</title>

<script type="text/javascript" src="js/prototype.js"></script>
<script type="text/javascript" src="js/tree.js"></script>

<script language="javascript">
	
		function exists(id, optVal) {
		var box=window.parent.frames[2].g(id);
 		 for(var j=0; j<box.length; j++) {
  		 if(box.options[j].value==optVal) {
    		  return true;
   		 }
  		}
  		return false;
	}
	
	function g(id) {
  		return document.getElementById(id);
	}
		
	function addUser(id){
		window.parent.frames[1].location.href="dispatch.do?method=addUsers&deptId="+id;
	}
	
	function addDept(id,dept){
	
		//window.parent.frames[1].location.href="authorizeColumnAdmin.do?method=addDept&deptId="+id;
		   var optValue =id+',2';
		   
		   if(exists('selectedBox', optValue)) {
			    return false;
  			}
	
		  var destbox=window.parent.frames[2].g('selectedBox');
 		  destbox.add(new Option(dept, optValue));
	}
	
	function list(deptId) {
		window.parent.frames[1].location.href="authorizeColumnAdmin.do?method=addUsers&deptId="+deptId;
	}
	
	function o(id) {
	var dd = document.getElementById('dd' + id);
	var da = document.getElementById('da' + id);
	if (dd.style.display == 'block') {
		dd.style.display = 'none';
		da.innerHTML = '＋';
	} else {
		dd.style.display = 'block';
		da.innerHTML = '－';
	}
	}



</script>

<style>
body {
	font-family: Arial, Helvetica, sans-serif;
	margin: 0px;
	text-underline-position: below; 
	font-size: 12px;line-height: 18px;
	scrollbar-3dlight-color:#170708;
	scrollbar-arrow-color:#000000; 
	scrollbar-base-color:#170708; 
	scrollbar-darkshadow-color:#ffffff; 
	scrollbar-face-color:#EEEAEB; 
	scrollbar-highlight-color:#FBFDFC; 
	scrollbar-shadow-color:#170708;
}
table.list{
	width: 100%;
	border-collapse:collapse;
}
table.list thead tr{
	height: 23px;
	line-height: 23px;
	text-align: left;
}
table.list tr.row_1{
	height: 23px;
	line-height: 23px;
	text-align: left;

}
table.list tr.row_2{
	height: 23px;
	line-height: 23px;
	text-align: left;

}
ol{

	color:#2B91AF;
	list-style:decimal outside none;
	margin:0 0 1px;
	padding:2px 0;
}
li{

	line-height:18px;
	margin:0 0 0 38px;
	padding-left:10px;
}
pre{
	display: inline;
}
a{
	cursor: pointer;
	padding: 0 5px;
}
.code{
	margin-left: 10px;

	font-weight: bold;
}
.code a{
	text-decoration: none ;
	font-family:Verdana, Tahoma, "宋体";
	font-size: 12px;
	font-weight: bolder;
	padding: 5px;
}
table.list img{
	margin: 0 2px;
}
</style>

</head>
<%
	String data = (String)request.getAttribute("placeStr"); 
	System.out.println(data);
%>
<body>
<center>
<div style="text-align:left;width:100%;">

<table style="font-size: 12px;" id="table1" class="list">
	<thead>
		<tr>
			<td width="*"></td>
		</tr>
	</thead>
</table>
<script type="text/javascript">
var data1=<%=data%>;
var tree1=new Tree(data1,{NodeOptions:{isFolder:function(){return this.properties.type=="0"}}});
var view1=new TableTree.View({tree:tree1,table:$("table1")});
view1.columnNames=["name"];
view1.classNames=["row_1","row_2"];
view1.onGetImg=function(node,level){
	if(node.isFolder())
		return "";
	return new Element("img",{src:"images/file.gif"});
};
view1.onCustomStatusTag=function(status,node){
	if(!node.isFolder())
		return null;
	switch(status){
		case TableTree.TreeNodeStatus.collapse:
			return new Element("img",{src:"images/expand.gif"});
		case TableTree.TreeNodeStatus.expanding:
			return new Element("img",{src:"images/wait1.gif",width:"12",height:"12"});
		case TableTree.TreeNodeStatus.expanded:
			return new Element("img",{src:"images/collapse.gif"});
	}
};

view1.sortEnable=true;
view1.setSort("name","asc");

view1.ondblClickEventFunc=function(node){
	addUser(node.id)
	//addDept(node.id, node.properties.name);
}

view1.loadChildsUrl="dispatch.do?method=loadChilds";

view1.setRefreshed();
view1.displayAll();


function singleSel(node){
	var organPropertys = new Array();
	organPropertys[0] = node.id||"";
	organPropertys[1] = node.properties.name||"";
	window.returnValue = organPropertys;
	window.close();
}

</script>


</div>
</center>
</body>
</html>

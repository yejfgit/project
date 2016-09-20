<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@page import="com.ulic.ulweb.ulweb2.entity.CusEdcprincipalentitytype"%>
<%@page import="com.ulic.ulweb.ulweb2.entity.Edcprincipalentity"%>

<%
	List<CusEdcprincipalentitytype> groupA = (List) request
			.getAttribute("groupA");
	List<CusEdcprincipalentitytype> groupC = (List) request
			.getAttribute("groupC");
	List<CusEdcprincipalentitytype> groupB = (List) request
			.getAttribute("groupB");
	String newGroups = (String) request.getAttribute("newGroups");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
<head>
	<html:base />

	<title>group.jsp</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	
	<style>
table { border-collapse:collapse;}
th,
td { }
</style>
-->
	<script type="text/javascript">
function ok(){
  var boxes = document.getElementsByName("group");
  var groups =null;
  for (var i = 0; i < boxes.length; i++){   
    if (boxes[i].checked){
        if(groups == null){
         	groups = boxes[i].value;
        }else{
        	groups +="%";
        	groups += boxes[i].value;
        }   
    } 
  }

  window.opener.document.getElementById("newGroups").value = groups;
  window.close();
}

function ok1(){
   alert("OK!");
  var boxes = document.getElementsByName("group");
  var groups =null;
  for (var i = 0; i < boxes.length; i++){   
    if (boxes[i].checked){
        if(groups == null){
         	groups = boxes[i].value;
        }else{
        	groups +="%";
        	groups += boxes[i].value;
        }   
    } 
  }
 parent.document.getElementById("newGroups").value = groups;   
}


var aryName = new Array();
var aryId = new Array();

var tbody ;
var table;
var rows = 0;


function findUser(){
var left, top;
var width = 600;
var height = 400;
left = (window.screen.availWidth - width) / 2;
top = (window.screen.availHeight - height) / 2;
var per = 'width=' + width + ',height=' + height + ',left=' + left + ',top=' + top + ',screenX=' + left + ',screenY=' + top;
var theURL = "<%=request.getContextPath()%>/jsp/admin/attachment/userlist.jsp";  
var returnValue = window.showModalDialog(theURL,window,"center=yes;help=yes;status=yes");

if( returnValue == undefined){
   return;
}

var result = returnValue.split("%");

var index = aryId.length;
aryId[index] = result[0];
aryName[index] = result[1];
fillUsers();
       
  		 if(table == null){
    		createTable();
  		 }
	
	    var rowIndex = Math.floor(index/1);
	    var cellIndex = Math.floor(index%1);
	    if(rowIndex > rows){
	       tbody.insertRow(rowIndex);
	       rows = rowIndex;
	    }
	
	    var img =  document.createElement("img"); 
	    img.id = "img"+index;
		img.src = "<%=request.getContextPath()%>/images/admin/attachment/delete.jpg";
		img.style.cursor = "pointer";
	    img.attachEvent("onclick", function(){deleteIt1(result[0])});
	    
	    
		tbody.rows[rowIndex].insertCell(cellIndex);
		var cell= tbody.rows[rowIndex].cells[cellIndex]
		cell.width="100%"
		cell.appendChild(document.createTextNode(result[1]));
		cell.appendChild(img);
}

function deleteIt1(deleteContent){
  var flag = window.confirm("你确定删除吗");
  if(flag){
 	 var index1 = aryId.remove2(deleteContent);
 	 aryName.remove(index1);
 	 fillUsers();
 	
 	 var rowIndex = Math.floor(index1/1);
	 var cellIndex = Math.floor(index1%1);
     tbody.rows[rowIndex].deleteCell(cellIndex);
     if( tbody.rows[rowIndex].cells.length ==0){
       tbody.deleteRow(rowIndex);
       rows--;
     }
   }
}



function createTable(){
        table = document.createElement("table");
        table.id = "userTable";
		//table.setAttribute("border","1");
		table.setAttribute("width","100%");
		tbody = document.createElement("tbody");
		tbody.id = "tbody1";
		table.appendChild(tbody);
		tbody.insertRow(0);
		var dest = document.getElementById("myH3");
		dest.appendChild(table);
}

function fillUsers(){
	
	 var users = aryId.join("%");
	 var newUserIds = parent.document.getElementById("newUserIds");
	 newUserIds.value = users; 

	var userNames = aryName.join(",");
	var newUserNames = parent.document.getElementById("newUserNames");
	newUserNames.value = userNames;

}

Array.prototype.remove2=function(dx) 
{  
     var flag = false;
     var index2 = this.length;
    //if(isNaN(dx)||dx>this.length){return false;} 
    for(var i=0;i<this.length;i++) 
    { 
        if(this[i] ==dx) 
        { 
            flag = true
            index2 = i;
        } 
        
        if(flag){
       		 this[i]=this[i+1];
        }
    } 
    this.length-=1 
    return index2;
}

Array.prototype.remove=function(dx) 
{  
    if(isNaN(dx)||dx>this.length){return false;} 
     for(var i=dx;i<this.length;i++) 
     { 
       this[i]= this[i+1];
     } 
     this.length -=1;
}
</script>

</head>

<body>
	<form action="">
		<table border="1" width="100%" height="100%" style="border-collapse:collapse;">
			<tr>
				<td align="center">
					<h1 align="center">
						A
					</h1>
				</td>
				<td >
					<table>
						<tr>
							<%
								for (int i = 0; i < groupA.size(); i++) {
							%>

							<td>
								<input type="checkbox" name="group"
									value="<%=groupA.get(i).getEdcprincipalentity()
									.getCanonicalname()%>" />
								<label
									id="<%=groupA.get(i).getEdcprincipalentity()
									.getCanonicalname()%>"><%=groupA.get(i).getName()%></label>
								

							</td>
							<%
								if (i % 3 == 2) {
							%>
						</tr>
						<tr>

							<%
								}
									}
							%>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<h1 align="center">
						B
					</h1>
				</td>
				<td >
					<table>
						<tr>
							<%
								for (int i = 0; i < groupB.size(); i++) {
							%>

							<td>
							    <input type="checkbox" name="group"
									value="<%=groupB.get(i).getEdcprincipalentity()
									.getCanonicalname()%>" />
									
								<label
									id="<%=groupB.get(i).getEdcprincipalentity()
									.getCanonicalname()%>"><%=groupB.get(i).getEdcprincipalentity()
									.getFriendlyname()%></label>
								
							</td>
							<%
								if (i % 3 == 2) {
							%>
						</tr>
						<tr>

							<%
								}
									}
							%>
						</tr>
					</table>
				</td>
			</tr>

			<tr>
				<td>
					<h1 align="center">
						C
					</h1>
				</td>
				<td >
					<table>
						<tr>
							<%
								for (int i = 0; i < groupC.size(); i++) {
							%>

							<td>
                                <input type="checkbox" name="group"
									value="<%=groupC.get(i).getEdcprincipalentity()
									.getCanonicalname()%>" />
									
								<label
									id="<%=groupC.get(i).getEdcprincipalentity()
									.getCanonicalname()%>"><%=groupC.get(i).getEdcprincipalentity()
									.getFriendlyname()%></label>
								
							</td>
							<%
								if (i % 3 == 2) {
							%>
						</tr>
						<tr>

							<%
								}
									}
							%>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<input type="button" value="指定人员" onclick="findUser();">
				</td>


				<td>
					<h2 id="myH3">

					</h2>
				</td>
			</tr>
		</table>


	</form>
</body>
</html:html>

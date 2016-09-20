<%@ page language="java" contentType="text/html; charset=utf-8" %>
<jsp:directive.page import="com.ulic.portal.demo.entity.Cat"/>

<html>
  <head>
    <title>cat query</title>
	<%@ include file="/include/head.jsp"%>
	
  </head>
  <body>
  <form id="testForm" method="post" onsubmit="return false;">
	
	<center>
	<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" class="tablebg">
	  <tr height="19">
		<td valign="top"><%-- <c:navigate menuId="${_menuId }" /> --%></td>
	  </tr>
	  <tr>
		<td align="center" valign="top">
		<fieldset>
		  <legend> 查询条件 </legend>
		  <table width="100%" border="0" cellpadding="2" cellspacing="1">
			<tr>
			  <td>
			    姓名:&nbsp;<input type="text" name="cat.catName" class="input1" value="" />
	  		  </td>
			  <td>
			  &nbsp;
	          </td>
			  <td>
			    <input type="button" onclick="thisQuery();" class="button1" value="查询">
			  	<input type="button" onclick="thisReset();" class="button2" value="重置">
		  	  </td>
			</tr>
		  </table>
		</fieldset>
		<br>
		<br>
		<table width="99%" border="0" cellpadding="2" cellspacing="1" class="tableopr">
		  <tr>
			<td align="left">
			  <a href="cat/add"><font class="addButton">新增</font></a> 
			</td>
		  </tr>
		</table>
		<table width="99%" border="0" cellpadding="2" cellspacing="1" class="table1">
		  <tr align="center">
			<td>序号</td>
			<td>编号</td>
			<td>姓名</td>
			<td>生日</td>
			<td>操作</td>
		  </tr>

		  <s:iterator value="pageSupport.items" id="e">

			<tr align="center">
			  <td></td>
			  <td>${e.id}</td>
			  <td>${e.catName}</td>
			  <td>${e.birthday}</td>
			  <td>
		      	<a href="cat/edit?cat.id=${e.id}">修改</a>&nbsp;
		      	<a href="cat/del?cat.id=${e.id}">删除</a>
		      </td>
		    </tr>

</s:iterator>

  ${pageSupport.pageContent}
  

		</table>
	  </td>
	</tr>
  </table>
  </center>


  </form>
  </body>
  
  <script type="text/javascript">
	  <!--
	  
	  	var testForm = document.getElementById('testForm');
	  
	  	function thisQuery() {
			testForm.action = "cat/query?rnd=" + Math.random();
			testForm.submit();
		}
		
		function thisReset() {
			document.getElementById("cat.catName").value = "";
	
		}
		
		function add() {
			location.href = 'cat/add';
		}
		
		
		function edit(id) {
			location.href = 'cat/edit?cat.id='+ id +'&rnd=' + Math.random();
		}
		
		function del(id) {
			
			if(!confirm("确认删除吗？")) return false;
			
			location.href = 'cat/del?cat.id=' + id;
			
		}
		
		function refreshPage() {
			thisQuery();
		}
		
		
		
	

	  //-->
  </script>
</html>

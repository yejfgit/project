<%@ page language="java" contentType="text/html; charset=utf-8" %>
<html>
  <head>
    <title>dog mod</title>
    <%@ include file="/include/head.jsp"%>
    
  </head>
  <body>  
  <form id="testForm" method="post" onsubmit="return false;" >
    <input type="hidden" name="cat.id" value="${cat.id}" />
	
	<center>
	<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" class="tablebg">
	  <tr height="19">
	    <td valign="top"><%-- <c:navigate menuId="${_menuId }" /> --%></td>
	  </tr>
	  <tr>
		<td align="center" valign="top">
		  <table width="80%" border="0" cellpadding="2" cellspacing="1">
            <tr align="left">
              <td>
	            <font class="title">修改猫猫</font>
        	  </td>
      	    </tr>
   	      </table>
		  <table width="80%" border="0" cellpadding="2" cellspacing="1" class="table1">
		    <tr>
			  <td width="20%" class="tabtd2">姓名</td>
			  <td class="tabtd1"><input type="text" name="cat.catName" class="inputred" value="${cat.catName}" /></td>
		    </tr>
		  </table>
		  <br>
		  <table width="80%" border="0" cellpadding="5" cellspacing="0" class="tableopr">
      	    <tr align="center">
              <td>
                <html:button property="" onclick="update();" styleClass="button1">保存</html:button>&nbsp;
                <html:button property="" onclick="history.back();" styleClass="button2">取消</html:button>
              </td>
            </tr>
          </table>
	    </td>
	  </tr>
	</table>
	</center>
	
  </form>
  </body>
  
  <script type="text/javascript">
    <!--
	function checkInput(){
		return true;
	}
	
	function update(){
	
		var isSubmit = checkInput();
		if(isSubmit == false){
			return false;
		}
		testForm.action = "cat/update";
		testForm.submit();
	}
  	//-->
  </script>
</html>

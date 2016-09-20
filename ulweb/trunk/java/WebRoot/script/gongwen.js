function filter(str){
		//return str.replace(/<script|<\/script|<frame|<\/frame|<iframe|<object|<embed|javascript:|onload=|onbeforeunload/ig, "");
		return str.replace(/<script|<\/script|<frame|<\/frame|<iframe|javascript:|onload=|onbeforeunload/ig, "");
	}

	function getContents(){
		var oEditor=FCKeditorAPI.GetInstance('FCKeditor1');
		return oEditor.GetXHTML(true);
	}

	function subFrm(){
		var i=0;
		
		if(!ValidateHtmlTag(document.getElementById("idcontentName").value)){
			alert("标题不能包含html标记");
			document.getElementById("idcontentName").value = filtertxt(document.getElementById("idcontentName").value);
			return false;
		}		 	
	 	if(document.getElementById("idcolumnId").value == 0){
	 		alert("请选择关键字");
	 		return false;
	 	}
		document.getElementById("idcontent").value=filter(getContents());
		document.getElementById("idform1").action = "admin/document.do?method=add";
		document.getElementById("idform1").target = "_self";
		document.getElementsByName('form1')[0].submit();
		
	}
	
	function subEditFrm(){
		var i=0;
		
		if(!ValidateHtmlTag(document.getElementById("idcontentName").value)){
			alert("标题不能包含html标记");
			document.getElementById("idcontentName").value = filtertxt(document.getElementById("idcontentName").value);
			return false;
		}		 	
	 	
		document.getElementById("idcontent").value=filter(getContents());
		document.getElementById("idform1").action = "admin/document.do?method=edit";
		document.getElementById("idform1").target = "_self";
		document.getElementsByName('form1')[0].submit();
		
	}
	
		
	function filtertxt(str){
		var filterStr=str.replace(/(^\s*)|(\s*$)/g, '').replace(/</g,"&lt;").replace(/>/g,"&gt;").replace(/\n/g,"<br>");
		return filterStr;
	}
	
	function ValidateHtmlTag(v)
	{
	  return !(/[\"\']|\<[^\>]*\>/ig).test(v);
	}
	
	function viewPage(){
		document.getElementById("idcontent").value=filter(getContents());
		document.getElementById("idform1").action = "admin/document.do?method=viewDocument";
		document.getElementById("idform1").target = "_blank";
		document.getElementById("idform1").submit();
			
	}
	
	function deleteA(num){	
		document.getElementById("idattDel").value += "," + num;
		document.getElementById("ida" + num).style.textDecoration = "line-through";
		attSum--;
		document.getElementById("idattSum").value = attSum;
		document.getElementById("ida" + num).href = "javascript:cancleDeleteA(" + num + ");";
	}
	
	function cancleDeleteA(num){
		document.getElementById("idattDel").value = document.getElementById("idattDel").value.replace(num, "");
		document.getElementById("ida" + num).style.textDecoration = "";
		attSum++;
		document.getElementById("idattSum").value = attSum;
		document.getElementById("ida" + num).href = "javascript:deleteA(" + num + ");";
	}
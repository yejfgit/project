
function cList(cid, cName){
	tableId = "idcolumn";
	send_request("admin/column.do?method=bEdit&columnId=" + cid);
	
}

function nList(cid, cName){
	tableId = "idcolumn";
	send_request("admin/column.do?method=bEdit&columnId=" + cid);
	
}

function toAddColumn(cid, cName){
	tableId = "idcolumn";	
	send_request("admin/add/addcolumn.jsp?cid=" + cid + "&cName=" + cName);
	
}

function addColumn(){
	if(document.getElementById("idparentColumn").value == ""){
		alert("请选择一个上级栏目");
		return;		
	}
	if(document.getElementById("idcolumnName").value == ""){
		alert("栏目名不能为空");
		return;
	}
	document.getElementById("idcolumnName").value = filtertxt(document.getElementById("idcolumnName").value);
		
	document.getElementById("idform1").action = "admin/column.do?method=save";
	document.getElementById("idform1").submit();	
}

function editColumn(){
	if(document.getElementById("idparentColumn").value == ""){
		alert("请选择一个上级栏目");
		return;		
	}
	if(document.getElementById("idcolumnName").value == ""){
		alert("栏目名不能为空");
		return;
	}
	document.getElementById("idform1").action = "admin/column.do?method=edit";
	document.getElementById("idform1").submit();
}

function deleteColumn(){
	if(!window.confirm("您确定要删除" + document.getElementById("idcolumnName").value + "吗？")){
		return false;
	}
	document.getElementById("idform1").submit();
}



	function filtertxt(str){
		var filterStr=str.replace(/(^\s*)|(\s*$)/g, '').replace(/</g,"&lt;").replace(/>/g,"&gt;").replace(/\n/g,"<br>");
		return filterStr;
	}
	
	function ValidateHtmlTag(v)
	{
	  return !(/[\"\']|\<[^\>]*\>/ig).test(v);
	}



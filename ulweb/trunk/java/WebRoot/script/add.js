function checkShowClass(){
	document.getElementsByName("showOtherClass")[0].value = document.getElementsByName("showOtherClass")[0].value.replace(/[^0-9]/g,'');
	document.getElementsByName("showOrganClass")[0].value = document.getElementsByName("showOtherClass")[0].value;
}

function checkNum(name){
	document.getElementsByName(name)[0].value = document.getElementsByName(name)[0].value.replace(/[^0-9]/g,'');
}

function addColumn(){
	if(document.getElementsByName("parentColumn")[0].value == -1){
		alert("父级栏目已被设置为只能放具体内容，请另选父栏目");
		return false;
	}
	document.getElementsByName("columnName")[0].value = document.getElementsByName("columnName")[0].value.replace(/[^\u4E00-\u9FA5\w ]/g,'');
	document.getElementsByName("showOtherClass")[0].value = document.getElementsByName("showOtherClass")[0].value.replace(/^[0-9]/g,'');
	document.getElementsByName("showOrganClass")[0].value = document.getElementsByName("showOrganClass")[0].value.replace(/^[0-9]/g,'');
	document.getElementsByName("form1")[0].submit();
}

function editColumn(){
	document.getElementsByName("columnName")[0].value = document.getElementsByName("columnName")[0].value.replace(/[^\u4E00-\u9FA5\w ]/g,'');
	document.getElementsByName("showOtherClass")[0].value = document.getElementsByName("showOtherClass")[0].value.replace(/[^0-9]/g,'');
	document.getElementsByName("showOrganClass")[0].value = document.getElementsByName("showOrganClass")[0].value.replace(/[^0-9]/g,'');
	document.getElementsByName("form1")[0].submit();
}

function useAjax(url, tId, id){
	tableId = tId;	
	send_request(url + document.getElementById(id).value);
}



function checkbox(id){
	document.getElementById("id" + id).checked = true;
}

function editRole(){
	if(document.getElementById("idisAdmin").value == 1){
		document.getElementById("idform1").action = "admin/addRoleClass.do?method=getColumn";
		document.getElementById("idform1").submit();
	}else{
		document.getElementById("idform1").submit();		
	}
}
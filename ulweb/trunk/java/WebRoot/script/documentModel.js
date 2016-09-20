
function viewModel(){
	document.getElementById("idform1").action="admin/document.do?method=viewModel";
	document.getElementById("idform1").target = "_blank";
	document.getElementById("idform1").submit();
}

function submitForm1(){
	if(document.getElementById("idmodelId").length == 0){
		alert("请添写id");
		return false;
	}
	document.getElementById("idform1").action="admin/document.do?method=addModel";
	document.getElementById("idform1").target = "_self";
	document.getElementById("idform1").submit();
}


function editSubmitForm1(){	
	document.getElementById("idform1").action="admin/document.do?method=editModel";
	document.getElementById("idform1").target = "_self";
	document.getElementById("idform1").submit();
}

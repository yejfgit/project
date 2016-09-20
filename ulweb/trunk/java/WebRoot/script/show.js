
function gotoP(page){
	document.getElementById("idform1").action = "admin/document.do?method=getDocumentList&page=" + page;
	document.getElementById("idform1").submit();
}

function gotoPage(){
	document.getElementById("idform1").action = "admin/document.do?method=getDocumentList&page" + document.getElementById("idpage").value;
	document.getElementById("idform1").submit();
}

function add(){
	document.getElementById("idform1").action = "admin/document.do?method=bAdd";
	document.getElementById("idform1").submit();
}
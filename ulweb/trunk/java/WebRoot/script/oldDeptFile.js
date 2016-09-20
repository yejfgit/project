function gotoP(page){
	document.getElementById("idforms").action = "oldFile.do?method=linkList&page=" + page;
	document.getElementById("idforms").submit();
}

function gotoPage(){
	document.getElementById("idforms").action = "oldFile.do?method=linkList&page=" + document.getElementById("idpage").value;
	document.getElementById("idforms").submit();
}

function getFilesList(){
	document.getElementById("idform1").submit();	
}
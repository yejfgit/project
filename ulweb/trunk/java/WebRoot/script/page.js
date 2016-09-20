function gotoP(page){
	document.getElementById("idforms").action = "list.do?method=zongbu&page=" + page;
	document.getElementById("idforms").submit();
}

function gotoPage(){
	document.getElementById("idforms").action = "list.do?method=zongbu&page=" + document.getElementById("idpage").value;
	document.getElementById("idforms").submit();
}

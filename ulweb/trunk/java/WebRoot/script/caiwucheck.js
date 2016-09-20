function gotoP(page){
	document.getElementById("idforms").action = "finacial.do?method=check&page=" + page;
	document.getElementById("idforms").submit();
}

function gotoPage(){
	document.getElementById("idforms").action = "finacial.do?method=check&page=" + document.getElementById("idpage").value;
	document.getElementById("idforms").submit();
}
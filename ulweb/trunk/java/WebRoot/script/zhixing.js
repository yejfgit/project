function goto1P(page){
	document.getElementById("idforms").action = "zhixing.do?method=subPage1&page=" + page;
	document.getElementById("idforms").submit();
}

function goto1Page(){
	document.getElementById("idforms").action = "zhixing.do?method=subPage1&page=" + document.getElementById("idpage").value;
	document.getElementById("idforms").submit();
}

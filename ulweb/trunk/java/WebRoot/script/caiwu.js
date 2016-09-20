function goto1P(page){
	document.getElementById("idforms").action = "finacial.do?method=subPage1&ptype=t&page=" + page;
	document.getElementById("idforms").submit();
}

function goto1Page(){
	document.getElementById("idforms").action = "finacial.do?method=subPage1&ptype=t&page=" + document.getElementById("idpage").value;
	document.getElementById("idforms").submit();
}

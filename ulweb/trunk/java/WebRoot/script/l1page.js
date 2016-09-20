function goto1P(page){
	document.getElementById("idforms").action = "dept1l.do?method=sub1&page=" + page;
	document.getElementById("idforms").submit();
}

function goto1Page(){
	document.getElementById("idforms").action = "dept1l.do?method=sub1&page=" + document.getElementById("idpage").value;
	document.getElementById("idforms").submit();
}
